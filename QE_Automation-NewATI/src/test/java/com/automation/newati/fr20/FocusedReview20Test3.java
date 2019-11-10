package com.automation.newati.fr20;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class FocusedReview20Test3 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ImproveTabPage improveTabPage;
	private TutorialPage tutorialPage;
	private MyResultsTabPage myResultsTabPage;
	private MyReportPage myReportPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		improveTabPage = new ImproveTabPage(driver);
		tutorialPage = new TutorialPage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		myReportPage = new MyReportPage(driver);

	}

	@TestAnnotations(testID = "NewATI1-686")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-686:Verify the functionality of New attempts for the multiple instance assessments")
	public void NewATI686_VerifyNewAttemptwithMultipleInstances() throws Exception {

		log(logger, "NewATI686_VerifyNewAttemptwithMultipleInstances Start");
		logger.info("NewATI686_VerifyNewAttemptwithMultipleInstances Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-3 & Step-4
		log(logger, "Verify Instances in Attempt Drop down");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyRetakeButtonInSelectInstance(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Verify Attempt in DD");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "NewATI686_VerifyNewAttemptwithMultipleInstances Ends");
		logger.info("NewATI686_VerifyNewAttemptwithMultipleInstances Ends");
	}

	@TestAnnotations(testID = "NewATI1-766")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-766:Verification for accessed assessment record under Improve tab")
	public void NewATI766_VerifyAssessmentStatusinImproveTab() throws Exception {

		log(logger, "NewATI766_VerifyAssessmentStatusinImproveTab Start");
		logger.info("NewATI766_VerifyAssessmentStatusinImproveTab Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-3
		log(logger, "Verifying Inprogress/Continue button under Select Instance");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyInprogressButtonInSelectInstance(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.assessment.value")),
				"Unable to Verify Attempt in DD");

		log(logger, "NewATI766_VerifyAssessmentStatusinImproveTab Ends");
		logger.info("NewATI766_VerifyAssessmentStatusinImproveTab Ends");

	}

	@TestAnnotations(testID = "NewATI-853")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-853:Verify message on proctor IPP page for focus review")
	public void NewATI853_VerifyFRProctorMessageinIPPPage() throws Exception {

		log(logger, "NewATI853_VerifyFRProctorMessageinIPPPage Start");
		logger.info("NewATI853_VerifyFRProctorMessageinIPPPage Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-Proctor-Username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-Proctor-Password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-3
		log(logger, "clicking on FR2.0 proctor assessment Link");
		myResultsTabPage.verifyAndClickProctorAssessmentName("RN Fundamentals 2016", true);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-4
		/**
		 * @TODO - Please rewrite the method.
		 */
		log(logger, "Verifying message for FR2.0 on IPP page");
		boolean verifyText = improveTabPage.VerifyProctorMessageInIPPPage("new-atitesting.proctor.message.ipp.page.loc",
				"Click Improve button to see Study Material");
		VerificationHandler.verifyTrue(verifyText);

		log(logger, "NewATI853_VerifyFRProctorMessageinIPPPage Ends");
		logger.info("NewATI853_VerifyFRProctorMessageinIPPPage Ends");

	}

	@TestAnnotations(testID = "NewATI-864")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-864:To verify [FR 2.0] My Results Page Updates")
	public void NewATI864_VerifyFR20inMyResultsPage() throws Exception {

		log(logger, "NewATI864_VerifyFR20inMyResultsPage Start");
		logger.info("NewATI864_VerifyFR20inMyResultsPage Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify FR2.0 updates in MyResults");

		log(logger, "Verify IPP Page Header");
		VerificationHandler.verifyFalse(myReportPage.verifyIPPPageSectionHeaders(), "Unable to verify IPP page header");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "verify results header");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.results.header.loc"),
				"Unable to verify results header");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "verify Header for practice assessment");
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPPageTable(),
				"Unable to verify Header for practice assessment");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		/*
		 * Note: Only Header is verified for FR Time spent and Focused Review Quiz
		 * Result as Cannot verify the Time spent and Quiz Score
		 */

		/**
		 * TODO - Please change locator.
		 */
		log(logger, "Verify Focused Review Time Header");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.myreslts.page.FRTime.header.loc"),
				"Unable to Verify Focused Review Time Header");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		/**
		 * TODO - Please change locator.
		 */
		log(logger, "verify Focused Review Quiz Result Header");
		VerificationHandler.verifyTrue(
				loginPage.isElementDisplayed("new-atitesting.myreslts.page.FRQuiz.result.header.loc"),
				"Unable to verify Focused Review Quiz Result Header");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "NewATI864_VerifyFR20inMyResultsPage Ends");
		logger.info("NewATI864_VerifyFR20inMyResultsPage Ends");

	}

	@TestAnnotations(testID = "NewATI-631")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-631:Verify the functionality of Test Type Filter Dropdown")
	public void NewATI631_VerifyStudyMaterialDDFunctionality() throws Exception {

		log(logger, "NewATI631_VerifyStudyMaterialDDFunctionality Start");
		logger.info("NewATI631_VerifyStudyMaterialDDFunctionality Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-3
		log(logger, "Verify FR2.0 assessment and Study Materials");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.improve.tab.review.button.loc"),
				"Unable to Verify FR2.0 assessment and Study Materials");

		// step-4
		log(logger, "Clicking on Study Materials ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.review.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		/**
		 * @TODO Need to verify dd values.
		 */
		log(logger, "NewATI631_VerifyStudyMaterialDDFunctionality Ends");
		logger.info("NewATI631_VerifyStudyMaterialDDFunctionality Ends");

	}

	@TestAnnotations(testID = "NewATI-803")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-803:Verify FR2.0 Study Quiz Result on IPP page")
	public void NewATI803_VerifyStudyMaterialDDFunctionality() throws Exception {

		log(logger, "NewATI803_VerifyStudyMaterialDDFunctionality Start");
		logger.info("NewATI803_VerifyStudyMaterialDDFunctionality Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-3
		log(logger, "Clicking MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "clicking on FR2.0 practice assessment Link");
		myResultsTabPage.verifyAndClickProctorAssessmentName("RN Fundamentals Online Practice 2016 A", true);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-4
		log(logger, "Verifying message for FR2.0 on IPP page");
		VerificationHandler.verifyTrue(
				improveTabPage.VerifyProctorMessageInIPPPage("new-atitesting.proctor.message.ipp.page.loc",
						"Click Improve button to see Study Material"),
				"Unable to Verifying message for FR2.0 on IPP page");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Note: Only Header is verified for Quiz Result as Cannot verify the Time spent
		// and Quiz Score

		log(logger, "verify Focused Review Quiz Result Header");
		VerificationHandler.verifyTrue(
				loginPage.isElementDisplayed("new-atitesting.myreslts.page.FRQuiz.result.header.loc"),
				"Unable to verify Focused Review Quiz Result Header");

		log(logger, "NewATI803_VerifyStudyMaterialDDFunctionality Ends");
		logger.info("NewATI803_VerifyStudyMaterialDDFunctionality Ends");

	}

	@TestAnnotations(testID = "NewATI-815")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-815:Verify the functionality of studymaterials on Imrpove tab")
	public void NewATI851_VerifyStudyMaterialDDwithAssessmentQuesAns() throws Exception {

		log(logger, "NewATI-815:Verify the functionality of studymaterials on Imrpove tab Start");
		logger.info("NewATI-815:Verify the functionality of studymaterials on Imrpove tab Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-3
		log(logger, "Verify FR2.0 assessment and Study Materials");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.improve.tab.review.button.loc"),
				"Unable to Verify FR2.0 assessment and Study Materials");

		// step-4
		log(logger, "Clicking on Study Materials ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab.review.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "selecting Assessment in Test Drop down");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.improvetab.test.type.DD.assessment"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-5
		log(logger, "Verifying Total Number of Questions and Answers in Card Front");
		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc", "Management of Care", 0),
				"Unable to Verifying Total Number of Questions and Answers in Card Front");
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc", "Physiological Adaptation",
				1));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc",
				"Safety and Infection Control", 2));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc",
				"Reduction of Risk Potential", 3));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc", "Basic Care and Comfort",
				4));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc", "Psychosocial Integrity",
				5));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc",
				"Health Promotion and Maintenance", 6));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(tutorialPage.verifyTextFromList(
				"new-atitesting.improve.tab.studymaterials.dropdown.content.area.list.loc",
				"Pharmacological and Parenteral Therapies", 7));
		VerificationHandler.verifyTrue(tutorialPage.checkElementEnabled(
				PropertiesRepository.getString("new-atitesting.improvetab.studymaterials.count.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "NewATI-815:Verify the functionality of studymaterials on Imrpove tab Ends");
		logger.info("NewATI-815:Verify the functionality of studymaterials on Imrpove tab Ends");
	}

	// Description: Toast message can not be automated as toast message is disappear
	// before the page is getting load.

	@TestAnnotations(testID = "NewATI-769")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = "{Regression}", description = "NewATI-769:Verify proctor not available message for proctor assessment under improve tab.")
	public void NewATI769_VerifyProctorNotAvailableToastMessage() throws Exception {

		log(logger, "NewATI769_VerifyProctorNotAvailableToastMessage Start");
		logger.info("NewATI769_VerifyProctorNotAvailableToastMessage Start");

		// Step-1
		loginPage.loginToApplication(PropertiesRepository.getString("new-atitesting-FR2.0-username.value"),
				PropertiesRepository.getString("new-atitesting-FR2.0-password.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking on Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// step-3
		/**
		 * @TODO - Need to add parameter for button name.
		 * 
		 */
		log(logger, "clicking on Continue/Begin/NewAttempt for proctor assessment");
		VerificationHandler.verifyTrue(
				improveTabPage.verifyProctorassessmentSelectInstance(
						PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.proctor.assessment.value")),
				"Unable to click on Continue/Begin/NewAttempt for proctor assessment");

		VerificationHandler
				.verifyTrue(
						loginPage.verifyContainsMessageWithDefaultWinSwitch(
								PropertiesRepository.getString("new-atitesting.toast.message"),
								PropertiesRepository
										.getString("new-atitesting.proctor.not.available.toast.message.value")),
						"unable to verify Toast message");

		log(logger, "NewATI769_VerifyProctorNotAvailableToastMessage Ends");
		logger.info("NewATI769_VerifyProctorNotAvailableToastMessage Ends");
	}
}
