package com.charity_web.donationapplication.service;


import com.charity_web.donationapplication.dto.RegisterRequest;
import com.charity_web.donationapplication.Repository.UserRepository;
import com.charity_web.donationapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already registered.";
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(encoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());

        userRepository.save(user);
        return "Registration successful!";
    }
}
