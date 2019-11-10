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

public class HelpPageTest2 extends BaseTest {
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

	@TestAnnotations(testID = "INST-1591")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify proctoring document in help tab.::Regression Test Suite")
	public void INST1591_VerifyProctorDocumet() throws Exception {
		logger.info("INST1591_VerifyProctorDocumet Start");
		log(logger, "INST1591_VerifyProctorDocumet Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help & Resources Link");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");

		log(logger, "Verifying Proctoring Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessageContains(PropertiesRepository.getString("id.help.proctoring.name"),
						PropertiesRepository.getString("id.help.proctoring.message")),
				"Unable to verify proctoring message");

		log(logger, "Clicking on Proctoring");
		VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 1, true), "Unable to click on Proctoring");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying an Assessment irreularities link");
		VerificationHandler.verifyTrue(homePage.verifyTextEquals(
				PropertiesRepository.getString("id.help.resource.contents"),
				PropertiesRepository.getString("id.help.proctoring.assessment.irregularities.and.misconduct"), 0));

		log(logger, "clicking on '+' icon for Assessment irreularities links");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 0);
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an proctor training link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.proctoring.proctor.training.videos"), 1));

		log(logger, "clicking on '+' icon for proctor training link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 1);
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an proctor and test security link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.proctoring.proctor.and.test.security.manuals"), 2));
		
		log(logger, "clicking on '+' icon for proctor and test security link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 2);

		log(logger, "INST1591_VerifyProctorDocumet Ends");
		logger.info("INST1591_VerifyProctorDocumet Ends");
	}

	@TestAnnotations(testID = "INST-1592")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify ebooks and Active Learning document in help tab.::Regression Test Suite")
	public void INST1592_VerifyebookandActiveLearning() throws Exception {
		logger.info("INST1592_VerifyebookandActiveLearning Start");
		log(logger, "INST1592_VerifyebookandActiveLearning Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help & Resources Link");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");

		log(logger, "Clicking on ebook and Active Learning Document");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 2, true);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying an EBooks & Media Index link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.ebook.media.index.link"), 0));
		
		log(logger, "clicking on '+' icon for EBooks & Media Index link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 0);
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying an Active Learning Templates link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.ebook.active.learning.template"), 1));
		log(logger, "clicking on '+' icon for EBooks & Media Index link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 1);

		log(logger, "INST1592_VerifyebookandActiveLearning Ends");
		logger.info("INST1592_VerifyebookandActiveLearning Ends");

	}

	@TestAnnotations(testID = "INST-1593")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify professional development document in help tab.::Regression Test Suite")
	public void INST1593_VerifyProfessionalDevelopment() throws Exception {
		logger.info("INST1593_VerifyProfessionalDevelopment Start");
		log(logger, "INST1593_VerifyProfessionalDevelopment Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help & Resources Link");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true),
				"Unable to verify Resources   Link");

		log(logger, "Clicking on professional Development");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 6, true);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an ATI Academy link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.professional.development.ati.academy.link"), 0));
		log(logger, "clicking on '+' icon for ATI Academy links");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 0);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an ATI Champion Training link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.professional.development.ati.champion"), 1));
		log(logger, "clicking on '+' icon ATI Champion Training link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 1);
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an ATI Summit, Conference, Consulation link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextContains(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.professional.development.ati.summit.conference"), 2));
		log(logger, "Clicking on '+' icon on ATI Summit, Conference, Consulation link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 2);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an Educating Nurse link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.professional.development.educating.nurse"), 3));
		log(logger, "Clicking on '+' icon on Educating Nurse link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 3);

		log(logger, "INST1593_VerifyProfessionalDevelopment Ends");
		logger.info("INST1593_VerifyProfessionalDevelopment Ends");

	}

	@TestAnnotations(testID = "INST-1597")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify research materials document in help tab.::Regression Test Suite")
	public void INST1597_VerifyResearchMaterials() throws Exception {
		logger.info("INST1597_VerifyResearchMaterials Start");
		log(logger, "INST1597_VerifyResearchMaterials Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help Link");
		homePage.clikOnLeftNavLink(8);

		log(logger, "Clicking on Research Materials");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 5, true);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an assessment irregularities and misconduct link");
		VerificationHandler.verifyTrue(homePage.verifyTextEquals(
				PropertiesRepository.getString("id.help.resource.contents"),
				PropertiesRepository.getString("id.help.polices.research.assessment.irregularities.and.misconduct"),
				0));
		log(logger, "Clicking on '+' icon on assessment irregularities and misconduct link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 0);

		log(logger, "verifying an research link");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.polices.research"), 1));
		log(logger, "Clicking on '+' icon on research link");
		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 1);

		log(logger, "INST1597_VerifyResearchMaterials Ends");
		logger.info("INST1597_VerifyResearchMaterials Ends");
	}

	/**
	 * Not verifying PDF content. 
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1729")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify ebooks and media index document in help tab.::Regression Test Suite")
	public void INST1729_VerifyebookandMediaIndex() throws Exception {
		logger.info("INST1729_VerifyebookandMediaIndex Start");
		log(logger, "INST1729_VerifyebookandMediaIndex Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help Link");
		homePage.clikOnLeftNavLink(8);

		log(logger, "Verifying ebook and Active Learning Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessageContains(PropertiesRepository.getString("id.help.ebook.active.learning.name"),
						PropertiesRepository.getString("id.help.ebook.active.learning.message")),
				"Unable to verify ebook and Active Learning message");

		log(logger, "Clicking on ebook and Active Learning Document");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 2, true);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify and click '+' icon on ebook media index link");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.help.resource.icon.link"), true));

		log(logger, "Click on any Ebook PDF link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.help.resource.ebook.pdf.link"), 1);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "INST1729_VerifyebookandMediaIndex Ends");
		logger.info("INST1729_VerifyebookandMediaIndex Ends");
	}

	/**
	 * Not verifying PDF. 
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1844")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify Best Practices in help tab.::Regression Test Suite")
	public void INST1844_VerifyBestPractices() throws Exception {
		logger.info("INST1844_VerifyBestPractices Start");
		log(logger, "INST1844_VerifyBestPractices Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.help"),
				PropertiesRepository.getString("id.login.faculty.password.help"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Help Link");
		homePage.clikOnLeftNavLink(8);

		log(logger, "Verifying Best Practice Help message");
		VerificationHandler.verifyTrue(
				helpPage.verifyHelpMessage(PropertiesRepository.getString("id.help.best.practice.name"),
						PropertiesRepository.getString("id.help.best.practice.message")),
				"Unable to verify Best Practice message");

		log(logger, "Clicking Best Practices ");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.help.all.portlets.loc"), 7, true);

		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "verifying an ATI Policy Recommendations");
		VerificationHandler
				.verifyTrue(homePage.verifyTextEquals(PropertiesRepository.getString("id.help.resource.contents"),
						PropertiesRepository.getString("id.help.best.practice.ATI.policy.pdf"), 0));
		log(logger, "Verify and click on '+'icon on ATI Policy Recommendations link");

		loginPage.clickButton(PropertiesRepository.getString("id.help.resource.icon.link"), 0);
		// VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.help.best.practice.ATI.policy"),
		// true));

		log(logger, "Open PDF for ATI Policy Recommendations");
		loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.help.best.practice.ATI.policy.pdf"),
				true);

		log(logger, "INST1844_VerifyBestPractices Ends");
		logger.info("INST1844_VerifyBestPractices Ends");

	}
}