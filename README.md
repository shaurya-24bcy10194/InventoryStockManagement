# Inventory & Stock Management System

## 1. Project Overview

The **Inventory & Stock Management System** is a Java-based console
application developed to simplify the management of products and
inventory stock.

The system provides an administrator with a structured way to add,
view, search, update, and delete products. It also allows stock to be
added or removed while maintaining a record of stock transactions.

The application can identify products that have reached their minimum
stock level and provides different reports to help the administrator
understand the current state of the inventory.

The project is developed using **Java 17** and demonstrates important
Object-Oriented Programming concepts such as encapsulation, inheritance,
abstraction, polymorphism, interfaces, enums, collections, exception
handling, and file handling.

---

## 2. Problem Statement

Managing inventory manually can result in several problems, including:

- Difficulty maintaining accurate product information
- Incorrect stock calculations
- Difficulty tracking stock movement
- Lack of proper low-stock notifications
- Difficulty searching for products
- Lack of organized inventory reports
- Loss of information when the application is closed

The Inventory & Stock Management System provides a simple console-based
solution for these problems.

The application maintains product information in memory and stores
important data in text files so that product information can be loaded
again when the application is started.

---

## 3. Objectives

The main objectives of the project are:

- To create a simple inventory management application
- To maintain product information
- To monitor available stock quantities
- To add and remove stock efficiently
- To prevent stock removal when sufficient stock is unavailable
- To identify low-stock products
- To maintain stock transaction records
- To generate inventory-related reports
- To store data using files
- To demonstrate Java Object-Oriented Programming concepts
- To implement input validation and exception handling

---

## 4. Key Features

### 4.1 Administrator Login

The application provides an administrator login system.

The administrator must enter valid credentials before accessing the
inventory management functions.

Demo credentials:

```text
Username: admin
Password: admin123