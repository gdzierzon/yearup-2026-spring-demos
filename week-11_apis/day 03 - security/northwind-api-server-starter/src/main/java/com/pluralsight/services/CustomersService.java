package com.pluralsight.services;

import com.pluralsight.models.Customer;
import com.pluralsight.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService
{
    CustomersRepository repository;

    @Autowired
    public CustomersService(CustomersRepository repository)
    {
        this.repository = repository;
    }

    public List<Customer> findAllCustomers()
    {
        var customers = repository.findAll();

        return customers;
    }

    public Optional<Customer> findCustomerById(String id)
    {
        var customer = repository.findById(id);

        return customer;
    }

    public Optional<Customer> findByCompanyName(String name)
    {
        var customer = repository.findByCompanyName(name);

        return customer;
    }

    public Customer addCustomer(Customer customer)
    {
        var newCustomer = repository.save(customer);

        return newCustomer;
    }

    public Customer updateCustomer(String id, Customer customer)
    {
        Customer newCustomer = repository.findById(id).get();

        newCustomer.setCompanyName(customer.getCompanyName());
        newCustomer.setContactName(customer.getContactName());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setCity(customer.getCity());
        newCustomer.setState(customer.getState());
        newCustomer.setZip(customer.getZip());

        return repository.save(newCustomer);
    }

    public void deleteCustomer(String id)
    {
        repository.deleteById(id);
    }
}
