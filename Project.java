import java.util.*;
import java.io.*;

public class Project {

    static final Scanner input = new Scanner (System.in); 

    public static void main(String[] args) {        //MAIN METHOD STARTS HERE
        
        System.out.println("\n ___________________________________ ");
        System.out.println("|                                   |");
        System.out.println("|          Cash and Carry           |");
        System.out.println("|         Management System         |");
        System.out.println("|___________________________________|\n");
        System.out.println("\nWelcome to the Cash and carry management system, to proceed login into your account\n");

        System.out.println("1. Admin Login");
        System.out.println("2. Cashier Login");
        System.out.println("0. Exit Program");
        System.out.println("\nEnter your option (0,1,2): ");

        String loginStatus = "invalid";

        switch (getMenuInput(0,2)) {  // getMenuInput function to validate menu input

            case 1:  //opens admin login
                
                System.out.println("\nAdmin login Selected\n");
                loginStatus = login("admin"); // calls login function with admin parameter
                break;

            case 2: //opens cashier login
                
                System.out.println("\nCashier login Selected\n");
                loginStatus = login("cashier"); // calls login function with cashier parameter
                break;

            case 0: // exits program
                System.out.println("Good bye! \nYou have exited the program.");
                System.exit(0);

            default:
                System.out.println("Invalid choice! Please enter 0, 1, or 2.\n");
        }

        //at this point login is successful either for admin or cashier

        if (loginStatus.equals("admin")){
            adminMenu(); // calls admin menu function
        }
        else if (loginStatus.equals("cashier")){
            cashierMenu(); // calls cashier menu function
        }
        else{              // login failed
            System.out.println("Exiting program.");
            System.exit(0);
        }





    } // END OF MAIN METHOD


    
    
    // function to validate menu input --------------------------------------------------------
    public static int getMenuInput(int min, int max) {  
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(input.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print("Invalid choice! Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException | InputMismatchException  e) {
                System.out.print("Invalid input! Please enter a valid number: ");
            }
        }
    }

    
    
    // function to handle login for admin and cashier--------------------------------------------
    public static String login(String userType) { 
        
        for (int i = 1; i <= 5; i++){
        System.out.print("Enter username (default is \"user\"): ");
        String username = input.nextLine();
        System.out.print("Enter password (default is \"password\"): ");
        String password = input.nextLine();


        if (userType.equals("admin") && username.equals("user") && password.equals("password")) {
            
            System.out.println("\nAdmin login successful!");
            System.out.println("Welcome " + username + "!");
            return ("admin"); // admin login successful

        } else if (userType.equals("cashier") && username.equals("user") && password.equals("password")) {
            
            System.out.println("\nCashier login successful!");
            System.out.println("Welcome " + username + "!");
            return ("cashier"); // cashier login successful

        } else {
            
            System.out.println("Invalid credentials! Please try again.");
            System.out.println((5-i) + " attempt(s) remaining.\n");
        }
        }
        System.out.println("Too many failed attempts. Exiting program.");
        return ("invalid"); // login failed
    }


    
    
