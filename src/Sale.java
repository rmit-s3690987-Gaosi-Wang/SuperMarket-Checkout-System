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
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Sale{

   private String saleID;
   private Customer ID;
   private List<SaleLine> cart = new ArrayList<>();
   private int numItems;
   private double total;
   private String dateCreated;
   private static saleReport saleReport;


   public Sale(Customer ID, String saleID) {
      this.ID = ID;
      this.saleID = saleID;
      numItems = 0;
      dateCreated = dateCreated();
   }

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

    //driver or sale class invoke constructor
    /*
    public SaleLine createSaleLine(String prodID,
            int quantity) {
        SaleLine prodID = new SaleLine(prodID, quantity);
        return prodID;
    }
    */

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
     total = 0;
   }


   public boolean isEmpty() {
     if (this.numItems == 0) {
         return true;
     }
     else return false;
   }


   public double calcTotal() {
	 total = 0;
     for(SaleLine i:this.cart) {
         this.total += i.calcSubtotal();
         }
     return this.total;
   };

    //Sacnner
   	//
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

    // public SaleLine addItemByList() {return constuctor of saleline and add}

    // make sure this method does not return null when there is a item with prodID.

    public boolean makePayment(double payment) {
        //checkout;
        if (payment > total) {
            System.out.println("Change for this transcation is: " 
        + (payment - total) + " Dollars");
            return true;
        }
        System.out.println("Need more cash.");
        return false;
    }


    public void updatePoints() {

    }

    //for driver class:


    public String dateCreated() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    /* interreated in selectFromList method;
    public void getProdNames() {
        System.out.println("Product Name:");
        String name;
        //ChangeStore.products to input
        for(Product p: Store.products) {
            name = p.getProdName();
            System.out.println(name);
        }
    }
    */
   public void inCart() {
	   String r = " ";
	   System.out.println("\n" + numItems + " items in cart:");
	   System.out.println("ID   Name       Subtotal");
	   for(SaleLine s:cart) {
		   r = new String(new char[11-s.getProdName().length()]).replace("\0", " ");
		   System.out.println(s.getProdID() 
   				+ " " + s.getProdName()
   				+ r + s.getSubtotal());
	   }
	   System.out.println("Total: $" + getTotal());
   }


    //How do we store product list, List<String> prodList as input
    //Prompt user to enter prod Name and Unit Price

   private static class saleReport{
     private static List<Sale> saleList = new ArrayList<>();
   }
}