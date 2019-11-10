package com.automation.asmt.regression.scenario;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentCommonPage;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PreviousPracticeTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private  AssessmentCommonPage assessmentCommonPage;
	
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private UserCreationUtils userCreationUtils;
	private String userName;
	
	
	@BeforeMethod
	public void PreviousPracticeTest() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		assessmentCommonPage = new AssessmentCommonPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}

	/**
	 * Covering : ASMT_275_186_592_147
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_275_186_592")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_275_186_592_147 -- Previous button functionality ")
	public void ASMT_275_186_592_147_PreviousDDFun() throws Exception {
		
		log(logger, "ASMT_275_186_592_147_PreviousDDFun Start");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.master.user1"),PropertiesRepository.getString("asmt.reg.tc.pass")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on My ATI Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));	
		
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.only.drag.drop.questions"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.only.drag.drop.questions"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}	
		
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));		
		
		log(logger, "Answer one question");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, true, true, false, false));	
		
		log(logger, "Verify if Previous button is displayed");
		VerificationHandler.verifyTrue((homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if 'Question Unanswered' popup is displayed");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0);
		
		log(logger, "Click on Close button in 'Question Unanswered' popup");
		homePage.clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
		
		//also covering TC-592
		log(logger, "Select answer");
		quizBankAssPage.clickAssessmemtType();
						
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
	
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		
		log(logger, "Verify if Drag and Drop Question is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.generic.tutorial.dragbox1.loc", 0));
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "ASMT_275_186_592_147_PreviousDDFun Ends");		
	}		
	
	
	/**
	 * Covering : ASMT_206
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_206")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_206 -- Previous button functionality Hint button")
	public void ASMT_206_PreviousHintBtnFun() throws Exception {
		
		log(logger, "ASMT_206_PreviousHintBtnFun Start");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.test11.username"),PropertiesRepository.getString("asmt.test11.password")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
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
		quizBankPage.clickQuizModuleButtonByName(PropertiesRepository.getString("asmt.learntab.quiz.bank.name.loc1"));
		
		log(logger, "Verify if Communication module is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.cardback.module.list.loc"),
				PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"), 0));
	
		log(logger, "Clicking on Begin Quiz button");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"));
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Verify if show hint button is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"),"SHOW HINT", 0));
		
		log(logger, "Click on Show Hint button");
		homePage.clickButton(PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"), 0);
			
		log(logger, "Verify if Hide Hint button is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"),"HIDE HINT", 0));		
				
		log(logger, "Verify if Highlighted Hint is displayed");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.hint.highlighted.loc"))).size()!=0);	
		
		log(logger, "Verify if Glossary link Hint is displayed");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.hint.glossarylink.loc"))).size()!=0);	
		
		//Select answer and check if retains the answer
		log(logger, "Select answer");
		quizBankAssPage.clickAssessmemtType();
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");	
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if show hint button is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.show.hint.btn.loc"),"SHOW HINT", 0));
				
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Verify if Highlighted Hint is not displayed");
		VerificationHandler.verifyTrue(!(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.hint.highlighted.loc"))).size()!=0));	
		
		log(logger, "Verify if Glossary link Hint is not displayed");
		VerificationHandler.verifyTrue(!(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.hint.glossarylink.loc"))).size()!=0));	
				
		log(logger, "ASMT_206_PreviousHintBtnFun Ends");		
	}	
}
