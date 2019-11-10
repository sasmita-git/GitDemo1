package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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
public class PaymentTest18 extends BaseTest {

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

	
	
	@Test(priority = 1, description= "Regression NewATI-355:Verify Payment for Tutorial using AMEX cards")
	public void NewATI355_verifyPaymentForTutorialUsingAMEXCard() throws Exception {
		logger.info("NewATI355_verifyPaymentForTutorialUsingAMEXCard Start");
		
	
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		/*log(logger, "Select Program Type");
		paymentsPage.selectProgramType();*/
		
		//myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository
						.getString("new-atitesting.userAccountInpt"),
				"Unable to verify My Account link");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage
					.verifyOrderDetails(
							PropertiesRepository
									.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
							PropertiesRepository
									.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"),
									orderNo), "Unable to verify Order No");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Verify Order Details Order No");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"),
									date), "Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");
			
			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
			
			
			logger.info("NewATI355_verifyPaymentForTutorialUsingAMEXCard End");
			
}
		
		
	}
	
	@Test(priority = 2, description= "Regression NewATI-343:Verify Payment for Practice Test by using AMEX cards")
	public void NewATI343_verifyPracticeTestPaymentviaAmericanCard() throws Exception {
		logger.info("NewATI343_verifyPracticeTestPaymentviaAmericanCard Start");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		
		for (int i = 0; i < 6; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
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

		logger.info("NewATI343_verifyPracticeTestPaymentviaAmericanCard End");
				}		
	}
	
	@Test(priority = 3, description= "Regression NewATI-349:Verify Payment for TEAS Practice Test by using AMEX cards")
	public void NewATI349_verifyTEASPracticeTestUsingAMEXCard() throws Exception {
		logger.info("NewATI349_verifyTEASPracticeTestUsingAMEXCard Start");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		for (int i = 0; i < 2; i++) {
			
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
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		
		tutorialPage.waitForAwhile(20000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
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
		
		logger.info("NewATI349_verifyTEASPracticeTestUsingAMEXCard End");
		
	}
	}}
