package com.automation.asmt.smoke;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.utils.CommonUtils;
import com.jaca.TestAnnotations;

public class SmokeTest1 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private QuizBankAssessmentPage quizBankAssPage ;
	private LoginPage loginPage;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		loginPage = new LoginPage(driver);
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-359")
	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "Verify presence of all element and  continue button functionality in practice assessment page.::ASMT_Smoke_E2E Scenarios")
	public void ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality()
			throws Exception {
		log(logger, "ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality Start");
		maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.maint.username1"),PropertiesRepository.getString("asmt.maint.password1"));
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		maintenanceScriptPage.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Logo");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyElementWithAssessmentSwitch(PropertiesRepository.getString("asmt.maint.logo")), "Unable to verify Logo");
		
		log(logger, "Verifying Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyAssessmentHeaderWithAssessmentSwitch(0, PropertiesRepository.getString("asmt.maint.assessment.name")), "Unable to verify Header");
		
		log(logger, "Verifying Close button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyElementWithAssessmentSwitch(PropertiesRepository.getString("asmt.assessment.close.button.loc")), "Unable to verify Close button");
		
		/*log(logger, "Verifying Previous button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyPreviousButton(), "Previous button is displayed");
		*/
		log(logger, "Verifying Continue button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyContinueButton(), "Unable to verify Continue button");
		
		log(logger, "Verifying Question nos");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionValue(), "Unable to verify Question nos");
		
		// Flag verify pending.
		
		//Already  Covering in ASMT747_VerifyITRExhibitAndFlag
		
		/*log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(maintenanceScriptPage.takeTestNew(false, false, true, false), "Unable to complete Assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");*/
		
		// logo, Close button, Assessment name, previous button should not be there, continue button should be there. 
		// Question no and text flag button. 
		
		log(logger, "ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality Ends");		
		
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-360")
	@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = "Verify pause , calculator and flag button functionality in practice assessment.::ASMT_Smoke_E2E Scenarios")
	public void ASMT360_VerifyPauseCalculatorAndFlagButtonFunctionality()
			throws Exception {
		log(logger, "ASMT360_VerifyPauseCalculatorAndFlagButtonFunctionality Start");
		maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.maint.username"),PropertiesRepository.getString("asmt.maint.password"));
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"),PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		maintenanceScriptPage.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		
		// Verifying Calculator functionality Start 
		log(logger, "Verifying Calculator");
		maintenanceScriptPage.verifyCalculatorFuncationality();
		// Verifying Calculator functionality End 
		
		// Verifying Pause functionality Start. 
		log(logger, "Verifying Pause Button. ");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyAssessmentPauseButton(false),
				"Unable to verify Pause Button");

		log(logger, "Clicking on Pause Button");
		maintenanceScriptPage.verifyAssessmentPauseButton(true);

		log(logger, "Verifying Pause Button Header Message");
		maintenanceScriptPage.verifyPauseButtonHeaderMessage();

		log(logger, "Verifying Pause Popup Resume Assessment Button");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyPauseButtonResumeAssessmentButton(false),
				"Unable to verify Resume Assessment Button");

		log(logger, "Clicking on Esc Button");
		maintenanceScriptPage.clickEscButton();

		log(logger, "Verifying Pause Popup Resume Assessment Button");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyPauseButtonResumeAssessmentButton(false),
				"Pause Button is not displayed");

		log(logger, "Clicking on Resume Assessment Button");
		maintenanceScriptPage.verifyPauseButtonResumeAssessmentButton(true);

		log(logger, "Getting Pause time in screen");
		Calendar pauseTimeInScreen = maintenanceScriptPage
				.getPauseTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Pause Button");
		maintenanceScriptPage.verifyAssessmentPauseButton(true);
		
		
		log(logger, "Getting Pause time in Pause Popup");
		Calendar pauseTimeFromPopup = maintenanceScriptPage
				.getPauseTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));

		log(logger, "Verifying Time difference.");
		CommonUtils.compareCalendar(
				pauseTimeInScreen, pauseTimeFromPopup);

		log(logger, "Clicking on Resume Assessment Button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyPauseButtonResumeAssessmentButton(true),"Unable to click on Resume Assessment button");
		// Verifying Pause functionality End.
		
		//Already  Covering in ASMT747_VerifyITRExhibitAndFlag
	
		/*log(logger, "Flagging Assessment");
		maintenanceScriptPage.takeTestFlag(false, false, true, false);
		
		log(logger, "Taking Assessment");
		maintenanceScriptPage.takeTestUnFlag(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");*/
		
		// logo, Close button, Assessment name, previous button should not be there, continue button should be there. 
		// Question no and text flag button. 
		
		log(logger, "ASMT360_VerifyPauseCalculatorAndFlagButtonFunctionality Ends");
		
	}
}
