package com.shopwavefusion.service;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.model.Cart;
import com.shopwavefusion.model.User;
import com.shopwavefusion.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
