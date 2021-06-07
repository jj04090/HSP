package com.hsp.inquiry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.community.Comment;
import com.hsp.community.Community;
import com.hsp.user.User;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	InquiryServiceImpl inquiryServiceImpl;
	
	//테스트용
	String product_id = "P01";
	
	//문의 목록 조회
	@GetMapping("/{product_id}")
	public ModelAndView listInquiry(@PathVariable String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		
		User user = (User)httpSession.getAttribute("user");
		String bizCheck = user.getUser_type();
		String u_id = user.getUser_id();
		
		if (bizCheck.equals("B")) {
			List<Inquiry> listInquiry = inquiryServiceImpl.viewInquiryList(product_id);
			modelAndView.setViewName("/inquiry/inquiryBizList");
			modelAndView.addObject("product_id", product_id);
			modelAndView.addObject("listInquiry", listInquiry);
		} else {
			List<Inquiry> listInquiry = inquiryServiceImpl.viewInquiryMyList(u_id);
			modelAndView.setViewName("/inquiry/inquiryList");
			modelAndView.addObject("product_id", product_id);
			modelAndView.addObject("user_id", u_id);
			modelAndView.addObject("listInquiry", listInquiry);
		}

		return modelAndView;
	}
	
	//문의 상세 조회
	@GetMapping("/{product_id}/{inquiry_id}")
	public ModelAndView viewInquiry(@PathVariable String product_id, @PathVariable String inquiry_id) {
		Inquiry inquiry = new Inquiry();
		ModelAndView modelAndView = new ModelAndView();
		
		User user = (User)httpSession.getAttribute("user");
		String bizCheck = user.getUser_type();
		
		if (bizCheck.equals("B")) {
			inquiry.setProduct_id(product_id);
			inquiry.setInquiry_id(inquiry_id);
			Inquiry result = inquiryServiceImpl.viewInquiry(inquiry);
			modelAndView.setViewName("/inquiry/inquiryBizView");
			modelAndView.addObject("inquiry", result);
		} else {
			inquiry.setProduct_id(product_id);
			inquiry.setInquiry_id(inquiry_id);
			Inquiry result = inquiryServiceImpl.viewInquiry(inquiry);
			modelAndView.setViewName("/inquiry/inquiryView");
			modelAndView.addObject("inquiry", result);
		}
		
		return modelAndView;
	}
	
	//문의 수정 폼
	@GetMapping("/{inquiry_id}/editform")
	public ModelAndView updateInquiry(@PathVariable(name = "inquiry_id") String inquiry_id) {
		ModelAndView modelAndView = new ModelAndView();
		Inquiry inquiry = new Inquiry();
		inquiry.setInquiry_id(inquiry_id);
		Inquiry result = inquiryServiceImpl.viewInquiry(inquiry);
		modelAndView.setViewName("/inquiry/inquiryEditForm");
		modelAndView.addObject("inquiry", result);
		return modelAndView;
	}
	
	//문의 답변 수정 폼
	@GetMapping("/{inquiry_id}/answereditform")
	public ModelAndView updateAnswer(@PathVariable(name = "inquiry_id") String inquiry_id) {
		ModelAndView modelAndView = new ModelAndView();
		Inquiry inquiry = new Inquiry();
		inquiry.setInquiry_id(inquiry_id);
		Inquiry result = inquiryServiceImpl.viewInquiry(inquiry);
		modelAndView.setViewName("/inquiry/inquiryAnswerEditForm");
		modelAndView.addObject("inquiry", result);
		return modelAndView;
	}
	
	//문의 등록 폼
	@GetMapping("/registform")
	public ModelAndView regitInquiry() {
		ModelAndView modelAndView = new ModelAndView();
		User getUser = (User)httpSession.getAttribute("user");
		String inquiry_id = "I" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/inquiry/inquiryRegist");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String inquiry_regit_date = format1.format(date);
		modelAndView.addObject("product_id", product_id);
		modelAndView.addObject("inquiry_id", inquiry_id);
		modelAndView.addObject("user_id", getUser.getUser_id());
		modelAndView.addObject("inquiry_regit_date", inquiry_regit_date);
		return modelAndView;
	}
	
	//문의 등록
	@PostMapping("")
	public ModelAndView regitInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.registInquiry(inquiry);
		modelAndView.setViewName("redirect:/inquiry/" + inquiry.getProduct_id());
		return modelAndView;
	}
	
	//문의 수정
	@PutMapping("/inquiry")
	public ModelAndView updateInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.updateInquiry(inquiry);
		modelAndView.setViewName("redirect:/inquiry/" + inquiry.getProduct_id() + "/" + inquiry.getInquiry_id());
		return modelAndView;
	}
	
	//문의 답변 수정
	@PutMapping("/answer")
	public ModelAndView updateAnswer(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.updateAnswer(inquiry);
		modelAndView.setViewName("redirect:/inquiry/" + inquiry.getProduct_id() + "/" + inquiry.getInquiry_id());
		return modelAndView;
	}
	
	//문의 삭제
	@DeleteMapping("")
	public ModelAndView deleteInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
}
