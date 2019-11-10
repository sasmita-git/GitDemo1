package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;

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
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.CheckboxHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage5 extends TutorialPage6 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	private CheckboxHandler checkBoxHandler;
	
	public TutorialPage5(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
		checkBoxHandler = new CheckboxHandler(driver);
	}

	public boolean verifyCalendarWeekNames() {
		List<Boolean> list=new ArrayList<Boolean>();
		String[] array = PropertiesRepository.getStringAsArray("new-atitesting.calendar.week.names");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.calendar.week.names.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for(int i=0;i<elements.size();i++)
				{
					list.add(array[i].equals(elements.get(i).getText()));
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		return list.contains(false)?false:true;
	}

	public boolean verifyCalendarWeeklyTable() {
		List<Boolean> list=new ArrayList<Boolean>();
		try {
			WebElement ele=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.week.days.header.loc"));
			String weekHeader=ele.getText().trim();
			
			WebElement previousEle=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.month.previous.loc"));
			previousEle.click();
			
			WebElement ele1=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.week.days.header.loc"));
			String weekHeader1=ele1.getText().trim();
			if(!weekHeader.equals(weekHeader1))
			{
				list.add(true);
			}
			else
			{
				list.add(false);
			}
			WebElement nextEle=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.month.next.loc"));
			nextEle.click();
			nextEle.click();
			WebElement ele2=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.week.days.header.loc"));
			String weekHeader3=ele2.getText().trim();
			if(!weekHeader.equals(weekHeader3))
			{
				list.add(true);
			}
			else
			{
				list.add(false);
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		return list.contains(false)?false:true;
		
	}
	
	public boolean verifyCalendarWeekHeaderNames() {
		List<Boolean> list=new ArrayList<Boolean>();
		String[] array = PropertiesRepository.getStringAsArray("new-atitesting.calendar.week.names");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.calendar.week.names"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for(int i=0;i<elements.size();i++)
				{
					list.add(array[i].equals(elements.get(i).getText().split(",")[0]));
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		return list.contains(false)?false:true;
	}

	public boolean  verifyAssignments() {
		logger.info("verifyAssignments Start ");
		try {
			
			List<WebElement> elements =baseHandler.findElements("#datepicker .ui-datepicker-title span");
			String monthAndYear=elements.get(0).getText()+" "+ elements.get(1).getText();			
			while(!monthAndYear.equalsIgnoreCase("December 2016"))
			{
				WebElement findElement = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.previous.month"));
				findElement.click();
				elements =baseHandler.findElements("#datepicker .ui-datepicker-title span");
				monthAndYear=elements.get(0).getText()+" "+ elements.get(1).getText();
			}			
			WebElement assignment = baseHandler.findElement(".ui-datepicker-week-end.calendar-event.focus-element-flag a");
			assignment.click();
			
			windowHandler.switchToModalDialog();
			
			List<WebElement> productNames = baseHandler.findElements("span[data-bind='text: LabelText']");
			for (WebElement webElement : productNames) {
				if(webElement.getText().trim().equalsIgnoreCase("Proctored Assessment") || webElement.getText().trim().equalsIgnoreCase("Practice Assessment") ||
						webElement.getText().trim().equalsIgnoreCase("Tutorial") ||webElement.getText().trim().equalsIgnoreCase("Flashcard")||
						webElement.getText().trim().equalsIgnoreCase("Quiz Bank") ||webElement.getText().trim().equalsIgnoreCase("Simulation"))
				{
					return true;
				}
				
			}
			
			
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		return false;
		
	}

	public boolean verifyNclexModuleName(String name) {
		try {
			WebElement moduleName = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.nclex.modules.name"));
			if(moduleName!=null && name.equalsIgnoreCase(moduleName.getText()))
			{
				return true;
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		return false;
	}

	public boolean verifyNCLXBoardLinkNames(String loc) {
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements) && "NCLEX Adaptive Test".equalsIgnoreCase(elements.get(0).getText()) &&
					"Test By Category".equalsIgnoreCase(elements.get(1).getText()) &&
							"Tests & Results".equalsIgnoreCase(elements.get(2).getText()))
							{
						return true;
							}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		return false;
	}
	
	public boolean verifySTTName() throws Exception {
		logger.info("Method: verifySTTName Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			if(element.get(1).getText().equalsIgnoreCase(PropertiesRepository
				.getString("new-atitesting.learntab.tutorial.153.assessment.name"))) {
    				if(element.get(3).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.module.name"))) {
    					flag = true;
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifySTTName");
			log(logger, "Unable to verifySTTName" );
    		throw new DriverException("Unable to verifySTTName" , e); 
    	}
    	logger.info("Method: verifySTTName End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyModuleStatus(String loc) {
		try {
			WebElement element = baseHandler.findElement(PropertiesRepository.getString(loc));
			if(element!=null && !element.getText().trim().isEmpty())
			{
				return true;
			}
		} catch (Exception e) {
		}
		
		return false;
	}

	public boolean verifyCardFrontHeader() {
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.nclextab.cardfront.header"));
		if(CollectionUtils.isNotEmpty(elements))
		{
			String header = elements.get(0).getText();
			if("Adaptive Test".equalsIgnoreCase(header))
			{
				return true;
			}
		}
		
		
		return false;
	}
	
	public boolean verifyTextFromList(String loc, String input,int index) {
		logger.info("verifyTextFromList Start");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if(CollectionUtils.isNotEmpty(elements))
			{
				String header = elements.get(index).getText();
				if(header!=null && input.equalsIgnoreCase(header))
				{
					return true;
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		return true;
	}

	public boolean verifyText(String loc, String input) {
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
		if(elements==null)
		{
			List<WebElement> element1 = baseHandler.findElements("section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container'] nav div div a span");
			String header = element1.get(0).getText();
			if("CONTINUE".equalsIgnoreCase(header))
			{
				return true;
			}
		}
		if(CollectionUtils.isNotEmpty(elements))
		{
			String header = elements.get(0).getText();
			if(input.equalsIgnoreCase(header))
			{
				return true;
			}
		}
		
		
		return false;
	}
	
	public String getTextFromLst(String loc,int size)
	{
		String name = null;
		logger.info("getTextFromList Start");
		try {
			List<WebElement> listOfElements = driver.findElements(By.cssSelector(PropertiesRepository
					.getString(loc)));
			name = listOfElements.get(size).getText().trim();
		} catch(Exception e) {
			logger.info("Error in getTextFromList ", e);
		}
		logger.info("getTextFromList End");
		
		return name;
	}
	
	/**
	 * Method is used to check hidden check box and click. 
	 * If text ends as Hidden, then click
	 * It text ends as Shown, don't click.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickHideCheckboxInTestTab() throws Exception {
		logger.info("Method: clickHideCheckboxInTestTab Starts");
    	try {
    		/*List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.checkbox.hidden.input.loc"));
    			if(CollectionUtils.isNotEmpty(element)) {
    				
    			}*/
    		if(checkBoxHandler.isCheckboxSelected(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.checkbox.hidden.input.loc"))) {
    			checkBoxHandler.selectCheckbox(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.checkbox.hidden.loc"));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Hide Checkbox In Test Tab " );
    		throw new DriverException("Unable to click Hide Checkbox In Test Tab " , e); 
    	}
    	logger.info("Method: clickHideCheckboxInTestTab End " );
	}
	
	/**
	 * Method is used to check hidden check box and click. 
	 * If text ends as Hidden, then click
	 * It text ends as Shown, don't click.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickHideCheckboxInLearnTab() throws Exception {
		logger.info("Method: clickHideCheckboxInLearnTab Starts");
    	try {
    		/*List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.checkbox.hidden.input.loc"));
    			if(CollectionUtils.isNotEmpty(element)) {
    				
    			}*/
    		if(checkBoxHandler.isCheckboxSelected("#tabs-1 .question-option.disabled-checkbox input")) {
    			checkBoxHandler.selectCheckbox("#tabs-1 .question-option.disabled-checkbox");
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Hide Checkbox In Learn Tab " );
    		throw new DriverException("Unable to click Hide Checkbox In Learn Tab " , e); 
    	}
    	logger.info("Method: clickHideCheckboxInLearnTab End " );
	}
	
	/**
	 * Method is used to verify hidden Assessment under My ATI Test Tab.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHideItemDisplayed() throws Exception {
		logger.info("Method: verifyHideItemDisplayed Starts");
		boolean flag = false;
    	try {
    		List<WebElement> hideAssessments = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.assessment.loc"));
    		if(CollectionUtils.isNotEmpty(hideAssessments)) {
    			if(hideAssessments.size() > 0) {
    				flag = true;
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Hide Item Displayed");
    		throw new DriverException("Unable to verify Hide Item Displayed" , e); 
    	}
    	logger.info("Method: verifyHideItemDisplayed End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify hidden Assessment under My ATI Test Tab.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHideItemDisplayed(String locator) throws Exception {
		logger.info("Method: verifyHideItemDisplayed Starts");
		boolean flag = false;
    	try {
    		List<WebElement> hideAssessments = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(hideAssessments)) {
    			if(hideAssessments.size() > 0) {
    				flag = true;
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Hide Item Displayed");
    		throw new DriverException("Unable to verify Hide Item Displayed" , e); 
    	}
    	logger.info("Method: verifyHideItemDisplayed End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to check hidden check box and click. 
	 * If text ends as Hidden, then click
	 * It text ends as Shown, don't click.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickHideCheckboxInTestTabWithoutChecking() throws Exception {
		logger.info("Method: clickHideCheckboxInTestTabWithoutChecking Starts");
    	try {
    		checkBoxHandler.selectCheckbox(PropertiesRepository.getString("new-atitesting.myatitab.testtab.hide.checkbox.hidden.loc"));
    	} catch (DriverException e) {
    		logger.info("Unable to click Hide Checkbox In Test Tab Without Checking " );
    		throw new DriverException("Unable to click Hide Checkbox In Test Tab Without Checking " , e); 
    	}
    	logger.info("Method: clickHideCheckboxInTestTabWithoutChecking End " );
	}
	
	/**
	 * Method is used to check hidden check box and click. 
	 * If text ends as Hidden, then click
	 * It text ends as Shown, don't click.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickHideCheckbox(String locator) throws Exception {
		logger.info("Method: clickHideCheckboxInTestTabWithoutChecking Starts");
    	try {
    		checkBoxHandler.selectCheckbox(locator);
    	} catch (DriverException e) {
    		logger.info("Unable to click Hide Checkbox In Test Tab Without Checking " );
    		throw new DriverException("Unable to click Hide Checkbox In Test Tab Without Checking " , e); 
    	}
    	logger.info("Method: clickHideCheckboxInTestTabWithoutChecking End " );
	}
	
	public boolean verifySelectInstance() throws Exception {
		logger.info("Method: verifySelectInstance Starts");
		boolean flag = false;
    	try {
    		
    		if(baseHandler.isDisplayed(baseHandler.findElement(".product-list-style.duplicate-list>li"))) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Select Instance");
    		throw new DriverException("Unable to verify Select Instance" , e); 
    	}
    	logger.info("Method: verifySelectInstance End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyTutorialSelectInstance() throws Exception {
		logger.info("Method: verifyTutorialSelectInstance Starts");
		boolean flag = false;
    	try {
    		
    		if(baseHandler.isDisplayed(baseHandler.findElement("#selectInstanceContainer ul"))) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Tutorial Select Instance");
    		throw new DriverException("Unable to verify Tutorial Select Instance" , e); 
    	}
    	logger.info("Method: verifyTutorialSelectInstance End flag --> " + flag);
    	return flag;
	}
	
	public boolean clickTutorialInfoIcon() throws Exception {
		logger.info("Method: clickModuleButtonByNameSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-1 ul[class='image-grid flipcontainer'] li");
			if (moduleList != null && moduleList.size() > 0) {
					WebElement element = moduleList.get(0);
					// Clicking on product icon. 
					if(element != null) {
						WebElement iconElement = element.findElement(By.cssSelector("header a[class='icon focus-element-flag']"));
						if(iconElement != null) {
							iconElement.click();
							// Product Information Popup verification.
							windowHandler.switchToLatestWindow();
							//List<WebElement> popupHeader = baseHandler.findElements("span[id='ui-id-7']");
							List<WebElement> popupHeader = baseHandler.findElements("#ui-id-7");
							if(CollectionUtils.isNotEmpty(popupHeader)) {
								String name = popupHeader.get(0).getText();
								if(StringUtils.isNotBlank(name) && name.equalsIgnoreCase("Product Information")) {
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//									driver.findElement(By.cssSelector(".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-icon-only.ui-dialog-titlebar-close.focus-element-flag.focus-on.ui-state-focus.ui-state-hover")).click();
//									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									//List<WebElement> popupCloseButton = baseHandler.findElements("div[aria-labelledby='ui-id-9'] button");
									List<WebElement> popupCloseButton = baseHandler.findElements(".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-icon-only.ui-dialog-titlebar-close.focus-element-flag.focus-on.ui-state-focus.ui-state-hover");
									if(CollectionUtils.isNotEmpty(popupCloseButton)) {
										popupCloseButton.get(0).click();
										
									}
									flag = true;
								}
							}
							
						}
					}
			}
					/*.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						element1.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.pharmacology.button.new.loc"))).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = verifySelectInstance();
						break;
					} */
		} catch(Exception e) {
			throw new Exception("clickModuleButtonByNameSelectInstance ", e);
		}
		logger.info("Method: clickModuleButtonByNameSelectInstance End flag-- > " + flag);
		return flag;
	}
	
	/**
	 * Method is used to click on first enabled pre or post test button in card
	 * 
	 * @author siddharth.roy
	 * @param cardBackButtonName
	 * @throws DriverException
	 */
	public boolean verifySkilsModuleName()
			throws Exception {
		logger.info("verifySkilsModuleName Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements("#productSkillsModulesModuleList .product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					flag = false;
					int value = index + 1;
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					String valueFromProperty = PropertiesRepository.getString("new-atitesting.learntab.skills.module.2.0.name."+String.valueOf(value));
					if(StringUtils.isNotBlank(skillsModuleName) && StringUtils.isNotBlank(valueFromProperty)) {
						if(skillsModuleName.equalsIgnoreCase(valueFromProperty) || skillsModuleName.contains(valueFromProperty)) {
						flag = true;
						}
						if(!flag) {
							flag = false;
							break;
						}
					}
				}
			}
		}
		catch (Exception e) {
			logger.info("Unable to click verifySkilsModuleName");
			throw new Exception("Unable to verifySkilsModuleName");
		}
		logger.info("Method: verifySkilsModuleName End --> " + flag);
		return flag;
	}

	public boolean verifyProctorPracticeModuleNames() throws Exception {
		logger.info("verifyProctorPracticeModuleNames start");
		try {
			List<WebElement> practiceAssessmentIcons = baseHandler.findElements("section[class='card practice-assessment front'] header a");
			List<WebElement> proctorAssessmentIcons = baseHandler.findElements("section[class='card proctored-assessment front'] header a");
			if(CollectionUtils.isNotEmpty(proctorAssessmentIcons) && CollectionUtils.isNotEmpty(proctorAssessmentIcons))
			{
				practiceAssessmentIcons.get(0).click();
				windowHandler.switchToModalDialog();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				//String text = baseHandler.findElement(".product-info-cell>div[data-bind='text: Name']").getText();
				clikButtonUsingJavaScript("div[aria-describedby='productInfoDialog'] div button");
				
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				proctorAssessmentIcons.get(0).click();
				windowHandler.switchToModalDialog();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				String text1 = baseHandler.findElement(".product-info-cell>div[data-bind='text: Name']").getText();
				clikButtonUsingJavaScript("div[aria-describedby='productInfoDialog'] div button");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				practiceAssessmentIcons.get(0).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				windowHandler.switchToModalDialog();
				String text2 = baseHandler.findElement(".product-info-cell>div[data-bind='text: Name']").getText();
				clikButtonUsingJavaScript("div[aria-describedby='productInfoDialog'] div button");
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				if(text1.equals(text2))
				{
					return false;
				}
			}
			
		}
		catch (Exception e) {
			logger.info("Unable to click information icon");
			throw new Exception("Unable to click information icon");
		}
		logger.info("verifyProctorPracticeModuleNames end");
		return true;
	}
	
	public boolean verifyDisabledMessage() throws Exception {
		logger.info("Method: verifyDisabledMessage Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements("#tabs-1 .disabled-background-tab2");
    		if(CollectionUtils.isEmpty(element)) {
    			checkBoxHandler.selectCheckbox("#tabs-1 .question-option.disabled-checkbox");
    			element = baseHandler.findElements("#tabs-1 .disabled-background-tab2");
    		}
    		if(CollectionUtils.isNotEmpty(element)) {
    			// Verifying Flashcard.
    			int size = element.size();
    			for(int index = 0; index < size; index ++ ) {
    				WebElement nameElement = element.get(index).findElement(By.cssSelector("header span"));
    				if(nameElement != null && StringUtils.isNotEmpty(nameElement.getText())) {
    					String name = nameElement.getText();
    					if(name.equalsIgnoreCase("Flashcards")) {
    						List<WebElement> disabledMessageElement = element.get(index).findElements(By.cssSelector("div nav div span[class='disabled-message']"));
    						if(CollectionUtils.isNotEmpty(disabledMessageElement)) {
    							if(disabledMessageElement.get(2).getText().equalsIgnoreCase("Semester Payment Required.")) {
    								flag = true;
    								break;
    							}
    						}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyDisabledMessage");
			log(logger, "Unable to verifyDisabledMessage" );
    		throw new DriverException("Unable to verifyDisabledMessage" , e); 
    	}
    	logger.info("Method: verifyDisabledMessage End flag --> " + flag);
    	return flag;
	}

	/**
	 * Method used to verify Semester Payment Required for Flash Card. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFlashCardSemesterPaymentRequiredMsg() throws Exception {
		logger.info("Method: verifyFlashCardSemesterPaymentRequiredMsg Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements("#tabs-1 ul li");
    		if(CollectionUtils.isNotEmpty(element)) {
    			WebElement flashCardDetails = element.get(0);
    			if(flashCardDetails != null) {
    				List<WebElement> semesterDetails = flashCardDetails.findElements(By.cssSelector("section div div[class='learn-card-front-wrapper default-container'] nav div span[class='disabled-message']"));
    				if(CollectionUtils.isNotEmpty(semesterDetails)) {
    					WebElement semesterElement = semesterDetails.get(2);
    					if(semesterElement != null) {
    						String semesterValue = semesterElement.getText().trim();
    						if(StringUtils.isNotBlank(semesterValue) && semesterValue.equalsIgnoreCase("Semester Payment Required.")) {
    							flag = true;
    						}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyFlashCardSemesterPaymentRequiredMsg");
			log(logger, "Unable to verifyFlashCardSemesterPaymentRequiredMsg" );
    		throw new DriverException("Unable to verifyFlashCardSemesterPaymentRequiredMsg" , e); 
    	}
    	logger.info("Method: verifyFlashCardSemesterPaymentRequiredMsg End flag --> " + flag);
    	return flag;
	}

	/**
	 * This method is used to identify footer objects when the page gets freezed
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFreezedPage() throws DriverException {
		logger.info("Method: verifyFreezedPage Starts");
		boolean flag = false;
		List<Boolean> list=new ArrayList<Boolean>();
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
			if(element!=null)
			element.click();
			windowHandler.switchToMainWindow();
			List<WebElement> webElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.assessment.footer.loc"));
			WebElement webElement1 = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.myati.assessment.footer.loc"));
			list.add(webElement1.isDisplayed());
			if(webElement!=null)
			{
				for(int i=0;i<3;i++)
				{
					if(!webElement.get(i).isDisplayed())
					{
						list.add(false);
					}
					else
					{
						list.add(true);
					}
					
				}
			}
			
		} catch (Exception e) {
			logger.info("Unable to verify Freezed Page");
			log(logger, "Unable to verify Freezed Page");
			throw new DriverException("Unable to verify Freezed Page", e);
		}
		logger.info("Method: verifyFreezedPage End flag --> " + flag);
		return list.contains(false)?false:true;

	}

	public boolean verifyProductSize(String loc) throws DriverException {
		logger.info("Method: verifyProductSize End");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (elements.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Product Size");
			log(logger, "Unable to verify Product Size");
			throw new DriverException("Unable to verify Product Size", e);
		}
		logger.info("Method: verifyProductSize End");
		return false;
	}

	public void takeOnlyFlaggedQuestions() throws DriverException {
		logger.info("Method: takeOnlyFlaggedQuestions End");
		try {
		buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
		
		String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1).getText();

		// Convert String to Integer
		int maxCount = Integer.parseInt(maxQtnTextNo);

		// Getting Current Question Number
		String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();

		// Convert String to Integer
		int minCount = Integer.parseInt(minQtnTextNo);

		// Maximum Question minus Minimum Questions
		int count = maxCount - minCount;

		for (int i = 0; i <= count; i++) {

			List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
			List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

			if (checkBoxElement != null) {
				checkBoxElement.get(0).click();
				checkBoxElement.get(1).click();
			}

			if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
				verifyFillForm("10");

			}

			if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
				DragAndDropAnswer(false);
			}

			if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
				radioElement.get(0).click();
			}

			if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
				hotSpotQuestion();
			}	
			
			if (i == count) 
			{
				clickButtonFromList("new-atitesting.learntab.tutorial.finalize.and.view.result2",2);
			}
			
			else 
			{
					driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext")).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		}
		}
		catch(Exception e)
		{
			logger.info("Unable to take the assessment" );
			log(logger, "Unable to take the assessment" );
			throw new DriverException("Unable to take the assessment" , e); 
		
		}
	}
	
	public void waitForAwhile(int milliSeconds)
	{
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
		}
	}
	
	public void hitTabButton(String loc) throws Exception
	{
		try {
			WebElement webElement = baseHandler.findElement(PropertiesRepository.getString(loc));
			webElement.sendKeys(Keys.TAB);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	/**
	 * Method used to verify Assessment Name. 
	 * 
	 * @param assessmentName
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyAssessmentName(String assessmentName) throws DriverException {
		//logger.info("verifyAssessmentName Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
			if(CollectionUtils.isNotEmpty(element)) {
				if(assessmentName.equalsIgnoreCase(element.get(1).getText())) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentName");
			log(logger, "Unable to verifyAssessmentName" );
    		throw new DriverException("Unable to verifyAssessmentName" , e);
		}
		logger.info("verifyAssessmentName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify flag time. 
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyAssessmentFlagTime() throws DriverException {
		logger.info("Method: verifyAssessmentFrameObjects Start");
		boolean flag = false;
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String currentFrame = (String) jsExecutor.executeScript("return self.name");
			if (!(currentFrame.equalsIgnoreCase("assessmentFrame"))) {
				windowHandler.switchToFrame("assessmentFrame");
			}			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> timeElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.Time.assessment.loc"));
			List<WebElement> flagElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.flag.assessment.loc.new"));
			if (CollectionUtils.isNotEmpty(timeElement) && CollectionUtils.isNotEmpty(flagElement)
					&& timeElement.get(0).isDisplayed() && flagElement.get(0).isDisplayed()) {
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

	/**
	 * Method is used to verify spedometer for specific assessmentName description
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerByDescName(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerByDescName Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));

					if (assessmentName.contains(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));

						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerByProductName End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerByDescName ", e);
		}
		logger.info("Method: VerifySpedometerByDescName End flag-- > " + flag);
		return flag;
	}

	/**
	 * Method is used to verify spedometer for specific assessmentName
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */

	public boolean VerifySpedometerByProductName(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerByProductName Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.product.name.loc")));
					if (assessmentName.equals(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));
						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerByProductName End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerByProductName ", e);
		}
		logger.info("Method: VerifySpedometerByProductName End flag-- > " + flag);
		return flag;
	}

	/**
	 * Method is used to verify spedometer for practice assessment
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerinPracticeTestTab(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerinPracticeTestTab Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.practice.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.product.testtab.name.loc")));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));
						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerinPracticeTestTab End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerinPracticeTestTab ", e);
		}
		logger.info("Method: VerifySpedometerinPracticeTestTab End flag-- > " + flag);
		return flag;
	}
	
	/**
	 * Method is used to verify if spedometer for practice assessment is
	 * displayed along with the numeric value
	 * 
	 * @author syed.pasha
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerWithValueinPracticeTestTab( ) throws Exception {
		logger.info("Method: VerifySpedometerWithValueinPracticeTestTab Start");
		boolean flag = true;
		try {
			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.modules.practice.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
						WebElement spedoMeter = moduleList.get(i).findElement(By.cssSelector((PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"))));
						WebElement spedoMeterValue = moduleList.get(i).findElement(By.cssSelector(".usage-overlay-50 div span"));						
						if (!(spedoMeter.isDisplayed() && spedoMeterValue.isDisplayed())) {
							flag = false;
							logger.info("Method: VerifySpedometerWithValueinPracticeTestTab End flag-- > " + flag);
							break;
						}					
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerWithValueinPracticeTestTab ", e);
		}
		logger.info("Method: VerifySpedometerWithValueinPracticeTestTab End flag-- > " + flag);
		return flag;
	}


	/**
	 * Method is used to verify spedometer for apply tab product
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerinApplyTab(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerinApplyTab Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.apply.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.product.testtab.name.loc")));
					if (assessmentName.contains(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));
						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerinApplyTab End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerinApplyTab ", e);
		}
		logger.info("Method: VerifySpedometerinApplyTab End flag-- > " + flag);
		return flag;
	}
	/**
	 * Method used to verify disabled functionality of Semester payment 
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyDisabledMessageSemesterPay() throws Exception {
		logger.info("Method: verifyDisabledMessageSemesterPay Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.disabled.products"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			for (int i = 0; i < element.size(); i++) {
    			String msg=element.get(i).findElement(By.cssSelector("[data-bind='visible: (!IsDemoProduct() && Tutorial.IsSemesterPaymentRequired())']")).getText();
    			
    			if(msg.equalsIgnoreCase("Semester Payment Required.")){
    				flag=true;
    				}
    			}
    			
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyDisabledMessage");
			log(logger, "Unable to verifyDisabledMessage" );
    		throw new DriverException("Unable to verifyDisabledMessage" , e); 
    	}
    	logger.info("Method: verifyDisabledMessageSemesterPay End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify disabled functionality of Semester payment with instances 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDisabledMessageSemesterPayInstances() throws Exception {
		logger.info("Method: verifyDisabledMessageSemesterPayInstances Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.disabled.products.instances"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			for (int i = 0; i < element.size(); i++) {
    			String msg=element.get(i).findElement(By.cssSelector("#selectInstanceContainerLearnTab > ul:nth-child(3) > li:nth-child(1) > section:nth-child(2) > div:nth-child(3) > span")).getText();
    			
    			if(msg.equalsIgnoreCase("Semester Payment Required.")){
    				flag=true;
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyDisabledMessage");
			log(logger, "Unable to verifyDisabledMessage" );
    		throw new DriverException("Unable to verifyDisabledMessage" , e); 
    	}
    	logger.info("Method: verifyDisabledMessageSemesterPayInstances End flag --> " + flag);
    	return flag;
	}
}


























