import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.HomePage;
import testbase.TestBase;
import utils.PropertyReader;

public class HomePageTest extends TestBase {
    HomePage homePage;
    BankManagerPage bankManagerPage;
//    @Test
//    public void test_BankManagerLogin(){
//        getApplicationURL(PropertyReader.configReader.getURL());
//        homePage = new HomePage(driver);
//        homePage.clickOnBankManagerLoginBtn();
//    }

    @Test
    public void test_NavigateToHomePage(){
        bankManagerPage.homePage();
    }
}
