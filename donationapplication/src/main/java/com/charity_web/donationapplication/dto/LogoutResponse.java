package com.charity_web.donationapplication.dto;

public class LogoutResponse {
    private String message;
    private boolean success;

    public LogoutResponse() {}

    public LogoutResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
}