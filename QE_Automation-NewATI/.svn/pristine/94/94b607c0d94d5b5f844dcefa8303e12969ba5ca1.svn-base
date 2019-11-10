package com.automation.newati.tutorial;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;

public class TutorialTestNew extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage reportPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		reportPage = new MyReportPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"), PropertiesRepository.getString("newati.login.password"));
		//loginPage.loginToApplication("prodauto1", "Test123");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-130:Skills Module : PreTest Button")
	public void NewATI130_VerifyTutorialSkillsModulePreTest() throws Exception {
		log(logger,
				"Skills Module Pre Test Button Verification - Starts : Method - NewATI130_VerifyTutorialSkillsModulePreTest");

		// Step 2 Start
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
		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		//step3 start
		tutorialPage.selectCardFrontBasedOnModuleName("Skills Modules 2.0");
		log(logger,
				"Clicking on Skills Module Tutorial Module Button in Card Front");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step3 end
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step4 start
		tutorialPage.verifyAllBeginButtonInCardBackTutorial();
		log(logger, "Clicking on verifying the presensence of all begin button on card back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step4 end
		
		
		//step5 start
		String section=tutorialPage.clickCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.skills.module.2.0.name.1"));
		
		log(logger, "cliking on the pretest btutton in th card back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step5 end

		//step 6 start
		tutorialPage.takeTest(false, true, false,false);
		log(logger, " Answering the first question tutorial again for completion");
		//step 6 end
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step 7 start
		tutorialPage.getTimeSpentInCardBack(section);
		log(logger, "getting the time spent in the card back");
		//step 7 end
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//step8 start
		tutorialPage.clickCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.skills.module.name"));
		log(logger, "Clicking on Begin Test on Card back");
		//step 8 end

		//step9-12 start
		log(logger, "Taking Assessment");
		tutorialPage.takeTest(false, false, false, false);
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
        //steps9-12 end
		
		log(logger, "NewATI130_VerifyTutorialSkillsModulePreTest Ends");

	}
	
	
}
