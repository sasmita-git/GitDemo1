package com.automation.newati.regression.payment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;

public class VerifySelfPayTutorial extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	private TutorialPage tutorialPage;
	private BaseHandler basehandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
		tutorialPage = new TutorialPage(driver);
		basehandler = new BaseHandler(driver);
	}
	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority=1, description="Regression NewATI-332:Verify Self Pay Tutorial payment using a Visa card.")
	public void NewATI332_verifySelfTutorialVisaCard() throws Exception {
		logger.info("NewATI332_verifySelfTutorialVisaCard Start");
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.visa.card.tutorial.name"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");			
		
		// Step 3 & 4 End
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		// Step 7 End
		
		// Step 8 Start
		//Verify Credit Card Details Page	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput"));
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
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI332_verifySelfTutorialVisaCard End");
	}
	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority=2, description="Regression NewATI-334:Verify Self Pay Tutorial payment using a Master card. ")
	public void NewATI334_verifySelfPayTutorialMasterCard() throws Exception {
		logger.info("NewATI334_verifySelfPayTutorialMasterCard Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.name"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		// Step 7 End
		
		// Step 8 Start
		//Verify Credit Card Details Page	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository
					.getString("new-atitesting.MastercreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository
					.getString("new-atitesting.MastercreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository
					.getString("new-atitesting.MastercreditcardCVVUInput"));
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
		logger.info("NewATI334_verifySelfPayTutorialMasterCard End");
	}	
	
	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority=3, description="Regression NewATI-336:Verify Self Pay Tutorial payment using a Discover card.")
	public void NewATI336_verifySelfPayTutorialDiscoverCard() throws Exception {
		logger.info("NewATI336_verifySelfPayTutorialDiscoverCard Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.discover.card.tutorial.name"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		// Step 7 End
		
		// Step 8 Start
		//Verify Credit Card Details Page	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository
					.getString("new-atitesting.discovercreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository
					.getString("new-atitesting.discovercreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository
					.getString("new-atitesting.discovercreditcardCVVUInput"));
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
		logger.info("NewATI336_verifySelfPayTutorialDiscoverCard End");
	}
	
	
	@Test(priority=4, description="Regression NewATI-339:Verify Self Pay Tutorial payment using a fraud card")
	public void NewATI339_verifySelfPayTutorialUsingFraudCard() throws Exception {
		logger.info("NewATI339_verifySelfPayTutorialUsingFraudCard Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.fraud.card.tutorial.name"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		// Step 7 End
		
		// Step 8 Start
		//Verify Credit Card Details Page	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.fraud.creditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		paymentsPage.clickOnSubmitOrderBtn();
		
		boolean status=paymentsPage.verifyFradCardErrorMessage("new-atitesting.fraud.card.error.msg.loc","new-atitesting.fraud.card.error.msg");
		VerificationHandler.verifyTrue(status);
		
		logger.info("NewATI339_verifySelfPayTutorialUsingFraudCard End");
	}
	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @throws Exception
	 */
	@Test(priority=5, description="Regression NewATI-311:Verify Self Pay Tutorial payment using American Express card.")
	public void NewATI311_verifySelfPayTutorialAmericanCard() throws Exception {
		logger.info("NewATI311_verifySelfPayTutorialAmericanCard Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.selfpay.american.card.tutorial.name"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		
		// Step 5 Start
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		// Step 6 End
		
		// Step 7 Start
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		// Step 7 End
		
		// Step 8 Start
		//Verify Credit Card Details Page	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
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
		logger.info("NewATI311_verifySelfPayTutorialAmericanCard End");
	}
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-312:Cancel the payment testing by clicking back button /refresh page")
	public void NewATI312_verifyPaymentcancellationbyRefreshing() throws Exception {
		log(logger, "NewATI312_verifyPaymentcancellationbyRefreshing Start");
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		// Product ID
		paymentsPage.enterSelfPayProductID("TUT173611");
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		// Product Password
		paymentsPage.enterSelfPayProductPassword("12D5X");
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");

		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
		"Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);

		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");

		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");

		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");

		// Verify Credit Card Details Page
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true),
		PropertiesRepository.getString("new-atitesting.creditCardDetailsInput"),
		"Unable to verify Credit card details dialogue");

		// Verify Credit Card Details Page Description section
		VerificationHandler.verifyEquals(basehandler
		.findElement(
				"div[data-bind='visible: IsOrderDetailsVisible'] .custom-table.order-detail-table tbody tr th")
		.getText(), "Description", "Unable to verify Description section");

		paymentsPage.switchToBrainTree();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
		PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click Submit with refresh page
		paymentsPage.clickOnSubmitOrderBtnteasWithRefresh();
		log(logger, "Click on Submit Button with refresh");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if order id is generated for the purchases assessment");
		VerificationHandler.verifyTrue(tutorialPage.VerifyifOrderIDGenerated("Pharmacology Made Easy 3.0"));

		log(logger, "NewATI312_verifyPaymentcancellationbyRefreshing End");

}
	
	
}
