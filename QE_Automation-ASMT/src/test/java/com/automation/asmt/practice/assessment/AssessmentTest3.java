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

public class AssessmentTest3 extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test3.username"),
				PropertiesRepository.getString("asmt.test3.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-275:Validate the previous button functionality for Drag-Drop Question.")
	public void ASMT275_VerifyDragAndDropPreviousFunctionality() throws Exception {
		logger.info("ASMT275_VerifyDragAndDropPreviousFunctionality Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Drag And Drop Previous Funcationality");
		assessmentPage.takeTestDragNDropPrevFuncationality(false, false, false, false);

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT275_VerifyDragAndDropPreviousFunctionality End");
	}

	@Test(priority = 2, alwaysRun = true, description = "ASMT-231:FNB Numeric Question: The Answer text box should accept upto 20 numbers(upto 19 numbers+1 decimal)19")
	public void ASMT231_VerifyTextBoxValidation() throws Exception {
		logger.info("ASMT231_VerifyTextBoxValidation Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestTextBoxValidation(false, false, false, false), "Unable to complete text box validation");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT231_VerifyTextBoxValidation End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-160:ASMT -28:Verify 'FLAG' functionality by flaging diff question.")
	public void ASMT160_VerifyFlagForDiffQuestion() throws Exception {
		logger.info("ASMT160_VerifyFlagForDiffQuestion Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestFlagForDiffQuestion(false, false, false, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT160_VerifyFlagForDiffQuestion End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-148:ASMT-33-:Verify rationale field functionality")
	public void ASMT148_VerifyRationaleFieldFuncationality() throws Exception {
		logger.info("ASMT148_VerifyRationaleFieldFuncationality Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestRationaleFieldFunctionality(false, false, true, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT148_VerifyRationaleFieldFuncationality End");
	}
}
