package com.automation.asmt.newPoroctorMonitor;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.NPMStapper2Page;
import com.automation.asmt.page.NPMStapper3Page;
import com.automation.asmt.page.NPMStapper4Page;
import com.automation.asmt.page.NPMStapper5Page;
import com.automation.asmt.page.NPMStepper22Page;
import com.automation.asmt.page.NewProctorMonitorPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class Myprogram extends BaseTest{
	
	
	Logger logger = LogManager.getLogger(this.getClass());
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;	
	private LoginPage loginPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private UserCreationUtils userCreationUtils;
	private String userName;
	
	private NPMStepper22Page npmstapper22Page;
	private NPMStapper3Page npmstapper3Page;
	private NPMStapper4Page npmstapper4Page;
	private NPMStapper5Page npmstapper5Page;
	private NewProctorMonitorPage npmmonitoringpage;
		
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		loginPage = new LoginPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);		
		loginPage = new LoginPage(driver);		
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);	
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
		npmstapper22Page = new NPMStepper22Page(driver);
		npmstapper3Page = new NPMStapper3Page (driver);
		npmstapper4Page = new NPMStapper4Page (driver);
		npmstapper5Page = new NPMStapper5Page (driver);
		npmmonitoringpage = new NewProctorMonitorPage(driver);
		
	}

	
	/*
	 * @author trupti.hiremath
	 */
	@TestAnnotations(testID="ASMT-New Proctor")
    @Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "Validate ITR assessment with new proctor monitoring")
	public void ProctorAssesment() throws Exception {
		logger.info("ProctorAssesment Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
	
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.in.step2");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.in.step2");
		
		//--------->>Faculty Start<<------------
		log(logger, "Login to Faculty application");
		VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("npm.proctor.username"),
				PropertiesRepository.getString("npm.proctor.password")));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Page");
		
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));
	
		log(logger, "Clicking on Left Navigation Link");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
				
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clicksearch(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enter batch id");
		VerificationHandler.verifyTrue(npmstapper22Page.enteringBatchId(proctorDriver, "10608973"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clickAssessment2(proctorDriver, PropertiesRepository.getString("step2.checkbox.for.assessment"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clickcontinue(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Complete Step-3");
		VerificationHandler.verifyTrue(npmstapper3Page.clickAllCheckbox(proctorDriver, true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Enter electronic signature");
		VerificationHandler.verifyTrue(npmstapper3Page.enteringElectronicsignature(proctorDriver, "tt"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Enter i agree");
		VerificationHandler.verifyTrue(npmstapper3Page.clickIAgree(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Complete Step-4");
		VerificationHandler.verifyTrue(npmstapper4Page.clickcontinuestep4(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		log(logger, "Complete Step-5");
		VerificationHandler.verifyTrue(npmstapper5Page.startProctor(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		//Thread.sleep(600);
		
		
		
		//--------->>Faculty Ends<<------------
		Thread.sleep(5000);
		//--------->>Student Start<<------------
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test@1234"));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on Add Product Button");
		maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger,"Verify if Add product popup is displayed");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Button");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(20000);
			
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(30000);
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		
		
		log(logger, "Click on approve");
		VerificationHandler.verifyTrue(npmmonitoringpage.clickOnApprove(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		
		//--------->>Faculty End<<------------
		
		
		//--------->>Student Start<<------------		
		log(logger, "Verifying Start bbutton is dispalyed or not");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quizBankAssPage.baseHandler.findElement(PropertiesRepository.getString("new-atitesting.proctor.start.test.button")));
		VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayed("new-atitesting.proctor.start.test.button", 0));
		
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		
		// Assessment Page.
				log(logger, "Taking ITR Proctor Assessment");
				VerificationHandler.verifyTrue(maintenanceScriptPage.takeTest(false, false, false, false));

				/*log(logger, "Taking Survery");
				boolean boolSurvey = proctorRNCompPredPage.takeTEASProctorAssessmentSurvey();*/
				
				log(logger, "Verifying IPP Page Header");
				VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
						
				log(logger, "Clicking on close button in IPP Page");
				maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
				maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				//--------->>Student Ends<<------------
				
						logger.info("ASMT-New Proctor End");	
						
}
	
	
	
	/////////////  ASMT-1120
	
	

	/*
	 * @author trupti.hiremath
	 */
	@TestAnnotations(testID="ASMT-1120")
    @Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = " Verify step1 to step5 proctor process for faculty users")
	public void ProctorAssesmentStep1ToStep5() throws Exception {
		logger.info("ProctorAssesment Step1 To Step5 Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
	
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.in.step2");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.in.step2");
		
		//--------->>Faculty Start<<------------
		log(logger, "Login to Faculty application");
		VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("npm.proctor.username"),
				PropertiesRepository.getString("npm.proctor.password")));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verifying Home Page");
		
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));
	
		log(logger, "Clicking on Left Navigation Link");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
		Thread.sleep(20000);
		
		//// VERIFICATION OF ALL ELEMENTS OF STEPPER2
		
		log(logger, "Verify Assessment Name column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.Assessment.name.column", 0));
		
		/// Arrow button beside the assessment column should be added to asmt-npm-locators.properties file
		
		log(logger, "click Assessment Arrow button");
		VerificationHandler.verifyTrue(npmstapper22Page.clickAssessmentArrowbutton(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
    	log(logger, "Verify Cohort/Group column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.cohort.group.column", 0));
		
		log(logger, "Verify Institution column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.institution.column", 0));
		
		log(logger, "Verify Search button dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.search.button", 0));
		
		log(logger, "Verify load more button dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.load.more.button", 0));
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clicksearch(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Enter batch id");
		VerificationHandler.verifyTrue(npmstapper22Page.enteringBatchId(proctorDriver, "dosage cal"));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clickAssessment2(proctorDriver, PropertiesRepository.getString("step2.checkbox.for.assessment"), true));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clicksearchclosebutton(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verify Number of assessments selected");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.number.of.assessment.selected", 0));
		
		log(logger, "Search the assessment Select and Click on continue in Step-2");
		VerificationHandler.verifyTrue(npmstapper22Page.clickcontinue(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Verify electronic signature field");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step3.electronicsignature", 0));
		
		log(logger, "Verify I agree field");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step3.I.agree.button", 0));
		
		log(logger, "Verify current date field");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step3.current.date", 0));
		
		////// STEP 4 ALL ELEMENTS DISPLAYED OR NOT
		
		log(logger, "Verify Student Name column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.Assessment.name.column", 0));
		
		/// Arrow button beside the assessment column should be added to asmt-npm-locators.properties file
		
		log(logger, "click Student Arrow button");
		VerificationHandler.verifyTrue(npmstapper22Page.clickAssessmentArrowbutton(proctorDriver));
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
    	log(logger, "Verify Cohort/Group column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.cohort.group.column", 0));
		
		log(logger, "Verify Institution column dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.institution.column", 0));
		
		log(logger, "Verify Search button dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver, "step2.search.button", 0));
		
		
		logger.info("ASMT-1120_ProctorAssesment End");	
						
}
	
	
/////////////  ASMT-1122
	
/*
* @author trupti.hiremath
*/
@TestAnnotations(testID="ASMT-1122")
@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = " Verify Abandon and close from batch grid")
public void CheatEventAndCloseFromBatchGrid() throws Exception {
         logger.info("Abandon Or Close From Need Attention Or Batch Grid Start");
          proctorDriver = openProctorChromeDriver();

          userName = userCreationUtils.getUserDetailsNonPilotuser();

         logger.info("Student User Created  --> " + userName);
         String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.in.step2");
         String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.in.step2");

//--------->>Faculty Start<<------------
log(logger, "Login to Faculty application");
VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
		PropertiesRepository.getString("npm.proctor.username"),
		PropertiesRepository.getString("npm.proctor.password")));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Verifying Home Page");

VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));

log(logger, "Clicking on Left Navigation Link");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
log(logger, "Verifying Home Link in Left Navigation");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
Thread.sleep(20000);

log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clicksearch(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Enter batch id");
VerificationHandler.verifyTrue(npmstapper22Page.enteringBatchId(proctorDriver, "10608973"));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clickAssessment2(proctorDriver, PropertiesRepository.getString("step2.checkbox.for.assessment"), true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clickcontinue(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-3");
VerificationHandler.verifyTrue(npmstapper3Page.clickAllCheckbox(proctorDriver, true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Enter electronic signature");
VerificationHandler.verifyTrue(npmstapper3Page.enteringElectronicsignature(proctorDriver, "tt"));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Enter i agree");
VerificationHandler.verifyTrue(npmstapper3Page.clickIAgree(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-4");
VerificationHandler.verifyTrue(npmstapper4Page.clickcontinuestep4(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-5");
VerificationHandler.verifyTrue(npmstapper5Page.startProctor(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

//Thread.sleep(600);



//--------->>Faculty Ends<<------------
Thread.sleep(5000);
//--------->>Student Start<<------------
log(logger,"Student Portal Login Start");
VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test@1234"));
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger, "Verifying Home Page");
VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));

log(logger, "Clicking on Add Product Button");
maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger,"Verify if Add product popup is displayed");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));

log(logger, "Entering Proctor Id"); // need to check locator
maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger, "Clicking on Button");
maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
Thread.sleep(20000);
	
log(logger, "Clicking on Proctor Check Box");
maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
Thread.sleep(30000);
//--------->>Student Ends<<------------

//--------->>Faculty Start<<------------


log(logger, "Complete Step-5");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnApprove(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


//--------->>Faculty End<<------------


//--------->>Student Start<<------------		
log(logger, "Verifying Start bbutton is dispalyed or not");
quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quizBankAssPage.baseHandler.findElement(PropertiesRepository.getString("new-atitesting.proctor.start.test.button")));
VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayed("new-atitesting.proctor.start.test.button", 0));

log(logger, "Clicking on Start/ Resume Test Button");
maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
Thread.sleep(30000);

log(logger, "Verifying Questions");
VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");

//-----Covering TC-686--Start-----------

log(logger, "Answer one question");
quizBankAssPage.takeTest(false, true, false, false, false);

//-----Covering TC-686--Ends-----------

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----1st Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----2nd Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----3rd Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify Stop Assessment popup and click on Stop Assessment button----4th Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.stopassessment.btn.loc"), "Stop Assessment"));
//--------->>Student End<<--------------


//--------->>Faculty Start<<------------


log(logger, "click On close button From Batch Grid");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnCloseFromBatchGrid(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "click On close confirm button From Batch Grid");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnCloseConfirmFromBatchGrid(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		
		//--------->>Faculty End<<------------


	
logger.info("ASMT-1122_ProctorAssesment_Abandon_From_Batch_Grid_End");	

}	


@TestAnnotations(testID="ASMT-1122")
@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = " Verify Abandon and close from batch grid")
public void CheatEventAndAbandonFromBatchGrid() throws Exception {
         logger.info("Abandon Or Close From Need Attention Or Batch Grid Start");
          proctorDriver = openProctorChromeDriver();

          userName = userCreationUtils.getUserDetailsNonPilotuser();

         logger.info("Student User Created  --> " + userName);
         String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.in.step2");
         String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.in.step2");

//--------->>Faculty Start<<------------
log(logger, "Login to Faculty application");
VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
		PropertiesRepository.getString("npm.proctor.username"),
		PropertiesRepository.getString("npm.proctor.password")));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Verifying Home Page");

VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));

