# Sequence Diagrams

## 1. Overview

Sequence diagrams show the order in which objects and classes
communicate during important operations of the Inventory & Stock
Management System.

---

## 2. Login Sequence

```text
Administrator       Main.java          Admin/User
      |                 |                   |
      |--- username --->|                   |
      |--- password --->|                   |
      |                 |--- login() ------>|
      |                 |<--- true/false ---|
      |                 |                   |
      |<-- Dashboard ---|                   |