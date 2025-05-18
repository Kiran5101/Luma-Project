package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.Luma_HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageSteps {
	WebDriver driver=null;
	Luma_HomePage lumaPage;
	boolean fla;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().deleteAllCookies();
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	@Given("User launches the Luma Project application on a browser")
	public void user_launches_the_luma_project_application_on_a_browser() {
	    
	    driver.navigate().to("https://magento.softwaretestingboard.com/");
	}

	@When("user enter the searchtext and clicks the enter button")
	public void user_enter_the_searchtext_and_clicks_the_enter_button() throws InterruptedException {
	   lumaPage=new Luma_HomePage(driver);
	   //lumaPage.clickOnSearch();
	   //lumaPage.sendTextToSearchBox("Tee");
	  // lumaPage.submitSearch();
	   
		fla=lumaPage.searchFeature("dfhfgj");
	   Thread.sleep(3000);
	}

	@Then("user must be able to see the matched products on the screen")
	public void user_must_be_able_to_see_the_matched_products_on_the_screen() throws InterruptedException {
	   Assert.assertTrue(fla);
	}




}
