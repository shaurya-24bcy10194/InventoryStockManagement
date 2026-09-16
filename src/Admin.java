public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        System.out.println("\n====================================");
        System.out.println("          ADMIN DASHBOARD");
        System.out.println("====================================");
        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Search Product");
        System.out.println("4. Update Product");
        System.out.println("5. Delete Product");
        System.out.println("6. Add Stock");
        System.out.println("7. Remove Stock");
        System.out.println("8. Low Stock Report");
        System.out.println("9. Inventory Report");
        System.out.println("10. Reports Menu");
        System.out.println("11. Logout");
        System.out.println("====================================");
    }

    public void showReportsMenu() {
        System.out.println("\n====================================");
        System.out.println("           REPORTS MENU");
        System.out.println("====================================");
        System.out.println("1. Inventory Report");
        System.out.println("2. Low Stock Report");
        System.out.println("3. Transaction Report");
        System.out.println("4. Category Report");
        System.out.println("5. Back to Admin Menu");
        System.out.println("====================================");
    }
}