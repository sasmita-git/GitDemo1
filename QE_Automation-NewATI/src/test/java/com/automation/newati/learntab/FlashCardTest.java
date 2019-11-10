package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.FlashCardPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class FlashCardTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private FlashCardPage flashCardPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		flashCardPage = new FlashCardPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.flashcard"), PropertiesRepository.getString("newati.login.password"));
	}
	
	@TestAnnotations(testID="NewATI-37")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Check for Flashcards:Learn Tab")
	public void NewATI37_VerifyFlashCard() throws Exception {
		log(logger, "Flash Card Verification Starts : Method - NewATI37_VerifyFlashCard");
		
		
		// Step 3, 4 Start
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.flashCardDropdown.value"));
		log(logger, "Selecting Flash Card from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String flashCardName = flashCardPage.getFlashCardNameInCardFront();
		
		flashCardPage.clickOnFlashcardModules();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		flashCardPage.beginLesson();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verifying the Quiz
		VerificationHandler.verifyEquals(flashCardPage
				.getFlashCardNameInFlashCardAssessment(),flashCardName,"FlashCard assessment name is not equal");
		log(logger, "Verifying Flash Card name");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Flash Card Close button
		flashCardPage.closeFlashCardAssessmentPopup("quizbanks.assessment.popup.close");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicked on Close button in Quiz Bank");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify recent activity
		log(logger, "Verifying Flash Cards test in Recent Activity");
		homePage.verifyAndClickRecentActivity(
				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.flashcard.loc"), "Flashcard",
				"Active Stack® Pharmacology Flash Cards", "In Progress");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("NewATI37_VerifyFlashCard Ends");
	}
	
	//For Maintainance
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-37: Check for Flashcards")
	public void NewATI779_VerifyFlashCardMaintainance() throws Exception {
		log(logger, "Flash Card Verification Starts : Method - NewATI37_VerifyFlashCard");
		
		
		// Step 3, 4 Start
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
				.getString("new-atitesting.flashCardDropdown.value"));
		log(logger, "Selecting Flash Card from Learn Tab");
		// Step 2 End
		
		String flashCardName = flashCardPage.getFlashCardNameInCardFront();
		
		flashCardPage.clickOnFlashcardModules();
		
		flashCardPage.beginLesson();
		
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-513:Verification for Print button on Flash Cards final score card")
	public void NewATI513_VerifyFlashcardReport() throws Exception {
		log(logger, "NewATI513_VerifyFlashcardReport Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		// Step 3, 4 Start
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.flashCardDropdown.value"));
		log(logger, "Selecting Flash Card from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//String flashCardName = flashCardPage.getFlashCardNameInCardFront();
		
		flashCardPage.clickOnFlashcardModules();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		flashCardPage.beginLesson();
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Start FlashCard
		flashCardPage.startflashcard();
		log(logger, "Clicking on Start Flash Card - Completed");
		
		// Completing the flash card.
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		flashCardPage.startFlashAssessment();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Start Flash Assessment in Flash Card - Completed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifing Print Result Button");
		VerificationHandler
		.verifyTrue(flashCardPage.verifyPrintResult(), "Unable to verify Print Results");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("NewATI513_VerifyFlashcardReport Ends");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-514:Verifcation for content displayed in report by clicking on Print result button for Flashcards")
	public void NewATI514_VerifyFlashcardDetails() throws Exception {
		log(logger, "NewATI514_VerifyFlashcardDetails Start");
		
		// Step 3, 4 Start
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.flashCardDropdown.value"));
		log(logger, "Selecting Flash Card from Learn Tab");
		// Step 2 End
		
		//String flashCardName = flashCardPage.getFlashCardNameInCardFront();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		flashCardPage.clickOnFlashcardModules();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		flashCardPage.beginLesson();
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Start FlashCard
		flashCardPage.startflashcard();
		log(logger, "Clicking on Start Flash Card - Completed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Completing the flash card.
		flashCardPage.startFlashAssessment();
		log(logger, "Clicking on Start Flash Assessment in Flash Card - Completed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifing Print Result Button");
		VerificationHandler
		.verifyTrue(flashCardPage.verifyPrintResult(), "Unable to verify Print Results");

		VerificationHandler
		.verifyTrue(flashCardPage.verifyPrintResultDetails(), "Unable to verify Print Results details");
		
		logger.info("NewATI514_VerifyFlashcardDetails Ends");
	}
	
}
