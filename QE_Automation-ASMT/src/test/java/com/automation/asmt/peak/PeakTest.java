package com.automation.asmt.peak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.CreateAccountPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.PeakPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.CommonUtils;
import com.automation.asmt.utils.UserCreationUtils;


public class PeakTest extends BaseTest{
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private  PeakPage peakPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private CreateAccountPage createAccountPage;
	
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private UserCreationUtils userCreationUtils;
	private String userName;
	private CommonUtils commonUtils;
	
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		peakPage = new PeakPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		createAccountPage = new CreateAccountPage(driver);
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		commonUtils = new CommonUtils();
	}

	/**
	 * Peak Testing -includes user creation , taking practice assessment and taking proctored assessment
	 * 
	 * @author Syed.pasha
	 * @throws Exception
	 */
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Regression","Smoke" }, description = "Peak Testing -includes user creation , taking practice assessment and taking proctored assessment")
	public void ASMT_CompletePrakHour() throws Exception {
		
		log(logger, "ASMT_CompletePrakHour Start");
		
		String CDN = PropertiesRepository.getString("asmt.peak.cdn");
		long timeAtFirstQuestionLoadProc = 0;
		long timeAtFirstQuestionLoadAss = 0;
		
		//*******************************Create User From API************************************
		
		userName = userCreationUtils.getUserDetails();
		log(logger, "Student User Created --> " +userName);		
					
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
		log(logger, "Verify if home Page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals(PropertiesRepository.getString("newati.Hope.Page.Title")));		
				
		//*******************************Create User From UI************************************
		
		/*loginPage.enterURL("new-atitesting.project.url"); 		
		
 		String userName = CommonUtils.getRandomUserName();
		StringBuilder sbEmail = new StringBuilder(userName);
		sbEmail.append("test@gm.com");
		
		log(logger, "TestCase: Step 1 Start");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep1(userName, sbEmail.toString()),PropertiesRepository.getString("asmt.step2.header"),"Unable to complete Step 1 in Create Account");
		log(logger, "TestCase: Step 1 Ends");

		log(logger, "TestCase:  Step 2 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep2(),PropertiesRepository.getString("asmt.step3.header"),"Unable to complete Step 2 in Create Account");
		log(logger, "TestCase: Step 2 Ends");

		log(logger, "TestCase: Step 3 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep3(),PropertiesRepository.getString("asmt.step4.header"),"Unable to complete Step 3 in Create Account");
		log(logger, "TestCase: Step 3 Ends");

		log(logger, "TestCase: Step 4 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep4(),PropertiesRepository.getString("asmt.step5.header"),"Unable to complete Step 4 in Create Account");
		log(logger, "TestCase: Step 4 Ends");

		log(logger, "TestCase: Step 5 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep5().trim().contains(PropertiesRepository.getString("asmt.step6.header").trim()),"Unable to complete Step 5 in Create Account");
		log(logger, "TestCase: Step 5 Ends");

		log(logger, "TestCase: Step 6 Starts");
		VerificationHandler.verifyEquals(createAccountPage.verifyStep6(),PropertiesRepository.getString("asmt.step7.header"),"Unable to complete Step 6 in Create Account");
		log(logger, "TestCase: Step 6 Ends");

		log(logger, "TestCase: Step 7 Starts");
		VerificationHandler.verifyTrue(createAccountPage.verifyStep7(), "Unable to complete Step 7 in Create Account");
		log(logger, "TestCase: Step 7 Ends");
		
		VerificationHandler.verifyTrue(createAccountPage.clickOnStudentGettingStarted(),"Student Getting Started video welcome dialogue box is not displayed");
		log(logger, "Welcome video dispalyed");
		
		//Click on Begin Using ATI button
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']")));
		homePage.clickButton("#getStartedMainMenu a[class='button primary-button skip-orientation-link focus-element-flag']");
		
		//Handling maintenance popup
		peakPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		loginPage.MaintanacePopUp();
		
		log(logger, "Verify if home Page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals(PropertiesRepository.getString("newati.Hope.Page.Title")));		
		log(logger, "createAccount method Ends");
		log(logger, "New user Created : "+ userName);
		HashMap<String, String> userCreationMap = new HashMap<String, String>();
		userCreationMap.put("New user Created : ", userName); */
		
		//*******************************Add Product************************************	
				
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		peakPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.add.product.input.loc"));
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Product Id"); // need to check locator
		//maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), CDN);
		peakPage.enterProductID(PropertiesRepository.getString("asmt.add.product.input.loc"), CDN);
		peakPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on My ATI Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		peakPage.waitUntillBufferInvisible(PropertiesRepository.getString("asmt.product.still.loading.loc"));
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));		
		
		log(logger, "Clicking on Info Icon for Specific Module");
		peakPage.clickInfoIconByName(PropertiesRepository.getString("asmt.assessment.peak.peactice.assessment.name")); //Need to enter the Name of practice/proctor
		log(logger, "Verifying the added Product in Learn tab");
		VerificationHandler.verifyTrue(peakPage.verifyIfProductAdded(PropertiesRepository.getString("asmt.Product.id.peak.testing.prod")));
		
		//Closing the info popup
		peakPage.pressEscapeKey();
			
		//*******************************Take Practice Test************************************
		
				
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.assessment.peak.peactice.assessment.name"));
		
		//Getting time before opening Practice Assessment 
		long timeBeforeLoadingFirstQuesAss = System.currentTimeMillis();
		
		//peakPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions and Taking Assessment");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		String maxQuestionNumPractice = quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

		
		//Getting time after loading first question 
		timeAtFirstQuestionLoadAss = System.currentTimeMillis();
		
		long timeTakenToLoadFirstQuestionAss = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadAss - timeBeforeLoadingFirstQuesAss); 
		
		long assessmentStartTime = System.currentTimeMillis();
		
		ArrayList<Double> timeListforPracticeAss = peakPage.takeTestPeak(false, false, true, false);
		
		double averageTimeForLoadingEachQuesforPracticeAss = timeListforPracticeAss.get(0);
		double timeForLoadingIPPPageforPracticeAss = timeListforPracticeAss.get(1);
		long assessmentEndTime = System.currentTimeMillis();
		Long timeTakeToCompleteAssessment = assessmentEndTime-assessmentStartTime;
		Long timeTakeInMinutesToCompleteAssessment = TimeUnit.MILLISECONDS.toSeconds(timeTakeToCompleteAssessment);
		//log(logger, "Time taken to Complete Aassessment >>>>>> " + timeTakeInMinutesToCompleteAssessment + " seconds");
		
		LinkedHashMap<String, String> practiceAssTimeMap = new LinkedHashMap<String, String>();
		
		practiceAssTimeMap.put("Time to load First Question in Practice Test : " , Long.toString(timeTakenToLoadFirstQuestionAss) + " Seconds");
		practiceAssTimeMap.put("Avg time taken to load each question  : ", Double.toString(averageTimeForLoadingEachQuesforPracticeAss)+ " Seconds");
		practiceAssTimeMap.put("Time taken to load IPP page after completing the test : ", Double.toString(timeForLoadingIPPPageforPracticeAss)+ " Seconds");
		practiceAssTimeMap.put("Total time taken to complete Practice Assessment test of " +maxQuestionNumPractice  +" Questions : ", Double.toString(timeTakeInMinutesToCompleteAssessment)+ " Seconds");	
	
		log (logger, "                                                           ");
		log(logger, "=========== TEST RESULT FOR PRACTICE ASSESSMENT =========");
		log (logger, "                                                           ");
		log(logger, "Practice Test Completed Successfully");
		for (Map.Entry<String, String> entry : practiceAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                           ");
		
		log(logger, "Close IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
						
		//*******************************Proctor Assessment************************************	
		
		proctorDriver = openProctorChromeDriver();
		
		String procAssessmentId = PropertiesRepository.getString("asmt.peak.product.id");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.peak.product.password");
		
		//--------->>Faculty Start<<------------
		log(logger, "Login to Faculty application");
		VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.ITROP.proctor.username"),
				PropertiesRepository.getString("id.login.ITROP.proctor.password")));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));
	
		log(logger, "Clicking on Left Navigation Link");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true));
				
		log(logger, "Enterin Proctor id, pwd and click submit button And Verify if Proctor Monitor Page is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.enteringProctIdAndPwd(proctorDriver,procAssessmentId,procAssessmentPwd));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc.new"));
		
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
		//--------->>Faculty Ends<<------------
		
		//--------->>Student Start<<------------
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));	
		
		log(logger, "Clicking on Proctor Assessment ");
		quizBankAssPage.clickTestTabProctorButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type.Proctor"), PropertiesRepository.getString("asmt.assessment.peak.proctor.assessment.name"));
		peakPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		
		
		Thread.sleep(5000);
		
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		//In Prod its too fast and wait is not working
		Thread.sleep(20000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")));

		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver));
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(10000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		
		Thread.sleep(3000);
		
		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver));
		//--------->>Faculty End<<------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);

		long timeBeforeLoadingFirstQuesProc = System.currentTimeMillis();
		
		log(logger, "Verifying Questions and Taking Assessment");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		String maxQuestionNumProctor = quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();
		
		timeAtFirstQuestionLoadProc = System.currentTimeMillis();
		//log(logger, "timeAtFirstQuestionLoadProc --> " +timeAtFirstQuestionLoadProc);
		
		long timeTakenToLoadFirstQuestionProc = TimeUnit.MILLISECONDS.toSeconds(timeAtFirstQuestionLoadProc - timeBeforeLoadingFirstQuesProc);
		
		long procAssessmentStartTime = System.currentTimeMillis();
		
		ArrayList<Double> timeListforProctorAss = peakPage.takeTestProctorPeak(false, false, false, false);
		
		long proctorAssessmentEndTime = System.currentTimeMillis();
		double averageTimeForLoadingEachQuesforProctorAss = timeListforProctorAss.get(0);
		double timeForLoadingIPPPageforProctorAss = timeListforProctorAss.get(1);
		
		Long timeTakeToCompleteProctorAssessment = proctorAssessmentEndTime-procAssessmentStartTime;
		Long timeTakeInMinutesToCompleteProctorAssessment = TimeUnit.MILLISECONDS.toSeconds(timeTakeToCompleteProctorAssessment);
		//log(logger, "Time taken to Complete Aassessment >>>>>> " + timeTakeInMinutesToCompleteProctorAssessment + " seconds");
		
		LinkedHashMap<String, String> proctorAssTimeMap = new LinkedHashMap<String, String>();
		
		proctorAssTimeMap.put("Time to load First Question in Proctor Test : " , Long.toString(timeTakenToLoadFirstQuestionProc) + " Seconds");
		proctorAssTimeMap.put("Avg time taken to load each question  : ", Double.toString(averageTimeForLoadingEachQuesforProctorAss)+ " Seconds");
		proctorAssTimeMap.put("Time taken to load IPP page after completing the test : ", Double.toString(timeForLoadingIPPPageforProctorAss)+ " Seconds");
		proctorAssTimeMap.put("Total time taken to complete Proctor Assessment test " +maxQuestionNumProctor +" Questions : ", Double.toString(timeTakeInMinutesToCompleteProctorAssessment)+ " Seconds");	
	
		log (logger, "                                                           ");
		log(logger, "=========== TEST RESULT FOR PRACTICE ASSESSMENT =========");
		log(logger, "Practice Test Completed Successfully");
		for (Map.Entry<String, String> entry : practiceAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                           ");
		
		log(logger, "=========== TEST RESULT FOR PROCTOR ASSESSMENT =========");
		log (logger, "                                                           ");
		log(logger, "Proctor Test Completed Successfully");
		for (Map.Entry<String, String> entry : proctorAssTimeMap.entrySet()) {
			log(logger, entry.getKey() + entry.getValue());
		}
		log (logger, "                                                           ");
		
		log(logger, "ASMT_CompletePrakHour Ends");
			
	}
	
	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	}

