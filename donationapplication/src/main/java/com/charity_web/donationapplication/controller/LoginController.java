package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.dto.LoginRequest;
import com.charity_web.donationapplication.dto.LoginResponse;
import com.charity_web.donationapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = loginService.login(request);
            if (response.getToken() != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(401).body(response);
            }
        } catch (Exception e) {
            LoginResponse errorResponse = new LoginResponse(null, null, "Login failed: " + e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
}