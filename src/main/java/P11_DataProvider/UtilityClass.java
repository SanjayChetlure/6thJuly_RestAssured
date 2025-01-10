package P11_DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class UtilityClass
{	  
	   @DataProvider
	   public static Iterator<Object[]> getExcelData(Method TCName) throws IOException
	   {
	       FileInputStream file = new FileInputStream("D:\\6th July 2024\\Workspace\\6thJuly_RestAssured\\src\\main\\java\\P11_DataProvider\\TD1.xlsx");
	       Workbook book = WorkbookFactory.create(file);
	       Sheet sh = book.getSheet("Sheet1");
	       
	       ArrayList<Object[]> al = new ArrayList<Object[]>();
	      
	       //Getting row data for test case
	       for (int i = 1; i <= sh.getLastRowNum(); i++)
	       {         
	           String SERVICE_ENDPOINT;
	   	        
	            String TCCellName = sh.getRow(i).getCell(1).getStringCellValue();;   //TC2
	         	          
	           //Checking test case name and returning that data
	           if (TCName.getName().equalsIgnoreCase(TCCellName))  // TC2==TC2
	           {	        	   
	        	   String ServiceBaseURL= sh.getRow(i).getCell(2).getStringCellValue();
		           String ServiceURI= sh.getRow(i).getCell(3).getStringCellValue();
		           String httpMethodName = sh.getRow(i).getCell(4).getStringCellValue();
		           String statusCodeCell = sh.getRow(i).getCell(5).getStringCellValue();
		           String respMsg = sh.getRow(i).getCell(6).getStringCellValue();
	        	   
	               //Set URL with URI
	               SERVICE_ENDPOINT = ServiceBaseURL + ServiceURI;
	               Object ar[] = {httpMethodName, SERVICE_ENDPOINT,Integer.parseInt(statusCodeCell),respMsg};
	               al.add(ar);
	           }
	       }
	      
	      Iterator<Object[]> itr = al.iterator();
	       
	       book.close();
	       return itr;
	   }
}
