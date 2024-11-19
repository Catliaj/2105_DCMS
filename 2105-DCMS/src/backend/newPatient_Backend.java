package backend;


import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

import DCMS_DB_CONNECTION.DB_DCMSConnection;



public class newPatient_Backend 
{
	private String firstName,MiddleInitial, lastName, gender,ContactNumber,DateOfBirth,Email,Address;
	private int age;

	
	
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
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

	  private Connection connection;

	    public List<String[]> getPatientData() {
	        List<String[]> patientData = new ArrayList<>();
	        try {
	            // Establish the connection
	            connection = dcmsConnection.getConnection();
	            Statement statement = connection.createStatement();
	            String query = "SELECT PatientID, firstname, middleinitial, lastname FROM PatientData";
	            ResultSet resultSet = statement.executeQuery(query);

	           
	            while (resultSet.next()) {
	                String patientId = resultSet.getString("PatientID");
	                String firstName = resultSet.getString("firstname");
	                String middleInitial = resultSet.getString("middleinitial");
	                String lastName = resultSet.getString("lastname");
	                
	               
	                patientData.add(new String[]{patientId, firstName, middleInitial, lastName});
	            }
	            
	           
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving patient data: " + ex.getMessage());
	        }
	        return patientData;
	    }
	}
