package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.DataExtractPage;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;

public class VerifyAssessmentResultOfDataExtract extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private DataExtractPage dataExtractPage;
	private EditProfilePage editProfilePage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dataExtractPage = new DataExtractPage(driver);
		quickReportPage = new QuickReportPage(driver);
		editProfilePage = new EditProfilePage(driver);
		loginPage = new LoginPage(driver);
	}

	// @TestAnnotations(testID="inst-1673")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify individual reports are generated")
	public void INST1673_VerifyAssessmentResultOfDataExtract() throws Exception {
		logger.info("INST1673_VerifyAssessmentResultOfDataExtract Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username.report"),
				PropertiesRepository.getString("id.login.faculty.password.report"));

		/*
		 * log(logger, "click on close button");
		 * editProfilePage.clickButtonFromList(
		 * "id.homepage.home.page.alert.close", 0);
		 */
		log(logger, "select one class");
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming.reprot"));

		log(logger, "Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "click on anlytics");
		homePage.clikOnLeftNavLink(4);

		log(logger, "click on data extract tab");
		quickReportPage.clicOnDataExtractTab();

		log(logger, "select student from custome result");
		dataExtractPage.selectStudentFromStudentList();

		log(logger, "click on a assessment from valid assessment table");
		dataExtractPage.clikOnValidAssessment();

		log(logger, "clik on generate extract btn");
		dataExtractPage.clickOnGenerateExtractBtn();

		log(logger, "Verify that results are displaying");
		VerificationHandler.verifyTrue(dataExtractPage.verifyUserData("4016722"));

		logger.info("INST1673_VerifyAssessmentResultOfDataExtract End");
	}

}
