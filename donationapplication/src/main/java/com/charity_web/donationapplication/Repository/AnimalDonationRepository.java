package com.charity_web.donationapplication.Repository;

import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalDonationRepository extends JpaRepository<AnimalDonation, Long> {
    List<AnimalDonation> findByUserUserId(Long userId);


    List<AnimalDonation> findByUser(User user);

    Long countByUser(User user);


    @Query("SELECT COALESCE(SUM(a.amount), 0.0) FROM AnimalDonation a WHERE a.user = :user")
    Double sumAmountByUser(@Param("user") User user);

}
