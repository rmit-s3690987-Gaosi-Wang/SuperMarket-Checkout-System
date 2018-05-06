import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Sale{
	
	private int saleID;
	private Customer ID;
	private List<SaleLine> cart = new ArrayList<>();
	private int numItems;
	private LocalDateTime dateCreated;
	private double total;

	
	public Sale(Customer ID, int saleID) {
		this.ID = ID;
		this.saleID = saleID;
		this.numItems = 0;
		this.dateCreated = this.dateCreated();
	}
	
	public LocalDateTime dateCreated() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		return now;
	}
	/*
	public void addItemByList(SaleLineItem item) {;
		saleLine.add(item);
	};
	
	//make sure this method does not return null when there is a item with prodID.
	public Product addItemByInput(String input) {
		searchbyProdID(input);
		return null;
		//Error message:"There is no matching product."
	}
	*/
	
	
	
	//for sale staff
	
	
	//for sale staff
	public void cancelSale() {
		for (SaleLine i: saleLine){
			saleLine.remove(i);
		}
	}
	
	//get products
	public Product searchbyProdID(String prodID) {
		for(Product p:test.products) {
			if (p.getProdID().equals(prodID))
			{
				return p;
				}
			}
		return null;
		//Error message:"There is no matching product."
	}
	
	
	public Product searchbyProdname(String name) {
		for(Product p:test.products) {
			for(String n:test.productlist) {
				if (p.getProdName().equals(n) && n == name)
				{
					return p;
					}
				else {
				return null;
				}
				}
		}
		
		return null;
		//Error message:"There is no matching product."
	}
	
/*
	public String searchbyProdname(String name) {
		for(String n:test.productlist) {
			if (n == name)
			{
				return ;
		}
			return null;
	}
		*/
	public double checkPrice(String input) {
		Product p;
		if (searchbyProdID(input) != null) {
			p = searchbyProdID(input);
		} else{
			p = searchbyProdname(input);
		}
		if (p != null) {
			if (p.getSalePrice() != 0)
			return p.getSalePrice();
			else {
				return p.getUnitPrice();
						}
		}
		return 0;
		//Error message:"There is no matching product."
	}
	//Need to add bulk price under condition true;
	
	
	public double checkBulkDiscount(String input) {
		/*
		 * Checks the product by input ID, and search for its bulk discount;
		 */
		Product p = searchbyProdID(input);
		if (p != null) {
			if (p.getBulkPrice() != 0)
				//Message: Bulk price applicable. Specify the numbers.
				return p.getBulkPrice();
			else {
				return p.getUnitPrice();
				//Message: Bulk price not applicable.
			}
		}
		return 0;
		//Error message:"There is no matching product."
	}
	
	
	//public void applyBulkOffer(String ProdID, int Quantity) {
	//	return this.subtotal;
	//}
	
	//public void makeLineItem() {}
	
	public double getTotal() {
		for(SaleLine i:this.saleLine) {
			this.total += i.getSubtotal();
		}
		return this.total;
	};
	
	//public makePayment() {};
	
	public void checkout() {
		//reduces the stock level for all products in the sale.
		List<SaleLine> toRemove = new ArrayList<>();
		for (SaleLine i:this.saleLine) {
			if(i.getQuantity() != 0) {
				Product p = searchbyProdID(i.getProdID());
				p.setQuantity(p.getQuantity() - 
						i.getQuantity());
			}
			else {
				Product p = searchbyProdname(i.getProdName());
				p.setWeight(p.getWeight() - 
						i.getWeight());		
			}
			toRemove.add(i);
		}
		this.saleLine.removeAll(toRemove);
		this.iscomplete = true;
	}
	
	//public updatePoints() {};
	
}