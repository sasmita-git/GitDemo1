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

public class AssessmentTest13 extends BaseTest {

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
		// loginPage.loginToApplication(PropertiesRepository.getString("asmt.username"),PropertiesRepository.getString("asmt.password"));
		//loginPage.loginToApplication("AutoUser23022018862", "Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test3.username"),
				PropertiesRepository.getString("asmt.test3.password"));
	}
	
	@Test(priority = 1, alwaysRun = true, description = "ASMT-239:ASMT-2911 : Resubmitting answers for Multiple Response question type which does not have rationales.")
	public void ASMT239_VerifySelectMultipleMRPrevious() throws Exception {
		logger.info("ASMT239_VerifySelectMultipleMRPrevious Start");
		
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
		
		log(logger, "Verify if correct question number appears in question number section for flagged question");
		VerificationHandler.verifyTrue(assessmentPage.takeTestVerifySelectMultipleMR(false, false, false, false), "Unable to verify resubmitting answers for Multiple Response question type");

		logger.info("ASMT239_VerifySelectMultipleMRPrevious End");
		
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-167:ASMT-1762:Verify Pause timer functionality for Practice Assessment")
		public void ASMT167_VerifyPauseTimer() throws Exception {
			logger.info("ASMT167_VerifyPauseTimer Start");

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

			assessmentPage.switchToAssessmentFrameHandler();
			
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

			log(logger, "Clicking on Esc Button");
			assessmentPage.clickEscButton();

			log(logger, "Clicking on Resume Assessment Button");
			assessmentPage.verifyPauseButtonResumeAssessmentButton(true);
			
			log(logger, "Verifying pause times before and after clicking pause");
			VerificationHandler.verifyTrue(CommonUtils.compareCalendar(pauseTimeInScreen, pauseTimeFromPopup),"Unable to verify pause times before and after clicking pause");
			
			assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			assessmentPage.switchToAssessmentFrameHandler();

			log(logger, "Clicking on Pause Button");
			assessmentPage.verifyAssessmentPauseButton(true);
			
			log(logger, "Getting Pause time again in Pause Popup");
			Calendar pauseTimeFromPopup1 = assessmentPage
					.getPauseTime(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.pause.time.in.screen.loc"));
			
			log(logger, "Clicking on Resume Assessment Button");
			assessmentPage.verifyPauseButtonResumeAssessmentButton(true);

			VerificationHandler.verifyTrue(CommonUtils.compareCalendar(pauseTimeFromPopup, pauseTimeFromPopup1),
					"Unable to verify pause times before and after clicking pause");

			logger.info("ASMT167_VerifyPauseTimer End");
		}
	
	
	@Test(priority = 3, alwaysRun = true, description = "ASMT-248:After un pausing an assessment the Time Elapsed starts counting the time")
	public void ASMT248_VerifyElapsedTimeAfterUnPause() throws Exception {
		
		logger.info("ASMT248_VerifyElapsedTimeAfterUnPause Start");

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

		assessmentPage.switchToAssessmentFrameHandler();
		
		log(logger, "Getting time elapsed in screen");
		Calendar elapsedtimeInScreen = assessmentPage
				.getElapsedTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.elapsed.time.in.screen.loc"));
		assessmentPage.waitUntillLoadingImageIsDisplayed(4);

		log(logger, "Clicking on Pause Button");
		assessmentPage.verifyAssessmentPauseButton(true);

		log(logger, "Clicking on Esc Button");
		assessmentPage.clickEscButton();

		log(logger, "Clicking on Resume Assessment Button");
		assessmentPage.verifyPauseButtonResumeAssessmentButton(true);

		log(logger, "Getting time elaspsed in screen after closing the Pause popup");
		Calendar elapsedtimeInScreen1 = assessmentPage
				.getElapsedTime(PropertiesRepository
						.getString("asmt.myati.test.tab.assessment.elapsed.time.in.screen.loc"));
		assessmentPage.waitUntillLoadingImageIsDisplayed(4);

		log(logger, "Verifying times before and after clicking pause");
		VerificationHandler.verifyTrue(CommonUtils.compareCalendar(elapsedtimeInScreen, elapsedtimeInScreen1),"Unable to verify elapsed times before and after clicking pause");
		
		logger.info("ASMT248_VerifyElapsedTimeAfterUnPause End");
	}
	
	
}
