import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String PRODUCT_FILE =
            "../data/products.txt";

    private static final String TRANSACTION_FILE =
            "../data/transactions.txt";

    public static void saveProducts(List<Product> products) {

        try {
            File directory = new File("../data");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(PRODUCT_FILE)
                    );

            for (Product product : products) {

                writer.write(
                        product.getProductId() + "|" +
                        product.getName() + "|" +
                        product.getCategory() + "|" +
                        product.getPrice() + "|" +
                        product.getQuantity() + "|" +
                        product.getMinimumStock()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println(
                    "Error saving products: "
                    + e.getMessage()
            );
        }
    }

    public static List<Product> loadProducts() {

        List<Product> products = new ArrayList<>();

        File file = new File(PRODUCT_FILE);

        if (!file.exists()) {
            return products;
        }

        try {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    int productId =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    String category = data[2];

                    double price =
                            Double.parseDouble(data[3]);

                    int quantity =
                            Integer.parseInt(data[4]);

                    int minimumStock =
                            Integer.parseInt(data[5]);

                    Product product =
                            new Product(
                                    productId,
                                    name,
                                    category,
                                    price,
                                    quantity,
                                    minimumStock
                            );

                    products.add(product);
                }
            }

            reader.close();

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading products: "
                    + e.getMessage()
            );
        }

        return products;
    }

    public static void saveTransactions(
            List<StockTransaction> transactions) {

        try {
            File directory = new File("../data");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(TRANSACTION_FILE)
                    );

            for (StockTransaction transaction
                    : transactions) {

                writer.write(
                        transaction.getTransactionId() + "|" +
                        transaction.getProductId() + "|" +
                        transaction.getTransactionType() + "|" +
                        transaction.getQuantity() + "|" +
                        transaction.getFormattedDateTime()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving transactions: "
                    + e.getMessage()
            );
        }
    }

    public static void displaySavedData() {

        System.out.println(
                "\n========== SAVED PRODUCT DATA =========="
        );

        File productFile =
                new File(PRODUCT_FILE);

        if (!productFile.exists()) {

            System.out.println(
                    "No saved product data found."
            );

        } else {

            try {

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(productFile)
                        );

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();

            } catch (IOException e) {

                System.out.println(
                        "Error reading product data: "
                        + e.getMessage()
                );
            }
        }

        System.out.println(
                "\n========== SAVED TRANSACTION DATA =========="
        );

        File transactionFile =
                new File(TRANSACTION_FILE);

        if (!transactionFile.exists()) {

            System.out.println(
                    "No saved transaction data found."
            );

        } else {

            try {

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(transactionFile)
                        );

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                reader.close();

            } catch (IOException e) {

                System.out.println(
                        "Error reading transaction data: "
                        + e.getMessage()
                );
            }
        }
    }
}