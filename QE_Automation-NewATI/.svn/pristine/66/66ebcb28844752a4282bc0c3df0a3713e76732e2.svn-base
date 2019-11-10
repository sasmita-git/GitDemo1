package com.automation.newati.myati.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PaymentsPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class PracticeAssessmentTest2 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private MyResultsTabPage myResultsTabPage;
	private LearnTabPage learnTabPage;
	private ImproveTabPage improveTabPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private PaymentsPage paymentsPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		learnTabPage = new LearnTabPage(driver);
		improveTabPage = new ImproveTabPage(driver);
		paymentsPage = new PaymentsPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-39")
	@Test(priority = 1, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify rationale and if answer can be changed for practice assessments")
	public void  NewATI39_VerifyPracticeRationaleAndAnswers() throws Exception {
		log(logger, "NewATI39_VerifyPracticeRationaleAndAnswers Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2.costume"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Practice value from TypeDD");
		
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", "sixquestions");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Take the assessment");
		VerificationHandler.verifyTrue(practiceAssessmentPage.takeTestVerifyRationaleAndDisableFuncationality(false, false, true, false), 
				"Unable to verify the rationale and disabled option functionality");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify the IPP page is opened or not ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  log(logger, "Launch assessment from Recent Activity");
		  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.assessment.recent.activity.loc"),0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  
		  log(logger, "Verify element after opening. ");
		  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		logger.info("NewATI39_VerifyPracticeRationaleAndAnswers Ends");

	}
	
	@TestAnnotations(testID="NewATI-49")
	@Test(priority = 2, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify if report is downloaded into the machine after a practice assessment is taken")
	public void  NewATI49_verifyDownloadedReportAfterPracticeAssessment() throws Exception {
		log(logger, "NewATI49_verifyDownloadedReportAfterPracticeAssessment39_PracticeRationaleAndAnswers Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2.new"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment Name");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", PropertiesRepository.getString("new-atitesting.testtab.teas.v.b.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
//		log(logger, "Verifying IPP Header");
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
//		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		//Step 3
//		log(logger, "Clicking on My ATI Tab");
//		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(1);
//
//		log(logger, "Clicking on Test Tab");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
//		log(logger, "Selecting Practice value from TypeDD");
//		
//		log(logger, "Click on assessment");
//		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", "sixquestions_no_rational");
//		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Take the assessment");
//		practiceAssessmentPage.takeTestWithIPPDownload(false, false, false, false);
//		
//		log(logger, "Verify the IPP page is opened or not ");
//		//homePage.verifyIPPPageHeader();
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		//VerificationHandler.verifyTrue(tutorialPage.verifyIPPPageTable(), "IPP is not displayed");
//		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		
		String downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
		homePage.deleteFileExists(downloadFilepath);
		reportPage.clickDownloadReportAfterTest(2);
		tutorialPage.waitForAwhile(10000);
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		 log(logger, "Clicking Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		 
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  log(logger, "Launch smart prep from Recent Activity");
		  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.assessment.recent.activity.loc"),0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  
		  log(logger, "Verify element after opening. ");
		  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		log(logger, "NewATI49_verifyDownloadedReportAfterPracticeAssessment39_PracticeRationaleAndAnswers Ends");
	}
	
	@TestAnnotations(testID="NewATI-380")
	@Test(priority = 3, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify if downloaded report of RN Fundamentals Online Practice Assessment 2013 A is matching the IPP page.")
	public void  NewATI380_verifyDownloadedReportRNFundamentalsPracticeAssessment() throws Exception {
		log(logger, "NewATI380_verifyDownloadedReportRNFundamentalsPracticeAssessment Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(2);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step4
		log(logger, " Navigating to the IPP page of the RN Fundamentals Online Practice 2013 A");
		myResultsTabPage.verifyAndClickPracticeAssessmentName("RN Fundamentals Online Practice 2013 A", true);
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 5
		log(logger, "Verifying Logo in the IPP page.");
		VerificationHandler.verifyTrue(homePage.verifyLogo("new-atitesting.learntab.tutorial.logo"),"Logo is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying practice assessment name in the IPP page.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.rn.fundamentals.value", 
				"new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.header.name.loc", "Practice", 0),"Practice name is not Correct");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if close button is present or not.");
		VerificationHandler.verifyTrue(tutorialPage.verifyCloseButton(), "Close button is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Download report button is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyDownloadButtonPrescence(),"Download Button is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Individual Score is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyIndividualScorePrescence("new-ati.report.Individual.score.loc"),"Individual Score is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Time Spent is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyTimeSpentPrescence(),"Time Spent is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Score Explanation Link is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.score.explanation.link.loc"),"Score Explanation Link is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if User name is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.user.name.value", 
				"new-ati.report.student.details.loc", "User name", 1),"User name is not Correct");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Student Number is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.student.number.value", 
				"new-ati.report.student.details.loc", "Student number", 3),"Student number is not Correct");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Institution name is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.institution.name.value", 
				"new-ati.report.student.details.loc", "Institution name", 5),"Institution name is not Correct");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Program type is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.program.type.value", 
				"new-ati.report.student.details.loc", "Program Type", 7),"Program type is not Correct");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Focused Review Section is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.focused.review.section.loc"),"Focused Review Section is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Content area is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyContentArea("new-ati.report.content.area.column.loc"),"Program type is not displayed.");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Show all topics to review toggle button is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.show.all.topics.toggle.btn.loc"),"Show all topics to review toggle button is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Outcome table header is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.table.headers.loc"),"Outcome table header is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 6
		//Content area is already verified in step 5.
		log(logger, "Verifying if topics to review is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.topics.to.review.count"),"topics to review is not present");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if total number of questions is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyTotalNumberOfQuestions(),"Program type is not displayed.");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if Individual Score is present or not.");
