package com.automation.asmt.maintenance;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.jaca.TestAnnotations;

public class SmokeTest extends BaseTest {

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
	@TestAnnotations(testID="ASMT-359")
	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "Verify presence of all element and  continue button functionality in practice assessment page.::ASMT_Smoke_E2E Scenarios")
	public void ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality()
			throws Exception {
		log(logger, "ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality Start");
		maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.maint.username359"),PropertiesRepository.getString("asmt.maint.password359"));
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		maintenanceScriptPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"),
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
		
		log(logger, "Taking Assessment");
		VerificationHandler.verifyTrue(maintenanceScriptPage.takeTestNew(false, false, true, false), "Unable to complete Assessment");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		// logo, Close button, Assessment name, previous button should not be there, continue button should be there. 
		// Question no and text flag button. 
		
		log(logger, "ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality Ends");
		
		
	}
	
	
}
