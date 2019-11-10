package com.automation.asmt.smoke;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.CommonUtils;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class SmokeTest extends BaseTest {

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
		
	}

	/*
	 * @author syed.pasha
	 */
	@TestAnnotations(testID="ASMT-755")
    @Test(priority = 4, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-755: Validate the message on student side when the proctor approves the assessment with post survey sect [Version : 1]")
	public void ASMT755_ProctorAssesment() throws Exception {
		logger.info("ASMT755_ProctorAssesment Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
	
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.755");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.value.755");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
				
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
		Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");

		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver),"Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(10000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(30000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver),"Verifying Stop Test Check box");
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
		
		log(logger, "Verify Assessment title");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),PropertiesRepository.getString("asmt.assessment.title.755"), 0));
				
		log(logger, "Verify if Close button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.assessment.close.btn.loc", 0));
		
		log(logger, "Verify if Log is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.assessment.logo.loc", 0));
		
		/*log(logger, "Verify if calculator is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.assessment.calculator.loc", 0));*/
		
		log(logger, "Verify if Pause button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.assessment.pause.btn.loc", 0));	
		
		log(logger, "Verify if Previous button is not displayed");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.quiz.previous.btn.loc", 0)));
		
		log(logger, "Verify if Continue button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.quiz.continue.btn.loc", 0));
			
		// Assessment Page.
		log(logger, "Taking Proctor Assessment Section -- 1");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false, false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList = new ArrayList<String>();
		buttonList.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList.add(PropertiesRepository.getString("asmt.popup.btn4.loc"));
		buttonList.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Complete post asessment survey', 'Finalize aned view results' buttons are displayed and Click on 'Complete post asessment survey' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList , PropertiesRepository.getString("asmt.popup.btn4.loc")));		
		
		log(logger, "Taking Proctor Assessment Section -- Survey");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false, false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Finalize aned view results' buttons are displayed and Click on 'Finalize aned view results' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn5.loc")));		

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		log(logger, "Clicking on close button in IPP Page");
		maintenanceScriptPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"),0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//--------->>Student Ends<<------------
		
		logger.info("ASMT755_ProctorAssesment End");		
}
	
	/*
	 * @author syed.pasha
	 */
	@TestAnnotations(testID="ASMT-756")
	@Test(priority = 5, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-756: Verify the scenario on Student Side when the faculty user Resumes/Abandons/Close/Stop Test states of")
	public void ASMT756_ProctorAssesmentResumeAbandonClose() throws Exception {
		logger.info("ASMT756_ProctorAssesmentResumeAbandonClose Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.756");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.value.756");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
				
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
		maintenanceScriptID.enterElectornicSignature(proctorDriver,	PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
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
		//Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"));
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");

		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver),
				"Unable to click Approve Button");
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(10000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(3000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver),
				"Verifying Stop Test Check box");
		
		//--------->>Faculty End<<------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");		
		//--------->>Student End<<------------
				
		//--------->>Faculty Start<<------------
		Thread.sleep(10000);
		log(logger, "Clicking on Stop Button, Wait for 30 sec and then click on refresh button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitStop(proctorDriver),	"Unable to click Stop Button");
		
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");
		//--------->>Faculty End<<--------------
		
		//--------->>Student Start<<------------
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Do some action by trying to answer any question");
		quizBankAssPage.switchToAssessmentFrameHandler();
		quizBankAssPage.clickAssessmemtType();
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.RETURN);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Verify if 'Go Back to Main Page' Popup is displayed");
		VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayed("asmt.proctor.backtomain.button", 0));
		
		log(logger, "Click on 'Go back to Main page' Button");
		maintenanceScriptID.clickButton(PropertiesRepository.getString("asmt.proctor.backtomain.button"), 0);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		windowHandler.switchToMainWindow();
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));		
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));			
		
		log(logger, "Clicking on Proctor Assessment ");
		quizBankAssPage.clickTestTabProctorButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type.Proctor"), PropertiesRepository.getString("asmt.assessment.dcfpa.proctor.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		//--------->>Student End<<--------------
		
		//--------->>Faculty Start<<------------

		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");

		Thread.sleep(30000);
		
		log(logger, "Verifying 'Resume/Deny/No Action' is Displayed");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyResumeDenyNoAction(proctorDriver));
		
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		
		log(logger, "Clicking on Resume Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver),"Unable to click Resume Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(5000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");
		//Thread.sleep(30000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver),"Verifying Stop Test Check box");
		
		
		//--------->>Faculty End<<--------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(5000);		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		log(logger, "Answer One Quesstion");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, true, false, false, false));
		//--------->>Student End<<------------
		
		//--------->>Faculty Start<<------------
		
		log(logger, "Clicking on Stop Button, Wait for 30 sec and then click on refresh button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitStop(proctorDriver),	"Unable to click Stop Button");	
		
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");
		
		Thread.sleep(30000);
		
		log(logger, "Verify if 'Close' radio button is displayed");
		VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayedProctor(proctorDriver ,"asmt.proctor.stop.button.loc", 0));
		
		log(logger, "Clicking on Close Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickCloseButtonInStoppedAssessmentSection(proctorDriver),"Unable to click Close Button");
		
		/*maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");*/
		
		//--------->>Faculty End<<--------------
		
		//--------->>Student Ends<<-------------
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Do some action by trying to answer any question");
		quizBankAssPage.switchToAssessmentFrameHandler();
		quizBankAssPage.clickAssessmemtType();
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.continue.btn.loc"))).sendKeys(Keys.RETURN);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		
		log(logger, "Verify if 'Closed Assessment Confirmation' Popup is displayed");
		VerificationHandler.verifyTrue(quizBankAssPage.isElementDisplayed("asmt.proctor.close.alert.ok.btn.loc", 0));
		
		log(logger, "Click on 'Closed Assessment Confirmation' Button");
		maintenanceScriptID.clickButton(PropertiesRepository.getString("asmt.proctor.close.alert.ok.btn.loc"), 0);			
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		//--------->>Student Ends<<------------
		
		logger.info("ASMT756_ProctorAssesmentResumeAbandonClose End");		
	}
	
	
	/*
	 * @author syed.pasha
	 */
	@TestAnnotations(testID="ASMT-757")
	@Test(priority = 6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-757: Verify the Stop Assessment pop-up on performing 4 cheat events on Student Side [Version : 1]")
	public void ASMT757_ProctorAssesmentCheatEvent() throws Exception {
		logger.info("ASMT757_ProctorAssesmentCheatEvent Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetailsNonPilotuser();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.756");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.value.756");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home Link");
				
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
		//Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"));
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//Thread.sleep(10000);
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");

		Thread.sleep(30000);
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Approve Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWaitApprove(proctorDriver),
				"Unable to click Approve Button");

		log(logger, "Clicking on Refresh Button");
		Thread.sleep(10000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(3000);

		log(logger, "Verifying Stop Test Check box is dispalyed or not");
		VerificationHandler.verifyTrue(maintenanceScriptID.checkStopTestCheckBox(proctorDriver),
				"Verifying Stop Test Check box");
		//--------->>Faculty End<<------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
			
		
		log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----1st Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));
		
		log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----2nd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));
		
		log(logger, "Create cheat event, Verify the cheat event popup and click on Resume button----3rd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"), "Resume"));
		
		log(logger, "Create cheat event, Verify Stop Assessment popup and click on Stop Assessment button----4th Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.stopassessment.btn.loc"), "Stop Assessment"));
		
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.content.area.dropdown"));
		log(logger, "Verify if Content Area drop down is displayed in Learn tab");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		//--------->>Student End<<------------
		
		logger.info("ASMT757_ProctorAssesmentCheatEvent End");		
		}
		

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
	
}
