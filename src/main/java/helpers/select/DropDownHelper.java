package helpers.select;

import javafx.scene.effect.DropShadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
    private WebDriver driver;
    private  Select select;

    public DropDownHelper(WebDriver driver){
        this.driver = driver;
    }

    public void selectUsingVisibleText(WebElement element, String text){
        select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectUsingValue(WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
    }
    public void selectUsingIndex(WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
    }
}
