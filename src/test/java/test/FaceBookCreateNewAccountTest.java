package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.FaceBookLoginPage;

public class FaceBookCreateNewAccountTest {
	WebDriver driver;
	
	@BeforeMethod
	public void browser() {
		driver = LaunchBrowser.openBrowser();
	}

	@Test
	public void createNewAccountTest() {
		FaceBookLoginPage faceBookLoginPage =new FaceBookLoginPage(driver);
		faceBookLoginPage.clickOnCreate();
		faceBookLoginPage.enterFirstName("Arise",driver);
	}
}
