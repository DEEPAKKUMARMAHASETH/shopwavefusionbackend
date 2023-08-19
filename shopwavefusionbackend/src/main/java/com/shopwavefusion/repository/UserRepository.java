package com.shopwavefusion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
