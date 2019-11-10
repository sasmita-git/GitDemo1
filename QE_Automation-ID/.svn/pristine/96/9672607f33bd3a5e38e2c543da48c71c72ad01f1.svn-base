package com.automation.id.home;

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

public class AlertsTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@TestAnnotations(testID="INST-1646")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups = {"smoke","Regression"}, description = "INST-1646:Verify content of fall down list pop-up for alert/news article")
	public void INST1646_VerifyNewsAndAlertList() throws Exception {
		logger.info("INST1646_VerifyNewsAndAlertList Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.faculty.home.alert.username"), PropertiesRepository.getString("id.faculty.home.alert.pwd"));
		
		log(logger,"verify alert toast message screen");
		boolean alertFlag = homePage.verifyAlertToastMessageDisplayed("id.home.page.alert.screen.loc");
		log(logger, "Status of Alert Displayed or not " + alertFlag);
		
		log(logger,"verify alert red bell icon");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.page.alert.bell.icon.loc")),"red bell icon not displayed");
		
		log(logger,"click alert icon bell");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.alert.bell.icon.loc"), true);
		
		log(logger,"verify News button displayed");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.page.alert.newssection.loc")),"News header not displayed");
		
		log(logger,"verify alert button displayed");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.page.alert.alertsection.loc")),"alert header not displayed");
		
		log(logger,"verify list of news displayed");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.page.alert.newssection.list.loc")),"list of news not dipalyed");
		
		log(logger,"click on alert button");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.alert.alertsection.loc"), true);
		
		log(logger,"verify list of alerts displayed");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.page.alert.alertsection.list.loc")),"list of alerts not dipalyed");
		
		log(logger,"click alert from list of alerts and compare text of clicked and received");
		VerificationHandler.verifyTrue(homePage.clickAndVerifyTextFromList("id.home.page.alert.alertsection.list.loc","id.home.page.alert.text2.loc",0),"unable to click and verify alert from list of alerts");
		
		logger.info("INST1646_VerifyNewsAndAlertList End");
	}
}