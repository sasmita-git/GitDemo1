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

public class LearnTabTutorialCardBackTest extends BaseTest {

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
	 * Currently Failing because of  Jira-ID ATISE-1065 : Learn tab : Usage Percentage mismatch from SV to FV at Product/Module level.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-712")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-712: Verify if Speedometer is displaying for all the modules on card back.")
	public void NewATI712_VerifySpeedometerDisplayingAllModulesTest() throws Exception {

		logger.info("Method : NewATI712_VerifySpeedometerDisplayingAllModulesTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);

		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage.waitUntillElementIsVisible("#tutorialTypeLabel");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());

		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.new"));
		
		log(logger, "Get list of modules and its Speedo meter presence in an Hashmap");
	    learnTabPage.InitializeMapWithModuleNameAndApeedometerValue();
	    
	    driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
							
		log(logger, "Click on Module by Name");	
		pulseLandingPage.clickModuleByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.new") , PropertiesRepository.getString("se.std.tutorial.list.loc"));
		
		log(logger, "Verify if Module List and its Speedometer Value for SV and FV are Equal");												
		VerificationHandler.verifyTrue(learnTabPage.VerifySVandFVModuleListAndItsSpeedometerValueAreEqual());

		logger.info("Method : NewATI712_VerifySpeedometerDisplayingAllModulesTest End");
	}
	
	
	/**
	 * Simulations are not tagged with “Accessed: Never” in Faculty portal , they just have speedometer value as zero, unlike in student portal.Currently I have validated only SV
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-713")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-713: Verify if Speedometer value is displaying zero for non accessed modules (value should match with FV.")
	public void NewATI713_VerifyModulesNeverAccessedZeroTest() throws Exception {

		logger.info("Method : NewATI713_VerifyModulesNeverAccessedZeroTest Start");
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
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking first Module that is never accessed");
		learnTabPage.clickModuleButtonNeverAccessed();		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Module that are never Accessed have Speedometer value as 0%");												
		VerificationHandler.verifyTrue(learnTabPage.VerifyNeverAccessedModuleZeroSMValue("new-atitesting.learn.tab.module.speedometer.value"));	
			
		logger.info("Method : NewATI713_VerifyModulesNeverAccessedZeroTest End");
	}


	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-714")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-714: Verify if information card is displaying by clicking on modules speedometer")
	public void NewATI714_VerifyCardBackUsageTableTest() throws Exception {

		logger.info("Method : NewATI714_VerifyCardBackUsageTableTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");
		

		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorials
		log(logger, "Filtering Tutorials");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		
		log(logger, "Click on Module button having Speedometer");
		learnTabPage.clickOnModuleWithSpeedometer(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on Speedometer on Card back");
		tutorialPage.clickButtonFromList("new-atitesting.speedometer.cardback.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify Speedometer Table header");
		VerificationHandler.verifyTrue(learnTabPage.verifyUsageTableHeader(".custom-table.back-usage-data" , "Usage,Questions Answered,Total Questions,Last Attempt %,Time Spent,Time Suggested,"));

		logger.info("Method : NewATI714_VerifyCardBackUsageTableTest End");
	}
}
