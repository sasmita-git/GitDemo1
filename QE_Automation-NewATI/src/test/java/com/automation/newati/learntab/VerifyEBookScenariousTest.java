package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.jaca.TestAnnotations;


public class VerifyEBookScenariousTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private EBookPage eBookPage;
	private HomePage homePage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private BaseHandler baseHadler;
	@BeforeMethod
	public void verifyHomePage() throws Exception {

		loginPage = new LoginPage(driver);
		homePage= new HomePage(driver);
		eBookPage = new EBookPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		baseHadler = new BaseHandler(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		
	}

	@TestAnnotations(testID="NewATI-36")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Validate user is able to access eBooks::Learn Tab")
	public void NewATI36_VerifyEBookTest() throws DriverException, Exception {
		log(logger, "NewATI36_VerifyEBookTest Start");
		
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Select EBook in Learn Tab - Type.
		eBookPage.myATILearnTabPageSelectEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebookstype.select.loc"),
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.type.selectebooks.value"));
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		// Open eBook
		/*eBookPage.myATILearnTabPageOpenEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebooksmodule.link"));*/
		practiceAssessmentPage
		.clickModuleButtonByNameEbook(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		
		//select 2016 PDF from dropdown
		Select dropdown = new Select(
				baseHadler.findElement("#productEbookList div[class='select select-secondary'] select"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		dropdown.selectByVisibleText("2016 PDF");
		
		eBookPage.clickEBookButton();
		VerificationHandler
		.verifyTrue(eBookPage.verifyPdfContinueButtonIsDisplayed(), "Unable to verify button in PDF");
		
		eBookPage.clickOnPdfClosButton();
		log(logger, "NewATI36_VerifyEBookTest End");
	}
	

	@Test(priority = 2, alwaysRun = true, enabled = true, description = "NewATI-528:Verify duplicate modules for e-books.")
	public void NewATI528_VerifyEBookDuplicateModuleName() throws DriverException, Exception {
		log(logger, "NewATI528_VerifyEBookDuplicateModuleName Start");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Select EBook in Learn Tab - Type.
		eBookPage.myATILearnTabPageSelectEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebookstype.select.loc"),
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.type.selectebooks.value"));

		// Open eBook
		eBookPage.myATILearnTabPageOpenEbook(
				PropertiesRepository.getString("new-atitesting.homepage.myatitab.ebooksmodule.link"));
		
		VerificationHandler
		.verifyFalse(eBookPage.verifyDuplicateModuleName(), "Duplicate value in Ebook Module name");
		
		log(logger, "NewATI528_VerifyEBookDuplicateModuleName End");
	}
}


