package com.automation.newati.regression.logintab;

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
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;

public class VerifyLoginPageRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	private String userName = null;
	private StringBuilder sbEmail = null;
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, description = "NewATI-689:Verify the New Country 'Philippines' in new account creation page")
	public void  NewATI689_VerifyNewCountryInAccountCreation() throws Exception {
		log(logger, "NewATI689_VerifyNewCountryInAccountCreation Starts ");

		loginPage.enterURL("newati.login.url");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		userName = CommonUtils.getRandomUserName();
		sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3OtherCountryFull(PropertiesRepository.getString("new-atitesting.philippines.countryInpt"), 
				PropertiesRepository.getString("new-atitesting.philippines.stateInpt"), PropertiesRepository
				.getString("new-atitesting.blank.loc"), PropertiesRepository.getString("new-atitesting.philippines.phoneInpt")),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Previous Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.createaccount.previous.button.loc"), true);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3OtherCountryPartial(PropertiesRepository.getString("new-atitesting.philippines.countryInpt"), 
				PropertiesRepository.getString("new-atitesting.philippines.stateInpt"), PropertiesRepository
				.getString("new-atitesting.philippines.zipCodeInput1"), PropertiesRepository.getString("new-atitesting.philippines.phoneInpt")),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Previous Button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.createaccount.previous.button.loc"), true);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3OtherCountryPartial(PropertiesRepository.getString("new-atitesting.philippines.countryInpt"), 
				PropertiesRepository.getString("new-atitesting.philippines.stateInpt"), PropertiesRepository
				.getString("new-atitesting.philippines.zipCodeInput2"), PropertiesRepository.getString("new-atitesting.philippines.phoneInpt")),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"Add product button is not Enabled");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI689_VerifyNewCountryInAccountCreation End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, description = "NewATI-690:Verify the New Country 'Philippines' in edit page")
	public void  NewATI690_VerifyUserProfileEditPage() throws Exception {
		log(logger,"NewATI690_VerifyUserProfileEditPage Start");
		
		log(logger, "Login page of Student Portal");
		loginPage.loginToApplication("User04181813", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on User Profile Link.");
		homePage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Address and Phone no Edit link");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.edit.link", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering blank zip code");
		homePage.enterTextValue(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.loc"), true, PropertiesRepository.getString("new-atitesting.blank.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.save.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Zip code");
		VerificationHandler.verifyTrue(homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.value.loc"), PropertiesRepository.getString("new-atitesting.blank.loc")), "Unable to verify blank zip code");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Address and Phone no Edit link");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.edit.link", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Numeric Zip Code");
		homePage.enterTextValue(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.loc"), true, PropertiesRepository.getString("new-atitesting.philippines.zipCodeInput1"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.save.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Zip code");
		VerificationHandler.verifyTrue(homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.value.loc"), PropertiesRepository.getString("new-atitesting.philippines.zipCodeInput1"))," Unable to verify numeric zip code");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Address and Phone no Edit link");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.edit.link", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Alphanumeric Zip Code");
		homePage.enterTextValue(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.loc"), true, PropertiesRepository.getString("new-atitesting.philippines.zipCodeInput2"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.address.and.ph.no.save.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Zip code");
		VerificationHandler.verifyTrue(homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.address.and.ph.no.edit.section.zipcode.value.loc"), PropertiesRepository.getString("new-atitesting.philippines.zipCodeInput2"))," Unable to verify alpha numeric zip code");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"NewATI690_VerifyUserProfileEditPage End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, description = "NewATI-752:Verify the Mandatory symbol for zip code")
	public void  NewATI752_VerifyMandatorySymbolForZipCode() throws Exception {
		log(logger, "NewATI752_VerifyMandatorySymbolForZipCode Starts ");

		loginPage.enterURL("newati.login.url");
		
		userName = CommonUtils.getRandomUserName();
		sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "Verifying Mandatory Zip Code");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep3MandatoryZipCode(), "Unable to verify Mandatory Zip Code");
		
		log(logger, "NewATI752_VerifyMandatorySymbolForZipCode End ");
		
	}
}
