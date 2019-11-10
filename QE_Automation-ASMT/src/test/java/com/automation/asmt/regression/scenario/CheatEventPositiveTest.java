package com.automation.asmt.regression.scenario;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentCommonPage;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class CheatEventPositiveTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private AssessmentCommonPage assessmentCommonPage;
	
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private UserCreationUtils userCreationUtils;
	private String userName;
	
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		assessmentCommonPage = new AssessmentCommonPage(driver);
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}

	/**
	 * Covering : ASMT_765_642_651
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_360_583_767")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_765_642_651-- Cheat Event Positive Scenario")
	public void ASMT_765_642_651_CheatEventPositiveScena() throws Exception {
		
		log(logger, "ASMT_765_642_651_CheatEventPositiveScena Start");
		proctorDriver = openProctorChromeDriver();	
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.multiplechoice");
		String procAssessmentPwd = PropertiesRepository.getString("smt.product.pass.value.multiplechoice");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication("User111518832","Test123"));
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
		Thread.sleep(30000);

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
		
		log(logger, "Navigate to Calculator icon using keyboard tab button and open calculator and verify if its opening");
		VerificationHandler.verifyTrue(assessmentCommonPage.navTocalcAndVerify() , "Unable to open and Verify Calculator" );
		
		log(logger, "Close Calculator using tab button");
		assessmentCommonPage.hitTabKeyboardButton(1);
		assessmentCommonPage.hitSpacebKeyboardButton();
		
		log(logger, "Verifying If Calculator is Closed");
		VerificationHandler.verifyTrue(!(maintenanceScriptPage.isElementDisplayed("asmt.calculator.section.loc", 0)));
		
		log(logger, "Navigate to Continue button using keyboard tab buttons");
		assessmentCommonPage.hitTabKeyboardButton(3);		
		
		log(logger, "Verifying If Continue button is focuesd");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed("asmt.continue.button.focused.loc", 0));
		
		log(logger, "Navigate to Close button using keyboard tab buttons");
		assessmentCommonPage.hitTabKeyboardButton(1);
		
		log(logger, "Verifying If Close button is focuesd");
		VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed("asmt.close.button.focused.loc", 0));
		
		log(logger, "Verifying If Cheat event is not triggered");
		VerificationHandler.verifyTrue(!(maintenanceScriptPage.isElementDisplayed("asmt.proctor.cheatevent.resume.btn.loc", 0)));
		
		// Using Mouse/Default Selenium actions
		log(logger, "Answer one question");
		quizBankAssPage.takeTest(false, true, false, false, false);
		
		log(logger, "Verifying If Cheat event is not triggered");
		VerificationHandler.verifyTrue(!(maintenanceScriptPage.isElementDisplayed("asmt.proctor.cheatevent.resume.btn.loc", 0)));
		
		// Using Keyboard actions
		log(logger, "Answer one question using keyboard buttons");
		assessmentCommonPage.answerRadioQuesByKeyboardBtns();
		
		log(logger, "Verifying If Cheat event is not triggered");
		VerificationHandler.verifyTrue(!(maintenanceScriptPage.isElementDisplayed("asmt.proctor.cheatevent.resume.btn.loc", 0)));
				
		//--------->>Student Ends<<------------		
		log(logger, "ASMT_765_642_651_CheatEventPositiveScena Ends");		
	}	
	
	/*
	 * @author syed.pasha
	 */
	@TestAnnotations(testID="ASMT_650_652_686")
	@Test(priority = 6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT_650_652_686: Cheat Event")
	public void ASMT_650_652_686_ProctorAssesmentCheatEvent() throws Exception {
		logger.info("ASMT_650_652_686_ProctorAssesmentCheatEvent Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.multiplechoice");
		String procAssessmentPwd = PropertiesRepository.getString("smt.product.pass.value.multiplechoice");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
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
		//-----Covering TC-652--Start-----------
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(20000);
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),"Unable to click Refresh Button");
		
		log(logger, "Verify if only 4 cheat events are are logged in Proctor Monitor page");
		VerificationHandler.verifyTrue(proctorDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.proctor.ignore.radio.button.input.loc"))).size()==4);
		
		//-----Covering TC-652--Ends------------		
		//--------->>Faculty End<<--------------
		
		//--------->>Student Start<<------------
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.content.area.dropdown"));
		log(logger, "Verify if Content Area drop down is displayed in Learn tab");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Clicking on Proctor Assessment ");
		quizBankAssPage.clickTestTabProctorButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type.Proctor"), PropertiesRepository.getString("asmt.assessment.mc10.proctor"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(3000);
			
		log(logger, "Clicking on Proctor Check Box");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		Thread.sleep(15000);
		
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
		//--------->>Faculty End<<------------
		
		//--------->>Student Start<<------------
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		log(logger, "Create cheat event, Verify Stop Assessment popup and click on Stop Assessment button");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandClickResume(PropertiesRepository.getString("asmt.proctor.cheatevent.stopassessment.btn.loc"), "Stop Assessment"));
				
		logger.info("ASMT_650_652_686_ProctorAssesmentCheatEvent End");		
		}
	
	/*
	 * @author syed.pasha
	 */
	@TestAnnotations(testID="ASMT_672_754_733")
	@Test(priority = 6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT_672_754_733: All Cheat Event")
	public void ASMT_672_754_733_ProctorAssesAllCheatEvent() throws Exception {
		logger.info("ASMT_672_754_733_ProctorAssesAllCheatEvent Start");
		proctorDriver = openProctorChromeDriver();
		
		Keys f12 = Keys.F12;
		Keys f5 = Keys.F5;
		Keys f11 = Keys.F11;
		Keys escape = Keys.ESCAPE;
		Keys blank = null;
		
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.multiplechoice");
		String procAssessmentPwd = PropertiesRepository.getString("smt.product.pass.value.multiplechoice");
		
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
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(userName,"Test123"));
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
		//--------->>Student Ends<<------------

		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		log(logger, "Clicking on Refersh Button");
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");

		Thread.sleep(32000);
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
				
		log(logger, "Create cheat event-ctrl+c, Verify the cheat event popup and popup message and click on Resume button----1st Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"),"ctrl" , "c", blank , "1"));

		log(logger, "Create cheat event-ctrl+p, Verify the cheat event popup and popup message and click on Resume button----2nd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "ctrl" , "p" , blank , "1"));

		log(logger, "Create cheat event-ctrl+s, Verify the cheat event popup and popup message and click on Resume button----3rd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "ctrl" , "s" , blank , "1"));
		
		log(logger, "Create cheat event-ctrl+v, Verify the cheat event popup and popup message and click on Stop button----4th Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.stopAss.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "ctrl" , "v" ,blank , "1"));
		
		
		//--------->>Student Ends<<------------
		
		//Abandon the Assessment and start again to check more cheat events
		//--------->>Faculty Starts<<------------
		Thread.sleep(5000);		
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(3000);

		log(logger, "Clicking on Abandon radio Button and refresh");
		maintenanceScriptID.clickAbandonButnInStoppedAssetSec(proctorDriver);
				
		//--------->>Faculty Ends<<------------
		
		//--------->>Student Starts<<------------
		
		windowHandler.switchToLatestWindow();
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Proctor Assessment ");
		quizBankAssPage.clickTestTabProctorButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type.Proctor"), PropertiesRepository.getString("asmt.assessment.mc10.proctor"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						
		log(logger, "Clicking on Proctor Check Box");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"));
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//--------->>Student Ends<<------------
		
		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		Thread.sleep(20000);
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
		
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
				
		log(logger, "Create cheat event-F12, Verify the cheat event popup and popup message and click on Resume button----1st Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"),"function" , "" ,f12 , "1"));

		log(logger, "Create cheat event-F5, Verify the cheat event popup and popup message and click on Resume button----2nd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "function", "" , f5 ,"1"));

		log(logger, "Create cheat event-F11, Verify the cheat event popup and popup message and click on Resume button----3rd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "function", "" , f11, "1"));
		
		log(logger, "Create cheat event-ctrl+n, Verify the cheat event popup's and popup message's and click on Stop button----4th Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.stopAss.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "ctrl" , "n", blank , "1"));
		//--------->>Student Ends<<------------
		
		//Abandon the Assessment and start again to check more cheat events
		//--------->>Faculty Starts<<------------
		Thread.sleep(5000);
		VerificationHandler.verifyTrue(maintenanceScriptID.clickButtonWith30SecWait(proctorDriver, PropertiesRepository.getString("asmt.proctor.page.refresh.btn.loc")),
				"Unable to click Refresh Button");
		Thread.sleep(3000);

		log(logger, "Clicking on Abandon radio Button and refresh");
		maintenanceScriptID.clickAbandonButnInStoppedAssetSec(proctorDriver);
				
		//--------->>Faculty Ends<<------------
		
		//--------->>Student Starts<<------------
		windowHandler.switchToLatestWindow();
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Proctor Assessment ");
		quizBankAssPage.clickTestTabProctorButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type.Proctor"), PropertiesRepository.getString("asmt.assessment.mc10.proctor"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						
		log(logger, "Clicking on Proctor Check Box");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"));
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.student.proxtor.check.box.loc"), 0);
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		//--------->>Student Ends<<------------
		
		//--------->>Faculty Start<<------------
		maintenanceScriptID.waitUntillLoadingImageIsDisappeared(proctorDriver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		maintenanceScriptID.scrollToElement(proctorDriver,
				PropertiesRepository.getString("asmt.proctor.page.element.loc"));
		Thread.sleep(20000);
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
		
		log(logger, "Clicking on Start/ Resume Test Button");
		maintenanceScriptPage.clickButtonForProctor(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"), 0);
		Thread.sleep(20000);
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		
		//Escape Functionality not working in Two browser scenario
		/*//Covering ASMT-733---Start
		log(logger, "Answer one question");
		quizBankAssPage.takeTest(false, true, false, false, false);		
		
		log(logger, "Create cheat event-Esc, Verify the cheat event popup's and popup message's and click on Resume button----1st Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.stopAss.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg2"), "escape" , "" , escape , "2"));
		
		log(logger, "Click on previous button");
		driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"))).sendKeys(Keys.ENTER);
		
		log(logger, "Verifying 1st Question is displayed");
		quizBankAssPage.waitUntillElementIsVisible("#highlightWordsText");
		VerificationHandler.verifyTrue(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText().equals("1"));
		
		log(logger, "Create cheat event-Esc, Verify the cheat event popup's and popup message's and click on Resume button----2nd Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.stopAss.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg2"), "escape" , "" , escape , "2"));
		//Covering ASMT-733---Ends
*/		
		log(logger, "Create cheat event-ctrl+t, Verify the cheat event popup's and popup message's and click on Resume button----3st Time ");
		VerificationHandler.verifyTrue(quizBankAssPage.createCheateEventVerifyPopupandAndMsg(
				PropertiesRepository.getString("asmt.proctor.cheatevent.resume.btn.loc"),
				PropertiesRepository.getString("asmt.cheatevent.popup.resume.btn"),
				PropertiesRepository.getString("asmt.cheatevent.popup.msg"), "ctrl" , "t" , blank , "1"));
		
		
		//--------->>Student Ends<<------------		
		
		logger.info("ASMT_672_754_733_ProctorAssesAllCheatEvent End");		
	}
	
	
	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
}
