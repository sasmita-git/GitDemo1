package com.automation.asmt.learntab;

import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.QuizBankPage;
import com.jaca.TestAnnotations;

public class QuizRegressionTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private QuizBankPage quizBankPage;
	
	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		quizBankPage = new QuizBankPage(driver);
		
		/*loginPage.loginToApplication(
				PropertiesRepository.getString("asmt.username"),
				PropertiesRepository.getString("asmt.password"));*/
		
		loginPage.loginToApplication("stgauto1","Test123");
	}	

	@TestAnnotations(testID = "217")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT-217:Verify Glossary pop up window on clicking underlined word by clicking 'HINT' button.")
	public void ASMT217_ValidateHintButtonForQuiz() throws Exception {
		log(logger, "ASMT217_ValidateHintButtonForQuiz Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		/*log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc"));
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());*/
		
		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(
				quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");
		
		log(logger, "Clicking on show hint button");
		quizBankPage.clickAssessmentShowHintButton();
		
		log(logger, "Click and verify glossary");
		VerificationHandler.verifyTrue(quizBankPage.verifyGlossaryLinkAndContent(), "Unable to verify Glossary for Quiz");
		
		log(logger, "ASMT217_ValidateHintButtonForQuiz End");
	}
	
	/**
	 * As discussed with Abhishek time difference is calculated for only one module. 
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "384")
	@Test(priority = 2, alwaysRun = true, groups = { "Regression" }, description = "ASMT-384:Verify the timer in Quizbank test.")
	public void ASMT384_ValidateTimerForQuiz() throws Exception {
		log(logger, "ASMT384_ValidateTimerForQuiz Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);
		
		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc"));
		
		log(logger, "Get the timing before starting quiz");
		Calendar calBeforeStartingQuiz = quizBankPage.getTimeSpentInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());
		
		log(logger, "Clicking on close button by adding timings");
		assessmentPage.clickOnCloseButtonWithAddingTiming("asmt.question.assement.question.close.button");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		log(logger, "Get the timing after starting quiz");
		Calendar calAfterStartingQuiz = quizBankPage.getTimeSpentInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Calculating Time Differnce");
		quizBankPage.verifyTimeDifference(calBeforeStartingQuiz, calAfterStartingQuiz);
		log(logger, "ASMT384_ValidateTimerForQuiz End");
	}
	
	@TestAnnotations(testID = "214")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT-214:Verify the header Name of completion pop up,when user completes quize.")
	public void ASMT214_ValidateFinalSectionForQuiz() throws Exception {
		log(logger, "ASMT214_ValidateFinalSectionForQuiz Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);
		
		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc"));
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());
		
		log(logger, "Take Test for Question text for all assessemnts Funcationality");
		VerificationHandler.verifyTrue(assessmentPage.takeTestQuizVerifyFinalSection(false, false, true, false), "Unable to verify Final Section for Quiz");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "ASMT214_ValidateFinalSectionForQuiz End");
	}
	
	@TestAnnotations(testID = "356")
	@Test(priority = 4, alwaysRun = true, groups = { "Regression" }, description = "ASMT-356:Verify functionality of Tools button on quizbank assessment page")
	public void ASMT356_VerifyQuizToolsSection() throws Exception {
		log(logger, "ASMT356_VerifyQuizToolsSection Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);
		
		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());
		
		log(logger, "Verifying Tools Section");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyToolsSection());
		
		log(logger, "ASMT356_VerifyQuizToolsSection End");
	}
	
	@TestAnnotations(testID = "210")
	@Test(priority = 5, alwaysRun = true, groups = { "Regression" }, description = "ASMT-210:Verify glossary heading and content Alignment in glossary for selected Glossary word")
	public void ASMT210_VerifySelectedGlossaryContentAlignment() throws Exception {
		log(logger, "ASMT210_verifySelectedGlossaryContentAlignment Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);
		
		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());
		
		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(
				quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");
		
		log(logger, "Clicking on show hint button");
		quizBankPage.clickAssessmentShowHintButton();
		
		log(logger, "Click and verify glossary");
		log(logger, "Click on the Glossary from the Gossary pop up list and Verify the Glossary content alignment");
		VerificationHandler.verifyTrue(quizBankPage.verifySelectedGlossaryContentAlignment(), "Unable to verify Glossary content in Glossary pop up");
		
		log(logger, "ASMT210_VerifySelectedGlossaryContentAlignment End");
	}
	
	
	@TestAnnotations(testID = "213")
	@Test(priority = 6, alwaysRun = true, groups = { "Regression" }, description = "ASMT-213:Verify the default Show Hint button status on answered Quiz Page")
	public void ASMT213_VerifyDefaultShowHintButtonStatusOnAnswerPage() throws Exception {
		log(logger, "ASMT213_VerifyDefaultShowHintButtonStatusOnAnswerPage Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
	
		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",0);
		
		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));
		
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage
				.verifyAssesmentNameInAssessmentPage());
		
		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(
				quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");
		
		log(logger, "Verifying the Show Hint Button status in asnwer validation page");
		VerificationHandler.verifyTrue(
				quizBankPage.verifyDefaultShowHintButtonStatusOnAnsweredQuizPage(),
				"Unable to verify Show Hint Button status in asnwer validation page");
		
		log(logger, "ASMT213_VerifyDefaultShowHintButtonStatusOnAnswerPage End");
	}
}
