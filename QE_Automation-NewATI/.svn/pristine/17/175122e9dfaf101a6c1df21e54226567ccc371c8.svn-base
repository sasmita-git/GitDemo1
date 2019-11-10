package com.automation.newati.applytab;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class VideoCaseStudies  extends BaseTest{
	
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
	private BaseHandler baseHandler;

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
		baseHandler=new BaseHandler(driver);
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-920")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-920:Verify landing page for VCS lite.")
	public void NewATI920_VerifyVCSLiteLandingPage() throws Exception {

		log(logger, "NewATI920_VerifyVCSLiteLandingPage Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.TEASShare"),
				PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Click on VCS by name
		log(logger, "Clicking on VCS by name");
		tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new-atitesting.vcs.rnLite"));
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
		
//		windowHandler.switchToFrame("#videoCaseStudiesLiteFrame");
		
		log(logger, "Verify if Player is Displayed");
//		tutorialPage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.VCS.player"));
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed(PropertiesRepository.getString("new-atitesting.VCS.player")));

		log(logger, "NewATI920_VerifyVCSLiteLandingPage End");
}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-924")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-924:VCS-LITE My Result page")
	public void NewATI924_VerifyVCSLiteMyResultsPage() throws Exception {

		log(logger, "NewATI924_VerifyVCSLiteMyResultsPage Start");
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.rn.pn.login.user.name"),
				PropertiesRepository.getString("newati.nclex.rn.pn.login.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2
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
		//Step 3
		log(logger, "Verify if all enabled products are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4
		log(logger, "Clicking on My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Get the Last Attempt Valuse from the result Tab by Module Name");
		VerificationHandler.verifyTrue(applyTabPage.verify_LAV_IV_TS(PropertiesRepository.getString("new-atitesting.vcs.module")));
		
		log(logger, "NewATI924_VerifyVCSLiteMyResultsPages End");
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-919:Verify card back functionality for VCS lite.")
	public void NewATI919_VerifyVCSLiteCardBack() throws Exception {

		log(logger, "NewATI919_VerifyVCSLiteCardBack Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.vcs"),
		PropertiesRepository.getString("newati.login.password"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on VCS by name");
		VerificationHandler.verifyTrue(tutorialPage.clickOnVCSModuleByName(PropertiesRepository.getString("new-atitesting.vcslite.pn")), "Unable to Click on VCS by name");
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
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicked on Close button in VCS lite");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Check for 'Hide disabled modules' checkbox.");
//		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.vcsLite.disablemodule.checkbox.loc"));

		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Click on close button");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		
		log(logger, "Check After accessing test module check status for module button.");
		VerificationHandler.verifyFalse(tutorialPage.verifyBeginLessonInCardBackForvcslite("new-atitesting.vcsLite.begintest.btn.loc",
			0,PropertiesRepository.getString("new.atitesting.vcslite.test.accessed.btnname")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Check for result page.");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.vcsLite.result.btn.loc"), 0);
		
		log(logger, "NewATI919_VerifyVCSLiteCardBack End");
	}
}
