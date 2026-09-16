# Use Case Specification

## 1. Actors

The main actor in the current system is:

### Administrator

The administrator is responsible for managing products, stock,
transactions, and reports.

---

## 2. Use Case Diagram

```text
                         +-----------------------------+
                         | Inventory & Stock           |
                         | Management System           |
                         |                             |
Admin ----------------->| Login                       |
                         |                             |
Admin ----------------->| Add Product                 |
                         | View Products               |
                         | Search Product              |
                         | Update Product              |
                         | Delete Product              |
                         | Add Stock                   |
                         | Remove Stock                |
                         | View Low Stock Report      |
                         | View Inventory Report      |
                         | View Transaction Report     |
                         | View Category Report        |
                         | Logout                      |
                         +-----------------------------+