# Inventory & Stock Management System

## Project Information

| Field | Details |
|---|---|
| Project Name | Inventory & Stock Management System |
| Application Type | Console-Based Application |
| Programming Language | Java |
| Java Version | Java 17 |
| Development Environment | Visual Studio Code |
| Data Storage | Text Files |
| Version Control | Git |
| Repository Hosting | GitHub |
| User Role | Administrator |

---

# 1. Project Overview

The **Inventory & Stock Management System** is a Java-based console
application developed to manage products, monitor inventory quantities,
record stock movement, identify low-stock products, and generate
inventory-related reports.

The application provides an administrator with a structured interface
for performing common inventory management operations.

The administrator can add new products, view existing products, search
products, update product information, delete products, add stock, remove
stock, and view different reports.

The system also maintains stock transaction information whenever stock
is successfully added or removed.

Product and transaction information is stored using text files. This
allows important product information to remain available after the
application is closed and started again.

The project has been developed using Java 17 and demonstrates several
important Java programming and Object-Oriented Programming concepts.

---

# 2. Problem Statement

Inventory management is an important requirement for businesses,
organizations, stores, and warehouses.

When inventory is maintained manually, several problems can occur:

- Product information may be difficult to maintain.
- Stock quantities may become inaccurate.
- Stock movement may not be properly recorded.
- Products with low stock may be overlooked.
- Searching for a particular product may take additional time.
- Inventory value may be difficult to calculate manually.
- Historical stock transactions may not be organized.
- Data may be lost when the application is closed.

The purpose of this project is to provide a simple software-based
solution for these problems.

The Inventory & Stock Management System maintains product information,
controls stock operations, records transactions, detects low stock, and
generates reports through a menu-driven Java console application.

---

# 3. Proposed Solution

The proposed system provides an administrator dashboard through which
inventory operations can be performed.

The application follows a modular structure where different classes
handle different responsibilities.

For example:

- `Product` represents a product.
- `ProductManager` manages products.
- `TransactionManager` manages stock transactions.
- `InventoryManager` handles inventory operations.
- `ReportGenerator` generates reports.
- `FileManager` handles file storage.
- `Admin` handles administrator-specific functionality.
- `Main` controls the application flow.

This separation of responsibilities makes the application easier to
understand, test, maintain, and extend.

---

# 4. Project Objectives

The main objectives of the project are:

1. To develop a simple inventory management application using Java.
2. To maintain product information in an organized manner.
3. To monitor current stock quantities.
4. To allow stock to be added when new inventory is received.
5. To allow stock to be removed when inventory is issued or sold.
6. To prevent stock removal when sufficient quantity is unavailable.
7. To identify products that require restocking.
8. To maintain stock-in and stock-out transaction records.
9. To generate useful inventory reports.
10. To store product and transaction information using files.
11. To implement input validation.
12. To handle common runtime and file-related exceptions.
13. To demonstrate Object-Oriented Programming concepts in Java.
14. To create a modular and maintainable Java application.

---

# 5. Scope of the Project

The current version of the system focuses on basic inventory and stock
management.

The system covers:

- Administrator authentication
- Product management
- Stock management
- Low-stock detection
- Transaction recording
- Inventory reporting
- Category reporting
- File-based data persistence
- Input validation
- Exception handling

The current version is intentionally implemented as a console
application so that the core Java programming and Object-Oriented
Programming concepts can be demonstrated clearly.

---

# 6. User Role

## Administrator

The current system provides one user role:

**Administrator**

The administrator has access to all available inventory operations.

The administrator can:

- Add products
- View products
- Search products
- Update products
- Delete products
- Add stock
- Remove stock
- View low-stock information
- View inventory reports
- View transaction reports
- View category reports
- Logout

---

# 7. Administrator Login

The application starts with an administrator login screen.

The administrator must enter valid credentials before accessing the
main dashboard.

### Demo Credentials

```text
Username: admin
Password: admin123