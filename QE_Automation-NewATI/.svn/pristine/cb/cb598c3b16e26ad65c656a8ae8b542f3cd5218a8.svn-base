package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class PaymentTest7 extends BaseTest {

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
	
	@Test(priority = 1, description= "Regression NewATI-348:Verify Payment for TEAS Practice Test by using MASTER cards")
	public void NewATI348_verifyTEASPracticeTestUsingMASTERCard() throws Exception {
		logger.info("NewATI348_verifyTEASPracticeTestUsingMASTERCard Start");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		for (int i = 0; i <2; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		for (int i = 0; i <3; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
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
			
			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		logger.info("NewATI348_verifyTEASPracticeTestUsingMASTERCard End");
		
	}}
	
	@Test(priority = 2, description= "Regression NewATI-363:Verify Payment for EBook using MASTER cards")
	public void NewATI363_verifyPaymentForEBookUsingMASTERCard() throws Exception {
		logger.info("NewATI363_verifyPaymentForEBookUsingMASTERCard Start");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		for (int i = 0; i <3; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
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
					
					VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
		
		logger.info("NewATI363_verifyPaymentForEBookUsingMASTERCard End");
		
	}}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-319:Verify Late Semester Payment using Master card with editted billing address")
	public void NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress() throws Exception {
		log(logger,"NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress Start");
		
	
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
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);
		
		/*log(logger, "Click on Continue button");
		tutorialPage.clickButtonFromList("new-atitesting.step4.continueButtonLoc", 0);*/
		
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "Changing Shipping address");
		// Clicking on Shipping Address.
		tutorialPage.clickButton("#OrderPaymentDialog .question-option label");
		// Entering shipping address. 
		paymentsPage.enterShippingAddress();
		
		driver.findElement(By.cssSelector(".email-and-phone .create-account-right input")).sendKeys(Keys.TAB);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(".focus-element-flag.step-modal-nav-right.move-to-next-content-active");
		
		// Enter pha, email nd click continue btn.
		log(logger, "Enter the card details");
		paymentsPage.enterMasterCardDetails();
		
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input"); windowHandler.switchToLatestWindow();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verify Order Summary page and click close btn.
		log(logger, "click on close button");
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.order.summary.loc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
		paymentsPage.closeOrderSummaryPage();
		
		log(logger,"NewATI319_VerifyLateSemesterPaymentWithMasterCardEditAddress End");
	}
}