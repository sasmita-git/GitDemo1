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

public class CreateAccountTest extends BaseTest {
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

	/**
	 * After entering Confirm Email value, continue button is not getting enabled. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-115:Verify Create Account Functionality.")
	
	public void NewATI115_VerifyCreateAccountFunctionality() throws Exception {
		log(logger, "NewATI115_VerifyCreateAccountFunctionality Starts ");
		
		driver.get(PropertiesRepository.getString("newati.login.url"));
		
		log(logger, "click on create account link");
		tutorialPage.clickButtonFromList("new-atitesting.create.account.link.loc", 0);
		
//		log(logger, "click on close button");
//		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
//		
//		driver.navigate().refresh();
//		
//		log(logger, "click on create account link");
//		tutorialPage.clickButtonFromList("new-atitesting.create.account.link.loc", 0);	
		homePage.scrollDownPage();
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("new-atitesting.continue.button.new", 0);	
		
		boolean result=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.username.error.message"), PropertiesRepository.getString("new-atitesting.username.error.input"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "enter existing username");
		tutorialPage.enterText("new-atitesting.username.loc", "newati.login.learn.tab.user.name",0);
		
		
		log(logger, "Hit Tab keyboard key");
		tutorialPage.hitTabButton("new-atitesting.username.loc");
		
		boolean result1=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.username.error.message"), PropertiesRepository.getString("new-atitesting.username.error.input1"));
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "enter  username with less then 5 characters");
		tutorialPage.enterText("new-atitesting.username.loc", "newati.login.learn.tab.user.name2",0);
		
		log(logger, "Hit Tab keyboard key");
		tutorialPage.hitTabButton("new-atitesting.username.loc");
		
		boolean result2=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.username.error.message"), PropertiesRepository.getString("new-atitesting.username.error.input2"));
		VerificationHandler.verifyTrue(result2);
		
		log(logger, "enter  password");
		tutorialPage.enterText("new-atitesting.pwd.loc", "newati.login.learn.tab.pwd",1);
		
		log(logger, "Hit Tab keyboard key");
		tutorialPage.hitTabButton("new-atitesting.pwd.loc");
		
		boolean result3=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.pwd.error.message"), PropertiesRepository.getString("new-atitesting.pwd.error.input"));
		VerificationHandler.verifyTrue(result3);
		
		log(logger, "enter  email");
		tutorialPage.enterText("new-atitesting.createaccount.email", "new-atitesting.createaccount.email.input",0);
		
		log(logger, "Hit Tab keyboard key");
		tutorialPage.hitTabButton("new-atitesting.createaccount.email");	
		
		boolean result4=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.email.error.message"), PropertiesRepository.getString("new-atitesting.email.error.input"));
		VerificationHandler.verifyTrue(result4);
		
		log(logger, "confirm email");
		tutorialPage.enterText("new-atitesting.createaccount.confirm.email.loc", "new-atitesting.createaccount.confirm.email.input",0);
		
		log(logger, "Hit Tab keyboard key");
		tutorialPage.hitTabButton("new-atitesting.createaccount.confirm.email.loc");		
		
		boolean result5=tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.createaccount.confirm.email.error.msg.loc"), PropertiesRepository.getString("new-atitesting.confirm.email.error.input"));
		VerificationHandler.verifyTrue(result5);
		
		log(logger, "NewATI115_VerifyCreateAccountFunctionality End");
	}
	
	/**
	 * After entering Confirm Email value, continue button is not getting enabled. 
	 * 
	 * @throws Exception
	 */
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
		loginPage.MaintanacePopUp();
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
		/*buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc"));*/
		
		/*log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);*/
		
		log(logger, "NewATI539_CreateAccount End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-1:Verify CreateAccount page.")
	public void NewATI1_CreateAccountPage() throws Exception {
		log(logger, "NewATI1_CreateAccountPage Starts ");

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
		log(logger, "NewATI1_CreateAccountPage End");
	}
}

