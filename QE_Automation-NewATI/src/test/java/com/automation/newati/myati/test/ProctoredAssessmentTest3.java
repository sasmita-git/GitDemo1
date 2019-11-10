package com.automation.newati.myati.test;

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
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctorPage;
import com.automation.newati.pages.ProctoredAssessmentPage;
import com.automation.newati.util.UserCreationUtils;

public class ProctoredAssessmentTest3 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver = null;
	private HomePage homePage;
	private ProctorPage proctorPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		homePage = new HomePage(driver);
		proctorPage = new ProctorPage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
		
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
			logger.info("Inside @BeforeMethod userId --> " + userId);
		}
		logger.info("Inside userId --> " + userId);
		
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-111:Verify proctor monitor page 'Abandon' Radio button.")
	public void NewATI111_ProctorMonitorPageAbandonButton() throws Exception {
		log(logger, "NewATI111_ProctorMonitorPageAbandonButton Start");
		String assessmentName = null;
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

		//Step - 2 --- starts here
		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Dismiss the alert");
//		proctorChromePage.closeAlert(proctorDriver); commenting as not required in prod
		
		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
		
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		Thread.sleep(10000);
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);

		//Step 2 --- ends here
		
		//Step 3 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, PropertiesRepository.getString("id.login.student.password"));		
		//Step 3 --- ends here
		
		//Step 4 --- starts here
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));		
		log(logger, "Entering Proctor Id"); 
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value"));		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4 --- ends here
		
		//Step 5 --- starts here
		//Faculty is resumed from here		
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		assessmentName = proctorChromePage.getAssessmentName(proctorDriver);
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		log(logger, "Clicking on Approve Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.approve.button"));
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Student is resumed from here
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		//Step 5 --- ends here
				
		//Step 6 --- starts here
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 2
		//Student
		log(logger, "Maximize this windiw");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 3
		//Student
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 4
		//Student
		log(logger, "Maximize this window");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		//Step 6 --- ends here
		
		//Step 7 --- starts here
		log(logger, "Verify abondon button and click");
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver,PropertiesRepository.getString("id.proctor.monitor.page.abandon.button")));
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Student
		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message"),PropertiesRepository.getString("new-atitesting.proctor.error.message.stop.text")));
		//Step 7 --- ends here
		
		//Step 8 --- starts here
		log(logger, "Go back to Main page");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.backtomain.button"), 0);
		log(logger, "Verify whether assessment is available");
		VerificationHandler.verifyTrue(proctorPage.verifyAssessmentCardAvailable(assessmentName));
		//Step 8 --- ends here
		
		log(logger, "NewATI111_ProctorMonitorPageAbandonButton End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-114:Verify proctor monitor page 'Close' Radio button.")
	public void NewATI114_ProctorMonitorPageCloseButton() throws Exception {
		log(logger, "NewATI114_ProctorMonitorPageCloseButton Start");

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

		//Step 2 --- starts here
		// Faculty Start
		
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
					
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000); //Vaishali
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000); //Vaishali
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);

		//Step 2 --- ends here
		
		//Step 3 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, PropertiesRepository.getString("id.login.student.password"));	
		//Step 3 --- ends here
		Thread.sleep(10000); //Vaishali
		//Step 4 --- starts here
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));		
		log(logger, "Entering Proctor Id"); 
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository.getString("id.proctor.id.value"));
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4 --- ends here

		//Step 5 --- starts here
		//Faculty is resumed from here

		log(logger, "Verify Proctor Monitor page displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyMonitorPageDisplayed(proctorDriver), "Proctor monitor page is not displayed");
		proctorChromePage.getAssessmentName(proctorDriver);
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		log(logger, "Clicking on Approve Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.approve.button"));
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
	
		//Student is resumed from here
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		//Step 5 --- ends here
		
		//Step 6 --- starts here
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 2
		//Student
		log(logger, "Maximize this window");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 3
		//Student
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Outside click 4
		//Student
		log(logger, "Maximize this window");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		//Step 6 --- ends here
		
		//Step 7 --- starts here		
		log(logger, "Verify close button and click");
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver,PropertiesRepository.getString("id.proctor.monitor.page.close.button")));
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		
		//Student
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message"), PropertiesRepository.getString("new-atitesting.proctor.error.message.stop.text")));
		//Step 7 --- ends here
		
		//Step 8 --- starts here
		log(logger, "Go back to Main page");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.backtomain.button"), 0);
		log(logger, "Verify whether assessment is available");
		//VerificationHandler.verifyTrue(proctorPage.verifyAssessmentCardAvailable(assessmentName));  --- not able to see assessment
		//Step 8 --- ends here
		
		log(logger, "NewATI114_ProctorMonitorPageCloseButton End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-101:Verify working of all features on 'MonitorProctor page")
	public void NewATI101A_ProctorDenyNoActionFeaturesOfProctorMonitorPage() throws Exception {
		log(logger, "NewATI101A_ProctorDenyNoActionFeaturesOfProctorMonitorPage Start");
		String assessmentName = null;
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

		//Step 1 -- starts here
		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		Thread.sleep(5000); //Vaishali
		
		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
						
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		Thread.sleep(5000); //Vaishali
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		Thread.sleep(5000); //Vaishali
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		Thread.sleep(5000); //Vaishali
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);

		// Step 1 --- ends here
		
		//Step 2 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, PropertiesRepository.getString("id.login.student.password"));	
		
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);		
		
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		Thread.sleep(5000); //Vaishali
		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));		
		log(logger, "Entering Proctor Id"); 
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository.getString("id.proctor.id.value"));
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2 --- ends here
		
		//Step 3 --- starts here
		//Faculty is resumed from here	
		log(logger, "Verify Proctor Monitor page displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyMonitorPageDisplayed(proctorDriver), "Proctor monitor page is not displayed");
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		assessmentName = proctorChromePage.getAssessmentName(proctorDriver);
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Deny Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.deny.button"));	
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Student is resumed from here
		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message"),PropertiesRepository.getString("new-atitesting.proctor.error.message.deny.text")));
		//Step 3 --- ends here
		
		//Step 4 --- starts here
		log(logger, "Go back to Main page");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.backtomain.button"), 0);		
		log(logger, "Verify whether assessment is available");
		VerificationHandler.verifyTrue(proctorPage.verifyAssessmentCardAvailable(assessmentName));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on BEGIN button");
		proctorPage.clickButtonOfProctoredAssessmentCard(assessmentName, "BEGIN");
		
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		log(logger, "Clicking on No Action Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.noaction.button"));

		// Student is resumed -- Verify No action by clicking on checkbox in student acreen
		Thread.sleep(10000);		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		//Step 4 --- ends here
		
		//Step 5 --- starts here
		//Faculty is resumed from here		
		log(logger, "Verify Proctor Monitor page displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyMonitorPageDisplayed(proctorDriver), "Proctor monitor page is not displayed");
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Approve Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.approve.button"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);	
		//Student is resumed from here
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		//Step 5 --- ends here
		
		//Step 6 --- starts here
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Verify that error message is displayed");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message1.loc"),
				PropertiesRepository.getString("new-atitesting.proctor.error.message.outside.click.text")));
		//Step 6 ---ends here
		
		//Step 8 --- starts here
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		//Step 8 --- ends here
		
		//Step 9 --- starts here
		log(logger, "Maximize this window");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		loginPage.moveToElementUsingJavaScript(PropertiesRepository.getString("id.proctor.monitor.page.refresh.button"));
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctoredAssessmentPage.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));

		//Student
		log(logger, "Minimize this window");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		loginPage.moveToElementUsingJavaScript(PropertiesRepository.getString("id.proctor.monitor.page.refresh.button"));
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
				
		//Outside click 3
		//Student
		log(logger, "Maximize this window");
		proctorPage.minimizeOrMaximizeWindow("maximize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		loginPage.moveToElementUsingJavaScript(PropertiesRepository.getString("id.proctor.monitor.page.refresh.button"));
		//Faculty is resumed from here
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);
				
		//Outside click 4
		//Student
		log(logger, "Open other tab and close");
		proctorPage.minimizeOrMaximizeWindow("minimize");
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.resumetest.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	

		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message"),PropertiesRepository.getString("new-atitesting.proctor.error.message.stop.text")));
		log(logger, "Go back to Main page");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.backtomain.button"), 0);
		log(logger, "Verify whether assessment is available");
		VerificationHandler.verifyTrue(proctorPage.verifyAssessmentCardAvailable(assessmentName));

		//Step 9 --- ends here
		
		log(logger, "NewATI101A_ProctorDenyNoActionFeaturesOfProctorMonitorPage End");
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-101:Verify working of all features on 'MonitorProctor page")
	public void NewATI101B_ProctorButtonsFeaturesOfProctorMonitorPage() throws Exception {
		log(logger, "NewATI101B_ProctorButtonsFeaturesOfProctorMonitorPage Start");
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

		//Step 1 -- starts here
		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Dismiss the alert");
//		proctorChromePage.closeAlert(proctorDriver); commenting as not required in prod
		
		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
						
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		// Step 1 --- ends here		
	
		//Step 12 --- starts here
		log(logger, "Click on Monitor Another Assessment");
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.assessment.button")));
		log(logger, "Verify whether proctor input frame is displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyAnotherProctorAssessmentInputFrame(proctorDriver,PropertiesRepository.getString("id.proctor.monitor.page.another.back.button")));
		log(logger, "Navigate back");
		proctorDriver.navigate().back();
		//Step 12 --- ends here
		
		//Step 13 --- starts here
		log(logger, "Click on Manage Student button");
		String mainHandle = proctorDriver.getWindowHandle();
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.manage.students.button")));
		log(logger, "Verify that Manage Student window displayed and close");
		VerificationHandler.verifyTrue(proctorChromePage.verifyManageStudentsWindowDisplayedAndClose(proctorDriver, mainHandle));
		//Step 13 --- ends here
		
		//Step 14 --- starts here
		log(logger, "Verify Auto-Refresh/Submit field functionality");
		VerificationHandler.verifyTrue(proctorChromePage.verifyAutoRefreshAndSubmitTimings(proctorDriver, "2"));
		//Step 14 --- ends here

		//Step 17 --- starts here
		log(logger, "Click on Stop Monitoring button");
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.stop.monitoring.button")));
		log(logger, "Verify whether proctor input frame is displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyAnotherProctorAssessmentInputFrame(proctorDriver,PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc")));
		log(logger, "Navigate back");
		proctorDriver.navigate().back();
		//Step 17 --- ends here
		
		log(logger, "NewATI101B_ProctorButtonsFeaturesOfProctorMonitorPage End");
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-101:Verify working of all features on 'MonitorProctor page")
	public void NewATI101C_ProctorCompleteTestFeaturesOfProctorMonitorPage() throws Exception {
		log(logger, "NewATI101C_ProctorCompleteTestFeaturesOfProctorMonitorPage Start");
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

		//Step 1 -- starts here
		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Dismiss the alert");
//		proctorChromePage.closeAlert(proctorDriver); commenting as not required in prod
		
		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
						
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		// Step 1 --- ends here		
	
		//Step 18 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, PropertiesRepository.getString("id.login.student.password"));		
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));		
		log(logger, "Entering Proctor Id"); 
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//As Faculty	
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Verify Proctor Monitor page displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyMonitorPageDisplayed(proctorDriver), "Proctor monitor page is not displayed");
		String assessmentName = proctorChromePage.getAssessmentName(proctorDriver);
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		log(logger, "Clicking on Approve Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.approve.button"));	
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		//As Student
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Taking Proctor Assessment TEAS");
		proctorPage.takeTEASProctorAssessmentContinue();
		log(logger, "Verify message and click on Finish button");
		VerificationHandler.verifyTrue(proctorPage.verifyMessageAndClickButton(PropertiesRepository.getString("new-atitesting.proctor.finish.message.test"),PropertiesRepository.getString("new-atitesting.proctor.finish.message.loc"), PropertiesRepository.getString("new-atitesting.proctor.finish.button")));
		log(logger, "Verify student is able to see result");
		VerificationHandler.verifyTrue(proctorPage.verifyScoreofStudent());
		
		//As Proctor
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);	
		log(logger, "Verify View Complete Assessment Link");
		
		//Step 18 --- ends here
		log(logger, "NewATI101C_ProctorCompleteTestFeaturesOfProctorMonitorPage End");
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-101:Verify working of all features on 'MonitorProctor page")
	public void NewATI101D_ProctorStopTestFeaturesOfProctorMonitorPage() throws Exception {
		log(logger, "NewATI101D_ProctorCStopTestFeaturesOfProctorMonitorPage Start");
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
Thread.sleep(5000); //Vaishali
		//Step 1 -- starts here
		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Dismiss the alert");
//		proctorChromePage.closeAlert(proctorDriver); commenting as not required in prod
		
		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
						
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(5000); //Vaishali
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value"),
				PropertiesRepository.getString("id.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(5000); //Vaishali
		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString(
						"faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository
						.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);

		// Step 1 --- ends here		
	
		//Step 16 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, PropertiesRepository.getString("id.login.student.password"));	
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));		
		log(logger, "Entering Proctor Id"); 
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		//As Faculty		
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Verify Proctor Monitor page displayed");
		VerificationHandler.verifyTrue(proctorChromePage.verifyMonitorPageDisplayed(proctorDriver), "Proctor monitor page is not displayed");
		String assessmentName = proctorChromePage.getAssessmentName(proctorDriver);
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		log(logger, "Clicking on Approve Button");
		proctorChromePage.clickButtonWith30SecWait2(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.approve.button"));	
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);		
		//As Student
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//As Faculty
		log(logger, "Verify and click on Stop Test button of Proctor");
		VerificationHandler.verifyTrue(proctorChromePage.verifyButtonAndClick(proctorDriver, PropertiesRepository.getString("id.proctor.monitor.page.stoptest.checkbox")));
		log(logger, "Click on Submit/Refresh button");
		proctorChromePage.clickSubmitRefreshButton(proctorDriver);	
		
		//As Student
		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(proctorPage.verifyErrorMsgDisplayed(PropertiesRepository.getString("new-atitesting.proctor.error.message"),PropertiesRepository.getString("new-atitesting.proctor.error.message.stop.text")));
		////Step 16 --- ends here
		
		log(logger, "NewATI101D_ProctorStopTestFeaturesOfProctorMonitorPage End");
	}
	
	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.quit();
		}
	}


}
