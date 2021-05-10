package Assertian_Assignment;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_3 {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {

		  System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://api.jquery.com/dblclick/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		

                 TakesScreenshot scrShot =((TakesScreenshot)driver);

                 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

                 FileUtils.copyFile(srcFile,"C:\\Users\\Madhu\\Desktop\\INFY\\screenshot.png");
       
	             }


	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		
	}

	
}
