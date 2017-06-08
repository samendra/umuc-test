import com.umuc.eApp.AboutYouPage;
import com.umuc.eApp.LogIn;
import com.umuc.eApp.PermenantAddressPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by samendra.bandara on 6/7/17.
 */
public class TestPermenantAddressPage {
    private WebDriver driver;
    private  LogIn logIn;
    private AboutYouPage aboutYouPage;
    private PermenantAddressPage permenantAddressPage;

    @Before
    public void setUp() throws Exception {
        //driver = TestUtils.getDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        driver = TestUtils.getBrowserStackDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        logIn = new LogIn(driver);
        logIn.continueApplicationLogIn("test@umuc.com", "test123+");
        permenantAddressPage = new PermenantAddressPage(driver);
        aboutYouPage = new AboutYouPage(driver);

    }
    @Test
    public void testMailHeaderPresent() throws Exception {
        Thread.sleep(2000);
        assertEquals("Mailing Address",permenantAddressPage.getMailingAddressText());
    }
    @Test
    public void testAdressErrorMsg() throws Exception {
        Thread.sleep(2000);
        permenantAddressPage.clearStreet();
        aboutYouPage.clickNextButton();
        assertEquals("Address is required.",permenantAddressPage.getAddressErrorMsg());
    }
    @Test
    public void testCityErrorMsg() throws Exception {
        Thread.sleep(2000);
        permenantAddressPage.clearCity();
        aboutYouPage.clickNextButton();
        assertEquals("City is required.",permenantAddressPage.getCityErrorMsg());
    }
    @Test
    public void testZipErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clearZipCode();
        aboutYouPage.clickNextButton();
        assertEquals("Zip Code is required",permenantAddressPage.getZipErrorMsg());
    }
    @Test
    public void testStateErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clickNextButton();
        assertEquals("State is required.",permenantAddressPage.getStateErrorMsg());
    }
    @Test
    public void testMilitaryAddressCheckBoxPresent() throws Exception {

    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }




}
