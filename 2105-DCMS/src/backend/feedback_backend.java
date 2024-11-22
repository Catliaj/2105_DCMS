package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DCMS_DB_CONNECTION.DB_DCMSConnection;

public class feedback_backend extends ApointmentForm_backend
{
	private String feedback;
	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	private Connection connection;
	
	public feedback_backend(String name, String email, String phonenumber,String feedback)
	{
		// TODO Auto-generated constructor stub
		super.setName(name);
		super.setEmail(email);
		super.setPhoneNumber(phonenumber);
		setFeedback(feedback);
		
        try 
        {               	
        	connection = dcmsConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO feedbackdata (Name, Email, PhoneNumber, Feedback) VALUES (?, ?, ?, ?)");
            ps.setString(1, super.getName());
            ps.setString(2, super.getEmail());
            ps.setString(3, super.getPhoneNumber());
            ps.setString(4, getFeedback());
            
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
	public feedback_backend(){}
	
	public String getFeedback() 
	{
		return feedback;
	}
	
	public void setFeedback(String feedback) 
	{
		this.feedback = feedback;
	}
	


}
