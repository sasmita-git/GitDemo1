package com.automation.asmt.maintenance;

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
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.utils.CommonUtils;
import com.jaca.TestAnnotations;

public class SmokeTest1 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
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
		maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.smoke12262018.username"),PropertiesRepository.getString("asmt.smoke12262018.password"));
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		maintenanceScriptPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"),PropertiesRepository.getString("asmt.maint.assessment.name"));
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
	
		log(logger, "Flagging Assessment");
		maintenanceScriptPage.takeTestFlag(false, false, true, false);
		
		log(logger, "Taking Assessment");
		maintenanceScriptPage.takeTestUnFlag(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		// logo, Close button, Assessment name, previous button should not be there, continue button should be there. 
		// Question no and text flag button. 
		
		log(logger, "ASMT360_VerifyPauseCalculatorAndFlagButtonFunctionality Ends");
		
	}
}
