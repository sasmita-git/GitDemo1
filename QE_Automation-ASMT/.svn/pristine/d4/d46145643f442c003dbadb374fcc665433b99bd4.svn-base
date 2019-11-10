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

public class ItemTypeRegressionTest extends BaseTest{
	
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
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test1.username"),
				PropertiesRepository.getString("asmt.test1.password"));
		
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
	}
	
	//@Test(priority = 1, alwaysRun = true, description = "ASMT-212:Verify Free form answer type question functionality.")
	public void ASMT212_VerifyITROPFeature() throws Exception {
		logger.info("ASMT212_VerifyITROPFeature Start");

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
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "completing section 1");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRMultipleChoice(true, false), "Unable to complete ITR Multiple choice");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT212_VerifyITROPFeature End");
	}
	
	//@Test(priority = 2, alwaysRun = true, description = "ASMT-236:T/F question should save the answers after SUBMIT ANSWER is selected.")
	public void ASMT236_VerifyITRTextBoxFeature() throws Exception {
		logger.info("ASMT236_VerifyITRTextBoxFeature Start");

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
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.assessment.itrop.assessment.name"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "completing section 1");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRTextBox(true, false), "Unable to complete ITR Text Box");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT236_VerifyITRTextBoxFeature End");
	}

	/**
	 * @throws Exception
	 */
	@Test(priority = 3, alwaysRun = true, description = "ASMT-234:Verify Exhibit section functionality")
	public void ASMT234_VerifyITRExihibitFeature() throws Exception {
		logger.info("ASMT234_VerifyITRExihibitFeature Start");

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
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRExhibit(true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT234_VerifyITRExihibitFeature End");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	//@Test(priority = 4, alwaysRun = true, description = "ASMT-218:EXHIBIT tabs on the Stimulus Question/Answer page should work the same")
	public void ASMT218_VerifyITRExihibitFeatureInRational() throws Exception {
		logger.info("ASMT218_VerifyITRExihibitFeatureInRational Start");

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

		log(logger, "completing section 1");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestITRExhibitInRational(true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT218_VerifyITRExihibitFeatureInRational End");
	}
}
