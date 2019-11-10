package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class TestTabTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private TutorialPage tutorialPage;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		tutorialPage=new TutorialPage(driver);
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-720")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-720: Verify if speedometer is displaying only for practice assessments but not for proctor assessments [Version : 1]")
	public void NewATI720_VerifySMForPracticeAssTest() throws Exception {

		logger.info("Method : NewATI720_VerifySMForPracticeAssTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Proctored");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer  displayed for Proctored Assessment");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinProctorTestTab("Proctored Assessment"),"For Proctored Assessment spedometer is displayed");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer displayed for Practice Assessment on card font");
		VerificationHandler.verifyFalse(tutorialPage.VerifySpedometerinPracticeTestTab("Practice Assessment"),"For practice spedometer is not displayed");
		logger.info("Method : NewATI720_VerifySMForPracticeAssTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-721")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = " NewATI-721: Verify if information table is displaying by clicking on Speedometer card front [Version : 1]")
	public void NewATI721_VerifyInfoTableForSM() throws Exception {

		logger.info("Method : NewATI721_VerifyInfoTableForSM Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name.pulse"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Verify if information table is displaying by clicking on Speedometer card front");
		VerificationHandler.verifyTrue(testTabPage.VerifyifInfoTablePresent());

		logger.info("Method : NewATI721_VerifyInfoTableForSM End");
	}

	/**
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-719")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = " NewATI-719: Verify if speedometer value is displaying zero for never accessed products (Practice assessments)")
	public void NewATI719_VerifySpeedometerDisplayStatus() throws Exception {

		logger.info("Method : NewATI719_VerifySpeedometerDisplayStatus Start");
		loginPage.loginToApplication("stagepulse21","Test123");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Info Icon in test tab");
		testTabPage.clickInfoIconByTesttab("PN Maternal Newborn Online Practice 2017 B");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify CDN is displaying by clicking on information icon card on front");
		VerificationHandler.verifyTrue(testTabPage.verifyBatchIdinProduct("new-atitesting.homepage.myati.assessment.productid.loc", 1));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify spedometer displayed for Never accessed Practice Assessment on card font");
		VerificationHandler.verifyTrue(testTabPage.verifyNeverAccessedSpedoAsZero(),"For practice spedometer is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc"); 
		logger.info("Method : NewATI719_VerifySpeedometerDisplayStatus End");
	}	
	
	
}
