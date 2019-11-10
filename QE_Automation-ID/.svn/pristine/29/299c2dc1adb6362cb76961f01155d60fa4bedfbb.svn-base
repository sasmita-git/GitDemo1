package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;
import com.automation.id.pages.ReportWizardReportPage;
import com.jaca.TestAnnotations;

public class VerifyReportWizardTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ReportWizardReportPage reportWizardpage;
	private EditProfilePage editProfilePage;
	private ReportWizardPage reportWizardPagee;
	private ReportWizardPage reportWizardPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void verifyHomePage() throws Exception {
		loginPage =new LoginPage(driver);
		homePage =new HomePage(driver);
		reportWizardpage = new ReportWizardReportPage(driver);
		new QuickReportPage(driver);
		loginPage = new LoginPage(driver);
		reportWizardPagee=new ReportWizardPage(driver);
		reportWizardPage =new ReportWizardPage(driver);
		editProfilePage = new EditProfilePage(driver);
	}
	
	//@TestAnnotations(testID="inst-1850")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Smoke","Regression"}, description = "Verify building Practice Assessment 'Question Analysis' report.")
	public void INST1850_VerifyQuestionAnalysisPracticeAssessmentReport() throws Exception {
		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.people.test.username"), PropertiesRepository.getString("id.login.faculty.people.test.password"));
		/*
		log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);
*/
		log(logger,"Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger,"click on anlytics");
		homePage.clikOnLeftNavLink(4);
		
		log(logger,"click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();
		
		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),"question analysis is not visible");
		
		log(logger, "Click on question analysis button");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);
		
		log(logger, "Verify proctored assessment tab");
		VerificationHandler.verifyTrue(loginPage.verifyMessage("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0, PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),"proctor assessment tab not visible");
		log(logger, "Verify practice assessment tab");
		VerificationHandler.verifyTrue(loginPage.verifyMessage("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0, PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),"practice assessment tab not visible");
		
		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid("id.reports.reportwizrad.questionanalysis.assGrid.loc"),"proctor assessment grid is not diplayed");
		
		log(logger, "Click on practice assessment tab");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc.practiceAss"), true);
				
		log(logger, "Verify practice assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid("id.reports.reportwizrad.questionanalysis.assGrid.loc"),"practice assessment grid is not diplayed");
		
		log(logger, "click on assessment from the practice grid list");
		reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc", PropertiesRepository.getString("id.reports.reportwizrad.practiceAss.value"));
		
		
		log(logger, "Verify assessment list associated with institution");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.qa.instituteAss.loc"),"assessment associated with institution not diplayed");
		
		log(logger, "click on assessment id");
		reportWizardPage.ClickAssessmentId("id.reports.reportwizrad.qa.instituteAss.loc", PropertiesRepository.getString("id.reports.reportwizrad.practiceAss.id.value"));
		
		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),"DataExtraction is not diplayed");
		
		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),"PDF is not diplayed");
		
		log(logger, "Click on DataExtract button");		
		reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);
		
		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),"CSV/Excel is not diplayed");
		
		log(logger, "Click and Verify CSV/Excel button");		
		VerificationHandler.verifyTrue(reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),"CSV/Excel button not clicked");
		
		log(logger, "Click and verify  XML button");		
		VerificationHandler.verifyTrue(reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),"XML button not clicked");
		
		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");
	}
	
	@TestAnnotations(testID="inst-1851")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Smoke","Regression"}, description = "Verify building proctor Assessment 'Question Analysis' Report.")
	public void INST1851_VerifyQuestionAnalysisProctorAssessmentReport() throws Exception {
		logger.info("INST1851_Verify building proctor Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username.report"), PropertiesRepository.getString("id.login.faculty.password.report"));
		
		/*log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);
		*/
		log(logger,"Click on left nav");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger,"click on anlytics");
		homePage.clikOnLeftNavLink(4);
		
		log(logger,"click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();
		
		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),"question analysis is not visible");
		
		log(logger, "Click on question analysis button");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);
		
		log(logger, "Verify proctored assessment tab");
		VerificationHandler.verifyTrue(loginPage.verifyMessage("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0, PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),"proctor assessment tab not visible");
		
		log(logger, "Verify practice assessment tab");
		VerificationHandler.verifyTrue(loginPage.verifyMessage("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0, PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),"practice assessment tab not visible");
		
		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid("id.reports.reportwizrad.questionanalysis.assGrid.loc"),"proctor assessment grid is not diplayed");
				
		log(logger, "click on assessment from the proctor grid list");
		reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc", PropertiesRepository.getString("id.reports.reportwizrad.proctorAss.value"));
		
		/*log(logger, "Verify assessment list associated with institution");
		VerificationHandler.verifyTrue(reportWizardpage.verifyAssessmentGrid1("id.reports.reportwizrad.qa.instituteAss.loc"),"assessment associated with institution not diplayed");
		*/
		log(logger, "click on assessment id");
		//reportWizardpage.ClickAssessmentId("id.reports.reportwizrad.qa.instituteAss.loc", PropertiesRepository.getString("id.reports.reportwizrad.proctorAss.id.value"));
		reportWizardPagee.clikOnProctorAssessment();
		
		log(logger,"select date to filter");
		reportWizardPagee.sendDateInTextField();
		
		log(logger,"click on assessment id");
		reportWizardPagee.clikOnProctorAssessmentId("id.reportwizard.proctor.batch.id");
		
		
		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),"DataExtraction is not diplayed");
		 
		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),"PDF is not diplayed");
		
		log(logger, "Click on DataExtract button");		
		reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);
		
		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),"CSV/Excel is not diplayed");
		
		log(logger, "Click and Verify CSV/Excel button");		
		VerificationHandler.verifyTrue(reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),"CSV/Excel button not clicked");
		
		log(logger, "Click and verify  XML button");		
		VerificationHandler.verifyTrue(reportWizardPage.verifyAndClickReportPageBtns(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),"XML button not clicked");
		
		logger.info("INST1851_Verify building Practice Assessment 'Question Analysis' report.");
	}
}
