import java.util.List;

public class InventoryManager {

    private ProductManager productManager;
    private TransactionManager transactionManager;

    public InventoryManager(ProductManager productManager,
                            TransactionManager transactionManager) {

        this.productManager = productManager;
        this.transactionManager = transactionManager;
    }

    public void addStock(int productId, int quantity) {

        Product product = productManager.findProduct(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        transactionManager.recordStockIn(product, quantity);
    }

    public void removeStock(int productId, int quantity) {

        Product product = productManager.findProduct(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        transactionManager.recordStockOut(product, quantity);
    }

    public void displayLowStockProducts() {

        List<Product> products = productManager.getProducts();

        boolean found = false;

        System.out.println("\n========== LOW STOCK REPORT ==========");

        for (Product product : products) {

            if (product.isLowStock()) {
                System.out.println(
                        "Product ID: " + product.getProductId()
                        + " | Name: " + product.getName()
                        + " | Current Stock: " + product.getQuantity()
                        + " | Minimum Stock: "
                        + product.getMinimumStock()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }
    }

    public double calculateTotalInventoryValue() {

        double totalValue = 0;

        for (Product product : productManager.getProducts()) {
            totalValue += product.getStockValue();
        }

        return totalValue;
    }

    public void displayInventorySummary() {

        List<Product> products = productManager.getProducts();

        int totalProducts = products.size();
        int totalQuantity = 0;
        int lowStockCount = 0;
        double totalValue = 0;

        for (Product product : products) {

            totalQuantity += product.getQuantity();
            totalValue += product.getStockValue();

            if (product.isLowStock()) {
                lowStockCount++;
            }
        }

        System.out.println("\n========== INVENTORY SUMMARY ==========");
        System.out.println("Total Products: " + totalProducts);
        System.out.println("Total Items in Stock: " + totalQuantity);
        System.out.println("Low Stock Products: " + lowStockCount);
        System.out.println(
                "Total Inventory Value: ₹"
                + String.format("%.2f", totalValue)
        );
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
}