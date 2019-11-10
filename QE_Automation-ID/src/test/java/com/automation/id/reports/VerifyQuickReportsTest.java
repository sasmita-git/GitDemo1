package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;

public class VerifyQuickReportsTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		quickReportPage = new QuickReportPage(driver);

		loginPage = new LoginPage(driver);
	}

	// @TestAnnotations(testID="inst-1612")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify individual reports are generated")
	public void INST1612_VerifyIndividualAssessmentReport() throws Exception {
		logger.info("INST1612_VerifyIndividualAssessmentReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username.report"),
				PropertiesRepository.getString("id.login.faculty.password.report"));

		log(logger, "Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "click on anlytics");
		homePage.clikOnLeftNavLink(4);

		log(logger, "enter assessment id in individual text field of quick report");
		quickReportPage.generateResultQuickReportIndividualReport("8882500");

		logger.info("INST1612_VerifyIndividualAssessmentReport End");
	}
}
