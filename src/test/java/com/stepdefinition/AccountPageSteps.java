package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccoutPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;

public class AccountPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	private AccoutPage accountPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable logindata)

	{
		List<Map<String, String>> credList = logindata.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		accountPage=loginPage.doLogin(username, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_Accounts_page() {
		accountPage.accountPageTitle();

	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {

		List<String> expertedAccountSectionList = sectionTable.asList();
		System.out.println("experted Account SectionList : " + expertedAccountSectionList);

		List<String> accountsesionPageList = accountPage.accountsesionPageList();

		System.out.println("Actual Account Section List: " + accountsesionPageList);

		Assert.assertTrue(expertedAccountSectionList.containsAll(accountsesionPageList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expertedSectionCount) {

		Assert.assertTrue(accountPage.accoutPageSectionCount() == expertedSectionCount);

	}

}
