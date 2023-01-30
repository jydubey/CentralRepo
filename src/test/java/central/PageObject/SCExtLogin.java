package central.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import central.TestCases.CommonClass;


public class SCExtLogin extends CommonClass
{
	WebDriver ldriver;
	public SCExtLogin(WebDriver driver)					//We have to create webdriver constructor in every class so to maintain same 
														//instance of browser instead of different instances
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);//Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. In Page Factory, testers use @FindBy annotation. The initElements method is used to initialize web elements
	}
		@FindBy(id = "signInName")
		public WebElement txtuname;
		
		@FindBy(id = "password")
		public WebElement txtpassword;
		
		@FindBy(id = "next")
		public  WebElement btnsignin;
		
		@FindBy(xpath = "/html/body/div[2]/div/button")
		public  WebElement cookieclose;
		
	public  void login() throws Exception 
	{
		
		txtuname.sendKeys(username);
		txtpassword.sendKeys(password);
		btnsignin.click();
		Thread.sleep(10000);
		cookieclose.click();
		
	}

}
