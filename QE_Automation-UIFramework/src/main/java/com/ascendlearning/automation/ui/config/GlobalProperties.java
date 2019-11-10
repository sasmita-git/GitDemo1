package com.ascendlearning.automation.ui.config;

public final class GlobalProperties {
	
	//Browser Constants	
	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String IE = "internet explorer";
	public static final String EDGE = "edge";
	public static final String SAFARI = "safari";
	public static final String ANDROID = "android";
	
	//Default wait - 10s
	public static final int EXPLICIT_WAIT = PropertiesRepository.getInt("global.driver.wait");
	
	//Default Properties Files
	public static final String PROPS_LIST = "prop-files.properties";
	public static final String GLOBAL_PROPS = "global.properties";
	public static final String LOG_PROPS = "log4j.properties";
	public static final String PROPS_LIST_QA = "qa_prop-files.properties";
	public static final String PROPS_LIST_STG = "stg_prop-files.properties";
	public static final String PROPS_LIST_PROD = "prod_prop-files.properties";
	
	// Selector Types
	public static final String CSS_SELECTOR = "CSS";
	public static final String SIZZLE_SELECTOR = "SIZZLE";
	
	// Environment Constants
	public static final String STAGE = "stage";
	public static final String STG = "stg";
	public static final String QA = "qa";
	public static final String PROD = "prod";
	public static final String PRODUCTION = "production";

}
