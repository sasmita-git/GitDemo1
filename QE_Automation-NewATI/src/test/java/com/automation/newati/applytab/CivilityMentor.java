package com.automation.newati.applytab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class CivilityMentor extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private LearnTabPage learnTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private WindowHandler windowHandler;
	private TutorialPage tutorialPage;
	private BaseHandler baseHadler;
	private TestTabPage testTabPage;
	private ApplyTabPage applyTabPage;
	private NclexPrepTabPage nclexPage;

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		windowHandler = new WindowHandler(driver);
		tutorialPage = new TutorialPage(driver);
		baseHadler = new BaseHandler(driver);
		testTabPage = new TestTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		nclexPage = new NclexPrepTabPage(driver);
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-945")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-945:Verify Civility Mentor card front under apply tab")
	public void NewATI945_VerifyCivilityMentorCF() throws Exception {

		log(logger, "NewATI947_VerifyCivilityMentorFunc Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.civility.username1"),
				PropertiesRepository.getString("newati.login.password"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if User is navigate apply tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Verifying 'Civility Mentor' in Card Front in Apply Tab");
		VerificationHandler.verifyTrue(
				applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),
				"Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4 and 5
		log(logger, "Verifying  all fields on card front and Modules count show  in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6
		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Verify if view drop down in card back is displayed");
		String[] modulesList = { PropertiesRepository.getString("new.atitesting.CM.module1"),
				PropertiesRepository.getString("new.atitesting.CM.module2") };
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulesList(modulesList, "2"));

		log(logger, "NewATI947_VerifyCivilityMentorFunc End");
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-947")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-947:Verify Civility Mentor functionality for Device")
	public void NewATI947_VerifyCivilityMentorFunc() throws Exception {

		log(logger, "NewATI947_VerifyCivilityMentorFunc Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.civility.username1"),
				PropertiesRepository.getString("newati.login.password"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);

		log(logger, "Verify if User is navigate apply tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());

		// Step - 3
		log(logger, "Verifying 'Civility Mentor' Card Front in Apply Tab");
		VerificationHandler.verifyTrue(
				applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),
				"Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));

		log(logger, "Verify if view drop down in card back is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Clicking on first module on card back");
		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.firstModule.loc"));

		// Need to add validation

		log(logger, "NewATI947_VerifyCivilityMentorFunc End");
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-948")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-948:Verify content area drop down functionality for Civility mentor")
	public void NewATI948_VerifyCivilityMentorCAdropDown() throws Exception {

		log(logger, "NewATI948_VerifyCivilityMentorCAdropDown Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.civility.username1"),
				PropertiesRepository.getString("newati.login.password"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);

		log(logger, "Verify if User is navigate apply tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());

		// Step 3
		log(logger, "Verifying 'Civility Mentor' in Card Front in Apply Tab");
		VerificationHandler.verifyTrue(
				applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),
				"Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 4
		log(logger, "Selecting 'Fundamentals' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.fundamentals"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying  all fields on card front and Modules count show is 1 in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "1"));

		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Verify if view drop down in card back is displayed");
		String[] modulesList = { PropertiesRepository.getString("new.atitesting.CM.module1") };
		VerificationHandler.verifyTrue(applyTabPage.verifyFirstCardBackModulesList(modulesList, "1"));

		log(logger, "Close Card back");
		applyTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 5 --> Content area Value : Admission
		log(logger, "Selecting 'Admissions' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.admissions"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying  all fields on card front and Modules count show is 1 in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "1"));

		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Verify if view drop down in card back is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verifyFirstCardBackModulesList(modulesList, "1"));

		log(logger, "Close Card back");
		applyTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 5 --> Content area Value : Professionalism
		log(logger, "Selecting 'Admissions' Option from Content Area");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				baseHadler.findElement(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc")));
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.professionalism"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying  all fields on card front and Modules count show is 1 in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "1"));

		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Verify if view drop down in card back is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verifyFirstCardBackModulesList(modulesList, "1"));

		log(logger, "Close Card back");
		applyTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 5 --> Content area Value : Communication
		log(logger, "Selecting 'Admissions' Option from Content Area");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				baseHadler.findElement(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc")));
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.communication"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying  all fields on card front and Modules count show is 1 in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "1"));

		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));

		log(logger, "Verify if view drop down in card back is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verifyFirstCardBackModulesList(modulesList, "1"));

		log(logger, "Close Card back");
		applyTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 6
		// Skipping this, as there is no data for this steep

		// Step 7
		log(logger, "Selecting 'All' Option from Content Area");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				baseHadler.findElement(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc")));
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.all"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying  all fields on card front and Modules count show is 2 in card front");
		VerificationHandler.verifyTrue(
				applyTabPage.verifyCardFrontDetails(PropertiesRepository.getString("new.atitesting.CM"), "2"));

		log(logger, "NewATI948_VerifyCivilityMentorCAdropDown End");
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-949")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-949:Verify access module functionality for 'Civility Mentor'")
	public void NewATI949_VerifyCivilityMentorAccessModule() throws Exception {

		log(logger, "NewATI949_VerifyCivilityMentorAccessModule Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.civility.username1"),
				PropertiesRepository.getString("newati.login.password"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);

		log(logger, "Verify if User is navigate apply tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		
		log(logger, "Verifying 'Civility Mentor' in Card Front in Apply Tab");
		VerificationHandler.verifyTrue(
				applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),
				"Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 3 and 4
		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));
		
		log(logger, "Clicking on first module on card back");
		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.firstModule.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5		
		log(logger, "Verify if URL contains LTI");
		VerificationHandler.verifyTrue(driver.getCurrentUrl().contains("LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Close button is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.button.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Simulation Name");
		VerificationHandler.verifyTrue(baseHadler.findElement(PropertiesRepository.getString("newati.simulation.name.LTI")).getText().equals(PropertiesRepository.getBoolean("new.atitesting.CM")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		log(logger, "Verify if Module Name ");
		VerificationHandler.verifyTrue(baseHadler.findElement(PropertiesRepository.getString("newati.module.name.LTI")).getText().equals(PropertiesRepository.getBoolean("new.atitesting.CM.module1")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Civility Module iframe is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.iframe.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6		
		log(logger, "Click on Close button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.button.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Close Dialog is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.dialog.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Yes button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.dialog.yes.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));
		
		log(logger, "NewATI949_VerifyCivilityMentorAccessModule End");
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-953")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-953:Verify Civility Mentor Functionality for Continue Case Results")
	public void NewATI953_VerifyCivilityCaseResult() throws Exception {

		log(logger, "NewATI953_VerifyCivilityCaseResult Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.civility.username1"),PropertiesRepository.getString("newati.login.password"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);

		log(logger, "Verify if User is navigate apply tab");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		
		log(logger, "Verifying 'Civility Mentor' in Card Front in Apply Tab");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),"Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 3
		log(logger, "Clicking on 'Civility Mentor' ");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if view drop down in card back is displayed");
		applyTabPage.waitUntillElementIsVisible(PropertiesRepository.getString("new.atitesting.cardback.dd.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));
		
		log(logger, "Clicking on first module on card back");
		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.firstModule.loc"));

		//Need to add more steeps
		
		log(logger, "NewATI953_VerifyCivilityCaseResult End");
	}
}
