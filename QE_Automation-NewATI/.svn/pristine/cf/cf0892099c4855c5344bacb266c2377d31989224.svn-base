package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
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
import com.automation.newati.util.UserCreationUtils;
public class PaymentTest8 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before class method ");
	}
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver);
		
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-342:Verify On-time Semester Payment using Master card with editted billing address")
	public void NewATI342_VerifyOnTimeMasterCard() throws Exception {
		log(logger,"NewATI342_VerifyOnTimeMasterCard Start");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),"0123406","0517changeing");
		
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
		
		log(logger, "Editing Shippint Address");
		paymentsPage.enterShippingAddressForOnTime();
		
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
		VerificationHandler.verifyTrue(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Tax Amount is not greater than zero");
		
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
		
	}		
		log(logger,"NewATI342_VerifyOnTimeMasterCard End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-327:Verify Individual Semester Payment using Master card without shipping tax")
	public void NewATI327_VerifyIndividualSemesterPaymentWithMasterCard() throws Exception {
		log(logger,"NewATI327_VerifyIndividualSemesterPaymentWithMasterCard Start");
		
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
		log(logger, "Verifying Late Payment fee");
		VerificationHandler.verifyTrue(tutorialPage.verifyElement(PropertiesRepository.getString("new-atitesting.late.payment.fee.loc")), "Unable to verify Late payment fee");
		
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
	
	@Test(priority=3, description="Regression  NewATI-335:Verify Self Pay Tutorial payment using a MasterCard with shipping tax")
	public void NewATI335_verifySelfPayTutorialMasterCardCardWithTax() throws Exception {
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax Start");
		// Step 2 Start		
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 & 4 Start
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		// Step 3 & 4 End
		
		// Step 5 Start
		//VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		log(logger, "Clicking Shipping Address Check box");
		paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
		// Step 7 End
		
		// Step 8 Start
		
		paymentsPage.enterShippingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.verifyTaxAmount();
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		
		paymentsPage.closeOrderSummaryPage();
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax End");
	}
}