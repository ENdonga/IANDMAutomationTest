import helpers.assertions.AssertionsHelper;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.HomePage;
import testbase.TestBase;
import utils.PropertyReader;

public class BankManagerTest extends TestBase {

    HomePage homePage;
    BankManagerPage bankManagerPage;
    @Test(priority = 1)
    public void test_BankManagerLogin(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        bankManagerPage=homePage.clickOnBankManagerLoginBtn();
    }

    @Test(priority = 2)
    public void test_VerifyAddCustomerDetails(){
        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.enterCustomerDetails("Edwin", "Ndonga", "35272");
    }
    @Test(priority = 3)
    public void test_VerifyOpenAccount(){
//        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.openAccount("Edwin Ndonga", "Pound");
    }

    @Test(priority = 4)
    public void test_VerifySearchCustomer(){
//        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.searchCustomer("Edwin");
        boolean status = bankManagerPage.validateCustomerName("Edwin", "Ndonga");
        AssertionsHelper.updateTestStatus(status);
    }

    @Test(priority = 5)
    public void test_NavigateBackToHome(){
        bankManagerPage.homePage();
    }

}
