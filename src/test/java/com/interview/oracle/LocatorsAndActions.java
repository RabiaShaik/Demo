package com.interview.oracle;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class LocatorsAndActions extends DriverFactory{


    @DataProvider(name = "validAuthentication")

    public static Object[][] credentials() {
        return new Object[][] { { "demo", "demo" },{"karthikrajesh","karthikrajesh"}};
    }

    public WebElement userName() throws Exception {
        return driver.findElement(By.name("userName"));
    }

    public WebElement password() throws Exception {
        return driver.findElement(By.name("password"));
   }

    public WebElement submitButton() throws Exception {
        return driver.findElement(By.name("login"));
    }

    public String pageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        return actualTitle;
    }

    public WebElement tripType() throws Exception{
        return driver.findElement(By.xpath("//input[@name='tripType' and @value='roundtrip']"));
    }

    public Select passengersCount() throws Exception{

        Select passCount = new Select(driver.findElement(By.name("passCount")));
        return passCount;
    }

    public Select departingFrom() throws Exception{

        Select fromPort = new Select(driver.findElement(By.name("fromPort")));
        return fromPort;
    }

    public Select departingMonth() throws Exception{

        Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
        return fromMonth;
    }

    public Select departingDate() throws Exception{

        Select fromDay = new Select(driver.findElement(By.name("fromDay")));
        return fromDay;
    }

    public Select arrivingTo() throws Exception{

        Select toPort = new Select(driver.findElement(By.name("toPort")));
        return toPort;
    }

    public Select returningMonth() throws Exception{

        Select toMonth = new Select(driver.findElement(By.name("toMonth")));
        return toMonth;
    }

    public Select returningDate() throws Exception{

        Select toDay = new Select(driver.findElement(By.name("toDay")));
        return toDay;
    }

    public WebElement travelClass() throws Exception{

        return driver.findElement(By.xpath("//input[@name='servClass' and @value='Business']"));
        }

    public Select airline() throws Exception{

        Select airline = new Select(driver.findElement(By.name("airline")));
        return airline;
    }

    public WebElement continueButton() throws Exception{

        return driver.findElement(By.name("findFlights"));
    }

    public String flightSearchPageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        return actualTitle;
    }

    public String page(){

        return driver.getPageSource();
    }

    public String flightActual(){

       WebElement flight =  driver.findElement(By.xpath("//input[@type='radio' and @value='Blue Skies Airlines$360$270$5:03']"));
      return  flight.getAttribute("value");

    }
}
