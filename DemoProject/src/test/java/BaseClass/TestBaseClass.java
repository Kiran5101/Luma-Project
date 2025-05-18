package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	public static WebDriver driver;
	
	public static void getProperties(){
		try {
	
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("Properties/config.properties");
	prop.load(fis);
	System.out.println(prop.getProperty("browser"));
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	

	public static  WebDriver launchBrowser(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.iedriver().setup();;
			driver=new InternetExplorerDriver();
		}
		else if(BrowserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver =new SafariDriver();
		}
		return driver;
	}
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	public static void main(String[] args) {
		//TestBaseClass tb=new TestBaseClass() {
			getProperties();
	}
	public void clickOn

}
