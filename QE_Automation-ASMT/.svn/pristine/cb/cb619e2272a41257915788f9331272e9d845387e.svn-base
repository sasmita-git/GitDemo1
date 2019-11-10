package com.automation.asmt.scenario.flag;

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

public class FlagScenarioPracticeTest extends BaseTest {

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
	 * Covering : ASMT-711
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_711_478")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_711_478 -- Flag Scenario Practice")
	public void ASMT_711_478_FlagScenarioPractice() throws Exception {
		
		log(logger, "ASMT_711_478_FlagScenarioPractice Start");
			
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.711");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository.getString("asmt.product.pass.value.711"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		//getting max question number
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged = (maxQtnTextNo/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo % 1) ==1)
		{questionsFlagged=+1;}		
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		log(logger, "Clicking on 'Go Back to Last Question' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 1);
		
		log(logger, "Clicking on Previous Button till the end and answer all the flagged questions without unflagging and verify assessment complete popup");
		VerificationHandler.verifyTrue(quizBankAssPage.answeringAllFlaggedQuesWithoutUnflagging());
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		log(logger, "Clicking on 'Finalize and View Results' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 2);
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.revisit.glagg.ques.cont.btn.loc"));
		
		log(logger, "Clicking on Continue Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.revisit.glagg.ques.cont.btn.loc"), 0);

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");				
		
		log(logger, "ASMT_711_478_FlagScenarioPractice Ends");		
	}		
	
	/**
	 * Covering : ASMT-269-159-512
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_269_159_512")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT-269-159-512 -- Flag Scenario Practice")
	public void ASMT_269_159_FlagScenarioPractice() throws Exception {
		
		log(logger, "ASMT_269_159_FlagScenarioPractice Start");
			
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.269");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.product.pass.value.269"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Answer all but flag only drag and Drop and drag all the answers to right as well");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestAnswerAllDDAndFlagDD(false, false, true, false,false));
		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Finalize and View Results' buttons are displayed and Click on 'Review Flagged questions' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn1.loc")));	
		
		//TC ASMT-159 Start
		log(logger, "Verify Flag button color is Orange and continue button is enable");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));
		
		log(logger, "Clicking on Unflag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
		
		log(logger, "Verify Flag button color is white and continue button is disabled");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("NotFlagged"));
		
		log(logger, "Clicking on flag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);		
		//TC ASMT-159 Ends
		
		log(logger, "Clicking on Unflag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
		
		log(logger, "Verify if Continue button is Enabled and click on it");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyAndClickContinueBtn());
		
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
		
		log(logger, "Verify if Continue button is Enabled and click on it for rational question");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyAndClickContinueBtn());
		
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
		
		log(logger, "Verify if 'Go Back to Last Question' and 'Finalize and View Results' buttons are displayed and Click on 'Finalize and View Results' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn5.loc")));	
			
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");	
		
		log(logger, "ASMT_269_159_FlagScenarioPractice Ends");		
	}	
	
	/**
	 * Covering : ASMT-407_290_224_244
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_407_290_224_244")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_407_290_224_244 -- Flag Scenario Practice")
	public void ASMT_407_290_FlagScenarioPracticeTEAS() throws Exception {
		
		log(logger, "ASMT_407_290_FlagScenarioPracticeTEAS Start");
			
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.407");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.product.pass.value.407"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(5000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//Section-1
		log(logger, "Verify TEAS title - Section 1");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),PropertiesRepository.getString("asmt.TEAS.401.section1.title"), 0));
				
		//getting max question number
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflagNoPopupVerification(false, false, false, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged = (maxQtnTextNo/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo % 2) ==1)
		{questionsFlagged++;}		
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Proceed to Next Section' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn3.loc")));
		
		//It takes time for the title to refresh
		Thread.sleep(5000);
		
		//Section-2
		log(logger, "Verify TEAS title - Section 2");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),PropertiesRepository.getString("asmt.TEAS.401.section2.title"), 0));
		
		//getting max question number
		int maxQtnTextNo2 = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflagNoPopupVerification(false, false, false, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged2 = (maxQtnTextNo2/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo2 % 2) ==1)
		{questionsFlagged2++;}		
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged2 == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn4.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Complete Post Assessment Survey' buttons are displayed and Click on 'Complete Post Assessment Survey");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn4.loc")));
		
		//It takes time for the title to refresh
		Thread.sleep(5000);
		
		//Section-Survey
		log(logger, "Verify TEAS title - Survey");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),PropertiesRepository.getString("asmt.TEAS.401.sectionSurvey.title"), 0));
				
		log(logger, "ASMT_407_290_FlagScenarioPracticeTEAS Ends");		
  }
	

	/**
	 * Covering : ASMT_277_278
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_277_278")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_277_278 -- Flag Scenario MR Functionality Practice")
	public void ASMT_277_278_FlagScenarioMRFun() throws Exception {
		
		log(logger, "ASMT_277_278_FlagScenarioMRFun Start");
			
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.269");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.product.pass.value.269"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(5000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Navigate to MR Question and select answer");
		VerificationHandler.verifyTrue(quizBankAssPage.MR_Functionality(),"Unable to find MR Question");
		
		log(logger, "Verifying if the answer is selected");
		VerificationHandler.verifyTrue(driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.mr.question.type.loc"))).isSelected());		
		
		log(logger, "Verifying if Continue button is enabled");
		VerificationHandler.verifyTrue(driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).isEnabled());
		
		log(logger, "Clicking on flag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);	
		
		log(logger, "Verify Flag button color is Orange and continue button is enable");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));
		
		log(logger, "Un Check the selected answer");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"), 0);
		
		log(logger, "Verifying if the answer is un-selected");
		VerificationHandler.verifyTrue(!(driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.mr.question.type.loc"))).isSelected()));			
		
		log(logger, "Clicking on Continue Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"), 0);
		
		log(logger, "Verifying if next question or assessment complete popup is dispalyed and go back to previous question");
		VerificationHandler.verifyTrue(assessmentCommonPage.verifyQuesNoOrAssCompletePopup());
		
		//Need to Verify the Absence of Toaster message
		
		log(logger, "ASMT_277_278_FlagScenarioMRFun Ends");		
	}
	
	/**
	 * Covering : ASMT_160_508_777_142
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_160_508_777_142")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_160_508_777_142 -- Flag Scenario flaging diff question.")
	public void ASMT_160_508_777_142_FS_FlaggingDiffQues() throws Exception {
		
		log(logger, "ASMT_160_508_777_142_FS_FlaggingDiffQues Start");
			
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.269");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
				
		//Adding Product
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); 
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Entering Password");
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("new-atitesting.add.product.pwd.loc"), PropertiesRepository
				.getString("asmt.product.pass.value.269"));
		
		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(5000);		
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Answer two questions");
		quizBankAssPage.HowManyQuesToAnswer(false, false, true, false, 2);		

		log(logger, "Verifying 3rd Question is displayed");
		quizBankAssPage.waitUntillElementIsVisible("#highlightWordsText");
		VerificationHandler.verifyTrue(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText().equals("3"));
		
		log(logger, "Flag 3rd question by Clicking on flag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);	
		
		log(logger, "Verify Flag button color is Orange and continue button is enable");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));
		
		log(logger, "Clicking on Continue Button");
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"), 0);
		
		//Also Covering ASMT-142
		log(logger, "Verifying 4th Question is displayed");
		quizBankAssPage.waitUntillElementIsVisible("#highlightWordsText");
		VerificationHandler.verifyTrue(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText().equals("4"));
		
		log(logger, "Clicking on Previous Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"), 0);
		
		log(logger, "Verifying 3rd Question is displayed");
		quizBankAssPage.waitUntillElementIsVisible("#highlightWordsText");
		VerificationHandler.verifyTrue(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText().equals("3"));
		
		log(logger, "Clicking on Unflag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
		
		log(logger, "Verify Flag button color is white and continue button is disabled");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("NotFlagged"));
		
		log(logger, "Verifying if Continue button is enabled");
		VerificationHandler.verifyTrue(driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).isEnabled());
		
		log(logger, "Answer the questions");
		quizBankAssPage.HowManyQuesToAnswer(false, false, true, false, 1);
		
		log(logger, "Answer the questions but dont submit the answer");
		quizBankAssPage.waitUntillElementIsVisible("#highlightWordsText");
		quizBankAssPage.clickAssessmemtType();
		
		log(logger, "Flag the question by Clicking on flag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);	
		
		log(logger, "Verify Flag button color is Orange and continue button is enable");
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));
		
		log(logger, "Clicking on Previous Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"), 0);
		
		log(logger, "Verifying if Flag button is disabled");
		VerificationHandler.verifyTrue(!(driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"))).isEnabled()));
		
		log(logger, "ASMT_160_508_777_142_FS_FlaggingDiffQues Ends");
	}
	
	
	/**
	 * Covering : ASMT_768
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_768")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_768-- Flag Scenario")
	public void ASMT_768_FlagScenarioPractice() throws Exception {
		
		log(logger, "ASMT_768_FlagScenarioPractice Start");
		
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
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining");
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		//getting max question number
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged = (maxQtnTextNo/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo % 1) ==1)
		{questionsFlagged=+1;}
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		log(logger, "Clicking on 'Review Flagged Questions' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 0);
				
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));		
				
		log(logger, "Taking Practie Assessment - Unflagging and answering all the questions and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, false));		
		
		log(logger, "Clicking on 'Finalize and View Results' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 1);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		log(logger, "ASMT_768_FlagScenarioPractice End");
	}
	
	
	
	/**
	 * Covering : ASMT_268
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_268")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_268 -- Verify 'Assessment Completed' pop up, if assessment has flagged questions.")
	public void ASMT_268_FS_AssCompletePopup() throws Exception {
		
		log(logger, "ASMT_268_FS_AssCompletePopup Start");
		
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
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		if(maxQtnTextNo > 5){
		log(logger, "Complete Practice Assessment if its not from begining");
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");	
		}
		
		assessmentCommonPage.switchToAssessmentFrameHandler();
		log(logger, "Verify if Continue button is Enabled and click on it");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyAndClickContinueBtn());
						
		log(logger, "Verify if Un answered popup is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unanswered.popup.loc", 0));
		
		log(logger, "Click on clocse button of Un answered popup ");
		assessmentCommonPage.clickButton(PropertiesRepository.getString("asmt.unanswered.popup.close.btn.loc"));
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));	
		
		log(logger, "Clicking on 'Finalize and View Results' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 2);
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.revisit.glagg.ques.cont.btn.loc"));		
		
		log(logger, "Verify if re visit flagged questions popup is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.revisit.flagged.ques.popup.loc", 0));
						
		log(logger, "Verify if re visit flagged questions popup is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.revisit.flagged.ques.popup.text.loc"), PropertiesRepository.getString("asmt.revist.flag.ques.text"), 1));
		
		log(logger, "Verify if re visit flagged questions popup 'Continue' button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.revisit.flagged.ques.popup.cancel.continue.btn.loc", 0));

		log(logger, "Verify if re visit flagged questions popup 'Cancel' button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.revisit.flagged.ques.popup.cancel.continue.btn.loc", 1));

		log(logger, "ASMT_268_FS_AssCompletePopup End");		
	}

	/**
	 * Covering : ASMT_256
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_256")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_256 -- Verify answer is retained for the 'Flagged for Review marked question'")
	public void ASMT_256_FS_VerifyAnswerRetained() throws Exception {
		
		log(logger, "ASMT_256_FS_VerifyAnswerRetained Start");
		
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
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining");
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.mc10"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		//getting max question number
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Practice Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged = (maxQtnTextNo/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo % 1) ==1)
		{questionsFlagged=+1;}
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		log(logger, "Clicking on 'Review Flagged Questions' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 0);
				
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));		
		
		//Select answer and check if retains the answer
		log(logger, "Select answer");
		quizBankAssPage.clickAssessmemtType();
		
		log(logger, "Verify if Continue button is Enabled and click on it");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyAndClickContinueBtn());
				
		log(logger, "Click on previous button");
		homePage.clickButton(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"), 0);
		
		log(logger, "Verify if Selected answer is retained");
		quizBankAssPage.waitUntillBufferInvisible(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"));
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.assessment.radio.input.loc"))).get(0).isSelected());
				
		//Change answer and check if retains the answer
		
		log(logger, "Select another answer");
		driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"))).get(1).click();
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if Continue button is Enabled and click on it");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyAndClickContinueBtn());
			
		log(logger, "Click on previous button");
		homePage.clickButton(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"), 0);
		
		log(logger, "Verify if Selected answer is retained");
		quizBankAssPage.waitUntillBufferInvisible(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"));
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.assessment.radio.input.loc"))).get(1).isSelected());

		log(logger, "ASMT_256_FS_VerifyAnswerRetained End");		
	}
	
	/**
	 * Will Fail as we are not sure if the TEAS is from begin state or Middle State -JIRA ID : ASMT-11611 
	 * Covering : ASMT_291_276_643_296
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_291_276_643_296")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_291_276_643_296 -- Flag Scenario flaging all sections and verify survey section.")
	public void ASMT_291_276_643_FS_FlaggingAllAndVerifySurvey() throws Exception {
		
		log(logger, "ASMT_291_276_643_FS_FlaggingAllAndVerifySurvey Start");
				
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.401.sectionSurvey.title"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Complete TEAS if its not from begining");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1 /* Add one more condition(verify if Section title is NOT Equal to first section Title)*/){
		assessmentCommonPage.completeContinueStateTEAS(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.401.sectionSurvey.title"));		
		}
		
		log(logger, "Flagg section-1");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagAllQues());
		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		//Covering TC-643
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Review flagged questions' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn1.loc")));
				
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Click on continue button till completion popup is displayed");
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		for (int i = 1; i < maxQtnTextNo-1 ; i++) {
			driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
			homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");				
		}	
		
		log(logger, "Verify if Previous button is displayed at the last question");
		VerificationHandler.verifyTrue((homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		//Covering TC-643
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Proceed to Next Section' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn3.loc")));
		
		log(logger, "Flagg section-2");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagAllQues());
		
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn4.loc"));
		
		//Covering TC-643
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Go back To Last Question' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn2.loc")));
				
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		
		//Covering TC-ASMT-296
		log(logger, "Verifying Questions  and User is redirected to 'Test' page ");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Click on continue button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.ENTER);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");	
		
		//Covering TC-643
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Complete Post Assessment Survey' buttons are displayed and Click on 'Complete Post Assessment Survey");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn4.loc")));
		
		//Section-Survey
		log(logger, "Verify TEAS title - Survey");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),PropertiesRepository.getString("asmt.TEAS.401.sectionSurvey.title"), 0));
		
		//TC: ASMT-276 .... completing survey by passing false to rational . Hence verifying rational page is not displayed.
		log(logger, "Taking TEAS Assessment Section -- Survey");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false, false));
		
		ArrayList<String> buttonList3 = new ArrayList<String>();
		buttonList3.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList3.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Finalize aned view results' buttons are displayed and Click on 'Finalize aned view results' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList3 , PropertiesRepository.getString("asmt.popup.btn5.loc")));		

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		log(logger, "ASMT_291_276_643_FS_FlaggingAllAndVerifySurvey End");		
	}
	
	/**
	 * Will Fail as we are not sure if the TEAS is from begin state or Middle State -JIRA ID :ASMT-11611
	 * Covering : ASMT_291_205
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_291_205")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_291_205 -- Flag all the questions in a TEAS section and select Proceed to the next Section..")
	public void ASMT_291_205_FS_FlagAllAndVerifyNexrSection() throws Exception {
		
		log(logger, "ASMT_291_205_FS_FlagAllAndVerifyNexrSection Start");
				
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.401.section.no.survey.title"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Complete TEAS if its not from begining");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1  /* Add one more condition(verify if Section title is NOT Equal to first section Title)*/ ){
		assessmentCommonPage.completeContinueStateTEAS(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.401.sectionSurvey.title"));		
		}
		
		log(logger, "Flag all the questions in the first section of TEAS and Verifying is all the questions are flagged");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagAllQues());
		
		//List of Button to be displayed in the popup		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Review Flagged questions' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn1.loc")));	
								
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));
		
		//Covering TC-ASMT-205
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		
		log(logger, "Un flag all the questions in the first section of TEAS");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestUnFlagAllQues(false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
				
		log(logger, "Verify if 'Go back To Last Question', 'Go Back to Last Question', 'Proceed to Next Section' buttons are displayed and Click on 'Proceed to Next Section' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn3.loc")));
		
		log(logger, "Taking TEAS Proctor Assessment Section -- 2");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false,false));
						
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList4 = new ArrayList<String>();
		buttonList4.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList4.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
				
		log(logger, "Verify if 'Go back To Last Question' and 'Finalize and View Results' buttons are displayed and Click on 'Finalize and View Results' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList4 , PropertiesRepository.getString("asmt.popup.btn5.loc")));	
				
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		log(logger, "ASMT_291_205_FS_FlagAllAndVerifyNexrSection End");		
	}
}
