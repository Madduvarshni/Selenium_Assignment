package Assignment;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Size_of_browser_window {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";
		  driver.get(url);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		System.out.println(driver.manage().window().getSize());
		Dimension dm = new Dimension(450,630);
		driver.manage().window().setSize(dm);
	      driver.close();
	      }


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
