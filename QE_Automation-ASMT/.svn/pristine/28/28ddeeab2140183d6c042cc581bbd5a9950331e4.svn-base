package com.automation.asmt.practice.assessment;

import java.util.Calendar;

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
import com.automation.asmt.utils.CommonUtils;

public class AssessmentTest1  extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test1.username")
				,PropertiesRepository.getString("asmt.test1.password"));
	}
	
	/**
	 * Unable to take text box response. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, description = "ASMT-231:FNB Numeric Question: The Answer text box should accept upto 20 numbers(upto 19 numbers+1 decimal)19")
	public void ASMT231_VerifyTextBoxMaxValueFunctionality() throws Exception {
		logger.info("ASMT231_VerifyTextBoxMaxValueFunctionality Start");

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
		assessmentPage.takeTestPreviousRationaleTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		logger.info("ASMT231_VerifyTextBoxMaxValueFunctionality End");
	}
	
	//@Test(priority = 2, alwaysRun = true, description = "ASMT-19:Practice Assessments>Complete Assessment Section actions")
	public void ASMT19_VerifyPracticeAssessmentsCompleteAssessmentSectionactions() throws Exception {
		logger.info("ASMT19_VerifyPracticeAssessmentsCompleteAssessmentSectionactions Start");

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
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		log(logger, "Clicking on Go to ");
		assessmentPage.takeTestWithUnFlagWithContinue(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT19_VerifyPracticeAssessmentsCompleteAssessmentSectionactions End");
	}
	

	@Test(priority = 3, alwaysRun = true, description = "ASMT-226:ASMT-2653-Verify if while taking assessment student see marked question after submitting question.")
	public void ASMT226_VerifyRationaleFeature() throws Exception {
		logger.info("ASMT226_VerifyRationaleFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.rationale.value"));

		log(logger, "Completing Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestRationaleFeature(false, false, true, false), "Unable to verify Rationale for assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT226_VerifyRationaleFeature End");
	}
	
	//@Test(priority = 4, alwaysRun = true, description = "ASMT-166:ASMT-1762:Verify Pause time Modal window for Practice Assessment")
	public void ASMT166_VerifyPauseFeature() throws Exception {
		logger.info("ASMT166_VerifyPauseFeature Start");

		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
//		log(logger, "Verifying Assessment Header");
//		assessmentPage.verifyAssessmentHeader(1,"Custom: "+
//				PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		assessmentPage.switchToAssessmentFrameHandler();
		
		log(logger, "Verifying Pause Button. ");
		VerificationHandler.verifyTrue(
				assessmentPage.verifyAssessmentPauseButton(false),
				"Unable to verify Pause Button");

		log(logger, "Clicking on Pause Button");
		assessmentPage.verifyAssessmentPauseButton(true);

		log(logger, "Verifying Pause Button Header Message");
		assessmentPage.verifyPauseButtonHeaderMessage();

		log(logger, "Verifying Pause Popup Resume Assessment Button");
		VerificationHandler.verifyTrue(
				assessmentPage.verifyPauseButtonResumeAssessmentButton(false),
				"Unable to verify Resume Assessment Button");

		log(logger, "Clicking on Esc Button");
		assessmentPage.clickEscButton();

		log(logger, "Verifying Pause Popup Resume Assessment Button");
		VerificationHandler.verifyTrue(
				assessmentPage.verifyPauseButtonResumeAssessmentButton(false),
				"Pause Button is not displayed");

		log(logger, "Clicking on Resume Assessment Button");
		assessmentPage.verifyPauseButtonResumeAssessmentButton(true);

		log(logger, "Getting Pause time in screen");
		Calendar pauseTimeInScreen = assessmentPage
				.getPauseTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));
		assessmentPage.waitUntillLoadingImageIsDisplayed(4);
		
		log(logger, "Clicking on Pause Button");
		assessmentPage.verifyAssessmentPauseButton(true);
		
		
		log(logger, "Getting Pause time in Pause Popup");
		Calendar pauseTimeFromPopup = assessmentPage
				.getPauseTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));

		log(logger, "Verifying Time difference.");
		CommonUtils.compareCalendar(
				pauseTimeInScreen, pauseTimeFromPopup);

		log(logger, "Clicking on Resume Assessment Button");
		VerificationHandler.verifyTrue(assessmentPage.verifyPauseButtonResumeAssessmentButton(true),"Unable to click on Resume Assessment button");

		
		logger.info("ASMT166_VerifyPauseFeature End");
	}
	
	//@Test(priority = 5, alwaysRun = true, description = "ASMT-170:ASMT-1740:Disabling the cursor when the mouser is hovered over the radio buttons")
	public void ASMT170_VerifyMouseHoverFeature() throws Exception {
		logger.info("ASMT170_VerifyMouseHoverFeature Start");

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
		
		log(logger, "Verifying Assessment Header");
		//assessmentPage.verifyAssessmentHeader(1,PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestMouseHoverFeature(false, false, true, false), "Unable to verify Mouse Hover functionality");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT170_VerifyMouseHoverFeature End");
	}
	
	//@Test(priority = 6, alwaysRun = true, description = "ASMT-171:ASMT 1739:Verify pointer should be disabled on FLAG icon, when the FLAG icon is set to off/disable")
	public void ASMT171_VerifyFlagFeature() throws Exception {
		logger.info("ASMT171_VerifyFlagFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		/*log(logger, "Verifying Assessment Header");
		//assessmentPage.verifyAssessmentHeader(1,PropertiesRepository.getString("asmt.assessment.144.assessment.name"));
*/
		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestFlagFeature(false, false, false, false), "Unable to verify flag hovering");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT171_VerifyFlagFeature End");
	}
	
	//@Test(priority = 7, alwaysRun = true, description = "ASMT-176:ASMT-1741:Verify Multiple Select QuestionType functionality for Text mediatype to display in Angular")
	public void ASMT176_VerifyPreviousContinueButtonFeature() throws Exception {
		logger.info("ASMT176_VerifyPreviousContinueButtonFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		log(logger, "Verifying Assessment Header");
		//assessmentPage.verifyAssessmentHeader(1,PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestPrevContFeature(false, false, false, false), "Unable to verify Previous Continus Button and Rationale feature for Assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT176_VerifyPreviousContinueButtonFeature End");
	}
	
	//@Test(priority = 8, alwaysRun = true, description = "ASMT-180:ASMT-1742:Verify Fill IntheBlank QuestionType functionality for TextMedia typeto display in Angular")
	public void ASMT180_VerifyPreviousContinueButtonForTextBoxFeature() throws Exception {
		logger.info("ASMT180_VerifyPreviousContinueButtonForTextBoxFeature Start");

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
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Header");
		//assessmentPage.verifyAssessmentHeader(1,PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestPrevContForTxtBoxFeature(false, false, true, false), "Unable to verify Previous Continus Button and Rationale feature for Assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT180_VerifyPreviousContinueButtonForTextBoxFeature End");
	}
	
	//@Test(priority = 9, alwaysRun = true, description = "ASMT-182:Verify the Hotspot question type to display in Angular")
	public void ASMT182_VerifyHotSpotFeature() throws Exception {
		logger.info("ASMT182_VerifyHotSpotFeature Start");

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
		VerificationHandler.verifyTrue(assessmentPage.takeTestHotSpotFeature(false, false, true, false), "Unable to verify Hot Spot Feature");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT182_VerifyHotSpotFeature End");
	}

	//@Test(priority = 10, alwaysRun = true, description = "ASMT-186:ASMT-37:Verify Previous/Continue buttons functionality in Angular")
	public void ASMT186_VerifyContinueButtonErrorMsgFeature() throws Exception {
		logger.info("ASMT186_VerifyContinueButtonErrorMsgFeature Start");

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
		
		
		log(logger, "Verifying Assessment Header");
		//assessmentPage.verifyAssessmentHeader(1,PropertiesRepository.getString("asmt.assessment.144.assessment.name"));

		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(assessmentPage.takeTestContinueButtonErrorMsgFeature(false, false, true, false), "Unable to verify Previous Continus Button and Rationale feature for Assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		logger.info("ASMT186_VerifyContinueButtonErrorMsgFeature End");
	}
	
	//@Test(priority = 11, alwaysRun = true, description = "ASMT-193:ASMT-36:Verify Submit buttons functionality in Angular")
	public void ASMT193_VerifyContinueButtonFeature() throws Exception {
		logger.info("ASMT193_VerifyContinueButtonFeature Start");

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
		assessmentPage.takeTestContinueButtonFeature(true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT193_VerifyContinueButtonFeature End");
	}
}

