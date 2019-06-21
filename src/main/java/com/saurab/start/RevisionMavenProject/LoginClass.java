package com.saurab.start.RevisionMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	WebDriver driver;

	@FindBy(id = "user_login")
	WebElement locatorOfUsername;

	@FindBy(name = "pwd")
	WebElement locatorPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement locatorloginButn;

	public LoginClass(WebDriver driver2) {
		driver = driver2;

		PageFactory.initElements(driver, this);
	}

	public void loginmethod() {
		locatorOfUsername.sendKeys("admin");

		locatorPassword.sendKeys("demo123");

		locatorloginButn.click();

	}
}
