package com.automation.newati.results;

import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class MyResultsTabTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private MyResultsTabPage myResultsTabPage;
	private BaseHandler basehandler;
	private MyATITabMainPage myATITabMainPage;
	private MyResultsTabPage myResultsPage;
	private TutorialPage tutorialPage;
	String downloadFilepath = null;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		basehandler = new BaseHandler(driver);
		myResultsPage = new MyResultsTabPage(driver);
		tutorialPage = new TutorialPage(driver);
		myATITabMainPage=new MyATITabMainPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-605")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-605:Verify the Content Area for Item Type Regression Proctor Assessment's IPP page::My Results")
	public void NewATI605_VerifyITRIPPPage() throws Exception {
		logger.info("Method : NewATI605_VerifyITRIPPPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		// Step 2 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying ITR in My Results Page");
		myResultsTabPage.verifyAndClickProctorAssessmentName("Item Type Regression Test (P)", true);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying ITR IPP Page details");
		VerificationHandler.verifyTrue(myResultsTabPage.verifyITRIPPPageDetails(), "Unable to verify ITR IPP Page Detials");
		logger.info("NewATI605_VerifyITRIPPPage End");
	}
	
	@Test(priority = 2, description = "NewATI-392:Verify the Content Area for TEAS Proctor Assessment's IPP page")
	public void NewATI392_VerifyTEASIPPPage() throws Exception {
		logger.info("Method : NewATI392_VerifyTEASIPPPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		// Step 2 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying ITR in My Results Page");
		myResultsTabPage.verifyAndClickProctorAssessmentName("Test of Essential Academic Skills V", true);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying ITR IPP Page details");
		VerificationHandler.verifyTrue(myResultsTabPage.verifyTEASIPPPageDetails(), "Unable to verify TEAS IPP Page Detials");
		logger.info("NewATI392_VerifyTEASIPPPage End");
	}

	
	@Test(priority = 3, description = "NewATI-47: My Results Tab feature [Version : 1]")
	public void NewATI47_VerifyMyresultDownload() throws Exception {
		logger.info("Method : NewATI47_VerifyMyresultDownload Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		// Step 2 Start
		
		log(logger, "Clicking on MyResults Tab");
		homePage.clickTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.results.heading")), "Unable to verify My Results Tab ");
		log(logger, "Verify My result page");
		VerificationHandler.verifyTrue(myResultsTabPage.verifyResultSection(), "Unable to verify My Results Tab ");
		log(logger, "Verify Print Report button");	
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-ati.report.download.loc"),"Download report is not displayed");
	
		logger.info("NewATI47_VerifyMyresultDownload End");
	}
	
	@Test(priority = 4, description = "NewATI-620: Verification of Life: Student Decision Log display controll on IPP page [Version : 1]")
	public void NewATI620_VerifyDecisionlogNotPresent() throws Exception {
		logger.info("Method : NewATI620_VerifyDecisionlogNotPresent Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"), PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		// Step 2 Start
		log(logger, "Clicking on My Results Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(2);
	
		//Click on RealLife Simulation
		myResultsTabPage.clickSimulationModuleByName("COPD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		
		log(logger, "Verify on IPP page bottom no decission log  should be displayed link should be displayed if disabled by faculty");
		VerificationHandler.verifyTrue(!(basehandler.findElement("div[data-bind='visible: IsEnableDecisionLog()'] div a").isDisplayed()));
		
		logger.info("NewATI620_VerifyDecisionlogNotPresent End");
	}
	
	@TestAnnotations(testID="NewATI-889")
	 @Test(priority = 5, description = "Verify if Dynamic Quizzes result available under My Result")
	 public void NewATI889_VerifyDynamicQuizResults() throws Exception {
	  logger.info("Method :NewATI889_VerifyDynamicQuizResults starts");
	  String cardbackAccesseddate = "";
	  String myResultsPageAccessDate = "";
	  loginPage.loginToApplication("stagesmoke18", "Test123");
	  
	  /*log(logger, "Clicking MyATI Tab");
	  homePage.clickTab(1);
	  
	  // Click on Learn Tab
	  log(logger, "Clicking on Learn Tab");
	  homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  tutorialPage.selectTutorialFromDropDown(PropertiesRepository
	    .getString("new-atitesting.allDropdown.quizbans.value"));
	  
	  log(logger, "Clicking on Quiz Bank Module");
	  tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.name"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/
	  
	  log(logger, "Clicking on My Results Tab");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.clickTab(2);
	  
	  log(logger, "Verifyig My Results Page is displayed");
		VerificationHandler.verifyTrue(
				myResultsPage.verifyMessage(PropertiesRepository.getString("new.atitestig.my.results.header.loc"),
						PropertiesRepository.getString("new.atitestig.my.results.header.value")));
		
		log(logger, "Verify LS name, header and section");
		VerificationHandler.verifyTrue(
		myResultsTabPage.verifyLSResultsSection(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.2.0.value"), true),
		"Unable to verify LS name, header and section");
		
		log(logger, "Verifying IPP Page header Name");
		VerificationHandler.verifyTrue(
				myResultsPage.verifyMessage(PropertiesRepository.getString("newati.ipp.page.header.loc"), 0,
						PropertiesRepository.getString("new-ati.report.header.value")),
				"Unable to Verify Tutorial Name");

	  /*log(logger, "click on Quiz result");
	  myResultsTabPage.clickQuizModuleReuslt("Communication");
	  
	  log(logger,"click on close button at cardback");
	  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
	  
	  log(logger, "Get the Last Date Accessed from my results page for Quiz");
	  myResultsPageAccessDate = myResultsPage.getLastDateAccessed(PropertiesRepository.getString("newati.myati.assessment.Quiz.Tutorial.value"), PropertiesRepository.getString("newati.myati.assessment.Quiz.Tutorial"));
	  
	  log(logger, "Verify if Accessed time should show up in MyResults page and time showing up in Card back of the tutorial and Myresults page should match");
	  VerificationHandler.verifyTrue(cardbackAccesseddate.equals(myResultsPageAccessDate)); 
	  
	  List<WebElement> moduleList = basehandler.findElements("span[data-atiid='TutorialModuleResults_LastDateAccessed']");
	  
	  log(logger, "Verify if IPP page should display showing up Time spent which should match across Myresults page and in card back");
	  VerificationHandler.verifyTrue(cardbackAccesseddate.equals(moduleList.get(0).getText()));
	  
	  log(logger, "Verify if  Download Report button is displayed");
	  homePage.isElementDisplayed("new.atitesting.downloaf.button.ipp.page.loc");*/
	  
	  logger.info("Method :NewATI889_VerifyDynamicQuizResults Ends");
	  
	  
	 }
}
