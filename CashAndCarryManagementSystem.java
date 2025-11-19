public class CashAndCarryManagementSystem{
	private static void mainMenu() {
        while (true) {
            
           
            
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