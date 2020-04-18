package practiceFW.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Setting {

	@SuppressWarnings("rawtypes")
	public Setting(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //appium field dec provides compatability for Both android and IOS platform
		
	}
	

	@AndroidFindBy(className="android.widget.EditText")
	public WebElement EditSettings;
	
}
