package com.pluralsight.services;

import com.pluralsight.models.Product;

import java.util.ArrayList;

public interface ProductDao
{
    ArrayList<Product> getProductsByCategory(int searchCategoryId);

    Product getProduct(int productId);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
