package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class PaymentTest20 extends BaseTest {

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

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-317:Verify Individual Semester Payment using American Express card without shipping tax")
	public void NewATI317_VerifyIndividualSemesterPaymentWithAmericanExpCard() throws Exception {
		log(logger,"NewATI317_VerifyIndividualSemesterPaymentWithAmericanExpCard Start");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),
				PropertiesRepository.getString("new-atitesting.individualsemesterpayment.paymentcode"),
				PropertiesRepository.getString("new-atitesting.individualsemesterpayment.class"));
		
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
		VerificationHandler.verifyFalse(paymentsPage.verifyIndSemesterEqual("Late Payment Fee"), "Late Payment Fee is not greater than zero");
		
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
	
	@Test(priority=2, description="Regression  NewATI-315:Verify Self Pay Tutorial payment using a American Express card with shipping tax")
		public void NewATI315_verifySelfPayTutorialAmericanCardWithTax() throws Exception {
			logger.info("NewATI315_verifySelfPayTutorialAmericanCardWithTax Start");
			// Step 2 Start		
			
			log(logger, "Click on AddProduct Button");
			paymentsPage.clickOnAddProductButton();
			// Step 2 End
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// Step 3 & 4 Start
			log(logger, "Entering Self Pay ID");
			paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
			paymentsPage.clickOnAddProductContinueButton(false);
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Entering Self Pay PWD");
			paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
			paymentsPage.clickOnAddProductContinueButton(false);
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// Step 3 & 4 End
			
			// Step 5 Start
			VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(), "Description Exists in Add Product");
			log(logger, "Verifying Description Exists");
			
			paymentsPage.clickOnAddProductContinueButton(false);
			
			// Step 5 End

			// Step 6 Start
			paymentsPage.checkShippingAddressCheckBox();
			log(logger, "Checking shipping address check box");
			// Step 6 End
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			jse.executeScript("window.scrollBy(0,250)", "");
			
			// Step 7 Start
			log(logger, "Clicking Shipping Address Check box");
			paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
			// Step 7 End
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// Step 8 Start
			
			paymentsPage.enterShippingAddress();
			
			VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
						.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
			
			
			log(logger, "verify tax amount greater than zero");
			paymentsPage.verifytaxvaluegreaterthanzero();
			
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
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// Step 8 End
			
			// Step 9 Start
			//Verify Order Summary Page	
			VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
					PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
					.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.closeOrderSummaryPage();
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			// Step 11 End\
			
			/*		log(logger, "Clicking on My ATI Tab");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			homePage.clickTab(1);
			log(logger, "Clicking Test Tab");
			myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.test.tab.new.loc"));
			log(logger, "Verifying purchased product under My ATI tab");
			
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Clicking on Info Icon for Specific Module");
			testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("new.atitesting.learntab.selfpay.assess.name.tutorial"));
			log(logger, "Verifying the added Product in Learn tab");				
			learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.selfpay.asessment.learn.tab.product.id"));*/
			/*buttonHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.product.information.popup.close.button.loc"));*/
			logger.info("NewATI315_verifySelfPayTutorialAmericanCardWithTax End");
		}
	
	@Test(priority=3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="NewATI-297:Verify (Non TEAS) Self Pay Assessment Payment using American Express Card without Shipping Tax")
	public void NewATI297_VerifyNonTEASSelfPayAmericanCard() throws Exception {
		logger.info("NewATI297_VerifyNonTEASSelfPayAmericanCard Start");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.american.without.tax.id.value"));
		
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNamePurchaseDetails(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Checking shipping address check box");
		paymentsPage.checkShippingAddressCheckBox();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Entering Email ID in Shipping address");
		paymentsPage.enterShippingEmailId();
		
		log(logger, "Entering Phone number in Shipping address");
		paymentsPage.enterShippingPhoneNo();
		
		
		log(logger, "Verify Credit Card Details Page");	
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		log(logger, "Verify tax amount");	
		paymentsPage.verifytaxvalue();
		paymentsPage.switchToBrainTree();
		
		log(logger, "Entering Master Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		  log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	  
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput1"));
		
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtn();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify MyAccount link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		log(logger, "Verify Payments tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify NoData Available");
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		log(logger, "verify MyAccount link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI297_VerifyNonTEASSelfPayAmericanCard End");
	}
}
