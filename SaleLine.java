import java.lang.Math;

public class SaleLine{
	private String prodID;
	private String name;
	private int quantity;
	private double weight;
	private double unitPrice;
	private double salePrice;
	private double bulkPrice;
	private double discountedPrice;
	private double subtotal;
	
	//need to get products.
	public SaleLine(String prodID, 
			int quantity) {
		this.prodID = prodID;
		this.quantity = quantity;
		for(Product p:Store.products) {
			if (p.getProdID().equals(prodID))
				this.name = p.getProdName();
				this.salePrice = p.getSalePrice();
				this.bulkPrice = p.getBulkPrice();
				this.unitPrice = p.getUnitPrice();
		}
	}
	
	public SaleLine(String name, 
			double weight) {
		this.name = name;
		this.weight = weight;
		this.quantity = 0;
		for(Product p:Store.products) {
			if (p.getProdName().equals(name)) {
				this.salePrice = p.getSalePrice();
				this.bulkPrice = p.getBulkPrice();
				this.unitPrice = p.getUnitPrice();
			}
	}
	}
	
	public double getDiscountedPrice() {
		this.discountedPrice = Math.min(unitPrice,
				Math.min(salePrice, bulkPrice));
		return this.discountedPrice;
	}
	
	public double getSubtotal() {
		if (this.quantity != 0){
			this.subtotal = quantity * 
					this.getDiscountedPrice();
		}
		else if (this.name != null) {
			this.subtotal = weight * 
					this.getDiscountedPrice();
		}
		return this.subtotal;
	}
	
	   public String getProdID() {
		      return this.prodID;
		      }

	   public String getProdName() {
		      return this.name;
		      }

	   public int getQuantity() {
		      return this.quantity;
		      }

	   public double getWeight() {
		      return this.weight;
		      }
}