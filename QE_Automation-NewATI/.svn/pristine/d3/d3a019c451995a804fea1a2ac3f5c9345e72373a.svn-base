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

@Test
public class VerifyTEASShareResultsWithTax extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
	}
	
	@Test(priority=1, description="Regression NewATI-358:Verify that user can make payment for TEAS Share Results using visa Card with Tax")
	public void NewATI358_verifyTEASShareResultsviaVisaCardWithTax() throws Exception {
		logger.info("NewATI358_verifyTEASShareResultsviaVisaCardWithTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.enterBillingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");

		boolean verifyTaxAmount = paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(verifyTaxAmount);
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("newati.payment.credit.card.details"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("newati.payment.credit.card.expiration.details"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("newati.payment.credit.card.cvv.info"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI358_verifyTEASShareResultsviaVisaCardWithTax End");
	}
	
	
	@Test(priority=2, description="Regression NewATI-374:Verify that user can make payment for TEAS Share Results using AMEX Card with Tax")
	public void NewATI374_verifyTEASShareResultsviaAmericanCardWithTax() throws Exception {
		logger.info("NewATI374_verifyTEASShareResultsviaAmericanCardWithTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.enterBillingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");

		boolean verifyTaxAmount = paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(verifyTaxAmount);
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI374_verifyTEASShareResultsviaAmericanCardWithTax End");
		
	}
	
	@Test(priority=3, description="Regression NewATI-362:Verify that user can make payment for TEAS Share Results using Master Card with Tax")
	public void NewATI362_verifyTEASShareResultsviaMasterCardWithTax() throws Exception {
		logger.info("NewATI362_verifyTEASShareResultsviaMasterCardWithTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.enterBillingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");

		boolean verifyTaxAmount = paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(verifyTaxAmount);
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI362_verifyTEASShareResultsviaMasterCardWithTax End");
		
	}
	
	@Test(priority=4, description="Regression NewATI-354:Verify that user can successfully purchas purchase Transcript using a Discover card with tax")
	public void NewATI354_verifyTEASShareResultsviaDiscoverCardWithTax() throws Exception {
		logger.info("NewATI354_verifyTEASShareResultsviaDiscoverCardWithTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.enterBillingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");

		boolean verifyTaxAmount = paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(verifyTaxAmount);
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI354_verifyTEASShareResultsviaDiscoverCardWithTax End");
		
	}
	
	@Test(priority=5, description="Regression NewATI-372:Verify that user can make payment for TEAS Share Results using AMEX Card")
	public void NewATI372_verifyTEASShareResultsviaAmericanCardWithOutTax() throws Exception {
		logger.info("NewATI372_verifyTEASShareResultsviaAmericanCardWithOutTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI372_verifyTEASShareResultsviaAmericanCardWithOutTax End");
	}
	
	@Test(priority=6, description="Regression NewATI-359:Verify that user can make payment for TEAS Share Results using Master Card")
	public void NewATI359_verifyTEASShareResultsviaMasterCardWithOutTax() throws Exception {
		logger.info("NewATI359_verifyTEASShareResultsviaMasterCardWithOutTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI359_verifyTEASShareResultsviaMasterCardWithOutTax End");
	}
	
	@Test(priority=6, description="Regression NewATI-351:Verify that user can successfully purchase 'Purchase Transcript' using a Discover card")
	public void NewATI351_verifyTEASShareResultsviaDiscoverCardWithOutTax() throws Exception {
		logger.info("NewATI351_verifyTEASShareResultsviaDiscoverCardWithOutTax Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on help tab");
		homePage.clickTab(2);
		
		log(logger,"click on share results link");
		homePage.clickButtonFromList("newati.login.teas.share.results.link", 0);
		
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton1(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
	   
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI351_verifyTEASShareResultsviaDiscoverCardWithOutTax End");
	}
	
	
	
}
