package com.shopwavefusion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shopwavefusion.exception.UserException;
import com.shopwavefusion.modal.Cart;
import com.shopwavefusion.modal.User;
import com.shopwavefusion.response.ApiResponse;
import com.shopwavefusion.service.CartService;
import com.shopwavefusion.service.UserService;

@RestController
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<ApiResponse> homeController() {

		ApiResponse res = new ApiResponse("Welcome To E-Commerce System", true);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	

}
