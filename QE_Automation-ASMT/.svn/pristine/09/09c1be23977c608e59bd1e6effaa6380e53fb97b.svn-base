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

public class AssessmentTest6 extends BaseTest {

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
		// loginPage.loginToApplication(PropertiesRepository.getString("asmt.username"),PropertiesRepository.getString("asmt.password"));
		//loginPage.loginToApplication("AutoUser23022018511", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test6.username"),
				PropertiesRepository.getString("asmt.test6.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-241:User should be able to change the answers on Drag and Drop questions after submitting the answers.")
	public void ASMT241_VerifyDragAndDropReverseFuncationality() throws Exception {
		logger.info("ASMT241_VerifyDragAndDropReverseFuncationality Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestForDragNDropReverseFunctinoality(false, false, false, false), "Unable to verify Drag and Drop reverse functionality. ");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT241_VerifyDragAndDropReverseFuncationality End");
	}
	
	/**
	 * Completed only Non Rationale verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2, alwaysRun = true, description = "ASMT-255:ASMT-2871:Verify Removal of Submit answer button from Practice Assessments")
	public void ASMT255_VerifyContinueFuncationalityforNonRationaleAssessment() throws Exception {
		logger.info("ASMT255_VerifyContinueFuncationalityforNonRationaleAssessment Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestContinueFuncationalityforNonRationaleAssessment(false, false, false, false), "Unable to Continue Funcationality for non rationale assessment ");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT255_VerifyContinueFuncationalityforNonRationaleAssessment End");
	}
	
	/**
	 * Completed only Non Rationale verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3, alwaysRun = true, description = "ASMT-267:Verify 'UnAnswered' pop up.")
	public void ASMT267_VerifyUnAnsweredPopup() throws Exception {
		logger.info("ASMT267_VerifyUnAnsweredPopup Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Verifying Un Answered Popup.");
		VerificationHandler.verifyTrue(assessmentPage.takeTestToVerifyUnAnsweredPopup(false, false, false, false), "Unable to verify UnAnswered Popup");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT267_VerifyUnAnsweredPopup End");
	}
	
	
	/**
	 * Completed only Non Rationale verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4, alwaysRun = true, description = "ASMT-225:Student should not be able to click outside the 'Question Unanswered' pop up window.")
	public void ASMT225_VerifyUnAnsweredPopupClickOutside() throws Exception {
		logger.info("ASMT225_VerifyUnAnsweredPopupClickOutside Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Verifying Un Answered Popup.");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyUnAnsweredPopupNotClosed(false, false, false, false), "Unable to verify UnAnswered Popup after clicking outside");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT225_VerifyUnAnsweredPopupClickOutside End");
	}
	
	/**
	 * Completed only Non Rationale verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5, alwaysRun = true, description = "ASMT-268:Verify 'Assessment Completed' pop up, if assessment has flagged questions.")
	public void ASMT268_VerifyAssessmentComplForFlaggedQuestions() throws Exception {
		logger.info("ASMT268_VerifyAssessmentComplForFlaggedQuestions Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Verifying Un Answered Popup.");
		VerificationHandler.verifyTrue(assessmentPage.takeTestFlaggedQuestionWithFinalizeAndViewResults(false, false, false, false), "Unable to verify UnAnswered Popup after clicking outside");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT268_VerifyAssessmentComplForFlaggedQuestions End");
	}
	
}
