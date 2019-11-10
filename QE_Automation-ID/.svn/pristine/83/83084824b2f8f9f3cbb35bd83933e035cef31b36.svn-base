package com.automation.id.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;

public class AnotherBrowserPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	public AnotherBrowserPage(WebDriver webDriver) {
		super(webDriver);
	}

	
	public void loginToApplication1(WebDriver driver, String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplication Start ");
		logger.info("userName value --> " + userName);
		logger.info("password value --> " + password);
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(driver, PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(driver, PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(driver, PropertiesRepository.getString("id.login.go.button"));
			if (userNameElement != null && passwordElement != null) {
				enterText(driver, userNameElement, userName);
				enterText(driver, passwordElement, password);
				verifyAndClick(driver, goButton, true);
				waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				
				MaintanacePopUp(driver);
				// Close Alert Box if present , close it
				if ((baseHandler.findElements("a[class='ati-modal-close']")) != null) {
					baseHandler.findElement("a[class='ati-modal-close']").click();
				}
				// Click on I Agree of Terms and Condition checkbox if present
				if ((baseHandler.findElements(".mat-checkbox-inner-container")) != null) {
					baseHandler.findElement(".mat-checkbox-inner-container").click();
					baseHandler.findElement(".mat-button.mat-primary").click();
					waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				}
			}
		} catch (Exception e) {
			logger.info("Unable to loginToApplication");
			log(logger, "Unable to loginToApplication");
			throw new DriverException("Unable to loginToApplication", e);
		}
		logger.info("loginToApplication End");
	}
	
	/**
	 * Method used to verify Element is present in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public WebElement verifyElement(WebDriver driver, String locator) throws DriverException {
		logger.info("verifyElement Start");
		WebElement webElement = null;
		try {
			List<WebElement> element = driver.findElements(By.cssSelector(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element.get(0);
			} else {
				logger.info("Unable to find element in verifyElement --> "+ locator );
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement");
			throw new DriverException("Unable to verifyElement", e);
		}
		logger.info("verifyElement End");
		return webElement;
	}
	
	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClick(WebDriver driver, String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			WebElement element = verifyElement(driver, locator);
			if (element != null) {
				if (click) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClick(WebDriver driver, WebElement element, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			if (element != null) {
				if (click) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisappeared(WebDriver driver, String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = driver.findElements(By.cssSelector(loc));
			try {
				if(CollectionUtils.isNotEmpty(buffecImage)) {

					while ((String.valueOf(buffecImage.size()) != null)
							&& ((System.currentTimeMillis() - startTime) < 120000)) {
						logger.info("page is still loading after click on the element");
						logger.info("Wait Counter in Seconds >>>> "
								+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
						buffecImage = driver.findElements(By.cssSelector(loc));
					}
					if (!((System.currentTimeMillis() - startTime) < 120000)) {
						logger.info("Waited 120 seconds to load the page");
						throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
					} else {
						logger.info("Page load complete");
					}
					// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				
				}
			} catch (Exception e) {
				logger.info("Error while handling loading image");
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End");
	}

	
	/**
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterText(WebDriver driver, String locator, String value) throws DriverException {
		logger.info("Method: enterText Starts");
		try {
			List<WebElement> inputText = verifyElementList(driver, locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click(); //unknown error: cannot focus element
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			logger.info("Unable to enterText");
			log(logger, "Unable to enterText");
			throw new DriverException("Unable to enterText", e);
		}
		logger.info("Method: clickButton End ");
	}
	
	/**
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterText(WebDriver driver, WebElement element, String value) throws DriverException {
		logger.info("Method: enterText Starts");
		try {
			if (element != null) {
				element.click(); 
				element.sendKeys(value);
				element.sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			logger.info("Unable to enterText");
			log(logger, "Unable to enterText");
			throw new DriverException("Unable to enterText", e);
		}
		logger.info("Method: clickButton End ");
	}
	
	/**
	 * Method used to verify Element is present in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public List<WebElement> verifyElementList(WebDriver driver, String locator) throws DriverException {
		logger.info("verifyElementList Start");
		List<WebElement> webElement = null;
		try {
			List<WebElement> element = driver.findElements(By.cssSelector(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElementList");
			log(logger, "Unable to verifyElementList");
			throw new DriverException("Unable to verifyElementList", e);
		}
		logger.info("verifyElementList End");
		return webElement;
	}

	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp(WebDriver driver) throws InterruptedException, Exception  {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover")); 
		if (CollectionUtils.isNotEmpty(buttonList)) {
			buttonList.get(0).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
			List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
			if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
				smallPopupCloseElement.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				// Sorry Popup.
				List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
				if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
					sorryPopupCloseElement.get(0).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
				} else {
					logger.info("Unable to close sorry popup");
				}
			} else {
				logger.info("Unable to close welcome to ati nursing education fp popup");
			}
		} else {
			logger.info("Unable to close main welcome popup window");
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}
	
	/**
	 * Method used to verify left navigation name and click if required.O
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(WebDriver driver, String locator, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = driver
					.findElements(By.cssSelector(PropertiesRepository.getString(locator)));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index++) {
					WebElement navElement = element.get(index);
					if (navElement != null && navElement.getText().trim().contains(leftNavName)) {
						flag = true;
						if (click) {
							navElement.click();
							waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author saravanan.jothimani34`5163784dixjn 3w
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextContains(WebDriver driver, String locator, String text, int index) throws DriverException {
		logger.info("Method: verifyTextContains Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("text --> " + text);
		boolean flag = false;
		try {
			List<WebElement> element = driver.findElements(By.cssSelector(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(index).getText().trim().contains(text)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextContains");
			log(logger, "Unable to verifyTextContains");
			throw new DriverException("Unable to verifyTextContains", e);
		}
		logger.info("Method: verifyTextContains End flag --> " + flag);
		return flag;
	}
	
	public boolean searchandVerifyStudentByCohort(WebDriver driver, String Cohortname)
			throws DriverException, InterruptedException {
		logger.info("Method : searchandVerifyStudentByCohort :::::::: START");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
			WebElement cohortDDValue1 = verifyElement(driver, "span.ati-heading:nth-child(3)");
			if (cohortDDValue1 != null) {
				cohortDDValue1.click();
				waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));
				// Enter Cohort Name
				WebElement cohortNameTxtElement = driver.findElement(
						By.cssSelector(PropertiesRepository.getString("id.people.student.by.cohort.name.loc")));
				if (cohortNameTxtElement != null) {
					enterText(driver, PropertiesRepository.getString("id.people.student.by.cohort.name.text.box.loc"),
							Cohortname);
					cohortNameTxtElement.sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared(driver,
							PropertiesRepository.getString("id.common.page.loader"));

					// Clicking on Select DD
					WebElement cohortDDValue = verifyElement(driver,
							PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(driver,
								PropertiesRepository.getString("id.common.page.loader"));
					}
					// Clicking on Save button.
					List<WebElement> ele = driver.findElements(By.cssSelector(
							PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc")));
					if (CollectionUtils.isNotEmpty(ele)) {
						ele.get(0).click();
					}
					waitUntillLoadingImageIsDisappeared(driver,
							PropertiesRepository.getString("id.common.page.loader"));

					// Verify result
					List<WebElement> resultcohert = driver
							.findElements(By.cssSelector(PropertiesRepository.getString("people.roster.studentlist")));
					for (int i = 0; i < resultcohert.size(); i++) {
						String StudentDetails = resultcohert.get(i).getText();
						if (StringUtils.isNotEmpty(StudentDetails) && StudentDetails.contains(Cohortname)) {
							flag = true;
						} else {
							flag = false;
						}
						if (!flag) {
							logger.info("Given cohort name is not displayed in table");
							break;
						}
					}
				}
			}
		} catch (Exception e) {

			logger.info("Unable to searchandVerifyStudentByCohort");
			throw new DriverException("Unable to searchandVerifyStudentByCohort", e);
		}
		logger.info("Method : searchandVerifyStudentByCohort :::::::: START");
		return flag;
	}
	
	/**
	 * This method will select one student check box and then it will click on
	 * Reassign button
	 * 
	 * @return
	 * @throws DriverException
	 * @author Syed.Hoque
	 */

	public boolean selectStudentCheckBox(WebDriver driver, int index) throws DriverException {
		logger.info("selectStudentCheckBox ::: START");
		boolean flag = false;
		try {
			// select check box for one student
			List<WebElement> checkBoxElement = driver
					.findElements(By.cssSelector(PropertiesRepository.getString("people.tab.ckeck.box")));
			if (CollectionUtils.isNotEmpty(checkBoxElement) & checkBoxElement.size() > 0) {
				logger.info("Check box is clicked");
				checkBoxElement.get(index).click();

				// Clicking on Reassign button.
				List<WebElement> reAssignBtn = driver.findElements(By
						.cssSelector(PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc")));
				if (CollectionUtils.isNotEmpty(reAssignBtn)) {
					reAssignBtn.get(0).click();
					waitUntillLoadingImageIsDisappeared(driver,
							PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Not able to find student from list");
			throw new DriverException("Not able to find student from list");
		}
		logger.info("selectStudentCheckBox ::: ENDS flag --> " + flag);
		return flag;
	}
	
	public boolean verifyReassignVerifyPopup(WebDriver driver, String textpopup) throws DriverException {
		logger.info("verifyReassignVerifyPopup ::: START");
		boolean flag = false;
		try {
			List<WebElement> popupElement = driver
					.findElements(By.cssSelector(PropertiesRepository.getString("reassigning.popup.headr")));
			if (CollectionUtils.isNotEmpty(popupElement)) {
				String text = popupElement.get(0).getText();
				if (StringUtils.isNotBlank(text) && textpopup.equalsIgnoreCase(text)) {
					flag = true;
				}
			} else {
				logger.info("Unable to verify popup message");
			}
		} catch (Exception e) {
			logger.info("Not able to verify reassign popup");
			throw new DriverException("Not able to verify reassign popup");
		}
		logger.info("verifyReassignVerifyPopup ::: END flag --> " + flag);
		return flag;
	}
	
	public boolean enterClassToReassignWithContent(WebDriver driver, String cohortInputName) throws DriverException {
		logger.info(" enterClassToReassignWithContent Start");
		boolean flag = false;
		try {
			// Verifying Reassign Cohort Popup.
			WebElement popupHeaderElement = verifyElement(driver,
					PropertiesRepository.getString("id.people.reassign.popup.title.loc"));
			if (popupHeaderElement != null && PropertiesRepository.getString("id.people.reassign.popup.title.value")
					.equalsIgnoreCase(popupHeaderElement.getText())) {
				// Entering cohort value.
				WebElement cohortElement = verifyElement(driver,
						PropertiesRepository.getString("id.people.reassign.popup.cohort.text.box.loc"));
				if (cohortElement != null) {
					cohortElement.clear();
					cohortElement.sendKeys(cohortInputName);
				} else {
					logger.info("Unable to enter cohort in Reassign cohort popup");
				}
				waitUntillLoadingImageIsDisappeared(driver, PropertiesRepository.getString("id.common.page.loader"));

				WebElement cohortDDValue = verifyElement(driver, 
						PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
				if (cohortDDValue != null) {
					cohortDDValue.click();
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}

				// Clicking on Confirm button.
				verifyAndClick(driver, PropertiesRepository.getString("id.people.reassign.popup.confirm.button.loc"), true);
				// Getting second popup value.
				WebElement secondPopupElement = verifyElement(driver, 
						PropertiesRepository.getString("id.people.are.you.sure.title.loc"));
				if (secondPopupElement != null && PropertiesRepository.getString("id.people.are.you.sure.title.value")
						.equalsIgnoreCase(secondPopupElement.getText())) {
					// Getting Are you sure? first content and verify.
					boolean boolAreYouSureFirstContent = verifyMessage(driver, "id.people.are.you.sure.popup.first.content.loc",
							0, PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.value"));

					// Getting Are you sure? Cohort Name.
					boolean cohortName = verifyMessage(driver, "id.people.are.you.sure.popup.selected.cohort.name.loc", 0,
							cohortInputName);

					// Getting Remember message value.
					boolean rememberContent = verifyMessage(driver, "id.people.are.you.sure.popup.remember.content.loc", 0,
							PropertiesRepository.getString("id.people.are.you.sure.popup.remember.content.value"));

					// Verifying Are you Sure content.
					if (boolAreYouSureFirstContent && cohortName && rememberContent) {

						// Clicking on Are you Sure Confirm button.
						verifyAndClick(driver, PropertiesRepository.getString("id.people.are.you.sure.confirm.button.loc"), true);

						// Clicking on Continue button in In Progress Popup.
						WebElement inProgressPopup = verifyElement(driver, 
								PropertiesRepository.getString("id.people.in.progress.popup.title.loc"));
						if (inProgressPopup != null
								&& PropertiesRepository.getString("id.people.in.progress.popup.title.value")
										.equalsIgnoreCase(inProgressPopup.getText())) {

							// In Progress popup first content.
							boolean boolFirstContent = verifyMessage(driver, 
									"id.people.are.you.sure.popup.first.content.loc", 0,
									PropertiesRepository.getString("id.people.in.progress.first.content.value"));

							// In Progress Getting Cohort name.
							boolean inProgressCohortName = verifyMessage(driver, 
									"id.people.are.you.sure.popup.selected.cohort.name.loc",
									0, cohortInputName);

							// In Progress Second content.
							boolean boolSecondContent = verifyTextContains(driver, 
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.second.content.value"), 1);

							// In Progresss Third content.
							boolean boolThirdContent = verifyTextContains(driver, 
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.third.content.value"), 2);

							// Verifying In Progress Content.
							if (boolFirstContent && inProgressCohortName && boolSecondContent && boolThirdContent) {
								verifyAndClick(driver, PropertiesRepository.getString("id.people.in.progress.popup.continue.button.loc"), true);
								flag = true;
							} else {
								logger.info("Unable to verify content in In Progress Popup");
							}
						} else {
							logger.info("Unable to click  Continue button in In Progress Popup");
						}
					} else {
						logger.info("Unable to verify Are you sure? popup content. ");

					}

				} else {
					logger.info("Unable to click Confirm button in Are you sure popup");
				}
			} else {
				logger.info("Popup header is not displayed");
			}
		} catch (Exception e) {
			logger.info("Unable assign to enterClassToReassignWithContent");
			throw new DriverException("Unable assign to enterClassToReassignWithContent", e);
		}
		logger.info("enterClassToReassignWithContent End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessage(WebDriver driver, String locator, int index, String value) throws DriverException {
		logger.info("verifyMessage Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			List<WebElement> element = driver.findElements(By.cssSelector(PropertiesRepository.getString(locator)));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyMessage");
			log(logger, "Unable to verifyMessage");
			throw new DriverException("Unable to verifyMessage", e);
		}
		logger.info("verifyMessage End flag -->" + flag);
		return flag;
	}
	
	/**
	 * 
	 * @param cohortName
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCohortInTransferHistory(WebDriver driver, String cohortName, int index) throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			// Get the list of row in Transfer History.
			List<WebElement> element = driver.findElements(By.cssSelector(PropertiesRepository.getString("id.people.transfer.history.table.row.loc")));
			if(CollectionUtils.isNotEmpty(element)) {
				// Get div details based on index. 
				List<WebElement> divIndexElement = element.get(index).findElements(By.cssSelector("div"));
				if(CollectionUtils.isNotEmpty(divIndexElement)) {
					
					// Getting first div and getting all label. 					
					List<WebElement> labelIndexElement1 = divIndexElement.get(0).findElements(By.cssSelector("label"));
					if(CollectionUtils.isNotEmpty(labelIndexElement1)) {
						if(labelIndexElement1.stream().filter(wE->wE.getText().trim().contains(cohortName)).count()>0){
							flag = true;
						}
					} else {
						logger.info("Unable to get values. ");
					}
					
					List<WebElement> labelIndexElement2 = divIndexElement.get(3).findElements(By.cssSelector("label"));
					if(CollectionUtils.isNotEmpty(labelIndexElement2)) {
						if(labelIndexElement1.stream().filter(wE->wE.getText().trim().contains("Complete")).count()>0){
							flag = true;
						}
					} else {
						logger.info("Unable to get values. ");
					}
					
				} else {
					logger.info("Unable to get rows");
				}
			} else {
				logger.info("Unable to find elements");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCohortInTransferHistory" );
			log(logger, "Unable to verifyCohortInTransferHistory" );
    		throw new DriverException("Unable to verifyCohortInTransferHistory" , e); 
    	}
		logger.info("Method: verifyCohortInTransferHistory End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClick(WebDriver driver, String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("click value --> " + click);
		boolean flag = false;
		//locator = "div[class='ng-star-inserted'] button[class='mat-button mat-primary'] span";
		try {
			List<WebElement> element = verifyElementList(driver, locator);
			if (element != null) {
				if (click) {
					element.get(index).click();
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}
}
