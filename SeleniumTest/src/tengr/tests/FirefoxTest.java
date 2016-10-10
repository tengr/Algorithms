package tengr.tests;

import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxTest extends TestBase {
	@Override
    public void setBrowser(DesiredCapabilities caps) {
			caps.setCapability("platform", "WIN10");
			caps.setCapability("version", "dev");
			caps.setCapability("browserName", "firefox");
			caps.setCapability("name", "Firefox Test");
  	}
}
