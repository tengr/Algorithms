package tengr.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
public class TestBase {
 
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    public static final String KEY = "b4e0388322e22fabaa9ab74de01a3110";
    public static final String SECRET = "6d9333fa691396536a9a4d683d66a70d";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
 
    @BeforeMethod
    public void setUp() throws MalformedURLException {
 
        threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities();
        FirefoxProfile fp = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, fp);
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
//        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc));
        
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "CAPITAN");
        caps.setCapability("version", "beta");
        caps.setCapability("browserName", "chrome");
        
        
        threadDriver.set(new RemoteWebDriver(new URL(URL), caps));

    }
 
    public WebDriver getDriver() {
        return threadDriver.get();
    }
 
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
 
    }
}