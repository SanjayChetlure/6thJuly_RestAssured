package P11_DataProvider;

import org.testng.annotations.Test;

public class StudentsTest 
{
	  // @Test(dataProvider = "getExcelData", dataProviderClass = UtilityClass.class)
	   public void TC1(String httpMethodName, String serviceEndpoint, int statusCode, String respMsg)
	   {
	   		System.out.println(httpMethodName);
	   		System.out.println(serviceEndpoint);
	   		System.out.println(statusCode);
	   		System.out.println(respMsg);
	   }
	   
	   
	  // @Test(dataProvider = "getExcelData", dataProviderClass = UtilityClass.class)
	   public void TC2(String httpMethodName, String serviceEndpoint, int statusCode, String respMsg)
	   {
	   		System.out.println(httpMethodName);
	   		System.out.println(serviceEndpoint);
	   		System.out.println(statusCode);
	   		System.out.println(respMsg);
	   }
	   
	   @Test(dataProvider = "getExcelData", dataProviderClass = UtilityClass.class)
	   public void TC3(String httpMethodName, String serviceEndpoint, int statusCode, String respMsg)
	   {
	   		System.out.println(httpMethodName);
	   		System.out.println(serviceEndpoint);
	   		System.out.println(statusCode);
	   		System.out.println(respMsg);
	   }
}
