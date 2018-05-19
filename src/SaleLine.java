/**
 * SaleLine class.
 *
 * @author Ken
 * @version 1.0
 *
 */

//Need to make sure the parameter entered into constructors
//exist in order to create correct object.

public class SaleLine {
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
			if (p.getProdID().equals(prodID)) {
				try {
					if (quantity > p.getQuantity())
						throw new Exception("No enough stock.");
				} 
				catch (Exception e){
					System.err.println(e.getMessage());
					quantity = 0;
				}
				this.prodID = p.getProdID();
				this.prodName = p.getProductName();
				this.salePrice = p.getSalesPrice();
				this.unitPrice = p.getUnitPrice();
				this.bulkPrice = p.getBulkPrice();
				}
			}
		calcSubtotal();
	}
	
	public SaleLine(String name, 
			double Qty) {
		prodName = name;
		quantity = Qty;
		for(Product p:Store.products) {
			if (p.getProductName().equals(name)) {
				try {
					if (quantity > p.getQuantity())
						throw new Exception("Insufficent stock.");
				} 
				catch (Exception e){
					System.out.println(e.getMessage());
					quantity = 0;
				}
				this.prodID = p.getProdID();
				this.salePrice = p.getSalesPrice();
				this.unitPrice = p.getUnitPrice();
				this.bulkPrice = p.getBulkPrice();
				}
			}
		calcSubtotal();
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
		for(Product p:Store.products) {
			if (p.getProductName().equals(prodName)) {
				if(quantity >= p.getBulk()){
					unitPrice = bulkPrice;
				}
				}
			}
	}

	//NEED TO ADD BULKPRICE CALCULATION
	public double calcSubtotal() {
		if (quantity != 0){
			applyBulkOffer();
			//if(salePrice != 0) {
			//subtotal = quantity * salePrice;
			//}
			//else if (bulkPrice != 0) {
			//	subtotal = quantity * bulkPrice;
			//}
			//else{
				subtotal = quantity * unitPrice;
			//}
			}
		return subtotal;
	}
	
	public void checkout() {
		for(Product p:Store.products) {
			if (p.getProdID().equals(prodID)) {
				p.setQuantity(p.getQuantity() - quantity);}
			}
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