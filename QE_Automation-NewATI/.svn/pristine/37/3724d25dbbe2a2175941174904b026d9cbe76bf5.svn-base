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
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class FocusedReview20Test extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ImproveTabPage improveTabPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		improveTabPage = new ImproveTabPage(driver);
		tutorialPage = new TutorialPage(driver);
	}

	 @TestAnnotations(testID = "NewATI-857")
	 @Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify the display of custom assessments under improve tab")
	public void NewATI857_VerifyCustomAssessmentUnderImproveTab() throws Exception {
		log(logger, "NewATI857_VerifyCustomAssessmentUnderImproveTab Start");
		logger.info("NewATI857_VerifyCustomAssessmentUnderImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Custom Assessments header and its Assessment name");
		VerificationHandler.verifyTrue(improveTabPage.verifyCustomAssessmentDetails(),
				"Unable to Verify Custom Assessments header and its Assessment name");

		log(logger, "NewATI857_VerifyCustomAssessmentUnderImproveTab End");
		logger.info("NewATI857_VerifyCustomAssessmentUnderImproveTab End");
	}

	@TestAnnotations(testID = "NewATI-573")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Attempt drowdown functionality fo the same assessment ")
	public void NewATI573_VerifyAttemptDDInImproveTab() throws Exception {
		log(logger, "NewATI573_VerifyAttemptDDInImproveTab Start");
		logger.info("NewATI573_VerifyAttemptDDInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Attempt in DD");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyAttemptDDValue(
				PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
		"Unable to Verify Attempt in DD");
		log(logger, "NewATI573_VerifyAttemptDDInImproveTab End");
		logger.info("NewATI573_VerifyAttemptDDInImproveTab End");
	}
	
	@TestAnnotations(testID = "NewATI-585")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Attempt drowdown functionality fo the same assessment ")
	public void NewATI585_VerifyInfoIconInImproveTab() throws Exception {
		log(logger, "NewATI585_VerifyInfoIconInImproveTab Start");
		logger.info("NewATI585_VerifyInfoIconInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying info icon and clicking on close button");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyInfoIconValue(
				PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
		"Unable to Verify Attempt in DD");
		
		log(logger, "NewATI585_VerifyInfoIconInImproveTab End");
		logger.info("NewATI585_VerifyInfoIconInImproveTab End");
	}
	
	@TestAnnotations(testID = "NewATI-616")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Retake button on Assessment record under Improve tab")
	public void NewATI616_VerifyRetakeButtonInSelectInstanceInImproveTab() throws Exception {
		log(logger, "NewATI616_VerifyRetakeButtonInSelectInstanceInImproveTab Start");
		logger.info("NewATI616_VerifyRetakeButtonInSelectInstanceInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Retake button under Select Instance");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyRetakeButtonInSelectInstance(
				PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
		"Unable to Verify Attempt in DD");
		
		log(logger, "NewATI616_VerifyRetakeButtonInSelectInstanceInImproveTab End");
		logger.info("NewATI616_VerifyRetakeButtonInSelectInstanceInImproveTab End");
	}
	
	@TestAnnotations(testID = "NewATI-576")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Content Area Functionality under Improve tab")
	public void NewATI576_VerifyCustomAssessmentInContentTag() throws Exception {
		logger.info("NewATI576_VerifyCustomAssessmentInContentTag Start");
		log(logger, "NewATI576_VerifyCustomAssessmentInContentTag Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		
		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting 'Communication' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.improve.tab.assessment.list.header.value"));
		
		log(logger, "Verifying Custom Assessment header");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyMessage(
				PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.with.name.loc"), 0,
				PropertiesRepository.getString("new-atitesting.improve.tab.assessment.list.header.value"))
				, "Unable to Verify Custom Assessment header");
		
		log(logger, "Verifying Custom Assessment Name 1");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyCustomAssessmentName(PropertiesRepository.getString("new-atitesting.improve.tab.custom.assessment.name1.value"))
		,"Unable to Verify Custom Assessment Name 1");
		
		log(logger, "Verifying Custom Assessment Name 2");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyCustomAssessmentName(PropertiesRepository.getString("new-atitesting.improve.tab.custom.assessment.name2.value"))
		, "Unable to Verify Custom Assessment Name 2");
		
		log(logger, "Verifying Custom Assessment Name 3");
		VerificationHandler.verifyTrue(
		improveTabPage.verifyCustomAssessmentName(PropertiesRepository.getString("new-atitesting.improve.tab.custom.assessment.name3.value"))
		, "Unable to Verify Custom Assessment Name 3");
		
		logger.info("NewATI576_VerifyCustomAssessmentInContentTag End");
		log(logger, "NewATI576_VerifyCustomAssessmentInContentTag End");
	}
	
	@TestAnnotations(testID = "NewATI-618")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verification for Record of assessment under Improve tab,which does not have Focused Review")
	public void NewATI618_VerifyAssessmentNameInImproveTab() throws Exception {
		logger.info("NewATI618_VerifyAssessmentNameInImproveTab Start");
		log(logger, "NewATI618_VerifyAssessmentNameInImproveTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.focused.review.2.0.username"),
				PropertiesRepository.getString("newati.focused.review.2.0.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying info icon and clicking on close button");
		StringBuilder sb = new StringBuilder();
		sb.append(PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")).append(" - ")
				.append(PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.attempt1.2.value"));

		VerificationHandler.verifyTrue(improveTabPage.verifyInfoIconValue(
				PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value"), sb.toString()),
				"Unable to Verify Attempt in DD");
		log(logger, "NewATI618_VerifyAssessmentNameInImproveTab End");
		log(logger, "NewATI618_VerifyAssessmentNameInImproveTab End");
	}
	
}
