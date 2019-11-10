package com.automation.asmt.listener;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.ascendlearning.automation.testlink.TestLinkAPIIntegration;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.driver.DriverFactory;
import com.ascendlearning.automation.ui.logging.LogHandler;

public class MyTestListenerAdapter extends TestListenerAdapter {
	private Logger logger = LogHandler.getLogger(DriverFactory.class);
	
	private String testDescription = "";
	private String testcase[];
	private String exception = null;
	private String updateTestLink = null;
	@Override
	public void onTestFailure(ITestResult result) {
		TestLinkAPIIntegration testlinkInt = new TestLinkAPIIntegration();
		
		// Getting value from Jenkins for Testlink - Start
		updateTestLink = System.getProperty("updateTestLink");
		logger.info("updateTestLink value ==> " + updateTestLink);
		// If not getting value from properties file
		if(StringUtils.isEmpty(updateTestLink)) {
			updateTestLink = PropertiesRepository.getString("global.testlink.execute");
		}
		// Getting value from Jenkins for Testlink - End
		
		//updateTestLink = PropertiesRepository.getString("global.testlink.execute");
		/*if (result.getMethod().getRetryAnalyzer() != null) {
			Reporter.setCurrentTestResult(result);
		}*/
		if(updateTestLink != null && updateTestLink.equalsIgnoreCase("true")) {
			testDescription = result.getMethod().getDescription();
			testcase = testDescription.split("::");
			testlinkInt.updateTestLinkResult(testcase[0], exception,
					testlinkInt.TESTCASE_FAILED, testcase[1]);
		}

	}

	@Override
	public void onFinish(ITestContext context) {
		Iterator<ITestResult> failedTestCases = context.getFailedTests()
				.getAllResults().iterator();
		while (failedTestCases.hasNext()) {
			ITestResult failedTestCase = failedTestCases.next();
			ITestNGMethod method = failedTestCase.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				logger.info("Failed TC removed as duplicate"
						+ failedTestCase.getTestClass().toString());
				failedTestCases.remove();
			} else {

				if (context.getPassedTests().getResults(method).size() > 0) {
					logger.info("Failed TC removed as Pass"
							+ failedTestCase.getTestClass().toString());
					failedTestCases.remove();
				}
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Getting value from Jenkins for Testlink - Start
		updateTestLink = System.getProperty("updateTestLink");
		logger.info("updateTestLink value ==> " + updateTestLink);
		// If not getting value from properties file
		if(StringUtils.isEmpty(updateTestLink)) {
			updateTestLink = PropertiesRepository.getString("global.testlink.execute");
		}
		// Getting value from Jenkins for Testlink - End
		if(updateTestLink != null && updateTestLink.equalsIgnoreCase("true")) {
			TestLinkAPIIntegration testlinkInt = new TestLinkAPIIntegration();
			testDescription = result.getMethod().getDescription();
			testcase = testDescription.split("::");
			testlinkInt.updateTestLinkResult(testcase[0], exception,
					testlinkInt.TESTCASE_SKIPPED, testcase[1]);
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Getting value from Jenkins for Testlink - Start
		updateTestLink = System.getProperty("updateTestLink");
		logger.info("updateTestLink value ==> " + updateTestLink);
		// If not getting value from properties file
		if(StringUtils.isEmpty(updateTestLink)) {
			updateTestLink = PropertiesRepository.getString("global.testlink.execute");
		}
		// Getting value from Jenkins for Testlink - End
		if(updateTestLink != null && updateTestLink.equalsIgnoreCase("true")) {
			TestLinkAPIIntegration testlinkInt = new TestLinkAPIIntegration();
			testDescription = result.getMethod().getDescription();
			testcase = testDescription.split("::");
			testlinkInt.updateTestLinkResult(testcase[0], exception,
					testlinkInt.TESTCASE_PASSED, testcase[1]);
		}

	}
}
