package com.katalon.plugin.keyword.waitforangular
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.paulhammant.ngwebdriver.NgWebDriver

public class WaitForAngularKeywords {

	/**
	 * Initialize NgWebDriver
	 *
	 */
	@Keyword
	public NgWebDriver initNgDriver() {
		WebDriver driver = DriverFactory.getWebDriver()
		return new NgWebDriver((JavascriptExecutor) driver)
	}

	/**
	 * Find Web element using By class
	 * @param by Locator created by By class
	 * @return a web element
	 */
	@Keyword
	public WebElement findWebElementBy(By by) {
		WebDriver driver = DriverFactory.getWebDriver()
		return driver.findElement(by)
	}

	/**
	 * Wait for the elements or requests in Angular application 
	 * until all the elements/request has been completed. 
	 * 	
	 */
	@Keyword
	def waitForAngularLoad() {
		try {
			//Get Web driver
			WebDriver driver = DriverFactory.getWebDriver()
			
			//Creating an instance of NgWebDriver
			NgWebDriver ngdriver = new NgWebDriver((JavascriptExecutor) driver)
			ngdriver.waitForAngularRequestsToFinish()
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Can't wait for Angular elements or requests to finish: " + e.message)
		}
	}
}
