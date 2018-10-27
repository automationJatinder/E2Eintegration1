package flipkart.base;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import flipkart.OR.OR;
import flipkart.Pages.HomePage;
import flipkart.constants.Constants;

public class Base implements OR {
	
	public static WebDriver driver;
	public Base base;
	public HomePage homePage; 
	private WebDriverWait wait;
	Logger log=Logger.getLogger(Base.class);
	{
		wait = new WebDriverWait(driver, 60);
		base = new Base();
	}
	
	@BeforeClass
	public void openBrowser()
	{
		try
		{	
		
		if(Constants.Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.out.println("chrome opened");
			log.debug("Chrome Opened");
		}
		else if (Constants.Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(Constants.URL);
		
		
		}
		catch (Exception e)
		{
			System.out.println("Browser Name is "+ Constants.Browser+" which is not equal to firefox or chrome");
			e.printStackTrace();
		}
	}
	
	public WebElement findElement(By by)
	{
		
	return driver.findElement(by); 
	}
	
	public  void type(By locator,String input)
	{
		System.out.println("type function working");
		findElement(locator).sendKeys(input);
	}
	
	public void Click(By locator)
	{
		findElement(locator).click();
	}
	
	@AfterTest
	private void closeBrowser()
	{
		driver.quit();
	}
	
	public void elementTobeVisible(By locator)
	{
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		WebElement element=driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		if(locator.toString().contains("link"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
	}
	
	public static ArrayList<WebElement> findElements(By locator)
	{
		ArrayList<WebElement> list= (ArrayList<WebElement>) driver.findElements(locator);
		return list;
	}
	
	public String get_Attribute(By locator, String attribute)
	{
		return findElement(locator).getAttribute(attribute);
	}
	
	public void click_Menu(String Menu, String Submenu) throws InterruptedException
	{
//		elementTobeVisible(By.xpath("//span[text()='"+Menu+"']"));
		Thread.sleep(1000);  
		driver.findElement(By.xpath("//span[text()='"+Menu+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='"+Submenu+"']")).click();
	}
}
