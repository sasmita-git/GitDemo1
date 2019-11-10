package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest10 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private WindowHandler windowHandler;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		windowHandler = new WindowHandler(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.skm.new"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
//pulse user with my result page validation --new test case
	@TestAnnotations(testID = "NewATI-1118")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-1118:Validate student is able to take Tutorial Test")
	public void NewATI1118_ValidateStudentIsAbleTakeTutorialTest() throws Exception {
	log(logger, "NewATI1118_ValidateStudentIsAbleTakeTutorialTest Starts ");
	
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	homePage.clickTab(1);
	log(logger, "Clicking on My ATI Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	
	log(logger, "Selecting Tutorial from Learn Tab");
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Clicking Module by Name");
	tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.product.name"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "cliking on the pretest btutton of card back");
//	tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.stepto.success.section.name"));
	log(logger, "Clicking Begin Test ");
	tutorialPage.clickOnPostTestCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.railway.management.section.name"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Taking Assessment");
	tutorialPage.takeTest(false, false, true, false);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "verifying IPP page");
	boolean result=myReportPage.verifyIPPpageObjects();
	VerificationHandler.verifyTrue(result, "PIP page is not displayed");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "verifying close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "click on cardback close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	log(logger, "Clicking on Home Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(0);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	//verify recent activity
	log(logger, "Verifying Skill Modules test in Recent Activity");
	homePage.verifyAndClickRecentActivity(PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial","Skills Modules 2.0","COMPLETED SCORE");
	 log(logger, "Verify element after opening. ");
	
	log(logger, "NewATI1118_ValidateStudentIsAbleTakeTutorialTest End");
	
	}
}
