package com.automation.newati.regression.hometab;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.FlashCardPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.QuizPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class GeneralRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private TextHandler textHandler;
	private BaseHandler baseHandler;
	private LearnTabPage learnTabPage;
	private WindowHandler windowHandler;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeMethod
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		textHandler = new TextHandler(driver);
		baseHandler = new BaseHandler(driver);
		learnTabPage = new LearnTabPage(driver);
		windowHandler = new WindowHandler(driver);

	}

	/**
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-530")
	@Test(priority = 1, alwaysRun = true, enabled = true, description = "NewATI-530:To verify the Add Product for Library institution purchases")
	public void NewATI530_VerifyAddProductLibInst() throws Exception {

		log(logger, "NewATI530_VerifyAddProductLibInst Start");

		// Step 1
		userId = userCreationUtils.getUserDetails();
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 2
		log(logger, "Clicking on add product button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.loc"),
				PropertiesRepository.getString("new-atitesting.add.product.productid.530"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.add.product.password.loc"));
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.password.loc"),
				PropertiesRepository.getString("new-atitesting.add.product.productpass.530"));		
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillElementIsVisible("#assessmentFrame");
		windowHandler.switchToFrame("assessmentFrame");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 3
		log(logger, "Verifying if product is added successfully without any errror message");
	
		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.assess.name.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(element.get(2).getText().equals(PropertiesRepository.getString("new-atitesting.product.530")));
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.focused.review.close.button.new.loc"));		
				
		log(logger, "Clicking on close button ");
		homePage.click(PropertiesRepository.getString("new-atitesting.focused.review.close.button.new.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Yes button in popup");
		homePage.click(PropertiesRepository.getString("new-atitesting.endassessment.yes.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						
		// Step 4
		log(logger, "Clicking on add product button");
		windowHandler.switchToMainWindow();
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("newati.add.product.learn.tab.no.products"));
		homePage.click(PropertiesRepository.getString("newati.add.product.learn.tab.no.products"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Enter Product ID");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.loc"),
				PropertiesRepository.getString("new-atitesting.add.product.CDN.530"));
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 5
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.checkbox.learntab"));
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(
				PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name.update"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Clicking on Begin Lesson ");
		tutorialPage.clickDosageCalculationModuleName(
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying if learnTabPage can be accessed");
		VerificationHandler.verifyTrue(learnTabPage.verifyTutorialPageTutorialAndModuleName(
				PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name.update"),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.142.dosage.module.name")));

		log(logger, "NewATI530_VerifyAddProductLibInst End");
	}

}
