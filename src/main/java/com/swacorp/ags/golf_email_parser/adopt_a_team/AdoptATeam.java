package com.swacorp.ags.golf_email_parser.adopt_a_team;

import org.joda.time.DateTime;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the Adopt-A-Team domain.
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class AdoptATeam {
   private DateTime _received;
   private String _companyName;
   private String _contactName;
   private String _contactPhone;
   private String _contactEmail;
   private String _contactAddress;
   private Integer _numSponsoredGolfers;
   private String _notes;
   private String _isUpdate;
   
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
   public Integer getNumSponsoredGolfers() {
      return _numSponsoredGolfers;
   }
   public void setNumSponsoredGolfers(Integer numSponsoredGolfers) {
      _numSponsoredGolfers = numSponsoredGolfers;
   }
   public String getNotes() {
      return _notes;
   }
   public void setNotes(String notes) {
      _notes = notes;
   }
   public String getIsUpdate() {
      return _isUpdate;
   }
   public void setIsUpdate(String isUpdate) {
      _isUpdate = isUpdate;
   }
}
