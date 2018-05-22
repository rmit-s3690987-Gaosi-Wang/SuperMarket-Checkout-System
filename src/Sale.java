/**
 * Sale class.
 *
 * @author Ken
 * @version 1.0
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Sale item can be seen as a cart, it aggregate all items which customer specify
 * Quantities and calculate the total price for them.
 * It also supports the functionality of make payment and checkout to control stock
 * level after each successful purchase.
 * @author Ken
 */
public class Sale{

   private String saleID;
   private Customer ID;
   private List<SaleLine> cart = new ArrayList<>();
   private int numItems;
   private double total;
   private String dateCreated;

   public Sale(Customer ID, String saleID) {
      this.ID = ID;
      this.saleID = saleID;
      numItems = 0;
      dateCreated = dateCreated();
   }

   public void addItem(SaleLine item) {
	  if (item.getQty() > 0) {
      this.cart.add(item);
      this.numItems++;
      calcTotal();
      System.out.println("You just added 1 item ("
    		  + getNumItems() + " item in total)");
      }
   }
   
   public void deleteItem(SaleLine item) {
      this.cart.remove(item);
      this.numItems--;
      calcTotal();
   }

   public void resetSale() {
     for (SaleLine i: cart){
         this.deleteItem(i);
     }
     calcTotal();
   }

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
<<<<<<< HEAD


        if (payment >= total) {

=======
        if (payment >= total) {
        		for(SaleLine s: getCart()) s.checkout();
>>>>>>> 38600028ca388ceafd5f5f673f42d9527a96095d
            System.out.println("Change for this transcation is: " 
        + (payment - total) + " Dollars");
            return true;
        }
        System.out.println("Need more cash.");
        return false;
    }


    public String dateCreated(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
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
}
