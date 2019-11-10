package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class VerifySmartPrepRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private WindowHandler windowHandler;
	private PaymentsPage paymentsPage;
	private MyResultsTabPage myResultsTabPage;
	private TextHandler textHandler;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private NclexPrepTabPage nclexPrepTabPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		windowHandler=new WindowHandler(driver);
		paymentsPage=new PaymentsPage(driver);
		textHandler = new TextHandler(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
	}

	@TestAnnotations(testID="NewATI-556")
	 @Test(priority=1,description = "Regression NewATI-556:20170112-12:15:05 Validate smartprep flow: Reading module : pretest = 100%, post test1 = 100%")
	 public void NewATI556_ValidateSmartprepFlowTest() throws Exception {
	  log(logger, "NewATI556_ValidateSmartprepFlowTest Start");
	  
	  loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.flashcard"), PropertiesRepository.getString("newati.login.password"));
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  homePage.clickTab(1);
	  log(logger, "Clicking on My ATI Tab");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Selecting Tutorial from Learn Tab");
	  tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
	 
	  log(logger, "Clicking Module by Name");
	  tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));

	  tutorialPage.clickOnAgreementCheckBox();
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  log(logger, "cliking on the pretest btutton of card back");
	  tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.eng"));
	  
	  windowHandler.switchToFrame("OpenPageFrame");
	  
	  log(logger, "Clicking on Begin Test Button");
	  tutorialPage.clickButton("#startTest");
	  
	  tutorialPage.takeTEASSmartPrep(CommonUtils.readingPreTest(),false,false);
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  log(logger, "Clicking on My Personalized Study plan");
	  tutorialPage.clickButtonByActionClassFromList("new-atitesting.smartprep.study.plan.loc", 0);
	  
	  log(logger, "Clicking on close button");
	  tutorialPage.clickButtonFromList("new-atitesting.smartprep.close.button.loc", 0);
	  
	  log(logger, "Clicking on launch posttest button");
	  tutorialPage.clickOnLaunchPostTestButton();
	  
	  log(logger, "Clicking on Begin Test Button");
	  tutorialPage.clickButton("#startTest");
	  
	  tutorialPage.takeTEASSmartPrep(CommonUtils.readingPostTest(),false,false);
	  
	  log(logger, "verifying close button");
	  windowHandler.switchToMainWindow();
	  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  VerificationHandler.verifyTrue(tutorialPage.verifymoduleButtonasContinue("new-atitesting.vcsLite.begin.btn.loc",0,"CONTINUE MODULE"));
	  log(logger, "click on cardback close button");
	  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	  
	  log(logger, "Clicking Home Tab");
	  homePage.clickTab(0);
	  
	  log(logger, "Launch smart prep from Recent Activity");
	  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.assessment.recent.activity.loc"),0);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Verify element after opening. ");
	  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
	  
	  log(logger, "NewATI556_ValidateSmartprepFlowTest End");
	 }
	@TestAnnotations(testID="NewATI-943")
	@Test(priority=2,groups = {"Regression"},description = "NewATI-943:Verify if online purchased product(Smart prep) can be accessed successfully")
	public void NewATI943_VerifySmartpreponlinestore() throws Exception {
		log(logger, "NewATI943_VerifySmartpreponlinestore Start");
		userId = userCreationUtils.getUserDetails();
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("ATI TEAS SmartPrep Study Package","new-atitesting.online.store.assessment.name");
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
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.smartprep.check.agreement.loc"));
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "cliking on the begin module button of card back");
		tutorialPage.clickSmartPrepCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.eng"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToFrame("OpenPageFrame");
		
		log(logger, "Clicking on Begin Test Button");
		tutorialPage.clickButton("#startTest");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.takeTEASSmartPrep(CommonUtils.readingPreTest(),false,false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying close button");
		windowHandler.switchToMainWindow();
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying smart prep in My Results Page");
		myResultsTabPage.clickSmartPrepModuleByName(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.eng"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying smart prep ipp Page");
		VerificationHandler.verifyTrue(myResultsTabPage.verify_smartprepIPPpage(PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial.section.name.eng")));
		log(logger, "NewATI556_ValidateSmartprepFlowTest End");
	}
	
}
