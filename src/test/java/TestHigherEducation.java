import com.umuc.eApp.HigherEducationPage;
import com.umuc.eApp.LogIn;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by samendra.bandara on 6/22/17.
 */
public class TestHigherEducation {
    private WebDriver driver;
    private LogIn logIn;
    private HigherEducationPage higherEducationPage;

    @Before
    public void setUp() throws Exception {
        //driver = TestUtils.getDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        driver = TestUtils.getBrowserStackDriver("https://eapp-umuc.cs54.force.com/eapp?key=wN46.~2");
        logIn = new LogIn(driver);
        higherEducationPage = new HigherEducationPage(driver);


    }

    @Test
    public void testHigherEducationTittle() throws Exception {


    }
    @Test
    public void testProgramLevelValues() throws Exception {


    }
    @Test
    public void testProgramLevelmessege() throws Exception {
     assertEquals("something",driver.getTitle());

    }
    @Test
    public void testPrgoramStartDropDownValues() throws Exception {


    }
    @Test
    public void testStartDateErrorMessege() throws Exception {


    }
    @Test
    public void testDegreeValues() throws Exception {


    }
    @Test
    public void testDegreeErrorMessege() throws Exception {


    }
    @Test
    public void testDegreeMessege() throws Exception {

        assertEquals("something",driver.getTitle());
    }
    @Test
    public void testDiplomaValues() throws Exception {


    }
    @Test
    public void testDiplomaValues() throws Exception {


    }







}
