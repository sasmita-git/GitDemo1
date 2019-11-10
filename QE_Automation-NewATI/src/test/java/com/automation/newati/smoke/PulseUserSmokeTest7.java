package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest7 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private TutorialPage tutorialPage;
	private HomePage homePage;
	public BaseHandler baseHandler;
	public TestTabPage testTabPage;
	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		baseHandler = new BaseHandler(driver);
		testTabPage=new TestTabPage(driver);
	}

	//quiz,
	@TestAnnotations(testID="NewATI-848")
	@Test(priority = 10, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-848:Verify practice and proctor assessment completion flow with pulse user.")
	public void NewATI848_VerifyPracticeAndProctorAssessmentCompletionFlowWithPulseUser() throws Exception {
		log(logger, "NewATI848_VerifyPracticeAndProctorAssessmentCompletionFlowWithPulseUser Start");
	
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse.practice"), PropertiesRepository.getString("newati.login.password"));
//		log(logger, "Clicking on My ATI Tab");
//		
//		homePage.clickTab(1);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Test Tab");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Sort Tutorial
//		log(logger, "Selecting Quiz from Test Tab");
////		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
//		
//		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 2 End
//
//		// Step 5 End
//		int i = quizPage.getQuizCardFrontCount(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0"));
//		log(logger, "the quiz count is " + i);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 6, 7 Start
//		
//		VerificationHandler.verifyTrue(quizPage.checkInfoButtonByAssessmentNameForQuiz(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0")));
//		log(logger, "Verifying Assessment Name");
//		log(logger, "Verifying Assessment Info button ");
//		// Step 6, 7 End
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 10 Start
////		VerificationHandler.verifyTrue(quizPage.verifyAssessmentAccessedStateAsNever(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0")));
//		log(logger, "Verifying Assessment Accessed State");
//		// Step 10 End
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		// Step 11 & 12 Start
//		log(logger, "Clicking Module by Name");
//		tutorialPage.clickQuizModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		log(logger, "Verify if Card Back Title is displayed");
//		VerificationHandler.verifyTrue(
//				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
//						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0")),
//				"Unable to verify Module name");
//		
//		// Step 11 & 12 End
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		quizPage.getQuizCardbackCount();	
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "the quiz card back count is " + i);
//		
//		// Step 15 Start
//		quizPage.clickBeginQuizInCardBack(PropertiesRepository
//				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
//		log(logger, "Clicking on Being Quiz button");
//		// Step 15 End
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 16 Start
//		VerificationHandler.verifyTrue(quizPage.verifyAssesmentNameInAssessmentPage());
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Verifying Assessment Name");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		VerificationHandler.verifyTrue(quizPage.verifyAssessmentShowHintButton(),"Unable to verify Show Hint Button in Nurse Logic Page");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Verifying Assessment Show Hint Button");
//		VerificationHandler
//				.verifyTrue(tutorialPage.verifyAssessmentStartingNumberButtonWithoutSwitch(),
//						"Unable to verify Question Starting Number in Nurse Logic Page");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verifying Assessment Question Start No");
//		VerificationHandler.verifyTrue(
//				tutorialPage.verifyAssessmentEndingNumberButtonWithoutSwitch(),
//				"Unable to verify Question Ending Number in Nurse Logic Page");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verifying Assessment Question End No");
//		
//		log(logger, "Verifying Assessment Submit Button");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentSubmitButtonWithoutSwitch());
//		
//		log(logger, "Verifying Assessment Continue Button");
//		// Step 16 End
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 17 Start
//		VerificationHandler.verifyTrue(quizPage.clickAssessmentToolsButtonWithoutSwitch(),
//				"Unable to verify Tools Glosasry, Calcualtor and Study Guide");
//		log(logger, "Verifying Assessment Tools Button");
//		tutorialPage.clickQuizCloseButton();
//		log(logger, "Clicked on Close button in Quiz Bank");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.new"));
//		
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify if Card Back Title is displayed");
//		VerificationHandler.verifyTrue(
//				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
//						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.3.0")),
//				"Unable to verify Module name");
//
//		log(logger, "Complete Learning System RN 3.0 Functionality");	
//			
				
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Add product button");
		createAccountPage.clickOnAddProductButton();
		createAccountPage.enterPracticeIdAddProduct("new-atitesting.createaccount.stage.addProductpracticeID");
		createAccountPage.clickOnButton("new-atitesting.createaccount.addProductContinueBtnLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Taking Assessment 1");
		tutorialPage.takeTestTEAS(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 2");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 3");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 4");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		createAccountPage.clickOnButton("new-atitesting.focusreview.button.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify recent activity name");
		boolean result=homePage.verifyRecentActivity1("ATI-ASMT-CPNP");
		VerificationHandler.verifyTrue(result, "Recent activity is not displayed");
		
	

}
}


