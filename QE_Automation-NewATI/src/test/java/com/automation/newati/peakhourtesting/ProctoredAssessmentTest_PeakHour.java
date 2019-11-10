package com.automation.newati.peakhourtesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctorPage;
import com.automation.newati.pages.ProctoredAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;

public class ProctoredAssessmentTest_PeakHour extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private HomePage homePage;
	private ProctorPage proctorPage;
	private CreateAccountPage createAccountPage;
	private TutorialPage tutorialPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		createAccountPage = new CreateAccountPage(driver);
		homePage = new HomePage(driver);
		proctorPage = new ProctorPage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
		tutorialPage=new TutorialPage(driver);
		if(count == 0) {
			userId = userCreationUtils.getUserDetails();
			count++;
		}
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
	}

	/**
	 * Proctor Assessment New Implementation
	 * 
	 * @author Syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Regression",
			"Smoke" }, description = "NewATI-102:Verify student is able to take a ITEM TYPE REGRESSION proctored assessment")
	public void NewATI102_ProctoredAssessmentTest_ItemType() throws Exception {
		log(logger, "NewATI102_ProctoredAssessmentTest_ItemType Start");
		long timeAtFirstQuestionLoadProc = 0;
		long timeAtFirstQuestionLoadAss = 0;
		
		loginPage.enterURL("newati.login.url");
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append("test@gm.com");

		
		// *******************************Proctor Assessment************************************
		// Getting value from Jenkins
		logger.info("Proctor Assessment Starts");
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);

		// If not getting value from properties file
		if (StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		}

		logger.info("browserType value ==> " + browserType);
		if (browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorChromeDriver();
			logger.info("Opening Chrome Browser");
		
		}

		// Faculty Start
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,"cps.personnel","Password1");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(proctorDriver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(20000);

		log(logger, "Verifying Home Link in Left Navigation"); 
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearchUpdated(proctorDriver,
				"assessment", true),
				"Unable to verify Home ");
		
		
//		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
//				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Enterin Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.proctor.id.value.prod.itemType"),
				PropertiesRepository.getString("id.proctor.pwd.value.prod.itemType"));// Thread.sleep(10000);Thread.sleep(10000);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

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
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver,
				PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);

		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);

		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);

		// Faculty Ends

		// Student Starts

		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(userId, "Test@1234");

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Add Product Button");
		proctoredAssessmentPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.add.product"));

		log(logger, "Verifying Add Product button is clicked or not.");
		VerificationHandler.verifyTrue(
				proctoredAssessmentPage.verifyAssessmentIDPopup(
						PropertiesRepository.getString("new-atitesting.add.product.id.new.loc")),
				"Unable to click and add product id/ pwd");

		log(logger, "Entering Proctor Id"); // need to check locator
		proctoredAssessmentPage.enterTextValue(PropertiesRepository.getString("new-atitesting.add.product.id.new.loc"),
				PropertiesRepository.getString("id.proctor.id.value.prod.itemType"));

		log(logger, "Clicking on Button");
		proctoredAssessmentPage
				.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(20000);

		log(logger, "Clicking on Proctor Check Box");
		proctoredAssessmentPage
				.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		// Student Ends

		// Proctor Portal Start
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver, "#btnRefreshBottom"),
				"Unable to click Refresh Button");

		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWaitApprove(proctorDriver),
				"Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
		// proctorChromePage.scrollToElement(proctorDriver,
		// "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver, "#btnRefreshBottom"),
				"Unable to click Refresh Button");
		Thread.sleep(30000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(proctorChromePage.checkStopTestCheckBox(proctorDriver),
				"Verifying Stop Test Check box");
		// Faculty End

		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"),
				0);
		Thread.sleep(20000);
//
//		log(logger, "Verifying Questions");
//		long timeBeforeLoadingFirstQuesProc = System.currentTimeMillis();
//		VerificationHandler.verifyTrue(proctorPage.verifyQuestionNos(), "Unable to verify Question nos");
//
//
//		if(proctorPage.verifyQuestionNos())
//		{
//			timeAtFirstQuestionLoadProc = System.currentTimeMillis();
//			log(logger, "timeAtFirstQuestionLoadProc --> " +timeAtFirstQuestionLoadProc);
//		}
//		long timeTakenToLoadFirstQuestionProc = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadProc - timeBeforeLoadingFirstQuesProc);
//		
//		
		// Assessment Page.
		log(logger, "Taking Proctor Assessment ITR");
		ArrayList<Double> avgTimeTakenForLodingAssForSecList = proctorPage.takeTEASProctorAssessmentContinue_ITR_PeakHour();
			
		tutorialPage.takeTest(false, false, false, false);
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(proctorPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
//		long ippLoadEnd = System.currentTimeMillis();
//		logger.info("Time Taken to load IPP Page >>>>>>>>>>>> " + (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(avgTimeTakenForLodingAssForSecList.get(1))).longValue())  + " seconds")); 

		log(logger, "Clicking on close button in IPP Page");
		proctorPage.clickButtonWithSwitchToDefault(
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"), 0);
		proctorPage.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
		
		Map<String, String> procAssTimeMap = new HashMap<String, String>();
//		procAssTimeMap.put("Time taken to load first question for Proctored Test : " , Long.toString(timeTakenToLoadFirstQuestionProc) + " Seconds");
//		procAssTimeMap.put("Average time taken to load each page in Proctored Test: " , Double.toString(avgTimeTakenForLodingAssForSecList.get(0))+ " Milli Seconds");		
//		procAssTimeMap.put("Time Taken to load the Results page after completing test : " , (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(avgTimeTakenForLodingAssForSecList.get(1))).longValue()))  + " seconds");
//		
		logger.info("Proctor Assessment End");
		// Student End
		log(logger, "NewATI102_ProctoredAssessmentTest_ItemType End");
		
		log (logger, "                                                           ");
		log(logger, "=========== TEST RESULT FOR PROCTORED ASSESSMENT =========");
		log (logger, "                                                           ");
		log(logger, "Proctored Test Completed Successfully");
		for (Map.Entry<String, String> entry : procAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                           ");
		
	}

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			//proctorDriver.quit();
		}
	}

}
