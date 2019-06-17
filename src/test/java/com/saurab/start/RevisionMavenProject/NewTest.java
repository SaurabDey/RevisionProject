package com.saurab.start.RevisionMavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;

	@Test
	public void f() {
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("pwd"));
		password.sendKeys("demo123");
		
		WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		button.click();
	}

	@Parameters("myBrowser")
	@BeforeTest
	public void beforeTest(String valueXyz) {

		String browser= valueXyz;
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			throw new RuntimeException("Browser is not available");
		}
		

		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("Ended");
		System.out.println("Ended");
		System.out.println("Ended");
		System.out.println("Ended");
	}

}
