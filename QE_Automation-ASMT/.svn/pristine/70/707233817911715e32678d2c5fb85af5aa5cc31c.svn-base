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
import com.automation.asmt.page.ItemTypeRegressionPage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.TakeAssessmentPage;

public class ItemTypeRegressionTest2 extends BaseTest{
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private ItemTypeRegressionPage itemTypeRegressionPage;
	private TakeAssessmentPage takeAssessment;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		itemTypeRegressionPage = new ItemTypeRegressionPage(driver);
		takeAssessment = new TakeAssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
	}
	
	/**
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, description = "ASMT-134:ASMT-38:Verify and Convert the exhibit section from knockout to Angular")
	public void ASMT134_VerifyITRExihibitFeature() throws Exception {
		logger.info("ASMT134_VerifyITRExihibitFeature Start");
	
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		/*assessmentPage.clickTestTabITRAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));*/
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Verifying Exhibit Funcatinality in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRExhibit(true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT134_VerifyITRExihibitFeature End");
	}
	
	/**
	 * @throws Exception
	 */
	@Test(priority = 2, alwaysRun = true, description = "ASMT-169:ASMT -32:Verify Stimulus portion functionality")
	public void ASMT169_VerifyITRStimulusFeature() throws Exception {
		logger.info("ASMT169_VerifyITRStimulusFeature Start");

		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabITRAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Verifying Exhibit Funcatinality in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestStimulusFeature(false, false, true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT169_VerifyITRStimulusFeature End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-242:User should be able access the application after answering/flagging EXHIBIT questions.")
	public void ASMT242_VerifyITRExihibitFlagFeature() throws Exception {
		logger.info("ASMT242_VerifyITRExihibitFlagFeature Start");
	
		
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger,
				"Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		/*assessmentPage.clickTestTabITRAssessmentButton(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));*/
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Verifying flagging option for Exhibit Funcatinality in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRExhibitFlagFeature(true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Clicking on close button ");
		assessmentPage.clickOnCloseButton("asmt.question.assement.question.close.button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		log(logger, "Completed Review and Flagged Questions");
		itemTypeRegressionPage.takeTestITRExhibitUnFlag(true, false);
		
		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT242_VerifyITRExihibitFlagFeature End");
	}

}
