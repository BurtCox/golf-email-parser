package com.swacorp.ags.golf_email_parser.adopt_a_team;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.joda.time.DateTime;

import com.embassy.file.GenericCsvWriter;
import com.swacorp.ags.golf_email_parser.EmailRecordProcessor;
import com.swacorp.ags.golf_email_parser.KeyValue;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Process records from the Adopt-A-Team file.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class AdoptATeamRecordProcessor extends EmailRecordProcessor {
   List<AdoptATeam> _teamAdoptions = new ArrayList<>();
   AdoptATeam _teamAdoption = new AdoptATeam();
   
   public void process(KeyValue keyValue) {
      switch (keyValue.getKey()) {
      case "Date":
         processDate(keyValue.getValue());
         break;
      case "Company Name":
         processCompanyName(keyValue.getValue());
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
      case "Number of sponsored SWA golfers":
         processNumberOfGolfers(keyValue.getValue());
         break;
      case "Notes":
         processNotes(keyValue.getValue());
         break;
      case "Are you updating an existing registration?" :
         processIsUpdate(keyValue.getValue());
         break;
      }
   }
   
   public void writeData(String outputPath) throws IOException {
      GenericCsvWriter genericCsvWriter = new GenericCsvWriter();
      String fullPath = outputPath + File.separator + "adoptATeam.csv";
      genericCsvWriter.write(fullPath, getAdoptATeamAsArray());
   }
   
   public Collection<String[]> getAdoptATeamAsArray() {
      Collection<String[]> contacts = new ArrayList<>();
      
      for (AdoptATeam adoptATeam : _teamAdoptions) {
         String[] contact = new String[9];
         contact[0] = adoptATeam.getReceived().toString();
         contact[1] = adoptATeam.getCompanyName();
         contact[2] = adoptATeam.getContactName();
         contact[3] = adoptATeam.getContactPhone();
         contact[4] = adoptATeam.getContactEmail();
         contact[5] = adoptATeam.getContactAddress();
         contact[6] = adoptATeam.getNumSponsoredGolfers().toString();
         contact[7] = adoptATeam.getIsUpdate();
         contact[8] = adoptATeam.getNotes();
         contacts.add(contact);
      }
      
      return contacts;
   }
   
   
   private void processDate(String dateTimeString) {
      DateTime received = fromString(dateTimeString);
      _teamAdoption.setReceived(received);
   }

   private void processCompanyName(String companyName) {
      _teamAdoption.setCompanyName(companyName);
   }
   
   private void processContactName(String contactName) {
      _teamAdoption.setContactName(contactName);
   }
   
   private void processContactPhone(String contactPhone) {
      _teamAdoption.setContactPhone(contactPhone);
   }
   
   private void processContactEmail(String contactEmail) {
      _teamAdoption.setContactEmail(contactEmail);
   }
   
   private void processContactAddress(String contactAddress) {
      _teamAdoption.setContactAddress(contactAddress);
   }
   
   private void processNumberOfGolfers(String numberOfGolfers) {
      _teamAdoption.setNumSponsoredGolfers(Integer.parseInt(numberOfGolfers));
   }
   
   private void processIsUpdate(String isUpdate) {
      _teamAdoption.setIsUpdate(isUpdate);
      _teamAdoptions.add(_teamAdoption);
      _teamAdoption = new AdoptATeam();
   }
   
   private void processNotes(String notes) {
      _teamAdoption.setNotes(notes);
   }
}
