package com.automation.id.edit.profile;

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
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.jaca.TestAnnotations;

public class EditProfileTest extends BaseTest {
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
	
	@TestAnnotations(testID="INST-1580")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Edit profile page for faculty")
	public void INST1580_verifyEditProfilePage() throws Exception{
		logger.info("INST1580_verifyEditProfilePage Start");
		
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		
		log(logger,"Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		
		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list",1);
		
		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		
		log(logger, "click on personal link");
		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 0);*/
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalSectionInfo("id.home.personal.profile.links","id.home.profile.field.names"));
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 0);
		*/
		log(logger, "click on sign in link");
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 1);*/
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalSectionInfo("id.home.personal.signin.links","id.home.personal.signin.links.input"));
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 1);*/
		
		log(logger, "click on institution link");
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 2);*/
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalInfo("id.home.profile.institution.name.loc","id.home.profile.institution.name.input"));
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalInfo("id.home.profile.institution.empid.loc","id.home.profile.institution.empid.input"));
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 2);*/
		
		log(logger, "click on Demographics link");
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 3);*/
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalInfo("id.home.profile.demographics.section.loc","id.home.profile.demographics.section.input"));
		VerificationHandler.verifyTrue(editProfilePage.verifyPersonalInfo("id.home.profile.demographics.section.birthdate.loc","id.home.profile.demographics.section.birthdate.input"));
		/*editProfilePage.clickButtonFromList("id.home.profile.top.links", 3);*/
		
		logger.info("INST1580_verifyEditProfilePage End");
	}
	
	@TestAnnotations(testID="INST-1628")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Edit profile page for newly addded country Philippines")
	public void INST1628_verifyEditProfilePageforNewlyAdddedCountry() throws Exception {
		logger.info("INST1628_verifyEditProfilePageforNewlyAdddedCountry Start");
		log(logger, "INST1628_verifyEditProfilePageforNewlyAdddedCountry Start");
		
		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "enter text for country ");
		VerificationHandler.verifyTrue(
				homePage.searchAndEnterCountry(
						PropertiesRepository.getString("id.home.profile.contry.field.dropdwown.loc"),
						PropertiesRepository.getString("id.home.profile.contry.philippines.countryInpt")),
				"Unable to select country from drop down");

		log(logger, "enter text for state ");
		VerificationHandler.verifyTrue(
				homePage.searchAndEnterCountry(
						PropertiesRepository.getString("id.home.profile.state.field.dropdwown.loc"),
						PropertiesRepository.getString("id.home.profile.state.philippines.stateInpt")),
				"Unable to select state from drop down");

		log(logger, "click on save button");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"), 0, true),
				"Unable to click on save button");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");

		log(logger, "verify county personal information");
		VerificationHandler.verifyTrue(
				loginPage.verifyMessageUsingGetAttribute("id.home.profile.contry.field.dropdwown.loc", 0,
						PropertiesRepository.getString("id.home.profile.contry.philippines.countryInpt")),
				"unable to verify country field");
		log(logger, "verify State personal information");
		VerificationHandler.verifyTrue(
				loginPage.verifyMessageUsingGetAttribute("id.home.profile.state.field.dropdwown.loc", 0,
						PropertiesRepository.getString("id.home.profile.state.philippines.stateInpt")),
				"unable to verify State field");

		logger.info("INST1628_verifyEditProfilePageforNewlyAdddedCountry End");
		log(logger, "INST1628_verifyEditProfilePageforNewlyAdddedCountry End");
	}
	
	
	@TestAnnotations(testID="INST-1635")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify Zipcode filed when country selected as Philippines")
	public void INST1635_verifyZipCode() throws Exception{
		logger.info("INST1635_verifyZipCode Start");
		log(logger, "INST1635_verifyZipCode Start");
		
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "enter text for country ");
		VerificationHandler.verifyTrue(
				homePage.searchAndEnterCountry(
						PropertiesRepository.getString("id.home.profile.contry.field.dropdwown.loc"),
						PropertiesRepository.getString("id.home.profile.contry.philippines.countryInpt")),
				"Unable to select country from drop down");

		log(logger, "enter text for state ");
		VerificationHandler.verifyTrue(
				homePage.searchAndEnterCountry(
						PropertiesRepository.getString("id.home.profile.state.field.dropdwown.loc"),
						PropertiesRepository.getString("id.home.profile.state.philippines.stateInpt")),
				"Unable to select state from drop down");
		
		log(logger, "Remvoing Zip Code");
		editProfilePage.removeZipCode();
		
		log(logger, "click on save button");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"), 0, true),
				"Unable to click on save button");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		
		log(logger, "Verifying zip code text box after clearing zipcode");
		VerificationHandler.verifyTrue(
		loginPage.verifyMessageUsingGetAttribute("id.editpage.personel.zipcode.loc", 2,
				""), "Unable to verify Zip code");
		
		logger.info("INST1635_verifyZipCode End");
		log(logger, "INST1635_verifyZipCode End");
	}
	
	@TestAnnotations(testID="INST-1650")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify phone number filed when country selected as Philippines ")
	public void INST1650_verifyPhoneNumber() throws Exception{
		logger.info("INST1650_verifyPhoneNumber Start");
		log(logger, "INST1650_verifyPhoneNumber Start");
		
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "enter phone no");
		editProfilePage.enterText("id.home.profile.phone.number.field.loc", "id.home.profile.phone.number.field.input", 0);

		log(logger, "click on save button");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"), 0, true),
				"Unable to click on save button");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Personal Right arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 0, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Personal Section details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"),
						PropertiesRepository.getString("id.home.profile.account.setting.pesonal.value"), 0),
				"Unable to verify User");
		
		log(logger, "Verifying Phone number text box after entering new phone number");
		VerificationHandler.verifyTrue(
		loginPage.verifyMessageUsingGetAttribute("id.home.profile.phone.number.field.loc", 0,
				PropertiesRepository.getString("id.home.profile.phone.number.field.input")), "Unable to verify Phone number");
		
		log(logger, "INST1650_verifyPhoneNumber End");
		logger.info("INST1650_verifyPhoneNumber End");
	}
	
	@TestAnnotations(testID="INST-1686")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check for ATI Email present")
	public void INST1686_verifyATIEmailPresent() throws Exception{
		logger.info("INST1686_verifyATIEmailPresent Start");
		log(logger, "INST1686_verifyATIEmailPresent Start");
		
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Sign In arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 1, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Verifying Sign In details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 1 ,
						PropertiesRepository.getString("id.home.profile.account.setting.sing.in.value")),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Email arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 2, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "entering email and confirm email ");
		String randomEmail=editProfilePage.enterTextDynamically("id.home.profile.email.loc",0);
		
		log(logger, "click on save button");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository.getString(
						"id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"), 1, true),
				"Unable to click on save button");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Sign In details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
						"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 1 ,
						PropertiesRepository.getString("id.home.profile.account.setting.sing.in.value")),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Email arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 2, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Verifying Email 1");
		VerificationHandler.verifyTrue(
		loginPage.verifyMessageUsingGetAttribute("id.home.profile.account.setting.sign.in.section.email1.loc", 0,
				randomEmail), "Unable to verify Email ID");
		
		log(logger, "INST1686_verifyATIEmailPresent End");
		logger.info("INST1686_verifyATIEmailPresent End");
	}
	
	
	@TestAnnotations(testID = "INST-1773")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify Sign in Info Section & edit functionality of Sign In info of My profile tab")
	public void INST1773_verifySignInInfoDetails() throws Exception {
		logger.info("INST1773_verifySignInInfoDetails Start");
		log(logger, "INST1773_verifySignInInfoDetails Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on Sign In arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 1, true),
				"Unable to click on Personal right arrow");

		log(logger, "Verifying Sign In details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
						"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 1,
						PropertiesRepository.getString("id.home.profile.account.setting.sing.in.value")),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Username");
		VerificationHandler
				.verifyTrue(
						editProfilePage.verifyMessage("id.home.profile.account.setting.sign.in.main.details.loc", 0,
								PropertiesRepository
										.getString("id.home.profile.account.setting.sign.in.username.value")),
						"Unable to verify username");

		log(logger, "Verifying Paper/ Pencil ID");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage("id.home.profile.account.setting.sign.in.main.details.loc", 1,
						PropertiesRepository
								.getString("id.home.profile.account.setting.sign.in.paper.pencil.id.value")),
				"unable to verify paper/ pencil id");

		logger.info("Email Section Start");

		log(logger, "Clicking on Email arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 2, true),
				"Unable to click on Email right arrow");

		log(logger, "Verifying Email details");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage(
				"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 3,
				PropertiesRepository.getString("email.text.people.page")), "Unable to verify Email");
		// editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Email main");
		VerificationHandler
				.verifyTrue(
						editProfilePage.verifyMessageUsingGetAttribute(
								"id.home.profile.account.setting.sign.in.email.section.loc", 0,
								PropertiesRepository
										.getString("id.home.profile.account.setting.sign.in.email.id.value")),
						"Unable to Verifying Email main");

		log(logger, "Verifying Email label");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
								.getString("id.home.profile.account.setting.sign.in.email.label.section.loc"),
						PropertiesRepository.getString("email.text.people.page"), 0),
				"Unable to Verifying Email label");

		log(logger, "Verifying Email value");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(
						PropertiesRepository.getString("id.home.profile.account.setting.sign.in.email.section.loc"), 0),
				"Unable to verify email");

		log(logger, "Verifying Confirm Email label");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
								.getString("id.home.profile.account.setting.sign.in.email.label.section.loc"),
						PropertiesRepository.getString("confirm.email.text.people.page"), 1),
				"Unable to verify Confirm Email label");

		log(logger, "Verifying Confirm Email value");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(
						PropertiesRepository.getString("id.home.profile.account.setting.sign.in.email.section.loc"), 1),
				"Unable to Confirm Email ");

		log(logger, "entering email and confirm email ");
		String randomEmail = editProfilePage.enterTextDynamically("id.home.profile.email.loc", 0);

		/*
		 * log(logger, "Clicking on Save button");
		 * editProfilePage.verifyAndClick(PropertiesRepository.getString(
		 * "id.home.profile.account.setting.sign.in.email.section.save.button.loc"),
		 * true);
		 */

		log(logger, "Clicking on Email arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 2, true),
				"Unable to click on Email right arrow");

		logger.info("Email Section End");

		logger.info("Password Section Start");

		log(logger, "Clicking on Password arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 3, true),
				"Unable to click on Password right arrow");

		log(logger, "Verifying Password details");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage(
				"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 4,
				PropertiesRepository.getString("password.text")), "Unable to verify Password");
		// editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Entering old password");
		editProfilePage.enterTextList(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.password.section.loc"), 0,
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Entering new password less than 6 characters");
		editProfilePage.enterTextListAndTab(
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.password.section.new.password.loc"),
				0, PropertiesRepository.getString("id.test.data.1773.value"));

		log(logger, "Entering confirm new password less than 6 characters");
		editProfilePage.enterTextList(
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.password.section.confirm.new.password.loc"),
				0, PropertiesRepository.getString("id.test.data.1773.value"));

		log(logger, "Clicking on Password arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 3, true),
				"Unable to click on Password right arrow");

		logger.info("Password Section End");

		logger.info("Security Question Start");

		log(logger, "Clicking on Secutiry Question arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 4, true),
				"Unable to click on Security Question right arrow");

		log(logger, "Verifying Secutiry details");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage(
				"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 5,
				PropertiesRepository.getString("security.questions.text")), "Unable to verify Secutiry");
		// editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Question 1 and Answer 1 Section
		log(logger, "Verifying Question 1 Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.question.label.loc"),
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.label.q1.loc"),
				0), "Unable to Verify Question 1 Label");

		log(logger, "Verifying default question 1");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.select.loc"), 0),
				"Unable to Verifying default question 1");

		log(logger, "Verifying Answer 1 Labe1");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.a1.loc"),
				0), "Unable to Verify Answer 1 Labe1");

		log(logger, "Verifying Answer 1 Text box");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.answer.textbox.loc"), 0),
				"Unable to Verify Answer 1 Text box");

		// Question 2 and Answer 2 Section
		log(logger, "Verifying Question 2 Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.question.label.loc"),
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.label.q2.loc"),
				1), "Unable to Verify Question 2 Label");

		log(logger, "Verifying default question 2");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.select.loc"), 1),
				"Unable to Verify default question 2");

		log(logger, "Verifying Answer 2 Labe1");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.a2.loc"),
				1), "Unable to Verify Answer 2 Labe1");

		log(logger, "Verifying Answer 2 Text box");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.answer.textbox.loc"), 1),
				"Unable to Verify Answer 2 Text box");

		// Question 3 and Answer 3 Section
		log(logger, "Verifying Question 2 Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.question.label.loc"),
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.label.q3.loc"),
				2), "Unable to Verify Question 2 Label");

		log(logger, "Verifying default question 3");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.question.select.loc"), 2),
				"Unable to Verify default question 3");

		log(logger, "Verifying Answer 3 Labe1");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.security.answer.label.a3.loc"),
				2), "Unable to Verify Answer 3 Labe1");

		log(logger, "Verifying Answer 3 Text box");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyElementExists(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.security.answer.textbox.loc"), 2),
				"Unable to Verify Answer 3 Text box");

		log(logger, "Clicking on Secutiry Question arrow ");
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 4, true);
		
		logger.info("Security Question End");

		logger.info("Institution Section Start");
		log(logger, "Clicking on Institution arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 5, true),
				"Unable to click on Institution right arrow");
		
		log(logger, "Verifying Institution details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository
						.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"), 
						PropertiesRepository.getString("id.home.profile.institution.name.input"),6),
				"Unable to verify Institution");
		//editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Institution DD details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 7 ,
						PropertiesRepository.getString("id.home.profile.institution.name.input")),
				"Unable to verify Institution");
		
		log(logger, "Clicking on Institution DD arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 6, true),
				"Unable to click on Institution DD rrow");
		
		log(logger, "Verifying Institution DD Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.institution.dd.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.institution.dd.value.label.value"), 0), "Unable to verify Institution DD Label");
		
		log(logger, "Veriyfing Institution DD value in textbox");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessageUsingGetAttribute(
				"id.home.profile.account.setting.sign.in.institution.dd.value.loc", 0 ,
		PropertiesRepository.getString("id.home.profile.account.setting.sign.in.institution.dd.value.value")), "Unable to verify Institution DD value in textbox");
		
		
		log(logger, "Verifying Employee ID DD details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 8 ,
						PropertiesRepository.getString("id.home.profile.institution.empid.input")),
				"Unable to verify Employee ID ");
		
		log(logger, "Clicking on Employee ID DD arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 7, true),
				"Unable to click on Employee ID DD rrow");
		
		log(logger, "Verifying Employee ID DD Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.employee.id.dd.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.employee.id.dd.label.value"), 0), "Unable to verify Employee ID DD Label");
		
		log(logger, "Veriyfing Employee ID DD value in textbox");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessageUsingGetAttribute(
				"id.home.profile.account.setting.sign.in.employee.id.dd.value.loc", 0 ,
		PropertiesRepository.getString("id.home.profile.account.setting.sign.in.employee.id.dd.value.value")), "Unable to verify Employee ID DD value in textbox");
		
		log(logger, "Clicking on Institution arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 5, true),
				"Unable to click on Institution right arrow");
		
		logger.info("Institution Section End");
		
		
		logger.info("Demographics Section Start"); 
		log(logger, "Clicking on Demographics arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 8, true),
				"Unable to click on Demographics right arrow");
		
		log(logger, "Verifying Demographics  details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(PropertiesRepository
						.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"), 
						PropertiesRepository.getString("demographics.text"),9),
				"Unable to verify Demographics");
		
		log(logger, "Clicking on Demographics (optional) arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 9, true),
				"Unable to click on Demographics right arrow");
		
		
		log(logger, "Verifying Demographics (optional) details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"), 
						PropertiesRepository.getString("demographics.optional.text"),10 ),
				"Unable to verify Demographics");
		
		log(logger, "Verifying Gender Identity Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.gender.identity.value"), 0), "Unable to verify Gender Identity Label");
		
		log(logger, "Verifying Gender Identity Value");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage(
				"id.home.profile.account.setting.sign.in.demographics.gender.primary.lang.loc", 0 ,
		PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.gender.value")), "Unable to verify Gender Identity Value");
		
		log(logger, "Verifying BirthDate Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.birth.date.value"), 1), "Unable to verify BirthDate Label");
		
		log(logger, "Verifying BirthDate value");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessageUsingGetAttribute(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.birth.date.loc"), 0 ,
		PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.birth.date.value")), "Unable to verify BirthDate value");
		
		log(logger, "Verifying Primary Language Label");
		VerificationHandler.verifyTrue(editProfilePage.verifyTextContains(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.label.loc"),
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.primary.language.value"), 2), "Unable to verify Primary Language Label");
		
		log(logger, "Verifying Primary Language Value");
		VerificationHandler.verifyTrue(editProfilePage.verifyMessage(
				"id.home.profile.account.setting.sign.in.demographics.gender.primary.lang.loc", 1 ,
		PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.primary.lang.value")), "Unable to verify Primary Language Value");
		
		
		log(logger, "Clicking on Ethinicity (Optional) arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 10, true),
				"Unable to click on Demographics right arrow");
		
		log(logger, "Verifying Ethinicity (Optional) details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyTextContains(
						PropertiesRepository.getString("id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc"), 
						PropertiesRepository.getString("ethnicity.optional.text"), 11),
				"Unable to verify Demographics");
		
		log(logger, "Verify White or European American check box is selected");
		editProfilePage.verifyEthinicityCheckBoxValue(
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.demographics.ethinicity.checkbox.loc"),
				PropertiesRepository.getString(
						"id.home.profile.account.setting.sign.in.demographics.ethinicity.checkbox.value"),
				0);
		
		log(logger, "Clicking on Demographics arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 8, true),
				"Unable to click on Demographics right arrow");
		
		logger.info("Demographics Section End");
		
		
		
		log(logger, "INST1773_verifySignInInfoDetails End");
		logger.info("INST1773_verifySignInInfoDetails End");
	}

	
	@TestAnnotations(testID="INST-1776")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify error message of Password of Sign in Info Section of My Profile tab")
	public void INST1776_verifyPasswordResetFunctionality() throws Exception{
		logger.info("INST1776_verifyPasswordResetFunctionality Start");
		log(logger, "INST1776_verifyPasswordResetFunctionality Start");
		
		log(logger,"Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Sign In arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.personal.section.right.arrow.loc"), 1, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Verifying Sign In details");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyMessage(
								"id.home.profile.account.setting.terms.and.condition.section.details.h3.new.loc", 1 ,
						PropertiesRepository.getString("id.home.profile.account.setting.sing.in.value")),
				"Unable to verify User");
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Password arrow ");
		VerificationHandler.verifyTrue(
				editProfilePage.verifyAndClick(PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.section.email.right.arrow.loc"), 3, true),
				"Unable to click on Personal right arrow");
		
		log(logger, "Entering old password");
		editProfilePage.enterTextList(
				PropertiesRepository.getString("id.home.profile.account.setting.sign.in.password.section.loc"), 0,
				PropertiesRepository.getString("id.login.faculty.password"));
		
		log(logger, "Entering new password less than 6 characters");
		editProfilePage.enterTextListAndTab(
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.password.section.new.password.loc"),
				0, PropertiesRepository.getString("id.test.data.1776.value"));

		/*editProfilePage.enterTextList(
				PropertiesRepository
						.getString("id.home.profile.account.setting.sign.in.password.section.new.password.loc"),
				1, PropertiesRepository.getString("id.test.data.1776.value"));*/
		
		log(logger, "Verifying Error message");
		VerificationHandler.verifyTrue(
		editProfilePage.verifyMessage(
				"id.home.profile.account.setting.sign.in.password.section.length.error.message.loc", 0,
				PropertiesRepository.getString(
						"id.home.profile.account.setting.sign.in.password.section.length.error.message.value")),
				"Unable to click on Personal right arrow");
		
		log(logger, "INST1776_verifyPasswordResetFunctionality End");
		logger.info("INST1776_verifyPasswordResetFunctionality End");
	}
	
	
	
	/*@TestAnnotations(testID="INST-1689")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Check ATI email integration with MU")*/
	public void INST1689_verifyATIEmailIntegration() throws Exception{
		logger.info("INST1689_verifyATIEmailIntegration Start");
		log(logger, "INST1689_verifyATIEmailIntegration Start");
		
		editProfilePage.launchLoginPage(PropertiesRepository.getString("current-atitesting.mu.url"));
		editProfilePage.loginIntoMU();
		
		editProfilePage.clickSystemAdmin("SYSTEM ADMINISTRATION");
		editProfilePage.clickMenuFromSystemAdmnstrtn("Management Utility");
		editProfilePage.clickMenuFromMgmtUtility("Manage Users");
		
		log(logger, "Enter instructor username");
		editProfilePage.enterTextInTextBox("current-atitesting.mu.users.username","current-atitesting.mu.instructor.username");
		
		log(logger, "click on go button");
		editProfilePage.clickGoButton();
		
		log(logger, "click on row link Start");
		editProfilePage.clickOnRowLink("current-atitesting.mu.users.selected.row.loc",0);
		
		log(logger, "click on atiEmail checkbox");
		boolean isChecked=editProfilePage.isAtiEmailChecked("current-atitesting.mu.users.ati.email.checkbox");
		
		log(logger,"Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"), PropertiesRepository.getString("id.login.faculty.password"));
		editProfilePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		/*log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);*/
		
		log(logger,"Clicking on Left Navigation Link");
		editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger,"Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);
		
		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list",1);
		
		log(logger, "Enter profile url");
		driver.get(PropertiesRepository.getString("profile.url"));
		editProfilePage.waitForAwhile(8000);
		
		boolean verifyToggleBarStatus = editProfilePage.verifyToggleBarStatus(isChecked);
		VerificationHandler.verifyTrue(verifyToggleBarStatus, "slider is not moving according to changes in the MU");
		
		log(logger, "INST1689_verifyATIEmailIntegration End");
		logger.info("INST1689_verifyATIEmailIntegration End");
	}
}
