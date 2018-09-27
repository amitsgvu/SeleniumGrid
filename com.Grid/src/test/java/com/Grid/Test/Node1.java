package com.Grid.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Node1 extends DriverManager {

	@Test
	public void gotoLogin() {
		DriverManager.getDriver().get("http://automationpractice.com/index.php");
		DriverManager.getDriver().manage().window().maximize();
		WebElement signIn = DriverManager.getDriver().findElement(By.cssSelector("a.login"));
		highLightElement(signIn);
		signIn.click();
		Actions action = new Actions(DriverManager.getDriver());
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

		WebElement email = DriverManager.getDriver().findElement(By.id("email"));
		highLightElement(email);
		email.clear();
		email.sendKeys("blog.cucumber@gmail.com");

		WebElement Password = DriverManager.getDriver().findElement(By.id("passwd"));
		highLightElement(Password);
		Password.clear();
		Password.sendKeys("Cucumber@blog");

		WebElement login = DriverManager.getDriver().findElement(By.id("SubmitLogin"));
		highLightElement(login);

		login.click();
	}

}