    // ==================== ADMIN MAIN MENU ====================
    public static void adminMenu() {

        while (true) {

            System.out.println("\n------ Admin Main Menu ------");
            System.out.println("\n1. Products Menu");
            System.out.println("2. Cashier Records");
            System.out.println("3. Customer Records");
            System.out.println("4. Sales Reports");
            System.out.println("0. Logout");
            System.out.print("\nEnter your choice (0-4): ");

            int choice = getMenuInput(0,4);
            switch (choice) {
                case 1:
                    productsMenu();
                     System.out.println("\nProducts Menu Selected");
                    break;
                case 2:
                    adminsCashierMenu();
                    System.out.println("\nCashier Record Menu Selected");
                    break;
                case 3:
                    customerMenu();
                    System.out.println("\nCustomer Records Selected");
                    break;
                case 4:
                    salesReports();
                    System.out.println("\nSales Reports Selected");
                    break;
                case 0:
                    System.out.println("\nLogging out from Admin...");
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

    
    
    // ==================== CASHIER  MAIN MENU ====================
    public static void cashierMenu() {

        while (true) {
            System.out.println("\n------ Cashier Main Menu ------");
            System.out.println("1. Generate New Bill");
            System.out.println("0. Logout");
            System.out.print("Enter your choice (0,1): ");

            int choice = getMenuInput(0,1);
            switch (choice) {
                case 1:
                    newBill();
                    System.out.println("\nNew Bill Generation Selected");
                    break;
                case 0:
                    System.out.println("\nLogging out from Cashier...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    
    
    //------------Products menu inside admin menu------------
    public static void productsMenu() {   
        while (true) {
            System.out.println("\n------ Products Menu ------");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Product price or stock");
            System.out.println("3. Delete Product");
            System.out.println("4. View/Search Products");
            System.out.println("0. Back to Admin Menu");
            System.out.print("\nEnter your choice (0-4): ");

            int choice = getMenuInput(0,4);
            switch (choice) {
                case 1:
                    System.out.println("\nAdd New Product Selected");
                    addProduct();
                    break;
                case 2:
                    System.out.println("\nUpdate Product Selected");
                    updateProduct();
                    break;
                case 3:
                    System.out.println("\nDelete Product Selected");
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("\nView/Search Products Selected");
                     searchProducts();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

    
    
    //-----------------Cashier menu inside admin menu------------
    public static void adminsCashierMenu() {
        while (true) {
            System.out.println("\n------ Cashier Records Menu ------");
            System.out.println("1. Add New Cashier");
            System.out.println("2. Update Cashier Details");
            System.out.println("3. Delete Cashier");
            System.out.println("4. View/Search Cashiers");
            System.out.println("0. Back to Admin Menu");
            System.out.print("\nEnter your choice (0-4): ");

            int choice = getMenuInput(0,4);
            switch (choice) {
                case 1:
                    System.out.println("\nAdd New Cashier Selected");
                    addCashier();
                    break;
                case 2:
                    System.out.println("\nUpdate Cashier Details Selected");
                    updateCashier();
                    break;
                case 3:
                    System.out.println("\nDelete Cashier Selected");
                    deleteCashier();
                    break;
                case 4:
                    System.out.println("\nView/Search Cashiers Selected");
                    searchCashier();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

    
    
    //------------Customer menu inside admin menu------------
    public static void customerMenu() {   
        while (true) {
            System.out.println("\n------ Customer Records Menu ------");
            System.out.println("1. Add New Customer");
            System.out.println("2. Update Customer Details");
            System.out.println("3. Delete Customer");
            System.out.println("4. View/Search Customers");
            System.out.println("0. Back to Admin Menu");
            System.out.print("\nEnter your choice (0-4): ");

            int choice = getMenuInput(0,4);
            switch (choice) {
                case 1:
                    System.out.println("\nAdd New Customer Selected");
                    addCustomer();
                    break;
                case 2:
                    System.out.println("\nUpdate Customer Details Selected");
                    updateCustomer();
                    break;
                case 3:
                    System.out.println("\nDelete Customer Selected");
                    deleteCustomer();
                    break;
                case 4:
                    System.out.println("\nView/Search Customers Selected");
                    searchCustomer();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }

    
    
    //------------Sales Reports menu inside admin menu------------
    public static void salesReports() {
        return;
        //To be done later
    }

    
    
    //------------New Bill menu inside cashier menu------------
    public static void newBill() {
        return;
        //To be done later
    }


    //--- add product method ---
    public static void addProduct() {
        File productFile = new File("products.txt");
        boolean addFileHeader = false;
        try {
            if (productFile.createNewFile()) {

                addFileHeader = true;
            } 

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace(); // extra
        }

        if (addFileHeader) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(productFile, true))) {
                pw.printf("%20s, %40s, %20s, %10s, %30s%n", "ProductID", "Product Name", "Price", "Stock","Category");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace(); // extra
            }
        }

        int lastProductID = getLastID("productsLastID.txt", "Product");
        if (lastProductID == 0000) {
            System.out.println("Error retrieving last Product ID. Cannot add new product.");
            return;
        }
        int newProductID = lastProductID + 1;




        try (PrintWriter pw = new PrintWriter(new FileWriter(productFile, true))) {
            pw.printf("%20s, ",newProductID);            
            
            System.out.print("Enter product name (no commas, max characters = 40): ");
            pw.printf ("%40s, ",getStringInput(40,','));

            System.out.print("Enter product price (non negative integer , no commas): ");
            while (true){
                
                try{
                    int price = Integer.parseInt(getStringInput(20,','));
                    if (price >= 0){
                        pw.printf ("%20s, ",price);
                        break;
                    } else 
                        System.out.print("Price must not be negative! Please enter a valid price: ");
                    
                }catch (NumberFormatException e){
                    System.out.print("Invalid input! Please enter a valid integer for price: ");
                    continue;
                }
            }
            System.out.print("Enter product stock (non negative integer, no commas): ");
            while (true){
                
                try{
                    int stock = Integer.parseInt(getStringInput(10,','));
                    if (stock >= 0){
                        pw.printf ("%10s, ",stock);
                        break;
                    } else 
                        System.out.print("Stock cannot be negative! Please enter a valid stock value: ");
                }catch (NumberFormatException e){
                    System.out.print("Invalid input! Please enter a valid integer for stock: ");
                    continue;
                }
            }

            System.out.print("Enter product category (no commas, max characters = 30): ");
            pw.printf ("%30s%n",getStringInput(30,','));

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace(); // extra
        }catch (ArrayIndexOutOfBoundsException e){
            // empty catch block to handle empty line at end of file
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("productsLastID.txt", false))) {
            pw.println("Last Product ID, " + newProductID);
        } catch (IOException e) {
            System.out.println("An error occurred while updating the last Product ID file.");
            e.printStackTrace(); // extra
        }

        System.out.println("\n\nProduct added successfully with Product ID: " + newProductID);

        
        return;

    }

    //--- get string input method with max length and no comma validation ---
    public static String getStringInput(int maxLength, char forbiddenChars) {
        String string;
        while (true) {
            string = input.nextLine().trim();
            if (string.length() > maxLength) {
                System.out.print("Input too long! Please enter maximum length of " + maxLength + " characters: ");
            } 
            else if (string.indexOf(forbiddenChars) != -1) {
                System.out.print("Input contains forbidden character '" + forbiddenChars + "'! Please enter valid input: ");
            } 
            else {
                return string;
            }

        }
    }

    //--- get last ID from file method ---
    public static int getLastID(String filename, String entity) {
        File idFile = new File(filename);
        try {
            if (!idFile.exists()) {
                idFile.createNewFile();
                try (PrintWriter pw = new PrintWriter(new FileWriter(idFile))) {
                    pw.println("Last" + entity + " ID, 0");
                }
                catch (IOException e) {
                    System.out.println("An error occurred while initializing the ID file.");
                    e.printStackTrace(); // extra
                }
                return 0;
            } 
            else {
                try (Scanner fileInput = new Scanner(idFile)) {

                        return Integer.parseInt(fileInput.nextLine().split(",")[1].trim());

                        
                }catch (IOException e) {
                    System.out.println("An error occurred while reading the ID file.");
                    e.printStackTrace(); // extra
                    return 0000;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred while accessing the ID file.");
            e.printStackTrace(); // extra
            return 0000;
        }
    }

    //--- search products method ---
    public static void searchProducts() {
        System.out.println("Search Products function called.");
        System.out.println("Do you want to search by:");
        System.out.println("1. Product ID");
        System.out.println("2. Product Name");
        System.out.println("3. Category");
        System.out.println("4. Stock lower than a threshold value:");
        System.out.println("0. Back to Products Menu");
        System.out.print("Enter your choice (0-4): ");
        int choice = getMenuInput(0,4);
        
        
        int searchCount = 0; // To keep track of number of matches found
        try (Scanner productFile = new Scanner(new File("products.txt"))){
            // Read and ignore header line
            if (productFile.hasNextLine()) {
                productFile.nextLine();
            }
            System.out.println();
            System.out.printf("%20s, %40s, %20s, %10s, %30s%n", "ProductID", "Product Name", "Price", "Stock","Category");
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID to search: ");

                    String productID = getStringInput(20,',');
                    while (productFile.hasNextLine()) {
                        String line = productFile.nextLine();
                        String[] parts = line.split(",");
                        if (parts[0].trim().equals(productID)) {
                            System.out.println("\n" + line);
                            searchCount++;
                        }
                        

                    }
                    if (searchCount == 0) {
                            System.out.println("Product ID not found.");
                        }
                        else{
                            System.out.println("\nTotal products found: " + searchCount);
                        }
                    break;
                case 2:
                    System.out.print("Enter Product Name to search: ");
                    String productName = getStringInput(40,',');
                    while (productFile.hasNextLine()) {
                        String line = productFile.nextLine();
                        String[] parts = line.split(",");
                        if (parts[1].trim().toLowerCase().contains(productName.toLowerCase())) {
                            System.out.println("\n" + line);
                            searchCount++;
                        }
                        

                    }
                    if (searchCount == 0) {
                            System.out.println("Product Name not found.");
                        }
                        else{
                            System.out.println("\nTotal products found: " + searchCount);
                        }
                    
                    break;
                case 3:
                    System.out.print("Enter Category to search: ");
                    String category = getStringInput(30,',');
                    while (productFile.hasNextLine()) {
                        String line = productFile.nextLine();
                        String[] parts = line.split(",");
                        if (parts[4].trim().toLowerCase().contains(category.toLowerCase())) {
                            System.out.println("\n" + line);
                            searchCount++;
                        }
                        

                    }
                    if (searchCount == 0) {
                            System.out.println("Category not found.");
                        }
                        else{
                            System.out.println("\nTotal products found: " + searchCount);
                        }
                    break;
                case 4:
                    System.out.print("Enter stock threshold value: ");
                    int stockThreshold;
                    while (true){
                        try{
                            stockThreshold = Integer.parseInt(getStringInput(10,','));
                            if (stockThreshold >= 0){
                                break;
                            } else 
                                System.out.print("Stock threshold cannot be negative! Please enter a valid stock value: ");
                        }catch (NumberFormatException e){
                            System.out.print("Invalid input! Please enter a valid integer for stock threshold: ");
                            continue;
                        }
                    }
                    while (productFile.hasNextLine()) {
                        String line = productFile.nextLine();
                        String[] parts = line.split(",");
                        try {
                            int stockValue = Integer.parseInt(parts[3].trim());
                            if (stockValue <= stockThreshold) {
                                System.out.println("\n" + line);
                                searchCount++;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid stock value in file for product: " + line);
                        }
                    }
                    if (searchCount == 0) {
                            System.out.println("No products found with stock lower than or equal to " + stockThreshold + ".");
                        }
                        else{
                            System.out.println("\nTotal products found: " + searchCount);
                        }
                    
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        
        } catch (FileNotFoundException e) {
            System.out.println("Products file not found.");
            e.printStackTrace(); // extra
        }
        System.out.println("\nEnd of search results.");
        return;
    }


    //--- update product method ---
    public static void updateProduct() {
        System.out.println("Update Product function called.");
        
        System.out.println("Press 1 to search for Product ID to update:");
        System.out.println("Press 2 to directly enter Product ID to update:");
        System.out.println("Press 0 to go back to Products Menu:"  );

        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Product ID to update:");
                searchProducts();
                
            case 2:
                System.out.print("Enter Product ID to update: ");
                String productID = getStringInput(20,',');

                try{
                    File file = new File("products.txt");
                    File tempFile = new File("products_temp.txt");

                    try (Scanner productFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (productFile.hasNextLine()) {
                            pw.println(productFile.nextLine());
                        }

                        boolean productFound = false;

                        while (productFile.hasNextLine()) {
                            String line = productFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(productID)) {
                                productFound = true;
                                System.out.println("Product found: " + line);
                                
                                System.out.print("Enter new price (non negative integer, no commas): ");
                                int newPrice;
                                while (true){
                                    try{
                                        newPrice = Integer.parseInt(getStringInput(20,','));
                                        if (newPrice >= 0){
                                            break;
                                        } else 
                                            System.out.print("Price must not be negative! Please enter a valid price: ");
                                        
                                    }catch (NumberFormatException e){
                                        System.out.print("Invalid input! Please enter a valid integer for price: ");
                                        continue;
                                    }
                                }

                                System.out.print("Enter new stock (non negative integer, no commas): ");
                                int newStock;
                                while (true){
                                    try{
                                        newStock = Integer.parseInt(getStringInput(10,','));
                                        if (newStock >= 0){
                                            break;
                                        } else 
                                            System.out.print("Stock cannot be negative! Please enter a valid stock value: ");
                                    }catch (NumberFormatException e){
                                        System.out.print("Invalid input! Please enter a valid integer for stock: ");
                                        continue;
                                    }
                                }

                                // Write updated product details
                                pw.printf("%20s, %40s, %20s, %10s, %30s%n", parts[0].trim(), parts[1].trim(), newPrice, newStock, parts[4].trim());
                            } else {
                                // Write unchanged product details
                                pw.println(line);
                            }
                        }

                        if (!productFound) {
                            System.out.println("Product ID not found.");
                        } else {
                            System.out.println("Product updated successfully.");
                        }



                    } catch (IOException e) {
                        System.out.println("An error occurred while updating the product.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);

                } catch (Exception e) {     
                    System.out.println("An error occurred while accessing the products file.");
                    e.printStackTrace(); // extra
                }          
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
        }




        return;
    }


    public static void deleteProduct() {
        System.out.println("Delete Product function called.");

        System.out.println("Press 1 to search for Product ID to delete:");
        System.out.println("Press 2 to directly enter Product ID to delete:");
        System.out.println("Press 0 to go back to Products Menu:"  );

        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Product ID to delete:");
                searchProducts();
                
            case 2:
                System.out.print("Enter Product ID to delete: ");
                String productID = getStringInput(20,',');

                try{
                    File file = new File("products.txt");
                    File tempFile = new File("products_temp.txt");

                    try (Scanner productFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (productFile.hasNextLine()) {
                            pw.println(productFile.nextLine());
                        }

                        boolean productFound = false;

                        while (productFile.hasNextLine()) {
                            String line = productFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(productID)) {
                                productFound = true;
                                System.out.println("Product found: " + line);

                                System.out.println("Deleting product...");
                                
                                
                            } else {
                                // Write unchanged product details
                                pw.println(line);
                            }
                        }

                        if (!productFound) {
                            System.out.println("Product ID not found.");
                        } else {
                            System.out.println("Product deleted successfully.");
                        }



                    } catch (IOException e) {
                        System.out.println("An error occurred while deleted the product.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);

                } catch (Exception e) {     
                    System.out.println("An error occurred while accessing the products file.");
                    e.printStackTrace(); // extra
                }          
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
        }

        return;
    }

    //--- add cashier method ---
    public static void addCashier() {
        File cashierFile = new File("cashiers.txt");
        boolean addFileHeader = false;
        try {
            if (cashierFile.createNewFile()) {

                addFileHeader = true;
            } 

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace(); // extra
        }

        if (addFileHeader) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(cashierFile, true))) {
                pw.printf("%10s, %40s, %20s, %20s%n", "CashierID", "Cashier Name", "CNIC number", " Contact Number");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace(); // extra
            }
        }

        int lastCashierID = getLastID("cashiersLastID.txt", "Cashier");
        if (lastCashierID == 0000) {
            System.out.println("Error retrieving last Cashier ID. ");
            return;
        }
        int newCashierID = lastCashierID + 1;

        try (PrintWriter pw = new PrintWriter(new FileWriter(cashierFile, true))) {
            pw.printf("%10s, ",newCashierID);            
            
            System.out.print("Enter cashier name (no commas, max characters = 40): ");
            pw.printf ("%40s, ",getStringInput(40,','));

             String cnicInput;
            while (true) {
                System.out.print("Enter CNIC number (only numbers, 16 digits): ");
                cnicInput = getStringInput(16,',');
                if (cnicInput.trim().length() != 16) {
                    System.out.println("CNIC number must be exactly 16 digits! Please try again.");
                    continue;
                }
                try{
                    long cnic = Long.parseLong(cnicInput); // will throw exception if not numeric
                    System.out.println(cnic);
                    pw.printf ("%20d, ",cnic);
                    break; // valid CNIC number
                }
                catch (Exception e){
                    System.out.println("CNIC must contain only digits! Please try again.");
                }
            }

            String contactInput;
            while (true) {
                System.out.print("Enter contact number (only numbers, 11 digits): ");
                contactInput = getStringInput(11,',');
                if (contactInput.trim().length() != 11) {
                    System.out.println("Contact number must be exactly 11 digits! Please try again.");
                    continue;
                }
                try{
                    long contact = Long.parseLong(contactInput); // will throw exception if not numeric
                    pw.printf ("%20d %n ",contact);
                    break; // valid contact number
                }
                catch (Exception e){
                    System.out.println("Contact number must contain only digits! Please try again.");
                }
            }


        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace(); // extra
        }catch (ArrayIndexOutOfBoundsException e){
            // empty catch block to handle empty line at end of file
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("cashiersLastID.txt", false))) {
            pw.println("Last Cashier ID, " + newCashierID);
        } catch (IOException e) {
            System.out.println("An error occurred while updating the last Cashier ID file.");
            e.printStackTrace(); // extra
        }
        System.out.println("\n\nCashier added successfully with Cashier ID: " + newCashierID);
        return;
    }


    public static void updateCashier() {
        System.out.println("Update Cashier function called.");

        System.out.println("Press 1 to search for Cashier ID to update contact of:");
        System.out.println("Press 2 to directly enter Cashier ID to update contact of:");
        System.out.println("Press 0 to go back to Cashier Records Menu:"  );
        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Cashier ID to update:");
                searchCashier();
                
            case 2:
                System.out.print("Enter Cashier ID to update contact number: ");
                String cashierID = getStringInput(11,',');

                try{
                    File file = new File("cashiers.txt");
                    File tempFile = new File("cashiers_temp.txt");

                    try (Scanner cashierFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (cashierFile.hasNextLine()) {
                            pw.println(cashierFile.nextLine());
                        }

                        boolean cashierFound = false;

                        while (cashierFile.hasNextLine()) {
                            String line = cashierFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(cashierID)) {
                                cashierFound = true;
                                System.out.println("Cashier found: " + line);
                                
                                System.out.print("Enter new contact (11 digits , no commas): ");
                                Long newContact;
                                while (true){
                                    try{
                                        String contactString = getStringInput(11,',');
                                        newContact = Long.parseLong(contactString);
                                        if (contactString.length() == 11){
                                            break;
                                        } else 
                                            System.out.print("Please enter a valid contact value with 11 digits: ");
                                    }catch (NumberFormatException e){
                                        System.out.print("Invalid input! Please enter a valid number for contact: ");
                                        continue;
                                    }
                                }

                                // Write updated cashier details
                                pw.printf("%10s, %40s, %20s, %20s%n", parts[0], parts[1], parts[2], newContact);
                            } else {
                                // Write unchanged cashier details
                                pw.println(line);
                            }
                        }

                        if (!cashierFound) {
                            System.out.println("Cashier ID not found.");
                        } else {
                            System.out.println("Cashier contact updated successfully.");
                        }



                    } catch (IOException e) {
                        System.out.println("An error occurred while updating the contact.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);

                } catch (Exception e) {     
                    System.out.println("An error occurred while accessing the cashier file.");
                    e.printStackTrace(); // extra
                }          
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
        }
        return;

        }
    

    public static void searchCashier() {
        System.out.println("Search Cashier function called.");

        System.out.println("Enter name of Cashier to search: ");
        String cashierName = getStringInput(40,',');
        
        int searchCount = 0; // To keep track of number of matches found
        try (Scanner cashierFile = new Scanner(new File("cashiers.txt"))){
            // Read and ignore header line
            if (cashierFile.hasNextLine()) {
                cashierFile.nextLine();
            }
            System.out.println();
            System.out.printf("%10s, %40s, %20s, %20s%n", "CashierID", "Cashier Name", "CNIC number", " Contact Number");
                while (cashierFile.hasNextLine()) {
                        String line = cashierFile.nextLine();
                        String[] parts = line.split(",");
                        try{
                            if (parts[1].trim().toLowerCase().contains(cashierName.toLowerCase())) {
                                System.out.println("\n" + line);
                                searchCount++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e){
                            // empty catch block to handle empty line at end of file
                        }

                    }
                if (searchCount == 0) {
                        System.out.println("Cashier Name not found.");
                    }
                    else{
                        System.out.println("\nTotal cashiers found: " + searchCount);
                    }
        } catch (FileNotFoundException e) {
            System.out.println("Cashiers file not found.");
            e.printStackTrace(); // extra
        }


        return;
    }


    public static void deleteCashier() {
        System.out.println("Delete Cashier function called.");

        System.out.println("Press 1 to search for Cashier ID to delete:");
        System.out.println("Press 2 to directly enter Cashier ID to delete:");
        System.out.println("Press 0 to go back to Cashier Records Menu:"  );

        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Cashier ID to delete:");
                searchCashier();
                
            case 2:
                System.out.print("Enter Cashier ID to delete: ");
                String cashierID = getStringInput(11,',');

                try{
                    File file = new File("cashiers.txt");
                    File tempFile = new File("cashiers_temp.txt");

                    try (Scanner cashierFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (cashierFile.hasNextLine()) {
                            pw.println(cashierFile.nextLine());
                        }

                        boolean cashierFound = false;

                        while (cashierFile.hasNextLine()) {
                            String line = cashierFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(cashierID)) {
                                cashierFound = true;
                                System.out.println("Cashier found: " + line);

                                System.out.println("Deleting cashier...");
                                
                                
                            } else {
                                // Write unchanged cashier details
                                pw.println(line);
                            }
                        }

                        if (!cashierFound) {
                            System.out.println("Cashier ID not found.");
                        } else {
                            System.out.println("Cashier deleted successfully.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while deleted the cashier.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);
                } catch (Exception e) {
                    System.out.println("An error occurred while accessing the cashier file.");
                    e.printStackTrace(); // extra
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
                deleteCashier();
                

            }

            }

    public static void addCustomer() {
        File customerFile = new File("customers.txt");
        boolean addFileHeader = false;
        try {
            if (customerFile.createNewFile()) {

                addFileHeader = true;
            } 

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace(); // extra
        }

        if (addFileHeader) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(customerFile, true))) {
                pw.printf("%10s, %40s, %20s, %20s%n", "CustomerID", "Customer Name", "CNIC number", " Contact Number");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace(); // extra
            }
        }

        int lastCustomerID = getLastID("customersLastID.txt", "Customer");
        if (lastCustomerID == 0000) {
            System.out.println("Error retrieving last Customer ID. ");
            return;
        }
        int newCustomerID = lastCustomerID + 1;
        try (PrintWriter pw = new PrintWriter(new FileWriter(customerFile, true))) {
            pw.printf("%10s, ",newCustomerID);            

            System.out.print("Enter customer name (no commas, max characters = 40): ");
            pw.printf ("%40s, ",getStringInput(40,','));

            String cnicInput;
            while (true) {
                System.out.print("Enter CNIC number (only numbers, 16 digits): ");
                cnicInput = getStringInput(16,',');
                if (cnicInput.trim().length() != 16) {
                    System.out.println("CNIC number must be exactly 16 digits! Please try again.");
                    continue;
                }
                try{
                    long cnic = Long.parseLong(cnicInput); // will throw exception if not numeric
                    System.out.println(cnic);
                    pw.printf ("%20d, ",cnic);
                    break; // valid CNIC number
                }
                catch (Exception e){
                    System.out.println("CNIC must contain only digits! Please try again.");
                }
            }

            String contactInput;
            while (true) {
                System.out.print("Enter contact number (only numbers, 11 digits): ");
                contactInput = getStringInput(11,',');
                if (contactInput.trim().length() != 11) {
                    System.out.println("Contact number must be exactly 11 digits! Please try again.");
                    continue;
                }
                try{
                    long contact = Long.parseLong(contactInput); // will throw exception if not numeric
                    pw.printf ("%20d %n ",contact);
                    break; // valid contact number
                }
                catch (Exception e){
                    System.out.println("Contact number must contain only digits! Please try again.");
                }
            }


        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace(); // extra
        }catch (ArrayIndexOutOfBoundsException e){
            // empty catch block to handle empty line at end of file
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("customersLastID.txt", false))) {
            pw.println("Last Customer ID, " + newCustomerID);
        } catch (IOException e) {
            System.out.println("An error occurred while updating the last Customer ID file.");
            e.printStackTrace(); // extra
        }
        System.out.println("\n\nCustomer added successfully with Customer ID: " + newCustomerID);
        return;
    }


    public static void updateCustomer() {
        System.out.println("Update Customer function called.");

        System.out.println("Press 1 to search for Customer ID to update contact of:");
        System.out.println("Press 2 to directly enter Customer ID to update contact of:");
        System.out.println("Press 0 to go back to Customer Records Menu:"  );
        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Customer ID to update:");
                searchCustomer();
                
            case 2:
                System.out.print("Enter Customer ID to update contact number: ");
                String customerID = getStringInput(11,',');

                try{
                    File file = new File("customers.txt");
                    File tempFile = new File("customers_temp.txt");
                    try (Scanner customerFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (customerFile.hasNextLine()) {
                            pw.println(customerFile.nextLine());
                        }

                        boolean customerFound = false;

                        while (customerFile.hasNextLine()) {
                            String line = customerFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(customerID)) {
                                customerFound = true;
                                System.out.println("Customer found: " + line);

                                System.out.print("Enter new contact (11 digits , no commas): ");
                                Long newContact;
                                while (true){
                                    try{
                                        String contactString = getStringInput(11,',');
                                        newContact = Long.parseLong(contactString);
                                        if (contactString.length() == 11){
                                            break;
                                        } else 
                                            System.out.print("Please enter a valid contact value with 11 digits: ");
                                    }catch (NumberFormatException e){
                                        System.out.print("Invalid input! Please enter a valid number for contact: ");
                                        continue;
                                    }
                                }

                                // Write updated customer details
                                pw.printf("%10s, %40s, %20s, %20s%n", parts[0], parts[1], parts[2], newContact);
                            } else {
                                // Write unchanged customer details
                                pw.println(line);
                            }
                        }

                        if (!customerFound) {
                            System.out.println("Customer ID not found.");
                        } else {
                            System.out.println("Customer contact updated successfully.");
                        }



                    } catch (IOException e) {
                        System.out.println("An error occurred while updating the contact.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);

                } catch (Exception e) {     
                    System.out.println("An error occurred while accessing the customer file.");
                    e.printStackTrace(); // extra
                }          
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
        }
        return;

    }

    public static void deleteCustomer() {
        System.out.println("Delete Customer function called.");

        System.out.println("Press 1 to search for Customer ID to delete:");
        System.out.println("Press 2 to directly enter Customer ID to delete:");
        System.out.println("Press 0 to go back to Customer Records Menu:"  );
        int choice = getMenuInput(0,2);
        switch (choice) {
            case 1:
                System.out.println("Search for Customer ID to delete:");
                searchCustomer();

            case 2:
                System.out.print("Enter Customer ID to delete: ");
                String customerID = getStringInput(11,',');

                try{
                    File file = new File("customers.txt");
                    File tempFile = new File("customers_temp.txt");
                    try (Scanner customerFile = new Scanner(file); PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                        // Read and write header line
                        if (customerFile.hasNextLine()) {
                            pw.println(customerFile.nextLine());
                        }

                        boolean customerFound = false;

                        while (customerFile.hasNextLine()) {
                            String line = customerFile.nextLine();
                            String[] parts = line.split(",");

                            if (parts[0].trim().equals(customerID)) {
                                customerFound = true;
                                System.out.println("Customer found: " + line);

                                System.out.println("Deleting customer...");
                                
                                
                            } else {
                                // Write unchanged customer details
                                pw.println(line);
                            }
                        }

                        if (!customerFound) {
                            System.out.println("Customer ID not found.");
                        } else {
                            System.out.println("Customer deleted successfully.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while deleted the customer.");
                        e.printStackTrace(); // extra
                    }

                        file.delete();
                        tempFile.renameTo(file);
                } catch (Exception e) {
                    System.out.println("An error occurred while accessing the customer file.");
                    e.printStackTrace(); // extra
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice! Try again.");
                deleteCustomer();
                

            }

    }


    public static void searchCustomer() {
        System.out.println("Search Customer function called.");

        System.out.println("Enter name of Customer to search: ");
        String customerName = getStringInput(40,',');

        int searchCount = 0; // To keep track of number of matches found
        try (Scanner customerFile = new Scanner(new File("customers.txt"))){
            // Read and ignore header line
            if (customerFile.hasNextLine()) {
                customerFile.nextLine();
            }
            System.out.println();
            System.out.printf("%10s, %40s, %20s, %20s%n", "CustomerID", "Customer Name", "CNIC number", " Contact Number");
                while (customerFile.hasNextLine()) {
                        String line = customerFile.nextLine();
                        String[] parts = line.split(",");
                        try{
                            if (parts[1].trim().toLowerCase().contains(customerName.toLowerCase())) {
                                System.out.println("\n" + line);
                                searchCount++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e){
                            // empty catch block to handle empty line at end of file
                        }

                    }
                if (searchCount == 0) {
                        System.out.println("Customer Name not found.");
                    }
                    else{
                        System.out.println("\nTotal customers found: " + searchCount);
                    }
        } catch (FileNotFoundException e) {
            System.out.println("Customers file not found.");
            e.printStackTrace(); // extra
        }


        return;
    }



    

}
