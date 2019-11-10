package com.automation.id.institution.cohort;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class InstitutionAndCohortTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
	}
			
	@TestAnnotations(testID="INST-1669")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify when 'Hide Graduated check/toggle' is OFF")
	public void INST1669_whenHideGraduatedcheckAndtogglisOFF() throws Exception {
		logger.info("INST1669_whenHideGraduatedcheckAndtogglisOFF Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		homePage.selectInstitutionLDropDown();
		log(logger, "Enter institution");
		
		boolean verifyHideGraduatedButton = loginPage.verifyHideGraduatedButton();
		VerificationHandler.verifyTrue(verifyHideGraduatedButton, "Button is not enable");
		
		logger.info("INST1669_whenHideGraduatedcheckAndtogglisOFF End");
	}
	
	@TestAnnotations(testID="INST-1668")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify when 'Hide Graduated check/toggle' is ON")
	public void INST1668_whenHideGraduatedcheckAndtogglisON() throws Exception {
		logger.info("INST1668_whenHideGraduatedcheckAndtogglisON Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		homePage.selectInstitutionLDropDown();
		log(logger, "Enter institution");
		
		log(logger,"Verify hide gradute is enabled");
		VerificationHandler.verifyTrue(loginPage.verifyHideGraduteButtonEnabled());
		
		boolean verifyHideGraduatedButton = loginPage.verifyHideGraduatedButton();
		VerificationHandler.verifyTrue(verifyHideGraduatedButton, "Button is not enable");
		
		logger.info("INST1668_whenHideGraduatedcheckAndtogglisON End");
	}
	
	@TestAnnotations(testID="INST-1703")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify that default institution is selected for Instructor/Director/Proctor")
	public void INST1703_verifyDefaultInstitute() throws Exception {
		logger.info("INST1703_verifyDefaultInstitute Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Enter institution");
		homePage.selectInstitutionLDropDown();
		
		log(logger, "verify institution name");
		//VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.homepage.home.page.institution.name",0));
		VerificationHandler.verifyTrue(homePage.verifyInstituteName("zzDevon Medical School"));
		
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on product tab");
		log(logger,"Verify that toster message is displaying if user is not selecting any class and navigating to other page ");
		VerificationHandler.verifyTrue(loginPage.verifySelectClassTosterMessage());
		
		logger.info("INST1703_verifyDefaultInstitute End");
	}
	
	@TestAnnotations(testID="INST-1667")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify 'Hide Graduated' check/toggle presented on top navigation menu")
	public void INST1667_verifyHideGraduatedOption() throws Exception {
		logger.info("INST1667_verifyHideGraduatedOption Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Enter institution");
		homePage.selectInstitutionLDropDown();
		
		log(logger,"verify that hide graduate is enabled ");
		VerificationHandler.verifyTrue(loginPage.verifyHideGraduteButtonEnabled());
		
		log(logger, "verify hidegraduated option");
		boolean verifyHideGraduatedButton = loginPage.verifyHideGraduatedButton();
		VerificationHandler.verifyTrue(verifyHideGraduatedButton, "Button is not enable");
		
		logger.info("INST1667_verifyHideGraduatedOption End");
	}
	
}


