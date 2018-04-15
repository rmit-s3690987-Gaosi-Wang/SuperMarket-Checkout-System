import java.util.ArrayList;

public class Product {
	private String prodID;
	private String name;
	private double unitPrice;
	private double salesPrice;
	private double bulkPrice;
	private int quantity;
	private double weight;
	Supplier supplier;
	
	
	public Product(String prodID, String name, double unitPrice, double salesPrice, double bulkPrice, int quantity,
			double weight) {
		
		this.prodID = prodID;
		this.name = name;
		this.unitPrice = unitPrice;
		this.salesPrice = salesPrice;
		this.bulkPrice = bulkPrice;
		this.quantity = quantity;
		this.weight = weight;
	}
	

	ArrayList<String> products;
	public String getProdID() {
		return prodID;
	}
	public void setProdID(String prodID) {
		this.prodID = prodID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public double getBulkPrice() {
		return bulkPrice;
	}
	public void setBulkPrice(double bulkPrice) {
		this.bulkPrice = bulkPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	

}
