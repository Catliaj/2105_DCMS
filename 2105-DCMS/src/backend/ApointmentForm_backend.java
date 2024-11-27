package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import DCMS_DB_CONNECTION.DB_DCMSConnection;
import backend.newPatient_Backend;

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
            PreparedStatement ps = connection.prepareStatement("INSERT INTO appointments (Name, Email, PhoneNumber, AppointmentDate, Time, Reason, status) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
	
	public List<String[]> getAppointment() {
	    List<String[]> appointments = new ArrayList<>();
	    try {
	        connection = dcmsConnection.getConnection();
	        Statement statement = connection.createStatement();
	        String query = "SELECT a.AppointmentID, CONCAT(p.FirstName, ' ', p.LastName) AS Name, " +
	                       "a.AppointmentDate AS Date, a.Time, a.Service, p.ContactNumber, p.Email, a.Status " +
	                       "FROM appointments a " +
	                       "JOIN patientdata p ON a.PatientID = p.PatientID";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String appointmentid = resultSet.getString("AppointmentID");
	            String name = resultSet.getString("Name");
	            String date = resultSet.getString("Date");  // This will now reference the correct column
	            String time = resultSet.getString("Time");
	            String reason = resultSet.getString("Service");
	            String contactNumber = resultSet.getString("ContactNumber");
	            String email = resultSet.getString("Email");
	            String status = resultSet.getString("Status");

	            appointments.add(new String[]{appointmentid, name, date, time, reason, contactNumber, email, status});
	        }

	        resultSet.close();
	        statement.close();
	        connection.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error retrieving appointment data: " + ex.getMessage());
	    }
	    return appointments;
	}


	
	public List<String[]> getAppointmentsSortedBy(String column) {
	    List<String[]> sortedAppointments = new ArrayList<>();

	    // Map column names to database columns
	    String dbColumn;
	    switch (column.toUpperCase()) {
	        case "PATIENT ID":
	            dbColumn = "a.PatientID";
	            break;
	        case "NAME":
	            dbColumn = "p.FirstName, p.LastName";
	            break;
	        case "DATE":
	            dbColumn = "a.AppointmentDate"; // Correct column name
	            break;
	        case "STATUS":
	        	dbColumn = "a.Status";
	        case "SERVICE":
	        	dbColumn = "a.Service";
	        default:
	            dbColumn = "a.AppointmentID"; // Default sorting by AppointmentID
	    }

	    String query = "SELECT a.AppointmentID, CONCAT(p.FirstName, ' ', p.LastName) AS Name, " +
	                   "a.AppointmentDate AS Date, a.Time, a.Service, p.ContactNumber, p.Email, a.Status " +
	                   "FROM appointments a " +
	                   "JOIN patientdata p ON a.PatientID = p.PatientID " +
	                   "ORDER BY " + dbColumn;

	    try (Connection connection = dcmsConnection.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(query)) {

	        while (resultSet.next()) {
	            sortedAppointments.add(new String[] {
	                resultSet.getString("AppointmentID"),
	                resultSet.getString("Name"),
	                resultSet.getString("Date"),
	                resultSet.getString("Time"),
	                resultSet.getString("Service"),
	                resultSet.getString("ContactNumber"),
	                resultSet.getString("Email"),
	                resultSet.getString("Status")
	            });
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error sorting appointments: " + e.getMessage());
	    }

	    return sortedAppointments;
	}







	public List<String[]> searchAppointments(String keyword, String sortBy, String sortOrder) {
	    List<String[]> results = new ArrayList<>();
	    String query = "SELECT a.PatientID, CONCAT(p.FirstName, ' ', p.MiddleInitial, ' ', p.LastName) AS Name, " +
	                   "a.Date, a.Time, a.Reason, a.ContactNumber, a.Email, a.Status " +
	                   "FROM appointments a " +
	                   "JOIN patientdata p ON a.PatientID = p.PatientID " +
	                   "WHERE CONCAT(p.FirstName, ' ', p.LastName) LIKE ? " +
	                   "ORDER BY " + sortBy + " " + sortOrder;

	    try (Connection connection = dcmsConnection.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        ps.setString(1, "%" + keyword + "%");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            String[] row = new String[]{
	                rs.getString("PatientID"),
	                rs.getString("Name"),
	                rs.getString("Date"),
	                rs.getString("Time"),
	                rs.getString("Reason"),
	                rs.getString("ContactNumber"),
	                rs.getString("Email"),
	                rs.getString("Status")
	            };
	            results.add(row);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return results;
	}

	public List<String[]> searchAppointments(String keyword) {
	    List<String[]> results = new ArrayList<>();
	    String query = "SELECT a.AppointmentID, CONCAT(p.FirstName, ' ', p.LastName) AS Name, " +
	                   "a.AppointmentDate AS Date, a.Time, a.Service, p.ContactNumber, p.Email, a.Status " +
	                   "FROM appointments a " +
	                   "JOIN patientdata p ON a.PatientID = p.PatientID " +
	                   "WHERE a.AppointmentDate LIKE ? OR p.FirstName LIKE ? OR p.LastName LIKE ?";

	    try (Connection connection = dcmsConnection.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {

	        String searchKeyword = "%" + keyword + "%";
	        ps.setString(1, searchKeyword); // For AppointmentDate
	        ps.setString(2, searchKeyword); // For FirstName
	        ps.setString(3, searchKeyword); // For LastName

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            results.add(new String[] {
	                rs.getString("AppointmentID"),
	                rs.getString("Name"),
	                rs.getString("Date"),
	                rs.getString("Time"),
	                rs.getString("Service"),
	                rs.getString("ContactNumber"),
	                rs.getString("Email"),
	                rs.getString("Status")
	            });
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error searching appointments: " + e.getMessage());
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
	                    resultSet.getString("AppointmentDate"),
	                    resultSet.getString("Time"),
	                    resultSet.getString("Phonenumber"),
	                    resultSet.getString("email"),
	                    resultSet.getString("status"),
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
	 
	 
	 public boolean deleteAppointment(String appointmentID) {
		    String query = "DELETE FROM appointments WHERE AppointmentID = ?";
		    try {
		        connection = dcmsConnection.getConnection();
		        PreparedStatement ps = connection.prepareStatement(query);
		        ps.setString(1, appointmentID); // Set the AppointmentID in the query

		        int rowsAffected = ps.executeUpdate();
		        ps.close();
		        connection.close();

		        return rowsAffected > 0; // Return true if the deletion was successful
		    } catch (Exception e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error deleting appointment: " + e.getMessage());
		        return false;
		    }
		}

	 public List<String[]> getTodaysAppointments() {
		    List<String[]> todaysAppointments = new ArrayList<>();
		    try {
		        // Establish connection to the database
		        connection = dcmsConnection.getConnection();
		        
		        // SQL query to fetch today's appointments
		        String query = "SELECT AppointmentID, AppointmentDate, Time, Service, Status FROM appointments WHERE DATE(AppointmentDate) = CURDATE()";  // Filters today's date

		        PreparedStatement ps = connection.prepareStatement(query);
		        ResultSet rs = ps.executeQuery();

		        // Loop through the result set and store appointment data in the list
		        while (rs.next()) {
		            String[] appointmentData = new String[8];
		            appointmentData[0] = rs.getString("AppointmentID");
		            appointmentData[1] = rs.getString("AppointmentDate");
		            appointmentData[2] = rs.getString("Time");
		            appointmentData[3] = rs.getString("Service");
		            appointmentData[4] = rs.getString("Status");

		            todaysAppointments.add(appointmentData);
		            
		            
		        }

		        rs.close();
		        ps.close();
		        connection.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error retrieving today's appointments: " + ex.getMessage());
		    }
		    return todaysAppointments;
		}

	    // Fetch Patient History
	 public List<String[]> getPatientHistory(String patientID) {
		    List<String[]> history = new ArrayList<>();
		    String query = "SELECT AppointmentDate, Time, Service, Status FROM appointments WHERE PatientID = ?";

		    try (Connection connection = dcmsConnection.getConnection();
		         PreparedStatement ps = connection.prepareStatement(query)) {

		        ps.setString(1, patientID);
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            history.add(new String[] {
		                rs.getString("AppointmentDate"),
		                rs.getString("Time"),
		                rs.getString("Service"),
		                rs.getString("Status")
		            });
		        }

		        rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error fetching patient history: " + e.getMessage());
		    }
		    return history;
		}


	    // Update Appointment
	    public boolean updateAppointment(String appointmentID, String name, String email, String phoneNumber, 
	                                     String date, String time, String reason, String status) {
	        String query = "UPDATE appointments SET Name = ?, Email = ?, PhoneNumber = ?, AppointmentDate = ?, Time = ?, Reason = ?, Status = ? WHERE AppointmentID = ?";
	        try (Connection connection = dcmsConnection.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, phoneNumber);
	            ps.setString(4, date);
	            ps.setString(5, time);
	            ps.setString(6, reason);
	            ps.setString(7, status);
	            ps.setString(8, appointmentID);

	            int rowsAffected = ps.executeUpdate();
	            return rowsAffected > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error updating appointment: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean addNewAppointment(String patientID,  String date, String time, String reason, String Status) {
	        String query = "INSERT INTO appointments (PatientID, AppointmentDate, Time, Service, Status) VALUES (?, ?, ?, ?, ?)";
	        try (Connection connection = dcmsConnection.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setString(1, patientID);
	            ps.setString(2, date);
	            ps.setString(3, time);
	            ps.setString(4, reason);
	            ps.setString(5, Status);

	            int rowsAffected = ps.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	    }
	    
	    public List<String[]> getAppointmentsByMonth(int year, int month) {
	        List<String[]> appointments = new ArrayList<>();
	        String query = "SELECT a.AppointmentID, CONCAT(p.FirstName, ' ', p.LastName) AS Name, " +
	                       "a.AppointmentDate AS Date, a.Time, a.Service, p.ContactNumber, p.Email, a.Status " +
	                       "FROM appointments a " +
	                       "JOIN patientdata p ON a.PatientID = p.PatientID " +
	                       "WHERE SUBSTRING(a.AppointmentDate, 1, 2) = ? " +  // Extract year
	                       "AND SUBSTRING(a.AppointmentDate, 4, 2) = ?";    // Extract month

	        try (Connection connection = dcmsConnection.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            // Format year as two digits (e.g., 2024 -> 24)
	            ps.setString(1, String.format("%02d", year % 100));
	            // Format month as two digits (e.g., 1 -> 01)
	            ps.setString(2, String.format("%02d", month));

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                appointments.add(new String[] {
	                    rs.getString("AppointmentID"),
	                    rs.getString("Name"),
	                    rs.getString("Date"),
	                    rs.getString("Time"),
	                    rs.getString("Service"),
	                    rs.getString("ContactNumber"),
	                    rs.getString("Email"),
	                    rs.getString("Status")
	                });
	            }
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error fetching appointments by month: " + e.getMessage());
	        }

	        return appointments;
	    }




	    public boolean updateAppointment(String appointmentID, String date, String time, String reason, String status) {
	        String query = "UPDATE appointments SET AppointmentDate = ?, Time = ?, Service = ?, Status = ? WHERE AppointmentID = ?";
	        try (Connection connection = dcmsConnection.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, date);        // AppointmentDate
	            ps.setString(2, time);        // Time
	            ps.setString(3, reason);      // Service/Reason
	            ps.setString(4, status);      // Status
	            ps.setString(5, appointmentID); // AppointmentID

	            int rowsAffected = ps.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error updating appointment: " + e.getMessage());
	            return false;
	        }
	    }







	   

	    

		
	 
	 



	

	 
}



