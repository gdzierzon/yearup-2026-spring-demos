package com.pluralsight.controllers;

// all requests related to Products will
// be handled by THIS controller

import com.pluralsight.models.Category;
import com.pluralsight.models.Product;
import com.pluralsight.services.ProductsService;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductsController
{
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService)
    {
        this.productsService = productsService;
    }


    @PermitAll
    public ResponseEntity<List<Product>> getAll(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="minprice", required = false) BigDecimal min,
            @RequestParam(name="maxprice", required = false) BigDecimal max,
            @RequestParam(name="category", required = false) String category
    )
    {
        var products = productsService.findAllProducts(name, min, max, category);

        return ResponseEntity.ok(products);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable int id)
    {
        var product = productsService.findByProductId(id);

        return ResponseEntity.ok(product);
    }

    @PostMapping("")
    public ResponseEntity<Product> addCategory(@RequestBody Product product)
    {
        var newProduct = productsService.addProduct(product);

        URI location = URI.create("/products/" + product.getProductId());

        return ResponseEntity.created(location).body(newProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Product product)
    {
        productsService.updateProduct(id, product);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        productsService.deleteProduct(id);

        // noContent = status 204
        return ResponseEntity.noContent().build();
    }
}
