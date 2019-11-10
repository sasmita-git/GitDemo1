package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.IDBasePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ManageRosterPage;
import com.automation.id.pages.PeopleTabPage;
import com.automation.id.pages.ReportWizardPage;
import com.automation.id.pages.ReportWizardReportPage;
import com.jaca.TestAnnotations;

public class PeoplePageTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	PeopleTabPage peopleTabPage;
	ReportWizardReportPage reportwizardpage;
	ReportWizardPage reportWizardPage ;
	IDBasePage idbasePage;
	WindowHandler windowHandler;
	ManageRosterPage manageRosterPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		peopleTabPage=new PeopleTabPage(driver);
		idbasePage=new IDBasePage(driver);
		reportWizardPage =new ReportWizardPage(driver);
		reportwizardpage=new ReportWizardReportPage(driver);
		windowHandler=new WindowHandler(driver);
		manageRosterPage=new ManageRosterPage(driver);
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
		
		log(logger,"click on 'CHANGES COMING TO COURSE GROUPS! ' message pop up");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc.close"), 0, true);
        
		
		log(logger, "click on course group tab");
		homePage.verifyAndClick(PropertiesRepository.getString("id.people.coursegroup"), 0, true);

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
	
	@TestAnnotations(testID="INST-1887")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "inst-1887:Verify student roster for director user")
	public void INST1887_VerifyStudentRosterForDirectorUser() throws Exception {
		log(logger, "INST1887_VerifyStudentRosterForDirectorUser Start");
		logger.info("INST1887_VerifyStudentRosterForDirectorUser Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.doc1"),
				PropertiesRepository.getString("id.login.faculty.password.doc1"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		/*log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");*/

		/*log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(peopleTabPage.searchandVerifyStudentByCohort(
				PropertiesRepository.getString("id.people.reassign.popup.cohort.name")), "value doesn't match");*/
		
		manageRosterPage.selectingInstitutionNameInStudentRosterPage(PropertiesRepository.getString("id.people.institution.name"));
		manageRosterPage.selectingCohortNameInStudentRosterPage(PropertiesRepository.getString("id.people.cohort.name"));
		
		log(logger, "Clicking on first student from table");
				VerificationHandler.verifyTrue(peopleTabPage.selectStudentCheckBox(1),
				"Unable to check student and click on reassign button");

		log(logger, "Click to verify popup");
		VerificationHandler.verifyTrue(peopleTabPage.verifyReassignVerifyPopup("Reassign Cohort"),
				"value doesn't match");

		log(logger, "reassign student to new cohert");
		VerificationHandler.verifyTrue(
				peopleTabPage.enterClassToReassignWithContent(
						PropertiesRepository.getString("id.people.reassign.cohort1")),
				"Unable to Reassign Cohort");

	/*	log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");*/
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
						PropertiesRepository.getString("id.people.reassign.cohort1"), 0),
				"Unable to verify Cohort name in Transfer History");
		
		log(logger, "Clicking on Student Roster");
		homePage.verifyAndClick(PropertiesRepository.getString("id.product.menu.loc"), 0, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		manageRosterPage.selectingCohortNameInStudentRosterPage(PropertiesRepository.getString("id.people.reassign.cohort1"));
		
		log(logger, "Clicking on first student from table");
		VerificationHandler.verifyTrue(peopleTabPage.selectStudentCheckBox(1),
		"Unable to check student and click on reassign button");

		log(logger, "Click to verify popup");
		VerificationHandler.verifyTrue(peopleTabPage.verifyReassignVerifyPopup("Reassign Cohort"),
		"value doesn't match");
		
		log(logger, "reassign student to new cohert");
		VerificationHandler.verifyTrue(peopleTabPage.resettingStudentTransfer(PropertiesRepository.getString("id.people.cohort.name")),"Unable to Reassign Cohort");
								
		logger.info("INST1887_VerifyStudentRosterForDirectorUser End");
		log(logger, "INST1887_VerifyStudentRosterForDirectorUser End");

	}
	
	
}
	
