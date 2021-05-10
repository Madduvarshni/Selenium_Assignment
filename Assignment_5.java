package Assertian_Assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5 {
    WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  }
	List<String> ls = new ArrayList<String>();
    @Test
	public void test() {
    	WebElement table = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
    	List<WebElement>row=table.findElements(By.tagName("tr"));
    	    for(int i=1,j=0;i<row.size();i++,j++) {
    	    	List<WebElement>cols=row.get(i).findElements(By.tagName("td"));
    	    	ls.add(cols.get(2).getText());
    	    	}
    	    int j=0;
    	    for(String value : ls) {
    	    	int n=0;
    	    	for(String value1 : ls) {
    	    	if(value.equals(value1)) {
    	    		j=++n;
    	    	} }
    	    	System.out.println(j); }
	}


	@After
	public void tearDown() throws Exception {
	
		driver.quit();
	}

}
