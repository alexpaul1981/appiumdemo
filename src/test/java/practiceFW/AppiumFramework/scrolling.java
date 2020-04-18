package practiceFW.AppiumFramework;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrolling extends base {

	@Test
	public void scrolltest() throws IOException, InterruptedException {

		service =startServer();  // to run the server via base.java class
		Thread.sleep(8000);
		
		AndroidDriver<AndroidElement> driver=Capabilities("APIDEMOAPP");  // Data type of driver is AndroidDriver<AndroidElement>
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  //for managing thread sleep
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		// Bring the Android API for scrolling "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
		
		service.stop();
	}
 
}
