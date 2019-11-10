package com.automation.newati.semester.payment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;

public class LateSemesterPaymentTest  extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver);
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-314:Verify Late Semester Payment using American Express card with same billing address")
	public void NewATI314_VerifyLateSemesterPaymentWithAmericanExpCard() throws Exception {
		log(logger,"NewATI314_VerifyLateSemesterPaymentWithAmericanExpCard Start");
		
		loginPage.loginToApplication("TestUser_07042017_6", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0124108","1181");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		
		log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Enter pha, email nd click continue btn.
		log(logger, "Enter the card details");
		paymentsPage.enterAmericanCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		// Verify Order Summary page and click close btn.
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		
		log(logger,"NewATI314_VerifyLateSemesterPaymentWithAmericanExpCard End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-318:Verify Late Semester Payment using Master card with same billing address")
	public void NewATI318_VerifyLateSemesterPaymentWithMasterCard() throws Exception {
		log(logger,"NewATI318_VerifyLateSemesterPaymentWithMasterCard Start");
		
		loginPage.loginToApplication("TestUser_07042017_5", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0124108","1181");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		
		log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Enter pha, email nd click continue btn.
		log(logger, "Enter the card details");
		paymentsPage.enterMasterCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI318_VerifyLateSemesterPaymentWithMasterCard End");
	}

	//@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-320:Verify Late Semester Payment using Visa card with same billing address")
	public void NewATI320_VerifyLateSemesterPaymentWithVisaCard() throws Exception {
		log(logger,"NewATI320_VerifyLateSemesterPaymentWithVisaCard Start");
		
		loginPage.loginToApplication("TestUser_07042017_3", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0124108","1181");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		
		log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Enter pha, email nd click continue btn.
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI320_VerifyLateSemesterPaymentWithVisaCard End");
	}

	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-325:Verify Late Semester Payment using Discover card with same billing address")
	public void NewATI325_VerifyLateSemesterPaymentWithDiscoverCard() throws Exception {
		log(logger,"NewATI325_VerifyLateSemesterPaymentWithDiscoverCard Start");
		
		loginPage.loginToApplication("TestUser_07042017_4", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0124108","1181");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		
		log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Enter pha, email nd click continue btn.
		log(logger, "Enter the card details");
		paymentsPage.enterDiscoverCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI325_VerifyLateSemesterPaymentWithDiscoverCard End");
	}


}
