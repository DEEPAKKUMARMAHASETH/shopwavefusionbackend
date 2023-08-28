package com.shopwavefusion.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shopwavefusion.modal.User;
import com.shopwavefusion.repository.UserRepository;
import com.shopwavefusion.service.CartService;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(UserRepository userRepository, CartService cartService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cartService = cartService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if admin user already exists
        if (userRepository.findByEmail("admin@example.com") == null) {
            User adminUser = new User();
            adminUser.setEmail("admin@example.com");
            adminUser.setFirstName("Admin");
            adminUser.setLastName("Admin");
            adminUser.setMobile("1234567890");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setRole("ROLE_ADMIN");
            adminUser.setCreatedAt(LocalDateTime.now());

            User savedAdminUser = userRepository.save(adminUser);

          
             cartService.createCart(savedAdminUser);
           
        }
    }
}

