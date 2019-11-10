package com.automation.asmt.smoke;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.CommonUtils;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class SmokeTest2 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private CommonUtils commonUtils;
	
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private UserCreationUtils userCreationUtils;
	private String userName;
	private BaseHandler baseHandler;
	
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		commonUtils = new CommonUtils();
		baseHandler= new BaseHandler(driver);
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}

	/**
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-746")
	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-746: Verify the Quiz bank and the elements in Quiz bank [Version : 1]")
	public void ASMT746_VerifyQuizBankAndItsElements() throws Exception {
		
		log(logger, "ASMT746_VerifyQuizBankAndItsElements Start");
		
		String pordID = PropertiesRepository.getString("asmt.quiz.id.value.746");
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
		logger.info("Student User Created  --> " + userName);
		
		log(logger, "Login to Application");
		loginPage.loginToApplication(userName, "Test@1234");	
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), pordID);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);
		
		log(logger, "Clicking on My ATI Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));		

		log(logger, "Clicking on Quiz Assessment ");
		quizBankPage.clickQuizModuleButtonByName(PropertiesRepository.getString("asmt.quiz.name.new"));
		//quizBankPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if Communication module is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.cardback.module.list.loc"),
				PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"), 0));
	
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"));		
		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		quizBankAssPage.switchToAssessmentFrameHandler();
		
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		
		log(logger, "Verify if Continue button is displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.continue.btn.loc")).isDisplayed());
				
		log(logger, "Answer one Question");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest_AnswerOnlyOneQuestion(false, false, true, false));
		
		log(logger, "Verify if Previous button is  displayed");
		VerificationHandler.verifyTrue((homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));		
		
		log(logger, "Verify if Continue button is displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.continue.btn.loc")).isDisplayed());	
		
		//log(logger, "Verify Quiz title");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.quiz.title.loc"),
				PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"), 0));		
		
		log(logger, "Verify if Close button is displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.close.btn.loc")).isDisplayed());
		
		log(logger, "Verify if Timer is  displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.timer.loc")).isDisplayed());
		
		log(logger, "Verify if show hint button is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"),
				"SHOW HINT", 0));
		
		log(logger, "Click on Show Hint button");
		homePage.clickButton(PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"), 0);
			
		log(logger, "Verify if Hide Hint button is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"),
				"HIDE HINT", 0));		
		
		log(logger, "Verify if Tools button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.quiz.tools.btn.loc", 0));		
				
		log(logger, "Click on Tools button and Verifying if Glossary, Calculator, Critical Thinking Guide are displayed");
		VerificationHandler.verifyTrue(quizBankPage.verifyToolsSection());		
				
		log(logger, "ASMT746_VerifyQuizBankAndItsElements Ends");		
	}
	
	/**
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-747")
	@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-747: Verify the ITR Assessment completion pop-up, Questions with exhibit tab and validate the End Assessm [Version : 1]")
	public void ASMT747_VerifyITRExhibitAndFlag() throws Exception {
		
		log(logger, "ASMT747_VerifyITRExhibitAndFlag Start");
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
		logger.info("Student User Created  --> " + userName);
		String pracAssessmentId = PropertiesRepository.getString("asmt.product.747");
																
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test@1234"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), pracAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository.getString("asmt.product.pass.747"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Flag some questions, Verify exhibit appears for at least one question  and  Verify if 'Assessment Completed' pop up if displaying 3 options");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagFirst5CheckExhibitAndPopup(false, false, true, false));
		
		log(logger, "Clicking on 'Review Flagged questions' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 0);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));
		
		log(logger, "Complete by unflagging the flagged questions");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestUnFlag(false, false, true, false));
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
						
		log(logger, "ASMT747_VerifyITRExhibitAndFlag Ends");		
	}
	
}
