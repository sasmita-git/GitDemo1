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

public class RationalPracticeTest extends BaseTest {

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
	public void verifyHomePage() throws Exception {
		
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
	 * Covering : ASMT_536_148_39_598_536
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_536_148_39_598_536")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_536_148_39_598_536 -- Rational Page Scenario Practice")
	public void ASMT_536_148_39_598_536_RationalPageScenarioPractice_One() throws Exception {
		
		log(logger, "ASMT_536_148_39_598_536_RationalPageScenarioPractice_One Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 5");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 5){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}		
		
		//getting current question number
		int currentQuestionNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());
		
		log(logger, "Answer one question");
		quizBankAssPage.takeTest(false, true, true, false, false);
		
		log(logger, "Verifying next question is displayed");
		VerificationHandler.verifyTrue(Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()) == (currentQuestionNo+1));
		
		log(logger, "Select answer");
		quizBankAssPage.clickAssessmemtType();
						
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
	
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Verifying previous question is displayed");
		VerificationHandler.verifyTrue(Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()) == (currentQuestionNo));
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");	
		
		log(logger, "Verify if Selected answer is retained");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.assessment.radio.input.loc"))).get(0).isSelected());
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		//TC ASMT-39
		log(logger, "Verify if Current Question number is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.question.ending.number.loc", 0));
		
		log(logger, "Verify if Previous button is  displayed");
		VerificationHandler.verifyTrue((homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));		
		
		log(logger, "Verify if Continue button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.quiz.continue.btn.loc", 0));		
		
		log(logger, "Verify if correct/incorrect lable is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.correct.incorrect.loc", 0));
		
		log(logger, "Verify if answer radio button is disabled");
		VerificationHandler.verifyTrue(!(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.assessment.radio.input.loc"))).get(0).isEnabled()));
		
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Verify if Current Question number is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.question.ending.number.loc", 0));
		
		log(logger, "Verify if Previous button is  displayed");
		VerificationHandler.verifyTrue((homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));		
		
		log(logger, "Verify if Continue button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.quiz.continue.btn.loc", 0));		
		
		log(logger, "Verify if correct/incorrect lable is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.correct.incorrect.loc", 0));
		
		//TC ASMT-598
		log(logger, "Verify if answer radio button is disabled");
		VerificationHandler.verifyTrue(!(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.assessment.radio.input.loc"))).get(0).isEnabled()));
		
		log(logger, "ASMT_536_148_39_598_536_RationalPageScenarioPractice_One Ends");		
	}		
	
	

	/**
	 * Covering : ASMT_16_135
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_16_135")
	@Test(priority = 2, alwaysRun = true, groups = { "Regression" }, description = "ASMT_16_135 -- Rational Page Scenario Practice")
	public void ASMT_16_135_RationalPageScenarioPractice_Two() throws Exception {
		
		log(logger, "ASMT_16_135_RationalPageScenarioPractice_Two Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.regression.assessment.no.rational"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 3");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 3){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}		
		
		//getting current question number
		int currentQuestionNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());
		
		log(logger, "Answer one question");
		quizBankAssPage.takeTest(false, true, false, false, false);
		
		log(logger, "Verifying next question is displayed");
		VerificationHandler.verifyTrue(Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()) == (currentQuestionNo+1));

		log(logger, "Verify if Rational Page is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.rational.page.correct.incorrect.loc", 0)));
		
		log(logger, "ASMT_16_135_RationalPageScenarioPractice_Two Ends");		
	}	
		
	/**
	 * Covering : ASMT_571_404
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-571-404")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT_571 -- Rational Page Scenario Practice -User should not be able to drag the options in rationale page for drag and drop type questions")
	public void ASMT_571_RationalPageScenarioPractice_Three() throws Exception {
		
		log(logger, "ASMT_571_RationalPageScenarioPractice_Three Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.all.type.ques.rational.on"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}		
		
		log(logger, "Answer all question's till you find drag and drop question, when found then answer it and come out");
		quizBankAssPage.takeTestBreakAfterDragDrop(false, false, true, false, false);
		
		//If Drag and Drop is the last question then we will get the Assessment completion popup, then will Click on "Go Back to Last Question" button
		if(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.popup.buttons.loc")) != null )
		{
			quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.popup.buttons.loc")).get(0).click();
		}
		
		//Else if Drag and Drop is not the last question, we will click on previous button
		else{
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
		}
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
	
		log(logger, "Verify if Dragged answers are disabled and cannot be dragged again");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.rational.page.dragdrop.disable.loc"))).size() == 4);
				
		log(logger, "ASMT_571_RationalPageScenarioPractice_Three Ends");		
	}	
	
	
	/**
	 * Covering : ASMT_571
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_709")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT_709 -- Rational Page Scenario Practice")
	public void ASMT_709_RationalPageScenarioPractice_Four() throws Exception {
		
		log(logger, "ASMT_709_RationalPageScenarioPractice_Four Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.all.type.ques.rational.on"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 5");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}	
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflagNoPopupVerification(false, false, true, true));
		
		log(logger, "Clicking on 'Review Flagged Questions' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 0);
				
		log(logger, "Verify if Unflag button is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.unflag.btn.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));
		
		log(logger, "Clicking on Unflag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
		
		log(logger, "Select answer");
		quizBankAssPage.clickAssessmemtType();		
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
				
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "ASMT_709_RationalPageScenarioPractice_Four Ends");		
	}
	
	/**
	 * Covering : ASMT_766
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_766")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT_766 -- Correct/Incorrect rationale displaying for Hotspot questions")
	public void ASMT_766_RationalPageScenarioPractice_Five() throws Exception {
		
		log(logger, "ASMT_766_RationalPageScenarioPractice_Five Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.all.type.ques.rational.on"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}	
		
		log(logger, "Answer all question's till you find drag and drop question, when found then answer it and come out");
		quizBankAssPage.takeTestBreakAfterHotspot(false, false, true, false, false);
		
		log(logger, "Verify if Rational Page is displayed with Correct/Incorrect label");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "ASMT_766_RationalPageScenarioPractice_Five Ends");		
	}	
	
	
	/**
	 * Covering :ASMT-607
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_607")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT-607 --RationalPageScenarioPractice_Six : Assessment Batch who's rationale is set to 1 for assessment level and batch level ")
	public void ASMT_607_RationalPageScenarioPractice_Six() throws Exception {
		
		log(logger, "ASMT_607_RationalPageScenarioPractice_Six Start"); 
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.rational.scenario");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.value.rational.scenario");
		
		//--------->>Faculty Start<<------------
		log(logger, "Login to Faculty application");
		VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.ITROP.proctor.username"),
				PropertiesRepository.getString("id.login.ITROP.proctor.password")));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));
	
		log(logger, "Clicking on Left Navigation Link");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
				
		log(logger, "Enterin Proctor id, pwd and click submit button And Verify if Proctor Monitor Page is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.enteringProctIdAndPwd(proctorDriver,procAssessmentId,procAssessmentPwd));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc.new"));
		
		log(logger, "Entering Electornic Signature");
		maintenanceScriptID.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		maintenanceScriptID.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						maintenanceScriptID.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		maintenanceScriptID.clickProctorWelcomePageProceedButton(proctorDriver);
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		maintenanceScriptID.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		maintenanceScriptID.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		maintenanceScriptID.clickCloseButtonInStoppedAssessmentSection(proctorDriver);		
		//--------->>Faculty Ends<<------------
		
		//--------->>Student Start<<------------
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");

		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver),
				"Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(10000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(30000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver),
				"Verifying Stop Test Check box");
		//--------->>Faculty End<<------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");			
		
		// Completing assessment by passing false to rational. Hence verifying rational page is not displayed.		
		log(logger, "Taking Proctor Assessment - Unflagging and answering all the questions and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, false, false));		
		
		log(logger, "Clicking on 'Finalize and View Results' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 1);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		//--------->>Student Ends<<------------
		
		log(logger, "ASMT_607_RationalPageScenarioPractice_Six Ends");		
	}		
}
