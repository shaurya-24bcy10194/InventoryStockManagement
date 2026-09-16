# System Architecture

## 1. Overview

The Inventory & Stock Management System follows a modular
object-oriented architecture.

The application is divided into different classes, with each class
responsible for a specific part of the system.

The main layers are:

1. User Interface Layer
2. Business Logic Layer
3. Data Management Layer
4. File Storage Layer

---

## 2. Architecture Flow

```text
+-------------------------+
|       Main.java         |
|   User Interface       |
+-----------+-------------+
            |
            v
+-------------------------+
|    Admin / User         |
| Authentication & Menu   |
+-----------+-------------+
            |
            v
+-------------------------+
|    Management Layer     |
|                         |
| ProductManager          |
| InventoryManager        |
| TransactionManager      |
| ReportGenerator         |
+-----------+-------------+
            |
            v
+-------------------------+
|      Model Classes      |
|                         |
| Product                 |
| StockTransaction        |
| Category                |
+-----------+-------------+
            |
            v
+-------------------------+
|     FileManager         |
|    File Read / Write    |
+-----------+-------------+
            |
            v
+-------------------------+
|       Data Files        |
|                         |
| products.txt            |
| transactions.txt        |
+-------------------------+