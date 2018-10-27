package flipkart.OR;

import org.openqa.selenium.By;



public interface OR {

	// Sign In Page
	By email_txt = By.xpath("//input[@class='_2zrpKA']");
	By LoginAndSignUp_link =By.linkText("Login & Signup");
	By newToFlipkart_link=By.xpath("//span[text()='New to Flipkart? Sign up']");
	By login_btn =By.xpath("//button//span[text()='Login']");
	By mobileNumber_txt =By.xpath("//input[@maxlength='10']");
	
	
}