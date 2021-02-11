package dev.ungar.steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.ungar.pages.TrmsLogin;
import dev.ungar.runner.TrmsRunner;
import junit.framework.Assert;

public class SearchStep {
	
	public static TrmsLogin trl = TrmsRunner.trl;
	public static WebDriver driver = TrmsRunner.driver;
	public static String url = "http://localhost:8080/TrmsApp/index.html";
	
	@Given("^guest is on login page$")
	public void guest_is_on_login_page() throws Throwable {
		driver.get(url);
	}

	@When("^the user types in \"([^\"]*)\" and$")
	public void the_user_types_in_and(String email) throws Throwable {
		trl.email.sendKeys(email);
	    throw new PendingException();
	}

	@SuppressWarnings("deprecation")
	@Then("^the employee name should be \"([^\"]*)\" and$")
	public void the_employee_name_should_be_and(String name) throws Throwable {
		Assert.assertEquals(name, false);
	    throw new PendingException();
	}
	

}
