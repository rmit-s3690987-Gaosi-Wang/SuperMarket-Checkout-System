/**
 * User - Employee - Manager class.
 *
 * @author Jed
 * @version 1.0
 *
 */

public class StoreManager extends Employee 
{
   public StoreManager(String employeeID, String password, String firstName, String lastName) 
   {
      super(employeeID, password, firstName, lastName);
   }

   public void alterPrice(Product product, double price)
   {
      product.setUnitPrice(price);
   }

   public void setStockLevel(Product product, double level) 
   {
      product.setReplenishLine(level);
   }

   public void reorder(Product product, double quantity) 
   {
   //        /*System.out.println("reorder product" + product.getProductName() + " " +
   //            product.getProductID()+ " from supplier " + product.printSupplier() + " for "
   //            + product.getQuantity() + " " +product.getUnit() );*/
        product.setQuantity(product.getQuantity()+quantity);
    }

   /* public void updateSupplier(Product product, String supplier) {
        product.setSupplier(supplier);
    }
    */

   //offer discount in percentage off without prerequisites
      public void promote(Product product, double discount) 
      {
         product.setSalesPrice((product.getUnitPrice() * (1 - discount/100)));
         product.setOnSale(true);
      }
   //offer discount for bulk purchase, bulk definition required
   public void bulkDiscount(Product product, double bulkQuantity, double bulkDiscount) 
   {
      product.setBulkPrice(product.getUnitPrice() * (1 - bulkDiscount/100));
      product.setBulk(bulkQuantity);
   }

   public void setReplenishQuantity(Product product, double quantity) 
   {
      product.setReplenishQuantity(quantity);

   }

   public void demote(Product product) 
   {
      product.setOnSale(false);
   }
}

