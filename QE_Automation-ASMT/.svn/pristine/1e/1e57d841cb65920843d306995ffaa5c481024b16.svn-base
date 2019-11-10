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

public class AssessmentTest11 extends BaseTest {

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
		//loginPage.loginToApplication("AutoUser23022018744", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test1.username"),
				PropertiesRepository.getString("asmt.test1.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-172:ASMT-1741Verify Multiple Select QuestionType functionality for Image media typeto display in Angular")
	public void ASMT172_VerifyMultipleSelectMedia() throws Exception {
		logger.info("ASMT172_VerifyMultipleSelectMedia Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Image Media Type Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "graphic"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT172_VerifyMultipleSelectMedia End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-174:ASMT-1741Verify Multiple Select QuestionType functionality for Audio media typeto display in Angular")
	public void ASMT174_VerifyMultipleSelectAudio() throws Exception {
		logger.info("ASMT174_VerifyMultipleSelectAudio Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Audio Media Type Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "audio"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT174_VerifyMultipleSelectAudio End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-175:ASMT-1741:Verify Multiple Select QuestionType functionality for video mediatypeto display in Angular")
	public void ASMT175_VerifyMultipleSelectVideo() throws Exception {
		logger.info("ASMT175_VerifyMultipleSelectVideo Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Video Media Type Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "audio"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT175_VerifyMultipleSelectVideo End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-177:ASMT-1742Verify Fill IntheBlank QuestionType functionality for Image media typeto display in Angular")
	public void ASMT177_VerifyFillInTheBlanksMedia() throws Exception {
		logger.info("ASMT177_VerifyFillInTheBlanksMedia Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Image Media Type Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "graphic"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT177_VerifyFillInTheBlanksMedia End");
	}
	
	@Test(priority = 5, alwaysRun = true, description = "ASMT-178:ASMT-1742:Verify Fill IntheBlank QuestionType functionality for AudioMedia typeto display in Angular")
	public void ASMT178_VerifyFillInTheBlanksAudio() throws Exception {
		logger.info("ASMT178_VerifyFillInTheBlanksAudio Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Audio Media Type Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "audio"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT178_VerifyFillInTheBlanksAudio End");
	}
	
	@Test(priority = 6, alwaysRun = true, description = "ASMT-179:ASMT-1742:Verify Fill IntheBlank QuestionType functionality for VideoMedia typeto display in Angular")
	public void ASMT179_VerifyFillInTheBlanksVideo() throws Exception {
		logger.info("ASMT179_VerifyFillInTheBlanksVideo Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.graphic.value"));

		log(logger, "Take Test for Video Media Type Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestGraphicQuestionType(false, false, true, false, "audio"), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT179_VerifyFillInTheBlanksVideo End");
	}
}
