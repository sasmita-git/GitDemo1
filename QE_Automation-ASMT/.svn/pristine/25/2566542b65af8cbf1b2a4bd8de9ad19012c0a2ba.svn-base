package com.automation.asmt.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	private static boolean flag = false;
	private static String result = null;
	
	/**
	 * Method is used to return a Calendar based on value as String and delimiter
	 * 
	 * Input : mm/dd/yyyy
	 * Output : Calendar Object. 
	 * 
	 * @param dateAsString
	 * @param delimiter
	 * @return
	 * @throws Exception
	 */
	public static Calendar getCalendarFromString(String dateAsString, String delimiter) throws Exception {
		
		logger.info("getCalendarFromString Start");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 00);
		cal.set(Calendar.DAY_OF_MONTH, 00);
		cal.set(Calendar.YEAR, 00);
		
		if(StringUtils.isNotBlank(dateAsString)) {
			String[] maxTime = dateAsString.split(delimiter);
			if(maxTime.length > 0) {
				cal.set(Calendar.MONTH, Integer.parseInt(maxTime[0]) - 1);
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(maxTime[1]));
				cal.set(Calendar.YEAR, Integer.parseInt(maxTime[2]));
			}
		}
		logger.info("getCalendarFromString End");
		return cal;
	}
	
	/**
	 * Method is used to return a Calendar based on value as String and delimiter
	 * 
	 * HH:MM:SS
	 * 
	 * @param dateAsString
	 * @param delimiter
	 * @return
	 * @throws Exception
	 */
	public static Calendar getCalendarWithTimeFromString(String dateAsString, String delimiter) throws Exception {
		
		logger.info("getCalendarWithTimeFromString Start");
		logger.info("getCalendarWithTimeFromString Start dateAsString --> " + dateAsString);
		logger.info("getCalendarWithTimeFromString Start delimiter --> " + delimiter);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		
		if(StringUtils.isNotBlank(dateAsString)) {
			String[] maxTime = dateAsString.split(delimiter);
			if(maxTime.length > 0) {
				cal.set(Calendar.HOUR, Integer.parseInt(maxTime[0]));
				cal.set(Calendar.MINUTE, Integer.parseInt(maxTime[1]));
				cal.set(Calendar.SECOND, Integer.parseInt(maxTime[2]));
			}
		}
		logger.info("getCalendarWithTimeFromString End");
		return cal;
	}
	
	/**
	 * Method is used to verify List is sorted in Ascending or not.
	 * In list 
	 * 
	 * 05/27/2016
	 * 05/26/2016
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isDateSortedInAscendingOrder	(List<Calendar> list)
	{
		logger.info("isDateSortedInAscendingOrder Start");
	    if(list == null || list.isEmpty())
	        return false;

	    if(list.size() == 1)  
	        return true;

	    for(int i=1; i<list.size();i++)
	    {
	    	Calendar currentValue = list.get(i);
	    	Calendar previousValue = list.get(i-1);
	    	
	        if(currentValue.compareTo(previousValue) > 0 ) {
	        	System.out.println("currentDateValue -->  " + currentValue);
	        	System.out.println("previousDateValue -->  " + previousValue);
	            return false;
	        }
	    }
	    logger.info("isDateSortedInAscendingOrder False");
	    return true;    
	}
	
	/**
	 * Method is used to verify List is sorted in Ascending or not.
	 * 
	 * Attempt1
	 * Attempt2
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isListSortedInAscendingOrder	(List<String> list)
	{
		logger.info("isListSortedInAscendingOrder Start");
	    if(list == null || list.isEmpty())
	        return false;

	    if(list.size() == 1)  
	        return true;

	    for(int i=1; i<list.size();i++)
	    {
	    	String currentValue = list.get(i).toLowerCase();
	    	String previousValue = list.get(i-1).toLowerCase();
	    	
	        if(currentValue.compareTo(previousValue) < 0 ) {
	        	System.out.println("currentValue -->  " + currentValue);
	        	System.out.println("previousValue -->  " + previousValue);
	            return true;
	        }
	    }
	    logger.info("isListSortedInAscendingOrder End");
	    return false;    
	}
	
	/**
	 * Method is used to check whether score has single value after decimal. 
	 * 
	 * 10.1
	 * 
	 * To check whether it has single value after decimal. 
	 * .1
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean checkSingleDigitAfterDeciaml(String input) throws Exception {
		 //logger.info("isListSortedInAscendingOrder Start");
		 flag = false;
		 String number = null;
		 if(org.apache.commons.lang3.StringUtils.isNotEmpty(input)) {
			 number = input.substring(input.indexOf(".")).substring(1);
		 }
		 if(number.length() == 1) {
			 flag = true;
		 }
		 logger.info("isListSortedInAscendingOrder End");
		 return flag;
	}
	
	public static String removeCharacters(String value, String oldChar, String newChar) throws Exception {
		logger.info("Method: removeCharacters Starts");
    	try {
    		result = null;
    		if(StringUtils.isNotBlank(value)) {
    			if(value.contains(oldChar)) {
    				result = value.replace(oldChar, newChar);
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to remove Characters");
    		throw new Exception("Unable to remove Characters" , e); 
    	}
    	logger.info("Method: removeCharacters End result --> " + result);
    	return result;
	}
	
	public static boolean compareCalendar(Calendar beforeDate, Calendar afterDate) throws Exception {
		logger.info("Method: compareCalendar Starts");
    	try {
    		flag = false;
    		if(beforeDate != null && afterDate != null) {
    			if(beforeDate.after(afterDate) || beforeDate.equals(afterDate)) {
    				flag = true;
    			} 
    		}
    	} catch (Exception e) {
    		logger.info("Unable to compare Calendar");
    		throw new Exception("Unable to compare Calendar" , e); 
    	}
    	logger.info("Method: compareCalendar End flag --> " + flag);
    	return flag;
	}
	
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

	/**
	 * Method used to get manual screen shot and add two random number.
	 * 
	 * @return
	 * @throws Exception
	 */
	public void takeScreenShotNow(WebDriver driverForSS, String nameForSS) {
		logger.info("takeScreenShotNow Start ");
		try {
			// Delete folder and recreate again --START
			/*File f = new File("target/proctorSS/");
			if(f.exists())
			{
            FileUtils.cleanDirectory(f);
            FileUtils.forceDelete(f);
			}
            // Delete folder and recreate again --END
*/            
			File scrFile = ((TakesScreenshot) driverForSS).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("target/proctorSS/" + nameForSS + ".png"));
		} catch (IOException e) {
			logger.info("Unable to takeScreenShotNow" + e);
		}

		logger.info("takeScreenShotNow End");

	}
	
	
}
