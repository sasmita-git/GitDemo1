package com.automation.newati.smoke;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PulseUserSmokeTest6 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	public BaseHandler baseHandler;
	private ApplyTabPage applyTabPage;
	private TutorialPage tutorialPage;
	private  BaseHandler baseHadler;
	private WindowHandler windowHandler;

	String downloadFilepath = null;
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		baseHandler = new BaseHandler(driver);
		tutorialPage=new TutorialPage(driver);
		baseHadler=new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	//Vcs lite,Board Vital,civility
	@TestAnnotations(testID="NewATI-862")
	@Test(priority = 10, enabled = true, alwaysRun = true, groups = {"Smoke", "Regression"}, description = "NewATI-862:Verify the functionality for simulation")
	public void NewATI862_VerifyTheFunctionalityForSimulation() throws Exception {
		log(logger, "NewATI862_VerifyTheFunctionalityForSimulation Start");
		
	
		log(logger, "Loging to application");
		loginPage.enterURL("newati.stage.login.url");
		log(logger, "login to application with existing user ");
					
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.newpulse"), PropertiesRepository.getString("newati.login.password1"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		//we should validate MYATI page loaded and we should verify all the tabs under MYATI page
		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
		PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index.update"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify list of modules  ");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.tutorial.cardback.buttons.update"),"List of modules");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Video Case Study in card front ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.videocasestudy.link.index.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify list of modules  ");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.tutorial.cardback.buttons.update"),"List of modules");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
//		log(logger, "Verifying 'Civility Mentor' in Card Front in Apply Tab");
////		VerificationHandler.verifyTrue(
////				applyTabPage.veifySimulationName(PropertiesRepository.getString("new.atitesting.CM")),
////				"Unable to verify Simulation name");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		
//		// Step 3 and 4
//		log(logger, "Clicking on 'Civility Mentor' ");
//		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new.atitesting.CM"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//
//		log(logger, "Clicking on first module on card back");
//		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.firstModule.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		// Step 5		
//		log(logger, "Verify if URL contains LTI");
//		VerificationHandler.verifyTrue(driver.getCurrentUrl().contains("LTI"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify if Close button is displayed");
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.button.LTI.civility"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify Simulation Name");
//		VerificationHandler.verifyTrue(baseHadler.findElement(PropertiesRepository.getString("newati.simulation.name.LTI")).getText().equals(PropertiesRepository.getString("new.atitesting.CM")));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
//		log(logger, "Verify if Module Name ");
//		VerificationHandler.verifyTrue(baseHadler.findElement(PropertiesRepository.getString("newati.product.module.name.LTI")).getText().equals(PropertiesRepository.getString("new.atitesting.CM.module1")));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//	
//		log(logger, "Click on Close button");
//		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.button.LTI.civility"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify if Close Dialog is displayed");
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.dialog.yes.LTI.new"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Click on Yes button");
////		driver.findElement(By.cssSelector(".button.primary-button.focus-element-flag.focus-on")).click();
//		tutorialPage.clickButton(".button.primary-button.focus-element-flag.focus-on");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Verify if view drop down in card back is displayed");
//		
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new.atitesting.cardback.dd.loc"));
//		log(logger, "Click on close button");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		log(logger, "Clicking on VCS by name");
		tutorialPage.clickOnVCSModuleByName("Video Case Studies RN - Lite");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on 'Acid-Base Imbalance' begin button");
		tutorialPage.clickButton("a[id^='BeginLessonButton']", 0);
		logger.info("Clicking on Dismiss button");
		// clicking on Dismiss button for chrome 69 popup. 
//		List<WebElement> dismissElement = baseHandler.findElements("button[class='md-btn md-btn-blue']");
//		if(CollectionUtils.isNotEmpty(dismissElement)) {
//			dismissElement.get(0).click();
//			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//			homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		}
		windowHandler.switchToMainWindow();
		windowHandler.switchToLatestWindow();
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Module Name is Displayed");
		driver.findElement(By.cssSelector("span[data-bind='text:ContentProductModuleName']")).isDisplayed();
//		tutorialPage.isElementDisplayed("span[data-bind='text:ContentProductModuleName']");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Sub Module Name is Displayed");
		Boolean disp1=driver.findElement(By.cssSelector("span[data-bind='text:ContentProductName']")).isDisplayed();
		VerificationHandler.verifyTrue(disp1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if 'VIEW CHALLENGE VIDEO' button is Displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.VCS.view.challenge.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if 'VIEW EXPERT RESPONSE VIDEO' button is Displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.VCS.view.expert.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on View Challenge button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.VCS.view.challenge.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String whandle = driver.getWindowHandle();
//		windowHandler.switchToFrame("#videoCaseStudiesLiteFrame");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Player is Displayed");
//		tutorialPage.waitUntillElementIsVisible(".vjs-limelight-big-play");
//		windowHandler.switchToFrame("#videoCaseStudiesLiteFrame");
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed(PropertiesRepository.getString("new-atitesting.VCS.player")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		driver.switchTo().window(whandle);
		log(logger, "Clicking on View Response button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.VCS.view.expert.button"), 0);
		log(logger, "Clicked on Close button in VCS lite");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on close button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.vcs"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
	    homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
//	    homePage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifyNCLXBoardLinkNames = tutorialPage.verifyModuleStatus("new-atitesting.nclextab.cardback.accessed.time.loc");
		VerificationHandler.verifyTrue(verifyNCLXBoardLinkNames);
		
		
		
		
		log(logger, "NewATI862_VerifyTheFunctionalityForSimulation End");
	}
}
