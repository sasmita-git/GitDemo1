package com.automation.asmt.practice.assessment;

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
import com.automation.asmt.page.TakeAssessmentPage;

public class AssessmentTest8 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private TakeAssessmentPage takeAssessment;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		takeAssessment = new TakeAssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test8.username"),
				PropertiesRepository.getString("asmt.test8.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-312:Verify verbiage under CompletePostAssessmentSurvey button.")
	public void ASMT312_VerifyVerbiageCompletePostAssessmentSurvey() throws Exception {
		logger.info("ASMT312_VerifyVerbiageCompletePostAssessmentSurvey Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		log(logger, "Take Test for VerbiageCompletePostAssessmentSurvey");
		VerificationHandler.verifyTrue(assessmentPage.takeTestCompletePostAssessmentSurvey(false, false, true, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Take Test for Assessment Survey Completion");
		VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifySection(false, false, false, false), "Unable to verify Flag for Different Quesiton");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT312_VerifyVerbiageCompletePostAssessmentSurvey End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-285:Verify survey button in 'Completion pop up' if IsPostSurveyMandatory is true.")
	public void ASMT285_VerifySurveyButtonInCompletionPopup() throws Exception {
		logger.info("ASMT285_VerifySurveyButtonInCompletionPopup Start");
		//loginPage.loginToApplication("stagesmokea1", "Test123");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		log(logger, "Take Test for Post Assessment Survey Popup Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyCompletionPopup(false, false, true, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Take Test for Assessment Survey Completion");
		VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifySection(false, false, false, false), "Unable to verify Flag for Different Quesiton");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT285_VerifySurveyButtonInCompletionPopup End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-290:Verify Survey and Scoring when all questions are flagged, for survey is true assessment.")
	public void ASMT290_FlagAndVerifySurveyQuestionsCompletionPopup() throws Exception {
		logger.info("ASMT290_FlagAndVerifySurveyQuestionsCompletionPopup Start");
		//loginPage.loginToApplication("stagesmokea1", "Test123");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		log(logger, "Take Test for Post Assessment Survey Popup Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestFlagAllQuestion(false, false, false, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Take Test for Assessment Survey Completion");
		VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifySection(false, false, false, false), "Unable to verify Flag for Different Quesiton");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT290_FlagAndVerifySurveyQuestionsCompletionPopup End");
	}
}
