package com.nithin.testLinks;

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

public class VerifyElements {

	WebDriver driver = null;

	@Test
	public void verifyTest() {

		Assert.assertEquals(driver.getTitle(), "Show | jQuery UI");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
//		verify web element is displayed
		WebElement element = driver.findElement(By.xpath("//div[@id='effect']/h3"));
		Assert.assertFalse(element.isDisplayed());
		System.out.println("Element initial state: " + element.isDisplayed());

		driver.findElement(By.id("button")).click();
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Element final state: " + element.isDisplayed());

	}

	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/show/");
//		ExtentReport.config();
	}

	@AfterTest
	public void tearDown() {

	}
}
