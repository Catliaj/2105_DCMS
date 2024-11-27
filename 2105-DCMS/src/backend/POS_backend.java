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

public class POS_backend 
{
	private String CustomerName,Products,Services;
	private double   ProductPrice, ServicePrice,total;
	private int productQuantity;
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	DB_DCMSConnection dcmsConnection = new DB_DCMSConnection();
	private Connection connection;
	public POS_backend(String CustomerName, String Products, String Services, int Quantity,
			    	   double ProductPrice,double ServicePrice, double total,String date
			          )
	{
		setCustomerName(CustomerName);
		setProducts(Products);
		setServices(Services);
		setProductPrice(ProductPrice);
		setProductQuantity(Quantity);
		setServicePrice(ServicePrice);
		setTotal(total);
		
        
        
        String sql = "INSERT INTO billdata ( customername, productname, productprice, quantity,servicename, serviceprice, total, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = dcmsConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) 
        {
            
          
            ps.setString(1, getCustomerName());
            ps.setString(2, getProducts());
            ps.setDouble(3, getProductPrice());
            ps.setInt(4, getProductQuantity());
            ps.setString(5, getServices());
            ps.setDouble(6, getServicePrice());
            ps.setDouble(7, getTotal());
            ps.setDate(8, java.sql.Date.valueOf(date));

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) 
            {
                JOptionPane.showMessageDialog(null, "Bill details saved successfully!");
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving bill details to the database.");
        }
		
		
	}
	public POS_backend() {}
	
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getProducts() {
		return Products;
	}
	public void setProducts(String products) {
		Products = products;
	}
	public String getServices() {
		return Services;
	}
	public void setServices(String services) {
		Services = services;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public double getServicePrice() {
		return ServicePrice;
	}
	public void setServicePrice(double servicePrice) {
		ServicePrice = servicePrice;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public List<String[]> getServiceBillData() 
	{
	  List<String[]> ServicePOS = new ArrayList<>();
	       try 
	       {
	            connection = dcmsConnection.getConnection();
	            Statement statement = connection.createStatement();
	            String query = "SELECT Bill_ID, CustomerName, date, ServiceName,ServicePrice,Total FROM billdata";
	            ResultSet resultSet = statement.executeQuery(query);
	            while (resultSet.next()) 
	            {
	                String billid = resultSet.getString("Bill_ID");
	                String customerName = resultSet.getString("CustomerName");
	                String date = resultSet.getString("date");
	                String serviceName = resultSet.getString("ServiceName");
	                String servicePrice = resultSet.getString("ServicePrice");
	                String total = resultSet.getString("Total");	                
	                ServicePOS.add(new String[]{billid, customerName, date, serviceName,servicePrice,total});
	            }         
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } 
	       catch (Exception ex) 
	       {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving POS data: " + ex.getMessage());
	       }
	        return ServicePOS;
	   }
	
	
	public List<String[]> getProductBillData() 
	{
	  List<String[]> ProductPOS = new ArrayList<>();
	       try 
	       {
	            connection = dcmsConnection.getConnection();
	            Statement statement = connection.createStatement();
	            String query = "SELECT Bill_ID, ProductName, date,  Quantity,ProductPrice,Total FROM billdata";
	            ResultSet resultSet = statement.executeQuery(query);
	            while (resultSet.next()) 
	            {
	                String billid = resultSet.getString("Bill_ID");
	                String ProductName = resultSet.getString("ProductName");
	                String date = resultSet.getString("date");
	                String quantity = resultSet.getString("Quantity");
	                String ProductPrice = resultSet.getString("ProductPrice");
	                String total = resultSet.getString("Total");	                
	                ProductPOS.add(new String[]{billid, ProductName, date, quantity,ProductPrice,total});
	            }         
	            resultSet.close();
	            statement.close();
	            connection.close();
	        } 
	       catch (Exception ex) 
	       {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error retrieving POS data: " + ex.getMessage());
	       }
	        return ProductPOS;
	   }
	
	public List<String[]> fetchProducts() {
	    List<String[]> products = new ArrayList<>();
	    try (Connection connection = dcmsConnection.getConnection();
	         Statement statement = connection.createStatement()) {
	        String query = "SELECT ProductName, Price FROM products";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String name = resultSet.getString("ProductName");
	            String price = resultSet.getString("Price");
	            products.add(new String[]{name, price});
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error fetching products: " + ex.getMessage());
	    }
	    return products;
	}

	
}
