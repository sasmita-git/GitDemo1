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

public class GlossaryTest extends BaseTest {

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
	 * Covering : ASMT_247
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_247")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_247:Verify all glossary words are displayed on selecting tab's in glossary pop-up.")
	public void ASMT_247_GlossaryTabs() throws Exception {
		
		log(logger, "ASMT_247_GlossaryTabs Start");
			
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
		
		log(logger, "Clicking Glossary button");
		maintenanceScriptPage.switchToAssessmentFrameHandler();
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.button.loc",0);
		
		log(logger, "Verify if Glossary popup with title as 'Glossary' is displayed");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(
				PropertiesRepository.getString("asmt.glossary.dialog.title.loc"),
				PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"), 0));
		
		log(logger, "Verify if Glossary popup by default starts with 'A'");
		VerificationHandler.verifyTrue(homePage.baseHandler.findElement(PropertiesRepository.getString("asmt.glossary.list.loc")).getText().toUpperCase().startsWith("A"));		
		
		log(logger, "Clicking 'A-F' tab");
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.tab.list.loc",0);
		
		log(logger, "Verify if Glossary popup starts with 'A'");
		VerificationHandler.verifyTrue(homePage.baseHandler.findElement(PropertiesRepository.getString("asmt.glossary.list.loc")).getText().toUpperCase().startsWith("A"));
		
		log(logger, "Clicking 'G-L' tab");
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.tab.list.loc",1);
		
		log(logger, "Verify if Glossary popup starts with 'G'");
		VerificationHandler.verifyTrue(homePage.baseHandler.findElement(PropertiesRepository.getString("asmt.glossary.list.loc")).getText().toUpperCase().startsWith("G"));
		
		log(logger, "Clicking 'M-R' tab");
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.tab.list.loc",2);
		
		log(logger, "Verify if Glossary popup starts with 'M'");
		VerificationHandler.verifyTrue(homePage.baseHandler.findElement(PropertiesRepository.getString("asmt.glossary.list.loc")).getText().toUpperCase().startsWith("M"));		
		
		log(logger, "Clicking 'S-Z' tab");
		maintenanceScriptPage.clickLinkFromList("asmt.glossary.tab.list.loc",3);
				
		log(logger, "Verify if Glossary popup starts with 'S'");
		VerificationHandler.verifyTrue(homePage.baseHandler.findElement(PropertiesRepository.getString("asmt.glossary.list.loc")).getText().toUpperCase().startsWith("S"));
		
		log(logger, "ASMT_247_GlossaryTabs Ends");		
	}	

}
