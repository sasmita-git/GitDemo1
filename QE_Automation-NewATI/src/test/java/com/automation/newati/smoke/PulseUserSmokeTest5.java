package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.FlashCardPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest5 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TutorialPage tutorialPage;
	private HomePage homePage;
	private MyResultsTabPage myResultsTabPage;
	private PaymentsPage paymentsPage;
	public BaseHandler baseHandler;
	private EBookPage eBookPage;
	private FlashCardPage flashCardPage;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		myResultsTabPage=new MyResultsTabPage(driver);
		paymentsPage=new PaymentsPage(driver);
		baseHandler = new BaseHandler(driver);
		eBookPage=new EBookPage(driver);
		flashCardPage=new FlashCardPage(driver);
	}


	@TestAnnotations(testID="NewATI-860")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-860:Verify that flow tutorial lessons and simulations.")
	public void NewATI860_VerifyThatFlowTutorialLessonsAndSimulations() throws Exception {
		log(logger, "NewATI860_VerifyThatFlowTutorialLessonsAndSimulations Starts ");

//		loginPage.enterURL("newati.login.url");
		//
		log(logger, "login to application with existing user ");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulseuser"), PropertiesRepository.getString("newati.login.password"));
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spent time for NurseLogic");
		
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage
				.verifyAllBeginLessonInCardBackForNurseLogic(PropertiesRepository
						.getString("new-atitesting.learntab.tutorial.nurse.logic.card.back.name.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage
				.clickBeginLessonButtonInNurseLogicCardBackNew(PropertiesRepository.getString("new-atitesting.learntab.tutorial.128.nurse.logic.card.front.module.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickTutorialCloseButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,
				"Verify time spent for  Skills Module ");
		tutorialPage.selectCardFrontBasedOnModuleName("Skills Modules 2.0");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage
		.clickBeginLessonButtonInSkillsModuleCardBack(PropertiesRepository.getString("new-atitesting.learntab.railway.management.section.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickTutorialCloseButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
//		Calendar currentTime1 = tutorialPage
//				.getTimeSpentInCardBackForNurseLogic(PropertiesRepository.getString("new-atitesting.learntab.railway.management.section.name"));
//		// Step 20 Start
//		Calendar updatedTime2 = tutorialPage
//				.getTimeSpentInCardBackForNurseLogic(PropertiesRepository
//						.getString("new-atitesting.learntab.railway.management.section.name"));
//		VerificationHandler.verifyTrue(tutorialPage.verifyTimeDifference(currentTime, updatedTime), "Unable to verify time difference");
		// Step 5 End
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		eBookPage.myATILearnTabPageSelectEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebookstype.select.loc"),
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.type.selectebooks.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		eBookPage.selectCardFrontBasedOnModuleNameeBook("RN eBook Library");
				
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		eBookPage.clickEBookButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickTutorialCloseButton();
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.ebook"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//boolean newUser=tutorialPage.clickOnAgreementCheckBox();
		tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickTutorialCloseButton();
//		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new.ATI"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Flash Card from Learn Tab");
		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
						.getString("new-atitesting.flashCardDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//String flashCardName = flashCardPage.getFlashCardNameInCardFront();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		flashCardPage.clickOnFlashcardModules();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
//		flashCardPage.beginLesson();
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
////		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button.flash"));
////		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button.flash"), 0);
//		tutorialPage.clickTutorialCloseButton();
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Home Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(homePage.verifyTutorailsLinkNamesInRecentActivitySection("new-atitesting.all.recentactivity.loc"),"All the tutorials not displayed inRecent Activity section");
		 VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
			      PropertiesRepository
			        .getString("new-atitesting.userAccountInpt"),
			      "Unable to verify My Account link");
		 log(logger, "Clicking on MyResults Tab and Verify the All result Under Result sections");
			homePage.clickTab(2);
			myResultsTabPage.verifyResultSection();
			VerificationHandler.verifyTrue(myResultsTabPage.verifyResultSection(), "Unable to verify My Results Tab ");
			
//			myResultsTabPage.verifyTutorailsLinkNamesInResultPage("new-atitesting.all.resulttab.section.loc");
//			VerificationHandler.verifyTrue(myResultsTabPage.verifyTutorailsLinkNamesInResultPage("new-atitesting.all.resulttab.section.loc"), "Unable to verify My Results Tab ");
		log(logger, "NewATI860_VerifyThatFlowTutorialLessonsAndSimulations End");		
			}
}
