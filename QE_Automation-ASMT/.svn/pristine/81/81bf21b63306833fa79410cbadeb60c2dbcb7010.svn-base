package com.automation.asmt.regression.assessment;

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
import com.automation.asmt.page.TestTabPage;
import com.jaca.TestAnnotations;

public class PracticeAssessmentRegressionTest extends BaseTest {

		Logger logger = LogManager.getLogger(this.getClass());
		private LoginPage loginPage;
		private HomePage homePage;
		private AssessmentPage assessmentPage;
		private TakeAssessmentPage takeAssessment;
		private TestTabPage testTabPage;
		
		@BeforeMethod(alwaysRun = true)
		public void verifyHomePage() throws Exception {
			loginPage = new LoginPage(driver);
			homePage = new HomePage(driver);
			assessmentPage = new AssessmentPage(driver);
			takeAssessment = new TakeAssessmentPage(driver);
			testTabPage = new TestTabPage(driver);
			
			/*loginPage.loginToApplication(
					PropertiesRepository.getString("asmt.username"),
					PropertiesRepository.getString("asmt.password"));*/
			
			// loginPage.loginToApplication("asmtreg1","Test123");
			
			loginPage.loginToApplication("Automation.User0583", "Test123");
		}	
	
	@TestAnnotations(testID = "205")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT-205:ASMT-2232 Validate Previous button is disable on 1st quest,when user selects Review Flagged qust on.")
	public void ASMT205_ValidatePrevBtnForFirstQuestion() throws Exception {
		log(logger, "ASMT205_ValidatePrevBtnForFirstQuestion Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"sixquestions");
		
		log(logger, "Completing Assessment if it is partial");
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				"sixquestions");
		
		log(logger, "completing section 1");
		assessmentPage.takeTestWithFirstAssessmentFlagging(false, false, true, false);
		
		log(logger, "verifying previous button status");
		boolean result1=assessmentPage.verifyPreviousButton("asmt.generic.tutorial.previous.loc");
		VerificationHandler.verifyTrue(result1,"previous button is  enable");
		
		log(logger, "Completed Review and Flagged Questions");
		VerificationHandler.verifyTrue(assessmentPage.takeTestWithUnFlagVerifyPreviousBtnFunc(false, false, true, false), "Unable to verify Previous Button");
		
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "Clicking on Close Button");
		homePage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("asmt.question.assement.question.close.button"), 0);
		
		log(logger, "ASMT205_ValidatePrevBtnForFirstQuestion End");
	}
	
	@TestAnnotations(testID = "294")
	//@Test(priority = 2, alwaysRun = true, groups = { "Regression" }, description = "ASMT-294:ASMT-3749:Verify browser back button, when user taking practice assessment.")
	public void ASMT294_ValidateBrowserBackButton() throws Exception {
		log(logger, "ASMT294_ValidateBrowserBackButton Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"sixquestions_no_rational");
		
		log(logger, "Completing Assessment if it is partial");
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				"sixquestions_no_rational");
		
		log(logger, "completing section");
		assessmentPage.takeTest(false, true, false, false);
		
		log(logger, "Click on Window Back Button");
		driver.navigate().back();
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify Test Tab");
		VerificationHandler.verifyTrue(assessmentPage.verifyElement("#TestTabNav"), "Unable to verify Test Tab");
		
		log(logger, "ASMT294_ValidateBrowserBackButton End");
	}
	
	@TestAnnotations(testID = "282")
	//@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "")
	public void ASMT282_VerifyCookieDetails() throws Exception {
		log(logger, "ASMT282_VerifyCookieDetails Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		testTabPage.getCookieDetails();
		
		
		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"sixquestions_no_rational");
		
		testTabPage.getCookieDetails();
		/*
		log(logger, "Completing Assessment if it is partial");
		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				"sixquestions_no_rational");
		
		log(logger, "completing section 1");
		assessmentPage.takeTest(false, true, false, false);
		
		log(logger, "Click on Window Back Button");
		driver.navigate().back();
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify Test Tab");
		VerificationHandler.verifyTrue(assessmentPage.verifyElement("#TestTabNav"), "Unable to verify Test Tab");*/
		
		log(logger, "ASMT282_VerifyCookieDetails End");
	}
	
	@TestAnnotations(testID = "130")
	@Test(priority = 4, alwaysRun = true, groups = { "Regression" }, description = "ASMT-130:ASMT-29:Verify Watermark In Practice Question No")
	public void ASMT130_ValidateAssessmentWaterMark() throws Exception {
		log(logger, "ASMT130_ValidateAssessmentWaterMark Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Cicking in My ATI Tab");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"sixquestions_no_rational");
		
		log(logger, "Verify Water Mark in Assessment Page");
		VerificationHandler.verifyTrue(assessmentPage.verifyWaterMark(), "Unable to verify WaterMark in Assessment Page");
		
		log(logger, "ASMT130_ValidateAssessmentWaterMark End");
	}
	
	@TestAnnotations(testID = "208")
	//@Test(priority = 5, alwaysRun = true, groups = { "Regression" }, description = "ASMT-2344: Verify if front and back arrow key from keyboard functionality without rationalise")
	public void ASMT208_VerifyKeyBoardFuncationality() throws Exception {
		log(logger, "ASMT208_VerifyKeyBoardFuncationality Start");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs", 1);
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs", 1);

		log(logger, "Verifying Test Tab Practice and Proctor is displayed or not");
		assessmentPage.verifyTestTabDetails();

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));

		takeAssessment.completeContinueStateAssessment(PropertiesRepository.getString("asmt.myati.assessment.type"),
				PropertiesRepository.getString("asmt.practice.assessment.with.no.rationale.value"));
		
		log(logger, "completing section");
		takeAssessment.takeTestWithKeyboardFuncationality(false, true, false, false);
		
		log(logger, "Verifying Assessmnet values");
		takeAssessment.verifyAssessment();
		
		log(logger, "ASMT208_VerifyKeyBoardFuncationality End");
	}
	
}
