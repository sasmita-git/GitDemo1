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
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.PeakHourTestingPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctorPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class CreateAccAddProPracticeAss extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private CreateAccountPage createAccountPage;
	private HomePage homePage;
	private TextHandler textHandler;
	private LearnTabPage learnTabPage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	public BaseHandler baseHandler;
	private ProctorPage proctorPage;
	private ProctorChromePage proctorChromePage;
	private String browserType = null;
	private WebDriver proctorDriver;
	private TutorialPage tutorialPage;
	private PeakHourTestingPage peakHourTestingPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		homePage = new HomePage(driver);
		textHandler = new TextHandler(driver);
		learnTabPage = new LearnTabPage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		baseHandler = new BaseHandler(driver);
		proctorPage = new ProctorPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		tutorialPage = new TutorialPage(driver);
		peakHourTestingPage = new PeakHourTestingPage(driver);
	}

	@TestAnnotations(testID = "PeakHrTest_1")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "NewATI-1:Verify CreateAccount page.")
	public void peakTestFlow() throws Exception {
		log(logger, "peakTestFlow Starts ");
		
		long timeAtFirstQuestionLoadAss = 0;
		long timeAtFirstQuestionLoadTut = 0;
		long timeAtFirstQuestionLoadProc = 0;
		loginPage.enterURL("newati.login.url");
		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append("test@gm.com");

		//*******************************Create User************************************
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName, sbEmail.toString()),
				PropertiesRepository.getString("new-atitesting.step2.header"),
				"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),
				PropertiesRepository.getString("new-atitesting.step3.header"),
				"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),
				PropertiesRepository.getString("new-atitesting.step4.header"),
				"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");

		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),
				PropertiesRepository.getString("new-atitesting.step5.header"),
				"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");

		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(
				createAccountPage.verifyStep5().trim()
						.contains(PropertiesRepository.getString("new-atitesting.step6.header").trim()),
				"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");

		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),
				PropertiesRepository.getString("new-atitesting.step7.header"),
				"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");

		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(), "Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");
		
		//Click on Begin Using ATI button
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']")));
		homePage.clickButton("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']");
		
		log(logger, "Verify if home Page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals(PropertiesRepository.getString("newati.Hope.Page.Title")));		
		log(logger, "createAccount method Ends");
		log(logger, "New user Created : "+ userName);
		HashMap<String, String> userCreationMap = new HashMap<String, String>();
		userCreationMap.put("New user Created : ", userName);
		
		//*******************************Add Product************************************		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.loc"));
	
		VerificationHandler.verifyTrue(homePage.verifyAddProductPopup());		
		textHandler.writeText(PropertiesRepository
				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("new-atitesting.add.product.peak.productid.prod"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		
		//Verifying if Product added
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
				
		log(logger, "Clicking on Info Icon for Specific Module");
		testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flowOne"));
		log(logger, "Verifying the added Product in Learn tab");
		VerificationHandler.verifyTrue(learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("new-atitesting.Product.id.peak.testing.prod")));
		
		//Closing the info popup
		homePage.pressEscapeKey();
		//homePage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.product.info.close.btn.loc"));
		log(logger, "CDN Added : "+ PropertiesRepository.getString("new-atitesting.Product.id.peak.testing"));
		HashMap<String, String> cdnAddedMap = new HashMap<String, String>();
		cdnAddedMap.put("CDN Added : ", PropertiesRepository.getString("new-atitesting.add.product.productid"));
	
		//*******************************Take Practice Test************************************
				
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		
		log(logger, "Select Practice Assessment Name");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", PropertiesRepository.getString("new-atitesting.testtab.flowOne.name"));
		long timeBeforeLoadingFirstQuesAss = System.currentTimeMillis();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.switchToAssessmentFrameHandler();
		if(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")).get(1).isDisplayed())
		{
			timeAtFirstQuestionLoadAss = System.currentTimeMillis();
		}
		long timeTakenToLoadFirstQuestionAss = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadAss - timeBeforeLoadingFirstQuesAss); 
		
		long assessmentStartTime = System.currentTimeMillis();		
		
		ArrayList<Double> timeListforPracticeAss = peakHourTestingPage.takeTest(false, false, false, false , "Targeted Medical-Surgical 2013: Endocrine" , 2);
		
		double averageTimeForLoadingEachQuesforPracticeAss = timeListforPracticeAss.get(0);
		double timeForLoadingIPPPageforPracticeAss = timeListforPracticeAss.get(1);
		long assessmentEndTime = System.currentTimeMillis();
		Long timeTakeToCompleteAssessment = assessmentEndTime-assessmentStartTime;
		Long timeTakeInMinutesToCompleteAssessment = TimeUnit.MILLISECONDS.toMinutes(timeTakeToCompleteAssessment);
		log(logger, "Time taken to Complete Aassessment >>>>>> " + timeTakeInMinutesToCompleteAssessment + " minutes");
		
		HashMap<String, String> practiceAssTimeMap = new HashMap<String, String>();
		
		practiceAssTimeMap.put("Time to load Practice First Question in Practice Test : " , Long.toString(timeTakenToLoadFirstQuestionAss) + " Seconds");
		practiceAssTimeMap.put("Avg time taken to load each Practice question  : ", Double.toString(averageTimeForLoadingEachQuesforPracticeAss)+ " Seconds");
		practiceAssTimeMap.put("Time taken to load the result page after completing the test : ", Double.toString(timeForLoadingIPPPageforPracticeAss)+ " Seconds");
		practiceAssTimeMap.put("Total time taken to complete Practice Assessment : ", Double.toString(timeTakeInMinutesToCompleteAssessment)+ " Minutes");		
		
		
		//*******************************Proctor Assessment************************************	
		// Getting value from Jenkins
		/*logger.info("Proctor Assessment Starts");
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
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);
		
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
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Proctored Assessment Name");
		VerificationHandler.verifyTrue(practiceAssessmentPage.clickProctorAssessment("ATI TEAS"), "Unable to click on Proctor Assessment");
		
		log(logger, "Clicking on Proctor Check Box");
		proctorPage.clickButton("#ctl00_CPHolder_chkIAgree", 0);
		Thread.sleep(10000);
		// Student Ends
		
		// Faculty Start #btnStop
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		//proctorChromePage.scrollToElement(proctorDriver, "#btnStop");
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
		//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
		VerificationHandler.verifyTrue(proctorChromePage.clickButtonWith30SecWait(proctorDriver,
				"#btnRefreshBottom"), "Unable to click Refresh Button");
		Thread.sleep(30000);
		// Faculty End
		
		// Student Start
		log(logger, "Clicking on Start/ Resume Test Button");
		proctorPage.clickButtonForProctor(PropertiesRepository
				.getString("new-atitesting.proctor.start.test.button"), 0);
		
		log(logger, "Verifying Questions");
		long timeBeforeLoadingFirstQuesProc = System.currentTimeMillis();
		VerificationHandler.verifyTrue(
				proctorPage.verifyQuestionNos(),
				"Unable to verify Question nos");
		log(logger, "Verifying Calculator");
		
		if(proctorPage.verifyQuestionNos())
		{
			timeAtFirstQuestionLoadProc = System.currentTimeMillis();
		}
		long timeTakenToLoadFirstQuestionProc = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadProc - timeBeforeLoadingFirstQuesProc);
		
		// Assessment Page.
		log(logger, "Taking Proctor Assessment TEAS Section 1");
		double avgTimeTakenForLodingAssForSec1 = proctorPage.takeTEASProctorAssessmentContinue();

		log(logger, "Taking Proctor Assessment TEAS Section 2");
		double avgTimeTakenForLodingAssForSec2 = proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 3");
		double avgTimeTakenForLodingAssForSec3 = proctorPage.takeTEASProctorAssessmentContinue();
		
		log(logger, "Taking Proctor Assessment TEAS Section 4");
		double avgTimeTakenForLodingAssForSec4 = proctorPage.takeTEASProctorAssessmentFinalize();
		
		double avgTimeTakenForLodingAssForProcAss = (avgTimeTakenForLodingAssForSec1 + avgTimeTakenForLodingAssForSec2 + avgTimeTakenForLodingAssForSec3 +avgTimeTakenForLodingAssForSec4) / 4;
		
		log(logger, "Taking Proctor Assessment TEAS Survey");
		double IPPStartTime = proctorPage.takeTEASProctorAssessmentSurvey();
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(
				proctorPage.verifyIPPPageHeader(),
				"Verifying IPP Page Header");
		
		long ippLoadEnd = System.currentTimeMillis();
		logger.info("Time Taken to load IPP Page >>>>>>>>>>>> " + (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(IPPStartTime)).longValue())  + " seconds")); 

		log(logger, "Clicking on close button in IPP Page");
		proctorPage
				.clickButtonWithSwitchToDefault(
						PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.close.button.loc"),
						0);
		proctorPage
				.waitUntillLoadingImageIsDisappeared("ATIFaculti.common.page.spinner.loc");
		
		Map<String, String> procAssTimeMap = new HashMap<String, String>();
		procAssTimeMap.put("Time taken to load first question for Proctored Test : " , Long.toString(timeTakenToLoadFirstQuestionProc) + " Seconds");
		procAssTimeMap.put("Average time taken to load each page in Proctored Test: " , Double.toString(avgTimeTakenForLodingAssForProcAss)+ " Milli Seconds");
		procAssTimeMap.put("Time Taken to load the Results page after completing test : " , (TimeUnit.MILLISECONDS.toSeconds(ippLoadEnd- (new Double(IPPStartTime)).longValue()))  + " seconds");
		
		logger.info("Proctor Assessment End");*/
		// Student End
				
		//*******************************Take Tutorial************************************		
		
		/*log(logger, "Clicking on Learn Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//homePage.waitUntillProductLoadingMsgDisappeared("new-atitesting.learntab.loading.products.loc");
		
		log(logger, "Verify if all enabled tutorials are displayed");
		VerificationHandler.verifyTrue(learnTabPage.VerifyIfEnabledTutorialsDisplayed());
				
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		log(logger, "Selecting Tutorial from Learn Tab");
		
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flowOne"));
		log(logger, "Clicking Module by Name");
		
		long timeBeforeLoadingFirstQuesTut = System.currentTimeMillis();
		tutorialPage.clickBeginTestButtonInPharmacologyCardBack(PropertiesRepository.getString("new-atitesting.learntab.tutorial.137.pharmacology.made.easy.module.name"));
		log(logger, "Clicking Begin Test ");		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.switchToAssessmentFrameHandler();
		if(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")).get(1).isDisplayed())
		{
			timeAtFirstQuestionLoadTut = System.currentTimeMillis();
		}
		long timeTakenToLoadFirstQuestionTut = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadTut - timeBeforeLoadingFirstQuesTut); 
		
		peakHourTestingPage.takeTest(false, true, false, false , null , 0);
		
		HashMap<String, String> tutorialTimeMap = new HashMap<String, String>();
		tutorialTimeMap.put("Time to load Tutorial First Question (Sec) : ", Long.toString(timeTakenToLoadFirstQuestionTut));*/
		
		//Reporting the recorded time's
		/*log(logger, "=========== TEST RESULT FOR PRACTICE ASSESSMENT =========");
		log (logger, "                                                           ");
		log(logger, "Practice Test Completed Successfully");
		for (Map.Entry<String, String> entry : practiceAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}*/
		/*log (logger, "                                                           ");
		log(logger, "=========== TEST RESULT FOR PROCTORED ASSESSMENT =========");
		log (logger, "                                                           ");
		log(logger, "Proctored Test Completed Successfully");
		for (Map.Entry<String, String> entry : procAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                           ");*/
		/*log(logger, "Tutorial Assessment Details");
		for (Map.Entry<String, String> entry : tutorialTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}*/
		
		log(logger, "peakTestFlow End");
	}
	
	@AfterMethod()
	public void finalMethod() {
		if(proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}

}
