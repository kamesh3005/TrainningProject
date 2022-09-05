package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is :" + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(driver = new ChromeDriver());	
		} else if (browser.equals("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(driver = new FirefoxDriver());
		}

		else if (browser.equals("safari")) {

			tlDriver.set(driver = new SafariDriver());
		} else {

			System.out.println("Please pass the correct browse value" + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {

		return tlDriver.get();
	}

}
