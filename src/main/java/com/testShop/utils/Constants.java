package com.testShop.utils;

import java.time.Duration;
import java.time.LocalDate;

public class Constants {
	
	final public static Duration waitTime = Duration.ofSeconds(60);
	final public static Duration minWaitTime = Duration.ofSeconds(5);
	final public static Duration  maxWaitTime = Duration.ofSeconds(60);
	public static String SEARCHTEXT = "Java";
	final public static int END_DATE = LocalDate.now().plusDays(14).getDayOfMonth();
	final static int ONE_WEEK= 7;
	final static int TWO_WEEKS= 14;
	
	


}
