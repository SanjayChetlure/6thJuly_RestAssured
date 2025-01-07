package P11_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample1 
{
	@DataProvider
	public Object[][] data()
	{
		Object [][] obj= {
							{"amol","patil",102},
							{"rahul","patil",103}
						};
		return obj;
	}
	
	
	@Test(dataProvider = "data")
	public void TC1(String fn, String ln, int rollNum) 
	{
		System.out.println(fn);
		System.out.println(ln);
		System.out.println(rollNum);
	}

}
