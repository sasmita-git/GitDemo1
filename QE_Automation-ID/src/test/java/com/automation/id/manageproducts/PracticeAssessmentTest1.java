package com.automation.id.manageproducts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.IDBasePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.PracticeAssessmentPage;
import com.automation.id.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PracticeAssessmentTest1 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	EditProfilePage editProfilePage;
	HomePage homePage;
	PracticeAssessmentPage practiceAssessmentPage;
	TutorialPage tutorialPage;
	WindowHandler windowHandler;
	IDBasePage idbasePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
		tutorialPage = new TutorialPage(driver);
		windowHandler = new WindowHandler(driver);
		idbasePage = new IDBasePage(driver);
		practiceAssessmentPage = new PracticeAssessmentPage(driver);
	}

	
	@TestAnnotations(testID = "INST-1872")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "INST-1872:Preview Real Life Simulation Module")
	public void INST1872_VerifyPreviewRealLifeScenario() throws Exception {
		logger.info("INST1872_VerifyPreviewRealLifeScenario Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.faculty.1872.login.username"),
				PropertiesRepository.getString("id.faculty.1872.login.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 1, "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");
		
		log(logger, "Clicking on  Real Life simulation ");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1872.new.name"));

		log(logger, "Clicking on Preview Button");
		tutorialPage.clickOnPreviewModuleImg(index, 6);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "Clicking on Begin Scenario");
		VerificationHandler.verifyTrue(tutorialPage.verifyBeginScenrioAndOptimalDecisions(),
				"Verifying Being Scenario and Optimal Decisions");

		log(logger, "Clicking on Begin Scenarios");
		homePage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.tutorial.begin.scenario.button.loc"), 0,
				true);
		// The Tutorial name is an image, could not be verified.
		/*log(logger, "Verifying Real Life name");
		practiceAssessmentPage.verifyAssessmentNameWithSwitchToContentFrame(PropertiesRepository.getString("id.product.tutorial.real.life.assessment.name.header.loc"), 1, 
				PropertiesRepository.getString("id.product.tutorial.real.life.assessment.name.header.value"));*/
		
		log(logger, "Clicking on Begin Scenarios Close Button");
		practiceAssessmentPage.verifyAndClickWithSwitchToContentFrame(
				PropertiesRepository.getString("new-atitesting.simulation.real.life.begin.test.close.button.loc"), 0, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "Clicking on Begin Scenario");
		VerificationHandler.verifyTrue(tutorialPage.verifyBeginScenrioAndOptimalDecisions(),
				"Verifying Being Scenario and Optimal Decisions");
		
		log(logger, "Clicking on Begin Scenarios Close Button");
		practiceAssessmentPage.verifyAndClickWithSwitchToContentFrame(
				PropertiesRepository.getString("new-atitesting.simulation.real.life.begin.test.close.button.loc"), 0, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));
		
		log(logger, "INST1872_VerifyPreviewRealLifeScenario End");

	}
}
