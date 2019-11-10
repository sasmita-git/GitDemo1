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
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PaymentTest2 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private HomePage homePage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeClass
	public void beforeClassMethod() {
		logger.info("Before class method ");
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage = new PaymentsPage(driver);
		windowHandler = new WindowHandler(driver);
		homePage = new HomePage(driver);

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

	}
	@TestAnnotations(testID = "NewATI-352")
	@Test(priority = 1, description = "Regression  NewATI-352:Verify Payment for Tutorial using VISA cards")
	public void NewATI352_verifyPaymentForTutorialUsingVISACard() throws Exception {
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard Start");

		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0",
				"new-atitesting.online.store.assessment.name");

		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);

		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);

		// Scroll down code
		// jse.executeScript("window.scrollBy(0,250)", "");

		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));

		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));

		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));

		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));

		log(logger, "Verifying Payment Success Message");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(paymentsPage.verifyPaymentSuccessMessage(),
				"Unable to verify Payment Success Message");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();

			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

			logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard End");
		}
	}
	/**
	 * Commented because of state
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-337")
	@Test(priority = 2, description = "Regression  NewATI-337:Verify Payment for Practice Test by using VISA cards")
	public void NewATI337_verifyPracticePaymentviaVISACard() throws Exception {
		logger.info("NewATI337_verifyPracticePaymentviaVISACard Start");

		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 3; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments",
				"new-atitesting.online.store.leftpanel.assessment.name");

		for (int i = 0; i < 6; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A",
				"new-atitesting.online.store.assessment.name");

		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));

		for (int i = 0; i < 2; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		tutorialPage.waitForAwhile(50000);
		for (int i = 0; i <= 5; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}
		/*
		 * jse.executeScript("window.scrollBy(0,250)", "");
		 * jse.executeScript("window.scrollBy(0,250)", "");
		 * jse.executeScript("window.scrollBy(0,250)", "");
		 */

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));

		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));

		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));

		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));

		log(logger, "Verifying Payment Success Message");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.verifyPaymentSuccessMessage();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();
			paymentsPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

			logger.info("NewATI337_verifyPracticePaymentviaVISACard End");
		}
	}

	@TestAnnotations(testID = "NewATI-347")
	@Test(priority = 3, description = "Regression  NewATI-347:Verify Payment for TEAS Practice Test by using VISA cards")
	public void NewATI347_verifyTEASPracticeTestUsingVISACard() throws Exception {
		logger.info("NewATI347_verifyTEASPracticeTestUsingVISACard Start");

		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();

		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products",
				"new-atitesting.online.store.leftpanel.assessment.name");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		for (int i = 0; i < 2; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A",
				"new-atitesting.online.store.assessment.name");

		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));

		
		for (int i = 0; i < 2; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}
/*jse.executeScript("window.scrollBy(0,250)", "");*/
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);

		for (int i = 0; i < 3; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));

		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));

		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));

		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));

		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();
			paymentsPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

			logger.info("NewATI347_verifyTEASPracticeTestUsingVISACard End");
		}
	}
	@TestAnnotations(testID = "NewATI-360")
	@Test(priority = 4, description = "Regression  NewATI-360:Verify Payment for EBook using VISA cards")
	public void NewATI360_verifyPaymentForEBookUsingVISACard() throws Exception {
		logger.info("NewATI360_verifyPaymentForEBookUsingVISACard Start");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success",
				"new-atitesting.online.store.assessment.name");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);

		for (int i = 0; i < 3; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();
			paymentsPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

			logger.info("NewATI360_verifyPaymentForEBookUsingVISACard End");
		}
	}
	@TestAnnotations(testID = "NewATI-382")
	@Test(priority = 5, description= "Regression NewATI-382:VERIFY if purchased product(Dosage & Calculations and Safe Medication) is available under My ATI tab")
	public void NewATI382_verifySafeMedicationviaVISACard() throws Exception {
		logger.info("NewATI382_verifySafeMedicationviaVISACard Start");

		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		for (int i = 0; i < 2; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments",
				"new-atitesting.online.store.leftpanel.assessment.name");

		jse.executeScript("window.scrollBy(0,250)", "");

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut(
				"Dosage & Calculations and Safe Medication Administration 2.0 - Dimensional Analysis Method",
				"new-atitesting.online.store.assessment.name");

		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));

		jse.executeScript("window.scrollBy(0,250)", "");
		
	log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);

		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		for (int i = 0; i < 3; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));

		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));

		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));

		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));

		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();
			paymentsPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

			logger.info("NewATI382_verifySafeMedicationviaVISACard End");

		}
	}

	@TestAnnotations(testID = "NewATI-384")
	@Test(priority = 6, description= "Regression NewATI-384:Verify if purchased product(Pharmacology Made Easy 3.0) is available under My ATI tab")
	public void NewATI384_verifyPaymentForTutorialUsingVISACard() throws Exception {
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard Start");

		String mainWindowHandler = paymentsPage.getWindowHandler();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0",
				"new-atitesting.online.store.assessment.name");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);

		for (int i = 0; i < 3; i++) {
			int value = 250 * i;
			jse.executeScript("window.scrollBy(0," + value + ")", "");
		}

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();

		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();

		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));

			logger.info("orderNo --> " + orderNo);
			logger.info("date --> " + date);
			logger.info("itemPurchased --> " + itemPurchased);

			paymentsPage.clickOnOrderLink();
			paymentsPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));
			log(logger, "Verify Order Details Header");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			VerificationHandler
					.verifyTrue(
							paymentsPage.verifyOrderDetails(PropertiesRepository
									.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
			tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Clicking on My ATI Tab");
		
			homePage.clickTab(1);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			log(logger, "Verifying purchased product under My ATI tab");
			VerificationHandler.verifyTrue(
					tutorialPage.verifyElement(
							PropertiesRepository.getString("new-atitesting.homepage.learn.tab.purchased.tutorial")),
					"Purchased product is not available");
			// VerificationHandler.verifyEquals((PropertiesRepository.getString("new-atitesting.homepage.learn.tab.purchased.tutorial")).,
			// "Pharmacology Made Easy 3.0");

			logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard End");

		}
	}
}
