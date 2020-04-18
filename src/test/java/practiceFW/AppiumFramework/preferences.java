package practiceFW.AppiumFramework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class preferences {

	@SuppressWarnings("rawtypes")
	public preferences(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //appium field dec provides compatability for Both android and IOS platform
		
	}
	

	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement Preferences;
}
