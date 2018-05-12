import java.util.ArrayList;
import java.util.List;
import java.math.*;
public class SaleLine{
	private String prodID;
	private String prodName;
	private double quantity;
	//private double weight;
	private double unitPrice;
	private double salePrice;
	private double subtotal;
	private double bulkPrice; //3 For 2
	
	
	//Using constructing overloadding to sperate (ID, quantity) and
	//(product name and weight) 
	public SaleLine(String prodID, 
			int quantity) {
		this.prodID = prodID;
		this.quantity = quantity;
		for(Product p:Store.products) {
			if (p.getProdID().equals(prodID))
				this.prodName = p.getProdName();
				this.salePrice = p.getSalePrice();
				this.unitPrice = p.getUnitPrice();
		}
	}
	
	public SaleLine(String name, 
			double Qty) {
		prodName = name;
		quantity = Qty;
		for(Product p:Store.products) {
			if (p.getProdName().equals(name)) {
				this.salePrice = p.getSalePrice();
				this.unitPrice = p.getUnitPrice();
				this.bulkPrice = p.getBulkPrice();
			}
	}
	}
	
	//get discounted price;
	/*
	public double getSalePrice(){
		this.salePrice = Math.min(unitPrice,
				Math.min(salePrice, bulkPrice));
		return this.salePrice;
	}
	*/
	
	public void applyBulkOffer() {
		
	}

	//NEED TO ADD BULKPRICE CALCULATION
	public double calcSubtotal() {
		if (quantity != 0){
			if(salePrice != 0) {
			subtotal = quantity * salePrice;
			}
			else{
				subtotal = quantity * unitPrice;
			}
			}
		return subtotal;
	}
	
	/*
	public List<String> getProdList() {
		List<String> prodList = new ArrayList<>();
		for(Product p:Store.products) {
			prodList.add(p.getProdName()); 
			}
		return prodList;
	   }
	   */

	   //Getters
	   public String getProdID() {
		      return prodID;
		      }

	   public String getProdName() {
		      return prodName;
		      }

	   public double getQty() {
		      return quantity;
		      }
	   
	   public double getSubtotal() {
		      return subtotal;
		      }
}