package practiceFW.AppiumFramework;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.touch.TapOptions;

public class Basics extends base { // extending the base class into this basics class - inheritance of parent class
	//into child class

	//public static void main(String[] args) throws InterruptedException, IOException {
		
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)  // data provider method and class name defined here
	public void Validation(String input) throws IOException, InterruptedException {
		
		service =startServer();  // to run the server via base.java class
		Thread.sleep(8000);
		AndroidDriver<AndroidElement> driver= Capabilities("APIDEMOAPP");  // Data type of driver is AndroidDriver<AndroidElement>
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		/* Finding the element using xpath eg "//classname[@attribute='Attributevalue']" 
		 * 
		*/
		
		// Creating Constructor class (part of pageObject factory tutorials)
		
		
		homepage hp=new homepage(driver);
		hp.HomePagePreferences.click();
		
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
	
		preferences pp=new preferences(driver);
		pp.Preferences.click();
		
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		driver.findElementById("android:id/checkbox").click();
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();  //using index value
		
		Setting st=new Setting(driver);
		st.EditSettings.click();
		st.EditSettings.sendKeys(input); //input from TestData.java file
		
		//driver.findElementByClassName("android.widget.EditText").sendKeys("rub786ies");
		driver.findElementById("android:id/button1").click();
		
		System.out.println("Test Completed");
		service.stop();
	}

//Method to kill all the running services if any are open by default
	
		@BeforeTest        // This is applied only when any of the tests are running
		public void killproc() throws IOException, InterruptedException {
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe"); Thread.sleep(10000);
		System.out.println("closed node.exe");
		 
		}
		
	}


