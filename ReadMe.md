**Project Name:** FlightFinderApplication

**Technologies used:** 

1.Selenium Webdriver 3.4.0
2.Java 8
3.TestNg 6.9.10
4.Maven

**Assumptions:**

This site which is taken for automation has many validation issues and hence while automating 
such factors are ignored

**example1:** There is no change in the flight display whichever from and to destinations are selected
**example2:** Even Feb 30th date can be selected
**example3:** Even if the user selects one way trip type the results shown are always for two ways

**Steps to run the project:**

1. git clone the project
2. Open the project in a terminal window
3. Execute mvn test
4. For output reports you can check the test-output folder

**Project Details:**

**DriverFactory:**

a.This is the BaseClass.
b.This class contains the methods to initiaise the webdriver.
c.This is where properties files are configured. An object of properties class is
present in this class so that it can be invoked from child classes and the data is parameterized
d.Also TestNG annotations like @BeforeMethod and @AfterMethod is made use before and after
webdriver initialization

**LocatorsAndActions:**

a.This class is inherited from DriverFactory
b.This is where Webelements and its actions are stored
c.It also contains two dimensional array objects where data are stored for login and this can be 
invoked by using @DataProvider annotations in test classes

**Test Classes**

`LoginTest:`

a. This test contains two methods one for valid login and another for invalid login
b. Valid login is using @DataProvider tags created in LocatorsAndActions class 
c. Invalid login is using @Parameters from testng.xml

`FlightFinderTest:`

a. This test contains three methods one for testingPage title and other two methods for testing flight searches
b. Config file properties are used to pass the values in the test
c. Login details for this method is useed from testng.xml


**Configs**

a. This is file created in src>main>java>com>interview>configs>config.properties
b. This file has the details of the following selections:

browser 
url
userName
password
passengersCount
departingFrom
departingMonth
departingDate
arrivingTo
returningMonth
returningDate
airline

All these parameters can be configured using this property file so that end user uses these tests
just by changing values in this file. This helps in easy maintenance of the tests.


