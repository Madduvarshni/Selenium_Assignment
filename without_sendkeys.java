package Assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class without_sendkeys {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://accounts.google.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {

          WebElement nextBtn = driver.findElement(By.id("identifierNext"));
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	      js.executeScript("document.getElementById('identifierId').value='testemail'");
	      js.executeScript("arguments[0].click();", nextBtn);
	      Thread.sleep(2000);
		}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
