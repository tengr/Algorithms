package tengr.tests;


public class FirefoxTest extends TestBase {
	@Override
    public void setBrowser() {
			caps.setCapability("platform", "WIN10");
			caps.setCapability("version", "dev");
			caps.setCapability("browserName", "firefox");
			caps.setCapability("name", "Firefox Test");
  	}
}
