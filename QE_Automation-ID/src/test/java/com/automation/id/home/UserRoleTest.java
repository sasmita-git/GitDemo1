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

public class UserRoleTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@TestAnnotations(testID = "INST-1793")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify User Role::Instructor Login")
	public void INST1793_VerifyInstructorRoleonHomePage() throws Exception {
		logger.info("INST1793_VerifyInstructorRoleonHomePage Start");

		log(logger, "login as instructor");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Verifying Instructor Role");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.login.role.loc"), false),
				"Unable to verify Instructor Role");

		logger.info("INST1793_VerifyInstructorRoleonHomePage Ends");
	}

	@TestAnnotations(testID = "INST-1794")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify User Role::Director Login")
	public void INST1794_VerifyDirectorRoleonHomePage() throws Exception {
		logger.info("INST1794_VerifyDirectorRoleonHomePage Start");

		log(logger, "login as Director");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.director.login.username.value"),
				PropertiesRepository.getString("id.login.director.login.password.value"));

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Verifying Director Role");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.login.role.loc"), false),
				"Unable to verify Director Role");

		logger.info("INST1794_VerifyDirectorRoleonHomePage Ends");
	}

	@TestAnnotations(testID = "INST-1795")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify User Role::Proctor Login")
	public void INST1795_VerifyProctorRoleonHomePage() throws Exception {
		logger.info("INST1795_VerifyProctorRoleonHomePage Start");

		log(logger, "login as Proctor");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.proctor.login.username.value"),
				PropertiesRepository.getString("id.login.proctor.login.password.value"));

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Verifying Proctor Role");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.login.role.loc"), false),
				"Unable to verify Proctor Role");

		logger.info("INST1795_VerifyProctorRoleonHomePage Ends");
	}

	@TestAnnotations(testID = "INST-1797")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify User Role::Personnel Login")
	public void INST1797_VerifyPersonnelRoleonHomePage() throws Exception {
		logger.info("INST1797_VerifyPersonnelRoleonHomePage Start");

		log(logger, "login as Personnel");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.username9"),
				PropertiesRepository.getString("id.login.personnel.password9"));

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Verifying Personnel Role");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.login.role.loc"), false),
				"Unable to verify Personnel Role");

		logger.info("INST1797_VerifyPersonnelRoleonHomePage Ends");
	}

	/**
	 * Invalid as per Angandeep.
	 * 
	 * @throws Exception
	 */
	/*@TestAnnotations(testID = "INST-1705")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify that no default institution is selected for personnel")*/
	public void INST1705_VerifynoDefaultInstitutionSelectedforPersonnel() throws Exception {
		logger.info("INST1705_INST1705_VerifynoDefaultInstitutionSelectedforPersonnel Starts");

		log(logger, "login as Personnel");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.personnel.login.username.value"),
				PropertiesRepository.getString("id.login.personnel.login.password.value"));

		log(logger, "click on close button");
		loginPage.verifyAndClickWithSwitch("id.home.page.alert.close.button.loc", 0, true);

		log(logger, "Verifying Home page");
		VerificationHandler.verifyTrue(
				loginPage.verifyElementExists(PropertiesRepository.getString("id.home.ati.contact.card.loc")),
				"Unable to veriy Home Page ATI Contact details");

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Products Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(1, "apps", true),
				"Unable to verify Products ");

		log(logger, "Verifying Tosted Message");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.slect.institution.tosted.loc"), true);

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Analytics Link");
		homePage.clikOnLeftNavLink(4);
		// VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(4,
		// "trending_up", true), "Unable to verify Analytics ");

		log(logger, "Verifying Tosted Message");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.slect.institution.tosted.loc"), false);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		logger.info("INST1705_INST1705_VerifynoDefaultInstitutionSelectedforPersonnel End");
	}

}
