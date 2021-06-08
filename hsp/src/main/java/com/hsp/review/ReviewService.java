package com.hsp.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ReviewService {
	public void registReview(Review review, MultipartFile attach);
	public void updateReview(Review review, MultipartFile attach);
	public void deleteReview(Review review);
	public List<Review> viewReviewList(String product_id);
	public Review viewReview(Review review);
	public String reviewCount(Review review);
	
	public String imgUpload(MultipartFile attach);
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload);
	public ResponseEntity<Resource> display(String fileName);
}
