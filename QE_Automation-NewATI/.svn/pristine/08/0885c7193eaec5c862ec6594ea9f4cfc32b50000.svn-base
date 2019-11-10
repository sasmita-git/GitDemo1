package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;

public class PaymentRegression2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private HomePage homePage;
	private BaseHandler basehandler;
	private CreateAccountPage accountPage;
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
		paymentsPage = new PaymentsPage(driver);
		homePage = new HomePage(driver);
		basehandler = new BaseHandler(driver);
		accountPage = new CreateAccountPage(driver);
		windowHandler = new WindowHandler(driver);

//		if (count == 0) {
//			userId = userCreationUtils.getUserDetails();
//			count++;
//		}
//		if (userId==null) {
//			logger.info("Recreation of user started ");
//			userId = userCreationUtils.getUserDetails();
//		}
//		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
//		
//		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	}

	/**
	 * Verify of payment on clicking "Refresh and Back" button when Payment is
	 * in progress.
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-375:Verify of payment on clicking 'Refresh and Back' button when Payment is in progress.")
	public void NewATI375_verifyRefreshAndBack() throws Exception {
		log(logger, "NewATI375_verifyRefreshAndBack Start");
		if (count == 0) {
		userId = userCreationUtils.getUserDetails();
		count++;
	}
	if (userId==null) {
		logger.info("Recreation of user started ");
		userId = userCreationUtils.getUserDetails();
	}
	loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
	

		log(logger, "Click on AddProduct Button");
		paymentsPage.clickOnAddProductButton();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Product ID
		paymentsPage.enterSelfPayProductID("TUT173611");
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay ID");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Product Password
		paymentsPage.enterSelfPayProductPassword("12D5X");
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Entering Self Pay PWD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNameExists2(),
				"Institution Name Exists in Add Product");
		log(logger, "Verifying Institution Name Exists");

		VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionExists2(), "Description Exists in Add Product");
		log(logger, "Verifying Description Exists");

		paymentsPage.clickOnAddProductContinueButton(false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.checkShippingAddressCheckBox();
		log(logger, "Checking shipping address check box");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterShippingEmailId();
		log(logger, "Entering Email ID in Shipping address");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterShippingPhoneNo();
		log(logger, "Entering Phone number in Shipping address");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Credit Card Details Page
		VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true),
				PropertiesRepository.getString("new-atitesting.creditCardDetailsInput"),
				"Unable to verify Credit card details dialogue");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Credit Card Details Page Description section
		VerificationHandler.verifyEquals(basehandler
				.findElement(
						"div[data-bind='visible: IsOrderDetailsVisible'] .custom-table.order-detail-table tbody tr th")
				.getText(), "Description", "Unable to verify Description section");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.switchToBrainTree();

		// Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		log(logger, "Entering Card No");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.enterCreditCardExpirationDate(
				PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Card Exp Date");

		paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click Submit with refresh page
		paymentsPage.clickOnSubmitOrderBtnteasWithRefresh();
		log(logger, "Click on Submit Button with refresh");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if order id is generated for the purchases assessment");
		tutorialPage.VerifyifOrderIDGenerated("Pharmacology Made Easy 3.0");

		log(logger, "NewATI375_verifyRefreshAndBack End");

	}

	/**
	 * Verify that user can update address filed
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-757:Edit profile: Verify that user can update address filed")
	public void NewATI757_verifyEditAddrField() throws Exception {
		log(logger, "NewATI757_verifyEditAddrField Start");
		String newEmail;
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		accountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify page title");
		VerificationHandler.verifyTrue(driver.getTitle().equals("My Profile - My Account - ATI Testing"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Edit Address");
		accountPage.editAddress();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Edit Email");
		newEmail = accountPage.editEmail();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Edit Password");
		accountPage.editPassword();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Address is updated");
		VerificationHandler.verifyTrue(driver.findElement(By.cssSelector("span[data-atiid='address2Value']")).getText()
				.equals(PropertiesRepository.getString("new-atitesting.edit.add2.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Email is updated");
		VerificationHandler.verifyTrue(
				driver.findElement(By.cssSelector("span[data-atiid='emailValue']")).getText().equals(newEmail));

		log(logger, "NewATI757_verifyEditAddrField End");

	}

	/**
	 * Verify that user can update address filed
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-768:Verify that security question will display on edit profile page.")
	public void NewATI768_verifyIfSecurityQuesAndAnswersDisplayed() throws Exception {
		log(logger, "NewATI768_verifyIfSecurityQuesAndAnswersDisplayed Start");
		logger.info("NewATI768_verifyIfSecurityQuesAndAnswersDisplayed Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "Verify if Security Questions are Displayed");
		VerificationHandler.verifyTrue(accountPage.verifyIfSecurityQuestionsDisplayed());

		log(logger, "Verify if Security Question Answer's are Displayed");
		VerificationHandler.verifyTrue(accountPage.verifyIfSecurityQuestionsAnswersDisplayed());
		
		logger.info("NewATI768_verifyIfSecurityQuesAndAnswersDisplayed End");
		log(logger, "NewATI768_verifyIfSecurityQuesAndAnswersDisplayed End");

	}

	/**
	 * Verify TEAS Transcript purchase by using VISA card Steep 12 onwards not
	 * implemented as its not in scope
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-366:Verify TEAS Transcript purchase by using VISA card")
	public void NewATI366_verifyTEASPurchaseVisa() throws Exception {
		log(logger, "NewATI366_verifyTEASPurchaseVisa Start");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

//		log(logger, "click on signout button");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS / Discover Transcript",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select institution");
		tutorialPage.selectFirstInstitution();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		// steep 9

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeMain();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if informative message is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement(".Agreement>table>tbody>tr>td>p").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeNext();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if brain tree is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#container").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));

		log(logger, "Entering Visa Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));

		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			/*String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));*/

			paymentsPage.clickOnOrderLink();
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

			log(logger, "Verify Order Details Header");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			log(logger, "NewATI366_verifyTEASPurchaseVisa End");
		}
	}

	/**
	 * Verify TEAS Transcript purchase by using Master card Steep 12 onwards not
	 * implemented as its not in scope
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-367:Verify TEAS Transcript purchase by using MASTER card")
	public void NewATI367_verifyTEASPurchaseMaster() throws Exception {
		log(logger, "NewATI367_verifyTEASPurchaseMaster Start");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

//		log(logger, "click on signout button");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.payment.pwd"));

		String mainWindowHandler = paymentsPage.getWindowHandler();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS / Discover Transcript",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select institution");
		tutorialPage.selectFirstInstitution();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		// steep 9

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeMain();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if informative message is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement(".Agreement>table>tbody>tr>td>p").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeNext();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if brain tree is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#container").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Master Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering AMEx Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage
				.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			/*String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));*/

			paymentsPage.clickOnOrderLink();

			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

			log(logger, "Verify Order Details Header");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			log(logger, "NewATI367_verifyTEASPurchaseMaster End");
		}
	}

	/**
	 * Verify TEAS Transcript purchase by using AMEX card Steep 12 onwards not
	 * implemented as its not in scope
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-368:Verify TEAS Transcript purchase by using AMEX card")
	public void NewATI368_verifyTEASPurchaseAMEX() throws Exception {
		log(logger, "NewATI368_verifyTEASPurchaseAMEX Start");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

//		log(logger, "click on signout button");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS / Discover Transcript",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select institution");
		tutorialPage.selectFirstInstitution();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		// steep 9

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeMain();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if informative message is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement(".Agreement>table>tbody>tr>td>p").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeNext();

		log(logger, "Verify if brain tree is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#container").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Master Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			/*String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));*/

			paymentsPage.clickOnOrderLink();

			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

			log(logger, "Verify Order Details Header");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			log(logger, "NewATI368_verifyTEASPurchaseAMEX End");
		}
	}

	/**
	 * Verify TEAS Transcript purchase by using Discover card Steep 12 onwards
	 * not implemented as its not in scope
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-369:Verify TEAS Transcript purchase by using DISCOVER card")
	public void NewATI369_verifyTEASPurchaseDiscover() throws Exception {
		log(logger, "NewATI369_verifyTEASPurchaseDiscover Start");

//		JavascriptExecutor jse = (JavascriptExecutor) driver;

//		log(logger, "click on signout button");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS / Discover Transcript",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select institution");
		tutorialPage.selectFirstInstitution();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		// steep 9

		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeMain();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if informative message is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement(".Agreement>table>tbody>tr>td>p").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeNext();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if brain tree is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#container").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Master Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage
				.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			/*String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));
*/
			paymentsPage.clickOnOrderLink();

			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

			log(logger, "Verify Order Details Header");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");

			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			log(logger, "NewATI369_verifyTEASPurchaseDiscover End");
		}
	}

	/**
	 * Verify Purchasing multiple products via Online store in single payment
	 * Steep 12 onwards not implemented as its not in scope
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-378:Verify Purchasing multiple products via Online store in single payment")
	public void NewATI378_verifyMultiplePurchaseInSinglePayment() throws Exception {
		log(logger, "NewATI378_verifyMultiplePurchaseInSinglePayment Start");

		log(logger, "NewATI369_verifyTEASPurchaseDiscover Start");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		log(logger, "click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		String mainWindowHandler = paymentsPage.getWindowHandler();

		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Adding Multiple Assessments to Cart
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on continue shopping button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.continueShopping"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Achieve™", "new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on continue shopping button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.continueShopping"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Active Stack - Pharmacology Flash Cards",
				"new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Steep 5
		// Verify if Secure Checkout page is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".ContentContainer>div>h1").isDisplayed());

		// Verify if Billing Address Form is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".Form").isDisplayed());

		// Verify if Shipping Address is same as Billing check box is displayed
		VerificationHandler.verifyTrue(basehandler
				.findElement("#ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxAddress_chkSameAsBilling").isDisplayed());

		// Steep 6
		// Verify if Student Address is present
		VerificationHandler.verifyTrue(
				basehandler.findElement("#ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxAddress_txtBillingStreet1")
						.getText() != null);

		// Verify if Shipping Address is same as Billing check box is checked
		VerificationHandler.verifyTrue(basehandler
				.findElement("#ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxAddress_chkSameAsBilling").isSelected());

		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc",
				"new-atitesting.online.store.assessments.state.info", 0);

		log(logger, "click on continue button");
		tutorialPage
				.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verify if Enter Your Payment Details Section is displayed
		VerificationHandler.verifyTrue(basehandler.findElement(".Active").isDisplayed());

		// Verify if Verbiage is not displayed
		VerificationHandler.verifyTrue(
				!(driver.getPageSource().contains(PropertiesRepository.getString("new-atitesting.Verbiage"))));

		// Verify Item, Quantity , Price and Total are present. here we are
		// checking if the rows ist and the second rows are present
		VerificationHandler.verifyTrue(basehandler.findElement(".Grid tr[class='Header']").isDisplayed()
				&& basehandler.findElement(".Grid tr[class='Row']").isDisplayed());

		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		// Steep 7
		log(logger, "Switch to Main Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeMain();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if informative message is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement(".Agreement>table>tbody>tr>td>p").isDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Switch to Next Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTreeNext();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if brain tree is displayed");
		VerificationHandler.verifyTrue(basehandler.findElement("#container").isDisplayed());

		log(logger, "Entering Master Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");

		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository
				.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));

		log(logger, "click on submit order button");
		tutorialPage.clickButton(
				PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Verify Purchased assessments under My ATI Tab
		log(logger, "Verify Purchased assessments under My ATI Learn Tab");
		VerificationHandler.verifyTrue(tutorialPage.verifyPurchasesAssessmentInLearnTab("Pharmacology Made Easy 3.0",
				"Achieve", "Active Stack - Pharmacology Flash Cards"));

		// verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),
				PropertiesRepository.getString("new-atitesting.userAccountInpt"), "Unable to verify My Account link");

		// Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),
				"Unable to verify My Purchase and Payments tab");

		if (!paymentsPage.verifyNoDataAvailable()
				.equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))) {

			String orderNo = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.no.loc"));
			String date = paymentsPage
					.getOrderNo(PropertiesRepository.getString("new-atitesting.order.history.order.date.loc"));
			/*String itemPurchased = paymentsPage.getOrderNo(
					PropertiesRepository.getString("new-atitesting.order.history.order.item.purchased.loc"));*/
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.clickOnOrderLink();
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			paymentsPage.verifyOrderDetails(PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc"),
					PropertiesRepository.getString("new-atitesting.order.history.order.details.page.header.value"));

			log(logger, "Verify Order Details Header");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.no.loc"), orderNo),
					"Unable to verify Order No");
			log(logger, "Verify Order Details Order No");
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			VerificationHandler.verifyTrue(paymentsPage.verifyOrderDetails(
					PropertiesRepository.getString("new-atitesting.order.history.order.details.order.date.loc"), date),
					"Unable to verify Order Date");
			log(logger, "Verify Order Details Order Date");

			log(logger, "NewATI378_verifyMultiplePurchaseInSinglePayment End");
		}

	}
}
