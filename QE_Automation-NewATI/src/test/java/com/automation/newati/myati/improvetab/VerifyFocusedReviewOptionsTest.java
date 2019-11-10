package com.automation.newati.myati.improvetab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyFocusedReviewOptionsTest extends BaseTest{
	
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private ImproveTabPage improveTabPage;
	private MyReportPage reportPage;
	private WindowHandler windowHandler;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		new LearnTabPage(driver);
		improveTabPage = new ImproveTabPage(driver);
		reportPage = new MyReportPage(driver);
		windowHandler = new WindowHandler(driver);
				
		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.user.name"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-116")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-116:Focused Review Regression Test Case")
	public void NewATI116_verifyFocusedReview() throws Exception{
		log(logger, "NewATI116_verifyFocusedReview Start");
		
		//Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		
		//Step 4
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying if Focused review page is opened.");
		VerificationHandler.verifyEquals(
				improveTabPage.getText(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.assessment.name.loc")),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment"));
		
		windowHandler.switchToFrame(0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//Step 6
		log(logger, "Verifying if the TOC is expanded");
		VerificationHandler.verifyTrue(improveTabPage.verifyElement(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.toc.expanded.list.loc")));
		
		//Step 7
		log(logger, "Verifying if the Expand All link is present. ");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.improve.tab.focused.review.1.0.expand.all.link.loc"));
				
		log(logger, "NewATI116_verifyFocusedReview Ends");
	}
	
	@TestAnnotations(testID="NewATI-985")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = " NewATI-985:To verify Choose Topics button of FR1.0 page.")
	public void NewATI985_VerifyChooseTopicsBtn() throws Exception{
		log(logger, "NewATI985_VerifyChooseTopicsBtn Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		windowHandler.switchToFrame(0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on TOOL button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.button.loc"));
		
		log(logger, "Verifying if Assessment Report is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				0, PropertiesRepository.getString("new-atitesting.focused.review.1.0.assessment.report.value")));
		
		log(logger, "Verifying if Choose Topics is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				1, PropertiesRepository.getString("new-atitesting.focused.review.1.0.choose.topics.value")));
		
		log(logger, "Verifying if Export to PDF is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				2, PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.value")));
				
		//Step 2
		log(logger, "Clicking on Choose Topics.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"), 1);
		
		log(logger, "Verifying if 'Choose from all missed topics' radio button is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.from.missed.topics.radio.loc"));
		
		log(logger, "Verifying if 'Choose from percentage' radio button is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.from.percent.radio.loc"));
		
		log(logger, "Verifying if 'percentage' text field is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.percentage.input.loc"));
		
		log(logger, "Verifying if 'close' button in the modal is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.topics.modal.close.loc"));
		
		log(logger, "Verifying if 'Apply' button in the modal is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.topics.modal.apply.btn.loc"));
		
		log(logger, "Verifying if 'Select all' check box in the modal is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.topics.select.all.check.box.loc"));
		
		log(logger, "Verifying if 'Filter' check box in the modal is present.");
		VerificationHandler.verifyTrue(improveTabPage.isElementDisplayed("new-atitesting.focused.review.1.0.choose.topics.filter.button.loc"));
		
		//Step 3
		log(logger, "Clicking on close button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.choose.topics.modal.close.loc"));
		
		windowHandler.switchToMainWindow();
		log(logger,"Verifying if FR1.0 is displayed.");
		VerificationHandler.verifyEquals(
				improveTabPage.getText(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.assessment.name.loc")),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment"));
		
		log(logger, "NewATI985_VerifyChooseTopicsBtn Ends");
	}
	
	@TestAnnotations(testID="NewATI-986")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-986:To verify Export to PDF functionality for FR1.0 assessment.")
	public void NewATI986_VerifyExportToPDFInFR() throws Exception{
		log(logger, "NewATI986_VerifyExportToPDFInFR Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		windowHandler.switchToFrame(0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 1
		log(logger, "Clicking on TOOL button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.button.loc"));
		
		log(logger, "Verifying if Assessment Report is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				0, PropertiesRepository.getString("new-atitesting.focused.review.1.0.assessment.report.value")));
		
		log(logger, "Verifying if Choose Topics is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				1, PropertiesRepository.getString("new-atitesting.focused.review.1.0.choose.topics.value")));
		
		log(logger, "Verifying if Export to PDF is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				2, PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.value")));
	
		//Step 3
		log(logger, "Clicking on Export to PDF button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),2);
		
		log(logger, "Verifying if the topic names are present");
		VerificationHandler.verifyTrue(improveTabPage.verifyElement(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.topic.names.loc")),
				"Topic names are not present.");
		
		log(logger, "Verifying the presence of the sub-topics");
		VerificationHandler.verifyTrue(improveTabPage.verifyElement(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.sub.topic.names.loc")),
				"Sub-topics are not present.");
		
		//Step 4
		log(logger, "Selecting multiple sub topics.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.sub.topic.names.loc"), 0);
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.sub.topic.names.loc"), 1);
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.sub.topic.names.loc"), 2);
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.sub.topic.names.loc"), 3);

		String downloadFilepath = PropertiesRepository.getString("global.download.location");
		homePage.createDirectory("C:\\download");
		homePage.createDirectory(downloadFilepath);
		homePage.deleteFileExists(downloadFilepath);
		
		log(logger, "Clicking on Export button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.export.btn.loc"));
				tutorialPage.waitForAwhile(10000);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(5000);
		
		log(logger, "Verifying file after download");
		VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath,
				PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.downloaded.file.name.value")), "Unable to verify file exists");
		
		//Step 5
		log(logger, "Clicking on close button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.focused.review.1.0.choose.topics.modal.close.loc"));
		
		windowHandler.switchToMainWindow();
		log(logger,"Verifying if FR1.0 is displayed.");
		VerificationHandler.verifyEquals(
				improveTabPage.getText(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.assessment.name.loc")),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment"));
				
		log(logger, "NewATI986_VerifyExportToPDFInFR Ends");
	}
	
	@TestAnnotations(testID="NewATI-987")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = " NewATI-987:To verify the Assessment Report button Functionality of FR1.0")
	public void NewATI987_VerifyAssessmentReportInFR() throws Exception{
		log(logger, "NewATI987_VerifyAssessmentReportInFR Start");
		
		//Step 1
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on close button if the new features pop up is displayed");
		improveTabPage.clickOnCloseOfNewFeaturesPopup();
		
		//Step 2
		log(logger, "Click on focused review product");
		improveTabPage.clickReviewOfFocusedReview("new-atitesting.learntab.tutorial.fundamentals.online.assessment", 0, 0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		windowHandler.switchToFrame(0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3
		log(logger, "Clicking on TOOL button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.button.loc"));
		
		log(logger, "Verifying if Assessment Report is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				0, PropertiesRepository.getString("new-atitesting.focused.review.1.0.assessment.report.value")));
		
		log(logger, "Verifying if Choose Topics is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				1, PropertiesRepository.getString("new-atitesting.focused.review.1.0.choose.topics.value")));
		
		log(logger, "Verifying if Export to PDF is present ");
		VerificationHandler.verifyTrue(improveTabPage.verifyTextWithBreak(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),
				2, PropertiesRepository.getString("new-atitesting.focused.review.1.0.export.to.pdf.value")));
	
		log(logger, "Clicking on Assessment Report button.");
		improveTabPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.focused.review.1.0.tools.list.loc"),0);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger,"Verifying if IPP page is displayed.");
		VerificationHandler.verifyTrue(reportPage.verifyIPPPageHeader(), "IPP page is not loaded.");
		
		log(logger, "NewATI987_VerifyAssessmentReportInFR Ends");
	}
}
