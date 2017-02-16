package com.swacorp.ags.golf_email_parser.swa_golfer_registration;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.swacorp.ags.golf_email_parser.Golfer;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the SWA Golfer registration domain.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class SwaGolferRegistration {
   private DateTime _received;
   private String _teamName;
   private String _numberOfGolfers;
   private String _contactPhone;
   private String _notes;
   private List<Golfer> _golfers = new ArrayList<>();
   
   public DateTime getReceived() {
      return _received;
   }
   public void setReceived(DateTime received) {
      _received = received;
   }
   public String getTeamName() {
      return _teamName;
   }
   public void setTeamName(String teamName) {
      _teamName = teamName;
   }
   public String getNumberOfGolfers() {
      return _numberOfGolfers;
   }
   public void setNumberOfGolfers(String numberOfGolfers) {
      _numberOfGolfers = numberOfGolfers;
   }
   public String getContactPhone() {
      return _contactPhone;
   }
   public void setContactPhone(String contactPhone) {
      _contactPhone = contactPhone;
   }
   public String getNotes() {
      return _notes;
   }
   public void setNotes(String notes) {
      _notes = notes;
   }
   public List<Golfer> getGolfers() {
      return _golfers;
   }
   public void setGolfers(List<Golfer> golfers) {
      _golfers = golfers;
   }
   
   public void addGolfer(Golfer golfer) {
      _golfers.add(golfer);
   }
}
