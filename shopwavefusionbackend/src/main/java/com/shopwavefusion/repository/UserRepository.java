package com.shopwavefusion.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwavefusion.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
