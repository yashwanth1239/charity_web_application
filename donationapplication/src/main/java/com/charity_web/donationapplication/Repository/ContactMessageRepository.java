package com.charity_web.donationapplication.Repository;

import com.charity_web.donationapplication.model.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}