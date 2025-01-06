package P9_FakerLibrary_APIChaining;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakeDataGenerator 
{
	@Test
	public void FakerLibraryDataGenerator()
	{
		Faker f=new Faker();
		
		System.out.println(f.name().firstName());
		System.out.println(f.name().lastName());
		System.out.println(f.name().fullName());
		
		System.out.println(f.name().username());
		System.out.println(f.internet().password());
		
		System.out.println(f.phoneNumber().subscriberNumber(10));
		System.out.println(f.internet().emailAddress());
		
		System.out.println(f.business().creditCardExpiry());
		System.out.println(f.business().creditCardNumber());
		
		System.out.println(f.color().name());		
		System.out.println(f.animal().name());
	}
}
