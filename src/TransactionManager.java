import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<StockTransaction> transactions;
    private int nextTransactionId;

    public TransactionManager() {
        transactions = new ArrayList<>();
        nextTransactionId = 1;
    }

    public void recordStockIn(Product product, int quantity) {

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        product.addStock(quantity);

        StockTransaction transaction =
                new StockTransaction(
                        nextTransactionId++,
                        product.getProductId(),
                        "STOCK IN",
                        quantity
                );

        transactions.add(transaction);

        System.out.println("Stock added successfully.");
        System.out.println("New quantity: " + product.getQuantity());
    }

    public void recordStockOut(Product product, int quantity) {

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        if (!product.removeStock(quantity)) {
            System.out.println("Insufficient stock.");
            return;
        }

        StockTransaction transaction =
                new StockTransaction(
                        nextTransactionId++,
                        product.getProductId(),
                        "STOCK OUT",
                        quantity
                );

        transactions.add(transaction);

        System.out.println("Stock removed successfully.");
        System.out.println("Remaining quantity: " + product.getQuantity());
    }

    public void displayTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No stock transactions available.");
            return;
        }

        System.out.println("\n========== STOCK TRANSACTIONS ==========");

        for (StockTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public List<StockTransaction> getTransactions() {
        return transactions;
    }
}