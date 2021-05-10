package Assignment;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popup_window {
	WebDriver driver;
   @Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://demo.guru99.com/popup.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  }
   @Test
	public void test() throws InterruptedException {
		 driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();			
		 String MainWindow=driver.getWindowHandle();		
         Set<String> s1=driver.getWindowHandles();		
         Iterator<String> i1=s1.iterator();		
         while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.findElement(By.name("emailid"))
                    .sendKeys("madhuarjun@gmail.com");                			
                    
                    driver.findElement(By.name("btnLogin")).click();
            }
                    driver.close();	
                    driver.switchTo().window(MainWindow);                     
      }		}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}



}
