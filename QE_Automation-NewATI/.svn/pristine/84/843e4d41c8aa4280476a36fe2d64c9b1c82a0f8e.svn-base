package com.automation.newati.myati.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PracticeAssessmentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-540:Validate that a student is able to take and complete Item Type Regression practice assessment")
	public void  NewATI540_TypeRegressionPracticeAssessment() throws Exception {
		log(logger, "NewATI540_TypeRegressionPracticeAssessment Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment Name");
		//practiceAssessmentPage.clickAssessment("practice march33");
		//tutorialPage.clickModuleButtonByName("practice march33");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", "practice march33");
		
		testTabPage.takeAssessmentTest(false,"Finalize and View Results");

		log(logger, "Verifying IPP Page Header");
		reportPage.verifyIPPpageObjects();
		log(logger, "NewATI540_TypeRegressionPracticeAssessment End");
	}
	
	//@Test(priority=1,description = "Smoke NewATI-45:Check for Calculator")
	public void  NewATI45_verifyCalculatorFunctionality() throws Exception {
		log(logger, "NewATI45_verifyCalculatorFunctionality Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		log(logger, "Select  Tutorial Module name");
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.pharmacology.name"));
		
		practiceAssessmentPage.verifyCalculatorFunctionality();
		
		log(logger, "NewATI45_verifyCalculatorFunctionality End");
	}
	
	@TestAnnotations(testID="NewAT-462")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Practice Assessments>Complete Assessment Section actions without flagging.::Practice Assessment")
	public void  NewAT462_VerifyTEAS() throws Exception {
		log(logger, "NewAT462_VerifyTEAS Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.nonpulse"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment Name");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", PropertiesRepository.getString("new-atitesting.testtab.teas.v.b.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 1");
		tutorialPage.takeTestTEAS(false, false, true, false);
		
		log(logger, "Taking Assessment 2");
		tutorialPage.takeTest(false, false, true, false);
		
		log(logger, "Taking Assessment 3");
		tutorialPage.takeTest(false, false, true, false);
		
		log(logger, "Taking Assessment 4");
		tutorialPage.takeTest(false, false, true, false);
		
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify recent activity name");
		boolean result=homePage.verifyRecentActivity1("ATI-ASMT-CPNP");
		VerificationHandler.verifyTrue(result, "Recent activity is not displayed");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 log(logger, "Clicking Home Tab");
		  homePage.clickTab(0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  log(logger, "Launch smart prep from Recent Activity");
		  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.assessment.recent.activity.loc"),0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  
		  log(logger, "Verify element after opening. ");
		  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		log(logger, "NewAT462_VerifyTEAS End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, description = "NewATI-19:Practice Assessments>Complete Assessment Section actions after flagging.")
	public void  NewAT19_VerifyCompleteAssessmentSection_1() throws Exception {
		log(logger, "NewAT19_VerifyCompleteAssessmentSection Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.flag.assessment.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		log(logger, "Select  Tutorial Module name");
		practiceAssessmentPage.clickAssessment(PropertiesRepository.getString("new-atitesting.test.tab.practice.assessment.flag.test.case.name"));
		
		boolean takeAssessment = practiceAssessmentPage.takeAssessment("Flag");
		VerificationHandler.verifyTrue(takeAssessment, "Error Occuring while taking flagged questions in the assessment");
		
		log(logger, "NewAT19_VerifyCompleteAssessmentSection End");
	}
	
	@Test(description = "Smoke P2 description = NewATI-19:Practice Assessments>Complete Assessment Section actions after flagging.")
	public void NewAT19_VerifyCompleteAssessmentSection() throws Exception {
		log(logger, "NewAT19_VerifyCompleteAssessmentSection Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.flag.assessment.uname"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		log(logger, "Select  Tutorial Module name");
		practiceAssessmentPage.clickAssessment(PropertiesRepository.getString("new-atitesting.test.tab.practice.assessment.flag.test.case.name"));

		log(logger, "Taking practice Assessment");
		//practiceAssessmentPage.takePracticeAssessmentWithMultipleSections(true,false);
		practiceAssessmentPage.takeTestNew(false,false,true,false);
		
		practiceAssessmentPage.takeTestNew(false,false,true,false);
		
		practiceAssessmentPage.takeTestNew(false,false,true,false);
		
		practiceAssessmentPage.takeTestNew(false,false,true,false);

		practiceAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.downloadreportLoc"));
		
		practiceAssessmentPage.waitForAwhile(6000);
				
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyReportHeaderSecIsDisplayed(),"Unable to find Individual Report Section");
		log(logger, "verify report section is displayed or not");

		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyDownloadReportActionIsEnabled(),"Unable to find Download Report Action button");
		
		practiceAssessmentPage.clickOnCloseButton();
		log(logger, "verify download report action button is enabled or not");
		log(logger, "NewAT19_VerifyCompleteAssessmentSection End");
	}
}
