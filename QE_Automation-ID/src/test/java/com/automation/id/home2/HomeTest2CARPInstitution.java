package com.automation.id.home2;

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

public class HomeTest2CARPInstitution extends BaseTest {

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
	@TestAnnotations(testID = "INST-2098")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify cohort card UI for non carp institution")
	public void INST2098_VerifyNonCARPInstituteDetails() throws Exception {
		logger.info("INST2098_VerifyNonCARPInstituteDetails Start");
		log(logger, "INST2098_VerifyNonCARPInstituteDetails Start");
		
		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.2098.username"),
				PropertiesRepository.getString("id.login.2098.password"));

		// Step 1
		log(logger, "Verifying Institution DD is present for Personnel User");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.institution.text.box.loc"), false),
				"Unable to verify Institution DD");

		// Step 2
		log(logger, "Verifying Personnel user is able to select Institution from DD");
		homePage.verifyInstitutionNameForPersonnel(PropertiesRepository.getString("id.instituton.2098.input.value"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		/*// Step 2
		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageUsingGetAttribute("id.home.institution.text.box.loc", 0,
						PropertiesRepository.getString("id.instituton.2098.input.value")),
				"Unable to verify Institution name");*/

		log(logger, "Verifying No Cohort Assigned Section ");
		VerificationHandler.verifyTrue(
				homePage.verifyNoCohortAssignedWithNoStudentPortlet("Graduation Cohort", PropertiesRepository.getString("id.noncarp.inst.nodata.cohort.val")),
				"Unable to verify no cohort assigned section");

		log(logger, "Verifying Graduation Cohort with No Cohort Assigned with Student taken assessment");
		VerificationHandler.verifyTrue(
				homePage.verifyGraduationCohortWithNoCohortAssignedPortlet("Graduation Cohort", PropertiesRepository.getString("id.noncarp.inst.data.cohort.val")),
				"Unable to verify Graduation Cohort with No Cohort Assigned with Student taken assessment");

		log(logger, "Verifying Graduation Cohort with No Cohort Assigned with Student taken assessment");
		VerificationHandler.verifyTrue(
				homePage.verifyGraduationCohortWithNoCohortAssignedPortlet("Graduation Cohort", PropertiesRepository.getString("id.noncarp.inst.nocohortassigned.val")),
				"Unable to verify Graduation Cohort with No Cohort Assigned with Student taken assessment");

		log(logger, "INST2098_VerifyNonCARPInstituteDetails End");
		logger.info("INST2098_VerifyNonCARPInstituteDetails End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-2099")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify cohort card UI for carp institution")
	public void INST2099_VerifyCARPInstituteDetails() throws Exception {
		logger.info("INST2099_VerifyCARPInstituteDetails Start");
		log(logger, "INST2099_VerifyCARPInstituteDetails Start");
		
		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.2099.username"),
				PropertiesRepository.getString("id.login.2099.password"));

		// Step 1
		log(logger, "Verifying Institution DD is present for Personnel User");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.institution.text.box.loc"), false),
				"Unable to verify Institution DD");

		// Step 2
		log(logger, "Verifying Personnel user is able to select Institution from DD");
		homePage.verifyInstitutionNameForPersonnel(PropertiesRepository.getString("id.instituton.2099.input.value"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

	/*	// Step 2
		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyMessageUsingGetAttribute("id.home.institution.text.box.loc", 0,
						PropertiesRepository.getString("id.instituton.2099.input.value")),
				"Unable to verify Institution name");*/

		log(logger, "Verifying No Cohort Assigned Section ");
		VerificationHandler.verifyTrue(
				homePage.verifyNoCohortAssignedWithNoStudentPortlet("Graduation Cohort",PropertiesRepository.getString("id.carp.inst.nocohortassigned.nodata.val") ),
				"Unable to verify no cohort assigned section");

		log(logger, "Verifying Graduation Cohort with No Student Section");
		VerificationHandler.verifyTrue(homePage.verifyGraduationCohortWithNoStudentPortlet("Graduation Cohort",PropertiesRepository.getString("id.carp.inst.cohort.nodata.val11") ),
				"Unable to verify Graduation Cohort with no student section");

		log(logger, "Verifying Graduation Cohort with No Cohort Assigned with Student taken assessment");
		VerificationHandler.verifyTrue(
				homePage.verifyGraduationCohortWithNoCohortAssignedPortlet("Graduation Cohort", PropertiesRepository.getString("id.carp.inst.nocohortassigned.data.val")),
				"Unable to verify Graduation Cohort with No Cohort Assigned with Student taken assessment");

		log(logger, "Verifying Graduation Cohort when some student take any assessment");
		VerificationHandler.verifyTrue(
		homePage.verifyGraduationCohortWithSomeStudentPortlet("Graduation Cohort",PropertiesRepository.getString("id.carp.inst.cohort.data.val22") ),
				"Unable to verify Graduation Cohort when some student take any assessment");
		
		log(logger, "INST2099_VerifyCARPInstituteDetails End");
		logger.info("INST2099_VerifyCARPInstituteDetails End");
	}
}
