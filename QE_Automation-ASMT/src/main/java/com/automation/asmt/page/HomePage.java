package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.LinkHandler;

public class HomePage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private LinkHandler linkHandler;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		linkHandler = new LinkHandler(driver);

	}

	/**
	 * This method is used to click on MyATI tab
	 * 
	 * @author Siddharth.roy
	 * @throws Exception
	 */
	public void clickOnMyAtiTab() throws Exception {
		logger.info("Method: clickOnMyAtiTab Starts");
		try {
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.homepage.myatiTabLoc"));
			if(baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.homepage.myatiTabLoc"))) {
				// click on myAti tab
				wait.until(ExpectedConditions.elementToBeClickable(baseHandler.findElement(PropertiesRepository
						.getString("asmt.homepage.myatiTabLoc"))));
				Thread.sleep(2000);
				linkHandler.selectLink(PropertiesRepository
						.getString("asmt.homepage.myatiTabLoc"));
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
				setDriverWait(PropertiesRepository
						.getString("asmt.testTabLoc"));
				waitUntillLoadingImageIsDisplayed(5);
			}
		} catch (Exception e) {
			logger.info("Unable to click On My ATI Tab");
			log(logger, "Unable to click On My ATI Tab");
			throw new DriverException("Unable to click On My ATI Tab", e);
		}
		logger.info("Method: clickOnMyAtiTab Ends");
	}

	/**
	 * This method is used to click on any button or link based on index.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws Exception 
	 */
	public void clickLinkFromList(String loc, int index) throws Exception {
		logger.info("clickLinkFromList Start");
		try {
		List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
		if(CollectionUtils.isNotEmpty(findElement))
		{
			findElement.get(index).click();
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		}
		} catch (Exception e) {
			logger.info("Unable to click Link From List");
			log(logger, "Unable to click Link From List");
			throw new DriverException("Unable to click Link From List", e);
		}
		logger.info("clickLinkFromList End");
	}
	
	

	/**
	 * Method used to verify Recent Activity. 
	 * 
	 * @param prodType
	 * 	Ex : Focused Review
	 * @param prodName
	 * 	Ex : Product name.
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRecentActivity(String prodType, String prodName) throws Exception {
		logger.info("Method: verifyRecentActivity Starts");
		boolean flag = false;
//		String productType = null;
//		String productName = null;
    	try {
    		/*List<WebElement> element = baseHandler.findElements(".ra-row.rb-col-main.focus-element-flag");
    		if(CollectionUtils.isNotEmpty(element)) {
    			// Taking first Recent Activity
    			List<WebElement> firstRecentActivity = element.get(0).findElements(By.cssSelector("div[class='rb-row-main'] div div[data-bind*='visible: ProductType()']"));
    			if(CollectionUtils.isNotEmpty(firstRecentActivity)) {
    				// Taking the assessemnt details.
    				if(CollectionUtils.isNotEmpty(firstRecentActivity)) {
    					int size = firstRecentActivity.size();
    					for(int index = 0 ; index < size; index ++) {
    						if(!"display: none;".equalsIgnoreCase(firstRecentActivity.get(index).getAttribute("style"))) {
    							List<WebElement> prodHeaderElement = firstRecentActivity.get(index).findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.recent.activity.assessment.headers.loc")));
    							if(CollectionUtils.isNotEmpty(prodHeaderElement)) {
    								productType = prodHeaderElement.get(0).findElement(By.cssSelector("div")).getText();
    								productName = prodHeaderElement.get(0).findElement(By.cssSelector("span")).getText();
    								break;
    							}
    						}
    					}
    				}    				
    		   }
    		}*/ 
    		// Taking the 1st assessemnt name in recent activity.
    		List<WebElement> recentActivityElement=driver.findElements(By.cssSelector((".ra-product-headers>span")));

    		if(!recentActivityElement.isEmpty()){
    			flag=true;    		}
//    		if(assessmentName.contains(prodName)) {
//    			flag = true;
//    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify recent activity section");
			log(logger, "Unable to verify recent activity section" );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyRecentActivity End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify Recent Activity. 
	 * 
	 * @param prodType
	 * 	Ex : Focused Review
	 * @param prodName
	 * 	Ex : Product name.
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRecentActivityNew(String prodType, String prodName) throws Exception {
		logger.info("Method: verifyRecentActivityNew Starts");
		boolean flag = false;
		String productTypeValue = null;
		String productNameValue = null;
    	try {
    		List<WebElement> element = baseHandler.findElements(".ra-row.rb-col-main.focus-element-flag");
    		if(CollectionUtils.isNotEmpty(element)) {
    			// Taking first Recent Activity
    			List<WebElement> firstRecentActivity = element.get(0).findElements(By.cssSelector("div[class='rb-row-main'] div div[data-bind*='visible:ProductType()']"));
    			if(CollectionUtils.isNotEmpty(firstRecentActivity)) {
    				// Taking the assessemnt details.
    				if(CollectionUtils.isNotEmpty(firstRecentActivity)) {
    					int size = firstRecentActivity.size();
    					for(int index = 0 ; index < size; index ++) {
    						if(!"display: none;".equalsIgnoreCase(firstRecentActivity.get(index).getAttribute("style"))) {
    							List<WebElement> prodHeaderElement = firstRecentActivity.get(index).findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.recent.activity.assessment.headers.loc")));
    							if(CollectionUtils.isNotEmpty(prodHeaderElement)) {
    								productTypeValue = prodHeaderElement.get(0).findElement(By.cssSelector("div")).getText();
    								productNameValue = prodHeaderElement.get(0).findElement(By.cssSelector("span")).getText();
    								break;
    							}
    						}
    					}
    				}    				
    		   }
    		} 
    		if(prodType.equalsIgnoreCase(productTypeValue) && productNameValue.contains(prodName)) {
    			flag = true;
    		}
    		// Taking the 1st assessemnt name in recent activity.
    		/*List<WebElement> recentActivityElement=driver.findElements(By.cssSelector((".ra-product-headers>span")));

    		if(!recentActivityElement.isEmpty()){
    			flag=true;    		
    			}*/
    		/*if(assessmentName.contains(prodName)) {
    			flag = true;
    		}*/
    	} catch (Exception e) {
    		logger.info("Unable to verifyRecentActivityNew");
			log(logger, "Unable to verifyRecentActivityNew" );
    		throw new DriverException("Unable to verifyRecentActivityNew" , e); 
    	}
    	logger.info("Method: verifyRecentActivityNew End flag --> " + flag);
    	return flag;
	}
}
