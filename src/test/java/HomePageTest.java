import com.umuc.eApp.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by samendra.bandara on 5/23/17.
 */
public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setUp() throws Exception {
        driver=TestUtils.getDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        homePage=new HomePage(driver);

    }
    /*
    This is testing the tittle of the page
     */
    @Test
    public void testHomePageTittle() throws Exception {
       assertEquals("UMUC",driver.getTitle());

    }

    /*
    This test is checking if the start a new application tab
    and the continue your application is present
     */
    @Test
    public void testTabsPresent() throws Exception {
        assertTrue(homePage.continueTab());
        assertTrue(homePage.startNewTab());

    }

    @After
    public void tearDown()throws Exception {
        driver.quit();
    }


}
