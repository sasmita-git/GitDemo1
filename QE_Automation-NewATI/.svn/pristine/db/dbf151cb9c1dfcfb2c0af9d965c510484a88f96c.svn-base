package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.jaca.TestAnnotations;

public class EBookTest3 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private EBookPage eBookPage;
	private CreateAccountPage createAccountPage;

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Exception {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		eBookPage=new EBookPage(driver);
		createAccountPage=new CreateAccountPage(driver);
		
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.ebook.2.0.user.name"),
				PropertiesRepository.getString("newati.login.ebook.2.0.password"));
		 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 createAccountPage.acceptTermsAndConditionsForNewUser();
		 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

	@TestAnnotations(testID = "NewATI-873")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-873:To verify RN and PN Library module for the single user")
	public void NewATI873_VerifyPNAndRNEBook() throws Exception {
		log(logger, "NewATI873_VerifyPNAndRNEBook Start");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		// Step 1, 2 and 3
		log(logger, "PN Book Lib and its count");
		VerificationHandler.verifyTrue(eBookPage.veifyEBookMoudleCount("PN eBook Library", "9"), "Unable to verify PN Book");
		// Step 1, 2 and 3
		log(logger, "RN Book Lib and its count");
		VerificationHandler.verifyTrue(eBookPage.veifyEBookMoudleCount("RN eBook Library", "10"),"Unable to verify RN Book");
		
		log(logger, "NewATI873_VerifyPNAndRNEBook End");
	}
	
	@TestAnnotations(testID = "NewATI-874")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-874:To verify RN Ebook for existing student .")
	public void NewATI874_VerifyRNEBook() throws Exception {
		log(logger, "NewATI874_VerifyRNEBook Start");
		
		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		// Step 3
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "RN Book Lib and its count");
		VerificationHandler.verifyTrue(eBookPage.veifyEBookMoudleCount("RN eBook Library", "10"),"Unable to verify RN Book");
		// Step 4
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Ebook of RN Book");
		eBookPage.clickEBookMoudleCount("RN eBook Library");
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying EBook Select Option");
		VerificationHandler.verifyTrue(eBookPage.verifyEBookSelectOption(),"Verifying ebook options");
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying EBook count in card back");
		VerificationHandler.verifyTrue(eBookPage.verifyEBookOrPDFCount(".ebook-row a[class='button primary-button focus-element-flag']", 10), "Unable to verify EBook modules in Card back");
		// Step 6
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select 2016 PDF");
		eBookPage.selectEBookOption("2016 PDF");
		// Step 6
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying PDF count in card bakc");
		VerificationHandler.verifyTrue(eBookPage.verifyEBookOrPDFCount(".ebook-row .button.secondary-button.focus-element-flag", 9), "Unable to verify EBook modules in Card back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI874_VerifyRNEBook End");
	}
	
	@TestAnnotations(testID = "NewATI-875")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-875:To verify PN Ebook for existing student .")
	public void NewATI875_VerifyRNEBookReviewModule() throws Exception {
		log(logger, "NewATI875_VerifyRNEBookReviewModule Start");
		
		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		// Step 2
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		// Step 3
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "RN Book Lib and its count");
		VerificationHandler.verifyTrue(eBookPage.veifyEBookMoudleCount("PN eBook Library", "9"),"Unable to verify RN Book");
		// Step 4
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Ebook of RN Book");
		eBookPage.clickEBookMoudleCount("PN eBook Library");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Getting eBook Name from Card Back");
		String eBookName = eBookPage.getTextFromLst(".ebook-row .library-section-name", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifing EBook tile");
		eBookPage.clickEBook(".ebook-row a[class='button primary-button focus-element-flag']", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying eBook name");
		String eBookNameHeader = eBookPage.getTextFromLst(".lesson-header-details.smartprep-details ul li span", 2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI875_VerifyRNEBookReviewModule End");
	}

}