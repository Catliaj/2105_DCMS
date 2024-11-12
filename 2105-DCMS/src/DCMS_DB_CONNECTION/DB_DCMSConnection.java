package DCMS_DB_CONNECTION;
import java.sql.*;

import javax.swing.JOptionPane;

public class DB_DCMSConnection 
{
	private static Connection connection;
	private static DB_DCMSConnection db;
	public DB_DCMSConnection() 
	{
	    new JOptionPane();
	    
		connection = null;
		try
		{
		connection = DriverManager.getConnection
        (
            "jdbc:mysql://localhost:3306/dcfdentalclinicdb", 
            "admin", 
            "admin"
            
        );
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Connection Error");
		}
		
	}
	
	public static DB_DCMSConnection getDbConnection()
	{
		if(db == null)
		{
			db = new DB_DCMSConnection();
		}
		return db;
	}
	public Connection getConnection()
	{
		return connection;
	}
}
