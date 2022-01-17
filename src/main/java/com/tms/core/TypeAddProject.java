package com.tms.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/*public class TypeAddProject {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public TypeAddProject() {
        this(ReadProperties.getType2Name();
    }

    public TypeAddProject(String type2Name) {
        switch (type2Name.toLowerCase()) {
            case "suite_mode_single":

                driverManagerType = ;
                WebDriverManager.getInstance(driverManagerType).setup();

                typeAddProject = TypeAddProject.
                WebDriverManager.getInstance(typeAddProject).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ReadProperties.isHeadless());
                chromeOptions.addArguments("--disable-gpu");
                //chromeOptions.addArguments("--window-size=1920,1200");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--silent");
                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "suite_mode_single_baseline":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver();
                break;

            case "suite_mode_multi":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();

                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Browser " + browserName + " is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}*/
