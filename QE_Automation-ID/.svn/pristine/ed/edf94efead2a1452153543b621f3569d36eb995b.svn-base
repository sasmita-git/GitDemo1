package com.automation.id.login;

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

public class LoginTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@TestAnnotations(testID="INST-1584")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Vereify faculty login page functionality")
	public void INST1584_VerifyLoginPageDetails() throws Exception {
		log(logger, "INST1584_VerifyLoginPageDetails Start");
		logger.info("INST1584_VerifyLoginPageDetails Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger, "Verifying Logo");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.logo")), "Unable to verify Logo");
		
		log(logger, "Verifying Username");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.username.loc")), "Unable to verify UserName");
		
		log(logger, "Verifying Password");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.password.loc")), "Unable to verify Password");
		
		log(logger, "Verifying Go Button");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.go.button")), "Unable to verify Go Button");
		
		log(logger, "Verifying Forgot Username/ password link");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.forgot.username.and.password")), "Unable to verify Forgot Username/ password");
		
		log(logger, "Verifying I am a Student link");
		VerificationHandler.verifyTrue(loginPage.verifyElementExists(PropertiesRepository.getString("id.login.i.am.a.student.link.loc")), "Unable to verify Student link");
		
		logger.info("INST1584_VerifyLoginPageDetails End");
		log(logger, "INST1584_VerifyLoginPageDetails End");
	}
	
	@TestAnnotations(testID="INST-1574")
	@Test(priority = 2, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify Forced log-in page should not come if user gives invalid UN")
	public void INST1574_VerifyInvalidLogin() throws Exception {
		log(logger, "INST1574_VerifyInvalidLogin Start");
		logger.info("INST1574_VerifyInvalidLogin Start");
		
		log(logger, "Verifying Invalid login");
		VerificationHandler
        .verifyTrue(loginPage.invalidLogin(PropertiesRepository.getString("id.login.invalid.username.value"), PropertiesRepository.getString("id.login.invalid.password.value")), "Unable to verify Invalid Login");
		
		log(logger, "INST1574_VerifyInvalidLogin End");
		logger.info("INST1574_VerifyInvalidLogin End");
	}
	
	
	@TestAnnotations(testID="INST-1585")
	@Test(priority = 3, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify faculty log out functinality")
	public void INST1585_VerifyLogoutFunctionality() throws Exception {
		log(logger, "INST1585_VerifyLogoutFunctionality Start");
		logger.info("INST1585_VerifyLogoutFunctionality Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Edit Profile Link");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigation.user.profile.loc"), 0, true), "Unable to Click Edit Profile Link in Left navigation ");
		
		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigation.user.details.loc"), 2, true), "Unable to verify Signout Page ");
		
		log(logger, "Verifying Username");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickWithSwitch(PropertiesRepository.getString("id.login.logo"),0,false), "Unable to verify UserName");
		
		logger.info("INST1585_VerifyLogoutFunctionality End");
		log(logger, "INST1585_VerifyLogoutFunctionality End");
	}
	
	//@TestAnnotations(testID="INST-1581")
	//@Test(priority = 4, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify that secure sign in is remove from contact us page")
	public void INST1581_VerifySecureLogin() throws Exception {
		logger.info("INST1581_VerifySecureLogin Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.old.url"));
		
		log(logger, "Clicking on Contact Us Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.old.contact.us.loc"), true);
		
		log(logger, "Verifying Secure Login Link in main tab");
		loginPage.verifyTextEqualsList(PropertiesRepository.getString("id.old.contact.us.secure.login.loc"), "Secure Sign in");
		
		logger.info("INST1581_VerifySecureLogin End");
	}
	
	@TestAnnotations(testID="INST-1583")
	@Test(priority = 5, alwaysRun =true, enabled = true, groups={"Regression"}, description = "On clicking the ATI logo,direct the user to www.atitesting.com")
	public void INST1583_VerifyATILogoLink() throws Exception {
		log(logger, "INST1583_VerifyATILogoLink Start");
		logger.info("INST1583_VerifyATILogoLink Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger,"Clicking on ATI logo link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.login.logo"), true);

		VerificationHandler.verifyEquals(driver.getCurrentUrl().trim(), PropertiesRepository.getString("id.ati.login.new.url"));		
		logger.info("INST1583_VerifyATILogoLink End");
		log(logger, "INST1583_VerifyATILogoLink End");
	}
	
	@TestAnnotations(testID="INST-1660")
	@Test(priority = 6, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify error message for invalid login")
	public void INST1660_VerifyInvalidLogin() throws Exception {
		log(logger, "INST1660_VerifyInvalidLogin Start");
		logger.info("INST1660_VerifyInvalidLogin Start");
		
		log(logger, "Verifying Invalid login");
		VerificationHandler
		.verifyTrue(loginPage.invalidLogin(PropertiesRepository.getString("id.login.invalid.login.username.value"), PropertiesRepository.getString("id.login.invalid.login.password.value")), "Unable to verify Invalid Login");
		
		driver.navigate().refresh();
		
		log(logger,"Varifying valid login");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), false), "Unable to click left navigation");
	
		logger.info("INST1660_VerifyInvalidLogin End");
		log(logger, "INST1660_VerifyInvalidLogin End");
	}
	
	@TestAnnotations(testID="INST-1679")
	@Test(priority = 7, alwaysRun =true, enabled = true, groups={"Regression"}, description = "Verify that login page header and footer links are navigating to respective page")
	public void INST1679_VerifyHeaderFooterLink() throws Exception {
		log(logger, "INST1679_VerifyHeaderFooterLink Start");
		logger.info("INST1679_VerifyHeaderFooterLink Start");
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		log(logger,"Navigate to online store link");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink("Online Store", 0));
	
		log(logger,"Verify online store link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("id.login.online.store.url")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Navigate to contact us");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink(PropertiesRepository.getString("id.login.contact.us.link.value"), 1));
		
		log(logger,"Verify contact us link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("id.login.contactus.new.url")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Navigate to i am a student link");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink("I am a Student", 3));
		
		log(logger,"Verify i am a student link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("newati.home.page.url")));
		
		log(logger, "Login Page");
		loginPage.enterURL(PropertiesRepository.getString("id.url"));
		
		//now need to verify footer link
		log(logger,"Navigate to privacy polocy");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink(PropertiesRepository.getString("id.login.privacy.policy.value"), 5));
		
		log(logger,"Verify privacy policy link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("newati.privacy.policy.link.loc")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Navigate to Web Site Terms of Use link");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink(PropertiesRepository.getString("id.login.web.site.value"),6));
		
		log(logger,"Verify Web Site Terms of Use link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("newati.web.site.link.loc")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Navigate to User Terms and Conditions link");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink(PropertiesRepository.getString("id.login.user.terms.and.conditions.value"),7));
		
		log(logger,"Verify User Terms and Conditions link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("newati.user.terms.and.conditions.loc")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Navigate to ATI Product Solutions link");
		VerificationHandler.verifyTrue(loginPage.VerifyAndclickLoginPageLink(PropertiesRepository.getString("id.login.ati.product.solutions.value"),9));
		
		log(logger,"Verify ATI Product Solutions link");
		VerificationHandler.verifyTrue(loginPage.verifyUrl(PropertiesRepository.getString("newati.ati.product.solutions.loc")));
		
		log(logger,"Navigate back to login page");
		loginPage.clikNavigateBackToLoginpage();
		
	   //LET THE BELOW CODE RUN :) 
		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		
		log(logger, "Verifying Home page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on Home Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", true), "Unable to verify Home Link");
		
		log(logger, "Verifying Home page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Products Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		
		log(logger, "Verifying Products page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Proctor Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", true), "Unable to verify Proctor ");
		
		log(logger, "Verifying Proctor page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Analytics Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		
		log(logger, "Verifying Analytics page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on People Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true), "Unable to verify People Link");
		
		log(logger, "Verifying People page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on C-MAP Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "map", true), "Unable to verify C-Map Link");
		
		log(logger, "Verifying C-MAP page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		log(logger,"Navigate back to Home page");
		loginPage.clikNavigateBackToLoginpage();
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Clicking on Help & Resources Link");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", true), "Unable to verify Resources   Link");
		
		log(logger, "Verifying Help & Resources page footer");
		VerificationHandler.verifyTrue(homePage.verifyHomePageFooterMessagae(), "Unable to verify Footer");
		
		logger.info("INST1679_VerifyHeaderFooterLink End"); 
		log(logger, "INST1679_VerifyHeaderFooterLink End");
	}
	
	//@TestAnnotations(testID="INST-1709")
	//@Test(priority = 8, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Home page for Proctor")
	public void  INST1709_VerifyHomePageForProctor() throws Exception {
		log(logger, "INST1709_VerifyHomePageForProctor Start");
		
		log(logger, "enter url");
		driver.get(PropertiesRepository.getString("id.login.url"));
		
		log(logger,"login as Proctor");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.proctor.login.username.value"), PropertiesRepository.getString("id.login.proctor.login.password.value"));	
		 
		log(logger, "verify ATI Contacts static menu popup ");
		VerificationHandler.verifyTrue(homePage.verifyTextEqualsList(PropertiesRepository.getString("id.home.static.list.option.loc"), PropertiesRepository.getString("id.home.static.list.ati.contacts.option.text")));
		
		log(logger, "verify content in the popup ");
		VerificationHandler.verifyTrue(homePage.verifyAtiContactsPopUpInfo(PropertiesRepository.getString("id.home.static.list.ati.contacts.popup.msg.loc")));
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Verifying Left Navigation analytics link not present");
		VerificationHandler.verifyFalse(homePage.verifyLeftNavigationText(0, PropertiesRepository.getString("id.home.left.navigation.report"), false), "Analytics is not present");
		
		log(logger, "INST1709_VerifyHomePageForProctor End");
	}
	
	
	@TestAnnotations(testID="INST-1674")
	@Test(priority = 9, alwaysRun =true, enabled = true, groups={"Smoke","Regression"}, description = "Verify the home page elements for faculty login.::Smoke Test Suite")
	public void INST1674_VerifyFacultyLoginLinkDetails() throws Exception {
		log(logger, "INST1674_VerifyFacultyLoginLinkDetails Start");
		logger.info("INST1674_VerifyFacultyLoginLinkDetails Start");
		
		log(logger, "Login Page");
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
		
		log(logger, "Verifying Technical Requirement");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.tech.requ.loc"), false), "Unable to verify Technical Requirement");
		
		log(logger, "Veriying I am a Student Link");
		VerificationHandler
		.verifyTrue(loginPage.verifyAndClick(PropertiesRepository.getString("id.login.i.am.a.student.link.new.loc"), false), "Unable to verify I am a Student link and clicking");
		
		log(logger, "Verifying Login Header");
		VerificationHandler
		.verifyTrue(loginPage.verifyLoginHeader(), "Unable to verify Login Header");
		
		log(logger, "Verifying Login Footer");
		VerificationHandler
		.verifyTrue(loginPage.verifyLoginFooter(), "Unable to verify Login Footer");
		
		logger.info("INST1674_VerifyFacultyLoginLinkDetails End");
		log(logger, "INST1674_VerifyFacultyLoginLinkDetails End");
	}
}
