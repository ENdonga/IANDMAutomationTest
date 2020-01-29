package helpers.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertionsHelper {
    private WebDriver driver;

    public AssertionsHelper(WebDriver driver){
        this.driver = driver;
    }

    public static void fail(){
        Assert.assertTrue(false);
    }
    public static void pass(){
        Assert.assertTrue(true);
    }
    public  static void assertEquals(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
    public static void updateTestStatus(boolean status){
        if(status){
            pass();
        } else {
            fail();
        }
    }
}
