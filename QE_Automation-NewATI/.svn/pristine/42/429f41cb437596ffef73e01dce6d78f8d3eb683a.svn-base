package com.automation.newati.payament;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
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

public class PaymentTest22 extends BaseTest {

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
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-385:Verify one products Purchase with 100% discount Coupon Code")
	public void NewATI385_VerifyOneProductPurchaseWithCouponCode() throws Exception 
	{
		log(logger,"NewATI385_VerifyOneProductPurchaseWithCouponCode Start");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickLinkOnLeftSideOnlineStore(PropertiesRepository.getString("new-atitesting.online.store.pnproducts.practice.assessment.link"));

		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("PN Mental Health Online Practice 2014 Form A","new-atitesting.online.store.assessment.name");

		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));

		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		log(logger, "Enter and apply coupon code");
		paymentsPage.enterAndApplyCouponCodeOnlineStore();
		
		log(logger, "Verify that the total amount is zero after applying coupon");
		VerificationHandler.verifyTrue(paymentsPage.verifyExpectedTotalAmountOnlineStoreCheckout(0.0), "Total amount is not zero");
				
		jse.executeScript("window.scrollBy(0,250)", "");
		jse.executeScript("window.scrollBy(0,250)", "");

		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.checkout.braintree.frame"));
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		log(logger, "Navigating to My Purchase & Products tab");
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(),PropertiesRepository.getString("new-atitesting.userAccountInpt"),
				"Unable to verify My Account link");
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
			
		log(logger, "Verifying that order ID is generated");
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
		
		log(logger,"NewATI385_VerifyOneProductPurchaseWithCouponCode End");

	}
	
}

