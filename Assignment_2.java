package Assertian_Assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
    
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		

		  System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

	@Test
	public void test() {
		
		driver.navigate().to("http://openclinic.sourceforge.net/openclinic/medical/index.php");
		driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).click();
		Select search = new Select(driver.findElement(By.xpath("//*[@id=\"search_type\"]")));
		search.selectByValue("First Name");
		Assert.assertFalse(true);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		
	}
}
