package helpers.browser;

import helpers.resource.ResourceHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxBrowser {
    public FirefoxOptions getFirefoxOptions(){
        FirefoxOptions firefox = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        firefox.setCapability(FirefoxDriver.PROFILE, profile);
        firefox.setCapability("marionette", true);

        return firefox;
    }

    public WebDriver getFirefoxDriver(FirefoxOptions options) {
        if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/linuxdrivers/geckodriver"));
            return new FirefoxDriver(options);
        } else if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/macdrivers/geckodriver"));
            return new FirefoxDriver(options);
        } else {
            System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("/src/main/resources/drivers/windowsdrivers/geckodriver.exe"));
            return new FirefoxDriver(options);
        }
    }
}
