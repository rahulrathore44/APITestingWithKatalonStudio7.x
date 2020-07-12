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

'Generate Random Value for local variable'
test_id = (int)(Math.random() * 100)


'Send the request and capture the response'
ResponseObject response = WS.sendRequest(findTestObject('PostRequest/PostRequest - DynamicData', [('uniq_id') : test_id]))

'Added the assertion on status code'
Assertions.assertThat(response.getStatusCode()).isEqualTo(200)

'Parse the json response'
JsonSlurper parser = new JsonSlurper()
def responseAfterParsing = parser.parseText(response.getResponseBodyContent())

'Print the response at console'
println response.getResponseBodyContent()

'Extract the id property'
def actualId = responseAfterParsing.Id

'Assertion for the response'
Assertions.assertThat(actualId).isEqualTo(test_id)










