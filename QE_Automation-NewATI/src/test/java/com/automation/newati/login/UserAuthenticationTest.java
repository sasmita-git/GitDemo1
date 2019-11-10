package com.automation.newati.login;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.LoginPage;

public class UserAuthenticationTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TextHandler textHandler;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		textHandler = new TextHandler(driver);
		
	}


	@Test(priority = 1, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-88:Complete Process of Forgot Password")
	public void NewATI88_VerifyForgetPasswordFunctionality() throws Exception {
		log(logger, "NewATI88_VerifyForgetPasswordFunctionality Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.88.user.name.new"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));

		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		//String password = "A111520173";
		log(logger, "New Password --> " + password);
		loginPage.resetWithNewPassword(password,
				password);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Password Change success message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.username.email.password.change.success.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.email.password.change.success.message.value")),
						"Unable to verify Passord Change Success Message");
		log(logger, "click on sign on now button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.sign.on.now.button"), false);
		
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"),PropertiesRepository.getString("new-atitesting.88.user.name.new"));
//		loginPage.enterTextValue(PropertiesRepository.getString("new-atitesting.username.textbox.forgotpwd"),PropertiesRepository.getString("new-atitesting.88.user.name.new"));
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"),true, password);

		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		
		
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),"Login is not Successful");
		log(logger, "NewATI88_VerifyForgetPasswordFunctionality End");
	}
	
	@Test(priority = 2, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-91:Verify login with new password")
	public void NewATI91_VerifyLoginWithResetPassword() throws Exception {
		log(logger, "NewATI91_VerifyLoginWithResetPassword Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.88.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));

		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String newPassword = CommonUtils.getRandomPassword();
		log(logger, "New Password --> " + newPassword);
		loginPage.resetWithNewPassword(newPassword,
				newPassword);

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Password Change success message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.username.email.password.change.success.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.email.password.change.success.message.value")),
						"Unable to verify Passord Change Success Message");
		
		log(logger, "click on sign on now button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.sign.on.now.button"), false);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), PropertiesRepository.getString("new-atitesting.88.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in password ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"), newPassword);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String termsHeader = loginPage.getText(PropertiesRepository.getString("new-atitesting.T&C"));
		if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
			// Clicking on Check Box. 
			loginPage.verifyAndClickWithList(".checkbox-not-checked", 3, true);
			
			// Clicking on Continue Button.
			loginPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
			
			// Wait for loading image. 
			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		}
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),"Login is not Successful");
		
		log(logger, "NewATI91_VerifyLoginWithResetPassword End");
	}
	
	@Test(priority = 3, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-63:Username Retrieval Error Message")
	public void NewATI63_VerifyUserNameRetrivalErrorMsg() throws Exception {
		log(logger, "NewATI63_VerifyUserNameRetrivalErrorMsg Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on UserName button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 0);
		
		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(PropertiesRepository
						.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Invalid Email Error Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.username.email.error.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.blank.username.error.message")),
						"Unable to verify Username Error Message");
		
		log(logger, "NewATI63_VerifyUserNameRetrivalErrorMsg End");
	}
	
	@Test(priority = 4, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-61:Username Retrieval")
	public void NewATI61_VerifyUserNameRetrival() throws Exception {
		log(logger, "NewATI61_VerifyUserNameRetrival Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage
				.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository
				.getString("new-atitesting.username.password.button"), 0);

		log(logger, "Enter Email id Format");
		loginPage
				.enterValue(
						PropertiesRepository
								.getString("new-atitesting.username.email.textbox"),
						PropertiesRepository
								.getString("new-atitesting.61.valid.email.id"));

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(
						PropertiesRepository
								.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Toast Email Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.toast.message"),
										PropertiesRepository
												.getString("new-atitesting.username.email.toast.message.value")),
						"Unable to verify Email Error Message");
		
		log(logger, "NewATI61_VerifyUserNameRetrival End");
	}

	@Test(priority = 5, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-68:Forgot Username Retrieval")
	public void NewATI68_VerifyForgetuserNameRetrival() throws Exception {
		log(logger, "NewATI68_VerifyForgetuserNameRetrival Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on UserName button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 0);
		
		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(PropertiesRepository
						.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Invalid Email Error Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.username.email.error.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.blank.username.error.message")),
						"Unable to verify Username Error Message");
		
		log(logger, "Enter Invalid Email id Format");
		loginPage.enterValue(PropertiesRepository
				.getString("new-atitesting.username.email.textbox"),
				PropertiesRepository
						.getString("new-atitesting.username.invalid.email.id"));

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(PropertiesRepository
						.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Invalid Email Error Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.username.email.error.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.invalid.email.message")),
						"Unable to verify Email Error Message");
		
		log(logger, "Enter Email id Format");
		loginPage
				.enterValue(
						PropertiesRepository
								.getString("new-atitesting.username.email.textbox"),
						PropertiesRepository
								.getString("new-atitesting.61.valid.email.id"));

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(
						PropertiesRepository
								.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Toast Email Message");
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.toast.message"),
										PropertiesRepository
												.getString("new-atitesting.username.email.toast.message.value"));
		
		log(logger, "NewATI68_VerifyForgetuserNameRetrival End");
	}
	
	@Test(priority = 6, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-72:Reset password-Error Message")
	public void NewATI72_VerifyResetPasswordErrorMsg() throws Exception {
		log(logger, "NewATI72_VerifyResetPasswordErrorMsg Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on Password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);

		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.88.user.name"));

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));

		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));

		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,"1");

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,"2");

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		
		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(
	          PropertiesRepository.getString("new-atitesting.username.email.error.message.loc"),
	          PropertiesRepository.getString("new-atitesting.security.question.1.correct.answer.error.message")),
	      "Unable to verify 1 correct password error Message");
		  
		log(logger, "NewATI72_VerifyResetPasswordErrorMsg End");
	}
	
	@Test(priority = 7, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-85:Reset password-Error Message 2")
	public void NewATI85_VerifyForgetPasswordFunctionality2() throws Exception {
		log(logger, "NewATI85_VerifyForgetPasswordFunctionality2 Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);

		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.88.user.name"));

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));

		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));

		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));

		log(logger, "enter password");
		loginPage.resetWithNewPassword(CommonUtils.getRandomPassword(),
				CommonUtils.getRandomPassword());

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));

		log(logger, "Verifying Password Change error message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.blank.password.error.message.loc"),3,
										PropertiesRepository
												.getString("new-atitesting.security.question.1.correct.password.error.message")),
						"Unable to verify Passord Change Error Message");
		
		log(logger, "NewATI85_VerifyForgetPasswordFunctionality2 End");
	}
	
	@Test(priority = 8, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-112:Username Retrieval Error Message 2")
	public void NewATI112_VerifyUserNameRetrival2() throws Exception {
		log(logger, "NewATI112_VerifyUserNameRetrival2 Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");

		log(logger, "click on UserName button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 0);
		
		log(logger, "Enter Invalid Email id Format");
		loginPage.enterValue(PropertiesRepository
				.getString("new-atitesting.username.email.textbox"),
				PropertiesRepository
						.getString("new-atitesting.88.user.name"));

		log(logger, "Clicking on Continue Button");
		loginPage
				.clickButton(PropertiesRepository
						.getString("new-atitesting.username.email.continue.button.loc"));

		log(logger, "Verifying Invalid Email Error Message");
		VerificationHandler
				.verifyTrue(
						loginPage
								.verifyContainsMessageWithDefaultWinSwitch(
										PropertiesRepository
												.getString("new-atitesting.username.email.error.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.invalid.email.error.message")),
						"Unable to verify Email Error Message");
		
		log(logger, "NewATI112_VerifyUserNameRetrival2 End");
	}
	
	@Test(priority = 9, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-3:Verify forgot password Functionality")
	public void NewATI3_VerifyForgetPasswordFunctionality2() throws Exception {
		log(logger, "NewATI3_VerifyForgetPasswordFunctionality2 Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.88.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		Thread.sleep(2000);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for first security question");
		loginPage.clickStudentSecurityQuestion(0,PropertiesRepository.getString("new-atitesting.account.first.security.question.input"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter input for second security question");
		loginPage.clickStudentSecurityQuestion(1,PropertiesRepository.getString("new-atitesting.account.second.security.question.input"));

		log(logger, "enter input for third security question");
		loginPage.clickStudentSecurityQuestion(2,PropertiesRepository.getString("new-atitesting.account.third.security.question.input"));

		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		String password = CommonUtils.getRandomPassword();
		log(logger, "New Password --> " + password);
		loginPage.resetWithNewPassword(password,
				password);
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Password Change success message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.username.email.password.change.success.message.loc"),
										PropertiesRepository
												.getString("new-atitesting.username.email.password.change.success.message.value")),
						"Unable to verify Passord Change Success Message");
		Thread.sleep(1000);
		log(logger, "click on sign on now button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.sign.on.now.button"), false);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), PropertiesRepository.getString("new-atitesting.88.user.name"));
		
		log(logger, "Enter value in password ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"), password);

		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String termsHeader = loginPage.getText(PropertiesRepository.getString("new-atitesting.T&C"));
		if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
			// Clicking on Check Box. 
			loginPage.verifyAndClickWithList(".checkbox-not-checked", 3, true);
			
			// Clicking on Continue Button.
			loginPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
			
			// Wait for loading image. 
			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		}

		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),"Login is not Successful");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI3_VerifyForgetPasswordFunctionality2 End");
	}
	
	@Test(priority = 10, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-66:User Authentication Test")
	public void NewATI66_VerifyUserAuthentication() throws Exception {
		log(logger, "NewATI66_VerifyUserAuthentication Start");

		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Error message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.login.page.error.message"),
										PropertiesRepository
												.getString("new-atitesting.username.and.pwd.empty")),
						"Unable to verify User Authentication Error Message for both blank");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), PropertiesRepository.getString("new-atitesting.66.user.name"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Error message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.login.page.error.message"),
										PropertiesRepository
												.getString("new-atitesting.pwd.empty.error.message.loc")),
						"Unable to verify User Authentication when password is blank");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Blank in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), true, "");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in password ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"), true, "Test123");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));

		log(logger, "Verifying Error message");
		VerificationHandler.verifyTrue(loginPage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.login.page.error.message"),
										PropertiesRepository
												.getString("new-atitesting.username.and.pwd.empty")),
						"Unable to verify User Authentication when User is blank");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), true, PropertiesRepository.getString("new-atitesting.66.user.name"));
		
		log(logger, "Enter value in password ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"), true, PropertiesRepository.getString("new-atitesting.66.pwd"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String termsHeader = loginPage.getText(PropertiesRepository.getString("new-atitesting.T&C"));
		
		if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
			// Clicking on Check Box. 
			loginPage.verifyAndClickWithList(".checkbox-not-checked", 3, true);
			
			// Clicking on Continue Button.
			loginPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
			
			// Wait for loading image. 
			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		}
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),"Login is not Successful");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.MaintanacePopUp();
		log(logger, "Clicking on Signout button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("new-atitesting.hometab.upper.links.loc"), 3); 
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(loginPage.verifyElement(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc")),"Login is not displayed");
		
		log(logger, "Clicking on back button");
		driver.navigate().back();
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(loginPage.verifyElement(PropertiesRepository.getString("new-atitesting.hometab.upper.links.loc")),"Home is not displayed");
		VerificationHandler.verifyTrue(loginPage.verifyElement(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc")),"Login is not displayed");

		log(logger, "Enter value in user name ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.userNameLoc"), true, PropertiesRepository.getString("new-atitesting.66.user.name.inactive"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter value in password ");
		loginPage.enterTextValue(PropertiesRepository
				.getString("new-atitesting.homepage.passwordLoc"), true, PropertiesRepository.getString("new-atitesting.66.pwd"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Go Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "NewATI66_VerifyUserAuthentication End");
	}

}
