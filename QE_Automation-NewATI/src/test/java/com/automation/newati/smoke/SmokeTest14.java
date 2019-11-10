
package com.automation.newati.smoke;

import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest14 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private TextHandler textHandler;
	private LearnTabPage learnTabPage;
	private ButtonHandler buttonHandler;
	private ApplyTabPage applyTabPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		textHandler = new TextHandler(driver);
		learnTabPage = new LearnTabPage(driver);
		buttonHandler = new ButtonHandler(driver);
		applyTabPage = new ApplyTabPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.calculation"), PropertiesRepository.getString("newati.login.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

@TestAnnotations(testID="NewATI-142")
@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Validate user is able to take up Dosage calculation tutorial Test::Learn Tab")
public void NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest() throws Exception {
	log(logger, "NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest Start");
	
	// Step 2 Start
	log(logger, "Clicking on My ATI Tab");
	//homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	homePage.clickTab(1);

	// Click on Learn Tab
	log(logger, "Clicking on Learn Tab");
	homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	// Sort Tutorial
	tutorialPage.selectTutorialFromDropDown(PropertiesRepository
			.getString("new-atitesting.tutorialDropdown.value"));
	log(logger, "Selecting Tutorial from Learn Tab");
	// Step 2 End

	// Step 3 Start
	tutorialPage
			.clickModuleButtonByName(PropertiesRepository
					.getString("new-atitesting.learntab.tutorial.142.dosage.name"));
	log(logger, "Clicking Module by Name");
	
	// Step 5 Start
	tutorialPage
			.clickDosageCalculationModuleNameTest(PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
	log(logger, "Clicking Begin Test ");
	
	log(logger, "verifying new ati logo");
	boolean flag = tutorialPage.checkLogo(PropertiesRepository.getString("new-atitesting.loginpage.newati.image.loc"));
	VerificationHandler.verifyTrue(flag, "Logo is not displayed");
	
	log(logger, "verifying close button");
	boolean closeButtonStatus = tutorialPage.verifyCloseButton();
	VerificationHandler.verifyTrue(closeButtonStatus, "close button is not displayed");
	
	log(logger, "verifying Question label text");
	boolean questionLabelText=tutorialPage.verifyQuestionLabelText();
	VerificationHandler.verifyTrue(questionLabelText, "question label text is not displayed");
	//done changes
	log(logger, "verifying calculator and time elapsed text ");
	boolean isEleDisplayed=tutorialPage.verifyAssessmentFrameObjectsWithoutCalc();
	VerificationHandler.verifyTrue(isEleDisplayed, "calculator  is not displayed");
	
	log(logger, "taking assessment for tutorial");
	tutorialPage.takeTestForDosage(false, false, true, false);
	Thread.sleep(5000);
	log(logger, "verifying IPP page");
	boolean result=myReportPage.verifyIPPpageObjects();
	VerificationHandler.verifyTrue(result, "PIP page is not displayed");
	
	log(logger, "verifying close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	
	log(logger, "click on cardback close button");
	tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.cardback.close.button.loc"));
	
	boolean result1 =tutorialPage.verifySubTabs();
	VerificationHandler.verifyTrue(result1, "home page sub tabs are not displayed");
	log(logger, "NewATI142_ValidateUserIsAbletoTakeupDosageCalculationTutorialTest End");
	
}


}
