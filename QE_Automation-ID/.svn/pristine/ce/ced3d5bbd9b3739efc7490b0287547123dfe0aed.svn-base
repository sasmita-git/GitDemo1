package com.automation.id.proctor;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProctorChromePage;
import com.automation.id.pages.ProctorPage;
import com.automation.id.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class ProctorAssessmentTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private ProctorPage proctorPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private LoginPage loginPage;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	
	@BeforeMethod(alwaysRun = true) 
	public void verifyHomePage() throws Exception {
		proctorPage = new ProctorPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		loginPage = new LoginPage(driver);
		userId = userCreationUtils.getUserDetails();
	}

	@TestAnnotations(testID="INST-2036")
	@Test(priority = 1, alwaysRun = true, enabled = true, description = "Verify that student is able to take 'TEAS V' proctored assessment")
	public void INST2036_verifyProctoredAssessment() throws Exception {

		log(logger, "Proctor Flow Starts ");
		
		// Getting value from Jenkins
		logger.info("Proctor Assessment Starts");
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
		
		// Faculty Start
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.faculty.username.prod"),
				PropertiesRepository.getString("id.login.faculty.password.prod"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage
				.verifyLeftNavigationTextSearch(proctorDriver, "assessment",
						true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enterin Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value.prod"),
				PropertiesRepository.getString("id.proctor.pwd.value.prod"));//Thread.sleep(10000);Thread.sleep(10000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Electornic Signature");
		proctorChromePage
				.enterElectornicSignature(
						proctorDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage
				.enterElectornicSignature(
						proctorDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
								proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		// Faculty Ends
		
		// Student Starts
		log(logger,
				"Student Portal Login Start");
		loginPage.loginToStudentApplication(
				userId,
				"Test123");
		proctorPage
				.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product Button");
		proctorPage.clickButton(
				".add-product-btn.focus-element-flag", 0);
		proctorPage
				.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Entering Proctor Id"); // need to check locator
		proctorPage
				.enterValue(
						".focus-element-flag.focus-on",
						PropertiesRepository
								.getString("id.proctor.id.value"));
		proctorPage
				.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Button");
		proctorPage
				.clickButton(
						".focus-element-flag.step-modal-nav-right.move-to-next-content-active",
						0);
		proctorPage
				.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
				
		log(logger, "Clicking on Proctor Check Box");
		proctorPage.clickButton("#ctl00_CPHolder_chkIAgree", 0);
		Thread.sleep(10000);
		// Student Ends
		
		// Faculty Start #btnStop
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,
				"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(proctorChromePage
				.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,
				"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository
				.getString("new-atitesting.proctor.start.test.button"), 0);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(
				proctorPage.verifyQuestionNos(),
				"Unable to verify Question nos");
		log(logger, "Verifying Calculator");
		
		// Assessment Page.
		log(logger, "Taking Proctor Assessment TEAS Section 1");
		proctorPage.takeTEASProctorAssessmentContinue();

		log(logger, "Taking Proctor Assessment TEAS Section 2");
		proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 3");
		proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 4");
		proctorPage.takeTEASProctorAssessmentFinalize();
		
		log(logger, "Taking Proctor Assessment TEAS Survey");
		proctorPage.takeTEASProctorAssessmentSurvey();
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(
				proctorPage.verifyIPPPageHeader(),
				"Verifying IPP Page Header");
		
		log(logger, "Clicking on close button in IPP Page");
		proctorPage
				.clickButtonWithSwitchToDefault(
						PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.close.button.loc"),
						0);
		proctorPage
				.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
		
		logger.info("Proctor Assessment End");
		// Student End
				
		log(logger, "Proctor Flow End");
	
	}
	@AfterMethod()
	public void finalMethod() {
		if(proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
}
