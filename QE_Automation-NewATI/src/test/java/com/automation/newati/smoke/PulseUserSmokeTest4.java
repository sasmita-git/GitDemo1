package com.automation.newati.smoke;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest4 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private HomePage homePage;
	private PaymentsPage paymentsPage;
	public BaseHandler baseHandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	String downloadFilepath = null;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		homePage = new HomePage(driver);
		paymentsPage = new PaymentsPage(driver);
		baseHandler = new BaseHandler(driver);

	}

	@TestAnnotations(testID = "NewATI-849")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "NewATI849_VerifyTheResetLockedFunctionalityFlow")
	public void NewATI849_VerifyTheResetLockedFunctionalityFlow() throws Exception {
		log(logger, "NewATI849_VerifyTheResetLockedFunctionalityFlow");
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId == null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		// loginPage.loginToApplication(userId,
		// PropertiesRepository.getString("newati.login.payment.pwd"));
		// loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");

		log(logger, "Enter value in user name and password for First Time");
		loginPage.enterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.InvalidenterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.InvalidenterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.InvalidenterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.InvalidenterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.InvalidenterUserIdAndPwd(userId, PropertiesRepository.getString("new-atitesting.lock.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"), true);
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"), true);
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"), true);
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"), true);
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"), true);

//		String termsHeader = loginPage.getText(PropertiesRepository.getString("new-atitesting.T&C"));
//
//		if (StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
//			// Clicking on Check Box.
//			loginPage.verifyAndClickWithList(".checkbox-not-checked", 3, true);
//
//			// Clicking on Continue Button.
//			loginPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
//
//			// Wait for loading image.
//			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		}

//		String welcomepopup = loginPage.getText(PropertiesRepository.getString("new-atitesting.welcometoati"));
//
//		if (StringUtils.isNotEmpty(welcomepopup) && "Welcome to ATI!".equalsIgnoreCase(welcomepopup)) {
//
//			// Clicking on Continue Button.
//			loginPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.welcometoati.close"), true);
//
//			// Wait for loading image.
//			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//			loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		}
//		loginPage.MaintanacePopUp();
//		log(logger, "Verifying Account is locker error message");
//		VerificationHandler
//				.verifyTrue(
//						loginPage.verifyMessageWithDefaultWinSwitch(
//								PropertiesRepository.getString("new-atitesting.account.lock.error.message"),
//								PropertiesRepository.getString("new-atitesting.account.lock.error.message.value")),
//						"Unable to verify account lock error message");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
//
//		log(logger, "Validate Forgot Username/Password  pop up");
//
//		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.username.textbox"),
//				"Username Text is not displayed");
//		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.password.page.continue.button"),
//				"Continue button is not displayed");
//		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.email.radio.button1"),
//				"Email radio button is not displayed");
//		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.email.radio.button"),
//				"Security question radio button is not displayed");
//
//		// JavascriptExecutor jse = (JavascriptExecutor)driver;
//		// jse.executeScript("arguments[0].value=
//		// '"+PropertiesRepository.getString("new-atitesting.lock.user.name.new")+"';",
//		// baseHandler.findElement(PropertiesRepository.getString("new-atitesting.username.textbox")));
//		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"), userId);
//
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
//
//		log(logger, "enter input for ecurity question");
//		loginPage.clickStudentSecurityQuestion(0,
//				PropertiesRepository.getString("new-atitesting.account.first.security.question.input.hm"));
//		loginPage.clickStudentSecurityQuestion(1,
//				PropertiesRepository.getString("new-atitesting.account.first.security.question.input.hm"));
//		loginPage.clickStudentSecurityQuestion(2,
//				PropertiesRepository.getString("new-atitesting.account.first.security.question.input.hm"));
//
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.second.page.continue.button"));
//		String password = CommonUtils.getRandomPassword();
//		log(logger, "New Password --> " + password);
//		loginPage.resetWithNewPassword(password, password);
//		// homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.third.page.continue.button"));
//
//		log(logger, "click on sign on now button");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.sign.on.now.button"), false);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		loginPage.enterTextValue(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), true, password);
//
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
//
//		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.logout.loc"),
//				"Login is not Successful");
//		loginPage.MaintanacePopUp();
//		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
//				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
//		log(logger, "update address in My account Page ");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.edit.address.link.loc"));
//		createAccountPage.editAddressInMyAccount("new-atitesting.edit.address.field.loc",
//				"new-atitesting.addresseditinput.new", "new-atitesting.edit.address.save.loc");
//		log(logger, "Update password in mY Account page");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.edit.password.link.loc"));
//		String password1 = CommonUtils.getRandomPassword();
//		createAccountPage.editPasswordInMyAccount("new-atitesting.oldpassword.loc", "new-atitesting.newpassword.loc",
//				"new-atitesting.confirmpassword.loc", password, password1, "new-atitesting.edit.password.save.loc");
//		log(logger, "update security qsn in My account page ");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.edit.sequrity.link.loc"));
//		createAccountPage.editSecurityqsnInMyAccount("new-atitesting.edit.sequrity.field.loc",
//				"new-atitesting.account.first.security.question.input", "new-atitesting.edit.sequrity.save.loc");
//		homePage.scrollUpPage();
//		log(logger, "Logout to Application");
//		homePage.SignOut();
//		log(logger, "Verify Login page ");
//		VerificationHandler.verifyTrue(homePage.verifyLogo("new-atitesting.learntab.tutorial.logo"),
//				"Login is not Successful");
//		log(logger, "login to application with existing user ");
//		loginPage.loginToApplication(userId, password1);

		log(logger, "NewATI849_VerifyTheResetLockedFunctionalityFlow");

	}
}
