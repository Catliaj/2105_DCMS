package backend;

public class POS_backend 
{
	private String CustomerName,Products,Services;
	private double   ProductPrice, ServicePrice,total;
	
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
	
	
}
