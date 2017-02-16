package com.swacorp.ags.golf_email_parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.embassy.file.ExcludeFileSpecFileFilter;
import com.embassy.file.FileFilters;
import com.embassy.file.FileList;
import com.embassy.file.FileSet;

/**
 * @author Burt Cox (e41887)
 *
 * Description: Main controller. Defines the location to look for files, and
 *    creates the top-level record processor to handle all records from those files.
 * 
 * Create Date: Feb 15, 2017
 *
 * Copyright 2017 Southwest Airlines. All rights reserved.
 */
public class GolfEmailParser {
	private static final String _inputPath = "U:/tlc/2017/golf tournament/registrations";
	private static final String _outputPath = _inputPath;
   private Logger _logger = LoggerFactory.getLogger(getClass().getSimpleName());
   private GolfEmailRecordProcessor _golfEmailRecordProcessor = new GolfEmailRecordProcessor(); 

	public GolfEmailParser(String[] args) throws IOException {
		Path inputPath = Paths.get(_inputPath);
		ExcludeFileSpecFileFilter excludeFileSpecFileFilter = new ExcludeFileSpecFileFilter(".csv");
		FileFilters fileFilters = new FileFilters();
		fileFilters.add(excludeFileSpecFileFilter);
		List<File> files = FileList.getFiles(inputPath, true);
		_logger.info("Source contains {} files", files.size());
		FileSet fileSet = new FileSet(files, _golfEmailRecordProcessor);
		fileSet.processFileSet();
		_golfEmailRecordProcessor.writeData(_outputPath);
	}
}
