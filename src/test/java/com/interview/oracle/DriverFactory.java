package com.interview.oracle;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public static Properties prop;

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/interview/configs/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = prop.getProperty("browser");
        if(browser.toUpperCase().equals("CHROME")){
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        }
        switch (browser)
        {
            case "IE":
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver();
            case "FIREFOX":
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            default:
                ChromeDriverManager.getInstance().setup();
                return new ChromeDriver();
        }
    }

    @BeforeMethod
    public void initializeDriver(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/interview/configs/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = getDriver();
        driver.get(prop.getProperty("url"));

    }
    // Close the webDriver instance
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}