package io.apicode.csvprocessor.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ProcessFile {

	public void parseNReadCSV(String fileName) throws FileNotFoundException, IOException, CsvException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			List<String[]> dataList = reader.readAll();
			updatedData(dataList);
			
		}
	}
	
	public void updatedData(List<String[]> dataList) {
		//Print the current data
		dataList.forEach(x -> System.out.println(Arrays.toString(x)));
		
		// Crunching the existing data
		List<String[]> updatedList = crunchData(dataList);
		updatedList.forEach(x -> System.out.println(Arrays.toString(x)));
	}

	/**
	 * Remove the row which has greater than or equal to 7 columns as zero
	 * 
	 * @param dataList
	 */
	public List<String[]> crunchData(List<String[]> dataList) {

		List<String[]> updatedCSV = Lists.newArrayList();

		for(String[] row: dataList) {
			int count = 0;
			for(String col: row) {
				if(col.equalsIgnoreCase("0")) {
					count++;
				}
			}
			if(count < 7) {
				updatedCSV.add(row);
			}
		}
		
		return updatedCSV;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {

		String fileName = "to_91762_ID_NJHPS_ADJUST_20210416.csv";

		ProcessFile processFile = new ProcessFile();
		processFile.parseNReadCSV(fileName);
	}

}
