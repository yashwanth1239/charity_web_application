package com.charity_web.donationapplication.model;

import jakarta.persistence.*;

@Entity
public class AnimalDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String charity;
    private String name;
    private String email;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

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

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(User user) {
        this.user = user;
    }
}
