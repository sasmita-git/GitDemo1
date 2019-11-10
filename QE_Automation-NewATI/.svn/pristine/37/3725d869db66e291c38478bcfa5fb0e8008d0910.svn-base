package com.automation.newati.payments;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class VerifySelfPayAssessmentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver);
	}
	
	
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-313:Verify Bookstore Semester Payment flow")
	public void NewATI313_VerifyBookstoreSemesterPaymentFlow() throws Exception {
		log(logger,"NewATI313_VerifyBookstoreSemesterPaymentFlow Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname"), PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		log(logger, "entering payment code");
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.login.payment.uname.payment.code"),PropertiesRepository.getString("newati.login.payment.class.code"));
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.continue.button.loc"));
		
		//coupon code data is not given
		paymentsPage.enterCouponCode("newati.login.payment.coupon.code.input");
		 
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.continue.button.loc"));
		
		log(logger, "verifying purchase page objects");
		boolean status=paymentsPage.verifypurchasePageObjectPresence("newati.payment.purchase.details.page");
		VerificationHandler.verifyTrue(status);
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.submit.button.loc"));
		
		boolean result1=paymentsPage.verifyingOrderSummaryPage();
		VerificationHandler.verifyTrue(result1);
		
		boolean result2=paymentsPage.verifyingOrderSummaryPageObjects();
		VerificationHandler.verifyTrue(result2);
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",1);
		
		log(logger, "click on order link");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.history.table.loc",0);
		
		boolean result3=paymentsPage.verifyOrderDetails("newati.payment.mypurchase.order.details");
		VerificationHandler.verifyTrue(result3);
		log(logger,"NewATI313_VerifyBookstoreSemesterPaymentFlow End");
	}
	
	@TestAnnotations(testID="NewATI-344")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify On-time Semester Payment Visa card with same billing address::SEMESTER Payment")
	public void NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard() throws Exception {
		log(logger,"NewATI344_VerifyOnTimeSemesterPaymentUsingVisaCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname"), PropertiesRepository.getString("newati.login.payment.ontime.sem.pwd"));
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
	
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-320:Verify Late Semester Payment using Visa card with same billing address ")
	public void NewATI320_VerifyLateSemPaymForSameBillingAddress() throws Exception {

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname"), PropertiesRepository.getString("newati.login.payment.ontime.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.late.sem.input2"),PropertiesRepository.getString("newati.payment.late.class.input2"));
		
		log(logger, "verifying payment page objects");
		boolean result=paymentsPage.isPaymentInfoDisplayed(PropertiesRepository.getString("newati.payment.mypurchase.class.payment.info"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.continue.button.loc", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButtonFromList("newati.payment.ontime.semester.continue.button", 0);

		log(logger, "verify Address Information Page");
		boolean result1=paymentsPage.verifyAddressInformationPage();
		VerificationHandler.verifyTrue(result1);
		
		/*log(logger, "Enter the shipping details");
		paymentsPage.enterShippingAddressDetails();*/
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
		
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		
		log(logger, "switch to frames");
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButtonWithSwitchToDefault(".step-modal-nav input" , 0);

		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
	}
	
	
	//@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-324:Verify Individual Semester Payment using Visa card with shipping tax ")
	public void NewATI324_VerifyLateSemPaymForSameBillingAddress() throws Exception {

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.individual.sem.uname"), PropertiesRepository.getString("newati.login.payment.individual.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		
		paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.individual.sem.input2"),PropertiesRepository.getString("newati.payment.individual.class.input2"));
		
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
		
		log(logger, "Enter the shipping details");
		paymentsPage.enterShippingAddressDetails();
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
		
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		
		log(logger, "switch to frames");
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");

		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc")),
			PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
	}
	
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-332:Verify Self Pay Tutorial payment using a Visa card.")
	public void NewATI332_VerifySelPayTutorialPaymentUsingaVisaCard() throws Exception {
		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.sem.uname"), PropertiesRepository.getString("newati.login.selfpay.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Self Pay ID");
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.master.id.value.new"));
		paymentsPage.clickOnAddProductContinueButton(false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Self Pay PWD");
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.master.pwd.value.new"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.clickOnAddProductContinueButton(false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Institution Name Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists(), "Institution Name Exists in Add Product");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Description Exists");
		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists(), "Description Exists in Add Product");
		paymentsPage.clickOnAddProductContinueButton(false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the shipping details");
		paymentsPage.enterShippingAddressDetails();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.ontime.semester.continue.button"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Enter the card details");
		paymentsPage.enterCardDetails();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "switch to frames");
		windowHandler.switchToLatestWindow();
		windowHandler.switchToFrame("paymentFrame");
		
		log(logger, "click on submit button");
		tutorialPage.clickButton(".step-modal-nav input");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Order Summary Page");
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc")),
			PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
		
	}
	
	@TestAnnotations(testID="NewATI-100")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify Order Link Under Purchase History Section.::General")
	public void NewATI100_VerifyOrderLinkUnderHistorySection() throws Exception {

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.selfpay.sem.uname.orderhistory"),
				PropertiesRepository.getString("newati.login.selfpay.sem.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));

		log(logger, "click on order link");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.history.table.loc",0);
		
		String orderNo = paymentsPage.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
		String date = paymentsPage.getOrderNoDetails(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));

		log(logger, "Verify Order Details Header");
		paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
				PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

		log(logger, "Verify Order Details Order No");
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
				"Unable to verify Order No");

		log(logger, "Verify Order Details Order Date");
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
				"Unable to verify Order Date");

		paymentsPage.verifyOrderDetailsExists(
				PropertiesRepository.getString("new-atitesting.order.history.order.details.account.no.loc"));
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(PropertiesRepository
								.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
				"Unable to verify Order No");
		log(logger, "Verify Order Details Order No");
	}
}
