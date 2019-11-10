package com.automation.newati.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest1 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity58"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-58")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Page: Recent Activity::Home Tab")
	public void NewATI58_verifyRecentActivitySection() throws Exception {
		
		log(logger, "NewATI58_verifyRecentActivitySection Start");
		
		log(logger, "verify recent activity name");
		boolean result=homePage.verifyRecentActivity1("Item Type Regression Test (OP)");
		VerificationHandler.verifyTrue(result, "Recent activity is not displayed");
		
		log(logger, "verify recent activity status");
		boolean status=homePage.verifyRecentActivityPresentStatus();
		VerificationHandler.verifyTrue(status, "Recent activity status is not displayed");
		
		log(logger, "NewATI58_verifyRecentActivitySection End");
	}
	@TestAnnotations(testID="NewATI-494")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Page Footer- Update Copyright to 2017::Home Tab")
	public void NewATI494_VerifyPageFooter() throws Exception {
		log(logger, "NewATI494_VerifyPageFooter Start");
		
		log(logger, "Verifying Footer");
		VerificationHandler.verifyTrue(homePage.verifyFooter(), "Unable to verify Footer message");
		log(logger, "NewATI494_VerifyPageFooter Start");
	}
	@TestAnnotations(testID="NewATI-7")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Tab UI Element verification::Home Tab")
	public void NewATI7_verifyHomeTabUIElements() throws Exception {
		
		log(logger, "NewATI7_verifyHomeTabUIElements Start");
		
		log(logger, "verify logo image");
		boolean isLogoDisplayed=homePage.verifyLogo("new-atitesting.logo.loc");
		VerificationHandler.verifyTrue(isLogoDisplayed, "Logo is not displayed");
		
		log(logger, "verify home tab upper links");
		boolean status=homePage.verifyHomeTabTopLinks();
		VerificationHandler.verifyTrue(status, "home tab upper links are not displayed");
		
		log(logger, "verify home tab links");
		boolean status0=homePage.verifyHomeTabLinks();
		VerificationHandler.verifyTrue(status0, "home tab names are not displayed");
		
		log(logger, "verify home tab bottom links");
		boolean status1=homePage.verifyHomeTabBottomLinks();
		VerificationHandler.verifyTrue(status1, "home tab bottom links are not displayed");
		
		log(logger, "NewATI7_verifyHomeTabUIElements End");
		
	}
	
	@TestAnnotations(testID="NewATI-11")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verifying the navigation's of all Tabs , SubTabs and Links::General")
	public void NewATI11_verifyNavigatinOfAllTabs() throws Exception {
		
		log(logger, "NewATI11_verifyNavigatinOfAllTabs Start");
		
		log(logger, "verify logo image");
		boolean isLogoDisplayed=homePage.verifyLogo("new-atitesting.logo.loc");
		VerificationHandler.verifyTrue(isLogoDisplayed, "Logo is not displayed");
		
		log(logger, "verify home tab upper links");
		boolean status=homePage.verifyHomeTabTopLinks();
		VerificationHandler.verifyTrue(status, "home tab upper links are not displayed");
		
		log(logger, "verify home tab links");
		boolean status0=homePage.verifyHomeTabLinks();
		VerificationHandler.verifyTrue(status0, "home tab names are not displayed");
		
		log(logger, "verify home tab bottom links");
		boolean status1=homePage.verifyHomeTabBottomLinks();
		VerificationHandler.verifyTrue(status1, "home tab bottom links are not displayed");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		
		boolean resutlt=tutorialPage.isElementDisplayed("new-atitesting.refresh.proctors.loc");
		VerificationHandler.verifyTrue(resutlt);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		
		log(logger, "Click on focused review product");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		
		log(logger, "Select Tutorial from the dropdown");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		
		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);
		
		boolean resutlt1=tutorialPage.isElementDisplayed("new-atitesting.applytab.disable.product.checkbox");
		VerificationHandler.verifyTrue(resutlt1);

		log(logger,"click on MY Results tab");
		homePage.clickTab(2);
		
		log(logger,"click on help tab");
		homePage.clickTab(3);
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		
		log(logger, "NewATI11_verifyNavigatinOfAllTabs End");
		
	}
	@TestAnnotations(testID="NewATI-92")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify the functionality of 'Advertisement'::Home Tab")
	public void NewATI92_verifyAdvertisementSection() throws Exception {
		
		log(logger, "NewATI92_verifyAdvertisementSection Start");
		
		boolean status=tutorialPage.verifyAdvertisementPage();
		VerificationHandler.verifyTrue(status);
		
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		
		log(logger, "NewATI92_verifyAdvertisementSection End");
		
	}

	
	@TestAnnotations(testID="NewATI-95")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Page- Recent Activity Display::Home Tab")
	public void NewATI95_HomePageRecentActivityDisplay() throws Exception {
		
		log(logger, "NewATI95_HomePageRecentActivityDisplay Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
			
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		
		log(logger, "Select Practice Assessment Name");
		practiceAssessmentPage.clickAssessment(PropertiesRepository.getString("faculty.portal.testtab.assessment.name"));

		log(logger, "Taking Assessment");
		tutorialPage.takeTest(false, true, true, false);
		
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI95_HomePageRecentActivityDisplay End");
}
}



