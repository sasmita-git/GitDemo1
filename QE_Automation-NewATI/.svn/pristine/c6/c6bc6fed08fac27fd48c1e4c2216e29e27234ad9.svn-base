package com.automation.newati.myati.improvetab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyFocusedReviewAccessTime extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private ImproveTabPage improveTabPage;
	private MyReportPage reportPage;
	private WindowHandler windowHandler;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		improveTabPage = new ImproveTabPage(driver);
		reportPage = new MyReportPage(driver);
		windowHandler = new WindowHandler(driver);	
		
	}

	
	// The test case is automated till downloading the report, need to verify the accessed time in the report file 
	// Test case is autmoated for only Practice assessments.
	@TestAnnotations(testID="NewATI-515")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-515:Verification for Focused Review Accessed time")
	public void NewATI515_verifyFocusedReviewAccessTime() throws Exception{
		log(logger, "NewATI515_verifyFocusedReviewAccessTime Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.user.name"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		
		//Step 3
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(35000);
		
		logger.info("Step 4");
		//Step 4
		log(logger, "Capture the time in the focused review.");
		windowHandler.switchToFrame(0);
		int time = improveTabPage.captureTime("new-atitesting.focused.review.time.spent.loc", 0);
		windowHandler.switchToMainWindow();
		
		log(logger, "Clicking on close button of the Focused review.");
		homePage.click(PropertiesRepository.getString("new-atitesting.focused.review.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(2000);

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("Step 5");
		//Step 5
		log(logger, "Click on Results button of the focused review closed. ");
		homePage.clickButtonFromList("new-atitesting.improve.tab.results.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");

		log(logger, "Capture the time of focused review in IPP page.");
		int timeIPP = improveTabPage.captureTimeFromIPP("new-atitesting.focused.review.time.spent.loc", 1);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify time difference");
//		VerificationHandler.verifyTrue(improveTabPage.verifyTimeDiffrence(time, timeIPP), "Time difference is large.");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Step 6");
		//Step 6
		log(logger, "Click close button of the IPP page.");
		homePage.click(PropertiesRepository.getString("new-atitesting.IPP.page.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(2000);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(35000);
		
		log(logger, "Capture the time in the focused review.");
		windowHandler.switchToFrame(0);
		int time2 = improveTabPage.captureTime("new-atitesting.focused.review.time.spent.loc", 0);
		windowHandler.switchToMainWindow();

		logger.info("time " + time);
		logger.info("timeIPP " + timeIPP);
		logger.info("time2 " + time2);
		
		log(logger, "Verify time difference");
		VerificationHandler.verifyTrue(improveTabPage.verifyTimeDiffrence(time, time2), "Time difference is large.");
		
		logger.info("Step 7");
		//Step 7
		log(logger, "Clicking on close button of the Focused review.");
		homePage.click(PropertiesRepository.getString("new-atitesting.focused.review.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking My Results Tab");
		homePage.clickTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Print Report button");	
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-ati.report.download.loc"),"Download report is not displayed");
				
//		log(logger, "Clicking on Download button for thr FR report.");
//		String downloadFilepath = PropertiesRepository.getString("global.download.location");
//		homePage.createDirectory("C:\\download");
//		homePage.createDirectory(downloadFilepath);
//		homePage.deleteFileExists(downloadFilepath);
//		reportPage.clickDownloadReportAfterTest(0);
//		tutorialPage.waitForAwhile(10000);
//		log(logger, "Verifying file after download");
//		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");

		log(logger, "NewATI515_verifyFocusedReviewAccessTime Ends");
		
	}
		
}
