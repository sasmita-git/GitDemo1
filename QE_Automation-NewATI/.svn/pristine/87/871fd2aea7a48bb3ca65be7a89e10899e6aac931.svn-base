package com.automation.newati.myati.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TakingAssessmentPage;
import com.automation.newati.pages.TestTabPage;

public class PracticeAssessmentRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private TakingAssessmentPage takingAssessmentPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		takingAssessmentPage = new TakingAssessmentPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
	}

	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-19:Practice Assessments>Complete Assessment Section actions after flagging.")
	public void  NewAT19_CompletePracAssessmentWithFlagging() throws Exception {
		log(logger, "NewAT19_CompletePracAssessmentWithFlagging Start");
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
		practiceAssessmentPage.clickAssessment(PropertiesRepository.getString("new-atitesting.test.tab.practice.assessment.19.test.case.name"));
		
		log(logger, "Taking Assessment 1");
		takingAssessmentPage.takeTestWithFlagging(false, false, true, false);
		
		log(logger, "Taking Assessment 2");
		takingAssessmentPage.takeTestFlagRemove(false, false, true, false);
		
		log(logger, "NewAT19_CompletePracAssessmentWithFlagging End");
	}

}
