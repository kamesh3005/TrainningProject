package AppsHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ApplicatioHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader confifReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {

		confifReader = new ConfigReader();
		prop = confifReader.init_prop();

	}

	@Before(order = 1)

	public void launchBrowser() {

		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@After(order = 0)

	public void quitBrowser() {

		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(sourcePath, "image/png");

		}
	}
}
