package com.automation.newati.helptab;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.jaca.TestAnnotations;

public class VerifyHelpPageRegressionTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private HelpPage helpPage;
	
	
	@BeforeMethod(alwaysRun = true)	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		helpPage = new HelpPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-12")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-12:Help Tab-FAQ verifications.::Help Tab")
	public void NewATI12_verifyHelpFAQSection() throws Exception {
		log(logger,"NewATI12_verifyHelpFAQSection Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		helpPage.verifyHeader("new-atitesting.homePage.faq.section.header.loc","new-atitesting.homePage.faq.section.header.name");
		
		VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.clickButton(".help-faq-question.focused-element-flag.more-icon");
		homePage.scrollUpPage();
		homePage.clickButton(".help-faq-question.focused-element-flag.more-icon p", 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickButton(".help-faq-question.focused-element-flag.more-icon p", 0);
		log(logger,"get browser details from help pag");
		Map<String, String> compareTechnicalRequirements = helpPage.getBrowserDetailsFromHelpPage();
		
		log(logger,"get device details from help page");
		Map<String, String> deviceDetailsFromHelpPage = helpPage.getDeviceDetailsFromHelpPage();
		
		log(logger,"click on home tab");
		homePage.clickTab(0);
		
		log(logger,"click on technical requirement link in the homepage");
		homePage.clickButton(".tech-requirements-area a");
		
		log(logger,"get browser details from homess page");
		Map<String, String> browserDetailsFromHomePage = helpPage.getBrowserDetailsFromHomePage();
		
		log(logger,"get device details from home page");
		Map<String, String> deviceDetailsFromHomePage = helpPage.getDeviceDetailsFromHomePage();
		
		VerificationHandler.verifyFalse(helpPage.compareTechnicalRequirements(compareTechnicalRequirements,deviceDetailsFromHelpPage,browserDetailsFromHomePage,deviceDetailsFromHomePage));
		log(logger,"NewATI12_verifyHelpFAQSection End");
	}
	
	
	@TestAnnotations(testID="NewATI-87")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "Help Tab: How to Use ATI")
	public void NewATI87_verifyHowToHowToUseATISection() throws Exception {
		log(logger,"NewATI87_verifyHowToHowToUseATISection Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		
		log(logger,"verifying help tab links");
		VerificationHandler.verifyTrue(helpPage.verifyLinks(PropertiesRepository.getString("new-atitesting.helptab.links.loc")));
		
		log(logger,"verifying pdf links");
		helpPage.verifyPdfLinks("new-atitesting.helptab.pdf.links.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"verifying video links");
		helpPage.verifyVideoLinks("new-atitesting.helptab.video.links.loc");
		
		log(logger,"NewATI87_verifyHowToHowToUseATISection End");
	}
	
	@TestAnnotations(testID="NewATI-90")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"},  description = "Help Tab: FAQs")
	public void NewATI90_verifyHelpTabFAQ() throws Exception {
		log(logger,"NewATI90_verifyHelpTabFAQ Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verify help tab FAQ headers");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSectionHeaders());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verify  help tab FAQ Links");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
		
		log(logger,"NewATI90_verifyHelpTabFAQ End");
	}
	
	@TestAnnotations(testID="NewATI-506")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"},  description = "Verification for availability of 'How To Documents' sub section under FAQ section")
	public void NewATI506_verifyHowToDocumentFAQ() throws Exception {
		log(logger,"NewATI506_verifyHowToDocumentFAQ Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		
		log(logger,"verify help tab FAQ headers");
		helpPage.verifyHowToSectionLinks();
		
		log(logger,"NewATI506_verifyHowToDocumentFAQ End");

	}
	
	@TestAnnotations(testID="NewATI-13")
	@Test(priority = 5,alwaysRun = true, enabled = true, groups = {"Regression"},  description = "NewATI-13:Help Tab-How to Use ATI verifications::Help Tab")
	public void NewATI13_verifyHowToHowToUseATIverifications() throws Exception {
		log(logger,"NewATI13_verifyHowToHowToUseATIverifications Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify getting started header ");
		String textFromList = helpPage.getTextFromLst(PropertiesRepository.getString("new-atiteting.faq.getting.started.all.links"),0);
		VerificationHandler.verifyEquals(textFromList.trim(),PropertiesRepository.getString("new-atiteting.faq.getting.started.header"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying help tab links");
		VerificationHandler.verifyTrue(helpPage.verifyLinks(PropertiesRepository.getString("new-atitesting.helptab.links.loc")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying pdf links");
		helpPage.verifyPdfLinks("new-atitesting.helptab.pdf.links.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying video links");
		helpPage.verifyVideoLinks("new-atitesting.helptab.video.links.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"NewATI13_verifyHowToHowToUseATIverifications End");
	}
	
	@TestAnnotations(testID="NewATI-48")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-48:Verify the availability of FAQs section.")
	public void NewATI48_verifyFAQSection() throws Exception {
		log(logger,"Verify FAQ Section Section Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);

		log(logger, "Successfully Verified FAQ Section ");
		VerificationHandler.verifyTrue(helpPage.verifyfaqSection(),"Unable to find Faq section");
		
		log(logger,"Verify FAQ Section Section End");

	}
	
	@TestAnnotations(testID="NewATI-505")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-505:Verification for 'Getting Started with ATI' section under Help tab.")
	public void NewATI505_verifyGettingStartedSection() throws Exception {
		log(logger,"NewATI505_verifyGettingStartedSection method Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);

		log(logger, "Successfully Verified FAQ Section ");
		boolean verifyHeader = helpPage.verifyHeader("new-atiteting.faq.getting.started.section.loc", "new-atiteting.faq.getting.started.header");
		VerificationHandler.verifyTrue(verifyHeader,"Unable to find Faq section");
		
		log(logger, "verify getting started header ");
		String textFromList = helpPage.getTextFromLst(PropertiesRepository.getString("new-atiteting.faq.getting.started.all.links"),0);
		VerificationHandler.verifyEquals(textFromList.trim(),PropertiesRepository.getString("new-atiteting.faq.getting.started.header"));

		log(logger,"NewATI505_verifyGettingStartedSection method End");
	}
	
	@TestAnnotations(testID="NewATI-529")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-529:Verify the order of Getting started with ATI section :STU-3637.")
	public void NewATI529_verifyGettingStartedSection() throws Exception {
		log(logger,"NewATI529_verifyGettingStartedSection method Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);

		boolean verifyHelpPageLinks = helpPage.verifyHelpPageLinks(PropertiesRepository.getString("new-atiteting.faq.getting.started.all.links"));
		VerificationHandler.verifyTrue(verifyHelpPageLinks,"getting started section is not displayed");
		
		log(logger,"NewATI529_verifyGettingStartedSection method End");

	}
}

