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

public class LateSemesterPaymentTestWithDiffAddress  extends BaseTest {
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
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-316:Verify Late Semester Payment using American Express card with editted billing address")
	public void NewATI316_VerifyLateSemesterPaymentWithAmericanExpCard() throws Exception {
		log(logger,"NewATI316_VerifyLateSemesterPaymentWithAmericanExpCardEditAddress Start");
		
		loginPage.loginToApplication("TestUser_30052017_1", "Test123");
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
		
		/*log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);*/
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Changing Shipping address");
		// Clicking on Shipping Address.
		tutorialPage.clickButton("#OrderPaymentDialog .question-option label");
		// Entering shipping address. 
		paymentsPage.enterShippingAddress();
		
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
		tutorialPage.clickButton(".step-modal-nav input"); windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI316_VerifyLateSemesterPaymentWithAmericanExpCardEditAddress End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-319:Verify Late Semester Payment using Master card with editted billing address")
	public void NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress() throws Exception {
		log(logger,"NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress Start");
		
		loginPage.loginToApplication("TestUser_07042017_8", "Test123");
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
		
		/*log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);*/
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Changing Shipping address");
		// Clicking on Shipping Address.
		tutorialPage.clickButton("#OrderPaymentDialog .question-option label");
		// Entering shipping address. 
		paymentsPage.enterShippingAddress();
		
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
		tutorialPage.clickButton(".step-modal-nav input"); windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress End");
	}

	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-323:Verify Late Semester Payment using Visa card with editted billing address")
	public void NewATI323_VerifyLateSemesterPaymentWithVisaCardEditAddress() throws Exception {
		log(logger,"NewATI323_VerifyLateSemesterPaymentWithVisaCardEditAddress Start");
		
		loginPage.loginToApplication("TestUser_07042017_9", "Test123");
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
		
		/*log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);*/
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Changing Shipping address");
		// Clicking on Shipping Address.
		tutorialPage.clickButton("#OrderPaymentDialog .question-option label");
		// Entering shipping address. 
		paymentsPage.enterShippingAddress();
		
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
		tutorialPage.clickButton(".step-modal-nav input"); windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI323_VerifyLateSemesterPaymentWithVisaCardEditAddress End");
	}

	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-330:Verify Late Semester Payment using Discover card with editted billing address")
	public void NewATI330_VerifyLateSemesterPaymentWithDiscoverCardEditAddress() throws Exception {
		log(logger,"NewATI330_VerifyLateSemesterPaymentWithDiscoverCardEditAddress Start");
		
		loginPage.loginToApplication("TestUser_07042017_10", "Test123");
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
		
		/*log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);*/
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Changing Shipping address");
		// Clicking on Shipping Address.
		tutorialPage.clickButton("#OrderPaymentDialog .question-option label");
		// Entering shipping address. 
		paymentsPage.enterShippingAddress();
		
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
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI330_VerifyLateSemesterPaymentWithDiscoverCardEditAddress End");
	}


}
