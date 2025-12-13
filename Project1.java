import java.io.*;
import java.util.Scanner;

public class Project1 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== Cash & Carry Management System =====\n");

        while (true) {
            System.out.println("1. Admin Login");
            System.out.println("2. Cashier Login");
            System.out.println("0. Exit Program");
            System.out.print("Enter choice: ");

            int loginChoice = input.nextInt();

            switch (loginChoice) {

                case 1:
                    adminMenu();
                    break;

                case 2:
                    cashierMenu();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please enter 0, 1, or 2.\n");
            }
        }
    }

    // ==================== ADMIN MENU ====================
    public static void adminMenu() {

        while (true) {

            System.out.println("\n------ Admin Main Menu ------");
            System.out.println("1. Products Menu");
            System.out.println("2. Cashier Records");
            System.out.println("3. Reports");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    productsMenu();
                    break;
                case 2:
                    System.out.println("Cashier Record Menu Selected");
                    break;
                case 3:
                    System.out.println("Reports Selected");
                    break;
                case 0:
                    System.out.println("Logging out from Admin...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ==================== CASHIER MENU ====================
    public static void cashierMenu() {

        while (true) {
            System.out.println("\n------ Cashier Main Menu ------");
            System.out.println("1. New Sale");
            System.out.println("2. Check Price");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("New Sale Started");
                    break;
                case 2:
                    System.out.println("Price Checking");
                    break;
                case 0:
                    System.out.println("Logging out from Cashier...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ==================== PRODUCTS MENU ====================
    public static void productsMenu() {
        while (true) {
            System.out.println("\n------ Products Menu ------");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    System.out.println("searchProduct()");
                    break;
                case 4:
                    System.out.println("updateProduct");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ==================== ADD PRODUCT ====================
    public static void addProduct() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("products.txt", true));

            System.out.println("Enter product ID: ");
            int id = input.nextInt();

            input.nextLine();

            System.out.println("Enter product name: ");
            String name = input.nextLine();

            System.out.println("Enter product price: ");
            double price = input.nextDouble();

            System.out.println("Enter stock Quantity: ");
            int stock = input.nextInt();

            writer.println(id + "," + name + "," + price + "," + stock);
            writer.flush();

            System.out.println("Product added successfully!\n");
        } catch (IOException ex) {
            System.out.println("Error while writing to file: " + ex.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    // ==================== VIEW PRODUCTS ====================
    public static void viewProducts() {
        try {
            File file = new File("products.txt");
            Scanner fileScanner = new Scanner(file);

            System.out.println("\n===== Product List =====");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                System.out.println("ID: " + parts[0] +
                        " | Name: " + parts[1] +
                        " | Price: " + parts[2] +
                        " | Stock: " + parts[3]);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
