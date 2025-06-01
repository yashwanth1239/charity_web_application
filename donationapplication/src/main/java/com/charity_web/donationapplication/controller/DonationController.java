package com.charity_web.donationapplication.controller;

import com.charity_web.donationapplication.dto.AnimalDonationDTO;
import com.charity_web.donationapplication.dto.ChildDonationDTO;
import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.ChildDonation;
import com.charity_web.donationapplication.service.AnimalDonationService;
import com.charity_web.donationapplication.service.ChildDonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/donate")
public class DonationController {

    private final AnimalDonationService animalService;
    private final ChildDonationService childService;

    public DonationController(AnimalDonationService animalService, ChildDonationService childService) {
        this.animalService = animalService;
        this.childService = childService;
    }

    @PostMapping("/animal")
    public ResponseEntity<AnimalDonation> donateToAnimal(@RequestBody AnimalDonationDTO dto) {
        AnimalDonation saved = animalService.saveDonation(dto);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/child")
    public ResponseEntity<ChildDonation> donateToChild(@RequestBody ChildDonationDTO dto) {
        ChildDonation saved = childService.saveDonation(dto);
        return ResponseEntity.ok(saved);
    }
}
