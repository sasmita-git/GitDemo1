package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;

public class VerifyModuleUnderTutorialTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private  MyReportPage myReportPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage= new MyReportPage(driver);
	}

	
	@Test(priority=1,description = "Smoke NewATI-635:Verify skill modules 2. posttest completion certificate in IPP page")
	public void NewATI635_VerifySkillModulesTest() throws Exception {
		
		log(logger, "NewATI635_VerifySkillModulesTest Start");
		
		loginPage.loginToApplication("Stgreg001", PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(1);
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Selecting Tutorial from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.product.name"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "cliking on the pretest btutton of card back");
		tutorialPage.clickOnPostTestCardBackButtonbyName(PropertiesRepository.getString("new-atitesting.learntab.railway.management.section.name"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment");
		tutorialPage.takeTest(false, false, true, false);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying IPP page");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verifying close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on cardback close button");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
		
		log(logger, "NewATI635_VerifySkillModulesTest End");
	}

}
