import helpers.assertions.AssertionsHelper;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.HomePage;
import testbase.TestBase;
import utils.PropertyReader;

public class CustomerSearchTest extends TestBase {

    HomePage homePage;
    CustomerPage customerPage;
    @Test(priority = 1)
    public void test_NavigateToCustomersPage(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        customerPage = homePage.clickOnCustomerLoginBtn();
    }

    @Test(priority = 2)
    public void test_VerifyCustomerLogin(){
        customerPage = homePage.clickOnCustomerLoginBtn();
        customerPage.customerLogin();
    }

    @Test(priority = 3)
    public void test_ValidateCustomerDeposit(){
        customerPage.depositAmount("5000");
        AssertionsHelper.verifyText(customerPage.getDepositSuccessMessage(), "Deposit Successful");
    }

    @Test(priority = 4)
    public void test_ValidateCustomerWithdrawal(){
        customerPage.withdrawAmount("2000");
        AssertionsHelper.verifyText(customerPage.getWithdrawalSuccessMessage(), "Transaction successful");
    }
}
