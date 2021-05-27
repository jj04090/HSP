package com.hsp.payment;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		mv.setViewName("/test/payment");

		return mv;
	}

	//일반 결제 정보 전송
	@PostMapping
	public IamportRequest normalPayment(@RequestBody User user, Errors errors,
			@PathVariable String merchantUid) {
		IamportRequest iamportRequest = null;

		try {
			if (errors.hasErrors()) {
				httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			} else {
				httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
			}
			//iamportRequest = paymentServiceImpl.paymentProcess(mission, merchantUid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return iamportRequest;
	}
	
	//정기 결제
	@PostMapping("/routine")
	public IamportRequest routinePayment(@RequestBody User user, Errors errors,
			@PathVariable String merchantUid) {
		IamportRequest iamportRequest = null;

		try {
			if (errors.hasErrors()) {
				httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			} else {
				httpServletResponse.setStatus(HttpServletResponse.SC_CREATED);
			}
			//iamportRequest = paymentServiceImpl.paymentProcess(mission, merchantUid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return iamportRequest;
	}
}
