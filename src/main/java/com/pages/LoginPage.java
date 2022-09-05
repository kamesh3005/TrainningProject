package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// By Locators

	private By emailId = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='passwd']");
	private By signin = By.xpath("//span[normalize-space()='Sign in']");
	private By forgotPassword = By.xpath("//a[text()='Forgot your password?']");

	// 2.Constructor of the page class
	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// 3.page action

	public String getLoginPageTitle() {

		return driver.getTitle();
	}

	public boolean isForgotPwdLixtExit() {

		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUserName(String uName) {

		driver.findElement(emailId).sendKeys(uName);

	}

	public void enterPassword(String pwd) {

		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {

		driver.findElement(signin).click();
	}

	public AccoutPage doLogin(String uname, String pwd) {

		System.out.println("Login with" + uname + "and" + pwd);

		driver.findElement(emailId).sendKeys(uname);

		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signin).click();

		return new AccoutPage(driver);
	}

}
