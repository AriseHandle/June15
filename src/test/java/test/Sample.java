package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners (test.Listeners.class)
public class Sample {
	@Test 
	public void test()  {
		System.out.println("test method");
	}
	
	@Test (timeOut = 1000)
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("test1 method");
	}
	
	@Test (dependsOnMethods = "test1")
	public void test2() {
		System.out.println("test2");
	}	
	
	
	
}
