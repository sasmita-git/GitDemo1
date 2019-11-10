package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;
import com.jaca.TestAnnotations;

public class VerifyReportWizardCustomeGroupReport extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private EditProfilePage editProfilePage;
	private ReportWizardPage reportWizardPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void verifyHomePage() throws Exception {
		loginPage =new LoginPage(driver);
		homePage =new HomePage(driver);
		reportWizardPage=new ReportWizardPage(driver);
		quickReportPage=new QuickReportPage(driver);
		editProfilePage = new EditProfilePage(driver);
		loginPage = new LoginPage(driver);
	}
	

//	@TestAnnotations(testID = "inst-1680")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "Verify building 'Group Reports' for Students from an existing Custom Group")
	public void INST1680_VerifyReportWizardCustomeGroupReport() throws Exception {
		logger.info("INST1680_VerifyReportWizardCustomeGroupReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username.report"), PropertiesRepository.getString("id.login.faculty.password.report"));
		
		/*log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);
		*/
		
		log(logger,"Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger,"click on anlytics");
		homePage.clikOnLeftNavLink(4);
		
		log(logger,"click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();
		
		log(logger,"click on build button for group report");
		reportWizardPage.clikOnBuildBtnForGroupReport();
		
		log(logger,"Select the radio button 'a Custom Group of Students");
		reportWizardPage.selectCustomeGroupOfStudent();
		
		log(logger,"verify that create new group button is present");
		VerificationHandler.verifyTrue(reportWizardPage.verifyCreateNewGrpButton());
		
		log(logger,"Select one group from custome group list");
		reportWizardPage.clickOnCutomGroupRadioBtnFromTable();
		
		log(logger,"verify that proctor and prcatice assessment tab are displaying");
		reportWizardPage.verifygroupReportProctorPracticeTab();
		
		log(logger,"click on one assessment pool name");
		reportWizardPage.clickOnAssessmentPool();

		/*
		 * saravanan will see log(logger,"click on data extract btn");
		 * reportWizardPage.scrollUp();
		 */

		logger.info("INST1680_VerifyReportWizardCustomeGroupReport End");
	}
	
	
}
