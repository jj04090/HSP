package com.hsp.payment;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.product.Product;
import com.hsp.user.User;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	IamportRequest iamportRequest = null;

	@Autowired
	private PaymentServiceImpl paymentServiceImpl;

	@Autowired
	private HttpServletResponse httpServletResponse;

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
	public IamportRequest normalPayment(User user) {
			return new IamportRequest("html5_inicis","merchant_uid"+UUID.randomUUID().toString(), "사과", 100, "jj04090@naver.com", "유상진");
	}

	// 정기 결제 정보 전송
	@PostMapping("/routine")
	@ResponseBody
	public IamportRequest routinePayment(User user) {
		IamportRequest iamportRequest = null;
		//user_id+"customerhsp";
		//빌링키를 조회하여 만약 존재한다면 카드등록말고 그대로 진행한다. 아니 선택지를 준다
		return new IamportRequest("html5_inicis.INIBillTst","merchant_uid"+UUID.randomUUID().toString(), "수박", 100, "jj04090@naver.com", "유상진", "cid_113");
	}
	
	
}
