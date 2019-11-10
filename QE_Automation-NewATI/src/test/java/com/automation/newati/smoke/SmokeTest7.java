package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;


public class SmokeTest7 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private EBookPage eBookPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyATITabMainPage myATITabMainPage;
	private HelpPage helpPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {

		loginPage = new LoginPage(driver);
		homePage= new HomePage(driver);
		eBookPage = new EBookPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		helpPage = new HelpPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name.ebook"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		
	}

	@TestAnnotations(testID="NewATI-36")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Validate user is able to access eBooks::Learn Tab")
	public void NewATI36_VerifyEBookTest() throws DriverException, Exception {
		log(logger, "NewATI36_VerifyEBookTest Start");
		
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		//homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Select EBook in Learn Tab - Type.
		eBookPage.myATILearnTabPageSelectEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebookstype.select.loc"),
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.type.selectebooks.value"));

		// Open eBook
		eBookPage.myATILearnTabPageOpenEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebooksmodule.link"));
		
		eBookPage.clickEBookButton();
		
		
		VerificationHandler
		.verifyTrue(eBookPage.verifyPdfContinueButtonIsDisplayed(), "Unable to verify button in PDF");
		
		eBookPage.clickOnPdfClosButton();
		log(logger, "NewATI36_VerifyEBookTest End");
	}
	
	@TestAnnotations(testID="NewATI-543")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Validate student is able to take Smartprep Reading module::Learn Tab")
	public void NewATI543_ValidateSmartPrepReadingModuleTest() throws Exception {
		log(logger, "NewATI543_ValidateSmartPrepReadingModuleTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname.Smartprep"), PropertiesRepository.getString("newati.login.payment.individual.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(1);
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
	
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));

		//boolean newUser=tutorialPage.clickOnAgreementCheckBox();
		
		log(logger, "cliking on the pretest btutton of card back");
		tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name"));
		
		log(logger, "cliking on the close btutton of SmartPrep");
		tutorialPage.closeSmartPrepAndCheckIfNewUser();
		
		
		
	/*	tutorialPage.takeTEASSmartPrep(false);
		
		log(logger, "Clicking on My Personalized Study plan");
		tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
		
		log(logger, "Clicking on close button");
		tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);

		log(logger, "Clicking on Quizzes tab");
		tutorialPage.clickButtonFromList("new-atitesting.smartprep.quizzes.tab.loc", 0);
		
		log(logger, "Clicking on Personalized Button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.smartprep.personalized.button"));
		
		tutorialPage.completeQuiz("new-atitesting.smartprep.quizzes.link");
		
		
		log(logger, "Clicking on launch posttest button");
		tutorialPage.clickOnLaunchPostTestButton();
		
		log(logger, "Clicking on Begin Test Button");
		tutorialPage.clickButton("#startTest");
		
		log(logger, "taking test");
		tutorialPage.takeTEASSmartPrep(false);
		
		log(logger, "Clicking on My Personalized Study plan/Full Study Plan Button");
		tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
		
		log(logger, "Clicking on close button");
		tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);
		
		log(logger, "Clicking on Quizzes tab");
		tutorialPage.clickButtonFromList("new-atitesting.smartprep.quizzes.tab.loc", 0);
		
		log(logger, "taking quiz sections wise");
		tutorialPage.completeQuiz("new-atitesting.smartprep.quizzes.link");
		
		
		log(logger, "Clicking on launch posttest button");
		tutorialPage.clickOnLaunchPostTestButton();
		
		log(logger, "Clicking on Begin Test Button");
		tutorialPage.clickButton("#startTest");
		
		log(logger, "taking test");
		tutorialPage.takeTEASSmartPrep(false);
		
		log(logger, "Clicking on My Personalized Study plan/Full Study Plan Button");
		tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);*/		
		
		log(logger, "NewATI543_ValidateSmartPrepReadingModuleTest End");
	}

	
	@TestAnnotations(testID="NewATI-41")
	@Test(priority =1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Check for simulation::Apply Tab")
	public void NewATI41_VerifySimulations() throws Exception {
		log(logger, "NewATI41_VerifySimulations Start");

		// step -3
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//we should validate MYATI page loaded and we should verify all the tabs under MYATI page
		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//we should check the simulation product avilable or not
		// step-4
		log(logger, "Click on Modules ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));

		// step-5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Begin case button ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.modules"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));

		log(logger, "Verify Simulation tab");
		boolean result = helpPage.verifySimulationsPage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-6
		log(logger, "Click on close button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));

		VerificationHandler.verifyTrue(result,"Simulation module is not present");
		log(logger, "NewATI41_VerifySimulations End");
	}
	


}




