package com.automation.newati.payments;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.jaca.TestAnnotations;

public class VerifyNonTEASSelfPayAssessment extends BaseTest {
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
	
	
	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-298")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="Verify (Non TEAS) Self Pay Assessment Payment using Visa Card without shipping address::SELF Pay")
	public void NewATI298_VerifyNonTEASSelfPayVisaCard() throws Exception {
		logger.info("NewATI298_VerifyNonTEASSelfPayVisaCard Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.uname.selfpaynonteas"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 2 Start		
		paymentsPage.clickOnAddProductButton();
		log(logger, "Click on AddProduct Button");
		// Step 2 End
		
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository
				.getString("new-atitesting.non.teas.selfpay.id.value"));
		log(logger, "Entering Self Pay ID");
		// Step 3 & 4 End
		
		// Step 5 Start
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExistsNew(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExistsNew(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		// Step 6 Start
		paymentsPage.checkShippingAddressCheckBoxNew();
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
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButtonNew(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
				
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository
					.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository
					.getString("new-atitesting.creditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository
					.getString("new-atitesting.creditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		//NEED TO Uncomment when running in Stage Environment
		/*paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
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
*/		logger.info("NewATI298_VerifyNonTEASSelfPayVisaCard End");
	}
}
