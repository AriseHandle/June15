package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.FaceBookLoginPage;
import utility.Reports;



public class FaceBooLoginTest extends BaseTest {

ExtentReports extentReports;
ExtentTest extentTest;


	@BeforeClass
	public void addReports() {
		extentReports = Reports.configureReports();
	}

	@BeforeMethod
	public void browser() {
		driver =LaunchBrowser.openBrowser();
	}
	
	@Test
	public void loginWithValidCredentials() {
		extentTest=extentReports.createTest("loginWithValidCredentials");
		System.out.println("bloginWithValidCredentials");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		faceBookLoginPage.enterEmailID("Arise");
		faceBookLoginPage.enterPassword("12345");
		faceBookLoginPage.clickOnLogin();
	}
	
	@Test
	public void loginWithValidUserNameAndInvalidPasssword() {
		extentTest=extentReports.createTest("loginWithValidUserNameAndInvalidPasssword");
		System.out.println("aloginWithValidUserNameAndInvalidPasssword");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		faceBookLoginPage.enterEmailID("Arise");
		faceBookLoginPage.enterPassword("0000");
		faceBookLoginPage.clickOnLogin();
	}
	
	@Test
	public void loginWithInvalidUserNameAndValidPassword() {
		extentTest=extentReports.createTest("loginWithInvalidUserNameAndValidPassword");
		System.out.println("cloginWithInvalidUserNameAndValidPassword");
		FaceBookLoginPage faceBookLoginPage = new FaceBookLoginPage(driver);
		faceBookLoginPage.enterEmailID("A");
		faceBookLoginPage.enterPassword("12345");
		faceBookLoginPage.clickOnLogin();
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		if(result.getStatus()==result.SUCCESS)
		{
			extentTest.log(Status.PASS,result.getName());
		}
		else if(result.getStatus()== result.FAILURE)
		{
			extentTest.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()== result.SKIP)
		{
			extentTest.log(Status.SKIP, result.getName());
		}
		driver.close();
	}
	
	@AfterClass
	public void flushData() {
		extentReports.flush();
	}
	
}
