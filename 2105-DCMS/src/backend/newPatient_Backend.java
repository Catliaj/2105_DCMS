package backend;

public class newPatient_Backend 
{
	private String firstName,MiddleInitial, lastName, gender,ContactNumber,DateOfBirth,Email,Address;
	private int age;
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return MiddleInitial;
	}
	public void setMiddleInitial(String middleInitial) 
	{
		MiddleInitial = middleInitial;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public String getContactNumber() 
	{
		return ContactNumber;
	}
	
	public void setContactNumber(String contactNumber) 
	{
		ContactNumber = contactNumber;
	}
	
	public String getDateOfBirth() 
	{
		return DateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth)
	{
		DateOfBirth = dateOfBirth;
	}
	
	public String getEmail() 
	{
		return Email;
	}
	
	public void setEmail(String email) 
	{
		Email = email;
	}
	
	public String getAddress() 
	{
		return Address;
	}
	
	public void setAddress(String address) 
	{
		Address = address;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
}
