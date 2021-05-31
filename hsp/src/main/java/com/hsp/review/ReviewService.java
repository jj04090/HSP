package com.hsp.review;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ReviewService {
	public void registReview(Review review, MultipartFile attach);
	public void updateReview(Review review, MultipartFile attach);
	public void deleteReview(Review review);
	public List<Review> viewReviewList();
	public Review viewReview(Review review);
	
	public String imgUpload(MultipartFile attach);
	public ResponseEntity<Resource> display(String fileName);
}
