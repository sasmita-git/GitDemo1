package com.automation.id.oldtests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class NewProductsPageTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ProductsPage productsPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		productsPage = new ProductsPage(driver);
	}
	/**
	 * Verification of PDF is pending. Informed to Angandeep. 
	 * 
	 * @throws Exception
	 */
	
	@TestAnnotations(testID="INST-2002")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify generate memo on products page.")
	public void INST2002_VerifyGenerateMemoFunctionality() throws Exception {
		log(logger, "INST2002_VerifyGenerateMemoFunctionality Start");
		logger.info("INST2002_VerifyGenerateMemoFunctionality Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Highlights Tab");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.highlights.tab.loc"), true),
		"Unable to Click on Highlights Tab");
		
		/*log(logger, "Verifying Header of Products Page");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.page.header.loc", 0, PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value")), 
		"Unable to Verify Header of Products Page");*/
		// Step 1
		log(logger, "Clicking on Three dots on Right Corner");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.right.corner.three.dots.loc"), true), "Unable to Click on Three dots on Right Corner");
		// Step 2
		log(logger, "Verifying Generate Memo link from menu");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.right.corner.three.dots.menu.list.loc",
				0, PropertiesRepository.getString("id.product.right.corner.three.dots.menu.list.value2")), "Unable to Verify Generate Memo link from menu");		
		// Step 2
		log(logger, "Clicking Generate Memo link from menu");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.right.corner.three.dots.menu.list.loc"), 1, true), "Unable to Click Generate Memo link from menu");
		
		log(logger, "INST2002_VerifyGenerateMemoFunctionality End");
		logger.info("INST2002_VerifyGenerateMemoFunctionality End");
	}
	
	@TestAnnotations(testID="INST-2003")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify course work card on highlights page.")
	public void INST2003_VerifyCourseWorkCardInHighlightsPage() throws Exception {
		log(logger, "INST2003_VerifyCourseWorkCardInHighlightsPage Start");
		logger.info("INST2003_VerifyCourseWorkCardInHighlightsPage Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 1
		log(logger, "Clicking on Highlights Tab");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.highlights.tab.loc"), true),
		"Unable to Click on Highlights Tab");
		// Step 1
		/*log(logger, "Verifying Header of Products Page");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.page.header.loc", 0, PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value")), 
		"Unable to Verify Header of Products Page");*/
		// Step 2, 5, 6
		log(logger, "Verifying Course Work Section");
		VerificationHandler.verifyTrue(
		productsPage.clickTutorialManageButtonForPersonnelUser(), "Unable to Verify Course Work Section");
		// Step 7
		log(logger, "Verify Manage Products Tab in Products Page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",0));
		
		log(logger, "INST2003_VerifyCourseWorkCardInHighlightsPage End");
		logger.info("INST2003_VerifyCourseWorkCardInHighlightsPage End");
	}

	@TestAnnotations(testID="INST-2067")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check new Highlights page.")
	public void INST2067_VerifyNewHighlightsPage() throws Exception {
		log(logger, "INST2067_VerifyNewHighlightsPage Start");
		logger.info("INST2067_VerifyNewHighlightsPage Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 1
		log(logger, "Clicking on Highlights Tab");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.highlights.tab.loc"), true),
		"Unable to Click on Highlights Tab");
		// Step 1
		log(logger, "Verifying Header of Products Page");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.page.header.updated.loc", 0, PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value")), 
		"Unable to Verify Header of Products Page");
		/*// Step 1
		log(logger, "Verifying Course Work Header tab");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.highlights.tab.course.work.assessment.loc", 0, PropertiesRepository.getString("id.product.page.tutorial.header.value")),
		"Unable to Verify Course Work Header tab");
		// Step 1
		log(logger, "Verifying Assessment Header tab");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.highlights.tab.course.work.assessment.loc", 1, PropertiesRepository.getString("id.common.assessment.value")),
		"Unable to Verify Assessment Header tab");*/
		// Step 1
		log(logger, "Verifying Student count");
		VerificationHandler.verifyTrue(
		productsPage.verifyTextContains(PropertiesRepository.getString("id.product.right.corner.student.number.loc"), PropertiesRepository.getString("id.common.student.value")),
				"Unable to Verify Student count");
		// Step 1
		log(logger, "Verifying Pulse Portlet");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.home.dashboard.subtitle.name.loc", 0, PropertiesRepository.getString("id.common.pulse.value")),
				"Unable to Verify Pulse Portlet");
		// Step 1
		log(logger, "Verifying Course Work Portlet");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.home.dashboard.subtitle.name.loc", 1, PropertiesRepository.getString("id.product.page.tutorial.header.value")),
				"Unable to Verify Course Work Portlet");
		// Step 1 verifyTextContains
		log(logger, "Verifying Practice Assessment Portlet");
		VerificationHandler.verifyTrue(
		productsPage.verifyTextContains(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc"), PropertiesRepository.getString("new-atitesting.myati.assessment.type"), 2), 
		"Unable to Verify Practice Assessment Portlet");
		// Step 1
		log(logger, "Verifying Proctored Assessment Portlet");
		VerificationHandler.verifyTrue(
		productsPage.verifyTextContains(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc"), PropertiesRepository.getString("id.common.proctored.assessment.value"), 3),
		"Unable to Verify Proctored Assessment Portlet");
		
		// Step 2
		log(logger, "Clicking on Three dots on Right Corner");
		VerificationHandler.verifyTrue(
		productsPage.verifyAndClick(PropertiesRepository.getString("id.product.right.corner.three.dots.loc"), true), "Unable to Click on Three dots on Right Corner");
		// Step 2
		log(logger, "Verifying Filter by content area link from menu");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.right.corner.three.dots.menu.list.loc",
				0, PropertiesRepository.getString("id.product.right.corner.three.dots.menu.list.value1")), "Unable to Verify Filter by content area link from menu");
		// Step 2
		log(logger, "Verifying Generate Memo link from menu");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.right.corner.three.dots.menu.list.loc",
				1, PropertiesRepository.getString("id.product.right.corner.three.dots.menu.list.value2")), "Unable to Verify Generate Memo link from menu");		
		// Step 2
		log(logger, "Verifying Manage student roster link from menu");
		VerificationHandler.verifyTrue(
		productsPage.verifyMessage("id.product.right.corner.three.dots.menu.list.loc",
				2, PropertiesRepository.getString("id.product.right.corner.three.dots.menu.list.value3")), "Unable to Verify Manage student roster link from menu");
		
		log(logger, "INST2067_VerifyNewHighlightsPage End");
		logger.info("INST2067_VerifyNewHighlightsPage End");
	}
	
	
}
