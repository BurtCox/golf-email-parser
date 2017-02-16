package com.swacorp.ags.golf_email_parser.sponsor_registration;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.swacorp.ags.golf_email_parser.Golfer;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the sponsor registration domain.
 * 
 * Create Date: Feb 13, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class SponsorRegistration {
   private DateTime _received;
   private String _companyName;
   private String _sponsorship;
   private String _contactName;
   private String _contactPhone;
   private String _contactEmail;
   private String _contactAddress;
   private String _numberOfGolfers;
   private List<Golfer> _golfers = new ArrayList<>();
   private String _notes;
   
   public DateTime getReceived() {
      return _received;
   }
   public void setReceived(DateTime received) {
      _received = received;
   }
   public String getCompanyName() {
      return _companyName;
   }
   public void setCompanyName(String companyName) {
      _companyName = companyName;
   }
   public String getSponsorship() {
      return _sponsorship;
   }
   public void setSponsorship(String sponsorship) {
      _sponsorship = sponsorship;
   }
   public String getContactName() {
      return _contactName;
   }
   public void setContactName(String contactName) {
      _contactName = contactName;
   }
   public String getContactPhone() {
      return _contactPhone;
   }
   public void setContactPhone(String contactPhone) {
      _contactPhone = contactPhone;
   }
   public String getContactEmail() {
      return _contactEmail;
   }
   public void setContactEmail(String contactEmail) {
      _contactEmail = contactEmail;
   }
   public String getContactAddress() {
      return _contactAddress;
   }
   public void setContactAddress(String contactAddress) {
      _contactAddress = contactAddress;
   }
   public String getNumberOfGolfers() {
      return _numberOfGolfers;
   }
   public void setNumberOfGolfers(String numberOfGolfers) {
      _numberOfGolfers = numberOfGolfers;
   }
   
   public void addGolfer(Golfer golfer) {
      _golfers.add(golfer);
   }
   
   public List<Golfer> getGolfers() {
      return _golfers;
   }
   public void setGolfers(List<Golfer> golfers) {
      _golfers = golfers;
   }
   public String getNotes() {
      return _notes;
   }
   public void setNotes(String notes) {
      _notes = notes;
   }
}
