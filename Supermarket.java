

public class Supermarket {

   public static void main(String[] args) {

      Store store = new Store();
      store = store.mainMenu(store);

      System.out.println("\n\n*********************************");
      System.out.println("* Supermarket Management System *");
      System.out.println("* Shutting down.................*");
      System.out.println("*********************************");

   }
//   public static void main(String[] args) {
//
//      Store a = new Store();
//      a.runStore();
//
//      /**
//       * Start run application - Store.
//       */
//
//
//      public void runStore() {
//
//         do {
//            displayMainMenu();
//            select = input.nextInt();
//            if (!((Integer) select instanceof Integer) || (select < 1) || (select > 2)) {
//               System.out.println(" ! Error: invalid input, no such option.");
//               continue;
//            }
//
//            switch (select) {
//               case 1:
//                  displayCustomerMenu();
//                  break;
//
//               case 2:
//                  break;
//
//               default:
//                  break;
//            }
//
//         } while (select != 2);
//      }
//
//      private void displayMainMenu() {
//         System.out.println("\n\n*********************************");
//         System.out.println("* Supermarket Management System *");
//         System.out.println("* Login as:                     *");
//         System.out.println("* - 1. Customer Checkout        *");
//         System.out.println("* - 2. System Management        *");
//         System.out.println("* - 3. Quit                     *");
//         System.out.println("*********************************");
//         System.out.print("Enter an option: ");
//      }
//
//      private void displayCustomerMenu() {
//         /*
//          * checkout with ID and quantity or product name and weight (select the product name from given list).
//          * check price of any item by keying in the ID before proceeding with the sale.
//          * check discounts applicable.
//          */
//
//         System.out.println("\n\n*********************************");
//         System.out.println("* Supermarket Management System *");
//         System.out.println("* Customer Checkout             *");
//         System.out.println("* - 1. Checkout                 *");
//         System.out.println("* - 2. Check price              *");
//         System.out.println("* - 3. Bulk discount offer      *");
//         System.out.println("* - 4. Back to main menu        *");
//         System.out.println("*********************************");
//         System.out.print("Enter an option: ");
//      }
//   }
}
