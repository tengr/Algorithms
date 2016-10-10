package tengr.tests;

import org.openqa.selenium.remote.DesiredCapabilities;
 
public class ChromeTest extends TestBase{
  	@Override
    public void setBrowser(DesiredCapabilities caps) {
  		caps.setCapability("platform", "CAPITAN");
  	    caps.setCapability("version", "beta");
  	    caps.setCapability("browserName", "chrome");
  	    caps.setCapability("name", "Chrome Test");
  	}
}
