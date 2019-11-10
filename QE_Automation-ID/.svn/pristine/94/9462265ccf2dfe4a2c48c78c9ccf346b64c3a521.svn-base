package com.automation.id.smoke;

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

public class Smoke_HelpPageTest extends BaseTest {
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
			"Smoke" }, description = "Smoke_HelpPageTest :: Verify the tile Website Basics under faculty help tab")
	
	public void INST1594_VerifyResourceBasics() throws Exception {
		logger.info("INST1594_VerifyResourceBasics Start");
		log(logger, "INST1594_VerifyResourceBasics Start");
		
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

		//****
		//Validate Website Basics tile
		//****
		log(logger, "Verifying Website Basics Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.website.basics.name"),
						PropertiesRepository.getString("id.help.website.basics.message")),
				"Unable to verify Website message");
		
		//****
		//Validate Proctoring tile
		//****
		log(logger, "Verifying Proctoring Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.proctoring.name"),
						PropertiesRepository.getString("id.help.proctoring.message")),
				"Unable to verify Proctoring message");

		//****
		//Validate eBooks & Active Learning tile
		//****
		log(logger, "Verifying eBooks & Active Learning Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.ebooks.name"),
						PropertiesRepository.getString("id.help.ebooks.message")),
				"Unable to verify eBooks & Active Learning Help message");
		
		//****
		//Validate Products & Integration tile
		//****
		log(logger, "Verifying Products & Integration message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.product.name"),
						PropertiesRepository.getString("id.help.product.message")),
				"Unable to verify Product and Integration message");
		
		//****
		//Validate Assessments & Focused Review tile
		//****
		log(logger, "Verifying Assessments & Focused Review message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.assessment.name"),
						PropertiesRepository.getString("id.help.assessment.message")),
				"Unable to verify Assessment message");
		
		//****
		//Validate Research tile
		//****
		log(logger, "Verifying Research message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.research.name"),
						PropertiesRepository.getString("id.help.research.message")),
				"Unable to verify Research message");
		
		//****
		//Validate Professional Development tile
		//****
		log(logger, "Verifying Professional Development message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.prodev.name"),
						PropertiesRepository.getString("id.help.prodev.message")),
				"Unable to verify Professional Development message");
		
		//****
		//Validate Best Practices tile
		//****
		log(logger, "Verifying Best Practices message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpPageTiles(PropertiesRepository.getString("id.help.bestpractices.name"),
						PropertiesRepository.getString("id.help.bestpractices.message")),
				"Unable to verify Best Practices message");
						
		log(logger, "INST1594_VerifyResourceBasics End");
		logger.info("INST1594_VerifyResourceBasics End");

	}

}
