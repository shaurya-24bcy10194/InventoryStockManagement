# Class Diagram

## 1. Overview

The Inventory & Stock Management System is implemented using multiple
Java classes, an interface, and an enumeration.

The classes are organized according to their responsibilities.

---

## 2. Class Relationships

```text
                         +----------------------+
                         |   <<abstract>>       |
                         |       User           |
                         +----------------------+
                         | - username: String   |
                         | - password: String   |
                         +----------------------+
                         | + login(): boolean   |
                         | + getUsername()      |
                         | + showMenu()         |
                         +----------+-----------+
                                    |
                                  extends
                                    |
                                    v
                         +----------------------+
                         |        Admin         |
                         +----------------------+
                         | + showMenu()         |
                         | + showReportsMenu()  |
                         +----------------------+


+----------------------+       implements       +----------------------+
|      Product         |----------------------->|     Stockable        |
+----------------------+                        +----------------------+
| - productId: int     |                        | + addStock()         |
| - name: String       |                        | + removeStock()      |
| - category: String   |                        | + isLowStock()       |
| - price: double      |                        +----------------------+
| - quantity: int      |
| - minimumStock: int  |
+----------------------+
| + addStock()         |
| + removeStock()      |
| + isLowStock()       |
| + getStockValue()    |
+----------------------+


+----------------------+
|      Category        |
|       <<enum>>       |
+----------------------+
| ELECTRONICS          |
| STATIONERY           |
| GROCERY              |
| CLOTHING             |
| FURNITURE            |
| OTHER                |
+----------------------+


+----------------------+        contains        +----------------------+
|   ProductManager     |----------------------->|      Product         |
+----------------------+                        +----------------------+
| - products: List     |
+----------------------+
| + addProduct()       |
| + displayProducts()  |
| + findProduct()      |
| + searchProduct()    |
| + updateProduct()    |
| + deleteProduct()    |
+----------------------+


+-------------------------+
|   StockTransaction      |
+-------------------------+
| - transactionId: int    |
| - productId: int       |
| - transactionType      |
| - quantity: int        |
| - dateTime             |
+-------------------------+
| + getTransactionId()    |
| + getProductId()       |
| + getTransactionType() |
| + getQuantity()        |
| + getDateTime()        |
+-------------------------+


+-------------------------+       contains       +-------------------------+
|   TransactionManager    |--------------------->|   StockTransaction      |
+-------------------------+                       +-------------------------+
| - transactions: List    |
| - nextTransactionId    |
+-------------------------+
| + recordStockIn()       |
| + recordStockOut()      |
| + displayTransactions() |
+-------------------------+


+-------------------------+
|   InventoryManager     |
+-------------------------+
| - productManager       |
| - transactionManager   |
+-------------------------+
| + addStock()           |
| + removeStock()        |
| + displayLowStock...() |
| + calculateTotal...()  |
| + displayInventory...()|
+-------------------------+


+-------------------------+
|    ReportGenerator     |
+-------------------------+
| - productManager       |
| - transactionManager   |
+-------------------------+
| + generateInventory... |
| + generateLowStock...  |
| + generateTransaction..|
| + generateCategory...  |
+-------------------------+


+-------------------------+
|      FileManager       |
+-------------------------+
| PRODUCT_FILE           |
| TRANSACTION_FILE       |
+-------------------------+
| + saveProducts()       |
| + loadProducts()       |
| + saveTransactions()   |
| + displaySavedData()   |
+-------------------------+