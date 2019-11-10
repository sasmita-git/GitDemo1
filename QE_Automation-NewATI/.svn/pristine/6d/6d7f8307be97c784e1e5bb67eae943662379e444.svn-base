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

public class SmokeTest16 extends BaseTest {

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
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

@TestAnnotations(testID="NewATI-601")
@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "To verify products can be added individually::My ATI")
public void NewATI601_VerifyProductsAddedIndividually() throws Exception {
	log(logger, "NewATI601_VerifyProductsAddedIndividually Start");
	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Clicking on Add Product button");
	homePage.click(PropertiesRepository
			.getString("new-atitesting.add.product.loc"));

	textHandler.writeText(PropertiesRepository
			.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
			.getString("new-atitesting.add.product.productid"));
	log(logger, "Clicking on Continue button");
	homePage.click(PropertiesRepository
			.getString("new-atitesting.add.product.continue.button.loc"));

	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	textHandler.writeText(PropertiesRepository
			.getString("new-atitesting.add.product.password.loc"), PropertiesRepository
			.getString("new-atitesting.add.product.productpassword"));
	log(logger, "Clicking on Continue button");
	homePage.click(PropertiesRepository
			.getString("new-atitesting.add.product.continue.button.loc"));

	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Clicking on My ATI Tab");
	homePage.clickTab(1);

	homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	log(logger, "Clicking on Info Icon for Specific Module");
	learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.product.name"));
	log(logger, "Verifying the added Product");
	learnTabPage.verifyAddedProduct(PropertiesRepository.getString("new-atitesting.add.product.productid"));
	log(logger, "NewATI601_VerifyProductsAddedIndividually End");
}
@TestAnnotations(testID="NewATI-510")
@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "To verify skills module 2.0 for existing NewATI user::Learn Tab")
public void NewATI510_VerifySkillsModules() throws Exception {
	log(logger,"NewATI510_VerifySkillsModules Start");

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
	log(logger, "Selecting Tutorial from Learn Tab");
	// Step 2 End

	//step3 start
	log(logger, "Verifying Skills Module 2.0");
	VerificationHandler
	.verifyTrue(tutorialPage.verifyCardFrontBasedOnModuleName("Skills Modules 2.0"), "Unable to verify Skills Modules 2.0");
	
	log(logger, "Verifying Skills Module");
	VerificationHandler
	.verifyTrue(tutorialPage.verifyCardFrontBasedOnModuleName("Skills Modules"), "Unable to verify Skills Modules 2.0");
	
	log(logger,"NewATI510_VerifySkillsModules End");
	//step3 end
}

}
