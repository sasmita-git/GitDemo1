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
import com.automation.asmt.page.MyResultsPage;
import com.automation.asmt.page.TakeAssessmentPage;

public class AssessmentTest2 extends BaseTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private MyResultsPage myResultsPage;
	private TakeAssessmentPage takeAssessment;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		myResultsPage = new MyResultsPage(driver);
		takeAssessment = new TakeAssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test2.username"),
				PropertiesRepository.getString("asmt.test2.password"));
	}
	
	//@Test(priority = 1, alwaysRun = true, description = "ASMT-121:CAB Practice assessment functionality check")
	public void ASMT121_VerifyPracticeAssessmentFunctionality() throws Exception {
		logger.info("ASMT121_VerifyPracticeAssessmentFunctionality Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Verifying Precentage in IPP Page");
		homePage.verifyElement(PropertiesRepository.getString("asmt.myati.assessment.ipp.page.percentage.of.marks"));
		
		log(logger, "Verifying Time Spent in IPP Page");
		homePage.verifyElement(PropertiesRepository.getString("asmt.myati.assessment.ipp.page.time.spent"));
		
		log(logger, "Verifying Questions in IPP Page");
		homePage.verifyElement(PropertiesRepository.getString("asmt.myati.assessment.ipp.page.no.of.questions"));
		
		
		log(logger, "Clicking on close button in IPP Page");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		
		log(logger, "Clicking on My Results Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",2);
		
		log(logger, "Verifying Practice Assessemnt details in My Results Page");
		myResultsPage.verifyPracticeAssessmentTitle(0, "Custom:"+
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		log(logger, "Verifying Date Completed for Practice Assessment");
		myResultsPage.verifyPracticeAssessmentOtherHeadings(0, 1);
		
		log(logger, "Veriyfing Individual Score for Practice Assessment");
		myResultsPage.verifyPracticeAssessmentOtherHeadings(0, 2);
		
		log(logger, "Verifying Practice Time for Practice Assessment");
		myResultsPage.verifyPracticeAssessmentOtherHeadings(0, 3);
		
		log(logger, "Clicking on My Results Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Results Button");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.144.assessment.name"), true, "Results");
		
		log(logger, "Clicking on Frist Results Button in Card Back");
		assessmentPage.clickPractAssCardBackForResults(0);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Close button in Card Back of Results Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.myati.assessment.results.button.card.back.close.button"), 0);
		
		//homePage.waitForElementToBeClickable(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
		//assessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("asmt.myati.assessment.type"),PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
		
		logger.info("ASMT121_VerifyPracticeAssessmentFunctionality End");
	}
	
	//@Test(priority = 2, alwaysRun = true, description = "ASMT-145:ASMT-33:Verify if answers options are displayed for each multiple choice questions.")
	public void ASMT145_VerifyMultipleChoiceFeature() throws Exception {
		logger.info("ASMT145_VerifyMultipleChoiceFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT145_VerifyMultipleChoiceFeature End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-173:ASMT-1744: Validate the Drag and Drop functionality for Question - Answer Box.")
	public void ASMT173_VerifyDragNDropMovePosition() throws Exception {
		logger.info("ASMT173_VerifyDragNDropMovePosition Start");

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
				PropertiesRepository.getString("asmt.assessment.assessment.DragAndDrop"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.practice.assessment.with.rationale.value");
		
		log(logger, "completing section 1");
		assessmentPage.takeTestAnswerMovePosition(true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT173_VerifyDragNDropMovePosition End");
	}
	
	/**
	 * Step 5
	 * 	After selecting a question to different location, the order is changing. 
	 *  So, not automated.
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4, alwaysRun = true, description = "ASMT-183:ASMT-1778:Verify the cursor functionality for Drag and Drop Question - Answer Box.")
	public void ASMT183_VerifyDragNDropFeature() throws Exception {
		logger.info("ASMT183_VerifyDragNDropFeature Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Assessment Type");
		assessmentPage.clickAssessmentType(PropertiesRepository
				.getString("asmt.myati.practice.type"));
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Completing Assessment");
		assessmentPage.takeTestDND(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT183_VerifyDragNDropFeature End");
	}
	
	//@Test(priority = 5, alwaysRun = true, description = "ASMT-19:Practice Assessments>Complete Assessment Section actions")
	public void ASMT19_VerifyReturnToLastQuestionOption() throws Exception {
		logger.info("ASMT19_VerifyReturnToLastQuestionOption Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "completing section 1");
		assessmentPage.takeTestReturnToLastQuestion(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT19_VerifyReturnToLastQuestionOption End");
	}
	
}
