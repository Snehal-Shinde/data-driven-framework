package com.w2a.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    /*
    * WebDriver
    * Properties
    * Logs
    * ExtentReports
    * DB
    * Excel
    * Mail
    */

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;

    @BeforeSuite
    public void setUp() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
        config.load(fis);
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
        OR.load(fis);

        if(driver == null){
            if(config.getProperty("browser").equals("chrome")){

            } else if(config.getProperty("browser").equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", "gecko.exe");
                driver = new FirefoxDriver();
            }
        }
    }

    @AfterSuite
    public void tearDown(){

    }
}
