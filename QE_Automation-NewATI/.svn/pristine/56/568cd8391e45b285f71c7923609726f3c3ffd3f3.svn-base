package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PaymentTest1 extends BaseTest{
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private HomePage homePage;
	
	@BeforeClass
	public void beforeClassMethod() {
		logger.info("Inside beforeclass");
	}
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver); 
		homePage=new HomePage(driver);
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
			logger.info("Inside @BeforeMethod userId --> " + userId);
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		logger.info("Inside userId --> " + userId);
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID = "NewATI-320")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-320:Verify Late Semester Payment using Visa card with same billing address ")
	public void NewATI320_VerifyLateSemPaymForSameBillingAddress() throws Exception {
		
		logger.info("User creation and login successful");

		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.late.sem.input2"),PropertiesRepository.getString("newati.payment.late.class.input2"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button.new", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button.new", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify Address Information Page");
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		/*log(logger, "Enter the shipping details");
		paymentsPage.enterShippingAddressDetails();*/
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button.new"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		
		log(logger, "switch to frames");
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		/*log(logger, "click on Submit button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.submit.button"));*/
		
		/*log(logger, "click on submit button");
		tutorialPage.clickButtonWithSwitchToDefault(".step-modal-nav input" , 0);*/

		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc11")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.closeOrderSummaryPage();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Order link under My Purchase & Payments tab");
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
				.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
	}

	@TestAnnotations(testID = "NewATI-344")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-344:Verify On-time Semester Payment Visa card with same billing address")
	public void NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard() throws Exception {
		log(logger,"NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard Start");
	
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.ontime.sem.input2"),PropertiesRepository.getString("newati.payment.ontime.class.input2"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button.new", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button.new", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button.new"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc11")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		paymentsPage.closeOrderSummaryPage();
		log(logger, "Verify Order link under My Purchase & Payments tab");
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
				.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
		
		log(logger,"NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard End");
		
	}
	
	@TestAnnotations(testID = "NewATI-324")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-324:Verify Individual Semester Payment using Visa card with shipping tax ")
	public void NewATI324_VerifyIndividualSemPayVisaCardWithTax() throws Exception {

		log(logger,"NewATI324_VerifyIndividualSemPayVisaCardWithTax Start");
		
		log(logger,"click on account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.individual.sem.input2"),PropertiesRepository.getString("newati.payment.individual.class.input2"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the shipping details");
		paymentsPage.enterShippingAddressDetails();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "switch to frames");
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc11")),
			PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		paymentsPage.closeOrderSummaryPage();
		log(logger, "Verify Order link under My Purchase & Payments tab");
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
				.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");

		log(logger,"NewATI324_VerifyIndividualSemPayVisaCardWithTax End");
	}
	
	@TestAnnotations(testID = "NewATI-313")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke, Regression"}, description = "NewATI-313:Verify Bookstore Semester Payment flow")
	public void NewATI313_VerifyBookstoreSemesterPaymentFlow() throws Exception {
		log(logger,"NewATI313_VerifyBookstoreSemesterPaymentFlow Start");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "entering payment code");
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),
				PropertiesRepository.getString("newati.login.payment.uname.payment.code"),PropertiesRepository.getString("newati.login.payment.class.code"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button.new"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//coupon code data is not given
		paymentsPage.enterCouponCode("newati.login.payment.coupon.code.input");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.orderbook.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying purchase page objects");
		boolean status=paymentsPage.verifypurchasePageObjectPresence("newati.payment.purchase.details.page");
		VerificationHandler.verifyTrue(status);
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button.new"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean result1=paymentsPage.verifyingOrderSummaryPage();
		VerificationHandler.verifyTrue(result1);
		
		boolean result2=paymentsPage.verifyingOrderSummaryPageObjects();
		VerificationHandler.verifyTrue(result2);
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on order link");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.history.table.loc",0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result3=paymentsPage.verifyOrderDetails("newati.payment.mypurchase.order.details");
		VerificationHandler.verifyTrue(result3);
		log(logger,"NewATI313_VerifyBookstoreSemesterPaymentFlow End");
	}
	
	@TestAnnotations(testID = "NewATI-333")
	@Test(priority=5, description="Regression  NewATI-333:Verify Self Pay Tutorial payment using a Visa card with shipping tax")
	public void NewATI333_verifySelfPayTutorialVisaCardWithTax() throws Exception {
		logger.info("NewATI333_verifySelfPayTutorialVisaCardWithTax Start");
		// Step 2 Start		
	
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
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
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
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
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
	
	@TestAnnotations(testID = "NewATI-306")
	@Test(priority=6, description="Regression NewATI-306:Verify (Non TEAS) Self Pay Assessment Payment using Visa Card with Shipping tax")
	public void NewATI306_verifyNonTEASSelfPayVisaCardWithTax() throws Exception {
		logger.info("NewATI306_verifyNonTEASSelfPayVisaCardWithTax Start");
		
		// Step 2 Start		
		paymentsPage.clickOnAddProductButton();
		log(logger, "Click on AddProduct Button");
		// Step 2 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.with.tax.id.value"));
		log(logger, "Entering Self Pay ID");
		// Step 3 & 4 End
		
		// Step 5 Start
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNamePurchaseDetails(), "Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");
		
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6 Start
		paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
		log(logger, "Checking shipping address check box");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		paymentsPage.enterShippingAddress();
		
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		log(logger, "verify tax amount greater than zero");
		paymentsPage.verifytaxvaluegreaterthanzero();
		
		//paymentsPage.verifyTaxAmount();
		paymentsPage.scrollUp();
		
		paymentsPage.switchToBrainTree();
		
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");
	
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		log(logger, "Click on Submit Button");
		windowHandler.switchToLatestWindow();
		paymentsPage.scrollUp();
		paymentsPage.clickOnSubmitOrderBtnForTEASSelfPay();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToLatestWindow();
		paymentsPage.scrollUp();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		log(logger, "Verifying Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		log(logger,"Clicking on close button");
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
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");			
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");			
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI306_verifyNonTEASSelfPayVisaCardWithTax End");
	}
	
	@TestAnnotations(testID = "NewATI-309")
	@Test(priority = 7, alwaysRun = true, enabled = true, description="NewATI-309:Verify (TEAS) Self Pay Assessment Payment using a Visa Card with Shipping tax")
	public void NewATI309_VerifyTEASSelfPayAssessmentVisaCard() throws Exception {
		logger.info("NewATI309_VerifyTEASSelfPayAssessmentVisaCard Start");
		
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering assessment Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.teas.selfpay.assessment.id.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickOnAddProductContinueButton(false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickOnAddProductContinueButton(false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(), "Institution Name Exists in Add Product");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExistsNew(), "Description Exists in Add Product");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Purchase Details Continue Button");
		paymentsPage.clickButtonFromList("new-atitesting.payment.purchase.details.continue.button.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
		log(logger, "Checking shipping address check box");
		
		log(logger, "Enter shipping address");
		paymentsPage.enterShippingAddress();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
					.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
		
		log(logger, "verify tax amount");
		boolean result=paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(result);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.switchToBrainTree();
		
		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 log(logger, "Entering Card Exp Date");
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
	    homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	    log(logger, "Entering Card CVV No");
	    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
	    homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	    log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtnForTEASSelfPay();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
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
		
		logger.info("NewATI309_VerifyTEASSelfPayAssessmentMasterCard End");
	}
}
