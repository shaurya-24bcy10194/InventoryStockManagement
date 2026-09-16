public class Product implements Stockable {

    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private int minimumStock;

    public Product(int productId, String name, String category,
                   double price, int quantity, int minimumStock) {

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    @Override
    public void addStock(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    @Override
    public boolean removeStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
            return true;
        }

        return false;
    }

    @Override
    public boolean isLowStock() {
        return quantity <= minimumStock;
    }

    public double getStockValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + name +
               ", Category: " + category +
               ", Price: ₹" + price +
               ", Quantity: " + quantity +
               ", Minimum Stock: " + minimumStock;
    }
}