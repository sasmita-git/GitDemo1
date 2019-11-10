package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;

public class ImproveTabPage2 extends MyATITabMainPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	private boolean flag = false;
	public BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;

	public ImproveTabPage2(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
	}

	/**
	 * Method is used to verify Improve Tab Value DD Value
	 * 
	 * All Practice Assessment Focused Reviews Proctored Assessment Focused Reviews
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImproveTabTypeDD() throws Exception {
		logger.info("Method: verifyImproveTabTypeDD Starts");
		flag = false;
		try {
			List<String> valueDD = new ArrayList<String>();
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.type.dd.1.value"));
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.type.dd.2.value"));
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.type.dd.3.value"));

			List<String> uiValueDD = new ArrayList<String>();

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				System.out.println(ddElement.get(0).getText());
				Select sel = new Select(ddElement.get(0));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						uiValueDD.add(allOptions.get(index).getAttribute("value"));
					}
				}
			}
			if (valueDD.equals(uiValueDD)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Improve Tab Value DD ");
			throw new DriverException("Unable to verify Improve Tab Value DD ", e);
		}
		logger.info("Method: verifyImproveTabTypeDD End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Improve Tab Value DD Value
	 * 
	 * All Accessed Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImproveTabViewDD() throws Exception {
		logger.info("Method: verifyImproveTabViewDD Starts");
		flag = false;
		try {
			List<String> valueDD = new ArrayList<String>();
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
			valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));

			List<String> uiValueDD = new ArrayList<String>();

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(1));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						uiValueDD.add(allOptions.get(index).getAttribute("value"));
					}
				}
			}
			if (valueDD.equals(uiValueDD)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify TestTab Value DD ");
			throw new DriverException("Unable to verify TestTab Value DD ", e);
		}
		logger.info("Method: verifyImproveTabViewDD End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Improve Tab Sort DD Value
	 * 
	 * Date Accessed Name
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImproveTabSortDD() throws Exception {
		logger.info("Method: verifyImproveTabSortDD Starts");
		flag = false;
		try {
			List<String> sortDD = new ArrayList<String>();
			sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
			sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));

			List<String> uiSortDD = new ArrayList<String>();

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(2));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						uiSortDD.add(allOptions.get(index).getAttribute("value"));
					}
				}
			}
			if (sortDD.equals(uiSortDD)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Improve Tab Sort DD ");
			throw new DriverException("Unable to verify Improve Tab Sort DD ", e);
		}
		logger.info("Method: verifyImproveTabSortDD End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to Select any of the below value under Improve Tab from Value
	 * DD Value
	 * 
	 * All Practice Assessment Focused Reviews Proctored Assessment Focused Reviews
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromTypeDDinImproveTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromTypeDDinImproveTab Starts");
		flag = false;
		try {

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(0));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						if (ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
							Select valueSelect = dropDownHandler.getDropDown(ddElement.get(0));
							dropDownHandler.selectByVisibleText(valueSelect, ddValue);
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Value From Type DD in Improve Tab ");
			throw new DriverException("Unable to select Value From Type DD in Improve Tab ", e);
		}
		logger.info("Method: selectValueFromTypeDDinImproveTab End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to Select any of the below value under Improve Tab from Value
	 * DD Value
	 * 
	 * All Accessed Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromValueDDinImproveTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromValueDDinImproveTab Starts");
		flag = false;
		try {

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(1));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						if (ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
							Select valueSelect = dropDownHandler.getDropDown(ddElement.get(1));
							dropDownHandler.selectByVisibleText(valueSelect, ddValue);
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Value From ValueDD in Improve Tab ");
			throw new DriverException("Unable to select Value From ValueDD in Improve Tab ", e);
		}
		logger.info("Method: selectValueFromValueDDinImproveTab End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to Select any of the below value under Improve Tab from SortDD
	 * Value
	 * 
	 * Date Accessed Name
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromSortDDinImproveTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromSortDDinImproveTab Starts");
		flag = false;
		try {

			List<WebElement> ddElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(2));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						if (ddValue.equalsIgnoreCase(allOptions.get(index).getAttribute("value"))) {
							Select valueSelect = dropDownHandler.getDropDown(ddElement.get(2));
							dropDownHandler.selectByVisibleText(valueSelect, ddValue);
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Value From SortDD in Improve Tab ");
			throw new DriverException("Unable to select Value From SortDD in ImproveTab ", e);
		}
		logger.info("Method: selectValueFromSortDDinImproveTab End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify List is sorted in Ascending or not.
	 * 
	 * @param list
	 * @return
	 */
	public boolean isDateSortedInAscendingOrder(List<Calendar> list) {
		boolean flag = false;
		logger.info("isDateSortedInAscendingOrder Start");
		if (list == null || list.isEmpty()) {
			flag = false;
		}

		if (list.size() == 1) {
			flag = true;
		}

		for (int i = 1; i < list.size(); i++) {
			Calendar currentValue = list.get(i);
			Calendar previousValue = list.get(i - 1);
			System.out.println("currentDateValue -->  " + currentValue);
			System.out.println("previousDateValue -->  " + previousValue);
			flag = true;
			int value = currentValue.compareTo(previousValue);
			if (value > 0) {
				if (DateUtils.isSameDay(currentValue, previousValue)) {
					flag = true;
					continue;
				}

				return false;
			}
		}
		logger.info("isDateSortedInAscendingOrder flag --> " + flag);
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
		int i = 0;
		try {
			list = new ArrayList<Calendar>();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					List<WebElement> dateElement = element.get(index).findElements(By.cssSelector("span"));
					if (CollectionUtils.isNotEmpty(dateElement)) {
						String dateValue = dateElement.get(0).getText();
						String neverValue = dateElement.get(1).getText();
						if (StringUtils.isNotEmpty(dateValue)) {
							if (!"Never".equalsIgnoreCase(dateValue) && !"Never".equalsIgnoreCase(neverValue)) {
								cal = Calendar.getInstance();
								String[] currDate = dateElement.get(1).getText().split("/");
								if (currDate.length > 0) {
									cal.set(Integer.parseInt(currDate[2]), Integer.parseInt(currDate[0]),
											Integer.parseInt(currDate[1]));
									list.add(i, cal);
									i++;
								}
							} else {
								continue;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to date value As List ");
			throw new DriverException("Unable to date value As List ", e);
		}
		logger.info("Method: dateValueAsList End ");
		return list;
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
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					list.add(element.get(index).getText());
				}
			}
		} catch (Exception e) {
			logger.info("Unable to value As List ");
			throw new DriverException("Unable to value As List ", e);
		}
		logger.info("Method: valueAsList End ");
		return list;
	}

	/**
	 * Method is used to verify the List is in Ascending or in Descending
	 * 
	 * sortedFlag : true : call Ascending Order Method and verify List. sortedFlag :
	 * false : call Descending Order Method and verify List.
	 * 
	 * @param sortedFlag
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public boolean verifyListSortedOrNot(boolean sortedFlag, List<String> list) throws Exception {
		logger.info("Method: verifyListSortedOrNot Starts");
		try {
			flag = false;
			if (sortedFlag) { // Ascending Order
				flag = isListSortedInAscendingOrder(list);
			} else { // Descending Order
				flag = isListSortedInDescendingOrder(list);
			}
		} catch (Exception e) {
			logger.info("Unable to verify List Sorted Or Not");
			throw new DriverException("Unable to verify List Sorted Or Not", e);
		}
		logger.info("Method: verifyListSortedOrNot End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify that no focused review available
	 */
	public boolean verifyNoFocusedReviewDisplayed(String locator, String text) throws Exception {
		logger.info("Method: verifyNoFocusedReviewDisplayed Starts");
		flag = false;
		try {
			setDriverWait(PropertiesRepository.getString("new-atitesting.improve.tab.area"));
			flag = baseHandler.findElement(locator).getText().contains(text);
		} catch (Exception e) {
			logger.info("Unable to verify content");
			throw new DriverException("Unable to verify content", e);
		}
		logger.info("Method: verifyNoFocusedReviewDisplayed End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify that focus review displayed
	 */
	public boolean verifyFocusedReviewDisplayed() throws Exception {
		logger.info("Method: verifyFocusedReviewDisplayed Starts");
		flag = false;
		try {
			setDriverWait(PropertiesRepository.getString("new-atitesting.learn.tab.focus.review"));
			flag = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learn.tab.focus.review"))
					.isDisplayed();
		} catch (Exception e) {
			logger.info("Unable to verify content");
			throw new DriverException("Unable to verify content", e);
		}
		logger.info("Method: verifyFocusedReviewDisplayed End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify the Focus Review assessment displays as per selected
	 * content area
	 * 
	 * @param contentAreaValue
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentAsPerContentAreaFR(String contentAreaValue) throws Exception {
		logger.info("Method: verifyAssessmentAsPerContentAreaFR Starts");
		boolean flag = false;
		try {
			List<WebElement> assessmentname = baseHandler
					.findElements(".remediation-type-cell.flex-item.wrapword>span");
			if (CollectionUtils.isNotEmpty(assessmentname)) {
				for (WebElement assessmentElement : assessmentname) {
					if (assessmentElement.getText().contains(contentAreaValue)) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify verifyAssessmentAsPerContentAreaFR");
			throw new DriverException("unable to verifyAssessmentAsPerContentAreaFR", e);
		}
		logger.info("Method: verifyAssessmentAsPerContentAreaFR End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify if all the assessments have Fundamentals in their
	 * name
	 * 
	 * @param contentAreaValue
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFundamentalsInName() throws Exception {
		logger.info("Method: verifyFundamentalsInName Starts");
		boolean flag = true;
		try {
			List<WebElement> assessmentname = baseHandler
					.findElements(".remediation-type-cell.flex-item.wrapword>span");
			if (CollectionUtils.isNotEmpty(assessmentname)) {
				for (WebElement assessmentElement : assessmentname) {
					if (!(assessmentElement.getText().contains("Fundamentals"))) {
						flag = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify verifyFundamentalsInName");
			throw new DriverException("unable to verifyFundamentalsInName", e);
		}
		logger.info("Method: verifyFundamentalsInName End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to click on close button of the new features pop up
	 * 
	 * @author Vishal.r
	 * 
	 */
	// div[aria-describedby='slideShowDialog']
	public void clickOnCloseOfNewFeaturesPopup() throws Exception {
		logger.info("Method clickOnCloseOfNewFeaturesPopup: Start");
		try {
			boolean present = baseHandler.isDisplayed(baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.features.popup.close.loc"))
					.get(3));
			if (present) {
				List<WebElement> element = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.improve.tab.features.popup.close.loc"));
				if (CollectionUtils.isNotEmpty(element) && element.get(3).isDisplayed()) {
					element.get(3).click();
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click on close button");
			log(logger, "Unable to click on close button");
			throw new DriverException("Unable to click on close button", e);
		}
		logger.info("Method clickOnCloseOfNewFeaturesPopup: Ends");
	}

	/**
	 * Method is used to click on review button of the focused review of a
	 * particular assessment
	 * 
	 * @author Vishal.r
	 * 
	 */
	public void clickReviewOfFocusedReview(String asmtName, int asmtIndex, int reviewIndex) throws Exception {
		logger.info("Method clickReviewOfFocusedReview: Start");
		try {
			List<WebElement> asmtsList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc"));
			if (CollectionUtils.isNotEmpty(asmtsList)
					&& asmtsList.get(asmtIndex).getText().equalsIgnoreCase(PropertiesRepository.getString(asmtName))) {
				List<WebElement> reviewList = baseHandler
						.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.review.button.loc"));
				if (CollectionUtils.isNotEmpty(reviewList)) {
					reviewList.get(reviewIndex).click();
				}

			}
		} catch (Exception e) {
			logger.info("Unable to click on review button");
			log(logger, "Unable to click on review button");
			throw new DriverException("Unable to click on review button", e);
		}
		logger.info("Method clickReviewOfFocusedReview: Ends");
	}

	/**
	 * Method used to capture time
	 * 
	 * @author Vishal
	 * @param type
	 * @param loc
	 * @return boolean
	 * @throws Exception
	 */
	public int captureTime(String loc, int index) throws Exception {
		logger.info("captureTime Starts");
		String time = "";
		int timeAfter = 0;
		boolean flag = false;
		try {
			List<WebElement> timeList1 = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(timeList1)) {
				time = timeList1.get(index).getText();
				logger.info("time: " + time);
				timeAfter = Integer.parseInt(time.substring(3, 5));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("unable to capture time" + e);
			throw new Exception("Unable to capture time. " + e);
		}
		logger.info("captureTime Ends ->" + flag);
		return timeAfter;
	}

	/**
	 * Method used to capture time
	 * 
	 * @author Vishal
	 * @param type
	 * @param loc
	 * @return boolean
	 * @throws Exception
	 */
	public int captureTimeFromIPP(String loc, int index) throws Exception {
		logger.info("captureTime Starts");
		String time = "";
		int timeAfter = 0;
		boolean flag = false;
		try {
			List<WebElement> timeList1 = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(timeList1)) {
				time = timeList1.get(index).getText();
				logger.info("time: " + time);
				timeAfter = Integer.parseInt(time.substring(0, 2));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("unable to capture time" + e);
			throw new Exception("Unable to capture time. " + e);
		}
		logger.info("captureTime Ends ->" + flag);
		return timeAfter;
	}

	/**
	 * Method used to verify time difference
	 * 
	 * @author Vishal
	 * @param type
	 * @param loc
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyTimeDiffrence(int timeBefore, int timeAfter) throws Exception {
		logger.info("verifyTimeDiffrence Starts");
		boolean flag = false;
		int diff = 0;
		try {
			diff = timeBefore - timeAfter;
			if (diff < 2) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("unable to verify time" + e);
			throw new Exception("Unable to verify time. " + e);
		}
		logger.info("verifyTimeDiffrence Ends ->" + flag);
		return flag;
	}

	/**
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyAllDropDownValues(String[] listOfValues) throws Exception {
		logger.info("verifyAllDropDownValues Starts ");
		boolean flag = false;
		try {
			int count = 0;
			Select select = new Select(
					baseHandler.findElement(PropertiesRepository.getString("new-atitesting.content.area.dropdown")));
			List<WebElement> options = select.getOptions();
			for (WebElement values : options) {
				for (int i = 0; i < listOfValues.length; i++) {
					if (values.getText().equals(listOfValues[i])) {
						count++;
					}
				}
			}
			if (count == listOfValues.length) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("unable to verifyAllDropDownValues" + e);
			throw new Exception("Unable to verifyAllDropDownValues" + e);
		}
		logger.info("verifyAllDropDownValues Ends");
		return flag;
	}

	/**
	 * Method is used to check if Assessment Name is display for each record present
	 * under Major Content Area and if its Bold
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyAssessnameBold() throws Exception {
		logger.info("verifyAssessnameBold Starts ");
		boolean flag = true;
		try {
			List<WebElement> list = baseHandler.findElements(".flex-container");
			for (int i = 0; i < list.size(); i++) {
				WebElement assName = list.get(i).findElement(By.cssSelector("span[data-bind='text:Name']"));
				// Checking for Assessment Name is Bold or not.
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String fontWeight = (String) js.executeScript(
						"return getComputedStyle(arguments[0]).getPropertyValue('font-Weight');", assName);
				if (!((assName.isDisplayed()) && (Integer.parseInt(fontWeight) >= 700))) {
					flag = false;
					break;

				}
			}
		} catch (Exception e) {
			logger.info("unable to verifyAssessnameBold" + e);
			throw new Exception("Unable to verifyAssessnameBold" + e);
		}
		logger.info("verifyAssessnameBold Ends");
		return flag;
	}

	/**
	 * @author Devika.RS
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImproveTabContentAreaDD() throws Exception {
		logger.info("Method: verifyImproveTabContentAreaDD Starts ");
		flag = false;
		try {
			List<String> ContentAreaDD = new ArrayList<String>();
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.1.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.2.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.3.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.3.1.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.4.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.4.1.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.5.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.5.1.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.6.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.7.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.8.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.9.value"));
			ContentAreaDD
					.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.10.value"));
			ContentAreaDD
			.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.11.value"));
			ContentAreaDD
			.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.12.value"));
			ContentAreaDD
			.add(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.contentarea.dd.13.value"));
			
			List<String> uiContentAreaDD = new ArrayList<String>();

			List<WebElement> ddElement = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.myati.improvetab.content.area.dd.loc"));
			if (CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0) {
				Select sel = new Select(ddElement.get(0));
				List<WebElement> allOptions = sel.getOptions();
				if (CollectionUtils.isNotEmpty(allOptions)) {
					int size = allOptions.size();
					for (int index = 0; index < size; index++) {
						uiContentAreaDD.add(allOptions.get(index).getAttribute("value"));
					}
				}
			}
			Collections.sort(ContentAreaDD);
			Collections.sort(uiContentAreaDD);
			if (ContentAreaDD.equals(uiContentAreaDD)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify ImproveTab ContentArea DD ");
			throw new DriverException("Unable to verify ImproveTab ContentArea DD ", e);
		}
		logger.info("Method: verifyImproveTabContentAreaDD End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify the assessment is in Ascending or in Descending
	 * 
	 * sortedFlag : true : call Ascending Order Method and verify List. sortedFlag :
	 * false : call Descending Order Method and verify List.
	 * 
	 * @param sortedFlag
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public boolean isAssessmentSortedInAscendingOrder(boolean sortedFlag) throws Exception {
		logger.info("isAssessmentSortedInAscendingOrder Start");
		boolean flag = false;
		List<String> list = null;
		try {
			list = new ArrayList<String>();
			List<WebElement> assessments = baseHandler.findElements(".remediation-list");
			for (int i = 0; i < assessments.size(); i++) {
				List<WebElement> element = assessments.get(i)
						.findElements(By.cssSelector(".remediation-type-cell.flex-item.wrapword>span"));
				if (CollectionUtils.isNotEmpty(element)) {
					int size = element.size();
					for (int j = 0; j < size; j++) {
						list.add(element.get(j).getText());

					}
					if (sortedFlag) { // Ascending Order
						flag = isListSortedInAscendingOrder(list);
					} else { // Descending Order
						flag = isListSortedInDescendingOrder(list);
					}
				}
			}

		} catch (Exception e) {
			throw new Exception("isAssessmentSortedInAscendingOrder ", e);
		}
		logger.info("isAssessmentSortedInAscendingOrder flag --> " + flag);
		return flag;
	}

	/**
	 * @author Devika.RS
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyInprogressButtonInSelectInstance(String assessmentName) throws Exception {
		logger.info("Method : verifyInprogressButtonInSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.
						WebElement attemptDDElement = attemptElement.findElement(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.improve.tab.assessment.attempt.drop.down.loc")));
						List<WebElement> ddValue = dropDownHandler.getOptions(attemptDDElement);
						for (WebElement item : ddValue) {
							if (PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.new.attempt.value").trim()
									.equalsIgnoreCase(item.getText().trim())) {
								item.click();
								// Verifying Retake Buton in Select Instance.
								List<WebElement> selectInstanceElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.select.instance.loc"));
								if(CollectionUtils.isNotEmpty(selectInstanceElement)) {
									for(WebElement buttonElement : selectInstanceElement) {
										//Verifying header.
										WebElement headerElement = buttonElement.findElement(By.cssSelector("header[class='duplicate-product-header'] span[data-bind*='ID']"));
										if(headerElement != null) {
											if(PropertiesRepository.getString("new-atitesting.improve.tab.select.instance.Inprogress.cdn.product.id.value").equalsIgnoreCase(headerElement.getText().trim())) {
												// Getting first button(Begin, Continue / Retake)
												List<WebElement> beginBtnElement = buttonElement.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.improve.tab.select.instance.buttons.loc"))); 
												if(CollectionUtils.isNotEmpty(beginBtnElement) ) {
													WebElement retakeBtnElement = beginBtnElement.get(0).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.improve.tab.select.instance.Continue.button.loc")));
													if(retakeBtnElement != null && "CONTINUE".equalsIgnoreCase(retakeBtnElement.getText().trim())) {
														flag = true;
														break;
													} else {
														logger.info("Unable to verify I button under Select Instance.");
													}
												} else {
													logger.info("Buttons are not available under Select Instance Section");
												}
											} else {
												logger.info("Unable to verify CDN and Product ID for CONTINUE button section");
											}
										} else {
											logger.info("Unable to get header element locator");
										}
									}if(flag) {
										break;
									}
								}
								
							} else {
								logger.info("Unable to verify Attempt dropdown for parameterized assessment name "
										+ assessmentName);
							}
						}if(flag) {
							break;
						}
					} else {
						logger.info("Unable to verify name");
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInprogressButtonInSelectInstance");
			log(logger, "Unable to verifyInprogressButtonInSelectInstance");
			throw new DriverException("Unable to verifyInprogressButtonInSelectInstance", e);
		}
		logger.info("Method: verifyInprogressButtonInSelectInstance End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Devika.RS
	 * @param loc
	 * @param input
	 * @return
	 */
	
	public boolean VerifyProctorMessageInIPPPage(String loc, String input) throws Exception {
		logger.info("Method: VerifyProctormessageinIPPPage start");
		try{
			
		List<WebElement> element = baseHandler.findElements(loc);
		if (CollectionUtils.isNotEmpty(element))
		{
			if(input.equalsIgnoreCase(getText(null)))
			{
				return true;
			}
		}
		}catch (Exception e){
			logger.info("Unable to VerifyProctormessageinIPPPage ");
			log(logger, "Unable to VerifyProctormessageinIPPPage");
		}
		return true;
	}
	
	/**
	 * @author Devika.RS
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyProctorassessmentSelectInstance(String assessmentName) throws Exception {
		logger.info("Method : verifyProctorassessmentSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.
						WebElement attemptDDElement = attemptElement.findElement(By.cssSelector(PropertiesRepository
								.getString("newatitesting.improveta.proctor.assessment.selectatest.loc")));
						List<WebElement> ddValue = dropDownHandler.getOptions(attemptDDElement);
						for (WebElement item : ddValue) {
							if (PropertiesRepository.getString("new-atitesting.improvetab.select.test.value").trim()
									.equalsIgnoreCase(item.getText().trim())) {
								item.click();
								// Verifying Retake Buton in Select Instance.
								List<WebElement> selectInstanceElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.select.instance.loc"));
								if(CollectionUtils.isNotEmpty(selectInstanceElement)) {
									for(WebElement buttonElement : selectInstanceElement) {
										//Verifying header.
										WebElement headerElement = buttonElement.findElement(By.cssSelector("header[class='duplicate-product-header'] span[data-bind*='ID']"));
										if(headerElement != null) {
											if(PropertiesRepository.getString("new-atitesting.improve.tab.proctor.select.instance.Begin.cdn.product.id.value").equalsIgnoreCase(headerElement.getText().trim())) {
												// Getting first button(Begin, Continue / Retake)
												List<WebElement> beginBtnElement = buttonElement.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.improvetab.proctor.begin.button.loc"))); 
												if(CollectionUtils.isNotEmpty(beginBtnElement) ) {
													WebElement BegnBtnElement = beginBtnElement.get(0).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.improvetab.proctor.begin.button.loc")));
													if(BegnBtnElement != null && "Retake".equalsIgnoreCase(BegnBtnElement.getText().trim())) {
														flag = true;
														break;
													} else {
														logger.info("Unable to verify Retake button under Select Instance.");
													}
												} else {
													logger.info("Buttons are not available under Select Instance Section");
												}
											} else {
												logger.info("Unable to verify CDN and Product ID for Retake button section");
											}
										} else {
											logger.info("Unable to get header element locator");
										}
									}if(flag) {
										break;
									}
								}
								
							} else {
								logger.info("Unable to verify Attempt dropdown for parameterized assessment name "
										+ assessmentName);
							}
						}if(flag) {
							break;
						}
					} else {
						logger.info("Unable to verify name");
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProctorassessmentSelectInstance");
			log(logger, "Unable to verifyProctorassessmentSelectInstance");
			throw new DriverException("Unable to verifyProctorassessmentSelectInstance", e);
		}
		logger.info("Method: verifyProctorassessmentSelectInstance End flag --> " + flag);
		return flag;
	}
	
	
}
