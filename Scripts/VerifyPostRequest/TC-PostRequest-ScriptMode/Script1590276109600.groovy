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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpBodyType
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent;
import com.kms.katalon.core.testobject.impl.HttpFileBodyContent;

def stringBody = "{" +
	"\"BrandName\":\"Alienware\", " +
	"\"Features\":{ " +
		"\"Feature\":[ " +
			"\"8th Generation Intel® Core™ i5-8300H\"," +
			"\"Windows 10 Home 64-bit English\","+
			"\"NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6\","+
			"\"8GB, 2x4GB, DDR4, 2666MHz\" " +
		"]" +
	"}," + 
	"\"Id\":10, " +
	"\"LaptopName\":\"Alienware M17\" " +
"}"


'Create a Request Object'
def requestObject = new RequestObject("Post Request")

'Create the Header for Content type'
def contentType = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json")

'Create the Header for Accept'
def acceptHeader = new TestObjectProperty("Accept", ConditionType.EQUALS, "application/json")

'Add the header with the request'
requestObject.setHttpHeaderProperties(Arrays.asList(contentType,acceptHeader))

'Configure the End point url'
requestObject.setRestUrl("http://localhost:8080/laptop-bag/webapi/api/add")

'Configure the HTTP Method'
requestObject.setRestRequestMethod("POST")

'Configure the Body'
HttpBodyContent content = new HttpTextBodyContent(stringBody)
//HttpBodyContent content = new HttpFileBodyContent("C:\\Users\\rathr1\\Desktop\\PostRequestData.txt")
requestObject.setBodyContent(content)

'Send The Post Request'
def responseObject = WS.sendRequest(requestObject)

'Verify the status Code'
Assertions.assertThat(responseObject.getStatusCode()).isEqualTo(200)

'Verify the response content'
WS.verifyElementPropertyValue(responseObject, 'Id', "51")
WS.verifyElementPropertyValue(responseObject, 'Features.Feature[1]', "Windows 10 Home 64-bit English")













