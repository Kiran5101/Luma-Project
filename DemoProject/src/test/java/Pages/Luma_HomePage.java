package Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Luma_HomePage {
	public WebDriver driver;
	
	@FindBy(how=How.XPATH,using="(//a[starts-with(text(),'Create')])[1]")
	WebElement CreateAnAccountLink;
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Sign ')])[1]")
	WebElement SignInLink;
	
	@FindBy(how=How.XPATH,using="//a[@class='logo']//child::img")
	WebElement LumaLogo;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement SearchBox;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement ShowCart;
	
	@FindBy(xpath="//span[starts-with(text(),'Wha')]")
	WebElement WhatsNewLInk;
	
	@FindBy(xpath="//span[starts-with(text(),'Wome')]")
	WebElement WomenLink;
	
	@FindBy(xpath="//span[starts-with(text(),'Men')]")
	WebElement MenLink;
	
	@FindBy(xpath="//span[starts-with(text(),'Gear')]")
	WebElement GearLink;
	
	@FindBy(xpath="//span[starts-with(text(),'Train')]")
	WebElement TrainingLink;
	
	@FindBy(xpath="//span[starts-with(text(),'Sale')]")
	WebElement SaleLink;
	
	@FindBy(xpath="//span[starts-with(text(),'Home')]")
	WebElement HompPageHeader;
	
	@FindBy(xpath="//a[@class='block-promo home-main']//img")
	WebElement HomePageImage;
	
	@FindBy(xpath="//strong[contains(text(),'Get')]")
	WebElement NewLumaCollectionLink;
	
	@FindBy(xpath="//h2[@class='title']")
	WebElement HotSellersText;
	
	@FindBy(xpath="//p[@class='info']")
	WebElement TrendingText;
	
	@FindBy(xpath="//li[@class='product-item']")
	List<WebElement> productsList;
	
	@FindBy(xpath="//a[starts-with(@class,'product-ite')]")
	List<WebElement> ProductNamesList;
	
	@FindBy(xpath="//strong[starts-with(@class,'product name product-item-name')]//child::a[contains(text(),'"+Radiant Tee+"')]")
	WebElement ProductName;
	
	@FindBy(xpath="//a[starts-with(text(),'Notes')]")
	WebElement NotesLink;
	
	@FindBy(xpath="//a[starts-with(text(),'Pra')]")
	WebElement ApiTestingLink;
	
	@FindBy(xpath="//a[starts-with(text(),'Writ')]")
	WebElement WriteForUs;
	
	@FindBy(xpath="//a[starts-with(text(),'Sub')]")
	WebElement Subscribe;
	
	@FindBy(xpath="//a[starts-with(text(),'Sea')]")
	WebElement SearchTerms;
	
	@FindBy(xpath="//a[starts-with(text(),'Privac')]")
	WebElement PrivacyAndCookiePolicyLink;
	
	@FindBy(xpath="//a[starts-with(text(),'Advanced')]")
	WebElement AdvancedSearch;
	
	@FindBy(xpath="//a[starts-with(text(),'Order')]")
	WebElement OrdersAndReturns;
	
	@FindBy(xpath="//span[starts-with(text(),'Add')]")
	List<WebElement> AddToCart;
	
	public Luma_HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click(WebElement ele) {
		ele.click();
	}
	public boolean isWebElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	public boolean containsProduct(String inputText,String searchText) {
		boolean flag=false;
		String[] sa=inputText.split("\\s");
		for(String si:sa) {
			if(si.equalsIgnoreCase(searchText)) {
				flag=true;
				break;
			}
		}
		
		return flag;
	}
	
	public boolean searchFeature(String InputProdcutName) throws InterruptedException{
		boolean flag=false;
		SearchBox.sendKeys(InputProdcutName);
		SearchBox.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(3000);
		for(WebElement we:ProductNamesList) {
			if(containsProduct(we.getText(),InputProdcutName)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	public void clickOnSignIn() {
		SignInLink.click();
	}
	
	public void addAnItemToTheCart(String ProductName) {
		SearchBox.sendKeys(ProductName);
		SearchBox.sendKeys(Keys.chord(Keys.ENTER));
		List<WebElement> ProductNames=ProductNamesList;
		for(WebElement we:ProductNamesList) {
			if(we.getText().equalsIgnoreCase(ProductName)) {
				
			}
		}
	}

}
