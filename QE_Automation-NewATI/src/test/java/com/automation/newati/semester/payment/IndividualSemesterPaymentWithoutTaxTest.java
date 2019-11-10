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

public class IndividualSemesterPaymentWithoutTaxTest  extends BaseTest {
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
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-317:Verify Individual Semester Payment using American Express card without shipping tax")
	public void NewATI317_VerifyIndividualSemesterPaymentWithAmericanExpCard() throws Exception {
		log(logger,"NewATI317_VerifyIndividualSemesterPaymentWithAmericanExpCard Start");
		
		loginPage.loginToApplication("TestUser_30052017_29", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0125543","0303106");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Verifying Shipping Address ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.billing.address.new.checkbox.loc")), "Unable to verify Shipping Address");
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		//myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Verify Price Details.
		log(logger, "Verifying Semester Payment");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.semester.payment.1220.loc")), "Unable to verify semester payment");
		
		log(logger, "Verifying Late Payment fee");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.late.payment.fee.loc")), "Unable to verify Late payment fee");
		
		log(logger, "Verifying Tax Amount ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.tax.amount.loc")), "Unable to verify Tax Amount");
		VerificationHandler.verifyTrue(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Late Payment Fee is not greater than zero");
		
		log(logger, "Verifying Discount");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.discount.loc")), "Verifying Discount");
		
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
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		log(logger,"NewATI317_VerifyIndividualSemesterPaymentWithAmericanExpCard End");
	}
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-327:Verify Individual Semester Payment using Master card without shipping tax")
	public void NewATI327_VerifyIndividualSemesterPaymentWithMasterCard() throws Exception {
		log(logger,"NewATI327_VerifyIndividualSemesterPaymentWithMasterCard Start");
		
		loginPage.loginToApplication("TestUser_30052017_26", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0125543","0303106");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Verifying Shipping Address ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.billing.address.new.checkbox.loc")), "Unable to verify Shipping Address");
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		//myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Verify Price Details.
		log(logger, "Verifying Semester Payment");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.semester.payment.1220.loc")), "Unable to verify semester payment");
		
		log(logger, "Verifying Late Payment fee");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.late.payment.fee.loc")), "Unable to verify Late payment fee");
		
		log(logger, "Verifying Tax Amount ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.tax.amount.loc")), "Unable to verify Tax Amount");
		VerificationHandler.verifyTrue(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Late Payment Fee is not greater than zero");
		
		log(logger, "Verifying Discount");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.discount.loc")), "Verifying Discount");
		
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
		// Verify Order Summary page and click close btn.
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		log(logger,"NewATI327_VerifyIndividualSemesterPaymentWithMasterCard End");
	}
	}

	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-322:Verify Individual Semester Payment using Visa card without shipping tax")
	public void NewATI322_VerifyIndividualSemesterPaymentWithVisaCard() throws Exception {
		log(logger,"NewATI322_VerifyIndividualSemesterPaymentWithVisaCard Start");
		
		loginPage.loginToApplication("TestUser_30052017_27", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0125543","0303106");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Verifying Shipping Address ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.billing.address.new.checkbox.loc")), "Unable to verify Shipping Address");
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		//myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Verify Price Details.
		log(logger, "Verifying Semester Payment");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.semester.payment.1220.loc")), "Unable to verify semester payment");
		
		log(logger, "Verifying Late Payment fee");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.late.payment.fee.loc")), "Unable to verify Late payment fee");
		
		log(logger, "Verifying Tax Amount ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.tax.amount.loc")), "Unable to verify Tax Amount");
		VerificationHandler.verifyTrue(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Late Payment Fee is not greater than zero");
		
		log(logger, "Verifying Discount");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.discount.loc")), "Verifying Discount");
		
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
		// Verify Order Summary page and click close btn.
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		log(logger,"NewATI322_VerifyIndividualSemesterPaymentWithVisaCard End");
	}
		
	}

	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-329:Verify Individual Semester Payment using Discover card without shipping tax")
	public void NewATI329_VerifyIndividualSemesterPaymentWithDiscoverCard() throws Exception {
		log(logger,"NewATI329_VerifyIndividualSemesterPaymentWithDiscoverCard Start");
		
		loginPage.loginToApplication("TestUser_30052017_28", "Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0125543","0303106");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Verifying Shipping Address ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.billing.address.new.checkbox.loc")), "Unable to verify Shipping Address");
		
		// Email
		tutorialPage.enterText("new-atitesting.email.loc", "new-atitesting.sample.email.id", 0);
		
		// Phone no
		tutorialPage.enterText("new-atitesting.phone.no.loc", "new-atitesting.phoneInpt", 0);
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		//myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		// Verify Price Details.
		log(logger, "Verifying Semester Payment");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.semester.payment.1220.loc")), "Unable to verify semester payment");
		
		log(logger, "Verifying Late Payment fee");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.late.payment.fee.loc")), "Unable to verify Late payment fee");
		
		log(logger, "Verifying Tax Amount ");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.tax.amount.loc")), "Unable to verify Tax Amount");
		VerificationHandler.verifyTrue(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Late Payment Fee is not greater than zero");
		
		log(logger, "Verifying Discount");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.discount.loc")), "Verifying Discount");
		
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
		// Verify Order Summary page and click close btn.
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		log(logger,"NewATI329_VerifyIndividualSemesterPaymentWithDiscoverCard End");
	}
	}


}
