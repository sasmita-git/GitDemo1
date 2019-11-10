package com.automation.newati.regression.helptab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;

public class VerifyHelpPageTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private HelpPage helpPage;
	
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		helpPage = new HelpPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@Test(priority=1, alwaysRun = true,description = "NewATI-24:Check for the elements on Feedback page.")
	public void  NewATI24_verifyElementsOnFeedbackPage() throws Exception {
		log(logger,"NewATI24_verifyElementsOnFeedbackPage Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back radio button text");
		boolean result=helpPage.verifyFeedBackPageRadioOptionText();
		VerificationHandler.verifyTrue(result);
		
		log(logger,"NewATI24_verifyElementsOnFeedbackPage End");
	}
	
	@Test(priority=2, alwaysRun = true,description = "NewATI-25:Verify that submit button become enable.")
	public void  NewATI25_verifySubmitButtonBecomeEnable() throws Exception {
		log(logger,"NewATI25_verifySubmitButtonBecomeEnable Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger,"NewATI25_verifySubmitButtonBecomeEnable End");
	}
	
	@Test(priority=3, alwaysRun = true,description = "NewATI-26:Check for Cancel button.")
	public void  NewATI26_verifyCancelButton() throws Exception {
		log(logger,"NewATI26_verifyCancelButton Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on cancel button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
		
		log(logger,"NewATI26_verifyCancelButton End");
	}
	
	@Test(priority=4, alwaysRun = true,description = "NewATI-27:Submit a bug with a Low severity.")
	public void  NewATI27_verifyBugSeverity() throws Exception {
		log(logger,"NewATI27_verifyBugSeverity Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on submit button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
		
		log(logger,"NewATI27_verifyBugSeverity End");
	}
	
	@Test(priority=5, alwaysRun = true,description = "NewATI-28:Submit a bug with a Medium severity.")
	public void  NewATI28_verifyBugSeverity() throws Exception {
		log(logger,"NewATI27_verifyBugSeverity Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on submit button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
		
		log(logger,"NewATI27_verifyBugSeverity End");
	}
	
	@Test(priority=6, alwaysRun = true,description = "NewATI-29:Submit a bug with a High severity.")
	public void  NewATI29_SubmitABugwithaHighSeverity() throws Exception {
		log(logger,"NewATI29_SubmitABugwithaHighSeverity Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.high.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on submit button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
		
		log(logger,"NewATI29_SubmitABugwithaHighSeverity End");
	}
	
	@Test(priority=7, alwaysRun = true,description = " NewATI-30:Check for Submit and Cancel button on Comments and Suggestions Feedback.")
	public void  NewATI30_VerifySubmitandCancelButton() throws Exception {
		log(logger,"NewATI30_VerifySubmitandCancelButton Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyFeedBackBugCommentBox(PropertiesRepository.getString("new-atitesting.helptab.feedback.high.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "verify cancel button");
		boolean checkElementEnabled = homePage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
		VerificationHandler.verifyTrue(checkElementEnabled);
		log(logger,"NewATI30_VerifySubmitandCancelButton End");
	}
	
	@Test(priority=8, alwaysRun = true,description = "NewATI-32:Check for Submit and Cancel button on Comments and Suggestions Feedback after selecting ratings")
	public void  NewATI32_VerifyCommentsandSuggestionsFeedbackafterSelectingRatings() throws Exception {
		log(logger,"NewATI32_VerifyCommentsandSuggestionsFeedbackafterSelectingRatings Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify feed back comment box");
		boolean result=helpPage.verifyCancelAndSubmitButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.high.priority"));
		VerificationHandler.verifyTrue(result);
		
		log(logger,"NewATI32_VerifyCommentsandSuggestionsFeedbackafterSelectingRatings End");
	}
	
	
	@Test(priority=9, alwaysRun = true,description = "NewATI-62:Submit Suggestion with much worse ratings.")
	public void  NewATI62_VerifyCommentsAndSuggestion() throws Exception {
		log(logger,"NewATI62_VerifyCommentsAndSuggestion Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify sumbit button when entering text in comment box");
		boolean result=helpPage.verifyCommentsAndSuggestionBox();
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on submit button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));

		log(logger,"NewATI62_VerifyCommentsAndSuggestion End");
	}
	
	@Test(priority=10, alwaysRun = true,description = "NewATI-73:Submit Suggestion with worse ratings.")
	public void  NewATI73_VerifyCommentsAndSuggestion() throws Exception {
		log(logger,"NewATI62_VerifyCommentsAndSuggestion Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify sumbit button when entering text in comment box");
		boolean result=helpPage.verifyCommentsAndSuggestionBox();
		VerificationHandler.verifyTrue(result);
		
		log(logger,"NewATI62_VerifyCommentsAndSuggestion End");
	}
	
	@Test(priority=11, alwaysRun = true,description = "NewATI-75:Submit Suggestion with About the same ratings.")
	public void  NewATI75_VerifyCommentsAndSuggestion() throws Exception {
		log(logger,"NewATI62_VerifyCommentsAndSuggestion Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify sumbit button when entering text in comment box");
		boolean result=helpPage.verifyCommentsAndSuggestionBox();
		VerificationHandler.verifyTrue(result);
		
		log(logger, "click on cancel button");
		helpPage.clickButton(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
		
		log(logger,"NewATI62_VerifyCommentsAndSuggestion End");
	}
	
	@Test(priority=12, alwaysRun = true,description = "NewATI-77:Submit Suggestion with better ratings.")
	public void  NewATI77_VerifyCommentsAndSuggestion() throws Exception {
		log(logger,"NewATI62_VerifyCommentsAndSuggestion Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify sumbit button when entering text in comment box");
		boolean result=helpPage.verifyCommentsAndSuggestionSectionDescription();
		VerificationHandler.verifyTrue(result);
		
		log(logger, "verify cancel button Presence");
		boolean checkElementEnabled = homePage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
		VerificationHandler.verifyTrue(checkElementEnabled);
		
		log(logger,"NewATI62_VerifyCommentsAndSuggestion End");
	}
	
	
	@Test(priority=13, alwaysRun = true,description = "NewATI-80:Submit Suggestion with much better ratings.")
	public void  NewATI80_VerifyCommentsAndSuggestionSubmitButton() throws Exception {
		log(logger,"NewATI80_VerifyCommentsAndSuggestionSubmitButton Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger, "click on help tab feedback button");
		helpPage.clickButton(PropertiesRepository.getString("new-atiteting.helptab.feedback.loc"));
		
		log(logger, "verify sumbit button when entering text in comment box");
		boolean result=helpPage.verifyCommentsAndSuggestionSectionDescription();
		VerificationHandler.verifyTrue(result);
		
		log(logger, "verify submit button Presence");
		boolean checkElementEnabled = homePage.checkElementSelected(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
		VerificationHandler.verifyFalse(checkElementEnabled);
		
		log(logger,"NewATI80_VerifyCommentsAndSuggestionSubmitButton End");
	}
	
	
}
