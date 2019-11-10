package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.sun.java.swing.plaf.windows.resources.windows;

public class ApplyTabPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	private boolean flag = false;
	public BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	private ArrayList<String> listOfSimulationsWithSpeedometer = new ArrayList<String>();
	private Map<String, String> simulationsWithSpeedometerWithValues = new HashMap<String , String>();
	private WindowHandler windowHandler;
	
	public ApplyTabPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method is used to verify Apply Tab Value DD Value 
	 * 
	 * All
	 * Accessed
	 * Not Accessed
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyApplyTabValueDD() throws Exception {
		logger.info("Method: verifyApplyTabValueDD Starts");
		flag = false;
    	try {
    		List<String> valueDD = new ArrayList<String>();
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
    		valueDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));
    		
    		List<String> uiValueDD = new ArrayList<String>();
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.applytab.dd.loc"));
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
    	logger.info("Method: verifyApplyTabValueDD End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify Apply Tab Sort DD Value 
	 * 
	 * Date Accessed
	 * Name
	 * Due Date
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyApplyTabSortDD() throws Exception {
		logger.info("Method: verifyTestTabSortDD Starts");
		flag = false;
    	try {
    		List<String> sortDD = new ArrayList<String>();
    		sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
    		sortDD.add(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
    		
    		List<String> uiSortDD = new ArrayList<String>();
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.applytab.dd.loc"));
    		if(CollectionUtils.isNotEmpty(ddElement) && ddElement.size() > 0 ) {
    			Select sel = new Select(ddElement.get(1));
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
	public boolean selectValueFromValueDDinApplyTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromValueDDinApplyTab Starts");
		flag = false;
    	try {
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.applytab.dd.loc"));
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
    		logger.info("Unable to select Value From ValueDD in ApplyTab " );
    		throw new DriverException("Unable to select Value From ValueDD in ApplyTab " , e); 
    	}
    	logger.info("Method: selectValueFromValueDDinApplyTab End flag --> " + flag);
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
	public boolean selectValueFromSortDDinApplyTab(String ddValue) throws Exception {
		logger.info("Method: selectValueFromSortDDinApplyTab Starts");
		boolean flag = false;
    	try {
    		
    		List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.applytab.dd.loc"));
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
    		logger.info("Unable to select Value From SortDD in ApplyTab " );
    		throw new DriverException("Unable to select Value From SortDD in ApplyTab " , e); 
    	}
    	logger.info("Method: selectValueFromSortDDinApplyTab End flag --> " + flag);
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
	
	public void clickInfoIconByName(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository
						.getString("new-atitesting.applytab.all.modules.loc"));
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList
						.get(i)
						.findElement(
								By.cssSelector(PropertiesRepository
										.getString("new-atitesting.applytab.specific.modules.name.loc")));
				WebElement element1 = moduleList.get(i);
				if (productName.equalsIgnoreCase(element.getText())) {
					element1.findElement(
							By.cssSelector(PropertiesRepository
									.getString("new-atitesting.applytab.specific.modules.info.icon.loc"))).click();
					Thread.sleep(10000);
					break;
				}
			}
		}
		logger.info("Method: clickInfoIconByName End");
	}	
	
	/**
	 *Verify if enabled Simulations are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfEnabledSimulationDisplayed() throws Exception {
		logger.info("Method: VerifyIfEnabledSimulationsDisplayed Start");
		boolean flag = false;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,120);
			wait.until(new ExpectedCondition<Boolean>() {
			    public Boolean apply(WebDriver driver) {
			        WebElement button = driver.findElement(By.cssSelector("div[data-bind='visible: IsTab4Loading']"));
			        String enabled = button.getAttribute("style");
					if (enabled.equals("display: none;")) {
						logger.info("Products load complete.");
						return true;
					} else {
						logger.info("Products are still loading......");
						return false;
					}
			    }
			});
			
			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				flag = true;
				}					
		} catch (Exception e) {
			logger.info("There are no enabled simulation's");
			throw new Exception("There are no enabled simulation's");
		}
		logger.info("Method: VerifyIfEnabledSimulationDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Method initialize's the Arraylist with list of Simulations with Speedometer.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void addArrayListwithSimulationsWithSpedometer()
			throws Exception {
		logger.info("Method: AddArrayListwithSimulationsWithSpedometer Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					if((moduleList.get(i).findElement(By.cssSelector("header span")).getText().equals("Simulation")) &&(element != null) && (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size()!=0) ) {
						listOfSimulationsWithSpeedometer.add(element.getText());	
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("List not initalized");
			throw new Exception(
					"List not initalized");
		}
		logger.info("Method: AddArrayListwithSimulationsWithSpedometer End --> " + flag);
		
	}
	
	/**
	 *Comparing actual and expected array lists of Simulations
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifySVandFVSimulationsListAreEqual() throws Exception {
		logger.info("Method: VerifySVandFVSimulationsListAreEqual Start");
		boolean flag = false;
		try {
			System.out.println("xc");
			ArrayList<String> actualSimulationsList = new ArrayList<String>();
			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("se.std.appli.tab.list.loc"));
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					actualSimulationsList.add(moduleList.get(i).getText());
					}
				}
			flag = listOfSimulationsWithSpeedometer.containsAll(actualSimulationsList) && actualSimulationsList.containsAll(listOfSimulationsWithSpeedometer) ;
					
		} catch (Exception e) {
			logger.info("Simulations List for SV and FV are not Equal");
			throw new Exception("Simulations List for SV and FV are not Equal");
		}
		logger.info("Method: VerifySVandFVSimulationsListAreEqual End --> " + flag);
		return flag;
	}
	
	/**
	 *Verify if Speedometer is Displayed on all active Simulations.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfSpeedometerIsDisplayedOnAllSimulations() throws Exception {
		logger.info("Method: VerifyIfSpeedometerIsDisplayedOnAllSimulations Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size-1; i++) {
					WebElement element = moduleList.get(2).findElement(By.cssSelector("section div[class='description']"));
					if ((element != null) && (moduleList.get(2).findElement(By.cssSelector("header span")).getText().equals("Simulation"))) {
						if ((moduleList.get(2).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
							flag = true;
						}
						else{
							flag = false;						
							break;
						}
					}
				}

			}
		} catch (Exception e) {
			logger.info("Not all enabled Simulations have Speedometer");
			throw new Exception("Not all enabled Simulations have Speedometer");
		}
		logger.info("Method: VerifyIfSpeedometerIsDisplayedOnAllSimulations End --> " + flag);
		return flag;
	}
	
	/**
	 *Verify if Speedometer is not Displayed on all  Video Case Study.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfSMIsNotDisplayedOnVideoCS() throws Exception {
		logger.info("Method: VerifyIfSMIsNotDisplayedOnVideoCS Start");
		boolean flag = true;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size-1; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					if ((element != null) && (moduleList.get(i).findElement(By.cssSelector("header span")).getText().equals("Video Case Study"))) {
						if ((moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
							flag = false;
							break;
						}						
					}
				}
			}
		} catch (Exception e) {
			logger.info("Video Case Study have Speedometer Displayed on it");
			throw new Exception("Video Case Study have Speedometer Displayed on it");
		}
		logger.info("Method: VerifyIfSMIsNotDisplayedOnVideoCS End --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method initialize's the Map with list of Simulations with Speedometer and Its values.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void addSimulationsWithSpedometerAndvaluesInMap()
			throws Exception {
		logger.info("Method: AddSimulationsWithSpedometerAndvaluesInMap Start");
		boolean flag = false;
		try {
			
			List<WebElement> moduleList = baseHandler
					.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					if((moduleList.get(i).findElement(By.cssSelector("header span")).getText().equals("Simulation")) && (element != null) && (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size()!=0) ) {
						simulationsWithSpeedometerWithValues.put(element.getText(),moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50'] div span")).getText());
						//simulationsWithSpeedometerWithValues.put(element.getText(),moduleList.get(i).findElement(By.cssSelector("#simUsagePercentDisplay50")).getText());
						flag=true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Map not initialized");
			throw new Exception(
					"Map not initalized");
		}
		logger.info("Method: AddSimulationsWithSpedometerAndvaluesInMap End --> " + flag);
		
	}
	
	/**
	 *Comparing actual and expected HashMap for Simulations and its Speedometer Values
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifySVandFVSimulationsListAndItsValueAreEqual() throws Exception {
		logger.info("Method: VerifySVandFVSimulationsListAndItsValueAreEqual Start");
		boolean flag = false;
		try {
			Map<String , String> actualSimulationsListAndValues = new HashMap<String , String>();
			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("se.std.appli.tab.list.loc"));
			List<WebElement> moduleListValues = baseHandler.findElements(PropertiesRepository.getString("se.std.apply.list.speedometer.value.loc"));
			if (CollectionUtils.isNotEmpty(moduleList) && CollectionUtils.isNotEmpty(moduleListValues)  && (moduleList.size()== moduleListValues.size()) ){
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					actualSimulationsListAndValues.put(moduleList.get(i).getText(), moduleListValues.get(i).getText());
					}
				}
			if(actualSimulationsListAndValues.size() == simulationsWithSpeedometerWithValues.size())
			{
			Map<String, String> actualSimulationsListAndValuesSorted = new TreeMap<>(actualSimulationsListAndValues);
			Map<String, String> simulationsWithSpeedometerWithValuesSorted = new TreeMap<>(simulationsWithSpeedometerWithValues);
			flag = simulationsWithSpeedometerWithValuesSorted.equals(actualSimulationsListAndValuesSorted);
			}
					
		} catch (Exception e) {
			logger.info("Simulations List and its Speedometer Value for SV and FV are not Equal");
			throw new Exception("Simulations List and Its Speedometer value for SV and FV are not Equal");
		}
		logger.info("Method: VerifySVandFVSimulationsListAndItsValueAreEqual End --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used check if Never accessed Simulations have Speedometer value as 0%
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyNeverAccessedSpedoAsZero()
			throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("footer span span"));
					WebElement elementToFind = moduleList.get(i);
					if(element != null ) {
						//If Tutorial is never accesses and is Speedometer is present
						if (("Never".equalsIgnoreCase(element.getText())) && (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size()!=0)) {
							if(elementToFind != null) {								
								flag= "0%".equals(moduleList.get(i).findElement(By.cssSelector("footer a div div div span")).getText());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Never accessed Simulations does not have speedometer value as 0%");
			throw new Exception(
					"Never accessed Simulations does not have speedometer value as 0%");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}
	
	
	/**
	 * Verify if Speedometer info table is present
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean VerifyifInfoTablePresent() throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if(moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50")).size()>0 ) {
						moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50']")).click();						 
						if(moduleList.get(i).findElements(By.cssSelector("table tbody tr td")).size()!=0)
						{
							flag = "Total Modules".equals(moduleList.get(i).findElement(By.cssSelector("table tbody tr td")).getText());
						}							
						break;
					}
				}
			}
	}
	catch(Exception e)
	{
			logger.info("Speedometer info table is not presen");
			throw new Exception("Speedometer info table is not presen");
	}logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> "+flag);return flag;
}	
	
	/**
	 * Verify if the Recent score value on card front information match with
	 * Results tab
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean VerifyifRecentScoreEqualsResultTab(String[] arraySimulationNameAndScore) throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {
			String score = null;
			if (arraySimulationNameAndScore[1].equals("Needs Improvement")) {
				score = "N.I.";
			} else if (arraySimulationNameAndScore[1].equals("Satisfactory")) {
				score = "Sat";
			} else if (arraySimulationNameAndScore[1].equals("Strong")) {
				score = "Str";
			}
			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (element != null && element.getText().equals(arraySimulationNameAndScore[0])) {
						moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50']"))
								.click();
						List<WebElement> moduleListNext = moduleList.get(i)
								.findElements(By.cssSelector("table tbody tr "));
						List<WebElement> moduleListNextagain = moduleListNext.get(2)
								.findElements(By.cssSelector("td "));
						if ((moduleListNextagain.get(1).findElement(By.cssSelector("td a span")).getText())
								.equals(score)) {
							flag = true;
							break;
						}

					}
				}
			}
		} catch (Exception e) {
			logger.info("Recent score value on card front information does not match with Results tab");
			throw new Exception("Recent score value on card front information does not match with Results tab");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used click Never accessed Tutorials with speedometer
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */

	public void clickModuleButtonNeverAccessed() throws Exception {
		logger.info("Method: clickModuleButtonNeverAccessed Start");
		List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card simulation front']");
		if (CollectionUtils.isNotEmpty(moduleList)) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList.get(i).findElement(By.cssSelector("footer span span"));
				if (element != null) {
					// If Tutorial is never accesses and is Speedometer is present
					if (("Never".equalsIgnoreCase(element.getText())) && (moduleList.get(i)
							.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
						{
							moduleList.get(i).findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: !Simulation.HasMultipleLearningLoopItems()'] a[class='button cardflip primary-button button-focus focus-element-flag']")).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			}
		}
	}	
	
	/**
	 * Click on Module Button which is having Speedometer
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public void clickOnModuleWithSpeedometer() throws Exception {
		logger.info("Method: clickOnModuleWithSpeedometer Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card simulation front']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50")).size()>0) {
						moduleList.get(i).findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: !Simulation.HasMultipleLearningLoopItems()'] a[class='button cardflip primary-button button-focus focus-element-flag']")).click();						
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						baseHandler.waitForPageToLoad(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to Click on Module with Speedometer");
			throw new Exception("Not able to Click on Module with Speedometer");
		}
		logger.info("Method: clickOnModuleWithSpeedometer End --> ");
		
	}
	
	/**
	 * Click on Speedometer by Module name and get last Attempt value form the card back SM info table
	 * 
	 * 
	 * @author syed.pasha
	 * 
	 * @throws DriverException
	 */
	public String clickOnSMByModuelName(String moduleName) throws Exception {
		logger.info("Method: clickOnSMByModuelName Start");
		String lastAttemptValue = null;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".product-list-style>li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("header span[class='product-result-take']"));
						if (element != null && element.getText().equals(moduleName)) {
						moduleList.get(i).findElement(By.cssSelector("header a div[class='usage-overlay-60-back']")).click();						
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> tableValues = moduleList.get(i).findElements(By.cssSelector("section [class='usage-back-table'] table tbody tr td"));
						lastAttemptValue = tableValues.get(3).getText();						
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to Click on Speedometer");
			throw new Exception("Not able to Click on Speedometer");
		}
		logger.info("Method: clickOnSMByModuelName End --> ");
		return  lastAttemptValue ;		
	}
	
	/**
	 * Get last Attempt value form the card back SM info table
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public String getLastAttemptvalueByModulename(String moduleName) throws Exception {
		logger.info("Method: getLastAttemptvalueByModulename Start");
		String lastAttemptValueRT = null;
		try {
			System.out.println("er");
			List<WebElement> moduleList = baseHandler.findElements(".multi-tables>div tbody");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("tr td a"));
						if (element != null && element.getText().equals(moduleName)) {
						List<WebElement> tableValues = moduleList.get(i).findElements(By.cssSelector("tr td"));
						lastAttemptValueRT = tableValues.get(3).getText();						
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to get Last attempt Value");
			throw new Exception("Not able to get Last attempt Value");
		}
		logger.info("Method: getLastAttemptvalueByModulename End --> ");
		return  lastAttemptValueRT ;		
	}
	
	/**
	 * Verify Last Attempt value , Individual Score and Time Spent for a given Product is displayed
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean verify_LAV_IV_TS(String moduleName) throws Exception {
		logger.info("Method: verify_LAV_IV_TS Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".multi-tables table tbody td a[aria-label='Learning Unit Type Name']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					
						if (moduleList != null && moduleList.get(i).getText().equals(moduleName)) {
						List<WebElement> tableValues =baseHandler.findElements(".multi-tables table tbody tr  td");
						if(tableValues.get(1).isDisplayed() && tableValues.get(2).isDisplayed() && tableValues.get(3).isDisplayed())
						{
							flag = true;
							break;
						}
											
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to verify_LAV_IV_TS");
			throw new Exception("Not able to verify_LAV_IV_TS");
		}
		logger.info("Method: verify_LAV_IV_TS End --> ");
		return  flag;		
	}
	
	/**
	 * Click on by Module Button name 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean clickOnModuelButtonByName(String moduleName) throws Exception {
		logger.info("Method: clickOnModuelButtonByName Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card simulation front']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement name = moduleList.get(i).findElement(By.cssSelector("div section div[class='description']"));
					if( name != null && name.getText().equals(moduleName)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moduleList.get(i).findElement(By.cssSelector("nav div a")));
						moduleList.get(i).findElement(By.cssSelector("nav div a")).click();
						baseHandler.waitForPageToLoad(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to click on module button");
			throw new Exception("Not able to click on module button");
		}
		logger.info("Method: clickOnModuelButtonByName End flag --> " + flag);
		return flag;
	}
	/**
	 * Click on Module Button which is having Speedometer
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public void clickOnModuleWithSpeedometer(int index) throws Exception {
		logger.info("Method: clickOnModuleWithSpeedometer Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card simulation front']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(index)
							.findElement(By.cssSelector("footer a div div[class='usage-overlay-50"));
					if (element != null) {
						moduleList.get(index).findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: !Simulation.HasMultipleLearningLoopItems()'] a[class='button cardflip primary-button button-focus focus-element-flag']")).click();						
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						baseHandler.waitForPageToLoad(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to Click on Module with Speedometer");
			throw new Exception("Not able to Click on Module with Speedometer");
		}
		logger.info("Method: clickOnModuleWithSpeedometer End --> ");
		
	}
	
	/**
	 * Verify if Speedometer info table is present
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean VerifyifInfoTablePresent(int index) throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(index)
							.findElement(By.cssSelector("footer a div div[class='usage-overlay-50"));
					if (element != null) {
						moduleList.get(index).findElement(By.cssSelector("footer a div div[class='usage-overlay-50']"))
								.click();
						if (moduleList.get(index).findElements(By.cssSelector("table tbody tr td")).size() != 0) {
							flag = "Total Modules".equals(
									moduleList.get(index).findElement(By.cssSelector("table tbody tr td")).getText());
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Speedometer info table is not presen");
			throw new Exception("Speedometer info table is not presen");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to compare assessment name. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifySimulationName(String simulationName) throws Exception {
		logger.info("Method : veifySimulationName Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#tabs-4 .card.simulation.front div[class='learn-card-front-wrapper default-container'] section div");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					String name = nameElement.getText();
					if(StringUtils.isNotEmpty(name) && name.equalsIgnoreCase(simulationName)) {
						flag = true; 
						break;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifySimulationName" );
			log(logger, "Unable to veifySimulationName" );
    		throw new DriverException("Unable to veifySimulationName" , e); 
    	}
		logger.info("Method: veifySimulationName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Simulation is present or not. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifySimulationHeader(String simulationName) throws Exception {
		logger.info("Method : veifySimulationHeader Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#tabs-4 .card.simulation.front");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container'] section div"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						// Verifying Simulation
						WebElement simulationText = nameElement.findElement(By.cssSelector("header span"));
						if(simulationText != null && simulationText.getText().equalsIgnoreCase("Simulation")) {
							flag = true; break;
						}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifySimulationHeader" );
			log(logger, "Unable to veifySimulationHeader" );
    		throw new DriverException("Unable to veifySimulationHeader" , e); 
    	}
		logger.info("Method: veifySimulationHeader End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Simulation module count. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifySimulationMoudleCount(String simulationName, String count) throws Exception {
		logger.info("Method : veifySimulationMoudleCount Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#tabs-4 .card.simulation.front");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container'] section div"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						// Getting Moudules count
						WebElement nameModulesElement = nameElement.findElement(By.cssSelector(".result-count-temp"));
						if(nameModulesElement != null ) {
							String mouduleCount = nameModulesElement.getText();
							if(StringUtils.isNotEmpty(mouduleCount) && mouduleCount.equalsIgnoreCase(count)) {
								flag = true;
							}
						} 
					} 
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifySimulationMoudleCount" );
			log(logger, "Unable to veifySimulationMoudleCount" );
    		throw new DriverException("Unable to veifySimulationMoudleCount" , e); 
    	}
		logger.info("Method: veifySimulationMoudleCount End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Simulation module count. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifySimulationMoudleCountContentArea(String simulationName) throws Exception {
		logger.info("Method : veifySimulationMoudleCountContentArea Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#tabs-4 .card.simulation.front");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container'] section div"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						// Getting Moudules count
						WebElement nameModulesElement = nameElement.findElement(By.cssSelector(".result-count-temp"));
						if(nameModulesElement != null ) {
							String mouduleCount = nameModulesElement.getText();
							if(StringUtils.isNotEmpty(mouduleCount) && ((Integer.parseInt(mouduleCount) > 0) || (Integer.parseInt(mouduleCount) < 15))) {
								flag = true;
							}
						} 
					} 
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifySimulationMoudleCountContentArea" );
			log(logger, "Unable to veifySimulationMoudleCountContentArea" );
    		throw new DriverException("Unable to veifySimulationMoudleCountContentArea" , e); 
    	}
		logger.info("Method: veifySimulationMoudleCountContentArea End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Simulation Accessed value. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifySimulationMoudleAccess(String simulationName) throws Exception {
		logger.info("Method : veifySimulationMoudleAccess Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#tabs-4 .card.simulation.front");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector("div[class='learn-card-front-wrapper default-container'] section div"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						// Getting Moudules count
						WebElement nameModulesElement = nameElement.findElement(By.cssSelector(".time-accessed span[data-bind='text: LastAccessed']"));
						if(nameModulesElement != null ) {
							String mouduleCount = nameModulesElement.getText();
							if(StringUtils.isNotEmpty(mouduleCount) && mouduleCount.contains("Never")) {
								flag = true;
							}
						} 
					} 
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifySimulationMoudleAccess" );
			log(logger, "Unable to veifySimulationMoudleAccess" );
    		throw new DriverException("Unable to veifySimulationMoudleAccess" , e); 
    	}
		logger.info("Method: veifySimulationMoudleAccess End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verify  Modules  by Name is present
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public boolean verfifyModuleIsDisplayedByName(String productName) throws Exception {
		logger.info("Method: verfifyModuleIsDisplayedByName Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verfifyModuleIsDisplayedByName");
			throw new Exception("Unable to verfifyModuleIsDisplayedByName");
		}
		logger.info("Method: verfifyModuleIsDisplayedByName End ");
		return flag;
	}
	
	public String getModuleCount(String assessmentName) throws Exception {
		// logger.info("Method : getModuleCount Start");
		String result = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement allElement : element) {
					String name = allElement.findElement(By.cssSelector(".description")).getText().trim();
					if (StringUtils.isNotBlank(name) && name.equalsIgnoreCase(assessmentName)) {
						result = allElement.findElement(By.cssSelector(".actions div a div[data-bind^='text: ModuleCount']")).getText().trim();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to getModuleCount");
			log(logger, "Unable to getModuleCount");
			throw new DriverException("Unable to getModuleCount", e);
		}
		logger.info("Method: getModuleCount End result --> " + result);
		return result;
	}
	
	/**
	 * This method used to Verify Card back Module name
	 * 
	 * @author Syed.pasha
	 * @throws DriverException 
	 * 
	 */
	public boolean verifyCardBackModulelName(String cardBackModuleName) throws DriverException {
		logger.info("Method: verifyCardBackModulelName Starts ");
		boolean flag = false;
		try {
			List<WebElement> titles = baseHandler.findElements(".product-list-style>li");
			for (int i = 0; i < titles.size(); i++) {
				if (titles.get(i).findElement(By.cssSelector(".product-result-take")).getText().replaceAll("\n", " ").equals(cardBackModuleName)) {
					flag = true;
					break;
				}
			}			
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackModulelName");
			log(logger, "Unable to verifyCardBackModulelName");
			throw new DriverException("Unable to verifyCardBackModulelName", e);
		}		
		logger.info("Method: verifyCardBackModulelName Ends");
		return flag;
	}
	
	/**
	 * This method used to Verify Card back Module name
	 * 
	 * @author Syed.pasha
	 * @throws DriverException 
	 * 
	 */
	public boolean verifyCardBackModulelNameWithSMValue(String cardBackModuleName, String smValueExp) throws DriverException {
		logger.info("Method: verifyCardBackModulelNameWithSMValue Starts ");
		boolean flag = false;
		try {
			List<WebElement> titles = baseHandler.findElements(".product-list-style>li ");
			for (int i = 0; i < titles.size(); i++) {
				String smValueActual = titles.get(i).findElement(By.cssSelector("#simModuleUsagePercent")).getText();
				if (titles.get(i).findElement(By.cssSelector(".product-result-take")).getText().replaceAll("\n", " ").equals(cardBackModuleName) && smValueActual.contains(smValueExp)) {
					flag = true;
					break;
				}
			}			
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackModulelNameWithSMValue");
			log(logger, "Unable to verifyCardBackModulelNameWithSMValue");
			throw new DriverException("Unable to verifyCardBackModulelNameWithSMValue", e);
		}		
		logger.info("Method: verifyCardBackModulelNameWithSMValue Ends");
		return flag;
	}
	/**
	 * Method used to verify Kognito details in recent activity
	 * 
	 * @param modulename index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyrecentActivityKognito(String modulename, int index) throws Exception {
		logger.info("verifyrecentActivityKognito Start");
		boolean flag = false;
		try {
			List<WebElement> recentActivityElement = baseHandler.findElements(".ra-row.rb-col-main.focus-element-flag");
			if(CollectionUtils.isNotEmpty(recentActivityElement))
			{
				String progressStatus = recentActivityElement.get(index).findElement(By.cssSelector("div[class*='status-in-progress']")).getText();
				String moduleNameloc = recentActivityElement.get(index).findElement(By.cssSelector("span[data-bind='html:ModuleName']")).getText();
				if(progressStatus.equalsIgnoreCase("IN PROGRESS")&& moduleNameloc.equalsIgnoreCase(modulename)){
					flag=true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyrecentActivityKognito" );
			log(logger, "Unable to verifyrecentActivityKognito" );
    		throw new DriverException("Unable to verifyrecentActivityKognito" , e); 
    	}
		logger.info("Method: verifyrecentActivityKognito End flag --> " + flag);
		return flag;
		}
	public boolean verifyKognitomoduleclosepopup() throws Exception {
		logger.info("verifyKognitomoduleclosepopup Start");
		boolean flag = false;
		try {
			List<WebElement> closepopup = baseHandler.findElements("#ui-id-1");
			List<WebElement> buttons = baseHandler.findElements(".button.primary-button.focus-element-flag");
			if(CollectionUtils.isNotEmpty(closepopup))
			{
				String popupmsg = closepopup.get(0).getText();
				String yesbtn = buttons.get(0).getText();
				String nobtn = buttons.get(1).getText();
			if(popupmsg.equalsIgnoreCase("Are you sure that you want to exit?")&& yesbtn.equalsIgnoreCase("Yes")&&nobtn.equalsIgnoreCase("No")){
					flag=true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyKognitomoduleclosepopup" );
			log(logger, "Unable to verifyKognitomoduleclosepopup" );
    		throw new DriverException("Unable to verifyKognitomoduleclosepopup" , e); 
    	}
		logger.info("Method: verifyKognitomoduleclosepopup End flag --> " + flag);
		return flag;
		}
	public boolean verifyKognitomodulepage(String modulename) throws Exception {
		logger.info("verifyKognitomodulepage Start");
		boolean flag = false;
		try {
			List<WebElement> Kognitoelement = baseHandler.findElements(".lesson-header-details.smartprep-details ul li");
			if(CollectionUtils.isNotEmpty(Kognitoelement))
			{
				String producytype = Kognitoelement.get(0).getText();
				String moduleNameele = Kognitoelement.get(1).getText();
				if(producytype.equalsIgnoreCase("Simulation:The Communicator 2.0")&& moduleNameele.contains(modulename)
						&& baseHandler.findElement(".close-button.focus-element-flag").isDisplayed()){
					flag=true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyKognitomodulepage" );
			log(logger, "Unable to verifyKognitomodulepage" );
    		throw new DriverException("Unable to verifyKognitomodulepage" , e); 
    	}
		logger.info("Method: verifyKognitomodulepage End flag --> " + flag);
		return flag;
		}
	
	public boolean verifyKognitomoduleTimespent() throws Exception {
		logger.info("verifyKognitomoduleTimespent Start");
		boolean flag = false;
		try {
			List<WebElement> modules = baseHandler.findElements("#productApplyModuleList .product-list-style>li");
			if(CollectionUtils.isNotEmpty(modules))
			for (int i = 0; i < modules.size(); i++) {
				if(!modules.get(i).findElement(By.cssSelector("#productApplyModuleList .product-list-style>li .time-accessed>span")).getText().equalsIgnoreCase("Never")) {
					if(modules.get(i).findElement(By.cssSelector(".time-suggested-spent")).isDisplayed()){
					flag = true;
					
				}
				}
			}	
		}catch (Exception e) {
    		logger.info("Unable to verifyKognitomoduleTimespent" );
			log(logger, "Unable to verifyKognitomoduleTimespent" );
    		throw new DriverException("Unable to verifyKognitomoduleTimespent" , e); 
    	}
		logger.info("Method: verifyKognitomoduleTimespent End flag --> " + flag);
		return flag;
		}
	
	/**
	 * This method used to Verify Card Front Details and modules count
	 * 
	 * @author Syed.pasha
	 * @throws DriverException 
	 * 
	 */
	public boolean verifyCardFrontDetails(String cardFrontModuleName, String modulesCount) throws DriverException {
		logger.info("Method: verifyCardFrontDetails Starts ");
		boolean flag = false;
		try {
			List<WebElement> titles = baseHandler.findElements(".card.simulation.front");
			for (int i = 0; i < titles.size(); i++) {
				if (titles.get(i).findElement(By.cssSelector(".description")).getText().equals(cardFrontModuleName)
						&& titles.get(i).findElement(By.cssSelector("header span")).getText().equals("Simulation")
						&& titles.get(i).findElement(By.cssSelector("footer span[data-bind='text: LastAccessed']")).isDisplayed()
						&& titles.get(i).findElement(By.cssSelector("header a")).isDisplayed()
						&& titles.get(i).findElement(By.cssSelector(".result-count-temp")).getText().equals(modulesCount)) {
					flag = true;
					break;
				}
			}			
		} catch (Exception e) {
			logger.info("Unable to verifyCardFrontDetails");
			log(logger, "Unable to verifyCardFrontDetails");
			throw new DriverException("Unable to verifyCardFrontDetails", e);
		}		
		logger.info("Method: verifyCardFrontDetails Ends");
		return flag;
	}
	
	/**
	 * This method used to Verify first 2 Card Back Modules List
	 * 
	 * @author Syed.pasha
	 * @throws DriverException 
	 * 
	 */
	public boolean verifyCardBackModulesList(String[] cardBacktModuleName, String modulesCount) throws DriverException {
		logger.info("Method: verifyCardBackModulesList Starts");
		boolean flag = false;
		try {
			List<WebElement> titles = baseHandler.findElements(".product-result-take");
			int moduleCount = 0;
			for (int i = 0; i < titles.size(); i++) {
				if (titles.get(i).isDisplayed()) {
					moduleCount++;
				}
			}			 
			if (moduleCount == 2 && titles.get(0).getText().equals(cardBacktModuleName[0]) && titles.get(1).getText().contains(cardBacktModuleName[1])) {
				flag = true;
			}		
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackModulesList");
			log(logger, "Unable to verifyCardBackModulesList");
			throw new DriverException("Unable to verifyCardBackModulesList", e);
		}		
		logger.info("Method: verifyCardBackModulesList Ends");
		return flag;
	}
	
	/**
	 * This method used to Verify first Card Back Modules List
	 * 
	 * @author Syed.pasha
	 * @throws DriverException 
	 * 
	 */
	public boolean verifyFirstCardBackModulesList(String[] cardBacktModuleName, String modulesCount) throws DriverException {
		logger.info("Method: verifyFirstCardBackModulesList Starts ");
		boolean flag = false;
		try {
			List<WebElement> titles = baseHandler.findElements(".product-result-take");
			int moduleCount = 0;
			for (int i = 0; i < titles.size(); i++) {
				if (titles.get(i).isDisplayed()) {
					moduleCount++;
				}
			}	
			if (moduleCount == 1 && titles.get(0).getText().equals(cardBacktModuleName[0])) {
				flag = true;
			}		
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackModulesList");
			log(logger, "Unable to verifyCardBackModulesList");
			throw new DriverException("Unable to verifyCardBackModulesList", e);
		}		
		logger.info("Method: verifyFirstCardBackModulesList Ends");
		return flag;
	}
	
	/**
	 * 
	 * @throws DriverException
	 */
	public boolean clickSimulationNameFromCardBack(String moduleName) throws Exception {

		//moduleName = "Gestational Diabetes";
		logger.info("Method: clickSimulationNameFromCardBack Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".product-list-style>li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("header span[class='product-result-take']"));
						if (element != null && element.getText().equals(moduleName)) {
							List<WebElement> moduleNameList = moduleList.get(i).findElements(By.cssSelector("div a[class='button primary-button focus-element-flag']"));
							if(CollectionUtils.isNotEmpty(moduleNameList)) {
								moduleNameList.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								logger.info("Clicking on Dismiss button");
								// clicking on Dismiss button for chrome 69 popup. 
								List<WebElement> dismissElement = baseHandler.findElements("button[class='md-btn md-btn-blue']");
								if(CollectionUtils.isNotEmpty(dismissElement)) {
									dismissElement.get(0).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								
								windowHandler.switchToMainWindow();
								windowHandler.switchToLatestWindow();
								Thread.sleep(20000);
								logger.info("Clicking on Book mark continue button");
								// Book mark continue button. 
								List<WebElement> bookMarkElement = baseHandler.findElements("div[class='hotspot widget sbobj'] canvas");
								if(CollectionUtils.isNotEmpty(bookMarkElement)) {
									bookMarkElement.get(2).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								
								// Verifying Simulation name and clicking on close button. 
								logger.info("Clicking on Simultion close button");
								driver.switchTo().frame("contentFrame");
								// clicking on close button
								List<WebElement> closeElement = baseHandler.findElements("div[class='hotspot widget sbobj'] canvas");
								if(CollectionUtils.isNotEmpty(closeElement)) {
									closeElement.get(0).click();
								}
								logger.info("Clicking on Yes or No button");
								// Yes or No button
								// clicking on close button
								List<WebElement> yesOrNoElement = baseHandler.findElements("div[class='hotspot widget sbobj'] canvas");
								if(CollectionUtils.isNotEmpty(yesOrNoElement)) {
									flag = true;
									yesOrNoElement.get(2).click();
									Thread.sleep(20000);
								}
								
								windowHandler.switchToLatestWindow();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
				}
			}
		}catch (Exception e) {
			logger.info("Unable to clickSimulationNameFromCardBack");
			log(logger, "Unable to clickSimulationNameFromCardBack");
			throw new DriverException("Unable to clickSimulationNameFromCardBack", e);
		}		
		logger.info("Method: clickSimulationNameFromCardBack Ends flag --> " + flag);
		return flag;
						}
	
}


