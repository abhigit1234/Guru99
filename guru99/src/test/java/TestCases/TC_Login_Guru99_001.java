package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.w3c.dom.xpath.XPathResult;

import PageObjectModel.Page_object;
import Utilities.ReadConfig;
import Utilities.ReadXlSXData;

public class TC_Login_Guru99_001 extends BaseClass {

	@Test(dataProviderClass = ReadXlSXData.class,dataProvider = "Guru_Customer_Details",groups = {"smoke","sanity","regression","functional","whitebox","blackbox","daily build","weekly build"})

	public void login(Object[] s) throws InterruptedException, IOException {
		ReadConfig rc = new ReadConfig();
		Page_object pom = new Page_object(driver);
		logger.info("user entered name");
		extenttest.info("username entered");
		pom.set_username(s[0]);
		extenttest.info("password entered");
		logger.info("user entered password");
		pom.set_pswd(s[0]);
		extenttest.info("clicked on login button");
		logger.info("user clicked login button");
		pom.click_login();
		
		if(isAlertPresent()==true) {
			extenttest.info("alert accepted");
			logger.info("user accepted alert");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			assertTrue(false);
		}
		else {
			extenttest.info("no alert shown");
			logger.info("no alert is shown");
			assertTrue(true);
		}
		extenttest.info("manager id verified by user");
		logger.info("manager id verified");
		pom.verify_id();
		extenttest.info("clicked on new customer");
		logger.info("clicked on new customer");
		pom.click_newcust();
		Thread.sleep(4000);
		extenttest.info("customer name entered");
		logger.info("new customer added name");
		pom.set_cname(s[2]);
		extenttest.info("customer gender entered");
		logger.info("gender selected");
		pom.set_gender(s[3]);
		extenttest.info("customer dob entered");
		logger.info("birth - date entered ");
		pom.set_dob(s[4], s[5], s[6]);
		extenttest.info("customer address entered");
		logger.info("address added");
		pom.set_address(s[7]);
		extenttest.info("customer entered city name");
		logger.info("user entered city ");
		pom.set_city(s[8]);
		extenttest.info("customer entered state name");
		logger.info("user entered state");
		pom.set_state(s[9]);
		extenttest.info("customer entered pincode");
		logger.info("pincode entered by customer");
		pom.set_pin(s[10]);
		extenttest.info("customer entered mobile number name");
		logger.info("mobile number entered by customer");
		pom.set_mob(s[11]);
		extenttest.info("customer entered email id");
		logger.info("email entered by customer");
		String email = email();
		System.out.println(email);
		pom.set_email(email+"@gamil.com");
		extenttest.info("customer entered password");
				logger.info("password number entered by customer");
		String pswd = password();
		System.out.println(pswd);
		pom.set_password(pswd);
		Thread.sleep(6000);
		extenttest.info("customer clicked on submit button");
		logger.info("clicked on submit button");
		pom.clicksubmit();
		logger.info("success message displayed");
		extenttest.info("successfull registered status verified ");
		pom.statussuccess();
		Thread.sleep(2000);
		//pom.logout();
		extenttest.info("customer logged out of page");
		logger.info("clicked on logout button");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	WebElement click = driver.findElement(By.xpath("//li/a[text()='Log out']"));
		jse.executeScript("arguments[0].click()",click);
		
		extenttest.info("finally customer acepted alert and returned back to default content");
		logger.info("alert handled and accepted successfully");
		driver.switchTo().alert().accept();
		 
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public String email() {
		String email = RandomStringUtils.randomAlphabetic(10);
		return email;
	}
	public String password() {
		String pswd = RandomStringUtils.randomNumeric(10);
		return pswd;
	}

		
		
		

		
/*		ReadConfig rc = new ReadConfig();
		Page_object pom = new Page_object(driver);
		pom.set_username(rc.username());
		pom.set_pswd(rc.password());
		pom.click_login();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			assertTrue(false);
		}
		else {
			assertTrue(true);
		}
		pom.verify_id();
		pom.click_newcust();
		Thread.sleep(4000);
		pom.set_cname(rc.cust_name());
		pom.set_gender(rc.gender());
		
		pom.set_dob(rc.day(), rc.month(), rc.year());
		
		pom.set_address(rc.address());
		pom.set_city(rc.city());
		pom.set_state(rc.state());
		pom.set_pin(rc.pincode());
		pom.set_mob(rc.mob());
		String email = email();
		System.out.println(email);
		pom.set_email(email+"@gamil.com");
		String pswd = password();
		System.out.println(pswd);
		pom.set_password(pswd);
		Thread.sleep(2000);
		pom.clicksubmit();
		pom.statussuccess();
		Thread.sleep(2000);
		//pom.logout();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	WebElement click = driver.findElement(By.xpath("//li/a[text()='Log out']"));
		jse.executeScript("arguments[0].click()",click);
		
		
		driver.switchTo().alert().accept();
		 
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public String email() {
		String email = RandomStringUtils.randomAlphabetic(10);
		return email;
	}
	public String password() {
		String pswd = RandomStringUtils.randomNumeric(10);
		return pswd;
	}
	*/
	
	
}
