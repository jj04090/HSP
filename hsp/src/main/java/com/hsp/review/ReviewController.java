package com.hsp.review;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsp.inquiry.Inquiry;
import com.hsp.inquiry.InquiryMapper;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ReviewMapper reviewMapper;
	
	//리뷰 조회
	@GetMapping
	public ModelAndView viewReview(Review review) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/review/ReviewView");
		
		return mv;
	}
	
	//리뷰 등록
	@PostMapping
	public void registReview(Review review) {
		
	}
	
	//리뷰 수정
	@PutMapping
	public void editReview(Review review) {
		
	}
	
	//리뷰 삭제
	@DeleteMapping
	public void deleteReview(Review review) {
		
	}
}
