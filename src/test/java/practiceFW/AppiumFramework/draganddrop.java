package practiceFW.AppiumFramework;
import org.testng.annotations.Test;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class draganddrop extends base{

	@Test
	public void dragtest () throws InterruptedException, IOException {
		service= startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("APIDEMOAPP");  // Data type of driver is AndroidDriver<AndroidElement>
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  //for managing thread sleep
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		

		//Code to find the source locator
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		// Code to find the destination locator
		WebElement dest=driver.findElementsByClassName("android.view.View").get(1);
		
		@SuppressWarnings("rawtypes")
		TouchAction t=new TouchAction(driver);
		
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(1))).moveTo(element(dest)).release().perform();
		
		
		service.stop();
		

	}

}
