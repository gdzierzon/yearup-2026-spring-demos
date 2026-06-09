package com.pluralsight.services.mysql;

import com.pluralsight.models.Product;
import com.pluralsight.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class MySqlProductDao implements ProductDao
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlProductDao(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Product> getProductsByCategory(int searchCategoryId)
    {
        ArrayList<Product> products = new ArrayList<>();

        String sql = """
            SELECT ProductID
                , CategoryID
                , ProductName
                , QuantityPerUnit
                , UnitPrice
                , UnitsInStock
                , UnitsOnOrder
                , ReorderLevel
            FROM products
            WHERE CategoryID = ?
            ORDER BY CategoryID
                    , ProductName
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, searchCategoryId);

        while (row.next())
        {
            Product product = mapRowToProduct(row);
            products.add(product);
        }

        return products;
    }

    public Product getProduct(int productId)
    {

        String sql = """
            SELECT ProductID
                , CategoryID
                , ProductName
                , QuantityPerUnit
                , UnitPrice
                , UnitsInStock
                , UnitsOnOrder
                , ReorderLevel
            FROM products
            WHERE ProductID = ?
        """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);

        if (row.next())
        {
            Product product = mapRowToProduct(row);
            return product;
        }

        return null;
    }

    public void addProduct(Product product)
    {
        String sql = """
                INSERT INTO products (ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getCategoryId()
                , product.getQuantityPerUnit()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel());
    }

    public void updateProduct(Product product)
    {
        String sql = """
                UPDATE products
                SET ProductName = ?
                  , CategoryID = ?
                  , QuantityPerUnit = ?
                  , UnitPrice = ?
                  , UnitsInStock = ?
                  , UnitsOnOrder = ?
                  , ReorderLevel = ?
                WHERE ProductId = ?;
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getCategoryId()
                , product.getQuantityPerUnit()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , product.getProductId());
    }

    public void deleteProduct(int id)
    {
        String sql = """
                DELETE FROM products
                WHERE ProductID = ?;
                """;

        jdbcTemplate.update(sql, id);
    }

    private Product mapRowToProduct(SqlRowSet row)
    {
        int productId = row.getInt("ProductID");
        int categoryId = row.getInt("CategoryID");
        String productName = row.getString("ProductName");
        String quantityPerUnit = row.getString("QuantityPerUnit");
        double unitPrice = row.getDouble("UnitPrice");
        int unitsInStock = row.getInt("UnitsInStock");
        int unitsOnOrder = row.getInt("UnitsOnOrder");
        int reorderLevel = row.getInt("ReorderLevel");

        return new Product(productId, categoryId, productName, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel);
    }

}
