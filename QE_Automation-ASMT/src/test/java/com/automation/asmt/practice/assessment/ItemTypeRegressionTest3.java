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

public class ItemTypeRegressionTest3 extends BaseTest{
	
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
	
		
	}
	
	/**
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, description = "ASMT-411:Verify presence of Stimulus portion in Practice assessment")
	public void ASMT411_VerifyITRStimulusFeature() throws Exception {
		logger.info("ASMT411_VerifyITRStimulusFeature Start");

		//loginPage.loginToApplication("Automation.User55", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
		
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
		
		logger.info("ASMT411_VerifyITRStimulusFeature End");
	}
	
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-136:ASMT-30:Verify the conservation of Question text portion of the practice assessment")
	public void ASMT136_VerifyITRAllQuestion() throws Exception {
		logger.info("ASMT136_VerifyITRAllQuestion Start");

		//loginPage.loginToApplication("Automation.User55", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
		
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

		log(logger, "Verifying All Question type in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestVerifyQuestionForAllAssessmentsForITR(false, false, true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT136_VerifyITRAllQuestion End");
	}
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-131:ASMT -32:Verify Stimulus portion question no functionality")
	public void ASMT131_VerifyStimulusQuestionNo() throws Exception {
		logger.info("ASMT221_VerifyStimulusText Start");

		//loginPage.loginToApplication("Automation.User22", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
		
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

		log(logger, "Verifying All Question type in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestStimulusFeatureWithQuestion(false, false, true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT131_VerifyStimulusQuestionNo End");
	}
	
	@Test(priority = 4, alwaysRun = true, description = "ASMT-221:Verify Stimulus portion does not have any extra text.")
	public void ASMT221_VerifyStimulusQuestionSection() throws Exception {
		logger.info("ASMT221_VerifyStimulusQuestionSection Start");

		//loginPage.loginToApplication("AutoUser20022018833", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.regtest1.username")
				,PropertiesRepository.getString("asmt.regtest1.password"));
		
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

		log(logger, "Verifying All Question type in Item Type Regression");
		VerificationHandler.verifyTrue(itemTypeRegressionPage.takeTestStimulusWithExtraText(false, false, true, false), "Unable to complete ITR Exhibit");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		logger.info("ASMT221_VerifyStimulusQuestionSection End");
	}
}
