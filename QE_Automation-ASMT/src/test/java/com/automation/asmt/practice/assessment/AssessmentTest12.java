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

public class AssessmentTest12 extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test3.username"),
				PropertiesRepository.getString("asmt.test3.password"));
	}

	
	//@Test(priority = 1, alwaysRun = true, description = "ASMT-275:Validate the previous button functionality for Drag-Drop Question.")
	public void ASMT275_VerifyDNDPreviousFuncationality() throws Exception {
		logger.info("ASMT275_VerifyDNDPreviousFuncationality Start");
		
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

		log(logger, "Take Test for Post Assessment Survey Popup Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestDNDPreviousFunctionality(false, false, false, false), "Unable to verify Previous funcationality for DND");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT275_VerifyDNDPreviousFuncationality End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-208:ASMT-2344: Verify if front and back arrow key from keyboard functionality without rationalise")
	public void ASMT208_VerifyKeyBoardForRationaleAssessment() throws Exception {
		logger.info("ASMT39_VerifyKeyBoardForRationaleAssessment Start");
		
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

		log(logger, "Take Keyboard functionality for rationale assessment ");
		VerificationHandler.verifyTrue(assessmentPage.takeTestKeyBoardForRationale(false, false, false, false), "Unable to verify Previous funcationality for DND");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT39_VerifyKeyBoardForRationaleAssessment End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-266:Verify if students is able to change questions in the background, when pauser is on")
	public void ASMT266_VerifyKeyBoardWhenPauseEnabled() throws Exception {
		logger.info("ASMT266_VerifyKeyBoardWhenPauseEnabled Start");
		
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

		log(logger, "Take Keyboard functionality for rationale assessment ");
		VerificationHandler.verifyTrue(assessmentPage.takeTestKeyBoardForPauseEnabled(false, false, false, false), "Unable to verify Previous funcationality for DND");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT266_VerifyKeyBoardWhenPauseEnabled End");
	}
	
	//@Test(priority = 4, alwaysRun = true, description = "ASMT-267:Verify 'UnAnswered' pop up.")
	public void ASMT267_VerifyUnAsweredPopup() throws Exception {
		logger.info("ASMT267_VerifyUnAsweredPopup Start");
		
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

		log(logger, "Take Keyboard functionality for rationale assessment ");
		VerificationHandler.verifyTrue(assessmentPage.takeTestUnAsweredPopup(false, false, false, false), "Unable to verify Previous funcationality for DND");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT267_VerifyUnAsweredPopup End");
	}
	
	@Test(priority = 5, alwaysRun = true, description = "ASMT-267:Verify 'UnAnswered' pop up.")
	public void ASMT380_VerifyDNDOutsideDropBox2() throws Exception {
		logger.info("ASMT380_VerifyDNDOutsideDropBox2 Start");
		
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

		log(logger, "Take Keyboard functionality for rationale assessment ");
		VerificationHandler.verifyTrue(assessmentPage.takeTestDNDOutsideDropBox2(false, false, false, false), "Unable to verify Previous funcationality for DND");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT380_VerifyDNDOutsideDropBox2 End");
	}
	
}
