package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookLoginPage {
	@FindBy (xpath ="//input[@id='email']") private WebElement email;
	
	@FindBy (xpath ="//input[@id='pass']") private WebElement pass;
	
	@FindBy (xpath ="//button[@name='login']") private WebElement login;
	
	@FindBy (xpath = "//a[@data-testid='open-registration-form-button']") private WebElement create;
	
	@FindBy (xpath = "//input[@name='firstname']") private WebElement firstName;
	
	public FaceBookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailID(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		pass.sendKeys(password);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnCreate() {
		create.click();
	}
	
	public void enterFirstName(String name, WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(50000));
		wait.pollingEvery(Duration.ofMillis(5000));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(name);
	}
	

}
