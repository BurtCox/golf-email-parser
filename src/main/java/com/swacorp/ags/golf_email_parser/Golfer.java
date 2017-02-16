package com.swacorp.ags.golf_email_parser;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Defines the Golfer domain.
 * 
 * Create Date: Feb 13, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class Golfer {
   private String _name;
   private String _employeeId;
   private String _email;
   private String _shirtSize;
   private String _swaEmployee;
   
   public String getName() {
      return _name;
   }
   public void setName(String name) {
      _name = name;
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
   public String getSwaEmployee() {
      return _swaEmployee;
   }
   public void setSwaEmployee(String swaEmployee) {
      _swaEmployee = swaEmployee;
   }
   public String getEmployeeId() {
      return _employeeId;
   }
   public void setEmployeeId(String employeeId) {
      _employeeId = employeeId;
   }
}
