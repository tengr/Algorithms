package tengr.tests;

import org.openqa.selenium.remote.DesiredCapabilities;

public class IETest extends TestBase{
	@Override
    public void setBrowser(DesiredCapabilities caps) {
		 caps.setCapability("browserName", "IE");
		 caps.setCapability("version", "11");
		 caps.setCapability("platform", "WIN10");
		 caps.setCapability("name", "IE Test");
  	}
}
