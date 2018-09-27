package com.Grid.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DriverManager {
	public RemoteWebDriver driver;

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	@BeforeTest
	public void Grid() {
		DesiredCapabilities cap = null;
		cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.ANY);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setWebDriver(driver);
	}
	public static WebDriver getDriver() {

		return dr.get();

	}

	public static void setWebDriver(RemoteWebDriver driver) {

		dr.set(driver);
	}
	
	@Test
	public void dummy(){
		
	}
	
	public void highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) 	DriverManager.getDriver();

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

}
