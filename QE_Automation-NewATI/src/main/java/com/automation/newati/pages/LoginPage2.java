package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class LoginPage2 extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private TextHandler textHandler;
	private ButtonHandler btnHandler;
	public BaseHandler baseHandler;
	long milliseconds =0;
	private String result = null;
	private WindowHandler windowHanlder;
	private ButtonHandler buttonHandler;
	private TutorialPage tutorialPage;
	public LoginPage2(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHanlder=new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		tutorialPage=new TutorialPage(driver);
	}
	
	public void enterURL(String url) throws Exception {
		logger.info("Method : enterURL :::::::: START");
		logger.info(PropertiesRepository.getString(url));
		driver.get(PropertiesRepository.getString(url));
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : enterURL :::::::: END");
	}
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		// List<WebElement> buttonList =
		// baseHandler.findElements(".wm-template-text");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".wm-close-button"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			driver.findElement(By.cssSelector(".wm-close-button")).click();
			Thread.sleep(1000);
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}
	
	/**
	 * Method to used to login to application.--->>> OLD
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 *//*
	public boolean loginToApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START ");
		boolean flag = false;
		try {
			driver.get(PropertiesRepository.getString("newati.login.url"));
			if(driver.findElement(By.cssSelector(".ico_70_intro-student")).isDisplayed())
			{
				driver.findElement(By.cssSelector(".ico_70_intro-student")).click();
			}
			driver.manage().deleteAllCookies();
			
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			logger.info("User name --> " + userName);
			logger.info("Password --> " + password);
			
			
			if(baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc")) && 
					baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc")) 
					&& StringUtils.isNotBlank(userName)
					&& StringUtils.isNotBlank(password)) {
				// User Name
				logger.info("UserName Element & Password is displayed ");
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), userName);
				// Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), password);
				logger.info("Password value -->" + getText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc")));
				// Click Go Button
				btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				String termsHeader = getText(PropertiesRepository.getString("new-atitesting.T&C"));
				
				if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
					// Clicking on Check Box. 
					verifyAndClickWithList(".checkbox-not-checked", 3, true);
					
					// Clicking on Continue Button.
					verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
					
					// Wait for loading image. 
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
				}

				String welcomepopup = getText(PropertiesRepository.getString("new-atitesting.welcometoati"));
				
				if(StringUtils.isNotEmpty(welcomepopup) && "Welcome to ATI!".equalsIgnoreCase(welcomepopup)) {
					
					
					// Clicking on Continue Button.
					verifyAndClick(PropertiesRepository.getString("new-atitesting.welcometoati.close"), true);
					
					// Wait for loading image. 
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
				
				MaintanacePopUp();
				flag = true;
			} else {
				logger.info("Unable to login To Application");
			}
			//logger.info("UserName value -->" + getText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc")));
			
		} catch (Exception e) {
			logger.info("Unable to login To Application" + e);
			log(logger, "Unable to login To Application" + e);
			throw new DriverException("Unable to login To Application", e);
		}

		logger.info("Method : loginToApplication :::::::: End flag --> " + flag);
		return flag;
	}*/
	
	/**
	 * Method to used to login to application.--->>>New : Post UA changes
	 * @author Syed.pasha
	 * @param userName
	 * @param password
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean loginToApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		boolean flag = false;
		try {
			driver.get(PropertiesRepository.getString("newati.login.url"));
			driver.manage().deleteAllCookies();

			if (driver.getTitle().equals("ATI Testing | Nursing Education | NCLEX Exam Review | TEAS Testing")) {
				if (driver.findElement(By.cssSelector(PropertiesRepository.getString("ati.login.page.model"))).isDisplayed()) {
					waitUntillElementIsVisible(PropertiesRepository.getString("ati.login.page.model"));
					logger.info("Select Site");
					clickButton(PropertiesRepository.getString("ati.login.page.model.three.options"), 1);
				}

				logger.info("Click on login button");
				clickButton(PropertiesRepository.getString("ati.login.page.login.btn"), 0);
				waitUntillElementIsVisible(PropertiesRepository.getString("ati.student.input.username"));

				textHandler.writeText(PropertiesRepository.getString("ati.student.input.username"), userName);
				textHandler.writeText(PropertiesRepository.getString("ati.student.input.pass"), password);
				clickButton(PropertiesRepository.getString("ati.student.btn.signIn"));
				
				waitUntillElementInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
				driverWait.until(ExpectedConditions.urlContains("Home"));
			}

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			String termsHeader = getText(PropertiesRepository.getString("new-atitesting.T&C"));

			if (StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
				// Clicking on Check Box.
				verifyAndClickWithList(".checkbox-not-checked", 3, true);
				// Clicking on Continue Button.
				verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
				// Wait for loading image.
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}

			String welcomepopup = getText(PropertiesRepository.getString("new-atitesting.welcometoati"));
			if (StringUtils.isNotEmpty(welcomepopup) && "Welcome to ATI!".equalsIgnoreCase(welcomepopup)) {
				// Clicking on Continue Button.
				verifyAndClick(PropertiesRepository.getString("new-atitesting.welcometoati.close"), true);
				// Wait for loading image.
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			MaintanacePopUp();
			flag = true;

		} catch (Exception e) {
			logger.info("Unable to login To Application" + e);
			throw new DriverException("Unable to login To Application", e);
		}
		logger.info("Method : loginToApplication :::::::: End flag --> " + flag);
		return flag;
	}

	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	// Changes----16thNov
	public void invalidLoginToApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		try {
			driver.get(PropertiesRepository.getString("newati.stage.login.url"));
			// User Name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), userName);
			// Password
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), password);
			// Click Go Button
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
//			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			String termsHeader = getText(PropertiesRepository.getString("new-atitesting.paymentstabloc"));
			
			if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
				// Clicking on Check Box. 
				verifyAndClickWithList(".checkbox-not-checked", 3, true);
				
				// Clicking on Continue Button.
				verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
				
				// Wait for loading image. 
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}

		} catch (Exception e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}

		logger.info("Method : loginToApplication :::::::: End");
	}


	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void enterUserIdAndPwd(String userName,
			 String password) throws DriverException {
		logger.info("Method : enterUserIdAndPwd :::::::: START ");
		try {
			
			if (driver.getTitle().equals("ATI Testing | Nursing Education | NCLEX Exam Review | TEAS Testing")) {
				if (driver.findElement(By.cssSelector(PropertiesRepository.getString("ati.login.page.model"))).isDisplayed()) {
					waitUntillElementIsVisible(PropertiesRepository.getString("ati.login.page.model"));
					logger.info("Select Site");
					clickButton(PropertiesRepository.getString("ati.login.page.model.three.options"), 1);
				}
			}
			
			logger.info("Click on login button");
			clickButton(PropertiesRepository.getString("ati.login.page.login.btn"), 0);
			waitUntillElementIsVisible(PropertiesRepository.getString("ati.student.input.username"));
			// User Name
			textHandler.writeText(PropertiesRepository.getString("ati.student.input.username"),userName);

			/*WebElement findElement = driver.findElement(By.cssSelector("div[id*='passwordAndGo']>input:nth-child(1)"));
			
			findElement.click();
			driver.findElement(By.cssSelector("#signOnForm-password")).sendKeys("kkk");*/
			
			// Password
			textHandler.writeText(PropertiesRepository.getString("ati.student.input.pass"),password);

			// Click Go Button
			btnHandler.clickButton(PropertiesRepository.getString("ati.student.btn.signIn"));
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			
			String termsHeader =getText(PropertiesRepository.getString("new-atitesting.T&C"));
			if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
				// Clicking on Check Box. 
				verifyAndClickWithList(".checkbox-not-checked", 3, true);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Clicking on Continue Button.
				verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
				
				// Wait for loading image. 
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
			
			}
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	
	public void InvalidenterUserIdAndPwd(String userName,
			 String password) throws DriverException {
		logger.info("Method : enterUserIdAndPwd :::::::: START ");
		try {
					
			// User Name
			textHandler.writeText(PropertiesRepository.getString("ati.student.input.username"),userName);

			/*WebElement findElement = driver.findElement(By.cssSelector("div[id*='passwordAndGo']>input:nth-child(1)"));
			
			findElement.click();
			driver.findElement(By.cssSelector("#signOnForm-password")).sendKeys("kkk");*/
			
			// Password
			textHandler.writeText(PropertiesRepository.getString("ati.student.input.pass"),password);

			// Click Go Button
			btnHandler.clickButton(PropertiesRepository.getString("ati.student.btn.signIn"));
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			
			String termsHeader =getText(PropertiesRepository.getString("new-atitesting.T&C"));
			if(StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
				// Clicking on Check Box. 
				verifyAndClickWithList(".checkbox-not-checked", 3, true);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Clicking on Continue Button.
				verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);
				
				// Wait for loading image. 
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
			
			}
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
   		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void enterUserIdAndPwdToFacultyPortal(String userName,
			 String password) throws DriverException {
		logger.info("Method : enterUserIdAndPwdToFacultyPortal :::::::: START ");
		try {
			// User Name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc.NFV"),userName);

			WebElement pwdLoc = driver.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc.FV")));
			pwdLoc.click();
			driver.findElement(By.cssSelector(PropertiesRepository.getString("faculty.portal.password1.loc"))).sendKeys(password);
			
			// Click Go Button
			btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc1"));
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwdToFacultyPortal :::::::: End");
	}
	/**
	 * Method used to click on Forgot Password Link in Login Page. 
	 * 
	 * @throws Exception
	 */
	public void clickForgotPasswordLink(String loc) throws Exception {
		logger.info("Method: clickForgotPasswordLink Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(0).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Forgot Password Link" );
			log(logger, "Unable to click Forgot Password Link" );
    		throw new DriverException("Unable to click Forgot Password Link" , e); 
    	}
    	logger.info("Method: clickForgotPasswordLink End " );
	}
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginIntoCurrentAti(String userNameLoc,String userName,
			String passwordLoc,String password) throws DriverException {
		//logger.info("Method : enterUserIdAndPwd :::::::: START");
		try {
			// User Name
			textHandler.writeText(PropertiesRepository.getString(userNameLoc),PropertiesRepository.getString(userName));

			// Password
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password.loc")).click();
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password1.loc"))
			.sendKeys(PropertiesRepository.getString(password));

			// Click Go Button
			List<WebElement> goButtonElement = baseHandler.findElements(".signOnForm-go");
			if(CollectionUtils.isNotEmpty(goButtonElement)) {
				goButtonElement.get(0).click();
			}
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginToCurrentAti(String userNameLoc,String userName,
			String passwordLoc,String password) throws DriverException {
		//logger.info("Method : enterUserIdAndPwd :::::::: START");
		try {
			// User Name
			textHandler.writeText(PropertiesRepository.getString(userNameLoc),PropertiesRepository.getString(userName));

			// Password
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password.loc")).click();
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password1.loc"))
			.sendKeys(password);

			// Click Go Button
			List<WebElement> goButtonElement = baseHandler.findElements(".signOnForm-go");
			if(CollectionUtils.isNotEmpty(goButtonElement)) {
				goButtonElement.get(0).click();
			}
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginIntoCurrentAti_new(String userNameLoc,String userName,
			String passwordLoc,String password) throws DriverException {
		//logger.info("Method : enterUserIdAndPwd :::::::: START");
		try {
			// User Name
			textHandler.writeText(PropertiesRepository.getString(userNameLoc),PropertiesRepository.getString(userName));

			// Password
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password.loc")).click();
			baseHandler.findElement(PropertiesRepository.getString("faculty.portal.password1.loc")).sendKeys(password);

			// Click Go Button
			List<WebElement> goButtonElement = baseHandler.findElements(".signOnForm-go");
			if(CollectionUtils.isNotEmpty(goButtonElement)) {
				goButtonElement.get(0).click();
			}
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void clickCurrentAtiOnSignOnButton(String userNameLoc,String userName,
			String passwordLoc,String password) throws DriverException {
		logger.info("Method : enterUserIdAndPwd :::::::: START");
		try {
			// User Name
			textHandler.writeText(PropertiesRepository.getString(userNameLoc),PropertiesRepository.getString(userName));

			// Password
			baseHandler.findElement(PropertiesRepository.getString(passwordLoc)).sendKeys(PropertiesRepository.getString(password));

			// Click Go Button
			List<WebElement> goButtonElement = baseHandler.findElements(PropertiesRepository.getString("atitesting.sign.on.go.button"));
			if(CollectionUtils.isNotEmpty(goButtonElement)) {
				new Actions(driver).moveToElement(goButtonElement.get(0)).click().build().perform();
			}
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
		} catch(Exception e) {
			logger.info("Unable to enter UserId And Pwd" );
			log(logger, "Unable to enter UserId And Pwd" );
    		throw new DriverException("Unable to enter UserId And Pwd" , e); 
		}
			
		logger.info("Method : enterUserIdAndPwd :::::::: End");
	}
	/**
	 * Method to enter Security Question for Student. 
	 * 
	 * index 0 for first answer. 
	 * index 1 for second answer. 
	 * index 2 for third answer. 
	 * 
	 * @param index
	 * @param answer
	 * @throws Exception
	 */
	public void clickStudentSecurityQuestion(int index, String answer) throws Exception {
		logger.info("Method: clickStudentSecurityQuestion Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.secutiry.question.list"));
    		if(CollectionUtils.isNotEmpty(element) && element.size() == 3) {
    			if(index == 0) {
    				element.get(0).click();
    				textHandler.writeText(element.get(0), answer);
    			} else if(index == 1) {
    				element.get(1).click();
    				textHandler.writeText(element.get(1), answer);
    			} else {
    				element.get(2).click();
    				textHandler.writeText(element.get(2), answer);
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Student Security Question" );
			log(logger, "Unable to click Student Security Question" );
    		throw new DriverException("Unable to click Student Security Question" , e); 
    	}
    	logger.info("Method: clickStudentSecurityQuestion End " );
	}

	/**
	 * Enter new password to reset old old password
	 * @author Sanapati.Srinu
	 * 
	 */
	public void resetWithNewPassword(String newPwd,String resetPwd) throws Exception {
		logger.info("Method: resetWithNewPassword Starts");
		try {
			List<WebElement> newPasswordElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.new.password"));
			if(CollectionUtils.isNotEmpty(newPasswordElement)) {
				newPasswordElement.get(0).sendKeys(newPwd);
			}
			
			List<WebElement> newConfirmPasswordElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.reset.password"));
			if(CollectionUtils.isNotEmpty(newConfirmPasswordElement)) {
				newConfirmPasswordElement.get(0).sendKeys(resetPwd);
			}
		} catch (Exception e) {
			logger.info("Unable to reset With New Password" );
			log(logger, "Unable to reset With New Password" );
    		throw new DriverException("Unable to reset With New Password" , e);
		}
		
		logger.info("Method: resetWithNewPassword End");
	}

	/**
	 * Enter new password to reset old old password
	 * @author Sanapati.Srinu
	 * 
	 */
	public void currentAtiResetPassword(String newPwd,String resetPwd) {
		
		logger.info("Method: resetWithNewPassword Starts");
		try {
			
		baseHandler.findElement(PropertiesRepository.getString("atitesting.new.password")).sendKeys(PropertiesRepository.getString(newPwd));
		baseHandler.findElement(PropertiesRepository.getString("atitesting.reset.password")).sendKeys(PropertiesRepository.getString(resetPwd));
		
		} catch (Exception e) {
		}
		
		logger.info("Method: resetWithNewPassword End");
	}
	
	/**
	 * Enter new password to reset old old password
	 * @author syed.pasha
	 * 
	 */
	public void currentAtiFacultyResetPassword(String newPwd,String resetPwd) {
		
		logger.info("Method: resetWithNewPassword Starts");
		try {
			
		baseHandler.findElement(PropertiesRepository.getString("ATIFaculty.atitesting.new.password")).sendKeys(newPwd);
		baseHandler.findElement(PropertiesRepository.getString("ATIFaculty.atitesting.reset.password")).sendKeys(resetPwd);
		
		} catch (Exception e) {
		}
		
		logger.info("Method: resetWithNewPassword End");
	}
	

	/**
	 * This method is used to verify email confirmation message
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param input
	 * @return boolean
	 */
	public boolean verifyEmailSentMessage(String loc, String input) {
		logger.info("Method: verifyEmailSentMessage End");
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
		if (CollectionUtils.isNotEmpty(elements)
				&& PropertiesRepository.getString(input).equals(elements.get(1).getText())) {
			return true;

		}
		logger.info("Method: verifyEmailSentMessage End");
		return false;
	}

	/**
	 * This method is used to select  email radio button
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 */
	public void clickButtonFromList(String loc,int index) {
		logger.info("Method: clickButtonFromList Start");
		try {
			List<WebElement> elements = baseHandler.findElements(loc);
			if(CollectionUtils.isNotEmpty(elements))
			{
				new WindowHandler(driver).switchToModalDialog();
				elements.get(index).click();
				
			}
		} catch (Exception e) {
		}
		logger.info("Method: clickButtonFromList End");
		
	}

	/**
	 * This method is used to enter value in the text box.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param input
	 * @throws Exception 
	 */
	public void enterInput(String loc, String input) throws Exception {
		logger.info("Method: enterInput Start");
		try {
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			/*if(browser.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
				
			}*/
			textHandler.writeText(loc,input);
		} catch (DriverException e) {
		}
		logger.info("Method: enterInput End");
	}
	

	

	/**
	 * This method is used to enter Security Questions Answers.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param input
	 * @throws Exception 
	 */
	public void enterSecurityQuesAnswers(String loc, String answer1 , String answer2 , String answer3) throws Exception {
		logger.info("Method: enterSecurityQuesAnswers Start");
		try {
			List<WebElement> element = baseHandler.findElements(loc);
			
			if(CollectionUtils.isNotEmpty(element)) {
    			element.get(0).sendKeys(answer1);
    			element.get(1).sendKeys(answer2);
    			element.get(2).sendKeys(answer3);
    			
    		}
		} catch (Exception e) {
		}
		logger.info("Method: enterSecurityQuesAnswers End");
	}
	

	/**
	 * This is used to lock the account by entering wrong password with  multiple times
	 * @author Sanapati.Srinu
	 * @throws DriverException
	 */
	public void lockTheAccount() throws DriverException {
		logger.info("Method: lockTheAccount Start");
		try {
			enterInput(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), PropertiesRepository.getString("new-atitesting.locked.user.name1"));
			for(int i=0;i<6;i++)
			{
				enterInput(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), PropertiesRepository.getString("new-atitesting.lock.user.name1"));
				clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
			}
		} catch (Exception e) {
			throw new DriverException("lockTheAccount",e);
		}
		logger.info("Method: lockTheAccount End");
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 */
	public void waitForUntillElementDisplayed(String loc) {
		
		try {
			baseHandler.waitToBeDisplayed(loc);
		} catch (DriverException e) {
		}
	}

	/**
	 * This method is used to verify ContactUs Link window.
	 *        
	 * @author Sagar.Rao 
	 * 
	 * @param loc
	 * @throws DriverException
	 */
	public String verifyContactUsLinks()
			throws DriverException {
		logger.info("Method : verifyContactUsLinks :::::::: START");
		result = null;
		try {
			//click on contact us link
			btnHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.contactUsLinkLoc"));
			Thread.sleep(5000);// Here Thread.sleep() is require to handle wait.
//			btnHandler.clickButton(PropertiesRepository
//					.getString("new-atitesting.contactUsLinkLoc"));
			//switch to particular window
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			throw new DriverException(
					"Method: verifyContactUsLinks, Unable to locate element"
							+ e);
		}
		result = textHandler.getText(PropertiesRepository
				.getString("new-atitesting.homepage.linkpage.linksText.contactus"));
		logger.info("Method : verifyContactUsLinks :::::::: END " + result);
		//fetching header
		return result;
	}
	
	public boolean clickLinkFromList(String loc,int index)
	{
		boolean viewStatus=false;
		WebElement webElement=null;
		
			try {
				Thread.sleep(7000); // Here Thread.sleep() is require to handle wait.
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return viewStatus;
	}
	
	public String getTextFromLst(String loc,int size)
	{
		List<WebElement> listOfElements = driver.findElements(By.cssSelector(PropertiesRepository
				.getString(loc)));
		String name = listOfElements.get(size).getText().trim();
		return name;
		
	
	}
	
	/**
	 * Method used to login to Faculty Application. 
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void loginToFacultyApplication(String URL, String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToFacultyApplication Start");
		try {
			driver.get(URL);
			tutorialPage.waitForAwhile(10000);
			WebElement userNameElement = baseHandler.findElement(PropertiesRepository.getString("ATIFaculti.login.username.loc"));
			WebElement passwordElement = baseHandler.findElement(PropertiesRepository.getString("ATIFaculti.login.password.loc"));
			if(userNameElement != null && passwordElement != null) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				btnHandler.clickButton(PropertiesRepository.getString("ATIFaculti.login.go.button"));
				waitUntillLoadingImageIsDisappeared("ATIFaculty.common.page.loader");
			}
    	} catch (Exception e) {
    		logger.info("Unable to loginToFacultyApplication");
			log(logger, "Unable to loginToFacultyApplication" );
    		throw new DriverException("Unable to loginToFacultyApplication" , e); 
    	}
		logger.info("loginToFacultyApplication End");		
	}

	public boolean verifyErrorMessage(String locator, String expectedErrorMsg) {
		return (baseHandler.findElement(locator).getText().contains(expectedErrorMsg));
	}
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginToStudentApplication(String userName,
			 String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		try {
			driver.get(PropertiesRepository.getString("newati.login.url"));
			// User Name
			textHandler
					.writeText(PropertiesRepository
							.getString("new-atitesting.homepage.userNameLoc"),
							userName);

			// Password
			textHandler
					.writeText(PropertiesRepository
							.getString("new-atitesting.homepage.passwordLoc"),
							password);

			// Click Go Button
			buttonHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.goBtnLoc"));
			
		} catch(Exception e) {
			logger.info("Unable to login To Application" );
			log(logger, "Unable to login To Application" );
    		throw new DriverException("Unable to login To Application" , e); 
		}
			
		logger.info("Method : loginToApplication :::::::: End");
	}

	/**
	 * Method used to verify login page Links
	 * 
	 * @return
	 * @throws Exception
	 */

	public boolean verifyLoginTabTopLinks() throws Exception {
		logger.info("Method: verifyLoginTabTopLinks Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.logintab.upper.links.loc"));
			if (CollectionUtils.isNotEmpty(elements) && elements.size() == 3
					&& PropertiesRepository.getString("new-atitesting.toplink.online.createaccount.name")
							.equals(elements.get(1).getText())
					&& PropertiesRepository.getString("new-atitesting.toplink.online.store.name")
							.equals(elements.get(2).getText())
					&& PropertiesRepository.getString("new-atitesting.toplink.contact.us")
							.equals(elements.get(3).getText())) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Login Tab Top Links");
			log(logger, "Unable to verify Login Tab Top Links");
			throw new DriverException("Unable to verify Login Tab Top Links", e);
		}
		logger.info("Method: verifyLoginTabTopLinks End flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method used to verify Email Address Lable in the Forgot username/password model
	 * 
	 * @return
	 * @throws Exception
	 */

	public boolean verifyEmailAddressLableInModel() throws Exception {
		logger.info("Method: verifyEmailAddressLableInModel Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler.findElements(".sign-in-step-username>h1");
			if (CollectionUtils.isNotEmpty(elements) && elements.get(1).getText().equals("Step 2: Enter your email address")){
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyEmailAddressLableInModel");
			log(logger, "Unable to verifyEmailAddressLableInModel");
			throw new DriverException("Unable to verifyEmailAddressLableInModel", e);
		}
		logger.info("Method: verifyEmailAddressLableInModel End flag --> " + flag);
		return flag;
	}
	// Login to MU 
	

	/**
	 * Method for LoginMU
	 * 
	 * @throws Exception
	 */
		public void loginIntoMU(String userName, String password) throws DriverException {
			logger.info("Method : loginToMUApplication :::::::: START");
			try {
				
				driver.manage().deleteAllCookies();
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.mu.username.loc"), userName);
				// Password
				JavascriptExecutor executor = (JavascriptExecutor) driver;

				executor.executeScript(
						"document.getElementById('" + PropertiesRepository.getString("new-atitesting.mu.password.loc")
								+ "').value='" + password + "'");
				
				// Click SignIn Button
				btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.mu.signin.button.loc"));
				System.out.println(driver.getTitle());
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				if (driver.getTitle().equals(PropertiesRepository.getString("newati.MU.home.Page.Title"))) {
					logger.info("Login Successful");
				} else {
					throw new DriverException("Unable to login To Application");
				}
			} catch (Exception e) {
				logger.info("Unable to login To MU Application");
				log(logger, "Unable to login To MU Application");
				throw new DriverException("Unable to login To MU Application", e);
			}

			logger.info("Method : loginToMUApplication :::::::: End");
		}
		public boolean VerifyLoginsuccessfullasEmulator()throws DriverException{
			logger.info("Method : VerifyLoginsuccessfullasEmulator :::::::: START");
			boolean flag=false;
			try {
				if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.home.page.tabs"))) {
					logger.info("Login Successful");
					flag=true;
				} 
				
			} catch (Exception e) {
				logger.info("Unable to login To student as emulator");
				log(logger, "Unable to login To student as emulator");
				throw new DriverException("Unable to login To student as emulator", e);
			}
			logger.info("Method : VerifyLoginsuccessfullasEmulator :::::::: End");
			return flag;
			}
		
		/**
		 * Method to used to login to application without deleting cookies
		 * @author Vaishali.Katta
		 */
		public void loginToApplicationwithoutDeletingCookies(String userName, String password) throws DriverException {
			logger.info("Method : loginToApplicationwithoutDeletingCookies :::::::: START");
			try {				
				driver.get(PropertiesRepository.getString("newati.login.url"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				if(baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"))) {
					logger.info("UserName Element is displayed ");
					textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), userName);
				}
				logger.info("UserName value -->" + getText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc")));
				
				// Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), password);
				logger.info("UserName value -->" + getText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc")));
				// Click Go Button
				btnHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			} catch (Exception e) {
				log(logger, "Unable to login To Application" + e);
				throw new DriverException("Unable to login To Application", e);
			}

			logger.info("Method : loginToApplicationwithoutDeletingCookies :::::::: End");
		}
		/**
		 * Method to used to login to the application with Faculty user credentials.
		 * 
		 * @param userName
		 * @param password
		 * @throws DriverException
		 */
		public boolean verifyFacultyLogin(String userName, String password) throws Exception {
			logger.info("Method: verifyFacultyLogin Starts");
			boolean flag = false;

			try {
				invalidLoginToApplication(userName, password);
//				waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
				List<WebElement> faultyMsg = baseHandler
						.findElements(PropertiesRepository.getString("asmt.login.faculty.msg.loc"));
				if (faultyMsg.get(0).getText()
						.equalsIgnoreCase("Invalid Student credentials, Please CLICK HERE to go to Faculty Log-in Page.")) {
					//VerificationHandler.verifyVisibleTextAppearance(faultyMsg.get(0));
					flag = true;
				}

			} catch (Exception e) {
				logger.info("Unable to verify the Faculty Login msg section");
				log(logger, "Unable to verify recent activity section");
				throw new DriverException("Unable to ", e);
			}
			logger.info("Method: verifyFacultyLogin End flag --> " + flag);
			return flag;
		}

		/**
		 * Method to used to login to the application with Faculty user credentials.
		 * 
		 * @param userName
		 * @param password
		 * @throws DriverException
		 */
		public boolean verifyInactiveInstitutionLogin(String userName, String password) throws Exception {
			logger.info("Method: verifyInactiveInstitutionLogin Starts");
			boolean flag = false;

			try {
				loginToApplication(userName, password);
				
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

//				waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));

				List<WebElement> inactiveMsg = baseHandler
						.findElements(PropertiesRepository.getString("asmt.login.inactive.institution.popup.loc"));
				if (inactiveMsg.get(0).getText().equalsIgnoreCase("Inactive Institution on Profile")) {
					//VerificationHandler.verifyVisibleTextAppearance(inactiveMsg.get(0));

					windowHanlder.switchToLatestWindow();
					List<WebElement> closeButton = baseHandler
							.findElements(PropertiesRepository.getString("asmt.login.inactive.institution.close.loc"));
					closeButton.get(0).click();
					//VerificationHandler.verifyInvisiblityOfWebElement(closeButton.get(0));
					flag = true;
				}
	
			} catch (Exception e) {
				logger.info("Unable to verify the Inactive Institution Login popup section");
				log(logger, "Unable to verify the Inactive Institution Login popup section");
				throw new DriverException("Unable to verify the Inactive Institution Login popup section", e);
			}
			logger.info("Method: verifyInactiveInstitutionLogin End flag --> " + flag);
			return flag;
		}

}
