package central.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import central.PageObject.SCExtLogin;

public class TC01_SCExtLogin extends CommonClass
{
	@Test(priority=1)
	public void Login() throws Exception
	{
		//ExtentTest test = extent.createTest("Ext Login");
		SCExtLogin sclogin = new SCExtLogin(driver);
		sclogin.login();
//		if(driver.getTitle().equals("Sage :: Dashboard")) 
//		{
//			String path=capturescreen(driver,"Ext Login Successful");
//			//test.pass("Successfully Logged in").addScreenCaptureFromPath(path);
//		}
//		else {
//			String path=capturescreen(driver,"Ext Login Failed");
//			//test.fail("Invalid Credentials").addScreenCaptureFromPath(path);
//		}
		
		
	}
	
}
