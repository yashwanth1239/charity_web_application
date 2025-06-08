package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.Repository.AnimalDonationRepository;
import com.charity_web.donationapplication.Repository.ChildDonationRepository;
import com.charity_web.donationapplication.dto.UserProfileDto;
import com.charity_web.donationapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private AnimalDonationRepository animalDonationRepository;

    @Autowired
    private ChildDonationRepository childDonationRepository;

    public UserProfileDto getUserProfile(User user) {
        // Get donation counts
        Long animalDonationCount = animalDonationRepository.countByUser(user);
        Long childDonationCount = childDonationRepository.countByUser(user);

        // Get total donation amounts
        Double totalAnimalAmount = animalDonationRepository.sumAmountByUser(user);
        Double totalChildAmount = childDonationRepository.sumAmountByUser(user);

        // Handle null values (in case user has no donations)
        if (animalDonationCount == null) animalDonationCount = 0L;
        if (childDonationCount == null) childDonationCount = 0L;
        if (totalAnimalAmount == null) totalAnimalAmount = 0.0;
        if (totalChildAmount == null) totalChildAmount = 0.0;

        return new UserProfileDto(
                user.getEmail(),
                user.getPhoneNumber(),
                animalDonationCount,
                childDonationCount,
                totalAnimalAmount,
                totalChildAmount
        );
    }
}