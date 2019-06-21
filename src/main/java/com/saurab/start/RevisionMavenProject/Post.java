package com.saurab.start.RevisionMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Post {
	WebDriver driver;
	
	By locatorOfpost=By.xpath("//div[text()='Posts']");
	
	By addlocator=By.xpath("//a[text()='Add New']");
	
	By locatorofaddpost=By.name("post_title");
	
	public Post(WebDriver driver2) {
		driver=driver2;
	}
	public void postmethod()
	{
		WebElement post = driver.findElement(locatorOfpost);
		post.click();
		
		WebElement add = driver.findElement(addlocator);
		add.click();
		
		WebElement addPost = driver.findElement(locatorofaddpost);
		addPost.sendKeys("MyPost");;
		
	}

}
