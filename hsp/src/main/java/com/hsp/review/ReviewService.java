package com.hsp.review;

import java.util.List;

public interface ReviewService {
	public void registReview(Review review);
	public void updateReview(Review review);
	public void deleteReview(Review review);
	public List<Review> viewReviewList(Review review);
	public Review viewReview(Review review);
}
