package com.ascendlearning.automation.testlink;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.driver.DriverFactory;
import com.ascendlearning.automation.ui.logging.LogHandler;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestLinkAPIIntegration {
	private Logger logger = LogHandler.getLogger(DriverFactory.class);
	
	private static String DEV_KEY =PropertiesRepository.getString("global.testlink.api.devkey");//"9deadca4d58d2dba8679f90b490bc0cf";
	private static String SERVER_URL = PropertiesRepository.getString("global.testlink.api.serverurl");//"http://testlink.ascendlearning.com/testlink/lib/api/xmlrpc/v1/xmlrpc.php"; //your testlink server url
	public static String PROJECT_NAME = PropertiesRepository.getString("global.testlink.api.projectname");
	public static String TESTPLAN_NAME = PropertiesRepository.getString("global.testlink.api.planname");
	public static int BUILD_ID;
	public  static int TESTPLAN_ID;	
	public static  int TESTCASE_ID;
	public static String BUILD_NAME;
	public static String TESTCASE_PASSED=TestLinkAPIResults.TEST_PASSED;
	public static  String TESTCASE_FAILED=TestLinkAPIResults.TEST_FAILED;
	public static String TESTCASE_SKIPPED=TestLinkAPIResults.TEST_BLOCKED;
	public static boolean flag=false;
	TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,SERVER_URL);
	

	public int getTestPlanID() {
		try {
			TestLinkAPIResults apiResult = testlinkAPIClient.getBuildsForTestPlan(PROJECT_NAME, TESTPLAN_NAME);
			if (apiResult != null && apiResult.size() > 0) {
				String testPlanID = apiResult.getData(0).get("testplan_id").toString();
				if (StringUtils.isNotEmpty(testPlanID)) {
					TESTPLAN_ID = Integer.valueOf(testPlanID);
				}
			}
			flag=true;
		} catch (TestLinkAPIException e) {
			e.printStackTrace();

		}
		logger.info("TESTPLAN_ID:"+TESTPLAN_ID);
		return TESTPLAN_ID;
	}

	public int getTestcaseID(String testcaseName,String testsuiteName) {
		
		try {
			//TestLinkAPIResults apiResult = testlinkAPIClient.getTestCaseIDByName("Automated - Report Wizard> Longitudinal report: Verify that report gets generate");
			TestLinkAPIResults apiResult = testlinkAPIClient.getTestCaseIDByName(testcaseName, PROJECT_NAME, testsuiteName);
			if (apiResult != null && apiResult.size() > 0) {
				String testCaseID = apiResult.getData(0).get("id").toString();
				if (StringUtils.isNotEmpty(testCaseID)) {
					TESTCASE_ID = Integer.valueOf(testCaseID);
				}
			}
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		logger.info("TestcaseID:"+TESTCASE_ID);
		return TESTCASE_ID;
	}


	public int getBuildID() {
		try {
			Map<String, String> buildMap = new HashMap<String, String>();
			TestLinkAPIResults apiResult = testlinkAPIClient.getBuildsForTestPlan(TESTPLAN_ID);
			if(apiResult != null && apiResult.size() > 0) {
				int size = apiResult.size();
				for(int index = 0; index < size; index++) {
					buildMap = apiResult.getData(index);
					if(buildMap != null && buildMap.get("name").trim().equalsIgnoreCase(BUILD_NAME)) {
						BUILD_ID = Integer.valueOf(buildMap.get("id"));
						break;
					}
				}
			}
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		logger.info("BUILD_ID:"+BUILD_ID);
		return BUILD_ID;
	}

	public  String createBuild()  {
		
		BUILD_NAME=TESTPLAN_NAME+"_"+getCurrentDate();
		logger.info("BUILD NAME:"+BUILD_NAME);
		try {
			testlinkAPIClient.createBuild(PROJECT_NAME, TESTPLAN_NAME, BUILD_NAME, "Automation build");
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
		return BUILD_NAME;
	}


	public void updateTestLinkResult(String testCase, String exception, String result,String suiteName) {
		try {
			if(!flag) {
				createBuild();
				getTestPlanID();
				getBuildID();
			}
			testlinkAPIClient.reportTestCaseResult(TESTPLAN_ID, getTestcaseID(testCase, suiteName), BUILD_ID, null, result);
		} catch (TestLinkAPIException e) {
			e.printStackTrace();
		}
	}


	public static String getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy_HHmmss");
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}
}
