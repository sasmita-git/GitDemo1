package com.automation.newati.myati.improvetab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyFocusedReviewPDFCheckTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private ImproveTabPage improveTabPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		improveTabPage = new ImproveTabPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

	@TestAnnotations(testID="NewATI-412")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Focused review PDF check::Improve Tab")
	public void NewATI412_VerifyFocusedReviewPDFCheck() throws Exception{
		log(logger, "NewATI412_VerifyFocusedReviewPDFCheck Start");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		/*loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.improve"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/
		
		log(logger, "Select value from content area");
		learnTabPage.selectFromContentAreaDropdown(PropertiesRepository.getString("new-atitesting.improve.contentarea.value"));
	
		log(logger, "Verify assessments as per content area");
		VerificationHandler.verifyTrue(improveTabPage.verifyAssessmentAsPerContentAreaFR(PropertiesRepository.getString("new-atitesting.improve.contentarea.value")), "FR Assessments not displays as per selected content area");
		
//		log(logger, "Click on focused review product");
//		tutorialPage.startFocusedReview();
//		
//		log(logger, "Verifying PDF Content");
//		VerificationHandler
//		.verifyTrue(tutorialPage.verifyImproveTabPDF(), "Unable to verify PDF");
//		
//		log(logger, "Click on close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		
	}
	
	@TestAnnotations(testID="NewATI-413")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Focused review Video check::Improve Tab")
	public void NewATI413_VerifyFocusedReviewPDFCheck() throws Exception{
		log(logger, "NewATI413_VerifyFocusedReviewPDFCheck Start");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		
		log(logger, "Click on focused review product");
		tutorialPage.startFocusedReview();
		
		log(logger, "Click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));

		log(logger, "NewATI413_VerifyFocusedReviewPDFCheck End");
	}
	@TestAnnotations(testID="NewATI-38")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-38:Check for Focused Review")
	public void NewATI38_CheckForFocusedReview() throws Exception{
		log(logger, "NewATI38_CheckForFocusedReview Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"), PropertiesRepository.getString("newati.login.password"));
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		
		log(logger, "Click on focused review product");
		VerificationHandler.verifyTrue(tutorialPage.startFocusedReview(), "Unable to click on first Focused Review assessment.");
		
		log(logger, "Click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));

		log(logger, "NewATI38_CheckForFocusedReview End");
	}
	
	@TestAnnotations(testID="NewATI-523")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-523:Tc04:Verify Each assessment will be tied to a single Content Area_STU-4100")
	public void NewATI523_VerifyFRaspercontentarea() throws Exception{
		log(logger, "NewATI523_VerifyFRaspercontentarea Start");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.improve"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select value from content area");
		learnTabPage.selectFromContentAreaDropdown(PropertiesRepository.getString("new-atitesting.improve.contentarea.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Verify assessments as per content area");
		VerificationHandler.verifyTrue(improveTabPage.verifyAssessmentAsPerContentAreaFR(PropertiesRepository.getString("new-atitesting.improve.contentarea.value")), "FR Assessments not displays as per selected content area");
		log(logger, "NewATI523_VerifyFRaspercontentarea End");
	}
	
	 
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-517")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-517:TC01:Verify Content area dropdown for all contents_STU-4100")
	public void NewATI517_VerifyContentAreaDD() throws Exception {

		log(logger, "NewATI517_VerifyContentAreaDD Start");
		
		String ddValues =PropertiesRepository.getString("new-atitesting.improve.contentarea.dd.all.values"); 
		System.out.println(ddValues);

		String[] ddValuesArray = ddValues.split("/");

		// Step 1 and 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.rn.pn.login.user.name"),
				PropertiesRepository.getString("newati.nclex.rn.pn.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4
		log(logger, "Clicking on the Content Area drop down");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.content.area.dropdown"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Drop Down values");
		VerificationHandler.verifyTrue(improveTabPage.verifyAllDropDownValues(ddValuesArray));

		log(logger, "NewATI517_VerifyContentAreaDD End");
	}
	
	/**
	 * PreCondition : Checking for Fundamentals content area, as there is no fixed naming convention for other content areas.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-518")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-518:TC02:Verify Focused Review grouped and displayed under corresponding content area selected_STU-4100")
	public void NewATI518_VerifyFRUnderContentArea() throws Exception {

		log(logger, "NewATI518_VerifyFRUnderContentArea Start");

		// Step 1 and 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.rn.pn.login.user.name"),
				PropertiesRepository.getString("newati.nclex.rn.pn.login.password"));

		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4
		log(logger, "Selecting Fundamentals Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), PropertiesRepository.getString("new-atitesting.improve.contentarea.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Fundementals focused review is displayed when Fundementals is selected in the content area.");
		VerificationHandler.verifyTrue(improveTabPage.verifyFundamentalsInName());
		
		log(logger, "NewATI518_VerifyFRUnderContentArea End");
	}
	
}
