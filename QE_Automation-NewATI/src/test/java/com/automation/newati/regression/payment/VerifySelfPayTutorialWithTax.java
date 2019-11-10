package com.automation.newati.regression.payment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;

public class VerifySelfPayTutorialWithTax extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
	}
	
	//@Test(priority=1, description="Regression  NewATI-315:Verify Self Pay Tutorial payment using a American Express card with shipping tax")
	public void NewATI315_verifySelfPayTutorialAmericanCardWithTax() throws Exception {
		logger.info("NewATI315_verifySelfPayTutorialAmericanCardWithTax Start");
		// Step 2 Start		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.american.card.with.tax.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		// Step 3 & 4 End
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
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
		
		
		paymentsPage.verifyTaxAmount();
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")), PropertiesRepository
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
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI315_verifySelfPayTutorialAmericanCardWithTax End");
	}	
	
	
	//@Test(priority=2, description="Regression  NewATI-333:Verify Self Pay Tutorial payment using a Visa card with shipping tax")
	public void NewATI333_verifySelfPayTutorialVisaCardWithTax() throws Exception {
		logger.info("NewATI333_verifySelfPayTutorialVisaCardWithTax Start");
		// Step 2 Start		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.visa.card.with.tax.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		// Step 3 & 4 End
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
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
		
		
		paymentsPage.verifyTaxAmount();
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")), PropertiesRepository
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
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI333_verifySelfPayTutorialVisaCardWithTax End");
	}	
	
	@Test(priority=3, description="Regression  NewATI-335:Verify Self Pay Tutorial payment using a MasterCard with shipping tax")
	public void NewATI335_verifySelfPayTutorialMasterCardCardWithTax() throws Exception {
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax Start");
		// Step 2 Start		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.master.card.with.tax.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		// Step 3 & 4 End
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
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
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")), PropertiesRepository
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
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax End");
	}	
	
	@Test(priority=4, description="Regression  NewATI-338:Verify Self Pay Tutorial payment using a Discover card with shipping tax")
	public void NewATI338_verifySelfPayTutorialDiscoverCardCardWithTax() throws Exception {
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax Start");
		// Step 2 Start		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.discover.card.with.tax.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		
		// Step 3 & 4 End
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
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
		
		
		paymentsPage.verifyTaxAmount();
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")), PropertiesRepository
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
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI335_verifySelfPayTutorialMasterCardCardWithTax End");
	}	
	
}
