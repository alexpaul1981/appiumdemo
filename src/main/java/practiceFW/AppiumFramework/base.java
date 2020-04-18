package practiceFW.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
	public static AppiumDriverLocalService service; //intialize service
	
	//Start Appium Server
	public static AppiumDriverLocalService startServer() throws InterruptedException
		{
		boolean flag= checkifServerIsRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		Thread.sleep(8000);
		
		}
		return service;
	}
	
	// Socket programming code method to check the server status
	private static boolean checkifServerIsRunning(int port) {

			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket=new ServerSocket(port);
				serverSocket.close();
				}
			catch (IOException e){
				//if control comes here ,then it means the port is in use
				isServerRunning = true;
				}
			finally{
				serverSocket = null;
				}
			return isServerRunning;
	}
public static void startEmulator() throws IOException, InterruptedException 
{
	Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\Emulator.bat");
	Thread.sleep(8000);
}
	//public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException{ // Function for Capabilities
	public static AndroidDriver<AndroidElement> Capabilities (String appName) throws IOException, InterruptedException  {
		
		
	//Get the current project path dynamically	
	//System.getProperty("user.dir");	
		
 //Reading the file from global.properties file
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\practiceFW\\AppiumFramework\\global.properties");		
		
		Properties prop=new Properties(); //creating prop object
		prop.load(fis);   // loading the read values to prop object
		
		
		// Code to import the apk file from the source path 
		
		File appDir=new File("src");  // accessing the source folder
		File apkpath=new File(appDir,prop.getProperty("APIDEMOAPP")); // accessing the apk file 
		
		// Appium Code for desired capabilities
		
				
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//Creating global.properties reading for devices
String device=prop.getProperty("DEVICE");   // Reading from global properties file
//String device=System.getProperty("deviceName"); // manually remove the value of device in global properties file and 
												//provide -DdeviceName="Device name" while running from Maven
if(device.contains("Pixel"))
{
startEmulator();

}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device); // providing the emulator name
		
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Note 3"); // providing the real device name
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2"); // providing the uiautomator ui element in android
		cap.setCapability(MobileCapabilityType.APP,apkpath.getAbsolutePath()); // calling the apk file
		
		// Calling AndroidDriver and connecting to appium server and return the object
		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
		// Android UIAUtomator Tool capability ,UIautomatorviewer located in sdk/tool folder
		
		

	
	}
}

