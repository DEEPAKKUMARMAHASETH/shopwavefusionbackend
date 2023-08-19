package com.shopwavefusion.service;

import java.util.List;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.model.Rating;
import com.shopwavefusion.model.User;
import com.shopwavefusion.request.RatingRequest;

public interface RatingServices {
	
	public Rating createRating(RatingRequest req,User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
