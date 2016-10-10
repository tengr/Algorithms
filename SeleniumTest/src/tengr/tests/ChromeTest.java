package tengr.tests;
 
public class ChromeTest extends TestBase{
  	@Override
  	public void setBrowser() {
  		caps.setCapability("platform", "CAPITAN");
  	    caps.setCapability("version", "beta");
  	    caps.setCapability("browserName", "chrome");
  	    caps.setCapability("name", "Chrome Test");
  	}
}
