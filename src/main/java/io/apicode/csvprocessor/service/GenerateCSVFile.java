package io.apicode.csvprocessor.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class GenerateCSVFile {

	public void generateCSV(String fileName, List<String[]> dataList) {

		File file = new File(fileName);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			for (String[] data : dataList) {
				// add data to csv
				writer.writeNext(data);
			}

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
