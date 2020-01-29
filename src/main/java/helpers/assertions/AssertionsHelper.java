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

    public static void verifyText(String s1, String s2){
        boolean match = s1.equals(s2);
        if(match){
            Assert.assertEquals(s1, s2);
            updateTestStatus(true);
        } else {
            Assert.assertEquals(s1, s2);
            updateTestStatus(false);
        }
    }
}
