package com.stepdefinition;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import cucumber.api.java.en.*;

public class LoginPageSteps {
	// private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		String title = loginPage.getLoginPageTitle();
		System.out.println("The Login Page Title is: " + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String exceptedTitleName) {
		String title = loginPage.getLoginPageTitle();

		Assert.assertTrue(title.contains(exceptedTitleName));

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		Assert.assertTrue(loginPage.isForgotPwdLixtExit());

	}

	@When("user enters username {string}")
	public void user_enters_username(String uname) {

		loginPage.enterUserName(uname);

	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {

		loginPage.enterPassword(pwd);

	}

	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {

		loginPage.clickOnLogin();

	}

}
