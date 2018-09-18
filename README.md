# About phptravels

Demonstration of software testing automation using Selenium, TestNG and Java, by Eduardo Brusch

# Setup

-jdk 1.7

-maven 3.5 +;

-Selenium webdriver 3.14;

-Chrome 62 +.


# Running 

-After cloning the project, download the latest google driver, available at: https://chromedriver.storage.googleapis.com/index.html;

-Put the file chromedrive.exe into /src/main/resources;

-Open Windows command prompt and go to the project folder;

-Run maven to download all needed libraries "mvn clean compile";

-You can run the project using maven, through the command "mvn clean test";

-Alternatively, if you have the Tesng eclipse plugin, just create a new Run Configuration, running the test suite located in the resources folder.

-After running the test, it's possible to check out all the steps executed in the file ${basedir}/test-output/emailable-report.html, created by testNG.

-The steps can show also on the console. To get steps in the console output, please open the cfg.properties file and set "logtoConsole" to true. 
