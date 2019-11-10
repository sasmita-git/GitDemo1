package com.automation.id.product;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.AnotherBrowserPage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ManageRosterPage;
import com.automation.id.pages.PeopleTabPage;
import com.automation.id.pages.StudentPortalPage;
import com.jaca.TestAnnotations;

public class ManageRosterTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ManageRosterPage manageRosterPage;
	private PeopleTabPage peopleTabPage;
	private AnotherBrowserPage anotherBrowserPage;
	private WebDriver anotherBrowserDriver;
	private StudentPortalPage studentPortalPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		manageRosterPage = new ManageRosterPage(driver);
		peopleTabPage = new PeopleTabPage(driver);
		anotherBrowserPage = new AnotherBrowserPage(driver);
		anotherBrowserDriver = openProctorChromeDriver();
		studentPortalPage = new StudentPortalPage(driver);
	}
	
	@TestAnnotations(testID="INST-1893")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify student should proceed for practice assessment while faculty reassign him to another cohort")
	public void INST1893_VerifyReassignStudentToAnotherCohort() throws Exception {
		log(logger, "INST1893_VerifyReassignStudentToAnotherCohort Start");
		logger.info("INST1893_VerifyReassignStudentToAnotherCohort Start");

		log(logger, "Login to Student Portal Application");
		studentPortalPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.enable.disable.username"),
				PropertiesRepository.getString("newati.nclex.login.enable.disable.password"));
		studentPortalPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(studentPortalPage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		studentPortalPage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(studentPortalPage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking Test Tab");
		studentPortalPage.clickSubTab(1);
		studentPortalPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Practice Assessment ");
		studentPortalPage.clickTestTabAssessmentButtonNew(
				PropertiesRepository.getString("new-atitesting.myati.assessment.type"),
				PropertiesRepository.getString("new-atitesting.assessment.itrop.assessment.name"));
		studentPortalPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		studentPortalPage.completeContinueStateAssessment(PropertiesRepository.getString("new-atitesting.myati.assessment.type"),
				PropertiesRepository.getString("new-atitesting.assessment.itrop.assessment.name"));
		studentPortalPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Logging to Faculty Portal Application");
		anotherBrowserPage.loginToApplication1(anotherBrowserDriver, PropertiesRepository.getString("id.login.faculty.username.personnel1"),
				PropertiesRepository.getString("id.login.faculty.password.personnel1"));
		anotherBrowserPage.waitUntillLoadingImageIsDisappeared(anotherBrowserDriver, PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyAndClick(anotherBrowserDriver, PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyLeftNavigationText(anotherBrowserDriver, "id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify  People Link  ");

		log(logger, "Verifying People page Student Roster header");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyTextContains(anotherBrowserDriver, PropertiesRepository.getString("id.product.manage.products.loc"),
						PropertiesRepository.getString("id.people.page.menu.header.value"), 0),
				"Unable to verify Products page Student Roster header");

		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(anotherBrowserPage.searchandVerifyStudentByCohort(anotherBrowserDriver, 
				PropertiesRepository.getString("id.people.reassign.popup.cohort.1884.name")), "value doesn't match");

		log(logger, "Clicking on first student from table");
		VerificationHandler.verifyTrue(anotherBrowserPage.selectStudentCheckBox(anotherBrowserDriver, 1),
				"Unable to check student and click on reassign button");

		log(logger, "Click to verify popup");
		VerificationHandler.verifyTrue(anotherBrowserPage.verifyReassignVerifyPopup(anotherBrowserDriver, "Reassign Cohort"),
				"value doesn't match");

		log(logger, "reassign student to new cohert");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.enterClassToReassignWithContent(anotherBrowserDriver, 
						PropertiesRepository.getString("id.studentroster.reassignTo.cohort.name1")),
				"Unable to Reassign Cohort");

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyTextContains(anotherBrowserDriver, PropertiesRepository.getString("id.product.menu.loc"),
						PropertiesRepository.getString("id.people.transer.history.page.menu.header.value"), 2),
				"Unable to verify Products page Transfer History header");
		anotherBrowserPage.waitUntillLoadingImageIsDisappeared(anotherBrowserDriver, PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Transfer History");
		anotherBrowserPage.verifyAndClick(anotherBrowserDriver, PropertiesRepository.getString("id.product.menu.loc"), 2, true);
		anotherBrowserPage.waitUntillLoadingImageIsDisappeared(anotherBrowserDriver, PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying People page Transfer History header");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyMessage(anotherBrowserDriver, "id.people.transfer.history.header.loc", 0,
						PropertiesRepository.getString("id.people.transfer.history.header.value")),
				"Unable to verify Products page Reports Groups header");

		log(logger, "Verifying Cohort name is displayed in Transfer History");
		VerificationHandler.verifyTrue(
				anotherBrowserPage.verifyCohortInTransferHistory(anotherBrowserDriver, 
						PropertiesRepository.getString("id.studentroster.reassignTo.cohort.name1"), 0),
				"Unable to verify Cohort name in Transfer History");

		logger.info("INST1893_VerifyReassignStudentToAnotherCohort End");
		log(logger, "INST1893_VerifyReassignStudentToAnotherCohort End");
	}
}
