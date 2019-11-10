package com.automation.newati.helptab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.jaca.TestAnnotations;

public class VerifyHelpPageRegressionTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private HelpPage helpPage;
	
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		helpPage = new HelpPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-680")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-680:Veridy the Technical requirements verbiage should be updated to include Windows 10 as supported OS.")
	public void NewATI680_VerifyBrowserVersionInFAQSection() throws Exception {
		log(logger,"NewATI680_VerifyBrowserVersionInFAQSection Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		helpPage.verifyHeader("new-atitesting.homePage.faq.section.header.loc","new-atitesting.homePage.faq.section.header.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.homePage.qsn.section.header.loc"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler
		.verifyTrue(helpPage.verifyPCValueInTechReqInFAQSection(), "Unable to verify Window OS versions.");
		log(logger,"NewATI680_VerifyBrowserVersionInFAQSection End");
	}
	
	@TestAnnotations(testID="NewATI-48")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-48:Verify the availability of FAQs section.")
	public void NewATI48_VerifyFAQSection() throws Exception {
		log(logger,"NewATI48_VerifyFAQSection Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		helpPage.verifyHeader("new-atitesting.homePage.faq.section.header.loc","new-atitesting.homePage.faq.section.header.name");
		
		VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
		
		log(logger,"NewATI48_VerifyFAQSection End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-505:Verification for 'Getting Started with ATI' section under Help tab")
	public void NewATI505_VerifyGettingStartedSection() throws Exception {
		log(logger,"NewATI505_VerifyGettingStartedSection Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		helpPage.verifyHeader("new-atitesting.homePage.getting.started.section.header.loc","new-atitesting.homePage.getting.started.section.header.name");
		
		VerificationHandler.verifyTrue(helpPage.verifyElement(PropertiesRepository.getString("new-atitesting.homePage.getting.started.table.section.loc")), "Unable to verify Getting started with ATI Section");
		
		log(logger,"NewATI505_VerifyGettingStartedSection End");
	}
	
}
