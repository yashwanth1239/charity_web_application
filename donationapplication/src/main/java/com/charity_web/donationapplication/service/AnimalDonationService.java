package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.dto.AnimalDonationDTO;
import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.User;
import com.charity_web.donationapplication.Repository.AnimalDonationRepository;
import com.charity_web.donationapplication.Repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AnimalDonationService {

    private final AnimalDonationRepository repository;
    private final UserRepository userRepository;

    public AnimalDonationService(AnimalDonationRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public AnimalDonation saveDonation(AnimalDonationDTO dto) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        AnimalDonation donation = new AnimalDonation();
        donation.setCharity(dto.getCharity());
        donation.setName(dto.getName());
        donation.setEmail(dto.getEmail());
        donation.setAmount(dto.getAmount());
        donation.setUser(user);

        return repository.save(donation);
    }
}
