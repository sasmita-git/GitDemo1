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

public class SmokeTest15 extends BaseTest {

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
		loginPage.loginToApplication(PropertiesRepository.getString("new.atitesting.calender.user"), PropertiesRepository.getString("newati.login.pulse.user.password"));
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	
	@TestAnnotations(testID="NewATI-82")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke"}, description = "Home Page - Calendar::Home Tab")
	public void NewATI82_HomePageCalendar() throws Exception {
		
		log(logger, "NewATI82_HomePageCalendar Start");
		Thread.sleep(5000);
		
		log(logger, "Click on full page calendar link");
		tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.link"));
		
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
		
		log(logger, "click on close button");
		tutorialPage.clickButtonFromList("newati.payment.mypurchase.order.close.button3",0);
		
		log(logger, "click on week tab");
		tutorialPage.clickButtonFromList("new-atitesting.homepage.full.page.calendar.month.button.loc", 1);
		
		log(logger, "verify weekly table navigation");
		boolean verifyCalendarWeeklyTable = tutorialPage.verifyCalendarWeeklyTable();
		VerificationHandler.verifyTrue(verifyCalendarWeeklyTable);
		
		log(logger, "verify week header names");
		boolean verifyCalendarWeekNames1 = tutorialPage.verifyCalendarWeekHeaderNames();
		VerificationHandler.verifyTrue(verifyCalendarWeekNames1);
		
		
		log(logger, "NewATI82_HomePageCalendar End");
	}
	
}

