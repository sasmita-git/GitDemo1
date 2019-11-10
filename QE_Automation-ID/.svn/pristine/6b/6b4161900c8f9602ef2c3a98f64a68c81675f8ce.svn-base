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

public class Smoke_ITR_BV_TEAS_PreviewTest extends BaseTest {

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

	@TestAnnotations(testID = "INST-Preview_ITR_BV_TEAS")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Smoke_ITR_BV_TEAS_PreviewTest :: Verify faculty can preview various Practice Assessments/Tutorials")
	public void INST_Validate_ITR_BV_TEAS_Preview() throws Exception {
		logger.info("INST_VerifyFacultyPreviewItemType Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor4.username"),
				PropertiesRepository.getString("id.auto.prd.instuctor4.password"));
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
		// inst-1803:Verify faculty can preview Item Type Regression Test(OP)
		// *******
		log(logger, "click on practice assessment tab");
		homePage.selectPracticeAssessmentTab();

		logger.info("Verifying Practice Assessments Tab is displayed");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.product.manage.products.preview.assessment.loc", 0));

		log(logger, "click on preview assessment name");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.clickOnPreviewAssessmentButton(
						PropertiesRepository.getString("id.practice.assessment.1803.names")),
				"Unable to click on Practice Assessment");

		log(logger, "click on assessment start button");
		practiceAssessmentPage.clickOnStartAssessment();

		log(logger, "verify Objects On The Assessment Page");
		boolean resultitr1 = practiceAssessmentPage.verifyObjectsOnTheAssessmentPage();
		VerificationHandler.verifyTrue(resultitr1, "Objects are not present on the assessment page");

		log(logger, "verify close button on the assessment page");
		boolean resultitr2 = practiceAssessmentPage.clickPracticeAssessmentCloseX(
				PropertiesRepository.getString("new-atitesting.question.assement.question.close.button.new"), true);
		VerificationHandler.verifyTrue(resultitr2, "close button is not present");

		logger.info("INST_VerifyFacultyPreviewItemType End");


		// *******
		// INST2073 Verify preview is available for Board Vitals > NCLEX
		// Adaptive Test
		// *******
		logger.info("INST2073_VerifyBoardVitalsNCLEXPrep Start");

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

		log(logger, "Clicking on Board Vitals NCLEX Prep RN Tutorial");
		int indexNCLEX = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.2703.name"));

		log(logger, "Clicking on Preview Button");
		tutorialPage.clickOnPreviewModuleImg(indexNCLEX, 8);
		Thread.sleep(40000);
		
		log(logger, "verify Objects On The Boardvitals LTI Page");
		boolean resultbv1 = tutorialPage.verifyObjectsOnTheBVLTIPage();
		VerificationHandler.verifyTrue(resultbv1, "Objects are not present on the Boardvitals LTI page");

		log(logger, "verify close button on the LTI page");
		boolean resultbv2 = tutorialPage.clickLTICloseX();
		VerificationHandler.verifyTrue(resultbv2, "close button is not present");
			
		boolean isEleDisplayedNCLEX = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 0);
		VerificationHandler.verifyTrue(isEleDisplayedNCLEX, "Element is not visible");

		logger.info("INST2073_VerifyBoardVitalsNCLEXPrep End");

						
		// *******
		// INST-1605:Verify instructor is able to preview ATI TEAS SmartPrep
		// *******
		log(logger, "INST1605_VerifyTEAS Start");

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		// loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		// loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "verify Manage Products tab name");
		VerificationHandler
				.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc", 0));

		log(logger, "click on Tutorial assessment tab");
		VerificationHandler.verifyTrue(homePage.selectTutorialTab(), "Unable to click on Tutorial assessment tab");

		log(logger, "Clicking on ATI TEAS Access Modules");
		int indexteas = tutorialPage
				.clickAndExpandAccessModulesSection(PropertiesRepository.getString("id.tutorial.1605.name"));

		log(logger, "Clicking on Preview Button");
		VerificationHandler.verifyTrue(tutorialPage.clickOnPreviewModuleImg(indexteas, 6),
				"Unable to Clicking on Preview Button");

		tutorialPage.goToMainWindow();

		log(logger, "verify Objects On The TEAS SmartPrep Page");
		boolean resultteas = practiceAssessmentPage.verifyObjectsOnTheTeasSmartPrepPage();
		VerificationHandler.verifyTrue(resultteas, "Objects are not present on the TEAS SmartPreps page");

		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyContainsMessageWithDefaultSwitch(
						PropertiesRepository.getString("id.product.tutorial.teas.smart.prep.assessment.name.loc"), 0,
						PropertiesRepository.getString("id.product.tutorial.teas.smart.prep.assessment.name.value")),
				"Unable to verify Assessment name");

		log(logger, "Click on close button."); // #lblModuleName
		tutorialPage.clickTeasCloseButton("Id.TEAS.Close.Loc", 0);

		boolean isEleDisplayedTEAS = homePage.isElementDisplayed("id.homepage.product.sub.tab.loc", 0);
		VerificationHandler.verifyTrue(isEleDisplayedTEAS, "Element is not visible");
		log(logger, "INST1605_VerifyTEAS End");
		logger.info("INST1605_VerifyTEAS End");

	}
}
