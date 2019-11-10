package com.automation.id.oldtests;

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

public class LoginTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage ;
	HelpPage helpPage;
	
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage=new HomePage(driver);
		helpPage = new HelpPage(driver);
	}
	
	
	@TestAnnotations(testID="INST-1577")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Smoke","Regression"}, description = "Verify features on Login Page::Smoke Test Suite")
	public void INST1577_VerifyFeaturesonLoginPage() throws Exception {
		  logger.info("INST1577_VerifyFeaturesonLoginPage Start");
		  
		  log(logger, "enter login url");
		  loginPage.enterURL(PropertiesRepository.getString("id.url"));
		  
		  log(logger, "Verifying Logo");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.logo"), false), "Unable to verify Logo");
		  
		  log(logger, "Verifying UserName");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.username.loc"), false), "Unable to verify UserName");
		  
		  log(logger, "Verifying Password");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.password.loc"), false), "Unable to verify Password");
		  
		  log(logger, "Verifying Go Button");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.go.button"), false), "Unable to verify Go Button");
		  
		  log(logger, "Verifying Faculty/ Proctor ");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.faculty.proctor.login.loc"), false), "Unable to verify Faculty/ Proctor");
		  
		  log(logger, "Verifying header section in the login page");
		  VerificationHandler.verifyTrue(loginPage.verifyLoginPageHeaders(), "Login page header links are not displayed");
		  
		  log(logger, "Verifying Technical Requirement");
		  VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.tech.requ.loc"), true), "Unable to verify Technical Requirement");
		  
		  log(logger, "Close Technical Requirement");
		  VerificationHandler.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.tech.requ.close.loc"), true), "Unable to Close Technical Requirement");
		  
		  log(logger, "Veriying I am a Student Link");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.i.am.a.student.link.new.loc"), true), "Unable to verify I am a Student link and clicking");
		  
		  String facultyUrl = driver.getCurrentUrl();
		  driver.navigate().back();
		  
		  log(logger, "Verifying Login Header");
		  VerificationHandler
		  .verifyTrue(loginPage.verifyLoginHeader(), "Unable to verify Login Header");
		  
		  log(logger, "Verifying Login Footer");
		  VerificationHandler.verifyTrue(loginPage.verifyLoginFooter(), "Unable to verify Login Footer");
		  
		  logger.info("INST1577_VerifyFeaturesonLoginPage End");
	}
	
	
	/**
	 * Unable to verify BLOG link. It is broken. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1684")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"smoke"}, description = "INST-1684:Online store : Verify that user directing to online store page")
	public void  INST1684_VerifyOnlineStoreNavigation() throws Exception {
		log(logger, "inst-INST1684_VerifyOnlineStoreNavigation Start");
		
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.login.stage.instructor.reportuname"),
				PropertiesRepository.getString("id.login.stage.instructor.reportPwd"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger,"click on three dots on top right corner");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger,"click on online store");
		VerificationHandler
		.verifyTrue(homePage.clickOnTopRightCornerElement(2), "Unable to click on online store");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		loginPage.waitUntillLoadingImageIsAppeared(PropertiesRepository.getString("id.online.store.home.page.not.an.educator.visit.the.student.site.link.loc"));
		
		log(logger,"Verify onlinestore home link");
		VerificationHandler
		.verifyTrue(homePage.VerifyOnLineStoreHome(PropertiesRepository.getString("id.online.store.home.page.header.value")), "Unable to Verify onlinestore home link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "Clicking on ATI Product Solutions header link");
		homePage.verifyAndClick(PropertiesRepository.getString("id.login.onlinestore.header.atiproducts.loc"), true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		VerificationHandler
		.verifyTrue(homePage.verifyMessageWithDefaultSwitch(PropertiesRepository.getString("id.online.store.product.solutions.page.header.loc"), 0, PropertiesRepository.getString("id.online.store.product.solutions.page.header.value")),
				"Unable to verify on ATI Product Solutions header link");
		driver.navigate().back();
		
		log(logger, "Clicking on Events Menu");
		homePage.verifyAndClick(PropertiesRepository.getString("id.online.store.home.page.menu.loc"), 1, true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		homePage.verifyContainsMessageWithDefaultSwitch(PropertiesRepository.getString("id.online.store.events.page.header.loc"), 0, PropertiesRepository.getString("id.online.store.events.page.header.value"));
		driver.navigate().back();
		
		log(logger, "Clicking on About Us Menu");
		homePage.verifyAndClick(PropertiesRepository.getString("id.online.store.home.page.menu.loc"), 2, true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		VerificationHandler
		.verifyTrue(homePage.verifyMessageWithDefaultSwitch(PropertiesRepository.getString("id.online.store.about.us.page.header.loc"), 0, PropertiesRepository.getString("id.online.store.about.us.page.header.value")),
				"Unable to verify on About Us Menu");
		driver.navigate().back();
		
		log(logger, "Clicking on Home link");
		homePage.verifyAndClick(PropertiesRepository.getString("id.login.onlinestore.home.link.loc"), true);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.page.sidebar.left.navigation.link.loc"), false);
		
		log(logger, "inst-INST1684_VerifyOnlineStoreNavigation End");
	}
}
