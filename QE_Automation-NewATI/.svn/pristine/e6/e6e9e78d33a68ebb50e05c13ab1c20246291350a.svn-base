package com.automation.newati.smoke;

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

public class SmokeTest2 extends BaseTest {

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
		tutorialPage = new TutorialPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.learn.tab.user.name.helptab"), PropertiesRepository.getString("newati.login.learn.tab.password"));
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
		
		log(logger,"verify help tab FAQ headers");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSectionHeaders());
		
		log(logger,"verify  help tab FAQ Links");
		VerificationHandler.verifyTrue(helpPage.verifyFAQSection());
		
		log(logger,"NewATI52_verifyHelpTabFAQverifyFAQSectionInFAQ End");
	}
	@TestAnnotations(testID="NewATI1-154")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = "{Smoke}", description="Content Area functionality::My ATI")
	public void NewATI154_VerifyContentAreaFunctionality() throws Exception 
	{
		log(logger, "NewATI154_VerifyContentAreaFunctionality: Start");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		
		log(logger, "Selecting valu in DropDown List ");
		//tutorialPage.selectValueBySelectClass("new-atitesting.homepage.myatitab.contentarea.dropdown.loc","new-atitesting.homepage.myatitab.contentarea.dropdown.value","new-atitesting.homepage.myatitab.contentarea.dropdown.options.loc");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"));
		log(logger, "Verify content in Learn Tab ");
		VerificationHandler.verifyTrue(tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.learn.tab")), "Learn Tab Content is not validated");
		
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		
		log(logger, "Verify Content of Test Tab ");
		VerificationHandler.verifyTrue(tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.Test.tab")), "Validation is fail for Test Tab Content");
		
		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);
		
		log(logger, "Verify Content of Apply Tab ");
		VerificationHandler.verifyTrue(tutorialPage.VerifyTabContent(PropertiesRepository.getString("new-atitesting.homepage.apply.tab")), "Validation is fail for Apply Tab Content");
		
		log(logger, "NewATI154_VerifyContentAreaFunctionality: end ");
		
	}
	@TestAnnotations(testID="NewATI-538")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups="{Smoke}", description="Validate that an existing user is able to login to the application::LoginPage")
	public void NewATI538_ValidateLoginWithExistingUser() throws Exception {
		log(logger, "NewATI538_ValidateLoginWithExistingUser Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.login"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Verifying Learn Tab");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.learn.type.section")), "Unable to verify Learn Tab ");
		
		log(logger, "Clicking Test Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.test.tab.new.loc"));
		
		log(logger, "Verifying Test Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.test.view.section")), "Unable to verify Test Tab ");
		
		log(logger, "Clicking Improve Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.improve.tab"));
		
		log(logger, "Verifying Improve Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.improve.type.section")), "Unable to verify Improve Tab ");

		log(logger, "Clicking Apply Tab");
		myATITabMainPage.clickButton(PropertiesRepository.getString("new-atitesting.apply.tab"));
		
		log(logger, "Verifying Apply Tab");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.apply.type.section")), "Unable to verify Apply Tab ");

		log(logger, "Clicking on MyResults Tab");
		homePage.clickTab(2);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.results.heading")), "Unable to verify My Results Tab ");
		
		log(logger, "Clicking on Help Tab");
		homePage.clickTab(3);
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.my.help.heading")), "Unable to verify My Help Tab ");
		
		log(logger, "NewATI538_ValidateLoginWithExistingUser End");
	}

}





