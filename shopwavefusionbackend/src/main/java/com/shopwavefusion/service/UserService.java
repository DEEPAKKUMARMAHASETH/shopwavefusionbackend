package com.shopwavefusion.service;

import com.shopwavefusion.exception.UserException;
import com.shopwavefusion.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

}
