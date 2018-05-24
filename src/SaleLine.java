/**
 * SaleLine class which supports a 1-M-1 relationship for Product and Sale.
 * It can be seen as each item in cart with parameter of quantity and price.
 * @author Ken
 * @version 1.0
 */
public class SaleLine {
   private String prodID;
   private String prodName;
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
	public SaleLine(String prodID, 
			int quantity) {
		this.prodID = prodID;
		this.quantity = (double)quantity;
		for(Product p:Store.products) {
			if (p.getProdID().equals(prodID)) {
				try {
					if (quantity > p.getQuantity())
						throw new Exception("Insufficent stock.");
				} 
				catch (Exception e){
					System.out.println(e.getMessage());
					this.quantity = 0;
					}
				this.prodID = p.getProdID();
				this.prodName = p.getProductName();
				product = p;
				}
		}
		try {
			if(product == null) throw new Exception("Cant find such product.");
			calcSubtotal();
			} 
		catch(Exception e) {
				System.out.println(e.getMessage());
				this.quantity = 0;
		}
	}
	
	/**
	 * The purpose of this class is same as SaleLine(String prodID, 
	 * int quantity), yet it takes two parameters of name
	 * and quantity which customer specify
	 *	
	 * @param name
	 * @param Qty
	 */
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
					this.quantity = 0;
				}
				this.prodID = p.getProdID();
				this.prodName = p.getProductName();
				product = p;
			}
		}
		try {
			if(product == null) throw new Exception("Cant find such product.");
			calcSubtotal();
			} 
			catch(Exception e) {
				System.out.println(e.getMessage());
				this.quantity = 0;
			}
		}
	
	/**
	 * alter the price to bulk offered price if customer has bought enough items.
	 */
	public void applyBulkOffer() {
		if (product.getProductName().equals(prodName)) {
			if(quantity >= product.getBulk()){
				finalPrice = product.getBulkPrice();
			}
		}
	}

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
	
	public void checkout() {
		product.setQuantity(
				product.getQuantity() - quantity);

		//AutoReplenish
				System.out.println("Product name                   "+product.getProductName());
				System.out.println("Quantity before auto replenish              "+product.getQuantity());
				if(product.getQuantity() < product.getReplenishLine())
				{
					product.setQuantity(product.getQuantity() + product.getReplenishQuantity());
					System.out.println("Product Quantity after autoReplenish             "+product.getQuantity());
				}

		//auto Replenish
		System.out.println("Name                                "+ product.getProductName());
		System.out.println("Initial Quantity                    "+ product.getQuantity());
		
		if(product.getQuantity() < product.getReplenishLine())
		{
			product.setQuantity(product.getQuantity() + product.getReplenishQuantity());
			System.out.println("new quantity                     "+ product.getQuantity());
		}

	}
	
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
	
	public double getPrice() {
		return finalPrice;
	}
	
	public Product getProduct() {
		return product;
	}
}