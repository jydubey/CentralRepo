package central.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import central.PageObject.SCCreateExtuser;



public class TC02_SCCreateExtuser extends TC01_SCExtLogin {
	
	@Test(priority=2)
	public void CreateExtuser() throws Exception
	{
		//ExtentTest test = extent.createTest("Create User");
		SCCreateExtuser sccreate = new SCCreateExtuser(driver);
		sccreate.createuser();
		//test.pass("Successfully Logged in");
		//extent.flush();
		
		
	}

}
