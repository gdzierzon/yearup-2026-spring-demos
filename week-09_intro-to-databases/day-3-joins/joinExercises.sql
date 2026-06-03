-- List the product id, product name, unit price and category name of all products.
-- Order by category name and within that, by product name.
SELECT ProductID, ProductName, UnitPrice, CategoryName FROM Products
JOIN Categories
ON Products.CategoryId = Categories.CategoryId
ORDER BY CategoryName, ProductName;

-- List the product id, product name, unit price and supplier name of all products
-- that cost more than $75. Order by product name.
SELECT ProductID, ProductName, UnitPrice, CompanyName FROM Products
JOIN Suppliers
ON Products.SupplierID = Suppliers.SupplierID
WHERE UnitPrice > 75
ORDER BY ProductName;

-- List the product id, product name, unit price, category name, and supplier name
-- of every product. Order by product name.

SELECT ProductID, ProductName, UnitPrice, CategoryName, Suppliers.CompanyName FROM Products
JOIN Categories
ON Products.CategoryId = Categories.CategoryId
JOIN Suppliers
ON Products.SupplierID = Suppliers.SupplierID
ORDER BY ProductName;