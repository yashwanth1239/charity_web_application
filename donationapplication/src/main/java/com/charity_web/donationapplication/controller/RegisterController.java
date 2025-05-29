package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.dto.RegisterRequest;
import com.charity_web.donationapplication.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String response = registerService.register(request);
        return ResponseEntity.ok(response);
    }
}
