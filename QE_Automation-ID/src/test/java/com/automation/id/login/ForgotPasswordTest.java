package com.automation.id.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HelpPage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class ForgotPasswordTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HelpPage helpPage;
	
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		helpPage = new HelpPage(driver);
	}
	
	@TestAnnotations(testID="INST-1568")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify that inactive user flow")
	public void INST1568_VerifyInactiveUserFlow() throws Exception {
		log(logger, "INST1568_VerifyInactiveUserFlow Start");
		logger.info("INST1568_VerifyInactiveUserFlow Start");
		
		log(logger, "Verifying Inactive Popup");
		VerificationHandler.verifyTrue(loginPage.verifyInActiveUser(PropertiesRepository.getString("id.login.inactive.username.value"), PropertiesRepository.getString("id.login.inactive.password.value")), "Unable to verify Inactive user details");
		
		logger.info("INST1568_VerifyInactiveUserFlow End");
		log(logger, "INST1568_VerifyInactiveUserFlow End");
	}

	
	@TestAnnotations(testID="INST-1569")
	@Test(priority = 3, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify that non account holder get forgot username email::LogIn-Forgot Password")
	public void INST1569_VerifyForgotPasswordFuncationality() throws Exception {
		log(logger, "INST1569_VerifyForgotPasswordFuncationality Start");
		logger.info("INST1569_VerifyForgotPasswordFuncationality Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));

		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);

		log(logger, "Clicking on Username button");
		loginPage.verifyAndClickWithSwitch(
				PropertiesRepository.getString("id.home.forgot.password.popup.username.button.loc"), true);

		log(logger, "Enter Email");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.forgot.password.username.email.text.loc"),2,
				PropertiesRepository.getString("id.home.forgot.password.username.email.text.1569.value"));

		log(logger, "Verify Email Toast Message");
		VerificationHandler.verifyTrue(
				loginPage.verifyToastMessage(
						PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"),
						PropertiesRepository.getString("id.home.email.toast.message.value")),
				"Unable to verify Email Toas Message");
		
		log(logger, "INST1569_VerifyForgotPasswordFuncationality End");
		log(logger, "INST1569_VerifyForgotPasswordFuncationality End");
	}
	
	/**
	 * Not in Regression suite, so commenting
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	//@TestAnnotations(testID="INST-1694")
	//@Test(priority = 4, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify user can change password by email::LogIn-Forgot Password")
	public void INST1694_VerifyChangePasswordByEmail() throws Exception {
		logger.info("INST1694_VerifyChangePasswordByEmail Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);

		log(logger, "Clicking on Username button");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.username.button.loc"), true);
		
		log(logger, "Enter Email");
		loginPage.enterText(PropertiesRepository.getString("id.home.forgot.password.username.email.text.loc"), PropertiesRepository.getString("id.home.forgot.password.username.email.text.value"));
		
		log(logger, "Verify Email Toast Message");
		VerificationHandler.verifyTrue(loginPage.verifyToastMessage(PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"), PropertiesRepository.getString("id.home.email.toast.message.value")),"Unable to verify Email Toas Message");
		
		log(logger, "INST1694_VerifyChangePasswordByEmail End");

	}
	
	//@TestAnnotations(testID="INST-1570")
	//@Test(priority = 5, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify that inactive user flow::LogIn-Forgot Password")
	public void INST1570_VerifyInactiveUserFlow() throws Exception {
		logger.info("INST1568_VerifyInactiveUserFlow Start");
		
		log(logger, "Verifying Inactive Popup");
		VerificationHandler.verifyTrue(loginPage.verifyInActiveUser(PropertiesRepository.getString("id.login.inactive.username.value"), PropertiesRepository.getString("id.login.inactive.password.value")), "Unable to verify Inactive user details");
		
		logger.info("INST1568_VerifyInactiveUserFlow End");
	}
	
	@TestAnnotations(testID="INST-1701")
	@Test(priority = 6, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Confirm password should not clickable before entering password in New password text box::LogIn-Forgot Password")
	public void INST1701_VerifyConfirmPwdNotClickable() throws Exception {
		log(logger, "INST1701_VerifyConfirmPwdNotClickable Start");
		logger.info("INST1701_VerifyConfirmPwdNotClickable Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Clicking on Forgot username and/or password Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.forgot.username.and.password"), true);
		
		log(logger, "Clicking on Password button");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.popup.password.button.loc"), true);

		log(logger, "Entering User name");
		loginPage.enterTextWithSwitchToLatestWindow(
				PropertiesRepository.getString("id.home.page.forget.password.scenario.your.username.textbox.loc"),
				PropertiesRepository.getString("id.login.faculty.username.1701.changes"));

		log(logger, "Clicking on Answering security Question radio button");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.page.forget.password.scenario.answering.security.questions.radio.button.loc"), true);
		
		log(logger, "Clicking on Continue Button");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.forgot.password.username.continue.button.loc"), true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Entering Security Question 1");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 0,
				PropertiesRepository.getString("id.home.security.question.input.value1"));

		log(logger, "Entering Security Question 2");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 1,
				PropertiesRepository.getString("id.home.security.question.input.value2"));

		log(logger, "Entering Security Question 3");
		loginPage.enterTextList(PropertiesRepository.getString("id.home.security.question.input.new.loc"), 2,
				PropertiesRepository.getString("id.home.security.question.input.value3"));
	
		log(logger, "Clicking on Continue Button for security question popup");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.home.security.question.continue.button.loc"), true);
		//loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Re-enter password is disabled");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.home.disabled.reenter.password.text.box.loc")),"Element is not disabled");
		
		log(logger, "INST1701_VerifyConfirmPwdNotClickable End");
		log(logger, "INST1701_VerifyConfirmPwdNotClickable End");
	}

}
