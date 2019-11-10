package com.automation.id.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.CheckboxHandler;

public class EditProfilePage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public ButtonHandler buttonHandler;
	public CheckboxHandler checkBoxHandler;
	
	public EditProfilePage(WebDriver webDriver) {	
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
		checkBoxHandler = new CheckboxHandler(driver);
	}

	/**
	 * This method is used to click element
	 * 
	 * @param loc
	 * @param size
	 * @throws DriverException
	 */
	public void clickElement(String loc, int size) throws DriverException {

		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository
					.getString("id.common.page.loader"));
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {

				element.get(size).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository
						.getString("id.common.page.loader"));
			}
		} catch (Exception e) {
			throw new DriverException("error in verify element");
		}
	}

	public boolean verifyPersonalSectionInfo(String loc, String input)
			throws DriverException {
		logger.info("Method: verifyPersonalSectionInfo Start");
		List<Boolean> list = new ArrayList<Boolean>();
		try {
			String[] inputList = PropertiesRepository.getStringAsArray(input);
			List<WebElement> personelSectionLoc = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(personelSectionLoc)) {
				for (int i = 1; i < personelSectionLoc.size(); i++) {
					if (personelSectionLoc.get(i).getText()
							.contains(inputList[i])) {
						list.add(true);
					} else {
						list.add(false);
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPersonalSectionInfo");
			log(logger, "Unable to verifyPersonalSectionInfo");
			throw new DriverException("Unable to verifyPersonalSectionInfo", e);
		}
		logger.info("Method: verifyPersonalSectionInfo End flag");
		return list.contains(true) ? true : false;
	}

	public boolean verifyPersonalInfo(String loc, String input)
			throws DriverException {
		logger.info("Method: verifyPersonalSectionInfo Start");
		List<Boolean> list = new ArrayList<Boolean>();
		try {
			String[] inputList = PropertiesRepository.getStringAsArray(input);
			List<WebElement> personelSectionLoc = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(personelSectionLoc)) {
				for (int i = 0; i < personelSectionLoc.size(); i++) {
					if (personelSectionLoc.get(i).getText()
							.contains(inputList[i])) {
						list.add(true);
					} else {
						list.add(false);
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPersonalSectionInfo");
			log(logger, "Unable to verifyPersonalSectionInfo");
			throw new DriverException("Unable to verifyPersonalSectionInfo", e);
		}
		logger.info("Method: verifyPersonalSectionInfo End flag");
		return list.contains(true) ? true : false;
	}

	public void enterText(String loc, String input, int index)
			throws DriverException {
		logger.info("Method: enter Text Start");
		try {
			List<WebElement> webElements = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(webElements)) {
				webElements.get(index).clear();
				webElements.get(index).sendKeys(
						PropertiesRepository.getStringAsArray(input));
			}

		} catch (Exception e) {
			logger.info("Unable to enter Text");
			log(logger, "Unable to enter Text");
			throw new DriverException("Unable to enter Text", e);
		}
		logger.info("Method: enterText End");
	}

	public String enterTextDynamically(String loc, int index)
			throws DriverException {
		logger.info("Method: enter Text Start");
		String email = "";
		try {
			Random rand = new Random();
			int randomNum = rand.nextInt(1000);
			email = "test" + randomNum + "@gmail.com";
			
			// Entering new Email ID. 
			List<WebElement> email1Elements = baseHandler
					.findElements(PropertiesRepository.getString("id.home.profile.account.setting.sign.in.section.email1.loc"));
			// Entering confirm Email ID.
			List<WebElement> email2Elements = baseHandler
					.findElements(PropertiesRepository.getString("id.home.profile.account.setting.sign.in.section.email2.loc"));
			if(CollectionUtils.isNotEmpty(email1Elements) && CollectionUtils.isNotEmpty(email2Elements)) {
				email1Elements.get(0).clear();
				email1Elements.get(0).click();
				email1Elements.get(0).sendKeys(email);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				email2Elements.get(0).clear();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				email2Elements.get(0).click();
				email2Elements.get(0).sendKeys(email);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			/*
			// Clicking on Email Arrow.
			List<WebElement> emailArrowElement = baseHandler.findElements("mat-icon[class='expand_icon mat-icon material-icons ng-star-inserted']");
			if(CollectionUtils.isNotEmpty(emailArrowElement)) {
				emailArrowElement.get(2).click();
				
				
			}*/
			/*List<WebElement> webElements = baseHandler
					.findElements("input[id='Email1']");
			if (CollectionUtils.isNotEmpty(webElements)) {
				webElements.get(index).clear();
				webElements.get(index).sendKeys(email);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository
						.getString("id.common.page.loader"));
			}*/

		} catch (Exception e) {
			logger.info("Unable to enter Text");
			log(logger, "Unable to enter Text");
			throw new DriverException("Unable to enter Text", e);
		}
		logger.info("Method: enterText End");
		return email;
	}

	public void enterValue(String loc, String input, int index)
			throws DriverException {
		logger.info("Method: enter Text Start");
		try {
			List<WebElement> webElements = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(webElements)) {
				webElements.get(index).clear();
				webElements.get(index).sendKeys(input);
			}
		} catch (Exception e) {
			logger.info("Unable to enter Text");
			log(logger, "Unable to enter Text");
			throw new DriverException("Unable to enter Text", e);
		}
		logger.info("Method: enterText End");
	}
	
	public boolean verifyEmailNotChecked() throws Exception {
		logger.info("Method: verifyEmailNotChecked Start");
		boolean flag = false;
		try { 
			// Not Checked
			List<WebElement> notEnabledElement = verifyElementList("mat-slide-toggle[class='focus-element-flag mat-slide-toggle mat-accent ng-untouched ng-pristine ng-valid']");
			if(CollectionUtils.isNotEmpty(notEnabledElement)) {
				// to check the checkbox
				verifyAndClick("mat-slide-toggle input", true);
				//waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			} else {
				logger.info("Email is checked already");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyEmailNotChecked");
			log(logger, "Unable to verifyEmailNotChecked");
			throw new DriverException("Unable to verifyEmailNotChecked", e);
		}
		logger.info("Method: verifyEmailNotChecked End flag --> " + flag);
		return flag;
	
	}
	
	public boolean verifyEmailChecked() throws Exception {
		logger.info("Method: verifyEmailChecked Start");
		boolean flag = false;
		try { 
			List<WebElement> enabledElement = verifyElementList("mat-slide-toggle[class='focus-element-flag mat-slide-toggle mat-accent mat-checked ng-untouched ng-pristine ng-valid']");
			if(CollectionUtils.isNotEmpty(enabledElement)) {
				// to check the checkbox
				verifyAndClick("mat-slide-toggle input", true);
				//waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			} else {
				logger.info("Email is not checked already");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyEmailChecked");
			log(logger, "Unable to verifyEmailChecked");
			throw new DriverException("Unable to verifyEmailChecked", e);
		}
		logger.info("Method: verifyEmailChecked End flag --> " + flag);
		return flag;
	
	}
	
	/**
	 * Method used to verify Edit profile sub-tab is displayed.
	 * 
	 * @author kumarisagarika.t
	 * @throws DriverException
	 */
	public boolean verifyEditProfileSubTab() throws DriverException {
		logger.info("Method: verifyEditProfileSubTab Start");
		boolean flag = false;
		try { 
			// Not Checked
			List<WebElement> editProfileSubTab = verifyElementList(".mat-tab-label-content");
			if(CollectionUtils.isNotEmpty(editProfileSubTab))
			{
				for(int i=0;i<editProfileSubTab.size();i++)
				{
					String tabs=editProfileSubTab.get(i).getText();
					logger.info("able to verify" +" "+ tabs);
				}flag=true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyEditProfileSubTab");
			log(logger, "Unable to verifyEditProfileSubTab");
			throw new DriverException("Unable to verifyEditProfileSubTab", e);
		}
		logger.info("Method: verifyEditProfileSubTab End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Edit profile tabs displayed
	 * 
	 * @author kumarisagarika.t
	 * @throws DriverException
	 */
	public boolean verifyEditProfile() throws DriverException {
		logger.info("Method: verifyEditProfile Start");
		boolean flag = false;
		try { 
			// Not Checked
			WebElement signIn = verifyElement(PropertiesRepository.getString("id.login.editProfile.signIn"));
			WebElement personal=verifyElement(PropertiesRepository.getString("id.login.editProfile.personal"));
			WebElement institution=verifyElement(PropertiesRepository.getString("id.login.editProfile.institution"));
			List<WebElement> demographic=verifyElementList(PropertiesRepository.getString("id.login.editProfile.demographic"));
			//flag=signIn.isDisplayed();
			//flag=personal.isDisplayed();
			//flag=institution.isDisplayed();
			//flag=demographic.get(0).isDisplayed();
			if(signIn.isDisplayed() && personal.isDisplayed() && institution.isDisplayed() && demographic.get(0).isDisplayed()){
				flag=true;
				log(logger , "successfully verified SignIn, Personal, institution,demographic sections");
			}
			
		} catch (Exception e) {
			logger.info("Unable to verifyEditProfile");
			log(logger, "Unable to verifyEditProfile");
			throw new DriverException("Unable to verifyEditProfile", e);
		}
		logger.info("Method: verifyEditProfile End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Edit profile terms & condition sub-tabs displayed
	 * 
	 * @author kumarisagarika.t
	 * @throws DriverException
	 */
	public boolean verifyTermsConditionContents() throws DriverException {
		logger.info("Method: verifyTermsConditionContents Start");
		boolean flag = false;
		try { 
			// Not Checked
			WebElement privacyPolicy = verifyElement(PropertiesRepository.getString("id.login.editProfile.privacyPolicy"));
			WebElement Website=verifyElement(PropertiesRepository.getString("id.login.editProfile.website"));
			WebElement facultyTC=verifyElement(PropertiesRepository.getString("id.login.editProfile.facultyTC"));
			WebElement userTC=verifyElement(PropertiesRepository.getString("id.login.editProfile.userTC"));
			
			if(privacyPolicy.isDisplayed() && Website.isDisplayed() && facultyTC.isDisplayed() && userTC.isDisplayed()){
				flag=true;
				log(logger , "successfully verified Privacy policy, website terms of use, Faculty terms & condition,User terms & conditon");
			}
			
		} catch (Exception e) {
			logger.info("Unable to verifyTermsConditionContents");
			log(logger, "Unable to verifyTermsConditionContents");
			throw new DriverException("Unable to verifyTermsConditionContents", e);
		}
		logger.info("Method: verifyTermsConditionContents End flag --> " + flag);
		return flag;
	}
	
	
	
	/**
	 * Method used to verify ATI Email is enabled.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public boolean verifyATIEmailEnabled() throws DriverException {
		logger.info("Method: verifyATIEmailEnabled Start");
		boolean flag = false;
		try { 
			// Not Checked
			List<WebElement> notEnabledElement = verifyElementList("mat-slide-toggle[class='focus-element-flag mat-slide-toggle mat-accent ng-valid ng-dirty ng-touched']");
			if(CollectionUtils.isNotEmpty(notEnabledElement)) {
				// to check the checkbox
				verifyAndClick("mat-slide-toggle input", true);
			} else {
				List<WebElement> enabledElement = verifyElementList("mat-slide-toggle[class='focus-element-flag mat-slide-toggle mat-accent ng-valid ng-dirty ng-touched mat-checked']");
				if(CollectionUtils.isNotEmpty(enabledElement)) {
					// to check the checkbox
					verifyAndClick("mat-slide-toggle input", true);
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyATIEmailEnabled");
			log(logger, "Unable to verifyATIEmailEnabled");
			throw new DriverException("Unable to verifyATIEmailEnabled", e);
		}
		logger.info("Method: verifyATIEmailEnabled End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify ATI Email is disabled.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public boolean verifyATIEmailDisabled() throws DriverException {
		logger.info("Method: verifyATIEmailDisabled Start");
		boolean flag = false;
		try { 
			List<WebElement> disabledElement = verifyElementList(".mpanel md-slide-toggle[class='focus-element-flag mat-slide-toggle ng-untouched ng-pristine ng-valid']");
			List<WebElement> disabledAnotherElement = verifyElementList(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.disabled.another.loc"));
			if(CollectionUtils.isNotEmpty(disabledElement) || CollectionUtils.isNotEmpty(disabledAnotherElement)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyATIEmailDisabled");
			log(logger, "Unable to verifyATIEmailDisabled");
			throw new DriverException("Unable to verifyATIEmailDisabled", e);
		}
		logger.info("Method: verifyATIEmailDisabled End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify ATI Email is enabled/ disabled.
	 * If enabled, check for disabled.
	 * If disabled, check for enabled.
	 *
	 * @param enabled
	 * @param disabled
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyATIEmailPropertyValue(boolean enabled, boolean disabled)
			throws DriverException {
		logger.info("Method: verifyATIEmailDisabled Start");
		boolean flag = false;
		try {
			if (enabled) {
				List<WebElement> disabledElement = verifyElementList(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.disabled.loc"));
				List<WebElement> disabledAnotherElement = verifyElementList(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.disabled.another.loc"));
				if (CollectionUtils.isNotEmpty(disabledElement) || CollectionUtils.isNotEmpty(disabledAnotherElement)) {
					flag = true;
				}
			} else if (disabled) {
				List<WebElement> enabledElement = verifyElementList(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.enabled.loc"));
				List<WebElement> enabledAnotherElement = verifyElementList(PropertiesRepository.getString("id.home.profile.account.setting.ati.email.enabled.another.loc"));
				if (CollectionUtils.isNotEmpty(enabledElement) || CollectionUtils.isNotEmpty(enabledAnotherElement)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyATIEmailDisabled");
			log(logger, "Unable to verifyATIEmailDisabled");
			throw new DriverException("Unable to verifyATIEmailDisabled", e);
		}
		logger.info("Method: verifyATIEmailDisabled End flag --> " + flag);
		return flag;
	}

	
	/**
	 * Method used to verify text for each section under Terms and Conditions section in Edit Profile. 
	 * 
	 * @author saravanan.jothimani
	 * @param value
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTermsAndConditionSection(String locator, String value) throws DriverException {
		//logger.info("Method: verifyTermsAndConditionSection Starts");
		boolean flag = false;
		locator = "li[class='titleName']";
		try {
			List<WebElement> element = baseHandler
					.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					WebElement valueElement = element.get(index);
					if (valueElement != null) {
						String text = valueElement.getText().trim();
						if (value.equalsIgnoreCase(text)) {
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTermsAndConditionSection");
			log(logger, "Unable to verifyTermsAndConditionSection");
			throw new DriverException(
					"Unable to verifyTermsAndConditionSection", e);
		}
		logger.info("Method: verifyTermsAndConditionSection End flag --> "
				+ flag);
    	return flag;
	}
	

	/**
	 * Method used to click on menu.
	 * 
	 * @param menuName
	 * @throws Exception
	 */
	public void clickSystemAdmin(String menuName) throws Exception {
		logger.info("Method: clickMenu " + menuName + " Starts");
		try {
			WebElement menuElement = baseHandler
					.findElement(PropertiesRepository.getString("current-atitesting.mu.main.menu.loc"));
			menuElement.click();
			/*
			 * Actions act = new Actions(driver);
			 * act.moveToElement(menuElement).build().perform();
			 */
		} catch (Exception e) {
			logger.info("Unable to click Menu");
			log(logger, "Unable to click Menu");
			throw new DriverException("Unable to click Menu", e);
		}
		logger.info("Method: clickMenu " + menuName + " End ");
	}
	
	/**
	 * Method used to click menu under System Administration.
	 * 
	 * @author Nibedita.Saha
	 * @param menuName
	 * @throws Exception
	 */
	public void clickMenuFromSystemAdmnstrtn(String menuName) throws Exception {
		logger.info("Method: clickMenuFromSystemAdmnstrtn " + menuName + " Starts");
		String baseUrl = PropertiesRepository.getString("current-atitesting.mu.url");
		try {
			List<WebElement> menuElement = baseHandler
					.findElements(PropertiesRepository.getString("current-atitesting.mu.sys.admn.menu.loc"));

			if (CollectionUtils.isNotEmpty(menuElement)) {
				int size = menuElement.size();
				for (int index = 0; index < size; index++) {
					if (menuElement.get(index).getText().trim().equalsIgnoreCase(menuName)) {
						menuElement.get(index).click();
						break;
					}
				}
			}
			String homeUrl = baseUrl.split("://")[1] + "main.aspx";
			if (driver.getCurrentUrl().split("://")[1].equalsIgnoreCase(homeUrl)) {
				logger.info("Unable to click menu under System Administration " + menuName
						+ ". So directly accessing the url ");
				log(logger, "Unable to click menu under System Administration " + menuName
						+ ". So directly accessing the url ");
				if (menuName.equalsIgnoreCase("Management Utility"))
					driver.get(baseUrl + "personnel/default.aspx");
				else if (menuName.equalsIgnoreCase("TestMaker Utility"))
					driver.get(baseUrl + "testmaker/Menu.aspx");
				else if (menuName.equalsIgnoreCase("Site Monitor"))
					driver.get(baseUrl + "personnel/SiteMonitor.aspx");
				else if (menuName.equalsIgnoreCase("News Tab Editor"))
					driver.get(baseUrl + "sitemanagement/NewsTabEditor.aspx");
				else if (menuName.equalsIgnoreCase("Password Access History"))
					driver.get(baseUrl + "personnel/ViewAccessLog.aspx");

			}
		} catch (Exception e) {
			logger.info("Unable to click menu under System Administration " + menuName);
			log(logger, "Unable to click menu under System Administration " + menuName);
			throw new DriverException("Unable to click menu under System Administration " + menuName, e);
		}
		logger.info("Method: clickMenuFromSystemAdmnstrtn " + menuName + " End ");
	}
	
	/**
	 * Method used to click on menu under Management Utility.
	 * 
	 * @author Nibedita.Saha
	 * @param menuName
	 * @throws Exception
	 */
	public void clickMenuFromMgmtUtility(String menuName) throws Exception {
		logger.info("Method: clickMenuFromMgmtUtility Starts");
		try {
			List<WebElement> menuElement = baseHandler
					.findElements(PropertiesRepository.getString("current-atitesting.mu.mgmt.utility.menu.loc"));
			if (CollectionUtils.isNotEmpty(menuElement)) {
				int size = menuElement.size();
				for (int index = 0; index < size; index++) {
					WebElement menu = menuElement.get(index);
					if (menu.getText().trim().equalsIgnoreCase(menuName)) {
						menu.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Mgmt Utility");
			log(logger, "Unable to click Mgmt Utility");
			throw new DriverException("Unable to click Mgmt Utility", e);
		}
		logger.info("Method: clickMenuFromMgmtUtility End ");
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @param userName
	 * @throws Exception
	 */
	public void enterTextInTextBox(String loc,String name) throws Exception {
		logger.info("Method: enterFirstName Starts");
		try {
			textHandler.writeText(PropertiesRepository.getString(loc),PropertiesRepository.getString(name));
		} catch (Exception e) {
			logger.info("Unable to enter text");
			log(logger, "Unable to enter text");
			throw new Exception("Unable to enter text", e);
		}
		logger.info("Method: enterFirstName End ");
	}
	
	/**
	 * Method used to click Go Button.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickGoButton() throws Exception {
		logger.info("Method: clickGoButton Starts");
		try {
			buttonHandler.clickButton(PropertiesRepository.getString("current-atitesting.mu.users.go.button.loc"),
					PropertiesRepository.getStringAsArray("current-atitesting.mu.users.table.load.loc"));
		} catch (Exception e) {
			logger.info("Unable to click Go Button");
			log(logger, "Unable to click Go Button");
			throw new DriverException("Unable to click Go Button", e);
		}
		logger.info("Method: clickGoButton End ");
	}
	
	/**
	 * Method used to click on First Row in Manage Users.
	 * @author Sanapati.Srinu
	 * @throws Exception
	 */
	public void clickOnRowLink(String loc,int size) throws Exception {
		logger.info("Method: clickOnRowLink Starts");
		try {
			List<WebElement> usersTable = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(usersTable) && usersTable.size() > 0) {
				usersTable.get(size).click();
				clickButtonWithWait("current-atitesting.mu.users.ati.email.checkbox");
				waitForLoad(driver);
			}
		} catch (Exception e) {
			logger.info("Unable to click Users First Row");
			log(logger, "Unable to click Users First Row");
			throw new DriverException("Unable to click Users First Row", e);
		}
		logger.info("Method: clickOnRowLink End ");
	}

	public boolean isAtiEmailChecked(String loc) throws DriverException {
		logger.info("Method: isAtiEmailChecked Start ");
		boolean flag=false;
		Actions action=new Actions(driver);
		try
		{
			List<WebElement> atiEmailCheckBoxLoc = baseHandler.findElements(PropertiesRepository.getString(loc));
			boolean status = atiEmailCheckBoxLoc.get(0).isSelected();
			if(status)
			{
				action.moveToElement(atiEmailCheckBoxLoc.get(0)).click().build().perform();
				flag= false;
			}
			else
			{
				action.moveToElement(atiEmailCheckBoxLoc.get(0)).click().build().perform();
				flag= true;
				
			}
		
			
	} catch (Exception e) {
		logger.info("Unable to Ati Email Check Box");
		log(logger, "Unable to Ati Email Check Box");
		throw new DriverException("Unable to Ati Email Check Box", e);
	}
	logger.info("Method: isAtiEmailChecked End ");
	return flag;
		
	}

	public boolean verifyToggleBarStatus(boolean isCheckedInMu) throws DriverException {
		
		logger.info("Method: verifyToggleBarStatus Start ");
		boolean flag=false;
		try
		{
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("id.home.toggle.label.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				elements.get(0).click();
				List<WebElement> toggleBar = baseHandler.findElements(".mat-tab-body-content .mpanel md-slide-toggle");
				if(CollectionUtils.isNotEmpty(toggleBar))
				{
					String attribute = toggleBar.get(0).getAttribute("class");
					if(isCheckedInMu && attribute.contains("ng-touched"))
					{
						flag=true;
					}
				}
				
			}
			
	} catch (Exception e) {
		logger.info("Unable to verify ToggleBar Status");
		log(logger, "Unable to verify ToggleBar Status");
		throw new DriverException("Unable to verify ToggleBar Status", e);
	}
	logger.info("Method: verifyToggleBarStatus End ");
	return flag;
		
	}
	
	/**
	 * Method used to remove Zip code from Personel section. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean removeZipCode() throws Exception {
		logger.info("Method : removeZipCode Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.editpage.personel.zipcode.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(2).clear();
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to removeZipCode" );
			log(logger, "Unable to removeZipCode" );
    		throw new DriverException("Unable to removeZipCode" , e); 
    	}
		logger.info("Method: removeZipCode End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify check box is checked and its label based on index. 
	 * 
	 * @param locator
	 * @param value
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEthinicityCheckBoxValue(String locator, String value, int index ) throws Exception {
		logger.info("Method : verifyEthinicityCheckBoxValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				boolean boolCheck = checkBoxHandler.isSelected(element.get(index));
				if(boolCheck) {
					List<WebElement> labelElement = baseHandler.findElements(PropertiesRepository.getString("id.home.profile.account.setting.sign.in.demographics.ethinicity.checkbox.label.loc"));
					if(CollectionUtils.isNotEmpty(labelElement) && labelElement.get(index).getText().trim().equalsIgnoreCase(value)) {
						flag = true;
					} else {
						logger.info("Unable to verify check box label");
					}
				} else {
					logger.info("Unable to check check box based on index");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyEthinicityCheckBoxValue" );
			log(logger, "Unable to verifyEthinicityCheckBoxValue" );
    		throw new DriverException("Unable to verifyEthinicityCheckBoxValue" , e); 
    	}
		logger.info("Method: verifyEthinicityCheckBoxValue End flag --> " + flag);
		return flag;
	}
}
