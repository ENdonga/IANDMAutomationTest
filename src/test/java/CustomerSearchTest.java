import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.HomePage;
import testbase.TestBase;
import utils.PropertyReader;

public class CustomerSearchTest extends TestBase {

    HomePage homePage;
    CustomerPage customerPage;
    @Test
    public void test_CustomerSearch(){
        getApplicationURL(PropertyReader.configReader.getURL());
        homePage = new HomePage(driver);
        customerPage = homePage.clickOnCustomerLoginBtn();
    }
}
