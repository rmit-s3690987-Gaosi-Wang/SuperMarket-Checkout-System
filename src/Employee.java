/**
 * User - Employee class.
 *
 * @author Jed
 * @version 1.0
 */

public abstract class Employee extends User {
   String employeeID, password;

   public Employee(String employeeID, String password, String firstName, String lastName) {
      super(firstName, lastName);
      this.employeeID = employeeID;
      this.password = password;
   }

   public String getEmployeeID() {
      return employeeID;
   }

   public String getPassword() {
      return password;
   }

   public void setEmployeeID(String employeeID) {
      this.employeeID = employeeID;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   //If current stock value is below replenish line, conduct automatic replenish
   public void checkStock(Product product) {
      System.out.println("The current stock quantity of the product " + product.getProductName() + " is " + product.getQuantity());
      try {
         if (product.getQuantity() < product.getReplenishLine()) {
            replenish(product);
            System.out.println("The stock level of product is too low, " + "automatically replenishing product "
                                       + product.getProductName() + " " + product.getProdID() +
                                       " of " + product.getReplenishQuantity());
            System.out.println("After replenish, the current stock level is " + product.getQuantity());
         }
         else {
            System.out.println("There is sufficient product in stock, no need to replenish");
         }
         System.out.println();
      } catch (Exception e) {
         System.out.println("invalid input, please try again");
      }

   }

   //can only replenish a fixed amount defined by store manager
   public void replenish(Product product) {
      try {
         product.setQuantity((product.getQuantity() + product.getReplenishQuantity()));
         System.out.print("After replenish the predefined amount, the current stock level of the product "
                                  + product.getProductName() + " is " + product.getQuantity());
         System.out.println();
      } catch (Exception e) {
         System.out.println("invalid input, please try again");
      }
   }

   public boolean topupCredit(LoyalityCard loyalitycard, double amount) {
      return false;
   }

   public boolean removeCartItem(Sale sale, String itemID) {
      return true;
   }


}
