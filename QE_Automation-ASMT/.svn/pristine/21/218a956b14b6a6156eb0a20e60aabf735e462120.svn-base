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

public class AssessmentTest10 extends BaseTest {

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
		//loginPage.loginToApplication("AutoUser09032018882", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test10.username"),
				PropertiesRepository.getString("asmt.test10.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-404:Verify user is not able to change the answers on DragAndDrop questions after submitting the answers.")
	public void ASMT404_VerifyDragAndDropPrevFunctionality() throws Exception {
		logger.info("ASMT404_VerifyDragAndDropPrevFunctionality Start");
		
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

		log(logger, "Take Test for Drag and drop with Previous func");
		VerificationHandler.verifyTrue(assessmentPage.takeTestDragAndDropPrevFunctionality(false, false, true, false), "Unable to verify Drag and drop with Previous functionality");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT404_VerifyDragAndDropPrevFunctionality End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-161:ASMT -28:Verify flag button functionality on clicking review flag question.")
	public void ASMT161_VerifyFlagTwoFunctionality() throws Exception {
		logger.info("ASMT256_VerifyFlagFunctionality Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
	
		log(logger, "Testing Flagging Functionality");
		VerificationHandler.verifyTrue(assessmentPage.takeTestWithTwoFlagFunctionality(false, false, false, false), "Unable to flag and verify button values in last section");
		
		log(logger, "Completed Review and Flagged Questions");
		VerificationHandler.verifyTrue(assessmentPage.takeTestWithUnFlagFuncationality(false, false, false, false),"Unable to verify UnFlag functionality");
		
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		logger.info("ASMT256_VerifyFlagFunctionality End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-277:ASMT-3575:Verify unchecking answers functionality for flagged MR questions.")
	public void ASMT277_VerifyFlagFunctionalityForMRQuestions() throws Exception {
		logger.info("ASMT277_VerifyFlagFunctionalityForMRQuestions Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
	
		log(logger, "Testing Flagging Functionality for MR Questions");
		VerificationHandler.verifyTrue(assessmentPage.takeTestFlagFunctionalityForMRQuestion(false, false, false, false), "Unable to flag and verify button values in last section");
		
		log(logger, "Completed Review and Flagged for MR Questions");
		VerificationHandler.verifyTrue(assessmentPage.takeTestWithUnFlagFuncationality(false, false, false, false),"Unable to verify UnFlag functionality");
		
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		logger.info("ASMT277_VerifyFlagFunctionalityForMRQuestions End");
	}
}
