package com.automation.newati.learntab;

import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class VerifyTutorialTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private LearnTabPage learnTabPage;
	private ApplyTabPage applyTabPage;
	private WindowHandler windowHandler;
	private TextHandler textHandler;
	private static String userId = null;
	private int count = 0;
	private NclexPrepTabPage nclexPrepTabPage;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	String downloadFilepath = null;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		learnTabPage = new LearnTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		windowHandler = new WindowHandler(driver);
		textHandler=new TextHandler(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.new"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-129")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Tutorials Assessment Test case")
	public void NewATI129_VerifyTutorialAssessmentTest() throws Exception {
		log(logger, "NewATI129_VerifyTutorialAssessmentTest Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
		log(logger, "Clicking Module by Name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 Start
		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking assessment for tutorial");
		learnTabPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying IPP page");
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1 =tutorialPage.verifySubTabs();
		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Home Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//verify recent activity
//		
//		log(logger, "Verifying pharmacology on test in Recent Activity");
//		homePage.verifyAndClickRecentActivity(
//				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.pharmacologymadeeasy.3.0.loc"), "Flashcard",
//				"Pharmacology Made easy 3.0", "In Progress");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger,"verify Begin case is replaced with Continue Case");
//		String continueCase=textHandler.getText(PropertiesRepository.getString("new-atitesting.Learntab.tutorial.card.front.module.status"));
//		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI129_VerifyTutorialAssessmentTest End");
		
	}
	
	
	@TestAnnotations(testID="NewATI-600")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-600:To Verify that the assessments and tutorials in a CDN are imported to the student account.")
	public void NewATI600_VerifyProductsAddedUsingCDN() throws Exception {
		log(logger, "NewATI600_VerifyProductsAddedUsingCDN Start");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
//		myATITabMainPage.addCDN();
//		
//		buttonHandler.clickButton(PropertiesRepository
//				.getString("new-atitesting.product.information.popup.close.button.loc"));
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name.update"));
		log(logger, "Verifying the added Product in Learn tab");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id.update.new"));
		learnTabPage.clikButtonUsingJavaScript(
				PropertiesRepository.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		myATITabMainPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.test.tab.product.name.update"));
		log(logger, "Verifying the added Product in Test tab");
		myATITabMainPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.test.tab.product.id"));
		learnTabPage.clikButtonUsingJavaScript(
				PropertiesRepository.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		applyTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.apply.tab.product.name.update"));
		log(logger, "Verifying the added Product in Apply tab");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.apply.tab.product.id.new"));
		learnTabPage.clikButtonUsingJavaScript(
				PropertiesRepository.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		
		log(logger, "NewATI600_VerifyProductsAddedUsingCDN End");
	}
	
	@TestAnnotations(testID="NewATI-140")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Dosage Calculation Tutorial Lesson Test case::Learn Tab")
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
		homePage.waitUntillElementIsVisible("#tutorialTypeLabel");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		// Step 3 Start
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.name"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name"); 
		// Step 3 End
		
		// Step 5 Start
		tutorialPage.clickDosageCalculationModuleName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name.new"));
		log(logger, "Clicking on Begin Lesson ");
		// Step 5 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6 Start
		VerificationHandler.verifyTrue(tutorialPage.verifyTableOfContents1(),
				"Unable to verify Table of Contents and Expand All");
		log(logger, "Verifying Assessment Table of Contents");
		// Step 6 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 7 Start
		VerificationHandler.verifyTrue(
				tutorialPage.verifyExpandAllFunctionality1(),
				"Unable to verify Expand and Collapse All functionality");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 14 Start
//		tutorialPage.verifyContinueButtonFunctionality();
		log(logger, "Verifying Assessment Continue Button Funcationality");
		// Step 14 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 15 Start
		tutorialPage.clickTutorialCloseButton();
		log(logger, "Verifying Assessment Close Button");
		// Step 15 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 16 Start
		tutorialPage
				.verifyDosageCalTimeSpentInCardBackForLesson(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name.new"));
		log(logger, "Verifying Time Spent");
		// Step 16 End

		// Step 17 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
        Calendar currentTime = tutorialPage.getTimeSpentInCardBackForDosageCalculation(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name.new"));

        
		tutorialPage
				.clickDosageCalculationModuleName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.142.dosage.module.name.new"));
		log(logger, "Clicking Continue Button in Card Back");
		// Step 17 End

		// Step 18 Start
		//nurseLogicPage.verifyAssessmentName(PropertiesRepository
		 //.getString("new-atitesting.learntab.tutorial.nurse.logic.card.front.module.name"));
		log(logger, "Verifying Assessment Name");
		// Step 18 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 19 Start
		tutorialPage.clickTutorialCloseButton();
		log(logger, "Verifying Assessment Close Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 19 End

		// Step 20 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Calendar updatedTime = tutorialPage.getTimeSpentInCardBackForDosageCalculation(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
//		VerificationHandler.verifyTrue(tutorialPage.verifyTimeDifference(currentTime, updatedTime), "Unable to verify time difference");
		log(logger, "Verifying Assessment Time Differnece");
		// Step 20 End		
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify recent activity
		log(logger, "Verifying Skill Modules test in Recent Activity");
		homePage.verifyAndClickRecentActivity(
				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial",
				"Dosage Calculation 2.0: Dimensional Analysis", "IN PROGRESS");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 log(logger, "Verify element after opening. ");
		  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		
		logger.info("NewATI140_VerifyDosageCalculationLesson End");
	}
	
	@TestAnnotations(testID="NewATI-137")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-137-Validate user is able to take up Pharmacology Made Easy 3.0")
	public void NewATI137_ValidateUserIsAbletoTakeupPharmacologyMadeEasyTest() throws Exception {
		log(logger, "NewATI137_ValidateUserIsAbletoTakeupPharmacologyMadeEasyTest Start");
		
		// Step 2 Start
//		log(logger, "Clicking on My ATI Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(1);
//
//		// Click on Learn Tab
//		log(logger, "Clicking on Learn Tab");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		// Sort Tutorial
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
//				.getString("new-atitesting.tutorialDropdown.value"));
//		log(logger, "Selecting Tutorial from Learn Tab");
//		// Step 2 End
//
//		// Step 3 Start
//		tutorialPage
//				.clickModuleButtonByName(PropertiesRepository
//						.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
//		log(logger, "Clicking Module by Name");
//		
//		// Step 5 Start
//		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
//		log(logger, "Clicking Begin Test ");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Tutorial from the dropdown");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select  Tutorial Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.pharmacology.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Begin Test and Begin Lesson for each module ");
//		boolean status=tutorialPage.verifyEachModuleBeginLessonAndBeginTest();
//		VerificationHandler.verifyTrue(status, "Begin Test and Begin Lesson is not displayed for each module ");
		tutorialPage
		.clickDosageCalculationModuleNameTest("Infection");
log(logger, "Clicking Begin Test ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying calculator and time elapsed text ");
		boolean isEleDisplayed=tutorialPage.verifyAssessmentFrameObjects();
		VerificationHandler.verifyTrue(isEleDisplayed, "calculator  is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "taking assessment for tutorial");
		//tutorialPage.takeRationalTutorialTest();
		//testTabPage.takeAssessmentTest(true,"Finalize and View Results");
		tutorialPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);
		
		Thread.sleep(5000);
		log(logger, "verifying IPP page");
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1 =tutorialPage.verifySubTabs();
		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		log(logger, "NewATI137_ValidateUserIsAbletoTakeupPharmacologyMadeEasyTest End");
		
	}
	
	@TestAnnotations(testID="NewATI-142")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Validate user is able to take up Dosage calculation tutorial Test::Learn Tab")
	public void NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest() throws Exception {
		log(logger, "NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
		tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.142.dosage.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		
		// Step 5 Start
		tutorialPage
				.clickDosageCalculationModuleNameTest(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
		log(logger, "Clicking Begin Test ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLabelText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying calculator and time elapsed text ");
		boolean isEleDisplayed=tutorialPage.verifyAssessmentFrameObjectsWithoutCalc();
		VerificationHandler.verifyTrue(isEleDisplayed, "calculator  is not displayed");
		
		log(logger, "taking assessment for tutorial");
		tutorialPage.takeTestForDosage(false, false, true, false);
		
		Thread.sleep(20000);
		log(logger, "verifying IPP page");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"));
	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1 =tutorialPage.verifySubTabs();
		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify recent activity
		log(logger, "Verifying Skill Modules test in Recent Activity");
		homePage.verifyAndClickRecentActivity(PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial","Dosage Calculation 2.0: Dimensional Analysis", "In Progress");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 log(logger, "Verify element after opening. ");
		// windowHandler.switchToFrame("assessmentFrame");
//		 VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.focused.review.close.button.new.loc")), "Unable to verify element after opening.");
		log(logger, "NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest End");
		
	}
	@TestAnnotations(testID="NewATI-601")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "To verify products can be added individually::My ATI")
	public void NewATI601_VerifyProductsAddedIndividually() throws Exception {
		log(logger, "NewATI601_VerifyProductsAddedIndividually Start");
		
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.productid"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.password.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.productpassword"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.product.name"));
		log(logger, "Verifying the added Product");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.add.product.productid"));
		log(logger, "NewATI601_VerifyProductsAddedIndividually End");
	}
	
	
	/*@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-777:Validate user is able to take up Dosage calculation tutorial Test")
	public void NewATI777_ValidateUserIsAbletoTakeupDosageCalculationTutorialTestMaintainance() throws Exception {
		log(logger, "NewATI777_ValidateUserIsAbletoTakeupDosageCalculationTutorialTestMaintainance Start");
		
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
		tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.142.dosage.name"));
		log(logger, "Clicking Module by Name");
		
		// Step 5 Start
		tutorialPage
				.clickBeginTestButtonInNurseLogicCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
		log(logger, "Clicking Begin Test ");
		
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		
		
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		Thread.sleep(2000);
		//for Lessson functionality
		
		tutorialPage
		.clickBeginLessonButtonInNurseLogicCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
		log(logger, "Clicking on Begin Lesson ");
// Step 5 End

// Step 6 Start
		VerificationHandler.verifyTrue(tutorialPage.verifyTableOfContents(),
		"Unable to verify Table of Contents and Expand All");
		log(logger, "Verifying Assessment Table of Contents");
// Step 6 End

// Step 7 Start
		VerificationHandler.verifyTrue(
		tutorialPage.verifyExpandAllFunctionality(),
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


		
        log(logger, "NewATI777_ValidateUserIsAbletoTakeupDosageCalculationTutorialTestMaintainance End");
		
	}
	
	
	@TestAnnotations(testID="NewATI-601")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "To verify products can be added individually::My ATI")
	public void NewATI601_VerifyProductsAddedIndividually() throws Exception {
		log(logger, "NewATI601_VerifyProductsAddedIndividually Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.loc"));

		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.productid"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.password.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.productpassword"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.product.name"));
		log(logger, "Verifying the added Product");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.add.product.productid"));
		log(logger, "NewATI601_VerifyProductsAddedIndividually End");
	}
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-600:To Verify that the assessments and tutorials in a CDN are imported to the student account.")
	public void NewATI600_VerifyProductsAddedUsingCDN() throws Exception {
		log(logger, "NewATI600_VerifyProductsAddedUsingCDN Start");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		myATITabMainPage.addCDN();
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name"));
		log(logger, "Verifying the added Product in Learn tab");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc"));
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		myATITabMainPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.test.tab.product.name"));
		log(logger, "Verifying the added Product in Test tab");
		myATITabMainPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.test.tab.product.id"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc"));
		
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		applyTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.apply.tab.product.name"));
		log(logger, "Verifying the added Product in Apply tab");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.apply.tab.product.id"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc"));
		
		log(logger, "NewATI600_VerifyProductsAddedUsingCDN End");
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
	}*/
	
	@TestAnnotations(testID="NewATI-153")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-153:STT Tutorials Test Regression")
	public void NewATI153_VerifySTTTest() throws Exception {
		log(logger, "NewATI153_VerifySTTTest Start");
		
		//Step-1
		loginPage.loginToApplication("stagesingleinstance","Test123");
				
		//Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Selecting Tutorial from Learn Tab drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		//Step-3
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Verify Modules count and header section in card back");
		VerificationHandler.verifyTrue(tutorialPage.verifyCardBackHeaderSection(PropertiesRepository.getString("newati.card.back.title.loc"),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")), "unable to verify card back header section");
				
		log(logger, "Clicking Begin/Continue Test ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.stt.test.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying calculator and time elapsed text ");
		boolean isEleDisplayed=tutorialPage.verifyAssessmentFlagTime();
		VerificationHandler.verifyTrue(isEleDisplayed, "calculator  is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "taking assessment for tutorial");
		VerificationHandler.verifyTrue(tutorialPage.takeTestSTT(false, false, true, false));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying IPP page");
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc"),
						PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")),
				"Unable to verify Module name");
		
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1 =tutorialPage.verifySubTabs();
		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		
		log(logger, "NewATI153_VerifySTTTest End");
		
	}
	
	@TestAnnotations(testID="NewATI-510")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "To verify skills module 2.0 for existing NewATI user::Learn Tab")
	public void NewATI510_VerifySkillsModules() throws Exception {
		log(logger,"NewATI510_VerifySkillsModules Start");

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

		//step3 start
		log(logger, "Verifying Skills Module 2.0");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyCardFrontBasedOnModuleName("Skills Modules 2.0"), "Unable to verify Skills Modules 2.0");
		
//		log(logger, "Verifying Skills Module");
//		VerificationHandler
//		.verifyTrue(tutorialPage.verifyCardFrontBasedOnModuleName("Skills Modules"), "Unable to verify Skills Modules 2.0");
		
		log(logger,"NewATI510_VerifySkillsModules End");
		//step3 end
	}
	/*
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-113:STT Tutorials Lesson: Regression Test Case")
	public void NewATI113_VerifySTTLesson() throws Exception {
		logger.info("NewATI113_VerifySTTLesson Start");

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
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.153.assessment.name"));
		log(logger, "Clicking Module by Name"); 
		// Step 3 End
		
		// Step 5 Start
		tutorialPage
				.clickBeginLessonButtonInNurseLogicCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.module.name"));
		log(logger, "Clicking on Begin Lesson ");
		// Step 5 End

		VerificationHandler.verifyTrue(tutorialPage.verifySTTName(), "Unable to verify STT Lesson name"); 
		
		
		logger.info("NewATI113_VerifySTTLesson End");
	}
	
	@TestAnnotations(testID="NewATI-129")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Tutorials Assessment Test case")
	public void NewATI129_VerifyTutorialAssessmentTest() throws Exception {
		log(logger, "NewATI129_VerifyTutorialAssessmentTest Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		// Step 3 Start
		tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
		log(logger, "Clicking Module by Name");
		
		// Step 5 Start
		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");
		
		log(logger, "Select  Tutorial Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify Begin Test and Begin Lesson for each module ");
		boolean status=tutorialPage.verifyEachModuleBeginLessonAndBeginTest();
		VerificationHandler.verifyTrue(status, "Begin Test and Begin Lesson is not displayed for each module ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying new ati logo");
		boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
		VerificationHandler.verifyTrue(flag, "Logo is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying close button");
		boolean closeButtonStatus = tutorialPage.verifyCloseButton();
		VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
		
		log(logger, "verifying Question label text");
		boolean questionLabelText=tutorialPage.verifyQuestionLableText();
		VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
		
		log(logger, "Taking assessment for tutorial");
		learnTabPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);

		log(logger, "verifying IPP page");
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		
		boolean result1 =tutorialPage.verifySubTabs();
		VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
		log(logger, "NewATI129_VerifyTutorialAssessmentTest End");
		
	}
	*/
	@TestAnnotations(testID="NewATI-40")
	@Test(priority = 8, groups = {"Regression"}, description = "NewATI-40:Check for Tutorial : Skill Modules")
	public void NewATI40_VerifySkillsModulesLessonAndTest() throws Exception {
		log(logger,"NewATI40_VerifySkillsModulesLessonAndTest Start");

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(10000);
		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		//step3 start
		log(logger, "Verifying Skills Module 2.0");
		VerificationHandler.verifyTrue(tutorialPage.verifyCardFrontBasedOnModuleName("Skills Modules 2.0"), "Unable to verify Skills Modules 2.0");

		//tutorialPage.selectCardFrontBasedOnModuleNameSkillsModule("Skills Modules 2.0");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new.atitesting.module.name.sk2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
//		log(logger, "Clicking on Post Test");
//		tutorialPage.clickPostTestCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.skills.module.2.0.name.3"));
//		tutorialPage.verifyAssessmentName(PropertiesRepository.getString("new-atitesting.learntab.skills.module.2.0.name.3"));
//		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
//		tutorialPage.waitForAwhile(50000);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
		log(logger, "Clicking on lesson");
		tutorialPage.clickBeginLessonButtonInSkillsModuleCardBack(PropertiesRepository.getString("new-atitesting.learntab.skills.module.2.0.name.3"));
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify recent activity
		log(logger, "Verifying Skill Modules test in Recent Activity");
		homePage.verifyAndClickRecentActivity(
				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial",
				"Skills Modules 2.0", "In Progress");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"NewATI40_VerifySkillsModulesLessonAndTest End");
		//step3 end
	}
	@TestAnnotations(testID = "NewATI-810")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-810: STT 2017 Tutorials Test Regression")
	public void NewATI810_STT2017Regression() throws Exception {
		logger.info("NewATI810_STT2017TestRegression Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"), PropertiesRepository.getString("newati.login.user.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Tutorialfrom dropdown");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler
				.verifyTrue(homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc"),
						PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")), "Unable to verify Assessment name");
	
		log(logger, "Clicking Begin Test ");
		tutorialPage.clickBeginTestButtonInNurseLogicCardBackNew("Introduction to Administrative, Management, and Organizational Theories 2017");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if assessment page is loaded");
		homePage.switchToAssessmentFrameHandler();
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.question.number.loc"), "Unable to verify Question number in Assessment page");
		windowHandler.switchToLatestWindow();		
		
		log(logger, "taking assessment for tutorial");
		VerificationHandler.verifyTrue(tutorialPage.takeTestSTT(false, false, false, false), "Unable to complete STT Assessment");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		log(logger, "verifying IPP page");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
		homePage.deleteFileExists(downloadFilepath);
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.download.report.loc"));
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
		
		logger.info("NewATI810_STT2017Regression End");
	}


}
