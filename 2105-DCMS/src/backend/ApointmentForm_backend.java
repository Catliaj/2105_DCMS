package backend;

public class ApointmentForm_backend extends newPatient_Backend
{
	private String Name, Email, PhoneNumber, Date, Time, Reason;

	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}

	public String getEmail() 
	{
		return Email;
	}

	public void setEmail(String email) 
	{
		Email = email;
	}

	public String getPhoneNumber() 
	{
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		PhoneNumber = phoneNumber;
	}

	public String getDate() 
	{
		return Date;
	}

	public void setDate(String date) 
	{
		Date = date;
	}

	public String getTime() 
	{
		return Time;
	}

	public void setTime(String time) 
	{
		Time = time;
	}

	public String getReason() 
	{
		return Reason;
	}

	public void setReason(String reason) 
	{
		Reason = reason;
	}
}
