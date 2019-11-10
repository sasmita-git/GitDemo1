package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;

public class PaymentRegression1 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private HomePage homePage;
	private BaseHandler basehandler;
	private LearnTabPage learnTabPage;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("Before class method ");
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage = new PaymentsPage(driver);
		homePage = new HomePage(driver);
		basehandler = new BaseHandler(driver);
		learnTabPage = new LearnTabPage(driver);

	}

	/**
	 * Verify that BrainTree identifies Visa Card
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 1, description = "NewATI-386:Verify that BrainTree identifies Visa Card")
	public void NewATI386_verifyBrainTreeVisaCard() throws Exception {
		logger.info("NewATI386_verifyBrainTreeVisaCard Start");


		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
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

		// Verify Credit Card, Expiry Date, CVV fields are displayed
		VerificationHandler.verifyTrue(paymentsPage.verifyCardFirlds());

		// Enter "4" as Credit card number verify if Visa icon is displayed
		paymentsPage.enterCreditCardNo("4");
		log(logger, "4");

		// Verify if Visa icon is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".payment-method-icon.visa").isDisplayed());

		// Clear Credit card number field
		paymentsPage.clearCreditCardfield();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");

		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");

		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage.verifyOrderSummaryPage(
						PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		// Verify Order Summary Page (Description, Assessment name ,Tax Amount,
		// Total, Student Name, Name on Credit Card, Date and Time Paid,
		// Institution)
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderSummaryPageAllFields());

		logger.info("NewATI386_verifyBrainTreeVisaCard End");
	}

	/**
	 * Verify that Brain Tree identifies Master Card successfully
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 2, description = "NewATI-387:Verify that Brain Tree identifies Master Card successfully")
	public void NewATI387_verifyBrainTreeMasterCard() throws Exception {
		logger.info("NewATI387_verifyBrainTreeMasterCard Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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

		// Verify Credit Card, Expiry Date, CVV fields are displayed
		VerificationHandler.verifyTrue(paymentsPage.verifyCardFirlds());

		// Enter "4" as Credit card number verify if Master Card icon is
		// displayed
		paymentsPage.enterCreditCardNo("51");
		log(logger, "51");

		// Verify if Visa icon is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".payment-method-icon.master-card").isDisplayed());

		// Clear Credit card number field
		paymentsPage.clearCreditCardfield();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");

		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage.verifyOrderSummaryPage(
						PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		// Verify Order Summary Page (Description, Assessment name ,Tax Amount,
		// Total, Student Name, Name on Credit Card, Date and Time Paid,
		// Institution)
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderSummaryPageAllFields());

		logger.info("NewATI387_verifyBrainTreeMasterCard End");
	}

	/**
	 * Verify that Brain Tree identifies Discover Card successfully
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 3, description = "NewATI-388:Verify that Brain Tree identifies Discover Card successfully")
	public void NewATI388_verifyBrainTreeDiscoverCard() throws Exception {
		logger.info("NewATI388_verifyBrainTreeDiscoverCard Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
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

		// Verify Credit Card, Expiry Date, CVV fields are displayed
		VerificationHandler.verifyTrue(paymentsPage.verifyCardFirlds());

		// Enter "4" as Credit card number verify if Discover icon is displayed
		paymentsPage.enterCreditCardNo("64");
		log(logger, "64");

		// Verify if Visa icon is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".payment-method-icon.discover").isDisplayed());

		// Clear Credit card number field
		paymentsPage.clearCreditCardfield();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");

		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");

		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage.verifyOrderSummaryPage(
						PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		// Verify Order Summary Page (Description, Assessment name ,Tax Amount,
		// Total, Student Name, Name on Credit Card, Date and Time Paid,
		// Institution)
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderSummaryPageAllFields());

		logger.info("NewATI388_verifyBrainTreeDiscoverCard End");
	}

	/**
	 * Verify that Brain Tree identifies American Express Card successfully
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 4, description = "NewATI-379:Verify that BrainTree identifies Amex Cards successfully")
	public void NewATI379_verifyBrainTreeAmexCard() throws Exception {
		logger.info("NewATI379_verifyBrainTreeAmexCard Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
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

		// Verify Credit Card, Expiry Date, CVV fields are displayed
		VerificationHandler.verifyTrue(paymentsPage.verifyCardFirlds());

		// Enter "4" as Credit card number verify if Master Card icon is
		// displayed
		paymentsPage.enterCreditCardNo("37");
		log(logger, "37");

		// Verify if Visa icon is displayed
		VerificationHandler.verifyTrue(
				basehandler.findElement("span[class='payment-method-icon american-express']").isDisplayed());

		// Clear Credit card number field
		paymentsPage.clearCreditCardfield();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmexcreditcardNoInput"));
		log(logger, "Entering Card No");

		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv("1234");
		log(logger, "Entering Card CVV No");

		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");

		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage.verifyOrderSummaryPage(
						PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		// Verify Order Summary Page (Description, Assessment name ,Tax Amount,
		// Total, Student Name, Name on Credit Card, Date and Time Paid,
		// Institution)
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderSummaryPageAllFields());

		logger.info("NewATI379_verifyBrainTreeAmexCard End");
	}

	/**
	 * Verify that Brain Tree identifies American Express Card successfully
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 5, description = "NewATI-389:Verification for Fraud or Invalid card while making payment")
	public void NewATI389_verifyFraudInvalidCard() throws Exception {
		logger.info("NewATI389_verifyFraudInvalidCard Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Self Pay PWD");

		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
				"Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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

		// Verify Credit Card, Expiry Date, CVV fields are displayed
		VerificationHandler.verifyTrue(paymentsPage.verifyCardFirlds());

		// Enter Fraud/Invalid Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.fraud.creditcardNoInput"));
		log(logger, "Entering Card No");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		log(logger, "Entering Card Exp Date");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Error message
		//VerificationHandler.verifyTrue(basehandler.findElement("div[data-atiid='creditcardAuthErrorMessage']").isDisplayed());
//		VerificationHandler.verifyTrue(basehandler.findElement(".validation").isDisplayed());
		boolean status=paymentsPage.verifyFradCardErrorMessage("new-atitesting.fraud.card.error.msg.loc","new-atitesting.fraud.card.error.msg");
		VerificationHandler.verifyTrue(status);
		System.out.println(status);
		logger.info("NewATI389_verifyFraudInvalidCard End");
	}

	/**
	 * Verify payment by giving Invalid Billing Address
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 6, description = "NewATI-390:Verify payment by giving Invalid Billing Address")
	public void NewATI390_verifyInvalidBillingAddress() throws Exception {
		logger.info("NewATI390_verifyInvalidBillingAddress Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");

		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
				"Institution Name Exists in Add Product");
		log(logger, "Verifying Institustion Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);

		paymentsPage.enterAdd1CityZip("assadsad", "Bangalore", "asdasd");
		log(logger, "Entering invalid Address1, City and Zip");

		VerificationHandler.verifyTrue(paymentsPage.verifyInvalidAddressErrorMsg());
		log(logger, "Verify if Invalid Address error message is displayed");

		logger.info("NewATI390_verifyInvalidBillingAddress End");
	}

	/**
	 * Verify payment by giving Invalid Shipping Address
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 7, description = "NewATI-390:Verify payment by giving Invalid Shipping Address")
	public void NewATI391_verifyInvalidShippingAddress() throws Exception {
		logger.info("NewATI391_verifyInvalidShippingAddress Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		paymentsPage
				.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		paymentsPage.enterSelfPayProductPassword(
				PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.pwd"));
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");

		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
				"Institution Name Exists in Add Product");
		log(logger, "Verifying Institustion Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);

		paymentsPage.clickButton("label[for='shippingAddressShow'] span");
		log(logger, "Clicking on same as billing address checkbox");

		paymentsPage.enterShippingInvalidAdd1CityZip("assadsad", "Bangalore", "asdasd");
		log(logger, "Entering invalid Address1, City and Zip");

		VerificationHandler.verifyTrue(paymentsPage.verifyInvalidAddressErrorMsg());
		log(logger, "Verify if Invalid Shipping Address error message is displayed");

		logger.info("NewATI391_verifyInvalidShippingAddress End");
	}

	/**
	 * Verify that case sensitivity removal for class ID
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "NewATI-645:Verify that case sensitivity removal for class ID")
	public void NewATI645_VerifyClassIDCaseSensitivity() throws Exception {

		logger.info("NewATI645_VerifyClassIDCaseSensitivity Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));

		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),
				PropertiesRepository.getString("newati.payment.late.sem.input2"),
				PropertiesRepository.getString("newati.payment.late.class.input2.mixesCase"));

		log(logger, "verifying payment page objects");
		VerificationHandler.verifyTrue(paymentsPage.isPaymentInfoDisplayed(
				PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info")));

		logger.info("NewATI645_VerifyClassIDCaseSensitivity End");

	}

	/**
	 * Verify self pay with extra space in id and password
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-773:verify self pay with extra space in id and password")
	public void NewATI773_verifySelfPayExtraSpaceInIDAndPass() throws Exception {
		log(logger, "NewATI773_verifySelfPayExtraSpaceInIDAndPass Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();

		// Product ID with spaces before and after
		paymentsPage.enterSelfPayProductID("   TUT173611   ");
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");

		// Product Password with spaces at the end
		paymentsPage.enterSelfPayProductPassword("12D5X    ");
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

		paymentsPage.clickOnSubmitOrderBtnteas();
		log(logger, "Click on Submit Button");

		// Verify Order Summary Page
		VerificationHandler.verifyEquals(
				paymentsPage.verifyOrderSummaryPage(
						PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc2")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		paymentsPage.closeOrderSummaryPage();

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Info Icon for Specific Module");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.self.pay.product.name"));

		log(logger, "Verifying the added Product");
		learnTabPage
				.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.visa.id.value"));

		log(logger, "NewATI773_verifySelfPayExtraSpaceInIDAndPass End");

	}

	/**
	 * Verify Purchase History Section
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "NewATI-99:Verify Purchase History Section")
	public void NewATI99_VerifyPurchaseHistorySec() throws Exception {

		logger.info("NewATI99_VerifyPurchaseHistorySec Start");

		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		// Steep 3
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "Verify page title");
		VerificationHandler.verifyTrue(driver.getTitle().equals("My Profile - My Account - ATI Testing"));

		log(logger, "Verify if My Profile Tab is selected by default");
		VerificationHandler
				.verifyTrue(basehandler.findElement("#tabs nav ul li").getAttribute("aria-selected").equals("true"));

		// Steep 4
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));

		log(logger, "Verify if My Purchase and Payments tab is selected");
		VerificationHandler.verifyTrue(basehandler.findElement("#tabs-2").getAttribute("aria-hidden").equals("false"));

		// Steep 5
		log(logger, "Verify if Correct Institution name is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#paymentInstitution").getText()
				.equals(PropertiesRepository.getString("new-atitesting.payment.institution.name")));

		// Steep 6
		log(logger, "Payment Code text field, Class text field and Submit Button is displayed");
		VerificationHandler.verifyTrue(basehandler
				.findElement(
						".semester-payment-input div input[data-bind='value: OrderPayment.PaymentCode, highlightIfEmpty: { }']")
				.isDisplayed()
				&& basehandler
						.findElement(
								".semester-payment-input div input[data-bind='value: OrderPayment.ClassCode, highlightIfEmpty: { }']")
						.isDisplayed()
				&& basehandler.findElement(".semester-payment-input div[class='semester-payment-submit'] a")
						.isDisplayed());
		// Steep 7
		log(logger, "Verify message displayed under 'Purchase history' section");
		VerificationHandler.verifyTrue(
				basehandler.findElement(".no-data-available-area").getText().equals("You have not placed any orders"));

		logger.info("NewATI99_VerifyPurchaseHistorySec End");

	}
}
