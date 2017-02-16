package com.swacorp.ags.golf_email_parser.volunteer_registration;

import org.joda.time.DateTime;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the volunteer registration domain.
 * 
 * Create Date: Feb 13, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class Volunteer {
	private DateTime _received;
	private String _subject;
	private String _name;
	private String _employeeId;
	private String _email;
	private String _shirtSize;
	private String _workLocation;
	private String _mobilePhone;
	private String _availability;
	private String _firstChoice;
	private String _secondChoice;
	private String _notes;
   
	public DateTime getReceived() {
      return _received;
   }
   public void setReceived(DateTime received) {
      _received = received;
   }
   public String getSubject() {
      return _subject;
   }
   public void setSubject(String subject) {
      _subject = subject;
   }
   public String getName() {
      return _name;
   }
   public void setName(String name) {
      _name = name;
   }
   public String getEmployeeId() {
      return _employeeId;
   }
   public void setEmployeeId(String employeeId) {
      _employeeId = employeeId;
   }
   public String getEmail() {
      return _email;
   }
   public void setEmail(String email) {
      _email = email;
   }
   public String getShirtSize() {
      return _shirtSize;
   }
   public void setShirtSize(String shirtSize) {
      _shirtSize = shirtSize;
   }
   public String getWorkLocation() {
      return _workLocation;
   }
   public void setWorkLocation(String workLocation) {
      _workLocation = workLocation;
   }
   public String getMobilePhone() {
      return _mobilePhone;
   }
   public void setMobilePhone(String mobilePhone) {
      _mobilePhone = mobilePhone;
   }
   public String getAvailability() {
      return _availability;
   }
   public void setAvailability(String availability) {
      _availability = availability;
   }
   public String getFirstChoice() {
      return _firstChoice;
   }
   public void setFirstChoice(String firstChoice) {
      _firstChoice = firstChoice;
   }
   public String getSecondChoice() {
      return _secondChoice;
   }
   public void setSecondChoice(String secondChoice) {
      _secondChoice = secondChoice;
   }
   public String getNotes() {
      return _notes;
   }
   public void setNotes(String notes) {
      _notes = notes;
   }
}
