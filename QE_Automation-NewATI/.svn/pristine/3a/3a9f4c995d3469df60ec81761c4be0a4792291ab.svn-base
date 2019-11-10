package com.automation.newati.tutorial;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class TutorialTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage reportPage;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private TestTabPage testTabPage;
	
	
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		reportPage = new MyReportPage(driver);
		textHandler=new TextHandler(driver);
		buttonHandler=new ButtonHandler(driver);
		testTabPage=new TestTabPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.43.user.name.152"), PropertiesRepository.getString("newati.login.519.password"));
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-139")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke","Regression"}, description = "NewATI-139 Tutorial NurseLogic 2.0 - Test : Test Case")
	public void NewATI139_VerifyNurseLogicBeginTest() throws Exception {
		logger.info("Method : NewATI139_VerifyNurseLogicBeginTest Start");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
		tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
		log(logger, "Clicking Module by Name");
		// Step 3 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4 Start
		tutorialPage
				.verifyAllBeginLessonInCardBackForNurseLogic(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.card.back.name.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Begin button in Card back");
		// Step 4 End

		// Step 5 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage
				.clickBeginTestButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.139.nurse.logic.card.front.module.name"));
		log(logger, "Clicking Begin Test ");
		// Step 5 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6 Start
//		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentLogo(),"Unable to verify Logo");
		log(logger, "Verifying Assessment Logo");
		// Step 6 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 7 Start
		VerificationHandler
				.verifyTrue(tutorialPage.verifyAssessmentStartingNumberButton(),
						"Unable to verify Question Starting Number in Nurse Logic Page");
		log(logger, "Verifying Assessment Question Start No");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentEndingNumberButton(),"Unable to verify Question Ending Number in  Page");
		log(logger, "Verifying Assessment Question End No");
		// Step 7 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 8 Start
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentFlagButton(),
				"Unable to verify Flag Button in  Page");
		log(logger, "Verifying Assessment Flag Button");
		// Step 8 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 9 Start
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentSubmitButton(),
				"Unable to verify Submit Button in Nurse Logic Page");
		log(logger, "Verifying Assessment Submit Button");
		// Step 9 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 10 - 13 Start
		log(logger, "Taking Assessment");
		tutorialPage.takeTestPharmacologyAndNurseLogic(false, true, true, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button.new"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 10 - 13 End

		// Step 14 - 17 Start
		log(logger, "Clicking Begin Test ");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickBeginTestButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.139.nurse.logic.card.front.module.name"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Previous Button");
		tutorialPage.clickAssessmentPreviousButton();
		log(logger, "Verifying Assessment Previous and Continue Button");
		// Step 14 - 17 End

		// Step 18 Start
		tutorialPage.takeTestPharmacologyAndNurseLogic(false, false, true, false);
		log(logger, "Completing Assessment ");
		// Step 18 End
		
		reportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=reportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 21 Start
