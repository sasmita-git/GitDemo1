package com.automation.newati.smoke;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class SmokeTest5  extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private TutorialPage tutorialPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TextHandler textHandler;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		tutorialPage = new TutorialPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		textHandler = new TextHandler(driver);
	}
	
	@TestAnnotations(testID="NewATI-775")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Smoke", "Regression"}, description="Verify student login page to mirror new faculty login page::LoginPage")
	 public void NewATI775_VerifyFacultyCredentialLoginErrorMessage() throws Exception
	 {
	  log(logger, "NewATI_VerifyFacultyCredentialLogin start");
	  //loginPage.enterURL("newati.login.url");
	  loginPage.invalidLoginToApplication(PropertiesRepository.getString("newati.facultyportal.username"), PropertiesRepository.getString("newati.facultyportal.password"));
	  homePage.waitUntillElementIsVisible(PropertiesRepository.getString("newati.login.error.message.loc"));
	   String errormessage=textHandler.getText(PropertiesRepository.getString("newati.login.error.message.loc"));
	   System.out.println(errormessage);
	  VerificationHandler.verifyEquals(errormessage, PropertiesRepository.getString("newati.error.message"));
	  homePage.clickButton(PropertiesRepository.getString("newati.login.error.message.loc"));
	   log(logger, "NewATI_VerifyFacultyCredentialLogin end");
	  
	 }



}
