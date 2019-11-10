package com.automation.newati.board.vitals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyBoardVitalsFunctionalityTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
	}
	
	@TestAnnotations(testID="NewATI-602")	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the card back page::Card Back")
	public void NewATI602_VerifyTheCardBackPage() throws Exception {
		logger.info("Method : NewATI602_VerifyTheCardBackPage Start");
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.newuser"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		loginPage.loginToApplication("boardvital01","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//log(logger, "click on terms and condition checkbox");
		//tutorialPage.clickButton("new-atitesting.nclex.modules.terms.condition.loc");
		
		boolean verifyNCLXBoardLinkNames = tutorialPage.verifyNCLXBoardLinkNames("new-atitesting.nclextab.cardback.loc");
		VerificationHandler.verifyTrue(verifyNCLXBoardLinkNames);
		
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));

		logger.info("Method : NewATI602_VerifyTheCardBackPage End");
	}
	
	@TestAnnotations(testID="NewATI-604")
	@Test(priority = 2, description = "NewATI-604:Verify Accessed Date & Time spent in card back page")
	public void NewATI604_VerifyAccessedDateAndTimeSpentIncardBackPage() throws Exception {
		logger.info("Method : NewATI604_VerifyAccessedDateAndTimeSpentIncardBackPage Start");
		
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.PN.new"), PropertiesRepository.getString("newati.nclex.login.password3"));
		loginPage.loginToApplication("boardvital01","Test123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//log(logger, "click on terms and condition checkbox");
		//tutorialPage.clickButton("new-atitesting.nclex.modules.terms.condition.loc");
		
		boolean verifyNCLXBoardLinkNames = tutorialPage.verifyModuleStatus("new-atitesting.nclextab.cardback.accessed.time.loc");
		VerificationHandler.verifyTrue(verifyNCLXBoardLinkNames);
		
		log(logger, "click on NCLEX Adaptive Test");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.AdaptiveTest.cardback.loc"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Thread.sleep(30000);
		//homePage.waitUntillElementIsVisible("new-atitesting.nclexprep.AdaptiveTest.lauch.loc");
		//homePage.verifyLogo("new-atitesting.nclexprep.AdaptiveTest.lauch.loc");
		log(logger, "click on close button");
		
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.AdaptiveTest.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));

		logger.info("Method : NewATI604_VerifyAccessedDateAndTimeSpentIncardBackPage End");
	}
	
	@TestAnnotations(testID="NewATI-577")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the UI in Card Front page of Board Vitals NCLEX Prep")
	public void NewATI577_VerifyUIInCardFrontPage() throws Exception {
		logger.info("Method : NewATI577_VerifyUIInCardFrontPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name577"), PropertiesRepository.getString("newati.nclex.login.passwordbv.name577"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		boolean cardFrontHeader = tutorialPage.verifyCardFrontHeader();
		VerificationHandler.verifyTrue(cardFrontHeader);
		
		boolean elementDisplayed = tutorialPage.isElementDisplayed("new-atitesting.nclextab.cardfront.info.loc");
		VerificationHandler.verifyTrue(elementDisplayed);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean footerLoc = tutorialPage.isElementDisplayed("new-atitesting.nclextab.cardfront.footer.loc");
		VerificationHandler.verifyTrue(footerLoc);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifyText1 = tutorialPage.verifyText("new-atitesting.nclextab.cardfront.name.loc","Board Vitals NCLEX Prep PN");
		VerificationHandler.verifyTrue(verifyText1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifyText = tutorialPage.verifyText("new-atitesting.nclextab.cardfront.button.name.loc","Begin");
		VerificationHandler.verifyTrue(verifyText);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		logger.info("Method : NewATI577_VerifyUIInCardFrontPage End");
	}
	
	@TestAnnotations(testID="NewATI-582")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "To verify Board Vitals- Navigate User to Shell Page of Board Vitals")
	public void NewATI582_VerifyShellPageofBoardVitals() throws Exception {
		logger.info("Method : NewATI582_VerifyShellPageofBoardVitals Start");
		
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.newuser"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		loginPage.loginToApplication("boardvital01","Test123");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		tutorialPage.clickButtonFromList("new-atitesting.nclextab.cardback.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//log(logger, "click on terms and condition checkbox");
		//tutorialPage.clickButton("new-atitesting.nclex.modules.terms.condition.loc");
		
		boolean verifyNclexModuleName = tutorialPage.verifyNclexModuleName(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		VerificationHandler.verifyTrue(verifyNclexModuleName);
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.click.yes"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI582_VerifyShellPageofBoardVitals End");
	}

	@TestAnnotations(testID="NewATI-676")
	@Test(priority = 5, description = "NewATI-676:Verify the recent activity for board vitals.")
	public void NewATI676_VerifyTheRecentActivityForBoardVitals() throws Exception {
		logger.info("Method : NewATI676_VerifyTheRecentActivityForBoardVitals Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.vcs"), PropertiesRepository.getString("newati.nclex.login.password"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		tutorialPage.clickButtonFromList("new-atitesting.nclextab.cardback.loc", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on terms and condition checkbox");
		tutorialPage.clickButton("new-atitesting.nclex.modules.terms.condition.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifyNclexModuleName = tutorialPage.verifyNclexModuleName(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		VerificationHandler.verifyTrue(verifyNclexModuleName);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.click.yes"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//verify recent activity
		tutorialPage.clickButtonFromList("new-atitesting..kognito.recent.activity", 0);
		tutorialPage.verifyTextFromList("new-atitesting.nclex.modules.name",PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"), 0);
		
		/*log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
				
		log(logger, "Clicking NCLEXPREP Tab");
		tutorialPage.clickButtonFromList("new-atitesting.nclextab.cardback.loc", 1);
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		
		
		log(logger, "Clicking NCLEXPREP Tab");
		tutorialPage.clickButtonFromList("new-atitesting.nclextab.cardback.loc", 2);
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
		
		log(logger, "click on close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));*/

		logger.info("Method : NewATI676_VerifyTheRecentActivityForBoardVitals End");
	}
	
}
