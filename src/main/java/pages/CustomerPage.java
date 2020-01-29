package pages;

import helpers.assertions.VerificationHelper;
import helpers.select.DropDownHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
    private WebDriver driver;

    @FindBy(xpath = "//select[@id='userSelect']")
    private WebElement customerSearch;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[@class='btn logout']")
    private WebElement logoutButton;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    private WebElement depositButton;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    private WebElement withdrawButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    private WebElement depositAmountField;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement depositFormButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    private WebElement withdrawAmountField;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement withdrawFormButton;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    private WebElement successMessage;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    private WebElement witdrawalSuccessMessage;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Customer search
    * Select name
    * Click Login
     */

    private void selectCustomer(){
        new DropDownHelper(driver).selectUsingVisibleText(customerSearch, "Harry Potter");
    }

    public boolean customerLogin(){
        selectCustomer();
        loginButton.click();
        boolean status = new VerificationHelper(driver).isElementVisible(logoutButton);
        return status;
    }

    public String getCustomerName(){
        String name = new DropDownHelper(driver).getSelectedOption(customerSearch);
        return name;
    }

    public String getDepositSuccessMessage(){
        return successMessage.getText();

    }public String getWithdrawalSuccessMessage(){
        return witdrawalSuccessMessage.getText();
    }


    public void depositAmount(String amountToDeposit){
        depositButton.click();
        depositAmountField.clear();
        depositAmountField.sendKeys(amountToDeposit);
        depositFormButton.click();
    }

    public void withdrawAmount(String amount){
        withdrawButton.click();
        withdrawAmountField.clear();
        withdrawAmountField.sendKeys(amount);
        withdrawFormButton.click();
    }
}
