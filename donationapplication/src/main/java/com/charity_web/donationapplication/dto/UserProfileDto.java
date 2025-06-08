package com.charity_web.donationapplication.dto;

public class UserProfileDto {
    private String email;
    private String phoneNumber;
    private Long animalDonationCount;
    private Long childDonationCount;
    private Double totalAnimalDonationAmount;
    private Double totalChildDonationAmount;

    public UserProfileDto() {}

    public UserProfileDto(String email, String phoneNumber, Long animalDonationCount,
                          Long childDonationCount, Double totalAnimalDonationAmount,
                          Double totalChildDonationAmount) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.animalDonationCount = animalDonationCount;
        this.childDonationCount = childDonationCount;
        this.totalAnimalDonationAmount = totalAnimalDonationAmount;
        this.totalChildDonationAmount = totalChildDonationAmount;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Long getAnimalDonationCount() { return animalDonationCount; }
    public void setAnimalDonationCount(Long animalDonationCount) { this.animalDonationCount = animalDonationCount; }

    public Long getChildDonationCount() { return childDonationCount; }
    public void setChildDonationCount(Long childDonationCount) { this.childDonationCount = childDonationCount; }

    public Double getTotalAnimalDonationAmount() { return totalAnimalDonationAmount; }
    public void setTotalAnimalDonationAmount(Double totalAnimalDonationAmount) {
        this.totalAnimalDonationAmount = totalAnimalDonationAmount;
    }

    public Double getTotalChildDonationAmount() { return totalChildDonationAmount; }
    public void setTotalChildDonationAmount(Double totalChildDonationAmount) {
        this.totalChildDonationAmount = totalChildDonationAmount;
    }
}