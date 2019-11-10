package com.automation.newati.quiz;

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
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.QuizPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class QuizTest extends BaseTest{

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private QuizPage quizPage;
	private MyReportPage myReportPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private TestTabPage testTabPage;
	private TextHandler textHandler;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	private CreateAccountPageNewSmoke createAccountPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		quizPage = new QuizPage(driver);
		myReportPage =new MyReportPage(driver);
		testTabPage=new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		textHandler=new TextHandler(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
//		loginPage.loginToApplication("Ascend_stage24","Test_123");
		
		
	}
	
	@TestAnnotations(testID="NewATI-97")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Quiz Bank Functionality::Test Tab")
	public void NewATI97_VerifyQuizBankFunctionality() throws Exception {
		logger.info("NewATI97_VerifyQuizBankFunctionality Start");
		// Step 3, 4 Start
		// Step 2 Start
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product button");
		createAccountPage.clickOnAddProductButton();
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.learn.tab.loc"),
				PropertiesRepository.getString("newati.GC.cohort.Quiz"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		// Click on Learn Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		log(logger, "Selecting Quiz from Test Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
		
		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 2 End

		// Step 5 End
		int i = quizPage.getQuizCardFrontCount(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0"));
		log(logger, "the quiz count is " + i);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 6, 7 Start
		
		VerificationHandler.verifyTrue(quizPage.checkInfoButtonByAssessmentNameForQuiz(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")));
		log(logger, "Verifying Assessment Name");
		log(logger, "Verifying Assessment Info button ");
		// Step 6, 7 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 10 Start
		VerificationHandler.verifyTrue(quizPage.verifyAssessmentAccessedStateAsNever(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")));
		log(logger, "Verifying Assessment Accessed State");
		// Step 10 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 11 & 12 Start
		log(logger, "Clicking Module by Name");
		tutorialPage.clickQuizModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")),
				"Unable to verify Module name");
		
		// Step 11 & 12 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		quizPage.getQuizCardbackCount();
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "the quiz card back count is " + i);
		
		// Step 15 Start
		quizPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		log(logger, "Clicking on Being Quiz button");
		// Step 15 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 16 Start
		VerificationHandler.verifyTrue(quizPage.verifyAssesmentNameInAssessmentPage());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(quizPage.verifyAssessmentShowHintButton(),"Unable to verify Show Hint Button in Nurse Logic Page");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Assessment Show Hint Button");
		VerificationHandler
				.verifyTrue(tutorialPage.verifyAssessmentStartingNumberButtonWithoutSwitch(),
						"Unable to verify Question Starting Number in Nurse Logic Page");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Assessment Question Start No");
		VerificationHandler.verifyTrue(
				tutorialPage.verifyAssessmentEndingNumberButtonWithoutSwitch(),
				"Unable to verify Question Ending Number in Nurse Logic Page");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Assessment Question End No");
		
		log(logger, "Verifying Assessment Submit Button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentSubmitButtonWithoutSwitch());
		
		log(logger, "Verifying Assessment Continue Button");
		// Step 16 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 17 Start
		VerificationHandler.verifyTrue(quizPage.clickAssessmentToolsButtonWithoutSwitch(),
				"Unable to verify Tools Glosasry, Calcualtor and Study Guide");
		log(logger, "Verifying Assessment Tools Button");
		// Step 17 End

		// Step 21 Start
		//quizPage.clickContinueWithoutAnswering();
		// Step 21 End

		// Step 22 Start
		VerificationHandler.verifyTrue(tutorialPage.takeTestQuiz(false, false, true, false));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying IPP page");
		boolean result=myReportPage.verifyIPPpageObjects();
		VerificationHandler.verifyTrue(result, "PIP page is not displayed");
		
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Complete Assessment Functionality");
		// Step 22 End
		logger.info("NewATI97_VerifyQuizBankFunctionality Start");
	}
	
	//For Maintainance
	
	@Test(priority = 1, groups = {"Smoke"}, description = "NewATI-97:Quiz Bank Functionality")
	public void NewATI779a_VerifyQuizBankMaintainance() throws Exception {
		logger.info("NewATI97_VerifyQuizBankFunctionality Start");
		// Step 3, 4 Start
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.allDropdown.quizbans.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		// Step 2 End

		// Step 5 End

		int i = quizPage.getQuizCardFrontCount(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "the quiz count is " + i);

		// Step 6, 7 Start
		quizPage.checkInfoButtonByAssessmentNameForQuiz(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "Verifying Assessment Name");
		log(logger, "Verifying Assessment Info button ");
		// Step 6, 7 End

		// Step 10 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		quizPage.verifyAssessmentAccessedStateAsNever(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "Verifying Assessment Accessed State");
		// Step 10 End

		// Step 11 & 12 Start

		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc"));
		log(logger, "Clicking Module by Name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 11 & 12 End

		quizPage.getQuizCardbackCount();
		log(logger, "the quiz card back count is " + i);
		// Step 15 Start
		quizPage.clickBeginQuizInCardBack(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.name.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Being Quiz button");
		// Step 15 End

		// Step 16 Start
		VerificationHandler.verifyTrue(quizPage
				.verifyAssesmentNameInAssessmentPage());
		log(logger, "Verifying Assessment Name");
		
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
	}
	
	@Test(priority = 2, groups = {"Regression"}, description = "NewATI-149:Quiz Bank Select Instance")
	public void NewATI149_VerifyQuizSelectInstance() throws Exception {
		logger.info("Method : NewATI149_VerifyQuizSelectInstance Start");
		loginPage.loginToApplication("Ascend_stage24","Test_123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Add Product Button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Product ID");
		tutorialPage.enterText("new-atitesting.add.product.id.new.loc", "new-atitesting.add.product.quiz.id", 0);
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Password");
		tutorialPage.enterText("new-atitesting.add.product.password.new.loc", "new-atitesting.add.product.quiz.pwd", 0);
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		

		// Click on Learn Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		log(logger, "Selecting Quiz from Test Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
		
		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 End
		
		// Step 7 Start
		log(logger, "Clicking Module by Name");
		VerificationHandler.verifyTrue(tutorialPage
		.clickModuleButtonByNameSelectInstance(PropertiesRepository
				.getString("new-atitesting.learntab.quiz.bank.name.loc.2.0")), "Unable to verify Instance");
		
		// Step 7 End
		
		logger.info("Method : NewATI149_VerifyQuizSelectInstance End");
	}
	
	@Test(priority = 3, groups = {"Regression"}, description = "NewATI-31: Check for Quiz Bank")
	public void NewATI31_VerifyQuiz() throws Exception {
		logger.info("NewATI31_VerifyQuiz: Start");
		loginPage.loginToApplication("Autostagequizz","Test123");
		
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Sort Tutorial
		log(logger, "Selecting Quiz from Test Tab");
//		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
		
		testTabPage.selectFiltersDropDown(1, "Quiz Banks");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 End
		
		// Click on Modules on Card front
		practiceAssessmentPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")),
				"Unable to verify Module name");
	
		log(logger, "Clicked on Quiz Bank Modules Button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click Begin on Card back
		String quizName = quizPage.clickQuizName(0);
		
		log(logger, "Clicked on Begin or Continue Button in Quiz Bank Card Back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verifying the Quiz
		VerificationHandler.verifyEquals(quizPage.getQuizBankAssessmentName(),quizName,"Quizbank assessment name is not equal");
		log(logger, "Verifying quiz name");

		// Click on Quiz Bank Assessment Close button
		tutorialPage.clickQuizCloseButton();
		log(logger, "Clicked on Close button in Quiz Bank");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.quiz.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Card Back Title is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageContains(PropertiesRepository.getString("newati.card.back.title.loc.quiz"),
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.name.loc.pn.2.0")),
				"Unable to verify Module name");
		
		/*// Close CardBack popup
		quizPage.closeCardBack("close.popup");
		log(logger, "Clicked on Close button in Quiz Bank Card back");*/
		
		logger.info("NewATI31_VerifyQuiz: End");
	}
	
	/**
	 * Obsolete
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "607")
	//@Test(priority = 4, alwaysRun = true, groups = {"Regression" }, description = "Verify the NCLEX Prep tab")
	
	public void NewATI607_verifyListOfProductsofNCLEXTab() throws Exception {
		log(logger, "NewATI607_verifyListOfProductsofNCLEXTab Start");
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		loginPage.loginToApplication("Ascend_stage24","Test_123");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(quizPage.verifyNCLEXProductList("newati.myati.learn.tab.product.list.loc","newati.myati.learn.tab.noproducts.loc"), "The Learing Tab  product list contains one of NCLEX Product List");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(quizPage.verifyNCLEXProductList("newati.myati.test.tab.product.list.loc","newati.myati.test.tab.noproducts.loc"), "The Test Tab product list contains one of NCLEX Product List");
		
		log(logger, "Clicking on Apply Tab");
		
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc.improve"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(quizPage.verifyNCLEXProductList("newati.myati.improve.tab.product.list.loc.new","newati.myati.improve.tab.noproducts.loc"), "The ** Imporve Tab**  product list contains one of NCLEX Product List");
		
		log(logger, "Clicking on Nclex Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		VerificationHandler.verifyTrue(quizPage.verifyNCLEXProductList("newati.myati.apply.tab.product.list.loc","newati.myati.apply.tab.noproducts.loc"), "The  Apply Tab product list contains one of NCLEX Product List");
		log(logger, "NewATI607_verifyListOfProductsofNCLEXTab End");
	
		
	
	}

}
