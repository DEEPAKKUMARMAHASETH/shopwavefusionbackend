package com.shopwavefusion.service;

import com.shopwavefusion.exception.CartItemException;
import com.shopwavefusion.exception.UserException;
import com.shopwavefusion.model.Cart;
import com.shopwavefusion.model.CartItem;
import com.shopwavefusion.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size, Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
	
}
