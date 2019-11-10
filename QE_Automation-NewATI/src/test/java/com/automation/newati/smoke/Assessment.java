package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;


public class Assessment extends BaseTest{
	
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private TutorialPage tutorialPage;
	private HomePage homePage;
	public BaseHandler baseHandler;
	public TestTabPage testTabPage;
	private PractiseAssessmentPage practiseAssessmentPage;
	private WindowHandler windowsHandler;
	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		tutorialPage=new TutorialPage(driver);
		homePage = new HomePage(driver);
		baseHandler = new BaseHandler(driver);
		testTabPage=new TestTabPage(driver);
		practiseAssessmentPage=new PractiseAssessmentPage(driver);
		windowsHandler = new WindowHandler(driver);
	}
	
		@TestAnnotations(testID="NewATI-123")
		@Test(priority = 1, enabled = true, alwaysRun = true, groups = {"Smoke"}, description = "ITR OP Smoke test complete assessment ")
		public void NewATI_CompelteAssessment() throws Exception {
			log(logger, "NewATI_CompelteAssessment Starts");
		
			log(logger, "Login to application");
			loginPage.loginToApplication("testjuly2 ", "Test@123");

			log(logger, "Verify home page is displayed");
			VerificationHandler.verifyTrue(driver.getTitle().equalsIgnoreCase("Home - ATI Testing"));
			
			log(logger, "Clicking on My ATI Tab");
			homePage.clickTab(1);

			// Click on Learn Tab
			log(logger, "Clicking on Test Tab");
			homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Select Practice Assessment Name");
			practiseAssessmentPage.clickTestTabAssessmentButtonNew("Practice Assessment", PropertiesRepository.getString("newati.itroOp"));			
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Verifying Assessment Page is displayed");
			VerificationHandler.verifyTrue(tutorialPage.verifyQuestionNos(),"Unable to verify Question nos");
			
			log(logger, "Complete Assessment");
			tutorialPage.takeTest(false, false, false, false);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
//			log(logger, "Verify Ipp Page is displayed and Focused review button is displayed");
//			VerificationHandler.verifyTrue(homePage.isElementDisplayed("ati.ipp.focusreview.btn.loc"));
			
//			log(logger, "Clicking on Focus Review button");
//			homePage.clickButton(PropertiesRepository.getString("ati.ipp.focusreview.btn.loc"), 0);
//			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//			
//			windowsHandler.switchToMainWindow();
//			windowsHandler.switchToFrame("focusedReviewFrame");			
//			log(logger, "Verify Focused review Page is displayed");
//			VerificationHandler.verifyTrue(homePage.isElementDisplayed("ati.ipp.focusreview.menu.link.loc"));
//			
//			windowsHandler.switchToMainWindow();
//			log(logger, "Clicking on Close button");
//			homePage.clickButton(PropertiesRepository.getString("ati.ipp.focusreview.close.btn.loc"), 0);
//			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Verify Ipp Page is displayed");
			VerificationHandler.verifyTrue(homePage.isElementDisplayed("ati.ipp.header.loc"));
			
			log(logger, "Clicking on Close button on IPP page");
			homePage.clickButton(PropertiesRepository.getString("ati.ipp.close.button.loc"), 0);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Clicking on My Results Tab");
			homePage.clickTab(2);
			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			log(logger, "Verify My Results page is displayed");
			VerificationHandler.verifyTrue(driver.getTitle().contains("My Results"));			
			
			log(logger, "NewATI_CompelteAssessment Ends");
			
		}

}
