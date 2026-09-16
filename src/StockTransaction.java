import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockTransaction {

    private int transactionId;
    private int productId;
    private String transactionType;
    private int quantity;
    private LocalDateTime dateTime;

    public StockTransaction(int transactionId, int productId,
                            String transactionType, int quantity) {

        this.transactionId = transactionId;
        this.productId = productId;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.dateTime = LocalDateTime.now();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getProductId() {
        return productId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return dateTime.format(formatter);
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Product ID: " + productId +
               ", Type: " + transactionType +
               ", Quantity: " + quantity +
               ", Date: " + getFormattedDateTime();
    }
}