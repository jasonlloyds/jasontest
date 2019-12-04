$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com.xceptor.selenium.features/UITest/Test1.feature");
formatter.feature({
  "name": "Create a classic account",
  "description": "  As a customer\n  I should be able to create an account through lloydsbank website",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Create a current account using lloydsbank website",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CreateCurrentAccount"
    }
  ]
});
formatter.step({
  "name": "Customer launches the Lloyds Bank Website",
  "keyword": "Given "
});
formatter.step({
  "name": "Customer click \"\u003cProductType\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Customer choose \"\u003cAccountType\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Customer enter No in the existing customer page",
  "keyword": "When "
});
formatter.step({
  "name": "Customer click continue in the before you start page",
  "keyword": "When "
});
formatter.step({
  "name": "Customer will fill in all the details",
  "keyword": "And "
});
formatter.step({
  "name": "Customer will be able to create a new account",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "ProductType",
        "AccountType"
      ]
    },
    {
      "cells": [
        "Current Account",
        "Classic Account"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create a current account using lloydsbank website",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CreateCurrentAccount"
    }
  ]
});
formatter.step({
  "name": "Customer launches the Lloyds Bank Website",
  "keyword": "Given "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_launches_the_Lloyds_Bank_Website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer click \"Current Account\"",
  "keyword": "When "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_click(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer choose \"Classic Account\"",
  "keyword": "When "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_choose(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Customer enter No in the existing customer page",
  "keyword": "When "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_enter_No_in_the_existing_customer_page()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"(//span[text()\u003d\u0027No\u0027])[last()]\"}\n  (Session info: chrome\u003d78.0.3904.108)\n  (Driver info: chromedriver\u003d71.0.3578.33 (269aa0e3f0db08097f0fe231c7e6be200b6939f7),platform\u003dMac OS X 10.14.4 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.13.0\u0027, revision: \u00272f0d292\u0027, time: \u00272018-06-25T15:24:21.231Z\u0027\nSystem info: host: \u00278106373s-MacBook-Pro.local\u0027, ip: \u0027fe80:0:0:0:1c7b:22b5:4eb0:84d3%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.4\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 71.0.3578.33 (269aa0e3f0db0..., userDataDir: /var/folders/c4/q7jyhym56dx...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:63863}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 78.0.3904.108, webStorageEnabled: true}\nSession ID: d903a6104f7b382dc5fa4cfb7287e99b\n*** Element info: {Using\u003dxpath, value\u003d(//span[text()\u003d\u0027No\u0027])[last()]}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:424)\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy14.click(Unknown Source)\n\tat seleniumTest.pageObjects.ClassicAccount_applyNow_page.existingLloydsBankCustomer(ClassicAccount_applyNow_page.java:16)\n\tat seleniumTest.step_def.currenct_account_step_definition.customer_enter_No_in_the_existing_customer_page(currenct_account_step_definition.java:63)\n\tat ✽.Customer enter No in the existing customer page(src/test/resources/com.xceptor.selenium.features/UITest/Test1.feature:11)\n",
  "status": "failed"
});
formatter.step({
  "name": "Customer click continue in the before you start page",
  "keyword": "When "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_click_continue_in_the_before_you_start_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Customer will fill in all the details",
  "keyword": "And "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_will_fill_in_all_the_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Customer will be able to create a new account",
  "keyword": "Then "
});
formatter.match({
  "location": "currenct_account_step_definition.customer_will_be_able_to_create_a_new_account()"
});
formatter.result({
  "status": "skipped"
});
});