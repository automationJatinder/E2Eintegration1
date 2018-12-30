package flipkart.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import flipkart.OR.OR;
import flipkart.Pages.LoginPage;
import flipkart.base.Base;

public class TC_01_VerifyTitle extends Base implements OR{

	
	@Test
	public void verifyTitle() throws InterruptedException 
	{
		waitUntilPresence(By.xpath("//div[@class='_39M2dM']/input[@class='_2zrpKA']"));
		driver.findElement(By.xpath("//div[@class='_39M2dM']/input[@class='_2zrpKA']")).sendKeys(Keys.ESCAPE);
		click_Menu("Men", "Jackets");
		Click(By.xpath("//*[a='Login & Signup']"));
		type(By.xpath("//div[@class='_39M2dM']/input[@class='_2zrpKA']"),"7834840555");
		type(By.xpath("//input[@type='password']"),"Khalsa@13");
		Click(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
	}
}
