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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

'Generate Random Value for local variable'
test_id = (int)(Math.random() * 100)

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
"\"Id\":" + test_id + ", " +
"\"LaptopName\":\"Alienware M17\" " +
"}"

'Print the body'
println stringBody

'Send the Request and Capture the response'
ResponseObject response =  WS.sendRequest(findTestObject('PostRequest/PostRequest - DynamicBody', [('req_body') : stringBody]))


'Assert on the status code'
Assertions.assertThat(response.getStatusCode()).isEqualTo(200)


