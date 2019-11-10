package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.PracticeAssessmentPage;
import com.automation.id.pages.ProductsPage;
import com.automation.id.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class Smoke_STT_SKM_RL_PreviewTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private PracticeAssessmentPage practiceAssessmentPage;
	private TutorialPage tutorialPage;
	private ProductsPage productsPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		practiceAssessmentPage = new PracticeAssessmentPage(driver);
		productsPage = new ProductsPage(driver);
	}
	
	@TestAnnotations(testID = "INST-Preview_STT_SKM_RL")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Smoke_STT_SKM_RL_PreviewTest :: Verify faculty can preview various Practice Assessments/Tutorials")
	public void INST_Validate_STT_SKM_RL_Preview() throws Exception {
		logger.info("INST_VerifyFacultyPreviewItemType Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor5.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor5.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products");

		log(logger, "verify Manage Products tab name");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc", 0));

		log(logger, "Clicking on Cohort search img");
		VerificationHandler
				.verifyTrue(
						productsPage.verifyAndClick(
								PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
						"Unable to click on cohort search image");

		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(
						PropertiesRepository.getString("id.auto.prd.noncarp.institute")),
				"Unable to Click on Enter base Institution text box in home page");

		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.auto.prd.preview.cohort"));
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"), 0,
						PropertiesRepository.getString("id.auto.prd.preview.cohort")),
				"Unable to verify cohort name after searching");

		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(
						PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true),
				"Unable to click on cohort name after searching");
		

		// *******
		// INST-1911:Verify Preview STT Module as faculty
		// *******
		logger.info("INST1911_VerifyPreviewSTT Start");

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");

		log(logger, "verify Manage Products tab name");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc", 0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on STT Access Modules");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1911.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(index, 6),
				"Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(
				tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.test", 0),
				"Unable to click on beginTest Button");

		logger.info("Clicking on Start Assessment Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnSkillModuleStartAssessmentButton("start.assessment.loc"),
				"Unable to Clicking on Start Assessment Button");

		log(logger, "Click on Proceed Button.");
		tutorialPage.clickButtonFromListForSTT("start.assessment.proceed.button", 0);

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The STT Assessment Page");
		boolean resultstt = practiceAssessmentPage.verifyObjectsOnTheSTTAssessmentPage();
		VerificationHandler.verifyTrue(resultstt, "Objects are not present on the STT assessment page");

		tutorialPage.goToMainWindow();

		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(
				tutorialPage.verifySTTMessageWithSwitchToAssessment(
						PropertiesRepository.getString("id.product.tutorial.assessment.name.loc"), 0, "STT"),
				"Unable to verify Assessment Name");

		tutorialPage.navigateToParentWindow();

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.lession", 0);

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickOnCloseButton("id.portal.product.schedule.popup.close.button.loc", 0);

		boolean isEleDisplayedSTT = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayedSTT, "Element is not visible");

		logger.info("INST1911_VerifyPreviewSTT End");
		
		
		// *******
		// Verify Preview SKM Module as faculty
		// *******
		logger.info("VerifyPreviewSkillsModule Start");

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");

		log(logger, "verify Manage Products tab name");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc", 0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on SKM Access Modules");
		int indexskm = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.sklmdl.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(indexskm, 6),
				"Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(
				tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.test", 0),
				"Unable to click on beginTest Button");

		logger.info("Clicking on Start Assessment Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnSkillModuleStartAssessmentButton("start.assessment.loc"),
				"Unable to Clicking on Start Assessment Button");

		log(logger, "Click on Proceed Button.");
		tutorialPage.clickButtonFromListForSTT("start.assessment.proceed.button", 0);

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The SKM Assessment Page");
		boolean resultskm = practiceAssessmentPage.verifyObjectsOnTheSTTAssessmentPage();
		VerificationHandler.verifyTrue(resultskm, "Objects are not present on the STT assessment page");

		tutorialPage.goToMainWindow();

		log(logger, "Verifying SKL Module Name");
		VerificationHandler.verifyTrue(tutorialPage.verifySTTMessageWithSwitchToAssessment(
				PropertiesRepository.getString("id.product.tutorial.assessment.name.loc"), 0, "Skills Module 2.0"),
				"Unable to verify SKL Module Name");

		tutorialPage.navigateToParentWindow();

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.lession", 0);

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickLTICloseX();

		boolean isEleDisplayedSKM = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayedSKM, "Element is not visible");

		logger.info("VerifyPreviewSkillsModule End");
		

		// *******
		// Verify Preview Real Life RN Module as faculty
		// *******
		logger.info("VerifyRLRNModule Start");

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");

		log(logger, "verify Manage Products tab name");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc", 0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on RL Access Modules");
		int indexrl = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.rlrn.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(indexrl, 6),
				"Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(
				tutorialPage.clickButtonFromListForSTT("id.tutorial.begin.scenario.button.loc", 0),
				"Unable to click on beginTest Button");

//		tutorialPage.goToMainWindow();
		
		log(logger, "Verifying RL Module Name");
		VerificationHandler.verifyTrue(tutorialPage.verifyRLMessageWithSwitchToScorm(
				PropertiesRepository.getString("id.product.RL.Scorm.name.loc"), 0, "Real Life 2.0"),
				"Unable to verify RL Module Name");

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickLTICloseX();

		boolean isEleDisplayedRL = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayedRL, "Element is not visible");

		logger.info("VerifyRLRNModule End");

	}
}
