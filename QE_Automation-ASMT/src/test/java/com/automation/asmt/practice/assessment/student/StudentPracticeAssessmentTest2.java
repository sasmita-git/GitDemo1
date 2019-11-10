package com.automation.asmt.practice.assessment.student;

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

public class StudentPracticeAssessmentTest2 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);

		/*loginPage.loginToApplication(
				PropertiesRepository.getString("asmt.username"),
				PropertiesRepository.getString("asmt.password"));*/
		
		loginPage.loginToApplication("studno1","A123456");
	}
	
	/**
	 * Rational off
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-186:ASMT-37:Verify Previous/Continue buttons functionality in Angular")
	public void ASMT186_VerifyContinueButtonFunctionalityRatinaloff() throws Exception {
		log(logger, "ASMT186_VerifyContinueButtonFunctionalityRatinaloff Start");
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
			"Item Type Regression Test (OP)");

		log(logger, "verifying the previous button is not present for the assement");
		 VerificationHandler.verifyFalse(assessmentPage.verifyAndClickPrevious(false));

		log(logger, "clicking the contiunue button");
		assessmentPage.verifyAndClickCountinue(true);
		
		log(logger,"verifiy the error messgae");
		VerificationHandler.verifyTrue(assessmentPage.verifyMessage("Please submit an answer or flag the question to continue.", PropertiesRepository.getString("asmt.question.unsweredpopup.loc")));
		log(logger, "ASMT186_VerifyContinueButtonFunctionalityRatinaloff End");
	}
	
	//@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-19:Practice Assessments>Complete Assessment Section actions")
	public void ASMT19_VerifyCompletePracticeAssessment() throws Exception {
		logger.info("ASMT19_VerifyCompletePracticeAssessment Start");
		log(logger, "ASMT19_VerifyCompletePracticeAssessment Start");
		
		homePage.clickOnMyAtiTab();
		homePage.waitUntillLoadingImageIsDisplayed(2);
		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
			"Test of Essential Academic Skills Online Practice V A");
		
		assessmentPage.takeTest(true, false, false, true);
		
		log(logger, "ASMT19_VerifyCompletePracticeAssessment End");
		logger.info("ASMT19_VerifyCompletePracticeAssessment End");
	}
	
	@Test(priority =3, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-144:ASMT-33:Verify if Question Text is displayed for all questions.")
	public void ASMT144_VerifyQuestionTextforAllQuestion() throws Exception {
		log(logger, "ASMT144_VerifyQuestionTextforAllQuestion Start");
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Header");
		boolean status=assessmentPage.isTextDisplayed("asmt.question.assement.question.text.loc");
		VerificationHandler.verifyTrue(status,"Displayed text is not visible");
		log(logger, "ASMT144_VerifyQuestionTextforAllQuestion End");
	}
	
	@Test(priority = 4, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-145:ASMT-33:Verify if answers options are displayed for each multiple choice questions.")
	public void ASMT145_VerifyQuestionAnswersForAllQuestion() throws Exception {
		log(logger, "ASMT145_VerifyQuestionAnswersForAllQuestion Start");
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Header");
		boolean status=assessmentPage.verifyQutionOptions("asmt.generic.tutorial.radio.button.loc");
		VerificationHandler.verifyTrue(status,"options are not displyed for the questions");
		log(logger, "ASMT145_VerifyQuestionAnswersForAllQuestion End");
	}
	
	@Test(priority = 5, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-146:ASMT-33:Verify if student user is able to select more than 2 answers.")
	public void ASMT146_VerifyUserisAbletoSelectMoreThanTwoAnswers() throws Exception {
		log(logger, "ASMT146_VerifyUserisAbletoSelectMoreThanTwoAnswers Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Verifying user is able to select more than one option");
		boolean status=assessmentPage.clickAndVerifySelectedOptions("asmt.generic.tutorial.radio.button.loc");
		VerificationHandler.verifyTrue(status,"two options are selected for the single question");
		
		log(logger, "ASMT146_VerifyUserisAbletoSelectMoreThanTwoAnswers End");
	}
	
	@Test(priority =6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-147:ASMT-33:Verify Continue button functionality.")
	public void ASMT147_VerifyContinueButtonFunctionality() throws Exception {
		log(logger, "ASMT147_VerifyContinueButtonFunctionality Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "verify Continue button functionality");
		boolean status=assessmentPage.isContinuButtonDisplayed("asmt.generic.tutorial.continue.loc");
		VerificationHandler.verifyTrue(status,"continue button is not enable");
		
		boolean result=assessmentPage.verifyContinueButtonFunctionality();
		VerificationHandler.verifyTrue(result,"continue button is not enable");
		
		log(logger, "ASMT147_VerifyContinueButtonFunctionality End");
	}
	
	@Test(priority = 7, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-170:ASMT-1740:Disabling the cursor when the mouser is hovered over the radio buttons")
	public void ASMT170_VerifyTheCursorStatusWhenMouseOverOnRadioButton() throws Exception {
		log(logger, "ASMT170_VerifyTheCursorStatusWhenMouseOverOnRadioButton Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		boolean result=assessmentPage.verifyQuestionType();
		VerificationHandler.verifyTrue(result,"continue button is not enable");
		
		log(logger, "ASMT170_VerifyTheCursorStatusWhenMouseOverOnRadioButton End");
	}
	
	//@Test(priority = 8, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-205:ASMT-2232 Validate Previous button is disable on 1st quest,when user selects Review Flagged qust on.")
	public void ASMT205_ValidatePreviousButtonForFirstQuestion() throws Exception {
		log(logger, "ASMT205_ValidatePreviousButtonForFirstQuestion Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "click on flag button");
		assessmentPage.clickOnFlagButton();
		
		log(logger, "verifying previous button status");
		boolean result1=assessmentPage.verifyPreviousButton("asmt.generic.tutorial.previous.loc");
		VerificationHandler.verifyTrue(result1,"previous button is  enable");
		
		log(logger, "ASMT205_ValidatePreviousButtonForFirstQuestion End");
	}
	
	//@Test(priority = 9, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-222:Verify Continue Assessment functionality.")
	public void ASMT222_VerifyContinueAssessmentFunctionality_old() throws Exception {
		log(logger, "ASMT222_VerifyContinueAssessmentFunctionality Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "select the question");
		assessmentPage.selectOrFlagTheQuestion();
		
		log(logger, "Clicking on close button ");
		assessmentPage.clickOnCloseButton("asmt.question.assement.question.close.button");
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "click on flag button");
		assessmentPage.clickOnFlagButton();
		log(logger, "verifying previous button status");
		
		boolean result1=assessmentPage.verifyDownloadPage("asmt.generic.tutorial.viewresult.loc");
		VerificationHandler.verifyTrue(result1,"previous button is  enable");
		
		log(logger, "ASMT222_VerifyContinueAssessmentFunctionality End");
	}
	
	@Test(priority = 10, alwaysRun = true, groups = { "Smoke" }, description = " ASMT-222:Verify Continue Assessment functionality.")
	public void ASMT222_VerifyContinueAssessmentFunctionality() throws Exception {
		log(logger, "ASMT222_VerifyContinueAssessmentFunctionality Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabValue(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"MasterAssessment1", true, "CONTINUE");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, true, true, false);
		
		log(logger, "Clicking on close button ");
		assessmentPage.clickOnCloseButton("asmt.question.assement.question.close.button");
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"MasterAssessment1", true, "CONTINUE");
		
		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		/*log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Item Type Regression Test (OP)", true, "BEGIN");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "click on flag button");
		assessmentPage.clickOnFlagButton();
		log(logger, "verifying previous button status");
		
		boolean result1=assessmentPage.verifyDownloadPage("asmt.generic.tutorial.viewresult.loc");
		VerificationHandler.verifyTrue(result1,"previous button is  enable");*/
		
		log(logger, "ASMT222_VerifyContinueAssessmentFunctionality End");
	}
}
