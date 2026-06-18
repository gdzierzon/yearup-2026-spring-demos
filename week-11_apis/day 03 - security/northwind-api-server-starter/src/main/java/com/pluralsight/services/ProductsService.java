package com.pluralsight.services;

import com.pluralsight.models.Product;
import com.pluralsight.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService
{
    ProductsRepository repository;

    @Autowired
    public ProductsService(ProductsRepository repository)
    {
        this.repository = repository;
    }

    public List<Product> findAllProducts(String name, BigDecimal min, BigDecimal max, String category)
    {
        List<Product> products = repository.search(name, min, max, category);

        return products;
    }

    public List<Product> findProductsByCategoryId(int categoryId)
    {
        var products = repository.findAll();

        // inefficiently filter AFTER query
        return products.stream()
                .filter(p -> p.getCategory().getCategoryId() == categoryId)
                .toList();
    }

    public Optional<Product> findByProductId(int id)
    {
        var product = repository.findById(id);

        return product;
    }

    public List<Product> findAllByProductName(String name)
    {
        var products = repository.findAllByProductName(name);

        return products;
    }

    public Product addProduct(Product product)
    {
        var newProduct = repository.save(product);

        return newProduct;
    }

    public Product updateProduct(int id, Product product)
    {
        var newProduct  = repository.findById(id).get();

        newProduct.setProductName(product.getProductName());
        newProduct.setUnitPrice(product.getUnitPrice());

        return repository.save(newProduct);
    }

    public void deleteProduct(int id)
    {
        repository.deleteById(id);
    }
}
