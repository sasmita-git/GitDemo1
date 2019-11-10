package com.automation.newati.payments;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class TutorialPaymentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private PaymentsPage paymentsPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		paymentsPage=new PaymentsPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-352")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description= "Verify Payment for Tutorial using VISA cards::ONLINE STORE Purchase")
	public void NewATI352_VerifyTutorialPaymentVISA() throws Exception {
		logger.info("NewATI352_VerifyTutorialPaymentVISA Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
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
	@TestAnnotations(testID="NewATI-526")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-526:Verification for Select Instance of Semester payment required Class products")
	public void NewATI526_DisabledFunctionalitySemesterpayment() throws Exception {
		logger.info("NewATI526_DisabledFunctionalitySemesterpayment Start");
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.Disabled.Semester.payment.products.user"), PropertiesRepository.getString("newati.login.user.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select tutorial from drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value1"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify product disabled message");
		VerificationHandler.verifyTrue(tutorialPage.verifyDisabledMessageSemesterPay());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select product with instance");
		tutorialPage.clickModuleButtonByNameSelectInstance(PropertiesRepository.getString("new-atitesting.cdn.selfpay.Tutorial.tab.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify product disabled message");
//		VerificationHandler.verifyTrue(tutorialPage.verifyDisabledMessageSemesterPayInstances());
		log(logger, "NewATI526_DisabledFunctionalitySemesterpayment End");
	}
}
