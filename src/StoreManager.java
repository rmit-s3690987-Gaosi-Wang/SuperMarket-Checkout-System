import java.util.Scanner;

/**
 * User - Employee - Manager class.
 *
 * @author Jed
 * @version 1.0
 */

public class StoreManager extends Employee {
   public StoreManager(String employeeID, String password, String firstName, String lastName) {
      super(employeeID, password, firstName, lastName);
   }

   //change the current unit price for a product
   public void alterPrice(Product product, double price) {
      product.setUnitPrice(price);
      System.out.print("You have changed the current price of product " + product.getProductName() +
                               " to " + product.getUnitPrice() + ", unit of " + product.getUnit());
      System.out.println();
   }

   //set automatic relenish level
   public void setStockLevel(Product product, double level) {
      product.setReplenishLine(level);
      System.out.print("You have changed the replenish level of product " + product.getProductName() + " to "
                               + product.getReplenishLine());
      System.out.println();
   }

   //reorder
   public void reorder(Product product, double quantity) {
      product.setQuantity(product.getQuantity() + quantity);
      System.out.println("You have reordered the product " + product.getProductName() + " of " + quantity +
                                 " " + product.getUnit());
      System.out.println("The current stock level of product " + product.getProductName() + " is " +
                                 product.getQuantity() + " " + product.getUnit());
      System.out.println();
   }


   //offer discount in percentage off without prerequisites
   public void promote(Product product, double discount) {
      product.setSalesPrice((product.getUnitPrice() * (1 - discount / 100)));
      product.setOnSale(true);
      System.out.println("You have offered the discount of " + discount + "%" + " to the product. The " +
                                 "current sale price is " + product.getSalesPrice());
   }

   //offer discount for bulk purchase, bulk definition required
   public void bulkDiscount(Product product, double bulkQuantity, double bulkDiscount) {
      product.setBulkPrice(product.getUnitPrice() * (1 - bulkDiscount / 100));
      product.setBulk(bulkQuantity);
      System.out.print("For purchase quantity over " + product.getBulk() + " , " +
                               "The price has a discount of " + bulkDiscount + "%, " + "making the bulk price: " +
                               product.getBulkPrice() + " " + product.getUnit());
      System.out.println();
   }

   //the difference between replenish and reorder is replenish is automatic and can only reorder a predefined amount where as
   //reorder can decide the amount to reorder from input.
   public void setReplenishQuantity(Product product, double quantity) {
      product.setReplenishQuantity(quantity);
      System.out.println("You have set the automatic replenish quanity for product " + product.getProductName() + " to "
                                 + quantity + " when the current stock level is below Replenish Line of " + product.getReplenishLine());
   }

   //put a product off sale
   public void demote(Product product) {
      try {
         if (product.isOnSale() == false) {
            System.out.println("Product is not on sale, no action required");
         }
         else {
            product.setOnSale(false);
            System.out.println("The product is no longer on sale.");
         }
         System.out.println();
      } catch (Exception e) {
         System.out.println("not valid input, please try again");
      }
   }
}