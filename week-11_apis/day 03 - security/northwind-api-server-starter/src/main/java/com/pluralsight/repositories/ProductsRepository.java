package com.pluralsight.repositories;

import com.pluralsight.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>
{
    List<Product> findByProductNameContainsAndUnitPriceBetween(String name, BigDecimal min, BigDecimal max);


    @Query("""
        SELECT p
        FROM Product p
        WHERE (:productName IS NULL OR p.productName LIKE CONCAT('%', :productName, '%'))
          AND (:min IS NULL OR p.unitPrice >= :min)
          AND (:max IS NULL OR p.unitPrice <= :max)
          AND (:categoryName IS NULL OR p.category.categoryName LIKE CONCAT('%', :categoryName, '%'))
        """)
    List<Product> search(@Param("productName")String name,
                         @Param("min") BigDecimal min,
                         @Param("max") BigDecimal max,
                         @Param("categoryName") String categoryName);

}
