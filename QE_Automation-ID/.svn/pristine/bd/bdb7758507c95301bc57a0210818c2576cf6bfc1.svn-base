package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;

public class VerifyIndividualReport extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private EditProfilePage editProfilePage;
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
		editProfilePage = new EditProfilePage(driver);
	}

	// @TestAnnotations(testID="inst-1848")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify that Faculty can build 'Individual Transcript Report' for one or more students.")
	public void INST1848_VerifyIndividualReport() throws Exception {
		logger.info("INST1848_VerifyIndividualReport Start");

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

		log(logger, "click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();

		log(logger, "click on build button for critical thinking report");
		reportWizardPage.clickOnIndividualReportbtn();

		log(logger, "select one or more student check box and continue");
		reportWizardPage.selectOneOrMoreStudentRadioBtnIndividual();

		log(logger, "select student from student table and click on continue btn");
		reportWizardPage.selectStudentFormTable();

		log(logger, "select a assessement from valid assessment table to select assessment table");
		reportWizardPage.selectAssessmentFromValidAssessmentTable();

		log(logger, "click on continue btn form configure the reports page");
		// reportWizardPage.clickOncontinueBtnFromConfigureReportPage();
		reportWizardPage.clickOnElementInFrame("reportwizrd.valid.assessment.ctn1");

		log(logger, "click on print individual reprot btn");
		// reportWizardPage.clickOnIndividualReportPrintBtn();
		reportWizardPage.clickOnElementInFrame("reportwizard.printindividual.btn");

		log(logger, "click on data extract btn");
		// reportWizardPage.clikOnIndividualReportdataExtract();
		reportWizardPage.clickOnElementInFrame("reportwizard.dataextract.option");

		log(logger, "click on csv and xml btn");
		reportWizardPage.clickCsvXmlBtn();

		logger.info("INST1848_VerifyIndividualReport End");
	}

}
