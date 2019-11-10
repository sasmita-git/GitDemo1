package com.automation.newati.pages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class EBookPage extends LearnTabPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private ButtonHandler btnHandler;
	private WindowHandler windowHandler;
	private HomePage homePage;
	private BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	
	public EBookPage(WebDriver driver) {
		super(driver);
		homePage = new HomePage(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		
	}

	public void myATILearnTabPageSelectEbook(String selectlocator,
			String selectvalue) throws DriverException {
		logger.info("Method : myATILearnTabPageSelectEbook :::::::: START");
		try {

			selectDropdownValue(selectlocator, selectvalue);

		} catch (DriverException e) {
			throw new DriverException("Unable to open Product in Test Tab" + e);
		}
		logger.info("Method : myATILearnTabPageSelectEbook :::::::: END");
	}

	public void myATILearnTabPageOpenEbook(
			String stmplateselectebookslinkToClick) throws Exception

	{
		logger.info("Method : myATILearnTabPageOpenEbook :::::::: START");
		btnHandler.clickButton(stmplateselectebookslinkToClick);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToLatestWindow();
		/*waitUntillLoadingImageIsDisappeared(PropertiesRepository
				.getString("new-atitesting.peasewait.bufferLoc"));*/

		logger.info("Method : myATILearnTabPageOpenEbook :::::::: END");
	}

	public void clickEBookButton() throws DriverException, NullPointerException, Exception {
		logger.info("Method: clickEBookButton Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(".ebook-row");
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			List<WebElement> eBookAndMediaElement = element.get(0).findElements(By.cssSelector("section div"));
    			if(CollectionUtils.isNotEmpty(eBookAndMediaElement)) {
    				WebElement eBookElement = eBookAndMediaElement.get(0).findElement(By.cssSelector("a"));
    				if(eBookElement != null) 
    					eBookElement.click();
    					windowHandler.switchToLatestWindow();
    					waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
    					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    			}
    			
    		}
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    	} catch (Exception e) {
    		logger.info("Unable to click EBook Button" );
			log(logger, "Unable to click EBook Button" );
    		throw new DriverException("Unable to click EBook Button" , e); 
    	}
    	logger.info("Method: clickEBookButton End " );
	}
	
	
	
	public boolean verifyPdfContinueButtonIsDisplayed() throws Exception {
		logger.info("Method: verifyPdfContinueButtonIsDisplayed Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			flag = checkElementEnabled(PropertiesRepository
					.getString("new-atitesting.homepage.myatitab.ebooks.continutBtn.loc"));

			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			throw new DriverException("Pdf Continue Button Is not displayed", e);
		}
		logger.info("Method: verifyPdfContinueButtonIsDisplayed Ends");
		return flag;
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

	public void myATILearnTabPageOpenEbook(int i) throws Exception {
		logger.info("Method : myATILearnTabPageOpenEbook :::::::: START");
		List<WebElement> ebooks = btnHandler
				.findElements("section[class=\"card front ebook\"] nav[class=\"actions\"] .button.primary-button.cardflip.focus-element-flag");
		if (CollectionUtils.isNotEmpty(ebooks)) {
			ebooks.get(2).click();
			windowHandler.switchToLatestWindow();
			homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
		}
		logger.info("Method : myATILearnTabPageOpenEbook :::::::: END");
	}
	
	public boolean verifyDuplicateModuleName() throws Exception {
		logger.info("Method: verifyDuplicateModuleName Starts");
		boolean flag = false;
		Set<String> duplicateName = new HashSet<String>();
    	try {
    		int i=0;
    		List<WebElement> element = baseHandler.findElements("#productEbookList .product-list-style");
    		if(CollectionUtils.isNotEmpty(element)) {
    			WebElement eBookElement = element.get(0);
    			// Getting all module.
    			if(eBookElement != null) {
    				List<WebElement> allEBookElement = eBookElement.findElements(By.cssSelector("li"));
    				// It will list 3 li element, take last one.
    				if(CollectionUtils.isNotEmpty(allEBookElement)) {
    					WebElement subEBookElement = allEBookElement.get(i);
    					if(subEBookElement != null) {
    						List<WebElement> individualModule = subEBookElement.findElements(By.cssSelector(".ebook-row .library-section-name"));
    						if(CollectionUtils.isNotEmpty(individualModule)) {
    							int size = individualModule.size();
    							for(int index = 0; index < size; index ++) {
    								String moduleName = individualModule.get(index).getText();
    								duplicateName.add(moduleName);
    							}
    							// Verifying the size of module and duplicate set object.
    							if(size == duplicateName.size()) {
    								flag = true;
    							}
    						}
    					}
    				}
    			}
    			
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyDuplicateModuleName");
			log(logger, "Unable to verifyDuplicateModuleName" );
    		throw new DriverException("Unable to verifyDuplicateModuleName" , e); 
    	}
    	logger.info("Method: verifyDuplicateModuleName End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to select card front based on name and click on module and
	 * verify below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author siddharth.roy
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean selectCardFrontBasedOnModuleNameeBook(String assessmentName) throws Exception {
		logger.info("Method: selectCardFrontBasedOnModuleName Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".card.front.ebook");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					WebElement elementToFind = moduleList.get(i);
					if (element != null) {
						if (assessmentName.equalsIgnoreCase(element.getText())) {
							if (elementToFind != null) {
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
										elementToFind);
								elementToFind
										.findElement(By.cssSelector(
												"nav a[class='button primary-button cardflip focus-element-flag']"))
										.click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag = true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Card Front Based On Module Name");
			throw new Exception("Unable to select Card Front Based On Module Name");
		}
		logger.info("Method: selectCardFrontBasedOnModuleName End --> " + flag);
		return flag;
	}

	public boolean verifyEbookTitles() throws DriverException, NullPointerException, Exception {
		logger.info("Method: verifyEbookTitles Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements(".ebook-row");
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				List<WebElement> eBookElement = baseHandler.findElements(".library-section-name");
				int size = eBookElement.size();
				if (CollectionUtils.isNotEmpty(eBookElement)) {
					for (int i = 0; i < size; i++) {
						String eBookTitle = eBookElement.get(i).getText();
						logger.info(eBookTitle);
						if (eBookTitle.contains("Review Module")) {
							flag = true;
						}
					}
				}
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to click EBook Button");
			log(logger, "Unable to click EBook Button");
			throw new DriverException("Unable to click EBook Button", e);
		}
		logger.info("Method: verifyEbookTitles End --> " + flag);
		return flag;

	}

	/**
	 * Method used to verify EBook module count. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public boolean veifyEBookMoudleCount(String simulationName, String count) throws Exception {
		logger.info("Method : veifyEBookMoudleCount Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements("#tabs-1 ul[class='image-grid flipcontainer'] li");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector(".card.front.ebook .learn-card-front-wrapper.default-container section .description"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						List<WebElement> buttonList = nameElement.findElements(By.cssSelector(".card.front.ebook .actions div[data-bind*='Tutorial']"));
						if(CollectionUtils.isNotEmpty(buttonList)) {
							// a[class='button primary-button cardflip focus-element-flag']
							int size = buttonList.size();
							for(int index = 0; index < size; index ++) {
								WebElement eBookElement = buttonList.get(index);
								if(eBookElement != null && !eBookElement.getAttribute("style").equalsIgnoreCase("display: none;")) {
									WebElement eBookCardFrontElement = eBookElement.findElement(By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
									if(eBookCardFrontElement != null) {
										String eBookMoudleCount = eBookCardFrontElement.findElement(By.cssSelector(".result-count-temp")).getText();
										if(StringUtils.isNotEmpty(eBookMoudleCount) && eBookMoudleCount.equalsIgnoreCase(count)) {
											flag = true;
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
											break;
										}
									}
								}
							}
						}
					} 
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to veifyEBookMoudleCount" );
			log(logger, "Unable to veifyEBookMoudleCount" );
    		throw new DriverException("Unable to veifyEBookMoudleCount" , e); 
    	}
		logger.info("Method: veifyEBookMoudleCount End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify EBook module count. 
	 * 
	 * @param simulationName
	 * @return
	 * @throws Exception
	 */
	public void clickEBookMoudleCount(String simulationName) throws Exception {
		logger.info("Method : clickEBookMoudleCount Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements("#tabs-1 ul[class='image-grid flipcontainer'] li");
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					// Verifying Name
					WebElement nameElementText = nameElement.findElement(By.cssSelector(".card.front.ebook .learn-card-front-wrapper.default-container section .description"));
					if(nameElementText != null && nameElementText.getText().equalsIgnoreCase(simulationName)) {
						List<WebElement> buttonList = nameElement.findElements(By.cssSelector(".card.front.ebook .actions div[data-bind*='Tutorial']"));
						if(CollectionUtils.isNotEmpty(buttonList)) {
							// a[class='button primary-button cardflip focus-element-flag']
							int size = buttonList.size();
							for(int index = 0; index < size; index ++) {
								WebElement eBookElement = buttonList.get(index);
								if(eBookElement != null && !eBookElement.getAttribute("style").equalsIgnoreCase("display: none;")) {
									WebElement eBookCardFrontElement = eBookElement.findElement(By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
									if(eBookCardFrontElement != null) {
										eBookCardFrontElement.click();
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
    		logger.info("Unable to clickEBookMoudleCount" );
			log(logger, "Unable to clickEBookMoudleCount" );
    		throw new DriverException("Unable to clickEBookMoudleCount" , e); 
    	}
		logger.info("Method: clickEBookMoudleCount End");
	}
	
	/**
	 * Method used to verify ebook and pdf in EBook Card back.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEBookSelectOption() throws Exception {
		logger.info("Method : verifyEBookSelectOption Start");
		boolean flag = false;
		boolean verifyFlag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements("#productEbookList .select.select-secondary");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					WebElement selectDivElement = element.get(index);
					if(selectDivElement != null ) {
						WebElement selectEle = selectDivElement.findElement(By.cssSelector("select"));
						Select selectElement = dropDownHandler.getDropDown(selectEle);
						//if(selectElement.selectByValue("2016 eBook") && selectElement.selectByValue("2016 PDF")) {
						List<WebElement> selectOptionElement = selectElement.getOptions();
						if(CollectionUtils.isNotEmpty(selectOptionElement)) {
							for(int listIndex =0 ; listIndex < selectOptionElement.size(); listIndex ++) {
								if(selectOptionElement.get(listIndex).getText().equalsIgnoreCase("2016 eBook") || selectOptionElement.get(listIndex).getText().equalsIgnoreCase("2016 PDF")
										||selectOptionElement.get(listIndex).getText().equalsIgnoreCase("2013")) {
									verifyFlag = true;
								} else {
									verifyFlag = false;
								}
							}
							if(!verifyFlag) {
								break;
							} else {
								flag = true;
							}
						}
						
					}
				}
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}catch (Exception e) {
    		logger.info("Unable to verifyEBookSelectOption" );
			log(logger, "Unable to verifyEBookSelectOption" );
    		throw new DriverException("Unable to verifyEBookSelectOption" , e); 
    	}
		logger.info("Method: verifyEBookSelectOption End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to select either ebook or pdf in EBook Card back.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean selectEBookOption(String option) throws Exception {
		logger.info("Method : selectEBookOption Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#productEbookList .select.select-secondary");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					WebElement selectDivElement = element.get(index);
					if(selectDivElement != null && !selectDivElement.getAttribute("style").equalsIgnoreCase("display: none;")) {
						WebElement selectEle = selectDivElement.findElement(By.cssSelector("select"));
						Select selectElement = dropDownHandler.getDropDown(selectEle);
						selectElement.selectByValue(option);
						flag = true;
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to selectEBookOption" );
			log(logger, "Unable to selectEBookOption" );
    		throw new DriverException("Unable to selectEBookOption" , e); 
    	}
		logger.info("Method: selectEBookOption End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify EBook or PDF count which is displayed on Card back.
	 * 
	 * @param locator
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEBookOrPDFCount(String locator, int count) throws Exception {
		logger.info("Method : verifyEBookOrPDFCountStart");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && element.size() == count) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyEBookOrPDFCount" );
			log(logger, "Unable to verifyEBookOrPDFCount" );
    		throw new DriverException("Unable to verifyEBookOrPDFCount" , e); 
    	}
		logger.info("Method: verifyEBookOrPDFCount End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify EBook or PDF count which is displayed on Card back.
	 * 
	 * @param locator
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public boolean clickEBook(String locator, int index) throws Exception {
		logger.info("Method : clickEBook");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to clickEBook" );
			log(logger, "Unable to clickEBook" );
    		throw new DriverException("Unable to clickEBook" , e); 
    	}
		logger.info("Method: clickEBook End flag --> " + flag);
		return flag;
	}
}
