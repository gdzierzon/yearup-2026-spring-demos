package com.pluralsight.controllers;

// all requests related to Categories will
// be handled by THIS controller

import com.pluralsight.models.Category;
import com.pluralsight.models.Customer;
import com.pluralsight.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomersController
{
    private CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService)
    {
        this.customersService = customersService;
    }


    @GetMapping("")
    public ResponseEntity<List<Customer>> getAll()
    {
        var categories = customersService.findAllCustomers();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id)
    {
        var category = customersService.findCustomerById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping("")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
    {
        var newCustomer = customersService.addCustomer(customer);

        URI location = URI.create("/categories/" + customer.getCustomerId());

        return ResponseEntity.created(location).body(newCustomer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Customer customer)
    {
        customersService.updateCustomer(id, customer);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        customersService.deleteCustomer(id);

        // noContent = status 204
        return ResponseEntity.noContent().build();
    }
}
