package com.automation.id.product;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ManageRosterPage;
import com.automation.id.pages.PeopleTabPage;
import com.jaca.TestAnnotations;

public class ManageRosterTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	ManageRosterPage manageRosterPage;
	PeopleTabPage peopleTabPage;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageRosterPage = new ManageRosterPage(driver);
		peopleTabPage = new PeopleTabPage(driver); 
		log(logger, "Login to application");
	}
	
	@TestAnnotations(testID="INST-1756")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify that 'view roster' button name change to 'Manage Roster'")
	public void INST1756_VerifyRosterNameChange() throws Exception {
		log(logger, "INST1756_VerifyRosterNameChange Start");
		logger.info("INST1756_VerifyRosterNameChange Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Manage Roster text");
		VerificationHandler.verifyTrue(manageRosterPage.verifyElementExistsWtihCardShadowSwitch(
				PropertiesRepository.getString("id.product.manage.products.label.loc"), 0,
				PropertiesRepository.getString("id.product.manage.products.label.value")), "Unable to verify Manage Roster text");

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "INST1756_VerifyRosterNameChange End");
		logger.info("INST1756_VerifyRosterNameChange End");
	}
	
	@TestAnnotations(testID="INST-1759")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Search for Name in bulk roaster management page with last name")
	public void INST1759_VerifyRosterNameInTable() throws Exception {
		log(logger, "INST1759_VerifyRosterNameInTable Start");
		logger.info("INST1759_VerifyRosterNameInTable Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering last name in search text box");
		manageRosterPage.enterTextInSearchBox(PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.last.name.text.box.value1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying last name in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyFirstNameAndLastNameInTable(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, 
				PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.last.name.text.box.value1"), 
				PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.last.name.text.box.value2")), "Unable to verify name in table");
		
		log(logger, "INST1759_VerifyRosterNameInTable End");
		logger.info("INST1759_VerifyRosterNameInTable End");
	}
	
	@TestAnnotations(testID="INST-1761")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Search for Name/cohort in bulk roaster management page with partial name")
	public void INST1761_VerifyPartialNameInTable() throws Exception {
		log(logger, "INST1761_VerifyPartialNameInTable Start");
		logger.info("INST1761_VerifyPartialNameInTable Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering last name in search text box");
		manageRosterPage.enterTextInSearchBox(PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.partial.name.text.box.value1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying last name in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyLastNameInTable(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, 
				PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.partial.name.text.box.result.value")), "Unable to verify name in table");
		
		log(logger, "INST1761_VerifyPartialNameInTable End");
		logger.info("INST1761_VerifyPartialNameInTable End");
	}
	
	@TestAnnotations(testID="INST-1762")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Search for cohort or student name to check case sensitivity")
	public void INST1762_VerifyCaseSensitivityNameInTable() throws Exception {
		log(logger, "INST1762_VerifyCaseSensitivityNameInTable Start");
		logger.info("INST1762_VerifyCaseSensitivityNameInTable Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering last name in search text box");
		manageRosterPage.enterTextInSearchBox(PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.case.sensitivity.name.text.box.value"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying last name in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyLastNameInTable(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.search.by.partial.name.text.box.result.value")),
				"Unable to verify name in table");

		log(logger, "INST1762_VerifyCaseSensitivityNameInTable End");
		logger.info("INST1762_VerifyCaseSensitivityNameInTable End");
	}
	
	@TestAnnotations(testID="INST-1764")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Cancel removing students from Bulk Roaster")
	public void INST1764_VerifyCancelFunctionalityInBulkRoster() throws Exception {
		log(logger, "INST1764_VerifyCancelFunctionalityInBulkRoster Start");
		logger.info("INST1764_VerifyCancelFunctionalityInBulkRoster Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering last name in search text box");
		manageRosterPage.enterTextInSearchBox(PropertiesRepository
				.getString("id.product.manage.roster.student.roster.search.by.case.sensitivity.name.text.box.value"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying last name in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyLastNameInTable(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.search.by.partial.name.text.box.result.value")),
				"Unable to verify name in table");
		
		log(logger, "Clicking on first check box");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"), 0, true),
				"Unable to click on first check box");

		log(logger, "Clicking on Remove button");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.remove.button.loc"), 0, true),
				"Unable to click on Remove button");

		log(logger, "Verifying Remove popup header value");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.remove.popup.header.loc",
						0, PropertiesRepository.getString("id.people.are.you.sure.title.value")),
				"Unable to verify Remove popup header value");

		log(logger, "Clicking on Remove popup cancel button");
		VerificationHandler.verifyTrue(manageRosterPage.verifyAndClick(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.remove.popup.cancel.button.loc"), 0, true), "Unable to Click on Remove popup cancel button");
		
		log(logger, "Verifying last name in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyLastNameInTable(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.search.by.partial.name.text.box.result.value")),
				"Unable to verify name in table");
		
		log(logger, "Clicking on Cancel button");
		log(logger, "INST1764_VerifyCancelFunctionalityInBulkRoster End");
		logger.info("INST1764_VerifyCancelFunctionalityInBulkRoster End");
	}
	
	@TestAnnotations(testID="INST-1767")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Cancel removing students from Bulk Roaster")
	public void INST1767_VerifyToCheckMultipleUser() throws Exception {
		log(logger, "INST1767_VerifyToCheckMultipleUser Start");
		logger.info("INST1767_VerifyToCheckMultipleUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohort.1767.name")), "value doesn't match");

		log(logger, "Clicking on first student check box");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"), 0, true),
				"Unable to click on first check box");

		log(logger, "Verifying Students selected count 1");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage(
						"id.product.manage.roster.student.roster.table.no.of.students.selected.loc", 0,
						PropertiesRepository
								.getString("id.product.manage.roster.student.roster.table.1.students.selected.value")),
				"Unable to Verify Students selected count 1");

		log(logger, "Clicking on Second student check box");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"), 1, true),
				"Unable to click on first check box");

		log(logger, "Verifying Students selected count 2");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage(
						"id.product.manage.roster.student.roster.table.no.of.students.selected.loc", 0,
						PropertiesRepository
								.getString("id.product.manage.roster.student.roster.table.2.students.selected.value")),
				"Unable to Verify Students selected count 2");

		log(logger, "INST1767_VerifyToCheckMultipleUser End");
		logger.info("INST1767_VerifyToCheckMultipleUser End");
	}
	
	@TestAnnotations(testID="INST-1768")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify institution/cohrt dropdown & hide graduated slider under people tab under student roaster")
	public void INST1768_VerifyHideGraduatedSlider() throws Exception {
		log(logger, "INST1768_VerifyHideGraduatedSlider Start");
		logger.info("INST1768_VerifyHideGraduatedSlider Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Institution name");
		VerificationHandler.verifyTrue(manageRosterPage.verifyMessage(
				"id.product.manage.roster.student.roster.table.institution.and.cohort.name.loc", 0,
				PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.institution.name.value")), "Unable to verify Institution name");
		
		log(logger, "Verifying Cohort Name");
		VerificationHandler.verifyTrue(manageRosterPage.verifyMessage(
				"id.product.manage.roster.student.roster.table.institution.and.cohort.name.loc", 1,
				PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.cohort.name.value")),"Unable to verify Cohort name");
		
		log(logger, "Clicking on Material Icon");
		manageRosterPage.clickButton(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.material.icon.loc"), 0);
		
		log(logger, "Verifying and clicking on Hide Graduated is enabled");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.loc"), true),
				"Unable to verify and click on Hide Graduated is enabled");
		
		log(logger, "Disabling Hide gradudated icon by clicking");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.disabled.loc")),
				"Unable to verify disabled Hide gradudated icon ");
		
		log(logger, "Clicking on Hide Graduated is enabled");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.loc"), true),
				"Unable to click hide graduated icon");
		
		log(logger, "Enabling Hide gradudated icon by clicking");
		VerificationHandler.verifyFalse(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.enabled.loc")),
				"Unable to verify enabled Hide gradudated icon ");
		
		log(logger, "INST1768_VerifyHideGraduatedSlider End");
		logger.info("INST1768_VerifyHideGraduatedSlider End");
	}
	
	@TestAnnotations(testID="INST-1769")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify grid/body/footer/page selection under people tab under student roaster")
	public void INST1769_VerifyHeaderFooter() throws Exception {
		log(logger, "INST1769_VerifyHeaderFooter Start");
		logger.info("INST1769_VerifyHeaderFooter Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), true),
				"Unable to click manage roster icon");

		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Table Header - CheckBox");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.checkbox.loc")), "Unable to verify Table Header - CheckBox");

		log(logger, "Verifying Table Header - Name");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.name.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.name.value")), "Unable to verify Table Header - Name");

		log(logger, "Verifying Table Header - Email");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.email.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.email.value")), "Unable to verify Table Header - Email");

		log(logger, "Verifying Table Header - Cohort");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.cohort.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.cohort.value")), "Unable to verify Table Header - Cohort");

		log(logger, "Verifying Table content details - CheckBox");
		manageRosterPage.verifyElementExists(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"));
		
		log(logger, "Verifying Table content details - Name");
		manageRosterPage.verifyElementExists(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"));

		log(logger, "Verifying Table content details - Email");
		manageRosterPage.verifyElementExists(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.email.loc"));

		log(logger, "Verifying Table content details - Cohort");
		manageRosterPage.verifyElementExists(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.cohort.loc"));
		
		log(logger, "Clicking on first student check box");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"), 0, true),
				"Unable to click on first check box");
		
		log(logger, "Verifying Students selected count 1");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage(
						"id.product.manage.roster.student.roster.table.no.of.students.selected.loc", 0,
						PropertiesRepository
								.getString("id.product.manage.roster.student.roster.table.1.students.selected.value")),
				"Unable to Verify Students selected count 1");
		
		log(logger, "Verifying ReAssign button");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.reassign.button.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.reassign.button.value")), "Unable to Verify ReAssign button");
		
		log(logger, "Verifying Remove button");
		VerificationHandler.verifyTrue(
		manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.remove.button.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.remove.button.value")), "Unable to Verify Remove button");
		
		log(logger, "Verifying Export button");
		VerificationHandler.verifyTrue(
		manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.export.button.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.export.button.value")), "Unable to Verify Remove button");
		
		log(logger, "Verifying Table Footer navigation");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.footer.navigation.page.count.loc")),
				"Unable to Verify Remove button");
		
		log(logger, "INST1769_VerifyHeaderFooter End");
		logger.info("INST1769_VerifyHeaderFooter End");
	}
	
	@TestAnnotations(testID="INST-1860")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify the faculty roster tab for personnel")
	public void INST1860_VerifyRosterTabForPersonnelUser() throws Exception {
		log(logger, "INST1860_VerifyRosterTabForPersonnelUser Start");
		logger.info("INST1860_VerifyRosterTabForPersonnelUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

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
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "Verifying Table Header - CheckBox");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.checkbox.loc")), "Unable to verify Table Header - CheckBox");

		log(logger, "Verifying Table Header - Name");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.name.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.name.value")), "Unable to verify Table Header - Name");

		log(logger, "Verifying Table Header - Email");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.email.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.email.value")), "Unable to verify Table Header - Email");

		log(logger, "Verifying Table Header - Cohort");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.table.header.cohort.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.cohort.value")), "Unable to verify Table Header - Cohort");
		
		log(logger, "Entering cohort name for sorting");
		VerificationHandler.verifyTrue(
				manageRosterPage.selectingCohortNameInStudentRosterPage(
						PropertiesRepository.getString("id.product.manage.roster.student.roster.1860.cohort.value")),
				"Unable to select cohort name for sorting");
		
		log(logger, "Verifying name sort in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyNameInAscendingOrder(), "Unable to verify sorted name");
		
		log(logger, "INST1860_VerifyRosterTabForPersonnelUser End");
		logger.info("INST1860_VerifyRosterTabForPersonnelUser End");
	}

	@TestAnnotations(testID="INST-1861")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify the faculty roster tab for Director of Consortium")
	public void INST1861_VerifyRosterTabForDirectorUser() throws Exception {
		log(logger, "INST1861_VerifyRosterTabForDirectorUser Start");
		logger.info("INST1861_VerifyRosterTabForDirectorUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.director.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.director.1.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

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
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "Verifying People page Faculty Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.faculty.roseterpage.menu.header.value"), 3),
				"Unable to verify Products page Faculty Roster header");
		
		log(logger, "Clicking on Faculty Roster");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 3, true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying People page Faculty Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.people.faculty.roster.header.loc")),
				"Unable to verify Products page Faculty Roster header");
		
		log(logger, "Verifying Table Header - CheckBox");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(
				PropertiesRepository.getString("id.product.manage.roster.faculty.roster.table.header.checkbox.loc")), "Unable to verify Table Header - CheckBox");

		log(logger, "Verifying Table Header - Name");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.faculty.roster.table.header.name.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.name.value")), "Unable to verify Table Header - Name");

		log(logger, "Verifying Table Header - Email");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.faculty.roster.table.header.email.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.email.value")), "Unable to verify Table Header - Email");

		log(logger, "Verifying Table Header - Role");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyMessage("id.product.manage.roster.faculty.roster.table.header.role.loc", 2,
				PropertiesRepository.getString("id.product.manage.roster.faculty.roster.table.header.role.value")), "Unable to verify Table Header - Role");
		
		log(logger, "Verifying role value in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyRoleInFacultyRosterTab(0, PropertiesRepository.getString("id.product.manage.roster.faculty.roster.role.director.value")),
				"Unable to verify role in table");
		
		log(logger, "Verifying name sort in table");
		VerificationHandler.verifyTrue(manageRosterPage.verifyNameInAscendingOrder(PropertiesRepository.getString("id.product.manage.roster.faculty.roster.table.header.name.row.loc")
				), "Unable to verify sorted name");
		
		
		log(logger, "INST1861_VerifyRosterTabForDirectorUser End");
		logger.info("INST1861_VerifyRosterTabForDirectorUser End");
	}
	
}
