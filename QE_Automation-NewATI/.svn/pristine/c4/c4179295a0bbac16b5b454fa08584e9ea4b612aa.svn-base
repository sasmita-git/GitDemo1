package com.automation.newati.board.vitals;

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
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class VerifyBoardVitalsFunctionalityTest3 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;		
	private NclexPrepTabPage nclexPrepTabPage;
	private WindowHandler windowHandler;
	private PaymentsPage paymentsPage;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		tutorialPage=new TutorialPage(driver);
		windowHandler=new WindowHandler(driver);
		paymentsPage=new PaymentsPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-593")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-593:Verify Board vital product added via CDN/Institution Purchase and greater than 30 days of graduation")
	public void NewATI593_VerifyDiabledCardFront() throws Exception {
		logger.info("Method : NewATI593_VerifyDiabledCardFront Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.disabled.login.user.name"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify Sub Tabs");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyDisabledNclex(), "Unable to verify Disabled Test");
		
		logger.info("Method : NewATI593_VerifyDiabledCardFront End");
	}
	
	@TestAnnotations(testID="NewATI-942")
	@Test(priority = 2,alwaysRun = true, enabled = true, groups = {"Regression"}, description ="NewATI-942:Verify if online purchased product(Board vital) can be accessed successfully")
	public void NewATI942_VerifyTheBoardVitalOnlineStore() throws Exception {
		logger.info("Method : NewATI942_VerifyTheBoardVitalOnlineStore Start");
		userId = userCreationUtils.getUserDetails();
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		String mainWindowHandler = paymentsPage.getWindowHandler();
		
		log(logger, "Clicking on Online Store Link");
		paymentsPage.verifyOnlineStoreLink();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on practice assessment on the left side");
		paymentsPage.clickOnPracticeAssessmentOnLeftSide("NCLEX® Review (6)","new-atitesting.online.store.leftpanel.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on  addcart button");
		paymentsPage.selectAssessmentToCheckOut("Board Vitals NCLEX Prep RN","new-atitesting.online.store.assessment.name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on checkout button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.assessment.checkout"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering input for state");
		tutorialPage.enterText("new-atitesting.online.store.assessments.state.loc", "new-atitesting.online.store.assessments.state.info", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.proceed.payment.details.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Program Type");
		paymentsPage.selectProgramType();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Brain Tree");
		paymentsPage.switchToOnlinePaymentBrainTree();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card No");
		paymentsPage.enterCreditCardNo(PropertiesRepository.getString("new-atitesting.creditcardNoInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card Expiration Date");
		paymentsPage.enterCreditCardExpirationDate(PropertiesRepository.getString("new-atitesting.creditcardExpInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Entering Credit Card CVV");
		paymentsPage.enterCreditCardCvvnumber(PropertiesRepository.getString("new-atitesting.AmxcreditcardCVVUInput"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("ctl00_ctl00_MainContent_uxCheckout_uxWizard_uxPayment_BrainTreeIframe");
		
		log(logger, "Clicking Check box Agreement");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on submit order button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Payment Success Message");
		paymentsPage.verifyPaymentSuccessMessage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing Online Store window");
		paymentsPage.closeCurrentOnlinePaymentWindow(mainWindowHandler);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Sub Tabs");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify sub tabs");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on nclex adaptive test link");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.product.links"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Unable to verify element after opening. ");
		VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.close.button")), "Unable to verify element after opening.");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI942_VerifyTheBoardVitalOnlineStore End");
	}
	
}
