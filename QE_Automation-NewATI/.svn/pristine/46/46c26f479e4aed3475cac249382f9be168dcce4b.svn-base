package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

public class UserSpecificTest extends BaseTest{
	
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
	}
	
	/**
	 * Failing because There is an issue with the locator to find all the rows of td in My results page. Assigned to dev team
	 * Needs Pulse User which have completed an real life assessment module
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-734")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-734: Verification for Last Attempt value on Card back information table (should match with Results tab [Version : 1]")
	public void NewATI734_VerifySpeedometerDisplayingAllModulesTest() throws Exception {

		String lastAttemptValueCB ;
		String lastAttemptValueRT ;
		
		logger.info("Method : NewATI734_VerifySpeedometerDisplayingAllModulesTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		
		log(logger, "Clicking Module by Name");
		applyTabPage.clickOnModuelButtonByName(PropertiesRepository.getString("NewATI734.simulation.name"));
		
		log(logger, "Clicking on Module by name and get Last Attempt result");
		lastAttemptValueCB = applyTabPage.clickOnSMByModuelName(PropertiesRepository.getString("NewATI734.module.name"));
		
		//Close Card Back
		log(logger, "Clicking on close button if the card back");
		applyTabPage.clickButton("div[class='back js-back-active js-no-back-transition'] button");
		
		log(logger, "Clicking on My Results Tab");
		homePage.clickTab(2);
				
		log(logger, "Get the Last Attempt Valuse from the result Tab by Module Name");
		lastAttemptValueRT = applyTabPage.getLastAttemptvalueByModulename(PropertiesRepository.getString("NewATI734.module.name"));
				
		log(logger, "Verify if last Attempt value on Card back information table is same as Results tab ");												
		VerificationHandler.verifyTrue(lastAttemptValueCB.equals(lastAttemptValueRT));		
		
		logger.info("Method : NewATI734_VerifySpeedometerDisplayingAllModulesTest Ends");
	}
	

}
