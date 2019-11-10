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

public class ProctoredAssessmentTest_RNNurseCareChildren2013 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private HomePage homePage;
	private ProctorPage proctorPage;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		homePage = new HomePage(driver);
		proctorPage = new ProctorPage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
	}
	
	/**
	 * Proctor Assessment New Implementation
	 * @author Syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression", "Smoke"}, description = "NewATI-60:Verify Proctor Assessment for different types of assessments")
	public void NewATI60_ProctoredAssessmentTest_RNNCOC2013() throws Exception {
		log(logger, "NewATI60_ProctoredAssessmentTest_RNNCOC2013 Start");
		// Getting value from Jenkins for environment - Start
		String environment = System.getProperty("env");
		logger.info("environment value ==> " + environment);
		
		if(StringUtils.isBlank(environment) || StringUtils.isEmpty(environment)) {
			environment = PropertiesRepository.getString("global.environment.name");
			logger.info("environment value from property file==> " + environment);
		}
		/*if (GlobalProperties.STAGE.equalsIgnoreCase(environment) || GlobalProperties.STG.equalsIgnoreCase(environment)) {
			envURL = "";
		} else if(GlobalProperties.PROD.equalsIgnoreCase(environment)){
			envURL = "";
		}*/		
		//Launch Application
		
		//loginPage.enterURL("newati.login.url");
		//Generate Random User Name
		//String userName = CommonUtils.getRandomUserName();
		String userName = userCreationUtils.getUserDetails();
		logger.info("userName --> " + userName);
		//*******************************Proctor Assessment************************************	
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
				PropertiesRepository.getString("id.login.proctor.pncp.2011.username"),
				PropertiesRepository.getString("id.login.proctor.pncp.2011.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository
				.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enterin Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value.prod.rnncoc2013"),
				PropertiesRepository.getString("id.proctor.pwd.value.prod.rnncoc2013"));//Thread.sleep(10000);Thread.sleep(10000);
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
		
		// Faculty Ends
		
		// Student Starts
		
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userName, PropertiesRepository.getString("id.login.student.password"));
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(5000); //Vaishali
		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));
		
		log(logger, "Verifying Add Product button is clicked or not.");
		VerificationHandler.verifyTrue(proctoredAssessmentPage.verifyAssessmentIDPopup(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"))
				,"Unable to click and add product id/ pwd");
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"), PropertiesRepository
				.getString("id.proctor.id.value.prod.rnncoc2013"));
		
		log(logger, "Clicking on Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
				
		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		// Student Ends
		
		// Proctor Portal Start
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWaitApprove(proctorDriver), "Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		
		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(proctorChromePage.checkStopTestCheckBox(proctorDriver), "Verifying Stop Test Check box");
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(),"Unable to verify Question nos");
		Thread.sleep(5000); //Vaishali
		// Assessment Page.
		log(logger, "Taking Proctor Assessment");
		boolean resultFlag = proctorPage.takeTEASProctorAssessmentContinue_RNNCOC2013();
		logger.info("Proctor Result --> " + resultFlag);

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(proctorPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		log(logger, "Clicking on close button in IPP Page");
		proctorPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		proctorPage.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
				
		logger.info("Proctor Assessment End");
		// Student End		
		log(logger, "NewATI60_ProctoredAssessmentTest_RNNCOC2013 End");		
	}	

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			//proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
}
