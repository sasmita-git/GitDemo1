package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class EBook_3_Test extends BaseTest {
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
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		
		
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-761(A):Verify Updated OpenPage eBooks RN review modules name")
	public void NewATI761_VerifyOpenPageEbookRNReviewModules() throws Exception {

		log(logger, "NewATI761A_VerifyOpenPageEbookRNReviewModules Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if RN eBook Library title is displayed on Card Back");
		practiceAssessmentPage.waitUntillElementIsVisible("#productEbookList>h1");
		VerificationHandler.verifyTrue(baseHadler.findElement("#productEbookList>h1").getText()
				.contains(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Adult Medical Surgical Nursing RN Review Module");
		learnTabPage.clickButton(".ebook-row section div a[class='button primary-button focus-element-flag']", 1);
		learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		windowHandler.switchToFrame("OpenPageFrame");

		// Close if help popup is displayed
		if (baseHadler.findElement("#helpCloseBtn").isDisplayed()) {
			baseHadler.findElement("#helpCloseBtn").click();
		}

		log(logger, "NewATI761A_VerifyOpenPageEbookRNReviewModules End");
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
	"Regression" }, description = "NewATI-994:Verify Media Resources for RN Review Modules")
	public void NewATI994_VerifyMediaResourcesForRNReviewModules() throws Exception {
	
		log(logger, "NewATI994_VerifyMediaResourcesForRNReviewModules Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
		log(logger, "Select 2016 eBook from Dropdown");
		Select dropdown = new Select(
				baseHadler.findElement("#productEbookList div[class='select select-secondary'] select"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		dropdown.selectByVisibleText("2016 PDF");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify If List of ebook modules with 'PDF Book' and 'Media Resources' button should display.");
		VerificationHandler.verifyTrue(tutorialPage.verifyEbooListAndPDFAndMediaResourceBtnDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Media Resources");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.first.PDFBook.mediaresource"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(baseHadler.findElement("ul li span[data-bind='text: EbookTitle']").getText()
				.contains("RN eBook Library 2016"));


		log(logger, "NewATI994_VerifyMediaResourcesForRNReviewModules End");
		}
		
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
	"Regression" }, description = "NewATI-996:Verify Updated OpenPage RN Review Modules 2016 for eBook")
	public void NewATI996_VerifyUpdatedRNReviewModuleForEbook() throws Exception {
	
			log(logger, "NewATI996_VerifyUpdatedRNReviewModuleForEbook Start");
			
			loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
					PropertiesRepository.getString("newati.login.pulse.user.password"));
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			log(logger, "Click on Adult Medical Surgical Nursing RN Review Module");
			learnTabPage.clickButton(".ebook-row section div a[class='button primary-button focus-element-flag']", 1);
			learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			learnTabPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			windowHandler.switchToFrame("OpenPageFrame");
			
			// Close if help popup is displayed
			if (baseHadler.findElement("#helpCloseBtn").isDisplayed()) {
				baseHadler.findElement("#helpCloseBtn").click();
			}
			
			log(logger, "NewATI996_VerifyUpdatedRNReviewModuleForEbook End");
			}
		
	}