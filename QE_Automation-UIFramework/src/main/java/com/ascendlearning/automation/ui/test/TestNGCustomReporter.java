package com.ascendlearning.automation.ui.test;

import org.testng.Reporter;

public class TestNGCustomReporter extends Reporter{
	
	public static void customLog(String str){
		log("\n"+str);
		ExtentReport.log(getCurrentTestResult().getMethod().getDescription(), str); // Updated by Bharath on 2/24
	}
	
	
}
