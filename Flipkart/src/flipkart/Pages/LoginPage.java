package flipkart.Pages;

import org.openqa.selenium.By;
import flipkart.base.Base;
import flipkart.constants.Constants;

public class LoginPage {
	
	
	By login_username = By.xpath("//input[@class='_2zrpKA']");
	By login_password = By.xpath("//input[@type='password']");
	By login_login_button = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	
	
	public void loginFlipkart()
	{
		Base.elementTobeVisible(login_username);
		Base.type(login_username,Constants.Email);
		Base.type(login_password,Constants.Password);
		Base.Click(login_login_button);
	}

}
