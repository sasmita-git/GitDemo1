package com.automation.newati.smoke;

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
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest1 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	private LoginPage loginPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private HomePage homePage;
	public BaseHandler baseHandler;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		baseHandler = new BaseHandler(driver);
	}

	/**
	 * After entering Confirm Email value, continue button is not getting enabled. 
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-845")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI845_VerifyAllFunctionalityWithNewPulseUser")
	public void NewATI845_VerifyAllFunctionalityWithNewPulseUser() throws Exception {
		log(logger, "NewATI845_VerifyAllFunctionalityWithNewPulseUser Starts ");
		
		driver.get(PropertiesRepository.getString("newati.login.url"));

		log(logger, "Verify if common login page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("ATI Testing | Nursing Education | NCLEX Exam Review | TEAS Testing"));
			
		tutorialPage.waitUntillElementIsVisible(PropertiesRepository.getString("ati.login.page.model"));
			
		logger.info("Select Site");
		tutorialPage.clickButton(PropertiesRepository.getString("ati.login.page.model.three.options"), 1);
		
		log(logger, "click on create account link");
		tutorialPage.clickButton(PropertiesRepository.getString("ati.student.create.acc.btn.loc"), 1);
		
		log(logger, "Verify if Create Account page is displayed"); 
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Create Account - ATI Testing"));
		
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		log(logger, "Create account start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		
		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"User name field is not Enabled");
		
		loginPage.loginToApplication(userName, PropertiesRepository.getString("new-atitesting.passwordInput"));
				
		log(logger, "verify Recent activity section");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.hometab.recent.activity.section"),"Recent activity section is not displayed");
		log(logger, "verify Add product section");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.createaccount.addProductButtonLoc"),"Add Product is not displayed");
		log(logger, "verify Advertisemnet section");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.advertisement.name.new"),"Advertisemnet is not displayed");
		log(logger, "verify News section");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.homepage.news.section.loc"),"News is not displayed");
		log(logger, "verify Home tab sections");	
		VerificationHandler.verifyTrue(homePage.verifyHomeTabLinks(),"Home tab is not displayed");
		
		
		log(logger, "Enter Id in  Add product ");
		createAccountPage.clickOnAddProductButton();
		createAccountPage.enterIdToAddProduct();
		createAccountPage.clickOnButton("new-atitesting.createaccount.addProductContinueBtnLoc");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Info Icon for Specific Module and Verify the product");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name.new"));
		VerificationHandler.verifyTrue(learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id.new")),"add product not able to verify");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on close button");
		learnTabPage.clikButtonUsingJavaScript(
				PropertiesRepository.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Add product button and Enter CDN");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		createAccountPage.clickOnAddProductButtoninLearnTab();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.enterCDNToAddProduct();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.clickOnButton("new-atitesting.createaccount.addProductContinueBtnLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name.new"));
		log(logger, "Verifying the added Product in Learn tab");
//		VerificationHandler.verifyTrue(learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id.cdn")),"add product not able to verify");
//		VerificationHandler.verifyFalse(learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.id.cdn")),"add product not able to verify");
		learnTabPage.clikButtonUsingJavaScript(
				PropertiesRepository.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		homePage.scrollUpPage();
		log(logger, "Verify productr is displayed ");
		VerificationHandler.verifyTrue(tutorialPage.verifyProductSize("new-atitesting.learntab.all.modules.loc"),"products not able to verify");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Product is displayed ");
		VerificationHandler.verifyTrue(tutorialPage.verifyProductSize("new-atitesting.all.modules.practice.loc"),"products not able to verify");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify productr is displayed ");
		VerificationHandler.verifyTrue(tutorialPage.verifyProductSize("new-atitesting.allytab.allproducts.loc"),"products not able to verify");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		log(logger, "Verify NCLEX Product is displayed ");
		VerificationHandler.verifyTrue(tutorialPage.verifyProductSize("new-atitesting.nclex.allproducts.loc"),"products not able to verify");
		log(logger, "Clicking Hometab Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Add product for calender");
		createAccountPage.clickOnAddProductButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.enterCorseIdToAddProduct();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.clickOnButton("new-atitesting.createaccount.addProductContinueBtnLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		driver.navigate().refresh();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify calender");
		VerificationHandler.verifyFalse(loginPage.isElementDisplayed("new-atitesting.homepage.full.page.calendar.link"),"Calender is not displayed");
		log(logger, "NewATI845_VerifyAllFunctionalityWithNewPulseUser End");
	}
}
