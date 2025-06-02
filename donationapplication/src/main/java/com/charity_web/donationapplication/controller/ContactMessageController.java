package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.service.ContactMessageService;
import com.charity_web.donationapplication.dto.ContactMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping
    public ResponseEntity<String> contactUs(@RequestBody ContactMessageRequest request) {
        String response = contactMessageService.saveMessage(request);
        return ResponseEntity.ok(response);
    }
}