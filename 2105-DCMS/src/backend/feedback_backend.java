package backend;


public class feedback_backend 
{
	private String feedback, Name, Email, contactNumber;


	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFeedback() 
	{
		return feedback;
	}

	public void setFeedback(String feedback) 
	{
		this.feedback = feedback;
	}
	


}
