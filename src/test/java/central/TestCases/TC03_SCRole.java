package central.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import central.PageObject.SCRole;

public class TC03_SCRole extends TC01_SCExtLogin {
	
	@Test(priority=2)
	public void roleCreateUpdate() throws Exception{
		//ExtentTest test= extent.createTest("Role Creation");
		SCRole srole=new SCRole(driver); 
		
		srole.role();
		
		try 
		{
			SCRole.rolesuccess.isDisplayed();
			String path = capturescreen(driver, "SCRole Create");
           // test.pass("Role created successfully").addScreenCaptureFromPath(path);
			
			
		} 
			catch (Exception e) 
		{
				String path = capturescreen(driver, "SCRole Creation failed");
	           // test.fail("Role creation failed").addScreenCaptureFromPath(path);	
		}
       
       
		
}
}
