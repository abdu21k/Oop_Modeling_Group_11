# Domain_4_Solution.md

## Title:
 Inventory Management System in Java

## Objective:
To design and implement a simple, yet effective inventory management system that accurately tracks inventory transactions and stock levels across multiple locations using a Java-based console application.

## Solution Overview:
I will develop a console-based system that helps users manage inventory through clear modules for purchasing, selling, transferring, adjusting, and reporting. The system will store and update data in real-time using file-based storage.

## Step-by-Step Solution Plan:

### 1. Define Transaction Types
Create a clear structure for the following inventory transactions:
- **Purchase Order**: Records incoming stock from suppliers.
- **Sales Order**: Records stock sold to customers.
- **Stock Transfer**: Moves stock between storage locations.
- **Stock Adjustment**: Fixes discrepancies due to damage or error.

### 2. Create Data Models (Java Classes)
- **Product**: Stores product ID, name, category, and unit price.
- **InventoryTransaction**: Holds transaction details (type, date, quantity, source/destination, reason).

### 3. Develop Core Functionalities
- `recordPurchaseOrder(productId, quantity)`: Adds items to stock.
- `recordSalesOrder(productId, quantity)`: Removes sold items from stock.
- `transferStock(productId, quantity, fromLocation, toLocation)`: Moves stock across locations.
- `adjustStock(productId, quantity, reason)`: Fixes overage/shortage problems.

### 4. Update Stock Levels
- Automatically update stock levels after every transaction.
- Prevent negative stock unless allowed (e.g., for backorders).
- Log every transaction with a timestamp.

### 5. Add Error Handling
- Prevent invalid operations like selling more than available.
- Validate inputs like product ID and quantity.

### 6. Implement Reporting
Generate simple text-based reports:
- Inventory levels by product/location.
- Transaction history by type and date.

### 7. Create Console-Based User Interface
- Display a menu to let users choose actions (purchase, sell, transfer, etc.).
- Use prompts to collect inputs.
- Display results and reports clearly.

### 8. Test and Validate
- Simulate use cases (e.g., multiple purchases, transfers, and sales).
- Check if stock levels are updated correctly.
- Validate edge cases like negative quantities or selling unavailable products.
