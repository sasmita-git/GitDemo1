package com.automation.newati.regression.payment.online;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;



public class TEASPracticeTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	WindowHandler windowHandler;
	private PractiseAssessmentPage practiceAssessmentPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		windowHandler=new WindowHandler(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
	}
	
	@Test(priority = 1, description= "Regression  NewATI-337:Verify Payment for Practice Test by using VISA cards")
	public void NewATI337_verifyPracticePaymentviaVISACard() throws Exception {
		logger.info("NewATI337_verifyPracticePaymentviaVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI337_verifyPracticePaymentviaVISACard End");
		
	}
	
	@Test(priority = 2, description= "Regression  NewATI-341:Verify Payment for Practice Test by using MASTER cards")
	public void NewATI341_verifyPracticeTestPaymentviaMasterCard() throws Exception {
		logger.info("NewATI341_verifyPracticeTestPaymentviaMasterCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI341_verifyPracticeTestPaymentviaMasterCard End");
		
	}
	
	@Test(priority = 3, description= "Regression NewATI-343:Verify Payment for Practice Test by using AMEX cards")
	public void NewATI343_verifyPracticeTestPaymentviaAmericanCard() throws Exception {
		logger.info("NewATI343_verifyPracticeTestPaymentviaAmericanCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		logger.info("NewATI343_verifyPracticeTestPaymentviaAmericanCard End");
		
	}
	
	@Test(priority = 4, description= "Regression NewATI-345:Verify Payment for Practice Test by using DISCOVER cards")
	public void NewATI345_verifyPracticeTestPaymentviaDiscoveredCard() throws Exception {
		logger.info("NewATI345_verifyPracticeTestPaymentviaDiscoveredCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("RN Mental Health Online Practice 2013 A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);

		logger.info("NewATI345_verifyPracticeTestPaymentviaDiscoveredCard End");
		
	}
	@Test(priority = 5, description= "Regression  NewATI-347:Verify Payment for TEAS Practice Test by using VISA cards")
	public void NewATI347_verifyTEASPracticeTestUsingVISACard() throws Exception {
		logger.info("NewATI347_verifyTEASPracticeTestUsingVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI347_verifyTEASPracticeTestUsingVISACard End");
		
	}
	
	@Test(priority = 6, description= "Regression NewATI-348:Verify Payment for TEAS Practice Test by using MASTER cards")
	public void NewATI348_verifyTEASPracticeTestUsingMASTERCard() throws Exception {
		logger.info("NewATI348_verifyTEASPracticeTestUsingMASTERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI348_verifyTEASPracticeTestUsingMASTERCard End");
		
	}
	
	@Test(priority = 7, description= "Regression NewATI-349:Verify Payment for TEAS Practice Test by using AMEX cards")
	public void NewATI349_verifyTEASPracticeTestUsingAMEXCard() throws Exception {
		logger.info("NewATI349_verifyTEASPracticeTestUsingAMEXCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI349_verifyTEASPracticeTestUsingAMEXCard End");
		
	}
	
	@Test(priority = 8, description= "Regression NewATI-350:Verify Payment for TEAS Practice Test by using DISCOVER cards")
	public void NewATI350_verifyTEASPracticeTestUsingDISCOVERCard() throws Exception {
		logger.info("NewATI350_verifyTEASPracticeTestUsingDISCOVERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI350_verifyTEASPracticeTestUsingDISCOVERCard End");
		
	}
	
	
	@Test(priority = 9, description= "Regression  NewATI-352:Verify Payment for Tutorial using VISA cards")
	public void NewATI352_verifyPaymentForTutorialUsingVISACard() throws Exception {
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard End");
		
	}
	
	@Test(priority = 10, description= "Regression NewATI-363:Verify Payment for EBook using MASTER cards")
	public void NewATI353_verifyPaymentForTutorialUsingMASTERCard() throws Exception {
		logger.info("NewATI353_verifyPaymentForTutorialUsingMASTERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI353_verifyPaymentForTutorialUsingMASTERCard End");
		
	}
	
	@Test(priority = 11, description= "Regression NewATI-355:Verify Payment for Tutorial using AMEX cards")
	public void NewATI355_verifyPaymentForTutorialUsingAMEXCard() throws Exception {
		logger.info("NewATI355_verifyPaymentForTutorialUsingAMEXCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI355_verifyPaymentForTutorialUsingAMEXCard End");
		
	}
	
	@Test(priority = 12, description= "Regression NewATI-356:Verify Payment for Tutorial using DISCOVER cards")
	public void NewATI356_verifyPaymentForTutorialUsingDISCOVERCard() throws Exception {
		logger.info("NewATI356_verifyPaymentForTutorialUsingDISCOVERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI356_verifyPaymentForTutorialUsingDISCOVERCard End");
		
	}
	
	@Test(priority = 13, description= "Regression  NewATI-360:Verify Payment for EBook using VISA cards")
	public void NewATI360_verifyPaymentForEBookUsingVISACard() throws Exception {
		logger.info("NewATI360_verifyPaymentForEBookUsingVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI360_verifyPaymentForEBookUsingVISACard End");
		
	}
	
	@Test(priority = 14, description= "Regression NewATI-363:Verify Payment for EBook using MASTER cards")
	public void NewATI363_verifyPaymentForEBookUsingMASTERCard() throws Exception {
		logger.info("NewATI363_verifyPaymentForEBookUsingMASTERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.MastercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.MastercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.MastercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI363_verifyPaymentForEBookUsingMASTERCard End");
		
	}
	
	@Test(priority = 15, description= "Regression NewATI-364:Verify Payment for EBook using AMEX cards")
	public void NewATI364_verifyPaymentForEBookUsingAMEXCard() throws Exception {
		logger.info("NewATI364_verifyPaymentForEBookUsingAMEXCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.AmxcreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.AmxcreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI364_verifyPaymentForEBookUsingAMEXCard End");
		
	}
	
	@Test(priority = 16, description= "Regression NewATI-365:Verify Payment for EBook using DISCOVER cards")
	public void NewATI365_verifyPaymentForEBookUsingDISCOVERCard() throws Exception {
		logger.info("NewATI365_verifyPaymentForEBookUsingDISCOVERCard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Learning Strategies: Your Guide to Classroom and Test-Taking Success","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
					
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.discovercreditcardNoInput"));
		
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.discovercreditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.discovercreditcardCVVUInput"));
		
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI365_verifyPaymentForEBookUsingDISCOVERCard End");
		
	}
	
	@Test(priority = 17, description= "Regression  NewATI-384:Verify if purchased product(Pharmacology Made Easy 3.0) is available under My ATI tab")
	public void NewATI384_verifyPaymentForTutorialUsingVISACard() throws Exception {
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Pharmacology Made Easy 3.0","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI352_verifyPaymentForTutorialUsingVISACard End");
		
	}
	
	@Test(priority = 18, description= "Regression  NewATI-382:VERIFY if purchased product(Dosage & Calculations and Safe Medication) is available under My ATI tab")
	public void NewATI382_verifySafeMedicationviaVISACard() throws Exception {
		logger.info("NewATI382_verifySafeMedicationviaVISACard Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("Online Practice Assessments","new-atitesting.online.store.leftpanel.assessment.name");
		
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Dosage & Calculations and Safe Medication Administration 2.0 - Dimensional Analysis Method","new-atitesting.online.store.assessment.name");
		
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		
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
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		
		logger.info("NewATI382_verifySafeMedicationviaVISACard End");
		
	}
	@Test(priority = 19, description= "NewATI-383:Verify if purchased product(TEAS V) is available under My ATI tab")
	public void NewATI383_verifyPurchasedProductMyATITab() throws Exception {
		logger.info("NewATI383_verifyPurchasedProductMyATITab Start");
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
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.self.assessment.uname"), PropertiesRepository.getString("newati.login.teas.self.assessment.pwd"));
		
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("TEAS® Products","new-atitesting.online.store.leftpanel.assessment.name");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("TEAS V Online Practice Assessment Form A","new-atitesting.online.store.assessment.name");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on mypurchase and payments tab");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.tab.loc"));

		log(logger, "Verify if order id is generated for the purchases assessment");
		VerificationHandler.verifyTrue(tutorialPage.VerifyifOrderIDGenerated("TEAS V Online Practice Assessment Form A"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if assessment is present in test tab");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyAssessmentAddedOnlinestore(PropertiesRepository.getString("new-atitesting.onlinestore.test.TEAS.name")));
		
		logger.info("NewATI383_verifyPurchasedProductMyATITab End");
		
	}
}
