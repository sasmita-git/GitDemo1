package com.automation.asmt.regression.scenario;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

public class ContinuePracticeTest extends BaseTest {
	
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
	private String downloadFilepath = null;
	
	@BeforeMethod
	public void ContinuePracticeTest() throws Exception {
		
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
	 * Covering : ASMT_222_223_49_289_296
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_222_223_49_289_296")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_222_223_49_289_296 -- Verify Continue Assessment functionality")
	public void ASMT_222_223_ContinueBtnFun() throws Exception {
		
		log(logger, "ASMT_222_223_ContinueBtnFun Start");
		
		//for TC ASMT-49 ---Download file
		downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.master.user1"),PropertiesRepository.getString("asmt.test11.password")));
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
		assessmentCommonPage.completeContinueStateAssessmentNewNext( );		
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying if Begin button is displayed for the assessment on the card front");
		VerificationHandler.verifyTrue(assessmentCommonPage.verifybeginContinueBtnCF(PropertiesRepository.getString("asmt.cf.retake.btn.loc"), PropertiesRepository.getString("asmt.only.drag.drop.questions")));	
		
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.only.drag.drop.questions"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		}			
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Answer one question");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, true, true, false, false));
		
		log(logger, "Close assessment page");
		assessmentCommonPage.clickButton(PropertiesRepository.getString("asmt.assessment.close.button.loc"), 0);
		assessmentCommonPage.clickButton(PropertiesRepository.getString("asmt.assessment.close.confirm.yes.loc"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));	
		
		log(logger, "Verifying if Continue button is displayed for the assessment on the card front");
		VerificationHandler.verifyTrue(assessmentCommonPage.verifybeginContinueBtnCF(PropertiesRepository.getString("asmt.cf.continue.btn.loc"), PropertiesRepository.getString("asmt.only.drag.drop.questions")));	

		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.only.drag.drop.questions"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");	
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Verifying if Question number is 2");
		VerificationHandler.verifyTrue((quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText().equals("2")));		
		
		log(logger, "Complete the Assessment");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, true, false, true));
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		//Covering : ASMT-ASMT-49
		
		log(logger, "Verify if Download button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.ipp.download.btn.loc", 0));
		
		homePage.deleteFileExists(downloadFilepath);
		
		log(logger, "Click on 'Download report' link");
		homePage.clickButton(PropertiesRepository.getString("asmt.ipp.download.btn.loc"));
		
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
		
		log(logger, "ASMT_222_223_ContinueBtnFun Ends");		
	}	
	

	/**
	 * Covering : ASMT_186
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_186")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_186 -- Verify Previous/Continue buttons functionality in Angularv")
	public void ASMT_186_ContinueBtnFun() throws Exception {
		
		log(logger, "ASMT_186_ContinueBtnFun Start");
		
		//Steep 1-5 is Covered in Test Case ASMT_275_186_592_PreviousDDFun.
		
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
		
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.no.previous.assessment"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Complete Practice Assessment if its on the last question");
		int minQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText());
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		if(minQtnTextNo == maxQtnTextNo){
		assessmentCommonPage.completeContinueStateAssessmentNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.no.previous.assessment"));				
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}	
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Answer one question");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, true, true, false, false));
		
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));		
		
		log(logger, "ASMT_186_ContinueBtnFun Ends");		
	}	
	
	
}
