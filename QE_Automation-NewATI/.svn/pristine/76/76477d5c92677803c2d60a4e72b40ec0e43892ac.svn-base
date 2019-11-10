package com.automation.newati.student.engagement.New;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class GeneralScenariosTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private LearnTabPage learnTabPage;
	private TestTabPage testTabPage;
	private ApplyTabPage applyTabPage;
	private NclexPrepTabPage nclexPage;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		learnTabPage = new LearnTabPage(driver);
		testTabPage = new TestTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		nclexPage = new NclexPrepTabPage(driver);
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-735")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-735: Verification for non availability Overall Usage for non pulse user [Version : 1]")
	public void NewATI735_VerifySeRelatedDataNotPresent() throws Exception {

		logger.info("Method : NewATI735_VerifySeRelatedDataNotPresent Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.nonpulse"),PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Pulse Banner is Not Displayed");
		VerificationHandler.verifyTrue(!(homePage.VerifyIfPulseBannerDiaplayed()));
		
		logger.info("Method : NewATI735_VerifySeRelatedDataNotPresent End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-736")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-736: Verification for non availability of speedometer for tutorials (EBOOKS , FLASHCARDS, TEAS SMARTPREP) [Version : 1]")
	public void NewATI736_VerifySMNonAvailability() throws Exception {

		logger.info("Method : NewATI736_VerifySMNonAvailability Start");
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"),PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2 
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verfify if Learn tab , Test tab , Improve tab , Apply tab , NCLEX PREP tab are Displayed");
		VerificationHandler.verifyTrue(learnTabPage.IsDisplayed(".ui-tabs-nav.ui-helper-reset.ui-helper-clearfix.ui-widget-header.ui-corner-all"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 3	
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify non availability of speedometer for EBOOKS , FLASHCARDS, TEAS SMARTPREP ");
		VerificationHandler.verifyTrue(learnTabPage.IdSpeedometerPresent());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Apply Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3 );
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify non availability of speedometer for EBOOKS , FLASHCARDS, TEAS SMARTPREP ");
		VerificationHandler.verifyTrue(learnTabPage.IdSpeedometerPresent());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on NCLEX Tab
		log(logger, "Clicking on NCLEX Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 4 );
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify non availability of speedometer for Board Vital Products ");
		VerificationHandler.verifyTrue(learnTabPage.IdSpeedometerPresent());	
						
		logger.info("Method : NewATI736_VerifySMNonAvailability End");
	}				
			 
			 
			 
			 
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-737")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-737: Verification for non availability if speedometer for Proctor assessments [Version : 1]")
	public void NewATI737_VerifySMNotDisplayedForProctorAssTest() throws Exception {

		logger.info("Method : NewATI737_VerifySMNotDisplayedForProctorAssTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Practice and Proctor assessments are displayed");
		VerificationHandler.verifyTrue(testTabPage.VerifyIfEnabledPracticeAndProctorDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Speedometer is Not Displayed for Proctor assessments");
		VerificationHandler.verifyTrue(testTabPage.VerifyIfSMIsNotDisplayedForProctorAss());		

		logger.info("Method : NewATI737_VerifySMNotDisplayedForProctorAssTest End");
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-738")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-738: Verification for non availability of speedometer for Following products under Apply tab (Video Case [Version : 1]")
	public void NewATI738_VerifySMNotDisplayedForVideoCaseStudies() throws Exception {

		logger.info("Method : NewATI737_VerifySMNotDisplayedForProctorAssTest Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"),
				PropertiesRepository.getString("newati.login.pulse.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations and Video Case Studies are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Speedometer is Not Displayed for Video Case Studies");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfSMIsNotDisplayedOnVideoCS());		

		logger.info("Method : NewATI738_VerifySMNotDisplayedForVideoCaseStudies End");
		
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-741")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-741: Verify if information table is getting closed by clicking on Close button (applicable for both Card [Version : 1]")
	public void NewATI741_VerifyInfoTableCloseBtnFunctionality() throws Exception {

		//Step 1
		logger.info("Method : NewATI741_VerifyInfoTableCloseBtnFunctionality Start");
		loginPage.loginToApplication("smoke_march13","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2
		Thread.sleep(5000);
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed()); 
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 3
		log(logger, "Verify if information table is displaying by clicking on Speedometer card front");
		VerificationHandler.verifyTrue(learnTabPage.VerifyifInfoTablePresent());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Steep 4
		log(logger, "Verify if information table is is Closed when clicked on close button");
		VerificationHandler.verifyTrue(!(learnTabPage.clickOnInfoTableCloseBtn()));		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Steep 5 
		log(logger, "Click on Module button having Speedometer");
		learnTabPage.clickOnModuleWithSpeedometer();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Speedometer on Card back");
		tutorialPage.clickButtonFromList("new-atitesting.speedometer.cardback.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify Speedometer Table header");
		VerificationHandler.verifyTrue(learnTabPage.verifyUsageTableHeader(".custom-table.back-usage-data" , "Usage"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if information table is is Closed when clicked on close button on Card Back");
		VerificationHandler.verifyTrue(!(learnTabPage.clickOnInfoTableCloseBtnCardBack()));		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI741_VerifyInfoTableCloseBtnFunctionality End");
		
	}	
	
	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-742")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-742: Verication for Suggested time and accessed time match of tutorials between FV and SV [Version : 1]")
	public void NewATI742_VerifyAccessedTimeOnCardFrontSMAndCardBackSM() throws Exception {

		String cardFrontTimeSpentValue ;
		int cardBackTimeSpentValue ;
		
		logger.info("Method : NewATI742_VerifyAccessedTimeOnCardFrontSMAndCardBackSM Start");
		loginPage.loginToApplication("stagepulse22","Test123");
		
		//Step 1
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed()); 		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 3 and 4
		log(logger, "Get Time Spent Value from Card front info Table");
		cardFrontTimeSpentValue = learnTabPage.getCardFrontTimeSpentValue(PropertiesRepository.getString("new-atitesting.learntab.NewATI-742.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 5
		log(logger, "Clicking on Modules button");
		learnTabPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.NewATI-742.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Accessed modules should be available on card back");
		VerificationHandler.verifyTrue(learnTabPage.VerifyAccessedModuleIsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 6 and 7
		log(logger, "Get total Time Spent Value from Card Back info Table for all the modules");
//		cardBackTimeSpentValue = learnTabPage.getCardBackTimeSpentValue(); 
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Time spent value should are matching");
//		VerificationHandler.verifyTrue(Integer.parseInt(cardFrontTimeSpentValue.substring(0, cardFrontTimeSpentValue.length() - 1)) == cardBackTimeSpentValue);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI742_VerifyAccessedTimeOnCardFrontSMAndCardBackSM End");
		
	}	
	


	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-745")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-745:Verification for accessed modules count on Speedometer usage table of products")
	public void NewATI745_VerifyAccessedModuleCount() throws Exception {

		String cardFrontAM ;
		int cardBackAMCount ;
		//Step 1
		logger.info("Method : NewATI745_VerifyAccessedModuleCount Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user.name") , PropertiesRepository.getString("newati.login.pulse.user.password"));
		
		//Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Speedometer is Displayed on all active tutorials except ATI TEAS SmartPrep tutorial");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfSpeedometerIsDisplayedOnAllTutorials());
		
		//Step 3		
		log(logger, "Clicking on Speedo Meter by Name");
		learnTabPage.clickSMByName(PropertiesRepository.getString("new-atitesting.learntab.NewATI-742.product.name"));
		
		log(logger, "Verify Speedometer Table header");
		VerificationHandler.verifyTrue(learnTabPage.verifyUsageTableHeaderCF(PropertiesRepository.getString("newati.card.front.infoTable.headers.loc") , "Total Modules,Accessed Modules,Recent Score,Time Spent,Time Suggested,"));
		
		log(logger, "Closing Info Table");
		learnTabPage.clickOnInfoTableCloseBtn();
		
		//Step 4
		log(logger, "Get Time 'Accessed Modules' from Card front info Table");
		cardFrontAM = learnTabPage.getCardFrontAccessedModulesValue(PropertiesRepository.getString("new-atitesting.learntab.NewATI-742.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		
		log(logger, "Clicking on Modules button");
		learnTabPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.NewATI-742.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Get Time 'Accessed Modules' count from Card Back");
		cardBackAMCount = learnTabPage.getCountOfSMGresterThanZero( );
		
		log(logger, "Verify if Speedometer Accessed Modules count number should be equal to the Accessed module count on card back");
		VerificationHandler.verifyTrue(cardBackAMCount == Integer.parseInt(cardFrontAM));
		
		logger.info("Method : NewATI745_VerifyAccessedModuleCount End");
		
	}	
	
}
