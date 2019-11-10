package com.automation.newati.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.jaca.TestAnnotations;

public class LoginTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}
	
	@Test(priority = 1, alwaysRun = true, description = "Verify faculty login via student portal")
	public void NewATI767_verifyFacultyLoginMsg() throws Exception {
		logger.info("NewATI767_verifyFacultyLoginMsg Start");
		
		log(logger, "Verifying Factulty login");
		VerificationHandler.verifyTrue(loginPage.verifyFacultyLogin("stgreg330", "Testing1"),
				"Verifying Factulty login");

		logger.info("NewATI767_verifyFacultyLoginMsg End");
	}

	@Test(priority = 3, alwaysRun = true, description = "Verify reactivation of student account via email flow")
	public void NewATI566_verifyReactivationAccountViaMailLogin() throws Exception {
		logger.info("NewATI566_verifyReactivationAccountViaMailLogin Start");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Factulty login");
//		VerificationHandler.verifyTrue(loginPage.verifyReactivationAccountViaMailLogin("AutoUser2302201891", "Test123"),
//				"Verifying Reactivation of Account login msg");
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("NewATI655_verifyReactiveAccountViaMailLogin End");
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-843")
	@Test(priority = 4, enabled = true, alwaysRun = true, description = "NewATI-843:Verify the flow on closing modal window.(Inactive Institution )")
	public void NewATI843_verifyInactiveInstPopup() throws Exception {

		log(logger, "NewATI843_verifyInactiveInstPopup Start");

		log(logger, "Login to application with user having inactive institution");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.inactive.inst"), PropertiesRepository.getString("newati.login.pwd.inactive.inst"));
		
		log(logger, "Verifying Student to get window with following information:'The Institution set on your profile is no longer active. Please select from the below active institutions before proceeding'");
		VerificationHandler.verifyTrue(baseHandler.findElement("#UpdateInstitutionDialog>h3").getText().contains("The Institution set on your profile is no longer active. Please select from the below active institutions before proceeding"));
		
		log(logger, "Verifying Dropdown is displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement("#institutionInput").isDisplayed());
		
		log(logger, "Click on close button on the popup");
		loginPage.clickButton("button[title='close']", 1);
		loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying if login page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Student Login - ATI Testing"));		
		
		logger.info("NewATI843_verifyInactiveInstPopup End");
	}
	
	
}