package com.charity_web.donationapplication.service;
import com.charity_web.donationapplication.dto.LoginRequest;
import com.charity_web.donationapplication.Repository.UserRepository;
import com.charity_web.donationapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return "Invalid email or password.";
        }

        User user = userOptional.get();
        if (encoder.matches(request.getPassword(), user.getPasswordHash())) {
            return "Login successful!";
        } else {
            return "Invalid email or password.";
        }
    }
}

