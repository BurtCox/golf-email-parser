package com.swacorp.ags.golf_email_parser;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Parent for all the RecordProcessors
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public abstract class EmailRecordProcessor {
   public abstract void process(KeyValue keyValue);
   public abstract void writeData(String outputPath) throws IOException;
   
   /*
    * Converts a date/time string in the format 'Tue, 14 Feb 2017 16:07:05 -0600' into a joda DateTime.
    */
   public DateTime fromString(String dateTimeString) {
      String[] dateParts = dateTimeString.split("\\s+");
      String day = dateParts[1];
      String month = dateParts[2];
      String year = dateParts[3];
      String time = dateParts[4];
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MMM-YYYY HH:mm:ss");
      formatter.parseDateTime(day + "-" + month + "-" + year + " " + time);
      DateTime dateTime = formatter.parseDateTime(day + "-" + month + "-" + year + " " + time);
      return dateTime;
   }
}
