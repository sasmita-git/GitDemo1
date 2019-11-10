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
import com.jaca.TestAnnotations;

public class PracticeAssessmentTest extends BaseTest {
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
		takeAssessment =new TakeAssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test1.username"),
				PropertiesRepository.getString("asmt.test1.password"));
	}
	
	//@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "ASMT-144:ASMT-33:Verify if Question Text is displayed for all questions.")
	public void ASMT144_VerifyQuestion() throws Exception {
		log(logger, "ASMT144_VerifyQuestion Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Header");
		VerificationHandler.verifyTrue(assessmentPage.isTextDisplayed("asmt.question.assement.question.text.loc"),"Displayed text is not visible");
		
		log(logger, "ASMT144_VerifyQuestion End");
	}
	
	/**
	 * DB Verification is not implemented. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-159:ASMT -28:Verify functionality of 'FLAG' button:Verify functionality of 'FLAG' button in Practice Assessment as 'FLAG' button of the practice assessment page is converted from knockout to Angular.")
	public void ASMT159_VerifyFlagFuncationalityForPracticeAssessment()
			throws Exception {
		log(logger, "ASMT159_VerifyFlagFuncationalityForPracticeAssessment Start");
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		//assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Verifying the flag button");
		VerificationHandler.verifyTrue(assessmentPage.verifyFlag(false),
				"Unable to verify Flag button before clicking");
		VerificationHandler.verifyEquals(assessmentPage.getAttributeValue(PropertiesRepository
				.getString("asmt.generic.tutorial.flag.value"), "class"), PropertiesRepository.getString("asmt.myati.test.tab.default.flag.value"), "Unable to verify default flag value");

		log(logger, "Clicking the flag button");
		assessmentPage.verifyFlag(true);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.toast.msg");
		
		log(logger, "Verifying Flag value after clicking");
		VerificationHandler.verifyEquals(assessmentPage.getAttributeValue(PropertiesRepository
				.getString("asmt.generic.tutorial.flag.value"), "class"), PropertiesRepository.getString("asmt.myati.test.tab.orange.flag.value"), "Unable to verify default flag value");
		
		log(logger, "ASMT159_VerifyFlagFuncationalityForPracticeAssessment End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-49:Practice assessment IPP page download report feature")
	public void ASMT49_VerifyIPPPageDownloadFeature() throws Exception {
		logger.info("ASMT49_VerifyIPPPageDownloadFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on IPP Page Download Button");
		//assessmentPage.clickIPPPageDownloadButton();
		
		
		logger.info("ASMT49_VerifyIPPPageDownloadFeature End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-273:Verify recent activity section for completed assessment.")
	public void ASMT273_VerifyRecentActivity() throws Exception {
		logger.info("ASMT273_VerifyRecentActivity Start");

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

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		log(logger, "Clicking on Home Tab");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",0);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
	
		log(logger, "Verify Recent Activity Section");
		VerificationHandler.verifyTrue(homePage.verifyRecentActivityNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value")), "Unable to verify Recent Activity");
		
		logger.info("ASMT273_VerifyRecentActivity End");
	}
	
	@TestAnnotations(testID = " ASMT-150")
	//@Test(priority = 6, alwaysRun = true, description = "ASMT-33:Verify if previously entered answer is displayed.")
	public void ASMT150_VerifyPrevEnteredAnswerIsDispalyed() throws Exception {
		logger.info("ASMT150_VerifyPrevEnteredAnswerIsDispalyed Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		/*log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));*/
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));
		
		/*takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");*/
		
		log(logger, "Verifying Previous button and rationale option");
		assessmentPage.takeTestRationaleEnabledPreviousVerification(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT150_VerifyPrevEnteredAnswerIsDispalyed End");
	}
	
}
