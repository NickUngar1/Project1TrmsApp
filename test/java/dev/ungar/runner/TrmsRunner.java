package dev.ungar.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.ungar.pages.TrmsLogin;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.ungar.steps")
public class TrmsRunner {
	
	public static WebDriver driver;
	public static TrmsLogin trl;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		driver = new ChromeDriver();
		trl = new TrmsLogin(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
