package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.Repository.AnimalDonationRepository;
import com.charity_web.donationapplication.Repository.ChildDonationRepository;
import com.charity_web.donationapplication.dto.DonationResponseDto;
import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonationHistoryService {

    @Autowired
    private AnimalDonationRepository animalDonationRepo;

    @Autowired
    private ChildDonationRepository childDonationRepo;

    public List<DonationResponseDto> getUserDonations(User user) {
        List<AnimalDonation> animalDonations = animalDonationRepo.findByUser(user);
        List<ChildDonation> childDonations = childDonationRepo.findByUser(user);

        List<DonationResponseDto> result = new ArrayList<>();

        for (AnimalDonation d : animalDonations) {
            result.add(new DonationResponseDto(
                    d.getId(), d.getName(), d.getEmail(), d.getCharity(),
                    d.getAmount(), "Animal", "/api/donations/pdf/animal/" + d.getId()
            ));
        }

        for (ChildDonation d : childDonations) {
            result.add(new DonationResponseDto(
                    d.getId(), d.getName(), d.getEmail(), d.getCharity(),
                    d.getAmount(), "Child", "/api/donations/pdf/child/" + d.getId()
            ));
        }

        return result;
    }
}