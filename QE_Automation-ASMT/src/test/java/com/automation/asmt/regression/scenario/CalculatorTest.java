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
import org.supercsv.cellprocessor.ParseInt;
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

public class CalculatorTest extends BaseTest {

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
	 * Covering : ASMT_590_129_127_21
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_590_129_127_21")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_590_129_127_21:Verify inactivity pop-up is not showing when user is using Calculator in practice")
	public void ASMT_590_CalculatorFun() throws Exception {
		
		log(logger, "ASMT_590_CalculatorFun Start");
		
		// Step #4 of 590 requires waiting for 10 mins, so skipping this step.
		// Step #4 of 127 cannot be automated
		// Step #6 of 127 cannot be automated
		// Step #11 of 127 cannot be automated
		// Step #6 of 21 cannot be automated
		// Step #7 of 21 cannot be automated
		// Step #8 of 21 cannot be automated

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
		
		log(logger, "Verify if Calculator is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.assessment.calculator.loc", 0));
		
		log(logger, "Clicking on Calculator");
		homePage.clickButton(PropertiesRepository.getString("asmt.assessment.calculator.loc"));		
		
		log(logger, "Verify if Calculator popup is displayed");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.calculator.header.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.calculator.header.loc", 0));
		
		String timeRemaningStart = driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assessment.time.remaning.loc"))).getText();
		
		log(logger, "Verify that whole window behind the calculator should not be greyed out by clicking on flag Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);	
		
		log(logger, "Verify Flag button color is Orange");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));		
		
		//TC-129
		log(logger, "Adding with decimal");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.plus.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
				
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.equals.loc"), 0);
		
		log(logger, "Verify the sum equlal to 2.2"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "2.2", 0));
		
		log(logger, "Subtracting with decimal");		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.minus.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.equals.loc"), 0);
		
		log(logger, "Verify the sum equlal to 1.1"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "1.1", 0));
				
		log(logger, "Multiply with decimal");		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.multiply.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.equals.loc"), 0);
		
		log(logger, "Verify the sum equlal to 1.21"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "1.21", 0));
		
		log(logger, "Divide with decimal");		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.divide.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.equals.loc"), 0);
		
		log(logger, "Verify the sum equlal to 1.1"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "1.1", 0));
		
		////TC-127
		String timeRemaningEnd = driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assessment.time.remaning.loc"))).getText();
		
		log(logger, "Time Remaining for the test should continue while using calculator"); 
		VerificationHandler.verifyTrue(timeRemaningEnd!=timeRemaningStart);
		
		log(logger, "Refresh page to Verify that the calculator is closed"); 
		driver.navigate().refresh();
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Verify if Calculator is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.calculator.header.loc", 0)));
		
		log(logger, "Clicking on Calculator");
		homePage.clickButton(PropertiesRepository.getString("asmt.assessment.calculator.loc"));		
		
		log(logger, "Verify if Calculator popup is displayed");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.calculator.header.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.calculator.header.loc", 0));
		
		log(logger, "Verify the value is 0"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "0", 0));
		
		//TC-21
		
		log(logger, "Verify the MRC functionality"); 
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		
		log(logger, "Adding 1.1 to memory");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.mrAdd.loc"), 0);
		
		log(logger, "do addition action");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.plus.loc"), 0);
		
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.point.loc"), 0);
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.1.loc"), 0);
				
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.equals.loc"), 0);
		
		log(logger, "Verify the sum equlal to 2.2"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "2.2", 0));
		
		log(logger, "Click on MRC to see if 1.1 is displayed");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.calculator.btn.mrc.loc"), 0);
		
		log(logger, "Verify the 1.1 stored in memory is displayed"); 
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndexByValueTag(PropertiesRepository.getString("asmt.calculator.answer.loc"), "1.1", 0));
		
		log(logger, "ASMT_590_CalculatorFun Ends");		
	}	
	
	
}
