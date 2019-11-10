package com.automation.id.oldtests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class BenchMarkTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	ProductsPage productsPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		productsPage = new ProductsPage(driver);
	}

	@TestAnnotations(testID = "INST-2004")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify that 'Director' can save benchmark for practice asessment::Set Benchmark")
	public void INST2004_VerifyDirectorcanSaveBenchmarkforPracticeAssessmnet() throws Exception {
		logger.info("INST2004_VerifyDirectorcanSaveBenchmarkforPracticeAssessmnet Start");
		log(logger, "INST2004_VerifyDirectorcanSaveBenchmarkforPracticeAssessmnet Start");

		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.faculty.login.director.user.name.benchmarkpage"),
				PropertiesRepository.getString("id.faculty.login.director.Password.benchmarkpage"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Left Navigation Link");
		VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Products tab");
		homePage.clikOnLeftNavLink(1);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger,"Verify if Products page is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.products.page.firstTab.loc", 0));

		// Syed.Pasha[5th Sept 2018] : Commented because this functionality is removed 
	/*	log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Alert Toast Message");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.toast.message.loc"), false));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
*/
		log(logger, "Clicking on Set Benchmark");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.products.set.benchmarks"), true));
		
		loginPage.switchToCardShadowFrame();
		
		log(logger, "Clicking on Practice Assessment Tab and Verify if Practice Assessment Tab is selected");
		VerificationHandler.verifyTrue(productsPage.clickPracticeAssessmentForSetBenchMark(0));
				
		log(logger, "Clicking on benchmark edit field");
		productsPage.clickButton(PropertiesRepository.getString("setbenchmark.practice.edit.field.new"), 0);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger,"to verify 'Bench Mark text field','Reset to Default button','Bench Mark type','Save for all assessments check box','Save and Cancel button'");
		VerificationHandler.verifyTrue(productsPage.checkFieldsOnSetBenchMarkPopUpPractice("Benchmark Type:", "Individual %","Save for all assessments"));

		log(logger, "Set a benchmark value, Click on Save and Verify if the Edited marks are displayed under 'Bench Mark' ");
		VerificationHandler.verifyTrue(productsPage.setBenchMarkPracticeValue());
		
		logger.info("INST2004_VerifyDirectorcanSaveBenchmarkforPracticeAssessmnet Ends");
		log(logger, "INST2004_VerifyDirectorcanSaveBenchmarkforPracticeAssessmnet Ends");
	}

	//@TestAnnotations(testID = "INST-2003")
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "INST-2003:Verify that 'Director' can save benchmark for proctor asessment::Set Benchmark")
	public void INST2003_VerifyDirectorcanSaveBenchmarkforProctorAssessmnet() throws Exception {
		
		logger.info("INST2003_VerifyDirectorcanSaveBenchmarkforProctorAssessmnet Start");
		log(logger, "INST2003_VerifyDirectorcanSaveBenchmarkforProctorAssessmnet Start");
		// loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.director.user.name"),
		// PropertiesRepository.getString("id.faculty.login.director.Password"));
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.faculty.login.director.user.name.benchmarkpage"),
				PropertiesRepository.getString("id.faculty.login.director.Password.benchmarkpage"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Products tab");
		homePage.clikOnLeftNavLink(1);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger,"Verify if Products page is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.products.page.firstTab.loc", 0));

		// Syed.Pasha[5th Sept 2018] : Commented because this functionality is removed 
		/*log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Alert Toast Message");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.toast.message.loc"), false);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));*/

		log(logger, "Clicking on Set Benchmark");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.products.set.benchmarks"), true));

		loginPage.switchToCardShadowFrame();
		
		log(logger, "Clicking on Proctor Assessment Tab and Verify if Proctor Assessment Tab is selected");
		VerificationHandler.verifyTrue(productsPage.clicProctoAssessmentForSetBenchMark(0));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on benchmark edit field");
		productsPage.clickButton(PropertiesRepository.getString("setbenchmark.practice.edit.field.new"), 0);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));		

		log(logger,"Setting value in Benchmark popup");
		VerificationHandler.verifyTrue(productsPage.checkFieldsOnSetBenchMarkPopUpProctor());

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Set a benchmark value, Click on Save and Verify if the Edited marks are displayed under 'Bench Mark' ");
		VerificationHandler.verifyTrue(productsPage.setBenchMarkPracticeValue());

		logger.info("INST2003_VerifyDirectorcanSaveBenchmarkforProctorAssessmnet Ends");
		log(logger, "INST2003_VerifyDirectorcanSaveBenchmarkforProctorAssessmnet Ends");
	}

}
