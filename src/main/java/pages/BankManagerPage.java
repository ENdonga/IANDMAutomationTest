package pages;

import helpers.select.DropDownHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    private WebElement openAccountButton;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    private WebElement customersButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postalCode;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement addCustomerBtn;
    @FindBy(xpath = "//select[@id='userSelect']")
    private WebElement customerDropdown;
    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencyDropdown;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    private WebElement processBtn;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerBox;

    public BankManagerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterCustomerDetails(String fName, String lName, String code){
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        postalCode.clear();
        postalCode.sendKeys(code);
        addCustomerBtn.click();
    }

    public void clickOpenAccountButton(){
        openAccountButton.click();
    }

    public void openAccount(String name, String currency){
        new DropDownHelper(driver).selectUsingVisibleText(customerDropdown,name);
        new DropDownHelper(driver).selectUsingVisibleText(currencyDropdown, currency);
        processBtn.click();
    }

    public  void clickOnOpenAccountBtn(){
        openAccountButton.click();
    }

    public void searchCustomer(String name){
        customersButton.click();
        searchCustomerBox.clear();
        searchCustomerBox.sendKeys(name);
    }


    public void clickOnAddCustomer(){
        addCustomerButton.click();
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
