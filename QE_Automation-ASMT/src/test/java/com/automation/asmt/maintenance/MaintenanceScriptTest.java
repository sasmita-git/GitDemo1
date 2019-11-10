package com.automation.asmt.maintenance;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.jaca.TestAnnotations;

public class MaintenanceScriptTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MaintenanceScriptPage maintenanceScriptPage;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		
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

		log(logger, "Login to Application");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test1.username"),PropertiesRepository.getString("asmt.test1.password"));
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		//maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
	
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		maintenanceScriptPage.waitUntillBufferInvisible(PropertiesRepository.getString("asmt.loading.loc"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					
		log(logger, "Clicking on Practice Assessment ");		
		maintenanceScriptPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"),PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		maintenanceScriptPage.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.maint.assessment.name"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Logo"); 
		maintenanceScriptPage.switchToAssessmentFrameHandler();
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyElement(PropertiesRepository.getString("asmt.maint.logo")), "Unable to verify Logo");
		
		log(logger, "Verifying Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyAssessmentHeader(0, PropertiesRepository.getString("asmt.maint.assessment.name")), "Unable to verify Header");
		
		log(logger, "Verifying Close button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyElement(PropertiesRepository.getString("asmt.maint.myati.test.tab.assessment.page.header.loc")), "Unable to verify Close button");
		
		log(logger, "Verifying Previous button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyPreviousButton(), "Previous button is displayed");
		
		log(logger, "Verifying Continue button");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyContinueButton(), "Unable to verify Continue button");
		
		log(logger, "Verifying Question nos");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionValue(), "Unable to verify Question nos");
				
		log(logger, "Taking Assessment");
		maintenanceScriptPage.takeTest(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "ASMT359_VerifyPpresenceOfAllElementAndContinueButtonFunctionality Ends");
		
		
	}
	
	
}
