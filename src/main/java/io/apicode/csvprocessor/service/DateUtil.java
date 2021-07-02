package io.apicode.csvprocessor.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String currentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ssz");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}

	
}
