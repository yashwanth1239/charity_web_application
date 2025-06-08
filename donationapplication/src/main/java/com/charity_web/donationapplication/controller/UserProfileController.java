package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.dto.UserProfileDto;
import com.charity_web.donationapplication.model.User;
import com.charity_web.donationapplication.security.CustomUserDetailsService;
import com.charity_web.donationapplication.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping
    public ResponseEntity<UserProfileDto> getUserProfile(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            // Get the authenticated user
            User user = userDetailsService.getUserByEmail(userDetails.getUsername());

            // Get user profile data
            UserProfileDto profileDto = userProfileService.getUserProfile(user);

            return ResponseEntity.ok(profileDto);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}