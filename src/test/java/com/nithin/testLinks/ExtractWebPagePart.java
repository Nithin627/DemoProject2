package com.nithin.testLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtractWebPagePart {
	WebDriver driver = null;

	@Test
	public void extractElementTest() {
		WebElement topStories = driver
				.findElement(By.xpath("(//div[@class='container container_lead-plus-headlines  lazy'])[2]"));
		Assert.assertTrue(topStories.isDisplayed());
		System.out.println("Is available: " + topStories.isDisplayed());

		List<WebElement> links = topStories.findElements(By.tagName("a"));
		System.out.println("No of links are: " + links.size());
		for (WebElement link : links) {
			System.out.println(link.getText() + "/n");

//			String attribute = link.getAttribute("href");
//			System.out.println(attribute);
//			System.out.println(link);
		}
	}

	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://edition.cnn.com/");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
