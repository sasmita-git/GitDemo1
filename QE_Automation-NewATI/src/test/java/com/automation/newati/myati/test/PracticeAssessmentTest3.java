package com.automation.newati.myati.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctorPage;
import com.automation.newati.pages.ProctorTestPage;
import com.automation.newati.pages.ProctoredAssessmentPage;
import com.jaca.TestAnnotations;

public class PracticeAssessmentTest3 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private WebDriver chromeDriver;
	private ProctorTestPage proctorTestPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private HomePage homePage;
	private ProctorPage proctorPage;
	private CreateAccountPage createAccountPage;
	
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorTestPage = new ProctorTestPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		homePage = new HomePage(driver);
		proctorPage = new ProctorPage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}	

	@TestAnnotations(testID="NewATI-42")
	@Test(priority = 1, alwaysRun = true, enabled = true,groups = {"Regression"}, description = "NewATI-42:Practice Assessment >Disabling and Enabling assessment and checking assessment accessibility")
	public void  NewATI42_VerifyAccessibilityWithEnableDisable() throws Exception {
		log(logger, "NewATI42_VerifyAccessibilityWithEnableDisable Start");
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);
		
		// If not getting value from properties file
		if(StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		} 
		
		logger.info("browserType value ==> " + browserType);
		if(browserType.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
			proctorDriver = openProctorChromeDriver();
			logger.info("Opening Chrome Browser");
		} else if(browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorFirefoxDriver();
			logger.info("Opening Firefox Browser");
		}
		
		//Step 1&2 --- starts here
		log(logger, "Login to student portal application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.practice.assessment.uname3"), PropertiesRepository.getString("newati.login.payment.selfpay.tutorial.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step 3 --- starts here
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying whether practice assessment button is enabled");
		VerificationHandler.verifyTrue(homePage.verifyAssessmentCardEnabledInTestTab(PropertiesRepository.getString("newati.login.practice.assessment.name.42"), "BEGIN", true));

		//Step 4 --- starts here
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Dismiss the alert");
		proctorChromePage.closeAlert(proctorDriver); //commenting as not required in prod
	
		log(logger, "Select and enter cohort");
		proctorChromePage.selectAndEnterCohortWithToggleOnOff(proctorDriver,PropertiesRepository.getString("newati.login.practice.cohort.name.42"));
		log(logger, "Clicking on Left Navigation Link");		
		proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);
		log(logger, "Clicking on Products page");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "apps",true), "Unable to verify Home ");
		
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Disable assessment as faculty");
		proctorChromePage.enableDisablePracticeAssessmentsAndSave(proctorDriver, PropertiesRepository.getString("newati.login.practice.assessment.name.42"));
		
		log(logger, "Refresh the student page");
		driver.navigate().refresh();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click Hide checkbox");
		homePage.clickHideDisabledProducts();
		log(logger, "Verifying whether practice assessment button is disabled");
		VerificationHandler.verifyTrue(homePage.verifyAssessmentCardEnabledInTestTab(PropertiesRepository.getString("newati.login.practice.assessment.name.42"), "BEGIN", false));

		log(logger, "Enable/Disable assessment as faculty");
		proctorChromePage.enableDisablePracticeAssessmentsAndSaveWithoutSwitch(proctorDriver, PropertiesRepository.getString("newati.login.practice.assessment.name.42"));
		log(logger, "Refresh the student page");
		driver.navigate().refresh();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying whether practice assessment button is enabled");
		VerificationHandler.verifyTrue(homePage.verifyAssessmentCardEnabledInTestTab(PropertiesRepository.getString("newati.login.practice.assessment.name.42"), "BEGIN", true));
		//Step 5 --- starts here
		
		logger.info("NewATI42_VerifyAccessibilityWithEnableDisable Ends");
	}
}
