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
import com.jaca.TestAnnotations;

public class PaymentTest_382 extends BaseTest {
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
		logger.info("Before class method ");
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage = new PaymentsPage(driver);
		windowHandler = new WindowHandler(driver);

		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	}
	@TestAnnotations(testID = "NewATI-382")
	@Test(priority = 1, description= "Regression NewATI-382:VERIFY if purchased product(Dosage & Calculations and Safe Medication) is available under My ATI tab")
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
	
}