log(logger, "Clicking on Left Navigation Link");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
log(logger, "Verifying Home Link in Left Navigation");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
Thread.sleep(20000);

log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clicksearch(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Enter batch id");
VerificationHandler.verifyTrue(npmstapper22Page.enteringBatchId(proctorDriver, "10608973"));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clickAssessment2(proctorDriver, PropertiesRepository.getString("step2.checkbox.for.assessment"), true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "Search the assessment Select and Click on continue in Step-2");
VerificationHandler.verifyTrue(npmstapper22Page.clickcontinue(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-3");
VerificationHandler.verifyTrue(npmstapper3Page.clickAllCheckbox(proctorDriver, true));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Enter electronic signature");
VerificationHandler.verifyTrue(npmstapper3Page.enteringElectronicsignature(proctorDriver, "tt"));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Enter i agree");
VerificationHandler.verifyTrue(npmstapper3Page.clickIAgree(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-4");
VerificationHandler.verifyTrue(npmstapper4Page.clickcontinuestep4(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


log(logger, "Complete Step-5");
VerificationHandler.verifyTrue(npmstapper5Page.startProctor(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

//Thread.sleep(600);



//--------->>Faculty Ends<<------------
Thread.sleep(5000);
//--------->>Student Start<<------------
log(logger,"Student Portal Login Start");
VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test@1234"));
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger, "Verifying Home Page");
VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));

log(logger, "Clicking on Add Product Button");
maintenanceScriptPage.clickButton(".add-product-btn.focus-element-flag", 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger,"Verify if Add product popup is displayed");
VerificationHandler.verifyTrue(maintenanceScriptID.verifyElementIsDisplayed(PropertiesRepository.getString("asmt.add.product.input.loc")));

log(logger, "Entering Proctor Id"); // need to check locator
maintenanceScriptPage.enterValue(PropertiesRepository.getString("asmt.add.product.input.loc"), procAssessmentId);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

log(logger, "Clicking on Button");
maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.add.product.continue.btn.loc"), 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
Thread.sleep(20000);
	
log(logger, "Clicking on Proctor Check Box");
maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
Thread.sleep(30000);
//--------->>Student Ends<<------------

//--------->>Faculty Start<<------------


log(logger, "Complete Step-5");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnApprove(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));


//--------->>Faculty End<<------------


//--------->>Student Start<<------------		
log(logger, "Verifying Start bbutton is dispalyed or not");
quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", quizBankAssPage.baseHandler.findElement(PropertiesRepository.getString("new-atitesting.proctor.start.test.button")));
VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayed("new-atitesting.proctor.start.test.button", 0));

log(logger, "Clicking on Start/ Resume Test Button");
maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
Thread.sleep(30000);

log(logger, "Verifying Questions");
VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");

//-----Covering TC-686--Start-----------

log(logger, "Answer one question");
quizBankAssPage.takeTest(false, true, false, false, false);

//-----Covering TC-686--Ends-----------

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----1st Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----2nd Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----3rd Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));

log(logger, "Create cheat event, Verify Stop Assessment popup and click on Stop Assessment button----4th Time ");
VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.stopassessment.btn.loc"), "Stop Assessment"));
//--------->>Student End<<--------------


//--------->>Faculty Start<<------------


log(logger, "click On Abandon From Batch Grid");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnAbandonFromBatchGrid(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

log(logger, "click On Abandon confirm From Batch Grid");
VerificationHandler.verifyTrue(npmmonitoringpage.clickOnAbandonConfirmFromBatchGrid(proctorDriver));
maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		
		//--------->>Faculty End<<------------


	
logger.info("ASMT-1122_ProctorAssesment_Abandon_From_Batch_Grid_End");	

}	

////////////   ASMT-1125

/*
 * @author trupti.hiremath
 */
@TestAnnotations(testID="ASMT-1125")
@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = " Verify proctor new assessment and stop all assessments from global menu")
public void ProctorNewAssessmentAndStopAllAssessments() throws Exception {
	logger.info("Proctor New Assessment And Stop All Assessments Start");
	proctorDriver = openProctorChromeDriver();
	
	userName = userCreationUtils.getUserDetailsNonPilotuser();

	logger.info("Student User Created  --> " + userName);
	String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.in.step2");
	String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.in.step2");
	
	//--------->>Faculty Start<<------------
	log(logger, "Login to Faculty application");
	VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(proctorDriver,
			PropertiesRepository.getString("npm.proctor.username"),
			PropertiesRepository.getString("npm.proctor.password")));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Verifying Home Page");
	
	VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(proctorDriver,"id.home.page.left.navigator.icon.link", 0));

	log(logger, "Clicking on Left Navigation Link");
	VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
			
	log(logger, "Verifying Home Link in Left Navigation");
	VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
	Thread.sleep(20000);
	
	log(logger, "Search the assessment Select and Click on continue in Step-2");
	VerificationHandler.verifyTrue(npmstapper22Page.clicksearch(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Enter batch id");
	VerificationHandler.verifyTrue(npmstapper22Page.enteringBatchId(proctorDriver, "10608973"));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Search the assessment Select and Click on continue in Step-2");
	VerificationHandler.verifyTrue(npmstapper22Page.clickAssessment2(proctorDriver, PropertiesRepository.getString("step2.checkbox.for.assessment"), true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Search the assessment Select and Click on continue in Step-2");
	VerificationHandler.verifyTrue(npmstapper22Page.clickcontinue(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Complete Step-3");
	VerificationHandler.verifyTrue(npmstapper3Page.clickAllCheckbox(proctorDriver, true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Enter electronic signature");
	VerificationHandler.verifyTrue(npmstapper3Page.enteringElectronicsignature(proctorDriver, "tt"));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Enter i agree");
	VerificationHandler.verifyTrue(npmstapper3Page.clickIAgree(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Complete Step-4");
	VerificationHandler.verifyTrue(npmstapper4Page.clickcontinuestep4(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Complete Step-5");
	VerificationHandler.verifyTrue(npmstapper5Page.startProctor(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(5000);
	
	log(logger, "Click on global menu");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickOnglobalmenu(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(500);
	log(logger, "Click on proctor new assessment");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickOnProctorNewAssessment(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

	Thread.sleep(6000);
	log(logger, "Click on search button present in modal pop up for assessment proctor new assessment");
	VerificationHandler.verifyTrue(npmmonitoringpage.searchassessmentinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	
	log(logger, "Click on search here button  present in modal pop up for assessment proctor new assessment");
	VerificationHandler.verifyTrue(npmmonitoringpage.searchhereassessmentinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Click on search here button  present in modal pop up for assessment proctor new assessment and search batchid");
	VerificationHandler.verifyTrue(npmmonitoringpage.enteringBatchIdinmodalpopup(proctorDriver, "10558467"));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "select searched assessment in modal pop up window");
	VerificationHandler.verifyTrue(npmmonitoringpage.selectassessmentinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "click on continue in modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickcontinueinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(500);
	log(logger, "click on all check box in modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickAllCheckboxinmodalpopup(proctorDriver, true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(20000);

	log(logger, "enter electronic signature in modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.enteringElectronicsignatureinmodalpopup(proctorDriver, "tt"));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "click on i agree in modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickIAgreeinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(1000);
	log(logger, "click on start proctoring in modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickIAgreeinmodalpopup(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "click on gear symbol");
	VerificationHandler.verifyTrue(npmmonitoringpage.gearbutton(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "click on add students from gear symbol list");
	VerificationHandler.verifyTrue(npmmonitoringpage.addstudentsFromBatchGrid(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "select all students from modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.clickonallcheckboxforstudentfrommodalpopup(proctorDriver, true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "click on add students modal pop up");
	VerificationHandler.verifyTrue(npmmonitoringpage.addstudentsbutton(proctorDriver));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(1000);
	
	logger.info("ASMT-1125_Proctor_New_Assessment_And_Stop_All_Assessments_End");	

	}	

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
	
	
	
	
}
