package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.dto.ChildDonationDTO;
import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.model.User;
import com.charity_web.donationapplication.Repository.ChildDonationRepository;
import com.charity_web.donationapplication.Repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ChildDonationService {

    private final ChildDonationRepository repository;
    private final UserRepository userRepository;

    public ChildDonationService(ChildDonationRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public ChildDonation saveDonation(ChildDonationDTO dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        ChildDonation donation = new ChildDonation();
        donation.setCharity(dto.getCharity());
        donation.setName(dto.getName());
        donation.setEmail(dto.getEmail());
        donation.setAmount(dto.getAmount());
        donation.setUser(user);

        return repository.save(donation);
    }
}
