package com.charity_web.donationapplication.dto;

public class DonationResponseDto {
    private Long id;
    private String name;
    private String email;
    private String charity;
    private Double amount;
    private String type;
    private String pdfUrl;

    public DonationResponseDto() {}

    public DonationResponseDto(Long id, String name, String email, String charity,
                               Double amount, String type, String pdfUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charity = charity;
        this.amount = amount;
        this.type = type;
        this.pdfUrl = pdfUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCharity() { return charity; }
    public void setCharity(String charity) { this.charity = charity; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPdfUrl() { return pdfUrl; }
    public void setPdfUrl(String pdfUrl) { this.pdfUrl = pdfUrl; }
}