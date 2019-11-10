package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HomeTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
	}

	@TestAnnotations(testID = "INST-1751")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1751:Verify the Warm Transfer from Faculty Login to student")
	public void INST1751_verifyStudentWarmTransfer() throws Exception {
		logger.info("INST1751_verifyStudentWarmTransfer Start");

		log(logger, "Login to application");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor6.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor6.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on user name");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.login.edit.profile.name.loc"), true),
				"Unable to click User Name in left navigation");

		log(logger, "click on student view tab");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.homepage.main.menu.list.top"), 1, true),
				"Unable to click Student view in left navigation");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");
		// editProfilePage.clickElement("id.homepage.main.menu.list.top", 1);

		log(logger, "click on student view continue button link");
		VerificationHandler.verifyTrue(homePage.clickContinueForStudentView(),
				"Unable to verify student view continue button funcationality");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on Return to faculty link");
		VerificationHandler.verifyTrue(homePage.clickOnReturnToFacultyLink(1),
				"Unable to click Return to faculty link in Student Portal");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		/*
		 * log(logger, "Verifying Home page header");
		 * VerificationHandler.verifyTrue(homePage.verifyMessage(
		 * "id.home.page.tile.loc", 0,
		 * PropertiesRepository.getString("id.home.page.tile.value")),
		 * "Unable to verify Home page header");
		 */

		log(logger, "Clicking on Left Navigation Link to verify that we are back to faculty");
		VerificationHandler
				.verifyTrue(
						editProfilePage.verifyAndClick(
								PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), false),
						"Unable to click left navifation in faculty portal application");

		logger.info("INST1751_verifyStudentWarmTransfer End");
	}

	@TestAnnotations(testID = "INST-1706")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify Proctor logIn into application::Smoke Test Suite")
	public void INST1706_VerifyProctorLogin() throws Exception {
		logger.info("INST1706_VerifyProctorLogin Start");

		log(logger, "Proctor login");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.proctor.username.home"),
				PropertiesRepository.getString("id.login.proctor.password.home"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", false),
				"Unable to verify Home Link");

		log(logger, "Verifying Proctor Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", false),
				"Unable to verify  Proctor ");

		log(logger, "Verifying ATI Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", false),
				"Unable to verify ATI Link");

		log(logger, "Verifying Resources Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", false),
				"Unable to verify Resources Link");

		log(logger, "Verify product Link is not present");
		VerificationHandler.verifyFalse(homePage.verifyThatWebLinkIsPresent("trending_up"));

		logger.info("INST1706_VerifyProctorLogin End");
	}
}
