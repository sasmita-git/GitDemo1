package com.automation.newati.myati.others;

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

public class VerifyContentAreafunctionality extends BaseTest {
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		
		loginPage.loginToApplication("TestCal23rdJuly","Test123");
	}

	@TestAnnotations(testID = "NewATI-154")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = "{Smoke}", description = "Content Area functionality::My ATI")
	public void NewATI154_VerifyContentAreaFunctionality() throws Exception {
		log(logger, "NewATI154_VerifyContentAreaFunctionality: Start");

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Selecting value in DropDown List ");
		// tutorialPage.selectValueBySelectClass("new-atitesting.homepage.myatitab.contentarea.dropdown.loc","new-atitesting.homepage.myatitab.contentarea.dropdown.value","new-atitesting.homepage.myatitab.contentarea.dropdown.options.loc");
		tutorialPage
				.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify content in Learn Tab ");
		VerificationHandler.verifyTrue(
				tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.learn.tab")),
				"Learn Tab Content is not validated");

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify Content of Test Tab ");
		VerificationHandler.verifyTrue(
				tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.Test.tab")),
				"Validation is fail for Test Tab Content");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify Content of Apply Tab ");
		VerificationHandler.verifyTrue(
				tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.apply.tab")),
				"Validation is fail for Apply Tab Content");
		log(logger, "NewATI154_VerifyContentAreaFunctionality: end ");

	}
}
