package com.automation.id.peopletab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.PeopleTabPage;
import com.jaca.TestAnnotations;

public class PeopleTabTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	PeopleTabPage peopleTabPage;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		peopleTabPage=new PeopleTabPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
	}
	
	@TestAnnotations(testID="INST-1681")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify navigation to 'Report Group' page.")
	public void INST1681_verifyNavigationtoReportGroupPage() throws Exception {
		logger.info("INST1681_verifyNavigationtoReportGroupPage Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on people tab");
		loginPage.clickElement("id.homepage.main.menu.list",5);
		
		/*log(logger, "click on Report Groups tab");
		peopleTabPage.clickButtonFromList("id.homepage.people.report.groups.tab.loc",1);*/
		
		boolean result=peopleTabPage.isElementSelected(PropertiesRepository.getString("id.homepage.people.report.groups.tab.loc"),1);
		VerificationHandler.verifyTrue(result, "Element is not selected");
		
		
		logger.info("INST1681_verifyNavigationtoReportGroupPage End");
	}
	
	@TestAnnotations(testID="INST-1682")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify navigation to 'Course Group' page.")
	public void INST1682_verifyNavigationtoCourseGroupPage() throws Exception {
		logger.info("INST1682_verifyNavigationtoCourseGroupPage Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on people tab");
		loginPage.clickElement("id.homepage.main.menu.list",5);
		
		/*log(logger, "click on Report Groups tab");
		peopleTabPage.clickButtonFromList("id.homepage.people.report.groups.tab.loc",2);
		*/
		boolean result=peopleTabPage.isElementSelected(PropertiesRepository.getString("id.homepage.people.report.groups.tab.loc"),2);
		VerificationHandler.verifyTrue(result, "Element is not selected");
		
		logger.info("INST1682_verifyNavigationtoCourseGroupPage End");
	}
	
	
	@TestAnnotations(testID="INST-1683")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify navigation to 'User Setting' page.")
	public void INST1683_verifyNavigationtoUserSettingPage() throws Exception {
		logger.info("INST1683_verifyNavigationtoUserSettingPage Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on people tab");
		loginPage.clickElement("id.homepage.main.menu.list",5);
		
		/*log(logger, "click on Report Groups tab");
		peopleTabPage.clickButtonFromList("id.homepage.people.report.groups.tab.loc",0);*/
		
		boolean result=peopleTabPage.isElementSelected(PropertiesRepository.getString("id.homepage.people.report.groups.tab.loc"),0);
		VerificationHandler.verifyTrue(result, "Element is not selected");
		
		logger.info("INST1683_verifyNavigationtoUserSettingPage End");
	}
	
	
}


