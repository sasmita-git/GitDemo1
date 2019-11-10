package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest11 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private BaseHandler basehandler;
	private WindowHandler windowHandler;
	
	
	
	private MyReportPage myReportPage;
	private TextHandler textHandler;
	private LearnTabPage learnTabPage;
	private ButtonHandler buttonHandler;
	private ApplyTabPage applyTabPage;

	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		basehandler=new BaseHandler(driver);
		
		learnTabPage = new LearnTabPage(driver);
		buttonHandler = new ButtonHandler(driver);
		applyTabPage = new ApplyTabPage(driver);
	
		windowHandler=new WindowHandler(driver);
	}
	
	


/**
 * Step 10, 12 & 13 DB Verification 
 * 
 * @author saravanan.jothimani
 * @throws Exception
 */

@TestAnnotations(testID="NewATI-352")
@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description= "Verify Payment for Tutorial using VISA cards::ONLINE STORE Purchase")
public void NewATI352_VerifyTutorialPaymentVISA() throws Exception {
	logger.info("NewATI352_VerifyTutorialPaymentVISA Start");
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.uname.payment"), PropertiesRepository.getString("newati.login.payment.pwd"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	String mainWindowHandler = paymentsPage.getWindowHandler();
	
	log(logger, "Clicking on Online Store Link");
	paymentsPage.verifyOnlineStoreLink();
	
	log(logger, "Clicking on TEAS V Online Product Assessment Form A");
	paymentsPage.clickPaymentTutorialOnline(PropertiesRepository.getString("new-atitesting.online.store.product.tutorial.name"));
	
	log(logger, "Clicking on Your Shopping Cart Check Out Button");
	paymentsPage.clickYourShoppingCartCheckOutButton();
	
	log(logger, "Clicking on Proceed to Payment Details Button in Secure Check Out ");
	paymentsPage.clickProceedToPaymentDetailsButtonInSecureCheckOutPage();
	
	log(logger, "Select Program Type");
	paymentsPage.selectProgramType();
	;
	log(logger, "Brain Tree");
	paymentsPage.switchToBrainTreeFrames();
	
	log(logger, "Entering Credit Card No");
	paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
	
	log(logger, "Entering Credit Card Expiration Date");
	paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
	
	log(logger, "Entering Credit Card CVV");
	paymentsPage.enterCreditCardCvvNumber(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput"));
	
	log(logger, "Clicking Check box Agreement");
	paymentsPage.checkAgreement();
	
	//****NEED TO UnComment this code when running in Stage Environment******
	
	/*log(logger, "Secure Check Out Submit Order");
	paymentsPage.clickSecureCheckOutSubmitOrder();
	
	log(logger, "Verifying Payment Success Message");
	paymentsPage.verifyPaymentSuccessMessage();
	
	log(logger, "Closing Online Store window");
	paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
	
	// verify MyAccount link
	VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
			PropertiesRepository
					.getString("new-atitesting.userAccountInpt"),
			"Unable to verify My Account link");

	// Verify Payments tab
	VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
			"Unable to verify My Purchase and Payments tab");

	
	// Step 11 Start
	if (!paymentsPage
			.verifyNoDataAvailable()
			.equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))) {

		String orderNo = paymentsPage
				.getOrderNo(PropertiesRepository
						.getString("new-atitesting.order.history.order.no.loc"));
		String date = paymentsPage
				.getOrderNo(PropertiesRepository
						.getString("new-atitesting.order.history.order.date.loc"));
		String itemPurchased = paymentsPage
				.getOrderNo(PropertiesRepository
						.getString("new-atitesting.order.history.order.item.purchased.loc"));

		System.out.println("orderNo --> " + orderNo);
		System.out.println("date --> " + date);
		System.out.println("itemPurchased --> " + itemPurchased);

		paymentsPage.clickOnOrderLink();

		paymentsPage
				.verifyOrderDetails(
						PropertiesRepository
								.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
						PropertiesRepository
								.getString("new-atitesting.order.history.order.details.page.header.value"));
		log(logger, "Verify Order Details Header");

		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"),
								orderNo), "Unable to verify Order No");
		log(logger, "Verify Order Details Order No");

		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"),
								date), "Unable to verify Order Date");
		log(logger, "Verify Order Details Order Date");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.account.no.loc"));
		log(logger, "Verify Account No in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.student.id.loc"));
		log(logger, "Verify Student Id in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.promotion.code.loc"));
		log(logger, "Verify Promotion Code in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.payment.method.loc"));
		log(logger, "Verify Payment Method in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.card.trans.id.loc"));
		log(logger, "Verify Transaction Id in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.selected.invoice.id.loc"));
		log(logger, "Verify Selected Invoice Id in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.puruchase.order.no.loc"));
		log(logger, "Verify Purchase Order No in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.delivery.method.loc"));
		log(logger, "Verify Delivery Method in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.email.loc"));
		log(logger, "Verify Email in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.billing.name.loc"));
		log(logger, "Verify Billing Name in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.billing.address.loc"));
		log(logger, "Verify Billing Address in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.billling.address.2.loc"));
		log(logger, "Verify Billing Address 2 in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.billing.country.loc"));
		log(logger, "Verify Billing Country in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.billing.phone.no.loc"));
		log(logger, "Verify Billing Phone No in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.name.loc"));
		log(logger, "Verify Shipping Name in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.address.loc"));
		log(logger, "Verify Shipping Address in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.address.2.loc"));
		log(logger, "Verify Shipping Address 2 in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.country.loc"));
		log(logger, "Verify Shipping Country in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.phone.no.loc"));
		log(logger, "Verify Shipping Phone No in Order details page");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.shipping.email.loc"));
		log(logger, "Verify Shipping Email in Order details page");

		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.order.history.order.details.description.loc"),
								itemPurchased),
						"Unable to verify Item Purchased");
		log(logger, "Verify Order Details Item Purchased");

		paymentsPage.verifyOrderDetailsExists(PropertiesRepository.getString("new-atitesting.order.history.order.details.institution.name.loc"));
		log(logger, "Verify Order Details Intitution Name in Table");

		paymentsPage.verifyOrderDetailsFooterMessage();
		log(logger, "Verifying Order Details Footer Message");

		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

	} else {
		throw new SkipException(
				"No data available, You have not placed any orders");
	}*/
	
	logger.info("NewATI352_VerifyTutorialPaymentVISA End");
}
@TestAnnotations(testID="NewATI-298")
@Test(priority=1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="Verify (Non TEAS) Self Pay Assessment Payment using Visa Card without shipping address::SELF Pay")
public void NewATI298_VerifyNonTEASSelfPayVisaCard() throws Exception {
	logger.info("NewATI298_VerifyNonTEASSelfPayVisaCard Start");
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.uname.payment"), PropertiesRepository.getString("newati.login.payment.pwd"));
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
@TestAnnotations(testID="NewATI-344")
@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify On-time Semester Payment Visa card with same billing address::SEMESTER Payment")
public void NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard() throws Exception {
	log(logger,"NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard Start");
	
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.uname.payment"), PropertiesRepository.getString("newati.login.payment.ontime.sem.pwd"));
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger,"click on  account link");
	tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
	
	log(logger, "click on mypurchase and payments tab");
	tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
	
	paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.ontime.sem.input2"),PropertiesRepository.getString("newati.payment.ontime.class.input2"));
	
	log(logger, "verifying payment page objects");
	boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
	VerificationHandler.verifyTrue(result);
	
	log(logger, "click on continue button");
	tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
	
	log(logger, "click on continue button");
	tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
	
	boolean result1=paymentsPage.verifyAddressInformationPage();
	VerificationHandler.verifyTrue(result1);
	
	log(logger, "click on continue button");
	tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
	
	log(logger, "Enter the card details");
	paymentsPage.enterCardDetails();
	
	
	windowHandler.switchToLatestWindow();
	String parentWindow = driver.getWindowHandle();
	windowHandler.switchToFrame("paymentFrame");
	
	//************Need to be Uncommented when running in Stage Environment******
	log(logger, "click on submit button");
	tutorialPage.clickButton(".step-modal-nav input");
	
	windowHandler.switchToWindow(parentWindow);
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "click on close button");
	tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
	
	log(logger,"NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard End");
	
}

}
