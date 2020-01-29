package testbase;

import helpers.browser.BrowserType;
import helpers.browser.ChromeBrowser;
import helpers.browser.FireFoxBrowser;
import helpers.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    public WebDriver getBrowserObject(BrowserType browserType) {
        try {
            switch (browserType) {
                case Chrome:
                    // Create an object of Chrome browser
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance();
                    ChromeOptions chromeOptions = chrome.getChromeOptions();
                    return chrome.getChromeDriver(chromeOptions);
                case Firefox:
                    // Create an object of Firefox browser
                    FireFoxBrowser firefox = FireFoxBrowser.class.newInstance();
                    FirefoxOptions firefoxOptions = firefox.getFirefoxOptions();
                    return firefox.getFirefoxDriver(firefoxOptions);
                default:
                    throw new Exception("Driver not found " + browserType.name());
            }
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void setupDriver(BrowserType browserType) {
        driver = getBrowserObject(browserType);
        WaitHelper wait = new WaitHelper(driver);
        wait.setImplicitWait(PropertyReader.configReader.getImplicitWait(), TimeUnit.SECONDS);
        wait.setPageLoadTime(PropertyReader.configReader.getPageLoadTime(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void getApplicationURL(String URL) {
        driver.get(URL);
    }

    @BeforeSuite
    public void beforeTest() {
        setupDriver(PropertyReader.configReader.getBrowserType());
    }

    @AfterSuite
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

}
