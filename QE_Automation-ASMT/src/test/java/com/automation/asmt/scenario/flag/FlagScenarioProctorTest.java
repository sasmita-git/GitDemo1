package com.automation.asmt.scenario.flag;

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
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class FlagScenarioProctorTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	
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
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}

	/**
	 * Covering : ASMT-360,ASMT-583,ASMT-767,ASMT-608
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_360_583_767_608")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT-360,ASMT-583,ASMT-767,ASMT-608 -- Flag Scenario")
	public void ASMT_360_583_767_608_FlagScenarioProctor() throws Exception {
		
		log(logger, "ASMT_360_583_767_608_FlagScenarioProctor Start"); 
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId = PropertiesRepository.getString("asmt.product.id.value.flag.scenario");
		String procAssessmentPwd = PropertiesRepository.getString("asmt.product.pass.value.flag.scenario");
		
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
		Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
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
		
		//getting max question number
		int maxQtnTextNo = Integer.parseInt(quizBankAssPage.baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText());
		
		log(logger, "Taking Proctor Assessment - Flag even questions, answer odd questions and flag and answer at the same time for one question and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, false, true));		
		
		//Total flagged question = all the odd questions + one even question(Covering a specific scenario to flag and answer at the same time)
		int questionsFlagged = (maxQtnTextNo/2) + 1 ;
		
		//if maxQtnTextNo is odd number then we add one to it.
		if((maxQtnTextNo % 1) ==1)
		{questionsFlagged=+1;}
		
		//Verify if the Total actual flagged question is equal to the number in the Pop up 
		VerificationHandler.verifyTrue(questionsFlagged == quizBankAssPage.getFlaggedQuestionNumfromPopup());
		
		log(logger, "Clicking on 'Review Flagged Questions' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 0);
				
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));		
		
		//TC: ASMT-608 -completing assessment by passing false to rational. Hence verifying rational page is not displayed.
		log(logger, "Taking Proctor Assessment - Unflagging and answering all the questions and Verify Assessment Complete Popup ");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, false, false));		
		
		log(logger, "Clicking on 'Finalize and View Results' Button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc"), 1);
		quizBankAssPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");		

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		//--------->>Student Ends<<------------
		
		log(logger, "ASMT_360_583_767_608_FlagScenarioProctor Ends");		
	}		
	
	/**
	 * Covering : ASMT_646_764_758
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_646_764_758")
	@Test(priority = 1, alwaysRun = true, groups = { "Regression" }, description = "ASMT_646_764_758 -- Flag Scenario-TEAS Proctor")
	public void ASMT_646_764_758_FlagScenarioTEASProctor() throws Exception {
		
		log(logger, "ASMT_646_764_758_FlagScenarioTEASProctor Start");
		proctorDriver = openProctorChromeDriver();
		
		userName = userCreationUtils.getUserDetails();
		logger.info("Student User Created  --> " + userName);
		String procAssessmentId =/* PropertiesRepository.getString("asmt.product.id.value.flag.scenario")*/"10448543";
		String procAssessmentPwd =/* PropertiesRepository.getString("asmt.product.pass.value.flag.scenario")*/"test";
		
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
		Thread.sleep(10000);
			
		log(logger, "Clicking on Proctor Check Box");
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
		
		log(logger, "Flag all the questions in the first section of TEAS and Verifying is all the questions are flagged");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagAllQues());
		
		//List of Button to be displayed in the popup		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		log(logger, "Verify if 'Go back To Last Question', 'Review Flagged questions', and 'Proceed to Next Section' buttons are displayed and Click on 'Review Flagged questions' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn1.loc")));	
								
		log(logger, "Verify if Unflag button is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.unflag.btn.loc", 0));	
		
		log(logger, "Un flag all the questions in the first section of TEAS");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestUnFlagAllQues(false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
				
		log(logger, "Verify if 'Go back To Last Question', 'Go Back to Last Question', 'Proceed to Next Section' buttons are displayed and Click on 'Proceed to Next Section' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn3.loc")));
		
		log(logger, "Taking TEAS Proctor Assessment Section -- 2");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false,false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList = new ArrayList<String>();
		buttonList.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList.add(PropertiesRepository.getString("asmt.popup.btn4.loc"));
				
		log(logger, "Verify if 'Go back To Last Question' and 'Complete Post Assessment Survey' buttons are displayed and Click on 'Complete Post Assessment Survey' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList , PropertiesRepository.getString("asmt.popup.btn4.loc")));
									
		log(logger, "Verifying the flag button in not present in the Survay Section");		
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.generic.tutorial.flag.value", 0)));
				
		log(logger, "Verify if calculator is displayed in the Survay Section");
		VerificationHandler.verifyTrue(!(homePage.isElementDisplayed("asmt.assessment.calculator.loc", 0)));
				
		log(logger, "Taking TEAS Proctor Assessment Section -- Survey");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTest(false, false, false, false,false));
		
		//List of Button to be displayed in the popup
		ArrayList<String> buttonList4 = new ArrayList<String>();
		buttonList4.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList4.add(PropertiesRepository.getString("asmt.popup.btn5.loc"));
				
		log(logger, "Verify if 'Go back To Last Question' and 'Finalize and View Results' buttons are displayed and Click on 'Finalize and View Results' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList4 , PropertiesRepository.getString("asmt.popup.btn5.loc")));	
				
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
				
		//--------->>Student Ends<<------------
		
		log(logger, "ASMT_646_764_758_FlagScenarioTEASProctor Ends");		
	}
	
	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.close();
			proctorDriver.quit();
		}
	}
	
}
