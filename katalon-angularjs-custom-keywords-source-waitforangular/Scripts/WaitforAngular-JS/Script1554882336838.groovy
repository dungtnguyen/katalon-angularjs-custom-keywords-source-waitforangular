import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.paulhammant.ngwebdriver.ByAngular
import com.paulhammant.ngwebdriver.NgWebDriver

WebUI.openBrowser('http://www.angularjshub.com/code/examples/forms/08_FormSubmission/index.demo.php')
//wait for angular load
CustomKeywords.'com.katalon.plugin.keyword.waitforangular.WaitForAngularKeywords.waitForAngularLoad'()

//find web element by angular
WebElement fn = CustomKeywords.'com.katalon.plugin.keyword.waitforangular.WaitForAngularKeywords.findWebElementBy'(ByAngular.model("person1.firstName"))
fn.sendKeys("Fred")

WebElement ln = CustomKeywords.'com.katalon.plugin.keyword.waitforangular.WaitForAngularKeywords.findWebElementBy'(ByAngular.model("person1.lastName"))
ln.sendKeys("Flintstone")

//initialize NgWebDriver and do somethings
WebDriver driver = DriverFactory.getWebDriver()
WebElement wholeForm = driver.findElement(By.xpath("//form[contains(@name,'personForm1')]"));
NgWebDriver ngModel = CustomKeywords.'com.katalon.plugin.keyword.waitforangular.WaitForAngularKeywords.initNgDriver'()

// change name via the $scope model
ngModel.mutate(wholeForm, "person1.firstName", "'Wilma'");

// retrieve the JSON for the location via the $scope model
String tv = ngModel.retrieveJson(wholeForm, "person1")
Assert.assertEquals(tv, "{\"firstName\":\"Wilma\",\"lastName\":\"Flintstone\"}")

// retrieve a single field as JSON
String v = ngModel.retrieveJson(wholeForm, "person1.firstName");
Assert.assertEquals(v, "\"Wilma\"")
