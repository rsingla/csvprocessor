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

	public List<String[]> parseNReadCSV(String fileName) throws FileNotFoundException, IOException, CsvException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			List<String[]> dataList = reader.readAll();
			return updatedData(dataList);

		}
	}

	public List<String[]> updatedData(List<String[]> dataList) {
		// Print the current data
		dataList.forEach(x -> System.out.println(Arrays.toString(x)));

		// Crunching the existing data
		List<String[]> updatedList = crunchData(dataList);
		updatedList.forEach(x -> System.out.println(Arrays.toString(x)));

		return updatedList;
	}

	/**
	 * Remove the row which has greater than or equal to 7 columns as zero
	 * 
	 * @param dataList
	 */
	public List<String[]> crunchData(List<String[]> dataList) {

		List<String[]> updatedCSV = Lists.newArrayList();

		for (String[] row : dataList) {
			//Code to check only for 7th Column - Row[6] Points to 7th Column 
			if (!row[6].equalsIgnoreCase("0")) {
				updatedCSV.add(row);
			}
		}

		return updatedCSV;

	}

}
