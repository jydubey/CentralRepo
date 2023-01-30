package central.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import central.Utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;



public class CommonClass 
{
	Readconfig RC = new Readconfig();
	public String baseurl = RC.getapplicationURL();
	public String username = RC.getusername();
	public String password = RC.getpassword();
	public WebDriver driver;
	
//	public ExtentReports extent = new ExtentReports();
//    ExtentSparkReporter spark = new ExtentSparkReporter("Reports//SCReport.html");
	
	@Parameters("browser")
	@BeforeClass
	public void launchbrowser(String br)
	{
		//ExtentTest test = extent.createTest("Hitting the URL");
		if(br.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		driver.get(baseurl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		test.pass("entered url successfully");
//		extent.flush();
	}
//	@BeforeSuite
//    public void reports() {
//
//        spark.config().setTheme(Theme.DARK);
//        spark.config().setDocumentTitle("Facebook Report");
//        spark.config().setDocumentTitle("Screen shot module");
//        extent.attachReporter(spark);
//	}

	
	
	public String capturescreen(WebDriver driver, String TCname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + TCname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	return target.getAbsolutePath();
}
	@AfterClass
    public void closebrowser()
    {
        //driver.quit();
        //extent.flush();
    }
	
	public String date() 
	{
		Random rand= new Random();
		int randValue=rand.nextInt(10);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE,randValue);
		c.add(Calendar.MONTH, 2);
		c.add(Calendar.YEAR, 2);
		Date d= c.getTime();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMM-YYYY");
		String dateString = sdf.format(d);
		return dateString;
		
		}
	static ExtentReports extentReport;
    public static ExtentReports getExtentReport() {
    	
    	Date date=new Date();
        System.out.println(date.toString().replaceAll(":", "-"));
        String reportsFolder=date.toString().replaceAll(":", "-")+"//screenshots";
        String screenShotFolderPath= System.getProperty("user.dir")+"//Reports//"+reportsFolder;
        String reportFolderPath= System.getProperty("user.dir")+"//Reports//"+date.toString().replaceAll(":", "-");
        //System.out.println(path);
        File f=new File(screenShotFolderPath);
        f.mkdirs();
            
            String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportFolderPath);
            reporter.config().setReportName("Regression Pack");
            reporter.config().setDocumentTitle("Sc Automation Report");
            
            extentReport = new ExtentReports();
            extentReport.attachReporter(reporter);
            //extentReport.setSystemInfo("Tested By","YBVN");
            
            
            return extentReport;
            
        }
    public void acctnav()
    {
    	driver.findElement(By.xpath("//a[@href='/User/Index']")).click();
    	
    }
}
