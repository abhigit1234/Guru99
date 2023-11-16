package PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_object {

	public Page_object(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement login_btn;

	@FindBy(xpath = "//table[@align=\"center\"]//td[text()=\"Manger Id : mngr527275\"]")
	WebElement verify_ManagerId;

	@FindBy(xpath = "//ul[@class=\"menusubnav\"]//li/a[text()=\"New Customer\"]")
	WebElement click_newcustomer;
	
	@FindBy(id = "dismiss-button")
	WebElement dismiss_btn;
	
	@FindBy(name = "name")
	WebElement c_name;

	@FindBy(name = "rad1")
	List<WebElement> c_gender;

	@FindBy(name = "dob")
	WebElement c_dob;

	@FindBy(name = "addr")
	WebElement c_address;

	@FindBy(name = "city")
	WebElement c_city;

	@FindBy(name = "state")
	WebElement c_state;

	@FindBy(name = "pinno")
	WebElement c_pin;

	@FindBy(name = "telephoneno")
	WebElement c_mob;

	@FindBy(name = "emailid")
	WebElement c_email;

	@FindBy(name = "password")
	WebElement c_password;

	@FindBy(name = "sub")
	WebElement click_submit;
	
	@FindBy(xpath = "//table[@id=\"customer\"]/tbody/tr/td/p[text()=\"Customer Registered Successfully!!!\"]")
	WebElement status_success;
	
	@FindBy(xpath = "//body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	WebElement logout_btn;

	public void set_username(Object n) {
		username.sendKeys((CharSequence)n);
	}

	public void set_pswd(Object p) {
		password.sendKeys((CharSequence)p);
	}

	public void click_login() {
		login_btn.click();
	}

	
	public void verify_id() {
		String act = verify_ManagerId.getText();
		String exp = "Manger Id : mngr527275";
		assertEquals(act, exp);
	}

	public void click_newcust() {
		click_newcustomer.click();
	}

	public void close_btn() {
		dismiss_btn.click();
	}
		
	public void set_cname(Object cn) {
		c_name.sendKeys((CharSequence)cn);
	}
	public void set_gender(Object v) {
		for (WebElement sex : c_gender) {
		if(sex.getAttribute("value").equals((CharSequence)v)){
			sex.click();
		}
		}
	}
	public void set_dob(Object d,Object m,Object y) {
		c_dob.sendKeys((CharSequence)d,(CharSequence)m,(CharSequence)y);
	
	}
	public void set_address(Object a) {
		c_address.sendKeys((CharSequence)a);
	}
	public void set_city(Object c) {
		c_city.sendKeys((CharSequence)c);
	}
	public void set_state(Object st) {
		c_state.sendKeys((CharSequence)st);
	}
	public void set_pin(Object s) {
		c_pin.sendKeys(String.valueOf(s));
	}
	public void set_mob(Object mob) {
		c_mob.sendKeys(String.valueOf(mob));
	}
	public void set_email(Object email) {
		c_email.sendKeys((CharSequence)email);
	}
	public void set_password(Object pswd) {
		c_password.sendKeys((CharSequence)pswd);
	}
	public void clicksubmit() {
		click_submit.click();
	}	
	
	public void statussuccess() {
		String act = status_success.getText();
		String exp = "Customer Registered Successfully!!!";
		assertEquals(act, exp);
	}
	public void logout() {
		logout_btn.click();
	}
	
	
}
