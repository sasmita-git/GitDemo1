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

public class ManageRosterTest3 extends BaseTest {

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

	@TestAnnotations(testID = "INST-1956")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify 'curriculum cohort' header section on individual overview modal window.")
	public void INST1956_VerifyIndividualOverviewForCurriculumCohort() throws Exception {
		log(logger, "INST1956_VerifyIndividualOverviewForCurriculumCohort Start");
		logger.info("INST1956_VerifyIndividualOverviewForCurriculumCohort Start");

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
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 1
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 1
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 3
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");

		log(logger, "INST1956_VerifyIndividualOverviewForCurriculumCohort End");
		logger.info("INST1956_VerifyIndividualOverviewForCurriculumCohort End");

	}

	@TestAnnotations(testID = "INST-1957")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify all curriculum cohorts associated with student are listed under curriculum cohorts sectio")
	public void INST1957_VerifyCurriculumCohortStudentListInIndvOverview() throws Exception {
		log(logger, "INST1957_VerifyCurriculumCohortStudentListInIndvOverview Start");
		logger.info("INST1957_VerifyCurriculumCohortStudentListInIndvOverview Start");

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
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section ");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section ");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section ");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section ");

		log(logger, "INST1957_VerifyCurriculumCohortStudentListInIndvOverview End");
		logger.info("INST1957_VerifyCurriculumCohortStudentListInIndvOverview End");

	}

	@TestAnnotations(testID = "INST-1958")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify for the student with an institution which does not have curriculum cohorts.")
	public void INST1958_VerifyNonCurriculumCohortStudentListInIndvOverview() throws Exception {
		log(logger, "INST1958_VerifyNonCurriculumCohortStudentListInIndvOverview Start");
		logger.info("INST1958_VerifyNonCurriculumCohortStudentListInIndvOverview Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		// Step 1
		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		// Step 2
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(
				peopleTabPage.searchandVerifyStudentByCohort(
						PropertiesRepository.getString("id.people.cohort.1958.people.tab.test.case.name")),
				"value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 3
		log(logger, "Verifying Course Cohort is not displayed in Individual Overview Section");
		VerificationHandler.verifyFalse(peopleTabPage.verifyIndividualOverviewCourseCohortHeaderSection(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");

		log(logger, "INST1958_VerifyNonCurriculumCohortStudentListInIndvOverview End");
		logger.info("INST1958_VerifyNonCurriculumCohortStudentListInIndvOverview End");
	}

	@TestAnnotations(testID = "INST-1959")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify curriculum cohort per page should be displayed as 4.")
	public void INST1959_VerifyCourseCohortStudentListInIndvOverview() throws Exception {
		log(logger, "INST1959_VerifyCourseCohortStudentListInIndvOverview Start");
		logger.info("INST1959_VerifyCourseCohortStudentListInIndvOverview Start");

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
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Course Cohort section is displayed with 4 course in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyCourseCohortList(),
				"Unable to Verify Course Cohort in Individual Overview Section");

		log(logger, "INST1959_VerifyCourseCohortStudentListInIndvOverview End");
		logger.info("INST1959_VerifyCourseCohortStudentListInIndvOverview End");
	}

	@TestAnnotations(testID = "INST-1960")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify pagination should be displayed when more than 4 cohorts available .")
	public void INST1960_VerifyCourseCohortNavigationInIndvOverview() throws Exception {
		log(logger, "INST1960_VerifyCourseCohortNavigationInIndvOverview Start");
		logger.info("INST1960_VerifyCourseCohortNavigationInIndvOverview Start");

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
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Course Cohort navigation section is displayed in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyTextContains(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.navigation.section.loc"),
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.navigation.section.value"),
				0), "Unable to Verify Course Cohort in Individual Overview Section");

		log(logger, "INST1960_VerifyCourseCohortNavigationInIndvOverview End");
		logger.info("INST1960_VerifyCourseCohortNavigationInIndvOverview End");
	}
	
	@TestAnnotations(testID = "INST-1961")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify personnel user,on clicking user from the roster can view all of their associated cohorts")
	public void INST1961_VerifyPersonnelUserViewAllCourseCohorts() throws Exception {
		log(logger, "INST1961_VerifyPersonnelUserViewAllCourseCohorts Start");
		logger.info("INST1961_VerifyPersonnelUserViewAllCourseCohorts Start");

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
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section 1");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 2");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section 2");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 3");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section 3");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 4");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section 4");
		// Step 3
		log(logger, "Clicking on right navigation");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.navigation.link.loc"),
				2, true), "Unable to Click on right navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 5");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value5")),
		"Unable to Verify Cohort names  Course Cohort Section 5");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 6");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value6")), 
		"Unable to Verify Cohort names  Course Cohort Section 6");
		
		log(logger, "INST1961_VerifyPersonnelUserViewAllCourseCohorts End");
		logger.info("INST1961_VerifyPersonnelUserViewAllCourseCohorts End");
	}
	
	@TestAnnotations(testID = "INST-1962")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify instructor user,on clicking user from the roster can view all of their associated cohorts")
	public void INST1962_VerifyStudentUserViewAllCourseCohorts() throws Exception {
		log(logger, "INST1962_VerifyStudentUserViewAllCourseCohorts Start");
		logger.info("INST1962_VerifyStudentUserViewAllCourseCohorts Start");

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
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section 1");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 2");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section 2");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 3");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section 3");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 4");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section 4");
		// Step 3
		log(logger, "Clicking on right navigation");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.navigation.link.loc"),
				2, true), "Unable to Click on right navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 5");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value5")),
		"Unable to Verify Cohort names  Course Cohort Section 5");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 6");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value6")), 
		"Unable to Verify Cohort names  Course Cohort Section 6");
		
		log(logger, "INST1962_VerifyStudentUserViewAllCourseCohorts End");
		logger.info("INST1962_VerifyStudentUserViewAllCourseCohorts End");
	}
	
	@TestAnnotations(testID = "INST-1963")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "verify Director user,on clicking user from the roster can view all of their associated cohorts")
	public void INST1963_VerifyDirectorUserViewAllCourseCohorts() throws Exception {
		log(logger, "INST1963_VerifyDirectorUserViewAllCourseCohorts Start");
		logger.info("INST1963_VerifyDirectorUserViewAllCourseCohorts Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.reg.roster.director.2.username"),
				PropertiesRepository.getString("id.auto.reg.roster.director.2.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 2
		log(logger, "Verifying Course Cohort list");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyElementExists(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc")),
				"Unable to Verify Course Cohort list");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section 1");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 2");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section 2");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 3");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section 3");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 4");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section 4");
		// Step 3
		log(logger, "Clicking on right navigation");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.navigation.link.loc"),
				2, true), "Unable to Click on right navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 5");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value5")),
		"Unable to Verify Cohort names  Course Cohort Section 5");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 6");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value6")), 
		"Unable to Verify Cohort names  Course Cohort Section 6");
		
		log(logger, "INST1963_VerifyDirectorUserViewAllCourseCohorts End");
		logger.info("INST1963_VerifyDirectorUserViewAllCourseCohorts End");
	}
	
	@TestAnnotations(testID = "INST-1918")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify Time Accommodations in Student Roster for director")
	public void INST1918_VerifyTimeAccomodationsForDirector() throws Exception {
		log(logger, "INST1918_VerifyTimeAccomodationsForDirector Start");
		logger.info("INST1918_VerifyTimeAccomodationsForDirector Start");

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
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 3
		log(logger, "Verifying Firstname, Lastname in Individual Overview Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyTextContains(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.firstname.lastname.loc"), 
						PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.firstname.lastname.value")),
				"Unable to Verify Firstname, Lastname in Individual Overview Section ");
		
		// Step 3
		log(logger, "Verifying Email ID in Individual Overview Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.email.loc",0, 
						PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.email.value")),
				"Unable to Verify Email ID in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Username and Paper/ Pencil ID in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.value")),
		"Unable to Verify Username and Paper/ Pencil ID in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Associations Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.header.value")), 
		"Unable to Verify Associations Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Institution Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value1")),
		"Unable to Verify Institution Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Institution value in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.loc", 1,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.institution.name.header.value")),
		"Unable to Verify Institution value in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Graduation Cohort Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 1,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value2")),
		"Unable to Verify Graduation Cohort Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Graduation names  Graduation Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.graduation.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Graduation Cohort Section 1");
		// Step 3
		log(logger, "Verifying Course Cohort(s) in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 2,
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value3")),
		"Unable to Verify Course Cohort(s) in Individual Overview Section ");
		
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section 1");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 2");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section 2");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 3");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section 3");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 4");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section 4");
		// Step 3
		log(logger, "Verifying Time Accommodation Factor Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.header.value")), 
		"Unable to Verify Time Accommodation Factor Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Time Accommodation Factor Content in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.content.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.content.value")), 
		"Unable to Verify Time Accommodation Factor Content in Individual Overview Section ");
		
		log(logger, "INST1918_VerifyTimeAccomodationsForDirector End");
		logger.info("INST1918_VerifyTimeAccomodationsForDirector End");
	}
	
	@TestAnnotations(testID = "INST-1919")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify Time Accommodations in Student Roster for instructor")
	public void INST1919_VerifyTimeAccomodationsForInstructor() throws Exception {
		log(logger, "INST1919_VerifyTimeAccomodationsForInstructor Start");
		logger.info("INST1919_VerifyTimeAccomodationsForInstructor Start");

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
		// Step 1
		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");
		// Step 2
		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.cohot.1956.value")), "value doesn't match");
		// Step 2
		log(logger, "Clicking on first Name from table");
		VerificationHandler.verifyTrue(peopleTabPage.verifyAndClick(
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"), 0, true),
				"Unable to Click on first Name from table");
		// Step 2
		log(logger, "Verifying Course Cohort in Individual Overview Section");
		VerificationHandler.verifyTrue(peopleTabPage.verifyMessage(
				"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.loc", 1,
				PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.header.value2")),
				"Unable to Verify Course Cohort in Individual Overview Section");
		// Step 3
		log(logger, "Verifying Firstname, Lastname in Individual Overview Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyTextContains(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.firstname.lastname.loc"), 
						PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.firstname.lastname.value")),
				"Unable to Verify Firstname, Lastname in Individual Overview Section ");
		
		// Step 3
		log(logger, "Verifying Email ID in Individual Overview Section ");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.email.loc",0, 
						PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.email.value")),
				"Unable to Verify Email ID in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Username and Paper/ Pencil ID in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.value")),
		"Unable to Verify Username and Paper/ Pencil ID in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Associations Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.header.value")), 
		"Unable to Verify Associations Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Institution Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value1")),
		"Unable to Verify Institution Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Institution value in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.username.and.paper.pencil.id.loc", 1,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.institution.name.header.value")),
		"Unable to Verify Institution value in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Graduation Cohort Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 1,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value2")),
		"Unable to Verify Graduation Cohort Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Graduation names  Graduation Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.graduation.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Graduation Cohort Section 1");
		// Step 3
		log(logger, "Verifying Course Cohort(s) in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.loc", 2,
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.association.sub.header.value3")),
		"Unable to Verify Course Cohort(s) in Individual Overview Section ");
		
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 1");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value1")),
				"Unable to Verify Cohort names  Course Cohort Section 1");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 2");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value2")),
				"Unable to Verify Cohort names  Course Cohort Section 2");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 3");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value3")),
				"Unable to Verify Cohort names  Course Cohort Section 3");
		// Step 3
		log(logger, "Verifying Cohort names  Course Cohort Section 4");
		VerificationHandler.verifyTrue(
				peopleTabPage.verifyCourseCohortValueInIndividualOverviewSection(PropertiesRepository.getString(
						"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.cohort.value4")),
				"Unable to Verify Cohort names  Course Cohort Section 4");
		// Step 3
		log(logger, "Verifying Time Accommodation Factor Header in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.header.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.header.value")), 
		"Unable to Verify Time Accommodation Factor Header in Individual Overview Section ");
		// Step 3
		log(logger, "Verifying Time Accommodation Factor Content in Individual Overview Section ");
		VerificationHandler.verifyTrue(
		peopleTabPage.verifyMessage("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.content.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.name.indidivual.overview.time.accommodation.factor.content.value")), 
		"Unable to Verify Time Accommodation Factor Content in Individual Overview Section ");
		
		log(logger, "INST1919_VerifyTimeAccomodationsForInstructor End");
		logger.info("INST1919_VerifyTimeAccomodationsForInstructor End");
	}
	

}
