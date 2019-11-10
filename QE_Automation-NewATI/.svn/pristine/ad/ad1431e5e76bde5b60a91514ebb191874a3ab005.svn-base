package com.automation.newati.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class LoginPageValidationTest  extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TutorialPage tutorialPage;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage = new TutorialPage(driver);
	}
	
	@Test(priority = 1,description="NewATI-567:Verify erorr message on trying to reactivate instructor/director/proctor account")
	public void NewATI567_VerifyErorrMessageonTryingToReactivateInstructor() throws Exception {
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateInstructor Start");
		
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		
		log(logger, "Enter username");
		loginPage.enterInput(PropertiesRepository.getString("new-atitesting.username.textbox"),PropertiesRepository.getString("new-atitesting.instructor.forgot.username.fac"));
//		loginPage.enterValue(PropertiesRepository.getString("new-atitesting.username.textbox"), PropertiesRepository.getString("new-atitesting.instructor.forgot.username.fac"));
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateInstructor End");
	}
	
	@Test(priority = 2,description="NewATI-567:Verify erorr message on trying to reactivate instructor/director/proctor account")
	public void NewATI567_VerifyErorrMessageonTryingToReactivateDirector() throws Exception {
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateDirector Start");
		
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		
		log(logger, "click on username button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		
		log(logger, "Enter username");
		loginPage.enterValue(PropertiesRepository.getString("new-atitesting.username.textbox"), PropertiesRepository.getString("new-atitesting.director.forgot.username"));
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		
		
		
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateDirector End");
	}
	
	
	
	@Test(priority = 3,description="NewATI-567:Verify erorr message on trying to reactivate instructor/director/proctor account")
	public void NewATI567_VerifyErorrMessageonTryingToReactivateProctor() throws Exception {
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateProctor Start");
		
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		
		log(logger, "click on forget password link");
		loginPage.clickForgotPasswordLink("new-atitesting.forgot.password.link");
		
		/*boolean result=loginPage.verifyStep1ObjectsOnForgetUsernameAndPasswordPopUp();
		VerificationHandler.verifyTrue(result, "Objects in the Step1 of Forget Username And Password PopUp are mismatch");*/
		
		
		log(logger, "click on password button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.username.password.button"), 1);
		
		log(logger, "Enter username");
		loginPage.enterValue(PropertiesRepository.getString("new-atitesting.username.textbox"), PropertiesRepository.getString("new-atitesting.proctor.forgot.username"));
		
		log(logger, "click on continue button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.password.page.continue.button"));
		
		log(logger, "NewATI567_VerifyErorrMessageonTryingToReactivateProctor End");
	}
	
	@TestAnnotations(testID="NewATI-78")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the functionality of 'Contact Us' link")
	public void NewATI78_ContactUsLinkloc() throws Exception {
		logger.info("NewATI78_ContactUsLinkloc Starts");
	///added by priyanka
		loginPage.enterURL("newati.stage.login.url");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify Contact Us link
		VerificationHandler.verifyEquals(loginPage.verifyContactUsLinks(),PropertiesRepository
				.getString("new-atitesting.contactUsTextInpt"),"Unable to verify Contact Us link");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("NewATI78_ContactUsLinkloc Ends");
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
