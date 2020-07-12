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
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent;

'Generate Random Value for local variable'
test_id = (int)(Math.random() * 100)

'Send the request and capture the response'
ResponseObject postResponse = WS.sendRequest(findTestObject('PostRequest/PostRequest - DynamicData', [('uniq_id') : test_id]))

'Assert for the status code'
Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(200)

'Create the body for put request'
def stringBody = "{" +
"\"BrandName\":\"Alienware\", " +
"\"Features\":{ " +
	"\"Feature\":[ " +
		"\"8th Generation Intel® Core™ i5-8300H\"," +
		"\"Windows 10 Home 64-bit English\","+
		"\"NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6\","+
		"\"8GB, 2x4GB, DDR4, 2666MHz\" ," +
		"\"One TB of Hard Drive\" " +
	"]" +
"}," +
"\"Id\":" + test_id + ", " +
"\"LaptopName\":\"Alienware M17\" " +
"}"


'Create the Put Request'
RequestObject putRequest = (RequestObject)findTestObject('Object Repository/PutRequest/PutRequest')


'Create the content'
HttpBodyContent content = new HttpTextBodyContent(stringBody)
putRequest.setBodyContent(content)

'Send the request'
ResponseObject putResponse = WS.sendRequest(putRequest)

'Assert for status code'
Assertions.assertThat(putResponse.getStatusCode()).isEqualTo(200)

'Print the response at console'
println putResponse.getResponseBodyContent()

'Parse the response'
JsonSlurper parser = new JsonSlurper()
def responseAfterPasrsing = parser.parseText(putResponse.getResponseBodyContent())

'Assert for the content'
Assertions.assertThat(responseAfterPasrsing.Features.Feature.size()).isEqualTo(5)



