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
import com.automation.id.pages.ReportWizardPage;

public class VerifyCriticalThinkingAnalysisReport extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private ReportWizardPage reportWizardPage;
	// private DataExtractPage dataExtractPage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		reportWizardPage = new ReportWizardPage(driver);
		// dataExtractPage=new DataExtractPage(driver);
		quickReportPage = new QuickReportPage(driver);
		loginPage = new LoginPage(driver);
	}

	// @TestAnnotations(testID="inst-1846")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify that Faculty can build 'Critical Thinking Analysis Report' for one or more students.")
	public void INST1846_VerifyCriticalThinkingAnalysisReport() throws Exception {
		logger.info("INST1846_VerifyCriticalThinkingAnalysisReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username.report"),
				PropertiesRepository.getString("id.login.faculty.password.report"));

		log(logger, "select one class");
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming.reprot"));

		log(logger, "Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "click on anlytics");
		homePage.clikOnLeftNavLink(4);

		log(logger, "click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();

		log(logger, "click on build button for critical thinking report");
		reportWizardPage.clikOnBuildBtnForCriticalThinkingReport();

		log(logger, "select one or more student check box and continue");
		reportWizardPage.selectOneOrMoreStudentRadioBtn();

		log(logger, "select student from student table and click on continue btn");
		reportWizardPage.selectStudentFormTable();

		log(logger, "click on as a group print btn");
		reportWizardPage.clickAsGroupPrintBtn();

		log(logger, "click on data extact option");
		reportWizardPage.clickOnDataExtractBtnFroCritical();

		log(logger, "click on csv and xml btn");
		reportWizardPage.clickCsvXmlBtn();

		logger.info("INST1846_VerifyCriticalThinkingAnalysisReport End");
	}

}
