-- page 73, exercise 4.1
SELECT ProductName, UnitPrice 
FROM Products
WHERE UnitPrice = (
  SELECT MAX(UnitPrice) 
  FROM northwind.Products
);

-- page 73, exercise 4.2
SELECT OrderId, ShipName, ShipAddress FROM northwind.Orders
WHERE ShipVia = (
  SELECT ShipperID 
  FROM northwind.Shippers
  WHERE CompanyName = 'Federal Shipping'
);

-- we didn't formally see joins, but here would be how to do it:
SELECT OrderId, ShipName, ShipAddress FROM Orders
JOIN Shippers
ON Orders.ShipVia = Shippers.ShipperID
WHERE CompanyName = 'Federal Shipping';

-- page 73, exercise 4.3
SELECT OrderId FROM northwind.`Order Details`
WHERE ProductId = (
  SELECT ProductId 
  FROM northwind.Products
  WHERE ProductName = 'Sasquatch Ale'
);



