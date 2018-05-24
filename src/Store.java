/**
 * Store class as driver.
 * :: serve as an open connection to methods involving in the system.
 *
 * @author Wan Yi Beh <s3368772@student.rmit.edu.au>
 * @version 1.0
 */

import java.util.*;


public class Store {

   // Create an ArrayList of custom objects.
   private ArrayList<Employee> employees = new ArrayList<Employee>();
   private ArrayList<Customer> customers = new ArrayList<Customer>();
   private ArrayList<Sale> sales = new ArrayList<Sale>();
   public static ArrayList<Product> products = new ArrayList<Product>();
   private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

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
    * 6. submenuStaffWHManager
    * 7. submenuStaffSalesStaff
    */

   public void mainMenu() {

      // Add new objects.
      int selection = 0;

      do {

         System.out.println("\n***************************************");
         System.out.println("**** Supermarket Management System ****");
         System.out.println("* -1. Check price by ID               *");
         System.out.println("* -2. Check promotions by ID          *");
         System.out.println("* -3. Customer login                  *");
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
      sc.close();
      String custID = sc.nextLine();
      validateCustomer(custID, customers);
   }

   private void submenuCustomer(Customer cust) {
      /*
       * 2.1 MENU: Customer
       * Menu serves to display Customer's capabilities.
       * checkout with ID and quantity or product name and weight (select the product name from given list).
       * check price of any item by keying in the ID before proceeding with the sale.
       * check discounts applicable.
       */
      int option = 0;
      boolean exit = false;
      Scanner sminput = new Scanner(System.in);
      Scanner stringInput = new Scanner(System.in);
      Scanner intInput = new Scanner(System.in);
      int rn = (int) (Math.random() * 1000);
      Sale sale = new Sale(cust, Integer.toString(rn));

      do {
         System.out.println("\n*******************************************");
         System.out.println("* Store/Menu/Customer                     *");
         System.out.println("* What would you like to do?              *");
         System.out.println("* - 1. Add products to cart by product ID *");
         System.out.println("* - 2. Add products to cart by search     *");
         System.out.println("* - 3. Check items in cart                *");
         System.out.println("* - 4. Checkout by cash                   *");
         System.out.println("* - 5. Checkout by card                   *");
         System.out.println("* - 6. Check price                        *");
         System.out.println("* - 7. Bulk discount offer                *");
         System.out.println("* - 8. Back to main menu                  *");
         System.out.println("*******************************************");
         System.out.print("Insert selection: ");
         try {
            option = sminput.nextInt();
            switch (option) {
               case 1:
                  ArrayList<String> nameList = new ArrayList<>();
                  for (Product p : Store.products) {
                     String r = new String(new char[11 - p.getProductName().length()]).replace("\0", " ");
                     nameList.add(p.getProductName());
                     System.out.println(p.getProdID()
                                                + " " + p.getProductName()
                                                + r + p.getUnitPrice());
                  }

                  System.out.println("Insert product ID:");
                  String prodID = stringInput.nextLine();
                  System.out.println("Insert quantity:");
                  int qty = intInput.nextInt();
                  sale.addItem(new SaleLine(prodID, qty));
                  break;
               case 2:
                  String prodName = sale.selectFromList();
                  System.out.println("Insert quantity:");
                  double qty2 = intInput.nextDouble();
                  sale.addItem(new SaleLine(prodName, qty2));
                  break;
               case 3:
                  sale.inCart();
                  break;
               case 4:
                  System.out.println("Please enter amount of cash: ");
                  double pmt = intInput.nextDouble();
                  //if payment go through, quantity deduct from stock level.
                  if (sale.makePayment(pmt)) {
                     for (SaleLine s : sale.getCart()) {
                        s.checkout();
                     }
                     sales.add(sale);
                     System.out.println("Thank You!!!");
                     System.out.println("Visit Again!!!");
                     mainMenu();
                  }

                  break;
               case 5:
                  double cardPmt = sale.getTotal();
                  LoyalityCard card = cust.getLoyalityCard();
                  System.out.println("Please enter card number");
                  String cardNum = stringInput.nextLine();
                  System.out.println("Please enter security number");
                  String securityCode = intInput.nextLine();
                  if (card.autheriseCharge(cardNum, securityCode)) {
                     if (card.spendCredit(cardPmt))

                        for (SaleLine s : sale.getCart()) s.checkout();
                     sales.add(sale);
                     exit = true;
                  }
                  else System.out.println("Try again");
                  break;
               case 6:
                  checkPriceByID();
                  break;
               case 7:
                  checkBulkByID();
                  break;
               case 8:
                  exit = true;
                  break;
               default:
                  System.out.println("\nError: Your input was invalid. Please try again.");
                  System.out.println("***************************************");
            }
         } catch (InputMismatchException e) {
            System.out.println("Invalid input.");

         }
      }
      while (!exit);
      System.out.println("Returning to main menu...");
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
      StoreManager a = (StoreManager) temp;
      Scanner doubleInput = new Scanner(System.in);
      Scanner stringInput = new Scanner(System.in);

      do {
         System.out.println("* Store/Menu/Manager                 *");
         System.out.println("* -1. Reorder                        *");
         System.out.println("* -2. Override standard price        *");
         System.out.println("* -3. Set Replenish Level            *");
         System.out.println("* -4. Generate sales report          *");
         System.out.println("* -5. Offer special discounts        *");
         System.out.println("* -6. Offer bulk discounts           *");
         System.out.println("* -7. Most profitable product        *");
         System.out.println("* -8. Check supplier details         *");
         System.out.println("* -9. Off Sale                       *");
         System.out.println("* -10. Set replenish level           *");
         System.out.println("* -11. Back to main menu             *");
         System.out.println("**************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            case 1:
               try {
                  System.out.println("Enter the product ID to reorder: ");
                  String id = stringInput.nextLine();
                  target = getProdByID(id);
                  System.out.println("The current stock of the product " + target.getProductName() + " is " +
                                             target.getQuantity() + ", unit is " + target.getUnit());
                  System.out.println("Enter quantity of product to reorder: ");
                  double qty = doubleInput.nextDouble();
                  a.reorder(target, qty);
                  break;
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
            case 2:
               try {
                  System.out.println("Please input the product(ID) to change price: ");
                  String input2 = stringInput.nextLine();
                  target = getProdByID(input2);
                  System.out.println("The current price of the product " + target.getProductName() + " is "
                                             + target.getUnitPrice() + ", unit of " + target.getUnit());
                  System.out.print("Please enter your new price: ");
                  Double price2ToChange = doubleInput.nextDouble();
                  a.alterPrice(target, price2ToChange);
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
            case 3:
<<<<<<< HEAD

               try 
               {
=======
               try {
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
                  System.out.print("Please input the product(ID) to maintain stock level: ");
                  String input3 = stringInput.nextLine();
                  target = getProdByID(input3);
                  System.out.println("The current replenish line of product " + target.getProductName() + " is "
                                             +target.getReplenishLine());
                  System.out.println("Please enter the intended maintain level of the product: ");
                  Double levelToChange = doubleInput.nextDouble();
                  a.setStockLevel(target,levelToChange);
<<<<<<< HEAD
               } 
               catch (Exception e) 
               {
                  System.out.println("invalid input, please try again");
               }
               break;

                

=======
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
            case 4:
               generateSaleReport();
               break;
            case 5:
<<<<<<< HEAD

            	try 
                {

	               System.out.print("Please input the product(ID) to offer discounts: ");
	               Scanner scanner5 = new Scanner(System.in);
	               String input5 = scanner5.nextLine();
	               target = getProdByID(input5);
	               if(target.isOnSale() == true)
	               {
	                  System.out.println("The product is currently on Sale, please cancel Sale first");
	                  break;
	               }
	               else 
	               {
		                  System.out.println("The current unit price for the product " + target.getProductName() + " is "
		                  + target.getUnitPrice());
		                  System.out.print("Please enter the discount percentile: ");
		                  Scanner offer = new Scanner(System.in);
		                  Double offerToChange = offer.nextDouble();
		                  a.promote(target, offerToChange);
		                  System.out.println("You have offered the discount of "+offerToChange + "%" + " to the product. The " +
		                          "current sale price is " + target.getSalesPrice());
		                  submenuStaffManager(temp);
		                  scanner5.close();
		                  offer.close();
		                  break;
	               }
                }
                 catch (Exception e) 
                  {
                     System.out.println("invalid input, please try again");

                  }
               	 
               
               
               

                try {
                    System.out.print("Please input the product(ID) to offer discounts: ");
                    String input5 = stringInput.nextLine();
                    target = getProdByID(input5);
                    if(target.isOnSale() == true){
                       System.out.println("The product is currently on Sale, please cancel Sale first");
                    }else {
                       System.out.println("The current unit price for the product " + target.getProductName() + " is "
                       + target.getUnitPrice());
                       System.out.print("Please enter the discount percentile: ");
                       Double offerToChange = doubleInput.nextDouble();
                       a.promote(target, offerToChange);
                       System.out.println("You have offered the discount of "+offerToChange + "%" + " to the product. The " +
                               "current sale price is " + target.getSalesPrice());
                        }
                    System.out.println();
                } catch (Exception e) {
                    System.out.println("invalid input, please try again");
                }
                break;

=======
               try {
                  System.out.print("Please input the product(ID) to offer discounts: ");
                  String input5 = stringInput.nextLine();
                  target = getProdByID(input5);
                  if(target.isOnSale() == true){
                     System.out.println("The product is currently on Sale, please cancel Sale first");
                  }else {
                     System.out.println("The current unit price for the product " + target.getProductName() + " is "
                                                + target.getUnitPrice());
                     System.out.print("Please enter the discount percentile: ");
                     Double offerToChange = doubleInput.nextDouble();
                     a.promote(target, offerToChange);
                  }
                  System.out.println();
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
            case 6:
               try {
                  System.out.print("Please input the product(ID) to offer bulk discounts: ");
                  String input6 = stringInput.nextLine();
                  target = getProdByID(input6);
                  System.out.println("The current unit price for the product " + target.getProductName() + " is "
                                             + target.getUnitPrice());
                  System.out.println("The current bulk quantity for bulk purchase is "+ target.getBulk());
                  System.out.print("Please input the quantity for bulk purchase: ");
                  Double bulkQuantity = doubleInput.nextDouble();
                  System.out.print("Please enter the percentile discount for bulk purchase: ");
                  Double bulkPrice= doubleInput.nextDouble();
                  a.bulkDiscount(target,bulkQuantity,bulkPrice);
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
            case 7:
               mostProfitableItem();
               break;
            case 8:
               for (Product p1 : products) {
                  System.out.println(p1.getProdID() + " " + p1.getProductName());
               }
               System.out.println("Please enter the ID of the product you want to get supplier information");
               Scanner scanner8 = new Scanner(System.in);
               String input8 = scanner8.nextLine();
               for (Product p : products) {
                  System.out.println(p.getProdID() + " " + p.getProductName());
               }
               target = getProdByID(input8);
               String supplierName = " ";
               System.out.println("The supplier of the product " + target.getProductName() + " is " + target.getSupplier().getFirstName());
               submenuStaffManager(temp);
               scanner8.close();
               break;
            case 9:
               try {
                  System.out.println("Please enter the ID of the product you want to put off sale");
                  String input9 = stringInput.nextLine();
                  target = getProdByID(input9);
                  a.demote(target);
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
            case 10:
               try {
                  System.out.println("Please enter the ID of the product you want to set automatic Replenish Quantity");
                  String string10 = stringInput.nextLine();
                  target = getProdByID(string10);
                  System.out.println("Please enter the automatic Replenish Quantity");
                  double double10 = doubleInput.nextDouble();
                  a.setReplenishQuantity(target,double10);
               } catch (Exception e) {
                  System.out.println("invalid input, please try again");
               }
               break;
            case 11:
               mainMenu();
               break;
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }
      } while (selection !=11);
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
      WHManager a = (WHManager)temp;
      Scanner doubleInput = new Scanner(System.in);
      Scanner stringInput = new Scanner(System.in);

      do {
         System.out.println("* Store/Menu/Warehouse Manager         *");
         System.out.println("* Login as:                            *");
         System.out.println("* - 1. Replenish stock levels          *");
         System.out.println("* - 2. Check Stock levels              *");
         System.out.println("* - 3. Go Back to Main Menu            *");
         System.out.println("***************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();

         switch (selection) {
            case 1:
               System.out.print("Enter the product ID to adjust: ");
               String input = stringInput.nextLine();
               target = getProdByID(input);
               System.out.println("The current stock level of the product: "
                                          + target.getProductName() + " is " + target.getQuantity());
               a.replenish(target);
               break;
            case 2:
               System.out.print("Enter the product ID to check: ");
               String checkString = stringInput.nextLine();
               target = getProdByID(checkString);
               a.checkStock(target);
               break;
            case 3:
               mainMenu();
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
      System.out.println("\n\n****************************************");

      int selection = 0;

      do {
         System.out.println("* Store/Menu/Sales Staff                   *");
         System.out.println("* Login as:                                *");
         System.out.println("* - 1. Delete cart                         *");
         System.out.println("* - 2. Delete item in cart                 *");
         System.out.println("* - 3. Register a new loyalty member       *");
         System.out.println("* - 4. Top up loyalty card                 *");
         System.out.println("* - 5. Back to main menu                   *");
         System.out.println("********************************************");
         System.out.print("Insert selection: ");

         selection = input.nextInt();
         Scanner stringInput = new Scanner(System.in);
         Scanner intInput = new Scanner(System.in);

         try {

<<<<<<< HEAD

         switch (selection) {
            case 1:            	   
            	    System.out.println("Please Enter the SalesID:  ");    
            	    String salesID = stringInput.nextLine();
            	    boolean saleFound = false;
            	    
            	    for (int i = 0; i < sales.size(); i++) {
            			if (sales.get(i).getSaleID().equals(salesID)) {
            				sales.remove(sales.get(i));
            				saleFound = true;	
            			}
            		}                       	    
            	    
            	    if (saleFound) {
            	    	System.out.println("Sale " + salesID + " Succesfully Removed");
            	    	submenuStaffSalesStaff(temp);
            	    } else {
            	    	System.out.println("Sale " + salesID + " Does not Exist");
            	    	submenuStaffSalesStaff(temp);
            	    }
            	   	    
            case 2: 
            		String itemID;
	        	    System.out.println("Please Enter the SalesID:  ");    
	        	    String salesid = stringInput.nextLine();
	        	    boolean salefound = false;
	        	    Sale sale = null;
	        	    
	        	    for (int i = 0; i < sales.size(); i++) {
	        			if (sales.get(i).getSaleID().equals(salesid)) {
	        				salefound = true;
	        				sale = sales.get(i);
	        			}
	        		}
	        	    
	        	    if (salefound) {	        	  
		        	    	System.out.println("Sales ID : " + sale.getSaleID());
		        	    	sale.inCart();
		        	    	System.out.println("Enter the Item ID you want to Remove  :");
		        	    	itemID = stringInput.nextLine();
		        	    
		        	    	
			        	Boolean removed = temp.removeCartItem(sale,itemID);
			        	if ( removed ) { 

			        	    		System.out.println("ItemID : " + itemID + " was Sucessfully removed from SaleID :" 
			        	+ sale.getSaleID());

			        	    		System.out.println("ItemID : " + itemID + " was Sucessfully removed from SaleID :" + sale.getSaleID());

			        	}else {
			        	    		System.out.println("Item Doesnt Exist on the Product List:");
			        	}
			        	    		
			        stringInput.nextLine();
			        	submenuStaffSalesStaff(temp);
		        	    
	        	  	
	        	    } else {
	        	    	System.out.println("Sale " + salesid + " Does not Exist");
	        	    	stringInput.nextLine();
	        	    	submenuStaffSalesStaff(temp);
	        	    }
            	
            case 3: 
	            	String custID, firstName, lastName;
	            	Date expDate;
	            	String securityCode = null; // Gave an error when not initialized
	            	String cardNum;
	            	System.out.println("Please Enter The CustomerID:  ");    
	            	custID = stringInput.nextLine();
	            	System.out.println("Please Enter Customer's First Name:  ");    
	            	firstName = stringInput.nextLine();
	            	System.out.println("Please Enter Customer's Last Name:  ");    
	            	lastName = stringInput.nextLine();	           
	            	System.out.println("Please Enter The Loyality Card Number:  ");    
	            	cardNum = intInput.nextLine();
	            	System.out.println("Please Enter The Security Code:  ");    
	            	cardNum = intInput.nextLine();	            	
	            	
	            	Calendar cal = Calendar.getInstance(); 	
	            	cal.add(Calendar.YEAR, 2); // to get next year adding +2
	            	expDate = cal.getTime();
	            	
	            	Customer customer = new Customer(custID,firstName,lastName);
	            	customers.add(customer);       

	            Boolean sold = SalesStaff.sellcard(customers.get(customers.indexOf(customer)), 
	            		(SalesStaff)temp , cardNum, securityCode, expDate);          

	                   

	            
	            if ( sold) {
	            	System.out.println("Customer and Loyality Card Sucessfully Added !!!!!");
	            	stringInput.nextLine();
	            submenuStaffSalesStaff(temp);
	            } else { 
	            	System.out.println(" Ooops something Went Wrong");
	            	stringInput.nextLine();
	            	submenuStaffSalesStaff(temp);
	            }
           
            case 4: 
	            	String customerID;
	            	double amount;
	            	LoyalityCard loyalitycard = null;	            
	            	System.out.println("Please Enter The CustomerID:  ");    
	            	customerID = stringInput.nextLine();
	            	System.out.println("Please Enter The Top-Up Amount : ");
	            	amount = stringInput.nextDouble();
	            	boolean found = false;
	            	
	            for (int i = 0; i < customers.size(); i++) {
	                    Customer cust = customers.get(i);
	                    if (cust.getCustID().equals(customerID)) {
	                    	loyalitycard = customers.get(i).getLoyalityCard(); 
	                    	temp.topupCredit(loyalitycard,amount);
	                    	System.out.println( amount + "AUD was credited to CustomerID: " + customerID);
	                    	found = true;
	                    	break;
	                    }
	                 }
	            if ( found == false ) {System.out.println( "Customer ID Not Found");}
	            intInput.nextLine();
        			submenuStaffSalesStaff(temp);	            
	            
	            
	      

            case 5: mainMenu();
            default:
               System.out.println("\nError: Your input was invalid. Please try again.");
               System.out.println("***************************************");
         }


=======
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
            switch (selection) {
               case 1:
                  System.out.println("Please Enter the SalesID:  ");
                  String salesID = stringInput.nextLine();
                  boolean saleFound = false;

                  for (int i = 0; i < sales.size(); i++) {
                     if (sales.get(i).getSaleID().equals(salesID)) {
                        sales.remove(sales.get(i));
                        saleFound = true;
                     }
                  }
                  if (saleFound) {
                     System.out.println("Sale " + salesID + " Succesfully Removed");
                     submenuStaffSalesStaff(temp);
                  }
                  else {
                     System.out.println("Sale " + salesID + " Does not Exist");
                     submenuStaffSalesStaff(temp);
                  }

               case 2:
                  String itemID;
                  System.out.println("Please Enter the SalesID:  ");
                  String salesid = stringInput.nextLine();
                  boolean salefound = false;
                  Sale sale = null;

                  for (int i = 0; i < sales.size(); i++) {
                     if (sales.get(i).getSaleID().equals(salesid)) {
                        salefound = true;
                        sale = sales.get(i);
                     }
                  }

                  if (salefound) {
                     System.out.println("Sales ID : " + sale.getSaleID());
                     sale.inCart();
                     System.out.println("Enter the Item ID you want to Remove  :");
                     itemID = stringInput.nextLine();
                     Boolean removed = temp.removeCartItem(sale, itemID);
                     if (removed) {
                        System.out.println("ItemID : " + itemID + " was Sucessfully removed from SaleID :" + sale.getSaleID());
                     }
                     else {
                        System.out.println("Item Doesnt Exist on the Product List:");
                     }
                     stringInput.nextLine();
                     submenuStaffSalesStaff(temp);
                  }
                  else {
                     System.out.println("Sale " + salesid + " Does not Exist");
                     stringInput.nextLine();
                     submenuStaffSalesStaff(temp);
                  }

               case 3:
                  String custID, firstName, lastName;
                  Date expDate;
                  String securityCode = null; // Gave an error when not initialized
                  String cardNum;
                  System.out.println("Please Enter The CustomerID:  ");
                  custID = stringInput.nextLine();
                  System.out.println("Please Enter Customer's First Name:  ");
                  firstName = stringInput.nextLine();
                  System.out.println("Please Enter Customer's Last Name:  ");
                  lastName = stringInput.nextLine();
                  System.out.println("Please Enter The Loyality Card Number:  ");
                  cardNum = intInput.nextLine();
                  System.out.println("Please Enter The Security Code:  ");
                  cardNum = intInput.nextLine();

                  Calendar cal = Calendar.getInstance();
                  cal.add(Calendar.YEAR, 2); // to get next year adding +2
                  expDate = cal.getTime();

                  Customer customer = new Customer(custID, firstName, lastName);
                  customers.add(customer);
                  Boolean sold = SalesStaff.sellcard(customers.get(customers.indexOf(customer)), (SalesStaff) temp, cardNum, securityCode, expDate);

                  if (sold) {
                     System.out.println("Customer and Loyality Card Sucessfully Added !!!!!");
                     stringInput.nextLine();
                     submenuStaffSalesStaff(temp);
                  }
                  else {
                     System.out.println(" Ooops something Went Wrong");
                     stringInput.nextLine();
                     submenuStaffSalesStaff(temp);
                  }

               case 4:
                  String customerID;
                  double amount;
                  LoyalityCard loyalitycard = null;
                  System.out.println("Please Enter The CustomerID:  ");
                  customerID = stringInput.nextLine();
                  System.out.println("Please Enter The Top-Up Amount : ");
                  amount = stringInput.nextDouble();
                  boolean found = false;

                  for (int i = 0; i < customers.size(); i++) {
                     Customer cust = customers.get(i);
                     if (cust.getCustID().equals(customerID)) {
                        loyalitycard = customers.get(i).getLoyalityCard();
                        temp.topupCredit(loyalitycard, amount);
                        System.out.println(amount + "AUD was credited to CustomerID: " + customerID);
                        found = true;
                        break;
                     }
                  }
                  if (found == false) {
                     System.out.println("Customer ID Not Found");
                  }
                  intInput.nextLine();
                  submenuStaffSalesStaff(temp);
               case 5:
                  mainMenu();
               default:
                  System.out.println("\nError: Your input was invalid. Please try again.");
                  System.out.println("***************************************");
            }
<<<<<<< HEAD


=======
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
         } catch (InputMismatchException e) {
            System.out.println("Please Enter a Valid Input");
            submenuStaffSalesStaff(temp);
         }
      } while (selection <= 6 && selection > 0);
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
      for (Customer c1 : c) {
         if (c1.getCustID().equals(userName)) {
            System.out.println("Logged in! Taking you to your options:");
            submenuCustomer(c1);
         }

      }
      System.out.println("\nError: Customer does not exist in the system.");
      mainMenu();
   }

   public void validateStaff(String userName, String password, ArrayList<Employee> e) {
      for (int i = 0; i < e.size(); i++) {
         Employee temp = e.get(i);
         if (temp.getEmployeeID().equals(userName) && temp.getPassword().equals(password)) 
         {
            System.out.println("Welcome back! Taking you to your options:");
            if (temp instanceof StoreManager) {
               submenuStaffManager(temp);
            }
            else if (temp instanceof SalesStaff) {
               submenuStaffSalesStaff(temp);
            }
            else if (temp instanceof WHManager) {
               submenuStaffWHManager(temp);
            }
            
         }
         
      }
      System.out.println("Wrong Username or password ");
   }

   /**
    * Check products in various methods.
    * -----------------------------------
    * :: checkPriceByID, checkPromoByID, checkBulkByID
    */

   private void checkPriceByID() {
      char exit = ' ';
      do {
<<<<<<< HEAD

         for (Product p : products) {
            System.out.println(p.getProdID() + " " + p.getProductName());
         }

=======
         for (Product p : products) {
            System.out.println(p.getProdID() + " " + p.getProductName() + " " + p.getQuantity());
         }
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514
         System.out.print("Please input product code: ");
         String prodID = input.next();
         Product product = getProdByID(prodID);

         if (product != null) {
            displayProdUnitPrice(product);
         }
         else {
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
         for (Product p : products) {
            System.out.println(p.getProdID() + " " + p.getProductName());
         }
         System.out.print("Please input product code: ");
         String prodID = input.next();
         Product product = getProdByID(prodID);

         if (product != null) {
            displayProdSalePrice(product);
         }
         else {
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
         }
         else {
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
    * :: SearchProdByID, getProdByName
    */

   public Product getProdByID(String prodID) {
      Product p = null;

      for (int i = 0; i < products.size(); i++) {
         p = products.get(i);
         if (p.getProdID().compareTo(prodID) == 0) {
            break;
         }
         else {
            p = null;
         }
      }
      return p;
   }

   public Product getProdByName(String prodName) {
      Product p = null;
      try {
         for (int i = 0; i < products.size(); i++) {
            p = products.get(i);
            if (p.getProductName().toUpperCase()
                    .equals(prodName.toUpperCase())) {
               return p;
            }
         }
         throw new Exception("There is no such item.");
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return p;
   }

   /**
    * Assisting the functionality of Sale and Saleline classes.
    * -----------------------------------
    * :: generateSaleReport, mostProfitableItem
    */
   public void generateSaleReport() {
      HashMap<String, Double> hmap = new HashMap<String, Double>();
      //output summary parameters of sales.
      //initial parameters
      double SaleTotal = 0;
      int SaleNum = 0;
      // double cartTotal = 0;
      for (Sale i : sales) {
         SaleTotal += i.getTotal();
         SaleNum++;
         for (SaleLine s : i.getCart()) {
            if (hmap.get(s.getProdName()) != null) {
               hmap.put(s.getProdName(), (hmap.get(s.getProdName()) + s.getSubtotal()));
            }
            else {
               hmap.put(s.getProdName(), s.getSubtotal());
            }
         }
      }
      // print total sales
      System.out.println("\n*********************************");
      System.out.println("* The total number of sales is: " + SaleNum);
      System.out.println("* The total sale figure is: " + SaleTotal + " dollars");
      System.out.println("\n*********************************");
      for (Map.Entry<String, Double> m : hmap.entrySet()) {
         System.out.println("* " + m.getKey() + "     " + m.getValue() + "     dollars.");
      }
   }

   public void mostProfitableItem() {
      HashMap<String, Double> hmap = new HashMap<String, Double>();
      //double cartTotal = 0;
      for (Sale i : sales) {
         for (SaleLine s : i.getCart()) {
            if (hmap.get(s.getProdName()) != null) {
               hmap.put(s.getProdName(), (hmap.get(s.getProdName()) + s.getSubtotal()));
            }
            else {
               hmap.put(s.getProdName(), s.getSubtotal());
            }
         }
      }
      String prod = "";
      double max = 0;
      for (Map.Entry<String, Double> m : hmap.entrySet()) {
         //System.out.println(m.getKey()+" "+m.getValue());
         if (m.getValue() > max) {
            max = m.getValue();
            prod = m.getKey();
         }
      }
      System.out.println("\n*********************************");
      System.out.println("* The most profitable item is: " + prod);
      System.out.println("* It has sold for " + max + " dollars.");

   }

   /**
    * Display all details on one product.
    * -----------------------------------
    * :: displayProdUnitPrice, displayProdSalePrice, displayProdBulkOffer
    */

   public void displayProdUnitPrice(Product product) {
      System.out.println("\n*********************************");
      System.out.println("* Information on product: " + product.getProdID() + "  *");
      System.out.println("* Product: " + product.getProductName());
      System.out.println("* Unit Price: $" + product.getUnitPrice());
   }

   public void displayProdSalePrice(Product product) {
      System.out.println("\n*********************************");
      System.out.println("* This week's offer on " + product.getProdID() + "!    *");
      System.out.println("* Product: " + product.getProductName());
      System.out.println("* Sale Price: $" + product.getSalesPrice());
   }

   public void displayProdBulkOffer(Product product) {
      System.out.println("\n*********************************");
      System.out.println("* This week's offer on " + product.getProdID() + "!    *");
      System.out.println("* Buy " + product.getBulk() + " or more " + product.getProductName() 
      + " to get them at $" + product.getBulkPrice() + " today!");
   }

   /**
    * Adding data to system
    */

   public void addData() {

<<<<<<< HEAD

	   
	   	Supplier supplier1 = new Supplier("S001", "Ken", "Williams", "121/8 some street");
	    Supplier supplier2 = new  Supplier("S002", "Charlote", "Ava", "212/9 this Street");
	    Supplier supplier3 = new Supplier("S003", "Nosh", "Noa", "8 This and that Street");
	     
	    suppliers.add(supplier1);
	    suppliers.add(supplier2);
	    suppliers.add(supplier3);

	   
      Product apple = new Product("P001","APPLE",5,4, 20, 3.8,60,40,
                                  400,"EA",false,supplier1);
      Product orange = new Product("P002","ORANGE",6,5, 20, 4,500,100,
                                   400,"EA",false,supplier2);
      Product pizza = new Product("P003","PIZZA",15,12, 20, 11,100,20,
                                  80,"EA",false,supplier2);
      Product doll = new Product("P004","SCARY DOLL",20,18, 10, 17,100,30,
                                 70,"EA",false,supplier3);
      Product meth= new Product("P005","METH",2000,1900, 10, 1880,100,50,
                                50,"KG",false,supplier1);
      Product laptop= new Product("P006","LAPTOP",3000,2900, 5, 2990,50,10,
                                  50,"EA",false,supplier2);
      Product boyfriend= new Product("P007","BOYFRIEND",1000,998, 5, 889,50,25,
                                     25,"EA",false,supplier1);                             



      Customer sarahm = new Customer("C001","Sarah","Moore");
      Customer peterl = new Customer("C002","Peter","Luke");
      Customer janed = new Customer("C003","Jane","Doe");
      Customer johnd = new Customer("C004","John","Doe");
      Customer kyliem = new Customer("C005","Kylie","Mac");
=======
      Supplier supplier1 = new Supplier("S001", "Ken", "Williams", "121/8 some street");
      Supplier supplier2 = new Supplier("S002", "Charlote", "Ava", "212/9 this Street");
      Supplier supplier3 = new Supplier("S003", "Nosh", "Noa", "8 This and that Street");

      suppliers.add(supplier1);
      suppliers.add(supplier2);
      suppliers.add(supplier3);

      Product apple = new Product("P001", "APPLE", 5, 4, 20, 3.8, 60, 40,
                                  400, "EA", false, supplier1);
      Product orange = new Product("P002", "ORANGE", 6, 5, 20, 4, 500, 100,
                                   400, "EA", false, supplier2);
      Product pizza = new Product("P003", "PIZZA", 15, 12, 20, 11, 100, 20,
                                  80, "EA", false, supplier2);
      Product doll = new Product("P004", "SCARY DOLL", 20, 18, 10, 17, 100, 30,
                                 70, "EA", false, supplier3);
      Product meth = new Product("P005", "METH", 2000, 1900, 10, 1880, 100, 50,
                                 50, "KG", false, supplier1);
      Product laptop = new Product("P006", "LAPTOP", 3000, 2900, 5, 2990, 50, 10,
                                   50, "EA", false, supplier2);
      Product boyfriend = new Product("P007", "BOYFRIEND", 1000, 998, 5, 889, 50, 25,
                                      25, "EA", false, supplier1);

      Customer sarahm = new Customer("C001", "Sarah", "Moore");
      Customer peterl = new Customer("C002", "Peter", "Luke");
      Customer janed = new Customer("C003", "Jane", "Doe");
      Customer johnd = new Customer("C004", "John", "Doe");
      Customer kyliem = new Customer("C005", "Kylie", "Mac");
>>>>>>> b1812bc07264b701567cfd085cf81e31f00bf514

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

      employees.add(new StoreManager("M001", "12345", "Nicolas", "Cage"));
      employees.add(new StoreManager("M002", "12345", "This", "Rogers"));
      employees.add(new StoreManager("M003", "12345", "George", "Rogers"));
      employees.add(new StoreManager("M004", "12345", "Steve", "Rogers"));
      employees.add(new StoreManager("M005", "12345", "Robert", "Donald"));
      employees.add(new StoreManager("M006", "12345", "Richard", "Who"));
      employees.add(new StoreManager("M006", "12345", "Richard", "Who"));
      employees.add(new WHManager("W001", "12345", "Ted", "Mosby"));
      employees.add(new WHManager("W002", "12345", "Barney", "Stinson"));

      SalesStaff s1 = new SalesStaff("SS001", "12345", "Larry", "Swany");
      SalesStaff s2 = new SalesStaff("SS002", "12345", "Demian", "Ross");
      SalesStaff s3 = new SalesStaff("SS003", "12345", "Donald", "Trump");

      employees.add(s1);
      employees.add(s2);
      employees.add(s3);

      sales.add(new Sale(sarahm, "S001"));
      sales.add(new Sale(peterl, "S002"));
      sales.add(new Sale(janed, "S003"));
      sales.add(new Sale(johnd, "S004"));
      sales.add(new Sale(kyliem, "S005"));

      sales.get(0).addDemoItem(new SaleLine(products.get(0).getProdID(), 2));
      sales.get(0).addDemoItem(new SaleLine(products.get(1).getProdID(), 3));

      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.YEAR, 2); // to get next year adding +2
      Date expDate = cal.getTime();

      SalesStaff.sellcard(customers.get(0), s1, "123456765", "123", expDate);
      SalesStaff.sellcard(customers.get(1), s2, "123456762", "123", expDate);
      SalesStaff.sellcard(customers.get(2), s3, "123456362", "123", expDate);

      customers.get(0).getLoyalityCard().addCredit(500);
      customers.get(1).getLoyalityCard().addCredit(300);
      customers.get(2).getLoyalityCard().addCredit(100);
   }
}
