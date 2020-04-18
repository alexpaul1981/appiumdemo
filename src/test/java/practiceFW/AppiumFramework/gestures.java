package practiceFW.AppiumFramework;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element; 

public class gestures extends base {

	@Test
	public void artofgestures() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		service =startServer();  // to run the server via base.java class
		Thread.sleep(8000);
		
		AndroidDriver<AndroidElement> driver=Capabilities("APIDEMOAPP");  // Data type of driver is AndroidDriver<AndroidElement>
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//driver.findElementByAndroidUIAutomator("Preference").click();
		
		//Writing Touch action codes
		
		@SuppressWarnings("rawtypes")
		
		TouchAction t=new TouchAction(driver);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		
		WebElement expandList= driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
		
		t.tap(tapOptions().withElement(element(expandList))).perform();
		
		System.out.println("This Test is completed");
		Thread.sleep(4000);
		
		
		
		service.stop();

	}
	}


