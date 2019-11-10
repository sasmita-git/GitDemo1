package com.automation.id.reports;

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

public class VerifyFcaultyNavigateToOnlineStore extends BaseTest {

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

	// @TestAnnotations(testID="INST-1684")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"smoke" }, description = "Faculty should have access to the Online Store link through the ellipses in the top right corner of the page.")
	public void INST1684_VerifyFcaultyNavigateToOnlineStore() throws Exception {
		logger.info("INST1684_VerifyFcaultyNavigateToOnlineStore Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.director.Password"));

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on online store link");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.homepage.static.menu.list"), false),
				"Unabel to click Signout link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 1);

		Thread.sleep(2000);

		log(logger, "verify Contact Us Link is present");
		VerificationHandler.verifyTrue(loginPage.verifyContactUsLink("Contact Us"));

		log(logger, "verify online store link is present");
		VerificationHandler.verifyTrue(loginPage.verifyOnlineStoreLink("Online Store"));

		log(logger, "verify edit account information link");
		VerificationHandler.verifyTrue(loginPage.verifyEditAccountInfoLink("Edit Account Information"));

		log(logger, "verify home link is present or not");
		VerificationHandler.verifyTrue(loginPage.verifyHomeLink("Home"));

		log(logger, "click on contact us link");
		loginPage.clickOnContactUsLink();

		log(logger, "click on online store link");
		loginPage.clickOnOnlineStoreLink();

		log(logger, "click on edit profile link");
		loginPage.clickOnEditProfileLink();

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on online store link");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.homepage.static.menu.list"), false),
				"Unabel to click Signout link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 1);

		log(logger, "click on home link");
		loginPage.clickOnHomeLink();

		log(logger, "click on left nav link to check that user is faculty portal");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		logger.info("INST1684_VerifyFcaultyNavigateToOnlineStore End");
	}

}
