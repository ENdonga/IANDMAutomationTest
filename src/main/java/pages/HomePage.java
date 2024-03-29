package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    private WebElement bankManagerLoginButton;
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    private WebElement customerLoginButton;
    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BankManagerPage clickOnBankManagerLoginBtn(){
        bankManagerLoginButton.click();
        return new BankManagerPage(driver);
    }

    public CustomerPage clickOnCustomerLoginBtn(){
        customerLoginButton.click();
        return new CustomerPage(driver);
    }

}
