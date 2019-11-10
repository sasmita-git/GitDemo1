package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.FocusedReviewPage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;

public class VerifyFocusedReview extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private FocusedReviewPage focusedReviewPage;
	private HomePage homePage;
	private EditProfilePage editProfilePage;

	// private DataExtractPage dataExtractPage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		focusedReviewPage = new FocusedReviewPage(driver);
		quickReportPage = new QuickReportPage(driver);
		loginPage = new LoginPage(driver);
		editProfilePage = new EditProfilePage(driver);
	}

	// @TestAnnotations(testID = "inst-1886")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Varifying For focused review for assessment is preasent in list.")
	public void INST1886_VerifyFocusedReview() throws Exception {
		logger.info("INST1886_VerifyFocusedReview Start");

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

		log(logger, "click on focused review tab");
		quickReportPage.clickOnFocusedReviewTab();

		log(logger, "click on pagination no");
		focusedReviewPage.clickOnPagination(2);

		log(logger, "send focused review creator name");
		focusedReviewPage.sendCreatorName("hurd");

		log(logger, "Verify paginaton");
		VerificationHandler.verifyTrue(focusedReviewPage.verifyPagiantion());

		log(logger, "click on any assessment for focused review");
		focusedReviewPage.clickAssessmentForFocusedReview();

		logger.info("INST1886_VerifyFocusedReview End");
	}

}
