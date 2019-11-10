package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class PulseUserSmokeTest2 extends BaseTest {
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
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-846:Verify all functionality with existing pulse user.")
	public void NewATI846_Verifyallfunctionalitywithexistingpulseuser() throws Exception {
		log(logger, "NewATI846_Verifyallfunctionalitywithexistingpulseuser Starts ");

		//loginPage.enterURL("newati.login.url");
		//
				
		log(logger, "login to application with existing user ");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"), PropertiesRepository.getString("newati.login.password"));
		homePage.scrollDownPage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String parentWindowHandle = driver.getWindowHandle();
		log(logger, "verify calender");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.homepage.full.page.calendar.area"),"calender is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.scrollUpPage();
		log(logger, "verify pulse Speedometer  ");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),"spedometer is not displayed");
		
	/*	log(logger, "verify usage banner and verify viewdetails page ");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(),"Pulse banner is not displayed");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.homepage.full.page.viewdetails.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(homePage.verifyViewDetailsPage(),"view details page is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickOnCloseButtonInViewDetailspage();
	*/	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Flash Card from Learn Tab");
		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
						.getString("new-atitesting.flashCardDropdown.value"));
		
		log(logger, "Verify spedometer not displayed in Flashcards");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByProductName("Flashcards"),"For Flashcard spedometer is not displayed not displayed");
		
		log(logger, "Selecting ebook from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.ebookDropdown.value"));
		log(logger, "Verify spedometer  not displayed in ebook");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByProductName("eBook"),"For eBook spedometer is not displayed not displayed");
		log(logger, "Selecting tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Verify spedometer not displayed in SmartPrep");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerByDescName("SmartPrep"),"For SmartPrep spedometer is not displayed not displayed");
//		log(logger, "Selecting Quiz Bank from Learn Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
//				.getString("new-atitesting.allDropdown.quizbans.value"));
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
		  String mainWindowHandler = paymentsPage.getWindowHandler();
		 
		  log(logger, "Purchage product from online store");		  
		  paymentsPage.verifyOnlineStoreLink();
		  String curUrl= driver.getCurrentUrl();
		  paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		  
		  JavascriptExecutor jse = (JavascriptExecutor)driver;
		  jse.executeScript("window.scrollBy(0,250)", "");
		   tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		  paymentsPage.selectProgramType();
		  //myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  //tutorialPage.waitForAwhile(30000);
		  jse.executeScript("window.scrollBy(0,250)", "");
		  jse.executeScript("window.scrollBy(0,250)", "");
		  jse.executeScript("window.scrollBy(0,250)", "");
		  paymentsPage.switchToOnlinePaymentBrainTree();
		  paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		  paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		  paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		  windowHandler.switchToMainWindow();
		  windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		  if(curUrl.startsWith("https://stage"))
		  {
		  paymentsPage.verifyPaymentSuccessMessage();
		  paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		     homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
			 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				tutorialPage.selectTutorialFromDropDown(PropertiesRepository
						.getString("new-atitesting.all.value"));
		    log(logger, "Verify spedometer displayed for Pharmacology Made Easy 3.0");
		    VerificationHandler.verifyTrue(tutorialPage.VerifySpedometerByDescName("Pharmacology Made Easy 3.0"), "For Pharmacology Made Easy 3.0 Spedometer is  displayed");
		     testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("new-atitesting.cdn.selfpay.Tutorial.tab.product.name.tutorial.pme"));
////		     log(logger, "Verifying the added Product in Learn tab");
////		     learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.selfpay.asessment.test.tab.product.id"));
		log(logger, "NewATI846_Verifyallfunctionalitywithexistingpulseuser End");
		  }else {
			  log(logger, "NewATI846_Verifyallfunctionalitywithexistingpulseuser End");
		  }
		  
	}	
	

}
