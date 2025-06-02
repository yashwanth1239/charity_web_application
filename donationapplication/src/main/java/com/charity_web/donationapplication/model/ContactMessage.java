package com.charity_web.donationapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String charity;

    @Column(nullable = false, length = 1000)
    private String message;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCharity() { return charity; }

    public void setCharity(String charity) { this.charity = charity; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}