package com.automation.newati.smoke;

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
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest8Prod extends BaseTest {
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
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.MaintanacePopUp();
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
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
	
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
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					log(logger, "Click on AddProduct Button");
					paymentsPage.clickOnAddProductButton();
					myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					log(logger, "Entering Self Pay ID");
					paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.non.teas.selfpay.american.without.tax.id.value1.prod"));
					
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

					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					windowHandler.switchToLatestWindow();
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
					Thread.sleep(50000);
					log(logger, "click on close button");
					tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
					// Step 2 Start
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					log(logger, "Clicking on HomeTab");
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					homePage.clickTab(0);
					
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					log(logger, "Click on AddProduct Button");
					paymentsPage.clickOnAddProductButton();
					// Step 2 End
					
					// Step 3 & 4 Start
					log(logger, "Entering Self Pay ID");
					paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.id.value.prod"));
					paymentsPage.clickOnAddProductContinueButton(false);
					
					log(logger, "Entering Self Pay PWD");
					paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.selfpay.tutorial.amex.with.tax.pwd.value.prod"));
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
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					
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
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					windowHandler.switchToLatestWindow();
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
					Thread.sleep(50000);
					log(logger, "click on close button");
					tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button",0);
					homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					log(logger,"click on  account link");
					tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
					
					log(logger, "click on mypurchase and payments tab");
					tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));
					paymentsPage.enterPaymentCode(PropertiesRepository.getString("newati.payment.mypurchase.input.loc"),PropertiesRepository.getString("newati.payment.late.sem.input2.prod"),PropertiesRepository.getString("newati.payment.late.class.input2.prod"));
					
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

					logger.info("NewATI858_VerifyPaymentFlowForOnlineStoreIndividualPaymentSemesterPayment");
		}
		}

	





