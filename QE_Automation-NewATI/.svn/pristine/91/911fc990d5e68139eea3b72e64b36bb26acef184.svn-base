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
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.jaca.TestAnnotations;

public class ApplyTabSimulationCardFrontTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private MyResultsTabPage myResultsTabPage;
	private ApplyTabPage applyTabPage;
	private PulseLandingPage pulseLandingPage;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		pulseLandingPage = new PulseLandingPage(driver);
	}

	/**
	 * Currently Failing because of  Jira-ID ATISE-1065 : Simulation count mismatch in FV and SV. 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-723")	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-723: Verify if products (Simulations) are matching in between FV and SV [Version : 1]")
	public void NewATI723_VerifySimulationsMatchInFvAndSvTest() throws Exception {
		
		logger.info("Method : NewATI723_VerifySimulationsMatchInFvAndSvTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		
		//Adding all the Simulations with Speedometer in the array list
		applyTabPage.addArrayListwithSimulationsWithSpedometer();
				
		driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
		
		//Clicking on Apply Tab
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(PropertiesRepository.getString("se.std.apply.tab.loc"))));
		homePage.clickButton(PropertiesRepository.getString("se.std.apply.tab.loc"),2);
		homePage.waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol2"));
		
		log(logger, "Verify if Simulations List for SV and FV are Equal");
		VerificationHandler.verifyTrue(applyTabPage.VerifySVandFVSimulationsListAreEqual());
	
		logger.info("Method : NewATI723_VerifySimulationsMatchInFvAndSvTest End");
	}
	
	/**
	 * Currently Failing because of  Jira-ID ATISE-1065 : Learn tab : Usage Percentage mismatch from SV to FV at Product/Module level.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-724")	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-724: Verify if speedometer is displaying on all the products card front under Apply tab [Version : 1]")
	public void NewATI724_VerifySpeedometerValueMatchInFvAndSvTest() throws Exception {
		
		logger.info("Method : NewATI724_VerifySpeedometerValueMatchInFvAndSvTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());		
		
		log(logger, "Verify if Speedometer is Displayed on all active Simulations");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfSpeedometerIsDisplayedOnAllSimulations());
				
		//Adding all the Tutorials with Speedometer and its Value in the map
		applyTabPage.addSimulationsWithSpedometerAndvaluesInMap();
		
		driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name"));
		
		//Clicking on Apply Tab
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(PropertiesRepository.getString("se.std.apply.tab.loc"))));
		homePage.clickButton(PropertiesRepository.getString("se.std.apply.tab.loc"), 2);
		homePage.waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol2"));
		
		log(logger, "Verify if Tutorial List and its Speedometer Value for SV and FV are  Equal");												
		VerificationHandler.verifyTrue(applyTabPage.VerifySVandFVSimulationsListAndItsValueAreEqual());
		
		logger.info("Method : NewATI724_VerifySpeedometerValueMatchInFvAndSvTest End");
	}
		
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-725")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-725: Verify if speedometer value is displaying zero for never accessed products (value should match FV) [Version : 1]")
	public void NewATI725_VerifySpeedometerValueTest() throws Exception {

		logger.info("Method : NewATI725_VerifySpeedometerValueTest Start");
		loginPage.loginToApplication("stage_march21","Test123");

		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());		
		
		log(logger, "Verify if Speedometer is Displayed on all active Simulations");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfSpeedometerIsDisplayedOnAllSimulations());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Never accessed Simulations have Speedometer value as 0%");
		VerificationHandler.verifyTrue(applyTabPage.VerifyNeverAccessedSpedoAsZero());

		logger.info("Method : NewATI725_VerifySpeedometerValueTest End");
	}
		
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-726")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-726: Verify if information table is displaying by clicking on Speedometer card front [Version : 1]")
	public void NewATI726_VerifySpeedometerInfoTableTest() throws Exception {

		logger.info("Method : NewATI726_VerifySpeedometerInfoTableTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());			
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if information table is displaying by clicking on Speedometer card front");
		VerificationHandler.verifyTrue(applyTabPage.VerifyifInfoTablePresent(2));

		logger.info("Method : NewATI726_VerifySpeedometerInfoTableTest End");
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-728")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-728:Verification for Recent score value on card front information table (should match with Results tab) [Version : 1]")
	public void NewATI728_VerifyRecentScoreTest() throws Exception {
		
		String[] arraySimulationNameAndScore;  
		
		logger.info("Method : NewATI728_VerifyRecentScoreTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//First Checking the Assessment in My result page and then verifying its Recent score in Apply Tab, because Apply Tab to MyResult Tab flow is not possible 
		log(logger, "Clicking on My Results Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Get Simulation Name and its individual score in an array
		arraySimulationNameAndScore = myResultsTabPage.getSimulationNameAndScore();
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if the Recent score value on card front information match with Results tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyifRecentScoreEqualsResultTab(arraySimulationNameAndScore));
		

		logger.info("Method : NewATI728_VerifyRecentScoreTest End");
	}
}
