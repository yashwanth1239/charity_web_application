package com.charity_web.donationapplication.controller;



import com.charity_web.donationapplication.dto.LoginRequest;
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
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String result = loginService.login(request);
        if (result.equals("Login successful!")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(401).body(result);  // Unauthorized
        }
    }
}

