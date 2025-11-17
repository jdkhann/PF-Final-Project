public class CashAndCarryManagementSystem{
	private static void mainMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(80));
            System.out.println("                   CASH & CARRY MANAGEMENT SYSTEM");
            System.out.println("                           MAIN MENU");
            System.out.println("=".repeat(80));
            System.out.println("1. Inventory Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Point of Sale (POS)");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            System.out.println("=".repeat(80));
            System.out.print("Select an option: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    inventoryMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    posMenu();
                    break;
                case 4:
                    reportsMenu();
                    break;
                case 5:
                    System.out.println("\nThank you for using Cash & Carry Management System!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}