package com.automation.id.help;

import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HelpPage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HelpPageTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HelpPage helpPage;
	private HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		helpPage = new HelpPage(driver);
		homePage = new HomePage(driver);
	}

	@TestAnnotations(testID = "INST-1594")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify the tile Website Basics under faculty help tab.")
	public void INST1594_VerifyWebSiteBasics() throws Exception {
		logger.info("INST1594_VerifyWebSiteBasics Start");
		log(logger, "INST1594_VerifyWebSiteBasics Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hlp.instuctor1.username"),
				PropertiesRepository.getString("id.auto.hlp.instuctor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Website Basics Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessage(PropertiesRepository.getString("id.help.website.basics.name"),
						PropertiesRepository.getString("id.help.website.basics.message")),
				"Unable to verify Website message");
		
		log(logger, "INST1594_VerifyWebSiteBasics End");
		logger.info("INST1594_VerifyWebSiteBasics End");

	}

	@TestAnnotations(testID = "INST-1595")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1595:Verify the tile Product and Integration under faculty help tab.::Smoke Test Suite")
	public void INST1595_VerifyProdAndIntegration() throws Exception {
		logger.info("INST1595_VerifyProdAndIntegration Start");
		log(logger, "INST1595_VerifyProdAndIntegration Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hlp.instuctor1.username"),
				PropertiesRepository.getString("id.auto.hlp.instuctor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "click on Resources   tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Website Basics Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessage(PropertiesRepository.getString("id.help.product.name"),
						PropertiesRepository.getString("id.help.product.message")),
				"Unable to verify Product and Integration message");
		
		log(logger, "INST1595_VerifyProdAndIntegration End");
		logger.info("INST1595_VerifyProdAndIntegration End");
	}

	@TestAnnotations(testID = "INST-1596")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1596:Verify the tile Assessment under faculty help tab.::Smoke Test Suite")
	public void INST1596_VerifyAssessment() throws Exception {
		logger.info("INST1596_VerifyAssessment Start");
		log(logger, "INST1596_VerifyAssessment Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hlp.instuctor1.username"),
				PropertiesRepository.getString("id.auto.hlp.instuctor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		/*
		 * log(logger, "Clicking on Help Link"); homePage.clickOnText("Resources");
		 */

		log(logger, "click on Resources   tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Assessments & Focused Review ");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessageContains(PropertiesRepository.getString("id.help.assessment.name"),
						PropertiesRepository.getString("id.help.assessment.message")),
				"Unable to verify Assessment message");
		
		log(logger, "INST1596_VerifyAssessment End");
		logger.info("INST1596_VerifyAssessment End");
	}

}