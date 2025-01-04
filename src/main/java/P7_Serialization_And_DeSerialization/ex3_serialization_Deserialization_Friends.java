package P7_Serialization_And_DeSerialization;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ex3_serialization_Deserialization_Friends
{	
	ObjectMapper mapper=new ObjectMapper();
	
	//@Test(priority = 1)
	public void serialization() throws StreamWriteException, DatabindException, IOException 
	{
		FriendsPojo fp=new FriendsPojo();                 //create pojo class with constructor parameter
		fp.setFirstname("abc1");
		fp.setLastname("xyz1");
		fp.setId(101);
		fp.setAge(20);
																	//no need to create these files manually
		mapper.writeValue(new File("JsonFiles/friend.json"), fp);     //writing data from java object into file  --serialization
	}
	
	
	@Test(priority = 2)
	public void DeSerialization() throws StreamWriteException, DatabindException, IOException 
	{
		FriendsPojo friendPojoObj = mapper.readValue(new File("./JsonFiles/friend.json"), FriendsPojo.class);    //reading data from json file into java object
		System.out.println(friendPojoObj.getFirstname());
		System.out.println(friendPojoObj.getLastname());
		System.out.println(friendPojoObj.getID());
		System.out.println(friendPojoObj.getAge());	
	}
	
}
