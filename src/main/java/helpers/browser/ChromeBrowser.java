package helpers.browser;

import helpers.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {
    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("--disable-popup-blocking");
//        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
//        chromeCapabilities.setJavascriptEnabled(true);
//        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeCapabilities);

        return chromeOptions;
    }

    public WebDriver getChromeDriver(ChromeOptions options) {
        if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/linuxdrivers/chromedriver"));
            return new ChromeDriver(options);
        } else if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/macdrivers/chromedriver"));
            return new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/windowsdrivers/chromedriver.exe"));
            return new ChromeDriver(options);
        }
    }
}
