package com.hsp.inquiry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/inquiry")
public class InquiryController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private InquiryMapper inquiryMapper;
	
	//문의 조회
	@GetMapping
	public ModelAndView viewInquiry(Inquiry inquiry) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/inquiry/InquiryView");
		
		return mv;
	}
	
	//문의 등록
	@PostMapping
	public void registInquiry(Inquiry inquiry) {
		
	}
	
	//문의 수정
	@PutMapping
	public void editInquiry(Inquiry inquiry) {
		
	}
	
	//문의 삭제
	@DeleteMapping
	public void deleteInquiry(Inquiry inquiry) {
		
	}
}
