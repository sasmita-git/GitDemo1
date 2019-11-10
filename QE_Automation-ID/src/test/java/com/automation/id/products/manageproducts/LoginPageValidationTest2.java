package com.automation.id.products.manageproducts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class LoginPageValidationTest2 extends BaseTest{

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		
	}
	
	
	@TestAnnotations(testID="INST-1573")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "inst-1573:Verify Select log-in section buttons state")
	public void  inst1573_verifySelectLoginSectionButtonsState() throws Exception {
		log(logger, "inst1573_verifySelectLoginSectionButtonsState Start");
		
		log(logger, "enter url");
		driver.get(PropertiesRepository.getString("id.ati.login.url"));
		
		log(logger, "click on student login link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.login.loc"), 0);
		
		log(logger, "verify student login header");
		VerificationHandler
		.verifyTrue(loginPage.verifyErrorMessage("id.loginpage.header.loc", "id.login.page.student.login.header"), "Unable to verify Error Message");
		
		driver.navigate().back();
		log(logger, "click on faculty login link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.login.loc"), 1);
		
		log(logger, "verify faculty login header");
		loginPage.verifyErrorMessage("id.loginpage.header.loc", "id.login.page.faculty.login.header");
		
		log(logger, "inst1573_verifySelectLoginSectionButtonsState End");
	}
	
}

