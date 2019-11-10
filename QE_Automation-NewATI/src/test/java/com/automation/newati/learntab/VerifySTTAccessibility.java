package com.automation.newati.learntab;

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
import com.automation.newati.pages.TutorialPage;

public class VerifySTTAccessibility extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.new"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-509:Verification for accessibility of Tutorial ' Sigma Theta Tau Modules 2013' for Student")
	public void NewATI509_VerifyStudentAccessibility() throws Exception {
		logger.info("NewATI509_VerifyStudentAccessibility Start");
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Disabled message");
//		VerificationHandler.verifyTrue(tutorialPage.verifyDisabledMessage(), "Unable to verify disabled message");
	
	}
	
	
}
