package dev.ungar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrmsLogin {
	
public WebDriver driver;
		
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "password")
	public WebElement password;

	public TrmsLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
