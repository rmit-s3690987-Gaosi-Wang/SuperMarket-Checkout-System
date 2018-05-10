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
   private ArrayList<Customer> customers = new ArrayList<Customer>();
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
      customers.add(new Customer("C001", "Peter",22,"M","peter"));
      customers.add(new Customer("C002", "Sarah",22,"F","sarah"));

      products.add(new Product("P001", "Coca Cola",22,10.0,3.00, 3.00, 2.00));
      products.add(new Product("P002", "Pepsi",22,10.0,3.00, 3.00, 2.00));


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
            case 3: addProdByID();
            case 4: return store.submenuCustomer(store);
            case 5: return store;
            default:
               System.out.println("\nError: Invalid input. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 5);
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

         checkCustomer();

         System.out.println("\n*********************************");
         System.out.println("* Welcome, " + username + "                 *");
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

   private Store submenu2(Store store) {
      /*
       * checkout with ID and quantity or product name and weight (select the product name from given list).
       * check price of any item by keying in the ID before proceeding with the sale.
       * check discounts applicable.
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
            case 1: return store.submenuCustomer(store);
            case 2: return store.submenuCustomer(store);
            case 3: return store.submenuCustomer(store);
            case 4: return store.mainMenu(store);
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("*********************************");
         }
      } while (selection != 4);
      return store.mainMenu(store);
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

   public User getCustByID(String userID) {
      User u = null;

      for (int i = 0; i < customers.size(); i++) {
         u = customers.get(i);
         if(u.getUserID().compareTo(userID) == 0) {
            break;
         } else {
            u = null;
         }
      }
      return u;
   }

   /**
    * Display all details on one product.
    * -----------------------------------
    * Support - SearchProdByID,
    */

   public void displayProdUnitPrice(Product product){
      System.out.println("\n*********************************");
      System.out.println("* Information on product: " + product.getProdID() + "  *");
      System.out.println("* Product: " + product.getProdName());
      System.out.println("* Unit Price: $" + product.getUnitPrice());
   }

   public void displayProdSalePrice(Product product){
      System.out.println("\n*********************************");
      System.out.println("* This week's offer on " + product.getProdID() + "!    *");
      System.out.println("* Product: " + product.getProdName());
      System.out.println("* Sale Price: $" + product.getSalePrice());
   }


   public boolean checkCustomer() {
      System.out.println("Enter your loyalty number: ");
      username = input.next();
      User user = getCustByID(username);

      if (getCustByID(username) instanceof Customer) {
         return true;
      }
      return false;
   }

}