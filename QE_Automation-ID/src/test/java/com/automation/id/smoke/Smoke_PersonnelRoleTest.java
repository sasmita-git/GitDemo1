package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class Smoke_PersonnelRoleTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;
	BaseHandler basehandler;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
		basehandler = new BaseHandler(driver);
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1951")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Smoke_PersonnelRoleTest :: Verify select institute for personnel present in home")
	public void INST1951_VerifyInstituteForPersonnel() throws Exception {
		logger.info("INST1951_VerifyInstituteForPersonnel Start");

		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.personnel1.1951.username"),
				PropertiesRepository.getString("id.auto.hm2.personnel1.1951.password"));

		// Step 1
		log(logger, "Verifying Institution DD is present for Personnel User");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.institution.text.box.loc"), false),
				"Unable to verify Institution DD");

		// Step 2
		log(logger, "Verifying Personnel user is able to select Institution from DD");
		homePage.verifyInstitutionNameForPersonnel(PropertiesRepository.getString("id.instituton.input.value"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		Thread.sleep(5000);

		// Step 2
		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageUsingGetAttribute(
						PropertiesRepository.getString("id.home.institution.text.box.loc"), 0,
						PropertiesRepository.getString("id.instituton.input.value")),
				"Unable to verify Institution name");

		logger.info("INST1951_VerifyInstituteForPersonnel End");
	}
}
