package com.swacorp.ags.golf_email_parser.swa_golfer_registration;

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
 * Description: Processes records from the SWA Golfer registration file.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class SwaGolferRecordProcessor extends EmailRecordProcessor {
   private List<SwaGolferRegistration> _swaGolferRegistrations = new ArrayList<>();
   private SwaGolferRegistration _swaGolferRegistration = new SwaGolferRegistration();
   private Golfer _golfer = new Golfer();
   
   public void process(KeyValue keyValue) {
      switch (keyValue.getKey()) {
      case "Date":
         processDate(keyValue.getValue());
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
      case "Golfer 1 Employee Number":
      case "Golfer 2 Employee Number":
      case "Golfer 3 Employee Number":
      case "Golfer 4 Employee Number":
         processGolferEmployeeNumber(keyValue.getValue());
         break;
      case "Golfer 1 Shirt":
      case "Golfer 2 Shirt":
      case "Golfer 3 Shirt":
      case "Golfer 4 Shirt":
         processGolferShirt(keyValue.getValue());
         break;
      case "Contact Phone":
         processContactPhone(keyValue.getValue());
         break;
      case "Notes":
         processNotes(keyValue.getValue());
         break;
      }
   }
   
   @Override
   public void writeData(String outputPath) throws IOException {
      GenericCsvWriter genericCsvWriter = new GenericCsvWriter();
      String fullPath = outputPath + File.separator + "swaGolfers.csv";
      genericCsvWriter.write(fullPath, getSwaGolfersAsArray());      
   }

   public Collection<String[]> getSwaGolfersAsArray() {
      Collection<String[]> swaGolfers = new ArrayList<>();

      for (SwaGolferRegistration swaGolferRegistration : _swaGolferRegistrations) {
         for (Golfer golfer : swaGolferRegistration.getGolfers()) {
            String[] swaGolfer = new String[9];
            swaGolfer[0] = swaGolferRegistration.getReceived().toString();
            swaGolfer[1] = swaGolferRegistration.getTeamName();
            swaGolfer[2] = swaGolferRegistration.getContactPhone();
            swaGolfer[3] = golfer.getName();
            swaGolfer[4] = golfer.getEmployeeId();
            swaGolfer[5] = golfer.getSwaEmployee();
            swaGolfer[6] = golfer.getEmail();
            swaGolfer[7] = golfer.getShirtSize();
            swaGolfer[8] = swaGolferRegistration.getNotes();
            swaGolfers.add(swaGolfer);
         }
      }
      
      return swaGolfers;
   }
   
   private void processDate(String dateTimeString) {
      DateTime received = fromString(dateTimeString);
      _swaGolferRegistration.setReceived(received);
   }

   private void processNotes(String notes) {
      _swaGolferRegistration.setNotes(notes);
      _swaGolferRegistrations.add(_swaGolferRegistration);
      _swaGolferRegistration = new SwaGolferRegistration();
   }

   private void processContactPhone(String contactPhone) {
      _swaGolferRegistration.setContactPhone(contactPhone);
   }
   
   private void processGolferName(String name) {
      if (_swaGolferRegistration.getTeamName() == null) {
         _swaGolferRegistration.setTeamName(name);         
      }
      
      if (!name.isEmpty()) {
         _golfer.setName(name);
         
      }
   }
   
   private void processGolferEmail(String email) {
      _golfer.setEmail(email);
   }
   
   private void processGolferEmployeeNumber(String employeeNumber) {
      _golfer.setEmployeeId(employeeNumber);
   }
   
   private void processGolferShirt(String shirtSize) {
      _golfer.setShirtSize(shirtSize);
      
      if (_golfer.getName() != null) {
         _swaGolferRegistration.addGolfer(_golfer);         
      }
      
      _golfer = new Golfer();
   }

}
