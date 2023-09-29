package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {

	@FindBy (xpath = "//input[@id='user-name']")private WebElement user;
	@FindBy (xpath = "//input[@id='password']")private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']") private WebElement login;
	@FindBy (xpath = "//span[text()='Products']") private WebElement products;
	@FindBy (xpath = "//div[@class='login_logo']") private WebElement logo;
	
	public SwagLabLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String name) {
		user.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public boolean isProductDisplayed() {
	 return	products.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
}
