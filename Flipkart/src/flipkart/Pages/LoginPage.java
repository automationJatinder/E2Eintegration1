package flipkart.Pages;

import flipkart.OR.OR;
import flipkart.base.Base;
import flipkart.base.BasePage;

public class LoginPage extends Base implements OR, BasePage {
	
	
//	By login_username = By.xpath("//input[@class='_2zrpKA']");
//	By login_password = By.xpath("//input[@type='password']");
//	By login_login_button = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	
	
	public void loginFlipkart()
	{
		System.out.println(" in loginFlipkart");
		
		if(driver==null)
		{
			System.out.println("driver null");
		}
		else
		{
			System.out.println("driver not null");
		}
		type(email_txt, "adas@asds.com");
	}

}
