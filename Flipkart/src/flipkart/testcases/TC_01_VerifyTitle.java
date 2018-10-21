package flipkart.testcases;


import org.testng.annotations.Test;

import flipkart.Pages.HomePage;
import flipkart.Pages.LoginPage;
import flipkart.base.Base;

public class TC_01_VerifyTitle extends Base {

//	WebDriver driver;
	LoginPage login = new LoginPage();
	HomePage home=new HomePage();
	
	@Test
	public void verifyTitle() throws InterruptedException 
	{
		login.loginFlipkart();
		home.verifyLoggedInUser();
		click_Menu("Electronics", "Mi");
	}
	
	
}
