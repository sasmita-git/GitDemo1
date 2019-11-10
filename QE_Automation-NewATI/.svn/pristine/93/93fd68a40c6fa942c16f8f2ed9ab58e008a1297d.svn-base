package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class TestTabPage extends TestTabPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	private WindowHandler windowHandler;
	private ButtonHandler buttonHandler;
	private TextHandler textHandler;
	public HomePage homePage;
	public TestTabPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		windowHandler = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		textHandler = new TextHandler(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * Method used to select value from view/ type/ sort option from test tab. 
	 * 
	 * @author saravanan.jothimani
	 * @param index
	 * @param selectValue
	 * @throws Exception
	 */
	public void selectFiltersDropDown(int index, String selectValue) throws Exception {
		logger.info("Method: selectFiltersDropDown Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.tab.filters.all"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			Select select = dropDownHandler.getDropDown(element.get(index));
    			select.selectByValue(selectValue);
    		}
    	} catch (Exception e) {
    		logger.info("Unable to select Filters DropDown" );
			log(logger, "Unable to select Filters DropDown" );
    		throw new DriverException("Unable to select Filters DropDown" , e); 
    	}
    	logger.info("Method: selectFiltersDropDown End " );
	}
	
	/**
	 * Method used to switch to assessmentFrame frame. 
	 * 
	 * @author saravanan.jothimani
	 */
	public void switchHandlers() {
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame("assessmentFrame");
	}
	
	/**
	 * Method is used to get Question No from Assessment Page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	private String[] getQuestionNo() throws Exception {
		logger.info("Method: getQuestionNo Starts");
		String[] questionNo = new String[2];
    	try {
     		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc"));
     		if(CollectionUtils.isNotEmpty(element)) {
     			questionNo[0] = element.get(0).getText();
     			questionNo[1] = element.get(1).getText();
     		}
     		
    	} catch (Exception e) {
    		logger.info("Unable to get Question No");
			log(logger, "Unable to get Question No" );
    		throw new DriverException("Unable to get Question No" , e); 
    	}
    	logger.info("Method: getQuestionNo End String[] --> " + questionNo);
    	return questionNo;
	}
	
	public void clickAssessmemtType() throws Exception {
		List<WebElement> checkBoxElement = baseHandler
				.findElements(".question-option.focus-element-flag label");
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
		List<WebElement> hotSpotElement = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.hot.spot.image"));				
		List<WebElement> inputBoxOption = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"));
		
		if (CollectionUtils.isNotEmpty(checkBoxElement)
				&& checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
		} else 	if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking Flag if it has Hot Spot Image
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
		} else if (CollectionUtils.isNotEmpty(radioElement)
				&& radioElement.size() > 0) {
			radioElement.get(0).click();
		} else if(CollectionUtils.isNotEmpty(inputBoxOption)) {
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"), "10");
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
	}
	/**
	 * Method used to take Assessment for Test Tab. 
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @param
	 * quizComplButtonName	- 	Go Back to Last Question
	 * 							Finalize and View Results
	 * @throws Exception
	 */
	public void takeAssessmentTest(boolean rationalFlag, String quizComplButtonName) throws Exception {
		logger.info("Method : takeAssessmentTest :::::::: Starts ");
		try {
			switchHandlers();
			Thread.sleep(10000);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			String[] questionNos = getQuestionNo();
			// Convert String to Integer
			int maxCount = Integer.parseInt(questionNos[1]);

			// Convert String to Integer
			int minCount = Integer.parseInt(questionNos[0]);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				
				List<WebElement> checkBoxElement = baseHandler
						.findElements(".question-option.focus-element-flag label");
				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
				List<WebElement> hotSpotElement = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.hot.spot.image"));				
				List<WebElement> inputBoxOption = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"));
				
				if (CollectionUtils.isNotEmpty(checkBoxElement)
						&& checkBoxElement.size() > 0) {
					checkBoxElement.get(0).click();
				} else 	if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking Flag if it has Hot Spot Image
					buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
				} else if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
				} else if(CollectionUtils.isNotEmpty(inputBoxOption)) {
					textHandler.writeText(PropertiesRepository.getString("new-atitesting.learntab.tutorial.input.box.loc"), "10");
				} else {
					buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
				if (i == count) {  
					// Clicking continue button. 
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								if(!continueButtonElement.isEnabled()) {
									clickAssessmemtType();
								}
							}
							//driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
						}
					}
					
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					if(rationalFlag) {
						Thread.sleep(500);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
					//Thread.sleep(10000);
					// Clicking on Finalize and View Results Button.
					List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section");
					if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
						List<WebElement> element = baseHandler.findElements(".button.primary-button.focus-element-flag");
						if(CollectionUtils.isNotEmpty(element)) {
							int size = element.size();
							for(int intSize = 0; intSize < size; intSize++) {
								WebElement quizCompElement = element.get(intSize);
								if(quizCompElement.getText().equalsIgnoreCase(quizComplButtonName)) {
									quizCompElement.click();
									waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}
					// Forcefully complete assessment without answering flag question.;
					
					/*List<WebElement> assessmentContinueElement = baseHandler.findElements(".button.secondary-button.focus-element-flag");
					if(CollectionUtils.isNotEmpty(assessmentContinueElement)) {
						clickButton(".button.secondary-button.focus-element-flag", 0);
					}
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");*/
					
				} else {
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER); //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
									clickAssessmemtType();
								}
							}
							//driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
						}
				}
					
					if(rationalFlag) {
						Thread.sleep(5000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
					
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to take Assessment Test" );
			log(logger, "Unable to take Assessment Test" +e);
	    		throw new DriverException("Unable to take Assessment Test" , e); 
    	}
    	logger.info("Method: takeAssessmentTest End " );
	}
	
	/**
	 * Method used to take Assessment for Test Tab. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void takeTutorialAssessmentTest(boolean rationalFlag) throws Exception {
		//logger.info("Method : takeTutorialAssessmentTest :::::::: Starts");
		try {
			/*waitUntillLoadingImageIsDisappeared(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));*/
			switchHandlers();
			String[] questionNos = getQuestionNo();
			// Convert String to Integer
			int maxCount = Integer.parseInt(questionNos[1]);

			// Convert String to Integer
			int minCount = Integer.parseInt(questionNos[0]);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				
				List<WebElement> checkBoxElement = baseHandler
						.findElements(".question-option.focus-element-flag label");
				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
				List<WebElement> hotSpotElement = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.hot.spot.image"));				
				
				if (CollectionUtils.isNotEmpty(checkBoxElement)
						&& checkBoxElement.size() > 0) {
					checkBoxElement.get(0).click();
				}

				/*if (driver
						.findElement(
								By.cssSelector(".answer-fill-in-the-blank.numericTextEntry"))
						.isDisplayed()) {
					driver.findElement(
							By.cssSelector(".answer-fill-in-the-blank.numericTextEntry"))
							.sendKeys("10");
				}*/
				
				// Clicking Flag if it has Hot Spot Image, 
				if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) {
					buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
				}
				
				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
				}
				if (i == count) { // FOra 
					// Clicking continue button. 
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							buttonElement.get(0).click();	
						}
					}
					
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
					if(rationalFlag) {
						Thread.sleep(5000);
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					// Clicking on Finalize and View Results Button.
					clickButton(".button.primary-button.focus-element-flag", 1);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					
				} else {
					Thread.sleep(5000);
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							buttonElement.get(0).click();	
						}
					}
					
					if(rationalFlag) {
						Thread.sleep(5000);
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to take Assessment Test" );
			log(logger, "Unable to take Assessment Test" );
    		throw new DriverException("Unable to take Assessment Test" , e); 
    	}
    	logger.info("Method: takeTutorialAssessmentTest End " );
	}

	/**
	 * Method is used to verify Test Tab Value DD Value 
	 * 
	 * All
	 * Accessed
	 * Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTabValueDD() throws Exception {
		logger.info("Method: verifyTestTabValueDD Starts");
		boolean flag = false;
    	try {
    		List<String> valueDD = new ArrayList<String>();
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));
    		
    		List<String> uiValueDD = new ArrayList<String>();
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(0));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					uiValueDD.add(allOptions.get(index).getAttribute("value"));
    				}
    			}
    		}
    		if(valueDD.equals(uiValueDD)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify TestTab Value DD " );
    		throw new DriverException("Unable to verify TestTab Value DD " , e); 
    	}
    	logger.info("Method: verifyTestTabValueDD End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify Test Tab Sort DD Value 
	 * 
	 * Date Accessed
	 * Name
	 * Due Date
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTabSortDD() throws Exception {
		logger.info("Method: verifyTestTabSortDD Starts");
		boolean flag = false;
    	try {
    		List<String> sortDD = new ArrayList<String>();
    		sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
    		sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
    		sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.3.Sort"));
    		
    		List<String> uiSortDD = new ArrayList<String>();
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(2));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					uiSortDD.add(allOptions.get(index).getAttribute("value"));
    				}
    			}
    		}
    		if(sortDD.equals(uiSortDD)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify TestTab Sort DD " );
    		throw new DriverException("Unable to verify TestTab Sort DD " , e); 
    	}
    	logger.info("Method: verifyTestTabSortDD End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to Select any of the below value under Test Tab from SortDD Value 
	 * 
	 * Date Accessed
	 * Name
	 * Due Date
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromSortDDinTestTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromSortDDinTestTab Starts");
		boolean flag = false;
    	try {
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(2));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					if(ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
    						Select valueSelect = dropDownHandler.getDropDown(ddElement.get(2));
    						dropDownHandler.selectByVisibleText(valueSelect, ddValue);
    						flag = true;
    						break;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to select Value From SortDD in TestTab " );
    		throw new DriverException("Unable to select Value From SortDD in TestTab " , e); 
    	}
    	logger.info("Method: selectValueFromSortDDinTestTab End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to get list of value from Test Tab
	 * 
	 * Assessment Name
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> valueAsList(String locator) throws Exception {
		logger.info("Method: valueAsList Starts");
		List<String> list = null;
    	try {
    		list = new ArrayList<String>();
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++ ) {
    				list.add(element.get(index).getText());
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to value As List " );
    		throw new DriverException("Unable to value As List " , e); 
    	}
    	logger.info("Method: valueAsList End " );
    	return list;
	}
	
	/**
	 * Method is used to verify the List is in Ascending or in Descending 
	 * 
	 *  sortedFlag : true : call Ascending Order Method and verify List. 
	 *  sortedFlag : false : call Descending Order Method and verify List.
	 *  
	 * @param sortedFlag
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public boolean verifyListSortedOrNot(boolean sortedFlag, List<String> list) throws Exception {
		logger.info("Method: verifyListSortedOrNot Starts");
		boolean flag = false;
    	try {
    		if(sortedFlag) { // Ascending Order
    			flag = isListSortedInAscendingOrder(list);	
    		} else { // Descending Order
    			flag = isListSortedInDescendingOrder(list);
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify List Sorted Or Not");
    		throw new DriverException("Unable to verify List Sorted Or Not" , e); 
    	}
    	logger.info("Method: verifyListSortedOrNot End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to Select any of the below value under Test Tab from Value DD Value 
	 * 
	 * All
	 * Accessed
	 * Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromValueDDinTestTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromValueDDinTestTab Starts");
		boolean flag = false;
    	try {
    		
    		List<String> valueDD = new ArrayList<String>();
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(0));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					if(ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
    						Select valueSelect = dropDownHandler.getDropDown(ddElement.get(0));
    						dropDownHandler.selectByVisibleText(valueSelect, ddValue);
    						flag = true;
    						break;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to select Value From ValueDD in TestTab " );
    		throw new DriverException("Unable to select Value From ValueDD in TestTab " , e); 
    	}
    	logger.info("Method: selectValueFromValueDDinTestTab End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to get list of date value
	 * 
	 * Assessment Name
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Calendar> dateValueAsList(String locator) throws Exception {
		logger.info("Method: dateValueAsList Starts");
		List<Calendar> list = null;
		Calendar cal = null;
    	try {
    		list = new ArrayList<Calendar>();
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++ ) {
    				String dateValue = element.get(index).getText();
    				if(!"Never".equalsIgnoreCase(dateValue)) {
    				cal = Calendar.getInstance();
    				String[] currDate = element.get(index).getText().split("/");
    				if(currDate.length > 0) {
    					cal.set(Integer.parseInt(currDate[2]), Integer.parseInt(currDate[0]), Integer.parseInt(currDate[1]));
    					list.add(cal);
    				} } else {
    					continue;
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to date value As List " );
    		throw new DriverException("Unable to date value As List " , e); 
    	}
    	logger.info("Method: dateValueAsList End " );
    	return list;
	}
	
	/**
	 * Method is used to verify Test Tab Type DD Value 
	 * 
	 * All
	 * Practice
	 * Proctored
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTabTypeDD() throws Exception {
		logger.info("Method: verifyTestTabTypeDD Starts");
		boolean flag = false;
    	try {
    		List<String> typeDD = new ArrayList<String>();
    		typeDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.1.value"));
    		typeDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
    		typeDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value"));
    		
    		List<String> uiValueDD = new ArrayList<String>();
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(1));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					uiValueDD.add(allOptions.get(index).getAttribute("value"));
    				}
    			}
    		}
    		if(typeDD.equals(uiValueDD)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify TestTab Type DD " );
    		throw new DriverException("Unable to verify TestTab Type DD " , e); 
    	}
    	logger.info("Method: verifyTestTabTypeDD End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify Assessment type name in Test Tab. 
	 * 
	 * Practice/ Proctored. 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentTypeName() throws Exception {
		logger.info("Method: verifyAssessmentTypeName Starts");
		boolean flag = false;
    	try {
    		List<WebElement> titleElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.assessment.type.loc"));
    		if(CollectionUtils.isNotEmpty(titleElement)) {
    			int size = titleElement.size();
    			for(int index = 0; index < size; index ++) {
    				String assessmentTypeName = titleElement.get(index).getText();
    				if(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value").equalsIgnoreCase(assessmentTypeName)
    						||
    						PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.value").equalsIgnoreCase(assessmentTypeName)) {
    					flag = true;
    					if(!flag) {
    						flag = false;
    						break;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Assessment Type Name" );
    		throw new DriverException("Unable to verify Assessment Type Name" , e); 
    	}
    	logger.info("Method: verifyAssessmentTypeName End flag --> " + flag );
    	return flag;
	}
	
	/**
	 * Method is used to Select any of the below value under Test Tab from Value DD Value 
	 * 
	 * All
	 * Accessed
	 * Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromTypeDDinTestTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromTypeDDinTestTab Starts");
		boolean flag = false;
    	try {
    		
    		List<String> valueDD = new ArrayList<String>();
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.1.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value"));
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(1));
    			List<WebElement> allOptions = sel.getOptions();
    			if(CollectionUtils.isNotEmpty(allOptions)) {
    				int size = allOptions.size();
    				for(int index = 0; index < size; index ++) {
    					if(ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
    						Select valueSelect = dropDownHandler.getDropDown(ddElement.get(1));
    						dropDownHandler.selectByVisibleText(valueSelect, ddValue);
    						flag = true;
    						break;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to select Value From TypeDD in TestTab " );
    		throw new DriverException("Unable to select Value From TypeDD in TestTab " , e); 
    	}
    	logger.info("Method: selectValueFromTypeDDinTestTab End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify Assessment type name in Test Tab. 
	 * 
	 * Practice/ Proctored. 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentTypeName(String locator,
			String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentTypeName Starts assessmentName -->"
				+ assessmentName);
		boolean flag = false;
		try {
			List<WebElement> titleElement = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(titleElement)) {
				int size = titleElement.size();
				for (int index = 0; index < size; index++) {
					String assessmentTypeName = titleElement.get(index)
							.getText();
					if (assessmentName.equalsIgnoreCase(assessmentTypeName)) {
						flag = true;
						if (!flag) {
							flag = false;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Assessment Type Name");
			throw new DriverException(
					"Unable to verify Assessment Type Name assessmentName -->"
							+ assessmentName, e);
		}
		logger.info("Method: verifyAssessmentTypeName End assessmentName --> "
				+ assessmentName);
		return flag;
	}
	
	public boolean clickLinkFromList(String loc,int index) throws Exception
	{
		logger.info("clickLinkFromList Start");
		boolean viewStatus=false;
		WebElement webElement=null;
		
			try {
 				List<WebElement> activeAssessmentList = driver.findElements(By.cssSelector(loc));
				if(activeAssessmentList.size()>0)
				{
					 try {
						 webElement = activeAssessmentList.get(index);
						buttonHandler.clickButton(webElement);
						viewStatus=true;
					} catch (DriverException e) {
						throw new Exception("Unable to get active Assessment list", e);
					}
					 
				}
				else 
				{
					String textFromList = getTextFromLst("new-atitesting.homepage.myatitab.testtab.nodata.loc",0);
					if(PropertiesRepository.getString("new-atitesting.homepage.myatitab.testtab.nodata").equals(textFromList))
					viewStatus=false;
				}
			} catch (InterruptedException e) {
				throw new Exception("unable to clickLinkFromList", e);
			}
			logger.info("clickLinkFromList End");
		return viewStatus;
	}
	
	public  void clickInfoIconByNameTesttab(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> elements = baseHandler.findElements(".flipper section[class='card proctored-assessment front']");		
		
		if(elements.get(0).findElement(By.cssSelector("section div")).getText().equals(productName))
		{	
			elements.get(0).findElement(By.cssSelector("header a")).click();
			
		}
		
		logger.info("Method: clickInfoIconByName End");
		}
	
		
	public void clickInfoIconByNameLearntab(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> elements = baseHandler.findElements(".card.front.tutorial");
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).findElement(By.cssSelector("div div section div")).getText().equals(productName)) {
				elements.get(i).findElement(By.cssSelector("header a")).click();

			}
		}

		logger.info("Method: clickInfoIconByName End");
	}
	
	public void clickInfoIconByTesttab(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> elements = baseHandler.findElements(".card.practice-assessment.front");
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).findElement(By.cssSelector("div div section div")).getText().equals(productName)) {
				elements.get(i).findElement(By.cssSelector("header a")).click();

			}
		}

		logger.info("Method: clickInfoIconByName End");
	}
	
	
	/**
	 * Method is used to click on information icon of Assessment in Test Tab. 
	 * 
	 * Practice. 
	 * @author saravanan.jothimani
	 * @return 
	 * @throws Exception
	 */
	
	public void clickInfoIconByNameLearntab(String locator, String productName) throws Exception {
		logger.info("Method: clickInfoIconByNameLearntab Start");
		try {
			List<WebElement> elements = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(elements)) {
				for (int i = 0; i < elements.size(); i++) {
					List<WebElement> divElement = elements.get(i).findElements(By.cssSelector(" div div section div"));
					if (CollectionUtils.isNotEmpty(divElement)
							&& divElement.get(0).getText().equalsIgnoreCase(productName)) {
						{
							List<WebElement> headerElement = elements.get(i).findElements(By.cssSelector("header a"));
							if (CollectionUtils.isNotEmpty(headerElement)) {
								headerElement.get(0).click();
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click clickInfoIconByNameLearntab ");
			log(logger, "Unable to click clickInfoIconByNameLearntab ");
			throw new Exception("Unable to click on Assessment Info cion clickInfoIconByNameLearntab");
		}
		logger.info("Method: clickInfoIconByNameLearntab End");
	}
	
	public String getTextFromLst(String loc,int size) throws Exception 
	{
		logger.info("getTextFromList Start");
		String name = null;
		try {
		List<WebElement> listOfElements = driver.findElements(By.cssSelector(PropertiesRepository
				.getString(loc)));
		if(CollectionUtils.isNotEmpty(listOfElements) && listOfElements.size() > 0) {
			name = listOfElements.get(size).getText().trim();
		}
		} catch(Exception e) {
			throw new Exception ("Unable to getTextFromList", e);
		}
		logger.info("getTextFromList End");
		return name;
	}
	
	public boolean verifyBatchIdinProduct(String loc,int index) throws Exception {
		logger.info("verifyBatchIdinProduct Start");
		boolean status=false;
		try {
			String productId = getTextFromLst(loc, index);
			if(productId!=null && !productId.isEmpty())
			{
				String batchid=productId.split("-")[1];
				if(batchid!=null && !batchid.isEmpty())
				{
					status=true;
				}
			}
		} catch(Exception e) {
			throw new Exception ("Unable to verifyBatchIdinProduct", e);
		}
		homePage.pressEscapeKey();
		
		logger.info("verifyBatchIdinProduct End");
		return status;
		
	}
	
	/**
	 *Verify if enabled Practice and Proctor assessments are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfEnabledPracticeAndProctorDisplayed() throws Exception {
		logger.info("Method: VerifyIfEnabledPracticeAndProctorDisplayed Start");
		boolean flag = false;
		try {
			
			List<WebElement> moduleList = baseHandler.findElements("#testApplications li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				flag = true;
				}					
		} catch (Exception e) {
			logger.info("There are no enabled Practice and Proctor assessments");
			throw new Exception("There are no enabled Practice and Proctor assessments");
		}
		logger.info("Method: VerifyIfEnabledPracticeAndProctorDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if Speedometer is Displayed only on all Practice assessment.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfSMIsDisplayedOnlyOnPracticeAss() throws Exception {
		logger.info("Method: VerifyIfSMIsDisplayedOnlyOnPracticeAss Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements("#testApplications li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("#testApplications li section header span"));
					if ((element != null) && element.getText().equals("Practice Assessment")) {
						if ((moduleList.get(i)
								.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']"))
								.size() != 0)) {
							flag = true;
						} else {
							flag = false;
							break;
						}
					} else {
						if ((moduleList.get(i)
								.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']"))
								.size() == 0)) {
							flag = true;
						} else {
							flag = false;
							break;
						}

					}
				}

			}
		} catch (Exception e) {
			logger.info("Not all Practice assessment have Speedometer");
			throw new Exception("Not all Practice assessment have Speedometer");
		}
		logger.info("Method: VerifyIfSMIsDisplayedOnlyOnPracticeAss End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if Speedometer info table is present
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean VerifyifInfoTablePresent() throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {
			System.out.println("");
			List<WebElement> moduleList = baseHandler.findElements("#testApplications li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(2).findElement(By.cssSelector("section header span"));
					if(element != null &&  element.getText().equals("Practice Assessment")) {
						moduleList.get(2).findElement(By.cssSelector("section div footer a div[class='usage-overlay-50']")).click();						 
						if(moduleList.get(2).findElements(By.cssSelector("table tbody tr td")).size()!=0)
						{
							flag = "Answered Questions".equals(moduleList.get(2).findElement(By.cssSelector("section div[class='test-card-front-usage usage-container'] table tbody tr td")).getText());
						}							
						break;
					}
				}
			}
	}
	catch(Exception e)
	{
			logger.info("Speedometer info table is not present");
			throw new Exception(
					"Speedometer info table is not present");
		}logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> "+flag);return flag;
}

	public boolean VerifyIfSMIsNotDisplayedForProctorAss() throws Exception {
		logger.info("Method: VerifyIfSMIsNotDisplayedForProctorAss Start");
		boolean flag = true;
		try {

			List<WebElement> moduleList = baseHandler.findElements("#testApplications li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("#testApplications li section header span"));
					if ((element != null) && element.getText().equals("Proctored Assessment")) {
						if ((moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
							flag = false;
							break;
						}
					}
				}

			}
		} catch (Exception e) {
			logger.info("Speedometer is Displaying for Proctor Assessment");
			throw new Exception("Speedometer is Displaying for Proctor Assessment");
		}
		logger.info("Method: VerifyIfSMIsNotDisplayedForProctorAss End --> " + flag);
		return flag;
	}
	
	

	/**
	 * Verify the Speedometer info of Never accessed Assessments
	 * @author
	 * @param 
	 * @throws DriverException
	 */
	public boolean verifyNeverAccessedSpedoAsZero() throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = driver.findElements(
					By.cssSelector(".card.practice-assessment.front"));
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					List<WebElement> accessElement = moduleList.get(i)
							.findElements(By.cssSelector("div footer span[class='time-accessed']"));
					if(CollectionUtils.isNotEmpty(accessElement)) {
						String access = accessElement.get(0).getText();
						if (StringUtils.isNotEmpty(access) && access.contains("Never")) {
							List<WebElement> accessSpedo = moduleList.get(i)
									.findElements(By.cssSelector("div footer a div[class='usage-overlay-50']"));
							if (accessSpedo != null) {
								accessSpedo.get(0).click();
								List<WebElement> tableElement = moduleList.get(i).findElements(By.cssSelector("table tbody tr td"));
								if (CollectionUtils.isNotEmpty(tableElement)) {
									List<WebElement> answerElement = moduleList.get(i).findElements(By.cssSelector(
											"section div[class='test-card-front-usage usage-container'] table tbody tr td"));
									if (CollectionUtils.isNotEmpty(answerElement)) {
										String answer = answerElement.get(0).getText();
										if (StringUtils.isNotBlank(answer)
												&& answer.equalsIgnoreCase("Answered Questions")) {
											flag = true;
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Speedometer info table is not present");
			throw new Exception("Speedometer info table is not present");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}
	public boolean verifyAssessementResultCount(String count)
	{
		logger.info("Method: verifyAssessementResultCount Start");
		boolean flag = false;
		List<WebElement> assres = driver.findElements(
				By.cssSelector("#testApplications .flipper div div  .result-count-temp"));
		if(CollectionUtils.isNotEmpty(assres)) {
			for(int i=0;i<assres.size();i++)
			{
			String access = assres.get(i).getText();
			if(access.equals(count))
			{
				flag=true;
			}
		}
		
		}
		logger.info("Method: verifyAssessementResultCount End");
		return flag;
	}
	public boolean verifyAssessementResultCountInCardBack(String count) throws Exception
	{
		logger.info("Method: verifyAssessementResultCountInCardBack Start");
		boolean flag = false;
	
		try {
		String asmtname = driver.findElement(
				By.cssSelector("#productResultList>section>h1")).getText();
		
		  String[] arrOfStr = asmtname.split(" "); 
		  System.out.println(arrOfStr[7]); 
		  String strcnt=arrOfStr[7];
		  String r1=strcnt.replace('(',' ');
		  System.out.println(r1); 
		  String r2=r1.replace(')',' ');
		  System.out.println(r2); 
		  if(r2.equalsIgnoreCase(count))
		  {
			  flag = true;
		  }
		}catch (Exception e) {
			logger.info("unable to verifyAssessementResultCountInCardBack");
			throw new Exception("unable to verifyAssessementResultCountInCardBack");
		}
	
		logger.info("Method: verifyAssessementResultCountInCardBack End"+"---->"+flag);
		return flag;
	}

}
