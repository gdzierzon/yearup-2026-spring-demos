package com.pluralsight.exercises;

import com.pluralsight.io.ProductsFileManager;
import com.pluralsight.models.CartItem;
import com.pluralsight.models.OrderDetail;
import com.pluralsight.models.Product;

import java.math.BigDecimal;
import java.util.List;

public class Exercises04Products
{
    private static List<Product> products = ProductsFileManager.loadProducts();
    private static List<CartItem> shoppingCart = List.of(
            new CartItem(products.get(3), 1),
            new CartItem(products.get(22), 1),
            new CartItem(products.get(25), 3),
            new CartItem(products.get(77), 1),
            new CartItem(products.get(94), 1),
            new CartItem(products.get(70), 5)
            );

    public List<Product> getProductsAbove(BigDecimal price)
    {
        return null;
    }

    public List<Product> getProductsByName(String nameContains)
    {
        return null;
    }

    public Product getMostExpensiveProduct()
    {
        return null;
    }

    public Product getLeastExpensiveProduct()
    {
        return null;
    }

    public List<Product> getProductsInCart()
    {
        return null;
    }

    public List<OrderDetail> convertCartToOrderDetails()
    {
        return null;
    }

    public Product getMostExpensiveProductInCart()
    {
        return null;
    }

    public BigDecimal getOrderTotal()
    {
        return null;
    }

    public BigDecimal getCostOfMostExpensiveOrderDetail()
    {
        return null;
    }

    public String getProductNameOfMostExpensiveLineItem()
    {
        return null;
    }

}
