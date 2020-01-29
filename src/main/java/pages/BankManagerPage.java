package pages;

import helpers.select.DropDownHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Struct;

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
    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;


    public BankManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private void clickOnAddCustomer() {
        addCustomerButton.click();
    }

    public void enterCustomerDetails(String fName, String lName, String code) {
        clickOnAddCustomer();
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.clear();
        lastName.sendKeys(lName);
        postalCode.clear();
        postalCode.sendKeys(code);
        addCustomerBtn.click();
        acceptAlert();
    }

    private void clickOpenAccount() {
        openAccountButton.click();
    }

    public void openAccount(String name, String currency) {
        clickOpenAccount();
        new DropDownHelper(driver).selectUsingVisibleText(customerDropdown, name);
        new DropDownHelper(driver).selectUsingVisibleText(currencyDropdown, currency);
        processBtn.click();
        acceptAlert();
    }

    public void searchCustomer(String name) {
        customersButton.click();
        searchCustomerBox.clear();
        searchCustomerBox.sendKeys(name);
    }

    public boolean validateCustomerName(String fname, String lname) {
        String firstname = fname;
        String lastname = lname;
        String xpathPartOne = " //td[contains(text(),'";
        String xpathPartTwo = "')]";
        String fullXpath = xpathPartOne + firstname + xpathPartTwo;
        String xpathLastnameCell = xpathPartOne + lastname + xpathPartTwo;
        WebElement fnameCell = driver.findElement(By.xpath(fullXpath));
        WebElement lnameCell = driver.findElement(By.xpath(xpathLastnameCell));
        if (fnameCell.getText().equals(fname) || lnameCell.getText().equals(lname)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnHomeButton(){
        homeButton.click();
    }

    public HomePage homePage(){
        homeButton.click();
        return new HomePage(driver);
    }


}
