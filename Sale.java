import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Sale{

   private int saleID;
   private Customer ID;
   private List<SaleLine> cart = new ArrayList<>();
   private int numItems;
   private String dateCreated;
   private double total;
   private List<Sale> saleReport = new ArrayList<>();


   public Sale(Customer ID, int saleID) {
      this.ID = ID;
      this.saleID = saleID;
      this.numItems = 0;
      this.dateCreated = this.dateCreated();
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
      this.cart.add(item);
      this.numItems++;
   }

   public void deleteItem(SaleLine item) {
      this.cart.remove(item);
      this.numItems--;
   }

   public void resetSale() {
      for (SaleLine i: cart){
         cart.remove(i);
      }
   }

   public boolean isEmpty() {
      if (this.numItems == 0) {
         return true;
      }
      else return false;
   }

   public double calcTotal() {
      for(SaleLine i:this.cart) {
         this.total += i.calcSubtotal();
      }
      return this.total;
   };


   // public SaleLine addItemByList() {return constuctor of saleline and add}

   // make sure this method does not return null when there is a item with prodID.

   public void makePayment() {

   }


   public void updatePoints() {

   }

   //for driver class:

   public void generateSaleReport(List<Sale> SaleReport) {
      double SaleTotal = 0;
      double SaleNum = 0;
      for(Sale i:SaleReport){
         SaleTotal += i.getTotal();
         SaleNum++;
      }
      System.out.println("The total number of sales is: " + SaleNum);
      System.out.println("The total sale figure is: " + SaleTotal);
   }


   public String dateCreated() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      return dtf.format(now);
   }


   //   public void getProdNames() {
   //      System.out.println("Product Name:");
   //      String name;
   //      //ChangeStore.products to input
   //      for(Product p: Store.products) {
   //         name = p.getProdName();
   //         System.out.println(name);
   //      }
   //   }

   //getters
   public int getNumItems() {
      return this.numItems;
   }

   public int getSaleID() {
      return this.saleID;
   }

   public double getTotal() {
      return this.total;
   }

   //How do we store product list, List<String> prodList as input
   //Prompt user to enter prod Name and Unit Price

}