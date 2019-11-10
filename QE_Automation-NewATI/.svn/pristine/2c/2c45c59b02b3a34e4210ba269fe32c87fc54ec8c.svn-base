package com.automation.newati.smoke;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest6 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPage createAccountPage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private HomePage homePage;
	private ButtonHandler buttonHandler;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		buttonHandler = new ButtonHandler(driver);
	}
	@TestAnnotations(testID="NewATI-539")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Validate that an new user is able to login to the application::CreateAccount")
	public void NewATI539_CreateAccount() throws Exception {
		log(logger, "NewATI539_CreateAccount Starts ");

		loginPage.enterURL("newati.login.url");
		
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");

		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");

		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");

		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");

		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");

		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");

		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"Add product button is not Enabled");

		log(logger, "createAccount: End");
		
		log(logger, "Click on AddProduct Button");
		createAccountPage.clickOnAddProductButton();
		
		log(logger, "Entering CDN");
		createAccountPage.enterCDNToAddProduct();
		
		log(logger, "clickOnButton ");
		createAccountPage.clickOnButton("new-atitesting.createaccount.addProductContinueBtnLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name"));
		log(logger, "Verifying the added Product in Learn tab");
		learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc"));
		
		/*log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);*/
		
		log(logger, "NewATI539_CreateAccount End");
	}
	


}
