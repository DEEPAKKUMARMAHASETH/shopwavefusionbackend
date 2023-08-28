package com.shopwavefusion.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopwavefusion.exception.UserException;
import com.shopwavefusion.modal.User;
import com.shopwavefusion.repository.UserRepository;
import com.shopwavefusion.service.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/control")
public class AdminController {
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private CartService cartService;
	

	
	public AdminController(UserRepository userRepository, PasswordEncoder passwordEncoder, CartService cartService) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.cartService = cartService;
	}
	@PostMapping("/signup")
	public ResponseEntity<User> createUserHandler(@Valid @RequestBody User user) throws UserException{
		
		  	String email = user.getEmail();
	        String password = user.getPassword();
	        String firstName=user.getFirstName();
	        String lastName=user.getLastName();
	        
	        User isEmailExist=userRepository.findByEmail(email);

	        // Check if user with the given email already exists
	        if (isEmailExist!=null) {
	        // 
	        	
	            throw new UserException("Email Is Already Used With Another Account");
	        }

	        // Create new user
			User createdUser= new User();
			createdUser.setEmail(email);
			createdUser.setFirstName(firstName);
			createdUser.setLastName(lastName);
	        createdUser.setPassword(passwordEncoder.encode(password));
	        createdUser.setRole("ROLE_ADMIN");
	        createdUser.setCreatedAt(LocalDateTime.now());
	        createdUser.setMobile(user.getMobile());
	        
	        
	        
	        User savedUser= userRepository.save(createdUser);
	        
	        cartService.createCart(savedUser);

	  			
	        return new ResponseEntity<>(savedUser,HttpStatus.OK);
		
	}
	
}
