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

public class HomeTest2Personnel extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;
	BaseHandler basehandler;
	private ProductsPage productsPage;
	
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
	@TestAnnotations(testID="INST-1951")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1951:Verify select institute for personnel present in home")
	public void INST1951_VerifyInstituteForPersonnel() throws Exception {
		logger.info("INST1951_VerifyInstituteForPersonnel Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.personnel1.1951.username"),
				PropertiesRepository.getString("id.auto.hm2.personnel1.1951.password"));
		
		// Step 1
		log(logger, "Verifying Institution DD is present for Personnel User");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.institution.text.box.loc"), false), "Unable to verify Institution DD");
		
		// Step 2
		log(logger, "Verifying Personnel user is able to select Institution from DD");
		homePage.verifyInstitutionNameForPersonnel(PropertiesRepository.getString("id.instituton.input.value"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		Thread.sleep(5000);
		
		// Step 2
		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(homePage.verifyMessageUsingGetAttribute("id.home.institution.text.box.loc", 0,"id.instituton.input.value"), "Unable to verify Institution name");
		
		logger.info("INST1951_VerifyInstituteForPersonnel End");
	}
	
	@TestAnnotations(testID="INST-2094")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "INST2094_Verify top navigation for Personnel")
	public void INST2094_VerifyTopNavigationForPersonnel() throws Exception {
		log(logger, "INST2094_VerifyTopNavigationForPersonnel Start");
		logger.info("INST2094_VerifyTopNavigationForPersonnel Start");

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
		
		log(logger, "INST2094_VerifyTopNavigationForPersonnel End");
		logger.info("INST2094_VerifyTopNavigationForPersonnel End");
	}
	
}
