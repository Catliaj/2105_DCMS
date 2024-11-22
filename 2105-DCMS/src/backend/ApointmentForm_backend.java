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
        	setName(name);
        	setEmail(email);
        	setPhoneNumber(phonenumber);
        	setDate(Date);
        	setTime(Time);
        	setReason(Reason);
        	connection = dcmsConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO appointments (Name, Email, PhoneNumber, Date, Time, Reason) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, getName());
            ps.setString(2, getEmail());
            ps.setString(3, getPhoneNumber());
            ps.setString(4, getDate());
            ps.setString(5, getTime());
            ps.setString(6, getReason());
            
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
}
