package com.automation.newati.regression.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.EBookPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class EBookTest1 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private LearnTabPage learnTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private EBookPage eBookPage;
	private TutorialPage tutorialPage;

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Exception {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		learnTabPage = new LearnTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		eBookPage=new EBookPage(driver);
		tutorialPage=new TutorialPage(driver);
		
		log(logger, "Loggin to application");
		
	}

	@TestAnnotations(testID = "NewATI-905")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-905:Verify each module title for eBook")
	public void NewATI905_VerifyEachModuleTitleForEBook() throws Exception {
		log(logger, "NewATI905_VerifyEachModuleTitleForEBook Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"),
				PropertiesRepository.getString("newati.login.password"));
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if RN eBook Library title is displayed on Card Front");
		VerificationHandler.verifyTrue(learnTabPage.verifyEbookCardFront(PropertiesRepository.getString("new-atitesting.learntab.module.name.502")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage
				.clickModuleButtonByNameEbook(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying eBook Titles");
		VerificationHandler.verifyTrue(eBookPage.verifyEbookTitles(),"Unable to find the ebooktitle");

		log(logger, "NewATI905_VerifyEachModuleTitleForEBook End");
	}


	@TestAnnotations(testID = "NewATI-504")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-504:To verify Update Offset Page Setting for RN Review Modules")
	public void NewATI504_ToVerifyUpdateOffsetPageSettingForRNReviewModules() throws Exception {
		log(logger, "NewATI504_ToVerifyUpdateOffsetPageSettingForRNReviewModules Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting ebook from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
		    .getString("new-atitesting.ebookDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Module name");
		practiceAssessmentPage.clickModuleButtonByNameEbook(PropertiesRepository.getString("new-atitesting.learntab.module.name.502"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Edition of RN Review Module");
		VerificationHandler.verifyTrue(learnTabPage.verifyUpdatedEdition("2016 eBook"), "Unable to verify Edition");
		log(logger, "NewATI504_ToVerifyUpdateOffsetPageSettingForRNReviewModules End");
	}


}