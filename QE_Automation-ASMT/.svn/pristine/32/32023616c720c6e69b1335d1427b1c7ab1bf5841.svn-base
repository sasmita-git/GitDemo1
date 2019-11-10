package com.automation.asmt.maintenance;

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
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class MaintenanceScriptProctored extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver proctorDriver;
	private String browserType = null;
	private UserCreationUtils userCreationUtils;
	private String userName;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		userCreationUtils = new UserCreationUtils();
	}
	
	@TestAnnotations(testID="ASMT-361")
	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-362,ASMT-361:Verify Proctored Assessment Functionality.")
	public void verifyProctoredAssessment() throws Exception {
		
		
		// Getting value from Jenkins
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);
		
		// If not getting value from properties file
		if(StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		} 
		
		if(browserType.equalsIgnoreCase("ie")) {
			browserType = "internet explorer";
		}
		
		logger.info("browserType value ==> " + browserType);
		if(browserType.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
			proctorDriver = openProctorChromeDriver();
		} else if(browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorFirefoxDriver();
		}
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Details  --> " + userName);
		
		/*
		// Faculty Start
		log(logger, "Login to application");
		maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		log(logger, "Clicking on Left Navigation Link");
		maintenanceScriptID.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID
				.verifyLeftNavigationTextSearch(proctorDriver, "assessment",
						true), "Unable to verify Home ");
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		//maintenanceScriptID.waitUntillLoadingImageIsAppeared(PropertiesRepository.getString("id.proctor.id.value"));
		log(logger, "Enterin Proctor id, pwd and click submit button");
		maintenanceScriptID.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Electornic Signature");
		maintenanceScriptID
				.enterElectornicSignature(
						proctorDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		maintenanceScriptID
				.enterElectornicSignature(
						proctorDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						maintenanceScriptID.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		maintenanceScriptID.clickProctorWelcomePageProceedButton(proctorDriver);
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		// Faculty end

		// Student Start
		log(logger,
				"Student Portal Login Start");
		maintenanceScriptPage.loginToApplication(
				userName,
				"Test123");
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//Thread.sleep(10000);
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(
				".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Entering Proctor Id"); // need to check locator
		maintenanceScriptPage
				.enterValue(
						".focus-element-flag.focus-on",
						PropertiesRepository
								.getString("id.proctor.id.value"));
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage
				.clickButton(
						".focus-element-flag.step-modal-nav-right.move-to-next-content-active",
						0);
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);
		//Thread.sleep(10000);
		// Student End

		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton("#ctl00_CPHolder_chkIAgree", 0);
		Thread.sleep(10000);
		// Proctor Portal End

		// Faculty Portal Start
		log(logger, "Clicking on Refersh Button");
		maintenanceScriptPage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		Thread.sleep(30000);
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver,
				"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		
		maintenanceScriptPage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		Thread.sleep(30000);
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID
				.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		maintenanceScriptPage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver,
				"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		// Faculty Portal End

		// click on Resume Test Button.
		maintenanceScriptPage.clickButton(PropertiesRepository
				.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(10000);
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyQuestionNos(),
				"Unable to verify Question nos");
		log(logger, "Verifying Calculator");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyCalculator(),
				"Unable to verify calculator");
		// Assessment Page.
		maintenanceScriptPage.takeITRProctorAssessment();

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(
				maintenanceScriptPage.verifyIPPPageHeader(),
				"Verifying IPP Page Header");

		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage
				.clickButtonWithSwitchToDefault(
						PropertiesRepository
								.getString("asmt.question.assement.question.close.button"),
						0);
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		proctorDriver.close();
		proctorDriver.quit();*/
		
		// Faculty Start
		log(logger, "Login to application");
		maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		log(logger, "Clicking on Left Navigation Link");
		maintenanceScriptID.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enterin Proctor id, pwd and click submit button");
		maintenanceScriptID.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Electornic Signature");
		maintenanceScriptID.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		maintenanceScriptID.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						maintenanceScriptID.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		maintenanceScriptID.clickProctorWelcomePageProceedButton(proctorDriver);
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		maintenanceScriptID.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		maintenanceScriptID.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		maintenanceScriptID.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		
		// Faculty Ends
		
		// Student Starts
		log(logger,
				"Student Portal Login Start");
		maintenanceScriptPage.loginToApplication(
				userName,
				"Test123");
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//Thread.sleep(10000);
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(
				".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Entering Proctor Id"); // need to check locator
		maintenanceScriptPage
				.enterValue(
						".focus-element-flag.focus-on",
						PropertiesRepository
								.getString("id.proctor.id.value"));
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage
				.clickButton(
						".focus-element-flag.step-modal-nav-right.move-to-next-content-active",
						0);
		maintenanceScriptPage
				.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);
		// Student Ends
		
		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton("#ctl00_CPHolder_chkIAgree", 0);
		maintenanceScriptPage
		.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(10000);
		// Proctor Portal End
		
		// Proctor Portal Start
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		
		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver), "Verifying Stop Test Check box");
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
			
		// Assessment Page.
		maintenanceScriptPage.takeITRProctorAssessment();

		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
		logger.info("Proctor Assessment End");
	}
	
	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
}
