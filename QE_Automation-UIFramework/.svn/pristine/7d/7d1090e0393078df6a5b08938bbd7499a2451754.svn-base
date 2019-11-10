package com.ascendlearning.automation.ui.handlers;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.exceptions.DriverException;

public class DropDownHandler extends BaseHandler {
	
	public DropDownHandler(WebDriver driver) {
		super(driver);
	}
	
	public Select getDropDown(String selector) throws DriverException {
		Select dropDown = null;
		WebElement we = findElement(selector);
		if (we != null) {
			dropDown = new Select(we);
		} else {
			throw new DriverException("Unable to locate dropdown element using getDropDown(String selector)");
		}
		return dropDown;
	}
	
	public Select getDropDown(WebElement we) throws DriverException {
		Select dropDown = null;
		if (we != null) {
			dropDown = new Select(we);
		} else {
			throw new DriverException("Unable to locate dropdown element using getDropDown(WebElement we)");
		}
		return dropDown;
	}
	
	public List<WebElement> getOptions(WebElement we) throws DriverException {
		List<WebElement> element = null;
		Select dropDown = null;
		if(we != null) {
			dropDown = new Select(we);
			if(dropDown != null) {
				element = dropDown.getOptions();
			}
		} else {
			throw new DriverException("Unable to locate dropdown element in getOptions ");
		}
		return element;
	}
	
	public void selectByVisibleText(Select dropDown, String visibleTest, String...waitFor) throws DriverException {
		if (dropDown != null) {
			dropDown.selectByVisibleText(visibleTest.trim());
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new DriverException("Unable to locate dropdown element");
		}
	}
	
	public void selectByIndex(Select dropDown, int index, String...waitFor) throws DriverException {
		if (dropDown != null) {
			dropDown.selectByIndex(index);
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new DriverException("Unable to locate dropdown element");
		}
	}
	
	public void selectByValue(Select dropDown, String value, String...waitFor) throws DriverException {
		if (dropDown != null) {
			dropDown.selectByValue(value);
			if (waitFor != null && waitFor.length > 0) {
				setDriverWait(waitFor[0]);
			}
		} else {
			throw new DriverException("Unable to locate dropdown element");
		}
	}
}
