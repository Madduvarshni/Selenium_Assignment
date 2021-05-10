package Assertian_Assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_1 {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		  System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://accounts.google.com/signup");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void test() {
		
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Madhu");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("M");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("mvarjun88");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("madhuarjun");
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("madhuarjun");
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
		}


	@After
	public void tearDown() throws Exception {
	
		driver.quit();
		
	}

	
}
