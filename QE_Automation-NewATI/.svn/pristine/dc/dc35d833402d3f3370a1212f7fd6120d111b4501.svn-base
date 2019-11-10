package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyTutorialTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	
	String downloadFilepath = null;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}


	
	@TestAnnotations(testID="NewATI-826")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-826:Verification for launching STT 2017 from Recent Activity")
	public void NewATI826_STTTestRecentActivity() throws Exception {
		logger.info("NewATI826_STTTestRecentActivity Start");
		
		//Step-1
		loginPage.loginToApplication("stagesingleinstance","Test123");
		
		//Step-2 & Step-3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step-4
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify Modules count and header section in card back");
		VerificationHandler.verifyTrue(tutorialPage.verifyCardBackHeaderSection(PropertiesRepository.getString("newati.card.back.title.loc"),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")), "unable to verify card back header section");
		
		log(logger, "Clicking Begin Test ");
		tutorialPage.clickBeginTestButtonInNurseLogicCardBackNew(
				"Using Evidence to Guide Decision Making and Management Practices 2017");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		tutorialPage.clickTutorialTestCloseButton();
		log(logger, "Clicked on Close button in Quiz Bank");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
        loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.popup.close"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Clicking on Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Verifying STT 2017 test in Recent Activity");
		homePage.verifyAndClickRecentActivity(
				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial",
				"Sigma Theta Tau Modules 2017", "In Progress");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "taking assessment for tutorial");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.takeTestSTT(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		if (baseHandler.findElement(".sub-header>section>img").isDisplayed()) {
			myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		}
		boolean result = myReportPage.verifyIPPpageObjects();

		log(logger, "click on close button on card Back");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying STT 2017 test-completed in Recent Activity");
		tutorialPage.clickButtonFromList("new-atitesting.assessment.recent.activity.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		if (baseHandler.findElement(".sub-header>section>img").isDisplayed()) {
			myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		}
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying IPP page");
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		logger.info("NewATI826_STTTestRecentActivity End");
	}
}
