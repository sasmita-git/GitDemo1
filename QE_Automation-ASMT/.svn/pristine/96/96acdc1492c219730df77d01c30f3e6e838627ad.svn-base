package com.automation.asmt.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class QuestionTypePage extends MyATIPage {

	private Logger logger = LogManager.getLogger(this.getClass());

	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	private boolean flag;
	
	public QuestionTypePage(WebDriver webDriver) {
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	
	/**
	 * This method is used to identify the presence of disabled submit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFillForm(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillForm :::::::: start ");
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			List<WebElement> element = baseHandler
					.findElements("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question",
					e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillForm End --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to identify the presence of disabled submit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFillFormWithClear(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillFormWithClear :::::::: start ");
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			List<WebElement> element = baseHandler
					.findElements(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-not-empty");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).clear();
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question verifyFillFormWithClear",
					e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillFormWithClear End --> " + flag);
		return flag;
	}
	
	
	/**
	 * This method is used to identify the presence of disabled submit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFillFormMaxValue(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillForm :::::::: start ");
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			List<WebElement> element = baseHandler
					.findElements("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				List<WebElement> txtElement = baseHandler.findElements(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
				if(CollectionUtils.isNotEmpty(txtElement)) {
					String txtValue = txtElement.get(0).getText();
					if(StringUtils.isNotBlank(txtValue) && txtValue.length() == 20) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question",
					e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillForm End --> " + flag);
		return flag;
	}
	
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifyDragAndDropAnswer() throws Exception {
		logger.info("DragAndDropAnswer Start");
		boolean flag = false;
		try {
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if(tot == 0) {
				flag = true;
			}
		}
		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
		return flag;
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswer(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerOutside(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerOutside Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							//WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							WebElement toElement = baseHandler.findElement("footer[class='product-screen-footer'] #moveNext");
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer for DragAndDropAnswerOutside", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswerOutside End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerReverse(boolean stop) throws Exception {
		//logger.info("DragAndDropAnswerReverse Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			//int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			int tot = baseHandler.findElements("#DropZoneTwo li[class='draggable-option draggable ng-scope focus-element-flag']").size();
			
			//if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))) {
				//while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
				int dragDropOneSize = 0;
				List<WebElement> dragDropOne = baseHandler.findElements("#DropZoneOne li[class='draggable-option draggable ng-scope focus-element-flag']");
				if(CollectionUtils.isNotEmpty(dragDropOne) ) {
					if(dragDropOne.size() == 0) {
						dragDropOneSize = 0;
					} else {
						dragDropOneSize = dragDropOne.size();
					}
				} else {
					dragDropOneSize = 0;
				}
				while (dragDropOneSize != tot) {	
					if (breakflag) {
						break;
					}
					//List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					List<WebElement> btn = baseHandler.findElements("#DropZoneTwo li[class='draggable-option draggable ng-scope focus-element-flag']");
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							//WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							//buttonHandler.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							buttonHandler.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswerReverse End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean DragAndDropPrevFun(boolean stop) throws Exception {
		logger.info("DragAndDropPrevFun Start");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						flag = true;
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to DragAndDropPrevFun", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropPrevFun End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean DragAndDropAnswerPartialMove(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerPartialMove Start");
		boolean flag = false;
		boolean countFlag = false;
		boolean partialFlag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;
			switchToAssessmentFrameHandler();
			
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			int answerTotal = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if(tot == 4 && answerTotal == 0) {
				countFlag = true; } else {
				logger.info("Size of Question Drag and Drag is not 4");
				logger.info("Size of Anser Drag and Drag is not 0");
			}
			
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						List<WebElement> dropZoneOne = baseHandler.findElements("#DropZoneOne li");
						List<WebElement> dropZoneTwo = baseHandler.findElements("#DropZoneTwo li");
						if(i > 0 && CollectionUtils.isNotEmpty(dropZoneOne) && CollectionUtils.isNotEmpty(dropZoneTwo) && dropZoneOne.size() == 3 && dropZoneTwo.size() == 2) {
							breakflag = true;
							partialFlag = true;
						} /*else {
							logger.info("Partial move between question and answer drag and drop is not moved properlysss");
						}*/
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		if(countFlag && partialFlag) {
			flag = true;
		}
		logger.info("Method:  DragAndDropAnswerPartialMove End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean DragAndDropAnswerSection(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerSection Start");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);

			List<String> beforeReOrder = new ArrayList<String>();
			List<String> afterReOrder = new ArrayList<String>();
			
			switchToAssessmentFrameHandler();
			List<WebElement> answerDDElement = baseHandler.findElements("#DropZoneTwo li");
			if(CollectionUtils.isNotEmpty(answerDDElement) && answerDDElement.size() == 4) {
				// Getting list name before reordering
				List<WebElement> dropZoneTwoDDList = baseHandler.findElements("#DropZoneTwo li");
				if(CollectionUtils.isNotEmpty(dropZoneTwoDDList)) {
					for(WebElement eachElement : dropZoneTwoDDList) {
						beforeReOrder.add(eachElement.getAttribute("id"));
					}
				}
				
				// Reordering Answer List
				WebElement thirdElement = answerDDElement.get(2);
				WebElement secondElement = answerDDElement.get(1);
				
				org.openqa.selenium.interactions.Action reOrder = act
						.clickAndHold(thirdElement)
						.moveToElement(secondElement)
						.release(secondElement).build();
				
				buttonHandler
				.clickButton(PropertiesRepository
						.getString("asmt.generic.tutorial.dragbox2.loc"));
				reOrder.perform();
				
				// Getting list name After reordering
				List<WebElement> afterReorder = baseHandler.findElements("#DropZoneTwo li");
				if(CollectionUtils.isNotEmpty(afterReorder)) {
					for(WebElement eachElement : afterReorder) {
						afterReOrder.add(eachElement.getAttribute("id"));
					}
				}
				
				// Verifying values after reordering. 
				if(beforeReOrder.get(2).equalsIgnoreCase(afterReOrder.get(1))) {
					flag = true;
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswerSection End --> flag" + flag);
		return flag;
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerForwardContinue(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerForwardContinue Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
					if(btn.size() == 0) {
						tot = 4;
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer");

		}
		logger.info("Method:  DragAndDropAnswerForwardContinue End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerForward(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerForward Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler
					.findElement(
							PropertiesRepository
									.getString("asmt.generic.tutorial.dragbox1.loc"))
					.findElements(
							By.cssSelector(PropertiesRepository
									.getString("asmt.generic.dragamddrop.loc")))
					.size();
			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler
						.findElement(
								PropertiesRepository
										.getString("asmt.generic.tutorial.dragbox2.loc"))
						.findElements(
								By.cssSelector(PropertiesRepository
										.getString("asmt.generic.dragamddrop.loc")))
						.size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox1.loc"))
							.findElements(
									By.cssSelector(PropertiesRepository
											.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler
									.findElement(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							List<WebElement> toCount = baseHandler.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.dragbox2.loc"));
							List<WebElement> toDragAndDropCount = toCount.get(0).findElements(
									By.cssSelector(PropertiesRepository
											.getString("asmt.generic.dragamddrop.loc")));
							if(CollectionUtils.isNotEmpty(toDragAndDropCount) && toDragAndDropCount.size() == 3) {
								stop = true;
							}
							if (stop) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}

				}
			}
		}
		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer");

		}
		logger.info("Method:  DragAndDropAnswerForward End --> ");
	}

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestion() throws Exception {
		try {
			logger.info("Method : hotSpotQuestion :::::::: start ");
			flag = false;
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.question.new.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository
						.getString("asmt.question.new.img.answer.loc"));
				//buttonHandler.clickButton("#polygon3");
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestionNextPolygon() throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : hotSpotQuestion :::::::: start ");
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.question.new.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository
						.getString("asmt.question.next.img.answer.loc"));
				//buttonHandler.clickButton("#polygon3");
				flag = true;
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}
	
	public void clickAssessmemtType() throws Exception {
		switchToAssessmentFrameHandler();
		List<WebElement> checkBoxElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
		List<WebElement> hotSpotElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.question.img.loc"));				
		List<WebElement> inputBoxOption = baseHandler.findElements(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
		List<WebElement> dragNDrop = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"));
		
		if (CollectionUtils.isNotEmpty(checkBoxElement)
				&& checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
		} else 	if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking Flag if it has Hot Spot Image
			hotSpotQuestion();
		} else if (CollectionUtils.isNotEmpty(radioElement)
				&& radioElement.size() > 0) {
			radioElement.get(0).click();
		} else if(CollectionUtils.isNotEmpty(inputBoxOption)) {
			verifyFillForm("10");
		} else if(CollectionUtils.isNotEmpty(dragNDrop)) {
			DragAndDropAnswer(false);
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
		windowHandler.switchToLatestWindow();
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessment(boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					break;
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentVerifySection(boolean bool, boolean flagquestion, String complButtonName, String headerValue)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentVerifySection starts");
		boolean flagCompleted = false;
		boolean boolHeaderValue = false;
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}
			// Getting Header of Modal Window. 
			List<WebElement> headerMessage = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.teas.section.completed.window.header.loc"));
			if(CollectionUtils.isNotEmpty(headerMessage) && headerMessage.get(0).getText().trim().equalsIgnoreCase(headerValue)) {
				boolHeaderValue = true;
			}
			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flagCompleted = true;
							break;
						}
					}
				}

			if(boolHeaderValue && flagCompleted) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessmentVerifySection Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentVerifySection(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentVerifySection starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}
			
			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flag = true;
							break;
						}
					}
				}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessmentVerifySection Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean completePostAssessmentSurveySection(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("completePostAssessmentSurveySection starts");
		boolean boolButtonflag = false;
		boolean boolMsgFlag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}
			
			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							boolButtonflag = true;
							break;
						}
					}
					// Verifying Post Assessment Survey Message. 
					List<WebElement> messageElement = baseHandler.findElements(".dialog-sub-head");
					if(CollectionUtils.isNotEmpty(messageElement)) {
						String message = messageElement.get(1).getText().trim();
						if(StringUtils.isNotEmpty(message) && message.equalsIgnoreCase("Post assessment survey must be completed to receive results.")) {
							boolMsgFlag = true;
						}
					}
				}
			// Validating both button and message. 
			if(boolButtonflag && boolMsgFlag ) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to complete completePostAssessmentSurveySection", e);
		}
		logger.info("completePostAssessmentSurveySection Ends flag --> " + boolButtonflag);
		return boolButtonflag;
	}
	
	
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentVerifyAllSection(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentVerifyAllSection starts");
		boolean flag = false;
		boolean boolButtonNames = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}
			// Verifying button names in last section.
			boolButtonNames = verifyLastSectionButtonNames();
			
			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flag = true;
							break;
						}
					}
				}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		if(flag && boolButtonNames) {
			logger.info("Verifying all button names in last section ");
			flag = true;
		}
		logger.info("takeAssessmentVerifyAllSection Ends flag --> " + flag);
		
		return flag;
	}
	
	/**
	 * Method used to verify all button names in last section. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLastSectionButtonNames() throws Exception {
		logger.info("verifyLastSectionButtonNames Ends flag --> " + flag);
		boolean flag = false;
		boolean boolFinalize = false;
		boolean boolReview = false;
		boolean boolGoBack = false;
		
		try {
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				int size = assessmentCompleteElement.size();
				for(int intSize = 0; intSize < size; intSize++) {
					WebElement quizCompElement = assessmentCompleteElement.get(intSize);
					if(quizCompElement.getText().trim().contains("Finalize")) {
						boolFinalize = true;
					}
					if(quizCompElement.getText().trim().contains("Go Back")) {
						boolGoBack = true;
					}
					if(quizCompElement.getText().trim().contains("Review")) {
						boolReview = true;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyLastSectionButtonNames" );
			log(logger, "Unable to verifyLastSectionButtonNames" );
    		throw new DriverException("Unable to verifyLastSectionButtonNames" , e); 
    	}
		
		if(boolFinalize && boolReview && boolGoBack) {
			logger.info("Both Finalize, Go Back and Review buttons are view in Final Section ");
			flag = true;
		}
		
		logger.info("Method: verifyLastSectionButtonNames End flag --> " + flag);
		return flag;
	}
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentDNDFeature(boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					flag = true;
					break;
				}
			}
			if (flagquestion) {
				viewResultFlag();
			}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessment Ends flag --> "+ flag);
		return flag;
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentMouseHover(boolean boolMouseHover, boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentMouseHover starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// Verifying mouse hover feature
			if(boolMouseHover) {
				flag = verifyDisableElement();
			}
			
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					break;
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessmentMouseHover Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		return flag;
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentDisabledFlag(boolean boolMouseHover, boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentDisabledFlag starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// Verifying mouse hover feature
			if(boolMouseHover) {
				flag = verifyFlagDisabled();
			}
			
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					break;
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessmentDisabledFlag Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		return flag;
	}
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessment(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}
	
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean verifyAssessment(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		boolean flag = false;
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flag = true;
							break;
						}
					}
				}

			if (flagquestion) {
				viewResultFlag();
			}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessment Ends flag --> "+ flag);
		return flag;
	}
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentLastSection(boolean bool, boolean flagquestion, String complButtonName, int questionNo)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentLastSection starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			
			// Verifying Question count. 
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);
			if(questionNo + 1 == maxCount) {
				flag = true;
			}
			// Clicking on Continue Button. 
			
			switchToAssessmentFrameHandler();
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(buttonElement)) {
				if(buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if(!continueButtonElement.isEnabled()) {
							clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							clickAssessmemtType();
						}
					}
				}
			}
			
			// Click on view result button
			complButtonName = "Finalize and View Results";
			List<WebElement> assessmentCompleteElement2 = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement2)) {
					int size = assessmentCompleteElement2.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement2 = assessmentCompleteElement2.get(intSize);
						if(quizCompElement2.getText().trim().contains(complButtonName)) {
							quizCompElement2.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			
			if (flagquestion) {
				viewResultFlag();
			}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment for takeAssessmentLastSection", e);
		}
		logger.info("takeAssessmentLastSection Ends flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessmentEquals(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentEquals starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().equalsIgnoreCase(complButtonName)) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessmentEquals Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}
	
	public boolean completeDialogVerifier() throws Exception {
		logger.info("Method : completeDialogVerifier -->start");
		flag = false;
		try {
			if (baseHandler
					.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler
							.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler
							.findElement("#CompleteAssessmentDialog div .button.default-button") != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException(
					"Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : completeDialogVerifier -->end");
		return flag;

	}

	public boolean viewResultFlag() throws Exception {
		logger.info("Method : viewResultFlag -->start");
		flag = false;
		try {
			windowHandler.switchToModalDialog();
			if (baseHandler
					.findElement("#RevisitFlaggedQuestionDialog button[class='button default-button']") != null) {
				flag = true;
				baseHandler
						.findElement(
								"#RevisitFlaggedQuestionDialog button[class='button default-button']")
						.click();
				Thread.sleep(2000);
				// click on view result button
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
				// windowHandler.switchToModalDialog();
				Thread.sleep(2000);
				buttonHandler.clickButton(PropertiesRepository
						.getString("new-atitesting.test.view.resultsLoc"));
				// click on view result button
				Thread.sleep(2000);
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
				windowHandler.switchToModalDialog();
				buttonHandler
						.clickButton(PropertiesRepository
								.getString("new-atitesting.generic.contiunuetestcomplete.value"));
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException(
					"Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : viewResultFlag -->end");
		return flag;
	}
	
	/**
	 * Method used to verify whether element is disabled or not It will check
	 * only for radio button or check box. Not for other elements.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyDisableElement() throws Exception {
		logger.info("Method: verifyDisableElement Starts");
		boolean flag = false;
		try {
			List<WebElement> radioElement = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.radio.button.for.answer.loc"));
			// Verification for radio button - Start
			if (CollectionUtils.isNotEmpty(radioElement)
					& radioElement.size() > 0) {
				WebElement radioSingleElement = radioElement.get(0);
				String attributeName = radioSingleElement.findElement(
						By.cssSelector("input")).getAttribute("type");
				if (StringUtils.isNotEmpty(attributeName)
						&& "radio".equalsIgnoreCase(attributeName)) {
					List<WebElement> disabledElement = radioSingleElement
							.findElements(By.cssSelector("label"));
					if (CollectionUtils.isNotEmpty(disabledElement)
							&& disabledElement.size() > 0) {
						flag = true;
					}
				}
			}
			// Verification for radio button - End
		} catch (Exception e) {
			logger.info("Unable to verify Disable Element");
			log(logger, "Unable to verify Disable Element");
			throw new DriverException("Unable to verify Disable Element", e);
		}
		logger.info("Method: verifyDisableElement End flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to identify the presence of disabled flag button
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifyFlagDisabled() throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFlagDisabled :::::::: start ");
			
			switchToAssessmentFrameHandler();
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.generic.tutorial.flagdisabled.loc"));

			if (baseHandler.findElement(PropertiesRepository
					.getString("asmt.generic.tutorial.flagdisabled.loc")) != null) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFlagDisabled End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to verify the flag button in the assessment page. and
	 * click if click==true author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifyFlag(boolean click) throws Exception {

		logger.info("Method:  verifyFlag Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));

			
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.generic.tutorial.flag.value"));

			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.flag.value"))) {
				if (click) {
					waitUntillElementIsVisible(PropertiesRepository
							.getString("asmt.generic.tutorial.flag.value"));
					waitUntillLoadingImageIsDisplayed(2);
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.flag.value"))
							.click();
				}
				flag = true;
			}
			switchToAssessmentFrameHandler();
		} catch (Exception e) {
			logger.info("Unable to  verify Flag");
			throw new DriverException("Unable to verify Flag", e);
		}
		logger.info("Method:  verifyFlag End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;
	}
	
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerMovingPosition(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerMovingPosition Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;


			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i+1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);

									} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
				
				// moving position in Answer Box. 
				List<WebElement> answerMoveElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
				if(CollectionUtils.isNotEmpty(answerMoveElement)) {
					org.openqa.selenium.interactions.Action moveAction = act
							.clickAndHold(answerMoveElement.get(0))
							.moveToElement(answerMoveElement.get(3))
							.release(answerMoveElement.get(3)).build();
					buttonHandler
							.clickButton(PropertiesRepository
									.getString("asmt.generic.tutorial.dragbox2.loc"));
					org.openqa.selenium.interactions.Action dropAction = act
							.clickAndHold(answerMoveElement.get(0))
							.moveToElement(answerMoveElement.get(3))
							.release(answerMoveElement.get(3)).build();
					moveAction.perform();
					dropAction.perform();
				}
				
			}
		}
		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer");

		}
		logger.info("Method:  DragAndDropAnswerMovingPosition End --> ");
	}
	
	public boolean verifyExhibitButton(boolean boolClick) throws Exception {
		logger.info("Method: verifyExhibitButton Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.exhibit.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    			if(boolClick) {
    				element.get(0).click();
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyExhibitButton End flag --> " + flag);
    	return flag;
	}
	
	
}
