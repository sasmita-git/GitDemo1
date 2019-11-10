package com.automation.id.smoke;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.IDBasePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Smoke_EditProfilePageTest extends BaseTest{
	private Logger logger = LogManager.getLogger(this.getClass());
	private EditProfilePage editProfilePage;
	private HomePage homePage;
	private LoginPage loginPage;
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		editProfilePage = new EditProfilePage(driver);
		homePage = new HomePage(driver);
		loginPage=new LoginPage(driver);
	}
	/**
	 * @author kumarisagarika.t
	 * @throws Exception
	 */
	
	@TestAnnotations(testID="7")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Smoke_EditProfilePageTest :: Verify Edit profile page for faculty")
	public void verifyEditProfilePage() throws Exception{
		logger.info("verifyEditProfilePage Start");
		
		//log-in
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.editProfile.username"), PropertiesRepository.getString("id.login.editProfile.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Click on left navigation icon
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		
		//Clicking on username
		log(logger,"Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		
		//Click on account setting tab
		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list",1);
		
		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		Thread.sleep(10000);
		
		//Edit profile sub-tab verification
		log(logger, "Verifying edit profile subtabs");
		VerificationHandler.verifyTrue(editProfilePage.verifyEditProfileSubTab());
		
		//Edit profile settings page verification
		log(logger, "Verifying edit profile settings page");
		VerificationHandler.verifyTrue(editProfilePage.verifyEditProfile());
		
		//Clicking on terms & condition
		log(logger, "Clicking on Terms and Condition Tab");
		editProfilePage.clickButton(
				PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.tab.loc"), 2);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Edit profile terms & condition sub-tab verification
		log(logger, "Verifying edit profile settings page");
		VerificationHandler.verifyTrue(editProfilePage.verifyTermsConditionContents());
				
		//Click on My purchase on edit profile page
		  log(logger, "Clicking on My purchase tab");
		  VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.editProfile.MyPurchage.loc"), true),
						"Unable to click My purchase tab");		
}}
