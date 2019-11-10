package com.automation.id.reports;

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

public class SmokeReportTest3 extends BaseTest {

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

	@TestAnnotations(testID = "inst-2016")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = " inst-2016:Verify Group report tile from the communicator 2.0 & civility mentor")
	public void INST2016_VerifyGrpReportFromCommunicatorAndCivilityMentor() throws Exception {
		logger.info("INST2016_VerifyGrpReportFromCommunicatorAndCivilityMentor Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.personnel..home2.0.login.user.name"),
				PropertiesRepository.getString("id.personnel..home2.0.login.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verify that Admission Tiles is displaying");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.VerifyReportingTextLink(
						PropertiesRepository.getString("id.analytics.reporting.admissions.and.ati.pulse.report.card.portlet.loc"),
						PropertiesRepository.getString("id.analytics.reports.home.page.report.admission.name")),
				"Unable to verify Admission Tiles");

		/*log(logger, "Verifying Admission Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.admission.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
*/				
		
		logger.info("INST2016_VerifyGrpReportFromCommunicatorAndCivilityMentor End");
	}

	@TestAnnotations(testID = "inst-1678")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify that TEAS/Discover report is generated as per the program type selected and if the booklet is valuated based on the program type selected.")
	public void INST1678_VerifyTEASDiscoverReportProgramType() throws Exception {
		logger.info("INST1678_VerifyTEASDiscoverReportProgramType Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.report1"),
				PropertiesRepository.getString("id.login.faculty.password.report1"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		
		/*log(logger, "Click on classic reporting tile");
		analyticsLandingPgae.clickOncardTiles(2);*/
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();

		log(logger, "Click on TEAS Discover report button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickswitchToCardShadowFrame(PropertiesRepository.getString("analytics.reportwizard.teasdiscover.loc"), true), "Unable to Click on TEAS Discover report button");

		reportWizardPage.scrollDown();

		log(logger, "send date to the text field for filter");
		reportWizardPage.sendDateTeasDiscover("03/19/2017");

		log(logger, "click on continue btn");
		reportWizardPage.clickContinueTEASDiscover();

		log(logger, "scroll up");
		reportWizardPage.scrollUP();

		log(logger, "Select radio button for diffrent program type");
		VerificationHandler.verifyTrue(reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("select.radio.btn.teas.discover"), 0), "Unable to Select radio button for diffrent program type");

		log(logger, "Select program type as pn");
		VerificationHandler.verifyTrue(reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("program.type.teas.discover.pn"), 0), "Unable to Select program type as pn");

		log(logger, "click on continue btn");
		reportWizardPage.clickOncontinueBtnFromConfigureReportPage();

		log(logger, "Select check box for student");
		VerificationHandler.verifyTrue(reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.select.student.loc"), 0), "Unable to Select check box for student");

		log(logger, "click print button");
		reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.report.print.button2"), 0);

		log(logger, "click on data extract button");
		reportWizardPage
				.clickAssIdwithIndex(PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), 0);

		log(logger, "click on previous button");
		reportWizardPage
				.clickAssIdwithIndex(PropertiesRepository.getString("reportwizard.individualreport.previous.btn"), 0);

		log(logger, "click on previous button again");
		reportWizardPage
				.clickAssIdwithIndex(PropertiesRepository.getString("reportwizard.individualreport.previous.btn"), 0);

		log(logger, "click on previous button");
		reportWizardPage
				.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.report.print.previuos.button"), 0);

		log(logger, "click on program type BSN");
		reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("program.type.teas.discover.bsn"), 0);

		log(logger, "click on continue btn");
		reportWizardPage.clickOncontinueBtnFromConfigureReportPage();

		log(logger, "click on print btn");
		reportWizardPage.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.report.print.button2"), 0);

		log(logger, "click on data extract button");
		reportWizardPage.clickAssIdwithIndex(
				PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc.report"), 0);

		log(logger, "Verify that selected program type ADN is displaying now");
		reportWizardPage.clickAssIdwithIndex("teas.discover.select.program.dataextract.result.loc", 8);

		logger.info("INST1678_VerifyAssessmentResultOfDataExtract End");
	}

	@TestAnnotations(testID = "inst-1850")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1850 ::Verify building Practice Assessment 'Question Analysis' report.")
	public void INST1850_VerifyQuestionAnalysisPracticeAssessmentReport() throws Exception {
		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.report2.new"),
				PropertiesRepository.getString("id.login.faculty.password.report2.new"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		
		/*log(logger, "Click on classic reporting tile");
		analyticsLandingPgae.clickOncardTiles(2);*/
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();

		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),
				"question analysis is not visible");

		log(logger, "Click on question analysis button");
		loginPage.verifyAndClickswitchToCardShadowFrame(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);

		log(logger, "Verify proctored assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),
						"proctor assessment tab not visible");

		log(logger, "Verify practice assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),
						"practice assessment tab not visible");

		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"proctor assessment grid is not diplayed");

		log(logger, "Click on practice assessment tab");
		loginPage.verifyAndClickswitchToCardShadowFrame(
				PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc.practiceAss"), true);

		log(logger, "Verify practice assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"practice assessment grid is not diplayed");

		log(logger, "click on assessment from the practice grid list");
		reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc",
				PropertiesRepository.getString("id.reports.reportwizrad.practiceAss.value"));

		reportWizardPage.sendDateInTextField();

		log(logger, "click on assessment id");
		reportWizardPage.clikOnProctorAssessmentId("id.reports.reportwizrad.practiceAss.id.values");

		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),
				"DataExtraction is not diplayed");

		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),
				"PDF is not diplayed");

		log(logger, "Click on DataExtract button");
		reportWizardPage.verifyAndClickReportPageBtns(
				PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);

		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),
				"CSV/Excel is not diplayed");

		log(logger, "Click and Verify CSV/Excel button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),
				"CSV/Excel button not clicked");

		log(logger, "Click and verify  XML button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),
				"XML button not clicked");

		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");
	}

	@TestAnnotations(testID = "inst-1851")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1851 Verify building proctor Assessment 'Question Analysis' Report.")
	public void INST1851_VerifyQuestionAnalysisProctorAssessmentReport() throws Exception {
		logger.info("INST1851_Verify building proctor Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.personnel..home2.0.login.user.name"),
				PropertiesRepository.getString("id.personnel..home2.0.login.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// loginPage.waitForAwhile(8000);

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 4, "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		
		/*log(logger, "Click on classic reporting tile");
		analyticsLandingPgae.clickOncardTiles(2);*/
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();

		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),
				"question analysis is not visible");

		log(logger, "Click on question analysis button");
		loginPage.verifyAndClickswitchToCardShadowFrame(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);

		log(logger, "Verify proctored assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),
						"proctor assessment tab not visible");

		log(logger, "Verify practice assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),
						"practice assessment tab not visible");

		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"proctor assessment grid is not diplayed");

		log(logger, "click on assessment from the proctor grid list");
		// reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc",
		// PropertiesRepository.getString("id.reports.reportwizrad.proctorAss.value"));
		//reportWizardPage.ClickAssessmentFromPools();
		reportWizardPage.ClickAssessmentFromPoolsBasedOnNames("Item Type Regression Test (P)");

		log(logger, "select date to filter");
		reportWizardPage.sendDateInTextField();

		log(logger, "click on assessment id");
		reportWizardPage.clikOnProctorAssessmentId("id.reportwizard.proctor.batch.id");

		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),
				"DataExtraction is not diplayed");

		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),
				"PDF is not diplayed");

		log(logger, "Click on DataExtract button");
		reportWizardPage.verifyAndClickReportPageBtns(
				PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);

		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),
				"CSV/Excel is not diplayed");

		log(logger, "Click and Verify CSV/Excel button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),
				"CSV/Excel button not clicked");

		log(logger, "Click and verify  XML button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),
				"XML button not clicked");

		logger.info("INST1851_Verify building Practice Assessment 'Question Analysis' report.");
	}

	@TestAnnotations(testID = "inst-1915")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify that ATI Beta Reporting Tiles are displaying")
	public void INST1915_VerifyBetaReportTiles() throws Exception {
		
		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.report2.new"),
				PropertiesRepository.getString("id.login.faculty.password.report2.new"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

/*		log(logger, "Verifying Admissions link is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.analytic.betaTile.admissionLoc")),
				"Admissions link not presented");
*/
		log(logger, "Verify that Admission Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Admissions"), "Unable to verify Admission Tiles");

		/*analyticsLandingPgae.VerifyReportingTextLink(
				PropertiesRepository.getString("id.analytics.reporting.admissions.and.ati.pulse.report.card.portlet.loc"),
				PropertiesRepository.getString("id.analytics.reports.home.page.report.admission.name"));*/
//		"Unable to verify Admission Tiles"
		
		log(logger, "click and verify admission page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.admissionLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 2),
				"admission link not opened");

		/*log(logger, "Verifying Tutorial link is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.analytic.betaTile.TutLoc")),
				"Tutorial link not presented");
*/
		log(logger, "Verify that Tutorial Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Tutorials"), "Unable to verify Tutorials Tiles");
		
		log(logger, "click and verify Tutorial page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.TutLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 3),
				"Tutorial link not opened");

		/*log(logger, "Verifying Assessmnet link is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.analytic.betaTile.assessmentLoc")),
				"Assessmnet link not presented");
*/
		log(logger, "Verify that Assessment Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Assessments"), "Unable to verify Assessments Tiles");
		
		log(logger, "click and verify Assessmnet page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.assessmentLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 4),
				"Assessmnet link not opened");

		/*log(logger, "Verifying Remediation link is displayed");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.analytic.betaTile.remediationLoc")),
				"Remediation link not presented");*/
		
		log(logger, "Verify that Remediation Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Remediation"), "Unable to verify Remediation Tiles");
		

		log(logger, "click and verify Remediation page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.remediationLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 5),
				"Remediation link not opened");
	}
	
	

}
