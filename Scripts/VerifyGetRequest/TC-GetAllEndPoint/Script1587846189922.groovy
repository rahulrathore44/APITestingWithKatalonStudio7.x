import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.assertj.core.api.Assertions

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject

'Create the object of Request Object class'
def requestObject = new RequestObject("RequestObject")

'Create the header'
def header = new TestObjectProperty("Accept",ConditionType.EQUALS,"application/json")

'Add the header with request'
requestObject.setHttpHeaderProperties(Arrays.asList(header))

'Configure the Endpoint url'
requestObject.setRestUrl("http://localhost:8080/laptop-bag/webapi/api/all")

'Configure the type of Request'
requestObject.setRestRequestMethod("GET")

'Send the request'
def responseObject = WS.sendRequest(requestObject)

'verify the status code'
Assertions.assertThat(responseObject.getStatusCode()).isEqualTo(200)

//'Print the response body'
//println responseObject.getResponseText()

'Verify the Response content'
Assertions.assertThat(responseObject.getResponseText()).asString().contains("Alienware")

