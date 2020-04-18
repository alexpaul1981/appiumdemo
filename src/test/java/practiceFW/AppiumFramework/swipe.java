package practiceFW.AppiumFramework;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element; // for line #29
import static java.time.Duration.ofSeconds;     // for line #29 with duration java 

import java.io.IOException;

public class swipe extends base {
	
	@Test
	public void swiping() throws IOException, InterruptedException {
		
		service=startServer();
		Thread.sleep(8000);
		
		AndroidDriver<AndroidElement> driver=Capabilities("APIDEMOAPP");  // Data type of driver is AndroidDriver<AndroidElement>
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	// TODO Auto-generated method stub
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		// Swiping code
		
		@SuppressWarnings("rawtypes")
		TouchAction t=new TouchAction(driver);
		
		WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second=driver.findElementByXPath("//*[@content-desc='45']");
		
		//longpress //on element first //for 2 sec // move to other element //then release //perform the action
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(1))).moveTo(element(second)).release().perform();
		
		Thread.sleep(5000);

		service.stop();
	}

}
