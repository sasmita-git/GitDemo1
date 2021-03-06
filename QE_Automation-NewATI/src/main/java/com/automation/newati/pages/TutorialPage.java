package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage extends TutorialPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private DropDownHandler dropDownHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;
	
	public TutorialPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		textHandler = new TextHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * This method is used to select practice from dropdown
	 * 
	 * @author Sanapati.Srinu
	 * @param dropDownInput
	 * @throws DriverException
	 */
	public void selectTutorialFromDropDown(String dropDownInput) {
		logger.info("Method: selectTutorialFromDropDown Starts");
		try {
			// Wait untill Content Area text to be displayed
			baseHandler.waitToBeDisplayed(".content-area-select>label");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// select tutorial from all dropdown
			Select selDrop = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.Quiz.dropdownLoc"));
			dropDownHandler.selectByValue(selDrop, dropDownInput);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to select tutorial from dropdown", e);
		}
		logger.info("Method: selectTutorialFromDropDown Ends");
	}

	/**
	 * This method is used to select practice from dropdown
	 * 
	 * @author Sanapati.Srinu
	 * @param dropDownInput
	 * @throws DriverException
	 */
	public void selectValueBySelectClass(String dropDownInput) {
		logger.info("Method: selectTutorialFromDropDown Starts");
		try {
			// Wait untill Content Area text to be displayed
			baseHandler.waitToBeDisplayed(".content-area-select>label");
			// select tutorial from all dropdown
			Select selDrop = dropDownHandler.getDropDown(dropDownInput);
			dropDownHandler.selectByIndex(selDrop, 3);

		} catch (Exception e) {
			logger.info("Unable to select tutorial from dropdown", e);
		}
		logger.info("Method: selectTutorialFromDropDown Ends");
	}
	
	/**
	 * This method is used to select practice from dropdown
	 * 
	 * @author Sanapati.Srinu
	 * @param dropDownInput
	 * @throws DriverException
	 */
	public void selectValueBySelectClass(String locator, String dropDownInput) {
		logger.info("Method: selectTutorialFromDropDown Starts");
		try {
			// Wait untill Content Area text to be displayed
			baseHandler.waitToBeDisplayed(".content-area-select>label");
			// select tutorial from all dropdown
			Select selDrop = dropDownHandler.getDropDown(locator);
			dropDownHandler.selectByValue(selDrop, dropDownInput);

		} catch (Exception e) {
			logger.info("Unable to select tutorial from dropdown", e);
		}
		logger.info("Method: selectTutorialFromDropDown Ends");
	}
	public boolean verifyEachModuleBeginLessonAndBeginTest() throws Exception {
		List<Boolean> list = new ArrayList<Boolean>();
		List<WebElement> findElements2 = null;
		WebElement firstBeginTestButton = null;
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<WebElement> findElements = baseHandler
				.findElements(PropertiesRepository
						.getString("new-atitesting.tutorial.cardback.buttons.update"));
		if (CollectionUtils.isNotEmpty(findElements)) {
			firstBeginTestButton = findElements
					.get(0)
					.findElements(
							By.cssSelector(".product-list-style li section div:nth-of-type(1) a"))
					.get(0);
			for (WebElement webElement : findElements) {

				findElements2 = webElement
						.findElements(By
								.cssSelector(".product-list-style li section div:nth-of-type(1) a"));
				if (CollectionUtils.isNotEmpty(findElements2)) {
					String[] lesson = findElements2.get(0).getText()
							.split("\\n");
					String[] test = findElements2.get(0).getText().split("\\n");
					if ("BEGIN LESSON".equals(lesson[0] + " " + lesson[1])
							|| "BEGIN TEST".equals(test[0] + " " + test[1])
							|| "CONTINUE TEST".equals(test[0] + " " + test[1])
							|| "RETAKE TEST".equals(test[0] + " " + test[1])) {
						list.add(true);
					} else {
						list.add(false);
					}
				}
			}
		}
		boolean contains = list.contains(false) ? false : true;
		if (contains) {
			firstBeginTestButton.click();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
		return contains;

	}

	/**
	 * Method to check Logo.
	 * 
	 * @param logoLoc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean checkLogo(String logoLoc, String... waitFor) {
		logger.info("Method : checkLogo :::::::: Start  " + logoLoc);
		
		boolean flag = false;
		if (waitFor != null && waitFor.length > 0) {
			baseHandler.setDriverWait(driver, waitFor[0]);
		}
		windowHandler.switchToFrame("assessmentFrame");
		WebElement logoElement = baseHandler.findElement(logoLoc);
		if (logoElement != null) {
			flag = baseHandler.isDisplayed(logoElement);
		}
		logger.info("Method : checkLogo :::::::: End" + flag);
		return flag;
	}

	public boolean verifyCloseButton() throws Exception {
		logger.info("Method: verifyCloseButton Starts");
		boolean flag = false;
		try {
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc.new")))) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to verify Close Button");
			throw new DriverException("Unable to verify Close Button", e);
		}
		logger.info("Method: verifyCloseButton End flag --> " + flag);
		return flag;
	}

	public boolean verifyQuestionLableText() throws DriverException {
		logger.info("Method: verifyQuestionLableText Start");
		boolean flag = false;
		try {
			flag = false;
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
			String currentFrame = (String) jsExecutor.executeScript("return self.name");
			if(!(currentFrame.equals("assessmentFrame")))
			{
				windowHandler.switchToFrame("assessmentFrame");	
			}
			if (baseHandler.isDisplayed(baseHandler.findElement("#header"))) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		} catch (Exception e) {
			logger.info("Unable to verify question label text");
			throw new DriverException("Unable to verify question label text", e);
		}
		logger.info("Method: verifyQuestionLableText End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyQuestionLabelText() throws DriverException {
		logger.info("Method: verifyQuestionLabelText Start ");
		boolean flag = false;
		try {
			flag = false;
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    		String currentFrame = (String) jsExecutor.executeScript("return self.name");
    		if(!(currentFrame.equalsIgnoreCase("assessmentFrame")))
    		{
			windowHandler.switchToFrame("assessmentFrame");
    		}
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new")))) {
				flag = true;
			}
			windowHandler.switchToMainWindow();

		} catch (Exception e) {
			windowHandler.switchToMainWindow();
			logger.info("Unable to verifyQuestionLabelText text");
			throw new DriverException("Unable to verifyQuestionLabelText text", e);
		}
		logger.info("Method: verifyQuestionLabelText End flag --> " + flag);
		return flag;
	}

	public boolean isElementDisplayed(String loc) throws DriverException {
		boolean flag = false;
		try {
			flag = false;
			if (baseHandler.isDisplayed(baseHandler
					.findElement(PropertiesRepository.getString(loc)))) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to verify Close Button");
			throw new DriverException("Unable to verify Close Button", e);
		}
		return flag;
	}

	public void takeRationalTutorialTest() throws Exception {
		logger.info("Method : takeRationalTutorialTest :::::::: Starts");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToFrame("assessmentFrame");
			String maxQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.maxQtnLoc"));

			int maxCount = Integer.parseInt(maxQtnTextNo);

			String minQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.minQtnLoc"));

			int minCount = Integer.parseInt(minQtnTextNo);

			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				if (i == count) {
					if (driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).isSelected()) {
						{
							driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							clickButton(".button.primary-button.focus-element-flag",1);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							windowHandler.switchToMainWindow("");
							return;
						}
					} else {
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						clickButton(".button.primary-button.focus-element-flag", 1);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> list = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
						if (list != null) {
							clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						return;

					}
				}
				List<WebElement> inputBoxOption = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"));
				List<WebElement> checkboxOrRadioButtonOptions = baseHandler.findElements(".question-option.focus-element-flag label");
				if (inputBoxOption != null) {
					textHandler.writeText(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"),"10");
					clickOption();
				} else if (checkboxOrRadioButtonOptions != null) {
					checkboxOrRadioButtonOptions.get(0).click();
					clickOption();
				} else {
					try {
						buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if (driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).isEnabled()) {
							buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.continue.button"));
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					} catch (Exception e) {
						logger.info("unable to click the button" + e);
						throw new DriverException("unable to click the button",e);
					}
				}
				if(count==i)
				{
				clickButton(".button.primary-button.focus-element-flag", 1);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				List<WebElement> list = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
				if (list != null) {
					clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
				}

			}
		} catch (DriverException e) {
			logger.info("unable to take tutorial test" + e);
		}

		logger.info("Method : takeRationalTutorialTest :::::::: END");
	}
	

	/*private void clickOnViewResultsButton() throws Exception {
			// Clicking on Finalize and View Results Button.
		try {
			windowHandler.switchToModalDialog();
			clickButton(".button.primary-button.focus-element-flag", 1);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> list = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
			if (list != null) {
				clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
			
	}*/

	private void clickOption() throws DriverException {
		try {
			buttonHandler
					.clickButton(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.continue.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> webElements = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.continue.button"));
			if (CollectionUtils.isNotEmpty(webElements)) {
				driver.findElement(
						By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
						.sendKeys(Keys.ENTER);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("unable to click the button" + e);
			throw new DriverException("unable to click the button", e);
		}

	}

	/**
	 * Method used to take Assessment for Test Tab.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void takeTutorialAssessmentTest(boolean rationalFlag)
			throws Exception {
		// logger.info("Method : takeTutorialAssessmentTest :::::::: Starts");
		try {
			/*
			 * waitUntillLoadingImageIsDisappeared(PropertiesRepository
			 * .getString("new-atitesting.peasewait.bufferLoc"));
			 */
			/*
			 * switchHandlers(); String[] questionNos = getQuestionNo();
			 */

			windowHandler.switchToFrame("assessmentFrame");
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.maxQtnLoc"));

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.minQtnLoc"));

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler
						.findElements(".question-option.focus-element-flag label");
				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("new-atitesting.test.assessment.radio.button.loc"));
				List<WebElement> hotSpotElement = baseHandler
						.findElements(PropertiesRepository
								.getString("new-atitesting.test.assessment.hot.spot.image"));

				if (CollectionUtils.isNotEmpty(checkBoxElement)
						&& checkBoxElement.size() > 0) {
					checkBoxElement.get(0).click();
				}

				/*
				 * if (driver .findElement(
				 * By.cssSelector(".answer-fill-in-the-blank.numericTextEntry"))
				 * .isDisplayed()) { driver.findElement(
				 * By.cssSelector(".answer-fill-in-the-blank.numericTextEntry"))
				 * .sendKeys("10"); }
				 */

				// Clicking Flag if it has Hot Spot Image,
				if (CollectionUtils.isNotEmpty(hotSpotElement)
						&& hotSpotElement.size() > 0) {
					buttonHandler
							.clickButton(PropertiesRepository
									.getString("new-atitesting.test.assessment.flag.button.loc"));
				}

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
				}
				if (i == count) { // FOra
					// Clicking continue button.
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler
							.findElements(PropertiesRepository
									.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							buttonElement.get(0).click();
						}
					}

					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

					if (rationalFlag) {
						Thread.sleep(5000);
						driver.findElement(
								By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
								.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					// Clicking on Finalize and View Results Button.
					clickButton(".button.primary-button.focus-element-flag", 1);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

				} else {
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler
							.findElements(PropertiesRepository
									.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							buttonElement.get(0).click();
						}
					}

					if (rationalFlag) {
						Thread.sleep(5000);
						driver.findElement(
								By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
								.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}

					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to take Assessment Test");
			log(logger, "Unable to take Assessment Test");
			throw new DriverException("Unable to take Assessment Test", e);
		}
		logger.info("Method: takeTutorialAssessmentTest End ");
	}

	public void takeTutorialTest() throws DriverException {
		try {
			windowHandler.switchToFrame("assessmentFrame");
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.maxQtnLoc"));

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText(PropertiesRepository
					.getString("new-atitesting.test.minQtnLoc"));

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
			}

		} catch (Exception e) {
			throw new DriverException("unable to click the button", e);
		}
	}
	
	
	public void clickModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start ");
		List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
		
		try {
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						WebElement mainDivElement = element1.findElement(By.cssSelector(
								".button.primary-button.cardflip.focus-element-flag"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								mainDivElement);
						if (mainDivElement != null) {
//							List<WebElement> moduleButtons = mainDivElement.findElements(
//									By.cssSelector(".button.primary-button.cardflip.focus-element-flag"));
//							moduleButtons.get(0).click();
							mainDivElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

							break;
						}
					}
				}
			}

		} catch (Exception e) {
			throw new DriverException("Unable to click on module button");
		}
	
		logger.info("Method: clickModuleButtonByName End");
	}
	
	public void clickQuizModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickQuizModuleButtonByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.Quiz.all.modules.loc"));

		try {
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						WebElement mainDivElement = element1.findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: $parent.HasMultipleLearningLoopItems']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",mainDivElement);
						if (mainDivElement != null) {
							List<WebElement> moduleButtons = mainDivElement.findElements(
									By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
							moduleButtons.get(0).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on module button");
		}
		logger.info("Method: clickQuizModuleButtonByName End");
	}
	
	public void clickQuizzModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickQuizzModuleButtonByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));

		try {
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						WebElement mainDivElement = element1.findElement(By.cssSelector(
								"nav[class='actions'] div[data-bind*='visible: Tutorial.HasMultipleLearningLoopItems()']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								mainDivElement);
						if (mainDivElement != null) {
							List<WebElement> moduleButtons = mainDivElement.findElements(
									By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
							moduleButtons.get(0).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

							break;
						}

					}

				}

			}

		} catch (Exception e) {
			throw new DriverException("Unable to click on module button");
		}

		logger.info("Method: clickQuizzModuleButtonByName End");
	}
	
	public boolean clickModuleButtonByNameSelectInstance(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByNameSelectInstance Start");
//		boolean flag = false;
//		try {
//			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc.quiz.new"));
//			if (moduleList != null && moduleList.size() > 0) {
//				int size = moduleList.size();
//			
//				for (int i = 0; i < size; i++) {
//					
//					WebElement element = moduleList.get(i).findElement(By.cssSelector(".description"));
////					WebElement element1 = element.get(0);
//					if (assessmentName.equalsIgnoreCase(element.getText())) {
//						
//						
//						element.findElements(By.cssSelector(".button.primary-button.cardflip.focus-element-flag")).get(0).click();
//						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//						flag = verifySelectInstance();
//						break;
//					} 
//				}
//			}
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i);
					if(element != null) {
						WebElement nameElement = element.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc")));
						if(nameElement != null) {
							String tutorialName = nameElement.getText();
							if(StringUtils.isNotBlank(tutorialName) && tutorialName.equalsIgnoreCase(assessmentName)) {
								List<WebElement> buttonElement = element.findElements(By.cssSelector(".button.primary-button.cardflip.focus-element-flag"));
								if(CollectionUtils.isNotEmpty(buttonElement)) {
									buttonElement.get(1).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									flag = verifyTutorialSelectInstance();
									break;
								}
							}
						}
					}
				}
					
			}
		} catch(Exception e) {
			throw new Exception("clickModuleButtonByNameSelectInstance ", e);
		}
		logger.info("Method: clickModuleButtonByNameSelectInstance End flag-- > " + flag);
		return flag;
	}
	
	public boolean clickTutorialModuleSelectInstance(String assessmentName) throws Exception {
		logger.info("Method: clickTutorialModuleSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("section[id='tabs-2'] ul[class='image-grid flipcontainer'] li");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i);
					if(element != null) {
						WebElement nameElement = element.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc")));
						if(nameElement != null) {
							String tutorialName = nameElement.getText();
							if(StringUtils.isNotBlank(tutorialName) && tutorialName.equalsIgnoreCase(assessmentName)) {
								List<WebElement> buttonElement = element.findElements(By.cssSelector("section[class='card practice-assessment front'] div nav #selectInstanceButton a"));
								if(CollectionUtils.isNotEmpty(buttonElement)) {
									buttonElement.get(0).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									flag = verifyTutorialSelectInstance();
									break;
								}
							}
						}
					}
				}
					
			}
		} catch(Exception e) {
			throw new Exception("clickTutorialModuleSelectInstance ", e);
		}
		logger.info("Method: clickModuleButtonByNameSelectInstance End flag-- > " + flag);
		return flag;
	}
	
	public boolean clickOnNCLEXModuleButtonForTEmp(String assessmentName) throws Exception {
		logger.info("Method: clickOnNCLEXModuleButtonForTEmp Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-6 ul li");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i)
							.findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container']"));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
						if (cardFrontName != null) {
							String name = cardFrontName.getText();
							if (name.equalsIgnoreCase(assessmentName)) {
								// Clicking on button.
								List<WebElement> navDivElement = moduleList.get(i)
										.findElements(By.cssSelector("nav div a[id^='NCLEXButtonText'] span"));
								navDivElement.get(0).click();
								break;

							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickOnNCLEXModuleButton");
			log(logger, "Unable to clickOnNCLEXModuleButton");
			throw new DriverException("Unable to clickOnNCLEXModuleButton", e);
		}
		logger.info("Method: clickOnNCLEXModuleButtonForTEmp End flag --> " + flag);
		return flag;
	}
	
	public boolean clickOnNCLEXModuleButton(String assessmentName) throws Exception {
		logger.info("Method: clickOnNCLEXModuleButton Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-6 ul li");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container']"));
					if(cardFrontDetails != null) {
					WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
					if( cardFrontName != null) {
						String name = cardFrontName.getText();
						if(name.equalsIgnoreCase(assessmentName)) {
							// Clicking on button. 
							List<WebElement> navDivElement = cardFrontDetails.findElements(By.cssSelector("nav div"));
							
							if(CollectionUtils.isNotEmpty(navDivElement)) {
								WebElement buttonElement = navDivElement.get(1);
							//	WebElement buttonElement = navDivElement.findElement(By.cssSelector("nav div"));
								
								if(buttonElement != null) {
									buttonElement.findElement(By.cssSelector("a")).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									flag = true;
									break;
								}
							}
							else
							{
								List<WebElement> navDivElement1 = cardFrontDetails.findElements(By.cssSelector("section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container'] nav div div a"));
								WebElement buttonElement = navDivElement1.get(0);
								if(buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickOnNCLEXModuleButton" );
			log(logger, "Unable to clickOnNCLEXModuleButton" );
    		throw new DriverException("Unable to clickOnNCLEXModuleButton" , e); 
    	}
		logger.info("Method: clickOnNCLEXModuleButton End flag --> " + flag);
		return flag;
	}
	
	
	
	public boolean clickOnNCLEXModuleButtonSelectInstance(String assessmentName) throws Exception {
		logger.info("Method: clickOnNCLEXModuleButtonSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-6 ul li");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container']"));
					if(cardFrontDetails != null) {
					WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
					if( cardFrontName != null) {
						String name = cardFrontName.getText();
						if(name.equalsIgnoreCase(assessmentName)) {
							// Clicking on button. 
							List<WebElement> navDivElement = cardFrontDetails.findElements(By.cssSelector("div[data-bind='visible: NCLEXPrep.HasMultipleLearningLoopItems()']"));
							
							if(CollectionUtils.isNotEmpty(navDivElement)) {
								WebElement buttonElement = navDivElement.get(0);
								
								if(buttonElement != null) {
									List<WebElement> aElement = buttonElement.findElements(By.cssSelector("a[class='primary-button button cardflip focus-element-flag']"));
									if(CollectionUtils.isNotEmpty(aElement)) {
										aElement.get(0).click();
										//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										flag = true;
										break;
									}
									
								}
							}
							else
							{
								List<WebElement> navDivElement1 = cardFrontDetails.findElements(By.cssSelector("section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container'] nav div div a"));
								WebElement buttonElement = navDivElement1.get(0);
								if(buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickOnNCLEXModuleButtonSelectInstance" );
			log(logger, "Unable to clickOnNCLEXModuleButtonSelectInstance" );
    		throw new DriverException("Unable to clickOnNCLEXModuleButtonSelectInstance" , e); 
    	}
		logger.info("Method: clickOnNCLEXModuleButtonSelectInstance End flag --> " + flag);
		return flag;
	}
	
	
	public boolean clickOnVCSModuleByName(String vcsName) throws Exception {
		logger.info("Method: clickOnVCSModuleByName Start");
		logger.info("Method : Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-4 .card.simulation.front");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).findElement(By.cssSelector(".description")).getText().equalsIgnoreCase(vcsName)) {
						List<WebElement> navDivElement = moduleList.get(i).findElements(By.cssSelector("nav div a"));
						for(WebElement moduleElement : navDivElement) {
							String style = moduleElement.getAttribute("style");
							if(!style.equalsIgnoreCase("display: none;")) {
								moduleElement.click();
								flag = true;
								break;							
							}
						}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
		logger.info("Method: clickOnVCSModuleByName End flag --> " + flag);
		return flag;
	}
	
	
	
	public boolean verifyAssessmentFrameObjects() throws DriverException {
		logger.info("Method: verifyAssessmentFrameObjects Start");
		boolean flag = false;
		try {
			
			windowHandler.switchToFrame("assessmentFrame");
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.calculator.loc")))
					&& baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.time.elapsed.loc.new")))
					&& baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.loc")))) {

				flag = true;
				windowHandler.switchToMainWindow();
			}
		} catch (Exception e) {
			logger.info("Unable to verify Close Button");
			throw new DriverException("Unable to verify Close Button", e);
		}
		logger.info("Method: verifyAssessmentFrameObjects End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyAssessmentFrameObjectsWithoutCalc() throws DriverException {
		logger.info("Method: verifyAssessmentFrameObjects Start");
		boolean flag = false;
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
    		String currentFrame = (String) jsExecutor.executeScript("return self.name");
    		if(!(currentFrame.equalsIgnoreCase("assessmentFrame")))
    		{
			windowHandler.switchToFrame("assessmentFrame");
    		}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.assessment.time.elapsed.loc.new")))
					&& baseHandler
							.isDisplayed(baseHandler.findElement(PropertiesRepository
									.getString("new-atitesting.assessment.flag.button.loc.new")))) {

				flag = true;				
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			logger.info("Unable to verify Close Button");
			throw new DriverException("Unable to verify Close Button", e);
		}
		logger.info("Method: verifyAssessmentFrameObjects End flag --> " + flag);
		return flag;
	}

	public boolean verifySubTabs() throws DriverException {
		logger.info("Method: verifySubTabs Starts");
		try {

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.all.tabs"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> tabElement = element.get(0).findElements(
						By.cssSelector(PropertiesRepository
								.getString("new-atitesting.common.li")));
				if (CollectionUtils.isNotEmpty(tabElement)
						&& tabElement.size() == 4) {
					return true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifySubTabs");
			log(logger, "Unable to verifySubTabs");
			throw new DriverException("Unable to verifySubTabs", e);
		}
		logger.info("Method: verifySubTabs End ");
		return false;
	}

	public boolean verifyProductId(String productID,String loc,int index) {
		System.out.println();
		List<WebElement> elements = baseHandler.findElements(loc);
		if(CollectionUtils.isNotEmpty(elements))
		{
			elements.get(0).click();
			List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.information"));
			if(CollectionUtils.isNotEmpty(elements1))
			{
				String text = elements1.get(1).getText();
				if(StringUtils.isNotEmpty(text) && productID.trim().equals(text.split("-")[index]))
				{
					return true;
				}
			}
		}
		return false;
	}

	/*public void clickButtonFromList(String loc,int index) throws Exception {
		logger.info("clickButtonFromList Start");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements))
			{	
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
				elements.get(index).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("Unable to clickButtonFromList");
			log(logger, "Unable to clickButtonFromList");
			throw new DriverException("Unable to clickButtonFromList", e);
		}
		logger.info("clickButtonFromList Ends");
		
	}*/
	
	public void clickButtonforOrdersummary(String loc,int index) throws Exception {
		logger.info("clickButtonforOrdersummary Start");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements))
			{	
				elements.get(index).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("Unable to clickButtonforOrdersummary");
			log(logger, "Unable to clickButtonforOrdersummary");
			throw new DriverException("Unable to clickButtonforOrdersummary", e);
		}
		logger.info("clickButtonforOrdersummary End");
	}
	
	public void enterText(String loc, String input,int index) {
		logger.info("enterText Start");
		
		try {
			List<WebElement> findElements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(findElements))
			{
				findElements.get(index).clear();
				findElements.get(index).sendKeys(PropertiesRepository.getString(input));
			}
		} catch (Exception e) {
			logger.info("Unable to enterText");
			log(logger, "Unable to enterText");
		}
		logger.info("enterText End");
	}

	public boolean startFocusedReview() throws DriverException {
		logger.info("Method: startFocusedReview Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler.findElements(".card.focused-review.front nav a");
			if (CollectionUtils.isNotEmpty(elements)) {
				int sizeButton = elements.size();
				for (int index = 0; index < sizeButton; index++) {
					String styleAttribute = elements.get(index).getAttribute("style");
					if (StringUtils.isEmpty(styleAttribute)) {
						elements.get(index).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to start Focused Review", e);
		}
		logger.info("Method: startFocusedReview Ends flag --> " + flag);
		return flag;
	}

	public boolean verifyTabSize() throws Exception {
		try {
			Set<String> windowHandles = windowHandler.getWindowHandles();
			if(windowHandles.size()>0)
			{
				return true;
			}
		} catch (Exception e) {
		}
		
		return false;
	}

	public boolean verifyOnlineStoreUrl() throws Exception {
		try {
			windowHandler.switchToLatestWindow();
			String url = driver.getCurrentUrl();
			String name = url.split("\\?")[0];
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(name.contains(PropertiesRepository.getString("new-atitesting.online.store.url")))
					{
				return true;
					}
			
		} catch (Exception e) {
		}
	
		return false;
	}
		
	public void closeCurrentWindow(String mainWindow)
	{
		try {
			/*Set<String> windowHandles = driver.getWindowHandles();
			System.out.println(windowHandles.size());*/
			windowHandler.switchToLatestWindow().close();
			windowHandler.switchToWindow(mainWindow);
		//	windowHandler.switchToMainWindow();
		} catch (Exception e) {
		}
		
	}

	public boolean verifyAdvertisementPage() {
		
		boolean flag=false;
		List<WebElement> findElements = baseHandler.findElements(".focus-element-flag img");
		if(CollectionUtils.isNotEmpty(findElements))
		{
			for (WebElement webElement : findElements) {
				
				if(webElement.isDisplayed())
				{
					webElement.click();
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
	
	/**
	 * Method is used to verify All Begin Button in STT Card Back.
	 * 
	 * Two Buttons.
	 * 
	 * Begin Lesson Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAllBeginLessonInCardBackForSTT(String assessmentName) throws Exception {
		logger.info("Method: verifyAllBeginLessonInCardBackForSTT Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			//Thread.sleep(5000);
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc"));
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc")))) {
				if (assessmentName
						.equalsIgnoreCase(
								baseHandler
										.findElement(
												PropertiesRepository
														.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc"))
										.getText())) {
					List<WebElement> allBeginButtonLiElement = baseHandler
							.findElements(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
					if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
						int size = allBeginButtonLiElement.size();
						for (int index = 0; index < size; index++) {
							String beginLesson = allBeginButtonLiElement
									.get(index)
									.findElement(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.stt.card.front.begin.lesson.button")))
									.getText().replace("\n", "")
									.replace("\r", "");
							if ("BeginLesson".equalsIgnoreCase(beginLesson)) {
								flag = true;
							} else {
								flag = false;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to Verify All Begin Lesson In Card Back For STT");
			throw new DriverException(
					"Unable to Verify All Begin Lesson In Card Back For STT", e);
		}
		logger.info("Method: verifyAllBeginLessonInCardBackForSTT End flag --> "
				+ flag);
		return flag;
	}

	/**
	 * Method is used to verify All Begin Button in vcs-lite Card Back.
	 * 
	 * Two Buttons.
	 * 
	 * Begin Lesson Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyBeginLessonInCardBackForvcslite(String loc, int index, String btnname) throws DriverException {
		boolean flag = false;
		try {
			List<WebElement> allBeginButtonElement = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(allBeginButtonElement)) {
				if (allBeginButtonElement.get(index).getText().trim().contains(btnname)) {
				flag = true;
				}
			}
			
		} catch (Exception e) {
			logger.info("Unable to verifyBeginLessonInCardBackForvcslite");
			throw new DriverException("Unable to verifyBeginLessonInCardBackForvcslite", e);
		}
		return flag;
	
	}
	public boolean verifymoduleButtonasContinue(String loc, int index, String btnname) throws DriverException {
		  boolean flag = false;
		  try {
		   List<WebElement> allmoduleButtonElement = baseHandler.findElements(PropertiesRepository.getString(loc));
		   if (CollectionUtils.isNotEmpty(allmoduleButtonElement)) {
		    if (allmoduleButtonElement.get(index).getText().trim().replaceAll("\n", " ").equals(btnname)) {
		    flag = true;
		    }
		   }
		   
		  } catch (Exception e) {
		   logger.info("Unable to verifymoduleButtonasContinue");
		   throw new DriverException("Unable to verifymoduleButtonasContinue", e);
		  }
		  return flag;
		 
		 }
}
