package com.automation.newati.regression.testtab;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class LearningSystemTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private TextHandler textHandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private CreateAccountPageNewSmoke createAccountPage;
	private MyResultsTabPage myResultsTabPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		textHandler = new TextHandler(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		tutorialPage = new TutorialPage(driver);
	}

	@TestAnnotations(testID = "NewATI-900")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Verify that Quiz Bank tag under Test tab.")
	public void NewATI900_VerifyLearningSystemInTestTab() throws Exception {
		logger.info("NewATI900_VerifyLearningSystemInTestTab Start");
		log(logger, "NewATI900_VerifyLearningSystemInTestTab Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
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

		log(logger, "Verifying Learning System PN 2.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.2.0.value")),
				"Unable to verify Learning System PN 2.0");

		log(logger, "Verifying Learning System RN 2.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.2.0.value")),
				"Unable to verify Learning System RN 2.0");

		log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to verify Learning System PN 3.0");

		log(logger, "Verifying Learning System RN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value")),
				"Unable to verify Learning System RN 3.0");

		logger.info("NewATI900_VerifyLearningSystemInTestTab End");
		log(logger, "NewATI900_VerifyLearningSystemInTestTab End");
	}

	@TestAnnotations(testID = "NewATI-886")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Verify if Dynamic Quizzes section is available on LS 3.0 card back")
	public void NewATI886_VerifyLearningSystemDynamicQuizesSection() throws Exception {
		logger.info("NewATI886_VerifyLearningSystemDynamicQuizesSection Start");
		log(logger, "NewATI886_VerifyLearningSystemDynamicQuizesSection Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
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

		log(logger, "Verifying Learning System RN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value")),
				"Unable to verify Learning System RN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System RN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Dynamic Quizzes Section");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyDynamicQuizzesSection(),
				" Unable to click on module button for Learning System RN 3.0");

		log(logger, "Getting Access Never Status");
		VerificationHandler.verifyEquals(PropertiesRepository.getString("new-atitesting.nclexprep.gc.accessed"),
				practiceAssessmentPage.verifyAccessedStatus(), "Unable to verify Accessed Status as Never");

		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage
						.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true),
				"Unable to Click on Card back close button");

		log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to verify Learning System PN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System PN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Dynamic Quizzes Section");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyDynamicQuizzesSection(),
				" Unable to click on module button for Learning System PN 3.0");

		log(logger, "Getting Access Never Status");
		String accessDate = practiceAssessmentPage.verifyAccessedStatus();

		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage
						.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true),
				"Unable to Click on Card back close button");

		logger.info("NewATI886_VerifyLearningSystemDynamicQuizesSection End");
		log(logger, "NewATI886_VerifyLearningSystemDynamicQuizesSection End");
	}

	@TestAnnotations(testID = "NewATI-887")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Verify if Standard Quizzes section is available on LS 3.0	card back")
	public void NewATI887_VerifyLearningSystemAllModuleList() throws Exception {
		logger.info("NewATI887_VerifyLearningSystemAllModuleList Start");
		log(logger, "NewATI887_VerifyLearningSystemAllModuleList Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
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

		log(logger, "Verifying Learning System RN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value")),
				"Unable to verify Learning System RN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System RN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Standard Quizzes Section");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyStandardQuizzesSection(),
				" Unable to click on module button for Learning System RN 3.0");

		log(logger, "Getting Access Never Status");
		VerificationHandler.verifyEquals(PropertiesRepository.getString("new-atitesting.nclexprep.gc.accessed"),
				practiceAssessmentPage.verifyAccessedStatus(), "Unable to verify Accessed Status as Never");

		log(logger, "Verifying Standard Quizzes all module name");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyModuleNameInAscendingOrder(),
				"Unable to Verify Standard Quizzes all module name");

		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage
						.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true),
				"Unable to Click on Card back close button");

		log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to verify Learning System PN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System PN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Standard Quizzes Section");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyStandardQuizzesSection(),
				" Unable to click on module button for Learning System PN 3.0");

		log(logger, "Getting Access Never Status");
		String accessDate = practiceAssessmentPage.verifyAccessedStatus();

		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage
						.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true),
				"Unable to Click on Card back close button");

		logger.info("NewATI887_VerifyLearningSystemAllModuleList End");
		log(logger, "NewATI887_VerifyLearningSystemAllModuleList End");
	}

	@TestAnnotations(testID = "NewATI-888")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Verification for Terms & Conditions window for Learning System3.0")
	public void NewATI888_VerifyLearningSystemTermsAndConditionWindow() throws Exception {
		logger.info("NewATI888_VerifyLearningSystemTermsAndConditionWindow Start");
		log(logger, "NewATI888_VerifyLearningSystemTermsAndConditionWindow Start");
		if (count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId == null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Add Product button");
		createAccountPage.clickOnAddProductButton();
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.learn.tab.loc"),
				PropertiesRepository.getString("newati.learning.studio.terms.and.condition.cohort.quiz"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler
				.verifyTrue(homePage.isElementDisplayed("new.atitesting.home.page.recent.activity.header.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);

		log(logger, "Verifying Proctor Message in Test Tab ");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.myati.test.tab.proctored.message.loc"),
				"Unable to verify Proctor Message in Test Tab");

		log(logger, "Verifying Learning System RN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value")),
				"Unable to verify Learning System RN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System RN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		/*
		 * log(logger, "Verifying Standard Quizzes Section");
		 * VerificationHandler.verifyTrue(practiceAssessmentPage.
		 * verifyStandardQuizzesSection(),
		 * " Unable to click on module button for Learning System RN 3.0");
		 * 
		 * log(logger, "Getting Access Never Status");
		 * VerificationHandler.verifyEquals(PropertiesRepository.getString(
		 * "new-atitesting.nclexprep.gc.accessed"),
		 * practiceAssessmentPage.verifyAccessedStatus(),
		 * "Unable to verify Accessed Status as Never");
		 * 
		 * log(logger, "Verifying Standard Quizzes all module name");
		 * VerificationHandler.verifyTrue(
		 * practiceAssessmentPage.verifyModuleNameInAscendingOrder()
		 * ,"Unable to Verify Standard Quizzes all module name");
		 * 
		 * log(logger, "Clicking on Close button"); VerificationHandler.verifyTrue(
		 * practiceAssessmentPage.verifyAndClick(PropertiesRepository.getString(
		 * "new-atitesting.cardback.close.loc.new"), true),
		 * "Unable to Click on Card back close button");
		 * 
		 * log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		 * VerificationHandler.verifyTrue(
		 * practiceAssessmentPage.verifyAssessmentNameByName(
		 * PropertiesRepository.getString(
		 * "newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
		 * "Unable to verify Learning System PN 3.0");
		 * 
		 * log(logger, "Clicking on Quizzes button for Learning System PN 3.0");
		 * practiceAssessmentPage.clickModuleButtonByName(
		 * PropertiesRepository.getString(
		 * "newati.myati.assessment.quiz.learning.system.pn.3.0.value"));
		 * homePage.waitUntillLoadingImageIsDisappeared(
		 * "new-atitesting.peasewait.bufferLoc");
		 * 
		 * log(logger, "Verifying Standard Quizzes Section");
		 * VerificationHandler.verifyTrue(practiceAssessmentPage.
		 * verifyStandardQuizzesSection(),
		 * " Unable to click on module button for Learning System PN 3.0");
		 * 
		 * log(logger, "Getting Access Never Status"); String accessDate =
		 * practiceAssessmentPage.verifyAccessedStatus();
		 * 
		 * log(logger, "Clicking on Close button"); VerificationHandler.verifyTrue(
		 * practiceAssessmentPage.verifyAndClick(PropertiesRepository.getString(
		 * "new-atitesting.cardback.close.loc.new"), true),
		 * "Unable to Click on Card back close button");
		 */

		logger.info("NewATI888_VerifyLearningSystemTermsAndConditionWindow End");
		log(logger, "NewATI888_VerifyLearningSystemTermsAndConditionWindow End");
	}

	@TestAnnotations(testID = "NewATI-1014")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify if Standard Quizzes section is available on LS 3.0 card back")
	public void NewATI1014_VerifyLearningSystemRecentActivity() throws Exception {
		logger.info("NewATI1014_VerifyLearningSystemRecentActivity Start");
		log(logger, "NewATI1014_VerifyLearningSystemRecentActivity Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
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

		log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to verify Learning System PN 3.0");

		log(logger, "Clicking on Quizzes button for Learning System PN 3.0");
		practiceAssessmentPage.clickModuleButtonByName(
				PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Dynamic Quizzes Section");
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyDynamicQuizzesSection(),
				" Unable to click on module button for Learning System PN 3.0");

		log(logger, "Getting Access Never Status");
		String accessAfter = practiceAssessmentPage.verifyAccessedStatus();

		log(logger, "Clicking on Button under Dynamic Quizzes");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.clickDynamicQuizzesButton(PropertiesRepository
						.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.adaptive.quizzes.value")),
				"Unable to Click on Button under Dynamic Quizzes");

		log(logger, "Verifying Tutorial Name");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyMessage(PropertiesRepository.getString("newati.myati.test.tab.ls.quiz.name.in.assessment.page.loc"), 1,
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to Verify Tutorial Name");

		log(logger, "Verfiying Module Name");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyMessage(PropertiesRepository.getString("newati.myati.test.tab.ls.quiz.name.in.assessment.page.loc"), 3,
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.adaptive.quizzes.value")),
				"Unable to Verify Module Name");

		/*
		 * log(logger, "Verifying Quiz Name in Assessment Page"); log(logger,
		 * "Verifying Customize Exam Section");
		 * practiceAssessmentPage.verifyCustomizeExamSection();
		 */

		log(logger, "Clicking on Quiz Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAndClick(
						PropertiesRepository.getString("newati.myati.test.tab.ls.quiz.name.close.button.loc"), true),
				"Unable to Click on Quiz Close button");

		log(logger, "Clicking on Yes button in Popup");
		VerificationHandler
				.verifyTrue(
						practiceAssessmentPage
								.verifyAndClick(PropertiesRepository.getString("newati.close.dialog.yes.LTI"), true),
						"Unable to Click on Yes button in Popup");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage
						.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true),
				"Unable to Click on Card back close button");

		log(logger, "Clicking Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying NCLEX Recent Activity Section 1");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyLSRecentActivity(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"),
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.adaptive.quizzes.value")),
				"Unable to Verify NCLEX Recent Activity Section 1");
		logger.info("NewATI1014_VerifyLearningSystemRecentActivity End");
		log(logger, "NewATI1014_VerifyLearningSystemRecentActivity End");
	}
	
	@TestAnnotations(testID = "NewATI-889")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify if Dynamic Quizzes result available under My Result.")
	public void NewATI889_VerifyLearningSystemMyResults() throws Exception {
		logger.info("NewATI889_VerifyLearningSystemMyResults Start");
		log(logger, "NewATI889_VerifyLearningSystemMyResults Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking My Results Tab");
		homePage.clickTab(2);
		
		log(logger, "Verifyig My Results Page is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage(PropertiesRepository.getString("new.atitestig.my.results.header.loc"),
						PropertiesRepository.getString("new.atitestig.my.results.header.value")));
		
		log(logger, "Verify LS name, header and section");
		VerificationHandler.verifyTrue(
		myResultsTabPage.verifyLSResultsSection(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"), true),
		"Unable to verify LS name, header and section");
		
		
		log(logger, "Verifying Tutorial Name");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyMessage(PropertiesRepository.getString("newati.myati.test.tab.ls.quiz.name.in.assessment.page.loc"), 1,
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to Verify Tutorial Name");

		log(logger, "Verfiying Module Name");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyMessage(PropertiesRepository.getString("newati.myati.test.tab.ls.quiz.name.in.assessment.page.loc"), 3,
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.quizzes.results.value")),
				"Unable to Verify Module Name");
		
		logger.info("NewATI889_VerifyLearningSystemMyResults End");
		log(logger, "NewATI889_VerifyLearningSystemMyResults End");
	}
	
	@TestAnnotations(testID = "NewATI-890")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify if Learning System 3.0 is available under Test Tab")
	public void NewATI890_VerifyLearningSystemUnderTestTab() throws Exception {
		logger.info("NewATI890_VerifyLearningSystemUnderTestTab Start");
		log(logger, "NewATI890_VerifyLearningSystemUnderTestTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
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

		log(logger, "Verifying Learning System PN 3.0 name under Test Tab");
		VerificationHandler.verifyTrue(
				practiceAssessmentPage.verifyAssessmentNameByName(
						PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value")),
				"Unable to verify Learning System PN 3.0");
		
		log(logger, "Verifying Assessment Type, Assessment Name, button and info icon details");
		VerificationHandler.verifyTrue(
		practiceAssessmentPage.verifyAssessmentTypeAndName("Quiz Bank", "Learning System PN 3.0")
		, "Unable to verify Assessment Type, Assessment Name, button and info icon details");
		
		logger.info("NewATI890_VerifyLearningSystemUnderTestTab End");
		log(logger, "NewATI890_VerifyLearningSystemUnderTestTab End");

	}
	
	@TestAnnotations(testID = "NewATI-903")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify that filter flow for quiz with content area tag .")
	public void NewATI903_VerifyLearningSystemContentTag() throws Exception {
		logger.info("NewATI903_VerifyLearningSystemContentTag Start");
		log(logger, "NewATI903_VerifyLearningSystemContentTag Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.learning.system.3.0.login.username"),
				PropertiesRepository.getString("newati.learning.system.3.0.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		
		log(logger, "Selecting 'Communication' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.communication"));
		
		log(logger, "Verifying LS Assessment name under Test Tab");
		List<String> quizNameList = new ArrayList<String>();
		quizNameList.add(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.2.0.value"));
		quizNameList.add(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.2.0.value"));
		quizNameList.add(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"));
		quizNameList.add(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.rn.3.0.value"));
		VerificationHandler.verifyTrue(practiceAssessmentPage.verifyAssessmentNameDisplayed(PropertiesRepository.getString("new.atitestig.test.tab.card.front.header.name"), quizNameList),
				"Unable to verify LS Assessment name under Test Tab");
		
		logger.info("NewATI903_VerifyLearningSystemContentTag End");
		log(logger, "NewATI903_VerifyLearningSystemContentTag End");
	}
	
}
