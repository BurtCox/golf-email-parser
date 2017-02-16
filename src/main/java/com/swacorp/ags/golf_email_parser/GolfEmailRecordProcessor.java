package com.swacorp.ags.golf_email_parser;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.embassy.file.RecordProcessor;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Top-level record processor. Receives all file records, and determines the
 *    lower-level record processor to handle that record. 
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class GolfEmailRecordProcessor extends RecordProcessor {
   private KeyValueParser _keyValueParser = new KeyValueParser();
   private Logger _logger = LoggerFactory.getLogger(getClass().getSimpleName());
   
   @Override
   public void process(File file, int recordNumber, String record) {
      KeyValue keyValue = _keyValueParser.parse(record);
      EmailRecordProcessor emailRecordProcessor = EmailType.getProcessorForFile(file);
      
      if (emailRecordProcessor != null) { // we may find some files that don't have a processor
         emailRecordProcessor.process(keyValue);         
      }
   }
   
   public void writeData(String outputPath) throws IOException {
      for (EmailRecordProcessor emailRecordProcessor : EmailType.getRecordProcessors()) {
         emailRecordProcessor.writeData(outputPath);
      }
   }
}
