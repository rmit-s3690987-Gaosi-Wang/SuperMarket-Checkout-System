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
   private String dateCreated;
   private double total;
   private static saleReport saleReport;


   public Sale(Customer ID, String saleID) {
      this.ID = ID;
      this.saleID = saleID;
      this.numItems = 0;
      this.dateCreated = this.dateCreated();

   }

   public int getNumItems() {
      return this.numItems;
   }

   public String getSaleID() {
      return this.saleID;
   }

   public double getTotal() {
      return this.total;
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
         this.deleteItem(i);
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

    //Sacnner
    public String selectFromList() {
        Scanner input = new Scanner(System.in);
        List<String> nameList = new ArrayList<>();
        for(Product p:Store.products) {
            nameList.add(p.getProductName());
        }
        for(int i = 0; i <nameList.size(); i++) {
            System.out.println(i + ". " + nameList.get(i));
        }
         // try and catch
        int selection = input.nextInt();
        input.close();
        return nameList.get(selection);
    }


    // public SaleLine addItemByList() {return constuctor of saleline and add}

    // make sure this method does not return null when there is a item with prodID.

    public boolean makePayment(double payment) {
        //checkout;
        if (payment > total) {
            System.out.println("Change for this transcation is: " + (total -  payment));
            return true;
        }
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

    /*intergrated in selectFromList method;
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


   public void generateSaleReport() {
      //output summary parameters of sales.
      //initial parameters
      double SaleTotal = 0;
      double SaleNum = 0;
      double cartTotal = 0;
      for (Sale i: Sale.saleReport.saleList) {
         SaleTotal += i.getTotal();
         SaleNum++;
      //need to finsih			//SaleLine Summary
         for(SaleLine s: i.cart) {
             cartTotal += s.getSubtotal();
         }
      }
         System.out.println("The total number of sales is: " + SaleNum);
         System.out.println("The total sale figure is: " + SaleTotal);
         System.out.println("This sale report is created on: " + dateCreated);
         Sale.saleReport.saleList = new ArrayList<>();
      }

    //How do we store product list, List<String> prodList as input
    //Prompt user to enter prod Name and Unit Price

   private static class saleReport{
     private static List<Sale> saleList = new ArrayList<>();
   }
}