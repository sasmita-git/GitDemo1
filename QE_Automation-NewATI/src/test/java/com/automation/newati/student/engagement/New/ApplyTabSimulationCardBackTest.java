package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.faculty.pages.PulseLandingPage;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class ApplyTabSimulationCardBackTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private PulseLandingPage pulseLandingPage;
	private ApplyTabPage applyTabPage;
	

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		pulseLandingPage = new PulseLandingPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),	PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
	}


	/**
	 * Currently Failing because of  Jira-ID ATISE-1065 : Apply tab : Usage Percentage mismatch from SV to FV at Product/Module level.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-729")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-729: Verify if Speedometer is displaying for all the modules on card back. (value should match with FV) [Version : 1]")
	public void NewATI729_VerifySpeedometerDisplayingAllModulesTest() throws Exception {

		logger.info("Method : NewATI729_VerifySpeedometerDisplayingAllModulesTest Start");		

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());

		log(logger, "Clicking Module by Name");
		applyTabPage.clickOnModuelButtonByName(PropertiesRepository.getString("new-atitesting.applytab.simulation.name"));
		
		log(logger, "Get list of modules and its Speedo meter presence in an Hashmap");
	    learnTabPage.InitializeMapWithModuleNameAndApeedometerValue();
	    
	    driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(PropertiesRepository.getString("se.std.apply.tab.loc"))));
		homePage.clickButton(PropertiesRepository.getString("se.std.apply.tab.loc"), 2);
		homePage.waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol2"));
		
		log(logger, "Click on Module by Name");	
		pulseLandingPage.clickModuleByName(PropertiesRepository.getString("new-atitesting.applytab.simulation.name"),PropertiesRepository.getString("se.std.appli.tab.list.loc"));
		
		log(logger, "Verify if Module List and its Speedometer Value for SV and FV are Equal");												
		VerificationHandler.verifyTrue(learnTabPage.VerifySVandFVModuleListAndItsSpeedometerValueAreEqual());

		logger.info("Method : NewATI729_VerifySpeedometerDisplayingAllModulesTest End");
	}
		
	
	
	
	
	/**
	 * Simulations are not tagged with “Accessed: Never” in Faculty portal , they just have speedometer value as zero, unlike in student portal.Currently have validated only SV
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-730")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-730: Verify if Speedometer value is displaying zero for non accessed modules (value should match with FV [Version : 1]")
	public void NewATI730_VerifyModulesNeverAccessedZeroTest() throws Exception {

		logger.info("Method : NewATI730_VerifyModulesNeverAccessedZeroTest Start");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking first Module that is never accessed");
		applyTabPage.clickModuleButtonNeverAccessed();		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Module that are never Accessed have Speedometer value as 0%");												
		VerificationHandler.verifyTrue(learnTabPage.VerifyNeverAccessedModuleZeroSMValue("new-atitesting.apply.tab.module.speedometer.value"));	
			
		logger.info("Method : NewATI730_VerifyModulesNeverAccessedZeroTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-731")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-731: Verify if information card is displaying by clicking on modules speedometer [Version : 1]")
	public void NewATI731_VerifyCardBackUsageTableTest() throws Exception {

		logger.info("Method : NewATI731_VerifyCardBackUsageTableTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Module button having Speedometer");
		applyTabPage.clickOnModuleWithSpeedometer(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Speedometer on Card back");
		tutorialPage.clickButtonFromList("new-atitesting.apply.tab.module.speedometer.value", 0);
		
		log(logger, "Verify Speedometer Table header");
		VerificationHandler.verifyTrue(learnTabPage.verifyUsageTableHeader(".custom-table.back-usage-data" , "Usage,Questions Answered,Total Questions,Last Attempt,Time Spent,Time Suggested,"));

		logger.info("Method : NewATI731_VerifyCardBackUsageTableTest End");
	}
	
	
}
