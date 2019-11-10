package com.automation.newati.regression.payment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;

public class VerifyTEASSelfPayAssessment extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
	}
	
		
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="NewATI-301:Verify (TEAS) Self Pay Assessment Payment using a Visa Card without shipping tax")
	public void NewATI301_VerifyTEASSelfPayVisaCard() throws Exception {
		logger.info("NewATI301_VerifyTEASSelfPayVisaCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.teas.selfpay.id.value.new"));
		
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		
		paymentsPage.clickOnAddProductContinueButton(false);

		log(logger, "Checking shipping address check box");
		paymentsPage.checkShippingAddressCheckBox();
		
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		log(logger, "Entering Phone number in Shipping address");
		paymentsPage.enterShippingPhoneNo();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
			
		log(logger, "switching to frame");
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		log(logger, "click on payment tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
					
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		
		logger.info("NewATI301_VerifyTEASSelfPayVisaCard End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description="NewATI-299:Verify (TEAS) Self Pay Assessment Payment using a American Express Card without shipping tax")
	public void NewATI299_VerifyTEASSelfPayAmericanExpressCard() throws Exception {
		logger.info("NewATI299_VerifyTEASSelfPayAmericanExpressCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.teas.american.without.tax.uname"), PropertiesRepository.getString("newati.login.assessment.payment.pwd.selfpaynonteas"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.american.without.tax.id.value1"));
		
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		
		paymentsPage.clickOnAddProductContinueButton(false);

		log(logger, "Checking shipping address check box");
		paymentsPage.checkShippingAddressCheckBox();
		
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		log(logger, "Entering Phone number in Shipping address");
		paymentsPage.enterShippingPhoneNo();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
			
		log(logger, "switching to frame");
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput1"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		log(logger, "click on payment tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
					
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		
		logger.info("NewATI299_VerifyTEASSelfPayAmericanExpressCard End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description="NewATI-300:Verify (TEAS) Self Pay Assessment Payment using a Master Card without shipping tax")
	public void NewATI300_VerifyTEASSelfPayMasterExpressCard() throws Exception {
		logger.info("NewATI300_VerifyTEASSelfPayMasterExpressCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.teas.master.without.tax.uname"), PropertiesRepository.getString("newati.login.assessment.payment.pwd.selfpaynonteas"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.master.card.without.tax.id.value"));
		
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		
		paymentsPage.clickOnAddProductContinueButton(false);

		log(logger, "Checking shipping address check box");
		paymentsPage.checkShippingAddressCheckBox();
		
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		log(logger, "Entering Phone number in Shipping address");
		paymentsPage.enterShippingPhoneNo();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
			
		log(logger, "switching to frame");
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput1"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		log(logger, "click on payment tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
					
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		
		logger.info("NewATI300_VerifyTEASSelfPayMasterExpressCard End");
	}
	
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description="NewATI-302:Verify (TEAS) Self Pay Assessment Payment using a Discover Card")
	public void NewATI300_VerifyTEASSelfPayDiscoverExpressCard() throws Exception {
		logger.info("NewATI300_VerifyTEASSelfPayDiscoverExpressCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.teas.discover.without.tax.uname"), PropertiesRepository.getString("newati.login.assessment.payment.pwd.selfpaynonteas"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.discover.card.without.tax.id.value"));
		
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		
		paymentsPage.clickOnAddProductContinueButton(false);

		log(logger, "Checking shipping address check box");
		paymentsPage.checkShippingAddressCheckBox();
		
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		log(logger, "Entering Phone number in Shipping address");
		paymentsPage.enterShippingPhoneNo();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
			
		log(logger, "switching to frame");
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput1"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		log(logger, "click on payment tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
					
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		
		logger.info("NewATI300_VerifyTEASSelfPayDiscoverExpressCard End");
	}
}
