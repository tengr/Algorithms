package tengr.tests;

public class IETest extends TestBase{
	@Override
  	public void setBrowser() {
		 caps.setCapability("browserName", "IE");
		 caps.setCapability("version", "11");
		 caps.setCapability("platform", "WIN10");
		 caps.setCapability("name", "IE Test");
  	}
}
