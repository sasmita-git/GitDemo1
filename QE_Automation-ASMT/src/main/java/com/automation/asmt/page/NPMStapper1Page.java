package com.automation.asmt.page;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ascendlearning.automation.ui.handlers.BaseHandler;

public class NPMStapper1Page extends ASMTBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	
	public NPMStapper1Page(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
	}
	 

}
