package P2_DiffrentWaysOfCreatingPostRequestBody;

public class StudentPojo 
{
	private String id;   //6
	private String name;  //Ajay
	private String location;
	private String phone;
	private String [] courses;
	
	public String getId() 
	{
		return id;
	}
	
	public void setId(String id) 
	{
		this.id = id;  //6
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)   // Ajay
	{
		this.name = name;   //Ajay
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public String getPhone() 
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String[] getCourses() 
	{
		return courses;
	}
	public void setCourses(String[] courses)
	{
		this.courses = courses;
	}

}
