package seleniumTest1;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;


public class LaunchChrome {
	
    
	public static void main(String[] args) {
    	
	     //System.setProperty("webdriver.chrome.driver", "/Users/snehat/Downloads/chromedriver-mac-arm64/chromedriver");
	    // WebDriver driver = new ChromeDriver();
		
        System.setProperty("webdriver.gecko.driver","/Users/snehat/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.ie.driver", "/Users/snehat/Downloads/edgedriver_mac64_m1");
	    //WebDriver driver = new  InternetExplorerDriver();
		driver.manage().window().maximize();
		
		
		
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.findElement(By.id("menu-item-10")).click();
		driver.findElement(By.name("g3-name")).sendKeys("sneha");
		driver.findElement(By.id("g3-email")).sendKeys("reddyanu98765@gmail.com");
		driver.findElement(By.id("contact-form-comment-g3-message")).sendKeys("Practicing automation");
		driver.findElement(By.xpath("//button[strong=\"Contact Me\"]")).click();
//		driver.close();
	}

}
