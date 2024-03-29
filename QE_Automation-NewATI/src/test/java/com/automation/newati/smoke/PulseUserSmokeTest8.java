package com.automation.newati.smoke;

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
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest8 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private WindowHandler windowHandler;
	private HomePage homePage;
	private CreateAccountPageNewSmoke createAccountPage;
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
		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, "Test@1234");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	@TestAnnotations(testID="NewATI-858")	
	@Test(priority = 3, description= "Regression NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment()")
	public void NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment() throws Exception {
		logger.info("NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment");
//		driver.get(PropertiesRepository.getString("newati.login.url"));
//		log(logger, "click on create account link");
//		tutorialPage.clickButtonFromList("new-atitesting.create.account.link.loc", 0);
//		String userName = CommonUtils.getRandomUserName();
//		StringBuilder sbEmail = new StringBuilder(userName);
//		sbEmail.append(PropertiesRepository.getString("new-atitesting.emailInput.539"));
//		log(logger, "Create account start");
//		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName,sbEmail.toString()),PropertiesRepository.getString("new-atitesting.step2.header"),
//				"Unable to complete Step 1 in Create Account");
//		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("new-atitesting.step3.header"),
//				"Unable to complete Step 2 in Create Account");
//		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("new-atitesting.step4.header"),
//				"Unable to complete Step 3 in Create Account");
//		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("new-atitesting.step5.header"),
//				"Unable to complete Step 4 in Create Account");
//		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
//				"Unable to complete Step 5 in Create Account");
//		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("new-atitesting.step7.header"),
//				"Unable to complete Step 6 in Create Account");
//		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(),"Unable to complete Step 7 in Create Account");
//		
//		log(logger, "createAccount method Ends");
//		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
//		VerificationHandler.verifyTrue(createAccountPage.clickOnWelcomeNewAti(),"Add product button is not Enabled");
//		loginPage.MaintanacePopUp();
		String parentWindowHandle = driver.getWindowHandle();
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		for (int i = 0; i <2; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("ATI TEAS SmartPrep Study Package","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		
		jse.executeScript("window.scrollBy(0,250)", "");
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		for (int i = 0; i <3; i++) {
			
			jse.executeScript("window.scrollBy(0,250)", "");
			
		}
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
		// This code should hide for production run
		
		log(logger, "Clicking Check box Agreement");
		 windowHandler.switchToMainWindow();
		  windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
	
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		String curUrl= driver.getCurrentUrl();
		Boolean b=curUrl.startsWith("https://student");
		if(b==false)
		{	
		paymentsPage.verifyPaymentSuccessMessage();
		
		 
		  
		log(logger, "Closing Online Payment window");
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
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				}
				else {
					log(logger, "Closing Online Payment window");
					paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);					
				}
				
					// Step 2 Start
					log(logger, "Clicking on HomeTab");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					homePage.clickTab(0);
					
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					log(logger, "Click on AddProduct Button");
					paymentsPage.clickOnAddProductButton();
					
					log(logger, "Entering Self Pay ID");
					paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.american.without.tax.id.value1"));
					
					log(logger, "Clicking on Add Product Continue Button");
					paymentsPage.clickOnAddProductContinueButton(false);
					
					paymentsPage.clickOnAddProductContinueButton(false);
					
					paymentsPage.selectAvailableInstitutions();
					
					paymentsPage.clickDownArrow();
					
					paymentsPage.checkSelectedInstitutions();
					
					JavascriptExecutor jse1 = (JavascriptExecutor)driver;
					jse1.executeScript("window.scrollBy(0,250)", "");
					jse1.executeScript("window.scrollBy(0,250)", "");
					
					paymentsPage.clickOnAddProductContinueButton(false);
					
					
					
					log(logger, "Verifying Institution Name Exists");
					VerificationHandler.verifyTrue(paymentsPage.verifyInstitutionNamePurchaseDetailsTEAS(), "Institution Name Exists in Add Product");
					
					log(logger, "Verifying Description Exists");
					VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(), "Description Exists in Add Product");
					
					paymentsPage.clickOnAddProductContinueButton(false);

					log(logger, "Checking shipping address check box");
					paymentsPage.checkShippingAddressCheckBox();
					
					jse1.executeScript("window.scrollBy(0,250)", "");
					jse1.executeScript("window.scrollBy(0,250)", "");
					
					paymentsPage.enterShippingEmailId();
					log(logger, "Entering Email ID in Shipping address");
					
					log(logger, "Entering Phone number in Shipping address");
					paymentsPage.enterShippingPhoneNo();
					
					VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
								.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
						
					log(logger, "Verify tax amount");	
					paymentsPage.verifytaxvalueforteas();
					
					log(logger, "switching to frame");
					paymentsPage.switchToBrainTree();
					
					log(logger, "Enter Credit card number");
					paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
					
					 log(logger, "Entering Card Exp Date");
				    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
				   
				    log(logger, "Entering Card CVV No");
				    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.creditcardCVVUInput1"));
					
// not required in production	
				    if(b==false)
					  {
				    log(logger, "Click on Submit Button");
					paymentsPage.clickOnSubmitOrderBtnteas();
					
					VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
							PropertiesRepository.getString("new-atitesting.classInfoHeaderLoc1")), PropertiesRepository
							.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
					
					log(logger, "click on close button");
					tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
					
					log(logger, "click on user account link");
					VerificationHandler.verifyEquals(paymentsPage.clickOnUserAccountLink(), PropertiesRepository.getString("new-atitesting.userAccountInpt"),"Unable to verify My Account link");
							
					log(logger, "click on payment tab");
					VerificationHandler.verifyTrue(paymentsPage.selectPaymentsTab(),"Unable to verify My Purchase and Payments tab");
					
					if(!paymentsPage.verifyNoDataAvailable().equals(PropertiesRepository.getString("new-atitesting.purchase.history.noDataInput"))){
								
						log(logger, "Verify Order link under Mypurchse & Payments tab");	
					VerificationHandler.verifyEquals(paymentsPage.clickOnOrderLink(), PropertiesRepository
								.getString("new-atitesting.purchase.history.orderDetailsTxtInput"),"Unable to verify Order Link Under Purchase History Page");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
					VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					else{
						throw new SkipException("No data available, You have not placed any orders");
					}
					
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					  }
					// Step 2 Start
					log(logger, "Clicking on HomeTab");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					homePage.clickTab(0);
					
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					log(logger, "Click on AddProduct Button");
					paymentsPage.clickOnAddProductButton();
					// Step 2 End
					
					// Step 3 & 4 Start
					log(logger, "Entering Self Pay ID");
					paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value"));
					paymentsPage.clickOnAddProductContinueButton(false);
					
					log(logger, "Entering Self Pay PWD");
					paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value"));
					paymentsPage.clickOnAddProductContinueButton(false);
					
					// Step 3 & 4 End
					
					// Step 5 Start
					VerificationHandler.verifyTrue(paymentsPage.verifyDescriptionPurchaseDetails(), "Description Exists in Add Product");
					log(logger, "Verifying Description Exists");
					
					paymentsPage.clickOnAddProductContinueButton(false);
					
					// Step 5 End

					// Step 6 Start
					paymentsPage.checkShippingAddressCheckBox();
					log(logger, "Checking shipping address check box");
					// Step 6 End
					
					
					jse.executeScript("window.scrollBy(0,250)", "");
					jse.executeScript("window.scrollBy(0,250)", "");
					
					// Step 7 Start
					log(logger, "Clicking Shipping Address Check box");
					paymentsPage.clickButtonFromList("new-atitesting.billing.address.checkbox.loc", 0);
					// Step 7 End
					
					// Step 8 Start
					
					paymentsPage.enterShippingAddress();
					
					VerificationHandler.verifyEquals(paymentsPage.clickOnAddProductContinueButton(true), PropertiesRepository
								.getString("new-atitesting.creditCardDetailsInput"),"Unable to verify Credit card details dialogue");
					
					
					log(logger, "verify tax amount greater than zero");
					paymentsPage.verifytaxvaluegreaterthanzero();
					
					paymentsPage.switchToBrainTree();
					
					//Enter Credit card number
					paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
					log(logger, "Entering Card No");
					
				    paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
				    log(logger, "Entering Card Exp Date");

				    paymentsPage.enterCreditCardCvv(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
					log(logger, "Entering Card CVV No");
					
// This code should hide for production run
					
				    if(b==false)
					{	
					paymentsPage.clickOnSubmitOrderBtnteas();
					log(logger, "Click on Submit Button");
					// Step 8 End
					
					// Step 9 Start
					//Verify Order Summary Page	
					VerificationHandler.verifyEquals(paymentsPage.verifyOrderSummaryPage(
							PropertiesRepository.getString("new-atitesting.selfpay.classInfoHeaderLoc1")), PropertiesRepository
							.getString("new-atitesting.orderSummaryheaderInput"),"Unable to verify Address Info dialogue");
					tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
					
					//paymentsPage.closeOrderSummaryPage();
					
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
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
					VerificationHandler.verifyFalse(paymentsPage.clickOnCloseButton());
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
								
					}
					else{
						throw new SkipException("No data available, You have not placed any orders");
					}
					
					logger.info("NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment");
		}
				}
				else {
					logger.info("NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment");
				}
		  }
		  
		}

	





