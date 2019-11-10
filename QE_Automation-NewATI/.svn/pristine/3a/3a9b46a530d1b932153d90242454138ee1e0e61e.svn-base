package com.automation.newati.myati.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.common.CommonUtils;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.ProctorTestPage;
import com.automation.newati.pages.ProctoredAssessmentPage;

public class ProctoredAssessmentRegressionTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private ProctoredAssessmentPage proctored123AssessmentPageTemp;
	private WebDriver chromeDriver;
	private ProctorTestPage proctorTestPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		proctorTestPage = new ProctorTestPage(driver);
		proctored123AssessmentPageTemp = new ProctoredAssessmentPage(driver);
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-108:Verify 'RN Comprehensive Predictor 2013' Proctored Assessment")
	public void NewATI108_RNCompPred2013ProctoredAssessment() throws Exception {
		log(logger, "NewATI108_RNCompPred2013ProctoredAssessment End");

		loginPage.loginToApplication("TestUser_07042017_5", "Test123");

		// Faculty Portal Start 
		chromeDriver = openProctorChromeDriver(); 
		chromeDriver.get("https://stage-www.atitesting.com/Home.aspx");
		proctored123AssessmentPageTemp.loginToFacultyPortal(chromeDriver, "stage.atiuser3", "test");
		proctored123AssessmentPageTemp.checkPopupIsDisplayed(chromeDriver);

		log(logger, "Selected the product tab");
		proctored123AssessmentPageTemp.selectTab(chromeDriver, "home.tabs.loc", 1);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selected the proctor Assesments form the drop down");
		proctored123AssessmentPageTemp.selectActivity(chromeDriver, 0);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Blank Proctor ID Value");
		proctored123AssessmentPageTemp
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.id.loc"),
						PropertiesRepository
								.getString("faculty.portal.108.product.assessment.id.value"));

		log(logger, "Enteing Proctor Pwd Value");
		proctored123AssessmentPageTemp
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.pwd.loc"),
						PropertiesRepository
								.getString("faculty.portal.108.product.assessment.pwd.value"));

		log(logger, "Clicking Proctor Submit Button");
		proctored123AssessmentPageTemp.clickButtonWithLoadingImageDisappeared(chromeDriver, PropertiesRepository
				.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"));
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		
		log(logger, "Entering Electornic Signature");
		proctored123AssessmentPageTemp
				.enterElectornicSignature(chromeDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctored123AssessmentPageTemp
				.enterElectornicSignature(chromeDriver, 
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						CommonUtils.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctored123AssessmentPageTemp.clickProctorWelcomePageProceedButton(chromeDriver);
		// Faculty Portal End
		
		// Student Portal Start
		log(logger, "Clicking on Add Product Button");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctored123AssessmentPageTemp.enterValue(PropertiesRepository.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("faculty.portal.itr.product.assessment.id.value"));
		
		log(logger, "Clicking on Button");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		// Student Portal End
		
		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));
		// Proctor Portal End
		
		// Faculty Portal Start
		log(logger, "Clicking on Aprove Button");
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000); 
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("faculty.portal.proctor.approve.radio.button.loc"));
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000);
		// Faculty Portal End 
		
		// click on Resume Test Button. 
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
		// Assessment Page. 
		proctorTestPage.takeRNCompPredProctorAssessment();
		
		chromeDriver.close();
		chromeDriver.quit();
		log(logger, "NewATI108_RNCompPred2013ProctoredAssessment Start");
	}

	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-104:Verify student is able to take a TEAS proctored assessments")
	public void NewATI104_TEASProctoredAssessment() throws Exception {
		log(logger, "NewATI104_TEASProctoredAssessment End");
		
		loginPage.loginToApplication("TestUser_06042017_6", "Test123");
		
		// Faculty Portal Start 
		chromeDriver = openProctorChromeDriver(); 
		chromeDriver.get("https://stage-www.atitesting.com/Home.aspx");
		proctored123AssessmentPageTemp.loginToFacultyPortal(chromeDriver, "stage.atiuser3", "test");
		proctored123AssessmentPageTemp.checkPopupIsDisplayed(chromeDriver);

		log(logger, "Selected the product tab");
		proctored123AssessmentPageTemp.selectTab(chromeDriver, "home.tabs.loc", 1);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selected the proctor Assesments form the drop down");
		proctored123AssessmentPageTemp.selectActivity(chromeDriver, 0);
		Thread.sleep(1000);
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Entering Blank Proctor ID Value");
		proctored123AssessmentPageTemp
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.id.loc"),
						PropertiesRepository
								.getString("faculty.portal.teas.product.assessment.id.value"));

		log(logger, "Enteing Proctor Pwd Value");
		proctored123AssessmentPageTemp
				.enterProctorIDAndPwd(chromeDriver, 
						PropertiesRepository
								.getString("proctor.assessment.pwd.loc"),
						PropertiesRepository
								.getString("faculty.portal.teas.product.assessment.pwd.value"));

		log(logger, "Clicking Proctor Submit Button");
		proctored123AssessmentPageTemp.clickButtonWithLoadingImageDisappeared(chromeDriver, PropertiesRepository
				.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"));
		//proctoredAssessmentPage.waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		Thread.sleep(10000);
		
		log(logger, "Entering Electornic Signature");
		proctored123AssessmentPageTemp
				.enterElectornicSignature(chromeDriver,
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctored123AssessmentPageTemp
				.enterElectornicSignature(chromeDriver, 
						PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
						CommonUtils.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctored123AssessmentPageTemp.clickProctorWelcomePageProceedButton(chromeDriver);
		// Faculty Portal End
		
		// Student Portal Start
		log(logger, "Clicking on Add Product Button");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		
		log(logger, "Entering Proctor Id"); // need to check locator
		proctored123AssessmentPageTemp.enterValue(PropertiesRepository.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
				.getString("faculty.portal.teas.product.assessment.id.value"));
		
		log(logger, "Clicking on Button");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		Thread.sleep(10000);
		// Student Portal End
		
		// Proctor Portal Start
		log(logger, "Clicking on Proctor Check Box");
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.checkbox.loc"));
		// Proctor Portal End
		
		// Faculty Portal Start
		log(logger, "Clicking on Aprove Button");
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000); 
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("faculty.portal.proctor.approve.radio.button.loc"));
		
		log(logger, "Clicking on Refresh Button");
		Thread.sleep(30000);
		Thread.sleep(30000);
		proctored123AssessmentPageTemp.clickButtonWith30SecWait(chromeDriver, PropertiesRepository.getString("new-atitesting.proctor.refresh.button"));
		Thread.sleep(30000);
		// Faculty Portal End 
		// click on Resume Test Button. 
		proctored123AssessmentPageTemp.clickButton(PropertiesRepository.getString("new-atitesting.proctor.start.test.button"));
		// Assessment Page.  
		// Section 1
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 2		
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 3
		proctorTestPage.takeTEASProctorAssessment_1();
		// Section 4
		proctorTestPage.takeTEASProctorAssessment_FinalSection();
		// Continue Section 
		proctorTestPage.clickContinueButton();
		// Last Section
		proctorTestPage.takeTEASProctorAssessment_last();
		log(logger, "NewATI104_TEASProctoredAssessment Start");
	}
	
}
