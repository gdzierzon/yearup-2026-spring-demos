package com.pluralsight.repositories;

import com.pluralsight.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>
{
    List<Product> findAllByCategory_CategoryName(String categoryName);
}
