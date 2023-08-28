package com.shopwavefusion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.modal.Product;
import com.shopwavefusion.modal.Rating;
import com.shopwavefusion.modal.User;
import com.shopwavefusion.repository.RatingRepository;
import com.shopwavefusion.request.RatingRequest;

@Service
public class RatingServiceImplementation implements RatingServices{
	
	private RatingRepository ratingRepository;
	private ProductService productService;
	
	public RatingServiceImplementation(RatingRepository ratingRepository,ProductService productService) {
		this.ratingRepository=ratingRepository;
		this.productService=productService;
	}

	@Override
	public Rating createRating(RatingRequest req,User user) throws ProductException {
		
		Product product=productService.findProductById(req.getProductId());
		
		Rating rating=new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}
	
	

}
