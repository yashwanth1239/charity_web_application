package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.dto.LogoutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoutService {

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    public LogoutResponse logout(String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                String jwtToken = token.substring(7);
                tokenBlacklistService.blacklistToken(jwtToken);
                return new LogoutResponse("Logout successful", true);
            } else {
                return new LogoutResponse("Invalid token format", false);
            }
        } catch (Exception e) {
            return new LogoutResponse("Logout failed: " + e.getMessage(), false);
        }
    }
}