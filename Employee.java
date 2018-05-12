public abstract class Employee extends User {
	String employeeID, password;
   

   public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

public Employee(String employeeID, String password, String firstName, String lastName) {
		super(firstName, lastName);
		this.employeeID = employeeID;
		this.password = password;
	}

public void checkStock(Product product) {
      System.out.println("The current stock quantity of the product "+product.getProductName() +" is "+ product.getQuantity());
      try {
         if (product.getQuantity() < product.getReplenishLine()) {
            replenish(product, product.getUnit());
         }
         System.out.println("automatically replenish product " + product.getProductName() +" " + product.getProdID()+
                                    " of " + product.getReplenishQuantity()
         );
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void replenish(Product product, String unit) {
      product.setQuantity((int) (product.getQuantity() + product.getReplenishQuantity()));
      product.setUnit(unit);
   }

   @Override
   public void menu() {

   }
   
//   public String displayRole(Object a) {
//	      if ( a instanceof Customer ) {
//	         return "Customer";
//	      }
//	      else if ( a instanceof SalesStaff ) {
//	         return "SalesStaff";
//	      }
//	      else if ( a instanceof StoreManager ) {
//	         return "StoreManager";
//	      }
//	      if ( a instanceof WHManager) {
//	         return "Warehouse Manager";
//	      }
//	      else {
//	         return "Not an Entiity";
//	      }
//	   }
}