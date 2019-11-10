package com.automation.newati.regression.testtab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;

public class VerifyPracticeAssessmentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiseAssessmentPage;
	private TutorialPage tutorialPage;
	private MyATITabMainPage myATITabMainPage;
	
	String downloadFilepath = null;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		tutorialPage=new TutorialPage(driver);
		practiseAssessmentPage=new PractiseAssessmentPage(driver);
		myATITabMainPage=new MyATITabMainPage(driver);
	}
	
	@Test(priority=1,description = "NewATI-558:Verify that footer links and key board strokes should be deactivated on the assessment freeze page")
	public void NewATI558_verifyFooterLinksWhenThePageisFreezed() throws Exception {
		log(logger, "NewATI558_verifyFooterLinksWhenThePageisFreezed Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.freezed.assessment.login.uname"), PropertiesRepository.getString("newati.freezed.assessment.login.pwd"));

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
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment Name");
		practiseAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", PropertiesRepository.getString("faculty.portal.testtab.freeze.assessment.name"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify page when assessment gets freezed");
		boolean result=tutorialPage.verifyFreezedPage();
		VerificationHandler.verifyTrue(result);
		
		
		log(logger, "NewATI558_verifyFooterLinksWhenThePageisFreezed End");
	}
	
	@Test(priority=2,description = "NewATI-512:To verify add product button without any product added to students account under MYATI")
	public void NewATI512_verifyAddProductButton() throws Exception {
		log(logger, "NewATI512_verifyAddProductButton Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.freezed.assessment.login.uname"), PropertiesRepository.getString("newati.freezed.assessment.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under learn tab");
		boolean verifyAddProductButton1 = practiseAssessmentPage.verifyAddProductButton("add.product.learn.tab");
		VerificationHandler.verifyTrue(verifyAddProductButton1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under test tab");
		boolean verifyAddProductButton = practiseAssessmentPage.verifyAddProductButton("add.product");
		VerificationHandler.verifyTrue(verifyAddProductButton);
		
		log(logger, "Clicking on apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under test tab");	
		boolean verifyAddProductButton2 = practiseAssessmentPage.verifyAddProductButton("add.product.apply.tab");
		VerificationHandler.verifyTrue(verifyAddProductButton2);
		
		log(logger, "NewATI512_verifyAddProductButton End");
	}
	
	@Test(priority=3,description = "NewATI-508:To verify Move and change appearance of ADD PRODUCT function")
	public void NewATI508_verifyAddProductButtonAppearance() throws Exception {
		log(logger, "NewATI508_verifyAddProductButtonAppearance Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.freezed.assessment.login.uname"), PropertiesRepository.getString("newati.freezed.assessment.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under learn tab");
		boolean verifyAddProductButton1 = practiseAssessmentPage.verifyAddProductButton("add.product.learn.tab");
		VerificationHandler.verifyTrue(verifyAddProductButton1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under test tab");
		boolean verifyAddProductButton = practiseAssessmentPage.verifyAddProductButton("add.product");
		VerificationHandler.verifyTrue(verifyAddProductButton);
		
		log(logger, "Clicking on apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify add product tab under test tab");
		boolean verifyAddProductButton2 = practiseAssessmentPage.verifyAddProductButton("add.product.apply.tab");
		VerificationHandler.verifyTrue(verifyAddProductButton2);
		
		log(logger, "Clicking on improve Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean verifyAddProductButton4 = practiseAssessmentPage.verifyAddProductButton("add.product.learn.tab");
		VerificationHandler.verifyFalse(verifyAddProductButton4);
		boolean verifyAddProductButton5 = practiseAssessmentPage.verifyAddProductButton("add.product");
		VerificationHandler.verifyFalse(verifyAddProductButton5);
		boolean verifyAddProductButton6 = practiseAssessmentPage.verifyAddProductButton("add.product.apply.tab");
		VerificationHandler.verifyFalse(verifyAddProductButton6);
		
		log(logger, "NewATI508_verifyAddProductButtonAppearance End");
	}
	
	
	@Test(priority=4,description = "NewATI-665:Verify that product displayed for 'Semester Payment Required' card front.")
	public void NewATI665_verifySemesterPaymentRequiredPayment() throws Exception {
		log(logger, "NewATI665_verifySemesterPaymentRequiredPayment Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.freezed.assessment.login.uname"), PropertiesRepository.getString("newati.freezed.assessment.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on hide products checkbox");
		tutorialPage.clickButtonFromList("new-atitesting.learntab.hide.products.checkbox.loc",0);
		
		boolean verifyProductSize = tutorialPage.verifyProductSize("new-atitesting.learntab.hide.products.loc");
		VerificationHandler.verifyTrue(verifyProductSize);
		
		log(logger, "NewATI665_verifySemesterPaymentRequiredPayment End");
	}
	
	@Test(priority=5,description = "NewATI-138:Verify the flag option for Assessment.")
	public void NewATI138_verifyTheFlagOptionForAssessment() throws Exception {
		log(logger, "NewATI138_verifyTheFlagOptionForAssessment Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on assessment");
		practiseAssessmentPage.clickAssessment(PropertiesRepository.getString("practice.assessment.with.no.rationale.value"));
		
		log(logger, "taking an  assessment");
		tutorialPage.takeTest();
		
		log(logger, "Click on Finalize and View Results button");
		homePage.clickButtonFromList("new-atitesting.learntab.tutorial.finalize.and.view.results", 2);	
		
		log(logger, "Click on cancel button");
		homePage.clickButtonFromList("new-atitesting.learntab.assessment.cancel.button.loc", 0);
		
		log(logger, "Click on Review Flagged Questions");
		homePage.clickButtonFromList("new-atitesting.learntab.tutorial.reviewed.flagged.questions", 0);
		
		log(logger, "Answering the Flagged Questions");
		tutorialPage.takeOnlyFlaggedQuestions();
		
		log(logger, "NewATI138_verifyTheFlagOptionForAssessment End");
	}
	@Test(priority = 6,description = "NewATI-51:To check the results and report for an assessment")
	
	public void NewATI51_VerifyReportFeature() throws Exception {
	log(logger, "NewATI51_VerifyReportFeature Starts ");
	log(logger, "login to application with existing user ");
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"), PropertiesRepository.getString("newati.login.pulse.user.password"));
	
	
	downloadFilepath = PropertiesRepository.getString("global.download.location");
	homePage.createDirectory("C:\\download");
	homePage.createDirectory(downloadFilepath);
	
	log(logger, "Clicking on My ATI Tab");
	homePage.clickTab(1);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Clicking on Test Tab");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	log(logger, "Select Practice Assessment from Type");
	testTabPage.selectFiltersDropDown(1, "Practice");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Select Practice Assessment Name");
	practiseAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.result.button.loc"), true);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
	homePage.deleteFileExists(downloadFilepath);
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.download.report.loc"));
	log(logger, "Verifying file after download");
	VerificationHandler.verifyTrue(homePage.verifyFileExists(downloadFilepath), "Unable to verify file exists");
	log(logger, "NewATI51_VerifyReportFeature End");
	
	}
}
