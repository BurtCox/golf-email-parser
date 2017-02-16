package com.swacorp.ags.golf_email_parser;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Splits a record into a key/value pair
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class KeyValueParser {

	public KeyValue parse(String record) {
	   String[] values = record.split(":", 2);
	   String key = null;
	   String value = null;
	   
	   if (values.length > 0) {
	      key = values[0].trim();
	   }
	   
	   if (values.length > 1) {
	      value = values[1].trim();
	   }
		
	   return new KeyValue(key, value);
	}

}
