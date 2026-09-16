public interface Stockable {

    void addStock(int quantity);

    boolean removeStock(int quantity);

    boolean isLowStock();
}