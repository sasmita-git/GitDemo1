package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class EBook_2_Test extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private LearnTabPage learnTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private BaseHandler baseHadler;
	private WindowHandler windowHandler;
	private TutorialPage tutorialPage;
	private EBookPage ebookPage;
	private TextHandler textHandler;
	private CreateAccountPageNewSmoke createAccountPage;
	private CreateAccountPage createAccPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Exception {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		baseHadler = new BaseHandler(driver);
		tutorialPage = new TutorialPage(driver);
		ebookPage=new EBookPage(driver);
		windowHandler = new WindowHandler(driver);
		textHandler = new TextHandler(driver);
		createAccPage=new CreateAccountPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			logger.info("User ID for Payment --> " + userId);
			count++;
		}
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-799:Verify Ebook title for RN module")
	public void NewATI799_VerifyEbookTitleForRN() throws Exception {

		log(logger, "NewATI799_VerifyEbookTitleForRN Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");

		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if RN eBook Library title is displayed on Card Front");
		VerificationHandler.verifyTrue(learnTabPage
				.verifyEbookCardFront(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByNameEbook(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if RN eBook Library title is displayed on Card Back");
		practiceAssessmentPage.waitUntillElementIsVisible("#productEbookList>h1");
		VerificationHandler.verifyTrue(baseHadler.findElement("#productEbookList>h1").getText()
				.contains(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Close Card back");
		learnTabPage.clickButton(".closeButton.focus-element-flag.focus-on");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if RN eBook Library title is Under Name field in the Product Information Popuo");
		VerificationHandler.verifyTrue(baseHadler.findElement(".product-info-cell>div[data-bind='text: ListItem.Name']")
				.getText().equals(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));

		log(logger, "NewATI799_VerifyEbookTitleForRN End");
	}

	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-800:Verify Ebook title for PN module")
	public void NewATI800_VerifyEbookTitleForPN() throws Exception {

		log(logger, "NewATI800_VerifyEbookTitleForPN Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if PN eBook Library title is displayed on Card Front");
		VerificationHandler.verifyTrue(learnTabPage
				.verifyEbookCardFront(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if PN eBook Library title is displayed on Card Back");
		practiceAssessmentPage.waitUntillElementIsVisible("#productEbookList>h1");
		VerificationHandler.verifyTrue(baseHadler.findElement("#productEbookList>h1").getText()
				.contains(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Close Card back");
		learnTabPage.clickButton(".closeButton.focus-element-flag.focus-on");

		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));

		log(logger, "Verify if PN eBook Library title is Under Name field in the Product Information Popuo");
		VerificationHandler.verifyTrue(baseHadler.findElement(".product-info-cell>div[data-bind='text: ListItem.Name']")
				.getText().equals(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name")));

		log(logger, "NewATI800_VerifyEbookTitleForPN End");
	}

	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-790:Verify Nurse's Drug Handbook is added to new eBooks")
	public void NewATI790_VerifyNurseDrugHandbook() throws Exception {

		log(logger, "NewATI790_VerifyNurseDrugHandbook Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByNameEbook(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if RN eBook Library title is displayed on Card Back");
		practiceAssessmentPage.waitUntillElementIsVisible("#productEbookList>h1");
		VerificationHandler.verifyTrue(baseHadler.findElement("#productEbookList>h1").getText()
				.contains(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Nurse's Drug Handbook is added to user account.");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfCardBackMaodulePresent(
				PropertiesRepository.getString("new-atitesting.learntab.cardback.module.name")));

		log(logger, "NewATI790_VerifyNurseDrugHandbook End");
	}
	@Test(priority = 4, alwaysRun = true, enabled = true, description = "NewATI-530:To verify the Add Product for Library institution purchases")
	public void NewATI530_VerifyEBookAddedByLibraryAndCDN() throws DriverException, Exception {
		log(logger, "NewATI530_VerifyEBookAddedByLibraryAndCDN Start");
		
		driver.get(PropertiesRepository.getString("newati.login.url"));
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product button");
		createAccountPage.clickOnAddProductButton();
		
		log(logger, "Enter Library ");
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.createaccount.addProductTextFieldLoc"), PropertiesRepository
				.getString("new-atitesting.add.product.ebookproductid"));
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		
		log(logger, "Enter password");
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
		
		log(logger, "Select Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.ebook.module.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "open ebook");
		ebookPage.clickEBookButton();
		VerificationHandler.verifyTrue(ebookPage.verifyPdfContinueButtonIsDisplayed(), "Unable to verify button in PDF");
		
		log(logger, "close pdf window");
		ebookPage.clickOnPdfClosButton();
		windowHandler.switchToLatestWindow();
		
		learnTabPage.clickButton(".closeButton.focus-element-flag.focus-on");
		
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Add CDN");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.createaccount.addProductButtonLoc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"),PropertiesRepository.getString("new-atitesting.ebook.cdn"));

		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(5000);
		
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.ebookDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Launch and verify module");
		
		learnTabPage.clickButton(".ebook-row section div a[class='button primary-button focus-element-flag']", 0);
		learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		windowHandler.switchToFrame("OpenPageFrame");

		// Close if help popup is displayed
		if (baseHadler.findElement("#helpCloseBtn").isDisplayed()) {
			baseHadler.findElement("#helpCloseBtn").click();
		}

		log(logger," ebook module is launch as open page");
		VerificationHandler.verifyTrue(
				baseHadler.findElement(".toc-title.text-ellip").getText().equals("RN Adult Medical Surgical Nursing: Review Module Edition 10.0"));
		log(logger, "NewATI530_VerifyEBookAddedByLibraryAndCDN");
	}
	
	@TestAnnotations(testID="NewATI-859")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-859:To verify eBooks Card Filter to be dynamic based on number of editions available")
	public void NewATI859_VerifyeBooksCardFilter() throws Exception {

	log(logger, "NewATI859_VerifyeBooksCardFilter Start");

	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
	PropertiesRepository.getString("newati.login.pulse.user.password"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on My ATI Tab");
	homePage.clickTab(1);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	log(logger, "Clicking on Learn Tab");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.ebookDropdown.value"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Select Module name RN eBook Library");
	practiceAssessmentPage
	.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Verify edition filter options for RN");
	VerificationHandler.verifyTrue(learnTabPage.verifyebookEditionDropdown());
	
	log(logger, "Verify selection edition message for RN");
	VerificationHandler.verifyTrue(learnTabPage.selectFromEbookeditionDD(PropertiesRepository.getString("new-atitesting.ebook.edition.value")));
	
	log(logger, "close RN ebook library card back");
	learnTabPage.clickButton(".closeButton.focus-element-flag.focus-on");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Select Module name PN eBook Library");
	practiceAssessmentPage
	.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.name"));
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Verify edition dropdown");
	VerificationHandler.verifyFalse(learnTabPage.IsDisplayed(PropertiesRepository.getString("newati.ebook.edition.dropdown")));
	
	log(logger, "Verify selection edition message for PN");
	VerificationHandler.verifyFalse(learnTabPage.IsDisplayed(PropertiesRepository.getString("newati.ebook.filter.selection.msg")));
	
	log(logger, "NewATI859_VerifyeBooksCardFilter End");
}

}