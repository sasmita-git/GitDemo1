package com.automation.newati.smoke;

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
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest12 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		
		
	}
@TestAnnotations(testID="NewAT-462")
@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Practice Assessments>Complete Assessment Section actions without flagging.::Practice Assessment")
public void  NewAT462_VerifyTEAS() throws Exception {
	log(logger, "NewAT462_VerifyTEAS Start");
	
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
	
	log(logger, "Select Practice Assessment Name");
	practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", PropertiesRepository.getString("new-atitesting.testtab.teas.v.b.name"));
	
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
	
	log(logger, "NewAT462_VerifyTEAS End");
}


}
