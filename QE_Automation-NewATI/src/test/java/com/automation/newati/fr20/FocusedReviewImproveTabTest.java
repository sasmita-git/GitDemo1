package com.automation.newati.fr20;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.jaca.TestAnnotations;

public class FocusedReviewImproveTabTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ImproveTabPage improveTabPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		improveTabPage = new ImproveTabPage(driver);
	}

	@TestAnnotations(testID = "NewATI-914")
	@Test(priority = 1, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-914:Verify that student can add graduation and curriculum cohort")
	public void NewATI914_verifyGraduationcurrcilum() throws Exception {

		log(logger, "NewATI914_verifyGraduationcurrcilum Start");

		// Step 1
		//loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));

	}
	@TestAnnotations(testID="NewATI-852")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-852:Verify assessments under content tag header.")
	public void  NewATI852_OrderofAssessmentImproveTab() throws Exception {
		log(logger, "NewATI852_OrderofAssessmentImproveTab Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, " Verify assessments are sorted in ascending");
		VerificationHandler.verifyTrue(improveTabPage.isAssessmentSortedInAscendingOrder(true));
	
		logger.info("NewATI852_OrderofAssessmentImproveTab Ends");
	}
}
