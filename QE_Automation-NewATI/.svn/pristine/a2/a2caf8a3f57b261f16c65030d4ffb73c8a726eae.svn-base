package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class LoginPage extends LoginPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private TextHandler textHandler;
	private ButtonHandler btnHandler;
	public BaseHandler baseHandler;
	long milliseconds =0;
	private String result = null;
	private WindowHandler windowHanlder;
	private ButtonHandler buttonHandler;
	private TutorialPage tutorialPage;
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHanlder=new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		tutorialPage=new TutorialPage(driver);
	}
	
	/**
	 * Method to used to login to the application with Faculty user credentials.
	 * 
	 * @param userName
	 * @param password
	 * @throws DriverException
	 */
	public boolean verifyReactivationAccountViaMailLogin(String userName, String password) throws Exception {
		logger.info("Method: verifyReactivationAccountViaMailLogin Starts");
		boolean flag = false;

		try {
			loginToApplication(userName, password);

			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			List<WebElement> reactivationMsg = baseHandler
					.findElements(PropertiesRepository.getString("asmt.login.reactivation.account.popup.loc"));
			if (reactivationMsg.get(0).getText().equalsIgnoreCase("Inactive Account")) {
				//VerificationHandler.verifyVisibleTextAppearance(reactivationMsg.get(0));

				windowHanlder.switchToLatestWindow();
				List<WebElement> radioChoiceButton = baseHandler.findElements(
						PropertiesRepository.getString("asmt.login.reactivation.account.popup.choice.loc"));

				int size = radioChoiceButton.size();

				for (int i = 0; i < size; i++) {
					String sValue = radioChoiceButton.get(i).getText();

					if (sValue.equalsIgnoreCase("Email")) {

						radioChoiceButton.get(i).click();
					}
				}

				windowHanlder.switchToLatestWindow();

				List<WebElement> clickContinue = baseHandler.findElements(
						PropertiesRepository.getString("asmt.login.reactivation.account.popup.choice.continue.loc"));
				clickContinue.get(1).click();
				Thread.sleep(3000);

				List<WebElement> emailSent = baseHandler.findElements(
						PropertiesRepository.getString("asmt.login.reactivation.account.popup.choice.emailsent.loc"));

				if (emailSent.get(0).getText().equalsIgnoreCase("Email Sent")) {
					//VerificationHandler.verifyVisibleTextAppearance(emailSent.get(0));
					List<WebElement> closeButton = baseHandler.findElements(
							PropertiesRepository.getString("asmt.login.reactivation.account.popup.close.loc"));
					closeButton.get(0).click();
					//VerificationHandler.verifyInvisiblityOfWebElement(closeButton.get(0));
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify the reactivation of student account via mail flow section");
			log(logger, "Unable to verify the reactivation of student account via mail flow section");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: verifyReactivationAccountViaMailLogin End flag --> " + flag);
		return flag;
	}
}
