package com.automation.newati.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CommonUtils {
	
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	private static String result = null;
	/**
	 * Method used to get current date with specified pattern. 
	 * 
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDate(String pattern) throws Exception {
		logger.info("Method: getCurrentDate Starts");
		result = null;
    	try {
    		Date currDate = new Date();
    		SimpleDateFormat format = new SimpleDateFormat(pattern);
    		result = format.format(currDate);
    		
    	} catch (Exception e) {
    		logger.info("Unable to get Current Date");
    		throw new Exception("Unable to get Current Date" , e); 
    	}
    	logger.info("Method: getCurrentDate End result --> " + result);
    	return result;
	}
	
	/**
	 * Method used to get Random Password, it will append today's date
	 * and add two random number. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getRandomPassword() throws Exception {
		logger.info("getRandomPassword Start");
		result = null;
		Random randomGenerator = new Random();
		try {
			result = "A"+getCurrentDate("MMddyy") + randomGenerator.nextInt(100);
		} catch (Exception e) {
			logger.info("Unable to get Random Password");
		}
		
		logger.info("getRandomPassword End");
		return result;
	}
	
	/**
	 * Method used to get Random Password, it will append today's date
	 * and add two random number. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getRandomUserName() throws Exception {
		logger.info("getRandomUserName Start");
		result = null;
		Random randomGenerator = new Random();
		try {
			result = "User"+getCurrentDate("MMddyy") + randomGenerator.nextInt(1000);
		} catch (Exception e) {
			logger.info("Unable to get Random UserName");
		}
		
		logger.info("getRandomUserName End");
		return result;
	}
	
	public static Map<Integer, Integer> readingPreTest() throws Exception {
		logger.info("readingPreTest start");
		Map<Integer, Integer> readingPreTestValue = new HashMap<Integer, Integer>();
		try {
			readingPreTestValue.put(1, 1);
			readingPreTestValue.put(2, 1);
			readingPreTestValue.put(3, 1);
			readingPreTestValue.put(4, 3);
			readingPreTestValue.put(5, 1);
			readingPreTestValue.put(6, 0);
			readingPreTestValue.put(7, 1);
			readingPreTestValue.put(8, 0);
			readingPreTestValue.put(9, 0);
			readingPreTestValue.put(10, 0);
			
			readingPreTestValue.put(11, 3);
			readingPreTestValue.put(12, 3);
			readingPreTestValue.put(13, 2);
			readingPreTestValue.put(14, 2);
			readingPreTestValue.put(15, 1);
			readingPreTestValue.put(16, 2);
			readingPreTestValue.put(17, 1);
			readingPreTestValue.put(18, 2);
			readingPreTestValue.put(19, 1);
			readingPreTestValue.put(20, 3);
			readingPreTestValue.put(21, 1);
			readingPreTestValue.put(22, 0);
			readingPreTestValue.put(23, 3);
			readingPreTestValue.put(24, 0);
			readingPreTestValue.put(25, 0);
			readingPreTestValue.put(26, 0);
			
			readingPreTestValue.put(27, 1);
			readingPreTestValue.put(28, 3);
			readingPreTestValue.put(29, 1);
			readingPreTestValue.put(30, 3);
			readingPreTestValue.put(31, 2);
			readingPreTestValue.put(32, 3);
			readingPreTestValue.put(33, 3);
			readingPreTestValue.put(34, 1);
			readingPreTestValue.put(35, 2);
			readingPreTestValue.put(36, 0);
			readingPreTestValue.put(37, 1);
			readingPreTestValue.put(38, 1);
			readingPreTestValue.put(39, 3);
			readingPreTestValue.put(40, 2);
			readingPreTestValue.put(41, 2);
			readingPreTestValue.put(42, 0);
			readingPreTestValue.put(43, 2);
			readingPreTestValue.put(44, 3);
			readingPreTestValue.put(45, 0);
			readingPreTestValue.put(46, 3);
			readingPreTestValue.put(47, 2);
						
		} catch(Exception e) {
			throw new Exception("Unabel to create reading Pre Test value", e);
		}
		logger.info("");
		return readingPreTestValue;
	}
	
	public static Map<Integer, Integer> readingPostTest() throws Exception {
		logger.info("readingPostTest start");
		Map<Integer, Integer> readingPreTestValue = new HashMap<Integer, Integer>();
		try {
			readingPreTestValue.put(1, 1);
			readingPreTestValue.put(2, 3);
			readingPreTestValue.put(3, 0);
			readingPreTestValue.put(4, 3);
			readingPreTestValue.put(5, 3);
			readingPreTestValue.put(6, 0);
			readingPreTestValue.put(7, 3);
			readingPreTestValue.put(8, 0);
			readingPreTestValue.put(9, 2);
			readingPreTestValue.put(10, 1);
			
			readingPreTestValue.put(11, 2);
			readingPreTestValue.put(12, 1);
			readingPreTestValue.put(13, 3);
			readingPreTestValue.put(14, 3);
			readingPreTestValue.put(15, 1);
			readingPreTestValue.put(16, 0);
			readingPreTestValue.put(17, 3);
			readingPreTestValue.put(18, 1);
			readingPreTestValue.put(19, 0);
			readingPreTestValue.put(20, 3);
			readingPreTestValue.put(21, 0);
			readingPreTestValue.put(22, 1);
			readingPreTestValue.put(23, 0);
			readingPreTestValue.put(24, 2);
			readingPreTestValue.put(25, 1);
			readingPreTestValue.put(26, 1);
			
			readingPreTestValue.put(27, 1);
			readingPreTestValue.put(28, 3);
			readingPreTestValue.put(29, 0);
			readingPreTestValue.put(30, 1);
			readingPreTestValue.put(31, 2);
			readingPreTestValue.put(32, 1);
			readingPreTestValue.put(33, 0);
			readingPreTestValue.put(34, 3);
			readingPreTestValue.put(35, 0);
			readingPreTestValue.put(36, 2);
			readingPreTestValue.put(37, 0);
			readingPreTestValue.put(38, 2);
			readingPreTestValue.put(39, 0);
			readingPreTestValue.put(40, 3);
			readingPreTestValue.put(41, 3);
			readingPreTestValue.put(42, 1);
			readingPreTestValue.put(43, 2);
			readingPreTestValue.put(44, 2);
			readingPreTestValue.put(45, 3);
			readingPreTestValue.put(46, 1);
			readingPreTestValue.put(47, 3);
						
		} catch(Exception e) {
			throw new Exception("Unabel to create reading Pre Test value", e);
		}
		logger.info("");
		return readingPreTestValue;
	}
}
