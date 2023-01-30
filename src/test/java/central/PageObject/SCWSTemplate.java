package central.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import central.TestCases.CommonClass;

public class SCWSTemplate extends CommonClass
{
	WebDriver ldriver;
	public SCWSTemplate(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Workspace dashboard']")
	public static WebElement wsdashboard;
	
	@FindBy(xpath = "//span[text()='Create a new workspace template']") 
	public static WebElement createwst;
	
	@FindBy(id = "txtWorkspacetemplatename")
	public static WebElement wstname;
	
	@FindBy(id = "txtDescriptionWS") 
	public static WebElement wstdescription;
	
	@FindBy(xpath = "//span[@class='mainslider round']")
	public static WebElement wstactivate;
	
	@FindBy(xpath = "//div[@id='ms-list-1']") 
	public static WebElement witlist;
	
	@FindBy(xpath = "//div[@class='ms-search']") 
	public static WebElement witsearch;
	
	@FindBy(xpath = "//input[contains(@id, \"ms-opt\")]") 
	public static WebElement selectwit;
	
	@FindBy(id = "AssignWSWIRel") 
	public static WebElement assignwit;
	
	@FindBy(id = "WorkspaceNote") 
	public static WebElement wsnote;
	
	@FindBy(xpath = "//button[text() ='Save workspace']") 
	public static WebElement savewst;
	
	@FindBy(id = "wrkitemwrkspacedashboardmsgs")
	public static WebElement successmsg;
	
	@FindBy(id= "txtworkspacetemplateSearchField")
	public static WebElement wstsearch;
	
	@FindBy(xpath = "//span[@class='ViewWorkSpace linkcolour']")
	public static WebElement foundWST;
	
	@FindBy(xpath = "//a[@class='editworkspace']")
	public static WebElement editwstbtn;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	public static WebElement searchbox;
	
	@FindBy(xpath="//a[text()='Select all']")
	public static WebElement selectallbtn;
	
	@FindBy(xpath="//label[@class='mainswitch']")
	public static WebElement deactivatewit;
	
	@FindBy(xpath="//p[@id='WorkspaceEditSuccessMsg']")
	public static WebElement editwstsuccessmsg;
	
	
	public static Faker faker = new Faker();
	public static String wsname = faker.name().name();
	public String WSTSM = "Workspace template " +wsname+ " created successfully.";
	public String EWSTSM= "Workspace template " +wsname+ " updated successfully.";
	
	public void WSTemplate() throws Exception
	{
		wsdashboard.click();
		createwst.click();
		
		wstname.sendKeys(wsname);
		wstdescription.sendKeys("WST created using selenium script");
		wstactivate.click();
		witlist.click();
		selectwit.click();
		assignwit.click();
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wsnote.click();
		wait.until(ExpectedConditions.elementToBeClickable(savewst));
		savewst.click();
		wait.until(ExpectedConditions.textToBePresentInElement(successmsg, WSTSM));	
		
		wstsearch.sendKeys(wsname);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(foundWST, wsname));
		editwstbtn.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElementValue(wstname,wsname));
		((JavascriptExecutor)driver).executeScript("scroll(0,300)");
		witlist.click();
		selectwit.click();
		searchbox.sendKeys(SCWITemplate.WIT);
		Thread.sleep(3000);
		selectallbtn.click();
		assignwit.click();
		Thread.sleep(3000);
		deactivatewit.click();
		savewst.click();
		wait.until(ExpectedConditions.textToBePresentInElement(editwstsuccessmsg, EWSTSM));
	}
}
