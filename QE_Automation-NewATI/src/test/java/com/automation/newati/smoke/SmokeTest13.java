package com.automation.newati.smoke;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.QuizPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest13 extends BaseTest{

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private QuizPage quizPage;
	private MyReportPage myReportPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		quizPage = new QuizPage(driver);
		myReportPage =new MyReportPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.quiz"), PropertiesRepository.getString("newati.login.password"));
	}
	
	@TestAnnotations(testID="NewATI-97")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Quiz Bank Functionality::Learn Tab")
	public void NewATI97_VerifyQuizBankFunctionality() throws Exception {
		logger.info("NewATI97_VerifyQuizBankFunctionality Start");
		// Step 3, 4 Start
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.allDropdown.quizbans.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		// Step 5 End

		int i = quizPage.getQuizCardFrontCount(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "the quiz count is " + i);

		// Step 6, 7 Start
		quizPage.checkInfoButtonByAssessmentNameForQuiz(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "Verifying Assessment Name");
		log(logger, "Verifying Assessment Info button ");
		// Step 6, 7 End

		// Step 10 Start

		quizPage.verifyAssessmentAccessedStateAsNever(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "Verifying Assessment Accessed State");
		// Step 10 End

		// Step 11 & 12 Start
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 11 & 12 End

		quizPage.getQuizCardbackCount();
		log(logger, "the quiz card back count is " + i);
		// Step 15 Start
		quizPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		log(logger, "Clicking on Being Quiz button");
		// Step 15 End

		// Step 16 Start
		VerificationHandler.verifyTrue(quizPage
				.verifyAssesmentNameInAssessmentPage());
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(
				quizPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");
		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler
				.verifyTrue(tutorialPage.verifyAssessmentStartingNumberButtonWithoutSwitch(),
						"Unable to verify Question Starting Number in Nurse Logic Page");
		log(logger, "Verifying Assessment Question Start No");
		VerificationHandler.verifyTrue(
				tutorialPage.verifyAssessmentEndingNumberButtonWithoutSwitch(),
				"Unable to verify Question Ending Number in Nurse Logic Page");
		log(logger, "Verifying Assessment Question End No");
		log(logger, "Verifying Assessment Submit Button");
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentSubmitButtonWithoutSwitch());
		log(logger, "Verifying Assessment Continue Button");
		// Step 16 End

		// Step 17 Start
		VerificationHandler.verifyTrue(quizPage.clickAssessmentToolsButtonWithoutSwitch(),
				"Unable to verify Tools Glosasry, Calcualtor and Study Guide");
		log(logger, "Verifying Assessment Tools Button");
		// Step 17 End

		// Step 21 Start
		//quizPage.clickContinueWithoutAnswering();
		// Step 21 End

		// Step 22 Start
		tutorialPage.takeTestQuiz(false, false, true, false);

		Thread.sleep(10000);
		log(logger, "verifying IPP page");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Complete Assessment Functionality");
		// Step 22 End
		logger.info("NewATI97_VerifyQuizBankFunctionality Start");
	}
	


}
