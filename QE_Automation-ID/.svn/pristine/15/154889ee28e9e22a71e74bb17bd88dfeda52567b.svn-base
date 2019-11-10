package com.automation.id.peopletab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.IDBasePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.PeopleTabPage;
import com.automation.id.pages.ReportWizardPage;
import com.automation.id.pages.ReportWizardReportPage;
import com.jaca.TestAnnotations;

public class PeopleTabSmokeTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	PeopleTabPage peopleTabPage;
	ReportWizardReportPage reportwizardpage;
	ReportWizardPage reportWizardPage ;
	IDBasePage idbasePage;
	WindowHandler windowHandler;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		peopleTabPage=new PeopleTabPage(driver);
		idbasePage=new IDBasePage(driver);
		reportWizardPage =new ReportWizardPage(driver);
		reportwizardpage=new ReportWizardReportPage(driver);
		windowHandler=new WindowHandler(driver);
		//loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.people.username"), PropertiesRepository.getString("id.login.faculty.people.password"));
	}

	@TestAnnotations(testID="INST-1661")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "Verify People tab in new faculty portal")
	public void INST1661_verifyNewPeoplePage() throws Exception {
		log(logger, "INST1661_verifyNewPeoplePage Start");
		logger.info("INST1661_verifyNewPeoplePage Start");
		
		log(logger, "enter url");
		
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.faculty.username.personnel1"),
				PropertiesRepository.getString("id.login.faculty.password.personnel1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
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

		// Assign Proctor
		logger.info("Assign Proctor ");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Assign Proctor header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.assign.proctor.page.menu.header.value"), 4),
				"Unable to verify Products page Assign Proctor header");

		log(logger, "Clicking on Assign Proctor");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 4, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Assign Proctor header");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.people.assign.proctor.header.loc")),
				"Unable to verify Products page Assign Proctor header");

		logger.info("INST1661_verifyNewPeoplePage End");
		log(logger, "INST1661_verifyNewPeoplePage End");
	}
	
	@TestAnnotations(testID="INST-1765")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1765:Verify Student Roster appears first by default under people tab under user setting")
	public void INST1765_VerifyDefaultValue_PeopleTab() throws Exception {
		log(logger, "INST1765_VerifyDefaultValue_PeopleTab Start");
		logger.info("INST1765_VerifyDefaultValue_PeopleTab Start");
		
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.faculty.username.personnel1"),
				PropertiesRepository.getString("id.login.faculty.password.personnel1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		
		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true), "Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");

		logger.info("INST1765_VerifyDefaultValue_PeopleTab End");
		log(logger, "INST1765_VerifyDefaultValue_PeopleTab End");
	}
	
	@TestAnnotations(testID="INST-1760")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1760:Search for Name in bulk roaster management page with last name")
	public void INST1760_SearchAndVerifyResultByLastname() throws Exception {
		log(logger, "INST1760_SearchAndVerifyResultByLastname Start");
		logger.info("INST1760_SearchAndVerifyResultByLastname Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.instructor1"), PropertiesRepository.getString("id.login.faculty.password.instructor1"));
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

		log(logger, "verify By default value under people tab");
		VerificationHandler.verifyTrue(
				peopleTabPage.searchAndVerifyByLastName(
						PropertiesRepository.getString("id.studentroaster.SearchBy.Lastname")),
				"By default value doesn't match");
		
		logger.info("INST1760_SearchAndVerifyResultByLastname End");
		log(logger, "INST1760_SearchAndVerifyResultByLastname End");
	}
	
	
	@TestAnnotations(testID="INST-1758")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1758:Search for cohort in bulk roaster management page")
	public void INST1758_SearchAndVerifyByCohort() throws Exception {
		log(logger, "INST1758_SearchAndVerifyByCohort Start");
		logger.info("INST1758_SearchAndVerifyByCohort Start");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.instructor1"),
				PropertiesRepository.getString("id.login.faculty.password.instructor1"));
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
				PropertiesRepository.getString("id.studentroster.cohort.name")), "value doesn't match");

		logger.info("INST1758_SearchAndVerifyByCohort End");
		log(logger, "INST1758_SearchAndVerifyByCohort End");
	}
	
	@TestAnnotations(testID="INST-1771")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1771:Verify the reassign feature")
	public void INST1771_VerifyReassignFeature() throws Exception {
		log(logger, "INST1771_VerifyReassignFeature Start");
		logger.info("INST1771_VerifyReassignFeature Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.director1"), PropertiesRepository.getString("id.login.faculty.password.director1"));
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
				PropertiesRepository.getString("id.studentroster.cohort.name")), "value doesn't match");

		log(logger, "Clicking on first student from table");
		VerificationHandler.verifyTrue(peopleTabPage.selectStudentCheckBox(1),
				"Unable to check student and click on reassign button");

		log(logger, "Click to verify popup");
		VerificationHandler.verifyTrue(peopleTabPage.verifyReassignVerifyPopup("Reassign Cohort"),
				"value doesn't match");

		log(logger, "reassign student to new cohert");
		VerificationHandler.verifyTrue(
				peopleTabPage.enterClassToReassign(
						PropertiesRepository.getString("id.studentroster.reassignTo.cohort.name1")),
				"Unable to Reassign Cohort");
		
		logger.info("INST1771_VerifyReassignFeature End");
		log(logger, "INST1771_VerifyReassignFeature End");
	}
	
	@TestAnnotations(testID="INST-1888")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1888:Verify student roster for instructor user")
	public void INST1888_VerifyStudentRosterForInstructorUser() throws Exception {
		log(logger, "INST1888_VerifyStudentRosterForInstructorUser Start");
		logger.info("INST1888_VerifyStudentRosterForInstructorUser Start");
		
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
				PropertiesRepository.getString("id.people.reassign.popup.cohort.name")), "value doesn't match");

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
		
		logger.info("INST1888_VerifyStudentRosterForInstructorUser End");
		log(logger, "INST1888_VerifyStudentRosterForInstructorUser End");
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	
	@TestAnnotations(testID="INST-1887")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "inst-1887:Verify student roster for director user")
	public void INST1887_VerifyStudentRosterForDirectorUser() throws Exception {
		log(logger, "INST1887_VerifyStudentRosterForDirectorUser Start");
		logger.info("INST1887_VerifyStudentRosterForDirectorUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.director1"),
				PropertiesRepository.getString("id.login.faculty.password.director1"));
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
				PropertiesRepository.getString("id.people.reassign.popup.cohort.name")), "value doesn't match");

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

		logger.info("INST1887_VerifyStudentRosterForDirectorUser End");
		log(logger, "INST1887_VerifyStudentRosterForDirectorUser End");

	}
	
	@TestAnnotations(testID="INST-1884")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1884:Verify student roster for Personnel user")
	public void INST1884_VerifyStudentRosterForPersonnelUser() throws Exception {
		log(logger, "INST1884_VerifyStudentRosterForPersonnelUser Start");
		logger.info("INST1884_VerifyStudentRosterForPersonnelUser Start");

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
				PropertiesRepository.getString("id.people.reassign.popup.cohort.1884.name")), "value doesn't match");

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

		logger.info("INST1884_VerifyStudentRosterForPersonnelUser End");
		log(logger, "INST1884_VerifyStudentRosterForPersonnelUser End");
	}
}
