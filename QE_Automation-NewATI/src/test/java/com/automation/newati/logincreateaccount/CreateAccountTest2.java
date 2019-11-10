package com.automation.newati.logincreateaccount;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class CreateAccountTest2 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPage createAccountPage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private HomePage homePage;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
	}


	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = " NewATI-1064:Create account other then male and female gender")
	public void NewATI1064_CreateAccountOtherThenMaleAndfemaleGender() throws Exception {
		log(logger, "NewATI1064_CreateAccountOtherThenMaleAndfemaleGender start");

		loginPage.enterURL("newati.login.url");
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName , sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "NewATI1064_CreateAccountOtherThenMaleAndfemaleGender End");
	}
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-1220:Verify user can create an account successfully")
	public void NewATI1220_VerifUserCanCreateAccountSuccessfully() throws Exception {
		log(logger, "NewATI1064_CreateAccountOtherThenMaleAndfemaleGender start");

		loginPage.enterURL("newati.login.url");
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName , sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "NewATI1220_VerifUserCanCreateAccountSuccessfully End");
	}
}

