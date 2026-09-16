import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        TransactionManager transactionManager =
                new TransactionManager();

        loadExistingProducts(productManager);

        InventoryManager inventoryManager =
                new InventoryManager(
                        productManager,
                        transactionManager
                );

        ReportGenerator reportGenerator =
                new ReportGenerator(
                        productManager,
                        transactionManager
                );

        Admin admin = new Admin(
                "admin",
                "admin123"
        );

        System.out.println("==========================================");
        System.out.println("     INVENTORY & STOCK MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        if (!login(admin)) {
            System.out.println("Too many failed attempts.");
            System.out.println("Application closed.");
            return;
        }

        boolean running = true;

        while (running) {

            admin.showMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addProduct(productManager);
                    saveProducts(productManager);
                    break;

                case 2:
                    productManager.displayProducts();
                    break;

                case 3:
                    searchProduct(productManager);
                    break;

                case 4:
                    updateProduct(productManager);
                    saveProducts(productManager);
                    break;

                case 5:
                    deleteProduct(productManager);
                    saveProducts(productManager);
                    break;

                case 6:
                    addStock(inventoryManager);
                    saveAll(
                            productManager,
                            transactionManager
                    );
                    break;

                case 7:
                    removeStock(inventoryManager);
                    saveAll(
                            productManager,
                            transactionManager
                    );
                    break;

                case 8:
                    inventoryManager.displayLowStockProducts();
                    break;

                case 9:
                    reportGenerator.generateInventoryReport();
                    break;

                case 10:
                    showReportsMenu(
                            admin,
                            reportGenerator,
                            inventoryManager
                    );
                    break;

                case 11:
                    saveAll(
                            productManager,
                            transactionManager
                    );

                    System.out.println(
                            "Logged out successfully."
                    );

                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();

        System.out.println(
                "Thank you for using the system!"
        );
    }

    private static boolean login(Admin admin) {

        System.out.println("\n========== ADMIN LOGIN ==========");

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {

                System.out.println(
                        "\nLogin successful. Welcome, "
                        + username + "!"
                );

                return true;
            }

            System.out.println(
                    "Invalid username or password."
            );

            System.out.println(
                    "Attempts remaining: "
                    + (3 - attempt)
            );
        }

        return false;
    }

    private static void showReportsMenu(
            Admin admin,
            ReportGenerator reportGenerator,
            InventoryManager inventoryManager) {

        boolean reportsRunning = true;

        while (reportsRunning) {

            admin.showReportsMenu();

            int choice =
                    readInt("Enter report choice: ");

            switch (choice) {

                case 1:
                    reportGenerator.generateInventoryReport();
                    break;

                case 2:
                    reportGenerator.generateLowStockReport();
                    break;

                case 3:
                    reportGenerator.generateTransactionReport();
                    break;

                case 4:
                    reportGenerator.generateCategoryReport();
                    break;

                case 5:
                    reportsRunning = false;
                    break;

                default:
                    System.out.println(
                            "Invalid report choice."
                    );
            }
        }
    }

    private static void addProduct(
            ProductManager productManager) {

        System.out.println("\n========== ADD PRODUCT ==========");

        int id = readInt("Enter product ID: ");

        if (productManager.findProduct(id) != null) {
            System.out.println(
                    "Product ID already exists."
            );
            return;
        }

        System.out.print("Enter product name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println(
                    "Product name cannot be empty."
            );
            return;
        }

        System.out.println("\nAvailable Categories:");

        for (Category category : Category.values()) {
            System.out.println("- " + category);
        }

        System.out.print("Enter category: ");
        String category =
                scanner.nextLine().trim().toUpperCase();

        if (!isValidCategory(category)) {
            System.out.println(
                    "Invalid category. Product not added."
            );
            return;
        }

        double price =
                readDouble("Enter price: ");

        int quantity =
                readInt("Enter initial quantity: ");

        int minimumStock =
                readInt("Enter minimum stock level: ");

        if (price < 0
                || quantity < 0
                || minimumStock < 0) {

            System.out.println(
                    "Price and stock values cannot be negative."
            );

            return;
        }

        Product product =
                new Product(
                        id,
                        name,
                        category,
                        price,
                        quantity,
                        minimumStock
                );

        productManager.addProduct(product);
    }

    private static void searchProduct(
            ProductManager productManager) {

        System.out.println(
                "\n========== SEARCH PRODUCT =========="
        );

        System.out.print(
                "Enter product name or category: "
        );

        String keyword =
                scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println(
                    "Search keyword cannot be empty."
            );
            return;
        }

        productManager.searchProduct(keyword);
    }

    private static void updateProduct(
            ProductManager productManager) {

        System.out.println(
                "\n========== UPDATE PRODUCT =========="
        );

        int id =
                readInt("Enter product ID: ");

        Product product =
                productManager.findProduct(id);

        if (product == null) {
            System.out.println(
                    "Product not found."
            );
            return;
        }

        System.out.println(
                "Current product: " + product
        );

        System.out.print(
                "Enter new product name: "
        );

        String name =
                scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println(
                    "Product name cannot be empty."
            );
            return;
        }

        System.out.print(
                "Enter new category: "
        );

        String category =
                scanner.nextLine()
                        .trim()
                        .toUpperCase();

        if (!isValidCategory(category)) {
            System.out.println(
                    "Invalid category."
            );
            return;
        }

        double price =
                readDouble("Enter new price: ");

        int minimumStock =
                readInt(
                        "Enter new minimum stock level: "
                );

        if (price < 0 || minimumStock < 0) {

            System.out.println(
                    "Price and stock values cannot be negative."
            );

            return;
        }

        boolean updated =
                productManager.updateProduct(
                        id,
                        name,
                        category,
                        price,
                        minimumStock
                );

        if (updated) {

            System.out.println(
                    "Product updated successfully."
            );

        } else {

            System.out.println(
                    "Unable to update product."
            );
        }
    }

    private static void deleteProduct(
            ProductManager productManager) {

        System.out.println(
                "\n========== DELETE PRODUCT =========="
        );

        int id =
                readInt("Enter product ID: ");

        Product product =
                productManager.findProduct(id);

        if (product == null) {
            System.out.println(
                    "Product not found."
            );
            return;
        }

        System.out.println(
                "Product selected: "
                        + product.getName()
        );

        System.out.print(
                "Are you sure you want to delete it? (yes/no): "
        );

        String confirmation =
                scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {

            if (productManager.deleteProduct(id)) {

                System.out.println(
                        "Product deleted successfully."
                );
            }

        } else {

            System.out.println(
                    "Delete operation cancelled."
            );
        }
    }

    private static void addStock(
            InventoryManager inventoryManager) {

        System.out.println(
                "\n========== ADD STOCK =========="
        );

        int productId =
                readInt("Enter product ID: ");

        int quantity =
                readInt("Enter quantity to add: ");

        inventoryManager.addStock(
                productId,
                quantity
        );
    }

    private static void removeStock(
            InventoryManager inventoryManager) {

        System.out.println(
                "\n========== REMOVE STOCK =========="
        );

        int productId =
                readInt("Enter product ID: ");

        int quantity =
                readInt("Enter quantity to remove: ");

        inventoryManager.removeStock(
                productId,
                quantity
        );
    }

    private static boolean isValidCategory(
            String category) {

        for (Category value : Category.values()) {

            if (value.name()
                    .equalsIgnoreCase(category)) {

                return true;
            }
        }

        return false;
    }

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine().trim();

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }

    private static double readDouble(
            String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine().trim();

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static void loadExistingProducts(
            ProductManager productManager) {

        List<Product> savedProducts =
                FileManager.loadProducts();

        for (Product product : savedProducts) {

            productManager.addProduct(product);
        }

        if (!savedProducts.isEmpty()) {

            System.out.println(
                    savedProducts.size()
                            + " product(s) loaded from storage."
            );
        }
    }

    private static void saveProducts(
            ProductManager productManager) {

        FileManager.saveProducts(
                productManager.getProducts()
        );
    }

    private static void saveAll(
            ProductManager productManager,
            TransactionManager transactionManager) {

        FileManager.saveProducts(
                productManager.getProducts()
        );

        FileManager.saveTransactions(
                transactionManager.getTransactions()
        );
    }
}