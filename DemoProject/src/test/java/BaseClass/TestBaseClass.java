package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
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
	

	public static  WebDriver launchBrowser(String BrowserName) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("Properties/config.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase("internetexplorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
		}
		else if(BrowserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver =new SafariDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
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
	
}
