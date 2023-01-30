package central.PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import central.TestCases.CommonClass;



public class SCRole extends CommonClass{
	
	WebDriver ldriver;
	public SCRole(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href='/User/Index']")//"/html/body/div[1]/aside/section/ul/li[3]/ul/li[1]/a")
	public WebElement acctdashboard;
	
	@FindBy(xpath = "//span[text() = ' Create a new role']")///html/body/div[1]/div[2]/section/div[1]/form/div/div/div/div/div/div/div[2]/div[1]/a/span
	public static WebElement createrole;
	
	@FindBy(id = "txtRoleName")
	public static WebElement rname;
	
	@FindBy(id = "chkIsassignExt")
	public static WebElement isassignext;
	
	@FindBy(id = "GetPermissions")
	public static WebElement assignprivileges;
	
	@FindBy(id = "prlgGroup1")
	public static WebElement accd;
	
	@FindBy(id = "Maptorole")
	public static WebElement maptorole;
	
	@FindBy(id = "RoleSubmitSave")
	public static WebElement rsave;
	
	@FindBy(id = "AccountMngDashboardSuccess")
	public static WebElement rolesuccess;
	
	@FindBy(id = "txtRoleNameSearchField")
	public static WebElement rsearch;
	
	@FindBy(xpath = "//a[@class ='editRole']")//"//*[@id=\"RolesGrid\"]/tbody/tr/td[4]/a[3]"
	public static WebElement editrole;
	
	@FindBy(id = "ModifyPermission")
	public static WebElement rmodifybtn;
	
	@FindBy(id = "prlgtype3")
	public static WebElement uncheckpriv;
	
	@FindBy(id = "prlgGroup10")
	public static WebElement wmgmtpriv;
	
	@FindBy(id = "MaptoroleUpdate")
	public static WebElement rupdate;
	
	@FindBy(id = "RoleSubmitUpdate")
	public static WebElement rupdatebtn;
	
	@FindBy(id = "roleUpdateMsg")
	public static WebElement rupdatesuccess;
	
	@FindBy(id = "CancelRole")
	public static WebElement cancelrole;
	
	@FindBy(xpath = "//a[@class ='CloneRole']")//////*[@id=\"RolesGrid\"]/tbody/tr/td[4]/a[2]/span
	public static WebElement clonerole;
	
	@FindBy(id = "RoleSubmitClone")
	public static WebElement rclonesave;
	
	 @FindBy(xpath = "//td[text() ='No roles exist']")////*[@id=\\\"RolesGrid\\\"]/tbody/tr/td
	 public static WebElement noroleexist;
	 
	
	public void role() throws Exception
	{
		Faker faker=new Faker();
		acctdashboard.click();
		SCRole.createrole.click();
		String rtext = faker.name().name();
		SCRole.rname.sendKeys(rtext.toLowerCase());
		SCRole.isassignext.click();
		SCRole.assignprivileges.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		SCRole.accd.click();
		SCRole.maptorole.click();
		SCRole.rsave.click();
		SCRole.rolesuccess.isDisplayed();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase());//.rtext
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));
        Boolean element = wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class='col-md-3 sorting_1']"), rtext.toLowerCase()));////*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]
		SCRole.editrole.click();
		SCRole.rmodifybtn.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SCRole.uncheckpriv.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//SCRole.wmgmtpriv.click();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SCRole.rupdate.click();
		SCRole.rupdatebtn.click();
		SCRole.rupdatesuccess.isDisplayed();
		SCRole.cancelrole.click();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase());
		Boolean celement = wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class='col-md-3 sorting_1']"), rtext.toLowerCase()));////*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]
		SCRole.clonerole.click();
		SCRole.rclonesave.click();
		SCRole.rolesuccess.isDisplayed();
	}
	

}
