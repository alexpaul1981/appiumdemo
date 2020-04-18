package practiceFW.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class homepage {

	//call the driver from test case to pageobject file and then contatenate driver
	@SuppressWarnings("rawtypes")
	public homepage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //appium field dec provides compatability for Both android and IOS platform
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement HomePagePreferences;
	
	
	
}
