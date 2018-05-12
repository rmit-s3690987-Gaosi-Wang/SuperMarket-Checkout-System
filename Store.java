import java.util.*;
import java.util.Scanner;

/**
 * Store class as driver.
 *
 * @author Wan Yi Beh
 * @version 1.0
 *
 */

public class Store {

   // Create an ArrayList of custom objects.
   private ArrayList<User> users = new ArrayList<User>();
   private ArrayList<Product> products = new ArrayList<Product>();

   // Variables.
   String username, password;

   static Scanner input = new Scanner(System.in);


   /**
    * Start run application - Store.
    * -------------------------------------------------
    * Primary Menu
    * -------------------------------------------------
    * 1. searchProdByID
    * 2. addProdById
    * 3. addProdByList
    * 4. submenuCustomer
    *
    */

   public Store mainMenu(Store store) {
      System.out.println("\n\n***************************************");
      System.out.println("**** Supermarket Management System ****");


      // Add new objects to the ArrayList.

      addData();

//      customers.add(new Customer("C001", "Peter",22,"M","peter"));
//      customers.add(new Customer("C002", "Sarah",22,"F","sarah"));
//

      int selection = 0;

      do {
         System.out.println("* -1. Check price by ID               *");
         System.out.println("* -2. Check promotions by ID          *");
         System.out.println("* -3. Checkout (members only)         *");
         System.out.println("* -4. Staff login                     *");
         System.out.println("* -5. Quit                            *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();
         switch (selection) {
            case 1: checkPriceByID();
            case 2: checkPromoByID();
            case 3: return store.submenuCustomer(store);
            case 4: return store.submenuStaff(store);
            case 5: return store;
            default:
               System.out.println("\nError: Invalid input. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 5);
      return store.mainMenu(store);
   }

   private Store submenuCustomer(Store store) {
      /*
       * checkout with ID and quantity or product name and weight (select the product name from given list).
       * check price of any item by keying in the ID before proceeding with the sale.
       * check discounts applicable.
       */
      int selection = 0;

      do {
//         System.out.println("Enter your loyalty number: ");
//         username = input.next();
//         User user = getCustByID(username);
//
//         if (user != null) {
//            System.out.println("Logged in!\n");
//         } else {
//            System.out.println("Please try again.\n");
//            continue;
//         }

//         checkCustomer();

         System.out.println("\n*********************************");
         System.out.println("* Welcome, " + "                *");
         System.out.println("* What would you like to do?    *");
         System.out.println("* - 1. Checkout                 *");
         System.out.println("* - 2. Check price              *");
         System.out.println("* - 3. Bulk discount offer      *");
         System.out.println("* - 4. Back to main menu        *");
         System.out.println("*********************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
//            case 1: return store.submenu1(store);
//            case 2: return store.submenu1(store);
//            case 3: return store.submenu1(store);
//            case 4: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 4);
      return store.mainMenu(store);
   }

   private Store submenuStaff(Store store) {
      /*
       * 3.0 MENU: STAFF
       * pick user role.
       * display user menu.
       */
      System.out.println("\n\n*********************************");

      int selection = 0;

      do {
         System.out.println("* Store/System                  *");
         System.out.println("* Login as:                     *");
         System.out.println("* - 1. Sales Staff              *");
         System.out.println("* - 2. Warehouse Manager        *");
         System.out.println("* - 3. Manager                  *");
         System.out.println("* - 4. Back to main menu        *");
         System.out.println("*********************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
//            case 1: checkUser();
//            case 2: User.authenticateUser();
//            case 3: User.displayRole();
            case 4: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 4);
      return store.mainMenu(store);
   }

   private Store submenuStaffManager(Store store) {
      /*
       * 3.1 MENU: Manager
       * display Manager menu.
       */
      System.out.println("\n\n*********************************");

      int selection = 0;

      do {
         System.out.println("* Store/System                  *");
         System.out.println("* Login as:                     *");
         System.out.println("* - 1. Replenish stock levels   *");
         System.out.println("* - 2. Override standard price  *");
         System.out.println("* - 3. Automatic restock order  *");
         System.out.println("* - 4. Generate sales report    *");
         System.out.println("* - 5. Offer special discounts  *");
         System.out.println("* - 6. Most profitable product  *");
         System.out.println("* - 7. Maintain supplier details*");
         System.out.println("* - 8. Back to main menu        *");
         System.out.println("*********************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
//            case 1: checkUser();
//            case 2: User.authenticateUser();
//            case 3: User.displayRole();
//            case 4: User.displayRole();
//            case 5: User.displayRole();
//            case 6: User.displayRole();
//            case 7: User.displayRole();
            case 8: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 8);
      return store.mainMenu(store);
   }

   private Store submenuStaffWHManager(Store store) {
      /*
       * 3.1 MENU: Warehouse Manager
       * display Warehouse Manager menu.
       */
      System.out.println("\n\n*********************************");

      int selection = 0;

      do {
         System.out.println("* Store/Warehouse Manager       *");
         System.out.println("* Login as:                     *");
         System.out.println("* - 1. Override transaction     *");
         System.out.println("* - 2. Back to main menu        *");
         System.out.println("*********************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            //            case 1: checkUser();
            case 2: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 2);
      return store.mainMenu(store);
   }

   private Store submenuStaffSalesStaff(Store store) {
      /*
       * 3.1 MENU: Sales Staff
       * display Sales Staff menu.
       */
      System.out.println("\n\n*********************************");

      int selection = 0;

      do {
         System.out.println("* Store/Sales Staff             *");
         System.out.println("* Login as:                     *");
         System.out.println("* - 1. Replenish stock levels   *");
         System.out.println("* - 2. Back to main menu        *");
         System.out.println("*********************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            //            case 1: checkUser();
            case 2: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 2);
      return store.mainMenu(store);
   }


   
   /**
    * Primary Menu - Methods
    * -------------------------------------------------
    * 1. SearchProdByID (getProdByID + displayProdInfo)
    * 2. AddProdById
    * 3. AddProdByList
    *
    *
    */

   private void checkPriceByID() {
      char exit = ' ';
      do {
         System.out.print("Please input product code: ");
         String prodID = input.next();
         Product product = getProdByID(prodID);

         if (product != null) {
            displayProdUnitPrice(product);
         } else {
            System.out.println("\nError: Your input was invalid. Please try again.");
            continue;
         }
         System.out.println("\nReturn(Y/N)? Press Y for exit or any other keys to continue.");
         exit = input.next().charAt(0);
      } while (exit != 'Y' && exit != 'y');
   }

   private void checkPromoByID() {
      char exit = ' ';
      do {
         System.out.print("Please input product code: ");
         String prodID = input.next();
         Product product = getProdByID(prodID);

         if (product != null) {
            displayProdSalePrice(product);
         } else {
            System.out.println("\nError: Your input was invalid. Please try again.");
            continue;
         }
         System.out.println("\nReturn(Y/N)? Press Y for exit or any other keys to continue.");
         exit = input.next().charAt(0);
      } while (exit != 'Y' && exit != 'y');
   }

   private void addProdByID() {

   }




   /**
    * Fetch product by ID.
    * -----------------------------------
    * Support - SearchProdByID,
    */

   public Product getProdByID(String prodID) {
      Product p = null;

      for (int i = 0; i < products.size(); i++) {
         p = products.get(i);
         if(p.getProdID().compareTo(prodID) == 0) {
            break;
         } else {
            p = null;
         }
      }
      return p;
   }

   /**
    * Fetch customer by ID.
    * -----------------------------------
    * Support - submenu1,
    */

//   public User getCustByID(String userID) {
//      User u = null;
//
//      for (int i = 0; i < customers.size(); i++) {
//         u = customers.get(i);
//         if(u.getUserID().compareTo(userID) == 0) {
//            break;
//         } else {
//            u = null;
//         }
//      }
//      return u;
//   }

   /**
    * Display all details on one product.
    * -----------------------------------
    * Support - SearchProdByID,
    */

   public void displayProdUnitPrice(Product product){
      System.out.println("\n*********************************");
      System.out.println("* Information on product: " + product.getProdID() + "  *");
      System.out.println("* Product: " + product.getProductName());
      System.out.println("* Unit Price: $" + product.getUnitPrice());
   }

   public void displayProdSalePrice(Product product){
      System.out.println("\n*********************************");
      System.out.println("* This week's offer on " + product.getProdID() + "!    *");
      System.out.println("* Product: " + product.getProductName());
      System.out.println("* Sale Price: $" + product.getSalesPrice());
   }

//   public boolean checkUser() {
//      System.out.println("Enter your username: ");
//      username = input.next();
//
//      System.out.println("Enter your password: ");
//      password = input.next();
//
//      for (int i = 0; i < users.size(); i++) {
//         if (users.get(i).getName().compareTo(username) == 0 && users.get(i).getPassword().compareTo(password) == 0) {
//            System.out.print("Welcome back! Taking you to your menu.");
//         }
//         User.menu();
//      }
//      return false;
//   }

   public void addData() {

      Product apple = new Product("PROD001","APPLE",5,4, 20, 3.8,500,100,
                                  400,"EA",false,"S001");
      Product orange = new Product("PROD002","ORANGE",6,5, 20, 4,500,100,
                                   400,"EA",false,"S002");
      Product pizza = new Product("PROD003","PIZZA",15,12, 20, 11,100,20,
                                  80,"EA",false,"S003");
      Product doll = new Product("PROD004","SCARY DOLL",20,18, 10, 17,100,30,
                                 70,"EA",false,"S004");
      Product meth= new Product("PROD005","METH",2000,1900, 10, 1880,100,50,
                                50,"KG",false,"S005");
      Product laptop= new Product("PROD006","LAPTOP",3000,2900, 5, 2990,50,10,
                                  50,"EA",false,"S006");
      Product boyfriend= new Product("PROD007","BOYFRIEND",1000,998, 5, 889,50,25,
                                     25,"EA",false,"S007");

      products.add(apple);
      products.add(orange);
      products.add(pizza);
      products.add(doll);
      products.add(meth);
      products.add(laptop);
      products.add(boyfriend);

      users.add(new Customer("C001","Sarah","Moore","sarahM"));
      users.add(new Customer("C002","Peter","Luke","peterL"));
      users.add(new Customer("C003","Jane","Doe","janeD"));
   }

}
