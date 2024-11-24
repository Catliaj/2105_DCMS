package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DCMS_DB_CONNECTION.DB_DCMSConnection;

public class ApointmentForm_backend extends newPatient_Backend
{
	private String Name, Email, PhoneNumber, Date, Time, Reason;
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	private Connection connection;
	
	public ApointmentForm_backend(String name, String email,String phonenumber, String Date, String Time, String Reason)
	{
        try 
        { 
        	String status = "In Progress";
        	setName(name);
        	setEmail(email);
        	setPhoneNumber(phonenumber);
        	setDate(Date);
        	setTime(Time);
        	setReason(Reason);
        	connection = dcmsConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO appointments (Name, Email, PhoneNumber, Date, Time, Reason, status) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, getName());
            ps.setString(2, getEmail());
            ps.setString(3, getPhoneNumber());
            ps.setString(4, getDate());
            ps.setString(5, getTime());
            ps.setString(6, getReason());
            ps.setString(7, status);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) 
            {
                JOptionPane.showMessageDialog( null, "Appointment scheduled successfully!");
            } 
            else 
            {
                JOptionPane.showMessageDialog( null, "Failed to Feedback. Please try again.");
            }

        } 
        catch (Exception ex) 
        {
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog( null,"Error: " + ex.getMessage() );
        }
	}
	
	public ApointmentForm_backend() {}
	
	

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
	
	public List<String[]> getAppointment() 
	{
	  List<String[]> appointments = new ArrayList<>();
	       try 
	       {
	            connection = dcmsConnection.getConnection();
	            Statement statement = connection.createStatement();
	            String query = "SELECT AppointmentID, Name, date, time,reason,Phonenumber,email FROM appointments";
	            ResultSet resultSet = statement.executeQuery(query);
	            
	            while (resultSet.next()) 
	            {
	                String appointmentid = resultSet.getString("AppointmentID");
	                String Name = resultSet.getString("Name");
	                String date = resultSet.getString("date");
	                String time = resultSet.getString("time");
	                String reason = resultSet.getString("reason");
	                String Phonenumber = resultSet.getString("Phonenumber");
	                String email = resultSet.getString("email");
	                
	                appointments.add(new String[]{appointmentid, Name, date, time,reason,Phonenumber,email});
	            }
	         
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } 
	       catch (Exception ex) 
	       {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving appointment data: " + ex.getMessage());
	        }
	        return appointments;
	    }
	
	public List<String[]> getAppointmentsSortedBy(String column) {
	    List<String[]> sortedAppointments = new ArrayList<>();
	    String query = "SELECT AppointmentID, Name, Date, Time, reason, Phonenumber, email,  Status FROM appointments ORDER BY " + column;

	    try
	    {
	    	connection = dcmsConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String[] row = new String[8];
	            row[0] = resultSet.getString("AppointmentID");
	            row[1] = resultSet.getString("Name");
	            row[2] = resultSet.getString("Date");
	            row[3] = resultSet.getString("Time");
	            row[4] = resultSet.getString("reason");
	            row[5] = resultSet.getString("Phonenumber");
	            row[6] = resultSet.getString("email");
	            row[7] = resultSet.getString("Status");
	           
	            sortedAppointments.add(row);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sortedAppointments;
	}

	public List<String[]> searchAppointments(String keyword) {
	    List<String[]> results = new ArrayList<>();
	    String query = "SELECT AppointmentID, Name, Date, Time, reason, Phonenumber, email, Status " +
	                   "FROM appointments " +
	                   "WHERE Name LIKE ? OR Email LIKE ? OR Phonenumber LIKE ?";

	    try {
	        connection = dcmsConnection.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(query);

	        // Use '%' to enable partial matching
	        String searchKeyword = "%" + keyword + "%";
	        preparedStatement.setString(1, searchKeyword); // For Name
	        preparedStatement.setString(2, searchKeyword); // For Email
	        preparedStatement.setString(3, searchKeyword); // For PhoneNumber

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            String[] row = new String[8];
	            row[0] = resultSet.getString("AppointmentID");
	            row[1] = resultSet.getString("Name");
	            row[2] = resultSet.getString("Date");
	            row[3] = resultSet.getString("Time");
	            row[4] = resultSet.getString("reason");
	            row[5] = resultSet.getString("Phonenumber");
	            row[6] = resultSet.getString("email");
	            row[7] = resultSet.getString("Status");

	            results.add(row);
	        }

	        resultSet.close();
	        preparedStatement.close();
	        connection.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error searching for appointments: " + ex.getMessage());
	    }

	    return results;
	}

	
	 public String[] getAppointmentByID(String AppointmentID) {
	        String[] AppointmentDetails = null;

	        try {
	            connection = dcmsConnection.getConnection();
	            String query = "SELECT * FROM appointments WHERE AppointmentID = ?";
	            PreparedStatement ps = connection.prepareStatement(query);
	            ps.setString(1, AppointmentID);
	            ResultSet resultSet = ps.executeQuery();

	            if (resultSet.next()) {
	            	AppointmentDetails = new String[]{
	                    resultSet.getString("AppointmentID"),
	                    resultSet.getString("Name"),
	                    resultSet.getString("Date"),
	                    resultSet.getString("Time"),
	                    resultSet.getString("Phonenumber"),
	                    resultSet.getString("email"),
	                    resultSet.getString("Status"),
	                };
	            }

	            resultSet.close();
	            ps.close();
	            connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving Appointment data: " + ex.getMessage());
	        }

	        return AppointmentDetails;
	    }
	 
	 public boolean updateAppointment(String appointmentID, String name, String email, String phoneNumber, 
			 	String date, String time, String reason) 
	 {
				String query = "UPDATE appointments SET Name = ?, Email = ?, PhoneNumber = ?, Date = ?, Time = ?, Reason = ? WHERE AppointmentID = ?";
				try {
				connection = dcmsConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, phoneNumber);
				ps.setString(4, date);
				ps.setString(5, time);
				ps.setString(6, reason);
				ps.setString(7, appointmentID);
				
				int rowsAffected = ps.executeUpdate();
				ps.close();
				connection.close();
				
				return rowsAffected > 0; // Return true if rows were updated
				} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error updating appointment: " + e.getMessage());
				return false;
				}
	 }

}
