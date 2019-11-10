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

public class AssessmentTest extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test10.username"),
				PropertiesRepository.getString("asmt.test4.password"));
	}
	
	
	@Test(priority = 1, alwaysRun = true, description = "ASMT-269:Verify Continue Button is getting activated after unflaging for Drag and drop type question.")
	public void ASMT269_VerifyFlagDragAndDropFunctionality() throws Exception {
		logger.info("ASMT269_VerifyFlagDragAndDropFunctionality Start");

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
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));
		
	
		
		log(logger, "completing section 1");
		assessmentPage.takeTestWithFlagging(false, false, true, false);
		
		log(logger, "Completed Review and Flagged Questions");
		assessmentPage.takeTestWithUnFlag(false, false, true, false);
		
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		logger.info("ASMT269_VerifyFlagDragAndDropFunctionality End");
	}
	
	//@Test(priority = 2, alwaysRun = true, description = "ASMT-147:ASMT-33:Verify Continue button functionality")
	public void ASMT147_VerifyContinueButtonFunctionality() throws Exception {
		logger.info("ASMT147_VerifyContinueButtonFunctionality Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		log(logger, "Verifying Continue button functionality.");
		VerificationHandler.verifyTrue(assessmentPage.verifyAssessemntContinueButton(), "Unable to verify Assessment Continue button functionality");
		
		logger.info("ASMT147_VerifyContinueButtonFunctionality End");
	}
	
	//@Test(priority = 3, alwaysRun = true, description = "ASMT-146:ASMT-33:Verify if student user is able to select more than 2 answers.")
	public void ASMT146_VerifyMultipleAnswerFunctionality() throws Exception {
		logger.info("ASMT146_VerifyMultipleAnswerFunctionality Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		log(logger, "Verifying Multiple Answer functionality.");
		VerificationHandler.verifyTrue(assessmentPage.takeTestForMultipleAnswer(false, false, true, false), "Unable to verify Selecting Multiple Answer ");
		
		logger.info("ASMT146_VerifyMultipleAnswerFunctionality End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-181:ASMT-1744: Validate the Drag and Drop functionality from Question - Answer Box.")
	public void ASMT181_VerifyDragAndDropFunctionality() throws Exception {
		logger.info("ASMT181_VerifyDragAndDropFunctionality Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT181_VerifyDragAndDropFunctionality End");
	}
	
	//@Test(priority = 5, alwaysRun = true, description = "ASMT-184:ASMT-1744: Validate the Forward Navigation for Drag-Drop Question.")
	public void ASMT184_VerifyDragAndDropForwardFunctionality() throws Exception {
		logger.info("ASMT184_VerifyDragAndDropForwardFunctionality Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "completing section 1");
		VerificationHandler.verifyTrue(assessmentPage.takeTestDragAndDrop(false, false, true, false), "Unable to verify Drag and Drop Forward functionality");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT184_VerifyDragAndDropForwardFunctionality End");
	}
	
	@Test(priority = 6, alwaysRun = true, description = "ASMT-185:ASMT-1744: Validate the Backward Navigation for Drag-Drop Question.")
	public void ASMT185_VerifyDragAndDropBackwardFunctionality() throws Exception {
		logger.info("ASMT185_VerifyDragAndDropBackwardFunctionality Start");

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

		log(logger, "completing section 1");
		VerificationHandler.verifyTrue(assessmentPage.takeTestDragAndDropBackward(false, false, false, false),"Unable to verify Previous button for Drag N Drop");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT185_VerifyDragAndDropBackwardFunctionality End");
	}
	//@Test(priority = 7, alwaysRun = true, description = "Smoke P2  ASMT-138:Launch Practice assessment" )
	public void ASMT138_verifyLaunchPracticeAssessmentTest() throws Exception {
		logger.info("verifyLaunchPracticeAssessmentTest Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		logger.info("verifyLaunchPracticeAssessmentTest End");
	}
	//@Test(priority = 7, alwaysRun = true, description = "ASMT-205:ASMT-2232 Validate Previous button is disable on 1st quest,when user selects Review Flagged qust on")
	public void ASMT205_VerifyPreviousBtnFunctionality() throws Exception {
		logger.info("ASMT269_VerifyFlagDragAndDropFunctionality Start");

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
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
	
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
	
		
		log(logger, "completing section 1");
		assessmentPage.takeTestWithFlagging(false, false, true, false);
		
		log(logger, "Completed Review and Flagged Questions");
		VerificationHandler.verifyTrue(assessmentPage.takeTestWithUnFlagVerifyPreviousBtnFunc(false, false, true, false), "Unable to verify Previous Button");
		
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		logger.info("ASMT269_VerifyFlagDragAndDropFunctionality End");
	}
	
}
