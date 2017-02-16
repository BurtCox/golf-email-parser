package com.swacorp.ags.golf_email_parser.chance_to_win;

import org.joda.time.DateTime;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the Chance-To-Win domain.
 * 
 * Create Date: Feb 14, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class ChanceToWin {
   private DateTime _received;
   private String _contactName;
   private String _companyName;
   private String _contactEmail;
   private String _contactPhone;
   private String _donations;
   
   public DateTime getReceived() {
      return _received;
   }
   public void setReceived(DateTime received) {
      _received = received;
   }
   public String getContactName() {
      return _contactName;
   }
   public void setContactName(String contactName) {
      _contactName = contactName;
   }
   public String getCompanyName() {
      return _companyName;
   }
   public void setCompanyName(String companyName) {
      _companyName = companyName;
   }
   public String getContactEmail() {
      return _contactEmail;
   }
   public void setContactEmail(String contactEmail) {
      _contactEmail = contactEmail;
   }
   public String getContactPhone() {
      return _contactPhone;
   }
   public void setContactPhone(String contactPhone) {
      _contactPhone = contactPhone;
   }
   public String getDonations() {
      return _donations;
   }
   public void setDonations(String donations) {
      _donations = donations;
   }
}
