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

public class AssessmentTest9 extends BaseTest {

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
		//loginPage.loginToApplication("AutoUser23022018496", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test9.username"),
				PropertiesRepository.getString("asmt.test9.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-140:ASMT-31:Verify if correct question number appears in question number section.")
	public void ASMT140_VerifyCorrectQuestionNumber() throws Exception {
		logger.info("ASMT140_VerifyCorrectQuestionNumber Start");
		
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
		
		log(logger, "Verifying correct end question number");
		VerificationHandler.verifyTrue(takeAssessment.verifyEndQuestionNumber(PropertiesRepository.getInt("asmt.practice.assessment.sixquestions.no.rational.maxquestions.value")));
		
		logger.info("ASMT140_VerifyCorrectQuestionNumber End");
		
	}
	
	@Test(priority = 2, alwaysRun = true, description = " ASMT-141:ASMT-31:Verify if correct question number appears in question number section., for flagged ques")
	public void ASMT141_VerifyFirstAndSecondQuestionNo() throws Exception {
		logger.info("ASMT141_VerifyFirstAndSecondQuestionNo Start");
		
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
		
		log(logger, "Verify if correct question number appears in question number section");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyQuestionNo(false, false, false, false), "Unable to verify First and second Quesiton No");

		logger.info("ASMT141_VerifyFirstAndSecondQuestionNo End");
		
	}
	
	@Test(priority = 3, alwaysRun = true, description = " ASMT-143:ASMT-31:Verify if correct question number appears in question number section for final questions")
	public void ASMT143_VerifyLastQuestionNumber() throws Exception {
		logger.info("ASMT143_VerifyLastQuestionNumber Start");
		
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
		
		log(logger, "Verify if correct question number appears in question number section for flagged question");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyLastQuestionNo(false, false, false, false), "Unable to verify last Quesiton No");

		logger.info("ASMT143_VerifyLastQuestionNumber End");
		
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-154:ASMT-35:Verify if 'Incorrect' image is displayed beside of all incorrect option, when user selects")
	public void ASMT154_VerifyIncorrectImageDisplayed() throws Exception {
		logger.info("ASMT154_VerifyIncorrectImageDisplayed Start");
		
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
		
		log(logger, "Verify if 'Incorrect' image is displayed");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyImage(false, false, true, false, false), "Unable to verify that 'Incorrect' image displayed");

		logger.info("ASMT154_VerifyIncorrectImageDisplayed End");
		
	}
	
	@Test(priority = 5, alwaysRun = true, description = "ASMT-157:ASMT-35:Verify 'InCorrect' image is displayed, when user have selected 1 correct answer for MR")
	public void ASMT157_VerifyIncorrectImageDisplayedForOneCorrect() throws Exception {
		logger.info("ASMT157_VerifyIncorrectImageDisplayedForOneCorrect Start");
		
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
		
		log(logger, "Verify if 'Incorrect' image is displayed when user have selected 1 correct answer");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyImage(false, false, true, false, true), "Unable to verify that 'Incorrect' image displayed when user have selected 1 correct answer");

		logger.info("ASMT157_VerifyIncorrectImageDisplayedForOneCorrect End");
		
	}
	
}
