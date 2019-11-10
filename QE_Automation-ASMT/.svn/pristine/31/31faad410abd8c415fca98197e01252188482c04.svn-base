package com.automation.asmt.learntab;

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

public class QuizRegressionTest3 extends BaseTest {

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

	@TestAnnotations(testID = "201")
	@Test(priority = 1, alwaysRun = true, groups = {
			"Regression" }, description = "ASMT201_VerifyContentHighlightOnClickingShowHintButton")
	public void ASMT201_VerifyContentHighlightAndShowHintButtonOnClickingShowHintButton() throws Exception {
		log(logger, "ASMT201_VerifyContentHighlightAndShowHintButtonOnClickingShowHintButton Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));

		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssesmentNameInAssessmentPage());

		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");

		log(logger, "Clicking on show hint button");
		quizBankPage.clickAssessmentShowHintButton();

		log(logger, "Verify Content Highlight and Show Hint Button On Clicking Show Hint Button End");
		VerificationHandler.verifyTrue(quizBankPage.VerifyHideAndHighlightButton(), "Unable to verify Content Highlight and Show Hint Button On Clicking Show Hint Button");
		log(logger, "ASMT201_VerifyContentHighlightAndShowHintButtonOnClickingShowHintButton End");
	}

	@TestAnnotations(testID = "206")
	@Test(priority = 2, alwaysRun = true, groups = {
			"Regression" }, description = "ASMT206_VerifyDefaultShowHintButtonStatusOnNextQuizQuestion")
	public void ASMT206_VerifyDefaultShowHintButtonStatusOnNextQuizQuestion() throws Exception {
		log(logger, "ASMT206_VerifyDefaultShowHintButtonStatusOnNextQuizQuestion Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));

		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssesmentNameInAssessmentPage());

		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");

		log(logger, "Clicking on show hint button");
		quizBankPage.clickAssessmentShowHintButton();

		log(logger, "Verify Default Show Hint Button Status On Next Quiz Question");
		VerificationHandler.verifyTrue(quizBankPage.verifyDefaultShowHintButtonStatusOnAnsweredQuizPage(), "Unable to verify Default Show Hint Button Status On Next Quiz Question");
		log(logger, "ASMT206_VerifyDefaultShowHintButtonStatusOnNextQuizQuestion End");
	}

	@TestAnnotations(testID = "247")
	@Test(priority = 3, alwaysRun = true, groups = {
			"Regression" }, description = "ASMT247_Verify All Glossary List Is Displayed On Selected Glossary Filter Tab")
	public void ASMT247_VerifyAllGlossaryListIsDisplayedOnSelectedFilterTab() throws Exception {
		log(logger, "ASMT210_verifySelectedGlossaryContentAlignment Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));

		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssesmentNameInAssessmentPage());

		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");

		log(logger, "Clicking on show hint button");
		quizBankPage.clickAssessmentShowHintButton();

		log(logger, "Verifying the highgligted content in Quiz question");
		VerificationHandler.verifyTrue(quizBankPage.VerifyAllGlossaryListIsDisplayedOnSelectedFilterTab(),
				"Unable to verify Glossary content in Glossary pop up");

		log(logger, "ASMT247_VerifyAllGlossaryListIsDisplayedOnSelectedFilterTab End");
	}

	@TestAnnotations(testID = "383")
	@Test(priority = 4, alwaysRun = true, groups = {
			"Regression" }, description = "ASMT383_verifyAnswerChoicesAreNotScrambled")
	public void ASMT383_verifyAnswerChoicesAreNotScrambled() throws Exception {
		log(logger, "ASMT383_verifyRightClickActionOnQuizPage Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));

		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssesmentNameInAssessmentPage());

		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");

		log(logger, "Clicking on show hint button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAnswerChoicesAreNotScrambled(), "Unable to verify show hint button");

		log(logger, "ASMT383_verifyAnswerChoicesAreNotScrambled End");
	}

	@TestAnnotations(testID = "297")
	@Test(priority = 5, alwaysRun = true, groups = {
			"Regression" }, description = "ASMT297_verifyMouseRightClickOnQuizQuestionPage")
	public void ASMT297_verifyMouseRightClickOnQuizQuestionPage() throws Exception {
		log(logger, "ASMT297_verifyMouseRightClickOnQuizQuestionPage Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 0);

		log(logger, "Clicking Module by Name");
		quizBankPage.clickModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));

		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssesmentNameInAssessmentPage());

		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler.verifyTrue(quizBankPage.verifyAssessmentShowHintButton(),
				"Unable to verify Show Hint Button in Nurse Logic Page");

		log(logger, "Mouse Right click on Quiz question page");
		VerificationHandler.verifyTrue(quizBankPage.verifyMouseRightClickOnQuizQuestionPage(), "Unable to verify Mouse Right click on Quiz question page");
		log(logger, "ASMT297_verifyMouseRightClickOnQuizQuestionPage End");
	}
}
