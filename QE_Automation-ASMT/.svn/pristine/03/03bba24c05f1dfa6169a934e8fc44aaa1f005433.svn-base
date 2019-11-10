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

public class AssessmentTest4 extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test4.username"),
				PropertiesRepository.getString("asmt.test4.password"));
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-139:ASMT-31:Verify if 'Question' field is displayed")
	public void ASMT139_VerifyQuestionsDisplayed() throws Exception {
		logger.info("ASMT139_VerifyQuestionsDisplayed Start");

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

		log(logger, "Take Test for Question text for all assessemnts Funcationality");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyQuestionForAllAssessments(false, false, false, false), "Unable to verify Questions for all assessments");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT139_VerifyQuestionsDisplayed End");
	}

	@Test(priority = 2, alwaysRun = true, description = "ASMT-165:ASMT-29:Verify Watermark while taking Practice Assessment")
	public void ASMT165_VerifyWaterMarkForAllQuestions() throws Exception {
		logger.info("ASMT165_VerifyWaterMarkForAllQuestions Start");

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

		log(logger, "Take Test for Water mark Funcationality");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyWaterMarkForAllQuestion(false, false, false, false), "Unable to verify water mark for all assessments");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT165_VerifyWaterMarkForAllQuestions End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-230:FNB Numeric Question :User should be able to key in decimal along with with numbers in the Text Box")
	public void ASMT230_VerifyTextBoxDecimalValidation() throws Exception {
		logger.info("ASMT230_VerifyTextBoxDecimalValidation Start");

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

		takeAssessment.completeContinueStateAssessmentFull(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Take Test for Text Box Validation");
		VerificationHandler.verifyTrue(assessmentPage.takeTestTextBoxDecimalValidation(false, false, false, false), "Unable to verify decimal value for text box");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT230_VerifyTextBoxDecimalValidation End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-142:ASMT-31:Verify if correct question number appears in question number section for continued ques.")
	public void ASMT142_VerifyQuestionNoSection() throws Exception {
		logger.info("ASMT142_VerifyQuestionNoSection Start");

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
		VerificationHandler.verifyTrue(assessmentPage.takeTestTextBoxDecimalValidation(false, false, false, false), "Unable to verify decimal value for text box");

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT142_VerifyQuestionNoSection End");
	}
	
	@Test(priority = 5, alwaysRun = true, description = "ASMT-274:Verify recent activity section for in-completed assessment.")
	public void ASMT274_VerifyRecentActivity() throws Exception {
		logger.info("ASMT274_VerifyRecentActivity Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		//assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Completing 1 assessment for checking Recent Activity");
		assessmentPage.takeTest(false, true, false, false);
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		log(logger, "Clicking on Home Tab");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",0);
	
		log(logger, "Verify Recent Activity Section");
		VerificationHandler.verifyTrue(homePage.verifyRecentActivityNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value")), "Unable to verify Recent Activity");
		
		logger.info("Completing Assessment  which is left in middle for verifying Recent Activity");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "completing all assessment after verifying Recent Activiyt");
		assessmentPage.takeTest(false, false, false, false);
		
		logger.info("Completing Assessment  which is left in middle for verifying Recent Activity");
		logger.info("ASMT274_VerifyRecentActivity End");
	}
}
