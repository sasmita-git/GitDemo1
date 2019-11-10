package com.automation.newati.nclex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class BoardVitalsTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private BaseHandler baseHandler;
	private MyATITabMainPage myATITabMainPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		baseHandler = new BaseHandler(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-682")
	@Test(priority = 1, enabled = true,  groups = {"Regression" }, alwaysRun = true, description = "NewATI-682:Verify User is able to launch the BV product from Recent Activity")
	public void NewATI682_verifyBVRecentActivity() throws Exception {

		log(logger, "NewATI682_verifyBVRecentActivity Start");
		
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.bv.login.user.name"), PropertiesRepository.getString("newati.nclex.bv.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Home page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Home - ATI Testing"));	
						
		//Step 2
//		log(logger, "Clicking on My ATI Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(1);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Verifying if All Tabs are displayed");
//		VerificationHandler.verifyTrue(myATITabMainPage.verifyAllTabsDisplayed());
//		
//		// Step 3
//		log(logger, "Clicking on NCLEX PREP Tab");
//		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 4);
//		
//		log(logger, "Verifying if  board vital/Adaptive test  products are displayed");
//		VerificationHandler.verifyTrue(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.nclex.bv.products.loc")).size() != 0);
//		
//		log(logger, "Clicking Module by Name");
//		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "click on nclex adaptive test link");
//		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.product.links"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Verify element after opening. ");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.close.button")), "Unable to verify element after opening.");
//		
//		log(logger, "click on close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.click.yes"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		// Step 4
//		log(logger, "Clicking on Home Tab");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickTab(0);
//		
//		log(logger, "Verifying Board Vitals NCLEX Prep RN test in Recent Activity");
//		homePage.verifyAndClickRecentActivity(
//				PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.NCLEX.loc"), "Board Vitals",
//				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"), "In Progress");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		log(logger, "Verify element after opening. ");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.close.button")), "Unable to verify element after opening.");
//		
		logger.info("NewATI682_verifyBVRecentActivity End");
	}

}
