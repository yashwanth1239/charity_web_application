package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.Repository.AnimalDonationRepository;
import com.charity_web.donationapplication.Repository.ChildDonationRepository;
import com.charity_web.donationapplication.dto.DonationResponseDto;
import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.model.User;
import com.charity_web.donationapplication.security.CustomUserDetailsService;
import com.charity_web.donationapplication.service.DonationHistoryService;
import com.charity_web.donationapplication.service.PdfGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonationHistoryController {

    @Autowired
    private DonationHistoryService donationHistoryService;

    @Autowired
    private PdfGeneratorService pdfService;

    @Autowired
    private AnimalDonationRepository animalRepo;

    @Autowired
    private ChildDonationRepository childRepo;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/history")
    public List<DonationResponseDto> getDonations(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userDetailsService.getUserByEmail(userDetails.getUsername());
        return donationHistoryService.getUserDonations(user);
    }

    @GetMapping(value = "/pdf/animal/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getAnimalReceipt(@PathVariable Long id, HttpServletResponse response,
                                 @AuthenticationPrincipal UserDetails userDetails) throws IOException {
        User user = userDetailsService.getUserByEmail(userDetails.getUsername());
        AnimalDonation donation = animalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        if (!donation.getUser().getUserId().equals(user.getUserId())) {
            throw new SecurityException("Access Denied");
        }
        pdfService.exportAnimal(response, donation);
    }

    @GetMapping(value = "/pdf/child/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void getChildReceipt(@PathVariable Long id, HttpServletResponse response,
                                @AuthenticationPrincipal UserDetails userDetails) throws IOException {
        User user = userDetailsService.getUserByEmail(userDetails.getUsername());
        ChildDonation donation = childRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation not found"));

        if (!donation.getUser().getUserId().equals(user.getUserId())) {
            throw new SecurityException("Access Denied");
        }
        pdfService.exportChild(response, donation);
    }
}