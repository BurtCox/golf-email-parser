package com.swacorp.ags.golf_email_parser.volunteer_registration;

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
 * Description: Processes records from the volunteer registration file.
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class VolunteerRecordProcessor extends EmailRecordProcessor {
   List<Volunteer> _volunteers = new ArrayList<>();
   Volunteer _volunteer = new Volunteer();
   
   public void process(KeyValue keyValue) {
      switch (keyValue.getKey()) {
      case "Date":
         processDate(keyValue.getValue());
         break;
      case "Name":
         processName(keyValue.getValue());
         break;
      case "Employee ID":
         processEmployeeId(keyValue.getValue());
         break;
      case "Email":
         processEmail(keyValue.getValue());
         break;
      case "Volunteer Shirt Size":
         processShirtSize(keyValue.getValue());
         break;
      case "Work Location":
         processWorkLocation(keyValue.getValue());
         break;
      case "Mobile Phone":
         processMobilePhone(keyValue.getValue());
         break;
      case "Availability":
         processAvailability(keyValue.getValue());
         break;
      case "First Choice":
         processFirstChoice(keyValue.getValue());
         break;
      case "Second Choice":
         processSecondChoice(keyValue.getValue());
         break;
      case "Notes":
         processNotes(keyValue.getValue());
         break;
      default:
         break;
      }
   }
   
   public List<Volunteer> getVolunteers() {
      return _volunteers;
   }
   
   @Override
   public void writeData(String outputPath) throws IOException {
      GenericCsvWriter genericCsvWriter = new GenericCsvWriter();
      String fullPath = outputPath + File.separator + "volunteers.csv";
      genericCsvWriter.write(fullPath, getVolunteersAsArray());      
   }

   public Collection<String[]> getVolunteersAsArray() {
      Collection<String[]> records = new ArrayList<>();
      
      for (Volunteer volunteer : _volunteers) {
         String[] fields = new String[11];
         fields[0] = volunteer.getReceived().toString();
         fields[1] = volunteer.getName();
         fields[2] = volunteer.getEmployeeId();
         fields[3] = volunteer.getEmail();
         fields[4] = volunteer.getShirtSize();
         fields[5] = volunteer.getWorkLocation();
         fields[6] = volunteer.getMobilePhone();
         fields[7] = volunteer.getAvailability();
         fields[8] = volunteer.getFirstChoice();
         fields[9] = volunteer.getSecondChoice();
         fields[10] = volunteer.getNotes();
         records.add(fields);
      }
      
      return records;
   }

   private void processDate(String dateTimeString) {
      DateTime received = fromString(dateTimeString);
      _volunteer.setReceived(received);
   }
   
   private void processName(String name) {
      _volunteer.setName(name);
   }
   
   private void processEmployeeId(String employeeId) {
      _volunteer.setEmployeeId(employeeId);
   }
   
   private void processEmail(String email) {
      _volunteer.setEmail(email);
   }
   
   private void processShirtSize(String shirtSize) {
      _volunteer.setShirtSize(shirtSize);
   }
   
   private void processWorkLocation(String workLocation) {
      _volunteer.setWorkLocation(workLocation);
   }
   
   private void processMobilePhone(String mobilePhone) {
      _volunteer.setMobilePhone(mobilePhone);
   }
   
   private void processAvailability(String availability) {
      _volunteer.setAvailability(availability);
   }
   
   private void processFirstChoice(String firstChoice) {
      _volunteer.setFirstChoice(firstChoice);
   }
   
   private void processSecondChoice(String secondChoice) {
      _volunteer.setSecondChoice(secondChoice);
   }
   
   private void processNotes(String notes) {
      _volunteer.setNotes(notes);
      _volunteers.add(_volunteer);
      _volunteer = new Volunteer();
   }

}
