package com.automation.newati.payments;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class VerifyTEASSelfPayAssessment extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private BaseHandler basehandler;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		basehandler=new BaseHandler(driver);
	}
	
	

	
	/**
	 * Step 10, 12 & 13 DB Verification. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="NewATI-301:Verify (TEAS) Self Pay Assessment Payment using a Visa Card without shipping tax")
	public void NewATI301_VerifyTEASSelfPayVisaCard() throws Exception {
		logger.info("NewATI301_VerifyTEASSelfPayVisaCard Start");
		
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
						PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")),
				PropertiesRepository.getString("new-atitesting.orderSummaryheaderInput"),
				"Unable to verify Address Info dialogue");

		// Verify Order Summary Page (Description, Assessment name ,Tax Amount,
		// Total, Student Name, Name on Credit Card, Date and Time Paid,
		// Institution)
		VerificationHandler.verifyTrue(paymentsPage.verifyOrderSummaryPageAllFields());
		logger.info("NewATI301_VerifyTEASSelfPayVisaCard End");
	}
	
	
	/**
	 * Step 10, 12 & 13 DB Verification 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-357")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="Verify that user can successfully make payment for TEAS Share Results using Visa Card::SELF Pay")
	public void NewATI357_VerifyTEASShareResults() throws Exception {
		logger.info("NewATI357_VerifyTEASShareResults Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"click on my results tab");
		homePage.clickTab(2);
		
		//tutorialPage.clickButtonFromList("newati.payment.myresults.share.results.loc", 0);
	     basehandler.findElement(".custom-table>tbody>tr:nth-child(6)>td>a>span").click();
	     myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		paymentsPage.selectAvailableInstitutions();
		
		paymentsPage.clickDownArrow();
		
		paymentsPage.checkSelectedInstitutions();
		
		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.clickOnAddProductContinueButton(false);
		// Step 5 End

		paymentsPage.clickOnAddProductContinueButton(false);
		
		paymentsPage.switchToBrainTree();
		
		//Enter Credit card number
		paymentsPage.enterCreditCardNo(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardNoInput"));
		log(logger, "Entering Card No");
		
	    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardExpInput"));
	    log(logger, "Entering Card Exp Date");

	    paymentsPage.enterCreditCardCvv(PropertiesRepository
					.getString("new-atitesting.AmxcreditcardCVVUInput"));
		log(logger, "Entering Card CVV No");
		
		// NEED TO UNcomment this code when running in Stage Environment
		/*paymentsPage.clickOnSubmitOrderBtn();
		log(logger, "Click on Submit Button");
		// Step 8 End
		
		// Step 9 Start
		//Verify Order Summary Page	
		VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
				PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc")), PropertiesRepository
				.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");

		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
		
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository
				.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
				
		//Verify Payments tab
		VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
		// Step 9 End
		
		// Step 11 Start
		if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository
					.getString("new-atitesting.purchase.history.noDataInput"))){
					
		//verify MyAccount link
		VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
					.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					
		VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					
		}
		else{
			throw new SkipException("No data available, You have not placed any orders");
		}*/
		// Step 11 End
		logger.info("NewATI357_VerifyTEASShareResults End");
	}
	
}
