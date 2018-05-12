public abstract class User {
   private String id,firstName,lastName, password;

   public User (String id,String firstName, String lastName, String password) {
      this.id = id;
      this.firstName = firstName;
      this.lastName  = lastName;
      this.password = password;
   }

   public String getName() {
      return firstName + " " + lastName;
   }

   public String getPassword() {
      return password;
   }

   public boolean authenticateUser(String id, String password) {
      if (this.id.equals(id) && this.password.equals(password)) {
         return true;
      }else {
         return false;
      }
   }

   public String displayRole(Object a) {
      if ( a instanceof Customer ) {
         return "Customer";
      }
      else if ( a instanceof SalesStaff ) {
         return "SalesStaff";
      }
      else if ( a instanceof StoreManager ) {
         return "StoreManager";
      }
      if ( a instanceof WHManager) {
         return "Warehouse Manager";
      }
      else {
         return "Not an Entiity";
      }
   }

   //   to show menu
   public abstract void menu();

}
