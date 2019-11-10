package com.automation.newati.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;

public class ForgetPasswordTest1 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority = 1, enabled = true, alwaysRun = true, description = "NewATI-560:Verification for Email link functionality for Inactive User")
	public void NEWATI560_EmailLinkFunctionalityforInactiveUser() throws Exception {
		log(logger, "NEWATI560_EmailLinkFunctionalityforInactiveUser Start");
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"), PropertiesRepository.getString("new-atitesting.inactive.user1.name"));
		
		log(logger, "Clicking on Email Radio Button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("new-atitesting.email.radio.button1"),1);
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		
		boolean result=loginPage.verifyEmailSentMessage("new-atitesting.email.message.loc","new-atitesting.email.success.message");
		VerificationHandler.verifyTrue(result, "Email is not sent successfully");
		
	
		log(logger, "NEWATI560_EmailLinkFunctionalityforInactiveUser End");
	}
	
	@Test(priority = 2, enabled = true, alwaysRun = true, description = " NewATI-561:Verification for Email link functionality for Locked User")
	public void NEWATI561_EmailLinkFunctionalityforLockedUser() throws Exception {
		log(logger, "NEWATI560_EmailLinkFunctionalityforLockedUser Start");
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		//loginPage.lockTheAccount();
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), PropertiesRepository.getString("new-atitesting.locked.user.name1"));
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), PropertiesRepository.getString("new-atitesting.lock.user.name1"));
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"), PropertiesRepository.getString("newati.login.user.name.forgotpwd"));
		
		log(logger, "Clicking on Email Radio Button");	
		loginPage.clickButtonFromList(PropertiesRepository.getString("new-atitesting.email.radio.button1"),1);
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result=loginPage.verifyEmailSentMessage("new-atitesting.email.message.loc","new-atitesting.email.success.message");
		VerificationHandler.verifyTrue(result, "Email is not sent successfully");
		
		log(logger, "NEWATI560_EmailLinkFunctionalityforLockedUser End");
	}
	
	@Test(priority = 3, enabled = true, alwaysRun = true, description = "NewATI-566:Verify reactivation of student account via email flow")
	public void NEWATI566_ReactivationViaEmailFlow() throws Exception {
		log(logger, "NEWATI566_ReactivationViaEmailFlow Start");
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		log(logger, "Enter value in user name and password");
		loginPage.enterUserIdAndPwd(PropertiesRepository
				.getString("new-atitesting.566.student.username"),
				PropertiesRepository
						.getString("new-atitesting.566.student.password"));
		
		log(logger, "Clicking on Email Radio Button");	
		loginPage.clickButtonFromList(PropertiesRepository.getString("new-atitesting.email.radio.button1"),1);
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		
		log(logger, "Verifying Email Sent error message in popup");
		VerificationHandler.verifyTrue(
				loginPage.verifyContainsMessageWithDefaultWinSwitch(
						PropertiesRepository.getString("new-atitesting.inactive.account.email.sent.loc"),
						PropertiesRepository.getString("new-atitesting.email.success.message")),
				"Email is not sent successfully");
	
		log(logger, "NEWATI566_ReactivationViaEmailFlow End");
	}
	
}
