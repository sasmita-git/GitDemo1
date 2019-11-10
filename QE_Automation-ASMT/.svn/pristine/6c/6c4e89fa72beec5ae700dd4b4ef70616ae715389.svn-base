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

public class CommonTest extends BaseTest {

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
	 * Covering : ASMT_559
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_559")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_559:Verify all glossary words are displayed on selecting tab's in glossary pop-up.")
	public void ASMT_559_FooterLinks() throws Exception {
		
		log(logger, "ASMT_559_FooterLinks Start");
		ArrayList<String> tabs ;
		
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.master.user1"),PropertiesRepository.getString("asmt.reg.tc.pass")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Verify if footer text is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.footer.text.loc"), PropertiesRepository.getString("asmt.footer.text"), 0));
		
		log(logger, "Verify if footer link 'Privacy Policy' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.footer.link.loc"), PropertiesRepository.getString("asmt.footer.link1"), 0));
					
		log(logger, "Click on 'Privacy Policy' link");
		homePage.clickButton(PropertiesRepository.getString("asmt.footer.link.loc"), 0);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		log(logger, "Verifying Privacy Policy Page Title");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.ati.logo.loc"));
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.footer.link1.title")));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		log(logger, "Verify if footer link 'Web Site Terms of Use' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.footer.link.loc"), PropertiesRepository.getString("asmt.footer.link2"), 1));
		
		log(logger, "Click on 'Web Site Terms of Use' link");
		homePage.clickButton(PropertiesRepository.getString("asmt.footer.link.loc"), 1);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		log(logger, "Verifying Web Site Terms of Use Page Title");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.ati.logo.loc"));
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.footer.link2.title")));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		log(logger, "Verify if footer link 'User Terms and Conditions' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.footer.link.loc"), PropertiesRepository.getString("asmt.footer.link3"), 2));
		
		log(logger, "Click on 'User Terms and Conditions' link");
		homePage.clickButton(PropertiesRepository.getString("asmt.footer.link.loc"), 2);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		log(logger, "Verifying User Terms and Conditions Page Title");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.ati.logo.loc"));
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.footer.link3.title")));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		log(logger, "Verify if footer link 'ATI Product Solutions' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.footer.link.loc"), PropertiesRepository.getString("asmt.footer.link4"), 4));
		
		log(logger, "Click on 'ATI Product Solutions' link");
		homePage.clickButton(PropertiesRepository.getString("asmt.footer.link.loc"), 4);
		tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		log(logger, "Verifying ATI Product Solutions Page Title");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.ati.logo.loc"));
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.footer.link4.title")));
				
		log(logger, "ASMT_559_FooterLinks Ends");		
	}	
	
	/**
	 * Covering : ASMT_552_532
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_552_532")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_552_532:Verify the text field of FIBA and FIBN question types")
	public void ASMT_552_FIBAFIBNFunc() throws Exception {
		
		log(logger, "ASMT_552_FIBAFIBNFunc Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.fiba.assessment"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 2){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.fiba.assessment"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}		
		
		logger.info("entering correct answers with case insensitive");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.fiba.input.field.loc"))).sendKeys(PropertiesRepository.getString("asmt.fiba.correcr.answer.mixedCase"));
		
		log(logger, "Clicking on Next button ");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).sendKeys(Keys.ENTER);
		
		log(logger, "Verify if Rational Page is displayed");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.correct.answer.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Verify if 'Correct' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.rational.page.correct.answer.loc"), "CORRECT", 0));
		
		log(logger, "Clicking on Next button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).sendKeys(Keys.ENTER);
		
		int minQtnNum = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		
		logger.info("entering correct answers with case insensitive");	
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.fiba.input.field.loc"))).sendKeys(PropertiesRepository.getString("asmt.fiba.correcr.answer.mixedCase"));
				
		log(logger, "Clicking on Hit Left arrow keyboard button ");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.fiba.input.field.loc"))).sendKeys(Keys.LEFT);
		
		log(logger, "Verify if we are still on the same question and not moved to previous question");
		VerificationHandler.verifyTrue(minQtnNum == Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()));
		
		log(logger, "Clicking on Hit Right arrow keyboard button ");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.fiba.input.field.loc"))).sendKeys(Keys.RIGHT);
		
		log(logger, "Verify if we are still on the same question and not moved to previous question");
		VerificationHandler.verifyTrue(minQtnNum == Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()));
			
		log(logger, "ASMT_552_FIBAFIBNFunc Ends");

	}
	
	/**
	 * Covering : ASMT_356
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_356")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_356:Verify all glossary words are displayed on selecting tab's in glossary pop-up.")
	public void ASMT_356_ToolsTabs() throws Exception {
		
		log(logger, "ASMT_356_ToolsTabs Start");
			
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
		
		log(logger, "Clicking on Quiz Assessment ");
		quizBankPage.clickQuizModuleButtonByName(PropertiesRepository.getString("asmt.quiz.name.new"));
				
		log(logger, "Verify if Communication module is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.cardback.module.list.loc"),
				PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"), 0));
		
		log(logger, "Clicking on Begin Quiz button for Communication Quiz");
		quizBankPage.clickBeginQuizInCardBack(PropertiesRepository.getString("asmt.quiz.cardback.module.name.new"));		
		
		log(logger, "Verify if Tools button is displayed");
		quizBankPage.switchToAssessmentFrameHandler();
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.quiz.tools.btn.loc", 0));		
				
		log(logger, "Click on Tools button and Verifying if Glossary, Calculator, Critical Thinking Guide are displayed");
		VerificationHandler.verifyTrue(quizBankPage.verifyToolsSection());
		
		log(logger, "Clicking 'Critical Thinking Guide' button");
		maintenanceScriptPage.switchToAssessmentFrameHandler();
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.button.loc",2);
		
		log(logger, "Verify 'Critical Thinking Guide' popup header");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.critical.thinking.popup.title.loc"),
				"Critical Thinking Guide", 0));
		
		log(logger, "Verify 'Critical Thinking Guide' popup 'INTRODUCTION' tab");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.critical.thinking.popup.tabs.loc"),
				"INTRODUCTION", 0));		
		
		log(logger, "Verify 'Critical Thinking Guide' popup 'KNOWLEDGE/CLINICAL JUDGMENT' tab");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.critical.thinking.popup.tabs.loc"),
				"KNOWLEDGE/CLINICAL JUDGMENT", 1));
		
		log(logger, "Verify 'Critical Thinking Guide' popup 'PRIORITY-SETTING FRAMEWORKS' tab");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.critical.thinking.popup.tabs.loc"),
				"PRIORITY-SETTING FRAMEWORKS", 2));
		
		log(logger, "Verify 'Critical Thinking Guide' popup 'CRITICALLY READING TEST ITEMS' tab");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.critical.thinking.popup.tabs.loc"),
				"CRITICALLY READING TEST ITEMS", 3));
				
		log(logger, "ASMT_356_ToolsTabs Ends");
		
	}
	
}
