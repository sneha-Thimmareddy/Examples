package Demo;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.model.Report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class OrangeHrm {
	
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver ; 

	@BeforeTest
	public void setup()
	{
		System.out.println("Before Test executed");
		// TODO Auto-generated method stub
		driver=new FirefoxDriver();

		//maximise windows
		driver.manage().window().maximize();

		//open url
		driver.get(baseUrl);

		//timer i kept as 60 you can keep 40
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Test
	public void loginTest()
	{
		//find username and enter username "Admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		//find password and enter password admin123
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		//login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();


		// Verify if the login was successful by checking the page title
		String pageTitle = driver.getTitle();

	/*	if (pageTitle.equals("OrangeHRM")) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed!");
		}*/


		Assert.assertEquals("OrangeHRMabc", pageTitle);
	}

    @Test
	public void logOut()
	{
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

		List <WebElement> elementlist = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));

		System.out.println("Text of logout option:" + elementlist.get(3).getText());


		elementlist.get(3).click();



	}

	@AfterTest
	public void tearDown() throws InterruptedException
	{

		Thread.sleep(10000);//wait for 5 secs before quit

		logOut();

		//driver.close();
		driver.quit();

	}

}


