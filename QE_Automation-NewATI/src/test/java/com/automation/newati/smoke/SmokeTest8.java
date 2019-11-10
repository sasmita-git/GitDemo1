
package com.automation.newati.smoke;
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

public class SmokeTest8 extends BaseTest {

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
		
		// Verifying the Quiz
		VerificationHandler.verifyEquals(flashCardPage
				.getFlashCardNameInFlashCardAssessment(),flashCardName,"FlashCard assessment name is not equal");
		log(logger, "Verifying Flash Card name");
		
		
		// Click on Flash Card Close button
		flashCardPage.closeFlashCardAssessmentPopup("quizbanks.assessment.popup.close");
		log(logger, "Clicked on Close button in Quiz Bank");
		
		logger.info("NewATI37_VerifyFlashCard Ends");
	}
	


}
