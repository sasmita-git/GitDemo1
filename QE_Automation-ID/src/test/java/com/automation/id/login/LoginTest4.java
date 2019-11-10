package com.automation.id.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class LoginTest4 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
	}
	
	//@TestAnnotations(testID="INST-1718")
	//@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Regression"}, description = "inst-1718:Verify block/unblock UI happens for forgot username/password")
	public void INST1718_VerifyPasswordResetModalWindow() throws Exception {
		log(logger, "INST1718_VerifyPasswordResetModalWindow Start");
		logger.info("INST1718_VerifyPasswordResetModalWindow Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);
		
		log(logger, "Verifying User name locator is enabled or not");
		VerificationHandler.verifyTrue(loginPage.verifyElementIsEnabled(PropertiesRepository.getString("id.login.username.loc")), 
				"Unable to select User name");
		
		log(logger, "Clicking on Password button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), true), "Unable to Clicking on Password button");
		
		log(logger, "Verifying User name locator is enabled or not");
		VerificationHandler.verifyTrue(loginPage.verifyElementIsEnabled(PropertiesRepository.getString("id.login.username.loc")),
				"Unable to select User name");
		
		log(logger, "INST1718_VerifyPasswordResetModalWindow End");
		logger.info("INST1718_VerifyPasswordResetModalWindow End");
		
	}
		
	@TestAnnotations(testID="INST-1967")
	@Test(priority = 2, alwaysRun =true, enabled = true, groups={"Regression"}, description = " inst-1967:Verifying Update TechnicalRequirements from login page")
	public void INST1967_VerifyTechnicalRequirements() throws Exception {
		logger.info("INST1967_VerifyTechnicalRequirements Start");
		log(logger,"INST1967_VerifyTechnicalRequirements Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Clicking on Technical Requirements");
		VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.page.technical.requirement.link.loc"), true), "Unable to click on Technical Requirements");
		
		log(logger, "Verifying Chrome browser Download link in Technical Requirement Popup");
		VerificationHandler.verifyTrue(loginPage.verifyTechnicalRequirementDownloadLink("Chrome"), "Unable to verify Chrome browser Download link in Technical Requirement Popup");
		
		log(logger, "Verifying Mozilla Firefox browser Download link in Technical Requirement Popup");
		VerificationHandler.verifyTrue(loginPage.verifyTechnicalRequirementDownloadLink("Mozilla"), "Unable to verify Mozilla Firefox browser Download link in Technical Requirement Popup");
		
		log(logger, "Verifying Safari browser Download link in Technical Requirement Popup");
		VerificationHandler.verifyTrue(loginPage.verifyTechnicalRequirementDownloadLink("Safari"), "Unable to verify Safari browser Download link in Technical Requirement Popup");
		
		logger.info("INST1967_VerifyTechnicalRequirements End");
		log(logger, "INST1967_VerifyTechnicalRequirements End");
	}
	
}
