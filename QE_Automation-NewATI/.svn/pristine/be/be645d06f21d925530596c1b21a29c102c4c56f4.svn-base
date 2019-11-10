package com.automation.newati.helptab;

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
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyHelpPageTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private HelpPage helpPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		helpPage = new HelpPage(driver);
		tutorialPage=new TutorialPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-46")
	@Test(priority=2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify if student is navigated to 'Help Tab'.::Help Tab")
	public void  NewATI46_verifyHelpPageTab() throws Exception {
		log(logger,"NewATI46_verifyHelpPageTab Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		log(logger, "Help Tab is displayed ");
		
		log(logger,"verify help tab message");
		boolean result=homePage.verifyMessage(PropertiesRepository.getString("new-atitesting.my.help.heading"), PropertiesRepository.getString("new-atitesting.help.tab.link"));
		
		VerificationHandler.verifyTrue(result,"unable to navigete to help page");
		log(logger,"NewATI46_verifyHelpPageTab End");
	}
	
	@TestAnnotations(testID="NewATI-52")
	@Test(priority=3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify the availability of FAQs in FAQs section.::Help Tab")
	public void NewATI52_verifyHelpTabFAQverifyFAQSectionInFAQ() throws Exception {
		log(logger,"NewATI52_verifyHelpTabFAQverifyFAQSectionInFAQ Start");
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		tutorialPage.waitForAwhile(50000);
		log(logger,"verify help tab FAQ headers");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSectionHeaders());
		
		
		log(logger,"verify  help tab FAQ Links");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
		
		log(logger,"NewATI52_verifyHelpTabFAQverifyFAQSectionInFAQ End");
	}
}
