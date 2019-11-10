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
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class MyAtiTabTest extends BaseTest{
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private LearnTabPage learnTabPage;
	private PulseLandingPage pulseLandingPage;
	private MyATITabMainPage myATITabMainPage;
	private TutorialPage tutorialPage;
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		pulseLandingPage = new PulseLandingPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-704")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-704: Verify if Overall Usage Percentage Speedometer is displaying under My ATI tab [Version : 1]")
	public void NewATI704_VerifyOverallSMPercentTest() throws Exception {
		
		String homeSMvalue;
		String myAtiSMvalue;
		String fvSMvalue;

		logger.info("Method : NewATI704_VerifyOverallSMPercentTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name.new"),PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		//Speedometer Value on the home page
		homeSMvalue = homePage.getText(".usage-overlay-60 div span");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);				
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify if Learn tab , Test tab , Improve tab , Apply tab , NCLEX PREP tab are Displayed");
		VerificationHandler.verifyTrue(learnTabPage.IsDisplayed(".ui-tabs-nav.ui-helper-reset.ui-helper-clearfix.ui-widget-header.ui-corner-all"));
		
		log(logger, "Verify if overall usage percentage is Displayed");
		VerificationHandler.verifyTrue(learnTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.numeric.value.loc")));

		log(logger, "Verify if Pulse Banner Speedometer is Displayed");
		VerificationHandler.verifyTrue(homePage.VerifyIfPulseBannerSpeedometerDiaplayed(),
				"Pulse Banner Speedometer is not Dispalyed");		
		
		//Speedometer Value on the MyAti page
		myAtiSMvalue = homePage.getText(".usage-overlay-60 div span");
		
		driver.navigate().to("https://stage-faculty.atitesting.com");
		pulseLandingPage.navigateToPatrialSEPage(PropertiesRepository.getString("Faculty.login.pulse.user.name"), PropertiesRepository.getString("Faculty.login.pulse.user.password"),"pulseagain" ,PropertiesRepository.getString("newati.login.pulse.user702.name.new"));
		fvSMvalue = homePage.getText("#viewOne .custom-table.false tbody tr:nth-child(1) td:nth-child(5) a div svg g text[dy='-12']");
		
		log(logger, "Verify if value in speedometer is matching with Home tab speedometer value and also with Faculty view displayed value");
		VerificationHandler.verifyTrue(homeSMvalue.equals(myAtiSMvalue) && homeSMvalue.equals(myAtiSMvalue) && myAtiSMvalue.equals(fvSMvalue) ,"Speedometer values are not equal");
				
		logger.info("Method : NewATI704_VerifyOverallSMPercentTest End");
		
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-705	")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-705:Verify the Overall usage speedometer on Pulse banner under MyATI tab [Version : 1]")
	public void NewATI705_VerifyOverallUagePulseBannerTest() throws Exception {
		
		String homeSMvalue;
		String myAtiSMvalue;
		
		logger.info("Method : NewATI705_VerifyOverallUagePulseBannerTest Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name.new"),PropertiesRepository.getString("newati.login.pulse.user.password"));		
		
		//Speedometer Value on the home page
		homeSMvalue = homePage.getText(".usage-overlay-60 div span");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify if Learn tab , Test tab , Improve tab , Apply tab , Predict tab are Displayed");
		VerificationHandler.verifyTrue(learnTabPage.checkElementEnabled(".ui-tabs-nav.ui-helper-reset.ui-helper-clearfix.ui-widget-header.ui-corner-all"));
		
		log(logger, "Verify if overall usage percentage is Displayed");
		VerificationHandler.verifyTrue(learnTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.numeric.value.loc")));
		
		//Speedometer Value on the MyAti Tab
		myAtiSMvalue = homePage.getText(".usage-overlay-60 div span");
		
		log(logger, "Verify if the MyATI tab Speedometer value matches with Home tab Speedometer value");
		VerificationHandler.verifyTrue(homeSMvalue.equals(myAtiSMvalue),"MyATI tab Speedometer value does not match with Home tab Speedometer value");
		
		logger.info("Method : NewATI705_VerifyOverallUagePulseBannerTest End");
		
	}
	
	@TestAnnotations(testID="NewATI-716")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-716:Verification of color code of speedometer on module level when score is 0%")
	public void  NewATI716_cardbackSpeedometerColor0Percent() throws Exception {
		log(logger, "NewATI716_cardbackSpeedometerColor0Percent Start");
		loginPage.loginToApplication("smoke_march13","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.pharmacology.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyspeedometercolor(PropertiesRepository.getString("new-atitesting.speedometer.score0.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.Speedometer.grey.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue"),1));
		
		logger.info("NewATI716_cardbackSpeedometerColor0Percent Ends");
	}
	
	@TestAnnotations(testID="NewATI-966")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-966:Verification of color code of speedometer on module level when score is between 1-39 percentage")
	public void  NewATI966_cardbackSpeedometerColorPercent1() throws Exception {
		log(logger, "NewATI966_cardbackSpeedometerColorPercent1 Start");
		loginPage.loginToApplication("stagepulse21","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new.atitesting.module.name.sk2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyspeedometercolor(PropertiesRepository.getString("new-atitesting.cardback.speedometer.loc.Sk2"),
				PropertiesRepository.getString("new-atitesting.Speedometer.red.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue"),3));
		
		logger.info("NewATI966_cardbackSpeedometerColorPercent1 Ends");
	}
	
	@TestAnnotations(testID="NewATI-967")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-967:Verification of color code of speedometer on module level when score is between 40-84 percentage")
	public void  NewATI967_cardbackSpeedometerColor40Percent() throws Exception {
		log(logger, "NewATI967_cardbackSpeedometerColor40Percent Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.Speedometer.color.module.yellow.user"), PropertiesRepository.getString("newati.Speedometer.color.usage.100%.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyspeedometercolor(PropertiesRepository.getString("new-atitesting.cardback.speedometer.loc.Nurselogic"),
				PropertiesRepository.getString("new-atitesting.Speedometer.yellow.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue"),0));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("NewATI967_cardbackSpeedometerColor40Percent Ends");
	}
	@TestAnnotations(testID="NewATI-968")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-968:Verification of color code of speedometer on module level when score is between 85-100 percentage")
	public void  NewATI968_cardbackSpeedometerColor85Percent() throws Exception {
		log(logger, "NewATI968_cardbackSpeedometerColor85Percent Start");
		loginPage.loginToApplication("stagesedata1","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.pharmacology.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying speedometer color");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyspeedometercolor(PropertiesRepository.getString("new-atitesting.cardback.speedometer.loc.Nurselogic"),PropertiesRepository.getString
				("new-atitesting.Speedometer.green.css.color.value"),PropertiesRepository.getString("new-atitesting.speedometer.css.score1.color.attribue"),0));
		
		logger.info("NewATI968_cardbackSpeedometerColor85Percent Ends");
	}
}
