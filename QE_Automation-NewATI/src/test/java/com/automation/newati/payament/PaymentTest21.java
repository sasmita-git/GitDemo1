package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;

@Test
public class PaymentTest21 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private BaseHandler basehandler;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		basehandler = new BaseHandler(driver);
	}
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="NewATI357-Verify that user can successfully make payment for TEAS Share Results using Visa Card::SELF Pay")
	public void NewATI357_VerifyTEASShareResults() throws Exception {
		logger.info("NewATI357_VerifyTEASShareResults Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on my results tab");
		homePage.clickTab(2);
		
		//tutorialPage.clickButtonFromList("newati.payment.myresults.share.results.loc", 0);
	     basehandler.findElement(".custom-table>tbody>tr:nth-child(6)>td>a>span").click();
	     myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		
		log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		
		log(logger, "click on close button");
		tutorialPage.clickButtonforOrdersummary("newati.payment.mypurchase.order.close.button",0);
		
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
		logger.info("NewATI357_VerifyTEASShareResults End");
	}
	
	@Test(priority=2, description="Regression NewATI-358:Verify that user can make payment for TEAS Share Results using visa Card with Tax")
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
		tutorialPage.clickButtonforOrdersummary("newati.payment.mypurchase.order.close.button",0);
		
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
	
	@Test(priority=3, description="Regression NewATI-374:Verify that user can make payment for TEAS Share Results using AMEX Card with Tax")
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
		tutorialPage.clickButtonforOrdersummary("newati.payment.mypurchase.order.close.button",0);
		
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
	
	@Test(priority=4, description="Regression NewATI-362:Verify that user can make payment for TEAS Share Results using Master Card with Tax")
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
		tutorialPage.clickButtonforOrdersummary("newati.payment.mypurchase.order.close.button",0);
		
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
	
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify Order Link Under Purchase History Section.::General")
	public void NewATI100_VerifyOrderLinkUnderHistorySection() throws Exception {

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.sem.uname.orderhistory"),
				PropertiesRepository.getString("newati.login.selfpay.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));

		log(logger, "click on order link");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.history.table.loc",0);
		
		String orderNo = paymentsPage.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
		String date = paymentsPage.getOrderNoDetails(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));

		log(logger, "Verify Order Details Header");
		paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
				PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

		log(logger, "Verify Order Details Order No");
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
				"Unable to verify Order No");

		log(logger, "Verify Order Details Order Date");
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
				"Unable to verify Order Date");

		paymentsPage.verifyOrderDetailsExists(
				PropertiesRepository.getString("new-atitesting.order.history.order.details.account.no.loc"));
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
				"Unable to verify Order No");
		log(logger, "Verify Order Details Order No");
	}
}