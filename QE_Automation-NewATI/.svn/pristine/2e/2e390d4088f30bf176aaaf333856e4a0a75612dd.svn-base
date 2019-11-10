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

public class VerifyNoDataBoardVitalsFunctionalityTest extends BaseTest {

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
	
	@TestAnnotations(testID="NewATI-609")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify NCLEX Prep tab when no products are added")
	public void NewATI609_VerifyNCLEXPrepTab() throws Exception {
		logger.info("Method : NewATI609_VerifyNCLEXPrepTab Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1"), PropertiesRepository.getString("newati.nclex.login.password"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		
		boolean verifyTextFromList = tutorialPage.verifyTextFromList("new-atitesting.nclextab.nodata.loc", "No NCLEX Preparation materials currently available.",0);
		VerificationHandler.verifyTrue(verifyTextFromList);
		
		logger.info("Method : NewATI609_VerifyNCLEXPrepTab End");
	}
	
	@TestAnnotations(testID="NewATI-580")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify Board vitals product enable/disable feature as part of CDN::Card Front")
	public void NewATI580_VerifyTheCardBackPage() throws Exception {
		logger.info("Method : NewATI580_VerifyTheCardBackPage Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name2"), PropertiesRepository.getString("newati.nclex.login.password"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(5);
		
		log(logger, "click on add product button");
		tutorialPage.clickButton("new-atitesting.nclextab.add.product.loc");
		
		log(logger, "enter cdn");
		tutorialPage.enterText("new-atitesting.nclextab.add.product.input.loc", "new-atitesting.nclextab.cdn.input",0);
		
		log(logger, "click on continue button");
		tutorialPage.clickButton("new-atitesting.add.product.continue.button.loc");
		
		log(logger, "click on hide disabled checkbox button");
		tutorialPage.clickButton("new-atitesting.nclextab.checkbox.loc");
		
		boolean verifyTextFromList = tutorialPage.verifyTextFromList("new-atitesting.nclextab.nodata.loc", "No NCLEX Preparation materials currently available.",0);
		VerificationHandler.verifyTrue(verifyTextFromList);
		
		logger.info("Method : NewATI580_VerifyTheCardBackPage End");
	}
}
