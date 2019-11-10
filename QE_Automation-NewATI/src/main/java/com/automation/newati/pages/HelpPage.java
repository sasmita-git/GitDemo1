package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class HelpPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	public HelpPage(WebDriver driver) {
		super(driver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}



	/**
	 * this is useful to verify header name
	 * @param headerLoc
	 * @param headerName
	 * @return boolean
	 * @throws DriverException 
	 */
	public boolean verifyHeader(String headerLoc, String headerName) throws DriverException {
		logger.info("Method: verifyHeader Starts");
		
		try {
			WebElement headerElement = baseHandler.findElement(PropertiesRepository.getString(headerLoc));
			if(headerElement!=null && PropertiesRepository.getString(headerName).equalsIgnoreCase(headerElement.getText().trim()))
			{
				return true;
			}
		} catch (Exception e) {
			throw new DriverException("unable to verify header"+e);
		}
		
		
		logger.info("Method: verifyHeader End");
		
		return false;
		
	}

	public boolean verifyFAQSection() throws InterruptedException {
		
		List<Boolean> list=new ArrayList<Boolean>();
		waitForWhile(7000);
		List<WebElement> elements = baseHandler.findElements(".help-faq-question.focused-element-flag.more-icon");
		if(CollectionUtils.isNotEmpty(elements))
		{
				List<WebElement> insideContentLocator = baseHandler.findElements(".help-faq-answer");
				for(int i=0;i<insideContentLocator.size();i++)
				{
					elements.get(i).click();
					waitForWhile(5000);
					list.add(insideContentLocator.get(i).isDisplayed());
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(200,1000)", "");
					waitForWhile(3000);

				}
				
		}
		return list.contains(true)?true:false;
	}

	/**
	 * this is used to verify links in the FAQ section
	 * @param loc
	 * @return boolean
	 */

	public boolean verifyFAQsSectionLinks(String loc) {
	int i;
	ArrayList<Boolean> list=new ArrayList<Boolean>();
		if(baseHandler.findElements(loc).size()==3)
		{
			List<WebElement> ele = baseHandler.findElements(loc);
			for(i=0;i<ele.size();i++)
			{
				List<WebElement> findElements = baseHandler.findElements(loc);
				findElements.get(i).click();
				List<WebElement> linknames = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homePage.faq.link.names"));
				if(i==0)
				{
					list.add(linknames.get(0).getText().equals(PropertiesRepository.getString("new-atitesting.homePage.faq.link1.name")));
				}
				else if(i==1)
				{
					list.add(linknames.get(4).getText().equals(PropertiesRepository.getString("new-atitesting.homePage.faq.link2.name")));
				}
				else
				{
					list.add(linknames.get(10).getText().equals(PropertiesRepository.getString("new-atitesting.homePage.faq.link3.name")));
				}
			}
		}
		else
		{
			logger.info("FAQ Links are not present");
		}
		return list.contains(false)?false:true;
		}
	
	public boolean verifyFAQSectionHeaders() {
		
		List<Boolean> list=new ArrayList<Boolean>();
		List<WebElement> elements = baseHandler.findElements(".help-faq-question.focused-element-flag.more-icon");
		String[] array = PropertiesRepository.getStringAsArray("new-atitesting.homePage.faq.names");
		if(CollectionUtils.isNotEmpty(elements))
		{
				List<WebElement> insideContentLocator = baseHandler.findElements(".help-faq-answer");
				for(int i=0;i<insideContentLocator.size();i++)
				{
					if(array[i].equalsIgnoreCase(elements.get(i).getText().trim()))
					{
					list.add(true);
					}
					else
					{
						list.add(false);
					}
				}
				
		}
		return list.contains(true)?true:false;
	}



	public void verifyHowToSectionLinks() throws InterruptedException {
		try {
			List<WebElement> elements = baseHandler.findElements(".help-faq-question.focused-element-flag.more-icon");
			if (CollectionUtils.isNotEmpty(elements)) {
				elements.get(3).click();
				List<WebElement> findElements = baseHandler.findElements(".help-faq-section .help-faq-answer");
				List<WebElement> findElements2 = findElements.get(3).findElements(By.tagName("a"));
				if (CollectionUtils.isNotEmpty(findElements2)) {
					for (WebElement webElement : findElements2) {
						waitForWhile(4000);
						webElement.click();							
						logger.info("Clicked on Link >>> " + webElement.getText());
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click link" + e);
		}
	}

	public boolean clickOnPdfClosButton() throws DriverException {
		logger.info("Method : clickOnPdfClosButton Starts");
		try {
			driver.findElement(
					By.cssSelector(".close-button.focus-element-flag")).click();
			windowHandler.switchToLatestWindow();
			WebElement findElement = baseHandler
					.findElement(PropertiesRepository
							.getString("new-atitesting.homepage.myatitab.ebooksmodule.link"));
			if (findElement != null) {
				return true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on pdf close button", e);
		}
		logger.info("Method : clickOnPdfClosButton Ends");
		return false;
	}

	public void verifyPdfLinks(String loc) throws Exception {
		
		List<WebElement> findElements = baseHandler.findElements(PropertiesRepository.getString(loc).trim());
		if(CollectionUtils.isNotEmpty(findElements))
		{
			for (WebElement webElement : findElements) {
				if(webElement.isDisplayed())
				{
				String windowHandle = driver.getWindowHandle();
				webElement.click();
				waitForWhile(15000);
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				windowHandler.switchToWindow(windowHandle); 
				}
			}
		}
		
	}

public void verifyVideoLinks(String loc) throws Exception {
	List<WebElement> findElements = baseHandler.findElements(PropertiesRepository.getString(loc).trim());
		if(CollectionUtils.isNotEmpty(findElements))
		{
			for (WebElement webElement : findElements) {
				if(webElement.isDisplayed())
				{
				webElement.click();
				//windowHandler.switchToModalDialog();
				waitForWhile(15000);
				List<WebElement> findElements1 = baseHandler.findElements(".ui-button.ui-widget");
				if(CollectionUtils.isNotEmpty(findElements))
				{
					findElements1.get(0).click();
				}
				findElements = baseHandler.findElements(PropertiesRepository.getString(loc).trim());
				}
			}
		}
		
	}


	private void waitForWhile(int milliSeconds) throws InterruptedException {
		Thread.sleep(milliSeconds);
		
	}



	public boolean verifyLinks(String loc) {
		
		List<Boolean> list=new ArrayList<Boolean>();
		List<WebElement> elements = baseHandler.findElements("div[data-bind='text:Title']");
		String[] array = PropertiesRepository.getStringAsArray("new-atitesting.homePage.links.names");
		if(CollectionUtils.isNotEmpty(elements))
		{
				for(int i=0;i<elements.size();i++)
				{
					if(array[i].equalsIgnoreCase(elements.get(i).getText().trim()))
					{
					list.add(true);
					}
					else
					{
						list.add(false);
					}
				}
				
		}
		return list.contains(true)?true:false;
		
	}
	
	
	/**
	 *  this method is used to verify the text in the simulation module
	 * @return boolean
	 */
	public boolean verifySimulationsPage() {
		boolean flag = false;
		try {
			Thread.sleep(22000);
			String parentWindow = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String windowHandle : handles) {
				if (!windowHandle.equals(parentWindow)) {
					driver.switchTo().window(windowHandle);
					driver.close(); // closing child window
					driver.switchTo().window(parentWindow); // cntrl to parent
															// window
					flag = true;
				}
			}
		} catch (InterruptedException e) {
		}

		return flag;

	}


	
	public Map<String, String> getBrowserDetailsFromHelpPage() throws DriverException {
		logger.info("Method: compareTechnicalRequirements Starts");
		boolean flag = false;
		Map<String, String> map=new LinkedHashMap<String, String>();
		try {
			
			List<WebElement> browserNames = baseHandler.findElements(".help-faq-answer .telerik-reTableEvenCol-1");
			List<WebElement> versions = baseHandler.findElements(".help-faq-answer .telerik-reTableOddCol-1");
			for (int i = 0; i < browserNames.size(); i++) {
				map.put(browserNames.get(i).getText().trim(), versions.get(i).getText().trim());
			}
				
		} catch (Exception e) {
			logger.info("Unable to compare Technical Requirements");
			log(logger, "Unable to compare Technical Requirements");
			throw new DriverException("Unable to compare Technical Requirements", e);
		}
		logger.info("Method: compareTechnicalRequirements End flag --> " + flag);
		return map;
	}
	
	public Map<String, String> getDeviceDetailsFromHelpPage() throws DriverException
	{
		logger.info("Method:getDeviceDetailsFromHelpPage Starts");
		Map<String, String> deviceMap=new LinkedHashMap<String, String>();
		try {
			List<WebElement> deviceNames = baseHandler.findElements(".help-faq-answer .telerik-reTable-1:nth-of-type(2) .telerik-reTableOddRow-1 .telerik-reTableHeaderEvenCol-1");
			List<WebElement> os = baseHandler.findElements(".help-faq-answer .telerik-reTable-1:nth-of-type(2) .telerik-reTableEvenRow-1 .telerik-reTableHeaderEvenCol-1");
			deviceMap.put(deviceNames.get(0).getText().trim(), deviceNames.get(1).getText().trim());
			deviceMap.put(os.get(0).getText().trim(), os.get(1).getText().trim());
			deviceMap.put(deviceNames.get(2).getText().trim(), deviceNames.get(3).getText().trim());
			deviceMap.put(os.get(2).getText().trim(), os.get(3).getText().trim());
		} catch (Exception e) {
			logger.info("Unable to get device Details From HelpPage");
			log(logger, "Unable to get device Details From HelpPage");
			throw new DriverException("Unable to get device Details From HelpPage", e);
		}
		logger.info("Method:getDeviceDetailsFromHelpPage End");
		return deviceMap;
	}
	
	public Map<String, String> getBrowserDetailsFromHomePage() throws DriverException {
		logger.info("Method: getBrowserDetailsFromHomePage Starts");
		Map<String, String> map=new LinkedHashMap<String, String>();
		try {
			
			List<WebElement> browserNames = baseHandler.findElements("#techRequirementsDialog .custom-table:nth-of-type(1) tr td");
			for (int i = 0; i < browserNames.size(); i=i+2) {
				map.put(browserNames.get(i).getText().trim(), browserNames.get(i+1).getText().trim());
			}
				
		} catch (Exception e) {
			logger.info("Unable to compare Technical Requirements");
			log(logger, "Unable to compare Technical Requirements");
			throw new DriverException("Unable to compare Technical Requirements", e);
		}
		logger.info("Method: getBrowserDetailsFromHomePage End flag --> ");
		return map;
	}
	
	public Map<String, String> getDeviceDetailsFromHomePage() throws DriverException
	{
		logger.info("Method:getDeviceDetailsFromHomePage Starts");
		Map<String, String> map=new LinkedHashMap<String, String>();
		try {
			
			List<WebElement> deviceDetails = baseHandler.findElements("#techRequirementsDialog .custom-table:nth-of-type(2) tr td");
			for (int i = 0; i < deviceDetails.size(); i=i+2) {
				map.put(deviceDetails.get(i).getText().trim(), deviceDetails.get(i+1).getText().trim());
			}
				
		} catch (Exception e) {
			logger.info("Unable to compare Technical Requirements");
			log(logger, "Unable to compare Technical Requirements");
			throw new DriverException("Unable to compare Technical Requirements", e);
		}
		logger.info("Method:getDeviceDetailsFromHomePage End");
		return map;
	}



	public boolean compareTechnicalRequirements(Map<String, String> compareTechnicalRequirements, Map<String, String> deviceDetailsFromHelpPage,
			Map<String, String> browserDetailsFromHomePage, Map<String, String> deviceDetailsFromHomePage) throws DriverException {
		try {
			  Map<String, String> treeMap = new TreeMap<String, String>(compareTechnicalRequirements);
			  Map<String, String> treeMap1 = new TreeMap<String, String>(browserDetailsFromHomePage);
			  Map<String, String> treeMap2 = new TreeMap<String, String>(deviceDetailsFromHelpPage);
			  Map<String, String> treeMap3 = new TreeMap<String, String>(deviceDetailsFromHomePage);
			if(treeMap.equals(treeMap1) &&treeMap2.equals(treeMap3))
				
			{
			return true;
			}
			
		} catch (Exception e) {
			logger.info("Unable to compare Technical Requirements");
			//log(logger, "Unable to compare Technical Requirements");
			throw new DriverException("Unable to compare Technical Requirements", e);
		}
		
		return false;
	}
	
	/**
	 * This method is used to verify faq section enabled or not
	 * 
	 * @author Sagar.Rao
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyfaqSection() throws DriverException {
		logger.info("Method: verifyfaqSection Start");
		boolean flag = false;
		try {
			flag = checkElementDispalyed(PropertiesRepository.getString("new-atiteting.faq.section.helpPageLoc"));
		} catch (Exception e) {
			throw new DriverException("faq section is not displayed", e);
		}
		logger.info("Method: verifyfaqSection Ends");
		return flag;
	}
	
	public boolean checkElementDispalyed(String locator, String... waitFor) throws DriverException {
		logger.info("checkElementDispalyed Start " + locator);
		boolean  flag = false;
		List<WebElement> element = baseHandler.findElements(locator);

		if (element.size() > 0) {
			WebElement elementDispalyed = element.get(0);
			//baseHandler.waitToBeDisplayed(elementDispalyed);
			flag = baseHandler.isDisplayed(elementDispalyed);
		}

		if (flag && waitFor != null && waitFor.length > 0) {
			baseHandler.setDriverWait(driver, waitFor[0]);
		}
		logger.info("checkElementDispalyed End " + flag);
		return flag;
	}

		
	public boolean verifyHelpPageLinks(String locator) throws DriverException {
		logger.info("Method: verifyIPPPageHeader Starts");
		boolean flag = false;
		String[] stringAsArray = PropertiesRepository.getStringAsArray("new-atitesting.helptab.getting.started.ati.link.names");
		List<String> list=new ArrayList<String>();
		List<Boolean> resultList=new ArrayList<Boolean>();
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					list.add(webElement.getText());
				}
			}
			for(int i=0;i<stringAsArray.length;i++)
			{
				if(list.get(i).equalsIgnoreCase(stringAsArray[i]))
				{
					resultList.add(true);
				}
				else
				{
					resultList.add(false);
				}
			}
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
		return resultList.contains(false)?false:true;
	}



	public boolean verifyFeedBackPageRadioOptionText() throws DriverException {
		logger.info("Method: verifyIPPPageHeader Start");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atiteting.helptab.feedback.radio.button.text.loc"));
			String text = PropertiesRepository.getString("new-atitesting.helptab.feedback.radio.button.text");
			String text1 = PropertiesRepository.getString("new-atitesting.helptab.feedback.radio.button.text1");
			if(CollectionUtils.isNotEmpty(elements) && text.equalsIgnoreCase(elements.get(0).getText().trim()) && 
					text1.equalsIgnoreCase(elements.get(1).getText().trim()))
			{
				return true;
			}
			
		} catch (Exception e) {
			logger.info("Unable to verify FeedBack Page Radio Option Text ");
			log(logger, "Unable to verify FeedBack Page Radio Option Text ");
			throw new DriverException("Unable to verify FeedBack Page Radio Option Text ", e);
		}
		logger.info("Method: verifyIPPPageHeader End");
		return false;

	}



	public boolean verifyFeedBackBugCommentBox(String priority) throws DriverException {
		logger.info("Method: verifyFeedBackBugCommentBox Start");
		try
		{
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atiteting.helptab.feedback.radio.button.text.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				elements.get(1).click();
				selectDropdownValue(PropertiesRepository.getString("new-atiteting.helptab.feedback.dropdown.loc"), priority);
				WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.box.loc"));
				if(element!=null)
				{
					element.sendKeys(PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.box.input"));
					WebElement submitButtonLoc = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
					String text = PropertiesRepository.getString("new-atitesting.helptab.feedback.description");
					List<WebElement> elements2 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.helptab.feedback.description.loc"));
					if(CollectionUtils.isNotEmpty(elements2) && text.trim().equalsIgnoreCase(elements2.get(1).getText().trim()) 
							&& submitButtonLoc.isDisplayed())
					{
						return true;
					}
				}
		}
		} catch (Exception e) {
		logger.info("Unable to verify Feed Back Bug Comment Box");
		log(logger, "Unable to verify Feed Back Bug Comment Box");
		throw new DriverException("Unable to verify Feed Back Bug Comment Box", e);
		}
		logger.info("Method: verifyFeedBackBugCommentBox End");
		return false;
	}


	public boolean verifyCancelAndSubmitButton(String priority) throws DriverException {
		logger.info("Method: verifyFeedBackBugCommentBox Start");
		List<Boolean> list=new ArrayList<Boolean>();
		try
		{
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atiteting.helptab.feedback.radio.button.text.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				elements.get(1).click();
				selectDropdownValue(PropertiesRepository.getString("new-atiteting.helptab.feedback.dropdown.loc"), priority);
				WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.box.loc"));
				if(element!=null)
				{
					WebElement cancelButton = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
					WebElement beforesubmitButtonStatus = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
					if(cancelButton.isEnabled() && !beforesubmitButtonStatus.isEnabled())
					{
						list.add(true);
					}
					element.sendKeys(PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.box.input"));
					WebElement submitButtonLoc = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
					WebElement cancelButton1 = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.cancel.button.loc"));
					
					if(submitButtonLoc.isEnabled() && cancelButton1.isEnabled())
					{
						list.add(true);
					}
				}
		}
		} catch (Exception e) {
		logger.info("Unable to verify Feed Back Bug Comment Box");
		log(logger, "Unable to verify Feed Back Bug Comment Box");
		throw new DriverException("Unable to verify Feed Back Bug Comment Box", e);
		}
		logger.info("Method: verifyFeedBackBugCommentBox End");
		return list.contains(false)?false:true;
	}



	public boolean verifyCommentsAndSuggestionBox() throws DriverException {
		logger.info("Method: verifyCommentsAndSuggestionBox Start");
		try
		{
			List<WebElement> radioButtonLoc = baseHandler.findElements(PropertiesRepository.getString("new-atiteting.helptab.feedback.radio.button.text.loc"));
			if(CollectionUtils.isNotEmpty(radioButtonLoc))
			{
				radioButtonLoc.get(0).click();
				WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.suggestion.textarea.loc"));
				if(element!=null)
				{
					element.sendKeys(PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.box.input"));
					WebElement submitButtonLoc = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.submit.button.loc"));
					String text = PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.suggestion.desc");
					List<WebElement> elements2 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.helptab.feedback.description.loc"));
					if(CollectionUtils.isNotEmpty(elements2) && text.trim().equalsIgnoreCase(elements2.get(2).getText().trim()) 
							&& submitButtonLoc.isDisplayed())
					{
						return true;
					}
				}
		}
		} catch (Exception e) {
		logger.info("Unable to verify Comments And Suggestion Box");
		log(logger, "Unable to verify Comments And Suggestion Box");
		throw new DriverException("Unable to verify Comments And Suggestion Box", e);
		}
		logger.info("Method: verifyCommentsAndSuggestionBox End");
		return false;
	}
	
	public boolean verifyCommentsAndSuggestionSectionDescription() throws DriverException {
		logger.info("Method: verifyCommentsAndSuggestionBox Start");
		try
		{
			List<WebElement> radioButtonLoc = baseHandler.findElements(PropertiesRepository.getString("new-atiteting.helptab.feedback.radio.button.text.loc"));
			if(CollectionUtils.isNotEmpty(radioButtonLoc))
			{
				radioButtonLoc.get(0).click();
				WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.helptab.feedback.suggestion.textarea.loc"));
				if(element!=null)
				{
					String text = PropertiesRepository.getString("new-atitesting.helptab.feedback.comment.suggestion.desc");
					List<WebElement> elements2 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.helptab.feedback.description.loc"));
					if(CollectionUtils.isNotEmpty(elements2) && text.trim().equalsIgnoreCase(elements2.get(2).getText().trim())) 
					{
						return true;
					}
				}
		}
		} catch (Exception e) {
		logger.info("Unable to verify Comments And Suggestion Box");
		log(logger, "Unable to verify Comments And Suggestion Box");
		throw new DriverException("Unable to verify Comments And Suggestion Box", e);
		}
		logger.info("Method: verifyCommentsAndSuggestionBox End");
		return false;
	}
	
	/**
	 * Method used to verify PC Device under FAQ Section. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPCValueInTechReqInFAQSection() throws Exception {
		//logger.info("Method: verifyPCValueInTechReqInFAQSection Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(".telerik-reTable-1");
    		if(CollectionUtils.isNotEmpty(element)) {
    			// Getting Device table
    			WebElement deviceTable = element.get(1);
    			if(deviceTable != null) {
    				List<WebElement> deviceTableOddTr = deviceTable.findElements(By.cssSelector("tr[class='telerik-reTableOddRow-1']"));
    				if(CollectionUtils.isNotEmpty(deviceTableOddTr)) {
    					List<WebElement> deviceTablePCTr = deviceTableOddTr.get(0).findElements(By.cssSelector("td"));
    					if(CollectionUtils.isNotEmpty(deviceTablePCTr)) {
    						WebElement pcOSDetailElement = deviceTablePCTr.get(1);
    						if(pcOSDetailElement != null && pcOSDetailElement.getText().trim().equalsIgnoreCase("Windows 7, 8, 8.1 and 10")) {
    							flag = true;
    						}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyPCValueInTechReqInFAQSection End flag --> " + flag);
    	return flag;
	}
}
