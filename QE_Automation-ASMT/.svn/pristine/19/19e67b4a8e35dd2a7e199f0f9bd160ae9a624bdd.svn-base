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
import com.ascendlearning.automation.ui.handlers.BaseHandler;
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

public class DragAndDropPracticeTest extends BaseTest {

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
	public BaseHandler baseHandler;
	
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		assessmentCommonPage = new AssessmentCommonPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		baseHandler = new BaseHandler(driver);
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-571-184-185")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT-571, ASMT-184, ASMT-185:ASMT-1744: Validate the Backward Navigation for Drag-Drop Question.")
	public void ASMT_DDFun185() throws Exception {
		
		log(logger, "ASMT_DDFun185 Start");
			
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
		
		log(logger, "Verifying Drag and Drop Question");
		quizBankAssPage.switchToAssessmentFrameHandler();
		VerificationHandler.verifyTrue(assessmentCommonPage.isElementDisplayed("asmt.generic.tutorial.dragbox1.loc", 0),"Unable to verify drag and drop Question");		
			
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 4){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.only.drag.drop.questions"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}
		
		log(logger, "Verifying Initially all the option should be listed under Question box");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.oprions.loc"))).size()>1);
		
		log(logger, "Verifying Initially Answer box is empty");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.options.loc"))).size()<1);
		
		log(logger, "Drag and drop One answers");
		quizBankAssPage.DragAndDropOneAnswers(false);
		
		log(logger, "Verifying Answer box is not empty");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.options.loc"))).size()>=1);
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if 'Question Unanswered' popup is displayed");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0);
		
		log(logger, "Click on Close button in 'Question Unanswered' popup");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
		homePage.clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
		
		log(logger, "Drag and drop all answers");
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		quizBankAssPage.DragAndDropAnswer(false);
		
		int questionNumBeforeAnswering = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		int questionNumAfterAnswering = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		
		log(logger, "Verify ifNext Question is displayed");
		VerificationHandler.verifyTrue(questionNumAfterAnswering == questionNumBeforeAnswering+1);	
		
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
	
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));		
		
		log(logger, "ASMT_DDFun185 Ends");		
	}	
	

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-448-173-183")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT-173,ASMT-183, ASMT-448:Verify drag and drop feature,Using Mouse and Keyboard at a time.")
	public void ASMT_DDFun448_Space() throws Exception {
		
		log(logger, "ASMT_DDFun448_Space Start");
			
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
		
		log(logger, "Verifying Drag and Drop Question");
		quizBankAssPage.switchToAssessmentFrameHandler();
		VerificationHandler.verifyTrue(assessmentCommonPage.isElementDisplayed("asmt.generic.tutorial.dragbox1.loc", 0),"Unable to verify drag and drop Question");		
		
		int optionsInQuestionBlock = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size();		
		
		log(logger, "Drag and drop all answers using space button");		
		quizBankAssPage.DragAndDropAnswerUsingSpaceBtn(false);
		
		log(logger, "Verifying if all the options are dropped to right ");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.options.loc"))).size() == optionsInQuestionBlock);
		
		//step 6 of TC ASMT-448 is not valid 
		
		//TC ASMT-173 and ASMT-183
		String firstAnswerBeforeReseq =  baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).get(0).getText();
		
		log(logger, "Drag and drop answers in the same Answer Block");
		quizBankAssPage.DragAndDropOneAnswersInAnswerBlock(false);
		
		log(logger, "Verify if the answer is re-sequnced in the answer block");
		VerificationHandler.verifyTrue(firstAnswerBeforeReseq != baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).get(0).getText() );
		
		log(logger, "Drag and drop all answers from Right to left");		
		quizBankAssPage.DragAndDropAnswerReverse(false);		
		
		log(logger, "Verifying if all the options are dropped to right ");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size() == optionsInQuestionBlock);
		
		String firstAnswerBeforeReseqInQuestionBlock =  baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).get(0).getText();
		log(logger, "Drag and drop answers in the same Question Block");
		quizBankAssPage.DragAndDropOneAnswersInQuestionBlock(false);
		
		log(logger, "Verify if re-sequnce is not possible in the Question block");
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		VerificationHandler.verifyTrue(firstAnswerBeforeReseqInQuestionBlock.equals(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).get(0).getText()) );
		
		log(logger, "ASMT_DDFun448_Space Ends");		
		}	
	
	
}
