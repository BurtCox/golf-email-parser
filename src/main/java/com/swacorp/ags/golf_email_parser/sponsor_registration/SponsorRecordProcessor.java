package com.swacorp.ags.golf_email_parser.sponsor_registration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;

import com.embassy.file.GenericCsvWriter;
import com.swacorp.ags.golf_email_parser.EmailRecordProcessor;
import com.swacorp.ags.golf_email_parser.Golfer;
import com.swacorp.ags.golf_email_parser.KeyValue;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Process records from the sponsor registration file.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class SponsorRecordProcessor extends EmailRecordProcessor {
   List<SponsorRegistration> _sponsorRegistrations = new ArrayList<>();
   SponsorRegistration _sponsorRegistration = new SponsorRegistration();
   Golfer _golfer = new Golfer();
   
   public void process(KeyValue keyValue) {
      switch (keyValue.getKey()) {
      case "Date":
         processDate(keyValue.getValue());
         break;
      case "Company Name":
         processCompanyName(keyValue.getValue());
         break;
      case "Sponsorship Choice":
         processSponsorship(keyValue.getValue());
         break;
      case "Point of Contact":
         processContactName(keyValue.getValue());
         break;
      case "Contact Phone":
         processContactPhone(keyValue.getValue());
         break;
      case "Contact Email":
         processContactEmail(keyValue.getValue());
         break;
      case "Contact Address":
         processContactAddress(keyValue.getValue());
         break;
      case "Select the number of golfers for this team":
         processNumberOfGolfers(keyValue.getValue());
         break;
      case "Golfer 1 Name":
      case "Golfer 2 Name":
      case "Golfer 3 Name":
      case "Golfer 4 Name":
         processGolferName(keyValue.getValue());
         break;
      case "Golfer 1 Email":
      case "Golfer 2 Email":
      case "Golfer 3 Email":
      case "Golfer 4 Email":
         processGolferEmail(keyValue.getValue());
         break;
      case "Golfer 1 Shirt":
      case "Golfer 2 Shirt":
      case "Golfer 3 Shirt":
      case "Golfer 4 Shirt":
         processGolferShirtSize(keyValue.getValue());
         break;
      case "Is Golfer 1 a SWA Employee?":
      case "Is Golfer 2 a SWA Employee?":
      case "Is Golfer 3 a SWA Employee?":
      case "Is Golfer 4 a SWA Employee?":
         processSwaEmployee(keyValue.getValue());
         break;
      case "Notes":
         processNotes(keyValue.getValue());
         break;
      }
   }
   
   public Collection<String[]> getContactsAsArray() {
      Collection<String[]> contacts = new ArrayList<>();
      
      for (SponsorRegistration sponsorRegistration : _sponsorRegistrations) {
         String[] contact = new String[6];
         contact[0] = sponsorRegistration.getReceived().toString();
         contact[1] = sponsorRegistration.getCompanyName();
         contact[2] = sponsorRegistration.getContactName();
         contact[3] = sponsorRegistration.getContactPhone();
         contact[4] = sponsorRegistration.getContactEmail();
         contact[5] = sponsorRegistration.getContactAddress();
         contacts.add(contact);
      }
      
      return contacts;
   }
   
   public Collection<String[]> getGolfersAsArray() {
      Collection<String[]> sponsorGolfers = new ArrayList<>();
      
      for (SponsorRegistration sponsorRegistration : _sponsorRegistrations) {
         Integer golferCount = Integer.parseInt(sponsorRegistration.getNumberOfGolfers());
         Integer thisGolfer = 0;
         
         for (Golfer golfer : sponsorRegistration.getGolfers()) {
            if (thisGolfer < golferCount) {
               thisGolfer++;
               String[] golfers = new String[7];
               golfers[0] = sponsorRegistration.getReceived().toString();
               golfers[1] = sponsorRegistration.getCompanyName();
               golfers[2] = sponsorRegistration.getNumberOfGolfers();
               golfers[3] = golfer.getName();
               golfers[4] = golfer.getEmail();
               golfers[5] = golfer.getShirtSize();
               golfers[6] = golfer.getSwaEmployee();
               sponsorGolfers.add(golfers);               
            }
         }
      }
      
      return sponsorGolfers;
   }
   
   @Override
   public void writeData(String outputPath) throws IOException {
      GenericCsvWriter genericCsvWriter = new GenericCsvWriter();
      String fullPath = outputPath + File.separator + "sponsorContacts.csv";
      genericCsvWriter.write(fullPath, getContactsAsArray());
      fullPath = outputPath + File.separator + "sponsorships.csv";
      genericCsvWriter.write(fullPath, getSponsorshipsAsArray());
      fullPath = outputPath + File.separator + "sponsorGolfers.csv";
      genericCsvWriter.write(fullPath, getGolfersAsArray());
   }

   public Collection<String[]> getSponsorshipsAsArray() {
      Collection<String[]> sponsorships = new ArrayList<>();
      
      for (SponsorRegistration sponsorRegistration : _sponsorRegistrations) {
         String[] sponsorship = new String[5];
         sponsorship[0] = sponsorRegistration.getReceived().toString();
         sponsorship[1] = sponsorRegistration.getCompanyName();
         sponsorship[2] = sponsorRegistration.getSponsorship();
         sponsorship[3] = sponsorRegistration.getNumberOfGolfers();
         sponsorship[4] = sponsorRegistration.getNotes();
         sponsorships.add(sponsorship);
      }
      
      return sponsorships;
   }
   
   private void processDate(String dateTimeString) {
      DateTime received = fromString(dateTimeString);
      _sponsorRegistration.setReceived(received);
   }

   private void processCompanyName(String companyName) {
      _sponsorRegistration.setCompanyName(companyName);
   }
   
   private void processSponsorship(String sponsorship) {
      _sponsorRegistration.setSponsorship(sponsorship);
   }
   
   private void processContactName(String contactName) {
      _sponsorRegistration.setContactName(contactName);
   }
   
   private void processContactPhone(String contactPhone) {
      _sponsorRegistration.setContactPhone(contactPhone);
   }
   
   private void processContactEmail(String contactEmail) {
      _sponsorRegistration.setContactEmail(contactEmail);
   }
   private void processContactAddress(String contactAddress) {
      _sponsorRegistration.setContactAddress(contactAddress);
   }
   
   private void processNumberOfGolfers(String numberOfGolfers) {
      _sponsorRegistration.setNumberOfGolfers(numberOfGolfers);
   }
   
   private void processGolferName(String golferName) {
      if (golferName.isEmpty()) {
         golferName = "TBD";
      }
      _golfer.setName(golferName);
   }
   
   private void processGolferEmail(String golferEmail) {
      _golfer.setEmail(golferEmail);
   }
   
   private void processGolferShirtSize(String shirtSize) {
      if (shirtSize.equalsIgnoreCase("Select")) {
         shirtSize = new String();
      }
      _golfer.setShirtSize(shirtSize);
   }
   
   private void processSwaEmployee(String isSwaEmployee) {
      if (isSwaEmployee.isEmpty()) {
         isSwaEmployee = "No";
      }

      _golfer.setSwaEmployee(isSwaEmployee);
      _sponsorRegistration.addGolfer(_golfer);
      _golfer = new Golfer();
   }
   
   private void processNotes(String notes) {
      _sponsorRegistration.setNotes(notes);
      _sponsorRegistrations.add(_sponsorRegistration);
      _sponsorRegistration = new SponsorRegistration();
   }

}
