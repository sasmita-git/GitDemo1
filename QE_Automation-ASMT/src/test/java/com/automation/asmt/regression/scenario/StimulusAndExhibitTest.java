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

public class StimulusAndExhibitTest extends BaseTest {

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
	 * Covering : ASMT_671_411_169
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_671_411_169")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_671_411_169:Verify Instruction for stimulus question is displayed in practice assessment.")
	public void ASMT_671_StimulusFunc() throws Exception {
		
		log(logger, "ASMT_671_StimulusFunc Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.stimulus.assessment"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 1");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 1){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.stimulus.assessment"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}		
	
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Verify if Stimulus question is loaded");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.stimulus.page.number.loc"),"Stimulus" , 0));
		
		log(logger, "Verify if instruction set is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.stimulus.instruction.loc", 0));
			
		log(logger, "Verify if Stimulus Box is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.stimulus.box.loc", 0));
		
		log(logger, "Verify if Stimulus Text and Image is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.stimulus.text.image.loc", 0));
		
		log(logger, "Verify if Stimulus question number format");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.stimulus.page.number.loc"),"Stimulus Question #: 1 of 2" , 0));
		
		log(logger, "Answer one Question");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest_AnswerOnlyOneQuestion(false, false, true, false));
		
		log(logger, "Verify if Stimulus question number format");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.stimulus.page.number.loc"),"Stimulus Question #: 2 of 2" , 0));
				
		log(logger, "ASMT_671_StimulusFunc Ends");		
	}	
	
	/**
	 * Covering : ASMT_234_550_218_416
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_234_550_218_416")
	@Test(priority = 2, alwaysRun = true, groups = { "Regression" }, description = "ASMT_234_550_218_416: Verify Exhibit section functionality")
	public void ASMT_234_ExhibitFunc() throws Exception {
		
		log(logger, "ASMT_234_ExhibitFunc Start");
			
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
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.exhibit.assessment"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
				
		log(logger, "Complete Practice Assessment if its not from begining and question greter than 3");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());		
		if(minQtnTextNo > 3){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.exhibit.assessment"));		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Verify if Exhibit Question is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.button.loc", 0));
		
		log(logger, "Click on Exhibit button");
		homePage.clickButton(PropertiesRepository.getString("asmt.exhibit.button.loc"), 0);
		
		log(logger, "Verify if Exhibit Popup is displayed");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.exhibit.popup.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.popup.loc", 0));
		
		//TC -218
		log(logger, "Verify if Exhibit Popup has 4 tabs");
		List<WebElement> tabList =(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.exhibit.popup.tabs.loc"))));	
		VerificationHandler.verifyTrue(tabList.size()==4);
		
		//TC-416		
		log(logger, "Verify if Exhibit Popup has 4 tabs with different names");	
		VerificationHandler.verifyTrue(quizBankAssPage.verifyExhibitPopupTabsUniqueness());
		
		log(logger, "Verify if Exhibit Popup close button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.popup.close.btn.loc", 0));
				
		log(logger, "Click outside exhibit popup");
		homePage.clickButton(PropertiesRepository.getString("asmt.exhibit.popup.outside.loc"), 0);
		
		log(logger, "Verify if Exhibit Popup is still displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.popup.loc", 0));
		
		log(logger, "Click on Exhibit popup close button");
		homePage.clickButton(PropertiesRepository.getString("asmt.exhibit.popup.close.btn.loc"), 0);
		
		log(logger, "Verify if Exhibit Popup is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.exhibit.popup.loc", 0)));
		
		log(logger, "Answer one Question to be on Rational page");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest_AnswerOnlyOneQuestion(false, false, false, false));
		
		log(logger, "Verify if Rational Page is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.rational.page.status.loc", 0));
		
		log(logger, "Verify if Exhibit Button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.button.loc", 0));
		
		log(logger, "Click on Exhibit button on rational page");
		homePage.clickButton(PropertiesRepository.getString("asmt.exhibit.button.loc"), 0);
		
		log(logger, "Verify if Exhibit Popup is displayed on rational page");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.exhibit.popup.loc"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.exhibit.popup.loc", 0));
		
		log(logger, "Verify if Exhibit Popup has 4 tabs even on rational page");
		VerificationHandler.verifyTrue(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.exhibit.popup.tabs.loc"))).size()==4);	
		
		log(logger, "ASMT_234_ExhibitFunc Ends");		
	}	
}
