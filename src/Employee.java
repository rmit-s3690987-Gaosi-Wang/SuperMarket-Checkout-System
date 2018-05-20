/**
 * User - Employee class.
 *
 * @author Jed
 * @version 1.0
 *
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

   public void checkStock(Product product) {
      System.out.println("The current stock quantity of the product "+product.getProductName() +" is "+ product.getQuantity());
      try {
         if (product.getQuantity() < product.getReplenishLine()) {
            replenish(product, product.getUnit());
            System.out.println("The stock level of product is too low, " +"automatically replenishing product "
                    + product.getProductName() +" " + product.getProdID()+
                    " of " + product.getReplenishQuantity());
            System.out.println("After replenish, the current stock level is "+ product.getQuantity());
         }
         else
            {System.out.println("There is sufficient product in stock, no need to replenish");
            }

      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void replenish(Product product, String unit) {
      product.setQuantity((int) (product.getQuantity() + product.getReplenishQuantity()));
      product.setUnit(unit);
   }
}