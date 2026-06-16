package com.pluralsight.repositories;

import com.pluralsight.models.Customer;
import com.pluralsight.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, String>
{
}
