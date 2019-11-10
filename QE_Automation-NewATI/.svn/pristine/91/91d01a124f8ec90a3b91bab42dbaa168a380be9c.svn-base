package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class PaymentOnlinePage extends NewATIBasePage{

	private Logger logger = LogManager.getLogger(this.getClass());
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	private boolean flag = false;
	private DropDownHandler dropDownHandler;
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	
	public PaymentOnlinePage(WebDriver webDriver) {
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
		baseHandler= new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		textHandler = new TextHandler(driver);
	}
	
	/**
	 * Method used to click on Online Store Left Menu.
	 * 
	 * @throws Exception
	 */
	public void clickTEASOnlineProduct() throws Exception {
		logger.info("Method: clickTEASOnlineProduct Starts");
		try {
			windowHandler.switchToLatestWindow();
			baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.storeTextLoc"));
			buttonHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.online.store.teas.product.loc"));
		} catch (DriverException e) {
			logger.info("Unable to click TEAS Online Product ");
			throw new DriverException("Unable to click TEAS Online Product ", e);
		}
		logger.info("Method: clickTEASOnlineProduct End ");
	}
	
	/**
	 * Click on TEAS Product based on TEAS Product Name
	 * 
	 * @throws Exception
	 */
	public void clickTEASOnlinePracAssFormA(String teasProductName) throws Exception {
		logger.info("Method: clickTEASOnlinePracAssFormA Starts");
    	try {
    		List<WebElement> teasPracList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.online.store.all.teas.product.loc"));
    		if(CollectionUtils.isNotEmpty(teasPracList)) {
    			int size = teasPracList.size();
    			for(int index = 0;  index < size; index ++) {
    				if(teasProductName.equalsIgnoreCase(teasPracList.get(index).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.online.store.teas.product.teas.name.loc"))).getText())) {
    					teasPracList.get(index).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.online.store.teas.product.teas.add.to.cart.loc"))).click();
    					break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click TEAS Online Pra cAss Form A" );
    		throw new DriverException("Unable to click TEAS Online Pra cAss Form A" , e); 
    	}
    	logger.info("Method: clickTEASOnlinePracAssFormA End " );
	}
	
	/**
	 * Click on TEAS Product based on TEAS Product Name
	 * 
	 * @throws Exception
	 */
	public void clickPaymentTutorialOnline(String teasProductName) throws Exception {
		logger.info("Method: clickPaymentTutorialOnline Starts");
    	try {
    		List<WebElement> teasPracList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.online.store.all.teas.product.tutorial.loc"));
    		if(CollectionUtils.isNotEmpty(teasPracList)) {
    			int size = teasPracList.size();
    			for(int index = 0;  index < size; index ++) {
    				if(teasProductName.equalsIgnoreCase(teasPracList.get(index).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.online.store.teas.product.teas.name.loc"))).getText())) {
    					teasPracList.get(index).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.online.store.teas.product.teas.add.to.cart.loc"))).click();
    					break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Payment Tutorial Online" );
    		throw new DriverException("Unable to click Payment Tutorial Online" , e); 
    	}
    	logger.info("Method: clickPaymentTutorialOnline End " );
	}
	
	/**
	 * Method used to click check out button in Your Shopping Cart Page. 
	 *  
	 * @throws Exception
	 */
	public void clickYourShoppingCartCheckOutButton() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
    	try {
    		baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.store.your.shopping.cart.header.loc"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.your.shopping.cart.check.out.button.loc"), PropertiesRepository.getStringAsArray("new-atitesting.online.store.secure.checkout.header.loc"));
    	} catch (DriverException e) {
    		logger.info("Unable to verify Faculty User Product Tab " );
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: verifyFacultyProductTabAssessment End " );
	}
	
	/**
	 * Method used to click check out button in Your Shopping Cart Page. 
	 *  
	 * @throws Exception
	 */
	public void clickYourShoppingCartCheckOutButtonTEASTranscript() throws Exception {
		logger.info("Method: clickYourShoppingCartCheckOutButtonTEASTranscript Starts");
    	try {
    		baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.store.your.shopping.cart.header.loc"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.your.shopping.cart.check.out.button.loc"));
    	} catch (DriverException e) {
    		logger.info("Unable to click Your Shopping Cart Check Out Button TEAS Transcript " );
    		throw new DriverException("Unable to click Your Shopping Cart Check Out Button TEAS Transcript " , e); 
    	}
    	logger.info("Method: clickYourShoppingCartCheckOutButtonTEASTranscript End " );
	}

	/**
	 * Method used to click Proceed to Payment Details Button in Secure checkou page 
	 *  
	 * @throws Exception
	 */
	public void clickProceedToPaymentDetailsButtonInSecureCheckOutPage() throws Exception {
		logger.info("Method: clickProceedToPaymentDetailsButtonInSecureCheckOutPage Starts");
    	try {
    		baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.store.secure.checkout.header.loc"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.proceed.to.payment.details.button.loc"), PropertiesRepository.getStringAsArray("new-atitesting.online.store.secure.checkout.header.loc"));
    	} catch (DriverException e) {
    		logger.info("Unable to click Proceed To Payment Details Button In Secure Check Out Page" );
    		throw new DriverException("Unable to click Proceed To Payment Details Button In Secure Check Out Page" , e); 
    	}
    	logger.info("Method: clickProceedToPaymentDetailsButtonInSecureCheckOutPage End " );
	}
	
	
	/**
	 * @author Sagar.Rao
	 * This method is used to enter the credit card exp date
	 * @param input
	 * @throws DriverException
	 */
	public void enterCreditCardCvv(String input) throws DriverException{
		logger.info("Method: enterCreditCvv Starts");
		try{
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.creditcardCVVLoc"), input);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			
		}
		catch(Exception e){
			throw new DriverException("Unable to enter credit card exp date",e);
		}
		logger.info("Method: enterCreditCvv Ends");
	}
	
	/**
	 * Method is switch to BrainTree Frame
	 * 
	 */
	public void switchToBrainTree(){
		windowHandler.switchToMainWindow();
		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
		windowHandler.switchToFrame("braintree-dropin-frame");
	}
	
	/**
	 * Method to click on Check Agreement check box. 
	 * 
	 * @throws Exception
	 */
	public void checkAgreement() throws Exception {
		logger.info("Method: checkAgreement Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.check.agreement.loc"));
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		logger.info("Unable to check Agreement" );
    		throw new DriverException("Unable to check Agreement" , e); 
    	}
    	logger.info("Method: checkAgreement End " );
	}
	
	/**
	 * Method to click on Submit order button in Secure Checkout Page. 
	 * 
	 * @throws Exception
	 */
	public void clickSecureCheckOutSubmitOrder() throws Exception {
		logger.info("Method: clickSecureCheckOutSubmitOrder Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		windowHandler.switchToFrame(PropertiesRepository.getString("new-atitesting.online.store.payment.frame.name"));
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.submit.order.button.loc"), PropertiesRepository
					.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		logger.info("Unable to click Secure Check Out Submit Order" );
    		throw new DriverException("Unable to click Secure Check Out Submit Order" , e); 
    	}
    	logger.info("Method: clickSecureCheckOutSubmitOrder End " );
	}
	
	/**
	 * Method to verify Frozen Message for Payment Processing. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFrozenMessage() throws Exception {
		logger.info("Method: verifyFrozenMessage Starts");
    	try {
    		flag = false;
    		String frozenMessage = getText(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.frozen.message.loc"));
    		if(frozenMessage.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.frozen.message.value"))) {
    			flag = true;
    		}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Frozen Message");
    		throw new DriverException("Unable to verify Frozen Message" , e); 
    	}
    	logger.info("Method: verifyFrozenMessage End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method to verify Payment Success Message. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPaymentSuccessMessage() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
    	try {
    		flag = false;
    		baseHandler.waitToBeDisplayed(PropertiesRepository
					.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		String successMessage = getText(PropertiesRepository.getString("new-atitesting.online.store.receipt.page.header.loc"));
    		if(successMessage.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.online.store.receipt.page.header.message.value"))) {
    			flag = true;
    		}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Faculty User Product Tab ");
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: verifyFacultyProductTabAssessment End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method to close current window.
	 * 
	 * @throws Exception
	 */
	public void closeCurrentOnlinePaymentWindow(String mainWindowHandler) throws Exception {
		logger.info("Method: closeCurrentOnlinePaymentWindow Starts");
    	try {
    		for (String winHandle : driver.getWindowHandles()) {
    		    driver.switchTo().window(winHandle);
    		}
    		driver.close();
    		driver.switchTo().window(mainWindowHandler);
    	} catch (Exception e) {
    		logger.info("Unable to close Current Online Payment Window" );
    		log(logger, "Unable to close Current Online Payment Window" );
    		throw new DriverException("Unable to close Current Online Payment Window" , e); 
    	}
    	logger.info("Method: closeCurrentOnlinePaymentWindow End " );
	}
	
	/**
	 * Method used to select Program Type if it is not selected by default. 
	 * 
	 * @throws Exception
	 */
	public void selectProgramType() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
    	try {
    		List<WebElement> programTypeList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.program.type.loc"));
			if(CollectionUtils.isNotEmpty(programTypeList)) {
				Select programTypeSelect = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.online.store.secure.checkout.program.type.loc"));
	    		dropDownHandler.selectByVisibleText(programTypeSelect, "PN");
			} else {
				logger.info("Program Type DD is not available");
			}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Faculty User Product Tab " );
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: verifyFacultyProductTabAssessment End " );
	}
	
	public String getWindowHandler() throws Exception {
		return driver.getWindowHandle();
	}
	
	/**
	 * Method used to select first institution from list for TEAS Transcript. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void selectInstitutionFromForTEASTranscript() throws Exception {
		logger.info("Method: selectInstitutionFromForTEASTranscript Starts");
    	try {
    		Select programTypeSelect = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.online.store.teas.discover.transcript.institution.from.loc"));
    		programTypeSelect.selectByIndex(1);
    		
    	} catch (DriverException e) {
    		logger.info("Unable to select Institution From For TEAS Transcript" );
    		throw new DriverException("Unable to select Institution From For TEAS Transcript" , e); 
    	}
    	logger.info("Method: selectInstitutionFromForTEASTranscript End " );
	}
	
	/**
	 * Method used to click Right Arrow for TEAS Transcript
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickInsitutionRightArrow() throws Exception {
		logger.info("Method: clickInsitutionRightArrow Starts");
    	try {
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.teas.discover.transcript.institution.right.arrow.loc"));
    	} catch (Exception e) {
    		logger.info("Unable to click Insitution Right Arrow " );
    		throw new DriverException("Unable to click Insitution Right Arrow " , e); 
    	}
    	logger.info("Method: clickInsitutionRightArrow End " );
	}
	
	/**
	 * Method used to verify institution is selected from list for TEAS Transcript. 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyInstitutionToForTEASTranscript() throws Exception {
		logger.info("Method: verifyInstitutionToForTEASTranscript Starts");
		flag = false;
    	try {
    		//Select programTypeSelect = dropDownHandler.getDropDown(PropertiesRepository.getString("new-atitesting.online.store.teas.discover.transcript.institution.to.loc"));
    		Select programTypeSelect = dropDownHandler.getDropDown("#ctl00_MainContent_swplistboxInstitutions_lstRightList");
    		List<WebElement> toList = programTypeSelect.getOptions();
    		if(CollectionUtils.isNotEmpty(toList)) {
    			if(toList.size() == 1) {
    				flag = true;
    			}
    		}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Institution To For TEAS Transcript" );
    		throw new DriverException("Unable to verify Institution To For TEAS Transcript" , e); 
    	}
    	logger.info("Method: verifyInstitutionToForTEASTranscript End flag --> " + flag );
    	return flag;
	}
	
	/**
	 * Method used to click Continue button after selecting Institution for TEAS Trascript. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickTranscriptContinueButton() throws Exception {
		logger.info("Method: clickTranscriptContinueButton Starts");
    	try {
    		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.online.store.teas.discover.transcript.institution.continue.button.loc"));
    	} catch (Exception e) {
    		logger.info("Unable to click Transcript Continue Button" );
    		throw new DriverException("Unable to click Transcript Continue Button" , e); 
    	}
    	logger.info("Method: clickTranscriptContinueButton End " );
	}
}
