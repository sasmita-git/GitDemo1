package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.AnalyticsLandingPgae;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;
import com.jaca.TestAnnotations;

public class Smoke_AnalyticsTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private AnalyticsLandingPgae analyticsLandingPgae;
	private ReportWizardPage reportWizardPage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		analyticsLandingPgae = new AnalyticsLandingPgae(driver);
		homePage = new HomePage(driver);
		quickReportPage = new QuickReportPage(driver);
		reportWizardPage = new ReportWizardPage(driver);
		loginPage = new LoginPage(driver);
	}
	
	
	@TestAnnotations(testID = "inst-1612")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Smoke_AnalyticsTest :: Verify individual reports are generated")
	public void INST1612_VerifyIndividualAssessmentReport() throws Exception {
		logger.info("INST1612_VerifyIndividualAssessmentReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
		log(logger, "enter practice assessment id in individual text field of quick report");
		VerificationHandler.verifyTrue(quickReportPage.generateIndividualReportforPracticeNProctor(PropertiesRepository.getString("individual.report.batch.practice.id")), "Unable to enter assessment id in individual text field of quick report");
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
		log(logger, "click on QickReport tab");
		reportWizardPage.clickOnQuickReportTab();
		
		log(logger, "enter proctor assessment id in individual text field of quick report");
		VerificationHandler.verifyTrue(quickReportPage.generateIndividualReportforPracticeNProctor(PropertiesRepository.getString("individual.report.batch.proctor.id")), "Unable to enter assessment id in individual text field of quick report");
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on QickReport tab");
		reportWizardPage.clickOnQuickReportTab();
				
		log(logger, "Entering Tutorial id in Group Report for Tutorial");
		reportWizardPage.enterTextWithSwitchToCardShow(
				PropertiesRepository
						.getString("id.analytics.classic.reporting.quick.reports.tutorial.group.report.text.box.loc"),
				PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.group.report.text.box.value.2016.value"));

		log(logger, "Clicking on Enter Button");
		VerificationHandler
				.verifyTrue(reportWizardPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.group.report.enter.button.loc"),
				true), "Unable to click Enter Button");
		log(logger, "Verifying Group Name in Comm and Civility Mentor portlet details");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyCommAndCivilityMentorPortletDetails(PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.title.value")),
				"Unable to verify on Group Report Portlet details");

		log(logger, "Clicking on Group Report Continue Button");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.title.value")),
				"Unable to click on Group Report continue button");

		log(logger, "Verifying Group Report Assessment Name ");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyMessage(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.assessemnt.name.loc",
						0,
						PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.group.report.assessment.2016.value")),
				"Unable Verifying Group Report Assessment Name ");
		
		log(logger, "Verifying Group Report Modules list");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletContinueBtnModulesList(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.modules.list.loc")),
				"Unable to Verifying Group Report Modules list");
		
		log(logger, "Clicking on classic reporting link");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.analytics.classicReporting.link.loc"), true), "Unable to click faculty navigation");
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();

		log(logger, "click on build button for group report");
		reportWizardPage.clikOnBuildBtnForGroupReport();

		log(logger, "Select the radio button 'a Custom Group of Students");
		reportWizardPage.selectCustomeGroupOfStudent();

		log(logger, "verify that create new group button is present");
		VerificationHandler.verifyTrue(reportWizardPage.verifyCreateNewGrpButton());

		log(logger, "Select one group from custome group list");
		VerificationHandler.verifyTrue(reportWizardPage.clickOnCutomGroupRadioBtnFromTable1(),"unable to click radio button");
		VerificationHandler.verifyTrue(reportWizardPage.clickOnCutomGroupContinueBtn(),"unable to click continue button");

		log(logger, "verify that proctor and prcatice assessment tab are displaying");
		VerificationHandler.verifyTrue(reportWizardPage.verifygroupReportProctorPracticeTab(), "Unable to verify that proctor and prcatice assessment tab are displaying");

		log(logger, "click on one assessment pool name");
		VerificationHandler.verifyTrue(reportWizardPage.clickOnAssessmentPool(), "Unable to verify Generate PDF button");

		// saravanan will see log
		log(logger, "click on data extract btn");
		reportWizardPage.scrollUp();
		
		log(logger, "click on data extract tab");
		VerificationHandler.verifyTrue(quickReportPage.clickOnDataExtractTab1(), "Unable to click on data extract tab");
		
		log(logger, "click on customReport tab");
		VerificationHandler.verifyTrue(quickReportPage.clickOnCustomReportsTab(), "Unable to click on custom report tab");
		
		log(logger, "click on focused review tab");
		VerificationHandler.verifyTrue(quickReportPage.clickOnFocusedReviewTab(), "Unable to click on focused review tab ");
		
		logger.info("INST1612_VerifyIndividualAssessmentReport End");
	}


	
}
