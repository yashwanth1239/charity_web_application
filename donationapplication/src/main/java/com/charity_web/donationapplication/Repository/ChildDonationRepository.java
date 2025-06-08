package com.charity_web.donationapplication.Repository;

import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildDonationRepository extends JpaRepository<ChildDonation, Long> {
    List<ChildDonation> findByUserUserId(Long userId);

    List<ChildDonation> findByUser(User user);

    Long countByUser(User user);

    // Sum total donation amount by user
    @Query("SELECT COALESCE(SUM(c.amount), 0.0) FROM ChildDonation c WHERE c.user = :user")
    Double sumAmountByUser(@Param("user") User user);
}
