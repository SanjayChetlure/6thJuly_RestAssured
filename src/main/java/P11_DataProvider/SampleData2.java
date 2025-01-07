package P11_DataProvider;

import org.testng.annotations.DataProvider;

public class SampleData2
{		
	@DataProvider
	public Object[][] m1() 
	{		
		Object[][] ar=	{
							{"https://reqres.in/api/users/2", 200},
							{"https://reqres.in/api/users?page=2", 200},
							{"https://reqres.in/api/users/23", 200}
							
						};
		return ar;
	}
	
}
