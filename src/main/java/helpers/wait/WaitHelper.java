package helpers.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver){
        this.driver=driver;
    }

    public void setImplicitWait(long timeout, TimeUnit unit){
        driver.manage().timeouts().implicitlyWait(timeout,unit);
    }
    public void setPageLoadTime(long timeout, TimeUnit unit){
        driver.manage().timeouts().pageLoadTimeout(timeout,unit);
    }
    public void waitForElementToBeClickable(WebElement element, long timeout){
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisible(WebElement element, long timeout){
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
