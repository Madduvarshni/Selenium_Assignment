package Assertian_Assignment;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.rowset.internal.Row;

public class Assignment_4 {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://thedemosite.co.uk/login.php");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     }
	

	@Test
	public void test() throws IOException {
		
		String path = " " ;
		FileInputStream  file = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int noofrows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for(int i=1;i<noofrows;i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			String password = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("The UserName is : " +username);
			System.out.println("The Password is : " +password);
			driver.findElement(By.name("username")).sendKeys("Madhu");
			driver.findElement(By.name("password")).sendKeys("mv@54321");
			
			String beforeloginurl = driver.getCurrentUrl();
			System.out.print("Before Login URL : " +beforeloginurl);
			
			driver.findElement(By.name("FormsButton2")).click();
			
			String aftloginurl = driver.getCurrentUrl();
			System.out.print("After Login URL : " +aftloginurl);
			
			Row currentRow = sheet.getRow(i);
			Cell status = currentRow.createCell(2);
			
			if (aftloginurl.equals(beforeloginurl)) {
				System.out.print("Login is Failed");
				status.setCellValue("Login is Failed");
			}
			else {
				System.out.print("Login is Passed");
				status.setCellValue("Login is Passed");
			}
			
			FileOutputStream op = new FileOutputStream(path);
			wb.write(op);
			op.close();
		}
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}


}
