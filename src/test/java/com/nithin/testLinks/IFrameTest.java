package com.nithin.testLinks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameTest {
	WebDriver driver = null;
	
	
	@Test
	public void iframeTest() {
		
		driver.switchTo().frame(0);
		
		
	}

	@BeforeTest
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/controlgroup/");
//		ExtentReport.config();
	}

	@AfterTest
	public void tearDown() {

	}

}
