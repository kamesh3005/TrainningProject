package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccoutPage {

	public WebDriver driver;
	private By accountSelector = By.xpath("//div[@class='row addresses-lists']//span");

	public AccoutPage(WebDriver driver) {

		this.driver = driver;

	}

	public String accountPageTitle() {

		return driver.getTitle();
	}

	public int accoutPageSectionCount() {

		return driver.findElements(accountSelector).size();
	}

	public List<String> accountsesionPageList() {

		List<String> accountList = new ArrayList<String>();

		List<WebElement> accoutHeaderList = driver.findElements(accountSelector);
		for (WebElement l : accoutHeaderList) {

			String text = l.getText();

			System.out.println(text);

			accountList.add(text);

		}
		return accountList;
	}

}
