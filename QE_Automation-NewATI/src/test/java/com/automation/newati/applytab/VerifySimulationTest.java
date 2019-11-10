package com.automation.newati.applytab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

/*import Flash.FlashObjectWebDriver;*/

public class VerifySimulationTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private HelpPage helpPage;
	private ApplyTabPage applyTabPage;
	private TutorialPage tutorialPage;
	private CreateAccountPage createAccountPage;
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		helpPage = new HelpPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		tutorialPage = new TutorialPage(driver);
		createAccountPage=new CreateAccountPage(driver);
		
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
//		loginPage.loginToApplication("stagequizuser","Test123");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

	/*@TestAnnotations(testID="NewATI-884")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "NewATI-884:Verify that filter by content area with ALL option for Communicator 2.0")
	public void NewATI8841_VerifyCommunicatorForAllContentArea() throws Exception {
		log(logger, "NewATI884_VerifyCommunicatorForAllContentArea Start");
		loginPage.loginToApplication("AutoUser1505201857","Test123");
		
		//lvp1
		
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "lvp1");
		driver.get(driver.getCurrentUrl()); //http://ati-stg-scrm02.ad.ascendlearning.com/courses/defaultID/c769bae2-b0d8-4432-908e-7f5c578325e2/5/scorm.html
		Thread.sleep(5000);	
		flashApp.callFlashObject("Play");			
	  	Thread.sleep(5000);		
		flashApp.callFlashObject("StopPlay");			
		Thread.sleep(5000);		
		flashApp.callFlashObject("SetVariable","/:message","Flash testing using selenium Webdriver");
	    System.out.println(flashApp.callFlashObject("GetVariable","/:message"));	
	}*/
	
	@TestAnnotations(testID="NewATI-41")
	//@Test(priority =1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Check for simulation::Apply Tab")
	public void NewATI41_VerifySimulations() throws Exception {
		log(logger, "NewATI41_VerifySimulations Start");
		loginPage.loginToApplication("stagequizuser","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// step -3
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-4
		log(logger, "Click on Modules ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));

		// step-5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Begin case button ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.modules"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));

		log(logger, "Verify Simulation tab");
		boolean result = helpPage.verifySimulationsPage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-6
		log(logger, "Click on close button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));

		VerificationHandler.verifyTrue(result,"Simulation module is not present");
		log(logger, "NewATI41_VerifySimulations End");
	}

	
	@TestAnnotations(testID="NewATI-881")
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "NewATI-881:Verify that Communicator 2.0 card front under apply tab.")
	public void NewATI881_VerifyCommunicatorCardFront() throws Exception {
		log(logger, "NewATI881_VerifyCommunicatorCardFront Start");
		loginPage.loginToApplication("stagequizuser","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step - 2
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step - 3
		log(logger, "Verifying Communicator Card Front in Apply Tab");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationName("The Communicator 2.0"), "Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step - 4
		log(logger, "Verifying Simulation - Header");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationHeader("The Communicator 2.0"), "Unable to verify Simulation header");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Simulation - Product Title");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationName("The Communicator 2.0"), "Unable to verify Product Title");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Simulation - Accessed");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationMoudleAccess("The Communicator 2.0"), "Unable to verify Accessed value");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step - 5
		log(logger, "Verify total number of module");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationMoudleCount("The Communicator 2.0", "20"), "Unable to verify No of Modules");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI881_VerifyCommunicatorCardFront End");
	}
	
	@TestAnnotations(testID="NewATI-882")
	//@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "Verify that filter by content area with Mental Health option for Communicator 3.0.")
	public void NewATI882_VerifyCommunicatorForMentalHealthContentArea() throws Exception {
		log(logger, "NewATI882_VerifyCommunicatorForMentalHealthContentArea Start");
		loginPage.loginToApplication("stagequizuser","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step - 2
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step - 3
		log(logger, "Selecting Mental Health Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), PropertiesRepository.getString("new-atitesting.content.area.mental.health.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//VerificationHandler.verifyTrue(applyTabPage.veifySimulationName("The Communicator 2.0"), "Unable to verify Simulation name");
		
		// Step - 4
		log(logger, "Verify total number of module");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationMoudleCountContentArea("The Communicator 2.0"), "Unable to verify No of Modules");
		
		log(logger, "NewATI882_VerifyCommunicatorForMentalHealthContentArea End");
	}
	
	@TestAnnotations(testID="NewATI-883")
	//@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "NewATI-883:Verify that filter by content area with Nutrition and Wellness option for Communicator 2.0")
	public void NewATI883_VerifyCommunicatorForNutritionContentArea() throws Exception {
		log(logger, "NewATI883_VerifyCommunicatorForNutritionContentArea Start");
		
		loginPage.loginToApplication("stagequizuser","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step - 2
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step - 3
		log(logger, "Selecting Nutrition Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), PropertiesRepository.getString("new-atitesting.content.area.nutrition.wellness.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//VerificationHandler.verifyTrue(applyTabPage.veifySimulationName("The Communicator 2.0"), "Unable to verify Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step - 4
		log(logger, "Verify total number of module");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationMoudleCountContentArea("The Communicator 2.0"), "Unable to verify No of Modules");
		
		log(logger, "NewATI883_VerifyCommunicatorForNutritionContentArea End");
	}
	
	@TestAnnotations(testID="NewATI-884")
	//@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "NewATI-884:Verify that filter by content area with ALL option for Communicator 2.0")
	public void NewATI884_VerifyCommunicatorForAllContentArea() throws Exception {
		log(logger, "NewATI884_VerifyCommunicatorForAllContentArea Start");
		loginPage.loginToApplication("stagequizuser","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		createAccountPage.acceptTermsAndConditionsForNewUser();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		Thread.sleep(8000);
		// Step - 2
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step - 3
		log(logger, "Selecting Nutrition Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), PropertiesRepository.getString("new-atitesting.content.area.all.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//VerificationHandler.verifyTrue(applyTabPage.veifySimulationName("The Communicator 2.0"), "Unable to verify Simulation name");
		
		// Step - 4
		log(logger, "Verify total number of module");
		VerificationHandler.verifyTrue(applyTabPage.veifySimulationMoudleCount("The Communicator 2.0", "20"), "Unable to verify No of Modules");
		
		log(logger, "NewATI884_VerifyCommunicatorForAllContentArea End");
	}
	


	
}
