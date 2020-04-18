package practiceFW.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	

@DataProvider(name="InputData")
public Object[][] getDataInput() {
	
	@SuppressWarnings("unused")
	Object[][] obj=new Object [][]
			{
		{"Dolly@12345"},{"master@123"},{"Slave@1234"}
			};
	
			return obj;

}
}