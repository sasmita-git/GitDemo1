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

public class PracticeAssessmentTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private EditProfilePage editProfilePage;
	private HomePage homePage;
	private PracticeAssessmentPage practiceAssessmentPage;
	private TutorialPage tutorialPage;
	private WindowHandler windowHandler;
	private IDBasePage idbasePage;

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

	@TestAnnotations(testID = "INST-1803")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "inst-1803:Verify faculty can preview Item Type Regression Test(OP)")
	public void INST1803_VerifyFacultyPreviewItemType() throws Exception {
		logger.info("INST1803_VerifyFacultyPreviewItemType Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));
		
		log(logger, "click on practice assessment tab");
		homePage.selectPracticeAssessmentTab();
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		logger.info("Verifying Practice Assessments Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.product.manage.products.preview.assessment.loc",0));
		//Item Type Regression Test (OP)
		log(logger, "click on preview assessment name");
		VerificationHandler.verifyTrue(practiceAssessmentPage
				.clickOnPreviewAssessmentButton(PropertiesRepository.getString("id.practice.assessment.1803.names")), "Unable to click on Practice Assessment");
		
		log(logger, "click on assessment start button");
		practiceAssessmentPage.clickOnStartAssessment();

		log(logger, "verify Objects On The Assessment Page");
		boolean result = practiceAssessmentPage.verifyObjectsOnTheAssessmentPage();
		VerificationHandler.verifyTrue(result, "Objects are not present on the assessment page");

		log(logger, "verify close button on the assessment page");
		boolean result1 = practiceAssessmentPage.clickPracticeAssessmentCloseBtn(
				PropertiesRepository.getString("new-atitesting.question.assement.question.close.button.new"), true);
		VerificationHandler.verifyTrue(result1, "close button is not present");

		log(logger, "clicking on Yes button");
		practiceAssessmentPage.clickPracticeAssessmentYesBtn(PropertiesRepository.getString("new-atitesting.question.assement.question.close.yes.button.new"), true);
		
		logger.info("INST1803_VerifyFacultyPreviewItemType End");
	}

	@TestAnnotations(testID = "INST-1911")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1911:Verify Preview STT Module as faculty")
	public void INST1911_VerifyPreviewSTT() throws Exception {
		logger.info("INST1911_VerifyPreviewSTT Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on STT Access Modules");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1911.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(index, 6), "Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.test", 0), "Unable to click on beginTest Button");

		logger.info("Clicking on Start Assessment Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnSkillModuleStartAssessmentButton("start.assessment.loc"), "Unable to Clicking on Start Assessment Button");

		log(logger, "Click on Proceed Button.");
		tutorialPage.clickButtonFromListForSTT("start.assessment.proceed.button", 0);

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The STT Assessment Page");
		boolean result = practiceAssessmentPage.verifyObjectsOnTheSTTAssessmentPage();
		VerificationHandler.verifyTrue(result, "Objects are not present on the STT assessment page");

		tutorialPage.goToMainWindow();
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(
		tutorialPage.verifySTTMessageWithSwitchToAssessment(
				PropertiesRepository.getString("id.product.tutorial.assessment.name.loc"), 2,
				"STT"),
		"Unable to verify Assessment Name");
		
		/*log(logger, "Verifying Assessment Name");
		practiceAssessmentPage.verifyMessageWithSwitchToAssessment(PropertiesRepository.getString("id.portal.product.tutorial.assessment.name.loc")
				, 2, PropertiesRepository.getString("id.tutorial.1911.assessment.name"));
		
		log(logger, "Click on assessment close button.");
		tutorialPage.clickOnCloseButtonWithSwitchToAssessment("practice.assessment.close.button", 0);*/

		tutorialPage.navigateToParentWindow();

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.lession", 0);

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickOnCloseButton("id.portal.product.schedule.popup.close.button.loc", 0);

		boolean isEleDisplayed = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayed, "Element is not visible");

		logger.info("INST1911_VerifyPreviewSTT End");
	}

	@TestAnnotations(testID = "INST-1605")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "INST-1605:Verify instructor is able to preview ATI TEAS SmartPrep")
	public void INST1605_VerifyTEAS() throws Exception {
		logger.info("INST1605_VerifyTEAS Start");
		
		log(logger, "INST1605_VerifyTEAS Start");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on ATI TEAS Access Modules");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1605.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(index, 6), "Unable to Clicking on Preview Button");

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The TEAS SmartPrep Page");
		boolean result = practiceAssessmentPage.verifyObjectsOnTheTeasSmartPrepPage();
		VerificationHandler.verifyTrue(result, "Objects are not present on the TEAS SmartPreps page");

		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyContainsMessageWithDefaultSwitch(
						PropertiesRepository.getString("id.product.tutorial.teas.smart.prep.assessment.name.loc"), 0,
						PropertiesRepository.getString("id.product.tutorial.teas.smart.prep.assessment.name.value")),
				"Unable to verify Assessment name");
		
		log(logger, "Click on close button."); //#lblModuleName
		tutorialPage.clickTeasCloseButton("Id.TEAS.Close.Loc", 0);

		windowHandler.switchToLatestWindow();
		boolean isEleDisplayed = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 0);
		VerificationHandler.verifyTrue(isEleDisplayed, "Element is not visible");
		log(logger, "INST1605_VerifyTEAS End");
		logger.info("INST1605_VerifyTEAS End");
	}

	//@TestAnnotations(testID = "INST-2073")
	//@Test(priority = 4, alwaysRun = true, enabled = true, groups = { "Smoke"}, description = "Verify preview is available for Board Vitals > NCLEX Adaptive Test")
	public void INST2073_VerifyNCLEXPreview() throws Exception {
		logger.info("INST2073_VerifyNCLEXPreview Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on products tab");
		loginPage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1911.cohort.name"));

		log(logger, "click on Tutorial assessment tab");
		homePage.selectTutorialTab();

		log(logger, "Clicking on NCLEX®-RN Live Review Tutorial");
		// tutorialPage.clickOnAccessModuleButton(PropertiesRepository.getString("id.tutorial.1911.name"));
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.2703.name"));

		log(logger, "Clicking on Preview Button");
		tutorialPage.clickOnPreviewModuleImg(index, 8);

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromList("id.portal.product.tab.tutorial.begin.lession", 0);
        Thread.sleep(60000);
        
		log(logger, "Click on close button.");
		tutorialPage.clickOnCloseButton("id.portal.product.schedule.popup.close.button.loc", 0);

		windowHandler.switchToLatestWindow();
		boolean isEleDisplayed = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 0);
		VerificationHandler.verifyTrue(isEleDisplayed, "Element is not visible");

		logger.info("INST2073_VerifyNCLEXPreview End");
	}

	@TestAnnotations(testID = "INST-1891")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1891:Verify Dynamic Quizzes preview/access Tests of Learning System RN 3.0")
	public void INST1891_VerifyLSRN30() throws Exception {
		logger.info("INST1891_VerifyLSRN30 Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on STT Access Modules");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1891.new.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(index, 6), "Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.test", 0), "Unable to click on beginTest Button");

		logger.info("Clicking on Start Assessment Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnSkillModuleStartAssessmentButton("start.assessment.loc"), "Unable to Clicking on Start Assessment Button");

		log(logger, "Click on Proceed Button.");
		tutorialPage.clickButtonFromListForSTT("start.assessment.proceed.button", 0);

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The STT Assessment Page");
		boolean result = practiceAssessmentPage.verifyObjectsOnTheSTTAssessmentPage();
		VerificationHandler.verifyTrue(result, "Objects are not present on the STT assessment page");

		tutorialPage.goToMainWindow();
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(
		tutorialPage.verifyMessageWithSwitchToAssessment(
				PropertiesRepository.getString("id.product.tutorial.assessment.name.loc"), 2,
				PropertiesRepository.getString("id.tutorial.1891.assessment.name")),
		"Unable to verify Assessment Name");
		
		/*log(logger, "Click on assessment close button.");
		tutorialPage.clickOnCloseButton("id.product.tutorial.assessment.close.button.loc", 0);*/

		tutorialPage.navigateToParentWindow();

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.lession", 0);

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickOnCloseButton("id.portal.product.schedule.popup.close.button.loc", 0);

		boolean isEleDisplayed = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayed, "Element is not visible");

		logger.info("INST1891_VerifyLSRN30 End");
	}
	
	@TestAnnotations(testID = "INST-1892")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1892:Verify Dynamic Quizzes preview/access Tests of Learning System PN 3.0")
	public void INST1892_VerifyLSPN30() throws Exception {
		logger.info("INST1892_VerifyLSPN30 Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on STT Access Modules");
		int index = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1892.new.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(index, 6), "Unable to Clicking on Preview Button");

		log(logger, "click on beginTest Button");
		VerificationHandler.verifyTrue(tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.test", 0), "Unable to click on beginTest Button");

		logger.info("Clicking on Start Assessment Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnSkillModuleStartAssessmentButton("start.assessment.loc"), "Unable to Clicking on Start Assessment Button");

		log(logger, "Click on Proceed Button.");
		tutorialPage.clickButtonFromListForSTT("start.assessment.proceed.button", 0);

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The STT Assessment Page");
		boolean result = practiceAssessmentPage.verifyObjectsOnTheSTTAssessmentPage();
		VerificationHandler.verifyTrue(result, "Objects are not present on the STT assessment page");

		tutorialPage.goToMainWindow();
		
		log(logger, "Verifying Assessment Name");
		VerificationHandler.verifyTrue(
		tutorialPage.verifyMessageWithSwitchToAssessment(
				PropertiesRepository.getString("id.product.tutorial.assessment.name.loc"), 2,
				PropertiesRepository.getString("id.tutorial.1892.assessment.name")),
		"Unable to verify Assessment Name");
		
		/*log(logger, "Verifying Assessment Name");
		tutorialPage.verifyMessage("id.portal.product.tutorial.assessment.name.loc", 0, PropertiesRepository.getString("id.tutorial.1892.assessment.name"));
		
		log(logger, "Click on assessment close button.");
		tutorialPage.clickOnCloseButton("practice.assessment.close.button", 0);*/

		tutorialPage.navigateToParentWindow();

		log(logger, "click on begin lesson Button");
		tutorialPage.clickButtonFromListForSTT("id.portal.product.tab.tutorial.begin.lession", 0);

		tutorialPage.navigateToParentWindow();

		log(logger, "Click on close button.");
		tutorialPage.clickOnCloseButton("id.portal.product.schedule.popup.close.button.loc", 0);

		boolean isEleDisplayed = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 1);
		VerificationHandler.verifyTrue(isEleDisplayed, "Element is not visible");

		logger.info("INST1892_VerifyLSPN30 End");
	}
}
