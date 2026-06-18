package com.pluralsight.controllers;

import com.pluralsight.models.Customer;
import com.pluralsight.models.ErrorResponse;
import com.pluralsight.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/customers")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CustomersController
{
    private final CustomersService customersService;

    @Autowired
    public CustomersController(CustomersService customersService)
    {
        this.customersService = customersService;
    }


    @GetMapping("")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getAll()
    {
        try
        {
            var categories = customersService.findAllCustomers();

            return ResponseEntity.ok(categories);
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<?> getById(@PathVariable String id)
    {

        try
        {
            var customer = customersService.findCustomerById(id);

            if (customer.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "The customer does not exist");
                error.addMessage("customerId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }


            return ResponseEntity.ok(customer.get());
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
    {

        try
        {
            // don't allow duplicates
            var existing = customersService.findByCompanyName(customer.getCompanyName());
            if (existing.isPresent())
            {
                var error = ErrorResponse.get400();
                error.addMessage("message", "Invalid new Customer.");
                error.addMessage("reason", "A Customer with that name already exists.");
                error.addMessage("new customer", customer);
                error.addMessage("existing customer", existing);

                return ResponseEntity.badRequest().body(error);
            }

            var newCustomer = customersService.addCustomer(customer);

            URI location = URI.create("/categories/" + customer.getCustomerId());
            return ResponseEntity.created(location).body(newCustomer);
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }

    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Customer customer)
    {

        try
        {
            var existing = customersService.findCustomerById(id);

            if (existing.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Update failed: The customer does not exist");
                error.addMessage("customerId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            customersService.updateCustomer(id, customer);

            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }

    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable String id)
    {
        try
        {
            var existing = customersService.findCustomerById(id);

            if (existing.isEmpty())
            {
                var error = ErrorResponse.get404();
                error.addMessage("message", "Delete failed: The customer does not exist");
                error.addMessage("customerId", id);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }

            customersService.deleteCustomer(id);

            return ResponseEntity.noContent().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.internalServerError().body(ErrorResponse.get500());
        }
    }
}
