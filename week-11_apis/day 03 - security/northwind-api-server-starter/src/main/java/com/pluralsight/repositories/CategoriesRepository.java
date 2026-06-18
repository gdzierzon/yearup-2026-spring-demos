package com.pluralsight.repositories;

import com.pluralsight.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer>
{
    List<Category> findAllByCategoryName(String name);
}
