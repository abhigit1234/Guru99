package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class ReadConfig {

	static Properties p ;
	static FileInputStream fis;
	public ReadConfig() throws IOException {
		
				p = new Properties();
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
				p.load(fis);
			
	}
	public String browser() {
		String browser = p.getProperty("browser_name");
		return browser;
	}
	public String baseurl() {
		String url = p.getProperty("base_url");
		return url;
	}
	
	public String username() {
		String username = p.getProperty("user_name");
		return username;
	}
	public String password() {
		String password = p.getProperty("user_pswd");
		return password;
	}
	public String cust_name() {
		String cust_name = p.getProperty("customer_name");
		return cust_name;
	}

	public String gender() {
		String gender = p.getProperty("gender");
		return gender;
	}
	public String day() {
		String date =p.getProperty("date");
		return date;
	}

	public String month() {
		String mon =p.getProperty("mon");
		return mon;
	}

	public String year() {
		String year =p.getProperty("year");
		return year;
	}
	
	public String address() {
		String address = p.getProperty("address");
		return address;
	}
	public String city() {
		String city = p.getProperty("city");
		return city;
	}
	public String state() {
		String state = p.getProperty("state");
		return state;
	}
	public String pincode() {
		String pincode = p.getProperty("pin");
		return pincode;
	}
	public String mob() {
		String mobnum = p.getProperty("mob");
		return mobnum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
