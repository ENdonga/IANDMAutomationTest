package pages;

import helpers.select.DropDownHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    private WebDriver driver;

    @FindBy(xpath = "//select[@id='userSelect']")
    private WebElement customerSearch;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void test_VerifyCustomerSearch(){
        new DropDownHelper(driver).selectUsingVisibleText(customerSearch, "Edwwin Ndonga");
    }

}
