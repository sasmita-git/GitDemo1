package com.automation.asmt.page;

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
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class QuizBankPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;

	public QuizBankPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method is used to click Begin Quiz Button based on Module Name in Quiz Bank
	 * Card Back.
	 * 
	 * Begin Quiz
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean clickBeginQuizInCardBack(String quizName) throws Exception {
		logger.info("Method: clickBeginQuizInCardBack Starts ");
		boolean flag = false;
		try {
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.button.loc")))) {
				List<WebElement> allBeginQuizButtonLiElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.button.loc"));
				if (CollectionUtils.isNotEmpty(allBeginQuizButtonLiElement)) {
					int size = allBeginQuizButtonLiElement.size();
					for (int index = 0; index < size; index++) {
						String moduleNameFromUI = allBeginQuizButtonLiElement.get(index)
								.findElement(By.cssSelector(PropertiesRepository.getString(
										"new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.name.loc")))
								.getText();
						// Matching Module Name
						if (StringUtils.isNotEmpty(moduleNameFromUI)) {
							if (quizName.equalsIgnoreCase(moduleNameFromUI)) {
								if (CollectionUtils.isNotEmpty(allBeginQuizButtonLiElement)) {
									allBeginQuizButtonLiElement.get(index)
											.findElement(By.cssSelector(PropertiesRepository.getString(
													"new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.button.loc")))
											.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									flag = true;
									break;
								}
							}
						}

					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Begin Quiz In Card Back");
			throw new DriverException("Unable to click Begin Quiz In Card Back", e);
		}
		logger.info("Method: clickBeginQuizInCardBack End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Assessment name in Assessment page
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssesmentNameInAssessmentPage() throws Exception {
		logger.info("verifyAssesmentNameInAssessmentPage Start");
		boolean flag = false;
		try {
			baseHandler.waitToBeDisplayed(".lesson-header-details ul li span[data-atiid='assessmentTitle']");

			if (baseHandler.findElement(".lesson-header-details ul li span[data-atiid='assessmentTitle']") != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Assesment Name In Assessment Page");
			throw new DriverException("Unable to verify Assesment Name In Assessment Page", e);
		}
		logger.info("Method: verifyAssesmentNameInAssessmentPage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Quiz Assessment Show Hint Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentShowHintButton() throws Exception {
		logger.info("Method: verifyAssessmentShowHintButton Starts ");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("assessmentFrame");
			baseHandler
					.waitToBeDisplayed(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
			//switchToQuizFrame();
			if (baseHandler.isDisplayed(baseHandler.findElement(
					PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.button.loc1")))) {
				flag = true;
			}
			//windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Show Hint Button");
			throw new DriverException("Unable to verify Assessment Show Hint Button", e);
		}
		logger.info("Method: verifyAssessmentShowHintButton End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Quiz Assessment Show Hint Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAssessmentShowHintButton() throws Exception {
		logger.info("Method: clickAssessmentShowHintButton Starts");
		boolean flag = false;
		try {
			//windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
			//switchToQuizFrame();
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.button.loc1"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
			}
			//windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAssessmentShowHintButton");
			throw new DriverException("Unable to clickAssessmentShowHintButton", e);
		}
		logger.info("Method: clickAssessmentShowHintButton End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click glossary link and verify glossary heading for quiz bank.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyGlossaryLink() throws Exception {
		logger.info("Method : verifyGlossaryLink Start");
		boolean flag = false;
		try {
			switchToQuizFrame();
			// Clicking on Glossary link after clicking show hint button
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				// Verifying Glossary header.
				List<WebElement> glossaryElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.loc"));
				if (CollectionUtils.isNotEmpty(glossaryElement)) {
					if (glossaryElement.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"))) {
						flag = true;
						// Clicking on Close button.
						List<WebElement> glossaryCloseElement = baseHandler.findElements(
								PropertiesRepository.getString("asmt.quiz.show.hint.glossary.close.link.loc"));
						if (CollectionUtils.isNotEmpty(glossaryCloseElement)) {
							glossaryCloseElement.get(0).click();
						}
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyGlossaryLink");
			log(logger, "Unable to verifyGlossaryLink");
			throw new DriverException("Unable to verifyGlossaryLink", e);
		}
		logger.info("Method: verifyGlossaryLink End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click glossary link and verify glossary heading and content in glossary for quiz bank.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyGlossaryLinkAndContent() throws Exception {
		logger.info("Method : verifyGlossaryLinkAndContent Start");
		boolean flag = false;
		try {
			//switchToQuizFrame();
			// Clicking on Glossary link after clicking show hint button
			List<WebElement> element = baseHandler
					.findElements(/*PropertiesRepository.getString("asmt.quiz.show.hint.glossary.loc")*/"#highlightWordsText span[class='hint-glossary-word focus-element-flag']");
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				// Verifying Glossary header.
				List<WebElement> glossaryElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.loc"));
				if (CollectionUtils.isNotEmpty(glossaryElement)) {
					if (glossaryElement.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"))) {
						//windowHandler.switchToLatestWindow();
						windowHandler.switchToFrame("childDialogFrame");
						// Verifying Glossary Section. 
						List<WebElement> glossaryLeftSection = baseHandler.findElements(".glossary-nav-container");
						List<WebElement> glossaryRightSection = baseHandler.findElements(".glossary-main-content.ng-scope");
						if(CollectionUtils.isNotEmpty(glossaryLeftSection) && CollectionUtils.isNotEmpty(glossaryRightSection)) {
							flag = true;
						}
						windowHandler.switchToLatestWindow();
						// Clicking on Close button.
						List<WebElement> glossaryCloseElement = baseHandler.findElements(
								PropertiesRepository.getString("asmt.quiz.show.hint.glossary.close.link.loc"));
						if (CollectionUtils.isNotEmpty(glossaryCloseElement)) {
							glossaryCloseElement.get(0).click();
						}
						windowHandler.switchToLatestWindow();
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyGlossaryLinkAndContent");
			log(logger, "Unable to verifyGlossaryLinkAndContent");
			throw new DriverException("Unable to verifyGlossaryLinkAndContent", e);
		}
		logger.info("Method: verifyGlossaryLinkAndContent End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to switch to Assessment name Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void switchToQuizFrame() throws Exception {
		logger.info("switchToQuizFrame Start");
		try {
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Quiz Frame");
			throw new DriverException("Unable to switch To Quiz Frame", e);
		}
		logger.info("Method: switchToQuizFrame End ");
	}

	/**
	 * Method used to verify tools sections.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyToolsSection() throws Exception {
		logger.info("Method : verifyToolsSection Start");
		boolean flag = false;
		try {
			//switchToQuizFrame();
			// Button Locator
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("asmt.quiz.tools.button.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				// Tools Section 
				List<WebElement> toolsSectionElement = baseHandler.findElements(PropertiesRepository.getString("asmt.quiz.tools.sections.loc"));
				if(CollectionUtils.isNotEmpty(toolsSectionElement) && toolsSectionElement.size() == 3) {
					List<WebElement> glossaryName = toolsSectionElement.get(0).findElements(By.cssSelector("button div"));
					List<WebElement> calculation = toolsSectionElement.get(1).findElements(By.cssSelector("button div"));
					List<WebElement> criticalThinkingGuide = toolsSectionElement.get(2).findElements(By.cssSelector("button div"));
					if (glossaryName != null
							&& glossaryName.get(1).getText().trim().equalsIgnoreCase(
									PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"))
							&& calculation != null
							&& calculation.get(1).getText().trim().equalsIgnoreCase(
									PropertiesRepository.getString("asmt.quiz.show.hint.calculator.header.value"))
							&& criticalThinkingGuide != null
							&& criticalThinkingGuide.get(1).getText().trim().contains("Critical")) {
						flag = true;

					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyToolsSection ");
			log(logger, "Unable to verifyToolsSection ");
			throw new DriverException("Unable to verifyToolsSection ", e);
		}
		logger.info("Method: verifyToolsSection End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click glossary link and verify glossary heading and content Alignment in glossary for quiz bank.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifySelectedGlossaryContentAlignment() throws Exception {
		logger.info("Method : verifySelectedGlossaryContentAlignment");
		boolean flag = false;
		try {
			// Clicking on first Glossary in the Glossary list index
			switchToQuizFrame();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				List<WebElement> glossaryElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.loc"));
				if (CollectionUtils.isNotEmpty(glossaryElement)) {
					if (glossaryElement.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"))) {
						windowHandler.switchToLatestWindow();
						// Verifying Glossary Section.
						Thread.sleep(15000);

						windowHandler.switchToFrame("childDialogFrame");
						WebElement mouseAction = baseHandler.findElement("#PronunciationBtn");
						Thread.sleep(10000);
						mouseAction.click();

						// extracting the Glossary List from left pane and verifying the Glossary
						// contnet from right frame.
						List<WebElement> glossaryLeftSection = driver
								.findElements(By.cssSelector(".glossary-word.focus-element-flag>span"));
						if (CollectionUtils.isNotEmpty(glossaryLeftSection) && glossaryLeftSection.size() > 0) {
							WebElement firstGlossarySelection = glossaryLeftSection.get(0);
							firstGlossarySelection.click();
						}

						List<WebElement> glossaryRightSection = driver
								.findElements(By.cssSelector(".glossary-main-content.ng-scope"));
						if (CollectionUtils.isNotEmpty(glossaryLeftSection)
								&& CollectionUtils.isNotEmpty(glossaryRightSection)) {
							flag = true;
						}

						// Clicking on Close button.
						windowHandler.switchToLatestWindow();
						List<WebElement> glossaryCloseElement = baseHandler.findElements(
								PropertiesRepository.getString("asmt.quiz.show.hint.glossary.close.link.loc"));
						if (CollectionUtils.isNotEmpty(glossaryCloseElement)) {
							glossaryCloseElement.get(0).click();
						}
					}
				}
			}

			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyGlossaryLinkContentAlignment");
			log(logger, "Unable to verifyGlossaryLinkContentAlignment");
			throw new DriverException("Unable to verifySelectedGlossaryContentAlignment", e);
		}
		logger.info("Method: verifySelectedGlossaryContentAlignment End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on answer button for the given quiz and verify the Show Hint button behavior in answer validation page.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyDefaultShowHintButtonStatusOnAnsweredQuizPage() throws Exception {
		logger.info("Method : verifyDefaultShowHintButtonStatusOnAnsweredQuizPage");
		boolean flag = false;
		try {
			switchToQuizFrame();
			// Selecting first answer for the given Quiz and clicking on Next button to
			// verify the selected answer status and Show Hint button status
			List<WebElement> radioElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
			if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
				radioElement.get(0).click();
				
				WebElement submitAnswer = baseHandler
						.findElement(PropertiesRepository.getString("asmt.quiz.question.submit.answer.loc"));
				submitAnswer.click();

				List<WebElement> answerStatus = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.question.submit.answer.status.loc"));
				for (WebElement elem : answerStatus) {
					String answerStatusText = elem.getAttribute("style");

					if (answerStatusText.contains("block") || answerStatusText.contains("none")) {
						log(logger, "Verifying Assessment Show Hint Button");
						verifyAssessmentShowHintButton();
						flag = true;
						break;
					}
				}
			}
			windowHandler.switchToLatestWindow();
		}
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify DefaultShowHintButtonStatusOnAnsweredQuizPage");
			log(logger, "Unable to verify DefaultShowHintButtonStatusOnAnsweredQuizPage");
			throw new DriverException("Unable to verify DefaultShowHintButtonStatusOnAnsweredQuizPage", e);
		}
		logger.info("Method: VerifyDefaultShowHintButtonStatusOnAnsweredQuizPage End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify the status of Show
	 * Hint button and Highlighted contend in Quiz question .
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean VerifyHideAndHighlightButton() throws Exception {
		logger.info("Method : VerifyHideAndHighlightButton");
		boolean flag = false;
		try {
			// Clicking on first Glossary in the Glossary list index
			windowHandler.switchToLatestWindow();
			List<WebElement> hideHintButton = baseHandler
					.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.loc"));

			// verify the Show hit button status and highlighted content in for the given quiz question.
			switchToQuizFrame();
			List<WebElement> questionContentHighlight = driver
					.findElements(By.cssSelector(".hint-word.hint-highlight"));

			if (CollectionUtils.isNotEmpty(hideHintButton) && CollectionUtils.isNotEmpty(questionContentHighlight)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to VerifyHideAndHighlightButton");
			log(logger, "Unable to VerifyHideAndHighlightButton");
			throw new DriverException("Unable to VerifyHideAndHighlightButton",
					e);
		}
		logger.info("Method: VerifyHideAndHighlightButton End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify 
	 * Show Hint button behavior in answer page.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyHintButtonOnAnsweredPage() throws Exception {
		logger.info("Method : verifyHintButtonOnAnsweredPage");
		boolean flag = false;
		try {
			switchToQuizFrame();
			// Selecting first answer for the given Quiz and clicking on Next
			// button to
			// verify the selected answer status and Show Hint button status
			List<WebElement> radioElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
			if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
				radioElement.get(0).click();

				List<WebElement> submitAnswer = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.question.submit.answer.loc"));
				if(CollectionUtils.isNotEmpty(submitAnswer)) {
					submitAnswer.get(0).click();

					List<WebElement> answerStatus = baseHandler
							.findElements(PropertiesRepository.getString("asmt.quiz.question.submit.answer.status.loc"));
					for (WebElement elem : answerStatus) {
						String answerStatusText = elem.getAttribute("style");

						if (answerStatusText.contains("block") || answerStatusText.contains("none")) {
							log(logger, "Verifying Assessment Show Hint Button");
							verifyAssessmentShowHintButton();
							flag = true;
							break;
						}
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify verifyHintButtonOnAnsweredPage");
			log(logger, "Unable to verify verifyHintButtonOnAnsweredPage");
			throw new DriverException("Unable to verify verifyHintButtonOnAnsweredPage", e);
		}
		logger.info("Method: verifyHintButtonOnAnsweredPage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to check the glossary filtering functionality in Glossary popup window
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean VerifyAllGlossaryListIsDisplayedOnSelectedFilterTab() throws Exception {
		logger.info("Method : VerifyAllGlossaryListIsDisplayedOnSelectedFilterTab");
		boolean flag = false;
		try {
			// Clicking on first Glossary in the Glossary list index
			switchToQuizFrame();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				List<WebElement> glossaryElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.loc"));
				if (CollectionUtils.isNotEmpty(glossaryElement)) {
					if (glossaryElement.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("asmt.quiz.show.hint.glossary.header.value"))) {
						windowHandler.switchToLatestWindow();
						// Verifying Glossary Section.
						Thread.sleep(25000);

						windowHandler.switchToFrame("childDialogFrame");
						WebElement mouseAction = baseHandler.findElement("#PronunciationBtn");
						Thread.sleep(10000);
						mouseAction.click();

						// Finding the Glossary Filter list tab and selecting
						// the 'A-F' filter Tab
						List<WebElement> glossaryFilterTab = baseHandler.findElements(
								PropertiesRepository.getString("asmt.quiz.show.hint.glossary.filter.tabs.loc"));
						if (CollectionUtils.isNotEmpty(glossaryFilterTab)) {
							glossaryFilterTab.get(1).click();
							Thread.sleep(10000);

							try {
								List<WebElement> glossaryLeftSection = null;
								List<WebElement> glossaryLeftSectionelements = null;

								int countElements = 0;

								while (true) {
									glossaryLeftSection = driver
											.findElements(By.cssSelector(".glossary-word.focus-element-flag>span"));
									glossaryLeftSectionelements = driver
											.findElements(By.cssSelector(".glossary-nav-container > nav > ul"));

									if (countElements != glossaryLeftSectionelements.size()) {

										countElements = glossaryLeftSectionelements.size();

										((JavascriptExecutor) driver).executeScript(
												"arguments[0].scrollIntoView(true);",
												glossaryLeftSection.get(glossaryLeftSection.size() - 1));
										Thread.sleep(10000);

									} else if (countElements == glossaryLeftSectionelements.size()) {
										logger.info("Elements are displayed to scrool in the Left side Menu");
										WebElement lostGlossarySelection = glossaryLeftSection
												.get(glossaryLeftSection.size() - 1);
										lostGlossarySelection.click();
										flag = true;
										break;
									} else {
										logger.info("No Elements to scrool in the Left side Menu");
										flag = false;
										break;
									}
								}
							}

							catch (Exception e) {
								logger.info("Unable to verify left menu");
								log(logger, "Unable to verify left menu");
							}

							WebElement scroller = baseHandler.findElement(".glossary-nav-container");
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroller);
							Thread.sleep(500);
						}
					}
					// Clicking on Close button.
					windowHandler.switchToLatestWindow();
					List<WebElement> glossaryCloseElement = baseHandler.findElements(
							PropertiesRepository.getString("asmt.quiz.show.hint.glossary.close.link.loc"));
					if (CollectionUtils.isNotEmpty(glossaryCloseElement)) {
						glossaryCloseElement.get(0).click();
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyGlossaryLinkContentAlignment");
			log(logger, "Unable to verifyGlossaryLinkContentAlignment");
			throw new DriverException("Unable to verifySelectedGlossaryContentAlignment", e);
		}
		logger.info("Method: verifySelectedGlossaryContentAlignment End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify the Quiz multiple answers order position on
	 * question page and answer validation page.
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyAnswerChoicesAreNotScrambled() throws Exception {
		logger.info("Method : verifyAnswerChoicesAreNotScrambled");
		boolean flag = false;
		try {
			switchToQuizFrame();

			// verify question answers order on Quiz question page
			List<WebElement> quizAnswersOrder = baseHandler
					.findElements(PropertiesRepository.getString("asmt.generic.tutorial.quiz.answer.ordere.loc"));

			// Selecting first answer for the given Quiz and clicking on
			// Click on Next button for Answer validation

			List<WebElement> radioElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
			if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
				radioElement.get(0).click();

				WebElement submitAnswer = baseHandler
						.findElement(PropertiesRepository.getString("asmt.quiz.question.submit.answer.loc"));
				submitAnswer.click();

				windowHandler.switchToLatestWindow();
				switchToQuizFrame();

				// verify question answers order on Answer validation page
				List<WebElement> quizAnswersOrderInAnswerPage = baseHandler
						.findElements(PropertiesRepository.getString("asmt.generic.tutorial.quiz.answer.ordere.loc"));

				if (quizAnswersOrder.equals(quizAnswersOrderInAnswerPage)) {
					flag = true;
				} else {
					flag = false;
				}

			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify AnswerChoicesAreNotScrambled");
			log(logger, "Unable to verify verifyAnswerChoicesAreNotScrambled");
			throw new DriverException("Unable to verifyAnswerChoicesAreNotScrambled", e);
		}
		logger.info("Method: verifyAnswerChoicesAreNotScrambled End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify the Mouse right click option is disabled in Quiz question page.
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyMouseRightClickOnQuizQuestionPage() throws Exception {
		logger.info("Method : verifyMouseRightClickOnQuizQuestionPage");
		boolean flag = false;
		try {
			switchToQuizFrame();

			// verify question answers order on Quiz question page
			
			List<WebElement> radioElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
			if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
				WebElement mouseRightclick = baseHandler
						.findElement(PropertiesRepository.getString("asmt.quiz.question.righclick.disable.loc"));
	            String mouseRightClickExpected = "return false;";
	            logger.info("****"+mouseRightclick.getAttribute("oncontextmenu"));
				if (mouseRightClickExpected.equalsIgnoreCase(mouseRightclick.getAttribute("oncontextmenu"))) {		        
					flag = true;
				} else {
					flag = false;
				}

			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify verifyMouseRightClickOnQuizQuestionPage");
			log(logger, "Unable to verify verifyMouseRightClickOnQuizQuestionPage");
			throw new DriverException("Unable to verifyMouseRightClickOnQuizQuestionPage", e);
		}
		logger.info("Method: verifyMouseRightClickOnQuizQuestionPage End flag --> " + flag);
		return flag;
	}
	
	public void clickQuizModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickQuizModuleButtonByName Start ");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("asmt.Quiz.all.modules.loc"));

		try {
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						WebElement mainDivElement = element1.findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: $parent.HasMultipleLearningLoopItems']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",mainDivElement);
						if (mainDivElement != null) {
							List<WebElement> moduleButtons = mainDivElement.findElements(
									By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
							moduleButtons.get(0).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on module button");
		}
		logger.info("Method: clickQuizModuleButtonByName End");
	}
	
}
