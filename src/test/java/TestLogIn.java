import com.umuc.eApp.LogIn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by samendra.bandara on 5/24/17.
 */
public class TestLogIn {
    private WebDriver driver;
    private LogIn logIn;

    @Before
    public void setUp() throws Exception {
       //driver = TestUtils.getDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
       driver = TestUtils.getBrowserStackDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        logIn = new LogIn(driver);

    }

    @Test
    public void testEmailHappyPath() throws Exception {
        logIn.populateLogIn("test@umuc.com", "test@umuc.com", "Test123+", "Test123+");
        Thread.sleep(2000);
        assertTrue(logIn.isPersonalInfoHeaderDisplayed());

    }
    @Test
    public void testConintueApplicationLogIn() throws Exception {
        logIn.continueApplicationLogIn("test@umuc.com", "Test123+");
        Thread.sleep(2000);
        assertTrue(logIn.isPersonalInfoHeaderDisplayed());

    }

    @Test
    public void testConfirmationEmailErrorMsg() throws Exception {
        logIn.populateEmail("test@umuc.com");
        logIn.populateConfirmationEmail("tes@umuc.com");
        logIn.clickPasswordBox();
        assertEquals("Email Addresses Do Not Match",logIn.getConfirmationEmailErrorMsg());

    }
    @Test
    public void testInvalidEmailErrorMsg() throws Exception {
        logIn.populateEmail("test@umuccom");
        logIn.clickConfirmationEmailBox();
        assertEquals("Invalid Email Address",logIn.getInvalidEmailErrorMsg());

    }
    @Test
    public void testEmptyEmailErrorMsg() throws Exception {
        logIn.clickEmailBox();
        logIn.clickConfirmPasswordBox();
        assertEquals("Invalid Email Address",logIn.getInvalidEmailErrorMsg());
    }

    /*
    Testing that the passwords match
     */
    @Test
    public void testPasswordMatchErrorMsg() throws Exception {
        logIn.populatePassword("Test123+");
        logIn.populatePasswordConfirmation("test123+");
        logIn.clickSubmit();
        assertEquals("Passwords Do Not Match",logIn.getPasswordErrorMsg());

    }
    /*
    Testing a 5 character password.
     */
    @Test
    public void testInvalidPasswordMsg() throws Exception {
        logIn.populatePassword("Test1");
        logIn.clickConfirmPasswordBox();
        assertEquals("Invalid Password",logIn.getInvalidPasswordErrorMsg());

    }
    @Test
    public void testEmptyPasswordErrorMsg() throws Exception {
        logIn.clickPasswordBox();
        logIn.clickConfirmPasswordBox();
        assertEquals("Invalid Password",logIn.getInvalidPasswordErrorMsg());
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
