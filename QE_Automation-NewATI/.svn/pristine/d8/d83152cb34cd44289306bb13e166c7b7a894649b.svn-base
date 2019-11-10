package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.faculty.pages.PulseLandingPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class LearnTabTutorialCardFrontTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private PulseLandingPage pulseLandingPage;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		pulseLandingPage = new PulseLandingPage(driver);
	}

	/**
	 * Currently Failing because of  Jira-ID ATISE-1067 : Learn Tab : Products mismatch from SV to FV.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-707")	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-707: Verify if TUtorials are matching in between FV and SV")
	public void NewATI707_VerifyTutorialsMatchInFvAndSvTest() throws Exception {
		
		logger.info("Method : NewATI707_VerifyTutorialsMatchInFvAndSvTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Adding all the Tutorials with Speedometer in the array list
		learnTabPage.AddArrayListwithTutorialsWithSpedometer();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		driver.navigate().to("https://stage-faculty.atitesting.com");
		Thread.sleep(5000);	
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
		Thread.sleep(5000);																																	
		log(logger, "Verify if Tutorial List for SV and FV are Equal");
		VerificationHandler.verifyTrue(learnTabPage.VerifySVandFVTutorialListAreEqual());
	
		logger.info("Method : NewATI707_VerifyTutorialsMatchInFvAndSvTest End");
	}
	
	/**
	 * Currently Failing because of  Jira-ID ATISE-1065 : Learn tab : Usage Percentage mismatch from SV to FV at Product/Module level.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-708")	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-708: Verify if speedometer is displaying on all the products card front under learn tab")
	public void NewATI708_VerifySpeedometerValueMatchInFvAndSvTest() throws Exception {
		
		logger.info("Method : NewATI708_VerifySpeedometerValueMatchInFvAndSvTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		
		log(logger, "Verify if Speedometer is Displayed on all active tutorials except ATI TEAS SmartPrep tutorial");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfSpeedometerIsDisplayedOnAllTutorials());
		
		//Adding all the Tutorials with Speedometer and its Value in the map
		learnTabPage.AddTutorialsWithSpedometerAndvaluesInMap();
		
		driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
		
		log(logger, "Verify if Tutorial List and its Speedometer Value for SV and FV are  Equal");												
		VerificationHandler.verifyTrue(learnTabPage.VerifySVandFVTutorialListAndItsValueAreEqual());
		
		logger.info("Method : NewATI708_VerifySpeedometerValueMatchInFvAndSvTest End");
	}
	
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-709")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-709: Verify if speedometer value is displaying zero for never accessed products")
	public void NewATI709_VerifySpeedometerValueTest() throws Exception {

		logger.info("Method : NewATI709_VerifySpeedometerValueTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage
				.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Speedometer is Displayed on all active tutorials except ATI TEAS SmartPrep tutorial and NCLEX");
		VerificationHandler.verifyFalse(learnTabPage.VerifyIfSpeedometerIsDisplayedOnAllTutorials());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Never accessed Tutorials have Speedometer value as 0%");
		VerificationHandler.verifyTrue(learnTabPage.VerifyNeverAccessedSpedoAsZero());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI709_VerifySpeedometerValueTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-710")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-710: Verify if information table is displaying by clicking on Speedometer card front")
	public void NewATI710_VerifySpeedometerInfoTableTest() throws Exception {

		logger.info("Method : NewATI710_VerifySpeedometerInfoTableTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage
				.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if information table is displaying by clicking on Speedometer card front");
		VerificationHandler.verifyFalse(learnTabPage.VerifyifInfoTablePresent(1));

		logger.info("Method : NewATI710_VerifySpeedometerInfoTableTest End");
	}
}
