package flipkart.Pages;

import org.openqa.selenium.By;

import flipkart.base.Base;

public class HomePage extends Base {

	Base b=new Base();
	By username=By.xpath("//div[@class='_2cyQi_']");
	
	
	public void verifyLoggedInUser()
	{
		Base.elementTobeVisible(username);
//		System.out.println(b.get_Attribute("Electronics", "Mi"));
	}
	
	
	
}
