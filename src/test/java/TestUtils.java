import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by samendra.bandara on 5/23/17.
 */
public class TestUtils {
    WebDriver driver;

    public static WebDriver getDriver(String url) {

        System.setProperty("webdriver.chrome.driver", "/Users/samendra.bandara/Downloads/chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }


    public static WebDriver getBrowserStackDriver() throws JSONException, FileNotFoundException, IOException, ParseException {
        JSONObject config = getConfig();
        //			System.setProperty("webdriver.chrome.driver", "/Users/sbandara/Downloads/chromedriver");
        JSONArray envs = (JSONArray) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(/*taskID*/ 0);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("key");
        }

        //	        if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
        //	            Local l = new Local();
        //	            Map<String, String> options = new HashMap<String, String>();
        //	            options.put("key", accessKey);
        //	            l.start(options);
        //	        }

        WebDriver driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);

        driver.get("http://author-new-qa.umuc.edu/");
        // driver.get("http://author-new-qa.umuc.edu/commonspot/dashboard/index.html#mode=read&url=/index.cfm?cs_pgIsInLView=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static JSONObject getConfig() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(new FileReader("src/test/resources/conf.local"/* + System.getProperty("config")*/));
    }
}
