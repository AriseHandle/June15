package test;

import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ScreenShot;

public class Listeners extends BaseTest implements ITestListener {
	

	public void onTestStart(ITestResult result) {
		System.out.println("on test start :- " +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("on test success:-" +result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			ScreenShot.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped:-"+result.getName());
	}
	
	public void onTestFinish(ITestResult result) {
		System.out.println("On Test Finish:-"+result.getName());
	}
}
