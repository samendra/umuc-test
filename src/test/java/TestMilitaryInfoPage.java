import com.umuc.eApp.AboutYouPage;
import com.umuc.eApp.LogIn;
import com.umuc.eApp.MilitaryInfoPage;
import com.umuc.eApp.PermenantAddressPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by samendra.bandara on 6/8/17.
 */
public class TestMilitaryInfoPage {
    private WebDriver driver;
    private LogIn logIn;
    private AboutYouPage aboutYouPage;
    private PermenantAddressPage permenantAddressPage;
    private MilitaryInfoPage militaryInfoPage;

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
    public void testMilitaryStatusDropDownListValues() throws Exception {

    }
    @Test
    public void testMilitaryDutyStatusDropDownListValues() throws Exception {

    }
    @Test
    public void testServiceBranchPresent() throws Exception {

    }
    @Test
    public void testServiceBranchDropDownListValues() throws Exception {

    }
    @Test
    public void testDutyStationPresent() throws Exception {

    }
    @Test
    public void testStationDropDownLisValuest() throws Exception {

    }
    @Test
    public void testMilitaryIdExpirationDate() throws Exception {

    }
    @Test
    public void testMilitaryIdExpirationDateErrorMessage() throws Exception {

    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
