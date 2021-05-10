package Assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_Drop {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
	      System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://jqueryui.com/droppable/");
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		  
		 }
	
	@Test
	public void test() throws InterruptedException {
		 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
	    WebElement Drag=driver.findElement(By.id("draggable"));
		WebElement Drop=driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(Drag, Drop).build().perform();
		
		Thread.sleep(1000);
		}

	@After
	public void tearDown() throws Exception {
		 
		driver.quit();
			}

	

}
