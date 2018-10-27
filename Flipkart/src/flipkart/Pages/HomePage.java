package flipkart.Pages;

import org.apache.log4j.Logger;
import flipkart.base.Base;


public class HomePage extends Base {

	Logger log=Logger.getLogger(HomePage.class);
	
	public void verifyLoggedInUser()
	{
		
//		System.out.println(b.get_Attribute("Electronics", "Mi"));
	}
	
	public void verifyPopUp()
	{
		base.elementTobeVisible(newToFlipkart_link);
		log.debug(newToFlipkart_link+ "is visible verified");
	}
	
	
	
}
