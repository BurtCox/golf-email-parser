package com.swacorp.ags.golf_email_parser.chance_to_win;

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
 * Description: Processes records from the Chance-To-Win file.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class ChanceToWinRecordProcessor extends EmailRecordProcessor {
   List<ChanceToWin> _chancesToWin = new ArrayList<>();
   ChanceToWin _chanceToWin = new ChanceToWin();
   
   public void process(KeyValue keyValue) {
      switch (keyValue.getKey()) {
      case "Date":
         processDate(keyValue.getValue());
         break;
      case "Company Name":
         processCompanyName(keyValue.getValue());
         break;
      case "Your Name":
         processContactName(keyValue.getValue());
         break;
      case "Contact Phone":
         processContactPhone(keyValue.getValue());
         break;
      case "Contact Email Address":
         processContactEmail(keyValue.getValue());
         break;
      case "Please provide us with a description and quantity of the prizes you would like to donate":
         processDonations(keyValue.getValue());
         break;
      }
   }
   
   public Collection<String[]> getChancesToWinAsArray() {
      Collection<String[]> chancesToWin = new ArrayList<>();
      
      for (ChanceToWin chanceToWin : _chancesToWin) {
         String[] contact = new String[6];
         contact[0] = chanceToWin.getReceived().toString();
         contact[1] = chanceToWin.getCompanyName();
         contact[2] = chanceToWin.getContactName();
         contact[3] = chanceToWin.getContactPhone();
         contact[4] = chanceToWin.getContactEmail();
         contact[5] = chanceToWin.getDonations();
         chancesToWin.add(contact);
      }
      
      return chancesToWin;
   }
   
   private void processDate(String dateTimeString) {
      DateTime received = fromString(dateTimeString);
      _chanceToWin.setReceived(received);
   }

   private void processCompanyName(String companyName) {
      _chanceToWin.setCompanyName(companyName);
   }
   
   private void processContactName(String contactName) {
      _chanceToWin.setContactName(contactName);
   }
   
   private void processContactPhone(String contactPhone) {
      _chanceToWin.setContactPhone(contactPhone);
   }
   
   private void processContactEmail(String contactEmail) {
      _chanceToWin.setContactEmail(contactEmail);
   }
   
   private void processDonations(String donations) {
      _chanceToWin.setDonations(donations);
      _chancesToWin.add(_chanceToWin);
      _chanceToWin = new ChanceToWin();
   }

   @Override
   public void writeData(String outputPath) throws IOException {
      GenericCsvWriter genericCsvWriter = new GenericCsvWriter();
      String fullPath = outputPath + File.separator + "chanceToWin.csv";
      genericCsvWriter.write(fullPath, getChancesToWinAsArray());
   }
}
