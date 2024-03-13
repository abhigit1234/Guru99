package TestCases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.ReadConfig;

public class BaseClass {

	static WebDriver driver;
	static Logger logger;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest extenttest;
	static String timestamp;
	static String repname;
	
	
	@Parameters({"browsername","url"})
	@BeforeTest
	public void initialiseBrowser(ITestContext context, String browsername,String url) throws IOException {
	logger = LogManager.getLogger(); 
	
		logger.info("browser opened");
		switch (browsername.toLowerCase()) {
		
			case "chrome":driver = new ChromeDriver();				
				break;
			case "firefox":driver = new FirefoxDriver();				
			break;
			case "edge":driver = new EdgeDriver();				
			break;

			default:System.out.println("invalid browser");
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			logger.info("url opened");
			driver.get(url);
		Capabilities	cap = ((RemoteWebDriver)driver).getCapabilities();
			extenttest =  extent.createTest(context.getName());
		String device =	cap.getBrowserName()+" "+cap.getBrowserVersion().substring(0,cap.getBrowserVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getName();
		extenttest.assignAuthor(author);
		extenttest.assignAuthor(device);
	}
	
	@AfterTest
	public void tearDown() {
		logger.info("driver closed");
		driver.close();
	}
	@BeforeSuite
	public void extentReports() {
		timestamp = new SimpleDateFormat("dd.MMM.yyyy.HH.mm.ss").format(new Date());
		 repname = "Test_Report"+timestamp+".html";
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("\\guru99\\"+repname);
		extent.attachReporter(spark);
		extent.setSystemInfo("os name", System.getProperty("os.name"));
		extent.setSystemInfo("os version", System.getProperty("os.version"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("user country", System.getProperty("user.country"));
		extent.setSystemInfo("java version", System.getProperty("java.version"));
		spark.config().setDocumentTitle("Guru99 Test Login");
		spark.config().setReportName("its ayaansh project");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");
	}
	@AfterSuite
	public void generateReports() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("\\guru99\\"+repname).toURI());
	}
	@BeforeMethod
	public void groupsstatus(Method m) {
		extenttest.assignCategory(m.getAnnotation(Test.class).groups());
	}
	@AfterMethod
	public void failedStatus(ITestResult result,Method m) {
		if(result.getStatus()==ITestResult.FAILURE) {
		String path =	capture(result.getTestContext().getName()+" "+result.getMethod().getMethodName()+".jpg");
		extenttest.addScreenCaptureFromPath(path);
		extenttest.fail(result.getThrowable());
		}
		else {
			if(result.getStatus()==ITestResult.SUCCESS ) {
				extenttest.pass(m.getName()+" test is passed");
			}
		}
	}
	
	
	public String capture(String filename) {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyyHHmmss");
		String date = ldt.format(dtf);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screenshot//"+date+filename);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}System.out.println("screen saved successfull");
			return dest.getAbsolutePath();
	}
	
}
