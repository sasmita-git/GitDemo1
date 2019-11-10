package com.automation.id.login;

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



public class LoginTest3 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private static String loginPassword = null;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@TestAnnotations(testID="INST-1843")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Change password using security questions")
	public void INST1843_VerifyChangePasswordUsingSecurityQuestion() throws Exception {
		log(logger, "INST1843_VerifyChangePasswordUsingSecurityQuestion Start");
		logger.info("INST1843_VerifyChangePasswordUsingSecurityQuestion Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);
		
		log(logger, "Verifying Forgot Username/Password Heading");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.heading.loc"), false), "Unable to verify Heading");
		
		log(logger, "Verifying Forgot Username/Password Content");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.content.loc"), false), "Unable to verify Content");
		
		log(logger, "Verifying Forgot Username/Password Username button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.username.button.loc"), false), "Unable to verify Username button");
		
		log(logger, "Verifying Forgot Username/Password Password button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), false), "Unable to verify Password button");

		log(logger, "Clicking on Password button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), true), "Unable to Clicking on Password button");
		
		log(logger, "Entering User name");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("id.home.page.forget.password.scenario.your.username.textbox.loc"),
				PropertiesRepository.getString("id.reg.auto.lgn.instuctor1.username"));
		
		log(logger, "Clicking on Answering security Question radio button");
		VerificationHandler
				.verifyTrue(loginPage.verifyAndClickWithSwitch(
						PropertiesRepository.getString(
								"id.home.page.forget.password.scenario.answering.security.questions.radio.button.loc"),
						true), "Unable to click on Answering security Question radio button");
		
		log(logger, "Clicking on Continue Button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"), true),
				"Unable to Click on Continue Button");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering Security Question 1");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 0,
				PropertiesRepository.getString("id.home.security.question.input.new.value1"));

		log(logger, "Entering Security Question 2");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 1,
				PropertiesRepository.getString("id.home.security.question.input.new.value2"));

		log(logger, "Entering Security Question 3");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 2,
				PropertiesRepository.getString("id.home.security.question.input.new.value3"));

		log(logger, "Clicking on Continue Button for security question popup");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(
				PropertiesRepository.getString("id.home.security.question.continue.button.loc"), true), "Unable to Click on Continue Button for security question popup");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		loginPassword = loginPage.generateLoginPassword();
		
		log(logger, "Entering Password");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("ATIFaculty.atitesting.new.password"),
				loginPassword);
		
		log(logger, "Entering Password Confirmation");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("ATIFaculty.atitesting.reset.password"),
				loginPassword);
		
		log(logger, "Clicking on Password Reset Page Continue button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(
				PropertiesRepository.getString("id.login.password.reset.page.continue.button.loc"), true), "Unable to Click on Password Reset Page Continue button");
		
		log(logger, "Clicking on Password Reset Page Login button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(
				PropertiesRepository.getString("id.login.password.reset.page.login.button.loc"), true), "Unable to Click on Password Reset Page Login button");
		
		log(logger,"Verifying valid login with new password");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.reg.auto.lgn.instuctor1.username"), loginPassword);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), false), "Unable to click left navigation");
		
		logger.info("INST1843_VerifyChangePasswordUsingSecurityQuestion End");
		log(logger, "INST1843_VerifyChangePasswordUsingSecurityQuestion End");
	}
	
	@TestAnnotations(testID="INST-1745")
	@Test(priority = 2, alwaysRun =true, enabled = true, groups={"Regression"}, description = "inst-1745:Check for Password with special characters in it")
	public void INST1745_VerifyPasswordWithSpecialCharacters() throws Exception {
		log(logger, "INST1745_VerifyPasswordWithSpecialCharacters Start");
		logger.info("INST1745_VerifyPasswordWithSpecialCharacters Start");
		
		log(logger,"Varifying valid login ");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.director.home2.0.login.user.name"), PropertiesRepository.getString("id.director.home2.0.login.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), false), "Unable to click left navigation");
		
		logger.info("INST1745_VerifyPasswordWithSpecialCharacters End");
		log(logger, "INST1745_VerifyPasswordWithSpecialCharacters End");
	}
	
	@TestAnnotations(testID="INST-1715")
	@Test(priority = 3, alwaysRun =true, enabled = true, groups={"Regression"}, description = "inst-1715:Verify block/unblock UI happens for log-in & log-out")
	public void INST1715_VerifyBlockUnBlockUIFunctionality() throws Exception {
		log(logger, "INST1715_VerifyBlockUnBlockUIFunctionality Start");
		logger.info("INST1715_VerifyBlockUnBlockUIFunctionality Start");
		
		log(logger, "Login to application");
		VerificationHandler.verifyTrue(
				loginPage.loginToApplicationVerifyLoadingImg(
						PropertiesRepository.getString("id.login.faculty.username"),
						PropertiesRepository.getString("id.login.faculty.password")),
				"Unable to login to application and loading image is not displayed");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Edit Profile Link");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigation.user.profile.loc"), 0, true), "Unable to Click Edit Profile Link in Left navigation ");
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigation.user.details.loc"), 2, true), "Unable to verify Signout Page ");
		VerificationHandler.verifyTrue(loginPage.verifyWaitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader")), "Loading image is not displayed while loading");
		
		log(logger, "Verifying Username");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.login.logo"),0,false), "Unable to verify UserName");
		
		log(logger, "INST1715_VerifyBlockUnBlockUIFunctionality Start");
		logger.info("INST1715_VerifyBlockUnBlockUIFunctionality End");
	}
	
	@TestAnnotations(testID="INST-1692")
	@Test(priority = 4, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify user should go to login page while dismissing forgot password")
	public void INST1692_VerifyDismissingForgotPasswordPopup() throws Exception {
		log(logger, "INST1692_VerifyDismissingForgotPasswordPopup Start");
		logger.info("INST1692_VerifyDismissingForgotPasswordPopup Start");
		// Step 1
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		// Step 1
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);
		// Step 1
		log(logger, "Verifying Forgot Username/Password Heading");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.heading.loc"), false), "Unable to verify Heading");
		// Step 2
		log(logger, "Clicking on Password button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), true), "Unable to Clicking on Password button");
		// Step 2
		log(logger, "Entering User name");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("id.home.page.forget.password.scenario.your.username.textbox.loc"),
				PropertiesRepository.getString("id.reg.auto.lgn.instuctor1.username"));
		// Step 2
		log(logger, "Clicking on Answering security Question radio button");
		VerificationHandler
				.verifyTrue(loginPage.verifyAndClickWithSwitch(
						PropertiesRepository.getString(
								"id.home.page.forget.password.scenario.answering.security.questions.radio.button.loc"),
						true), "Unable to click on Answering security Question radio button");
		// Step 2
		log(logger, "Clicking on Continue Button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"), true),
				"Unable to Click on Continue Button");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 2
		log(logger, "Verifying Forgot Username/ Password Popup Header");
		VerificationHandler
		.verifyTrue(loginPage.verifyMessage("id.login.password.reset.forgot.username.password.header.loc", 0, PropertiesRepository.getString("id.login.password.reset.forgot.username.password.header.value")), "Unable to Verify Forgot Username/ Password Popup Header");
		// Step 2
		log(logger, "Clicking on Forgot Username/ Password Popup close button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.login.password.reset.forgot.username.password.close.button.loc"), true), "Unable to Click on Forgot Username/ Password Popup close button");
		// Step 2
		log(logger, "Verifying Login page");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), false), "Unable to Verify Login page");
		
		log(logger, "INST1692_VerifyDismissingForgotPasswordPopup End");
		logger.info("INST1692_VerifyDismissingForgotPasswordPopup End");
	}
	
	@TestAnnotations(testID="INST-1604")
	@Test(priority = 5, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify erorr message on trying to reactivate instructor/director/proctor account")
	public void INST1604_VerifyErrorMsgForInactiveUser() throws Exception {
		log(logger, "INST1604_VerifyErrorMsgForInactiveUser Start");
		logger.info("INST1604_VerifyErrorMsgForInactiveUser Start");
		// Step 1
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		// Step 1
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);
		// Step 1
		log(logger, "Verifying Forgot Username/Password Heading");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.heading.loc"), false), "Unable to verify Heading");
		// Step 2
		log(logger, "Clicking on Password button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), true), "Unable to Clicking on Password button");
		// Step 2
		log(logger, "Entering User name");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("id.home.page.forget.password.scenario.your.username.textbox.loc"),
				PropertiesRepository.getString("id.login.inactive.username.value"));
		// Step 2
		log(logger, "Clicking on Answering security Question radio button");
		VerificationHandler
				.verifyTrue(loginPage.verifyAndClickWithSwitch(
						PropertiesRepository.getString(
								"id.home.page.forget.password.scenario.answering.security.questions.radio.button.loc"),
						true), "Unable to click on Answering security Question radio button");
		// Step 2
		log(logger, "Clicking on Continue Button");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"), true),
				"Unable to Click on Continue Button");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Error message");
		VerificationHandler.verifyTrue(
				loginPage.verifyMessage("id.login.password.reset.forgot.username.password.specified.user.not.found.loc",
						0,
						PropertiesRepository.getString(
								"id.login.password.reset.forgot.username.password.specified.user.not.found.value")),
				"Unable to Verify Error Message");
	
		log(logger, "INST1604_VerifyErrorMsgForInactiveUser End");
		logger.info("INST1604_VerifyErrorMsgForInactiveUser End");
	}
	
}
