package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	WebDriver driver;

	By loginButton = By.xpath("//div[@id='SW']/div[2]/div/ul/li[6]/div/p");
	By loginGoogle = By.xpath("//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/div[4]/div[2]");
	By emailField = By.id("identifierId");
	By passwordField = By.name("password");
	By closeButton = By.xpath("//*[@id=\"SW\"]/div[2]/div[2]/div[2]/section/div[1]/div/span");
	By fromcity = By.id("fromCity");
	By fromCityDropDown = By.className("react-autosuggest__suggestions-list");
	By fromCityDropDownElements = By.className("react-autosuggest__suggestion");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignIn() {
		driver.findElement(loginButton).click();
	}

	public void login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(loginGoogle).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("Print current window name" + parentWindow);
		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
		}

		Thread.sleep(6000);
		driver.findElement(emailField).sendKeys("liya14.d@gmail.com");
		driver.findElement(emailField).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(passwordField).sendKeys("Liyakuty");
		driver.findElement(passwordField).sendKeys(Keys.ENTER);
		// driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(closeButton).click();

	}

	public void search() throws InterruptedException {
		String text="London Heathrow Airport";
		driver.findElement(fromcity).sendKeys("london");
		Thread.sleep(5000);
		WebElement f_city_dropdown = driver.findElement(fromCityDropDownElements);
		/*List<WebElement> f_city = driver.findElements(fromCityDropDownElements);
		for(WebElement li :f_city ) {
			if(li.getText().equals(text)) {
				li.click();
				break;
			}
	}*/
		Select option = new Select(f_city_dropdown);
		option.selectByVisibleText(text);
}
}