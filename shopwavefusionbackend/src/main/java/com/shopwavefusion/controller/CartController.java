package com.shopwavefusion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwavefusion.exception.ProductException;
import com.shopwavefusion.exception.UserException;
import com.shopwavefusion.modal.Cart;
import com.shopwavefusion.modal.CartItem;
import com.shopwavefusion.modal.User;
import com.shopwavefusion.request.AddItemRequest;
import com.shopwavefusion.response.ApiResponse;
import com.shopwavefusion.service.CartService;
import com.shopwavefusion.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private CartService cartService;
	private UserService userService;
	
	public CartController(CartService cartService,UserService userService) {
		this.cartService=cartService;
		this.userService=userService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		Cart cart=cartService.findUserCart(user.getId());
		
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		
		User user=userService.findUserProfileByJwt(jwt);
		
		CartItem createdCartItem = cartService.addCartItem(user.getId(), req);
		
		
		return new ResponseEntity<>(createdCartItem,HttpStatus.ACCEPTED);
		
	}
	

}
