package com.automation.id.smoke;

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

public class Smoke_FacultyRoleTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1709")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "Smoke_FacultyRoleTest :: Verify Home page for Proctor")
	public void INST1709_VerifyProctorFunctionality() throws Exception {
		log(logger, "INST1709_VerifyProctorFunctionality Start");
		logger.info("INST1709_VerifyProctorFunctionality Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		
		// Step 1
		log(logger, "Verifying ATI Contacts");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.proctor.home.page.ati.contacts.header.loc", 0,
						PropertiesRepository.getString("id.proctor.home.page.ati.contacts.header.value")),
				"Unable to verify ATI Contacts");
		
		log(logger, "Verifying Customer Support");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage("id.proctor.home.page.ati.contacts.customer.support.loc", 0,
						PropertiesRepository.getString("id.proctor.home.page.ati.contacts.customer.support.value")),
				"Unable to verify Customer Support");
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyFalse(homePage.verifyTextContains(PropertiesRepository.getString("id.home.menu.item.list.loc"),
				PropertiesRepository.getString("id.home.customize.home.link.value"), 0), "Customize home link is displayed");
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyFalse(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", false),
				"Unable to verify People Link");
		
		log(logger, "INST1709_VerifyProctorFunctionality End");
		logger.info("INST1709_VerifyProctorFunctionality End");
	}
	
	
	
}
