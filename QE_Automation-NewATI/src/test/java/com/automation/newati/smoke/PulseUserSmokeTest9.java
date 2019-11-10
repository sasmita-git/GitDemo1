package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest9 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private MyATITabMainPage myATITabMainPage;
	private HelpPage helpPage;
	private MyResultsTabPage myResultsTabPage;
	public BaseHandler baseHandler;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage=new MyATITabMainPage(driver);
		helpPage=new HelpPage(driver);
		myResultsTabPage=new MyResultsTabPage(driver);
		baseHandler = new BaseHandler(driver);
	}
//pulse user with my result page validation --new test case
	@TestAnnotations(testID="NewATI-1116")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-1116:Verify result functionality for exiting Pulse user.")
	
	public void NewATI1116_VerifyResultFunctionalityForExitingPulseUser() throws Exception {
	log(logger, "NewATI1116_VerifyResultFunctionalityForExitingPulseUser Starts ");
	log(logger, "login to application with existing user ");
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
	
	
//	downloadFilepath = PropertiesRepository.getString("global.download.location");
//	homePage.createDirectory("C:\\download");
//	homePage.createDirectory(downloadFilepath);
//	
	log(logger, "Clicking on MyResults Tab");
	homePage.clickTab(2);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.results.heading")), "Unable to verify My Results Tab ");
	log(logger, "Verify My result page");
	VerificationHandler.verifyTrue(myResultsTabPage.verifyResultSection(), "Unable to verify My Results Tab ");
	log(logger, "Verify Print Report button");	
	VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-ati.report.download.loc"),"Download report is not displayed");
//	homePage.deleteFileExists(downloadFilepath);
//	homePage.clickButton(".default-button.focus-element-flag");
//	log(logger, "Verifying file after download");
//	VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
	homePage.clickTab(3);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger,"verify help tab FAQ headers");
//	sVerificationHandler.verifyTrue(helpPage.verifyFAQSectionHeaders());
	log(logger,"verify  help tab FAQ Links");
	VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
	homePage.scrollUpPage();
	homePage.SignOut();
	log(logger, "Verify Login page ");
	VerificationHandler.verifyTrue(homePage.verifyLogo("new-atitesting.learntab.tutorial.logo"));
	
	log(logger, "NewATI1116_VerifyResultFunctionalityForExitingPulseUser End");
	
	}
}
