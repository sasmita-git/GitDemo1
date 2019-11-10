package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class Smoke_WarmTransfersTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
	}

	@TestAnnotations(testID = "INST-1751")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Smoke_WarmTransfersTest :: Verify the Warm Transfer from Faculty Login to student")
	public void INST1751_verifyStudentWarmTransfer() throws Exception {
		logger.info("INST1751_verifyStudentWarmTransfer Start");

		log(logger, "Login to application");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor6.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor6.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on user name");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.login.edit.profile.name.loc"), true),
				"Unable to click User Name in left navigation");

		log(logger, "click on student view tab");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.homepage.main.menu.list.top"), 1, true),
				"Unable to click Student view in left navigation");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");
		// editProfilePage.clickElement("id.homepage.main.menu.list.top", 1);

		log(logger, "click on student view continue button link");
		VerificationHandler.verifyTrue(homePage.clickContinueForStudentView(),
				"Unable to verify student view continue button funcationality");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on Return to faculty link");
		VerificationHandler.verifyTrue(homePage.clickOnReturnToFacultyLink(1),
				"Unable to click Return to faculty link in Student Portal");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Left Navigation Link to verify that we are back to faculty");
		VerificationHandler
				.verifyTrue(
						editProfilePage.verifyAndClick(
								PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), false),
						"Unable to click left navifation in faculty portal application");
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		//click online store link
		log(logger,"click on online store");
		VerificationHandler
		.verifyTrue(homePage.clickOnTopRightCornerElement(2), "Unable to click on online store");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		loginPage.waitUntillLoadingImageIsAppeared(PropertiesRepository.getString("id.online.store.home.page.not.an.educator.visit.the.student.site.link.loc"));
		
		log(logger,"Verify onlinestore home link");
		VerificationHandler
		.verifyTrue(homePage.VerifyOnLineStoreHome(PropertiesRepository.getString("id.online.store.home.page.header.value")), "Unable to Verify onlinestore home header");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "Clicking on Home link");
		homePage.verifyAndClick(PropertiesRepository.getString("id.login.onlinestore.home.link.loc"), true);
//		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.onlinestore.homelink.loc"), true),"Unable to Verify onlinestore home link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		
		// ATI Academy.
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

				log(logger, "Verifying ATI Academy from Left navigation");
				VerificationHandler.verifyTrue(
						homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", true),
						"Unable to verify ATI Academy ");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Verifying ATI Academy");
				VerificationHandler.verifyTrue(
						homePage.verifyATIAcademyPage(PropertiesRepository.getString("id.home.page.ati.academy.header.loc"), 0,
								PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value")),
						"Unable to verify ATI Contacts");
		
		log(logger, "Return to faculty home from ATI Academy");
		//VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString(""), true),"Unable to  return to faculty home from Ati academy");
		
				
		//Assessment builder				
				VerificationHandler.verifyTrue(
						homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
						"Unable to click left navigation");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
				
				log(logger, "Verifying Assessment Builder from Left navigation");
				VerificationHandler.verifyTrue(
						homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "Assessment Builder", true),
						"Unable to verify Assessment builder ");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Click on Return to faculty link");
				VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.cab.returntoFaculty.loc"), true),"Unable to click return to faculty");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
				
				VerificationHandler.verifyTrue(
						homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
						"Unable to click left navigation");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		logger.info("INST1751_verifyStudentWarmTransfer End");
	}
	
}





