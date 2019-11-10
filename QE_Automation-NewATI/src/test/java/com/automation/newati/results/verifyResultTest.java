package com.automation.newati.results;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class verifyResultTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-150")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-150: My Results verification Test Case::My Results")
	public void NewATI150_VerifyResultsPageValidation() throws Exception {
		
		log(logger, "NewATI150_VerifyResultsPageValidation Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.smart.prep.user.name"), PropertiesRepository.getString("newati.login.smart.prep.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My RESULTS Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result=myReportPage.verifyIPPPageSectionHeaders();
		VerificationHandler.verifyFalse(result);
		
//		log(logger, "verify download button");
//		boolean result1=tutorialPage.isElementDisplayed("new-atitesting.myresult.page.download.button.loc");
//		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Verify Print Report button");	
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-ati.report.download.loc"),"Download report is not displayed");
		log(logger, "verify logo image");
		boolean result2=tutorialPage.isElementDisplayed("new-atitesting.learntab.tutorial.logo");
		VerificationHandler.verifyTrue(result2);
		
		log(logger, "verify results header");
		boolean result3=tutorialPage.isElementDisplayed("new-atitesting.results.header.loc");
		VerificationHandler.verifyTrue(result3);
		
		boolean result4=tutorialPage.verifyIPPPageTable();
		VerificationHandler.verifyTrue(result4);
		
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.myresult.page.download.button.loc"));
		
		log(logger, "NewATI150_VerifyResultsPageValidation End");
	}
}
