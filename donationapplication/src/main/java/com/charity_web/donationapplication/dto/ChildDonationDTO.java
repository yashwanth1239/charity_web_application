package com.charity_web.donationapplication.dto;

public class ChildDonationDTO {
    private String charity;
    private String name;
    private String email;
    private Double amount;

    public String getCharity() {
        return charity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getAmount() {
        return amount;
    }

    public void setCharity(String charity) {
        this.charity = charity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
