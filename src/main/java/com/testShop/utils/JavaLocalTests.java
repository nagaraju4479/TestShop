package com.testShop.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaLocalTests {
	
	public static String getFutureMonthYear() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM YYYY");

	return date.format(formatter);
		
	}
	
	public static String getDate()
	{
		 String dateName = new SimpleDateFormat("yyyy/MMMM/dd-hh:mm:ss").format(new Date());
		 return dateName;
	}

	public static void main(String[] args) {
		System.out.println(getDate()); 

	}

}
