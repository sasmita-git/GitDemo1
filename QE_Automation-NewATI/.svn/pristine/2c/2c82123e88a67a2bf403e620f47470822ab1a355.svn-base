package com.automation.newati.pages;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class MyATITabMainPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	private HomePage homePage;
	
	public MyATITabMainPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * Method is used to Click Info icon using Product Name
	 * 
	 * Product Name
	 * 
	 * @throws Exception
	 */
	
	public void clickInfoIconByName(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository
						.getString("new-atitesting.test.tab.all.modules.loc"));
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList
						.get(i)
						.findElement(
								By.cssSelector(PropertiesRepository
										.getString("new-atitesting.testtab.specific.modules.name.loc")));
				WebElement element1 = moduleList.get(i);
				if (productName.equalsIgnoreCase(element.getText())) {
					element1.findElement(
							By.cssSelector(PropertiesRepository
									.getString("new-atitesting.testtab.specific.modules.info.icon.loc"))).click();
					Thread.sleep(10000);
					break;
				}
			}
		}
		logger.info("Method: clickInfoIconByName End");
	}
	
	/**
	 * Method is used to Verify Added product
	 * 
	 * Product ID
	 * 
	 * @throws Exception
	 */
	
	public void verifyAddedProduct(String ProductID) throws Exception {
		
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.testtab.product.information.popup.loc"));
		if (CollectionUtils.isNotEmpty(elements)) {
			
			System.out.println("Product Name=" +elements.get(0).getText());
			VerificationHandler.verifyEquals(ProductID, elements.get(1).getText());
		}
	}
	
	/**
	 * Method is used to Add CDN on Student portal home page
	 * 
	 * @throws Exception
	 */
	
	public void addCDN() throws Exception {
		
		log(logger, "Clicking on Add Product button");
		String result = null;
		String environment = getEnvironment();
		homePage.click(PropertiesRepository
				.getString("new-atitesting.createaccount.addProductButtonLoc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");


		if("Production".equalsIgnoreCase(environment)) {
			result =  PropertiesRepository.getString("new-atitesting.add.product.secondary.cdn.id");
		
		} else if("Stage".equalsIgnoreCase(environment)) {
			result = PropertiesRepository.getString("new-atitesting.add.product.secondary.cdn.id");
		} else {
			result = PropertiesRepository.getString("new-atitesting.add.product.secondary.cdn.id");
		}
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"),result);

		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository
				.getString("new-atitesting.add.product.continue.button.loc"));
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
//		if(baseHandler.findElement(PropertiesRepository
//				.getString("new-atitesting.add.product.continue.button.loc")).isDisplayed()) {
//			
//			baseHandler.findElement(PropertiesRepository.getString("new-atitesting.add.product.id.loc")).clear();
//			textHandler.writeText(PropertiesRepository
//					.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
//					.getString("new-atitesting.add.product.primary.cdn.id"));
//			homePage.click(PropertiesRepository
//					.getString("new-atitesting.add.product.continue.button.loc"));
//		} 
//		else {
//		expWaitVisibilityofElement(PropertiesRepository
//				.getString("new-atitesting.add.product.loc"));
//		log(logger, "Clicking on Add Product button");
//		homePage.click(PropertiesRepository
//				.getString("new-atitesting.add.product.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		textHandler.writeText(PropertiesRepository
//				.getString("new-atitesting.add.product.id.loc"), PropertiesRepository
//				.getString("new-atitesting.add.product.primary.cdn.id"));
//		
//		log(logger, "Clicking on Continue button");
//		homePage.click(PropertiesRepository
//				.getString("new-atitesting.add.product.continue.button.loc"));
//		
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		}	
	}
	
	/**
	 * Method is used to verify List is sorted in Ascending or not.
	 * 
	 * @param list
	 * @return
	 */
	public boolean isListSortedInAscendingOrder	(List<String> list) throws Exception 
	{
		logger.info("isListSortedInAscendingOrder Start");
		boolean flag = false;
		try{
			if(list == null || list.isEmpty())
				flag = false;

		    if(list.size() == 1)  
		    	flag = true;

		    for(int i=1; i<list.size();i++)
		    {
		    	String currentValue = list.get(i).toLowerCase();
		    	String previousValue = list.get(i-1).toLowerCase();
		    	
		        if(currentValue.compareTo(previousValue) < 0 ) {
		        	System.out.println("currentValue -->  " + currentValue);
		        	System.out.println("previousValue -->  " + previousValue);
		        	flag = false;
		        }
		        flag = true;
		    }
		} catch(Exception e) {
			throw new Exception("isListSortedInAscendingOrder ", e);
		}
	    logger.info("isListSortedInAscendingOrder flag --> " + flag);
	    return flag;    
	}
	
	/**
	 * Method is used to verify List is sorted in Descending or not.
	 * 
	 * @param list
	 * @return
	 */
	public boolean isListSortedInDescendingOrder(List<String> list)
	{
		logger.info("isListSortedInDescendingOrder Start");
		boolean flag = false;
	    if(list == null || list.isEmpty())
	        flag = false;

	    if(list.size() == 1)  
	        flag = true;

	    for(int i=1; i<list.size();i++)
	    {
	    	String currentValue = list.get(i).toLowerCase();
	    	String previousValue = list.get(i-1).toLowerCase();
	    	
	        if(currentValue.compareTo(previousValue) > 0 ) {
	        	System.out.println("currentValue -->  " + currentValue);
	        	System.out.println("previousValue -->  " + previousValue);
	            flag = false;
	        }
	        
	        flag = true;
	    }
	    logger.info("isListSortedInDescendingOrder End");
	    return flag;    
	}
	
	/**
	 * Method is used to get the Selected option from All Type.
	 * 
	 * locator of Select Option. 
	 * Index - Location of index in Locator. 
	 * 	0 - View
	 * 	1 - Type
	 * 	2 - Sort
	 * ddValue - Value in it corresponding dd. 
	 * 	if Type
	 * 	ddValue - All/ Practice/ Proctored.
	 * 
	 * @param locator
	 * @param index
	 * @param ddValue
	 * @return
	 * @throws DriverException
	 */
	public boolean getLearnTabTypeSelectedOption(String locator, int index, String ddValue) throws DriverException {
			logger.info("Method: getLearnTabTypeSelectedOption Start" );
			boolean flag = false;
			try {
				List<WebElement> selectDiv = baseHandler.findElements(locator);
				int size = selectDiv.size();
				if(selectDiv !=null && size > 0) {
					Select selDrop = new Select(selectDiv.get(index));
					WebElement element = selDrop.getFirstSelectedOption();
					if(ddValue.equalsIgnoreCase(element.getText())) {
						flag = true;
					}
				}
			} catch (Exception e) {
				logger.info("Unable to click on Learn Tab All value in Type Drop down");
				throw new DriverException("Unable to click on Learn Tab All value in Type Drop down", e);
			}
			logger.info("Method: getLearnTabTypeSelectedOption Ends flag --> " + flag );
			return flag;
		}
	
	/**
	 * Method is used to verify List is sorted in Ascending or not.
	 * 
	 * @param list
	 * @return
	 */
	public boolean isDateSortedInAscendingOrder	(List<Calendar> list) throws Exception 
	{
		logger.info("isDateSortedInAscendingOrder Start");
		boolean flag = false;
	   try {
		   if(list == null || list.isEmpty())
			   flag = false;

		    if(list.size() == 1)  
		    	flag = true;

		    for(int i=1; i<list.size();i++)
		    {
		    	Calendar currentValue = list.get(i);
		    	Calendar previousValue = list.get(i-1);
		    	
		        if(currentValue.compareTo(previousValue) > 0 ) {
		        	flag = false;
		        }
		        flag=true;
		    }
	   }catch(Exception e) {
		   throw new Exception ("isDateSortedInAscendingOrder", e);
	   }
	    logger.info("isDateSortedInAscendingOrder flag --> " + flag);
	    return flag;    
	}
	
	/**
	 * Method is used to verify Accessed Assessments displayed.
	 * @author Vaishali.Katta
	 */
	public boolean isAccessedAssessmentDisplayedinTestTab() throws Exception 
	{
		logger.info("isAccessedAssessmentDisplayedinTestTab Start");
		boolean flag = false;
	   try {
		   System.err.println(PropertiesRepository.getString("new-atitesting.test.tab.accessed.text.loc"));
		   List<WebElement> allAccessed = sizzleSelector.findElementsBySizzleCss(driver, 
				   PropertiesRepository.getString("new-atitesting.test.tab.accessed.text.loc"));
		   for (WebElement webElement : allAccessed) {
			flag = webElement.isDisplayed();
		   }
	   }catch(Exception e) {
		   throw new Exception ("isAccessedAssessmentDisplayedinTestTab", e);
	   }
	    logger.info("isAccessedAssessmentDisplayedinTestTab flag --> " + flag);
	    return flag;    
	}
	
	/**
	 * Method is used to verify Not Accessed Assessments displayed.
	 * @author Vaishali.Katta
	 */
	public boolean isNotAccessedAssessmentDisplayedinTestTab() throws Exception 
	{
		logger.info("isNotAccessedAssessmentDisplayedinTestTab Start");
		boolean flag = false;
	   try {
		   List<WebElement> allAccessed = sizzleSelector.findElementsBySizzleCss(driver, 
				   PropertiesRepository.getString("new-atitesting.test.tab.not.accessed.text.loc"));
		   for (WebElement webElement : allAccessed) {
			flag = webElement.isDisplayed();
		   }
	   }catch(Exception e) {
		   throw new Exception ("isNotAccessedAssessmentDisplayedinTestTab", e);
	   }
	    logger.info("isNotAccessedAssessmentDisplayedinTestTab flag --> " + flag);
	    return flag;    
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyDemoButtonForType(String tutorialName) throws Exception {
		logger.info("verifyDemoButtonForType Start");
		boolean flag = false;
		try {
			List<WebElement> demoButtons = baseHandler.findElements("#tabs-1 .card.front.tutorial");
			for (int i = 0; i < demoButtons.size(); i++) {
				if(demoButtons.get(i).findElement(By.cssSelector(".description")).getText().equals(tutorialName))
				{
					if(demoButtons.get(i).findElement(By.cssSelector("a[class='button accent-button cardflip focus-element-flag']")).isDisplayed())
					{
						flag= true;
						break;
					}
				}			
			}			
		}catch (Exception e) {
			throw new Exception("verifyDemoButtonForType", e);
		}
		logger.info("verifyDemoButtonForType flag --> " + flag);
		return flag;
	}
	
	/**
	 * method used
	 * click demo button for specified product
	 */
	public void clickonDemoButton(String tutorialName) throws Exception {
		logger.info("ClickonDemoButton Start");
		try {
			List<WebElement> demoButtons = baseHandler.findElements("#tabs-1 .card.front.tutorial");
			if (CollectionUtils.isNotEmpty(demoButtons)) {
				for (int i = 0; i < demoButtons.size(); i++) {
					if (demoButtons.get(i).findElement(By.cssSelector(".description")).getText()
							.equalsIgnoreCase(tutorialName)) {
						if (demoButtons.get(i)
								.findElement(
										By.cssSelector("a[class='button accent-button cardflip focus-element-flag']"))
								.isDisplayed()) {
							demoButtons.get(i)
									.findElement(By
											.cssSelector("a[class='button accent-button cardflip focus-element-flag']"))
									.click();
							break;
						}

					}
				}
			}
		} catch (Exception e) {
			throw new Exception("ClickonDemoButton", e);
		}
		logger.info("unable to click demo button ");

	}
	
	/**
	 * method used
	 * Verify demo popup details
	 */
	public boolean verifyDemoButtonpopup() throws Exception {
		logger.info("verifyDemoButtonpopup Start");
		boolean flag=false;
		try {
			List<WebElement> popupheader = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.demo.popup.header.loc"));
			List<WebElement> popverbiages=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.demo.popup.verbiage.loc"));
			List<WebElement> buttons=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.demo.popup.button.loc"));
			
				if(popupheader.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.Demo.popup.header.name")))
				{
					if(popverbiages.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.Demo.popup.verbiage1"))
							&& popverbiages.get(1).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.Demo.popup.verbiage2")))
					{
						if(buttons.get(0).getText().equalsIgnoreCase("CANCEL")
								&& buttons.get(1).getText().equalsIgnoreCase("YES, CONTINUE")){
							flag=true;
						}
					}
					
				}			
						
		}catch (Exception e) {
			throw new Exception("verifyDemoButtonpopup", e);
		}
		logger.info("verifyDemoButtonpopup flag --> " + flag);
		return flag;
	}
	/**
	 * method used
	 * Verify demo button color
	 */
	public boolean verifyDemoButtonColor(String locator,String colorHexcode,String cssAttribute) throws Exception {
		logger.info("verifydemobuttoncolor Start");
		boolean flag=false;
		try {
			List<WebElement> demoButtons = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(demoButtons)){
			for (int i = 0; i < demoButtons.size(); i++) {
				if(demoButtons.get(i).isDisplayed()){
					String color = demoButtons.get(i).getCssValue(cssAttribute);
					String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");                           
					hexValue[0] = hexValue[0].trim();
					int hexValue1 = Integer.parseInt(hexValue[0]);                   
					hexValue[1] = hexValue[1].trim();
					int hexValue2 = Integer.parseInt(hexValue[1]);                   
					hexValue[2] = hexValue[2].trim();
					int hexValue3 = Integer.parseInt(hexValue[2]);                   
					String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
					if(actualColor.equalsIgnoreCase(colorHexcode)){
						flag=true;
						break;
					}
					
				 }
				
			   }
			}
		}catch (Exception e) {
			throw new Exception("verifyDemoButtonColor", e);
		}
		logger.info("verifyDemoButtonColor flag --> " + flag);
		return flag;
	}
	
	/**
	 * method used
	 * Verify disabled demo products
	 */
	public boolean verifyDisabledDemoProducts(String tutorialName) throws Exception {
		logger.info("verifyDisabledDemoProducts Start");
		boolean flag = false;
		try {
			List<WebElement> DisabledProducts = baseHandler.findElements(".disabled-background-tab2");
			for (int i = 0; i < DisabledProducts.size(); i++) {
				if(DisabledProducts.get(i).findElement(By.cssSelector(".disabled-background-tab2 section")).getText().equals(tutorialName))
				{
					if(DisabledProducts.get(i).findElement(By.cssSelector(".disabled-background-tab2 nav div span:nth-child(4)")).getText()
							.equalsIgnoreCase(PropertiesRepository.getString("new.atitesting.disabled.demo.product.cardfront.msg")))
					{
						flag= true;
						break;
					}
				}			
			}			
		}catch (Exception e) {
			throw new Exception("verifyDisabledDemoProducts", e);
		}
		logger.info("verifyDisabledDemoProducts flag --> " + flag);
		return flag;
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */	
	public boolean verifyAllTabsDisplayed( ) throws Exception {
		logger.info("verifyAllTabsDisplayed Start");
		boolean flag = false;
		try {
			if( (baseHandler.findElement("#LearnTabNav").isDisplayed()) && (baseHandler.findElement("#TestTabNav").isDisplayed()) && 
					(baseHandler.findElement("#ImproveTabNav").isDisplayed()) && (baseHandler.findElement("#ImproveTabNav").isDisplayed())
					&& (baseHandler.findElement("#ImproveTabNav").isDisplayed()))
			{
					{
						flag= true;	
					}
			}		
		}catch (Exception e) {
			throw new Exception("verifyAllTabsDisplayed", e);
		}
		logger.info("verifyAllTabsDisplayed flag --> " + flag);
		return flag;
	}

	/**
	 * method used
	 * verify speedometer color on cardback
	 * for module by giving index
	 */
	public boolean verifyspeedometercolor(String locator,String colorHexcode,String cssAttribute,int index) throws Exception {
		logger.info("verifydemobuttoncolor Start");
		boolean flag=false;
		try {
			List<WebElement> speedometer = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(speedometer)){
				if(speedometer.get(index).isDisplayed()){
					String color = speedometer.get(index).getCssValue(cssAttribute);
					String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");                           
					hexValue[0] = hexValue[0].trim();
					int hexValue1 = Integer.parseInt(hexValue[0]);                   
					hexValue[1] = hexValue[1].trim();
					int hexValue2 = Integer.parseInt(hexValue[1]);                   
					hexValue[2] = hexValue[2].trim();
					int hexValue3 = Integer.parseInt(hexValue[2]);                   
					String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
					if(actualColor.equalsIgnoreCase(colorHexcode)){
						flag=true;
						
					}
					
				 }
				
			   }
			
		}catch (Exception e) {
			throw new Exception("verifyDemoButtonColor", e);
		}
		logger.info("verifyDemoButtonColor flag --> " + flag);
		return flag;
	}
	

	/**
	 * method used
	 * verify Demo button popup 2
	 * for module by giving index
	 */
	public boolean verifyDemoButtonpopup2() throws Exception {
		logger.info("verifyDemoButtonpopup2 Start");
		boolean flag=false;
		try {
			List<WebElement> popverbiages=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.demo.popup2.verbiage.loc"));
			if(CollectionUtils.isNotEmpty(popverbiages)){
					if(popverbiages.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.Demo.popup2.verbiage1"))
							&& popverbiages.get(1).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.Demo.popup2.verbiage2")))
					{
						flag=true;
					}
					
				}			
						
		}catch (Exception e) {
			throw new Exception("verifyDemoButtonpopup2", e);
		}
		logger.info("verifyDemoButtonpopup2 flag --> " + flag);
		return flag;
	}
}
