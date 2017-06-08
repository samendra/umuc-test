import com.umuc.eApp.LogIn;
import com.umuc.eApp.AboutYouPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Created by samendra.bandara on 6/7/17.
 */
public class TestAboutYouPage {
    private WebDriver driver;
    private AboutYouPage aboutYouPage;
    private LogIn logIn;

    @Before
    public void setUp() throws Exception {
       // driver = TestUtils.getDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        driver = TestUtils.getBrowserStackDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        logIn = new LogIn(driver);
        logIn.continueApplicationLogIn("test@umuc.com", "Test123+");
        aboutYouPage = new AboutYouPage(driver);
    }
    @Test
    public void testNumberOfCountries() throws Exception {

    }
    @Test
    public void testUsSocialSecurityNumberBoxPresent() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.populateCitizenship("USA");
        assertTrue(aboutYouPage.isSocialSecurityTextBoxPresent());
    }
    @Test
    public void testVisaFieldPresent() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.populateCitizenship("Austria");
        assertTrue(aboutYouPage.isVisaTextBoxPresent());
    }
    @Test
    public void testFirstNameErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clearFirstName();
       aboutYouPage.populateLastName("Test");
       aboutYouPage.populateDOB("06/06/1990");
       aboutYouPage.clickNextButton();
       assertEquals("Firstname is required", aboutYouPage.getFirstNameErrorMsg());

    }
    @Test
    public void testLastNameErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clearLasttName();
        aboutYouPage.populateFirstName("Testi");
        aboutYouPage.populateDOB("06/06/1990");
        aboutYouPage.clickNextButton();
        assertEquals("Lastname is required", aboutYouPage.getLastNameErrorMsg());

    }
    @Test
    public void testDobErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clearDOB();
        aboutYouPage.populateFirstName("Testi");
        aboutYouPage.populateLastName("testtto");
        aboutYouPage.clickNextButton();
        assertEquals("Please enter a valid birth year.", aboutYouPage.getDobErrorMsg());

    }
    @Test
    public void testCountryCodeValues() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.populateFirstName("Testi");
        aboutYouPage.populateLastName("testtto");
        aboutYouPage.populateCountryCode("+1");
//        aboutYouPage.clickNextButton();
//        assertEquals("Date of birth is required.", aboutYouPage.getDobErrorMsg());

    }
    @Test
    public void testPhoneErrorMsg() throws Exception {
        Thread.sleep(2000);
        aboutYouPage.clearPhone();
        aboutYouPage.populateFirstName("Testi");
        aboutYouPage.populateLastName("testtto");
        aboutYouPage.clickNextButton();
        assertEquals("Phone number is required", aboutYouPage.getPhoneNumbereErrorMsg());

    }
    @Test
    public void testBridgeProgramParticipationErrorMsg() throws Exception {

    }
    @Test
    public void testCurrentStationErrorMsg() throws Exception {

    }
    @Test
    public void testConsortiumProgramErrorMsg() throws Exception {

    }
    @Test
    public void testForeignUniversityJointProgram() throws Exception {

    }



    @After
    public void tearDown() throws Exception {
        driver.quit();
    }





}
