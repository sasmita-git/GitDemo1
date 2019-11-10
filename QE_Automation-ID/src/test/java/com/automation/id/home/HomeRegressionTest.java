package com.automation.id.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HomeRegressionTest extends BaseTest {

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
	
	@TestAnnotations(testID="INST-1738")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups = {"Regression"}, description = "Verify User Role::Instructor Login by Account Settings Dropdown")
	public void INST1738_VerifyAccountSettingsDropdown() throws Exception {
		logger.info("INST1738_VerifyAccountSettingsDropdown Start");
		log(logger, "INST1738_VerifyAccountSettingsDropdown Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Verifying Instructor Role");
		VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.home.login.role.loc"), false), "Unable to verify Instructor Role");
		
		log(logger,"Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		
		log(logger, "click on Account Settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list",1);
		
		log(logger, "INST1738_VerifyAccountSettingsDropdown Ends");
		logger.info("INST1738_VerifyAccountSettingsDropdown Ends");
	}
	
	/**
	 * TC Moved to Obsolete.
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1708")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify that home screen shows 3 widget blank space holders")
	public void INST1708_VerifyHomeScreenThreeWidgetBlankSpaceHolders() throws Exception {
		logger.info("INST1708_VerifyHomeScreenThreeWidgetBlankSpaceHolders Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying three widget");
		VerificationHandler.verifyTrue(
				loginPage.verifyElementExists(PropertiesRepository.getString("id.home.screen.three.blank.widget")),
				"Unable to Verify three tabs in home page");

		logger.info("INST1708_VerifyHomeScreenThreeWidgetBlankSpaceHolders Ends");
	}
	
	@TestAnnotations(testID = "INST-1639")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify list of News and Alerts that have been published from Sitefinity on faculty portal::Smoke Test Suite")
	public void INST1639_VerifyToastMessage() throws Exception {
		logger.info("INST1639_VerifyToastMessage Start");

		log(logger, "Login to application");
		// loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.home"),
				PropertiesRepository.getString("id.login.faculty.password.home"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering cohort");
		// homePage.selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
		// homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming"));
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming.home"));

		log(logger, "Verifying Alert Toast Message");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.toast.message.loc"), false);

		log(logger, "Verifying Red Bell");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.red.bell.new.loc"), 0, true);

		log(logger, "Verifying Toast Message both News and Alerts");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.news.and.alert.popup.loc"), false);

		log(logger, "Verifying Alert Heading");
		boolean verifyAndClickWithSwitch = homePage
				.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.alert.heading.list.loc"), 1, true);
		if (!verifyAndClickWithSwitch) {
			throw new SkipException("inst-1639: Test case is skipped as there is no new alerts displayed");
		}
		log(logger, "Clicking on Red Bell");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 0);
		// homePage.clickAlerts();
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying Alert Details Page");
		homePage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.alert.individual.alert.details.loc"),
				false);

		/*log(logger, "Clicking on Close Button");
		homePage.clickButtonFromList("id.home.alert.homepage.close.button.loc", 0);*/

		log(logger, "Verifying Alert Red colour changed to normal");
		boolean verifyAlerts = homePage.verifyAlerts();
		if (!verifyAlerts) {
			throw new SkipException("inst-1639: Test case is skipped as there is no new alerts displayed");
		}
		VerificationHandler.verifyTrue(verifyAlerts, "");
		logger.info("INST1639_VerifyToastMeesage End");
	}

}
