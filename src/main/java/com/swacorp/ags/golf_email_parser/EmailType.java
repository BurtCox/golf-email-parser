package com.swacorp.ags.golf_email_parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.swacorp.ags.golf_email_parser.adopt_a_team.AdoptATeamRecordProcessor;
import com.swacorp.ags.golf_email_parser.chance_to_win.ChanceToWinRecordProcessor;
import com.swacorp.ags.golf_email_parser.golfer_update.GolferUpdateRecordProcessor;
import com.swacorp.ags.golf_email_parser.sponsor_registration.SponsorRecordProcessor;
import com.swacorp.ags.golf_email_parser.swa_golfer_registration.SwaGolferRecordProcessor;
import com.swacorp.ags.golf_email_parser.volunteer_registration.VolunteerRecordProcessor;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the record processor for each kind of email file.
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public enum EmailType {
   VOLUNTEER("SWA Volunteer Signup", new VolunteerRecordProcessor()),
   ADOPT_A_TEAM("Adopt-A-Team Sponsor", new AdoptATeamRecordProcessor()),
   SPONSOR("Sponsor Registration", new SponsorRecordProcessor()),
   SWA_GOLFER("SWA Golfer Signup", new SwaGolferRecordProcessor()),
   GOLFER_UPDATE("Sponsor Golfer Update", new GolferUpdateRecordProcessor()),
   CHANCE_TO_WIN("Raffle Donation", new ChanceToWinRecordProcessor());
   
   private final String _key;
   private final EmailRecordProcessor _processor;
   
   EmailType(String key, EmailRecordProcessor processor) {
      _key = key;
      _processor = processor;
   }
   
   public String getKey() {
      return _key;
   }
   
   public EmailRecordProcessor getEmailRecordProcessor() {
      return _processor;
   }
   
   public static List<EmailRecordProcessor> getRecordProcessors() {
      List<EmailRecordProcessor> emailRecordProcessors = new ArrayList<>();
      for (EmailType emailType : EmailType.values()) {
         emailRecordProcessors.add(emailType.getEmailRecordProcessor());
      }
      
      return emailRecordProcessors;
   }
   
   public static EmailRecordProcessor getProcessorForFile(File file) {
      EmailRecordProcessor emailRecordProcessor = null;
      
      for (EmailType emailType : EmailType.values()) {
         if (file.getName().contains(emailType.getKey())) {
            emailRecordProcessor = emailType.getEmailRecordProcessor();
            break;
         }
      }
      
      return emailRecordProcessor;
   }
   
   public static EmailType getType(String key) {
      EmailType configuration = null;
      
      for (EmailType config : EmailType.values()) {
         if (config._key.equalsIgnoreCase(key)) {
            configuration = config;
         }
      }
      
      return configuration;
   }

}
