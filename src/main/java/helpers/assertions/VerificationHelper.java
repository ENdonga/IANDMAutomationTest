package helpers.assertions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {
    private WebDriver driver;

    public VerificationHelper(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementVisible(WebElement element){
        try{
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            e.getMessage();
            return false;
        }
    }
}
