import java.util.List;

public class ReportGenerator {

    private ProductManager productManager;
    private TransactionManager transactionManager;

    public ReportGenerator(ProductManager productManager,
                           TransactionManager transactionManager) {

        this.productManager = productManager;
        this.transactionManager = transactionManager;
    }

    public void generateInventoryReport() {

        List<Product> products = productManager.getProducts();

        System.out.println("\n========================================");
        System.out.println("         INVENTORY STOCK REPORT");
        System.out.println("========================================");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.printf(
                "%-8s %-20s %-15s %-10s %-12s%n",
                "ID", "Product", "Category", "Quantity", "Value"
        );

        System.out.println("----------------------------------------"
                + "--------------------------------");

        for (Product product : products) {

            System.out.printf(
                    "%-8d %-20s %-15s %-10d ₹%-11.2f%n",
                    product.getProductId(),
                    product.getName(),
                    product.getCategory(),
                    product.getQuantity(),
                    product.getStockValue()
            );
        }

        System.out.println("----------------------------------------"
                + "--------------------------------");

        double totalValue = 0;

        for (Product product : products) {
            totalValue += product.getStockValue();
        }

        System.out.printf(
                "Total Inventory Value: ₹%.2f%n",
                totalValue
        );

        System.out.println("========================================");
    }

    public void generateLowStockReport() {

        List<Product> products = productManager.getProducts();

        System.out.println("\n========================================");
        System.out.println("           LOW STOCK REPORT");
        System.out.println("========================================");

        boolean found = false;

        for (Product product : products) {

            if (product.isLowStock()) {

                System.out.println(
                        "ID: " + product.getProductId()
                        + " | Product: " + product.getName()
                        + " | Current Stock: "
                        + product.getQuantity()
                        + " | Minimum Required: "
                        + product.getMinimumStock()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No products are currently low in stock.");
        }

        System.out.println("========================================");
    }

    public void generateTransactionReport() {

        List<StockTransaction> transactions =
                transactionManager.getTransactions();

        System.out.println("\n========================================");
        System.out.println("         TRANSACTION REPORT");
        System.out.println("========================================");

        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }

        for (StockTransaction transaction : transactions) {
            System.out.println(transaction);
        }

        System.out.println("========================================");
    }

    public void generateCategoryReport() {

        List<Product> products = productManager.getProducts();

        System.out.println("\n========================================");
        System.out.println("          CATEGORY REPORT");
        System.out.println("========================================");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Category category : Category.values()) {

            int productCount = 0;
            int totalQuantity = 0;

            for (Product product : products) {

                if (product.getCategory()
                        .equalsIgnoreCase(category.name())) {

                    productCount++;
                    totalQuantity += product.getQuantity();
                }
            }

            if (productCount > 0) {

                System.out.println(
                        category + " -> Products: "
                        + productCount
                        + ", Total Stock: "
                        + totalQuantity
                );
            }
        }

        System.out.println("========================================");
    }
}