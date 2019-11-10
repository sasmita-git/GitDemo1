package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest10 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TutorialPage tutorialPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage = new TutorialPage(driver);
	}

@TestAnnotations(testID="NewATI-536")
@Test(priority = 9, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Verify user can unlock the account using Email Id.::LoginPage")
public void NewATI536_VerifyUnLockAccUsingEmailId() throws Exception {
	log(logger, "NewATI536_VerifyUnLockAccUsingEmailId End");

	log(logger, "Loging to application");
	loginPage.enterURL("newati.stage.login.url");

	log(logger, "click on forget password link");
	loginPage
			.clickForgotPasswordLink("new-atitesting.forgot.password.link");

	log(logger, "click on username button");
	loginPage.clickButton(PropertiesRepository
			.getString("new-atitesting.username.password.button"), 0);

	log(logger, "Enter Emaild Id");
	loginPage.enterValue(PropertiesRepository
			.getString("new-atitesting.username.textbox"),"murali.inbasekaran@happiestminds.com");

	
	/*log(logger, "Clicking on Email Radio Button");
	loginPage.clickButton(PropertiesRepository
			.getString("new-atitesting.email.radio.button"));*/

	log(logger, "Clicking on Continue Button");
	loginPage
			.clickButton(
					PropertiesRepository
							.getString("new-atitesting.username.email.continue.button.loc"),
					false);

	log(logger, "Verifying Toast Email Message"); // Valid Email ID.
													// murali.inbasekaran@happiestminds.com
	VerificationHandler
			.verifyTrue(
					loginPage
							.verifyContainsMessageWithDefaultWinSwitch(
									PropertiesRepository
											.getString("new-atitesting.toast.message"),
									PropertiesRepository
											.getString("new-atitesting.username.email.toast.message.value")),
					"Unable to verify Email Error Message");

	log(logger, "NewATI536_VerifyUnLockAccUsingEmailId End");
}
@TestAnnotations(testID="NewATI-76")
@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify the functionality of 'Online Store' link.::CreateAccount")
public void NewATI76_VerifyOnlineStoreLink() throws Exception {
	logger.info("NewATI76_VerifyOnlineStoreLink Starts");
	
	///added by priyanka
			loginPage.enterURL("newati.stage.login.url");
	
	//log(logger,"click on signout button");
	//homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
	
	log(logger,"verifying links in the home tab");
	tutorialPage.clickButtonFromList("new-atitesting.onlinestore.link", 1);

	log(logger,"verifying  window size");
	VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
	
	logger.info("NewATI76_VerifyOnlineStoreLink Ends");
}
}
