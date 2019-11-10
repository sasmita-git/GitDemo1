package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifySmartPrepModuleTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private WindowHandler windowHandler;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		windowHandler = new WindowHandler(driver);
	}

	@TestAnnotations(testID="NewATI-543")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Validate student is able to take Smartprep Reading module::Learn Tab")
	public void NewATI543_ValidateSmartPrepReadingModuleTest() throws Exception {
		log(logger, "NewATI543_ValidateSmartPrepReadingModuleTest Start");
		
		loginPage.loginToApplication("stagepulse21","Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//boolean newUser=tutorialPage.clickOnAgreementCheckBox();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "cliking on the pretest btutton of card back");
		tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "cliking on the close btutton of SmartPrep");
		tutorialPage.closeSmartPrepAndCheckIfNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
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


//for maintainance

@Test(priority=1,description = "Smoke NewATI-543:Validate student is able to take Smartprep Reading module")
public void NewATI778_ValidateSmartPrepReadingModuleTestMaintainance() throws Exception {
	log(logger, "NewATI778_ValidateSmartPrepReadingModuleTest Start");
	
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
	
	log(logger, "Clicking on Close Button");
	tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
	tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
}


	@Test(priority=3, alwaysRun = true, enabled = true, groups = "{smoke}", description = "Validate student is able to take Smartprep English module::Learn Tab")
	public void NewATI544_ValidateSmartPrepEnglishModuleTest() throws Exception {
	log(logger, "NewATI544_ValidateSmartPrepEnglishModuleTest Start");
	
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname.Smartprep"), PropertiesRepository.getString("newati.login.payment.individual.sem.pwd"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(1);
	
	log(logger, "Clicking on My ATI Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Selecting Tutorial from Learn Tab");
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking Module by Name");
	tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on preTest button for English Module");
	tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.eng"));
	
	windowHandler.switchToFrame("OpenPageFrame");
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPreTest(),false,false);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on My Personalized Study plan");
	tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
	
	log(logger, "Clicking on close button");
	tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);
	
	log(logger, "Clicking on launch posttest button");
	tutorialPage.clickOnLaunchPostTestButton();
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPostTest(),false,false);
	
	log(logger, "verifying close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	
	log(logger, "click on cardback close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	
	log(logger,"click on signout button");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
	
	log(logger,"NewATI544_ValidateSmartPrepEnglishModuleTest Ends");
	
}
	
	@Test(priority=4, alwaysRun = true, enabled = true, groups = "{smoke}", description = "Validate student is able to take Smartprep English module::Learn Tab")
	public void NewATI545_ValidateSmartPrepMathsModuleTest() throws Exception {
	log(logger, "NewATI545_ValidateSmartPrepMathsModuleTest Start");
	
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname.Smartprep"), PropertiesRepository.getString("newati.login.payment.individual.sem.pwd"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(1);
	
	log(logger, "Clicking on My ATI Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Selecting Tutorial from Learn Tab");
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking Module by Name");
	tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on preTest button for Maths Module");
	tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.maths"));
	
	windowHandler.switchToFrame("OpenPageFrame");
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPreTest(),false,false);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on My Personalized Study plan");
	tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
	
	log(logger, "Clicking on close button");
	tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);
	
	log(logger, "Clicking on launch posttest button");
	tutorialPage.clickOnLaunchPostTestButton();
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPostTest(),false,false);
	
	log(logger, "verifying close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	
	log(logger, "click on cardback close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	
	log(logger,"click on signout button");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
	
	log(logger,"NewATI545_ValidateSmartPrepMathsModuleTest Ends");
	
}
	
	@Test(priority=4, alwaysRun = true, enabled = true, groups = "{smoke}", description = "Validate student is able to take Smartprep English module::Learn Tab")
	public void NewATI546_ValidateSmartPrepScienceModuleTest() throws Exception {
	log(logger, "NewATI546_ValidateSmartPrepScienceModuleTest Start");
	
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname.Smartprep"), PropertiesRepository.getString("newati.login.payment.individual.sem.pwd"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(1);
	
	log(logger, "Clicking on My ATI Tab");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Selecting Tutorial from Learn Tab");
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking Module by Name");
	tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on preTest button for Science Module");
	tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.science"));
	
	windowHandler.switchToFrame("OpenPageFrame");
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPreTest(),false,false);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on My Personalized Study plan");
	tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
	
	log(logger, "Clicking on close button");
	tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);
	
	log(logger, "Clicking on launch posttest button");
	tutorialPage.clickOnLaunchPostTestButton();
	
	log(logger, "Clicking on Begin Test Button");
	tutorialPage.clickButton("#startTest");
	
	tutorialPage.takeTEASSmartPrep(CommonUtils.readingPostTest(),false,false);
	
	log(logger, "verifying close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	
	log(logger, "click on cardback close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	
	log(logger,"click on signout button");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
	
	log(logger,"NewATI546_ValidateSmartPrepScienceModuleTest Ends");
	
}
	
	
}