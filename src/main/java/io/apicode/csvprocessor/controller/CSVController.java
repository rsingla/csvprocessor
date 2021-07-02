package io.apicode.csvprocessor.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import io.apicode.csvprocessor.service.DateUtil;
import io.apicode.csvprocessor.service.GenerateCSVFile;
import io.apicode.csvprocessor.service.ProcessFile;

public class CSVController {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {

		String fileName = "to_91762_ID_NJHPS_ADJUST_20210416.csv";

		ProcessFile processFile = new ProcessFile();
		List<String[]> updatedData = processFile.parseNReadCSV(fileName);

		String updatedFileName = DateUtil.currentDate() + "_updated_" + fileName;

		GenerateCSVFile generateCSVFile = new GenerateCSVFile();
		
		generateCSVFile.generateCSV(updatedFileName, updatedData);

	}

}
