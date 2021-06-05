package com.hsp.payment;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.orders.OrderServiceImpl;
import com.hsp.user.User;
import com.hsp.user.UserServiceImpl;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private HttpServletResponse httpServletResponse;

	@Autowired
	private HttpSession httpSession;

	// 결제 처리
	@GetMapping
	public ModelAndView paymentProcess() {
		ModelAndView mv = new ModelAndView();

		try {
			paymentServiceImpl.calculate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("/test/payment");

		return mv;
	}

	// 일반 결제 정보 전송
	@PostMapping
	@ResponseBody
	public IamportRequest normalPayment() {
		User getUser = (User) httpSession.getAttribute("user");

		return new IamportRequest("html5_inicis", "merchant_uid" + UUID.randomUUID().toString(), "장바구니 상품 구매",
				orderServiceImpl.totalPrice(getUser.getUser_id(), "S"), getUser.getEmail(), getUser.getName());
	}

	// 정기 결제 정보 전송
	@PostMapping("/routine")
	@ResponseBody
	public IamportRequest routinePayment() {
		User getUser = (User) httpSession.getAttribute("user");
		boolean flag = paymentServiceImpl.checkBilingKey(getUser.getUser_id());
		// 빌링키를 조회하여 만약 존재한다면 카드등록말고 그대로 진행한다. 아니 선택지를 준다
		if (flag) {
			return new IamportRequest("html5_inicis.INIBillTst", "merchant_uid" + UUID.randomUUID().toString(),
					"정기상품 결제", orderServiceImpl.totalPrice(getUser.getUser_id(), "W"), getUser.getEmail(),
					getUser.getName(), getUser.getUser_id() + "bilingkey");
		}
		return new IamportRequest();
	}

}
