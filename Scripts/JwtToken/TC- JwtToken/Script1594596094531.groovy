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

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

'Create the body for the request'
def stringBody = "{  \"password\": \"Guns and Bikes\",  \"username\": \"John Wick\"}"

'Send the request for registration'
ResponseObject postResponse = WS.sendRequest(findTestObject('PostRequest/PostRequest - Jwt', [('url') : GlobalVariable.reg_url, ('body') : stringBody]))

'Assert the status code'
Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(200)

'Send the request for auth and capture the response'
postResponse = WS.sendRequest(findTestObject('PostRequest/PostRequest - Jwt', [('url') : GlobalVariable.auth_url, ('body') : stringBody]))

'Assert the status code'
Assertions.assertThat(postResponse.getStatusCode()).isEqualTo(200)

'Extract the token'
JsonSlurper parser = new JsonSlurper()
def afterParsing = parser.parseText(postResponse.getResponseBodyContent());

'Print the token at console'
println postResponse.getResponseBodyContent()

'Send the request with jwt token'
ResponseObject getResponse = WS.sendRequest(findTestObject('GetRequest/GetRequest - Jwt', [('jwt_token') : afterParsing.token]))

'Assert on the status code'
 Assertions.assertThat(getResponse.getStatusCode()).isEqualTo(200)

