/**
 * SaleLine class which supports a 1-M-1 relationship for Product and Sale.
 * It can be seen as each item in cart with parameter of quantity and price.
 * @author Ken
 * @version 2.0
 */
public class SaleLine {
   private Product product;
   private double quantity;
   private double subtotal;
   private double finalPrice;


	/**
	 * SaleLine Constructor which takes 2 parameters of product ID,
	 * and quantity customer is going to purchase. It checks for stock level
	 * and create the class if the stock level is higher than customer specified.
	 * 
	 * @param prodID
	 * @param quantity
	 */
	public SaleLine(String prodID, int quantity) {
		this.quantity = (double)quantity;
		try {
		for(Product p:Store.products) {
			if (p.getProdID().equals(prodID)) {
					product = p;
					if (quantity > p.getQuantity())
						throw new Exception("Insufficent stock.");
				} 
			}
			if(product == null) throw new Exception("Cant find such product.");
			calcSubtotal();
			} 
		catch(Exception e) {
				System.out.println(e.getMessage());
				this.quantity = 0;
		}//end catch
	}//end method
	
	/**
	 * The purpose of this class is same as SaleLine(String prodID, 
	 * int quantity), yet it takes two parameters of name
	 * and quantity which customer specify.
	 *	
	 * @param name
	 * @param Qty
	 */
	public SaleLine(String prodName, double weight) {
		this.quantity = weight;
		try {
		for(Product p:Store.products) {
			if (p.getProductName().equals(prodName)) {
					product = p;
					if (quantity > p.getQuantity())
						throw new Exception("Insufficent stock.");
				}
			}//end for loop
			if(product == null) throw new Exception("Cant find such product.");
			calcSubtotal();
			} 
			catch(Exception e) {
				System.out.println(e.getMessage());
				this.quantity = 0;
			}//end catch
	}//end method
	
	/**
	 * alter the price to bulk offered price if customer has bought enough items.
	 */
	public void applyBulkOffer() {
			if(quantity >= product.getBulk()){
				finalPrice = product.getBulkPrice();
		}
	}

	/**
	 * calculate the subtotal for this particular sale line item.
	 * @return subtotal
	 */
	public double calcSubtotal() {
		if (product.isOnSale()){
			finalPrice = product.getSalesPrice();
		} else {
			finalPrice = product.getUnitPrice();
		}
			applyBulkOffer();
			subtotal = quantity * finalPrice;
		return subtotal;
	}
	
	/**
	 * replenish after checkout, it supports stuff memeber's functionality.
	 */
	public void checkout() {
		product.setQuantity(
				product.getQuantity() - quantity);
		//AutoReplenish
		System.out.println("Product name                   "+product.getProductName());
		System.out.println("Quantity before auto replenish              "
							+product.getQuantity());
		if(product.getQuantity() < product.getReplenishLine()){
			product.setQuantity(product.getQuantity() 
					+ product.getReplenishQuantity());
			System.out.println("Product Quantity after autoReplenish             "
								+product.getQuantity());
			}
		//auto Replenish
		System.out.println("Name                                "
							+ product.getProductName());
		System.out.println("Initial Quantity                    "
							+ product.getQuantity());
		if(product.getQuantity() < product.getReplenishLine()){
			product.setQuantity(product.getQuantity() + product.getReplenishQuantity());
			System.out.println("new quantity                     "
							+ product.getQuantity());
			}
	}
	
	//Getters
	public String getProdID() {
		return product.getProdID();
	}	

	public String getProdName() {
	    return product.getProductName();
	}

	public double getQty() {
		return quantity;
	}
	   
	public double getSubtotal() {
	    return subtotal;
	}
	
	public double getPrice() {
		return finalPrice;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
}