package com.automation.asmt.newPoroctorMonitor;

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
import com.automation.asmt.page.NPMStapper2Page;
import com.automation.asmt.page.NPMStapper3Page;
import com.automation.asmt.page.NPMStapper4Page;
import com.automation.asmt.page.NPMStapper5Page;
import com.automation.asmt.page.NewProctorMonitorPage;
import com.automation.asmt.page.PeakPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.CommonUtils;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;


public class newPM extends BaseTest{
	
Logger logger = LogManager.getLogger(this.getClass());
private MaintenanceScriptPage maintenanceScriptPage;
private MaintenanceScriptID maintenanceScriptID;	
private LoginPage loginPage;
private QuizBankAssessmentPage quizBankAssPage ;
private HomePage homePage;

private WindowHandler windowHandler;
private UserCreationUtils userCreationUtils;
private String userName;

private NPMStapper2Page npmstapper2Page;
private NPMStapper3Page npmstapper3Page;
private NPMStapper4Page npmstapper4Page;
private NPMStapper5Page npmstapper5Page;
private NewProctorMonitorPage npmmonitoringpage;
	
@BeforeMethod
public void verifyHomePage() throws Exception {

	loginPage = new LoginPage(driver);		
	loginPage = new LoginPage(driver);		
	
	homePage =  new HomePage(driver);	
	userCreationUtils = new UserCreationUtils();		
	windowHandler = new WindowHandler(driver);
	maintenanceScriptPage = new MaintenanceScriptPage(driver);
	maintenanceScriptID = new MaintenanceScriptID(driver);
	npmstapper2Page = new NPMStapper2Page(driver);
	npmstapper3Page = new NPMStapper3Page (driver);
	npmstapper4Page = new NPMStapper4Page (driver);
	npmstapper5Page = new NPMStapper5Page (driver);
	npmmonitoringpage = new NewProctorMonitorPage(driver);
}

/*
 * 
 */
@TestAnnotations(testID="")
@Test(priority = 4, alwaysRun = true, groups = { "Smoke" }, description = " Step1 to step5 and monitoring a page")
public void ProctorAssesment() throws Exception {
	logger.info("ProctorAssesment Start");

	
	//--------->>Faculty Start<<------------
	log(logger, "Login to Faculty application");
	VerificationHandler.verifyTrue(maintenanceScriptID.loginToApplicationID(driver,
			PropertiesRepository.getString("npm.proctor.username"),
			PropertiesRepository.getString("npm.proctor.password")));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Verifying Home Page");
	
	VerificationHandler.verifyTrue(maintenanceScriptPage.isElementDisplayed(driver,"id.home.page.left.navigator.icon.link", 0));

	log(logger, "Clicking on Left Navigation Link");
	VerificationHandler.verifyTrue(maintenanceScriptID.verifyAndClickSimple(driver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
			
	log(logger, "Verifying Home Link in Left Navigation");
	VerificationHandler.verifyTrue(maintenanceScriptID.verifyLeftNavigationTextSearch(driver, "assessment",true), "Unable to verify Home Link");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Search the assessment Select and Click on continue in Step-2");
	VerificationHandler.verifyTrue(npmstapper2Page.selectAssesmentAndCloickOnContinue("10608966"),"Unable to find batchID");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Complete Step-3");
	VerificationHandler.verifyTrue(npmstapper3Page.SelectAgreementCheckboxesEnterSignatureAndContinue(),"Unable to Complete Step-3");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Complete Step-4");
	VerificationHandler.verifyTrue(npmstapper4Page.clickOnContinueButton(),"Unable to click on continue button in Step-4");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	log(logger, "Complete Step-5");
	VerificationHandler.verifyTrue(npmstapper5Page.clickOnStartProctoring(),"Unable to Complete Step-5");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(600);
	
	
	log(logger, "Approve test");
	VerificationHandler.verifyTrue(npmmonitoringpage.monitoring(),"Unable to click on approve buton");
	maintenanceScriptID.waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	
	Thread.sleep(600);
	
	
	
	
	
	
	maintenanceScriptID.waitUntillElementIsVisible(PropertiesRepository.getString("pmPage.EndAllSessionsbutton"));
	
	Thread.sleep(500);
	logger.info("ASMT755_ProctorAssesment End");		
}
	
	@AfterMethod()
	public void finalMethod() {
	}

}