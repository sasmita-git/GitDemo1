package com.automation.newati.payments;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.FlashCardPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class PaymentsProductTest extends BaseTest{

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private FlashCardPage flashCardPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		flashCardPage = new FlashCardPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.payment.product.username.update"), 
				PropertiesRepository.getString("newati.login.payment.product.password"));
	}
	
	@TestAnnotations(testID = "NewATI-944")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify if online purchased product(Tutorials) can be accessed successfully")
	public void NewATI944_VerifyPharmacologyTutorial() throws Exception {
		// Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 4
		log(logger, "Clicking Pharmacology Made Easy 3.0 Module ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.name"));
		// Step 4 
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Pharmacology Made Easy 3.0 Card back ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		// Step 4
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Taking assessment for Pharmacology Made Easy 3.0");
		tutorialPage.takeTestTEAS(false, false, false, false);
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
//		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, true, true, false);
		
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.clickTab(0);
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Pharmacology Made Easy 3.0 in Recent Activity");
		VerificationHandler.verifyTrue(homePage.verifyAndClickRecentActivity(PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.tutorial.loc"), "Tutorial", "Pharmacology Made Easy 3.0", "In Progress"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking assessment for Pharmacology Made Easy 3.0");
		tutorialPage.takeTestPharmacologyAndNurseLogic30(false, false, true, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying IPP page");
		myReportPage.waitUntillIPPPageIsLoaded(".sub-header>section>img");
		VerificationHandler.verifyTrue(myReportPage.verifyIPPPageHeader(), "IPP page is not displayed");
		
		logger.info("Method : NewATI944_VerifyPharmacologyTutorial End");
	}
	
	@TestAnnotations(testID = "NewATI-941")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify if online purchased product(Flash card) can be accessed successfully")
	public void NewATI941_VerifyFlashCard() throws Exception {
		// Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Active Stack® Pharmacology Flash Cards Module ");
		tutorialPage
		.clickModuleButtonByName(PropertiesRepository
				.getString("new.atitesting.learntab.selfpay.assess.name.tutorial"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Flash card card back");
		flashCardPage.clickFlasCardCardBack(PropertiesRepository.getString("new.atitesting.learntab.flashcard.name.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Home Tab");
		homePage.clickTab(0);
		// Step 5
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Pharmacology Made Easy 3.0 in Recent Activity");
		homePage.verifyAndClickRecentActivity(PropertiesRepository.getString("new-atitesting.home.tab.recent.activity.flashcard.loc"), "Flashcard", "Active Stack® Pharmacology Flash Cards", "In Progress");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Start Flash Assessment in Flash Card - Completed");
		// Completing the flash card.
		flashCardPage.startFlashAssessment();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
}
