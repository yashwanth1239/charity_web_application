package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.Repository.ContactMessageRepository;
import com.charity_web.donationapplication.dto.ContactMessageRequest;
import com.charity_web.donationapplication.model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    public String saveMessage(ContactMessageRequest request) {
        ContactMessage message = new ContactMessage();
        message.setName(request.getName());
        message.setEmail(request.getEmail());
        message.setCharity(request.getCharity());
        message.setMessage(request.getMessage());

        repository.save(message);
        return "Your message has been received!";
    }
}