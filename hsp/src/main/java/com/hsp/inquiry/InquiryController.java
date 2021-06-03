package com.hsp.inquiry;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	@GetMapping("/inquiry")
	public ModelAndView listInquiry() {
		ModelAndView modelAndView = new ModelAndView();
		List<Inquiry> listInquiry = inquiryServiceImpl.viewInquiryList();
		modelAndView.setViewName("/inquiry/inquiryList");
		modelAndView.addObject("listInquiry", listInquiry);
		return modelAndView;
	}
	
	//문의 상세 조회
	@GetMapping("/inquiry/{inquiry_id}")
	public ModelAndView viewInquiry(@PathVariable(name = "inquiry_id") String inquiry_id) {
		Inquiry inquiry = new Inquiry();
		inquiry.setInquiry_id(inquiry_id);
		Inquiry result = inquiryServiceImpl.viewInquiry(inquiry);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/inquiry/inquiryView");
		modelAndView.addObject("inquiry", result);
		return modelAndView;
	}
	
	//문의 수정 폼
	@GetMapping("/inquiry/{inquiry_id}/editform")
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
	@GetMapping("/inquiry/{inquiry_id}/answereditform")
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
	@GetMapping("/inquiry/registform")
	public ModelAndView regitInquiry() {
		ModelAndView modelAndView = new ModelAndView();
		String inquiry_id = "I" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/inquiry/inquiryRegist");
		modelAndView.addObject("product_id", product_id);
		modelAndView.addObject("inquiry_id", inquiry_id);
		return modelAndView;
	}
	
	//문의 등록
	@PostMapping("/inquiry")
	public ModelAndView regitInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.registInquiry(inquiry);
		modelAndView.setViewName("redirect:/hsp/inquiry");
		return modelAndView;
	}
	
	//문의 수정
	@PostMapping("/inquiryupdate")
	public ModelAndView updateInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.updateInquiry(inquiry);
		modelAndView.setViewName("redirect:/hsp/inquiry/" + inquiry.getInquiry_id());
		return modelAndView;
	}
	
	//문의 답변 수정
	@PostMapping("/inquiryanswerupdate")
	public ModelAndView updateAnswer(Inquiry inquiry) {
		ModelAndView modelAndView = new ModelAndView();
		inquiryServiceImpl.updateInquiry(inquiry);
		modelAndView.setViewName("redirect:/hsp/inquiry/" + inquiry.getInquiry_id());
		return modelAndView;
	}
	
	//문의 삭제
	@DeleteMapping("/inquiry")
	public ModelAndView deleteInquiry(Inquiry inquiry) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
}
