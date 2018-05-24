import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * Sale item can be seen as a cart, it aggregate all items which customer specify
 * Quantities and calculate the total price for them.
 * It also supports the functionality of make payment and checkout to control stock
 * level after each successful purchase.
 * @author Ken
 * @version 2.0
 */
public class Sale{

   private String saleID;
   private Customer ID;
   private List<SaleLine> cart = new ArrayList<>();
   private int numItems;
   private double total;
   private Date dateCreated;

   public Sale(Customer ID, String saleID) {
      this.ID = ID;
      this.saleID = saleID;
      numItems = 0;
      dateCreated = dateCreated();
   }

   /**
    * Adding item to cart if sale line's quantity is more than 0.
    * @param item
    */
   public void addItem(SaleLine item) {
	  boolean existed = false;
	  if (item.getQty() > 0) {
		  for(SaleLine s: cart) {
			  if (s.getProduct() == item.getProduct()) {
				  s.setQuantity(s.getQty() + item.getQty());
				  existed = true;
			  }
		  }
	  if(!existed) {
		  this.cart.add(item);
		  this.numItems++;
			  }
      calcTotal();
      System.out.println("You just added 1 item ("
    		  + getNumItems() + " item in total)");
      }
   }
   
   /**
    * Delete item in cart and calculate the total price in cart to make sure
    * the price is up with deletion.
    * @param item
    */
   public void deleteItem(SaleLine item) {
      this.cart.remove(item);
      this.numItems--;
      calcTotal();
   }
   
   /**
    * Reset whole sale, it supports the functionality of staff memebers.
    */
   public void resetSale() {
     for (SaleLine i: cart){
         this.deleteItem(i);
     }
     calcTotal();
   }

   /**
    * @return total The total price of the cart.
    */
   public double calcTotal() {
	 total = 0;
     for(SaleLine i:this.cart) {
         this.total += i.calcSubtotal();
         }
     return this.total;
   }
   
   /**
    * Promt customer to select a item from generated product list.
    * @return item which customer selected from product list.
    */
   public String selectFromList() {
	   Scanner sFLinput = new Scanner(System.in);
	   ArrayList<String> nameList = new ArrayList<>();
	   System.out.println("ID   Name       Price");
	   String r = " ";
	   for(Product p:Store.products) {
        		r = new String(new char[11-p.getProductName().length()]).replace("\0", " ");
        		nameList.add(p.getProductName());
        		System.out.println(p.getProdID() 
        				+ " " + p.getProductName()
        				+ r + p.getUnitPrice());
	   }
        String pn = null;
        System.out.println("\nInsert product name:");
        while (pn == null) {
        pn = sFLinput.nextLine();
        for(int i = 0; i <nameList.size(); i++) {
        		if(nameList.get(i).equals(pn.toUpperCase())) {
        			pn = pn.toUpperCase();
        			return pn;}
        }
        pn = null;
        System.out.println("Please enter the correct product name:");
        } 
        return pn;  // try and catch}
    }
   
   	
   	/**
   	 * @param payment total amount in cart.
   	 * @return true if there is more cash provided than payment request, vice versa.
   	 */
    public boolean makePayment(double payment) {
        //checkout;
        if (payment >= total) {
        		for(SaleLine s: getCart()) s.checkout();
            System.out.println("Change for this transcation is: " 
        + (payment - total) + " Dollars");
            return true;
        }
        System.out.println("Need more cash.");
        return false;
    }


    public Date dateCreated(){
        return new Date();
    	}
    
    public void inCart() {
	   String r = " ";
	   System.out.println("\n" + numItems + " items in cart:");
	   System.out.println("Description");
	   for(SaleLine s:cart) {
		   r = new String(new char[14-s.getProdName().length()]).replace("\0", " ");
		   System.out.println(s.getProdID() 
   				+ "    " + s.getProdName()
   				+ r + s.getQty() + " x " + s.getPrice() + "      " +  s.getSubtotal());
	   }
	   System.out.println("Total: $" + getTotal());
    }
   
    //Getters
	public int getNumItems() {
		return numItems;
	}

	public String getSaleID() {
		return saleID;
	}

	public double getTotal() {
		return total;
	}
   
	public List<SaleLine> getCart(){
		return cart;
	}	
   
	public SaleLine getSaleLineByID(String itemID) {
		try {
			for (SaleLine s: getCart()) {
				if (s.getProdID().toUpperCase().equals(itemID.toUpperCase())) {
					return s;
				}
				else	 throw new Exception("SaleLine item cannot be found.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
   
	/**
	 * This method prompt user to input ID and quantity in order to 
	 * add item to cart
	 * to add item.
	 * This method supports the functionality case 1 of 2.1 sub meanu of customer
	 */
	public void addItemByIDandQuantity() {
		Scanner input = new Scanner(System.in);
		System.out.println("Insert product ID:");
		String prodID = input.next();
		System.out.println("Insert quantity:");
		int quantity = input.nextInt();
		addItem(new SaleLine(prodID, quantity));
	}
	
	
	/**
	 * This method prompt user to input name and weight in order to 
	 * add item to cart
	 * to add item.
	 * This method supports the functionality case 1 of 2.1 sub meanu of customer
	 */
	public void addItemByNameandWeight() {
		Scanner stringInput = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		String prodName = selectFromList();
        System.out.println("Insert quantity:");
        double weight = intInput.nextDouble();
        addItem(new SaleLine(prodName, weight));
	}
	
	public boolean deleteitem(String itemID) { // Added By Senadhi
		SaleLine item;
		boolean removed = false;
		for ( int i = 0; i < cart.size(); i++) {
	    		if (cart.get(i).getProdID().equals(itemID)) {
	    			item = cart.get(i);
	    			this.cart.remove(item);
	    			this.numItems--;
	    			calcTotal();
	    			removed = true;
	    		}    	
		}
		return removed;
	}
   
	public void addDemoItem(SaleLine item) { // added By Senadhi for Demo
		if (item.getQty() > 0) {
			this.cart.add(item);
			this.numItems++;
			calcTotal();
		}
	}
}
