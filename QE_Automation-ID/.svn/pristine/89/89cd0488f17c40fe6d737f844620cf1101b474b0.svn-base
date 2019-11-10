package com.automation.id.edit.profile;

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

public class AccountCreationTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private EditProfilePage editProfilePage;
	private HomePage homePage;
	private LoginPage loginPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		editProfilePage = new EditProfilePage(driver);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}

	@TestAnnotations(testID = "INST-1687")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Enabling the Checkbox for ATI Email in Accounts page::AccountCreation/Edit Profile")
	public void INST1687_VerifyATIEmailEnableVerification() throws Exception {
		logger.info("INST1687_VerifyATIEmailEnableVerification Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Check whether Email is checked or not");
		boolean boolEmailNotEnabled = editProfilePage.verifyEmailNotChecked();
		boolean boolEmailEnabled = editProfilePage.verifyEmailChecked();
		
		/*log(logger, "Verifying ATI Email Enabled value");
		boolean boolEnabled = editProfilePage.verifyATIEmailEnabled();

		log(logger, "Verifying ATI Email disabled value");
		boolean boolDisabled = editProfilePage.verifyATIEmailDisabled();

		log(logger, "Clicking on ATI Email to change property");
		editProfilePage
				.clickButton(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.text.loc"), 0);

		log(logger, "Verifying ATI Email Enabled/ Disabled");
		VerificationHandler.verifyTrue(editProfilePage.verifyATIEmailPropertyValue(boolEnabled, boolDisabled),
				"Unable to verify ATI Email before log out");*/

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on Sign out tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 2);

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");


		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Verifying ATI Email Enabled/ Disabled");
		VerificationHandler.verifyTrue(editProfilePage.verifyATIEmailPropertyValue(boolEmailNotEnabled, boolEmailEnabled),
				"Unable to verify ATI Email after log out");

		logger.info("INST1687_VerifyATIEmailEnableVerification End");
	}

	@TestAnnotations(testID = "INST-1688")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Disabling the Checkbox for ATI Email in Accounts page::AccountCreation/Edit Profile")
	public void INST1688_VerifyATIEmailDisableVerification() throws Exception {
		logger.info("INST1688_VerifyATIEmailDisableVerification Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		/*log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);*/

		log(logger, "Clicking on Left Navigation Link");
		editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Verifying ATI Email Enabled value");
		boolean boolEnabled = editProfilePage.verifyATIEmailEnabled();

		log(logger, "Verifying ATI Email disabled value");
		boolean boolDisabled = editProfilePage.verifyATIEmailDisabled();

		log(logger, "Clicking on ATI Email to change property");
		editProfilePage
				.clickButton(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.text.loc"), 0);

		log(logger, "Verifying ATI Email Enabled/ Disabled");
		VerificationHandler.verifyTrue(editProfilePage.verifyATIEmailPropertyValue(boolEnabled, boolDisabled),
				"Unable to verify ATI Email before log out");

		log(logger, "Clicking on Left Navigation Link for Logout");
		editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking signout Link in Left Navigation");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.signout.link"), true);

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Clicking on Left Navigation Link");
		editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Verifying ATI Email Enabled/ Disabled");
		VerificationHandler.verifyTrue(editProfilePage.verifyATIEmailPropertyValue(boolEnabled, boolDisabled),
				"Unable to verify ATI Email after log out");

		logger.info("INST1688_VerifyATIEmailDisableVerification End");
	}

	@TestAnnotations(testID = "INST-1693")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Check for Terms and Condition page in Accounts tab::AccountCreation/Edit Profile")
	public void INST1693_VerifyTermsAndConditionTab() throws Exception {
		logger.info("INST1693_VerifyTermsAndConditionTab Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on Terms and Condition Tab");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.tab.loc"), 2);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Privacy Policy Right Arrow");
		// editProfilePage.clickButton(PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
		// 0);
		editProfilePage.clickButton(PropertiesRepository.getString("accountpage.loc"), 0);

		log(logger, "Verifying Privacy Policy Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
								.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.privacy.policy.data.loc"), 0),
				"Unable to verify Privacy Policy");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				0);

		log(logger, "Clicking on Website Terms of Use Right Arrow");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				1);

		log(logger, "Verifying Website Terms of Use Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
								.getString("id.home.profile.account.setting.terms.and.condition.section.details.loc"),
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.website.terms.of.use.data.loc"), 1),
				"Unable to verify Website terms of use");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				1);

		log(logger, "Clicking on Faculty Terms and Conditions Right Arrow");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				2);

		log(logger, "Verifying Faculty Terms and Conditions Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
								.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.faculty.terms.and.conditions.data.new.loc"), 2),
				"Unable to verify Faculty Terms and Condition ");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				2);

		log(logger, "Clicking on Users Terms and Conditions Right Arrow");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				3);

		log(logger, "Verifying Users Terms and Conditions Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.user.terms.and.conditions.data.loc"), 3),
				"Unable to verify User");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.right.arrow.loc"),
				3);

		logger.info("INST1693_VerifyTermsAndConditionTab End");
	}

	@TestAnnotations(testID = "INST-1712")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify rearranging fields of account creation page")
	public void INST1712_VerifyAccCreationPageRearrange() throws Exception {
		logger.info("INST1712_VerifyAccCreationPageRearrange Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage
				.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString(
								"id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		
		
		log(logger, "Verifying Name section");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage("id.home.profile.account.setting.personal.section.loc", 0,  
				PropertiesRepository.getString("id.product.manage.roster.student.roster.table.header.name.value")),
				"Unable to verify Name");
		
		log(logger, "Verifying City section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.city.value"), 1),
				"Unable to verify City");
		
		log(logger, "Verifying Country section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.country.value"), 2),
				"Unable to verify Country");
		
		log(logger, "Verifying State section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.state.value"), 3),
				"Unable to verify State");
		
		log(logger, "Verifying Address 1 section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.address1.value"), 4),
				"Unable to verify Address 1");
		
		log(logger, "Verifying ZipCode section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.zipcode.value"), 5),
				"Unable to verify ZipCode");
		
		log(logger, "Verifying Address 2 section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.address2.value"), 6),
				"Unable to verify Address 2");
		
		log(logger, "Verifying Mobile Phone Number section");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(PropertiesRepository.getString("id.home.profile.account.setting.personal.section.loc"),   
				PropertiesRepository.getString("id.home.profile.account.setting.personal.mobile.value"), 7),
				"Unable to verify Mobile Phone Number");
		logger.info("INST1712_VerifyAccCreationPageRearrange End ");
	}
}
