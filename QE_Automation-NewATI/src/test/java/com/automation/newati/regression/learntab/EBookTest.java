package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;

public class EBookTest extends BaseTest{
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private LearnTabPage learnTabPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private PractiseAssessmentPage practiceAssessmentPage;
	private WindowHandler windowHandler;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Exception {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		windowHandler = new WindowHandler(driver);
		tutorialPage = new TutorialPage(driver);
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-520:Adding Library Institution Purchase (ebooks) from Add product button")
	public void NewATI520_VerifyEbookAddedUsingAddProductTest() throws Exception {
	
		log(logger, "NewATI520_VerifyEbookAddedUsingAddProductTest Start");
		
		driver.get(PropertiesRepository.getString("newati.login.url"));
		
		log(logger, "Verify loginTab Top links");
		loginPage.verifyLoginTabTopLinks();
		
		
		VerificationHandler.verifyTrue(homePage.verifyHomeTabBottomLinks(),"Unable to verify home top links");
		log(logger, "click on create account link");
		tutorialPage.clickButtonFromList("new-atitesting.create.account.link.loc", 0);
		
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
		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"Add product button is not Enabled");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.MaintanacePopUp();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		createAccountPage.clickOnAddProductButton();

		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.createaccount.addProductTextFieldLoc"), PropertiesRepository
				.getString("new-atitesting.add.product.ebookproductid"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.password.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.ebookproductpassword"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));
		log(logger, "Verifying the added Product in Learn tab");
		learnTabPage.verifyAddedEbook(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		
		log(logger, "NewATI520_VerifyEbookAddedUsingAddProductTest End");
	}

	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-521:Adding Class to user which is having Library package (ebooks)")
	public void NewATI521_verifyEbookAddedUsingCDN() throws Exception {
		log(logger, "NewATI521_verifyEbookAddedUsingCDN Start");
		
		driver.get(PropertiesRepository.getString("newati.login.url"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify loginTab Top links");
		loginPage.verifyLoginTabTopLinks();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(homePage.verifyHomeTabBottomLinks(),"Unable to verify home top links");
		log(logger, "click on create account link");
		tutorialPage.clickButtonFromList("new-atitesting.create.account.link.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
		log(logger, "Create account start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "createAccount method Ends");
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"Add product button is not Enabled");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.MaintanacePopUp();
		homePage.click(PropertiesRepository
				.getString("new-atitesting.createaccount.addProductButtonLoc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"),PropertiesRepository.getString("new-atitesting.add.product.secondary.cdn.id.new"));

		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 4
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.ebook.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying the added Product in Learn tab");
		learnTabPage.verifyAddedEbook(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));
		buttonHandler.clickButton(PropertiesRepository
				.getString("new-atitesting.product.information.popup.close.button.loc.update"));
		log(logger, "NewATI521_verifyEbookAddedUsingCDN End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-502:To verify updat Edition Dropdown to display 2016 as the default for RN Review Modules")
	public void NewATI502_VerifyUpdatedEditionForRNReviewModuleTest() throws Exception {

		log(logger, "NewATI502_VerifyUpdatedEditionForRNReviewModuleTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting ebook from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
		    .getString("new-atitesting.ebookDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Edition of RN Review Module");
		VerificationHandler.verifyTrue(learnTabPage.verifyUpdatedEdition("2016 eBook"), "Unable to verify Edition");
		
		log(logger, "NewATI502_VerifyUpdatedEditionForRNReviewModuleTest End");
	}
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-503:To verify updated RN Review Modules 2016 Package")
	public void NewATI503_verifyUpdatedRNReviewModulesPackageTest() throws Exception {
		
		log(logger, "NewATI503_verifyUpdatedRNReviewModulesPackageTest Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Edition of RN Review Module 2016 Package");
		learnTabPage.verifyUpdatedRNReviewModulesEdition();
		
		log(logger, "NewATI503_verifyUpdatedRNReviewModulesPackageTest End");
	}
	
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-504:To verify Update Offset Page Setting for RN Review Modules")
	public void NewATI504_verifyUpdateOffsetPageSettingRNReviewModulesTest() throws Exception {
	
		log(logger, "NewATI503_verifyUpdatedRNReviewModulesPackageTest Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.module.name"));
		
		log(logger, "Click on PDF BOOK button");
		learnTabPage.clickOnPdfBookButton();
		
		log(logger, "Switching to PDF window");
		windowHandler.switchToLatestWindow();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Offset Page Settings");
		learnTabPage.verifyOffsetPageSettings();
	}
	
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-557:Validate Virtual Classroom Capstone product :Admission:contents area:STU-4373")
	public void NewATI557_VerifyVirtualClassroomCapstoneProduct() throws Exception {	
	
		log(logger, "NewATI557_VerifyVirtualClassroomCapstoneProduct Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.admission"), PropertiesRepository.getString("newati.login.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Admissions from Content Area Dropdown");
		learnTabPage.selectFromContentAreaDropdown("Admissions");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, " Verify Virtual Classroom Capstone product");
		learnTabPage.verifyVirtualClassroomCapstonProduct("Virtual Classroom Capstone");
		
		log(logger, "NewATI557_VerifyVirtualClassroomCapstoneProduct End");
	}
}