//		VerificationHandler.verifyTrue(reportPage.verifyIndividualScorePrescence("new-ati.report.Individual.score.of.content.area.loc"),"Individual Score is not present");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 7: to check the footer, is not automated as it is already automated in a different test case
		//The footer does not have FAQs and Sitemap.
		
		//Step 8
		String downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
		homePage.deleteFileExists(downloadFilepath);
		reportPage.clickDownloadReportAfterTest(2);
		logger.info("File Downloaded");
		tutorialPage.waitForAwhile(10000);
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
		
		//Step 9 is yet to be implemented 
		
		tutorialPage.waitForAwhile(5000);
		//VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.myresult.page.download.button.loc"));
		log(logger, "NewATI380_verifyDownloadedReportRNFundamentalsPracticeAssessment Ends");

	}
	
	@TestAnnotations(testID="NewATI-522")
	@Test(priority = 4, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "NewATI-522:TC03:Verify if Content Area does not have any Focused Reviews_STU-4100")
	public void  NewATI522_VerifyContentAreaWithNoFocusReviews() throws Exception {
		log(logger, "NewATI522_VerifyContentAreaWithNoFocusReviews Start");
		//Step 1 & 2
		log(logger, "Login to Student portal application");		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Closing pop up");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.popup.close.loc"), 0);
		
		log(logger, "Select content area as 'Fundamentals'");
		learnTabPage.selectFromContentAreaDropdown(PropertiesRepository.getString("new-atitesting.content.area.value.fundamentals"));		
		log(logger, "Verify that focus review is available");
		VerificationHandler.verifyTrue(improveTabPage.verifyFocusedReviewDisplayed());		
		
		log(logger, "Selecting Not Accessed value from ViewDD");
		learnTabPage.selectFromContentAreaDropdown(PropertiesRepository.getString("new-atitesting.content.area.value.admissions"));		
		log(logger, "Verify that focus review is not available");
		VerificationHandler.verifyTrue(improveTabPage.verifyNoFocusedReviewDisplayed(PropertiesRepository.getString("new-atitesting.improve.tab.area"), PropertiesRepository.getString("new-atitesting.improve.tab.area.text.expected")));
		
		logger.info("NewATI522_VerifyContentAreaWithNoFocusReviews Ends");
	}
	
	// test case 16 works only, if the check box question arrives between 2 and n-2 in a practice assessment of n questions 
	@TestAnnotations(testID="NewATI-16")
	@Test(priority = 5, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify the rationale and change the answers of a practice test which has rationale=off and forward-only=off")
	public void  NewATI16_verifyPracticeAsmtWithNoRationale() throws Exception {
		log(logger, "NewATI16_verifyPracticeAsmtWithNoRationale Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2.new.update"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4-9
		log(logger, "Take the assessment");
		VerificationHandler.verifyTrue(practiceAssessmentPage.takePracticeTestAndChangeAnswers(false, false, false, false), "unable to verify Assessment ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify the IPP page is opened or not ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		
		log(logger, "NewATI16_verifyPracticeAsmtWithNoRationale Ends");
	}
	
	@TestAnnotations(testID="NewATI-20")
	@Test(priority = 6, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify the buttons in the modal that pops up after a practice asssessments")
	public void  NewATI20_verifyModalButtonsForPracticeAsmt() throws Exception {
		log(logger, "NewATI20_verifyModalButtonsForPracticeAsmt Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname2.update"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value")),
				"Unable to select Practice from the filter");
		log(logger, "Selecting Practice value from TypeDD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 4 and 5
		log(logger, "Take the assessment to verify the two buttons of the pop up");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(practiceAssessmentPage.takeTestAndVerifyModalForTwoBtns(false, false, false, false),"Unable to complete the assessment");
	
		log(logger, "Verify the IPP page is opened or not ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		
		log(logger, "Click on close button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value")),
				"Unable to select Practice from the filter");
		log(logger, "Selecting Practice value from TypeDD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 6
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Take the assessment to verify the three buttons of the pop up");
		VerificationHandler.verifyTrue(practiceAssessmentPage.takeTestAndVerifyModalForThreeBtnsWhileFlagging(false, false, false, false),"Unable to complete the assessment");
	
		log(logger, "Verify the IPP page is opened or not ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on close button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value")),
				"Unable to select Practice from the filter");
		log(logger, "Selecting Practice value from TypeDD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 7 and 8
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Take the assessment to verify the three buttons of the pop up after flagging all the questions");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(practiceAssessmentPage.takeTestByFlaggingAll(false, false),"Unable to complete the assessment");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify the IPP page is opened or not ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.waitForAwhile(5000);		
		log(logger, "NewATI20_verifyModalButtonsForPracticeAsmt Ends");
	}
	
	@TestAnnotations(testID="NewATI-19")
	@Test(priority = 7, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify the flag button and the order of the flagged questions when reviewing the flagged questions")
	public void  NewATI19_verifyFlagBtnFunctionalityForPracticeAsmt() throws Exception {
		log(logger, "NewATI19_verifyFlagBtnFunctionalityForPracticeAsmt Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname.asmnt"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.teas.practice.assessment.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4 and 5
		log(logger, "Take the assessment to verify the two buttons of the pop up");
		VerificationHandler.verifyFalse(practiceAssessmentPage.takeTestAndFlagForTEAS(false, false, false, false),"Unable to complete the TEAS assessment");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "NewATI19_verifyFlagBtnFunctionalityForPracticeAsmt Ends");
	}

	@TestAnnotations(testID="NewATI-23")
	@Test(priority = 8, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = "Verify the changes in pause time and assessment time of a practice assessment")
	public void  NewATI23_verifyPauseAndAsmtTimeForPracticeAsmt() throws Exception {
		log(logger, "NewATI23_verifyPauseAndAsmtTimeForPracticeAsmt Start");
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		
		logger.info("userId: "+userId);
		//Step 1 & 2
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));

		paymentsPage.clickOnAddProductButton();
		log(logger, "Click on AddProduct Button");
		
		paymentsPage.enterSelfPayProductID(PropertiesRepository.getString("new-atitesting.practice.assessment.sixquestions.no.rational.id.value"));
		log(logger, "Entering Sixquestions_without_rational assessment Id");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
			
		paymentsPage.enterSelfPayProductPassword(PropertiesRepository.getString("new-atitesting.practice.assessment.sixquestions.no.rational.pwd.value"));
		log(logger, "Entering Sixquestions_without_rational assessment Password");
		
		paymentsPage.clickOnAddProductContinueButton(false);
		log(logger, "Clicking on Add Product Continue Button");
		
		log(logger, "Close the assessment");
		practiceAssessmentPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		
		//---------------Change this to Not Accessed
		//Step 4
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value")); //change to 3 or 2 for accessed
		log(logger, " Test Tab View DD Not Accessed Option");
		
		//Step 5
		log(logger, "Click on BEGIN button of the assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//Step 6
		log(logger, "Take the assessment and answer one question");
		int QNo = practiceAssessmentPage.takeTestAndAnswerOneQ(false, false, false, false);
		logger.info("QNo in test page : "+QNo);
		
		log(logger, "Close the assessment");
		practiceAssessmentPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 7
		log(logger, "Click on CONTINUE button of the assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
		
		//verify q no
		log(logger, "Verify if last unattempted question is displayed ");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyQuestionNumber(QNo),"Last unattempted question is not displayed.");
		
		//Step 8
		//note asmt time and close it
		log(logger, "Note the assessment time");
		int asmtTime=practiceAssessmentPage.captureAsmtAndPauseTime("Assessment");
		
		log(logger, "Close the assessment");
		practiceAssessmentPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//Step 9-15
		//click on prac asmt and verify asmnt time and pause time
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"),
				PropertiesRepository.getString("new-atitesting.practice.assessment.without.rationale.value"));
					
		log(logger,"Verify if the assessment time continues from the previous time");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyAsmtAndPauseTime(asmtTime),"Unable to verify assessment time and pause time .");

		log(logger, "Click on close button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);

		tutorialPage.waitForAwhile(5000);		
		log(logger, "NewATI23_verifyPauseAndAsmtTimeForPracticeAsmt Ends");
	}
	
	//PDF vaerification is not done.
	@TestAnnotations(testID="NewATI-381")
	@Test(priority = 9, alwaysRun = true, enabled = true,groups = {"Regression, Smoke"}, description = " NewATI-381:Individual Performance Profile : For practice assessment (Test of Essential Academic Skills V)")
	public void  NewATI381_verifyDownloadedReportForTEASV() throws Exception {
		log(logger, "NewATI381_verifyDownloadedReportForTEASV Start");
		//Step 1 & 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.teas.share.results.uname"), 
				PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//Step4
		log(logger, " Navigating to the IPP page of the RN Fundamentals Online Practice 2013 A");
		myResultsTabPage.verifyAndClickPracticeAssessmentName(PropertiesRepository.getString("new-atitesting.onlinestore.test.TEAS.name"), true);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, " Verifying if IPP page is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(),"IPP is not displayed");
				
		//Step 5
		log(logger, "Verifying Logo in the IPP page.");
		VerificationHandler.verifyTrue(homePage.verifyLogo("new-atitesting.learntab.tutorial.logo"),"Logo is not displayed");
		
		log(logger, "Verifying practice assessment name in the IPP page.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-atitesting.onlinestore.test.TEAS.name", 
				"new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.header.name.loc", "Practice", 0),"Practice name is not Correct");
		
		log(logger, "Verifying if close button is present or not.");
		VerificationHandler.verifyTrue(tutorialPage.verifyCloseButton(), "Close button is not present");
		
		log(logger, "Verifying if Download report button is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyDownloadButtonPrescence(),"Download Button is not present");
		
		log(logger, "Verifying if Score Explanation Link is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.score.explanation.link.loc"),"Score Explanation Link is not present");
		
		log(logger, "Verifying if Individual Score is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyIndividualScorePrescence("new-ati.report.Individual.score.loc"),"Individual Score is not present");
		
		log(logger, "Verifying if Time Spent is present or not.");
		VerificationHandler.verifyTrue(reportPage.verifyTimeSpentPrescence(),"Time Spent is not present");
		
		log(logger, "Verifying if name is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-atitesting.ipp.page.user.name.value", 
				"new-ati.report.student.details.loc", "User name", 1),"User name is not Correct");
		
		log(logger, "Verifying if Student Number is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-atitesting.ipp.page.stagerega1.student.number.value", 
				"new-ati.report.student.details.loc", "Student number", 3),"Student number is not Correct");
		
		log(logger, "Verifying if Institution name is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.institution.name.value", 
				"new-ati.report.student.details.loc", "Institution name", 5),"Institution name is not Correct");
		
		log(logger, "Verifying if Program type is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPElements("new-ati.report.program.type.value", 
				"new-ati.report.student.details.loc", "Program Type", 7),"Program type is not Correct");
		
		log(logger, "Verifying if Content area is present or not.");
		VerificationHandler.verifyFalse(reportPage.verifyContentArea("new-ati.report.content.area.column.loc"),"Program type is not displayed.");
		
		log(logger, "Verifying if Show all topics to review toggle button is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.show.all.topics.toggle.btn.loc"),"Show all topics to review toggle button is not present");
		
		log(logger, "Verifying if Outcome table header is present or not.");
		VerificationHandler.verifyTrue(reportPage.isElementDisplayed("new-ati.report.table.headers.loc"),"Outcome table header is not present");
		
		//Step 6
		//Content area is already verified in step 5.
		log(logger, "Clicking on the Show all topics to review toggle.");
		reportPage.clickButton(PropertiesRepository.getString("new-ati.report.teas.topics.to.review.toggle.btn.loc"), 0);
		
		log(logger, "Verifying if topics to review is present or not.");
		VerificationHandler.verifyFalse(reportPage.verifyElement("new-ati.report.teas.major.content.area.topics.to.review.block.loc"),
				"topics to review is not present");
		
		log(logger, "Verifying if total number of questions is present or not.");
		VerificationHandler.verifyFalse(reportPage.verifyTotalNumberOfQuestions(),"Program type is not displayed.");
		
		log(logger, "Verifying if Individual Score is present or not in the major content area.");
		VerificationHandler.verifyTrue(reportPage.verifyIndividualScorePrescence("new-ati.report.Individual.score.of.content.area.loc"),"Individual Score is not present");	

		//Step 7: to check the footer, is not automated as it is already automated in a different test case
		log(logger, "Verifying the copyright message.");
		VerificationHandler.verifyTrue(homePage.verifyFooter(), "Copyright message is not displayed.");
		
		log(logger, "Verification of presence of Privacy policy, Terms of Use, User Terms and ATI products.");
		VerificationHandler.verifyTrue(homePage.verifyHomeTabBottomLinks(), "Footer links are not present.");
		
		//Step 8
		/*String downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
		homePage.deleteFileExists(downloadFilepath);
		reportPage.clickDownloadReportAfterTest(2);
		logger.info("File Downloaded");
		tutorialPage.waitForAwhile(10000);
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
		
		//Step 9 is yet to be implemented 
		
		tutorialPage.waitForAwhile(5000);*/

		log(logger, "NewATI381_verifyDownloadedReportForTEASV Ends");

	}
}
