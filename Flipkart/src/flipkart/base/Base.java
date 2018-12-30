package flipkart.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import flipkart.OR.OR;
import flipkart.Pages.HomePage;
import flipkart.Pages.LoginPage;
import flipkart.constants.Constants;

public class Base {
	
	public WebDriver driver;
//	public Base base;
	public HomePage homePage; 
	public LoginPage lp;
	public WebDriverWait wait;
	private static Map<String, BasePage> objRep = new HashMap<String, BasePage>();
	private Wait<WebDriver> w;
//	public Properties prop;
	
	
	public static BasePage getInstance(String input)
	{
		BasePage interfaceType =null;
		if(objRep.containsKey(input))
		{
			return (BasePage) objRep.get(input);
		}
		try {
			   String className = "flipkart.Pages."+input;// really passed in from config
			   Class c = Class.forName(className);
			   interfaceType = (BasePage)c.newInstance();
			   objRep.put(input, interfaceType);
//			   if (className.equals("com.path.to.ImplementationType") {
//			      ((ImplementationType)interfaceType).doSomethingOnlyICanDo();
//			   } 
			} catch (Exception e) {
			   e.printStackTrace();
			}
		return interfaceType;
	}
	
	@BeforeSuite
	public void befSuite() 
	{
		System.out.println("befs runing");
//		wait = new WebDriverWait(driver, 60);
//		homePage = new HomePage();
//		lp = new LoginPage();
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
			//log.debug("Chrome Opened");
		}
		else if (Constants.Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com");
		
		
		}
		catch (Exception e)
		{
			System.out.println("Browser Name is "+ Constants.Browser+" which is not equal to firefox or chrome");
			e.printStackTrace();
		}
	}
	
//	public String getProperty(String key)
//	{
//		String propName = prop.getProperty(key);
//		return propName;
//	}
	
	
	public WebElement findElement(By by)
	{		
		waitUntilPresence(by);
		
	return driver.findElement(by);
	}
	
//	public void test()
//	{
//		WebElement e =driver.findElement(By.cssSelector("font-weight"));
//		e.size
//		
//	}
	
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
		if(locator.toString().contains("link"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(findElement(locator)));
			System.out.println("2");
		}
		else if(locator.toString().toLowerCase().contains("chk"))
		{
			wait.until(ExpectedConditions.elementToBeSelected(locator));
		}	
	}
	
	public boolean isElementVisible(By locator)
	{
		return driver.findElement(locator).isDisplayed() ? true:false;
		
	}
	
//	public static ArrayList<WebElement> findElements(By locator)
//	{
//		ArrayList<WebElement> list= (ArrayList<WebElement>) driver.findElements(locator);
//		return list;
//	}
	
	public String get_Attribute(By locator, String attribute)
	{
		return findElement(locator).getAttribute(attribute);
	}
	
	public void click_Menu(String Menu, String Submenu) throws InterruptedException
	{
//		elementTobeVisible(By.xpath("//span[text()='"+Menu+"']"));
//		Thread.sleep(1000);  
		driver.findElement(By.xpath("//span[text()='"+Menu+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='"+Submenu+"']")).click();
	}
	
	public void click_Menu2(String Menu, String Submenu) throws InterruptedException
	{
//		elementTobeVisible(By.xpath("//span[text()='"+Menu+"']"));
//		Thread.sleep(1000);  
		driver.findElement(By.xpath("//span[text()='"+Menu+"']")).click();
		waitUntilPresence(By.xpath("//a[text()='"+Submenu+"']"));
		driver.findElement(By.xpath("//a[text()='"+Submenu+"']")).click();
	}
	
	public void waitUntilPresence(By by)
	{
//		getWebdriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
//		getWebdriverWait().until(ExpectedConditions.visibilityOf(findElement(by))); //generates StackOverfow
//		getWebdriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	private WebDriverWait getWebdriverWait(){
		if(wait==null)
		{
			wait = new WebDriverWait(driver, 30);
			return wait;
		}
		else
		{
			return wait;
		}
	}
	
	private Wait<WebDriver> getFluentWait()
	{
		if(w==null){
			w=new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofMillis(600))
					.ignoring(NoSuchElementException.class);
			return w;
		}
		else{
			return w;
		}
		
		
	}
//	public void getProperty() throws IOException
//	{
//		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Jitinder Pal\\git\\repository\\Flipkart\\OR.properties"));
//		prop=new Properties();
//		prop.load(reader);
//		reader.close();
//		
//			
//	}
}
