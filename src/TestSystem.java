public class TestSystem {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("     INVENTORY SYSTEM TESTING");
        System.out.println("====================================");

        Product product = new Product(
                101,
                "Laptop",
                "ELECTRONICS",
                55000.00,
                10,
                5
        );

        System.out.println("\nTest 1: Product Creation");

        if (product.getProductId() == 101
                && product.getName().equals("Laptop")
                && product.getQuantity() == 10) {

            System.out.println("PASS - Product created correctly.");

        } else {

            System.out.println("FAIL - Product creation failed.");
        }

        System.out.println("\nTest 2: Add Stock");

        product.addStock(5);

        if (product.getQuantity() == 15) {

            System.out.println("PASS - Stock added correctly.");

        } else {

            System.out.println("FAIL - Stock addition failed.");
        }

        System.out.println("\nTest 3: Remove Stock");

        boolean removed = product.removeStock(3);

        if (removed && product.getQuantity() == 12) {

            System.out.println(
                    "PASS - Stock removed correctly."
            );

        } else {

            System.out.println(
                    "FAIL - Stock removal failed."
            );
        }

        System.out.println("\nTest 4: Insufficient Stock");

        boolean insufficientRemoval =
                product.removeStock(100);

        if (!insufficientRemoval
                && product.getQuantity() == 12) {

            System.out.println(
                    "PASS - Insufficient stock handled correctly."
            );

        } else {

            System.out.println(
                    "FAIL - Insufficient stock test failed."
            );
        }

        System.out.println("\nTest 5: Stock Value");

        double expectedValue = 55000.00 * 12;

        if (product.getStockValue() == expectedValue) {

            System.out.println(
                    "PASS - Stock value calculated correctly."
            );

        } else {

            System.out.println(
                    "FAIL - Stock value calculation failed."
            );
        }

        System.out.println("\nTest 6: Low Stock Detection");

        Product lowStockProduct = new Product(
                102,
                "Keyboard",
                "ELECTRONICS",
                1200.00,
                3,
                5
        );

        if (lowStockProduct.isLowStock()) {

            System.out.println(
                    "PASS - Low stock detected correctly."
            );

        } else {

            System.out.println(
                    "FAIL - Low stock detection failed."
            );
        }

        System.out.println("\nTest 7: Product Manager");

        ProductManager manager = new ProductManager();

        manager.addProduct(product);

        if (manager.findProduct(101) != null) {

            System.out.println(
                    "PASS - Product Manager works correctly."
            );

        } else {

            System.out.println(
                    "FAIL - Product Manager test failed."
            );
        }

        System.out.println("\n====================================");
        System.out.println("       TESTING COMPLETED");
        System.out.println("====================================");
    }
}