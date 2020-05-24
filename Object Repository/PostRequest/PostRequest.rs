<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>PostRequest</name>
   <tag></tag>
   <elementGuidId>bb6ed3cc-646c-4164-99fc-eef6c4f64e23</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;BrandName\&quot;:\&quot;Alienware\&quot;,\n\t\&quot;Features\&quot;:{\n\t\t\&quot;Feature\&quot;:[\n\t\t\t\&quot;8th Generation Intel® Core™ i5-8300H\&quot;,\n\t\t\t\&quot;Windows 10 Home 64-bit English\&quot;,\n\t\t\t\&quot;NVIDIA® GeForce® GTX 1660 Ti 6GB GDDR6\&quot;,\n\t\t\t\&quot;8GB, 2x4GB, DDR4, 2666MHz\&quot;,\n          \t\&quot;16GB, 2x4GB, DDR4, 2666MHz\&quot;\n\t\t]\n\t},\n\t\&quot;Id\&quot;:5,\n\t\&quot;LaptopName\&quot;:\&quot;Alienware M17\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:8080/laptop-bag/webapi/api/add</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()



WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)
WS.verifyElementPropertyValue(response, 'Features.Feature[1]', 'Windows 10 Home 64-bit English')</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
