package com.automation.asmt.practice.assessment.student;

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
import com.automation.asmt.utils.CommonUtils;

public class StudentPracticeAssessmentTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);

		/*loginPage.loginToApplication(
				PropertiesRepository.getString("asmt.username"),
				PropertiesRepository.getString("asmt.password"));*/
				
				loginPage.loginToApplication("studno1","A123456");
	}

	//@Test(priority = 1, alwaysRun = true, description = "Smoke P2  ASMT-138:Launch Practice assessment" )
	public void verifyLaunchPracticeAssessmentTest() throws Exception {
		logger.info("verifyLaunchPracticeAssessmentTest Start");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Verifying all tabs in My ATI Tab");
		assessmentPage.verifyAllTabsUnderMyATITab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		VerificationHandler.verifyTrue(assessmentPage.verifyTestTabDetails(), "Test Tab details are not verified");

		logger.info("verifyLaunchPracticeAssessmentTest End");
	}

	@Test(priority = 2, alwaysRun = true, description = "ASMT-49:Practice assessment IPP page download report feature")
	public void ASMT49_VerifyIPPPageDownloadFeature() throws Exception {
		logger.info("ASMT49_VerifyIPPPageDownloadFeature Start");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabValue(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"MasterAssessment1", true, "CONTINUE");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on IPP Page Download Button");
		//assessmentPage.clickIPPPageDownloadButton();
		
		
		logger.info("ASMT49_VerifyIPPPageDownloadFeature End");
	}

	//@Test(priority = 3, alwaysRun = true, groups = { "Smoke" }, description = "Smoke ASMT-166:ASMT-1762:Verify Pause time Modal window for Practice Assessment")
	public void verfiryTimeModalWindowsForPracticeAssessment() throws Exception {
		logger.info("verfiryTimeModalWindowsForPracticeAssessment Start");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();
		
		log(logger, "Clicking on Assessment Type");
		assessmentPage.clickAssessmentType(PropertiesRepository
				.getString("asmt.myati.assessment.type"));
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage
				.clickTestTabAssessmentButton(
						PropertiesRepository
								.getString("asmt.myati.assessment.type"),
						PropertiesRepository
								.getString("asmt.myati.assessment.name"));

		log(logger, "Verifying Assessment Header");
		assessmentPage.verifyAssessmentHeader(1,
				PropertiesRepository.getString("asmt.myati.assessment.name"));

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

		log(logger, "Clicking on Pause Button");
		assessmentPage.verifyAssessmentPauseButton(true);

		log(logger, "Getting Pause time in Pause Popup");
		Calendar pauseTimeFromPopup = assessmentPage
				.getPauseTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));

		log(logger, "Verifying Time difference.");
		VerificationHandler.verifyTrue(CommonUtils.compareCalendar(
				pauseTimeInScreen, pauseTimeFromPopup),
				"Pause Time in Screen is not after Pause time in popup");

		log(logger, "Clicking on Resume Assessment Button");
		assessmentPage.verifyPauseButtonResumeAssessmentButton(true);

		logger.info("verfiryTimeModalWindowsForPracticeAssessment End");
	}

	//@Test(priority = 4, alwaysRun = true, groups= {"Smoke"}, description = "Smoke ASMT-170:ASMT-1740:Disabling the cursor when the mouser is hovered over the radio buttons")
	public void verfiryTimeModalWindows() throws Exception {
		logger.info("verfiryTimeModalWindows Start");

		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"RN Fundamentals Online Practice 2013 A", true, "BEGIN");

		log(logger, "Verifying Assessment Header");
		assessmentPage.verifyAssessmentHeader(1,
				"RN Fundamentals Online Practice 2013 A");

		assessmentPage.takeTest(false, true, true, false);

		log(logger, "Verifying disabled element in Answer page");
		assessmentPage.verifyDisableElement();

		log(logger, "verfiryTimeModalWindows End");
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	//@Test(priority = 5, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-159:ASMT -28:Verify functionality of 'FLAG' button:Verify functionality of 'FLAG' button in Practice Assessment as 'FLAG' button of the practice assessment page is converted from knockout to Angular.")
	public void verfiryFlagFuncationalityForPracticeAssessment()
			throws Exception {
		log(logger, "verfiryFlagFuncationalityForPracticeAssessment Start");
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"MasterAssessment1");

		log(logger, "Verifying the flag button");
		VerificationHandler.verifyTrue(assessmentPage.verifyFlag(false),
				"Unable to verify Flag button");

		log(logger, "Clicking the flag button");
		assessmentPage.verifyFlag(true);

		log(logger, "verifying the subbmit button button");
		VerificationHandler.verifyTrue(assessmentPage.verifySubmitDisabled());

		log(logger, "Verifying the flag button");
		assessmentPage.verifyFlag(true);

		log(logger, "verifiying the flag submit button");
		VerificationHandler.verifyTrue(assessmentPage.verifySubmitButton(false),
				"Unable to veriry Submit Button");

		log(logger, "verfiryFlagFuncationalityForPracticeAssessment End");
	}

	//@Test(priority = 6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-234:In this section we will verify exhibit window functionality on the practice assessment page.")
	public void verifyExibitTest() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Test of Essential Academic Skills Online Practice V B");

		log(logger, "clikcing on the exibit button");
		assessmentPage.verifyAndClickExibit(true);

		log(logger, "clikcing on the exibitclose button");
		assessmentPage.closeExibitWindow();
	}

	/**
	 * Need proper question type to answer, if not the test case will fail.
	 * 
	 * @throws Exception
	 */
	//@Test(priority = 7, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-173:ASMT-1744: Validate the Drag and Drop functionality for Question - Answer Box.")
	public void verifyDragAndDrop() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Targeted Medical-Surgical 2010: Respiratory");

		log(logger, "Dragging and drop answer");
		assessmentPage.takeTestTillTypeOfQuestion(true, "draganddrop", "10",false);

		VerificationHandler.verifyTrue(assessmentPage.verifySubmitButton(false));
	}

	//@Test(priority = 8, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-212:Verify Free form answer type question functionality.")
	public void verifyFormFill() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"PN ATI Capstone Content Review Adult Medical Surgical 1 2014");

		log(logger, "Dragging and drop answer");
		assessmentPage.takeTestTillTypeOfQuestion(true, "text", "10",false);

		VerificationHandler.verifyTrue(assessmentPage.verifySubmitButton(false));
	}

	//@Test(priority = 9, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-226:ASMT-2653-Verify if while taking assessment student see marked question after submitting question.")
	public void verifyRational() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Targeted Medical-Surgical 2010: Respiratory");

		log(logger, "Dragging and drop answer");
		assessmentPage.takeTest(true, true, true, false);

		log(logger, "Click on the continue button");
		assessmentPage.verifyAndClickCountinue(true);

		log(logger, "Click on the previous button");
		assessmentPage.verifyAndClickPrevious(true);

		log(logger, "Veriffiying thde rational");
		VerificationHandler.verifyTrue(assessmentPage
				.verifyRationaleAndMyAnswer());
	}

	@Test(priority = 10, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-224:'Finalized and view results' should be displayed when the user completes the last section of a TEAS.")
	public void verifyTeasLastSection() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Test of Essential Academic Skills Online Practice V B");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, false, false, false);
		log(logger, "Completing section 2 ");

		assessmentPage.takeTest(false, false, false, false);
		log(logger, "Completing section three ");

		assessmentPage.takeTest(false, false, false, false);
		log(logger, "Completing section 4");

		assessmentPage.takeTest(false, false, false, true);
		log(logger, "Completing section 5");

	}

}
