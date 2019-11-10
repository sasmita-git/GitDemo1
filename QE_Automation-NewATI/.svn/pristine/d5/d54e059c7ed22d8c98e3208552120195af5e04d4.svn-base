package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PaymentTest9 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
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
		paymentsPage = new PaymentsPage(driver);

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

	@TestAnnotations(testID = "NewATI-303")
	@Test(priority = 1, description = "Regression  NewATI-303:Verify (Non TEAS) Self Pay Assessment Payment using MasterCard with shipping tax")
	public void NewATI303_verifyTEASSelfPayMasterCardWithTax() throws Exception {
		logger.info("NewATI303_verifyTEASSelfPayMasterCardWithTax Start");

		// Step 2 Start
		paymentsPage.clickOnAddProductButton();
		log(logger, "Click on AddProduct Button");
		// Step 2 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 & 4 Start
		paymentsPage.enterSelfPayProductID(
				PropertiesRepository.getString("new-atitesting.non.teas.selfpay.with.tax.id.value"));
		log(logger, "Entering Self Pay ID");
		// Step 3 & 4 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 Start
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNamePurchaseDetails(),
				"Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(),
				"Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6 Start
		paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
		log(logger, "Checking shipping address check box");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterShippingAddress();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true),
				PropertiesRepository.getString("new-atitesting.creditCardDetailsInput"),
				"Unable to verify Credit card details dialogue");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify tax amount greater than zero");
		paymentsPage.verifytaxvaluegreaterthanzero();

		paymentsPage.switchToBrainTree();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");

		paymentsPage.clickOnSubmitOrderBtnForTEASSelfPay();
		log(logger, "Click on Submit Button");
		// Step 8 End
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 9 Start
		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage
						.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		paymentsPage.closeOrderSummaryPage();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");
				// Step 9 End

		// Step 11 Start
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			// verify MyAccount link
			VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(),
					PropertiesRepository.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),
					"Unable to verify Order Link Under Purchase History Page");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

		} else {
			throw new SkipException("No data available, You have not placed any orders");
		}
		// Step 11 End
		logger.info("NewATI303_verifyTEASSelfPayMasterCardWithTax End");
	}

	@TestAnnotations(testID = "NewATI-308")
	@Test(priority = 2, alwaysRun = true, enabled = true, description = "NewATI-308:Verify (TEAS) Self Pay Assessment Payment using a Master Card with Shipping tax")
	public void NewATI308_VerifyTEASSelfPayAssessmentMasterCard() throws Exception {
		logger.info("NewATI308_VerifyTEASSelfPayAssessmentMasterCard Start");

		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering assessment Self Pay ID");
		paymentsPage.enterSelfPayProductID(
				PropertiesRepository.getString("new-atitesting.teas.selfpay.assessment.id.value"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product Continue Button");
		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.selectAvailableInstitutions();

		paymentsPage.clickDownArrow();

		paymentsPage.checkSelectedInstitutions();

		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
				"Institution Name Exists in Add Product");

		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExistsNew(), "Description Exists in Add Product");

		// paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Purchase Details Continue Button");
		paymentsPage.clickButtonFromList("new-atitesting.payment.purchase.details.continue.button.loc", 0);

		paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
		log(logger, "Checking shipping address check box");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter shipping address");
		paymentsPage.enterShippingAddress();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true),
				PropertiesRepository.getString("new-atitesting.creditCardDetailsInput"),
				"Unable to verify Credit card details dialogue");

		log(logger, "verify tax amount");
		boolean result = paymentsPage.verifyTaxAmount();
		VerificationHandler.verifyTrue(result);

		paymentsPage.switchToBrainTree();

		log(logger, "Enter Credit card number");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));

		log(logger, "Entering Card Exp Date");
		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));

		log(logger, "Entering Card CVV No");
		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Click on Submit Button");
		paymentsPage.clickOnSubmitOrderBtnForTEASSelfPay();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyEquals(
				paymentsPage
						.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button", 0);

		log(logger, "click on user account link");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on payment tab");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(),
					PropertiesRepository.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),
					"Unable to verify Order Link Under Purchase History Page");

			VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());

		} else {
			throw new SkipException("No data available, You have not placed any orders");
		}

		logger.info("NewATI308_VerifyTEASSelfPayAssessmentMasterCard End");
	}
}