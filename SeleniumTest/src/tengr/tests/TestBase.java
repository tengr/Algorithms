package tengr.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
public class TestBase {
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    protected DesiredCapabilities caps = new DesiredCapabilities();
    public static final String KEY = "2888c898fd4f8302e394664fa37b15ca";
    public static final String SECRET = "867c79e2ff182a2dc96bf105c5bfac12";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        threadDriver = new ThreadLocal<RemoteWebDriver>();        
        setBrowser();
        threadDriver.set(new RemoteWebDriver(new URL(URL), caps));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void setBrowser() {
    	
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    
    @Test
    public void testJavaWebDriver() throws Exception {
    	//create new to-do
  	    WebElement newTodo = ((WebElement) threadDriver).findElement(By.id("new-todo"));
  	    newTodo.sendKeys("new to-do");
  	    
  	    //edit existing to do
  	    Actions actions = new Actions(getDriver());
  	    WebElement existingTodo = ((WebDriver) threadDriver).findElement(By.className("ng-scope"));
  	    actions.moveToElement(existingTodo);
  	    actions.doubleClick(existingTodo).perform();
  	    newTodo.sendKeys("edited new to-do");
  	    Thread.sleep(5000);
  	    
  	    
//  	    //complete exisiting to-do
//  	    WebElement aCheckBox = driver.findElement(By.xpath("//ul/li/div/input[@type='checkbox']"));
//	    
//	    aCheckBox.click();
  	    
  	    //click complete
//  	    WebElement checkBox = getDriver().findElement(By.xpath("id('todo-list')/x:li[1]/x:div/x:input"));
//  	    checkBox.click();
//  	    checkBox.click();
  	    		//findElements(By.cssSelector("[type=checkbox]"));
  	    //System.out.println(checkBoxes.size());
//  	    List<WebElement> checkBoxes2 = getDriver().findElements(By.id("toggle-all"));
//  	    Actions act = new Actions(getDriver());
//  	    act.moveToElement(checkBoxes2.get(0));
//  	    checkBoxes2.get(0);
//  	    System.out.println(checkBoxes2.size());
//  	    for(WebElement ele : checkBoxes) {
//  	    	if(ele.g)
//  	    	System.out.println(ele.);
  	//    
//  	    }
  	    //find the first one and mark as complete
//  	    WebElement aCheckBox = checkBoxes.get(0);
//  	    WebElement todoList = getDriver().findElement(By.id("todo-list"));
//  	    List<WebElement> checkBoxes = todoList.findElements(By.tagName("li"));
//  	    WebElement aCheckBox = checkBoxes.get(0);
  	    //WebElement aCheckBox = getDriver().findElement(By.xpath("//input[@class='toggle']"));
//  	    aCheckBox.click();
//  	    aCheckBox.click();
  	    										//input[@type="checkbox" and @ng-model="todo.completed"]

  	    
  	    
  	    //getDriver().findElement(By.cssSelector("label.ng-binding")).click();
  	    //edit to-do
  	    
  	    //edit existing to-do
  		//    Actions action = new Actions(getDriver());
  		//    WebElement element = getDriver().findElement(By.id("info"));
  		//    action.doubleClick(element).perform();
  		//    element.sendKeys("edited to-do");
  	    	
  	    //complete a to-do
  	    //getDriver().findElement(By.className("toggle")).click();
  	    //getDriver().findElement(By.cssSelector("label.ng-model")).click();
  	    
  	    
//  	    //second new to-do
//  	    WebElement secondNewTodo = getDriver().findElement(By.id("new-todo"));
//	    secondNewTodo.sendKeys("second new to-do");
  	    
  	    
//  	    //remove to-do
//  	    getDriver().findElement(By.xpath("id('todo-list')/x:li[1]/x:div/x:button")).click();
//
//  	    
//  	//    
////  	    getDriver().findElement(By.xpath("//ul[@id='todo-list']/li/form/input")).clear();
////  	    getDriver().findElement(By.xpath("//ul[@id='todo-list']/li/form/input")).sendKeys("to-do1");
////  	    getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
////  	    getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
//  	    //second to do
//  	    getDriver().findElement(By.id("new-todo")).clear();
//  	    getDriver().findElement(By.id("new-todo")).sendKeys("second to-do");
  	    
  	    //complete all active to-dos
//  	    getDriver().findElement(By.id("toggle-all")).click();
//  	    getDriver().findElement(By.linkText("Completed")).click();
//  	    getDriver().findElement(By.id("clear-completed")).click();
  	    

  	    System.out.println(getDriver().getTitle());
  	    getDriver().quit();
    	}
    
 
    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
    }
}