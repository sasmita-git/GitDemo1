package com.automation.newati.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.CheckboxHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class CreateAccountPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler btnHandler;
	private DropDownHandler dropDownHandler;
	private TextHandler textHandler;
	private CheckboxHandler checkBoxHandler;
	private LinkHandler linkHandler;
	private WindowHandler windowHandler;
	private String result;
	List<WebElement> elements;
	private TutorialPage tutorialPage;
	public CreateAccountPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		btnHandler = new ButtonHandler(driver);
		checkBoxHandler = new CheckboxHandler(driver);
		linkHandler = new LinkHandler(driver);
		windowHandler = new WindowHandler(driver);
		tutorialPage=new TutorialPage(driver);
	}
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public String verifyStep1(String uname,String email) throws DriverException {
		logger.info("Method:verifyStep1 START");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// click on create account link
			linkHandler.selectLink(PropertiesRepository.getString("new-atitesting.createAccountLoc"),PropertiesRepository.getString("new-atitesting.createaccount.waitFor"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// Enter UserName
			enterUserName(uname);
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// fetching text
			result = textHandler.getText(PropertiesRepository.getString("new-atitesting.username.already.exists"));

			// Checking username is already exist or not
			if (!result.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.user.alredy.existsInput"))
					&& StringUtils.isNotEmpty(PropertiesRepository.getString("new-atitesting.steps.headerLoc"))) {

				// Enter Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.passwordLoc"),PropertiesRepository.getString("new-atitesting.passwordInput"));

				// Confirm Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.confirmPasswordLoc"),PropertiesRepository.getString("new-atitesting.passwordInput"));

				// Enter Email
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.emailLoc"),email);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				tutorialPage.clickButtonFromList("new-atitesting.createaccount.confirm.email.loc", 0);	
				
				// confirm email
				log(logger, "confirm email");
				//tutorialPage.enterText("new-atitesting.createaccount.confirm.email.loc", email,0);
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.confirm.email.loc"),email);
				
				WebElement ele=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.createaccount.confirm.email.loc"));
				ele.sendKeys(Keys.TAB);
				tutorialPage.clickButtonFromList("new-atitesting.createaccount.addProductContinueBtnLoc", 0);	
				
				// fetching text
				result = textHandler.getText("#ui-id-4");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			} else {
				logger.info("Method: verifyStep1:::::User Already Exists");
			}
			
			
		} catch (Exception exp) {
			throw new DriverException("Method: verifyStep1:::::Unable to verify step1" + exp);
		}
		logger.info("Method: verifyStep1 Ends result --> " + result);
		return result;
	}
	/**
	 * @author Devika.RS
	 * @param input
	 * @throws DriverException
	 */
	public void enterUserName(String input) throws Exception {
		logger.info("Method : enterUserName :::::::: STARTS");

		try {
			// enter username
			//long input=System.currentTimeMillis();
			textHandler.writeText(PropertiesRepository
					.getString("new-atitesting.usernameLoc"),input);
			clickTab(PropertiesRepository.getString("new-atitesting.usernameLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (DriverException e) {
			throw new DriverException(
					"Unable to enter User name in text field ", e);
		}

		logger.info("Method : enterUserName :::::::: END");
	}
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public String verifyStep2() throws DriverException {
		logger.info("Method: verifyStep2 Starts");
		String result = null;
		try {
			// select 1st security question
			Select selDrop = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.dropdown1Loc"));
			dropDownHandler.selectByVisibleText(selDrop, PropertiesRepository
					.getString("new-atitesting.first.security.qtnInput"));

			// Enter answer for 1st security question
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.answer1Loc"),PropertiesRepository.getString("new-atitesting.answerfor.all.securityQtnInput"));

			// select 2nd security question
			Select selDrop1 = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.dropdown2Loc"));
			dropDownHandler.selectByVisibleText(selDrop1, PropertiesRepository.getString("new-atitesting.second.security.qtnInput"));

			// Enter answer for 2nd security question
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.answer2Loc"),PropertiesRepository
									.getString("new-atitesting.answerfor.all.securityQtnInput"));

			// select 3rd security question
			Select selDrop2 = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.dropdown3Loc"));
			dropDownHandler.selectByVisibleText(selDrop2, PropertiesRepository
					.getString("new-atitesting.third.security.qtnInput"));

			// Enter answer for 3rd security question
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.answer3Loc"),
							PropertiesRepository.getString("new-atitesting.answerfor.all.securityQtnInput"));

			// click on continue button
			btnHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.continueButtonLoc"));
			result = textHandler.getText("#ui-id-4");
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep2:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep2 Ends result --> " + result);
		// fetching text
		return result;
	}
/**
 * @author Devika.RS
 * @return
 * @throws DriverException
 */
	public String verifyStep3() throws DriverException {
		logger.info("Method: verifyStep3 Starts");
		String result = null;
		try {
			// enter 1st name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.firstNameLoc"),
					PropertiesRepository.getString("new-atitesting.firstNameInpt"));
			// enter last name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.lastNameLoc"),
					PropertiesRepository.getString("new-atitesting.lastNameInpt"));
			// enter address1
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.address1Loc"),
					PropertiesRepository.getString("new-atitesting.address1Input"));
		
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.cityLoc"),
					PropertiesRepository.getString("new-atitesting.cityInpt"));

			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.zipLoc"), PropertiesRepository
					.getString("new-atitesting.zipCodeInpt"));

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,PropertiesRepository.getString("new-atitesting.countryInpt"));

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,PropertiesRepository.getString("new-atitesting.stateInpt"));

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// enter phone number
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.phoneLoc"),PropertiesRepository.getString("new-atitesting.phoneInpt"));

			// click on continue button
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
			result = textHandler.getText("#ui-id-4");
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep3:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep3 Ends");
		return result;
	}
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
		public boolean verifyStep3MandatoryZipCode() throws DriverException {
			logger.info("Method: verifyStep3MandatoryZipCode Starts");
			boolean result = false;
			try {
				// enter 1st name
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.firstNameLoc"),
						PropertiesRepository.getString("new-atitesting.firstNameInpt"));
				// enter last name
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.lastNameLoc"),
						PropertiesRepository.getString("new-atitesting.lastNameInpt"));
				// enter address1
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.address1Loc"),
						PropertiesRepository.getString("new-atitesting.address1Input"));
			
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.cityLoc"),
						PropertiesRepository.getString("new-atitesting.cityInpt"));

				// enter zipcode
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.zipLoc"), PropertiesRepository
						.getString("new-atitesting.zipCodeInpt"));

				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

				// select country
				Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.countrydropdownLoc"));
				dropDownHandler.selectByVisibleText(selCountry,PropertiesRepository.getString("new-atitesting.countryInpt"));

				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

				// select state
				Select selState = dropDownHandler.getDropDown(PropertiesRepository
						.getString("new-atitesting.statedropdownLoc"));
				dropDownHandler.selectByVisibleText(selState,PropertiesRepository.getString("new-atitesting.stateInpt"));

				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				/*
				// enter phone number
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.phoneLoc"),PropertiesRepository.getString("new-atitesting.phoneInpt"));

				// click on continue button
				btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));*/
				result = verifyZipCodeMandatory();
			} catch (Exception e) {
				throw new DriverException(
						"Method: verifyStep3MandatoryZipCode:::::Unable to locate element" + e);
			}
			logger.info("Method: verifyStep3MandatoryZipCode Ends result --> " + result);
			return result;
		}
	
		private boolean verifyZipCodeMandatory() throws Exception {
			logger.info("Method : verifyZipCodeMandatory Start");
			boolean flag = false;
			try {
				List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.user.creation.zipcode.mandatory.star.loc"));
				if(CollectionUtils.isNotEmpty(element) && element.get(0).getAttribute("style").equalsIgnoreCase("")) {
					flag = true;
				}
			}catch (Exception e) {
	    		logger.info("Unable to verifyZipCodeMandatory" );
				log(logger, "Unable to verifyZipCodeMandatory" );
	    		throw new DriverException("Unable to verifyZipCodeMandatory" , e); 
	    	}
			logger.info("Method: verifyZipCodeMandatory End flag --> " + flag);
			return flag;
		}
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public String verifyStep3OtherCountryFull(String countryName, String stateName, String postalCode, String phoneNumber) throws DriverException {
		logger.info("Method: verifyStep3OtherCountryFull Starts");
		String result = null;
		try {
			// enter 1st name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.firstNameLoc"),
					PropertiesRepository.getString("new-atitesting.firstNameInpt"));
			// enter last name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.lastNameLoc"),
					PropertiesRepository.getString("new-atitesting.lastNameInpt"));
			// enter address1
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.address1Loc"),
					PropertiesRepository.getString("new-atitesting.address1Input"));
		
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.cityLoc"),
					PropertiesRepository.getString("new-atitesting.cityInpt"));

			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.zipLoc"), postalCode);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,countryName);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,stateName);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// enter phone number
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.phoneLoc"),phoneNumber);

			// click on continue button
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
			result = textHandler.getText("#ui-id-4");
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep3OtherCountryFull:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep3OtherCountryFull Ends");
		return result;
	}
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public String verifyStep3OtherCountryPartial(String countryName, String stateName, String postalCode, String phoneNumber) throws DriverException {
		logger.info("Method: verifyStep3OtherCountryPartial Starts");
		String result = null;
		try {
			// enter zipcode
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.zipLoc"), postalCode);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select country
			Select selCountry = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.countrydropdownLoc"));
			dropDownHandler.selectByVisibleText(selCountry,countryName);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// select state
			Select selState = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.statedropdownLoc"));
			dropDownHandler.selectByVisibleText(selState,stateName);

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// enter phone number
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.phoneLoc"),phoneNumber);

			// click on continue button
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
			result = textHandler.getText("#ui-id-4");
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep3OtherCountryPartial:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep3OtherCountryPartial Ends");
		return result;
	}
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws InterruptedException
	 * @throws DriverException
	 */
	public String verifyStep4() throws InterruptedException, DriverException {
		logger.info("Method: verifyStep4 starts");
		try {
			enterInstitutionName(PropertiesRepository.getString("new-atitesting.createaccount.autoFillLoc.new"),
					PropertiesRepository.getString("new-atitesting.createaccount.institution.value"));

			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.createaccount.institution.click"));

			// enter student id
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.studentidLoc"),PropertiesRepository.getString("new-atitesting.studentIdInput"));

			// enter credentials
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.credentialsLoc"),PropertiesRepository.getString("new-atitesting.credntialsInput"));

			// select graduation date
			selectDatePicker(PropertiesRepository.getString("new-atitesting.expectdgraduateddateLoc"),
					PropertiesRepository.getString("new-atitesting.graduationDateInput"));
			String strCurrentPage = textHandler.getText("#ui-id-4");
			
			logger.info("Current Page Header -->  " + strCurrentPage);
			WebElement textAreaElement = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
					
			if(baseHandler.isEnabled(textAreaElement)) {
				logger.info("Continue Element is enabled");
				if(baseHandler.isDisplayed(textAreaElement)) {
					logger.info("Continue Element is dispalyed");
					//windowHandler.switchToMainWindow();
					btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.studentidLoc"));
					btnHandler.clickButtonWithWait(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
				}
			}
			
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep4:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep4 Ends");
		String strNewPage = textHandler.getText("#ui-id-4");
		logger.info("New Page Header -->  " + strNewPage);
		return textHandler.getText("#ui-id-4");
	}
/**
 * @author Devika.RS
 * @param textFieldLoc
 * @param input
 * @throws DriverException
 */
	public void enterInstitutionName(String textFieldLoc, String input)
			throws Exception {
		logger.info("Method : enterInstitutionName :::::::: STARTS");

		try {
			// enter username
			textHandler.writeText(textFieldLoc, input);
			clickTab(textFieldLoc);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (DriverException e) {
			throw new DriverException(
					"Unable to enter Institution Name in text field ", e);
		}

		logger.info("Method : enterInstitutionName :::::::: END");
	}
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	
	public String verifyStep5() throws DriverException {

		logger.info("Method: verifyStep5 Starts");
		try {
			// select gender
			Select selGender = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.genderdropdownLoc"));
			dropDownHandler.selectByVisibleText(selGender, PropertiesRepository.getString("new-atitesting.genderDropdownInput"));

			// select birth day date
			selectDatePicker(PropertiesRepository.getString("new-atitesting.birthDateLoc"),PropertiesRepository.getString("new-atitesting.birthDateInput"));
			// select language
			Select selLanguage = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.primaryLanguageLoc"));
			dropDownHandler.selectByVisibleText(selLanguage,PropertiesRepository.getString("new-atitesting.languageDropdownInput"));

			// click on continue button
			btnHandler.clickButtonWithWait(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
		} catch (Exception e) {
			throw new DriverException("Method: verifyStep5:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep5 Ends");
		return textHandler.getText("#ui-id-4");
	}
/**
 * @author Devika.RS
 * @return
 * @throws DriverException
 */
	public String verifyStep6() throws DriverException {
		logger.info("Method: verifyStep6 Starts");
		try {
			
			// select check box
			checkBoxHandler.selectCheckbox(PropertiesRepository.getString("new-atitesting.checkboxLoc"));
			
			// click on continue button
			btnHandler.clickButtonWithWait(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));
			logger.info("Method: completeStep6 Ends");
			
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep6:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep6 Ends");
		return getText("#ui-id-4");
	}
	
	/**
	 * @author Devika.RS
	 */
	public boolean verifyStep7() throws DriverException {
		//logger.info("Method: verifyStep7 Starts");
		try {
			// select check box
			checkBoxHandler.selectCheckbox(PropertiesRepository.getString("new-atitesting.agree.checkboxLoc"));

			// click on register button
			//btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.registerLoc"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"))));
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyStep7:::::Unable to locate element" + e);
		}
		logger.info("Method: verifyStep7 Ends");
		return checkElementEnabled(PropertiesRepository.getString("new-atitesting.homePage.welcomeDialogueBoxLoc"));
	}

	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public boolean clickOnStudentGettingStarted() throws DriverException {
		logger.info("Method : clickOnStudentGettingStarted :::::::: STARTS");
		try {
			// click on student getting start button.
			windowHandler.switchToMainWindow();
			btnHandler.clickButtonWithWait(PropertiesRepository.getString("new-atitesting.createaccount.student.getting.startedLoc"),PropertiesRepository.getString("new-atitesting.createaccount.student.getting.startedvideoDialogueBoxLoc"));

		} catch (Exception e) {
			throw new DriverException("Unable to click on student getting start button", e);
		}
		logger.info("Method : clickOnStudentGettingStarted :::::::: Ends");
		return checkElementEnabled(PropertiesRepository
				.getString("new-atitesting.createaccount.student.getting.startedvideoDialogueBoxLoc"));
	}
	
	
	/**
	 * @author Devika.RS
	 * @return
	 * @throws DriverException
	 */
	public boolean clickOnWelcomeNewAti() throws DriverException{
		logger.info("Method : clickOnWelcomeNewAti :::::::: STARTS");
		try{
			// click on student getting start button
			Thread.sleep(7000);
						btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.createaccount.student.getting.startedToNewAtiLoc"));
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (Exception e) {
			throw new DriverException(
					"Unable to click on student getting start button", e);
		}
		
		logger.info("Method : clickOnWelcomeNewAti :::::::: Ends");
		return checkElementEnabled(PropertiesRepository.getString("new-atitesting.createaccount.addProductButtonLoc"));
	}
	/**
	 * @author Devika.RS
	 * @throws DriverException
	 */
	
	public void clickOnAddProductButton() throws DriverException {
		logger.info("Method : clickOnAddProductButton :::::::: Starts");
		try {
			// click on Add Product button
			btnHandler
					.clickButton(PropertiesRepository
							.getString("new-atitesting.createaccount.addProductButtonLoc"));
			waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");

		} catch (Exception e) {
			throw new DriverException("Unable to click on Add Product Button",
					e);
		}
		logger.info("Method : clickOnAddProductButton :::::::: Ends");
	}

	/**
	 * @author Devika.RS
	 * @throws DriverException
	 */
	public void enterCDNToAddProduct() throws DriverException{
		logger.info("Method : enterCDNToAddProduct :::::::: Starts");
		result = null;
		String environment = getEnvironment();
		logger.info("Method : enterCDNToAddProduct getEnvironment :::::::: " + environment);
		try{
			if("Production".equalsIgnoreCase(environment)) {
				result =  PropertiesRepository.getString("new-atitesting.createaccount.addProductCDNValue");
			
			} else if("Stage".equalsIgnoreCase(environment)) {
				result = PropertiesRepository.getString("new-atitesting.createaccount.stage.addProductCDNValue");
			} else {
				result = PropertiesRepository.getString("new-atitesting.createaccount.qa.addProductCDNValue");
			}
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"),result);
			setCdnProductId(result);
		}
		catch (Exception e) {
			throw new DriverException(
					"Unable to Enter CDN to Add Product Button", e);
		}
		logger.info("Method : enterCDNToAddProduct :::::::: Ends " + result);
	}
	
	/*
	 * 
	 */
	public void setCdnProductId(String cdnProductId) {
	}
	
	/**
	 * @author Devika.RS
	 * @param buttonLoc
	 * @return
	 */
	public String clickOnButton(String buttonLoc)  {
		logger.info("Method : clickOnAddProductContinueButton :::::::: Starts");
		result = null;
		try {
			// click on Add Product button
			btnHandler.clickButton(
					PropertiesRepository.getString(buttonLoc));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
		}
		logger.info("Method : clickOnAddProductContinueButton :::::::: End  " + result);
		return result;
	}
	/**
	 * @author Devika.RS
	 * @param loc
	 * @param index
	 * @throws Exception 
	 */
	public void selectTab(String loc,int index) throws Exception
	{
	
		try {
			List<WebElement> findElement = driver.findElements(By.cssSelector(loc));
			if(findElement.size()>0)
			findElement.get(index).click();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			Thread.sleep(8000); // Testcase : VerifyBatchtIDinProductIDTest , thread.sleep() has to be used
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 */
	public boolean clickLinkFromList(String loc,int index)
	{
		boolean viewStatus=false;
		WebElement webElement=null;
		
			try {
				Thread.sleep(7000); // Here Thread.sleep() is required to handle wait.
 				List<WebElement> activeAssessmentList = driver.findElements(By.cssSelector(loc));
				if(activeAssessmentList.size()>0)
				{
					 try {
						 webElement = activeAssessmentList.get(index);
						 btnHandler.clickButton(webElement);
						viewStatus=true;
					} catch (DriverException e) {
					}
					 
				}
				else 
				{
					String textFromList = getTextFromLst("new-atitesting.homepage.myatitab.testtab.nodata.loc",0);
					if(PropertiesRepository.getString("new-atitesting.homepage.myatitab.testtab.nodata").equals(textFromList))
					viewStatus=false;
				}
			} catch (InterruptedException e) {
			}
		return viewStatus;
	}
	/*
	 * 
	 */
	public String getTextFromLst(String loc,int size)
	{
		List<WebElement> listOfElements = driver.findElements(By.cssSelector(PropertiesRepository
				.getString(loc)));
		String name = listOfElements.get(size).getText().trim();
		return name;
		
	
	}
	
	/*
	 * 
	 */
	public boolean verifyCDNinProduct(String loc,int index) {
		boolean status=false;
		String productId = getTextFromLst(loc, 1);
		if(productId!=null && !productId.isEmpty())
		{
			String batchid=productId.split("-")[0];
			if(batchid!=null && !batchid.isEmpty() && PropertiesRepository
					.getString("new-atitesting.createaccount.stage.addProductCDNValue").equals(batchid))
			{
								status=true;
			}
		}
		return status;
		
	}
	
	/**
	 * Edit Address
	 * @author syed.pasha
	 * @throws Exception
	 */
	public void editAddress() throws Exception {
		try {
			clickButton(PropertiesRepository.getString("new-atitesting.edit.addr.link"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.addr.input"), PropertiesRepository.getString("new-atitesting.edit.add2.value"));
			clickButton(PropertiesRepository.getString("new-atitesting.edit.addr.save.link"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Edit Email
	 * @author syed.pasha
	 * @throws Exception
	 */
	public String editEmail() throws Exception {
		String email = "" ;
		try {
			 email = "test"+System.currentTimeMillis()/1000+"@gg.com" ; 
			clickButton(PropertiesRepository.getString("new-atitesting.edit.email.link"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.email.input"), email);
			clickButton(PropertiesRepository.getString("new-atitesting.edit.confirmEmail.input"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.confirmEmail.input"), email);
			clickButton(PropertiesRepository.getString("new-atitesting.edit.email.input"));
			clickButton(PropertiesRepository.getString("new-atitesting.edit.email.save.link"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}
	
	/**
	 * Edit Password
	 * @author syed.pasha
	 * @throws Exception
	 */
	public void editPassword() throws Exception {
		try {
			clickButton(PropertiesRepository.getString("new-atitesting.edit.password.link"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.oldPassword.input"), PropertiesRepository.getString("new-atitesting.edit.oldPass.value"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.newPassword.input"), PropertiesRepository.getString("new-atitesting.edit.newPass.value"));
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.edit.confirmNewPassword.input"), PropertiesRepository.getString("new-atitesting.edit.confirmNewPass.value"));
			clickButton(PropertiesRepository.getString("new-atitesting.edit.password.save.link"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verify if Security Questions are Displayed
	 * @author syed.pasha
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIfSecurityQuestionsDisplayed() throws Exception{
		logger.info("Method : verifyIfSecurityQuestionsDisplayed :::::::: STARTS");
		boolean flag = false;
		try{
			clickButton(PropertiesRepository.getString("new-atitesting.edit.secQues.link"));
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.securityQuestiion.present"));
			if(elements!=null && elements.get(0).isDisplayed() && elements.get(1).isDisplayed() && elements.get(2).isDisplayed())
			{
				flag = true;
			}			
		} catch (Exception e) {
			throw new Exception("Security Question's not dislapyed", e);
		}		
		logger.info("Method : verifyIfSecurityQuestionsDisplayed :::::::: Ends");
		return flag;
	}
	
	/**
	 * Verify if Security Questions Answers are Displayed
	 * @author syed.pasha
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIfSecurityQuestionsAnswersDisplayed() throws Exception{
		logger.info("Method : verifyIfSecurityQuestionsAnswersDisplayed :::::::: STARTS");
		boolean flag = false;
		try{
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.securityQuestiion.answers.present"));
			if(elements!=null && elements.get(0).isDisplayed() && elements.get(1).isDisplayed() && elements.get(2).isDisplayed())
			{
				flag = true;
			}			
		} catch (Exception e) {
			throw new Exception("Security Question Answers not dislapyed", e);
		}		
		logger.info("Method : verifyIfSecurityQuestionsAnswersDisplayed :::::::: Ends");
		return flag;
	}

	
	
	/*public String verifyStep1() throws DriverException {
		logger.info("Method:verifyStep1 START");
		String result = null;
		try {
			// Enter UserName
			enterUserName(PropertiesRepository.getString("new-atitesting.usernameInput"));
			
			// fetching text
			result = textHandler.getText(PropertiesRepository.getString("new-atitesting.username.already.exists"));
			
			// Checking username is already exist or not
			if (!result.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.user.alredy.existsInput"))
					&& StringUtils.isNotEmpty(PropertiesRepository.getString("new-atitesting.steps.headerLoc"))) {

				// Enter Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.passwordLoc"),
						"password1");

				// Confirm Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.confirmPasswordLoc"),
						"password1");

				// Enter Email
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.emailLoc"),
						"roysid81911@gmail.com");

				// confirm email
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.confirmEmailLoc"),
						"roysid81911@gmail.com");
				
				clickTextBoxTab(PropertiesRepository
						.getString("new-atitesting.confirmEmailLoc"));
				
				// click on continue button
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueButtonLoc"));

				// fetching text
				result = textHandler.getText(PropertiesRepository.getString("new-atitesting.steps.headerLoc"));
			} else {
				logger.info("Method: verifyStep1:::::User Already Exists");
			}
		} catch (Exception exp) {
			throw new DriverException("Method: verifyStep1:::::Unable to verify step1" + exp);
		}
		logger.info("Method: verifyStep1 Ends");
		return result;
	}
	
	public void enterUserName(String input) throws Exception {
		logger.info("Method : enterUserName :::::::: STARTS");
		try {
			textHandler.writeText(PropertiesRepository
					.getString("new-atitesting.usernameLoc"),input);
			clickTextBoxTab(PropertiesRepository
					.getString("new-atitesting.usernameLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (DriverException e) {
			throw new DriverException(
					"Unable to enter User name in text field ", e);
		}

		logger.info("Method : enterUserName :::::::: END");
	}
	
	public void clickTextBoxTab(String loc) {
		logger.info("Method : clickTextBoxTab :::::::: START");
		driver.findElement(By.cssSelector(loc)).sendKeys(Keys.TAB);
		logger.info("Method : clickTextBoxTab :::::::: END");

	}*/
	/**
	  * @author sasmita
	  */
	 public boolean acceptTermsAndConditionsForNewUser() throws DriverException {
	  logger.info("Method: acceptTermsAndConditionsForNewUser Starts");
	  boolean flag=false;
	  try {
	   // select check box
	   if(driver.findElement(By.cssSelector("label[for='ATITermsConsent'] span[class='checkbox-not-checked']")).isDisplayed())
	   {
	   checkBoxHandler.selectCheckbox(PropertiesRepository.getString("new-atitesting.agree.term&condition.checkboxLoc"));

	   // click on register button
	   //btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.registerLoc"));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"))));
	   btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"));
	   waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	   flag=true;
	   }

	  } catch (Exception e) {
	   throw new DriverException(
	     "Method: acceptTermsAndConditionsForNewUser:::::Unable to locate element" + e);
	  }
	  logger.info("Method: acceptTermsAndConditionsForNewUser Ends--->flag");
	  return flag;
	 }
	
}

