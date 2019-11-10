package com.automation.newati.student.engagement.New;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class HomeTabTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ButtonHandler btnHandler;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private MyATITabMainPage myATITabMainPage;
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		btnHandler = new ButtonHandler(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
	}

	/**
	 * Pre Condition - Overall % should be greater than 1.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-699")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-699:Verify if Overall Usage Percentage Speedometer is displaying in pulse banner")
	public void NewATI699_VerifyPulseBannerTest() throws Exception {

		logger.info("Method : NewATI699_VerifyPulseBannerTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(), "Pulse Banner is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if overall usage percentage is Displayed");
		VerificationHandler.verifyTrue(learnTabPage.IsDisplayed(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.numeric.value.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");

		logger.info("Method : NewATI699_VerifyPulseBannerTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-700")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = " NewATI-700:Verify if NCLEX passing score value is displaying in Pulse banner")
	public void NewATI700_VerifyNCLEXPassingScoreTest() throws Exception {

		logger.info("Method : NewATI700_VerifyNCLEXPassingScoreTest Start");
		loginPage.loginToApplication("stage_march21","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(), "Pulse Banner is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify if the numeric value is as expected");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.numeric.value.loc",
						"new-atitesting.homepage.puse.banner.numeric.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,
				"Verify Status category · 90% - 99% 'On Track' , 80% - 89% 'Needs Improvement' , 79% or below 'At Risk' ");
		VerificationHandler.verifyTrue(homePage.VerifyStatusCategory(
				"new-atitesting.homepage.puse.banner.numeric.value", "new-atitesting.homepage.puse.banner.status.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI700_VerifyNCLEXPassingScoreTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-702")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-702:Verification for pop up message when clicked on Overall product usage on Pulse banner")
	public void NewATI702_VerifyPopupMessageTest() throws Exception {

		logger.info("Method : NewATI702_VerifyPopupMessageTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on info Icon");
		btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.info.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify Popup Title");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.info.popup.title.loc", 0,
						"new-atitesting.homepage.puse.banner.info.popup.title"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI702_VerifyPopupMessageTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-703")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-703:Verification for View Details link on Pulse banner")
	public void NewATI703_VerifyViewDetailsLinkTest() throws Exception {

		logger.info("Method : NewATI703_VerifyViewDetailsLinkTest Start");
		loginPage.loginToApplication("smoke_march13","Test123");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if View Details Link is Displayed");
		VerificationHandler.verifyTrue(
				loginPage.isElementDisplayed("new-atitesting.homepage.puse.banner.view.details.link.loc"),
				"View Details link is not Dispalyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on View Details Link");
		btnHandler.clickButton(
				PropertiesRepository.getString("new-atitesting.homepage.puse.banner.view.details.link.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Predict Tab");
		tutorialPage.clickButtonFromList("new-atitesting.homepage.puse.banner.view.details.link.predictAndUsageTab.loc",
				0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().frame("predictFrame2");
		
		log(logger, "Verfify Predict Tab Table heading");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.predictTab.heading.loc",
						"new-atitesting.homepage.puse.banner.predictTab.heading"));
		driver.switchTo().window(parentWindow);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Usage Tab");
		tutorialPage.clickButtonFromList("new-atitesting.homepage.puse.banner.view.details.link.predictAndUsageTab.loc",
				1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(50000);
		driver.switchTo().frame("usageFrame2");

		log(logger, "Verfify Predict Tab Table heading");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.UsageTab.heading.loc",
						"new-atitesting.homepage.puse.banner.UsageTab.heading"));

		logger.info("Method : NewATI703_VerifyViewDetailsLinkTest End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-807")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-807:Verification for speedometer pop up message under Pulse banner")
	public void NewATI807_VerifySpeedometerPopupMsgeTest() throws Exception {

		logger.info("Method : NewATI807_VerifySpeedometerPopupMsgeTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));

		log(logger, "Verify if Pulse Banner is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerDiaplayed(), "Pulse Banner is not Dispalyed");

		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");

		log(logger, "Click on the Speedometer");
		btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.spedometer.loc"));

		log(logger, "Verfify if the Popup text is as expected");
		VerificationHandler.verifyTrue(
				homePage.VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.puse.banner.speedometer.text.loc",
						"new-atitesting.homepage.puse.banner.speedometer.text"));

		logger.info("Method : NewATI807_VerifySpeedometerPopupMsgeTest End");
	}
	
	@TestAnnotations(testID="NewATI-106")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression, Smoke"}, description = "Verify if User Terms and Conditions Link opens")
	public void  NewATI106_UserTermsAndConditionsLink() throws Exception {
		log(logger, "NewATI106_UserTermsAndConditionsLink Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify home tab bottom links");
		VerificationHandler.verifyTrue(homePage.verifyHomeTabBottomLinks(), "Home tab bottom links are not displayed");
		
		log(logger,"click on User Terms and Condiditions Link");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.userTermsConditionsLinkLoc"),2);
		log(logger,"User Terms and Condiditions link is clicked ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if the User Terms and Condiditions link is opened");
		VerificationHandler.verifyTrue(homePage.verifyUserTermsAndConditionsPage(), "User Terms and Condiditions page is not opened.");
		
		logger.info("NewATI106_UserTermsAndConditionsLink Ends");
	}
	
	@TestAnnotations(testID="NewATI-809")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-809:Verification for pop up message when clicked on 'i' icon on pulse banner")
	public void  NewATI809_VerifyiIconPulseBanner() throws Exception {
		log(logger, "NewATI809_VerifyiIconPulseBanner Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on info icon in pulse banner Start");
		btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.pulse.banner.info.btn.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying pop up message when clicked on info icon on pulse banner");
//		VerificationHandler.verifyTrue(homePage.VerifyMessageInfoIcon(), "Pulse banner message not displayed");
		
		logger.info("NewATI809_VerifyiIconPulseBanner Ends");
	}
	@TestAnnotations(testID="NewATI-706")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-706:Verification of color code of Overall usage percentage speedometer for score 0%")
	public void  NewATI706_verifySpeedometercolor0Percent() throws Exception {
		log(logger, "NewATI706_verifySpeedometercolor0Percent Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.speedometer.zero.percent.user"), PropertiesRepository.getString("newati.speedometer.zero.percent.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score0.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.grey.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		logger.info("NewATI706_verifySpeedometercolor0Percent Ends");
	}
	@TestAnnotations(testID="NewATI-962")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-962:Verification of color code of Overall usage percentage speedometer for score between between (1-39)")
	public void  NewATI962_SpeedometerColorpercentage1() throws Exception {
		log(logger, "NewATI962_SpeedometerColorpercentage1 Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.new.pulse"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyFalse(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.red.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		logger.info("NewATI962_SpeedometerColorpercentage1 Ends");
	}
	@TestAnnotations(testID="NewATI-963")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-963:Verification of color code of Overall usage percentage speedometer for score between between (40-84)")
	public void  NewATI963_SpeedometerColorpercentage41() throws Exception {
		log(logger, "NewATI963_SpeedometerColorpercentage41 Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.new"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.yellow.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		logger.info("NewATI963_SpeedometerColorpercentage41 Ends");
	}
	
	@TestAnnotations(testID="NewATI-964")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-964:Verification of color code of Overall usage percentage speedometer for score between between(85-100)")
	public void  NewATI964_SpeedometerColorpercentage85() throws Exception {
		log(logger, "NewATI964_SpeedometerColorpercentage85 Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.Speedometer.color.usage.100%.user"), PropertiesRepository.getString("newati.Speedometer.color.usage.100%.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyFalse(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.green.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		logger.info("NewATI964_SpeedometerColorpercentage85 Ends");
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-701")
	@Test(priority = 11, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-701:Verification of color code of Overall usage percentage speedometer")
	public void NewATI701_VerifyOverallUsageTest() throws Exception {

		logger.info("Method : NewATI701_VerifyOverallUsageTest Start");
		
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.gray.user"),PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		
		//Step 2
		log(logger, "Verify if overall usage percentage is Displayed");
		VerificationHandler.verifyTrue(learnTabPage.IsDisplayed(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.numeric.value.loc.new")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");
		
		String myAtiSMvalue = homePage.getText(".usage-overlay-60 div span");
		
		//Step 3
		log(logger, "Verifying if Speedometer value is 0%");
		VerificationHandler.verifyTrue(myAtiSMvalue.equals("0%"));
		
		log(logger, "Verifying if Speedometer color id Gray");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score0.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.grey.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Loging with user having different SpeedoMeter value
		loginPage.loginToApplication(PropertiesRepository.getString("newati.red.user"),"ati");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 4
		String myAtiSMvalue2 = homePage.getText(".usage-overlay-60 div span");
		String myAtiSMvaluenew2 = StringUtils.substring(myAtiSMvalue2, 0, myAtiSMvalue2.length() - 1);
				
		log(logger, "Verifying if Speedometer value is is between 1-39");
		VerificationHandler.verifyTrue(Integer.parseInt(myAtiSMvaluenew2) >= 1 && Integer.parseInt(myAtiSMvaluenew2) <= 39);
		
		log(logger, "Verifying if Speedometer color is red");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.red.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Loging with user having different SpeedoMeter value
		loginPage.loginToApplication(PropertiesRepository.getString("newati.yellow.user"),"ati");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 4
		String myAtiSMvalue3 = homePage.getText(".usage-overlay-60 div span");
		String myAtiSMvaluenew3 = StringUtils.substring(myAtiSMvalue3, 0, myAtiSMvalue3.length() - 1);
				
		log(logger, "Verifying if Speedometer value is is between 40-84");
		VerificationHandler.verifyTrue(Integer.parseInt(myAtiSMvaluenew3) >= 40 && Integer.parseInt(myAtiSMvaluenew3) <= 84);
		
		log(logger, "Verifying if Speedometer color is yellow");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.yellow.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Loging with user having different SpeedoMeter value
		loginPage.loginToApplication(PropertiesRepository.getString("newati.green.user"),"ati");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 4
		String myAtiSMvalue4 = homePage.getText(".usage-overlay-60 div span");
		String myAtiSMvaluenew4 = StringUtils.substring(myAtiSMvalue4, 0, myAtiSMvalue4.length() - 1);
				
		log(logger, "Verifying if Speedometer value is is between 85-100");
		VerificationHandler.verifyTrue(Integer.parseInt(myAtiSMvaluenew4) >= 85 && Integer.parseInt(myAtiSMvaluenew4) <= 100);
		
		log(logger, "Verifying if Speedometer color is yellow");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(PropertiesRepository.getString("new-atitesting.speedometer.score1.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.green.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue")));
			
		logger.info("Method : NewATI701_VerifyOverallUsageTest End");
	}
	
	

}
