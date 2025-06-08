package com.charity_web.donationapplication.Repository;

import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalDonationRepository extends JpaRepository<AnimalDonation, Long> {
    List<AnimalDonation> findByUserUserId(Long userId);


    List<AnimalDonation> findByUser(User user);
}
