package com.shopwavefusion.service;

import java.util.List;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.model.Review;
import com.shopwavefusion.model.User;
import com.shopwavefusion.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req,User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
