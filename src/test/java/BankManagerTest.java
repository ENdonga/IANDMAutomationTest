import helpers.assertions.AssertionsHelper;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.HomePage;
import testbase.TestBase;
import utils.PropertyReader;

public class BankManagerTest extends TestBase {

    HomePage homePage;
    BankManagerPage bankManagerPage;
    @Test
    public void test_BankManagerLogin(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        homePage.clickOnBankManagerLoginBtn();
    }

    @Test
    public void test_VerifyAddCustomerDetails(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.clickOnAddCustomer();
        bankManagerPage.enterCustomerDetails("Edwin", "Ndonga", "35272");
    }
    @Test
    public void test_VerifyOpenAccount(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.clickOnOpenAccountBtn();
        bankManagerPage.openAccount("Harry Potter", "Pound");
        bankManagerPage.acceptAlert();
    }

    @Test
    public void test_VerifySearchCustomer(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        bankManagerPage  = homePage.clickOnBankManagerLoginBtn();
        bankManagerPage.searchCustomer("test");
    }

}
