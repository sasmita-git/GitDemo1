package com.automation.id.products.manageproducts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.IDBasePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ReportWizardPage;
import com.automation.id.pages.ReportWizardReportPage;
import com.jaca.TestAnnotations;

public class LoginPageValidationTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ButtonHandler buttonHandler;
	private HomePage homePage;
	private ReportWizardPage reportWizardPage;
	ReportWizardReportPage reportwizardpage;
	IDBasePage idbasePage;
	WindowHandler windowHandler;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		buttonHandler = new ButtonHandler(driver);
		homePage = new HomePage(driver);
		reportwizardpage = new ReportWizardReportPage(driver);
		reportWizardPage = new ReportWizardPage(driver);
		windowHandler = new WindowHandler(driver);
		idbasePage = new IDBasePage(driver);
	}

	@TestAnnotations(testID = "INST-1576")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify ATI logo is clickable present on faculty log-in page::Smoke Test Suite")
	public void inst1576_VerifyATILogo() throws Exception {
		log(logger, "inst1576_VerifyATILogo Start");

		log(logger, "enter url");
		driver.get(PropertiesRepository.getString("id.login.faculty.url"));

		log(logger, "verify logo");
		VerificationHandler.verifyTrue(buttonHandler.isDisplayed(PropertiesRepository.getString("id.logo.loc")),
				"Logo is not displayed");

		log(logger, "click on logo image");
		buttonHandler.clickButton(PropertiesRepository.getString("id.logo.loc"));

		log(logger, "verify url when click on logo image");
		VerificationHandler.verifyEquals(PropertiesRepository.getString("id.ati.login.new.url"), driver.getCurrentUrl());

		log(logger, "inst1576_VerifyATILogo End");
	}

	@TestAnnotations(testID = "INST-1575")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Prevent Faculty user from logging in from student portal login::Smoke Test Suite")
	public void inst1575_VerifyNewATILogin() throws Exception {
		log(logger, "inst1575_VerifyNewATILogin Start");

		log(logger, "enter url");
		loginPage.loginToStudentApplication(PropertiesRepository.getString("id.director.home2.0.login.user.name"),
				PropertiesRepository.getString("id.director.home2.0.login.password"));

		log(logger, "verify Login Error Message");
		VerificationHandler.verifyTrue(loginPage.verifyErrorMessage("id.login.error.msg", "id.login.error.message"),
				"Login error message is not displayed");

		log(logger, "inst1575_VerifyNewATILogin End");
	}

	@TestAnnotations(testID = "INST-1637")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1637:Check for the menu for faculty::Smoke Test Suite")
	public void inst1637_VerifyFacultyMenu() throws Exception {
		log(logger, "inst1637_VerifyFacultyMenu Start");

		log(logger, "Login to application");
		
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.auto.lgn.instuctor1.username"),
				PropertiesRepository.getString("id.auto.lgn.instuctor1.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		//Step 1
		log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", false), "Unable to verify Home Link");
		//Step 1
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", false), "Unable to verify  Products   ");
		//Step 1
		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", false), "Unable to verify Proctor ");
		//Step 1
		log(logger, "Verifying Assessment Builder Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "build", false), "Unable to verify Assessment Builder Link");
		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", false), "Unable to verify Analytics Link");
		//Step 1
		log(logger, "click on People tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", false), "Unable to verify People Link");
		//Step 1
		log(logger, "click on ATI Academy tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "school", false), "Unable to verify ATI Academy Link");
		//Step 1
		log(logger, "click on C-Map tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "map", false), "Unable to verify C-Map Link");
		//Step 1
		log(logger, "click on Resources   tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", false), "Unable to verify Resources   Link");

		log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", true), "Unable to verify Home Link");

		//Step 2
		log(logger, "verify bell image");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.homepage.static.menu", 0));

		//Step 2
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		
		//Step 2
		log(logger, "Verify Customize Home link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 0, "settings"));
		//Step 2
		log(logger, "Verify ATI contact link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 1, "contacts"));
		//Step 2
		log(logger, "Verify online store link");
		VerificationHandler.verifyTrue(homePage.verifyLink(
				PropertiesRepository.getString("id.home.menu.item.list.loc"), 2, "store_mall_directory"));
		//Step 2
		log(logger, "Verify product solution link");
		VerificationHandler.verifyTrue(homePage.verifyLink(
				PropertiesRepository.getString("id.home.menu.item.list.loc"), 3, "explore"));
		//Step 2
		log(logger, "Verify Sign Out link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 4, "exit_to_app"));

		log(logger, "inst1637_VerifyFacultyMenu End");
	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1579")
	//@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "Verify that diffrent types of login option::Smoke Test Suite")
	public void inst1579_VerifyDiffrentTypesofLoginOption() throws Exception {
		log(logger, "inst1579_VerifyDiffrentTypesofLoginOption Start");

		log(logger, "enter url");
		driver.get(PropertiesRepository.getString("id.ati.login.url"));

		log(logger, "click on student login link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.login.loc"), 0);

		log(logger, "verify student login header");
		loginPage.verifyErrorMessage("id.loginpage.header.loc", "id.login.page.student.login.header");

		driver.navigate().back();
		log(logger, "click on faculty login link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.login.loc"), 1);

		log(logger, "verify faculty login header");
		loginPage.verifyErrorMessage("id.loginpage.header.loc", "id.login.page.faculty.login.header");

		log(logger, "inst1579_VerifyDiffrentTypesofLoginOption End");
	}

	// @TestAnnotations(testID="INST-1630") Commented based on Pradeep review.
	// @Test(priority = 5, alwaysRun = true, enabled = true,
	// groups={"Smoke","Regression"}, description = "Check for Contact Us
	// widget::Smoke Test Suite")
	public void inst1630_VerifyContactUsWidget() throws Exception {
		log(logger, "inst1630_VerifyContactUsWidget Start");

		log(logger, "enter url");
		// loginPage.loginToInstApplication(PropertiesRepository.getString("id.login.user.name"),
		// PropertiesRepository.getString("id.login.password"));
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.faculty.username.LoginPageValidationTest"),
				PropertiesRepository.getString("id.login.faculty.password.LoginPageValidationTest"));
		loginPage.waitForAwhile(8000);

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on ATI Contacts link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 0);

		log(logger, "verify faculty login header");
		loginPage.verifyErrorMessage("id.homepage.home.page.ati.contacts.header.name.loc",
				"id.homepage.home.page.ati.contacts.header");

		// boolean result=loginPage.verifyContactsPopUpInfo();
		// VerificationHandler.verifyTrue(result, "Contacts info is not
		// displayed");

		VerificationHandler.verifyTrue(loginPage.getList("id.homepage.static.menu.list"));

		log(logger, "inst1630_VerifyContactUsWidget End");
	}

	@TestAnnotations(testID = "INST-1638")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1638:Navigation from the Menu for Instructor::Smoke Test Suite")
	public void inst1638_VerifyMenuNavigation() throws Exception {
		log(logger, "inst1638_VerifyMenuNavigation Start");

		log(logger, "enter url");
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.auto.lgn.instuctor1.username"),
				PropertiesRepository.getString("id.auto.lgn.instuctor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

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

		log(logger, "inst1638_VerifyMenuNavigation End");

	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1645")
	//@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "inst1645-Check for Consortium/Institution List icon for Instructor::Smoke Test Suite")
	public void inst1645_VerifyInstructorIcon() throws Exception {
		log(logger, "inst1645_VerifyInstructorIcon Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.faculty.login.consortium.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.consortium.director.Password"));

		/*
		 * log(logger, "click on close button");
		 * loginPage.verifyAndClickWithSwitch(
		 * "id.home.page.alert.close.button.loc", 0, true);
		 */
		/*
		 * log(logger, "click on close button");
		 * editProfilePage.clickButtonFromList(
		 * "id.homepage.home.page.alert.close", 0);
		 */

		log(logger, "Entering Institute and cohort value");
		homePage.selectInstituteAndCohortForConsortium(
				PropertiesRepository.getString("id.faculty.navigation.institute.name"),
				PropertiesRepository.getString("id.faculty.navigation.cohort.name"));

		log(logger, "verify Institution name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.homepage.home.page.institution.name", 0));

		log(logger, "inst1645_VerifyInstructorIcon End");
	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	// @TestAnnotations(testID="INST-1632") Removed as per Pradep comments.
	// @Test(priority = 9, alwaysRun = true, enabled = true,
	// groups={"Smoke","Regression"}, description = "Verify Alert toast message
	// on faculty portal::Smoke Test Suite")
	public void inst1632_VerifyAlertToastMessage() throws Exception {
		log(logger, "inst1632_VerifyAlertToastMessage Start");

		log(logger, "enter url");
		// loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.faculty.username.LoginPageValidationTest"),
				PropertiesRepository.getString("id.login.faculty.password.LoginPageValidationTest"));
		// loginPage.waitForAwhile(8000);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		boolean result = loginPage.verifyAlertMessageText("id.homepage.alert.text");
		if (!result) {
			throw new SkipException("Test Case inst-1632 is skipped as Alert PopUp is not displayed.");
		}
		VerificationHandler.verifyTrue(result, "Alert is not dismissed");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "inst1632_VerifyAlertToastMessage End");
	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1602")
	//@Test(priority = 10, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "INST-1602 :Verify personnel should able to select institution after log-in::Smoke Test Suite")
	public void inst1602_VerifyInstitutionDropDown() throws Exception {
		log(logger, "inst1602_VerifyInstitutionDropDown Start");

		log(logger, "enter url");
		// loginPage.loginToInstApplication(PropertiesRepository.getString("id.login.user.name"),
		// PropertiesRepository.getString("id.login.password"));
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitForAwhile(2000);

		log(logger, "select institution and cohort from dropdown");
		homePage.selectInstituteAndCohortNew(PropertiesRepository.getString("new-atitesting.institution.name"),
				PropertiesRepository.getString("id.stg.cohort.naming.home"));

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on Resorces link");
		homePage.clikOnLeftNavLink(7);
		//homePage.verifyLeftNavigationText("Resources", true);

		log(logger, "verify user landing on help page");
		boolean resourcelink = reportWizardPage.isEleDisplayeds("id.resources.header.loc");
		VerificationHandler.verifyTrue(resourcelink, "user is not in help page");
		loginPage.waitForAwhile(8000);

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on products link");
		homePage.clikOnLeftNavLink(1);

		log(logger, "verify user landing on products page");
		idbasePage.switchToCardShadowFrame();
		boolean productheader = reportWizardPage.isEleDisplayeds("id.product.manage.products.page.header.loc");
		VerificationHandler.verifyTrue(productheader, "user is not in product page");
		windowHandler.switchToLatestWindow();

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on people link");
		homePage.clikOnLeftNavLink(5);

		log(logger, "verify user landing on user page");
		// idbasePage.switchToCardShadowFrame();
		boolean peopleheader = reportWizardPage.isEleDisplayeds("id.people.search.option");
		VerificationHandler.verifyTrue(peopleheader, "not in people page");
		// windowHandler.switchToLatestWindow();

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on analytics link");
		homePage.clikOnLeftNavLink(4);

		log(logger, "verify user landing on analytics page");
		// idbasePage.switchToCardShadowFrame();
		boolean analyticshedaer = reportWizardPage.isEleDisplayeds("id.analytics.header.loc1");
		VerificationHandler.verifyTrue(analyticshedaer, "user is not in analytics page");
		// windowHandler.switchToLatestWindow();

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "verify user landing on cmap page");
		homePage.clikOnLeftNavLink(7);

		log(logger, "verify user landing on cmap page");

		boolean cmapheader = reportWizardPage.isEleDisplayeds("id.home.cmap.header.loc");
		VerificationHandler.verifyTrue(cmapheader, "user is not in cmap page");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.home.cab.returnto.faculty.cmap.loc"), 0);
		loginPage.waitForAwhile(7000);
		log(logger, "verify user landing on home page back");

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on ATI Academy");
		loginPage.clickElement("id.homepage.main.menu.list", 6);
		new WindowHandler(driver).switchToLatestWindow();
		String currentUrl = driver.getCurrentUrl();

		System.out.println(currentUrl);
		VerificationHandler.verifyEquals(currentUrl, PropertiesRepository.getString("newati.ati.nursing.url"));

		log(logger, "inst1602_VerifyInstitutionDropDown End");
	}

	/**
	 * Not in smoke, so commenting code. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	
	//@TestAnnotations(testID = "INST-1636")
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "INST-1636:Check inside Contact us Widget::Smoke Test Suite")
	public void inst1636_VerifyInsideContactUsWidget() throws Exception {
		log(logger, "inst1636_VerifyInsideContactUsWidget Start");

		log(logger, "enter url");
		// loginPage.loginToInstApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.home"),
				PropertiesRepository.getString("id.login.faculty.password.LoginPageValidationTest"));
		// loginPage.waitForAwhile(8000);
		loginPage.waitUntillOverlayImageIsDisappeared("id.common.page.spinner.loc");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on ATI Contacts link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 0);

		log(logger, "verify faculty login header");
		loginPage.verifyErrorMessage("id.homepage.home.page.ati.contacts.header.name.loc",
				"id.homepage.home.page.ati.contacts.header");

		boolean result = loginPage.verifyContactsPopUpInfo();
		VerificationHandler.verifyTrue(result, "Contacts info is not displayed");

		log(logger, "inst1636_VerifyInsideContactUsWidget End");
	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	// @TestAnnotations(testID="INST-1633") Removed as per Pradeep comments
	// @Test(priority = 11, alwaysRun = true, enabled = true,
	// groups={"Smoke","Regression"}, description = "Verify dismiss to Alert
	// toast message on faculty portal::Smoke Test Suite")
	public void inst1633_VerifyDismissToAlertastMessage() throws Exception {
		log(logger, "inst1633_VerifyDismissToAlertastMessage Start");

		log(logger, "enter url");
		// loginPage.loginToInstApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.faculty.username.LoginPageValidationTest"),
				PropertiesRepository.getString("id.login.faculty.password.LoginPageValidationTest"));
		loginPage.waitUntillOverlayImageIsDisappeared("id.common.page.spinner.loc");

		boolean result = loginPage.verifyAlertMessageText("id.homepage.alert.text");
		if (!result) {
			throw new SkipException("Test Case inst-1633 is skipped as  Alert PopUp is not displayed.");
		}
		VerificationHandler.verifyTrue(result, "Alert is not dismissed");

		log(logger, "verify bell symbol");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.homepage.alert.popup.bell.symbol.loc", 0));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "inst1633_VerifyDismissToAlertastMessage End");
	}
}
