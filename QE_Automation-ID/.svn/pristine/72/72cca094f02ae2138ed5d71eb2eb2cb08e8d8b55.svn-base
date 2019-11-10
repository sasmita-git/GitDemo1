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

public class ManageRosterTest1 extends BaseTest {

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
	
	
	
	@TestAnnotations(testID="INST-1862")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Faculty Roster header for personnel login")
	public void INST1862_VerifyRosterHeaderForPersonnelUser() throws Exception {
		log(logger, "INST1862_VerifyRosterHeaderForPersonnelUser Start");
		logger.info("INST1862_VerifyRosterHeaderForPersonnelUser Start");

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
		
		// Student Roster
		logger.info("Student Roster ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");

		log(logger, "Verifying Student Roster Page details");
		homePage.verifyElementExists(PropertiesRepository.getString("id.people.search.option"));
		
		// Course Groups
		logger.info("Course Groups ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Course Groups header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.course.groups.page.menu.header.value"), 0),
				"Unable to verify Products page Course Groups header");

		log(logger, "Clicking on Course Groups");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 0, true);

		log(logger, "Verifying Page is loaded or not");
		homePage.waitUntillElementIsVisible(
				PropertiesRepository.getString("id.people.page.course.groups.create.a.course.loc"));

		log(logger, "Verifying Course Groups Page details");
		VerificationHandler.verifyTrue(
				homePage.verifyMessages("id.people.page.course.groups.create.a.course.loc", 0,
						PropertiesRepository.getString("id.people.course.groups.page.header.value")),
				"Unable to verify Course Group page header");
		
		// Report Groups
		logger.info("Report Groups ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Report Groups header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.report.groups.page.menu.header.value"), 1),
				"Unable to verify Products page Reports Groups header");

		log(logger, "Clicking on Report Groups");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 1, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying Page is loaded or not");
		VerificationHandler.verifyTrue(
				homePage.waitUntillElementIsVisible(
						PropertiesRepository.getString("id.people.report.groups.group.name.contains.text.box.loc")),
				"Unable to verify Report group name contains text box");
		
		// Transfer History
		logger.info("Transfer History ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Transfer History");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 2, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.people.transfer.history.header.loc", 0,
						PropertiesRepository.getString("id.people.transfer.history.header.value")),
				"Unable to verify Products page Reports Groups header");

		// Faculty Roster
		logger.info("Faculty Roster ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Faculty Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.faculty.roseterpage.menu.header.value"), 3),
				"Unable to verify Products page Faculty Roster header");

		log(logger, "Clicking on Faculty Roster");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 3, true);

		log(logger, "Verifying People page Faculty Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.people.faculty.roster.header.loc")),
				"Unable to verify Products page Faculty Roster header");

		log(logger, "INST1862_VerifyRosterHeaderForPersonnelUser End");
		logger.info("INST1862_VerifyRosterHeaderForPersonnelUser End");
		
	}
	
	@TestAnnotations(testID="INST-1863")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Transfer History tab for personnel user")
	public void INST1863_VerifyTransferHistoryForPersonnelUser() throws Exception {
		log(logger, "INST1863_VerifyTransferHistoryForPersonnelUser Start");
		logger.info("INST1863_VerifyTransferHistoryForPersonnelUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Transfer History
		logger.info("Transfer History ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Transfer History");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 2, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.people.transfer.history.header.loc", 0,
						PropertiesRepository.getString("id.people.transfer.history.header.value")),
				"Unable to verify Products page Reports Groups header");

		log(logger, "Verifying Tansfer Summary header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.transfer.summary.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.transfer.summary.value")), 
		"Unable to Verify Tansfer Summary header");
		
		log(logger, "Verifying Initiated header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.initiated.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.initiated.value")), 
		"Unable to Verify Initiated header");
		
		log(logger, "Verifying Status header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.status.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.status.value")), 
		"Unable to Verify Status header");
		
		log(logger, "Verifying View header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.view.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.view.value")), 
		"Unable to Verify View header");
		
		log(logger, "INST1863_VerifyTransferHistoryForPersonnelUser End");
		logger.info("INST1863_VerifyTransferHistoryForPersonnelUser End");
		
	}
	
	@TestAnnotations(testID="INST-1865")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify the faculty roster tab for instructor")
	public void INST1865_VerifyRosterTabForInstructorUser() throws Exception {
		log(logger, "INST1865_VerifyRosterTabForInstructorUser Start");
		logger.info("INST1865_VerifyRosterTabForInstructorUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.1.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.1.password"));
		
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
						PropertiesRepository.getString("id.people.faculty.roseterpage.menu.header.value"), 2),
				"Unable to verify Products page Faculty Roster header");
		
		log(logger, "Clicking on Faculty Roster");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 2, true);
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
		
		
		log(logger, "INST1865_VerifyRosterTabForInstructorUser End");
		logger.info("INST1865_VerifyRosterTabForInstructorUser End");
	}
	
	@TestAnnotations(testID="INST-1866")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Transfer History Record")
	public void INST1866_VerifyTransferHistoryRecordForPersonnelUser() throws Exception {
		log(logger, "INST1866_VerifyTransferHistoryRecordForPersonnelUser Start");
		logger.info("INST1866_VerifyTransferHistoryRecordForPersonnelUser Start");
		
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
		
		log(logger, "Verifying People page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Transfer History");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 2, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.people.transfer.history.header.loc", 0,
						PropertiesRepository.getString("id.people.transfer.history.header.value")),
				"Unable to verify Products page Reports Groups header");

		log(logger, "Verifying Tansfer Summary header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.transfer.summary.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.transfer.summary.value")), 
		"Unable to Verify Tansfer Summary header");
		
		log(logger, "Verifying Initiated header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.initiated.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.initiated.value")), 
		"Unable to Verify Initiated header");
		
		log(logger, "Verifying Status header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.status.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.status.value")), 
		"Unable to Verify Status header");
		
		log(logger, "Verifying View header");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.header.view.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.header.view.value")), 
		"Unable to Verify View header");
		
		log(logger, "Verifying Load More Button");
		VerificationHandler.verifyTrue(
		homePage.verifyMessage("id.product.manage.roster.transfer.history.footer.load.more.button.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.transfer.history.footer.load.more.button.value")),
		"Unable to Verify Load More Button");
		
		log(logger, "Verifying Tansfer History Table row details");
		VerificationHandler.verifyTrue(manageRosterPage.verifyTransferHistoryRowDetails(), "Unable to Verify Tansfer History Table row details");
		
		log(logger, "INST1866_VerifyTransferHistoryRecordForPersonnelUser End");
		logger.info("INST1866_VerifyTransferHistoryRecordForPersonnelUser End");
	}
	
	@TestAnnotations(testID="INST-1903")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check for institute change operation in BRM for personnel")
	public void INST1903_VerifyInstChngOprForPersonnelUser() throws Exception {
		log(logger, "INST1903_VerifyInstChngOprForPersonnelUser Start");
		logger.info("INST1903_VerifyInstChngOprForPersonnelUser Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		
		log(logger, "Clicking on Home Link");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", true),
				"Unable to verify Home Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Enter base Institution text box in home page");
		VerificationHandler.verifyTrue(
		manageRosterPage.enterBaseInsititionNameInHomePage(PropertiesRepository.getString("id.home.page.enter.base.institution.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
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
		
		log(logger, "Selecting Insitution name from Consortium");
		VerificationHandler.verifyTrue(
		manageRosterPage.selectingInstitutionNameInStudentRosterPage(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.institution.only.name.value")), 
		"Unable to SelectInsitution name from Consortium");

		log(logger, "Verifying Selected Consortium institution is displayed.");
		VerificationHandler.verifyTrue(
		manageRosterPage.verifyMessage("id.product.manage.roster.student.roster.selected.institution.loc", 0,
				PropertiesRepository.getString("id.product.manage.roster.student.roster.institution.name.value")), 
		"Unable to Verify Selected Consortium institution is displayed.");
		
		log(logger, "INST1903_VerifyInstChngOprForPersonnelUser End");
		logger.info("INST1903_VerifyInstChngOprForPersonnelUser End");
	}
	
	@TestAnnotations(testID="inst-1906")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check for already graduated cohort under BRM")
	public void INST1906_VerifyAlreadyGraduatedCohort() throws Exception {
		log(logger, "INST1906_VerifyAlreadyGraduatedCohort Start");
		logger.info("INST1906_VerifyAlreadyGraduatedCohort Start");

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
		// Step 1
		log(logger, "Entering Cohort and verify");
		VerificationHandler.verifyTrue(
		manageRosterPage.searchAndVerifyCohortForHidGradudated(
				PropertiesRepository.getString("id.people.reassign.popup.cohort.1906.name")), "value doesn't match");
		// Step 1
		log(logger, "Verifying and clicking on Hide Graduated is enabled");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.loc"), true),
				"Unable to verify and click on Hide Graduated is enabled");
		// Step 2
		log(logger, "Disabling Hide gradudated icon by clicking");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.hide.graduated.disabled.loc")),
				"Unable to verify disabled Hide gradudated icon ");
		
		log(logger, "Clicking on Material Icon");
		manageRosterPage.clickButton(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.material.icon.loc"), 0);
		
		// Step 3 
		log(logger, "Entering cohort after disabling hide graduated");
		VerificationHandler.verifyTrue(
		peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.reassign.popup.cohort.1906.name")), "value doesn't match");;
		
		log(logger, "INST1906_VerifyAlreadyGraduatedCohort End");
		logger.info("INST1906_VerifyAlreadyGraduatedCohort End");
	}
	
	@TestAnnotations(testID="inst-1907")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check for Semester payment option for a CDN in BRM page")
	public void INST1907_VerifySemesterPaymentForCDN() throws Exception {
		log(logger, "INST1907_VerifySemesterPaymentForCDN Start");
		logger.info("INST1907_VerifySemesterPaymentForCDN Start");

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
		
		// Step 1
		log(logger, "Clicking on CDN link");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(
						PropertiesRepository.getString("id.product.manage.roster.student.roster.cdn.link.loc"), true),
				"Unable to Click on CDN link");

		// Step 2
		log(logger, "Clicking on View Semester Payment link");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.cdn.view.semester.payment.link.loc"), true),
				"Unable to Click on View Semester Payment link");

		// Step 3
		log(logger, "Verifying Semester Payment Page");
		manageRosterPage.verifyMessage(
				"id.product.manage.roster.student.roster.cdn.view.semester.payment.page.header.loc", 0,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.cdn.view.semester.payment.page.header.value"));

		log(logger, "Clicking on Back to Studen Roster link");
		VerificationHandler.verifyTrue(manageRosterPage.verifyAndClick(PropertiesRepository.getString(
				"id.product.manage.roster.student.roster.cdn.view.semester.payment.back.to.student.roster.link.loc"),
				true), "Unable to Click on Back to Studen Roster link");

		// Step 3
		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				manageRosterPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "INST1907_VerifySemesterPaymentForCDN End");
		logger.info("INST1907_VerifySemesterPaymentForCDN End");
	}
	
	@TestAnnotations(testID="inst-1909")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Transfer History tab for faculty user")
	public void INST1909_VerifyTransferHistoryTab() throws Exception {
		log(logger, "INST1909_VerifyTransferHistoryTab Start");
		logger.info("INST1909_VerifyTransferHistoryTab Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.2.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.2.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		
		log(logger, "Verify Transfer History tab is disabled");
		VerificationHandler.verifyTrue(
		manageRosterPage.verifyElementExists(PropertiesRepository.getString("id.product.manage.roster.transfer.history.tab.disabled.loc")),
		"Unable to Verify Transfer History tab is disabled");
		
		log(logger, "INST1909_VerifyTransferHistoryTab End");
		logger.info("INST1909_VerifyTransferHistoryTab End");
	}
	
	
	@TestAnnotations(testID="inst-1911")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check reassign and remove feature as faculty")
	public void INST1911_VerifyReassignRemoveForInstructor() throws Exception {
		log(logger, "INST1911_VerifyReassignRemoveForInstructor Start");
		logger.info("INST1911_VerifyReassignRemoveForInstructor Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.instructor.2.username"),
				PropertiesRepository.getString("id.auto.reg.roster.instructor.2.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		
		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohort.1911.people.tab.test.case.name")), "value doesn't match");
		
		log(logger, "Clicking on first student check box");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.row.checkbox.loc"), 0, true),
				"Unable to click on first check box");
		
		log(logger, "Verfiy and clicking on Reassign Button");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyAndClick(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.table.header.reassign.button.loc"), true),
				"Unable to Verfiy and clicking on Reassign Button");

		log(logger, "Verifying Access Denied Error Popup");
		VerificationHandler
				.verifyTrue(
						peopleTabPage
								.verifyMessage("id.product.manage.roster.student.roster.assign.popup.error.message.loc",
										0,
										PropertiesRepository.getString(
												"id.product.manage.roster.student.roster.assign.error.message.value")),
						"Unable to Verify Access Denied Error Popup");

		log(logger, "Verifying Access Denied Error Message ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyMessage(
						"id.product.manage.roster.student.roster.assign.popup.error.message.body.loc", 0,
						PropertiesRepository
								.getString("id.product.manage.roster.student.roster.assign.error.message.body.value")),
				"Unable to Verify Access Denied Error Message ");

		log(logger, "Clicking on Ok Button in Error Popup");
		VerificationHandler
				.verifyTrue(
						peopleTabPage.verifyAndClick(PropertiesRepository
								.getString("id.product.manage.roster.student.roster.assign.popup.ok.button.loc"), true),
						"Unable to Click on Ok Button in Error Popup");
		
		log(logger, "INST1911_VerifyReassignRemoveForInstructor End");
		logger.info("INST1911_VerifyReassignRemoveForInstructor End");
	}
	
	/**
	 * Need to work on pending steps.
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1904")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "Check for reassigned students in student roster")
	public void INST1904_VerifyReassignedStudentToAnotherCohort() throws Exception {
		log(logger, "INST1904_VerifyReassignedStudentToAnotherCohort Start");
		logger.info("INST1904_VerifyReassignedStudentToAnotherCohort Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.personnel1"),
				PropertiesRepository.getString("id.login.faculty.password.personnel1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");

		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.cohort.input.value")), "value doesn't match");

		log(logger, "Clicking on first student from table");
		VerificationHandler.verifyTrue(peopleTabPage.selectStudentCheckBox(1),
				"Unable to check student and click on reassign button");

		log(logger, "Click to verify popup");
		VerificationHandler.verifyTrue(peopleTabPage.verifyReassignVerifyPopup("Reassign Cohort"),
				"value doesn't match");

		log(logger, "reassign student to new cohert");
		VerificationHandler.verifyTrue(
				peopleTabPage.enterClassToReassignWithContent(
						PropertiesRepository.getString("id.studentroster.reassignTo.cohort.name1")),
				"Unable to Reassign Cohort");

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Transfer History");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 2, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.people.transfer.history.header.loc", 0,
						PropertiesRepository.getString("id.people.transfer.history.header.value")),
				"Unable to verify Products page Reports Groups header");

		log(logger, "Verifying Cohort name is displayed in Transfer History");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCohortInTransferHistory(
						PropertiesRepository.getString("id.studentroster.reassignTo.cohort.name1"), 0),
				"Unable to verify Cohort name in Transfer History");
		
		logger.info("INST1904_VerifyReassignedStudentToAnotherCohort End");
		log(logger, "INST1904_VerifyReassignedStudentToAnotherCohort End");
	}
}
