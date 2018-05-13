/**
 * Store class as driver.
 *
 * @author Wan Yi Beh
 * @version 1.0
 *
 */

import java.util.*;

public class Store {

   // Create an ArrayList of custom objects.
   private ArrayList<Employee> employees = new ArrayList<Employee>();
   private ArrayList<Customer> customers = new ArrayList<Customer>();
   private ArrayList<Sale> sales = new ArrayList<Sale>();
   public static ArrayList<Product> products = new ArrayList<Product>();

   // Variables.
   String username, password;
   static Scanner input = new Scanner(System.in);

   /**
    * Start run application - Store.
    * -------------------------------------------------
    * Menus
    * -------------------------------------------------
    * 1. mainMenu
    * 2. submenuCustomerLogin
    * 3. submenuCustomer
    * 4. submenuStaffLogin
    * 5. submenuStaffManager
    */

   public void mainMenu() {

      // Add new objects.
      addData();

      int selection = 0;

      do {
         System.out.println("\n***************************************");
         System.out.println("**** Supermarket Management System ****");
         System.out.println("* -1. Check price by ID               *");
         System.out.println("* -2. Check promotions by ID          *");
         System.out.println("* -3. Checkout (members only)         *");
         System.out.println("* -4. Staff login                     *");
         System.out.println("* -5. Quit                            *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();
         switch (selection) {
            case 1:
               checkPriceByID();
               break;
            case 2:
               checkPromoByID();
               break;
            case 3:
               submenuCustomerLogin();
               break;
            case 4:
               submenuStaffLogin();
               break;
            case 5:
               System.out.println("\n***************************************");
               System.out.println("* Supermarket Management System       *");
               System.out.println("* Shutting down.......................*");
               System.out.println("***************************************");
               System.exit(0);
               break;
            default:
               System.out.println("\nError: Invalid input. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 5);
      mainMenu();
   }

   private void submenuCustomerLogin() {
      /*
       * 2.0 MENU: Customer
       * Menu serves as a login window to access customer's options.
       */
      System.out.println("Please enter your customer ID : ");
      Scanner sc = new Scanner(System.in);
      String userId = sc.nextLine();
      validateCustomer(userId, customers);
   }

   private void submenuCustomer() {
      /*
       * 2.1 MENU: Customer
       * Menu serves to display Customer's capabilities.
       * checkout with ID and quantity or product name and weight (select the product name from given list).
       * check price of any item by keying in the ID before proceeding with the sale.
       * check discounts applicable.
       */
      int selection = 0;

      do {
         System.out.println("\n***************************************");
         System.out.println("* Store/Menu/Customer                 *");
         System.out.println("* What would you like to do?          *");
         System.out.println("* - 1. Add products to cart           *");
         System.out.println("* - 2. Checkout                       *");
         System.out.println("* - 3. Check price                    *");
         System.out.println("* - 4. Bulk discount offer            *");
         System.out.println("* - 5. Back to main menu              *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
//            case 1: KEN - Add products to cart
//            case 2: KEN - Checkout
            case 3: checkPriceByID();
            case 4: checkBulkByID();
            case 5: mainMenu();
               break;
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 5);
      mainMenu();
   }

   private void submenuStaffLogin() {
      /*
       * 3.0 MENU: Staff Login
       * Menu serves as a login window to access each user role's options.
       */
      System.out.println("Please enter your employee ID : ");
      Scanner sc = new Scanner(System.in);
      String userId = sc.nextLine();
      System.out.println("Please enter your password: ");
      String password = sc.nextLine();
      validateStaff(userId, password, employees);
   }

   private void submenuStaffManager(Employee temp) {
      /*
       * 3.1 MENU: Manager
       * Menu serves to display Manager's capabilities.
       */
      System.out.println("\n***************************************");

      int selection = 0;
      Product target;
      StoreManager a = (StoreManager)temp;

      do {
         System.out.println("* Store/Menu/Manager                 *");
         System.out.println("* -1. Reorder stock levels           *");
         System.out.println("* -2. Override standard price        *");
         System.out.println("* -3. Set Replenish Level            *");
         System.out.println("* -4. Generate sales report          *");
         System.out.println("* -5. Offer special discounts        *");
         System.out.println("* -6. Offer bulk discounts           *");
         System.out.println("* -7. Most profitable product        *");
         System.out.println("* -8. Check supplier details         *");
         System.out.println("* -9. Back to main menu              *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            case 1:
               System.out.print("Enter the product ID to adjust: ");
               Scanner in = new Scanner(System.in);
               String input = in.nextLine();
               System.out.print("Enter quantity of product to reorder: ");
               Scanner qty = new Scanner(System.in);
               Double qtyReorder= qty.nextDouble();
               target = getProdByID(input);
               a.reorder(target,qtyReorder );
               submenuStaffManager(temp);
               in.close();
               qty.close();
               break;
            case 2:
               System.out.print("Please input the product(ID) to change price: ");
               Scanner scanner2 = new Scanner(System.in);
               String input2 = scanner2.nextLine();
               System.out.print("Please enter your new price: ");
               Scanner price2 = new Scanner(System.in);
               Double price2ToChange = price2.nextDouble();
               target = getProdByID(input2);
               a.alterPrice(target,price2ToChange);
               submenuStaffManager(temp);
               scanner2.close();
               price2.close();
               break;
            case 3:
               System.out.print("Please input the product(ID) to maintain stock level: ");
               Scanner scanner3 = new Scanner(System.in);
               String input3 = scanner3.nextLine();
               System.out.print("Please enter the maintain level of the product: ");
               Scanner level = new Scanner(System.in);
               Double levelToChange = level.nextDouble();
               target = getProdByID(input3);
               a.setStockLevel(target,levelToChange);
               submenuStaffManager(temp);
               scanner3.close();
               level.close();
               break;
            //case 4: KEN
            case 5:
               System.out.print("Please input the product(ID) to offer discounts: ");
               Scanner scanner5 = new Scanner(System.in);
               String input5 = scanner5.nextLine();
               System.out.print("Please enter the percentile discount: ");
               Scanner offer = new Scanner(System.in);
               Double offerToChange = offer.nextDouble();
               target = getProdByID(input5);
               a.promote(target, offerToChange);
               submenuStaffManager(temp);
               scanner5.close();
               offer.close();
               break;
            case 6:
               System.out.print("Please input the product(ID) to offer bulk discounts: ");
               Scanner scanner6 = new Scanner(System.in);
               String input6 = scanner6.nextLine();
               System.out.print("Please input the quantity for bulk purchase: ");
               Scanner bulk = new Scanner(System.in);
               Double bulkQuantity = bulk.nextDouble();
               System.out.print("Please enter the percentile discount for bulk purchase: ");
               Double bulkPrice= bulk.nextDouble();
               target = getProdByID(input6);
               a.bulkDiscount(target,bulkQuantity,bulkPrice);
               submenuStaffManager(temp);
               scanner6.close();
               bulk.close();
               break;
            //case 7: KEN
            case 8:
               System.out.print("Please enter the ID of the product you want to get supplier information");
               Scanner scanner8 = new Scanner(System.in);
               String input8 = scanner8.nextLine();
               target = getProdByID(input8);
               System.out.println("The supplier of the product " + target.getProductName() + " is" + target.getSupplierId());
               submenuStaffManager(temp);
               scanner8.close();
               break;
            case 9:
               mainMenu();
               break;
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection <1 || selection >9);
      mainMenu();
   }

   private void submenuStaffWHManager(Employee temp) {
      /*
       * 3.2 MENU: Warehouse Manager
       * Menu serves to display Warehouse Manager's capabilities.
       */
      System.out.println("\n***************************************");

      int selection = 0;
      Product target;
      StoreManager a = (StoreManager)temp;

      do {
         System.out.println("* Store/Menu/Warehouse Manager         *");
         System.out.println("* Login as:                            *");
         System.out.println("* - 1. Replenish stock levels          *");
         System.out.println("* - 2. Check Stock levels              *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            case 1:
               System.out.print("Enter the product ID to adjust: ");
               Scanner in = new Scanner(System.in);
               String input = in.nextLine();
               System.out.print("Enter quantity of product to reorder: ");
               Scanner qty = new Scanner(System.in);
               Double qtyReorder= qty.nextDouble();
               target = getProdByID(input);
               a.reorder(target,qtyReorder );
               submenuStaffManager(temp);
               in.close();
               qty.close();
               break;
            case 2: mainMenu();
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 2);
      mainMenu();
   }

   private void submenuStaffSalesStaff(Employee temp) {
      /*
       * 3.3 MENU: Sales staff
       * Menu serves to display Sales Staff's capabilities.
       */
      System.out.println("\n\n*********************************");

      int selection = 0;

      do {
         System.out.println("* Store/Menu/Sales Staff              *");
         System.out.println("* Login as:                           *");
         System.out.println("* - 1. Delete cart                    *");
         System.out.println("* - 2. Delete item in cart            *");
         System.out.println("* - 3. Back to main menu              *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            //case 1: SENADHI
            //case 2: SENADHI
            case 3: mainMenu();
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection != 2);
      mainMenu();
   }



   /**
    * Menu - Methods
    * --------------------------------------------------------------------------
    * 1. validateCustomer(String userName, ArrayList<Customer> c)
    * 2. validateStaff(String userName, String password, ArrayList<Employee> e)
    * 3. checkPriceByID
    * 4. checkPromoByID
    * 5. checkBulkByID
    * 6. getProdByID(String prodID)
    * 7. displayProdUnitPrice (Product product)
    * 8. displayProdSalePrice (Product product)
    * 9. displayProdBulkOffer (Product product)
    * 10. addData()
    */

   public void validateCustomer(String userName, ArrayList<Customer> c) {
      for (int i = 0; i < c.size(); i++) {
         Customer temp = c.get(i);
         if (temp.getCustID().equals(userName)) {
            System.out.println("Logged in! Taking you to your options:");
            submenuCustomer();
         } else {
            System.out.println("\nError: Customer does not exist in the system.");
         }
      }
   }

   public void validateStaff(String userName, String password, ArrayList<Employee> e) {
      for (int i = 0; i < e.size(); i++) {
         Employee temp = e.get(i);
         if (temp.getEmployeeID().equals(userName) && temp.getPassword().equals(password)) {
            System.out.println("Welcome back! Taking you to your options:");
            if(temp instanceof StoreManager) {
               submenuStaffManager(temp);
            }
            else if(temp instanceof SalesStaff) {
               submenuStaffSalesStaff(temp);
            }
            else if(temp instanceof WHManager) {
               submenuStaffWHManager(temp);
            }
            else {
               System.out.println("\nError: Employee does not exist in the system.");
            }
         }
      }
   }

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
         System.out.print("\nReturn(Y/N)? Press Y to exit or any other keys to continue: ");
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
         System.out.print("\nReturn(Y/N)? Press Y to exit or any other keys to continue: ");
         exit = input.next().charAt(0);
      } while (exit != 'Y' && exit != 'y');
   }

   private void checkBulkByID() {
      char exit = ' ';
      do {
         System.out.print("Please input product code: ");
         String prodID = input.next();
         Product product = getProdByID(prodID);

         if (product != null) {
            displayProdBulkOffer(product);
         } else {
            System.out.println("\nError: Your input was invalid. Please try again.");
            continue;
         }
         System.out.print("\nReturn(Y/N)? Press Y to exit or any other keys to continue: ");
         exit = input.next().charAt(0);
      } while (exit != 'Y' && exit != 'y');
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
         if (p.getProdID().compareTo(prodID) == 0) {
            break;
         } else {
            p = null;
         }
      }
      return p;
   }

  /* public Sale deleteSale(String saleID){
      Sale s = null;

      for (int i = 0; i < sales.size(); i++) {
         s = sales.get(i);
        // if (s.getSaleID().equalsto(saleID)) {
            //found, delete.
            sales.remove(i);
            break;
         } else {
            System.out.println("\nError: Your input was invalid. Please try again.");
         }
      }
      return s;
   }*/

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

   public void displayProdBulkOffer(Product product){
      System.out.println("\n*********************************");
      System.out.println("* This week's offer on " + product.getProdID() + "!    *");
      System.out.println("* Buy " + product.getBulk() + " or more " + product.getProductName() + " to get them at $" + product.getBulkPrice() + " today!");
   }


   public void addData() {

      Product apple = new Product("P001","APPLE",5,4, 20, 3.8,500,100,
                                  400,"EA",false,"S001");
      Product orange = new Product("P002","ORANGE",6,5, 20, 4,500,100,
                                   400,"EA",false,"S002");
      Product pizza = new Product("P003","PIZZA",15,12, 20, 11,100,20,
                                  80,"EA",false,"S003");
      Product doll = new Product("P004","SCARY DOLL",20,18, 10, 17,100,30,
                                 70,"EA",false,"S004");
      Product meth= new Product("P005","METH",2000,1900, 10, 1880,100,50,
                                50,"KG",false,"S005");
      Product laptop= new Product("P006","LAPTOP",3000,2900, 5, 2990,50,10,
                                  50,"EA",false,"S006");
      Product boyfriend= new Product("P007","BOYFRIEND",1000,998, 5, 889,50,25,
                                     25,"EA",false,"S007");

      Customer sarahm = new Customer("C001","Sarah","Moore");
      Customer peterl = new Customer("C002","Peter","Luke");
      Customer janed = new Customer("C003","Jane","Doe");
      Customer johnd = new Customer("C004","John","Doe");
      Customer kyliem = new Customer("C005","Kylie","Mac");

      products.add(apple);
      products.add(orange);
      products.add(pizza);
      products.add(doll);
      products.add(meth);
      products.add(laptop);
      products.add(boyfriend);

      customers.add(sarahm);
      customers.add(peterl);
      customers.add(janed);
      customers.add(johnd);
      customers.add(kyliem);

      employees.add(new StoreManager("M001", "12345", "Steve", "Rogers"));
      employees.add(new StoreManager("M002", "12345", "Steve", "Rogers"));
      employees.add(new StoreManager("M003", "12345", "Steve", "Rogers"));
      employees.add(new StoreManager("M004", "12345", "Steve", "Rogers"));
      employees.add(new StoreManager("M005", "12345", "Robert", "Donald"));
      employees.add(new StoreManager("M006", "12345", "Richard", "Who"));

      employees.add(new WHManager("W001", "12345", "Ted", "Mosby"));
      employees.add(new WHManager("W002", "12345", "Barney", "Stinson"));

      sales.add(new Sale(sarahm,"S001"));
      sales.add(new Sale(peterl,"S002"));
      sales.add(new Sale(janed,"S003"));
      sales.add(new Sale(johnd,"S004"));
      sales.add(new Sale(kyliem,"S005"));
   }
}
