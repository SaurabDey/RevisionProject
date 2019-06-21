package com.saurab.start.RevisionMavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;

	@Test
	public void f() {
	
		LoginClass log = new LoginClass(driver);
		log.loginmethod();
		
		Post po = new Post(driver);
		po.postmethod();
		
	}

	@Parameters("myBrowser")
	@BeforeTest
	public void beforeTest(String valueXyz) throws MalformedURLException {

		String browser= valueXyz;
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		
		/*DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		driver= new RemoteWebDriver(new URL("http://192.168.0.3:4444/wd/hub"), capabilities);*/
		

		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Dyanesh");
		driver.quit();
		System.out.println("Ended");
	}

}
