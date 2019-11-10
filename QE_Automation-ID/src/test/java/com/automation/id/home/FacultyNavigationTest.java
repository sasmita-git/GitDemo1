package com.automation.id.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class FacultyNavigationTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@TestAnnotations(testID = "INST-1640")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Navigation from the Menu for Director::Faculty Navigation")
	public void INST1640_VerifyDirectorUserLink() throws Exception {
		logger.info("INST1640_VerifyDirectorUserLink Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.faculty.login.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.director.Password"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Products
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Products page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.product.main.tab1.name"), 0),
				"Unable to verify Products page header");

		// Proctor 
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Proctor page header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExistsWtihCardShadowSwitch(
						PropertiesRepository.getString("id.homepage.home.page.proctor.message")),
				"Unable to verify Proctor page header");

		// Assessment Builder.

		// Analytics
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Analytics page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.anlytics.page.header.loc", 0,
						PropertiesRepository.getString("id.anlytics.page.header.value")),
				"Unable to verify Analytics page header");

		// People
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page header");

		// ATI Academy.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying ATI Academy");
		VerificationHandler.verifyTrue(
				homePage.verifyATIAcademyPage(PropertiesRepository.getString("id.home.page.ati.academy.header.loc"), 0,
						PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value")),
				"Unable to verify ATI Contacts");
		
		// Resources.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Resources page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.resources.header.loc", 0,
						PropertiesRepository.getString("id.resources.header.value")),
				"Unable to verify Resources page header");

		logger.info("INST1640_VerifyDirectorUserLink End");
	}

	@TestAnnotations(testID = "INST-1641")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Navigation from the Menu for Consortium Director")
	public void INST1641_VerifyConsortiumDirectorUserLink() throws Exception {
		logger.info("INST1641_VerifyConsortiumDirectorUserLink Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.director.of.consortium.username"),
				PropertiesRepository.getString("id.director.of.consortium.password"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Products
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Products page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.product.main.tab1.name"), 0),
				"Unable to verify Products page header");

		// Proctor 
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Proctor page header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExistsWtihCardShadowSwitch(
						PropertiesRepository.getString("id.homepage.home.page.proctor.message")),
				"Unable to verify Proctor page header");

		// Assessment Builder.

		// Analytics
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Analytics page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.anlytics.page.header.loc", 0,
						PropertiesRepository.getString("id.anlytics.page.header.value")),
				"Unable to verify Analytics page header");

		// People
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page header");

		// ATI Academy.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying ATI Academy");
		VerificationHandler.verifyTrue(
				homePage.verifyATIAcademyPage(PropertiesRepository.getString("id.home.page.ati.academy.header.loc"), 0,
						PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value")),
				"Unable to verify ATI Contacts");
		
		// C-Map
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on C-Map tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "map", true),
				"Unable to verify C-Map Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying C-MAP page details ");
		VerificationHandler.verifyTrue(
				loginPage.verifyElementExistsWithDefaultSwitch(
						PropertiesRepository.getString("id.home.left.menu.cmap.page.header.loc")),
				"Unable to veriy C-MAP ");
		driver.navigate().back();
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Resources.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Resources page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.resources.header.loc", 0,
						PropertiesRepository.getString("id.resources.header.value")),
				"Unable to verify Resources page header");

		logger.info("INST1641_VerifyConsortiumDirectorUserLink End");
	}

	@TestAnnotations(testID = "INST-1642")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Navigation from the Menu for Personnel")
	public void INST1642_VerifyPersonnelUserLink() throws Exception {
		logger.info("INST1642_VerifyPersonnelUserLink Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Products
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Products page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.product.main.tab1.name"), 0),
				"Unable to verify Products page header");

		// Proctor 
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Proctor page header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExistsWtihCardShadowSwitch(
						PropertiesRepository.getString("id.homepage.home.page.proctor.message")),
				"Unable to verify Proctor page header");

		// Assessment Builder.

		// Analytics
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Analytics page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.anlytics.page.header.loc", 0,
						PropertiesRepository.getString("id.anlytics.page.header.value")),
				"Unable to verify Analytics page header");

		// People
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page header");

		// ATI Academy.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying ATI Academy");
		VerificationHandler.verifyTrue(
				homePage.verifyATIAcademyPage(PropertiesRepository.getString("id.home.page.ati.academy.header.loc"), 0,
						PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value")),
				"Unable to verify ATI Contacts");
		
		// C-Map
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on C-Map tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "map", true),
				"Unable to verify C-Map Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying C-MAP page details ");
		VerificationHandler.verifyTrue(
				loginPage.verifyElementExistsWithDefaultSwitch(
						PropertiesRepository.getString("id.home.left.menu.cmap.page.header.loc")),
				"Unable to veriy C-MAP ");
		driver.navigate().back();
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Resources.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Resources page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.resources.header.loc", 0,
						PropertiesRepository.getString("id.resources.header.value")),
				"Unable to verify Resources page header");

		logger.info("INST1642_VerifyPersonnelUserLink End");
	}

	@TestAnnotations(testID = "INST-1643")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Navigation from the Menu for Proctor")
	public void INST1643_VerifyProctorUserLink() throws Exception {
		logger.info("INST1643_VerifyProctorUserLink Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));

		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Proctor 
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Proctor page header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExistsWtihCardShadowSwitch(
						PropertiesRepository.getString("id.homepage.home.page.proctor.message")),
				"Unable to verify Proctor page header");

		// ATI Academy.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", true),
				"Unable to verify Proctor ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying ATI Academy");
		VerificationHandler.verifyTrue(
				homePage.verifyATIAcademyPage(PropertiesRepository.getString("id.home.page.ati.academy.header.loc"), 0,
						PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value")),
				"Unable to verify ATI Contacts");
		
		// Resources.
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Resources page header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.resources.header.loc", 0,
						PropertiesRepository.getString("id.resources.header.value")),
				"Unable to verify Resources page header");

		logger.info("INST1643_VerifyProctorUserLink End");
	}

	@TestAnnotations(testID = "INST-1647")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Check for Consortium/Institution List icon for Proctor")
	public void INST1647_VerifyInstListForProctor() throws Exception {
		logger.info("INST1647_VerifyInstListForProctor Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));

		log(logger, "click on close button");
		loginPage.verifyAndClickWithSwitch("id.home.page.alert.close.button.loc", 0, true);

		log(logger, "Entering Institute and cohort value");
		VerificationHandler.verifyTrue(homePage.verifyInstitute(), "Institute displayed for Proctor");

		logger.info("INST1647_VerifyInstListForProctor End");
	}

	
	@TestAnnotations(testID = "INST-1648")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Check for Consortium/Institution List icon for Consortium Director")
	public void INST1648_VerifyInstListForConsortiumDirector() throws Exception {
		logger.info("INST1648_VerifyInstListForConsortiumDirector Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.consortium.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.consortium.director.Password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		/*
		 * log(logger, "click on close button");
		 * loginPage.verifyAndClickWithSwitch(
		 * "id.home.page.alert.close.button.loc", 0, true);
		 */
		log(logger, "Entering Institute and cohort value");
		homePage.selectInstitute(PropertiesRepository.getString("id.faculty.navigation.institute.name"));

		log(logger, "Verifying Home page");
		VerificationHandler.verifyTrue(
				loginPage.verifyElementExists(PropertiesRepository.getString("id.home.ati.contact.card.loc")),
				"Unable to veriy Home Page ATI Contact details");

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Proctor Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(2, "assessment", true),
				"Unable to verify Proctor ");

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Home Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(0, "dashboard", true),
				"Unable to verify Proctor ");

		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyInstituteName(PropertiesRepository.getString("id.faculty.navigation.institute.name")),
				"Unable to verify Institution name");

		log(logger, "Verify that institution are displaying at drop down");
		homePage.selectInstituteDDList(homePage.getInstitutionList());

		logger.info("INST1648_VerifyInstListForConsortiumDirector End");
	}

	/**
	 * Need to change to personnel user, since it is not logging in, using
	 * consortium director user.
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1649")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Check for Consortium/Institution List icon for Personnel")
	public void INST1649_VerifyInstListForPersonnel() throws Exception {
		logger.info("INST1649_VerifyInstListForPersonnel Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.consortium.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.consortium.director.Password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Entering Institute and cohort value");
		homePage.selectInstitute(PropertiesRepository.getString("id.faculty.navigation.institute.name"));

		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyInstituteName(PropertiesRepository.getString("id.faculty.navigation.institute.name")),
				"Unable to verify Institution name");

		log(logger, "Verify that institution are displaying at drop down");
		homePage.selectInstituteDDList(homePage.getInstitutionList());

		logger.info("INST1649_VerifyInstListForPersonnel End");
	}
}
