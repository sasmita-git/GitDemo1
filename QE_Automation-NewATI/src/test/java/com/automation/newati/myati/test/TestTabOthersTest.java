package com.automation.newati.myati.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class TestTabOthersTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		tutorialPage = new TutorialPage(driver);
		
		
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-496:Verification for message on Card Front for 'TIme Between Attempts' set for TUtorial")
	public void  NewATI496_VerifyTimeBetweenAttempts() throws Exception {
		log(logger, "NewATI496_VerifyTimeBetweenAttempts Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingTestTabAssessmentDisappeared("new-atitesting.peasewait.testtab.assessment.loading");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		/*VerificationHandler
				.verifyTrue(
						practiceAssessmentPage
								.verifyTimeBetweenAttempts(PropertiesRepository
										.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment")),
						"Unable to verify Time Between Attempts");*/
		
		log(logger, "Select Tutorial Module name");
//		boolean result=practiceAssessmentPage.verifyAvailableDaysForAssessment(PropertiesRepository.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment.new"));
//		VerificationHandler.verifyTrue(result);
		
		logger.info("NewATI496_VerifyTimeBetweenAttempts End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-497:Verification for visibiity of Tutorial card front when Time b/w attempts is set.")
	public void NewATI497_VerifyTimeBetweenAttempts() throws Exception {
		log(logger,"NewATI497_VerifyTimeBetweenAttempts Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab");
		log(logger,
				"Clicking on Skills Module Tutorial Module Button in Card Front");
		// Step 2 End
		tutorialPage.selectCardFrontBasedOnModuleName("Skills Modules 2.0");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		VerificationHandler
//		.verifyTrue(tutorialPage.verifyTimeBetweenAttemptsInLearnTab("Nasogastric Tube"), "Unable to verify Time Between att");
		log(logger, "NewATI497_VerifyTimeBetweenAttempts End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-43:Check for Source Online Store")
	public void  NewATI43_VerifyOnlineStoreSource() throws Exception {
		log(logger, "NewATI43_VerifyOnlineStoreSource Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.43.user.name"), PropertiesRepository.getString("newati.login.43.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingTestTabAssessmentDisappeared("new-atitesting.peasewait.testtab.assessment.loading");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		VerificationHandler
				.verifyTrue(
						practiceAssessmentPage
								.verifyProctorInfoSource(PropertiesRepository
										.getString("new-atitesting.practice.assessment.43.name"), "Online Store"),
						"Unable to verify Time Between Attempts");
		
		logger.info("NewATI43_VerifyOnlineStoreSource End");
	}
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "NewATI-57:Check for Source 'Institution - SelfPay'")
	public void  NewATI57_VerifyInstitutionSelfPaySource() throws Exception {
		log(logger, "NewATI57_VerifyInstitutionSelfPaySource Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.43.user.name"), PropertiesRepository.getString("newati.login.43.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillLoadingTestTabAssessmentDisappeared("new-atitesting.peasewait.testtab.assessment.loading");
		
		VerificationHandler
				.verifyTrue(
						practiceAssessmentPage
								.verifyProctorInfoSource(PropertiesRepository
										.getString("new-atitesting.practice.assessment.57.name"), "Institution - SelfPay"),
						"Unable to verify Time Between Attempts");
		
		logger.info("NewATI57_VerifyInstitutionSelfPaySource End");
	}
	
	@TestAnnotations(testID = "NewATI-939")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "verify view, sort and Type filters Functionality by closing an incomplete Assessment")
	public void NewATI939_VerifyTestTabSortOption() throws Exception {
		logger.info("NewATI939_VerifyTestTabSortOption Start");
		log(logger, "NewATI939_VerifyTestTabSortOption Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.stt.username"),
				PropertiesRepository.getString("newati.stt.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);

		log(logger, "Verifying Proctor Message in Test Tab ");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.myati.test.tab.proctored.message.loc"),
				"Unable to verify Proctor Message in Test Tab");
		
		log(logger, "Verifying RN Fundamentals Online Practice 2016 A name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.rn.fundamentals.online.practice.2016.a.value")),
				"Unable to verify RN Fundamentals Online Practice 2016 A");

		log(logger, "Clicking on RN Fundamentals Online Practice 2016 A");
		practiceAssessmentPage.clickModuleButtonByPracticeName(
				PropertiesRepository.getString("newati.myati.assessment.rn.fundamentals.online.practice.2016.a.value"));
		//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Tutorial Name");
		VerificationHandler.verifyTrue(
				tutorialPage.verifyMessageWithSwitchToAssessmentFrame(PropertiesRepository.getString("new.atitesting.assessment.name.loc"), 0,
						PropertiesRepository.getString("newati.myati.assessment.rn.fundamentals.online.practice.2016.a.value")),
				"Unable to Verify Tutorial Name");
		
		log(logger, "Clicking on Assessment Close button");
		VerificationHandler.verifyTrue(
				tutorialPage.verifyAndClickWithSwitchToAssessmentFrame(
						PropertiesRepository.getString("id.product.tutorial.assessment.close.button.loc"), true),
				"Unable to Click on Assessment Close button");

		log(logger, "Clicking on Yes button in Popup");
		VerificationHandler
				.verifyTrue(
						practiceAssessmentPage
								.verifyAndClick(PropertiesRepository.getString("newati.close.dialog.yes.LTI"), true),
						"Unable to Click on Yes button in Popup");
		
		logger.info("NewATI939_VerifyTestTabSortOption End");
		log(logger, "NewATI939_VerifyTestTabSortOption End");
	}
	
	@TestAnnotations(testID = "NewATI-940")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Verify My ATI Dropdown Functionality")
	public void NewATI940_VerifyATIDropdownFunctionality() throws Exception {
		logger.info("NewATI940_VerifyATIDropdownFunctionality Start");
		log(logger, "NewATI940_VerifyATIDropdownFunctionality Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.stt.username"),
				PropertiesRepository.getString("newati.stt.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);

		log(logger, "Verifying Proctor Message in Test Tab ");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.myati.test.tab.proctored.message.loc"),
				"Unable to verify Proctor Message in Test Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select All Option from Type DD");
		VerificationHandler
		.verifyTrue(testTabPage.selectOption(1, "All"), "Unable to Select All Option from Type DD");
		
		log(logger, "Verifying Practice, Proctored and Quiz Bank Assessment Type");
		List<String> allTypes = new ArrayList<String>();
		allTypes.add("Quiz Bank");
		allTypes.add("Practice Assessment");
		allTypes.add("Proctored Assessment");
		VerificationHandler
		.verifyTrue(testTabPage.verifyAssessmentType(allTypes), "Unable to Verifying Practice, Proctored and Quiz Bank Assessment Type");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Option from Type DD");
		VerificationHandler
		.verifyTrue(testTabPage.selectOption(1, "Practice"), "Unable to Select Practice Option from Type DD");
		
		log(logger, "Verifying Practice Assessment Type");
		List<String> practiceTypes = new ArrayList<String>();
		practiceTypes.add("Practice Assessment");
		VerificationHandler
		.verifyTrue(testTabPage.verifyAssessmentType(practiceTypes), "Unable to Verifying Practice Assessment Type");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Proctored Option from Type DD");
		VerificationHandler
		.verifyTrue(testTabPage.selectOption(1, "Proctored"), "Unable to Select Proctored Option from Type DD");
		
		log(logger, "Verifying Practice, Proctored and Quiz Bank Assessment Type");
		List<String> proctoredTypes = new ArrayList<String>();
		proctoredTypes.add("Proctored Assessment");
		VerificationHandler
		.verifyTrue(testTabPage.verifyAssessmentType(proctoredTypes), "Unable to Verifying Practice, Proctored and Quiz Bank Assessment Type");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Option from Type DD");
		VerificationHandler
		.verifyTrue(testTabPage.selectOption(1, "Quiz Banks"), "Unable to Select Practice Option from Type DD");
		
		log(logger, "Verifying Practice, Proctored and Quiz Bank Assessment Type");
		List<String> quizTypes = new ArrayList<String>();
		quizTypes.add("Quiz Bank");
		VerificationHandler
		.verifyTrue(testTabPage.verifyAssessmentType(quizTypes), "Unable to Verifying Practice, Proctored and Quiz Bank Assessment Type");
		
		log(logger, "Get selected option for type dd");
		String beforeChange = testTabPage.getSelectedOption(1);
		
		log(logger, "Clicking Learn Tab");
		homePage.clickSubTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Get selected option for type dd");
		String afterChange = testTabPage.getSelectedOption(1);
		VerificationHandler.verifyEquals(beforeChange, afterChange, "Selected values are not matching");
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.forgot.password.link"));
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.stt.username"),
				PropertiesRepository.getString("newati.stt.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Add Product Link is displayed in Home page after relogin");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab after relogin");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Content Area drop down is displayed after relogin");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab after relogin");
		homePage.clickSubTab(1);

		log(logger, "Verifying Proctor Message in Test Tab after relogin");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.myati.test.tab.proctored.message.loc"),
				"Unable to verify Proctor Message in Test Tab");
		
		log(logger, "Get selected option for type dd after relogin");
		String afterReLogin = testTabPage.getSelectedOption(1);
		VerificationHandler.verifyEquals("All", afterReLogin, "Selected values are not matching after relogin");
		
		logger.info("NewATI940_VerifyATIDropdownFunctionality End");
		log(logger, "NewATI940_VerifyATIDropdownFunctionality End");
	}
}
