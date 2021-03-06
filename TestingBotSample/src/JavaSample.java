import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class JavaSample {

  public static final String KEY = "2888c898fd4f8302e394664fa37b15ca";
  public static final String SECRET = "867c79e2ff182a2dc96bf105c5bfac12";
  public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("browserName", "IE");
//    caps.setCapability("version", "11");
//    caps.setCapability("platform", "WIN10");
//    caps.setCapability("name", "My First Test");
    
    caps.setCapability("platform", "WIN10");
	caps.setCapability("version", "dev");
	caps.setCapability("browserName", "firefox");
	caps.setCapability("name", "Firefox Test");


//    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//    driver.get("http://www.google.com/ncr");
//    WebElement element = driver.findElement(By.name("q"));
//
//    element.sendKeys("TestingBot");
//    element.submit();
	FirefoxProfile profile = new FirefoxProfile(); 
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("firefox_profile", profile);
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
    //WebDriverWait driverWait = new WebDriverWait(driver,TestConstant.WAIT_ELEMENT_TO_LOAD);
    
    	//WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    	//WebDriver driver = new ChromeDriver();
    	String baseUrl = "http://todomvc.com/";
    	driver.get(baseUrl + "examples/angularjs/#/");
    	//create new to-do
	    WebElement newTodo = driver.findElement(By.id("new-todo"));
	    newTodo.sendKeys("new to-do");
	    
	    //edit existing to do
//	    Actions actions = new Actions(driver);
//	    WebElement existingTodo = driver.findElement(By.className("ng-binding"));
//	    actions.moveToElement(existingTodo);
//	    actions.doubleClick(existingTodo).perform();
//	    newTodo.sendKeys("edited new to-do");
  
	    //complete to-do
//	    List<WebElement> inputs = driver.findElements(By.tagName("input"));
//	    System.out.println(inputs.size());
//	    for(WebElement input : inputs) {
//	    	System.out.println(input.getAttribute("type"));
//	    	if(input.getAttribute("ng-model").equals("todo.completed")) {
//	    		input.click();
//	    		System.out.println("clicked");
//	    	}
//	    }
	    WebElement aCheckBox = driver.findElement(By.xpath("//ul/li/div/input[@type='checkbox']"));
	    
	    aCheckBox.click();
	    //re-activate to-do
	    //aCheckBox.click();
	    
	    
	    //add second to-do
	    
	    
    //click complete
//    WebElement checkBox = driver.findElement(By.xpath("id('todo-list')/x:li[1]/x:div/x:input"));
//    checkBox.click();
//    checkBox.click();
    		//findElements(By.cssSelector("[type=checkbox]"));
    //System.out.println(checkBoxes.size());
//    List<WebElement> checkBoxes2 = driver.findElements(By.id("toggle-all"));
//    Actions act = new Actions(driver);
//    act.moveToElement(checkBoxes2.get(0));
//    checkBoxes2.get(0);
//    System.out.println(checkBoxes2.size());
//    for(WebElement ele : checkBoxes) {
//    	if(ele.g)
//    	System.out.println(ele.);
//    
//    }
    //find the first one and mark as complete
//    WebElement aCheckBox = checkBoxes.get(0);
//    WebElement todoList = driver.findElement(By.id("todo-list"));
//    List<WebElement> checkBoxes = todoList.findElements(By.tagName("li"));
//    WebElement aCheckBox = checkBoxes.get(0);
    //WebElement aCheckBox = driver.findElement(By.xpath("//input[@class='toggle']"));
//    aCheckBox.click();
//    aCheckBox.click();
    										//input[@type="checkbox" and @ng-model="todo.completed"]

//    //second new to-do
//    WebElement secondNewTodo = driver.findElement(By.id("new-todo"));
//    secondNewTodo.sendKeys("second new to-do");
    
    //driver.findElement(By.cssSelector("label.ng-binding")).click();
    //edit to-do
    
    //edit existing to-do
	//    Actions action = new Actions(driver);
	//    WebElement element = driver.findElement(By.id("info"));
	//    action.doubleClick(element).perform();
	//    element.sendKeys("edited to-do");
    	
    //complete a to-do
    //driver.findElement(By.className("toggle")).click();
    //driver.findElement(By.cssSelector("label.ng-model")).click();
    
    
    
    //remove to-do
//    driver.findElement(By.xpath("id('todo-list')/x:li[1]/x:div/x:button")).click();

    
//    
//    driver.findElement(By.xpath("//ul[@id='todo-list']/li/form/input")).clear();
//    driver.findElement(By.xpath("//ul[@id='todo-list']/li/form/input")).sendKeys("to-do1");
//    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
//    driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
    //second to do
//    driver.findElement(By.id("new-todo")).clear();
//    driver.findElement(By.id("new-todo")).sendKeys("second to-do");
    
    //complete all active to-dos
//    driver.findElement(By.id("toggle-all")).click();
//    driver.findElement(By.linkText("Completed")).click();
//    driver.findElement(By.id("clear-completed")).click();
    

    System.out.println(driver.getTitle());
    driver.quit();

  }
  
}