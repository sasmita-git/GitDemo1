package com.automation.asmt.practice.assessment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.utils.UserCreationUtils;

public class AssessmentNewUserTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private UserCreationUtils userCreationUtils;
	private TextHandler textHandler;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		textHandler = new TextHandler(driver);
		assessmentPage = new AssessmentPage(driver);
		userCreationUtils = new UserCreationUtils();
	}

	@Test(priority = 1, alwaysRun = true, description = "ASMT-223:Verify Continue Assessment functionality for older in-complete assessment.")
	public void ASMT223_VerifyAssessmentTest() throws Exception {
		logger.info("ASMT223_VerifyAssessmentTest Start");

		String userId = userCreationUtils.getUserDetails();
		logger.info("userId --> "+ userId);
		loginPage.loginToApplication(userId, "Test123");
		
		//*******************************Add Product************************************		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.loc")), "Unable to verify Add Product Link");
		
		log(logger, "Adding Practice Assessment");
		log(logger, "Adding id ");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.id.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Adding pwd");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.pwd.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//*******************************Add Product************************************
		log(logger, "Completing 1 assessment for checking Recent Activity");
		assessmentPage.takeTest(false, true, false, false);
		
		log(logger, "Clicking on close button ");
		assessmentPage.clickOnCloseButton("asmt.question.assement.question.close.button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();
		
		log(logger, "Verifying Assessment button name");
		VerificationHandler.verifyTrue(assessmentPage.verifyPractiseAssessentButtonName(PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value")),"Assessment button name is not in Continue");
		
		log(logger, "Clicking on Practice Assessment on Continue Button");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		log(logger, "Completing 1 assessment for checking Recent Activity");
		VerificationHandler.verifyTrue(assessmentPage.takeTestNewUser(false, false, false, false), "Unable to complete after clicking on continue button");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");

		logger.info("ASMT223_VerifyAssessmentTest End");
	}

	//@Test(priority = 2, alwaysRun = true, description = "ASMT-23:Practice Assessment: Test Case")
	public void ASMT23_VerifyAssessmentTest() throws Exception {
		logger.info("ASMT23_VerifyAssessmentTest Start");

		String userId = userCreationUtils.getUserDetails();
		logger.info("userId --> "+ userId);
		loginPage.loginToApplication(userId, "Test123");
		
		//*******************************Add Product************************************		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.loc")), "Unable to verify Add Product Link");
		
		log(logger, "Adding Practice Assessment");
		log(logger, "Adding id ");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.id.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Adding pwd");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.pwd.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//*******************************Add Product************************************
		log(logger, "Completing 1 assessment for checking Recent Activity");
		assessmentPage.takeTestReturnQuestionNo(false, true, false, false);
		
		log(logger, "Clicking on close button ");
		assessmentPage.clickOnCloseButton("asmt.question.assement.question.close.button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();
		
		log(logger, "Verifying Assessment button name");
		VerificationHandler.verifyTrue(assessmentPage.verifyPractiseAssessentButtonName(PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value")),"Assessment button name is not in Continue");
		
		log(logger, "Clicking on Practice Assessment on Continue Button");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		logger.info("ASMT23_VerifyAssessmentTest End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-254:ASMT-2997:Verify if 'Timer' is displayed for CAB practice assessment.")
	public void ASMT254_VerifyTimerForCABAssessment() throws Exception {
		logger.info("ASMT254_VerifyTimerForCABAssessment Start");

		String userId = userCreationUtils.getUserDetails();
		logger.info("userId --> "+ userId);
		loginPage.loginToApplication(userId, "Test123");
		
		//*******************************Add Product************************************		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.loc")), "Unable to verify Add Product Link");
		
		log(logger, "Adding Practice Assessment");
		log(logger, "Adding id ");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.id.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Adding pwd");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.pwd.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//*******************************Add Product************************************
		
		log(logger, "Completing assessment for checking Timer");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifyTimeForCABAssessment(false, false, false, false), "Unable to complete after clicking on continue button");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT254_VerifyTimerForCABAssessment End");
	}
	
	//@Test(priority = 4, alwaysRun = true, description = "ASMT-222:Verify Continue Assessment functionality")
	public void ASMT222_VerifyContinueAssessmentFunctionality() throws Exception {
		logger.info("ASMT222_VerifyContinueAssessmentFunctionality Start");

		String userId = userCreationUtils.getUserDetails();
		logger.info("userId --> "+ userId);
		loginPage.loginToApplication(userId, "Test123");
		
		//*******************************Add Product************************************		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.loc")), "Unable to verify Add Product Link");
		
		log(logger, "Adding Practice Assessment");
		log(logger, "Adding id ");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.id.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Adding pwd");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.practice.assessment.sixquestions.no.rational.pwd.value"));
		log(logger, "Clicking on Continue button");
		homePage.clickButton(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//*******************************Add Product************************************
		
		log(logger, "completing Assessment");
		assessmentPage.takeTest(false, true, false, false);
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Practice Assessment ");
		VerificationHandler.verifyTrue(assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"),"CONTINUE"), "Unable to verify Button name");
		
		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT222_VerifyContinueAssessmentFunctionality End");
	}
	
	/*@Test(priority = 2, alwaysRun = true, description = "ASMT-165:ASMT-29:Verify Watermark while taking Practice Assessment")
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

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
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
*/}
