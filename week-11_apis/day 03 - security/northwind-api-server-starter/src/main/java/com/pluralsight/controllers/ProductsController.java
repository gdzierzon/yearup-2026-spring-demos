package com.pluralsight.controllers;


import com.pluralsight.models.ErrorResponse;
import com.pluralsight.models.Product;
import com.pluralsight.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/products")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProductsController
{
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService)
    {
        this.productsService = productsService;
    }


    @GetMapping()
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> findAll(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="minprice", required = false) BigDecimal min,
            @RequestParam(name="maxprice", required = false) BigDecimal max,
            @RequestParam(name="category", required = false) String category
    )
    {
        try
        {
            var products = productsService.findAllProducts(name, min, max, category);

            return ResponseEntity.ok(products);
        }
        catch(Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> findById(@PathVariable int id)
    {
        try
        {
            var product = productsService.findByProductId(id);

            if (product.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "The product does not exist");
                error.addMessage("productId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            return ResponseEntity.ok(product.get());
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Product product)
    {
        try
        {
            // don't allow duplicates
            var existing = productsService.findAllByProductName(product.getProductName());
            if (!existing.isEmpty())
            {
                var error = ErrorResponse.get400();
                error.addMessage("message", "Invalid new Product");
                error.addMessage("reason", "A product with that name already exists.");
                error.addMessage("new product", product);
                error.addMessage("existing product", existing);

                return ResponseEntity.badRequest().body(error);
            }
            var newProduct = productsService.addProduct(product);

            URI location = URI.create("/products/" + product.getProductId());
            return ResponseEntity.created(location).body(newProduct);

        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Product product)
    {

        try
        {
            var existing = productsService.findByProductId(id);

            if (existing.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Update failed: The product does not exist");
                error.addMessage("productId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productsService.updateProduct(id, product);

            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        try
        {
            var existing = productsService.findByProductId(id);

            if (existing.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Delete failed: The product does not exist");
                error.addMessage("productId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            productsService.deleteProduct(id);

            // noContent = status 204
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }
}
