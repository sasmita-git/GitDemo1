package com.automation.newati.smoke;

import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest9 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private TextHandler textHandler;
	private LearnTabPage learnTabPage;
	private ButtonHandler buttonHandler;
	private ApplyTabPage applyTabPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		textHandler = new TextHandler(driver);
		learnTabPage = new LearnTabPage(driver);
		buttonHandler = new ButtonHandler(driver);
		applyTabPage = new ApplyTabPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name.dosasecal"), PropertiesRepository.getString("newati.login.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

@TestAnnotations(testID="NewATI-140")
@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Dosage Calculation Tutorial Lesson Test case::Learn Tab")
public void NewATI140_VerifyDosageCalculationLesson() throws Exception {
	logger.info("NewATI140_VerifyDosageCalculationLesson Start");

	// Step 2 Start
	log(logger, "Clicking on My ATI Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(1);

	// Click on Learn Tab
	log(logger, "Clicking on Learn Tab");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	// Sort Tutorial
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	log(logger, "Selecting Tutorial from Learn Tab");
	// Step 2 End

	// Step 3 Start
	tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.name"));
	log(logger, "Clicking Module by Name"); 
	// Step 3 End
	//DOne chnages_15thNov
	// Step 5 Start
	tutorialPage
			.clickDosageCalculationModuleName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
	log(logger, "Clicking on Begin Lesson ");
	// Step 5 End

	// Step 6 Start
	VerificationHandler.verifyTrue(tutorialPage.verifyTableOfContents1(),
			"Unable to verify Table of Contents and Expand All");
	log(logger, "Verifying Assessment Table of Contents");
	// Step 6 End

	// Step 7 Start
	VerificationHandler.verifyTrue(
			tutorialPage.verifyExpandAllFunctionality1(),
			"Unable to verify Expand and Collapse All functionality");
	log(logger,
			"Verifying Assessment Expand and Collapse Button Funcationality");
	// Step 7 End

	// Step 8 Start
	VerificationHandler.verifyTrue(
			tutorialPage.verifyAssessmentLogo(),
			"Unable to verify Logo");
	log(logger, "Verifying Assessment Logo");
	// Step 8 End

	// Step 11 Start
	tutorialPage.clickNurseLogicToolsButton1();
	log(logger, "Verifying Assessment Tools Button");
	// Step 11 End

	// Step 13 Start
	// nurseLogicPage.verifyPlayAndPauseButton();
	// Step 13 End

	// Step 14 Start
	tutorialPage.verifyContinueButtonFunctionality();
	log(logger, "Verifying Assessment Continue Button Funcationality");
	// Step 14 End

	// Step 15 Start
	tutorialPage.clickTutorialCloseButton();
	log(logger, "Verifying Assessment Close Button");
	// Step 15 End

	// Step 16 Start
	tutorialPage
			.verifyDosageCalTimeSpentInCardBackForLesson(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
	log(logger, "Verifying Time Spent");
	// Step 16 End

	// Step 17 Start
    Calendar currentTime = tutorialPage
	.getTimeSpentInCardBackForDosageCalculation(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));

	tutorialPage
			.clickDosageCalculationModuleName(PropertiesRepository
					.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
	log(logger, "Clicking Continue Button in Card Back");
	// Step 17 End

	// Step 18 Start
	//nurseLogicPage.verifyAssessmentName(PropertiesRepository
	 //.getString("new-atitesting.learntab.tutorial.nurse.logic.card.front.module.name"));
	log(logger, "Verifying Assessment Name");
	// Step 18 End

	// Step 19 Start
	tutorialPage.clickTutorialCloseButton();
	log(logger, "Verifying Assessment Close Button");
	// Step 19 End

	// Step 20 Start
	Calendar updatedTime = tutorialPage.getTimeSpentInCardBackForDosageCalculation(PropertiesRepository
					.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
	VerificationHandler.verifyTrue(tutorialPage.verifyTimeDifference(currentTime, updatedTime), "Unable to verify time difference");
	log(logger, "Verifying Assessment Time Differnece");
	// Step 20 End
	
	
	
	logger.info("NewATI140_VerifyDosageCalculationLesson End");
}



}
