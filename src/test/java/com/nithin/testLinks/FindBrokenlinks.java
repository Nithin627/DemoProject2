package com.nithin.testLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenlinks {
//	ExtentReports extent;

	WebDriver driver = null;

	@Test
	public void findBrokenLinks() {

//			All the links on the web page

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are: " + links.size());

		for (WebElement link : links) {
//				System.out.println(link.getText());
			String linkURL = link.getAttribute("href");

			VerifyLinkStatusCode.verifylinks(linkURL);
		}
		System.out.println("Total number of invalid links are");
		VerifyLinkStatusCode.getInvalidLinkCount();

	}

	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://edition.cnn.com/");
//		ExtentReport.config();
	}

	@AfterTest
	public void tearDown() {

		

	}

}
