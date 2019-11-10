package com.automation.newati.hometab;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.NewATIBasePage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyHomeTabTest1 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private ApplyTabPage applyTabPage;
	private ImproveTabPage improveTabPage;
	private NewATIBasePage newATIBasepage;
	private CreateAccountPageNewSmoke createAccountPage;
	
	@BeforeMethod(alwaysRun = true) 	
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		tutorialPage = new TutorialPage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		improveTabPage = new ImproveTabPage(driver);
		newATIBasepage = new NewATIBasePage(driver);
		createAccountPage=new CreateAccountPageNewSmoke(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.home"), PropertiesRepository.getString("newati.login.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	@TestAnnotations(testID="NewATI-92")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Verify the functionality of 'Advertisement'::Home Tab")
	public void NewATI92_verifyAdvertisementSection() throws Exception {
		
		log(logger, "NewATI92_verifyAdvertisementSection Start");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean status=tutorialPage.verifyAdvertisementPage();
		VerificationHandler.verifyTrue(status);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"verifying  window size");
		VerificationHandler.verifyTrue(tutorialPage.verifyTabSize());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI92_verifyAdvertisementSection End");
		
	}
	
	@TestAnnotations(testID="NewATI-93")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the functionality of 'User Account' link.::Home Tab")
	public void NewATI93_verifyUserAccountLink() throws Exception {
		
		log(logger, "NewATI93_verifyUserAccountLink Start");
		
		log(logger,"click on  account link");
		tutorialPage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);
		
		log(logger,"verifying  account link");
		tutorialPage.verifyMessage(PropertiesRepository.getString("new-atitesting.user.account.link.header.loc"), PropertiesRepository.getString("new-atitesting.user.account.link.header"));
		
		log(logger, "NewATI93_verifyUserAccountLink	 End");
		
	}
	@TestAnnotations(testID="NewATI-94")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description = "Verify the functionality of 'Sign Out' link.::Home Tab")
	public void NewATI94_verifySignOutLink() throws Exception {
		
		log(logger, "NewATI94_verifySignOutLink Start");
		
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.forgot.password.link"));
		log(logger, "NewATI94_verifySignOutLink	 End");
		
	}

	@TestAnnotations(testID="NewATI-95")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "NewATI-95:Home Page- Recent Activity Display::Home Tab")
	public void NewATI95_HomePageRecentActivityDisplay() throws Exception {
		
		log(logger, "NewATI95_HomePageRecentActivityDisplay Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Test Tab");
		homePage.clickSubTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment Name");
		log(logger, "Click on assessment");
		practiceAssessmentPage.clickTestTabAssessmentButton("Practice Assessment", "ATI-ASMT-CPNP");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.takeTestTEAS(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 2");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 3");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment 4");
		tutorialPage.takeTest(false, false, false, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(tutorialPage.verifyIPPHeaderAndClickCloseButton(),"Unable to verify IPP Header and clicking on Close button");
		log(logger, "Verifying IPP Header");
		createAccountPage.clickOnButton("new-atitesting.focusreview.button.loc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify recent activity name");
		boolean result=homePage.verifyRecentActivity1("ATI-ASMT-CPNP");
		VerificationHandler.verifyTrue(result, "Recent activity is not displayed");
		
//		log(logger, "Taking Assessment");
//		tutorialPage.takeTest(false, true, true, false);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Clicking on Close Button");
//		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI95_HomePageRecentActivityDisplay End");
}
	
	@TestAnnotations(testID="NewATI-82")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Page - Calendar::Home Tab")
	public void NewATI82_HomePageCalendar() throws Exception {
		
		log(logger, "NewATI82_HomePageCalendar Start");
//		homePage.scrollDownPage();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on full page calendar link");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.link.nonpulse"));
		
		log(logger, "verify full page calendar objects");
		boolean verifyCalendarObjects = tutorialPage.verifyCalendarObjects();
		VerificationHandler.verifyTrue(verifyCalendarObjects);
		
		log(logger, "verify year length");
		boolean verifyCalendarYear = tutorialPage.verifyCalendarYear();
		VerificationHandler.verifyTrue(verifyCalendarYear);
		
		log(logger, "verify previous year navigation");
		boolean verifyYearNavigation = tutorialPage.verifyPreviousYearNavigation();
		VerificationHandler.verifyTrue(verifyYearNavigation);
		
		log(logger, "verify next year navigation");
		boolean verifyNextYearNavigation = tutorialPage.verifyNextYearNavigation();
		VerificationHandler.verifyTrue(verifyNextYearNavigation);
		
		log(logger, "verify months header names");
		boolean verifyCalendarWeekNames = tutorialPage.verifyCalendarWeekNames();
		VerificationHandler.verifyTrue(verifyCalendarWeekNames);
		
		boolean verifyAssignments = tutorialPage.verifyAssignments();
		VerificationHandler.verifyTrue(verifyAssignments);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on close button");
		loginPage.clickButton(PropertiesRepository.getString("newati.assessment.close.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on week tab");
		tutorialPage.clickButtonFromList("new-atitesting.homepage.full.page.calendar.month.button.loc", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify weekly table navigation");
		boolean verifyCalendarWeeklyTable = tutorialPage.verifyCalendarWeeklyTable();
		VerificationHandler.verifyTrue(verifyCalendarWeeklyTable);
		
		log(logger, "verify week header names");
		boolean verifyCalendarWeekNames1 = tutorialPage.verifyCalendarWeekHeaderNames();
		VerificationHandler.verifyTrue(verifyCalendarWeekNames1);
		
		
		log(logger, "NewATI82_HomePageCalendar End");
	}
	
	@TestAnnotations(testID="NewATI-524")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-524:Verify for news section displaying in descending order of publish date_STU-4048")
	public void NewATI524_VerifyNewsdateInDescending() throws Exception {
		
		log(logger, "NewATI524_VerifyNewsdateInDescending Start");
		newATIBasepage.clikButtonUsingJavaScript(PropertiesRepository.getString("new-atitesting.news.seemore.loc"));
        List<Calendar> allDateList = applyTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.home.news.date.loc"));
        VerificationHandler.verifyTrue(improveTabPage.isDateSortedInAscendingOrder(allDateList));
		log(logger, "NewATI524_VerifyNewsdateInDescending	 End");
		
	}
}
