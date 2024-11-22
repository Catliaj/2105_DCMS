package backend;


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
	private Connection connection;
	  
	
	public newPatient_Backend(String firstName, String middleInitial, String lastName, String gender,
			                 String contactNumber, String dateOfBirth, String email, String address, int age) 
	{
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
		setGender(gender);
		setContactNumber(contactNumber);
		setDateOfBirth(dateOfBirth);
		setEmail(email);
		setAddress(address);
		setAge(age);
		
		
		try {
        	connection = dcmsConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO patientdata (FirstName, LastName, MiddleInitial, Age, Gender, ContactNumber, Email, Address, DateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, getFirstName());
            ps.setString(2, getLastName());
            ps.setString(3, getMiddleInitial());
            ps.setInt(4,    getAge());
            ps.setString(5, getGender());
            ps.setString(6, getContactNumber());
            ps.setString(7, getEmail());
            ps.setString(8, getAddress());
            ps.setString(9, dateOfBirth);

            int rowsAffected = ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Successfully Add");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        

	}

	public newPatient_Backend() {}
	
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
	    
	    public String[] getPatientByID(String patientID) {
	        String[] patientDetails = null;

	        try {
	            connection = dcmsConnection.getConnection();
	            String query = "SELECT * FROM PatientData WHERE PatientID = ?";
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setString(1, patientID);
	            ResultSet resultSet = ps.executeQuery();

	            if (resultSet.next()) {
	                patientDetails = new String[]{
	                    resultSet.getString("PatientID"),
	                    resultSet.getString("FirstName"),
	                    resultSet.getString("MiddleInitial"),
	                    resultSet.getString("LastName"),
	                    resultSet.getString("DateOfBirth"),
	                    String.valueOf(resultSet.getInt("Age")),
	                    resultSet.getString("Gender"),
	                    resultSet.getString("Email"),
	                    resultSet.getString("Address"),
	                    resultSet.getString("ContactNumber")
	                };
	            }

	            resultSet.close();
	            ps.close();
	            connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving patient data: " + ex.getMessage());
	        }

	        return patientDetails;
	    }
	    
	    
 public boolean updatePatientData(String patientID, String firstName, String middleInitial, String lastName,
		 						  String dob, String age, String gender, String email, String address, String contactNumber) {
			boolean isUpdated = false;
			
			try {
			connection = dcmsConnection.getConnection();
			String query = "UPDATE PatientData SET FirstName = ?, MiddleInitial = ?, LastName = ?, DateOfBirth = ?, " +
			      "Age = ?, Gender = ?, Email = ?, Address = ?, ContactNumber = ? WHERE PatientID = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, firstName);
			ps.setString(2, middleInitial);
			ps.setString(3, lastName);
			ps.setString(4, dob);
			ps.setInt(5, Integer.parseInt(age));
			ps.setString(6, gender);
			ps.setString(7, email);
			ps.setString(8, address);
			ps.setString(9, contactNumber);
			ps.setString(10, patientID);
			
			int rowsAffected = ps.executeUpdate();
			isUpdated = rowsAffected > 0;
			
			ps.close();
			connection.close();
			} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error updating patient data: " + ex.getMessage());
			}
			
			return isUpdated;
			}

	public boolean deletePatientByID(String patientID) {
	    try {
	        // Database connection and deletion logic
	    	connection = dcmsConnection.getConnection();
	        String query = "DELETE FROM patientdata WHERE patientid = ?";
	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, patientID);
	        int rowsAffected = pstmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	}
