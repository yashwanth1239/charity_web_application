package com.charity_web.donationapplication.Repository;

import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildDonationRepository extends JpaRepository<ChildDonation, Long> {
    List<ChildDonation> findByUserUserId(Long userId);

    List<ChildDonation> findByUser(User user);
}
