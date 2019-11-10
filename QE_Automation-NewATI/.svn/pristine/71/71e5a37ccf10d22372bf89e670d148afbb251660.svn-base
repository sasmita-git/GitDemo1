package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest2Prod extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	private LoginPage loginPage;
	private TutorialPage tutorialPage;
	private HomePage homePage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private TestTabPage testTabPage;
	public BaseHandler baseHandler;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage=new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver);
		testTabPage=new TestTabPage(driver);
		baseHandler = new BaseHandler(driver);
	}

	
	@TestAnnotations(testID="NewATI-846")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-846:Verify all functionality with existing pulse user.")
	public void NewATI846_Verifyallfunctionalitywithexistingpulseuser() throws Exception {
		log(logger, "NewATI846_Verifyallfunctionalitywithexistingpulseuser Starts ");
		loginPage.enterURL("newati.login.url");
		//
		log(logger, "login to application with existing user ");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"), PropertiesRepository.getString("newati.login.password"));
		homePage.scrollDownPage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify calender");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.homepage.full.page.calendar.area"),"calender is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.scrollUpPage();
		log(logger, "verify pulse Speedometer  ");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),"spedometer is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify usage banner and verify viewdetails page ");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(),"Pulse banner is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.homepage.full.page.viewdetails.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyViewDetailsPage(),"view details page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickOnCloseButtonInViewDetailspage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Flash Card from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.flashCardDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer not displayed in Flashcards");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByProductName("Flashcards"),"For Flashcard spedometer is not displayed not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting ebook from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.ebookDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer  not displayed in ebook");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByProductName("eBook"),"For eBook spedometer is not displayed not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer not displayed in SmartPrep");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByDescName("SmartPrep"),"For SmartPrep spedometer is not displayed not displayed");
//		log(logger, "Selecting Quiz Bank from Learn Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
//				.getString("new-atitesting.allDropdown.quizbans.value"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify spedometer displayed for Quiz Bank");
//		VerificationHandler.verifyTrue(tutorialPage.VerifySpedometerByProductName("Quiz Bank"),"For Quiz Bank spedometer is displayed");
		log(logger, "Selecting tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer displayed for Dosage Calculation");
		VerificationHandler.verifyTrue(tutorialPage.VerifySpedometerByDescName("Dosage Calculation 2.0: Dimensional Analysis"),"For Dosage Calculation 2.0 spedometer is displayed");
		log(logger, "Verify spedometer displayed for Skills Modules 2.0");
		VerificationHandler.verifyTrue(tutorialPage.VerifySpedometerByDescName("Skills Modules 2.0"),"For Skills Modules 2.0 spedometer is displayed");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Proctored");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer  displayed for Proctored Assessment");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinProctorTestTab("Proctored Assessment"),"For Proctored Assessment spedometer is displayed");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer displayed for Practice Assessment on card font");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinPracticeTestTab("Practice Assessment"),"For practice spedometer is not displayed");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer not displayed for video case study product..");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinApplyTab("Video Case Study"),"For Video Case Study spedometer is displayed");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);		

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer not displayed on card front and on card back.");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinNCLEXPREPTab("Board Vitals")," For Board Vitals Spedometer is  displayed");
		log(logger, "NewATI846_Verifyallfunctionalitywithexistingpulseuser End");
	}

}
