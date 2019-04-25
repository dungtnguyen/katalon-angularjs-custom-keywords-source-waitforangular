package com.katalon.plugin.keyword.waitforangular
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import com.paulhammant.ngwebdriver.ByAngular
import com.paulhammant.ngwebdriver.NgWebDriver


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


import internal.GlobalVariable

public class WaitForAngularKeywords {

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
