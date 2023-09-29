package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;

@Listeners (test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	
	
	@BeforeMethod
	public void browser() {
		driver =LaunchBrowser.openBrowser();
	}
	
	@Test
	public void verifySwagLabLogIn() {
		SoftAssert softAssert = new SoftAssert();
		SwagLabLoginPage swagLabLoginPage =new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		String currentUrl =driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory");
		System.out.println("post asssertion");
		
		

	}
	
	
}
