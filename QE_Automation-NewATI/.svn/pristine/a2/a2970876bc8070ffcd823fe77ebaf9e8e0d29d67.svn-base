package com.automation.newati.smoke;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest3 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private PaymentsPage paymentsPage;
	private BaseHandler basehandler;
	private MyResultsTabPage myResultsTabPage;
	private MyReportPage myReportPage;
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		paymentsPage=new PaymentsPage(driver);
		basehandler=new BaseHandler(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		myReportPage = new MyReportPage(driver);
		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

	@TestAnnotations(testID="NewATI-412")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Focused review PDF check::Improve Tab")
	public void NewATI412_VerifyFocusedReviewPDFCheck() throws Exception{
		log(logger, "NewATI412_VerifyFocusedReviewPDFCheck Start");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		
		log(logger, "Click on focused review product");
		tutorialPage.startFocusedReview();
		
		log(logger, "Verifying PDF Content");
		VerificationHandler
		.verifyTrue(tutorialPage.verifyImproveTabPDF(), "Unable to verify PDF");
		
		log(logger, "Click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		
	}
	
	@TestAnnotations(testID="NewATI-413")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Focused review Video check::Improve Tab")
	public void NewATI413_VerifyFocusedReviewPDFCheck() throws Exception{
		log(logger, "NewATI413_VerifyFocusedReviewPDFCheck Start");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		
		log(logger, "Click on focused review product");
		tutorialPage.startFocusedReview();
		
		log(logger, "Click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));

		log(logger, "NewATI413_VerifyFocusedReviewPDFCheck End");
	}
	@TestAnnotations(testID="NewATI-357")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="Verify that user can successfully make payment for TEAS Share Results using Visa Card::SELF Pay")
	public void NewATI357_VerifyTEASShareResults() throws Exception {
		logger.info("NewATI357_VerifyTEASShareResults Start");
		
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"), PropertiesRepository.getString("newati.login.password"));
//		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
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
			throw new SkipException("No data available, You have not placed any VerifyPaymentPageorders");
		}*/
		// Step 11 End
		logger.info("NewATI357_VerifyTEASShareResults End");
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
	@TestAnnotations(testID="NewATI-150")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "My Results verification Test Case::My Results")
	public void NewATI150_VerifyResultsPageValidation() throws Exception {
		
		log(logger, "NewATI150_VerifyResultsPageValidation Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.smart.prep.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My RESULTS Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean result=myReportPage.verifyIPPPageSectionHeaders();
		VerificationHandler.verifyTrue(result);
		
		log(logger, "verify download button");
		boolean result1=tutorialPage.isElementDisplayed("new-atitesting.myresult.page.download.button.loc");
		VerificationHandler.verifyTrue(result1);
		
		log(logger, "verify logo image");
		boolean result2=tutorialPage.isElementDisplayed("new-atitesting.learntab.tutorial.logo");
		VerificationHandler.verifyTrue(result2);
		
		log(logger, "verify results header");
		boolean result3=tutorialPage.isElementDisplayed("new-atitesting.results.header.loc");
		VerificationHandler.verifyTrue(result3);
		
		boolean result4=tutorialPage.verifyIPPPageTable();
		VerificationHandler.verifyTrue(result4);
		
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.myresult.page.download.button.loc"));
		
		log(logger, "NewATI150_VerifyResultsPageValidation End");
	}
	@TestAnnotations(testID="NewATI-605")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify the Content Area for Item Type Regression Proctor Assessment's IPP page::My Results")
	public void NewATI605_VerifyITRIPPPage() throws Exception {
		logger.info("Method : NewATI605_VerifyITRIPPPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.smart.prep.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(2);
		
		log(logger, "Verifying ITR in My Results Page");
		myResultsTabPage.verifyAndClickProctorAssessmentName("Item Type Regression Test (P)", true);
		
		log(logger, "Verifying ITR IPP Page details");
		VerificationHandler.verifyTrue(myResultsTabPage.verifyITRIPPPageDetails(), "Unable to verify ITR IPP Page Detials");
		logger.info("NewATI605_VerifyITRIPPPage End");
	}

}
	
	 
