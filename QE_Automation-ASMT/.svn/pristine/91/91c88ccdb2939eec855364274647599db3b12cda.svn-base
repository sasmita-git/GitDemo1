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

public class AssessmentTest5 extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test5.username"),
				PropertiesRepository.getString("asmt.test5.password"));
	}

	
	@Test(priority = 1, alwaysRun = true, description = "ASMT-135:ASMT-34:Verify Conservation of Rationales section to Angular ")
	public void ASMT135_VerifyRationaleSectionFuncationality() throws Exception {
		logger.info("takeTestRationaleSectionFunctionality Start");

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

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestRationaleSectionFunctionality(false, false, true, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("takeTestRationaleSectionFunctionality End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-158:ASMT-39:Verify and convert completion modal on the practice assessment page for current ATI")
	public void ASMT158_VerifyLastSectionFuncationality() throws Exception {
		logger.info("ASMT158_VerifyLastSectionFuncationality Start");

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
		VerificationHandler.verifyTrue(assessmentPage.takeTestLastSectionFuncationality(false, false, false, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT158_VerifyLastSectionFuncationality End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-240:Only one rationale will be displayed(Correct/Incorrect)for multiple responses.")
	public void ASMT240_VerifyRationaleForMRQuestionType() throws Exception {
		logger.info("ASMT240_VerifyRationaleForMRQuestionType Start");

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

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestMRQuestionType(false, false, true, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT240_VerifyRationaleForMRQuestionType End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-251:ASMT-3059: Verify if user is able to select answer for Hot spot question,Even after submitting answe")
	public void ASMT251_VerifyHotSpotChangeImageFuncationality() throws Exception {
		logger.info("ASMT251_VerifyHotSpotChangeImageFuncationality Start");

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
		VerificationHandler.verifyTrue(assessmentPage.takeTestHotSpotChangeImage(false, false, false, false), "Unable to verify Flag for Different Quesiton");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT251_VerifyHotSpotChangeImageFuncationality End");
	}
}
