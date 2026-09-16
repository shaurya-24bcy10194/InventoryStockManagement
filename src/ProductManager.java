import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Invalid product.");
            return;
        }

        if (findProduct(product.getProductId()) != null) {
            System.out.println("Product ID already exists.");
            return;
        }

        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n========== PRODUCT LIST ==========");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product findProduct(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }

        return null;
    }

    public void searchProduct(String keyword) {
        boolean found = false;

        for (Product product : products) {
            if (product.getName().toLowerCase()
                    .contains(keyword.toLowerCase())
                    || product.getCategory().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching product found.");
        }
    }

    public boolean updateProduct(int productId, String name,
                                 String category, double price,
                                 int minimumStock) {

        Product product = findProduct(productId);

        if (product == null) {
            return false;
        }

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        product.setMinimumStock(minimumStock);

        return true;
    }

    public boolean deleteProduct(int productId) {
        Product product = findProduct(productId);

        if (product == null) {
            return false;
        }

        products.remove(product);
        return true;
    }

    public List<Product> getProducts() {
        return products;
    }
}