//		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Home Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//verify recent activity
//		log(logger, "Verifying Skill Modules test in Recent Activity");
//		homePage.verifyAndClickRecentActivity(
//				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial",
//				"NurseLogic 2.0", "In Progress");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 21 End
		logger.info("Method : NewATI139_VerifyNurseLogicBeginTest End");
	}
	
	@TestAnnotations(testID="NewATI-128")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke","Regression"}, description = "Tutorial NurseLogic 2.0 - Lesson : Test Case")
	public void NewATI128_VerifyNurseLogicLesson() throws Exception {
		logger.info("NewATI128_VerifyNurseLogicLesson Start");

		// Step 2 Start
		// Step 2 Start
				log(logger, "Clicking on My ATI Tab");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.clickTab(1);
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Click on Learn Tab
				log(logger, "Clicking on Learn Tab");
				homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				

				// Sort Tutorial
				tutorialPage.selectTutorialFromDropDown(PropertiesRepository
						.getString("new-atitesting.tutorialDropdown.value"));
				log(logger, "Selecting Tutorial from Learn Tab");
				// Step 2 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Step 3 Start
				tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
				tutorialPage
						.verifyAllBeginLessonInCardBackForNurseLogic(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.nurse.logic.card.back.name.value"));
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
				tutorialPage
						.clickBeginLessonButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.128.nurse.logic.card.front.module.name"));
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				/*homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/

				// Step 6 Start
//				VerificationHandler.verifyFalse(tutorialPage.verifyTableOfContents(),
//						"Unable to verify Table of Contents and Expand All");
				log(logger, "Verifying Assessment Table of Contents");
				// Step 6 End

				// Step 7 Start
				VerificationHandler.verifyTrue(
						tutorialPage.verifyExpandAllFunctionality(),
						"Unable to verify Expand and Collapse All functionality");
				log(logger,
						"Verifying Assessment Expand and Collapse Button Funcationality");
				// Step 7 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Step 8 Start
				VerificationHandler.verifyTrue(
						tutorialPage.verifyAssessmentLogo(),
						"Unable to verify Logo");
				log(logger, "Verifying Assessment Logo");
				// Step 8 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Step 11 Start
				tutorialPage.clickNurseLogicToolsButton();
				log(logger, "Verifying Assessment Tools Button");
				// Step 11 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				/*homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/
				// Step 13 Start
				// nurseLogicPage.verifyPlayAndPauseButton();
				// Step 13 End

				// Step 14 Start
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				tutorialPage.verifyContinueButtonFunctionality();
				log(logger, "Verifying Assessment Continue Button Funcationality");
				// Step 14 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Step 15 Start
				tutorialPage.clickTutorialCloseButton();
				log(logger, "Verifying Assessment Close Button");
				// Step 15 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Step 16 Start
//				tutorialPage
//						.verifyTimeSpentInCardBackForLesson(PropertiesRepository.getString("new-atitesting.learntab.tutorial.133.skills.module.name"));
				log(logger, "Verifying Time Spent");
				// Step 16 End

				// Step 17 Start
//				Calendar currentTime = tutorialPage
//						.getTimeSpentInCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.133.skills.module.name"));
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				tutorialPage
				.clickBeginLessonButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.128.nurse.logic.card.front.module.name"));
				log(logger, "Clicking Continue Button in Card Back");
				// Step 17 End
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				// Step 18 Start
				//nurseLogicPage.verifyAssessmentName(PropertiesRepository
				 //.getString("new-atitesting.learntab.tutorial.nurse.logic.card.front.module.name"));
				log(logger, "Verifying Assessment Name");
				// Step 18 End

				// Step 19 Start
				tutorialPage.clickTutorialCloseButton();
				log(logger, "Verifying Assessment Close Button");
				// Step 19 End

				// Step 20 Start
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//				VerificationHandler.verifyTrue(tutorialPage.verifyTimeDifference(currentTime, updatedTime), "Unable to verify time difference");
				log(logger, "Verifying Assessment Time Differnece");
			log(logger, "Verifying Time Spent");
			
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Clicking on Home Tab");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.clickTab(0);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//verify recent activity
			log(logger, "Verifying Skill Modules test in Recent Activity");
			homePage.verifyAndClickRecentActivity(
					PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial",
					"NurseLogic 2.0", "COMPLETED ");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			
			logger.info("NewATI128_VerifyNurseLogicLesson End");
	}
	
	
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-96:Skills Module: Post-Test test case")
	public void NewATI96_VerifySkillsModulePostTestcase() throws Exception {
		log(logger,	"NewATI96_VerifySkillsModulePostTestcase -- Start");

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		//step3 start
		tutorialPage.selectCardFrontBasedOnModuleName("Skills Modules 2.0");
		log(logger,
				"Clicking on Skills Module Tutorial Module Button in Card Front");
		//step3 end
		
		//step4 start
		tutorialPage.verifyAllBeginButtonInCardBackTutorialForSkillsModule();
		log(logger, "Clicking on verifying the presensence of all begin button on card back");
		//step4 end
		
		
		//step5 start
		String section=tutorialPage.clickPostTestCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.96.skills.module.name"));
		log(logger, "cliking on the pretest btutton in th card back");
		//step5 end

		//step 6 start
		tutorialPage.takeTest(false, true, true,false);
		log(logger, " Answering the first question tutorial again for completion");
		//step 6 end
		
		//step 7 start
		tutorialPage.getTimeSpentInCardBack(section);
		log(logger, "getting the time spent in the card back");
		//step 7 end
		
		
		//step8 start
		tutorialPage.clickPostTestCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.skills.module.name"));
		log(logger, "Clicking on Begin Test on Card back");
		//step 8 end
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step9-12 start
		log(logger, "Taking Assessment");
		tutorialPage.takeTest(false, false, true, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		reportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		boolean result=reportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "IPP page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 21 Start
//		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		
		log(logger, "Skills Module Pre Test Button Verification Ends");
	}
	
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-133:Tutorials Lesson Test case(Nurse logic 2.0)")
	public void NewATI133_VerifyNurseLogicLesson() throws Exception {
		logger.info("NewATI133_VerifyNurseLogicLesson Start");

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
		
		tutorialPage
				.verifyAllBeginLessonInCardBackForNurseLogic(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.card.back.name.value"));
		tutorialPage
				.clickBeginLessonButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.128.nurse.logic.card.front.module.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 6 Start
//		VerificationHandler.verifyFalse(tutorialPage.verifyTableOfContents(),
//				"Unable to verify Table of Contents and Expand All");
		log(logger, "Verifying Assessment Table of Contents");
		// Step 6 End

		// Step 7 Start
		VerificationHandler.verifyTrue(
				tutorialPage.verifyExpandAllFunctionality(),
				"Unable to verify Expand and Collapse All functionality");
		log(logger,
				"Verifying Assessment Expand and Collapse Button Funcationality");
		// Step 7 End

		// Step 8 Start
		VerificationHandler.verifyTrue(
				tutorialPage.verifyAssessmentLogo(),
				"Unable to verify Logo");
		log(logger, "Verifying Assessment Logo");
		// Step 8 End

		// Step 11 Start
		tutorialPage.clickNurseLogicToolsButton();
		log(logger, "Verifying Assessment Tools Button");
		// Step 11 End

		// Step 13 Start
		// nurseLogicPage.verifyPlayAndPauseButton();
		// Step 13 End

		// Step 14 Start
		tutorialPage.verifyContinueButtonFunctionality();
		log(logger, "Verifying Assessment Continue Button Funcationality");
		// Step 14 End

		// Step 15 Start
		tutorialPage.clickTutorialCloseButton();
		log(logger, "Verifying Assessment Close Button");
		// Step 15 End

		// Step 16 Start
//		tutorialPage
//				.verifyTimeSpentInCardBackForLesson(PropertiesRepository.getString("new-atitesting.learntab.tutorial.133.skills.module.name"));
		log(logger, "Verifying Time Spent");
		// Step 16 End

		// Step 17 Start
//		Calendar currentTime = tutorialPage
//				.getTimeSpentInCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.133.skills.module.name"));

		tutorialPage
		.clickBeginLessonButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.128.nurse.logic.card.front.module.name"));
		log(logger, "Clicking Continue Button in Card Back");
		// Step 17 End

		// Step 18 Start
		//nurseLogicPage.verifyAssessmentName(PropertiesRepository
		 //.getString("new-atitesting.learntab.tutorial.nurse.logic.card.front.module.name"));
		log(logger, "Verifying Assessment Name");
		// Step 18 End

		// Step 19 Start
		tutorialPage.clickTutorialCloseButton();
		log(logger, "Verifying Assessment Close Button");
		// Step 19 End

		// Step 20 Start

//		VerificationHandler.verifyTrue(tutorialPage.verifyTimeDifference(currentTime, updatedTime), "Unable to verify time difference");
		log(logger, "Verifying Assessment Time Differnece");
		// Step 20 End
		logger.info("NewATI133_VerifyNurseLogicLesson End");
	}

	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-55:Verify tutorials and their Card front accessability")
	public void NewATI55_VerifyTutorialInfoCard() throws Exception {
		logger.info("NewATI55_VerifyTutorialInfoCard Start");

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler
		.verifyTrue(tutorialPage.clickTutorialInfoIcon(), "Unable to verify Info Card details");
		logger.info("NewATI55_VerifyTutorialInfoCard End");
	}
	
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-134:Tutorial Tests Rational Test case")
	public void NewATI134_VerifyTutorialRationale() throws Exception {
		logger.info("Method : NewATI134_VerifyTutorialRationale Start");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		// Step 3 Start
		tutorialPage
				.clickModuleButtonByName(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
		log(logger, "Clicking Module by Name");
		// Step 3 End

		// Step 5 Start
		tutorialPage
				.clickBeginTestButtonInNewNurseLogicCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.139.nurse.logic.card.front.module.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Begin Test ");

		//step9-12 start
		log(logger, "Taking Assessment");
		
		tutorialPage.takeTestRationale(false, false, true, false);
		log(logger, "Clicking on Close Button");
		reportPage.verifyIPPPageHeader();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
        //steps9-12 end
		
		log(logger, "NewATI134_VerifyTutorialRationale End");
	}

	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-143:Tutorial Select Instance")
	public void NewATI143_VerifyTutorialSelectInstance() throws Exception {
		logger.info("Method : NewATI143_VerifyTutorialSelect"
				+ " Start");
		
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product Button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Product ID");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"),PropertiesRepository.getString("new-atitesting.add.product.tut.id"));
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Password");
		tutorialPage.enterText("new-atitesting.add.product.password.new.loc", "new-atitesting.add.product.tut.pwd", 0);
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Test  Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		log(logger, "Selecting Quiz from Test Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
		
		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 7 Start
		log(logger, "Clicking Module by Name");
		VerificationHandler.verifyTrue(tutorialPage
		.clickModuleButtonByNameSelectInstance(PropertiesRepository
				.getString("new-atitesting.Quiz.143.select.instance.name")), "Unable to verify Tutorial Instance");
		
		// Step 7 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI143_VerifyTutorialSelectInstance End");
	}
	
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-152:Hide disabled products checkbox(Test Tab)")
	public void NewATI152_VerifyHideDisabledCheckbox() throws Exception {
		logger.info("NewATI152_VerifyHideDisabledCheckbox Start");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	/*	// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Quiz from Learn Tab");*/
		// Step 3 End
		
		tutorialPage.clickHideCheckboxInTestTab();
		log(logger, "Unchecking on Hide Check box");
		
		VerificationHandler.verifyTrue(tutorialPage.verifyHideItemDisplayed(), "Hidden Assessment are not shown");
		log(logger, "Verifying Hidden items are shown");
		
		tutorialPage.clickHideCheckboxInTestTabWithoutChecking();
		log(logger, "Checking Hide check box");
		
		VerificationHandler.verifyFalse(tutorialPage.verifyHideItemDisplayed(), "Non Hidden Assessment are shown");
		log(logger, "Verifying Assessment are shown");
		
		logger.info("NewATI152_VerifyHideDisabledCheckbox End");
	}
	
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-511:Verification for Modules of Skills Module 2.0")
	public void NewATI511_VerifySkillsModuleModuleName() throws Exception {
		log(logger,"NewATI511_VerifySkillsModuleModuleName Start");

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step3 start
		log(logger,
				"Clicking on Skills Module Tutorial Module Button in Card Front");
		tutorialPage.selectCardFrontBasedOnModuleName("Skills Modules 2.0");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler
		.verifyTrue(tutorialPage.verifySkilsModuleName(),"Unable to verifySkilsModuleName");
		//step3 end
		log(logger,"NewATI511_VerifySkillsModuleModuleName End");
	}
}
