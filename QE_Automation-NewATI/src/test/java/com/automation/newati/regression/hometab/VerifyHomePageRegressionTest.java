package com.automation.newati.regression.hometab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.FlashCardPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.QuizPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;

public class VerifyHomePageRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private QuizPage quizPage;
	private FlashCardPage flashCardPage;
	private CreateAccountPage createAccountPage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		quizPage = new QuizPage(driver);
		flashCardPage = new FlashCardPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		testTabPage=new TestTabPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		//loginPage.loginToApplication("stagesmoke17", "Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, description = "NewATI-507:To verify changed appearance of ADD PRODUCT function")
	public void  NewATI507_VerifyAddProductFunctionality() throws Exception {
		log(logger,"NewATI507_VerifyAddProductFunctionality Start");
		
		log(logger, "Clicking on add product button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Add Product Enter ID text box");
		VerificationHandler.verifyTrue(homePage.verifyElement(PropertiesRepository.getString("new-atitesting.add.product.id.loc")), "Unable to verify text box after clicking Add Product");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(homePage.verifyModalWindowFunctionality(1), "Unable to verify elemnet when modal window is displayed");
		
		log(logger,"NewATI507_VerifyAddProductFunctionality End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, description = "NewATI-105:Verify the functionality of 'Web Site Terms of Use' footer link.")
	public void  NewATI105_VerifyWebSiteTermsFooter() throws Exception {
		log(logger,"NewATI105_VerifyWebSiteTermsFooter Start");
		
		log(logger, "Clicking on Web Site Terms of Use link");
		homePage.verifyAndClickWithList(PropertiesRepository.getString("new-atitesting.hometab.bottom.links.loc"), 1, true);
		
		log(logger, "Verifying Web Site Terms fo Use link header");
		VerificationHandler.verifyFalse(homePage.verifyMessageWithDefaultWinSwitch(PropertiesRepository.getString("new-atitesting.homepage.linkpage.linksText.Terms"), PropertiesRepository.getString("new-atitesting.web.site.terms.use.page.header.value")),"Unable to verify Web Site Page Header");
		
		log(logger,"NewATI105_VerifyWebSiteTermsFooter End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, description = "NewATI-527:Verify Recent Activity section in case of Change Institution:STU-2450")
	public void  NewATI527_VerifyRecentActivitySection() throws Exception {
		log(logger,"NewATI527_VerifyRecentActivitySection Start");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "click on signout button");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Login with this specific user");
		loginPage.loginToApplication("User050918321","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		log(logger, "Selecting Quiz from Test Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
		
		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 End
		
		// Click on Modules on Card front
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")),
				"Unable to verify Module name");
	
		log(logger, "Clicked on Quiz Bank Modules Button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click Begin on Card back
		String quizName = quizPage.clickQuizName(0);
		
		log(logger, "Clicked on Begin or Continue Button in Quiz Bank Card Back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verifying the Quiz
		VerificationHandler.verifyEquals(quizPage.getQuizBankAssessmentName(),quizName,"Quizbank assessment name is not equal");
		log(logger, "Verifying quiz name");

		// Click on Quiz Bank Assessment Close button
		tutorialPage.clickQuizCloseButton();
		log(logger, "Clicked on Close button in Quiz Bank");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Closing card back");
		flashCardPage.clickCardbackClose();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 Start
		log(logger, "Clicking on Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying same assessment in Recent Activity");
		VerificationHandler.verifyTrue(homePage.verifyRecentActivity1(quizName), "Recent activity is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My Profile link");
		homePage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Insitution info edit link");
		homePage.clickButtonFromList("new-atitesting.institution.info.edit.link", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Changing Institution name");
		createAccountPage.selectDropdownValue(PropertiesRepository.getString("new-atitesting.institution.info.dd.institution.loc"),
				PropertiesRepository.getString("new-atitesting.profile.edit.institution.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.institution.info.save.button.loc", 0);
		
		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.institution.info.institution.value.loc"), PropertiesRepository.getString("new-atitesting.profile.edit.institution.value")), "Institution name is not changed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Go to Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify assessment name is not displayed");
		VerificationHandler.verifyFalse(homePage.verifyRecentActivity1(quizName), "Recent activity is displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Resetting Institution value. 
		log(logger, "Clicking on My Profile link");
		homePage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Insitution info edit link");
		homePage.clickButtonFromList("new-atitesting.institution.info.edit.link", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Changing Institution name");
		createAccountPage.selectDropdownValue(PropertiesRepository.getString("new-atitesting.institution.info.dd.institution.loc"),
				PropertiesRepository.getString("new-atitesting.createaccount.institution.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.institution.info.save.button.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Resetting Institution Name");
		VerificationHandler.verifyTrue(homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.institution.info.institution.value.loc"), PropertiesRepository.getString("new-atitesting.createaccount.institution.value")), "Unable to reset institution value");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"NewATI527_VerifyRecentActivitySection End");
	}
}
