package com.hsp.review;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private HttpSession httpSession;

	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	
	//테스트용
	String product_id = "P01";
	
	//리뷰 목록 조회
	@GetMapping("/{product_id}")
	public ModelAndView listReview(@PathVariable String product_id) {
		ModelAndView modelAndView = new ModelAndView();
		List<Review> listreview = reviewServiceImpl.viewReviewList(product_id);
		modelAndView.setViewName("/review/reviewList");
		modelAndView.addObject("product_id", product_id);
		modelAndView.addObject("listreview", listreview);
		return modelAndView;
	}
	
	//리뷰 상세 조회
	@GetMapping("/{product_id}/{review_id}")
	public ModelAndView viewreview(@PathVariable String product_id, @PathVariable String review_id) {
		Review review = new Review();
		review.setProduct_id(product_id);
		review.setReview_id(review_id);
		Review result = reviewServiceImpl.viewReview(review);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/review/reviewView");
		modelAndView.addObject("review", result);
		return modelAndView;
	}
	
	//리뷰 수정 폼
	@GetMapping("/{review_id}/editform")
	public ModelAndView updatereview(@PathVariable(name = "review_id") String review_id) {
		ModelAndView modelAndView = new ModelAndView();
		Review review = new Review();
		review.setReview_id(review_id);
		Review result = reviewServiceImpl.viewReview(review);
		modelAndView.setViewName("/review/reviewEditForm");
		modelAndView.addObject("review", result);
		return modelAndView;
	}
	
	//리뷰 등록 폼
	@GetMapping("/registform")
	public ModelAndView regitReview() {
		ModelAndView modelAndView = new ModelAndView();
		String review_id = "R" + UUID.randomUUID().toString().subSequence(0, 9);
		modelAndView.setViewName("/review/reviewRegist");
		modelAndView.addObject("product_id", product_id);
		modelAndView.addObject("review_id", review_id);
		return modelAndView;
	}
	
	//리뷰 등록
	@PostMapping("")
	public ModelAndView regitReview(Review review, @RequestParam("attach") MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		reviewServiceImpl.registReview(review, attach);
		modelAndView.setViewName("redirect:/review/" + review.getProduct_id());
		return modelAndView;
	}
	
	//리뷰 수정
	@PutMapping("")
	public ModelAndView updateReview(Review review, MultipartFile attach) {
		ModelAndView modelAndView = new ModelAndView();
		reviewServiceImpl.updateReview(review, attach);
		modelAndView.setViewName("redirect:/review/" + review.getReview_id());
		return modelAndView;
	}
	
	//리뷰 삭제
	@DeleteMapping("")
	public ModelAndView deleteReview(Review review) {
		ModelAndView modelAndView = null;
		return modelAndView;
	}
	
	//사진업로드
	@PostMapping("/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		reviewServiceImpl.postCKEditorImgUpload(req, res, upload);
	}
	
	@GetMapping("/review/display")
	public ResponseEntity<Resource> display(@RequestParam("filename") String fileName)throws Exception{
		
		return reviewServiceImpl.display(fileName);
	}
}
