package com.charity_web.donationapplication.service;

import com.charity_web.donationapplication.model.AnimalDonation;
import com.charity_web.donationapplication.model.ChildDonation;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfGeneratorService {

    public void exportAnimal(HttpServletResponse response, AnimalDonation donation) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=animal_donation_receipt.pdf");

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            document.add(new Paragraph("Animal Donation Receipt", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Name: " + donation.getName()));
            document.add(new Paragraph("Email: " + donation.getEmail()));
            document.add(new Paragraph("Charity: " + donation.getCharity()));
            document.add(new Paragraph("Amount: ₹" + donation.getAmount()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank you for your generous donation!"));

        } catch (DocumentException e) {
            throw new IOException("Error generating PDF", e);
        } finally {
            document.close();
        }
    }

    public void exportChild(HttpServletResponse response, ChildDonation donation) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=child_donation_receipt.pdf");

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            document.add(new Paragraph("Child Donation Receipt", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Name: " + donation.getName()));
            document.add(new Paragraph("Email: " + donation.getEmail()));
            document.add(new Paragraph("Charity: " + donation.getCharity()));
            document.add(new Paragraph("Amount: ₹" + donation.getAmount()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank you for your generous donation!"));

        } catch (DocumentException e) {
            throw new IOException("Error generating PDF", e);
        } finally {
            document.close();
        }
    }
}