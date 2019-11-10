package com.automation.id.home2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class HomeTest2Director extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;
	BaseHandler basehandler;
	ProductsPage productsPage; 
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
		basehandler = new BaseHandler(driver);
		productsPage = new ProductsPage(driver);
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1954")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1954:Check for elements present in filter for institute and cohort for consortium director")
	public void INST1954_VerifyElementsInFilter() throws Exception {
		logger.info("INST1954_VerifyElementsInFilter Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.director2.username"),
				PropertiesRepository.getString("id.auto.hm2.director2.password"));
		
		//Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		
		//Step 1
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		
		//Step 1
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying and clicking on Course Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 2 
		log(logger, "Verifying Filter Header");
		VerificationHandler.verifyTrue(homePage.verifyTextContains(PropertiesRepository.getString("id.home.customize.home.cohort.filter.header.loc"), PropertiesRepository.getString("id.home.customize.home.cohort.filter.header.value"), 0), "Unable to verify Filters Section in cohort Page");
		
		// Step 2 
		log(logger, "Verifying Institution(s) header");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.home.customize.home.cohort.institution.and.cohort.status.header.loc", 0, PropertiesRepository.getString("id.home.customize.home.cohort.institution.header.loc")), "Unable to verify Filters Section Institution(s) secton in Filter Page");
		
		// Step 2
		log(logger, "Verifying Institution(s) list");
		VerificationHandler.verifyTrue(homePage.verifyFilterSectionInstitutions(), "Unable to verify Instiution list in Filter Section of Cohort");
		
		// Step 2
		log(logger,  "Verifying check box with each institutions");
		VerificationHandler.verifyTrue(homePage.verifyFilterSectionInstitutionsCheckBox(), "Unable to verify Instiution list checkbox in Filter Section of Cohort");
		
		// Step 2 
		log(logger, "Verifying Cohort Status hader");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.home.customize.home.cohort.institution.and.cohort.status.header.loc", 1, PropertiesRepository.getString("id.home.customize.home.cohort.cohort.status.header.loc")), "Unable to verify Filters Section Cohort Status secton in Filter Page");

		// Step 2 
		log(logger, "Verifying Cohort Status Graduated Check box");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.customize.home.filter.cohort.status.checkbox.loc")), "Unable to verify Filter Cohort Status Graduated Check box");
		
		// Step 2
		log(logger, "Veriyfing Apply Button ");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.home.customize.home.cohort.apply.button.loc")), "Unable to verify Filter Apply button");
		
		// Step 3
		log(logger, "Verifying Filter Institution section check box");
		VerificationHandler.verifyTrue(homePage.verifyFilterSectionInstitutionsCheckBoxFn(), "Unable to verify check/ Uncheck funcationality in filter section");
		
		logger.info("INST1954_VerifyElementsInFilter End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1969")
	@Test(priority = 2, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1969:Verify Searching from the search bar for cohort")
	public void INST1969_VerifySearchBarForProductsTab() throws Exception {
		logger.info("INST1969_VerifySearchBarForProductsTab Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.1969.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.1969.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		
		log(logger, "Navigating to Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to Navigating to Products Tab from Left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Search Cohort funcationality ");
		VerificationHandler.verifyTrue(productsPage.clickSearchByCohortSection(), "Unable to verify Cohort Section after searching");
		
		logger.info("INST1969_VerifySearchBarForProductsTab End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-2091")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Add and save cohorts in home dashboard as Director of consortium")
	public void INST2091_VerifyCohortsForDOCUser() throws Exception {
		log(logger, "INST2091_VerifyCohortsForDOCUser Start");
		logger.info("INST2091_VerifyCohortsForDOCUser Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.director.of.consortium.username"),
				PropertiesRepository.getString("id.director.of.consortium.password"));

		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying and clicking on Graduation Cohort ");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClickUsingContains(
						PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"),
						PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,
						"Graduation/ Course Cohorts menu link"),
				"Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 2
		log(logger, "To check PN institution name is checked or not and clicking on Save / View Dashboard button");
		String pnCohortName = homePage.verifyInstitutionSelectedInGraduationCohort(
				PropertiesRepository.getString("id.zzCAB.2.0.test.institution.pn.institute.name"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 2
		log(logger, "Veriyfing Course Cohort name in Dashboard");
		VerificationHandler.verifyTrue(
				homePage.verifyCohortAndItsNameInDashboardAndItsInstutiton(
						PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"), pnCohortName,
						PropertiesRepository.getString("id.zzCAB.2.0.test.institution.pn.institute.name")),
				"Unable to verify Cohort name in dashboard");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));		
		
		// Step 3
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 3
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 3
		log(logger, "Verifying and clicking on Graduation Cohort ");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClickUsingContains(
						PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"),
						PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,
						"Graduation/ Course Cohorts menu link"),
				"Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 4
		log(logger, "To check RN institution name is checked or not and clicking on Save / View Dashboard button");
		String rnCohortName = homePage.verifyInstitutionSelectedInGraduationCohort(
				PropertiesRepository.getString("id.zzCAB.2.0.test.institution.rn.institute.name"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 4
		log(logger, "Veriyfing Course Cohort name in Dashboard");
		VerificationHandler.verifyTrue(
				homePage.verifyCohortAndItsNameInDashboard(
						PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"), rnCohortName),
				"Unable to verify Cohort name in dashboard");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		
		log(logger, "INST2091_VerifyCohortsForDOCUser End");
		logger.info("INST2091_VerifyCohortsForDOCUser End");
	}
	
	@TestAnnotations(testID="INST-2095")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify top navigation for DOC")
	public void INST2095_VerifyTopNavigationForDOC() throws Exception {
		log(logger, "INST2095_VerifyTopNavigationForDOC Start");
		logger.info("INST2095_VerifyTopNavigationForDOC Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.director.of.consortium.2095.username"),
				PropertiesRepository.getString("id.director.of.consortium.2095.password"));
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
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.chamberlai.con.addison.institute.2095.name")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2095.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2095.value")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name in Home page");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage("id.home.page.cohort.name.loc", 1,
						PropertiesRepository.getString("id.cohort.input.2095.value")),
				"Unable to Verify Cohort name in Home page");
		
		// Verifying for invalid cohort name - Start
		log(logger, "Logic for verifying invalid cohort Start");
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
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.chamberlai.con.addison.institute.2095.name")), 
		"Unable to Click on Enter base Institution text box in home page");
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2095.invalid.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and it should not be displayed");
		VerificationHandler.verifyFalse(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2095.invalid.value")), 
		"Unable to verify cohort name after searching");
		// Verifying for invalid cohort name - End
		log(logger, "Logic for verifying invalid cohort End");
		
		log(logger, "Logic for verifying People Tab Start");
		// Verifying Institution name in People tab - Start
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify People Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				productsPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.chamberlai.con.addison.institute.2095.name")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterTextInInstitution(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2095.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2095.value")), 
		"Unable to verify cohort name after searching");
		// Verifying Institution name in People tab - End
		log(logger, "Logic for verifying People Tab End");
		
		log(logger, "INST2095_VerifyTopNavigationForDOC End");
		logger.info("INST2095_VerifyTopNavigationForDOC End");
	}
	
	@TestAnnotations(testID="INST-2097")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Regression"}, description = "INST2097_Verify top navigation for Director")
	public void INST2097_VerifyTopNavigationForDirector() throws Exception {
		log(logger, "INST2097_VerifyTopNavigationForDirector Start");
		logger.info("INST2097_VerifyTopNavigationForDirector Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.director2.username"),
				PropertiesRepository.getString("id.auto.hm2.director2.password"));
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
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2094.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2094.value")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name in Home page");
		VerificationHandler.verifyTrue(productsPage.verifyMessage("id.home.page.cohort.name.loc", 1, PropertiesRepository.getString("id.cohort.input.2094.value")),
				"Unable to Verify Cohort name in Home page");
		
		// Verifying for invalid cohort name - Start
		log(logger, "Logic for verifying invalid cohort Start");
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
				PropertiesRepository.getString("id.cohort.input.2094.invalid.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and it should not be displayed");
		VerificationHandler.verifyFalse(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2094.invalid.value")), 
		"Unable to verify cohort name after searching");
		// Verifying for invalid cohort name - End
		log(logger, "Logic for verifying invalid cohort End");
		
		log(logger, "Logic for verifying People Tab Start");
		// Verifying Institution name in People tab - Start
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify People Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				productsPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterTextInInstitution(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2094.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2094.value")), 
		"Unable to verify cohort name after searching");
		// Verifying Institution name in People tab - End
		log(logger, "Logic for verifying People Tab End");
		
		log(logger, "INST2097_VerifyTopNavigationForDirector End");
		logger.info("INST2097_VerifyTopNavigationForDirector End");
	}
}
